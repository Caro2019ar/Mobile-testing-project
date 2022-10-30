package com.carina.tests;


import com.carina.allureReport.AllureListener;
import com.carina.base.TestBase;
import com.carina.base.WebViewPageBase;
import com.carina.dataproviders.SignUpDP;
import com.carina.pagesObj.SignUpPage;
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

    private SignUpPage signUpPage;
    private WebViewPageBase webViewPageBase;

    @BeforeClass
    public void setUpSignUp() {
        signUpPage = new SignUpPage(driver);
        webViewPageBase = new WebViewPageBase(driver);

    }


    @Test(dataProviderClass = SignUpDP.class, dataProvider = "signUpData")
    @Description("Signup")
    @Story("Story: Can enter user´s data and signup")
    @Step("Enter name, password and gender")
    public void enterNamePasswordGender(String name, String password, String gender) {
        signUpPage.enterName(name);
        signUpPage.enterPassword(password);
        if (gender.contains("female")) {
            signUpPage.clickFemale();
        } else {
            signUpPage.clickMale();
        }
    }


    @Test(dependsOnMethods = "enterNamePasswordGender")
    @Description("Click on agree")
    @Story("Story: Can agree on terms")
    @Step("Click on agree")
    public void clickOnAgree() {
        signUpPage.clickCheckBtn();
    }

    @Test(dependsOnMethods = "clickOnAgree")
    @Description("Click on signup button")
    @Story("Story: Can click on signup button")
    @Step("Click on signup button")
    public void clickOnSignup() {
        signUpPage.clickSignBtn();
    }

    @Test(dependsOnMethods = "clickOnSignup")
    @Description("Assert signUpSuccessfully")
    @Step("signUpSuccessfully")
    public void signUpSuccessfully() {
        webViewPageBase.waitToolbar();
        Assert.assertTrue(driver.findElement(By.id("toolbar")).isDisplayed());
    }

}
