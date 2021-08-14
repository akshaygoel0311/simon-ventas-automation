package com.simonventas.automation.commons.utils;

import java.io.InputStream;
import java.net.URL;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

public class Rough {
	ClassLoader classLoader = getClass().getClassLoader();
	URL resource = classLoader.getResource("log4j.properties");
	InputStream inputStream = classLoader.getResourceAsStream("log4j.properties");
	URL u=getClass().getProtectionDomain().getCodeSource().getLocation();
	
	public static void main(String[] args) {
		 
		Rough r=new Rough();
		
		PropertyConfigurator.configure(r.inputStream);
	//	File f=new File(r.resource);
		System.out.println(r.resource.getPath());
		System.out.println(r.u.getPath() );
		
	/*	String[] s=PropertyManager.getConfigValueByKey("scenarios").split(",");
		System.out.println(s[0]);
		System.out.println(s[1]);
		System.out.println(s[2]);
		System.out.println(s[3]);
		System.out.println(s[4]);
		System.out.println(s[5]);*/
		ExcelReader dataExcel=DataUtil.dataExcel;
		int rowNum=Integer.parseInt(dataExcel.getCellData(PropertyManager.getConfigValueByKey("inputExcelSheetName"),"Clave", 2));
		
		System.out.println(rowNum);


		//printInputStream(r.inputStream);

	

		

	}
	
	/*@Test
	public void printInputStream() {
		
	}
*/
}
