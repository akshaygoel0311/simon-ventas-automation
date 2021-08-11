package com.simonventas.automation.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.simonventas.automation.commons.BaseTest;
import com.simonventas.automation.commons.helpers.DriverFacade;

public class RegressionUI extends BaseTest{
	
	protected DriverFacade webDriverFacade;

	@FindBy(xpath="//button")
	public static WebElement login;

	@FindBy(xpath="//h2")
	public static WebElement error_404;
	
	@FindBy(xpath="//div[@id='pageError']")
	public static WebElement login_eror;
	
	


}
