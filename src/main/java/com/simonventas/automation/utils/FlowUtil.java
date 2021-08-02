package com.simonventas.automation.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.simonventas.automation.commons.helpers.DriverFactory;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class FlowUtil {
	
	public static Logger log=Logger.getLogger(FlowUtil.class.getName());
	
	
	public static void sendvalue(WebElement element , String value) {
		
		element.sendKeys(value);
	}
	public static void click(WebElement element) {
		waitTillClickable(element);
		element.click();
	}
	
	public static String getText(By element) {
		return DriverFactory.getDriverFacade().getWebDriver().findElement(element).getText();
	}
	
	public static String getText(String element) {
		return DriverFactory.getDriverFacade().getWebDriver().findElement(By.xpath(element)).getText();
	}
	
	public static String getFirstSelectedOption(WebElement element) {
		
		
		boolean staleElement = true; 
		String text="";
		while(staleElement){
		  try{
			  Select select=new Select(element);
			  text=select.getFirstSelectedOption().getText();
		     staleElement = false;
		  } catch(StaleElementReferenceException e){
		    staleElement = true;
		  }
		}
		return text;
	}

	public static void selectByValue(WebElement element,String value) {
		
		boolean staleElement = true; 
		while(staleElement){
		  try{
			  Select select=new Select(element);
				select.selectByValue(value);
		     staleElement = false;
		  } catch(StaleElementReferenceException e){
		    staleElement = true;
		  }
		}
	}

	public static void selectByVisibleText(WebElement element,String value) {
		
		boolean staleElement = true; 
		while(staleElement){
		  try{
			  Select select=new Select(element);
			  select.selectByVisibleText(value);
		     staleElement = false;
		  } catch(StaleElementReferenceException e){
		    staleElement = true;
		  }
		}
	}

	public static int getOptionsSize(WebElement element) {
		
		int size=0;
		boolean staleElement = true; 
		while(staleElement){
			  try{
				  Select select=new Select(element);
				   size=select.getOptions().size();
			     staleElement = false;
			  } catch(StaleElementReferenceException e){
			    staleElement = true;
			  }
			}
		return size;
	}

	public static void movetoElement(WebElement element) {
		
		Actions action=new Actions(DriverFactory.getDriverFacade().getWebDriver());
		action.moveToElement(element).perform();
	}

	public static void movetoElementandClick(WebElement element) {
		
		Actions action=new Actions(DriverFactory.getDriverFacade().getWebDriver());
		action.moveToElement(element).click().build().perform();
	}

	public static void javascriptClick(WebElement element) {
		
		JavascriptExecutor jse2 = (JavascriptExecutor)DriverFactory.getDriverFacade().getWebDriver();
		jse2.executeScript("arguments[0].click();", element);
	}
	
	public static WebElement expandRootElement(WebElement element) {
		WebElement ele = (WebElement) ((JavascriptExecutor)DriverFactory.getDriverFacade().getWebDriver())
            .executeScript("return arguments[0].shadowRoot",element);
		return ele;
	}
	
	public static void scrollToElement(WebElement element) {
		
		JavascriptExecutor jse2 = (JavascriptExecutor)DriverFactory.getDriverFacade().getWebDriver();
		jse2.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void clearvalue(WebElement element) {
		
		element.clear();
		
	}
	public static void close_window() {
		
		DriverFactory.getDriverFacade().getWebDriver().close();
		
	}
	public static void win_maximize() {
		
		DriverFactory.getDriverFacade().getWebDriver().manage().window().maximize();
		
	}
	public static Set<String> getWindowHandles() {
		Set<String> windows=DriverFactory.getDriverFacade().getWebDriver().getWindowHandles();
		return windows;
	}
	public static String getWindowHandle() {
		String window=DriverFactory.getDriverFacade().getWebDriver().getWindowHandle();
		return window;
	}
	public static void swichToWindow(String window_name) {
		
		DriverFactory.getDriverFacade().getWebDriver().switchTo().window(window_name);
	}
	public static String getWindowTitle(String window_name) {
		
		String title=DriverFactory.getDriverFacade().getWebDriver().switchTo().window(window_name).getTitle();
		return title;
	}
	public static boolean elementIsDisplayed(WebElement element) {
		
		boolean isDisplayed=element.isDisplayed();
		return isDisplayed;
	}

	public static boolean isElementPresent(WebElement element) {
		try {
			DriverFactory.getDriverFacade().getWebDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			WebElement ele=element;

			return ele.isDisplayed();
		}
		catch(NoSuchElementException e) {
			return false;
		}
	}

	public static void waitTillVisibility(WebElement element) {
		
		WebDriverWait wait=new WebDriverWait(DriverFactory.getDriverFacade().getWebDriver(), Long.parseLong(PropertyManager.getConfigValueByKey("waitinseconds")));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitTillClickable(WebElement element) {
		
		WebDriverWait wait=new WebDriverWait(DriverFactory.getDriverFacade().getWebDriver(), Long.parseLong(PropertyManager.getConfigValueByKey("waitinseconds")));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitTillInivisibility(WebElement element) {
		
		WebDriverWait wait=new WebDriverWait(DriverFactory.getDriverFacade().getWebDriver(), Long.parseLong(PropertyManager.getConfigValueByKey("waitinseconds")));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public static void waitTillTitleContains(String title) {
		
		WebDriverWait wait=new WebDriverWait(DriverFactory.getDriverFacade().getWebDriver(), Long.parseLong(PropertyManager.getConfigValueByKey("waitinseconds")));
		wait.until(ExpectedConditions.titleContains(title));
	}

	public static void pressTab() {
		
		/*try {
			new Robot().keyPress(KeyEvent.VK_TAB);
		} catch (AWTException e) {
			e.printStackTrace();
		}*/
		
		Actions action=new Actions(DriverFactory.getDriverFacade().getWebDriver());		
		action.sendKeys(Keys.TAB).build().perform();
	}
	
	public static void gotoDownloads() {
		Robot r = null;
		try {
			r=new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_J);
		
	}

	public static void sleep(int time) {
		
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void takeFailedScreenshot(String test_name) {
		LocalDateTime d = LocalDateTime.now();
		DateTimeFormatter ft = DateTimeFormatter.ofPattern("dd_MM_yyyy HH_mm_ss");
		String date=ft.format(d);
		String failed_sc_folder=".\\src\\main\\resources\\Screenshot\\Failed";
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(DriverFactory.getDriverFacade().getWebDriver());
		try {
			ImageIO.write(screenshot.getImage(),"PNG",new File(failed_sc_folder+"\\"+"_"+test_name+"_"+date+".png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void takeSuccessScreenshot(String test_name) {
		LocalDateTime d = LocalDateTime.now();
		DateTimeFormatter ft = DateTimeFormatter.ofPattern("dd_MM_yyyy HH_mm_ss");
		String date=ft.format(d);
		String success_sc_folder=".\\src\\main\\resources\\Screenshot\\Success";
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(DriverFactory.getDriverFacade().getWebDriver());
		try {
			ImageIO.write(screenshot.getImage(),"PNG",new File(success_sc_folder+"\\"+"_"+test_name+"_"+date+".png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public static void getAlert() {
		// TODO Auto-generated method stub
		DriverFactory.getDriverFacade().getWebDriver().switchTo().alert();

	}
	public static void getAlertTitle() {
		// TODO Auto-generated method stub
		DriverFactory.getDriverFacade().getWebDriver().switchTo().alert().getText();

	}
	
	public static void acceptAlert() {
		// TODO Auto-generated method stub
		DriverFactory.getDriverFacade().getWebDriver().switchTo().alert().accept();

	}
	
	



}
