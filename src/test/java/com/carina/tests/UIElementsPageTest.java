package com.carina.tests;

import com.carina.allureReport.AllureListener;
import com.carina.base.TestBase;
import com.carina.dataproviders.UIElementsDP;
import com.carina.pagesObj.LeftMenuPage;
import com.carina.pagesObj.UIElementsPage;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.*;
import org.openqa.selenium.Dimension;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;


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
        scrollDown();
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
//        AllureListener.takeScreenShotAllure(driver);
    }

    private void scrollDown() {
        Dimension dimension = driver.manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.8);
        int scrollEnd = (int) (dimension.getHeight() * 0.1);
        AndroidTouchAction actions = new AndroidTouchAction(driver)
                .press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(0, scrollEnd)).release().perform();
    }

}
