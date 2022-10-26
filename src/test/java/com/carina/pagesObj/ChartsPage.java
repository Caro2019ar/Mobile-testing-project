package com.carina.pagesObj;

import com.carina.base.WebViewPageBase;
import io.appium.java_client.AppiumDriver;

public class ChartsPage extends WebViewPageBase {

    public ChartsPage(AppiumDriver driver) {
        super(driver);
    }

    //@FindBy(xpath = "*//*[@text='venn chart']")
//    @FindBy(xpath = "//*[contains(@text,'venn chart')]")
//    @FindBy(id = "ac_chart_2")
/*
    @FindAll({
            @FindBy(id = "ac_chart_2")
    })
    List<WebElement> ac_chart_2;
*/
/*
    @FindAll({
            @FindBy(id = "ac_chart_2")
    })
    List<MobileElement> ac_chart_2;
*/


    public void waitVisibilityChart() {

    }

    public void clickAcChart() {

    }
}
