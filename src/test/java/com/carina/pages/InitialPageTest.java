package com.carina.pages;

import com.carina.base.TestBase;

import java.net.MalformedURLException;

public class InitialPageTest extends TestBase {
    InitialPage initialPage;

    public void clickOnNext() {
        android_setUp();
        initialPage = new InitialPage(driver);
        initialPage.clickNextBtn();
    }

    public void goToSignupPageSuccessfully() {
        tearDown();
    }
}
