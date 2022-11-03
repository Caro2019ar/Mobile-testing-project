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
import io.appium.java_client.MobileElement;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.carina.base.WebViewPageBase.WAIT;

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
    public void scrollDownWebView() throws InterruptedException {
        ScrollDownUtil scrollUtil = new ScrollDownUtil();
        ContextHandler.changeContext(driver, ContextUtil.WEB.getContext());
        scrollUtil.scrollDown(driver, 0.8, 0.4);

    }

    @Test(dependsOnMethods = "scrollDownWebView")
    @Description("clickOnReadOnGithub")
    @Story("clickOnReadOnGithub")
    @Step("clickOnReadOnGithub")
    public void clickOnReadOnGithub() {
        ContextHandler.changeContext(driver, ContextUtil.WEB.getContext());
        webViewPage.waitVisibleGitHub();
        webViewPage.clickReadOnGit();
    }

    @Test(dependsOnMethods = "clickOnReadOnGithub")
    @Parameters({"URL"})
    @Description("readOnGithub")
    @Story("readOnGithub")
    @Step("readOnGithub")
    public void readOnGithub(String url) {
        ContextHandler.changeContext(driver, ContextUtil.NATIVE.getContext());
        WebDriverWait wait = new WebDriverWait(driver, WAIT);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement urlBar = (MobileElement) driver.findElementById("com.android.chrome:id/url_bar");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.chrome:id/url_bar")));
        Assert.assertEquals(urlBar.getText(), url);
                                                                                                                 /*   FluentWait<AppiumDriver> wait = new FluentWait<>(driver).ignoring(NoSuchElementException.class).withMessage(" Timeout exception throw, baby");
                                                                                                                        Function<AppiumDriver,MobileElement> findElement = new Function<>() {
                                                                                                                        @Override
                                                                                                                        public MobileElement apply(AppiumDriver appiumDriver) {
                                                                                                                            return (MobileElement) driver.findElementById("com.android.chrome:id/url_bar");
                                                                                                                        }
                                                                                                                    };
                                                                                                                    wait.until(findElement);*/

    }

    @Test(priority = 1)
    @Description("Webview right menu")
    @Story("Story: user can open right menu")
    @Step("Click on right menu of WebView")
    public void clickRightHambMenu() {
        ContextHandler.changeContext(driver, ContextUtil.WEB.getContext());
        webViewPage.clickRightMenuWeb();
        AllureListener.takeScreenShotAllure(driver);
    }

    @Test(dependsOnMethods = "clickRightHambMenu")
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
