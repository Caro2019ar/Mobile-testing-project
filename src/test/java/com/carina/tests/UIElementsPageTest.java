package com.carina.tests;

import com.carina.allureReport.AllureListener;
import com.carina.base.TestBase;
import com.carina.pagesObj.LeftMenuPage;
import com.carina.pagesObj.UIElementsPage;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Test(groups = {"uiElements"}, dependsOnGroups = "chartspage")
@Listeners({AllureListener.class})
@Epic("EP001")
@Feature("Feature: UI Elements")
@Severity(SeverityLevel.CRITICAL)
public class UIElementsPageTest extends TestBase {
    private LeftMenuPage leftMenuPage;
    private UIElementsPage uiElementsPage;

    @BeforeClass
    public void setUpWebView() {
        leftMenuPage = new LeftMenuPage(driver);
        uiElementsPage = new UIElementsPage(driver);
    }

    @Test
    @Description("Go to UI Elements Page")
    @Step("click on UI Elements on LeftMenu")
    public void goToUIElements() throws InterruptedException {
        leftMenuPage.clickUIElements();
    }

    @Test(dependsOnMethods = "goToUIElements")
    @Description("Insert data")
    @Step("Insert info on first text field")
    public void insertDatainUIElements() throws InterruptedException {
        uiElementsPage.enterName("John Darth");
        AllureListener.takeScreenShot(driver);
    }
}
