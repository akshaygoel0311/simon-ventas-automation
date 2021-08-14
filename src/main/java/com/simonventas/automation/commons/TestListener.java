/*package com.simonventas.automation.commons;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;

import javax.xml.crypto.Data;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.annotations.TestType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.simonventas.automation.commons.helpers.driver.DriverConstants;
import com.simonventas.automation.commons.helpers.driver.web.DriverWebBase;
import com.simonventas.automation.commons.utils.Constants;
import com.simonventas.automation.commons.utils.Log;
import com.simonventas.automation.commons.utils.Utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;


public class TestListener implements ITestListener {
	
	public enum TestType {
	    MOBILE,
	    WEB,
	    HYBRID
	}
	private static Log log = new Log(TestListener.class.getName());

 

    @Attachment(value = "Test Evidence Web", type = "image/png")
    public byte[] takeWebScreenshot() {
        WebDriver driver = DriverWebBase.getCurrentDriver();
        TakesScreenshot scrShot = null;
        try {
            Allure.addAttachment("failure", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            scrShot = ((TakesScreenshot) driver);
        } catch (Exception ex) {
            log.error("Web Driver: " + driver);
        }
        return scrShot.getScreenshotAs(OutputType.BYTES);
    }


    @Override
    public void onTestStart(ITestResult iTestResult) {
        Test testAnnotation = Utils.getTestAnnotation(iTestResult);
        boolean isLocalDriver = Boolean.parseBoolean(DriverConstants.DRIVER_LOCAL);
        if(!isLocalDriver){
            DriverWebBase.getDriverRemote(testAnnotation.description());
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Test testAnnotation = Utils.getTestAnnotation(iTestResult);

        TestType testType = testAnnotation.testType();

        boolean isLocalDriver = Boolean.parseBoolean(DriverConstants.DRIVER_LOCAL);



        if (testType == TestType.WEB) {
            takeWebScreenshot();
            if (!isLocalDriver) {
                WebDriver driver = DriverWebBase.getCurrentDriver();
                ((JavascriptExecutor) driver).executeScript("lambda-status=failed");
            }
            DriverWebBase.quitDriver();
        } else if (testType == TestType.MOBILE) {
        } else if (testType == TestType.HYBRID) {
        }



       
    }


    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        boolean isLocalDriver = Boolean.parseBoolean(DriverConstants.DRIVER_LOCAL);

        Object[] params = iTestResult.getParameters();
        if (params.length > 0) {
            
            System.out.println(params);

        }
        
        if (!isLocalDriver) {
            WebDriver driver = DriverWebBase.getCurrentDriver();
            ((JavascriptExecutor) driver).executeScript("lambda-status=passed");
        }

         
       // sendTestMethodStatus(iTestResult, Constants.TEST_SUCCESS);
    }

   

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
*/