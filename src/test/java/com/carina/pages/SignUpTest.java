package com.carina.pages;

import com.carina.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;


public class SignUpTest extends TestBase {

    @DataProvider
    public Object[][] signUpData() {
        Object[][] data = new Object[3][3];

        data[0][0] = "Cristian";
        data[0][1] = "123456";
        data[0][2] = "male";
        data[1][0] = "Carina Gonzalez";
        data[1][1] = "pass1234";
        data[1][2] = "female";
        data[2][0] = "Ezequiel";
        data[2][1] = "eze123";
        data[2][2] = "male";

        return data;
    }

    SignUpPage signUpPage;
     InitialPage initialPage;

    @Test
    public void setUpSignUp()  {
        android_setUp();
        initialPage = new InitialPage(driver);
        initialPage.clickNextBtn();
        tearDown();
    }

    @Test(priority = 1, dataProvider = "signUpData")
    public void enterNamePassGender(String name, String password, String gender) {

        signUpPage = new SignUpPage(driver);

        signUpPage.enterName(name);
        signUpPage.enterPassword(password);
        if (gender.contains("female")) {
            signUpPage.clickFemale();
        } else {
            signUpPage.clickMale();
        }
    }

    /*@Test(priority = 1)
    public void enterYourName(String nameTxt) {


    }
    @Test(priority = 2)
    public void enterPassword(String passwordTxt) {
        ;
    }

    @Test(priority = 3)
    public void selectGender(String gender) {

    }*/

    @Test(priority = 2)
    public void clickOnAgree() {
        signUpPage.clickCheckBtn();
    }

    @Test(priority = 3)
    public void clickOnSignup() {
        signUpPage.clickSignBtn();
    }

   /* @AfterTest
    public void signUpSuccessfully() {
        Assert.assertEquals(driver.findElement(By.xpath("//android.widget.TextView[@text='Lorem ipsum']")).getText(), "Lorem ipsum");
        tearDown();
    }*/
}
