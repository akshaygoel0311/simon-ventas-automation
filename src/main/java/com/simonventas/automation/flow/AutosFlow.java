package com.simonventas.automation.flow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.simonventas.automation.commons.helpers.DriverFactory;
import com.simonventas.automation.commons.utils.DataUtil;
import com.simonventas.automation.commons.utils.ExcelReader;
import com.simonventas.automation.commons.utils.FlowUtil;
import com.simonventas.automation.commons.utils.Log;
import com.simonventas.automation.ui.AutosUI;

public class AutosFlow extends AutosUI{
	
	public ExcelReader dataExcel=DataUtil.dataExcel;
	public static Log log=new Log(AutosFlow.class.getName());
	

	public  void gotoAutos(int rowNum) {
		if(FlowUtil.elementIsDisplayed(page_error)) {
			dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion",rowNum, page_error.getText().substring(0, 53));
			Assert.fail(page_error.getText());
		}
		else {
			FlowUtil.waitTillClickable(autos_main);
			FlowUtil.movetoElement(autos_main);
			FlowUtil.waitTillVisibility(autos_menu);
			FlowUtil.movetoElementandClick(autos_menu);
			log.info("Navigated to Autos Menu");
			
		}	
	}
	
	public void enterMarcaPlaca(int rowNum,String agente,String codsubProducto,String placa, String marcaDesc) {
		waitTillInvisibilityofCargando();
		if(FlowUtil.isElementPresent(page_error)) {
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
			FlowUtil.movetoElement(subproducto);
			FlowUtil.selectByValue(subproducto, codsubProducto);
			if(FlowUtil.isElementPresent(DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@class='blockUI blockMsg blockPage']//img")))) {
				waitTillInvisibilityofCargando();
			}
			if(placa.isEmpty()) {
				FlowUtil.movetoElement(marcaCheckbox);
				FlowUtil.javascriptClick(marcaCheckbox);
				FlowUtil.sendvalue(marcaDescription, marcaDesc);
				FlowUtil.pressTab();
				waitTillInvisibilityofCargando();
				if(FlowUtil.elementIsDisplayed(errorMarcaPlaca)) {
					dataExcel.setCellData(DataUtil.inputExcelSheetName, "Error_Cotizacion",rowNum, errorMarcaPlaca.getText().substring(0, 53));
					Assert.fail(errorMarcaPlaca.getText());
				}
				else {
					FlowUtil.movetoElement(marcaConsultationTable);
					FlowUtil.click(firstmarca);
					FlowUtil.waitTillVisibility(modelo);
					FlowUtil.click(modelo);
					FlowUtil.acceptAlert();
					waitTillInvisibilityofCargando();
				}
			}
			else {
				//placa part
				FlowUtil.click(placa_marcaContinuar);
			}
		}
		else if(FlowUtil.elementIsDisplayed(clave_service_error)) {
			FlowUtil.click(inicio);
			Assert.fail("clave service error");
		}
		
		
	}
	
	public void waitTillInvisibilityofCargando() {
		WebElement cargando=DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath("//div[@class='blockUI blockMsg blockPage']//img"));
		FlowUtil.waitTillInivisibility(cargando);
	}


}
