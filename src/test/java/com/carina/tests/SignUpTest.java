package com.carina.tests;


import com.carina.allureReport.AllureListener;
import com.carina.base.DriverFactory;
import com.carina.base.TestBase;
import com.carina.base.WebViewPageBase;
import com.carina.dataproviders.SignUpDP;
import com.carina.pagesObj.SignUpPage;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
@Epic("EP001")
@Feature("Feature: Signup page")
@Severity(SeverityLevel.BLOCKER)
@Test(groups = {"signup"}, dependsOnGroups = "initialize")
public class SignUpTest extends TestBase {
    private AppiumDriver driver;
    private SignUpPage signUpPage;
    private WebViewPageBase webViewPageBase;

    @BeforeClass
    public void setUpSignUp() {
        driver = DriverFactory.getDriver();
        signUpPage = new SignUpPage(driver);
        webViewPageBase = new WebViewPageBase(driver);

    }

    @Test(priority = 1)
    @Description("Check the Carina Text")
    @Step("Can see the Carina text")
    public void canViewTheCarinaText() {
        signUpPage.waitCarinaText();
        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='CARINA']")).isDisplayed());
    }

    @Test(priority = 1)
    @Description("Check the Back button")
    @Step("Can see the Back button")
    public void canViewBackButton() {
        Assert.assertTrue(driver.findElement(By.id("backButton")).isDisplayed());
    }

    @Test(dataProviderClass = SignUpDP.class, dataProvider = "signUpData", dependsOnMethods = "canViewTheCarinaText")
    @Description("Signup")
    @Story("Story: Can enter user´s data and signup")
    @Step("Enter name, password and gender")
    public void enterNamePasswordGender(String name, String password, String gender) {
        signUpPage.enterName(name);
        signUpPage.enterPassword(password);
        signUpPage.clickGender(gender);

    }


    @Test(dependsOnMethods = "enterNamePasswordGender")
    @Description("Click on agree")
    @Story("Story: Can agree on terms")
    @Step("Click on agree")
    public void clickOnAgree() {
        signUpPage.visibleAgreeTextOFF();
        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.Switch[@text='I agree to the Privacy Policy OFF']")).isDisplayed());
        signUpPage.clickCheckBtn();
        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.Switch[@text='I agree to the Privacy Policy ON']")).isDisplayed());
    }

    @Test(dependsOnMethods = "clickOnAgree")
    @Description("Click on signup button")
    @Story("Story: Can click on signup button")
    @Step("Click on signup button")
    public void clickOnSignup() {
        Assert.assertTrue(driver.findElement(By.id("login_button")).isDisplayed());
        signUpPage.clickSignBtn();
        AllureListener.takeScreenShotAllure(driver);
    }

    @Test(dependsOnMethods = "clickOnSignup")
    @Description("Assert signUpSuccessfully")
    @Step("signUpSuccessfully")
    public void signUpSuccessfully() {
        webViewPageBase.waitToolbar();
        Assert.assertTrue(driver.findElement(By.id("toolbar")).isDisplayed());
    }

}
