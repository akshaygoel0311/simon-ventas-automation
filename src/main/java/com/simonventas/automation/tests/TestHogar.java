package com.simonventas.automation.tests;

import java.util.Hashtable;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.simonventas.automation.commons.Hooks;
import com.simonventas.automation.commons.dataproviders.DataProviderSource;
import com.simonventas.automation.commons.utils.DataUtil;
import com.simonventas.automation.commons.utils.ExcelReader;
import com.simonventas.automation.commons.utils.Log;
import com.simonventas.automation.commons.utils.PropertyManager;

import io.qameta.allure.Step;


@Listeners(com.simonventas.automation.utils.TestListener.class)	
public class TestHogar {//extends Hooks{

	public ExcelReader dataExcel=DataUtil.dataExcel;
	public static Log log=new Log(TestHogar.class.getName());
	ThreadLocal<VentasStepDef> steps= ThreadLocal.withInitial(VentasStepDef::new);

	@Test(  
			priority=1,
			dataProviderClass=DataProviderSource.class,
			dataProvider="existing-tercero-test-data",
			enabled=true,
			testName="Verify Hogar with Existing Tercero")
	@Step("Hogar with Existing Tercero")
	public void verifyHogarwithExisitingTercero(Hashtable<String,String> data) {
			/*int rowNum=Integer.parseInt(dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"),"S.no", 2));
			steps.get()
			.hogarCrearCotizacion(rowNum+1)
			.hogarEmisionPoliza(rowNum+1);*/
			VentasStepDef step=new VentasStepDef();
			step.hogarCrearCotizacion(0);
			
	}
	@Test(priority=2,
			enabled=false,
			dataProviderClass=DataProviderSource.class,
			dataProvider="non-existing-tercero-test-data",
			testName="Verify Hogar with Non Existing Tercero")
	public void verifyHogarwithNonExisitingTercero(Hashtable<String,String> data) {
		int rowNum=Integer.parseInt(dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"),"S.no", 3));
		steps.get()
		.hogarCrearCotizacion(rowNum+1)
		.hogarEmisionPoliza(rowNum+1);
	}
	@Test(priority=3,
			enabled=false,
			dataProviderClass=DataProviderSource.class,
			dataProvider="copiar-cotizacion-test-data")
	public void verifyHogarCopiarCotiazacion(Hashtable<String,String> data) {
		int rowNum=Integer.parseInt(dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"),"S.no", 4));
		steps.get()
		.hogarCrearCotizacion(rowNum+1)
		.hogarCopiarCotizacion(rowNum+1);
	}
	@Test(priority=4,
			enabled=false,
			dataProviderClass=DataProviderSource.class,
			dataProvider="common-consultation-test-data")
	public void verifyHogarCommonConsultation(Hashtable<String,String> data) {
		int rowNum=Integer.parseInt(dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"),"S.no", 5));
		steps.get().hogarCommonConsultation(rowNum);
	}
	@Test(priority=5,
			enabled=false,
			dataProviderClass=DataProviderSource.class,
			dataProvider="cotizacion-pdf-test-data")
	public void verifyHogarCotizacionPDF(Hashtable<String,String> data) {
		int rowNum=Integer.parseInt(dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"),"S.no", 6));
		steps.get()
		.hogarCrearCotizacion(rowNum)
		.hogarCotizacionPDF(rowNum);
	}
	@Test(priority=6,
			enabled=false,
			dataProviderClass=DataProviderSource.class,
			dataProvider="poliza-pdf-test-data")
	public void verifyHogarPolizaPDF(Hashtable<String,String> data) {
		int rowNum=Integer.parseInt(dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"),"S.no", 7));
		steps.get()
		.hogarCrearCotizacion(rowNum)
		.hogarPolicyPDF(rowNum);
	}
	/*String scenario=data.get("S.no");
	switch(scenario) {
			case "1":
					log.info("Existing Tercero");
					steps.get()
					.hogarCrearCotizacion(String.valueOf(data.get("S.no")), String.valueOf(data.get("Clave")), String.valueOf(data.get("Producto")), String.valueOf(data.get("Num_Doc")), String.valueOf(data.get("Ciudad")),String.valueOf(data.get("Direccion")),String.valueOf(data.get("Estrato")), String.valueOf(data.get("Ano_Construccion")),String.valueOf(data.get("Rural")),String.valueOf(data.get("Edifico")), String.valueOf(data.get("No_Electrico")), String.valueOf(data.get("Electrico")))
					.hogarEmisionPoliza(data.get("S.no"),data.get("Insp_FechaSegurida"),data.get("Insp_FechaSegurida2"),data.get("Numero_Pisos"),data.get("Barrio"));
				break;
			case "2":
					log.info("Non Existing");
					steps.get()
					.hogarCrearCotizacion(String.valueOf(data.get("S.no")), String.valueOf(data.get("Clave")), String.valueOf(data.get("Producto")), String.valueOf(data.get("Num_Doc")), String.valueOf(data.get("Ciudad")),  String.valueOf(data.get("Direccion")),String.valueOf(data.get("Estrato")), String.valueOf(data.get("Ano_Construccion")),String.valueOf(data.get("Rural")),String.valueOf(data.get("Edifico")), String.valueOf(data.get("No_Electrico")), String.valueOf(data.get("Electrico")))
					.hogarEmisionPoliza(data.get("S.no"),data.get("Insp_FechaSegurida"),data.get("Insp_FechaSegurida2"),data.get("Numero_Pisos"),data.get("Barrio"));
				break;
			case "3":
					log.info("Copiar Cotizacion");
					steps.get().hogarCrearCotizacion(String.valueOf(data.get("S.no")), String.valueOf(data.get("Clave")), String.valueOf(data.get("Producto")), String.valueOf(data.get("Num_Doc")), String.valueOf(data.get("Ciudad")),  String.valueOf(data.get("Direccion")),String.valueOf(data.get("Estrato")), String.valueOf(data.get("Ano_Construccion")),String.valueOf(data.get("Rural")),String.valueOf(data.get("Edifico")), String.valueOf(data.get("No_Electrico")), String.valueOf(data.get("Electrico")))
					.hogarCopiarCotizacion(String.valueOf(data.get("S.no")), String.valueOf(data.get("Clave")), String.valueOf(data.get("Producto")), String.valueOf(data.get("Num_Doc")), String.valueOf(data.get("Ciudad")),  String.valueOf(data.get("Direccion")),String.valueOf(data.get("Estrato")), String.valueOf(data.get("Ano_Construccion")),String.valueOf(data.get("Edifico")), String.valueOf(data.get("No_Electrico")), String.valueOf(data.get("Electrico")));
				break;
			case "4":
					log.info("Common Consultation");
					steps.get().hogarCommonConsultation(String.valueOf(data.get("S.no")),data.get("Numero_Pisos"),data.get("Barrio"));
				break;
			case "5":
					log.info("Cotizacion_PDF");
					steps.get().hogarCrearCotizacion(String.valueOf(data.get("S.no")), String.valueOf(data.get("Clave")), String.valueOf(data.get("Producto")), String.valueOf(data.get("Num_Doc")), String.valueOf(data.get("Ciudad")),  String.valueOf(data.get("Direccion")),String.valueOf(data.get("Estrato")), String.valueOf(data.get("Ano_Construccion")),String.valueOf(data.get("Rural")),String.valueOf(data.get("Edifico")), String.valueOf(data.get("No_Electrico")), String.valueOf(data.get("Electrico")))
					.hogarCotizacionPDF(String.valueOf(data.get("S.no")));
				break;
			case "6":
					log.info("Poliza PDF");
					steps.get().hogarCrearCotizacion(String.valueOf(data.get("S.no")), String.valueOf(data.get("Clave")), String.valueOf(data.get("Producto")), String.valueOf(data.get("Num_Doc")), String.valueOf(data.get("Ciudad")),  String.valueOf(data.get("Direccion")),String.valueOf(data.get("Estrato")), String.valueOf(data.get("Ano_Construccion")),String.valueOf(data.get("Rural")),String.valueOf(data.get("Edifico")), String.valueOf(data.get("No_Electrico")), String.valueOf(data.get("Electrico")))
					.hogarPolicyPDF(data.get("S.no"),data.get("Numero_Pisos"),data.get("Barrio"));
				break;
	}*/
	
}
