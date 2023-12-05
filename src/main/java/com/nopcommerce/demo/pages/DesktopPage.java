package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class DesktopPage extends Utility {

    By dropdown = By.name("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']");
    By addToCart = By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]");

    public void clickOnAddToCart() {
        clickOnElement(addToCart);
    }

    public void setDropdown(String Desktop){
        selectByVisibleTextFromDropDown(dropdown,Desktop);
    }
}
