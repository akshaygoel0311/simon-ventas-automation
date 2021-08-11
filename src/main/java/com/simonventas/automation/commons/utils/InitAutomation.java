package com.simonventas.automation.commons.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.simonventas.automation.commons.helpers.driver.DriverConstants;
import com.simonventas.automation.commons.helpers.driver.web.DriverWebBase;


public class InitAutomation {
	public static Logger log=Logger.getLogger(InitAutomation.class);
   

    public static void initDriverFactories() {
        log.info("Start config Factories ....");
        String nameExecution ="UI_"+ DriverConstants.WEB_PLATFORM_NAME+"_" + DriverConstants.WEB_TYPE_EXECUTE + "_" + new SimpleDateFormat("yyyy_MM_dd_hh:mm:ss").format(new Date());
        DriverWebBase.nameExecutionLambda = nameExecution;
        DriverWebBase.instantiateDriverObject();
    }


   

}
