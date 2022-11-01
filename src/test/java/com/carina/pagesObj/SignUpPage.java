package com.carina.pagesObj;


import com.carina.base.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SignUpPage extends PageBase {
    public SignUpPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "backButton")
    MobileElement backButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CARINA']")
    MobileElement carinaText;


    @AndroidFindBy(id = "name")
    MobileElement nameSignUp;

    @AndroidFindBy(id = "password")
    MobileElement password;
    @AndroidFindBy(id = "radio_male")
    MobileElement radioMale;
    @AndroidFindBy(id = "radio_female")
    MobileElement radioFemale;
    @AndroidFindBy(id = "checkbox")
    MobileElement agreeCheck;

    @AndroidFindBy(xpath = "//android.widget.Switch[@text='I agree to the Privacy Policy OFF']")
    MobileElement agreeTextOFF;

    @AndroidFindBy(id = "login_button")
    MobileElement signUpBtn;

    @AndroidFindBy(id = "loginForm")
    MobileElement loginForm;

    public void enterName(String nameTxt) {
        clear(nameSignUp);
        sendText(nameSignUp, nameTxt);
    }

    public void enterPassword(String passwordTxt) {
        clear(password);
        sendText(password, passwordTxt);
    }

    public void clickMale() {
        click(radioMale);
    }

    public void clickFemale() {
        click(radioFemale);
    }

    public void clickGender(String gender) {
        if (gender.contains("female")) {
            click(radioFemale);
        } else {
            click(radioMale);
        }
    }

    public void clickCheckBtn() {
        click(agreeCheck);
    }

    public void clickSignBtn() {
        click(signUpBtn);
    }

    public void waitLoginForm() {
        waitForVisibility(loginForm);
    }

    public void clickBackBtn() {
        click(backButton);
    }

    public void waitCarinaText() {
        waitForVisibility(carinaText);
    }

    public void visibleAgreeTextOFF() {
        waitForVisibility(agreeTextOFF);
    }
}
