package com.carina.tests;

import com.carina.allureReport.AllureListener;
import com.carina.base.ContextHandler;
import com.carina.base.TestBase;
import com.carina.pagesObj.ChartsPage;
import com.carina.pagesObj.WebViewPage;
import com.carina.util.ContextUtil;
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

    private ChartsPage chartsPage;
    private WebViewPage webViewPage;

    @BeforeClass
    public void setUpWebView() {
        webViewPage = new WebViewPage(driver);
        chartsPage = new ChartsPage(driver);
    }


    @Test
    @Description("Show charts page")
    @Step("showChartsPage")
    public void showChartsPage() throws InterruptedException {
        Thread.sleep(5000);

    }

    @Test(dependsOnMethods = "showChartsPage")
    @Description("Go back to left menu")
    @Step("click on left Menu and open it")
    public void clickLeftMenu() throws InterruptedException {
        ContextHandler.changeContext(driver, ContextUtil.NATIVE.getContext());
        webViewPage.clickLeftHambMenu();
    }


}
