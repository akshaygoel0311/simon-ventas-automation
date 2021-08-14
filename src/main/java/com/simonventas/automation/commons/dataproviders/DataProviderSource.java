package com.simonventas.automation.commons.dataproviders;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.simonventas.automation.commons.utils.DataUtil;
import com.simonventas.automation.commons.utils.ExcelReader;
import com.simonventas.automation.commons.utils.PropertyManager;


public class DataProviderSource {
	@Test(dataProvider="poliza-pdf-test-data")
	public void test(Hashtable<String,String> data) {
		System.out.println(data);
	}
    @DataProvider(name = "existing-tercero-test-data")
    public static Object[][] getTestData1() throws Exception {
		ExcelReader excel=DataUtil.dataExcel;
		String sheetName=PropertyManager.getConfigValueByKey("inputExcelSheetName");
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[1][1];
		Hashtable<Object,Object> table=null;
		for(int rowNum=2; rowNum<3; rowNum++){
				table=new Hashtable<Object,Object>();
				for(int colNum=0; colNum<cols; colNum++){
					table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
					data[rowNum-2][0]=table;
				}
		}
		return data;
    }
    @DataProvider(name = "non-existing-tercero-test-data")
    public static Object[][] getTestData2() throws Exception {
		ExcelReader excel=DataUtil.dataExcel;
		String sheetName=PropertyManager.getConfigValueByKey("inputExcelSheetName");
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[1][1];
		Hashtable<Object,Object> table=null;
		for(int rowNum=3; rowNum<4; rowNum++){
				table=new Hashtable<Object,Object>();
				for(int colNum=0; colNum<cols; colNum++){
					table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
					data[rowNum-3][0]=table;
				}
		}
		return data;
    }
    @DataProvider(name = "copiar-cotizacion-test-data")
    public static Object[][] getTestData3() throws Exception {
		ExcelReader excel=DataUtil.dataExcel;
		String sheetName=PropertyManager.getConfigValueByKey("inputExcelSheetName");
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[1][1];
		Hashtable<Object,Object> table=null;
		for(int rowNum=4; rowNum<5; rowNum++){
				table=new Hashtable<Object,Object>();
				for(int colNum=0; colNum<cols; colNum++){
					table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
					data[rowNum-4][0]=table;
				}
		}
		return data;
    }
    @DataProvider(name = "common-consultation-test-data")
    public static Object[][] getTestData4() throws Exception {
		ExcelReader excel=DataUtil.dataExcel;
		String sheetName=PropertyManager.getConfigValueByKey("inputExcelSheetName");
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[1][1];
		Hashtable<Object,Object> table=null;
		for(int rowNum=5; rowNum<6; rowNum++){
				table=new Hashtable<Object,Object>();
				for(int colNum=0; colNum<cols; colNum++){
					table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
					data[rowNum-5][0]=table;
				}
		}
		return data;
    }
    @DataProvider(name = "cotizacion-pdf-test-data")
    public static Object[][] getTestData5() throws Exception {
		ExcelReader excel=DataUtil.dataExcel;
		String sheetName=PropertyManager.getConfigValueByKey("inputExcelSheetName");
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[1][1];
		Hashtable<Object,Object> table=null;
		for(int rowNum=6; rowNum<7; rowNum++){
				table=new Hashtable<Object,Object>();
				for(int colNum=0; colNum<cols; colNum++){
					table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
					data[rowNum-6][0]=table;
				}
		}
		return data;
    }
    @DataProvider(name = "poliza-pdf-test-data")
    public static Object[][] getTestData6() throws Exception {
		ExcelReader excel=DataUtil.dataExcel;
		String sheetName=PropertyManager.getConfigValueByKey("inputExcelSheetName");
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[1][1];
		Hashtable<Object,Object> table=null;
		for(int rowNum=7; rowNum<8; rowNum++){
				table=new Hashtable<Object,Object>();
				for(int colNum=0; colNum<cols; colNum++){
					table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
					data[rowNum-7][0]=table;
				}
		}
		return data;
    }
   
}