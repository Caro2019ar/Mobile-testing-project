package com.carina.tests;

import com.carina.allureReport.AllureListener;
import com.carina.base.TestBase;
import com.carina.pagesObj.InitialPage;
import com.carina.pagesObj.SignUpPage;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Test(groups = {"initialize"})
@Listeners({AllureListener.class})
@Epic("EP001")
@Feature("Feature: Initial page")
@Severity(SeverityLevel.BLOCKER)
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
    @Story("Story: Can initiate app")
    @Step("Initiate page and click on NEXT")
    public void clickOnNext() {
        initialPage.clickNextBtn();

    }

    @Test(dependsOnMethods = "clickOnNext")
    @Description("goToSignupPageSuccessfully")
    @Step("goToSignupPageSuccessfully")
    public void goToSignupPageSuccessfully() {
        signUpPage.waitLoginForm();
        Assert.assertTrue(driver.findElement(By.id("loginForm")).isDisplayed());
    }


}
