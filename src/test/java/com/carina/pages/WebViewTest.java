package com.carina.pages;


import com.carina.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class WebViewTest extends TestBase {
    private WebViewPage webViewPage;
    private LeftMenuPage leftMenuPage;

    @BeforeClass
    public void setUpWebView(){
        webViewPage = new WebViewPage(driver);
        leftMenuPage = new LeftMenuPage(driver);
    }
    @Test
    public void openLeftMenu(){
        webViewPage.clickLeftHambMenu();
    }

    @Test (dependsOnMethods = "openLeftMenu")
    public void checkUserProfile(){
        leftMenuPage.waitProfile();
        Assert.assertEquals(driver.findElement(By.xpath("//android.widget.TextView[@text='Lorem ipsum']")).getText(), "Lorem ipsum");
    }

}
