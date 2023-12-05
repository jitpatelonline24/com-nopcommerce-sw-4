package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoginPageTest extends BaseTest {
    HomePage homePage = new HomePage();
    CheckoutPage checkoutPage = new CheckoutPage();
   CellPhonePage cellPhonePage = new CellPhonePage();
    BuildYourOwnComputerPage buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    DesktopPage desktopPage = new DesktopPage();
    RegisterPage registerPage = new RegisterPage();
    ShoppingCartPage shoppingCartPage =new ShoppingCartPage();
    WelcomePleaseSignInPage welcomePleaseSignInPage = new WelcomePleaseSignInPage();
    ThankYouMessagePage thankYouMessagePage = new ThankYouMessagePage();
    WelcomeToOurStorePage welcomeToOurStorePage =new WelcomeToOurStorePage();
    @Test
    public void verifyProductArrangeInAlphabaticalOrder(){
        homePage.mouseHoverOnComputer();
        homePage.clickOnDesktop();
        //Select Z to A sorting option from dropdown list & verify
        List<WebElement> beforeFilterNameZtoAList = driver.findElements(By.className("item-grid"));
        List<String> beforeFileNameZtoAList = new ArrayList<>();
        for (WebElement nameZtoA : beforeFilterNameZtoAList) {
            beforeFileNameZtoAList.add(nameZtoA.getText());
        }
        Select select = new Select(driver.findElement(By.id("products-orderby")));
        select.selectByVisibleText("Name: Z to A");
        List<WebElement> afterFilterNameZtoAList = driver.findElements(By.className("item-grid"));
        List<String> afterFileNameZtoAList = new ArrayList<>();
        for (WebElement nameZtoA : afterFilterNameZtoAList) {
            afterFileNameZtoAList.add(nameZtoA.getText());
        }
        Collections.sort(beforeFileNameZtoAList);
        Assert.assertEquals(beforeFilterNameZtoAList, afterFilterNameZtoAList);
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        homePage.mouseHoverOnComputer();
        homePage.clickOnDesktop();
        //Select A to Z sorting option from dropdown list
        //  WebElement dropdown = driver.findElement(By.name("products-orderby"));
        //  Select select = new Select(dropdown);
        //   select.selectByVisibleText("Name: A to Z");
        desktopPage.setDropdown("Desktop");
        desktopPage.clickOnAddToCart();
        buildYourOwnComputerPage.selectByVisibleText();
        buildYourOwnComputerPage.setRam();
        buildYourOwnComputerPage.setRadioButtonHDD();
        buildYourOwnComputerPage.setRadioButtonOS();
        buildYourOwnComputerPage.setMicrosoftOfficeCheckBox();
        buildYourOwnComputerPage.setTotalCommanderCheckbox();
        //verify the price $ 1415.00
        String expectedPrice = "$1,470.00";
        String actualPrice = getTextFromElement(By.xpath("//span[@id='price-value-1']"));
        //Assert.assertEquals(expectedPrice,actualPrice);

        buildYourOwnComputerPage.clickOnAddToCart();
        buildYourOwnComputerPage.setCloseBar();
        // Verify the cart msg
        String expectedCartMsg = "Shopping cart";
        String actualCartMsg = getTextFromElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Assert.assertEquals(expectedCartMsg, actualCartMsg);

        buildYourOwnComputerPage.setShoppingCart();
        //shoppingCartPage.changeOrderQty();
        // Verify the total $2,950.00
        //  String expectedTotal = "$2,950.00";
        //   String actualTotal = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"));
        //   Assert.assertEquals(expectedTotal, actualTotal);
        shoppingCartPage.setCheckBox();
        shoppingCartPage.setCheckoutButton();
        Thread.sleep(2000);
        welcomePleaseSignInPage.getWelcomeText();

        welcomePleaseSignInPage.setCheckoutGuest();
        // verify the order msg.
        // String expectedOrdMsg = "The product has been added to your shopping cart";           // shopping cart
        //    String actualOrderMsg = getTextFromElement(By.xpath("//p[@class='content']"));
        //  Assert.assertEquals(actualOrderMsg, expectedOrdMsg);
        checkoutPage.enterFirstName("Prime");
        checkoutPage.enterLastName("Testing");
        checkoutPage.enterEmailId("prime12345678@gmail.com");

        Thread.sleep(5000);
        checkoutPage.selectFromDropdownCountry("United Kingdom");
        checkoutPage.enterCity("Harrow");
        checkoutPage.enterAddress1("100");
        checkoutPage.enterAddress2("ABC LANE");
        checkoutPage.enterZip("HA2 9SE");
        checkoutPage.enterPhoneNumber("0754741442");
        checkoutPage.enterFaxNumber("0192535448");
        checkoutPage.clickOnContinueButton();
        checkoutPage.clickOnNextDayAirButton();
        checkoutPage.clickOnContinueButton1();
        checkoutPage.clickOnCreditCardPaymentMethod();
        checkoutPage.clickOnContinueButton2();
        checkoutPage.selectCreditCardType("Master card");
        checkoutPage.fillingCardDetails("Prime Testing","5521573041475125", "10","2027","245");
        checkoutPage.clickOnContinueButton3();
        checkoutPage.clickOnConfirm();
        // verify the Thankyou Message
        String expectedMsg3 = "Thank you";
        String actualMsg3 = getTextFromElement(thankYouMessagePage.thankYouMessageElement());

        Assert.assertEquals(expectedMsg3, actualMsg3);

        // Verify the order msg. - Your order has been successfully processed!
        String exporderMsg = "Your order has been successfully processed!";
        String actordMsg = getTextFromElement(thankYouMessagePage.youOrderMessageElement());
        Assert.assertEquals(actordMsg, exporderMsg);

        thankYouMessagePage.clickOnContinueButton();


        String actFinalmsg = "Welcome to our store";
        String expFinalmsg = getTextFromElement(welcomeToOurStorePage.welcomeToOurStoreElement());
        Assert.assertEquals(actFinalmsg,expFinalmsg);

    }
}
