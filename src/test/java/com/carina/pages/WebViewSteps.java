package com.carina.pages;


import com.carina.pages.WebViewPage;
import com.carina.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;



public class WebViewSteps extends TestBase {
    WebViewPage webViewPage;


    public void iAmLoggedIn()  {
        webViewPage = new WebViewPage(driver);
    }


    public void iOpenTheLeftMenu() {
        webViewPage.clickLeftHambMenu();
    }


    public void iSuccessfullyCanSeeMyProfile() {
        Assert.assertEquals(driver.findElement(By.xpath("//android.widget.TextView[@text='Lorem ipsum']")).getText(), "Lorem ipsum");
        tearDown();
    }
}
