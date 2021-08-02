package com.simonventas.automation.commons.helpers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.simonventas.automation.tests.VentasStepDef;
import com.simonventas.automation.utils.Log;
import com.simonventas.automation.utils.PropertyManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFacade {
	public static Log log=new Log(DriverFacade.class.getName());
	RemoteWebDriver driver;
	WebDriverWait wait;
	ThreadLocal<VentasStepDef> steps= ThreadLocal.withInitial(VentasStepDef::new);

	private DesiredCapabilities capabilitiesSetUp() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability("version", PropertyManager.getConfigValueByKey("lambdatestBrowserVersion"));
		capabilities.setCapability("platform", PropertyManager.getConfigValueByKey("lambdatestPlatform")); // If this cap isn't specified, it will just get the any available one
		capabilities.setCapability("build", PropertyManager.getConfigValueByKey("lambdaBuildVersion"));
		capabilities.setCapability("name", PropertyManager.getConfigValueByKey("lambdaTestName"));
		capabilities.setCapability("idleTimeout",PropertyManager.getConfigValueByKey("lambdatestidleTimeout"));
		capabilities.setCapability("network",Boolean.parseBoolean(PropertyManager.getConfigValueByKey("lambdaNetwork"))); // To enable network logs
		capabilities.setCapability("visual",Boolean.parseBoolean(PropertyManager.getConfigValueByKey("lambdaVisual"))); // To enable step by step screenshot
		capabilities.setCapability("video",Boolean.parseBoolean(PropertyManager.getConfigValueByKey("lambdaVideo"))); // To enable video recording
		capabilities.setCapability("console",Boolean.parseBoolean(PropertyManager.getConfigValueByKey("lambdaConsole"))); // To capture console logs
		capabilities.setCapability("tunnel",Boolean.parseBoolean(PropertyManager.getConfigValueByKey("lambdaTunnel")));
		capabilities.setCapability("headless",Boolean.parseBoolean(PropertyManager.getConfigValueByKey("headless")));
		capabilities.setCapability("resolution",PropertyManager.getConfigValueByKey("lambdaResolution"));
		return capabilities;
	}

	public DriverFacade(String browser) {
			
	
		boolean lambdaTest=Boolean.parseBoolean(PropertyManager.getConfigValueByKey("lambdaTestRun"));
		if(lambdaTest) {
			try {
				driver = new RemoteWebDriver(new URL("https://" + PropertyManager.getConfigValueByKey("lambdausername")
				+ ":" + PropertyManager.getConfigValueByKey("lambdapassword") +
				PropertyManager.getConfigValueByKey("gridURL")), capabilitiesSetUp());
			} catch (MalformedURLException e) {
				System.out.println("Invalid grid URL");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			log.info("Webdriver Initialised!!!");
			driver.manage().timeouts().implicitlyWait(Long.parseLong(PropertyManager.getConfigValueByKey("timeoutinseconds")), TimeUnit.SECONDS);


		}
		else {
			
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				log.info("Chrome Driver Initialised");
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				log.info("FireFox Driver Initialised");
			}
			else if(browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				log.info("IE Driver Initialised");
			}
			else if(browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				log.info("Edge Driver Initialised");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Long.parseLong(PropertyManager.getConfigValueByKey("timeoutinseconds")), TimeUnit.SECONDS);


		}



	}
	public RemoteWebDriver getWebDriver(){
		return driver;
	}

	public void waitForVisibilityOfElement(WebElement webElement) {
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

	/*public void awaitToFindElement(By webElement) {
		await().atMost(1, TimeUnit.MINUTES)
		.pollInterval(Duration.ONE_SECOND)
		.until(() -> {
			try {
				driver.findElement(webElement);
				return true;
			} catch (NoSuchElementException e) {
				return false;
			}

		});
	}*/
}
