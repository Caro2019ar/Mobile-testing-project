package com.carina.tests;

import com.carina.allureReport.AllureListener;
import com.carina.base.DriverFactory;
import com.carina.base.TestBase;
import com.carina.dataproviders.UIElementsDP;
import com.carina.pagesObj.LeftMenuPage;
import com.carina.pagesObj.UIElementsPage;
import io.appium.java_client.AppiumDriver;
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
    private AppiumDriver driver;
    private LeftMenuPage leftMenuPage;
    private UIElementsPage uiElementsPage;

    @BeforeClass
    public void setUpWebView() {
        driver = DriverFactory.getDriver();
        leftMenuPage = new LeftMenuPage(driver);
    }

    @Test(priority = 1)
    @Description("Go to UI Elements Page")
    @Step("click on UI Elements on LeftMenu")
    public void goToUIElements() {
        leftMenuPage.clickUIElements();
    }

/*    @Test
    public String checkCopy() {
        Log.info("CopyBtb-----" + uiElementsPage.checkCopyTrueOrFalse());
        return uiElementsPage.checkCopyTrueOrFalse();
    }*/

    @Test(dependsOnMethods = "goToUIElements", dataProviderClass = UIElementsDP.class, dataProvider = "uiElementsDP")
    @Description("Insert data")
    @Step("Insert info on first text field")
    public void insertDataInUIElements(String editText, String email, String date, Boolean copyCheck, String genderUtil) {
        uiElementsPage = new UIElementsPage(driver);
        uiElementsPage.enterName(editText);
        uiElementsPage.enterEMail(email);
        uiElementsPage.enterDate(date);
        uiElementsPage.checkCopy(copyCheck);
        uiElementsPage.scrollDown(driver, 0.8, 0.1);
        uiElementsPage.selectGender(genderUtil);

    }

    @Test(dependsOnMethods = "insertDataInUIElements")
    @Step("clickProgressBars")
    public void clickProgressBars() {
        uiElementsPage.clickProgressBar();
        uiElementsPage.clickSeekBar();

    }

    @Test(dependsOnMethods = "clickProgressBars")
    @Step("enableClick")
    public void enableClick() {
        uiElementsPage.clickEnable();
        AllureListener.takeScreenShotAllure(driver);
    }


}
