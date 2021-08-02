package com.simonventas.automation.flow;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.simonventas.automation.commons.helpers.DriverFactory;
import com.simonventas.automation.ui.HogarUI;
import com.simonventas.automation.utils.DataUtil;
import com.simonventas.automation.utils.ExcelReader;
import com.simonventas.automation.utils.FlowUtil;
import com.simonventas.automation.utils.Log;

public class HogarFlow extends HogarUI{

	public ExcelReader dataExcel=DataUtil.dataExcel;
	public static Log log=new Log(HogarFlow.class.getName());
	

	public  void gotoHogar(String s_no) {
		if(FlowUtil.elementIsDisplayed(page_error)) {
			int n=Integer.parseInt(s_no);
			int rowNum=n+1;
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion",rowNum, page_error.getText().substring(0, 53));
			Assert.fail(page_error.getText());
		}
		else {
			FlowUtil.waitTillClickable(hogar_main);
			FlowUtil.movetoElement(hogar_main);
			FlowUtil.waitTillVisibility(hogar_menu);
			FlowUtil.movetoElementandClick(hogar_menu);
			log.info("Navigated to Hogar Menu");
			
		}	
	}

	public void enterClave(String s_no,String agente) {
		waitTillInvisibilityofCargando();
		if(FlowUtil.elementIsDisplayed(page_error)) {
			int n=Integer.parseInt(s_no);
			int rowNum=n+1;
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion",rowNum, "Serivce Error");
			Assert.fail("Service Error"+page_error.getText());
		}
		FlowUtil.clearvalue(clave);
		FlowUtil.click(clave);
		FlowUtil.sendvalue(clave, agente);
		FlowUtil.pressTab();
		waitTillInvisibilityofCargando();
		FlowUtil.sleep(3000);
		log.info("clave nombre:"+clave_nombre.getText());
		if(FlowUtil.elementIsDisplayed(clave_nombre)){
			//FlowUtil.movetoElementandClick(siguiente1);
			FlowUtil.javascriptClick(siguiente1);
		}
		else if(FlowUtil.elementIsDisplayed(clave_service_error)) {
			FlowUtil.click(inicio);
			Assert.fail("clave service error");
		}
	}

	public void selectProducto(String codProducto) {
		FlowUtil.movetoElement(producto);
		FlowUtil.selectByValue(producto, codProducto);
		waitTillInvisibilityofCargando();
		FlowUtil.javascriptClick(siguiente2);
		FlowUtil.javascriptClick(siguiente3);
	}

	public void enterTomador(String s_no,String nro_documento  ) {
		
		FlowUtil.javascriptClick(nrodocumento);
		FlowUtil.clearvalue(nrodocumento);
		FlowUtil.sendvalue(nrodocumento, nro_documento);
		FlowUtil.pressTab();
		waitTillInvisibilityofCargando();
		FlowUtil.sleep(3000);
		if(FlowUtil.elementIsDisplayed(tomador_error)){
			log.info(DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@id='errorSpan']")).getText());
			if(FlowUtil.getText(tomador_no_existe).contains("Persona no existe")){
				FlowUtil.sendvalue(nombre, DataUtil.newTomadorNombre);
				FlowUtil.sendvalue(apellidos, DataUtil.newTomadorApellido);
			}else {
				int n=Integer.parseInt(s_no);
				int rowNum=n+1;
				dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion",rowNum, tomador_error.getText().substring(0, 53));
				dataExcel.setCellData(DataUtil.inputExcelSheetName, "Policy No", rowNum, "Not Executed");
				dataExcel.setCellData(DataUtil.inputExcelSheetName, "Pass/Fail", rowNum, "Fail");
				FlowUtil.takeFailedScreenshot("CrearCotizacion");
				FlowUtil.movetoElementandClick(inicio);
				Assert.fail("Error on Tomador Screen");
			}
		}
		FlowUtil.scrollToElement(autoriza_datos_chbx);
		FlowUtil.movetoElement(autoriza_datos_chbx);
		FlowUtil.javascriptClick(autoriza_datos_chbx);
		FlowUtil.click(continuar);
		FlowUtil.javascriptClick(siguiente4);
	}


	public void enterRiesgoInmueble(String ciudad, String direccion,String estratoNum, String ano_construction,String rural) {
		FlowUtil.sendvalue(ciudadRiesgo, ciudad);
		FlowUtil.pressTab();
		waitTillInvisibilityofCargando();
		FlowUtil.sendvalue(direccionRiesgo, direccion);
		FlowUtil.pressTab();
		waitTillInvisibilityofCargando();
		FlowUtil.selectByValue(estrato, estratoNum);
		FlowUtil.scrollToElement(anosConstruccion);
		FlowUtil.movetoElement(anosConstruccion);
		FlowUtil.selectByValue(anosConstruccion, ano_construction);
		if(rural.equalsIgnoreCase("Yes")) {
			FlowUtil.movetoElement(rural_box);
			FlowUtil.javascriptClick(rural_box);
		}
		FlowUtil.javascriptClick(riesgo_continuar);
	}

	public void enterValorAsegurado(String s_no,String edificio, String contenido_no_electrico, String contenido_electrico) {
		FlowUtil.javascriptClick(vr_edificio);
		FlowUtil.sendvalue(vr_edificio, edificio);
		FlowUtil.javascriptClick(vr_contenido_no_electrico);
		FlowUtil.sendvalue(vr_contenido_no_electrico, contenido_no_electrico);
		FlowUtil.javascriptClick(vr_contenido_electrico);
		FlowUtil.sendvalue(vr_contenido_electrico, contenido_electrico);
		FlowUtil.click(siguiente6);
		FlowUtil.click(submit);
		waitTillInvisibilityofCargando();
		if(FlowUtil.isElementPresent(quoteNo)) {
			log.info("Cotizacion No is : "+quoteNo.getText());
			int n=Integer.parseInt(s_no);
			int rowNum=n+1;
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Num_Cotizacion",rowNum , quoteNo.getText());
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion",rowNum , "No");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "CotizacionPDF",rowNum,"Not Executed");
			FlowUtil.takeSuccessScreenshot("CrearCotizacion");
		}
		else if(FlowUtil.isElementPresent(error)){
			log.info("Error is displayed on Crear Cotizacion:"+error.getText());
			int n=Integer.parseInt(s_no);
			int rowNum=n+1;
			//dataExcel.setCellData("Hogar", "Num_Cotizacion",rowNum ," ");
			//dataExcel.setCellData("Hogar", "Error", rowNum, " ");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Num_Cotizacion", rowNum, "");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion", rowNum, error.getText());
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Policy No", rowNum, "Not Executed");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Pass/Fail", rowNum, "Fail");
			FlowUtil.takeFailedScreenshot("CrearCotizacion");
			FlowUtil.click(cancelar);
			Assert.fail("Error on Crear Cotizacion");
		}		
	}

	public void doEmitir(String s_no,String fechasegurida,String fechasegurida2,String pisos, String num_barrio) {
		FlowUtil.click(emitir);
		log.info("Emision Started");
		if(FlowUtil.isElementPresent(inspeccion_continuar)) {
			FlowUtil.click(inspeccion_continuar);
			waitTillInvisibilityofCargando();
			FlowUtil.movetoElement(fecha_segurida);
			FlowUtil.sendvalue(fecha_segurida,fechasegurida);
			FlowUtil.movetoElement(fecha_segurida2);
			FlowUtil.sendvalue(fecha_segurida2, fechasegurida2);
			FlowUtil.click(siguiente1);
			FlowUtil.click(siguiente2);
			FlowUtil.click(agendar);
			waitTillInvisibilityofCargando();
		}
		else if(FlowUtil.isElementPresent(alert)) {
			FlowUtil.click(alert);
		}
		waitTillInvisibilityofCargando();
		String parentWindow=FlowUtil.getWindowHandle();
		FlowUtil.click(siguiente1);
		if(FlowUtil.isElementPresent(addTomador)) {
			FlowUtil.waitTillClickable(addTomador);
			FlowUtil.click(addTomador);
			FlowUtil.sleep(3000);
			Set<String> windows=FlowUtil.getWindowHandles();
			String subWindow = null;
			Iterator<String> iterate_window = windows.iterator();
			while (iterate_window.hasNext()) {
				subWindow = iterate_window.next();
				FlowUtil.swichToWindow(subWindow);
				String title=DriverFactory.getDriverFacade().getWebDriver().getTitle();
				if(title.contains("CONOCIMIENTO")) {
					FlowUtil.swichToWindow(subWindow);
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
			FlowUtil.sendvalue(direccion, DataUtil.general_direccion);
			FlowUtil.sendvalue(ciudad, DataUtil.general_ciudad);
			FlowUtil.pressTab();
			FlowUtil.sendvalue(telephono, DataUtil.general_telephono);
			FlowUtil.sendvalue(celular, DataUtil.general_celular);
			FlowUtil.sendvalue(correo, DataUtil.general_correo);
			FlowUtil.click(informacion_general_siguiente);
			waitTillInvisibilityofCargando();
			FlowUtil.selectByValue(occupacion, DataUtil.actividad_economica_occupacion);
			WebElement expuesta=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@id='uniform-personaPublicamente"+DataUtil.actividad_economica_expuesta+"']"));
			FlowUtil.click(expuesta);
			WebElement expuesta_familiares=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@id='uniform-tieneVinculosSocio"+DataUtil.actividad_economica_familiares_expuesta+"']"));
			FlowUtil.click(expuesta_familiares);
			FlowUtil.click(actividad_econimica_siguiente);
			FlowUtil.sendvalue(total_activos, DataUtil.financiera_activos);
			FlowUtil.sendvalue(total_pasivos, DataUtil.financiera_pasivos);
			FlowUtil.sendvalue(total_patrimonio, DataUtil.financiera_patrimonio);
			FlowUtil.sendvalue(ingresos_mensuales, DataUtil.financiera_ingresos_menusales);
			FlowUtil.sendvalue(egresos_mensuales, DataUtil.financiera_egresos_mensuales);
			WebElement ingresos_adicionales=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@id='uniform-recibeOtrosIngresos"+DataUtil.financiera_ingresos_adicionales+"']"));
			FlowUtil.click(ingresos_adicionales);
			WebElement moneda_extranjera=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@id='uniform-realizaTransacciones"+DataUtil.financiera_moneda_extranjera+"']"));
			FlowUtil.click(moneda_extranjera);
			WebElement operaciones_internaciones=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@id='uniform-relizaOperaciones"+DataUtil.financiera_operaciones_internacionales+"']"));
			FlowUtil.click(operaciones_internaciones);
			WebElement financiero_exterior=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@id='uniform-posesProductos"+DataUtil.financiera_en_el_exterior+"']"));
			FlowUtil.click(financiero_exterior);
			FlowUtil.click(financiera_informacion_siguiente);
			WebElement autorizar_compartir=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//input[@id='autorizaCOmpartirInformacion"+DataUtil.declaracion_autoriza_compartir+"']"));
			FlowUtil.click(autorizar_compartir);
			WebElement autorizar_recibir=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//input[@id='autorizaRecibirInformacion"+DataUtil.declaracion_autoriza_recibir+"']"));
			FlowUtil.click(autorizar_recibir);
			FlowUtil.click(declaracion_siguiente);
			waitTillInvisibilityofCargando();
			if(FlowUtil.isElementPresent(conocimiento_ok)) {
				FlowUtil.click(conocimiento_ok);
				FlowUtil.swichToWindow(parentWindow);
				FlowUtil.click(refresh_tomador);
				waitTillInvisibilityofCargando();
			}
			else if(FlowUtil.isElementPresent(add_tomador_error)){
				int n=Integer.parseInt(s_no);
				int rowNum=n+1;
				dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Policy", rowNum, add_tomador_error.getText());
				FlowUtil.takeFailedScreenshot("emisionPoliza");
				Assert.fail("Error on Emision Poliza");
			}
			
		}
		FlowUtil.movetoElement(autoriza_datos_chbx);
		FlowUtil.javascriptClick(autoriza_datos_chbx);
		FlowUtil.click(continuar);
		FlowUtil.click(siguiente2);
		FlowUtil.click(siguiente3);
		FlowUtil.click(siguiente4);
		FlowUtil.waitTillClickable(datos_adicionales_1);
		FlowUtil.movetoElementandClick(datos_adicionales_1);
		FlowUtil.sendvalue(numero_pisos, pisos);
		FlowUtil.sendvalue(barrio, num_barrio);
		FlowUtil.click(riesgo_continuar);
		FlowUtil.click(siguiente6);
		FlowUtil.click(siguiente7);
		FlowUtil.selectByValue(tipo_envio, DataUtil.tipoEnvio);
		FlowUtil.click(submit);
		log.info("Final Emitir button clicked");
		waitTillInvisibilityofCargando();
		if(FlowUtil.isElementPresent(error)) {
			log.info("Error is displayed on Emision Poliza:"+error.getText());
			int n=Integer.parseInt(s_no);
			int rowNum=n+1;
			//dataExcel.setCellData("Hogar", "Num_Cotizacion",rowNum ," ");
			//dataExcel.setCellData("Hogar", "Error", rowNum, " ");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Policy", rowNum, error.getText());
			FlowUtil.takeFailedScreenshot("emisionPoliza");
			FlowUtil.click(cancelar);
			Assert.fail("Error on Emision Poliza");
		}
		else {
			FlowUtil.javascriptClick(acceptar);
			String poliza=numero_poliza.getText();
			log.info("Numero de poliza: "+poliza);
			int n=Integer.parseInt(s_no);
			int rowNum=n+1;
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Policy No", rowNum, poliza);
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Pass/Fail", rowNum, "Pass");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Policy", rowNum, "No");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Copiar_Cotizacion",rowNum , "Not Executed");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "PolicyPDF",rowNum , "Not Executed");
			FlowUtil.takeSuccessScreenshot("emisionPoliza");
			FlowUtil.waitTillClickable(continuar_poliza);
			FlowUtil.click(continuar_poliza);
		}
		
		
	}
	
	public void copiarCotizacion(String s_no) {
		FlowUtil.click(copiar_quote);
		waitTillInvisibilityofCargando();
		log.info("clave nombre:"+clave_nombre.getText());
		if(FlowUtil.elementIsDisplayed(clave_nombre)){
			//FlowUtil.movetoElementandClick(siguiente1);
			FlowUtil.javascriptClick(siguiente1);
		}
		else if(FlowUtil.elementIsDisplayed(clave_service_error)) {
			FlowUtil.click(inicio);
			Assert.fail("clave service error");
		}
		FlowUtil.javascriptClick(siguiente2);
		FlowUtil.javascriptClick(siguiente3);
		FlowUtil.scrollToElement(autoriza_datos_chbx);
		FlowUtil.movetoElement(autoriza_datos_chbx);
		FlowUtil.javascriptClick(autoriza_datos_chbx);
		FlowUtil.click(continuar);
		FlowUtil.javascriptClick(siguiente4);
		waitTillInvisibilityofCargando();
		FlowUtil.javascriptClick(riesgo_continuar);
		FlowUtil.click(siguiente6);
		FlowUtil.click(submit);
		waitTillInvisibilityofCargando();
		if(FlowUtil.isElementPresent(quoteNo)) {
			log.info("Cotizacion No is : "+quoteNo.getText());
			int n=Integer.parseInt(s_no);
			int rowNum=n+1;
			//dataExcel.setCellData(DataUtil.inputExcelSheetName, "Num_Cotizacion",rowNum," ");
			//dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error",rowNum ," ");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Copiar_Cotizacion",rowNum , quoteNo.getText());
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion",rowNum , "No");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Policy No",rowNum , "Not Executed");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Policy",rowNum , "No");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "PolicyPDF",rowNum , "Not Executed");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Pass/Fail",rowNum , "Pass");
			FlowUtil.takeSuccessScreenshot("CopiarCotizacion");
			FlowUtil.click(cancelar);
		}
		else if(FlowUtil.isElementPresent(error)){
			log.info("Error is displayed on Crear Cotizacion:"+error.getText());
			int n=Integer.parseInt(s_no);
			int rowNum=n+1;
			//dataExcel.setCellData("Hogar", "Num_Cotizacion",rowNum ," ");
			//dataExcel.setCellData("Hogar", "Error", rowNum, " ");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Num_Cotizacion", rowNum, "");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion", rowNum, error.getText());
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Policy No", rowNum, "Not Executed");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Pass/Fail", rowNum, "Fail");
			FlowUtil.takeFailedScreenshot("CrearCotizacion");
			FlowUtil.click(cancelar);
			Assert.fail("Error on Crear Cotizacion");
		}
		
		
	}
	
	public void cotizacionPDF(String s_no) {
		String parentWindow=FlowUtil.getWindowHandle();
		FlowUtil.movetoElement(pdf);
		FlowUtil.click(pdf);
		Set<String> windows=FlowUtil.getWindowHandles();
		String subWindow = null;
		Iterator<String> iterate_window = windows.iterator();
		while (iterate_window.hasNext()) {
			subWindow = iterate_window.next();
			FlowUtil.swichToWindow(subWindow);
			String title=DriverFactory.getDriverFacade().getWebDriver().getTitle();
			if(title.contains("Untitled")) {
				FlowUtil.swichToWindow(subWindow);
				log.info(DriverFactory.getDriverFacade().getWebDriver().getTitle());
			}
		}
		FlowUtil.swichToWindow(parentWindow);
		int n=Integer.parseInt(s_no);
		int rowNum=n+1;
		dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion",rowNum , "No");
		dataExcel.setCellData(DataUtil.inputExcelSheetName, "Policy No",rowNum , "Not Executed");
		dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Policy",rowNum , "No");
		dataExcel.setCellData(DataUtil.inputExcelSheetName, "PolicyPDF",rowNum , "Not Executed");
		dataExcel.setCellData(DataUtil.inputExcelSheetName, "Pass/Fail",rowNum , "Pass");
		dataExcel.setCellData(DataUtil.inputExcelSheetName, "CotizacionPDF", rowNum, "Pass");
		FlowUtil.movetoElement(cancelar);
		FlowUtil.click(cancelar);
		
		
	}
	
	public void doEmitirPDF(String s_no,String pisos, String num_barrio) {
		FlowUtil.click(emitir);
		log.info("Emision Started");
		FlowUtil.click(alert);
		waitTillInvisibilityofCargando();
		String parentWindow=FlowUtil.getWindowHandle();
		FlowUtil.click(siguiente1);
		if(FlowUtil.isElementPresent(addTomador)) {
			FlowUtil.waitTillClickable(addTomador);
			FlowUtil.click(addTomador);
			FlowUtil.sleep(3000);
			Set<String> windows=FlowUtil.getWindowHandles();
			String subWindow = null;
			Iterator<String> iterate_window = windows.iterator();
			while (iterate_window.hasNext()) {
				subWindow = iterate_window.next();
				FlowUtil.swichToWindow(subWindow);
				String title=DriverFactory.getDriverFacade().getWebDriver().getTitle();
				if(title.contains("CONOCIMIENTO")) {
					FlowUtil.swichToWindow(subWindow);
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
			FlowUtil.sendvalue(direccion, DataUtil.general_direccion);
			FlowUtil.sendvalue(ciudad, DataUtil.general_ciudad);
			FlowUtil.pressTab();
			FlowUtil.sendvalue(telephono, DataUtil.general_telephono);
			FlowUtil.sendvalue(celular, DataUtil.general_celular);
			FlowUtil.sendvalue(correo, DataUtil.general_correo);
			FlowUtil.click(informacion_general_siguiente);
			waitTillInvisibilityofCargando();
			FlowUtil.selectByValue(occupacion, DataUtil.actividad_economica_occupacion);
			WebElement expuesta=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@id='uniform-personaPublicamente"+DataUtil.actividad_economica_expuesta+"']"));
			FlowUtil.click(expuesta);
			WebElement expuesta_familiares=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@id='uniform-tieneVinculosSocio"+DataUtil.actividad_economica_familiares_expuesta+"']"));
			FlowUtil.click(expuesta_familiares);
			FlowUtil.click(actividad_econimica_siguiente);
			FlowUtil.sendvalue(total_activos, DataUtil.financiera_activos);
			FlowUtil.sendvalue(total_pasivos, DataUtil.financiera_pasivos);
			FlowUtil.sendvalue(total_patrimonio, DataUtil.financiera_patrimonio);
			FlowUtil.sendvalue(ingresos_mensuales, DataUtil.financiera_ingresos_menusales);
			FlowUtil.sendvalue(egresos_mensuales, DataUtil.financiera_egresos_mensuales);
			WebElement ingresos_adicionales=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@id='uniform-recibeOtrosIngresos"+DataUtil.financiera_ingresos_adicionales+"']"));
			FlowUtil.click(ingresos_adicionales);
			WebElement moneda_extranjera=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@id='uniform-realizaTransacciones"+DataUtil.financiera_moneda_extranjera+"']"));
			FlowUtil.click(moneda_extranjera);
			WebElement operaciones_internaciones=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@id='uniform-relizaOperaciones"+DataUtil.financiera_operaciones_internacionales+"']"));
			FlowUtil.click(operaciones_internaciones);
			WebElement financiero_exterior=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@id='uniform-posesProductos"+DataUtil.financiera_en_el_exterior+"']"));
			FlowUtil.click(financiero_exterior);
			FlowUtil.click(financiera_informacion_siguiente);
			WebElement autorizar_compartir=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//input[@id='autorizaCOmpartirInformacion"+DataUtil.declaracion_autoriza_compartir+"']"));
			FlowUtil.click(autorizar_compartir);
			WebElement autorizar_recibir=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//input[@id='autorizaRecibirInformacion"+DataUtil.declaracion_autoriza_recibir+"']"));
			FlowUtil.click(autorizar_recibir);
			FlowUtil.click(declaracion_siguiente);
			waitTillInvisibilityofCargando();
			if(FlowUtil.isElementPresent(conocimiento_ok)) {
				FlowUtil.click(conocimiento_ok);
				FlowUtil.swichToWindow(parentWindow);
				FlowUtil.click(refresh_tomador);
				waitTillInvisibilityofCargando();
			}
			else if(FlowUtil.isElementPresent(add_tomador_error)){
				int n=Integer.parseInt(s_no);
				int rowNum=n+1;
				dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Policy", rowNum, add_tomador_error.getText());
				FlowUtil.takeFailedScreenshot("emisionPoliza");
				Assert.fail("Error on Emision Poliza");
			}
			
		}
		FlowUtil.movetoElement(autoriza_datos_chbx);
		FlowUtil.javascriptClick(autoriza_datos_chbx);
		FlowUtil.click(continuar);
		FlowUtil.click(siguiente2);
		FlowUtil.click(siguiente3);
		FlowUtil.click(siguiente4);
		FlowUtil.waitTillClickable(datos_adicionales_1);
		FlowUtil.movetoElementandClick(datos_adicionales_1);
		FlowUtil.sendvalue(numero_pisos, pisos);
		FlowUtil.sendvalue(barrio, num_barrio);
		FlowUtil.click(riesgo_continuar);
		FlowUtil.click(siguiente6);
		FlowUtil.click(siguiente7);
		FlowUtil.selectByValue(tipo_envio, DataUtil.tipoEnvio);
		FlowUtil.click(submit);
		log.info("Final Emitir button clicked");
		waitTillInvisibilityofCargando();
		if(FlowUtil.isElementPresent(error)) {
			log.info("Error is displayed on Emision Poliza:"+error.getText());
			int n=Integer.parseInt(s_no);
			int rowNum=n+1;
			//dataExcel.setCellData("Hogar", "Num_Cotizacion",rowNum ," ");
			//dataExcel.setCellData("Hogar", "Error", rowNum, " ");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Policy", rowNum, error.getText());
			FlowUtil.takeFailedScreenshot("emisionPoliza");
			FlowUtil.click(cancelar);
			Assert.fail("Error on Emision Poliza");
		}
		else {
			FlowUtil.javascriptClick(acceptar);
			String poliza=numero_poliza.getText();
			log.info("Numero de poliza: "+poliza);
			int n=Integer.parseInt(s_no);
			int rowNum=n+1;
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Policy No", rowNum, poliza);
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Pass/Fail", rowNum, "Pass");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Policy", rowNum, "No");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Copiar_Cotizacion",rowNum , "Not Executed");
			FlowUtil.takeSuccessScreenshot("emisionPoliza");
			FlowUtil.waitTillClickable(continuar_poliza);
			//FlowUtil.click(continuar_poliza);
		}
		
		
	}
	
	public void policyPDF(String s_no) {
		String parentWindow=FlowUtil.getWindowHandle();
		if(FlowUtil.isElementPresent(warning_message)) {
			int n=Integer.parseInt(s_no);
			int rowNum=n+1;
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "CotizacionPDF", rowNum, "Not Executed");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "PolicyPDF",rowNum ,warning_message.getText());
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Pass/Fail",rowNum , "Pass");

		}
		else {
			FlowUtil.movetoElement(pdf);
			FlowUtil.click(pdf);
			Set<String> windows=FlowUtil.getWindowHandles();
			String subWindow = null;
			Iterator<String> iterate_window = windows.iterator();
			while (iterate_window.hasNext()) {
				subWindow = iterate_window.next();
				FlowUtil.swichToWindow(subWindow);
				String title=DriverFactory.getDriverFacade().getWebDriver().getTitle();
				if(title.contains("Untitled")) {
					FlowUtil.swichToWindow(subWindow);
					log.info(DriverFactory.getDriverFacade().getWebDriver().getTitle());
				}
			}
			FlowUtil.swichToWindow(parentWindow);
			int n=Integer.parseInt(s_no);
			int rowNum=n+1;
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "CotizacionPDF", rowNum, "Not Executed");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "PolicyPDF",rowNum , "Pass");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Pass/Fail",rowNum , "Pass");

		}
		
	}
	
	public void waitTillInvisibilityofCargando() {
		WebElement cargando=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@class='blockUI blockMsg blockPage']//img"));
		FlowUtil.waitTillInivisibility(cargando);
	}
	
	
	
}
