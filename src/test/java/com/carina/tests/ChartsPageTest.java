package com.carina.tests;

import com.carina.allureReport.AllureListener;
import com.carina.base.ContextHandler;
import com.carina.base.TestBase;
import com.carina.pagesObj.ChartsPage;
import com.carina.util.ContextUtil;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
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

    @BeforeClass
    public void setUpChartsPage() {
        chartsPage = new ChartsPage(driver);
    }

    @Test
    @Description("chartsPageClick")
    @Step("chartsPageClick")
    public void chartsPageClick() throws InterruptedException {
        Thread.sleep(4000);
        ContextHandler.changeContext(driver, ContextUtil.WEB.getContext());
        chartsPage.clickAcChart();
    }

}
