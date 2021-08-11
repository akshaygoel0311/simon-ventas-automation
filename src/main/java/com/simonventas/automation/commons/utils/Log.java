package com.simonventas.automation.commons.utils;

import java.io.InputStream;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {
	
	public static Logger log;
	ClassLoader classLoader = getClass().getClassLoader();
	InputStream inputStream = classLoader.getResourceAsStream("log4j.properties");
	 
	public Log(String className) {
		log = Logger.getLogger(className);
	}
	
	public void info(String message) {
		
    	PropertyConfigurator.configure(inputStream);
		log.info(message);
	}
	public  void error(Object object) {
    	PropertyConfigurator.configure(inputStream);
		log.error(object);
	}

}
