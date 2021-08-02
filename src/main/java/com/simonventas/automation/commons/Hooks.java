package com.simonventas.automation.commons;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.simonventas.automation.commons.helpers.DriverFactory;
import com.simonventas.automation.tests.VentasStepDef;
import com.simonventas.automation.utils.DataUtil;
import com.simonventas.automation.utils.Log;

public class Hooks {

	public static Log log=new Log(Hooks.class.getName());
	ThreadLocal<VentasStepDef> steps= ThreadLocal.withInitial(VentasStepDef::new);

	@BeforeSuite
	public void starttimeofexecution() {
		/*// creates file appender
        FileAppender fileAppender = new FileAppender();
        fileAppender.setFile("app_log.txt");
        fileAppender.setLayout(new PatternLayout("%p %d %c  - %m%n"));
        fileAppender.activateOptions();
        
     // configures the root logger
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.addAppender(fileAppender);
		
		BasicConfigurator.configure(new ConsoleAppender(new PatternLayout("%p %d %c  - %m%n")));
		*/
		
		LocalDateTime d = LocalDateTime.now();
		DateTimeFormatter ft = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String date=ft.format(d);
		log.info("Execution Started at: "+date);
		
		
	}

	@BeforeTest
	public void before() {
		
		DriverFactory.setWebDriver(DataUtil.browser);
		log.info("Browser is launched");
		try {

			steps.get().clickLogin(DataUtil.url);
			
		}
		catch(WebDriverException e) {
			LocalDateTime d = LocalDateTime.now();
			DateTimeFormatter ft = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String date=ft.format(d);
		}
		
	}


	@AfterTest
	public void after() {
		//DriverFactory.getDriverFacade().getWebDriver().quit();
	}

	@AfterSuite
	public void endtimeofexecution() {
		LocalDateTime d = LocalDateTime.now();
		DateTimeFormatter ft = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String date=ft.format(d);
		log.info("Execution Ended at: "+date);
	}

}
