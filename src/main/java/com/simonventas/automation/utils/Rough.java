package com.simonventas.automation.utils;

import java.util.Hashtable;

import org.testng.TestNG;
import org.testng.annotations.Test;

import com.simonventas.automation.commons.utils.Log;

import io.qameta.allure.Step;

public class Rough {

	public static Log log=new Log(Rough.class.getName());
	static TestNG testng;
	@Test(dataProviderClass=DataProviders.class,
			dataProvider="VentasProductData"	
			
			)
	@Step("AAAA")
	public void test(Hashtable<String,String> data) {
		System.out.println(data.get("S.no")+data.get("Product"));
		if(data.get("Product").equalsIgnoreCase("Hogar")) {
			 /*testng = new TestNG();
				testng.setTestClasses(new Class[] {HogarTest.class});
				//testng.addListener(extentlistener);
				testng.run();*/
			HogarTest h=new HogarTest();
			h.testA();
		}
		else if(data.get("Product").equalsIgnoreCase("Salud")) {
			 testng = new TestNG();
				testng.setTestClasses(new Class[] {SaludTest.class});
				//testng.addListener(extentlistener);
				testng.run();
		}
	}

	/*public static void main(String[] args) {
		

		ExcelReader testexcel=new ExcelReader(System.getProperty("user.dir")+PropertyManager.getConfigValueByKey("testdata_excelpath"));
		ExcelReader clasificacion_excel=new ExcelReader(System.getProperty("user.dir")+PropertyManager.getConfigValueByKey("clasificaciondata_excelpath"));
		ExcelReader definacion_excel=new ExcelReader(System.getProperty("user.dir")+PropertyManager.getConfigValueByKey("definaciondata_excelpath"));
		log.info("excel loaded");
		
		String encuesta_values=  PropertyManager.getConfigValueByKey("resultdoEncuesta");
		System.out.println(encuesta_values);
		int encuesta_code=Integer.parseInt(encuesta_values.split(",")[0].split(" - ")[0]);
		System.out.println(encuesta_code);
		
		
		for(int i=2;i<21;i++) {
			System.out.println("---");
			System.out.print(DataUtil.getCode(clasificacion_excel.getCellData("Data","ID",i))+" , ");
			

			System.out.print(DataUtil.getCode(clasificacion_excel.getCellData("Data","COMPANIA",i))+" , ");
			System.out.print(DataUtil.getCode(clasificacion_excel.getCellData("Data","SECCION",i))+" , ");
			System.out.print(DataUtil.getCode(clasificacion_excel.getCellData("Data","PRODUCTO",i))+" , ");
			System.out.print(DataUtil.getCode(clasificacion_excel.getCellData("Data","CLV",i))+" , ");
			System.out.print(DataUtil.getCode(clasificacion_excel.getCellData("Data","SCORE RIESGO",i))+" , ");
			System.out.print(DataUtil.getCode(clasificacion_excel.getCellData("Data","COBERTURAS",i))+" , ");
			System.out.print(DataUtil.getCode(clasificacion_excel.getCellData("Data","CAUSAS",i))+" , ");
			
			System.out.print(DataUtil.getCode(clasificacion_excel.getCellData("Data","CONSECUENCIA",i))+" , ");
			System.out.print(DataUtil.getCode(clasificacion_excel.getCellData("Data","MODELO RIESGO PRETENSION",i))+" , ");
			System.out.print(DataUtil.getCode(clasificacion_excel.getCellData("Data","RESULTADO ENCUESTA",i))+" , ");
			System.out.print(DataUtil.getCode(clasificacion_excel.getCellData("Data","SALIDA MOTOR",i)));
			System.out.println("---");
		}
		
		

		
		ExcelCreator unique=new ExcelCreator("E:\\Input_Files\\Unique_237.xlsx","Producto_112");
		
		
		for(int i=2;i<uniquecombinations_excel.getRowCount("Producto_237")+1;i++) {
			
			unique.createHeader();
			int cobertura=DataUtil.getCode(uniquecombinations_excel.getCellData("Producto_237","COBERTURAS", i));
			int causa=DataUtil.getCode(uniquecombinations_excel.getCellData("Producto_237","CAUSAS", i));
			int consequencia=DataUtil.getCode(uniquecombinations_excel.getCellData("Producto_237","CONSECUENCIA", i));
			
			System.out.println("causa:"+causa+",consequencia:"+consequencia+",cobertura:"+cobertura);
			unique.setValue(i-1, causa,consequencia,cobertura);
			//unique.setConsequenciaValue(i-1, consequencia);
			//unique.setCoberturaValue(i-1, cobertura);
			
		}
		
		
		

		//System.out.println(c);
		JSONObject obj=new JSONObject();
		obj.put("Producto", "117");
		obj.put("Causa", "28");
		

		
		String clasificacionPath="E:\\"+PropertyManager.getConfigValueByKey("outputClasificacionFileName")+"_Output_"+DataUtil.localDateTime()+"_Clasificacion.xlsx";
		  String definicionPath="E:\\"+PropertyManager.getConfigValueByKey("outputDefinicionFileName")+"_Output_"+DataUtil.localDateTime()+"_Definicion.xlsx";
		  String sheetname=PropertyManager.getConfigValueByKey("outputExcelSheet");
		  
		  ClasificacionExcelCreator outputClasificacionExcel=new ClasificacionExcelCreator(clasificacionPath, sheetname);
		 // DefinicionExcelCreator outputDefinicionExcel=new DefinicionExcelCreator(definicionPath, sheetname);
		  
		  for(int i=1;i<3;i++) {
			  
			  outputClasificacionExcel.setClasificacionCellValue(i,obj);
			 // outputDefinicionExcel.setDefinicionCellValue(i, obj);
		  }
		  
		  
		 
		  
		 
		  
		
		System.out.println("Insertion successful");
		log.info("end");
		log.error("Error log");
		log.warn("Warn Log");
		log.debug("Debug Log");
		
		
		JSONObject obj=new JSONObject();
		obj.put("Producto", "117");
		obj.put("Causa", "28");
		clasificacionExcel.setClasificacionCellValue(2, obj);


		

		//System.out.println(obj.get("Producto"));
		System.out.println("end");
		

	}*/
	
	
	
}
