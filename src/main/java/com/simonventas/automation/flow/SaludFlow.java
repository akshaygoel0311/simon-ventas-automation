package com.simonventas.automation.flow;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.simonventas.automation.commons.helpers.DriverFactory;
import com.simonventas.automation.commons.utils.DataUtil;
import com.simonventas.automation.commons.utils.ExcelReader;
import com.simonventas.automation.commons.utils.FlowUtil;
import com.simonventas.automation.commons.utils.Log;
import com.simonventas.automation.ui.HogarUI;
import com.simonventas.automation.ui.SaludUI;

public class SaludFlow extends SaludUI {

	public ExcelReader dataExcel = DataUtil.dataExcel;
	// private WebElement autoriza_datos_chbx;
	// private WebElement continuar;
	public static Log log = new Log(SaludFlow.class.getName());

	public void gotoSalud(String s_no) {
		if (FlowUtil.elementIsDisplayed(page_error)) {
			int n = Integer.parseInt(s_no);
			int rowNum = n + 1;
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion", rowNum,
					page_error.getText().substring(0, 53));
			Assert.fail(page_error.getText());
		} else

			FlowUtil.waitTillClickable(salud_main);
		FlowUtil.movetoElement(salud_main);
		FlowUtil.waitTillVisibility(salud_menu);
		FlowUtil.movetoElementandClick(salud_menu);
		log.info("Navigated to Salud Menu");

	}

	public void enterClave(String s_no, String agente) {
		waitTillInvisibilityofCargando();
		if (FlowUtil.elementIsDisplayed(page_error)) {
			int n = Integer.parseInt(s_no);
			int rowNum = n + 1;
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion", rowNum, "Serivce Error");
			Assert.fail("Service Error" + page_error.getText());
		}
		FlowUtil.clearvalue(clave);
		FlowUtil.click(clave);
		FlowUtil.sendvalue(clave, agente);
		FlowUtil.pressTab();
		waitTillInvisibilityofCargando();
		FlowUtil.sleep(3000);
		log.info("clave nombre:" + clave_nombre.getText());
		if (FlowUtil.elementIsDisplayed(clave_nombre)) {
			// FlowUtil.movetoElementandClick(siguiente1);
			FlowUtil.javascriptClick(siguiente1);
		} else if (FlowUtil.elementIsDisplayed(clave_service_error)) {
			FlowUtil.click(inicio);
			Assert.fail("clave service error");
		}
	}

	public void selectProducto(String codProducto) {
		FlowUtil.movetoElement(producto);
		FlowUtil.selectByValue(producto, codProducto);
		waitTillInvisibilityofCargando();
		FlowUtil.javascriptClick(plan);
		FlowUtil.javascriptClick(siguiente2);
	}

	public void enterTomador(String s_no, String nro_documento, String saludFecha, String saludTelefono,
			String saludCuidad, String saludDireccion) {

		FlowUtil.javascriptClick(nrodocumento);
		FlowUtil.clearvalue(nrodocumento);
		FlowUtil.sendvalue(nrodocumento, nro_documento);
		FlowUtil.pressTab();
		waitTillInvisibilityofCargando();
		FlowUtil.sleep(3000);
		if (FlowUtil.elementIsDisplayed(tomador_error)) {
			log.info(DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//span[@id='errorSpan']"))
					.getText());
			if (FlowUtil.getText(tomador_no_existe).contains("Persona no existe")) {
				FlowUtil.sendvalue(nombre, DataUtil.newTomadorNombre);
				FlowUtil.sendvalue(apellidos, DataUtil.newTomadorApellido);
				String text = fecha.getAttribute("value");
				if (text.isEmpty()) {
					FlowUtil.javascriptClick(fecha);
					FlowUtil.clearvalue(fecha);
					FlowUtil.sendvalue(fecha, saludFecha);
					FlowUtil.javascriptClick(teleFono);
					FlowUtil.clearvalue(teleFono);
					FlowUtil.sendvalue(teleFono, saludTelefono);
					FlowUtil.javascriptClick(cuidad);
					FlowUtil.clearvalue(cuidad);
					FlowUtil.sendvalue(cuidad, saludCuidad);
					FlowUtil.javascriptClick(direccion);
					FlowUtil.clearvalue(direccion);
					FlowUtil.sendvalue(direccion, saludDireccion);
				}
			} else {
				int n = Integer.parseInt(s_no);
				int rowNum = n + 1;
				dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion", rowNum,
						tomador_error.getText().substring(0, 53));
				dataExcel.setCellData(DataUtil.inputExcelSheetName, "Policy No", rowNum, "Not Executed");
				dataExcel.setCellData(DataUtil.inputExcelSheetName, "Pass/Fail", rowNum, "Fail");
				FlowUtil.takeFailedScreenshot("CrearCotizacion");
				FlowUtil.movetoElementandClick(inicio);
				Assert.fail("Error on Tomador Screen");
			}
		}
		FlowUtil.sleep(3000);
		FlowUtil.scrollToElement(autoriza_datos_chbx);
		FlowUtil.movetoElement(autoriza_datos_chbx);
		FlowUtil.javascriptClick(autoriza_datos_chbx);
		FlowUtil.click(continuar);
		FlowUtil.javascriptClick(siguiente3);
	}

	public void enterRiesgo(String s_no, String riesgo_Identification, String Salud_occupacion, String saludFecha,
			String saludCuidad) {
		FlowUtil.javascriptClick(riesoIdentification);
		FlowUtil.clearvalue(riesoIdentification);
		FlowUtil.sendvalue(riesoIdentification, riesgo_Identification);
		FlowUtil.pressTab();
		waitTillInvisibilityofCargando();
		FlowUtil.sleep(3000);
		{
			if (FlowUtil.elementIsDisplayed(riesgo_error)) {
				log.info(DriverFactory.getDriverFacade().getWebDriver()
						.findElement(By.xpath("//*[@id='errorSpanIdentificationR']")).getText());
			}
			if (FlowUtil.getText(riesgo_no_existe).contains("Persona no existe")) {
				FlowUtil.sendvalue(apellidoRiesgo, DataUtil.newRiesgoApellido);
				FlowUtil.sendvalue(nombreRiesgo, DataUtil.newRiesgoNombre);
				FlowUtil.pressTab();
				String text = fechaReisgo.getAttribute("value");
				if (text.isEmpty()) {
					FlowUtil.javascriptClick(fechaReisgo);
					FlowUtil.clearvalue(fechaReisgo);
					FlowUtil.sendvalue(fechaReisgo, saludFecha);
					FlowUtil.javascriptClick(cuidadRiesgo);
					FlowUtil.clearvalue(cuidadRiesgo);
					FlowUtil.sendvalue(cuidadRiesgo, saludCuidad);
				}
			}
			// waitTillInvisibilityofCargando();
			FlowUtil.click(occupacion);
			// FlowUtil.movetoElement(occupacion);
			FlowUtil.sendvalue(occupacion, Salud_occupacion);
			FlowUtil.pressTab();
			FlowUtil.javascriptClick(addriesgo);
			// String alertTitle=null;
			try {
				String Title = DriverFactory.getDriverFacade().getWebDriver().switchTo().alert().getText();
				System.out.println(Title);
				FlowUtil.acceptAlert();
			} // try
			catch (NoAlertPresentException Ex) {
				System.out.println("Popup not appeared");
			}
			waitTillInvisibilityofCargando();
			String parentWindow = FlowUtil.getWindowHandle();
			FlowUtil.javascriptClick(liqidarprima);
			waitTillInvisibilityofCargando();

			Set<String> windows = FlowUtil.getWindowHandles();
			Iterator<String> iterate_window = windows.iterator();

			log.info(DriverFactory.getDriverFacade().getWebDriver().getTitle());
			while (iterate_window.hasNext()) {
				String subWindow = iterate_window.next();
				FlowUtil.swichToWindow(subWindow);

				String title = DriverFactory.getDriverFacade().getWebDriver().getTitle();
				if (title.contains("Liquidar Salud")) {
					FlowUtil.swichToWindow(subWindow);
					System.out.println(title);
					FlowUtil.movetoElement(selectPlan);
					FlowUtil.javascriptClick(selectPlan);
					FlowUtil.movetoElement(crearCotizacion);
					FlowUtil.javascriptClick(crearCotizacion);
					FlowUtil.swichToWindow(parentWindow);
					waitTillInvisibilityofCargando();
					log.info("Cotizacion No is : " + quoteNo.getText());
					int n = Integer.parseInt(s_no);
					int rowNum = n + 1;
					dataExcel.setCellData(DataUtil.inputExcelSheetName, "Num_Cotizacion", rowNum, quoteNo.getText());
					// dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error",rowNum ," ");
					// dataExcel.setCellData(DataUtil.inputExcelSheetName,
					// "Copiar_Cotizacion",rowNum , quoteNo.getText());
					dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion", rowNum, "No");
					dataExcel.setCellData(DataUtil.inputExcelSheetName, "Policy No", rowNum, "Not Executed");
					dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Policy", rowNum, "No");
					dataExcel.setCellData(DataUtil.inputExcelSheetName, "Pass/Fail", rowNum, "Pass");

				}

			}
		}
	}

	public void cotizacionPDF(String s_no) {
		String parentWindow = FlowUtil.getWindowHandle();
		FlowUtil.movetoElement(cotizacion_pdf);
		FlowUtil.click(cotizacion_pdf);
		Set<String> windows = FlowUtil.getWindowHandles();
		String subWindow = null;
		Iterator<String> iterate_window = windows.iterator();
		while (iterate_window.hasNext()) {
			subWindow = iterate_window.next();
			FlowUtil.swichToWindow(subWindow);
			String title = DriverFactory.getDriverFacade().getWebDriver().getTitle();
			if (title.contains("Untitled")) {
				FlowUtil.swichToWindow(subWindow);
				log.info(DriverFactory.getDriverFacade().getWebDriver().getTitle());
			}
		}
		FlowUtil.swichToWindow(parentWindow);
		FlowUtil.gotoDownloads();
		FlowUtil.sleep(5000);
		// WebElement root1 =
		// DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//downloads-manager"));
		// WebElement shadowRoot1 =FlowUtil.expandRootElement(root1);
		// WebElement root2 = shadowRoot1.findElement(By.cssSelector("downloads-item"));
		// WebElement shadowRoot2 = FlowUtil.expandRootElement(root2);
		// WebElement root3 =
		// shadowRoot2.findElement(By.cssSelector("div[id=content]>div[id=details]>a"));
		// WebElement shadowRoot3 = FlowUtil.expandRootElement(root3);
		// String pdfTitle = shadowRoot3.getText();
		// log.info(pdfTitle);
		int n = Integer.parseInt(s_no);
		int rowNum = n + 1;
		dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion", rowNum, "No");
		dataExcel.setCellData(DataUtil.inputExcelSheetName, "Policy No", rowNum, "Not Executed");
		dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Policy", rowNum, "No");
		dataExcel.setCellData(DataUtil.inputExcelSheetName, "PolicyPDF", rowNum, "Not Executed");
		dataExcel.setCellData(DataUtil.inputExcelSheetName, "Pass/Fail", rowNum, "Pass");
		dataExcel.setCellData(DataUtil.inputExcelSheetName, "CotizacionPDF", rowNum, "Downloaded Successfully");

	}

	public void copiarCotizacion(String s_no, String codProducto, String dec_Weight, String dec_height,
			String selectEntidad) {
		FlowUtil.movetoElement(copiarCotizacion);
		FlowUtil.click(copiarCotizacion);
		waitTillInvisibilityofCargando();
		log.info("clave nombre:" + clave_nombre.getText());
		if (FlowUtil.elementIsDisplayed(clave_nombre)) {
			// FlowUtil.movetoElementandClick(siguiente1);
			FlowUtil.javascriptClick(siguiente1);
		} else if (FlowUtil.elementIsDisplayed(clave_service_error)) {
			FlowUtil.click(inicio);
			Assert.fail("clave service error");
		}
		FlowUtil.javascriptClick(siguiente1);
		FlowUtil.movetoElement(producto);
		FlowUtil.selectByValue(producto, codProducto);
		waitTillInvisibilityofCargando();
		FlowUtil.javascriptClick(plan);
		FlowUtil.javascriptClick(siguiente2);
		FlowUtil.javascriptClick(siguiente3);
		String parentWindow = FlowUtil.getWindowHandle();
		FlowUtil.javascriptClick(liqidarprima);
		waitTillInvisibilityofCargando();

		Set<String> windows = FlowUtil.getWindowHandles();
		Iterator<String> iterate_window = windows.iterator();

		log.info(DriverFactory.getDriverFacade().getWebDriver().getTitle());
		while (iterate_window.hasNext()) {
			String subWindow = iterate_window.next();
			FlowUtil.swichToWindow(subWindow);

			String title = DriverFactory.getDriverFacade().getWebDriver().getTitle();
			if (title.contains("Liquidar Salud")) {
				FlowUtil.swichToWindow(subWindow);
				System.out.println(title);
				FlowUtil.movetoElement(selectPlan);
				FlowUtil.javascriptClick(selectPlan);
				FlowUtil.movetoElement(crearCotizacion);
				FlowUtil.javascriptClick(crearCotizacion);
				FlowUtil.swichToWindow(parentWindow);
				waitTillInvisibilityofCargando();
				log.info("Cotizacion No is : " + quoteNo.getText());
				int n = Integer.parseInt(s_no);
				int rowNum = n + 1;
				// dataExcel.setCellData(DataUtil.inputExcelSheetName, "Num_Cotizacion",rowNum,"
				// ");
				// dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error",rowNum ," ");
				// FlowUtil.takeSuccessScreenshot("CopiarCotizacion");
				// FlowUtil.click(cancelar);
				dataExcel.setCellData(DataUtil.inputExcelSheetName, "Copiar_Cotizacion", rowNum, quoteNo.getText());
				dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion", rowNum, "No");
				/*
				 * dataExcel.setCellData(DataUtil.inputExcelSheetName, "Policy No",rowNum ,
				 * "Not Executed"); dataExcel.setCellData(DataUtil.inputExcelSheetName,
				 * "Error_Policy",rowNum , "No");
				 * dataExcel.setCellData(DataUtil.inputExcelSheetName, "Pass/Fail",rowNum ,
				 * "Pass");
				 */

				FlowUtil.movetoElement(decLink);
				FlowUtil.javascriptClick(decLink);
				waitTillInvisibilityofCargando();
				// FlowUtil.javascriptClick(weight);
				FlowUtil.sendvalue(weight, dec_Weight);
				// waitTillInvisibilityofCargando();
				FlowUtil.pressTab();
				FlowUtil.javascriptClick(height);
				FlowUtil.sendvalue(height, dec_height);
				FlowUtil.javascriptClick(decQue);
				FlowUtil.javascriptClick(decQue1);
				FlowUtil.javascriptClick(decQue2);
				FlowUtil.javascriptClick(decQue3);
				FlowUtil.javascriptClick(decQue4);
				FlowUtil.javascriptClick(decQue5);
				FlowUtil.javascriptClick(decQue6);
				FlowUtil.javascriptClick(decQue7);
				FlowUtil.javascriptClick(decQue8);
				FlowUtil.javascriptClick(decQue9);
				FlowUtil.javascriptClick(decQue10);
				FlowUtil.javascriptClick(decQue11);
				FlowUtil.javascriptClick(decQue12);
				FlowUtil.javascriptClick(decQue13);
				FlowUtil.javascriptClick(decQue14);
				FlowUtil.javascriptClick(submitDec);
				System.out.println("DECLARATION FILLED");
				waitTillInvisibilityofCargando();
				dataExcel.setCellData(DataUtil.inputExcelSheetName, "Numero Declaration", rowNum, decNo.getText());
				FlowUtil.javascriptClick(decContinuar);
				FlowUtil.javascriptClick(emitir);
				waitTillInvisibilityofCargando();
				String parentWindow1 = FlowUtil.getWindowHandle();
				FlowUtil.javascriptClick(siguiente1);
				if (FlowUtil.isElementPresent(addTomador)) {
					FlowUtil.waitTillClickable(addTomador);
					FlowUtil.click(addTomador);
					FlowUtil.sleep(3000);
					Set<String> windows1 = FlowUtil.getWindowHandles();
					String subWindow1 = null;
					Iterator<String> iterate_window1 = windows1.iterator();
					while (iterate_window1.hasNext()) {
						subWindow1 = iterate_window1.next();
						FlowUtil.swichToWindow(subWindow1);
						String title1 = DriverFactory.getDriverFacade().getWebDriver().getTitle();
						if (title1.contains("CONOCIMIENTO")) {
							FlowUtil.swichToWindow(subWindow1);
							log.info(DriverFactory.getDriverFacade().getWebDriver().getTitle());
						}
					}
					waitTillInvisibilityofCargando();
					FlowUtil.selectByValue(rol, DataUtil.general_rol);
					FlowUtil.sendvalue(general_primer_nombre, DataUtil.general_primer_nombre);
					FlowUtil.sendvalue(general_primer_appelido, DataUtil.general_primer_appelido);
					FlowUtil.sendvalue(fecha_nacimiento, DataUtil.general_fecha_nacimiento);
					FlowUtil.sendvalue(lugar_nacimiento, DataUtil.general_lugar_nacimiento);
					FlowUtil.pressTab();
					FlowUtil.selectByValue(estado_civil, DataUtil.general_estado_civil);
					FlowUtil.selectByValue(sexo, DataUtil.general_sexo);
					FlowUtil.sendvalue(direccion1, DataUtil.general_direccion);
					FlowUtil.sendvalue(ciudad, DataUtil.general_ciudad);
					FlowUtil.pressTab();
					FlowUtil.sendvalue(telephono, DataUtil.general_telephono);
					FlowUtil.sendvalue(celular, DataUtil.general_celular);
					FlowUtil.sendvalue(correo, DataUtil.general_correo);
					FlowUtil.click(informacion_general_siguiente);
					waitTillInvisibilityofCargando();
					FlowUtil.selectByValue(occupacion1, DataUtil.actividad_economica_occupacion);
					WebElement expuesta = DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath(
							"//div[@id='uniform-personaPublicamente" + DataUtil.actividad_economica_expuesta + "']"));
					FlowUtil.click(expuesta);
					WebElement expuesta_familiares = DriverFactory.getDriverFacade().getWebDriver()
							.findElement(By.xpath("//div[@id='uniform-tieneVinculosSocio"
									+ DataUtil.actividad_economica_familiares_expuesta + "']"));
					FlowUtil.click(expuesta_familiares);
					FlowUtil.click(actividad_econimica_siguiente);
					FlowUtil.sendvalue(total_activos, DataUtil.financiera_activos);
					FlowUtil.sendvalue(total_pasivos, DataUtil.financiera_pasivos);
					FlowUtil.sendvalue(total_patrimonio, DataUtil.financiera_patrimonio);
					FlowUtil.sendvalue(ingresos_mensuales, DataUtil.financiera_ingresos_menusales);
					FlowUtil.sendvalue(egresos_mensuales, DataUtil.financiera_egresos_mensuales);
					WebElement ingresos_adicionales = DriverFactory.getDriverFacade().getWebDriver()
							.findElement(By.xpath("//div[@id='uniform-recibeOtrosIngresos"
									+ DataUtil.financiera_ingresos_adicionales + "']"));
					FlowUtil.click(ingresos_adicionales);
					WebElement moneda_extranjera = DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath(
							"//div[@id='uniform-realizaTransacciones" + DataUtil.financiera_moneda_extranjera + "']"));
					FlowUtil.click(moneda_extranjera);
					WebElement operaciones_internaciones = DriverFactory.getDriverFacade().getWebDriver()
							.findElement(By.xpath("//div[@id='uniform-relizaOperaciones"
									+ DataUtil.financiera_operaciones_internacionales + "']"));
					FlowUtil.click(operaciones_internaciones);
					WebElement financiero_exterior = DriverFactory.getDriverFacade().getWebDriver().findElement(
							By.xpath("//div[@id='uniform-posesProductos" + DataUtil.financiera_en_el_exterior + "']"));
					FlowUtil.click(financiero_exterior);
					FlowUtil.click(financiera_informacion_siguiente);
					WebElement autorizar_compartir = DriverFactory.getDriverFacade().getWebDriver()
							.findElement(By.xpath("//input[@id='autorizaCOmpartirInformacion"
									+ DataUtil.declaracion_autoriza_compartir + "']"));
					FlowUtil.click(autorizar_compartir);
					WebElement autorizar_recibir = DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath(
							"//input[@id='autorizaRecibirInformacion" + DataUtil.declaracion_autoriza_recibir + "']"));
					FlowUtil.click(autorizar_recibir);
					FlowUtil.click(declaracion_siguiente);
					waitTillInvisibilityofCargando();
					if (FlowUtil.isElementPresent(conocimiento_ok)) {
						FlowUtil.click(conocimiento_ok);
						FlowUtil.swichToWindow(parentWindow);
						FlowUtil.click(refresh_tomador);
						// waitTillInvisibilityofCargando();
					} else if (FlowUtil.isElementPresent(add_tomador_error)) {
						dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Policy", rowNum,
								add_tomador_error.getText());
						FlowUtil.takeFailedScreenshot("emisionPoliza");
						Assert.fail("Error on Emision Poliza");
					}
				}
				// waitTillInvisibilityofCargando();
				FlowUtil.scrollToElement(autoriza_datos_chbx);
				FlowUtil.movetoElement(autoriza_datos_chbx);
				FlowUtil.javascriptClick(autoriza_datos_chbx);
				FlowUtil.click(continuar);
				FlowUtil.click(siguiente2);
				FlowUtil.movetoElement(entidad);
				FlowUtil.selectByValue(entidad, selectEntidad);
				// waitTillInvisibilityofCargando();
				FlowUtil.click(siguiente3);
				// swaitTillInvisibilityofCargando();
				FlowUtil.click(siguiente4);
				FlowUtil.click(siguiente5);
				FlowUtil.click(observaciones);
				FlowUtil.click(submitDec);
				waitTillInvisibilityofCargando();
				if (FlowUtil.isElementPresent(error)) {
					log.info("Error is displayed on Emision Poliza:" + error.getText());
					dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Policy", rowNum, error.getText());
					FlowUtil.takeFailedScreenshot("emisionPoliza");
					FlowUtil.click(cancelar);
					Assert.fail("Error on Emision Poliza");
				} else {
					String poliza = numeroPoliza.getText();
					FlowUtil.javascriptClick(acceptar);
					FlowUtil.sleep(3000);
					// String poliza=numeroPoliza.getText();
					log.info("Numero de poliza: " + poliza);
					FlowUtil.movetoElement(closeRating);
					FlowUtil.javascriptClick(closeRating);

 				dataExcel.setCellData(DataUtil.inputExcelSheetName, "Policy No", rowNum,poliza);
 				dataExcel.setCellData(DataUtil.inputExcelSheetName, "Pass/Fail",rowNum, "Pass"); 
 				dataExcel.setCellData(DataUtil.inputExcelSheetName,"Error_Policy", rowNum, "No");
				FlowUtil.takeSuccessScreenshot("emisionPoliza");
				}

			}
		}
	}

	public void policyPDF(String s_no) {
		FlowUtil.waitTillClickable(pdf_download);
		FlowUtil.movetoElement(pdf_download);
		FlowUtil.javascriptClick(pdf_download);
		try {
			String Title = DriverFactory.getDriverFacade().getWebDriver().switchTo().alert().getText();
			System.out.println(Title);
			FlowUtil.acceptAlert();
		} // try
		catch (NoAlertPresentException Ex) {
			System.out.println("Popup not appeared");
		}
		int n = Integer.parseInt(s_no);
		int rowNum = n + 1;
		//dataExcel.setCellData(DataUtil.inputExcelSheetName, "Policy No", rowNum,poliza);
		dataExcel.setCellData(DataUtil.inputExcelSheetName,"PolicyPDF", rowNum, "Pass");
		dataExcel.setCellData(DataUtil.inputExcelSheetName, "Pass/Fail",rowNum, "Pass"); 
		dataExcel.setCellData(DataUtil.inputExcelSheetName,"Error_Policy", rowNum, "No");
		FlowUtil.takeSuccessScreenshot("emisionPoliza");
		FlowUtil.waitTillClickable(continuar_poliza);
		FlowUtil.click(continuar_poliza);


	}

	public void waitTillInvisibilityofCargando() {
		WebElement cargando = DriverFactory.getDriverFacade().getWebDriver()
				.findElement(By.xpath("//div[@class='blockUI blockMsg blockPage']//img"));
		FlowUtil.waitTillInivisibility(cargando);
	}

}