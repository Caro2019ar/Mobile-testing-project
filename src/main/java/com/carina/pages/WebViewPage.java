package com.carina.pages;

import com.carina.base.WebViewPageBase;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebViewPage extends WebViewPageBase {


    public WebViewPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @FindBy(xpath = "//*[@id=\"rec42972268\"]/div[2]/div/div[2]")
    WebElement burgerWeb;
    // classname= t228_burger
    public void clickRightMenuWeb() {
        clickWeb(burgerWeb);
    }


    //readongithub
    // xpath = //*[@id="nav40073764"]/div/div[3]/div/ul/li[1]/a
}
