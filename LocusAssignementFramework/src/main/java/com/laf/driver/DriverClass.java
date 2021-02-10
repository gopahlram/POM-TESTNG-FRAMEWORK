package com.laf.driver;

import java.io.IOException;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.laf.constants.FrameworkConstants;
import com.laf.utils.ReadProperties;

public final class DriverClass {
	
	private DriverClass() {
		
	}
	
	public static void initDriver() throws IOException {
		
		if(Objects.isNull(DriverManager.getDriver())) {
			System.setProperty("webdriver.chrome.driver",FrameworkConstants.getCHROMEDRIVERPATH());
			DriverManager.setDriver(new ChromeDriver());
			DriverManager.getDriver().get(ReadProperties.getValue("url"));
			
		}	
	}
	
	public static void quitDriver() {
		
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
		
		
	}

}
