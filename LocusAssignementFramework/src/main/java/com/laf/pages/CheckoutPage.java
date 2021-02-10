package com.laf.pages;
import com.laf.constants.FrameworkConstants;
import org.openqa.selenium.By;
import com.laf.driver.DriverManager;

public final class CheckoutPage extends BasePage{



    private By emailField = By.xpath("//span[text()='CONTINUE']//ancestor::form//input");

    public Boolean validateCheckOutPageUrl(String url){

        return url.contains(DriverManager.getDriver().getCurrentUrl());

    }

    public CheckoutPage enterCheckoutDetails(String email){
        explicitlyWaitForElementClickable(emailField, FrameworkConstants.midWaitTime);
        click(emailField);
        send(emailField, email);
        System.out.println("User able to enter the email address in checkout page");

        return this;
    }

}
