package com.simonventas.automation.utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.simonventas.automation.commons.helpers.DriverFactory;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestListener implements ITestListener{

	
	
	
	
	public void onTestStart(ITestResult result) {
				

	}

	public void onTestSuccess(ITestResult result) {

		
	
		
		/*String test_name=result.getMethod().getMethodName();
		

		LocalDateTime d = LocalDateTime.now();
		DateTimeFormatter ft = DateTimeFormatter.ofPattern("dd_MM_yyyy HH_mm_ss");


		String date=ft.format(d);


		
		String success_sc_folder=".\\src\\main\\resources\\Screenshot\\Success";
		
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(DriverFactory.getDriverFacade().getWebDriver());
		try {
			ImageIO.write(screenshot.getImage(),"PNG",new File(success_sc_folder+"\\"+"_"+test_name+"_"+date+".png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		

	}

	public void onTestFailure(ITestResult result) {

	}

	public void onTestSkipped(ITestResult result) {
		
		

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
	
	}

	public void onFinish(ITestContext context) {


	}




}
