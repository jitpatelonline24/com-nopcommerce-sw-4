package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class ThankYouMessagePage extends Utility {
    By thankYouMessage = By.xpath("//h1[normalize-space()='Thank you']");
    By youOrder = By.xpath("//strong[normalize-space()='Your order has been successfully processed!']");
    By continueButton = By.xpath("//button[normalize-space()='Continue']");

    public By thankYouMessageElement(){
        return thankYouMessage;
    }
    public By youOrderMessageElement(){
        return youOrder;
    }
    public void clickOnContinueButton(){
        clickOnElement(continueButton);
    }

}
