package com.simonventas.automation.commons.dataproviders;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import com.simonventas.automation.commons.utils.DataUtil;
import com.simonventas.automation.commons.utils.ExcelReader;
import com.simonventas.automation.commons.utils.PropertyManager;


public class DataProviderSource {
    @DataProvider(name = "test-data")
    public static Object[][] getTestTypeData(Method method) throws Exception {

		ExcelReader excel=DataUtil.dataExcel;
		String sheetName=PropertyManager.getConfigValueByKey("inputExcelSheetName");
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rows-1][1];
		Hashtable<Object,Object> table=null;
		for(int rowNum=2; rowNum<=rows; rowNum++){
				table=new Hashtable<Object,Object>();
				for(int colNum=0; colNum<cols; colNum++){
					table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
					data[rowNum-2][0]=table;
				}
		}
		return data;
    }
   
}