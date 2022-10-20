package com.carina.pages;


import com.carina.base.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.annotations.Test;

public class InitialPage extends PageBase {
    public InitialPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "next_button")
    MobileElement nextBtn;

    public void clickNextBtn() {
        click(nextBtn);
    }
}
