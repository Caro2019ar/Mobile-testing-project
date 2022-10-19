package com.carina.tests;

import com.carina.InitialPage;
import com.carina.SignUpPage;
import com.carina.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.net.MalformedURLException;

public class SignUpWithExample extends TestBase {
    SignUpPage signUpPage;
    InitialPage initialPage;


    public void setUpSignUp() throws MalformedURLException {
        android_setUp();
    }

    public void enterYourName(String nameTxt) {
        initialPage = new InitialPage(driver);
        signUpPage = new SignUpPage(driver);
        initialPage.clickNextBtn();
        signUpPage.enterName(nameTxt);
    }

    public void enterPassword(String passwordTxt) {
        signUpPage.enterPassword(passwordTxt);
    }

    public void selectGender(String gender) {
        if (gender.contains("female")) {
            signUpPage.clickFemale();
        } else {
            signUpPage.clickMale();
        }
    }


    public void clickOnAgree() {
        signUpPage.clickCheckBtn();
    }


    public void clickOnSignup() {
        signUpPage.clickSignBtn();
    }


    public void signUpSuccessfully() {
        Assert.assertEquals(driver.findElement(By.xpath("//android.widget.TextView[@text='Lorem ipsum']")).getText(), "Lorem ipsum");
        tearDown();
    }
}
