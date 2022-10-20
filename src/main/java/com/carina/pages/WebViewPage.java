package com.carina.pages;

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
    @AndroidFindBy(id = "image_view")
    MobileElement imageView;

    public void clickImageView() {
        click(imageView);
    }
    public void clickLeftHambMenu() {
        click(leftHambMenu);
    }
    public void waitToolbar(){
        waitForVisibility(toolbar);
    }

}
