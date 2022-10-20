package com.carina.pages;


import com.carina.pages.InitialPage;
import com.carina.base.TestBase;

import java.net.MalformedURLException;

public class StartToNext extends TestBase {

    InitialPage initialPage;

    public void clickOnNext() throws MalformedURLException {
    android_setUp();
    initialPage = new InitialPage(driver);
    initialPage.clickNextBtn();
    }

    public void goToSignupPage() {
        tearDown();
    }
}
