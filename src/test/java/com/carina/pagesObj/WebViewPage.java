package com.carina.pagesObj;

import com.carina.base.WebViewPageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebViewPage extends WebViewPageBase {


    public WebViewPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }


    @FindBy(xpath = "//*[@id=\"rec42972268\"]")
    WebElement burgerWeb;


    String menuXpath = "//*[@id=\"rec42972268\"]";
    public void clickRightMenuWeb() {
        waitForVisibilityWeb(menuXpath);
    }


//*[@id="screenshotContainer"]/div[2]/div/div/div/div/div[40]/div
    //readongithub
    // xpath = //*[@id="nav40073764"]/div/div[3]/div/ul/li[1]/a
}
