package com.carina.pages;


import com.carina.base.TestBase;
import com.carina.dataproviders.SignUpDP;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners({com.carina.allureReport.AllureListener.class})
@Epic("EP001")
@Feature("Feature: Signup page")
@Severity(SeverityLevel.BLOCKER)
@Test(dependsOnGroups = "initialize")
public class SignUpTest extends TestBase {

    private SignUpPage signUpPage;
    private WebViewPage webViewPage;

    @BeforeClass
    public void setUpSignUp() {
        signUpPage = new SignUpPage(driver);
        webViewPage = new WebViewPage(driver);
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
    public void signUpSuccessfully() {
        webViewPage.waitToolbar();
        Assert.assertTrue(driver.findElement(By.id("toolbar")).isDisplayed());
    }

}
