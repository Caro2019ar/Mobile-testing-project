package com.carina.pagesObj;

import com.carina.base.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LeftMenuPage extends PageBase {

    public LeftMenuPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Lorem ipsum']")
    MobileElement profileLorem;


    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Charts']")
    MobileElement chartsBtn;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Map']")
    MobileElement mapBtn;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='UI elements']")
    MobileElement uiBtn;

    public void clickCharts() {
        click(chartsBtn);
    }
    public void clickMap() {
        click(mapBtn);
    }
    public void clickUIElements() {
        click(uiBtn);
    }

    public void waitProfile() {
        waitForVisibility(profileLorem);
    }


}
