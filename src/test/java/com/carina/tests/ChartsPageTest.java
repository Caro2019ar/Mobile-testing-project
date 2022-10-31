package com.carina.tests;

import com.carina.allureReport.AllureListener;
import com.carina.base.ContextHandler;
import com.carina.base.DriverFactory;
import com.carina.base.TestBase;
import com.carina.pagesObj.ChartsPage;
import com.carina.pagesObj.WebViewPage;
import com.carina.util.ContextUtil;
import com.carina.util.ScrollDownUtil;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Test(groups = {"chartspage"}, dependsOnGroups = "leftMenu")
@Listeners({AllureListener.class})
@Epic("EP001")
@Feature("Feature: Charts Page")
@Severity(SeverityLevel.CRITICAL)
public class ChartsPageTest extends TestBase {
    private AppiumDriver driver;
    private ChartsPage chartsPage;
    private WebViewPage webViewPage;

    @BeforeClass
    public void setUpWebView() {
        driver = DriverFactory.getDriver();
        webViewPage = new WebViewPage(driver);
        chartsPage = new ChartsPage(driver);
    }



    @Test
    @Description("Click on Apples")
    @Step("Click on Apples")
    public void applesOnChartsPage() throws InterruptedException {

        //---- apples:
        chartsPage.tapChart(driver, 609, 1330);
        AllureListener.takeScreenShotAllure(driver);

    }
    @Test(dependsOnMethods = "applesOnChartsPage")
    @Description("click on bananas")
    @Step(" click on bananas")
    public void showChartsPageAndBananas() throws InterruptedException {
        //---- Bananas:
        chartsPage.tapChart(driver, 376, 1421);
        AllureListener.takeScreenShotAllure(driver);

    }

    @Test(dependsOnMethods = "showChartsPageAndBananas")
    @Description("Go back to left menu")
    @Step("click on left Menu and open it")
    public void clickLeftMenu()  {
        ScrollDownUtil.scrollDown(driver, 0.8, 0.0);
        ContextHandler.changeContext(driver, ContextUtil.NATIVE.getContext());
        webViewPage.clickLeftHambMenu();
    }


}
