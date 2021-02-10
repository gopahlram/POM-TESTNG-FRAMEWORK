package com.laf.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.laf.driver.DriverClass;

public class BaseTest {
	
	protected BaseTest() {
		
	}

	@BeforeMethod
	protected void setUp() throws IOException {

		DriverClass.initDriver();
		
	}

	@AfterMethod
	protected void tearDown() {

		DriverClass.quitDriver();
		
	}

}
