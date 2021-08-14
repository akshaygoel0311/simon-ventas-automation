package com.simonventas.automation.tests;

import java.util.Hashtable;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.simonventas.automation.commons.Hooks;
import com.simonventas.automation.commons.dataproviders.DataProviderSource;
import com.simonventas.automation.commons.utils.DataUtil;
import com.simonventas.automation.commons.utils.ExcelReader;
import com.simonventas.automation.commons.utils.Log;

@Listeners(com.simonventas.automation.utils.TestListener.class)
public class TestAutos extends Hooks{
	public ExcelReader dataExcel=DataUtil.dataExcel;
	public static Log log=new Log(TestHogar.class.getName());
	ThreadLocal<VentasStepDef> steps= ThreadLocal.withInitial(VentasStepDef::new);
	
	@Test(  
			priority=1,
			dataProviderClass=DataProviderSource.class,
			dataProvider="existing-tercero-test-data",
			enabled=true,
			testName="Verify Autos with Existing Tercero")
	public void verifyAutoswithExisitingTercero(Hashtable<String,String> data) {
			int rowNum=Integer.parseInt(data.get("S.no"));
			steps.get()
			.autosCrearCotizacion(rowNum+1);
	}

}
