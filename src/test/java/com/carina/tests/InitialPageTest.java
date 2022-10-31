package com.carina.tests;

import com.carina.allureReport.AllureListener;
import com.carina.base.DriverFactory;
import com.carina.base.TestBase;
import com.carina.pagesObj.InitialPage;
import com.carina.pagesObj.SignUpPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

@Test(groups = {"initialize"})
@Listeners({AllureListener.class})
@Epic("EP001")
@Feature("Feature: Initial page")
@Severity(SeverityLevel.BLOCKER)
public class InitialPageTest extends TestBase {
    private AppiumDriver driver;
    private InitialPage initialPage;
    private SignUpPage signUpPage;


    @BeforeClass
    public void setUpInitialPage() {
        driver = DriverFactory.getDriver();
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
        AllureListener.takeScreenShotAllure(driver);
        Assert.assertTrue(driver.findElement(By.id("loginForm")).isDisplayed());
    }



}
