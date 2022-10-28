package com.carina.pagesObj;


import com.carina.base.WebViewPageBase;
import com.carina.log.Log;
import com.carina.util.GenderUtil;
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

    @AndroidFindBy(id = "radioButton")
    MobileElement maleRadio;
    @AndroidFindBy(id = "radioButton3")
    MobileElement femaleRadio;
    @AndroidFindBy(id = "radioButton5")
    MobileElement otherRadio;

    @AndroidFindBy(id = "progressBar")
    MobileElement roundBar;
    @AndroidFindBy(id = "progressBar2")
    MobileElement lineBar;
    @AndroidFindBy(id = "seekBar")
    MobileElement pointSeekBar;

    @AndroidFindBy(id = "switch1")
    MobileElement enableBtn;


    public void enterName(String nameTxt) {
        clear(editText);
        sendText(editText, nameTxt);
    }

    public void enterEMail(String emailTxt) {
        clear(email);
        sendText(email, emailTxt);
    }

    public void enterDate(String dateTxt) {
        clear(date);
        sendText(date, dateTxt);
    }

    public void checkCopy(Boolean checkOrNot) {
        if (checkOrNot) {
            click(copyCheck);
        }
    }

    public void selectGender(String gender) {
        if (gender.equals(GenderUtil.MALE.getGender())) {
            click(maleRadio);
        } else if (gender.equals(GenderUtil.FEMALE.getGender())) {
            click(femaleRadio);
        } else if (gender.equals(GenderUtil.OTHER.getGender())) {
            click(otherRadio);
        } else {
            Log.error("Gender not found.");
            //throw new Exception;
        }

    }

    public void clickProgressBar() {
        click(lineBar);
    }

    public void clickSeekBar() {
        click(pointSeekBar);
    }

    public void clickEnable() {
        click(enableBtn);
    }


}
