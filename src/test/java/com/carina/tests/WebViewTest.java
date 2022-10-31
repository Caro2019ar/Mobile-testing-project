package com.carina.tests;


import com.carina.allureReport.AllureListener;
import com.carina.base.ContextHandler;
import com.carina.base.DriverFactory;
import com.carina.base.TestBase;
import com.carina.pagesObj.LeftMenuPage;
import com.carina.pagesObj.WebViewPage;
import com.carina.util.ContextUtil;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
@Epic("EP001")
@Feature("Feature: WebView Hybrid page")
@Severity(SeverityLevel.CRITICAL)
@Test(groups = {"webview"}, dependsOnGroups = "signup")
public class WebViewTest extends TestBase {
    private AppiumDriver driver;
    private WebViewPage webViewPage;
    private LeftMenuPage leftMenuPage;

    @BeforeClass
    public void setUpWebView() {
        driver = DriverFactory.getDriver();
        webViewPage = new WebViewPage(driver);
        leftMenuPage = new LeftMenuPage(driver);
    }


    @Test(priority = 1)
    @Description("Webview right menu")
    @Story("Story: user can open right menu")
    @Step("Click on right menu of WebView")
    public void clickRightHambMenu() {
        ContextHandler.changeContext(driver, ContextUtil.WEB.getContext());
        webViewPage.clickRightMenuWeb();
        ContextHandler.changeContext(driver, ContextUtil.NATIVE.getContext());
    }

    @Test(priority = 2)
    @Description("openLeftMenu")
    @Step("openLeftMenu")
    public void openLeftMenu() {

        webViewPage.clickLeftHambMenu();
        leftMenuPage.waitProfile();
        AllureListener.takeScreenShotAllure(driver);
        Assert.assertEquals(driver.findElement(By.xpath("//android.widget.TextView[@text='Lorem ipsum']")).getText(), "Lorem ipsum");
    }

}
