package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class ShoppingCartPage extends Utility {

    By qty = By.xpath("#itemquantity11222");
    By total = By.xpath("//td[@class='subtotal']");
    By checkBox = By.xpath("//input[@id='termsofservice']");
    By checkoutButton= By.xpath("//button[@id='checkout']");
/**
    //    2.16 Change the Qty to "2" and Click on "Update shopping cart"
    public void changeOrderBy(){
        clearTextFromField(qty);
        sendTextToElement(qty,"2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));
    }
    //            2.17 Verify the Total"$2,950.00"
    public void setTotal(){
        clickOnElement(total);
    }  */
    //            2.18 click on checkbox “I agree with the terms of service”
    public void setCheckBox(){
        clickOnElement(checkBox);
    }
    //            2.19 Click on “CHECKOUT”
    public void setCheckoutButton(){
        clickOnElement(checkoutButton);
    }

}
