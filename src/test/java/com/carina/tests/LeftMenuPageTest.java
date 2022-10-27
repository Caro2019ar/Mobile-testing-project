package com.carina.tests;

import com.carina.allureReport.AllureListener;
import com.carina.base.TestBase;
import com.carina.pagesObj.LeftMenuPage;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
@Test(groups = {"leftMenu"}, dependsOnGroups = "webview")
@Epic("EP001")
@Feature("Feature: Left Menu")
@Severity(SeverityLevel.CRITICAL)
public class LeftMenuPageTest extends TestBase {

    private LeftMenuPage leftMenuPage;

    @BeforeClass
    public void setUpLeftMenu() {
        leftMenuPage = new LeftMenuPage(driver);
    }

    @Test
    @Description("clickOnChart")
    @Step("clickOnChart")
    public void clickOnChart() {
        AllureListener.takeScreenShot(driver);
        leftMenuPage.clickCharts();
    }

}
