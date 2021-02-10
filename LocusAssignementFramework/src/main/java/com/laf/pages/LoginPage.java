package com.laf.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.laf.driver.DriverManager;

public class LoginPage extends BasePage {


	/*  Add all Page Elements related to Login page below  */

	private final By passowrd = By.xpath("//input[@type='password']");
	private final By closeIcon = By.xpath("//button[text()='✕']");
	private final By fkNameEle = By.xpath("href=\"/\"");


	/*  Add Page methods  related to Login page below  */
	
	
	
	/* This method is to close 
	 	the Login window pop up 
	  */

	public LoginPage closeLoginWindow() {

		
		if (DriverManager.getDriver().findElement(passowrd).isDisplayed()) { click(closeIcon); }
		return this;

	}
	
}
