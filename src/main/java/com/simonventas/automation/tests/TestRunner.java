package com.simonventas.automation.tests;

import org.testng.TestNG;

import com.simonventas.automation.commons.utils.PropertyManager;

public class TestRunner {
	
static TestNG testng;
	
	public static void main(String[] args) {
		
		 testng = new TestNG();
		 String product=PropertyManager.getConfigValueByKey("productRun");
		 if(product.equalsIgnoreCase("Hogar")) {
			 testng.setTestClasses(new Class[] {TestHogar.class});
		 }
		 else if(product.equalsIgnoreCase("Autos")) {
			 testng.setTestClasses(new Class[] {TestAutos.class}); 
		 }
		
		//testng.addListener(extentlistener);
		testng.run();
		}

}