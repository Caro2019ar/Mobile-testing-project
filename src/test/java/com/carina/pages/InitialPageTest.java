package com.carina.pages;

import com.carina.base.TestBase;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;


public class InitialPageTest extends TestBase {
    private InitialPage initialPage;

    @Test
    public void clickOnNext() {
        android_setUp();
        initialPage = new InitialPage(driver);
        initialPage.clickNextBtn();
    }

    public void goToSignupPageSuccessfully() {

        tearDown();
    }
}
