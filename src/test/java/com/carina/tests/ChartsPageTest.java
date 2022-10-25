package com.carina.tests;

import com.carina.allureReport.AllureListener;
import com.carina.base.ContextHandler;
import com.carina.base.TestBase;
import com.carina.pagesObj.ChartsPage;
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
    public void chartsPageClick() {
        ContextHandler.changeContext(driver);
        chartsPage.clickAcChart();
        Assert.assertTrue(driver.findElement(By.id("ac_chart_2")).isDisplayed());
    }
}
