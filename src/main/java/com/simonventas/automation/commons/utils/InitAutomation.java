package com.simonventas.automation.commons.utils;

import org.apache.log4j.Logger;

import com.simonventas.automation.commons.helpers.DriverFactory;
import com.simonventas.automation.commons.helpers.driver.DriverConstants;
import com.simonventas.automation.flow.RegressionFlow;


public class InitAutomation {
	public static Logger log=Logger.getLogger(InitAutomation.class);
   

    public static void initDriverFactories() {
        log.info("Start config Factories ....");
        DriverFactory.setWebDriver(PropertyManager.getConfigValueByKey("browserName"));
    }
    public static void initApplicationBrowser() {
        log.info("Start application browser with url ....");
        new RegressionFlow().login(DriverConstants.WEB_URL_ENVIRONMENT);
    }
    


   

}
