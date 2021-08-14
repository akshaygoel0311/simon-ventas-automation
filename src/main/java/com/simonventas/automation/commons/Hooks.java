package com.simonventas.automation.commons;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.simonventas.automation.commons.utils.InitAutomation;
import com.simonventas.automation.commons.utils.Log;

public class Hooks {

	public static Log log = new Log(Hooks.class.getName());

	@BeforeSuite(alwaysRun = true)
	public void suiteUp() {
		LocalDateTime d = LocalDateTime.now();
		DateTimeFormatter ft = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String date = ft.format(d);
		log.info("Execution Started at: " + date);
		// Init driver Factories
		InitAutomation.initDriverFactories();
		// Init aaplication browser with url
		InitAutomation.initApplicationBrowser();
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method) throws Exception {
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(Method method) {
		// DriverMobileBase.quitDriver();
	}

	@AfterSuite(alwaysRun = true)
	public void closeDriverObjects() throws MalformedURLException {
		LocalDateTime d = LocalDateTime.now();
		DateTimeFormatter ft = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String date = ft.format(d);
		log.info("Execution Ended at: " + date);
		// DriverWebBase.closeDriverObjects();
	}

	/*@BeforeTest
	public void before() {

		DriverFactory.setWebDriver(DataUtil.browser);
		log.info("Browser is launched");
		try {

			steps.get().clickLogin(DataUtil.url);

		} catch (WebDriverException e) {
			LocalDateTime d = LocalDateTime.now();
			DateTimeFormatter ft = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String date = ft.format(d);
		}

	}*/

}
