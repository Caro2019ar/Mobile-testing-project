package com.carina.pagesObj;

import com.carina.base.WebViewPageBase;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebViewPage extends WebViewPageBase {


    public WebViewPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }


    @FindBy(xpath = "//*[@id=\"rec42972268\"]")
    WebElement burgerWeb;


    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div[6]/a")
    WebElement readOnGitHub;


  /*  @FindBys({
            @FindBy(tagName = "a"),
            @FindBy(linkText = "Read on GitHub")
    })
    WebElement readOnGitHub;*/
//    List<WebElement> readOnGitHub;

    String menuXpath = "//*[@id=\"rec42972268\"]";


    public void waitVisibleGitHub() {
        waitForVisibilityWeb(readOnGitHub);
    }

    public void clickRightMenuWeb() {
        waitForVisibilityWeb(menuXpath);
    }

    public void clickReadOnGit() {
        clickWeb(readOnGitHub);
    }

}


