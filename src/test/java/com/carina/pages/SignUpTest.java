package com.carina.pages;

import com.carina.base.TestBase;
import com.carina.dataproviders.SignUpDP;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

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
    public void clickOnAgree() {
        signUpPage.clickCheckBtn();
    }

    @Test(dependsOnMethods = "clickOnAgree")
    public void clickOnSignup() {
        signUpPage.clickSignBtn();
    }

    @Test(dependsOnMethods = "clickOnSignup")
    public void signUpSuccessfully() {
        webViewPage.waitToolbar();
        Assert.assertTrue(driver.findElement(By.id("toolbar")).isDisplayed());
    }

}
