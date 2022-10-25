package com.carina.pagesObj;


import com.carina.base.DriverFactory;
import com.carina.base.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class InitialPage extends PageBase {


    public InitialPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "next_button")
    MobileElement nextBtn;

    public void clickNextBtn() {
        click(nextBtn);
    }


}
