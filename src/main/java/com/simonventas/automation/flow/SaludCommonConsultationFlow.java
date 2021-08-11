package com.simonventas.automation.flow;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class SaludCommonConsultationFlow extends CommonConsultationUI{


	public ExcelReader dataExcel=DataUtil.dataExcel;
	public static Log log=new Log(SaludCommonConsultationFlow.class.getName());

	public void gotoCommonConsult() {
		FlowUtil.sleep(5000);
		FlowUtil.waitTillClickable(consulta_cotizaciones_main);
		FlowUtil.movetoElement(consulta_cotizaciones_main);
		FlowUtil.waitTillVisibility(consulta_cotizaciones_menu);
		FlowUtil.movetoElementandClick(consulta_cotizaciones_menu);
		log.info("Navigated to Common Consultation Menu");
	}
	
	public void consultaCotizaciones(String s_no) {
		waitTillInvisibilityofCargando();
		//FlowUtil.selectByValue(compania, DataUtil.salud_common_consultation_campania);
		//waitTillInvisibilityofCargando();
	//	FlowUtil.selectByValue(seccion, DataUtil.salud_common_consultation_seccion);
		waitTillInvisibilityofCargando();
		//FlowUtil.selectByValue(producto, DataUtil.salud_common_consultation_producto);
		String numCotiz=dataExcel.getCellData(DataUtil.inputExcelSheetName, "Num_Cotizacion",2);
		System.out.println("Numero Cotizacion=" +numCotiz);
		FlowUtil.sendvalue(numero_cotizacion,numCotiz );
		//FlowUtil.clearvalue(fecha_desde);
		//FlowUtil.sendvalue(fecha_desde, DataUtil.salud_common_consultation_desde);
		//System.out.println(fecha_desde);
		//FlowUtil.clearvalue(fecha_hasta);
		//FlowUtil.sendvalue(fecha_hasta, DataUtil.salud_common_consultation_hasta);
		//System.out.println(fecha_hasta);
		int n=Integer.parseInt(s_no);
		int rowNum=n+1;
	    //dataExcel.setCellData(DataUtil.inputExcelSheetName, "Num_Cotizacion",rowNum,numCotiz);
		dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion",rowNum , "No");
		FlowUtil.click(consultar);
		waitTillInvisibilityofCargando();

	}

	public void doEmitir(String s_no, String codProducto, 
			String dec_Weight , String dec_height, String selectEntidad) {
		FlowUtil.javascriptClick(emitir);
		FlowUtil.movetoElement(decLink);
		FlowUtil.javascriptClick(decLink);
		waitTillInvisibilityofCargando();
		//FlowUtil.javascriptClick(weight);
		FlowUtil.sendvalue(weight,dec_Weight);
		//waitTillInvisibilityofCargando();
		FlowUtil.pressTab();
		FlowUtil.javascriptClick(height);
		FlowUtil.sendvalue(height,dec_height);
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
		int n=Integer.parseInt(s_no);
		int rowNum=n+1;
		dataExcel.setCellData(DataUtil.inputExcelSheetName, "Numero Declaration",rowNum , decNo.getText());
		FlowUtil.javascriptClick(decContinuar);
		FlowUtil.javascriptClick(emitirCotiz);
		//waitTillInvisibilityofCargando();
		waitTillInvisibilityofCargando();
		String parentWindow1=FlowUtil.getWindowHandle();
		FlowUtil.javascriptClick(siguiente1);
		if(FlowUtil.isElementPresent(addTomador)) {
			FlowUtil.waitTillClickable(addTomador);
			FlowUtil.click(addTomador);
			FlowUtil.sleep(3000);
			Set<String> windows1=FlowUtil.getWindowHandles();
			String subWindow1=null;
			Iterator<String> iterate_window1 = windows1.iterator();
			while (iterate_window1.hasNext()) {
				subWindow1 = iterate_window1.next();
				FlowUtil.swichToWindow(subWindow1);
				String title1=DriverFactory.getDriverFacade().getWebDriver().getTitle();
				if(title1.contains("CONOCIMIENTO")) {
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
				//FlowUtil.swichToWindow(parentWindow);
				FlowUtil.click(refresh_tomador);
				//waitTillInvisibilityofCargando();
			}
			else if(FlowUtil.isElementPresent(add_tomador_error)){
				//dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Policy", rowNum, add_tomador_error.getText());
				FlowUtil.takeFailedScreenshot("emisionPoliza");
				Assert.fail("Error on Emision Poliza");
			}
		}
		//waitTillInvisibilityofCargando();
		FlowUtil.scrollToElement(autoriza_datos_chbx);
		FlowUtil.movetoElement(autoriza_datos_chbx);
		FlowUtil.javascriptClick(autoriza_datos_chbx);
		FlowUtil.click(continuar);
		FlowUtil.click(siguiente2);
		FlowUtil.movetoElement(entidad);
		FlowUtil.selectByValue(entidad, selectEntidad);
		//waitTillInvisibilityofCargando();
		FlowUtil.click(siguiente3);
		//swaitTillInvisibilityofCargando();
		FlowUtil.click(siguiente4);
		FlowUtil.click(siguiente5);
		//FlowUtil.click(observaciones);
		FlowUtil.click(submitDec);
		waitTillInvisibilityofCargando();
		if(FlowUtil.isElementPresent(error)) {
			log.info("Error is displayed on Emision Poliza:"+error.getText());
			//dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Policy", rowNum, error.getText());
			FlowUtil.takeFailedScreenshot("emisionPoliza");
			FlowUtil.click(cancelar);
			Assert.fail("Error on Emision Poliza");
		}
		else {
			String poliza=numeroPoliza.getText();
			FlowUtil.javascriptClick(acceptar);
			FlowUtil.sleep(3000);
			//String poliza=numeroPoliza.getText();
			log.info("Numero de poliza: "+poliza);
			FlowUtil.movetoElement(closeRating);
			FlowUtil.javascriptClick(closeRating);
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
		WebElement cargando=DriverFactory.getDriverFacade().
				getWebDriver().findElement(By.xpath("//div[@class='blockUI blockMsg blockPage']//img"));
		FlowUtil.waitTillInivisibility(cargando);
	}
}

