package com.carina.tests;


import com.carina.allureReport.AllureListener;
import com.carina.base.ContextHandler;
import com.carina.base.DriverFactory;
import com.carina.base.TestBase;
import com.carina.pagesObj.LeftMenuPage;
import com.carina.pagesObj.WebViewPage;
import com.carina.util.ContextUtil;
import com.carina.util.ScrollDownUtil;
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

    @Test(priority = 0)
    @Description("ScrollDown")
    @Story("Scroll down the webview")
    @Step("Scroll down the webview")
    public void scrollDownWebView() {
        ScrollDownUtil.scrollDown(driver, 0.8, 0.4);
        AllureListener.takeScreenShotAllure(driver);
    }

    @Test(priority = 1)
    @Description("Webview right menu")
    @Story("Story: user can open right menu")
    @Step("Click on right menu of WebView")
    public void clickRightHambMenu() {
        ContextHandler.changeContext(driver, ContextUtil.WEB.getContext());
        webViewPage.clickRightMenuWeb();

    }

    @Test(priority = 2)
    @Description("openLeftMenu")
    @Story("Story: user can open left menu")
    @Step("openLeftMenu")
    public void openLeftMenu() {
        ContextHandler.changeContext(driver, ContextUtil.NATIVE.getContext());
        webViewPage.clickLeftHambMenu();
        leftMenuPage.waitProfile();

        Assert.assertEquals(driver.findElement(By.xpath("//android.widget.TextView[@text='Lorem ipsum']")).getText(), "Lorem ipsum");
    }

}
