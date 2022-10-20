package com.carina.pages;

import com.carina.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;


public class SignUpTest extends TestBase {

    @DataProvider
    public Object[][] signUpData() {
        Object[][] data = new Object[1][3];

        data[0][0] = "Cristian";
        data[0][1] = "123456";
        data[0][2] = "male";
        return data;
    }

    SignUpPage signUpPage;
    InitialPage initialPage;
    WebViewPage webViewPage;

    @BeforeClass
    public void setUpSignUp() {
        android_setUp();
    }

    @Test(priority = 1, dataProvider = "signUpData")
    public void enterNamePasswordGender(String name, String password, String gender) {
        initialPage = new InitialPage(driver);
        signUpPage = new SignUpPage(driver);
        initialPage.clickNextBtn();
        signUpPage.enterName(name);
        signUpPage.enterPassword(password);
        if (gender.contains("female")) {
            signUpPage.clickFemale();
        } else {
            signUpPage.clickMale();
        }
    }


    @Test(priority = 2)
    public void clickOnAgree() {
        signUpPage.clickCheckBtn();
    }

    @Test(priority = 3)
    public void clickOnSignup() {
        signUpPage.clickSignBtn();
    }

    @Test(priority = 4)
    public void signUpSuccessfully() {
        webViewPage = new WebViewPage(driver);
        webViewPage.waitToolbar();
        Assert.assertTrue(driver.findElement(By.id("toolbar")).isDisplayed());
    }

}
