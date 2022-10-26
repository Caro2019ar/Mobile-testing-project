package com.carina.pagesObj;

import com.carina.base.WebViewPageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChartsPage extends WebViewPageBase {

    public ChartsPage(AppiumDriver driver) {
        super(driver);
    }

    //@FindBy(xpath = "*//*[@text='venn chart']")
//    @FindBy(xpath = "//*[contains(@text,'venn chart')]")
    @FindBy(id = "ac_chart_2")
    WebElement ac_chart_2;

    public void clickAcChart() {
        clickWeb(ac_chart_2);
    }
}
