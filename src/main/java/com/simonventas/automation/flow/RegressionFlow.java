package com.simonventas.automation.flow;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.simonventas.automation.commons.helpers.DriverFactory;
import com.simonventas.automation.commons.utils.DataUtil;
import com.simonventas.automation.commons.utils.ExcelReader;
import com.simonventas.automation.commons.utils.FlowUtil;
import com.simonventas.automation.commons.utils.Log;
import com.simonventas.automation.commons.utils.PropertyManager;
import com.simonventas.automation.ui.RegressionUI;

public class RegressionFlow extends RegressionUI{


	public static Log log =new Log(RegressionFlow.class.getName());
	public ExcelReader dataExcel=DataUtil.dataExcel;
	public void login(String url) {
		DriverFactory.getDriverFacade().getWebDriver().get(url);
		FlowUtil.waitTillClickable(login);
		FlowUtil.scrollToElement(login);
		FlowUtil.click(login);
		if(FlowUtil.elementIsDisplayed(login_eror)) {
			//dataExcel.setCellData(DataUtil.inputExcelSheetName, "Policy No", rowNum, "Not Executed");
			Assert.fail("Build not found");
		}
		FlowUtil.waitTillTitleContains(PropertyManager.getConfigValueByKey("homepageTitle"));
		log.info("User successfuly Landed on Home page with page title : "+DriverFactory.getDriverFacade().getWebDriver().getTitle());
	}
	

}
