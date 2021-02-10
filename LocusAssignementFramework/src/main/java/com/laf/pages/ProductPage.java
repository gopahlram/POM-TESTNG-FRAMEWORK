package com.laf.pages;

import com.laf.constants.FrameworkConstants;
import com.laf.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProductPage extends BasePage{



    private final By buyBtn = By.xpath("//button[text()='BUY NOW']");
    private final By notifyBtn = By.xpath("//button[text()='NOTIFY ME']");

    private String sizeEle = "//div[span[text()='Size- UK/India']]//a[text()='%s']";
    private By emailField = By.xpath("//span[text()='CONTINUE']//ancestor::form//input");

    String url = "https://www.flipkart.com/checkout/init";


    public ProductPage enterProductDetailsToPurchase(String size){

        if (DriverManager.getDriver().findElements(By.xpath(String.format(sizeEle, size))).size()>0){
            WebElement element = DriverManager.getDriver().findElement(By.xpath(String.format(sizeEle, size)));

            if(element.isEnabled()) {
                element.click();
                explicitlyWaitForElementVisibility(By.xpath(String.format(sizeEle, size)), FrameworkConstants.midWaitTime);
                System.out.println("User prefered size " + size + " is got selected from available size");

                if (DriverManager.getDriver().findElements(buyBtn).size() > 0) {
                    click(buyBtn);
                    explicitlyWaitForElementVisibility(emailField, FrameworkConstants.midWaitTime);
                    System.out.println("User able to click on Buy button from product details page");
                    Assert.assertTrue(validateCheckOutPageUrl(url));

                } else if (DriverManager.getDriver().findElement(notifyBtn).isDisplayed()) {
                    System.out.println("User prefered item is not available for purchase, How about we notify once we get that??");
                }
            }

        }

        else { System.out.println("Your wished item is not available at this size"); }

        return this;

    }

    public Boolean validateCheckOutPageUrl(String url){

        return url.contains(DriverManager.getDriver().getCurrentUrl());

    }


}
