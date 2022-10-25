package com.carina.pages;

import com.carina.allureReport.AllureListener;
import com.carina.base.ContextHandler;
import com.carina.base.TestBase;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
@Test(dependsOnGroups = "initialize")
public class ChartsPageTest extends TestBase {
    private ChartsPage chartsPage;

    @BeforeClass
    public void setUpChartsPage(){
        chartsPage = new ChartsPage(driver);
    }

    @Test
    @Description("chartsPageClick")
    @Step("chartsPageClick")
    public void chartsPageClick(){
        ContextHandler.changeContext(driver);
        chartsPage.clickAcChart();
        Assert.assertTrue(driver.findElement(By.id("ac_chart_2")).isDisplayed());
    }
}
