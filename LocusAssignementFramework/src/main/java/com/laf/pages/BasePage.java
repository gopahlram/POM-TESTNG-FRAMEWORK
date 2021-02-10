package com.laf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import com.laf.constants.FrameworkConstants;
import com.laf.driver.DriverManager;

public class BasePage {
		
	
	protected void click(By by) {
		explicitlyWaitForElementClickable(by, FrameworkConstants.waitTime);
		DriverManager.getDriver().findElement(by).click();
		
	}
	
	protected void send(By by, String value) {
		explicitlyWaitForElementClickable(by, FrameworkConstants.waitTime);
		DriverManager.getDriver().findElement(by).sendKeys(value);;
		
	}
	
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
		
	}
	
	protected void explicitlyWaitForElementClickable(By by, int waitSeconds) {
		new WebDriverWait(DriverManager.getDriver(), waitSeconds )
			.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	protected void explicitlyWaitForElementPresence(By by, int waitSeconds) {
		new WebDriverWait(DriverManager.getDriver(), waitSeconds )
			.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	protected void explicitlyWaitForElementVisibility(By by, int waitSeconds) {
		new WebDriverWait(DriverManager.getDriver(), waitSeconds )
			.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public synchronized void scrollToElement(WebElement element) {

			((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.scrollTo(arguments[0],arguments[1])",
					element.getLocation().x,
					element.getLocation().y);

		}


	public void clickUsingJS(WebElement element) {

			JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
			executor.executeScript("arguments[0].click()", element);

	}


	public void selectElement(WebElement element, String dropDownValue) {

		Select dropdown = new Select(element);
		dropdown.selectByValue(dropDownValue);
	}


	public void navigateToURL(String url){
		DriverManager.getDriver().get(url);
	}
}


