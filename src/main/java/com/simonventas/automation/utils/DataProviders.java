package com.simonventas.automation.utils;

import java.io.File;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.simonventas.automation.commons.utils.DataUtil;
import com.simonventas.automation.commons.utils.ExcelReader;
import com.simonventas.automation.commons.utils.PropertyManager;

public class DataProviders {



	/*@Test(dataProvider="getData")
	public void data(Hashtable<Object,Object> data) {
			System.out.println(data.get("S.no")+"----"+data.get("Clave")+"-----"+data.get("Producto")+"----"+data.get("Num_Doc")+"----"+data.get("Ciudad")+"----"+data.get("Direccion")+"----"+data.get("Ano_Construccion")+"----"+data.get("Edifico")+"----"+	data.get("No_Electrico")+"----"+data.get("Electrico")+"----"+data.get("Numero_Pisos")+"----"+data.get("Barrio"));	
	}*/

	@DataProvider
	public static Object[][] getData() {
		
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
