package com.carina.pages;

import com.carina.base.ContextHandler;
import com.carina.base.TestBase;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChartsPageTest extends TestBase {
    private ChartsPage chartsPage;
    AndroidDriver androidDriver;

    @BeforeClass
    public void setUpChartsPage(){
        chartsPage = new ChartsPage(driver);

    }

    @Test
    public void chartsPageClick(){
        ContextHandler.changeContext(driver);
        chartsPage.clickAcChart();
    }
}
