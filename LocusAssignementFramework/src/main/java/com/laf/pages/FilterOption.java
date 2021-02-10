package com.laf.pages;
import com.laf.constants.FrameworkConstants;
import org.openqa.selenium.By;
import com.laf.driver.DriverManager;
import org.openqa.selenium.WebElement;
import java.util.List;


public class FilterOption extends BasePage {
	
	
	/* Declare Web Elements Here */
	
	private final By rangeDrpDwn = By.xpath("//span[text()='Price']//ancestor::section//select");
	
	/* Declare Strings here */
	
	private String filterText = "//div[contains(text(),'%s')]//parent::label/input[@type='checkbox']";
	private String filterTag = "//span[text()='Filters']//ancestor::section//div[contains(text(),'%s')]";


	/*                  ----------- Declare Page Object Methods -----------------                       */



	/*  This method is to select the filter option from filter section
	 *
	 * 	Using Java script executor as action, scroll not working to select the element
	 *   */

	public FilterOption selectFilter(String filterValue) {

		By element = By.xpath(String.format(filterText,filterValue));
		By filterTagEle = By.xpath(String.format(filterTag,filterValue));

		clickUsingJS(DriverManager.getDriver().findElement(element));
		explicitlyWaitForElementVisibility(filterTagEle, FrameworkConstants.midWaitTime);

		System.out.println("User able to select the filter "+filterValue+" from filter option");


		return this;
	}


	public FilterOption selectPriceRange(String priceRange) {

		List<WebElement> elements = DriverManager.getDriver().findElements(rangeDrpDwn);
		selectElement(elements.get(1), priceRange);

		System.out.println("User able to select the price  "+priceRange+" from price dropdown");

		return this;
	}



	/*  This method is to validate that filter is applied or not to the search product
	 *
	 *   */

	public Boolean validateAppliedFilter(String filterName, String option){

		By filterTagEle = By.xpath(String.format(filterTag,filterName));

		String pageURL = DriverManager.getDriver().getCurrentUrl();
		Boolean value = false;

		if(option.toLowerCase().equals("brand")){

			explicitlyWaitForElementVisibility(filterTagEle, FrameworkConstants.midWaitTime);
			value = pageURL.contains(filterName) && DriverManager.getDriver().findElement(filterTagEle).isDisplayed();
		}

		else if(option.toLowerCase().equals("range")){
			explicitlyWaitForElementVisibility(filterTagEle, FrameworkConstants.midWaitTime);
			value = pageURL.contains(filterName) && DriverManager.getDriver().findElement(filterTagEle).isDisplayed();

		}
		return value;
	}

}
