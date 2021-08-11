package com.simonventas.automation.commons.helpers;

public class DriverFactory { 
	
	private static ThreadLocal<DriverFacade> webDriverMap=new ThreadLocal<>();

	public static void setWebDriver(String browser) {
		webDriverMap.set(new DriverFacade(browser));
	}

	public static DriverFacade getDriverFacade() {
		return webDriverMap.get();
	}
}
