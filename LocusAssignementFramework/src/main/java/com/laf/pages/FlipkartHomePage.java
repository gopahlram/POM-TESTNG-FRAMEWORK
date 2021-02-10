package com.laf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.laf.constants.FrameworkConstants;
import com.laf.driver.DriverManager;

public class FlipkartHomePage extends BasePage{
	
	
	/*  Add all Page Elements related to search page below  */
	
	private final By searchBar = By.xpath("//form[contains(@action,'search')]//input[@type='text']");
	private final By filterTextEle = By.xpath("//span[text()='CATEGORIES']/ancestor::section//a[@title='Footwear']");
	private final By searchBtn = By.xpath("//form[contains(@action,'search')]//button");
	private final By urlEle = By.xpath("//a[@rel='noopener noreferrer']");


	/*  Add Page methods  related to search page below  */

	public FlipkartHomePage enterSearch(String searchValue) {
		
		WebElement element = DriverManager.getDriver().findElement(searchBar);
		send(searchBar,searchValue);
		click(searchBtn);
		explicitlyWaitForElementVisibility(filterTextEle, FrameworkConstants.midWaitTime);
		System.out.println("User able to search for "+searchValue+" in flipkart product page");
		return this;
	
	}


	/*  This method is to validate the search page is loading or not
	* 	We are validating If url getting added with search paramter and filter section
	* 	getting change based on search text
	*   */

	public Boolean validateSearchPage(String searchValue){

		String pageURL = DriverManager.getDriver().getCurrentUrl();
		explicitlyWaitForElementVisibility(filterTextEle, FrameworkConstants.midWaitTime);
		Boolean elementVisible =DriverManager.getDriver().findElement(filterTextEle).isDisplayed();
		return pageURL.contains(String.format(searchValue)) && elementVisible;

	}
	
	public String getTitle() {
		
		return getPageTitle().toLowerCase();
		
	}

	public FlipkartHomePage fetchProductURL(){
//		System.out.println(DriverManager.getDriver().findElements(urlEle).get(0).getAttribute("href"));
		navigateToURL(DriverManager.getDriver().findElements(urlEle).get(0).getAttribute("href"));

		return this;
	}

}
