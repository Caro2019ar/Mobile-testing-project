package com.carina.pages;

import com.carina.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = {"initialize"})
public class InitialPageTest extends TestBase {
    private InitialPage initialPage;
    private SignUpPage signUpPage;

    @BeforeClass
    public void setUpInitialPage() {
        initialPage = new InitialPage(driver);
        signUpPage = new SignUpPage(driver);
    }
    @Test
    @Description("Verify and click on NEXT  button")
    @Epic("EP001")
    @Feature("Feature: Initial page")
    @Story("Story: Can initiate app")
    @Step("Initiate page and click on NEXT")
    @Severity(SeverityLevel.BLOCKER)
    public void clickOnNext() {
        initialPage.clickNextBtn();
    }

    @Test(dependsOnMethods = "clickOnNext")
    public void goToSignupPageSuccessfully() {
        signUpPage.waitLoginForm();
        Assert.assertTrue(driver.findElement(By.id("loginForm")).isDisplayed());
    }
}
