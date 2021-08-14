package com.simonventas.automation.flow;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.simonventas.automation.commons.helpers.DriverFactory;
import com.simonventas.automation.commons.utils.DataUtil;
import com.simonventas.automation.commons.utils.ExcelReader;
import com.simonventas.automation.commons.utils.FlowUtil;
import com.simonventas.automation.commons.utils.Log;
import com.simonventas.automation.ui.CommonConsultationUI;

public class CommonConsultationFlow extends CommonConsultationUI{


	public ExcelReader dataExcel=DataUtil.dataExcel;
	public static Log log=new Log(CommonConsultationFlow.class.getName());

	public void gotoCommonConsult() {
		FlowUtil.waitTillClickable(consulta_cotizaciones_main);
		FlowUtil.movetoElement(consulta_cotizaciones_main);
		FlowUtil.waitTillVisibility(consulta_cotizaciones_menu);
		FlowUtil.movetoElementandClick(consulta_cotizaciones_menu);
		log.info("Navigated to Common Consultation Menu");
	}

	public void consultaCotizaciones(int rowNum) {
		waitTillInvisibilityofCargando();
		FlowUtil.selectByValue(compania, DataUtil.common_consultation_campania);
		waitTillInvisibilityofCargando();
		FlowUtil.selectByValue(seccion, DataUtil.common_consultation_seccion);
		waitTillInvisibilityofCargando();
		FlowUtil.selectByValue(producto, DataUtil.common_consultation_producto);
		String numCotiz=dataExcel.getCellData(DataUtil.inputExcelSheetName, "Num_Cotizacion",4);
		FlowUtil.sendvalue(numero_cotizacion,numCotiz);
		log.info(dataExcel.getCellData(DataUtil.inputExcelSheetName, "Fecha_Desde",rowNum));
		FlowUtil.clearvalue(fecha_desde);
		FlowUtil.sendvalue(fecha_desde, dataExcel.getCellData(DataUtil.inputExcelSheetName, "Fecha_Desde",rowNum));
		log.info(dataExcel.getCellData(DataUtil.inputExcelSheetName, "Fecha_Hasta",rowNum));
		FlowUtil.clearvalue(fecha_hasta);
		FlowUtil.sendvalue(fecha_hasta, dataExcel.getCellData(DataUtil.inputExcelSheetName, "Fecha_Hasta",rowNum));
		dataExcel.setCellData(DataUtil.inputExcelSheetName, "Num_Cotizacion",rowNum,numCotiz);
		dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion",rowNum , "No");
		dataExcel.setCellData(DataUtil.inputExcelSheetName, "PolicyPDF",rowNum , "Not Executed");
		dataExcel.setCellData(DataUtil.inputExcelSheetName, "CotizacionPDF",rowNum , "Not Executed");
		FlowUtil.click(consultar);
		waitTillInvisibilityofCargando();
	}

	public void doEmitir(int rowNum,String pisos, String num_barrio) {
		FlowUtil.movetoElement(emitir);
		FlowUtil.click(emitir);
		waitTillInvisibilityofCargando();
		log.info("Emision Started");
		FlowUtil.click(alert);
		FlowUtil.sleep(3000);
		waitTillInvisibilityofCargando();
		String parentWindow=FlowUtil.getWindowHandle();
		FlowUtil.javascriptClick(siguiente1);
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
			FlowUtil.click(conocimiento_ok);
			FlowUtil.swichToWindow(parentWindow);
			FlowUtil.click(refresh_tomador);
			waitTillInvisibilityofCargando();
			if(FlowUtil.isElementPresent(conocimiento_ok)) {
				FlowUtil.click(conocimiento_ok);
				FlowUtil.swichToWindow(parentWindow);
				FlowUtil.click(refresh_tomador);
				waitTillInvisibilityofCargando();
			}
			else if(FlowUtil.isElementPresent(add_tomador_error)){
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
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Policy No", rowNum, poliza);
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Pass/Fail", rowNum, "Pass");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Policy", rowNum, "No");
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Copiar_Cotizacion",rowNum , "Not Executed");
			FlowUtil.takeSuccessScreenshot("emisionPoliza");
			FlowUtil.waitTillClickable(continuar_poliza);
			FlowUtil.click(continuar_poliza);
		}
		
	}

	public void waitTillInvisibilityofCargando() {
		WebElement cargando=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@class='blockUI blockMsg blockPage']//img"));
		FlowUtil.waitTillInivisibility(cargando);
	}


}
