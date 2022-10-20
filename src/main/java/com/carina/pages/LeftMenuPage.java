package com.carina.pages;

import com.carina.base.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LeftMenuPage extends PageBase {

    public LeftMenuPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

  /*  @AndroidFindBy(id = "design_menu_item_text")
    MobileElement designMenu;*/

    @AndroidFindBy(xpath ="//android.widget.CheckedTextView[@text='Charts']")
    MobileElement chartsBtn;


    public void clickCharts() {
        click(chartsBtn);
    }


}
