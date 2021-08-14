package com.simonventas.automation.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.simonventas.automation.commons.utils.DataUtil;
import com.simonventas.automation.commons.utils.ExcelReader;
import com.simonventas.automation.commons.utils.PropertyManager;
import com.simonventas.automation.flow.AutosFlow;
import com.simonventas.automation.flow.CommonConsultationFlow;
import com.simonventas.automation.flow.HogarFlow;

import io.qameta.allure.Step;

public class VentasStepDef {
	public ExcelReader dataExcel=DataUtil.dataExcel;
	public static Logger log=Logger.getLogger(VentasStepDef.class);
	
	
	@Step("Hogar Crear Cotizacion {0}")
	public VentasStepDef hogarCrearCotizacion(int rowNum) {
		/*HogarFlow h=new HogarFlow();
		h.gotoHogar(rowNum);
		h.enterClave(rowNum, dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"), "Clave", rowNum));
		h.selectProducto(dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"), "Producto", rowNum));
		h.enterTomador(rowNum,dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"), "Num_Doc", rowNum));
		h.enterRiesgoInmueble(dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"), "Ciudad", rowNum),dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"), "Direccion", rowNum),dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"), "Estrato", rowNum),dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"), "Ano_Construccion", rowNum),dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"), "Rural", rowNum));
		h.enterValorAsegurado(rowNum,dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"), "Edifico", rowNum),dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"), "No_Electrico", rowNum),dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"), "Electrico", rowNum));
		*/
		System.out.println("Hogar Crear Cotizacion");
		return this;
	}
	
	@Step("Hogar Emission Poliza {0}")
	public VentasStepDef hogarEmisionPoliza(int rowNum) {
		HogarFlow h=new HogarFlow();
		h.doEmitir(rowNum,dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"), "Insp_FechaSegurida", rowNum),dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"), "Insp_FechaSegurida2", rowNum),dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"), "Numero_Pisos", rowNum),dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"), "Barrio", rowNum));
		return this;
	}
	
	@Step("Hogar Common Consultation {0}")
	public VentasStepDef hogarCommonConsultation(int rowNum) {
		CommonConsultationFlow c=new CommonConsultationFlow();
		c.gotoCommonConsult();
		c.consultaCotizaciones(rowNum);
		c.doEmitir(rowNum,dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"), "Numero_Pisos", rowNum),dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"), "Barrio", rowNum));
		return this;
	}
	
	@Step("Hogar Copiar Cotizacion {0}")
	public VentasStepDef hogarCopiarCotizacion(int rowNum) {
		HogarFlow h=new HogarFlow();
		h.copiarCotizacion(rowNum);
		return this;
	}
	
	@Step("Hogar Cotizacion PDF {0}")
	public VentasStepDef hogarCotizacionPDF(int rowNum) {
		HogarFlow h=new HogarFlow();
		h.cotizacionPDF(rowNum);
		return this;
	}
	@Step("Hogar Poliza PDF {0}")
	public VentasStepDef hogarPolicyPDF(int rowNum) {
		HogarFlow h=new HogarFlow();
		h.doEmitirPDF(rowNum, dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"), "Numero_Pisos", rowNum), dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"), "Barrio", rowNum));
		h.policyPDF(rowNum);
		return this;
	}
	
	//Autos Steps Start--------
	@Step("Autos Poliza PDF {0}")
	public VentasStepDef autosCrearCotizacion(int rowNum) {
		AutosFlow a=new AutosFlow();
		a.gotoAutos(rowNum);
		a.enterMarcaPlaca(rowNum, dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"), "Clave", rowNum), dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"), "Sub_Producto", rowNum), dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"), "Placa", rowNum), dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"), "Marca", rowNum));
		return this;
	}
	
   
    	
    
    
}
