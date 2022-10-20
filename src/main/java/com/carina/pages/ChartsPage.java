package com.carina.pages;

import com.carina.base.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ChartsPage extends PageBase {

    public ChartsPage(AppiumDriver appiumDriver){
        super(appiumDriver);
    }

    @AndroidFindBy(id="ac_chart_2")
    MobileElement ac_chart_2;

    public void clickAcChart(){
        click(ac_chart_2);
    }
}
