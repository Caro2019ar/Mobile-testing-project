package com.carina;

import com.carina.base.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WebViewPage extends PageBase {
    public WebViewPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(accessibility = "Navigate up")
    MobileElement leftHambMenu;

    @AndroidFindBy(id = "toolbar")
    MobileElement toolbar;

  /*  @AndroidFindBy(id = "design_menu_item_text")
    MobileElement designMenu;*/


    @AndroidFindBy(xpath ="//android.widget.CheckedTextView[@text='Charts']")
    MobileElement chartsBtn;

    @AndroidFindBy(id = "image_view")
    MobileElement imageView;


    public void clickImageView() {
        click(imageView);
    }

    public void clickCharts() {
        click(chartsBtn);
    }

    public void clickLeftHambMenu() {
        click(leftHambMenu);
    }

}
