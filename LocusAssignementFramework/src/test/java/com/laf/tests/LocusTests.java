package com.laf.tests;
import com.laf.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public final class LocusTests extends BaseTest{
	
	private LocusTests() {
		
	}
	
	String searchValue = "shoe";
	String appName = "online shopping site for mobiles, electronics, furniture, grocery, lifestyle, books & more. best offers!";
	String brand = "Puma";
	String priceRange = "3000";

	/* create objects for page methods to fetch items */
	
	FlipkartHomePage homePage = new FlipkartHomePage();
	LoginPage loginPage = new LoginPage();
	FilterOption filter = new FilterOption();
	CheckoutPage checkout = new CheckoutPage();
	ProductPage productPage = new ProductPage();



	@Test(testName = "This test is cover the scenario of selecting shoe from flipkart using price range 3000 and " +
			"brand filter and size 8")
	public void buyProductFromsearchFilter() throws InterruptedException{
		
		loginPage.closeLoginWindow();
		Assert.assertEquals(homePage.getTitle(), appName);
		homePage.enterSearch(searchValue);
		Assert.assertTrue(homePage.validateSearchPage(searchValue),"User not able to validate the search page filter section and url parameter");
		filter.selectFilter(brand);
		Assert.assertTrue(filter.validateAppliedFilter("Puma","brand"),
				"User not able to validate the added filter paramter brand " +brand + " in url and filter tag");
		filter.selectPriceRange("3000");
		Assert.assertTrue(filter.validateAppliedFilter("3000","range"),
				"User not able to validate the added filter paramter range " +priceRange + " in url and filter tag");


		homePage.fetchProductURL();
		productPage.enterProductDetailsToPurchase("8");

		
	}

	/* Added this to show failure in reports
	*  please uncomment these lines to see how failures appear in report
	*
	*  */
//
//	@Test(testName = "This test is cover the scenario of selecting shoe from flipkart using price range 3000 and " +
//			"brand filter and size 3")
//	public void buyShoeFromFlipkart() throws InterruptedException{
//
//		loginPage.closeLoginWindow();
//		Assert.assertEquals(homePage.getTitle(), "failure");
//
//	}
	
	
	
	
	
	
	

}
