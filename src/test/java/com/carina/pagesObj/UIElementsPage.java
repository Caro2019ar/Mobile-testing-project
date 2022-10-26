package com.carina.pagesObj;

import com.carina.base.WebViewPageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class UIElementsPage extends WebViewPageBase {


    public UIElementsPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "imageView")
    MobileElement picProfile;
    @AndroidFindBy(id = "textView")
    MobileElement loremText;
    @AndroidFindBy(id = "textView2")
    MobileElement dolorText;

    @AndroidFindBy(id = "editText")
    MobileElement editText;

    @AndroidFindBy(id = "editText2")
    MobileElement email;

    @AndroidFindBy(id = "editText3")
    MobileElement date;

    @AndroidFindBy(id = "checkBox2")
    MobileElement copyCheck;

    @AndroidFindBy(id = "radioBUtton")
    MobileElement maleRadio;
    @AndroidFindBy(id = "radioBUtton3")
    MobileElement femaleRadio;
    @AndroidFindBy(id = "radioBUtton5")
    MobileElement otherRadio;

    @AndroidFindBy(id = "progressBar")
    MobileElement roundBar;
    @AndroidFindBy(id = "progressBar2")
    MobileElement lineBar;
    @AndroidFindBy(id = "seekBar")
    MobileElement pointBar;

    @AndroidFindBy(id = "switch1")
    MobileElement enableBtn;


    public void enterName(String nameTxt) {
        clear(editText);
        sendText(editText, nameTxt);
    }
}
