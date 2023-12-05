package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {

    By computer =By.xpath("/html[1]/body[1]/div[6]/div[2]/ul[1]/li[1]/a[1]");
    By desktop = By.xpath("/html[1]/body[1]/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]");
    By electronics = By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]");
    By cellphones= By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]");

    //1.1 Click on Computer Menu
    public void mouseHoverOnComputer(){
        clickOnElement(computer);
    }
    public void clickOnDesktop(){
        clickOnElement(desktop);
    }
    public void mouseHoverOnElectronics(){clickOnElement(electronics);}
    public void clickOnCellphone(){clickOnElement(cellphones);
    }

}
