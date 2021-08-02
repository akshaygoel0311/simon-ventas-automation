package com.simonventas.automation.commons;

import org.openqa.selenium.support.PageFactory;

import com.simonventas.automation.commons.helpers.DriverFacade;
import com.simonventas.automation.commons.helpers.DriverFactory;

public class BaseTest {
	protected DriverFacade driverFacade;
    
    public BaseTest() {
		this.driverFacade = DriverFactory.getDriverFacade();
		PageFactory.initElements(driverFacade.getWebDriver(),this);
	}
}
