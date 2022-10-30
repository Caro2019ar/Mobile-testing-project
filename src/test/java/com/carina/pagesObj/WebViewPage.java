package com.carina.pagesObj;

import com.carina.base.WebViewPageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebViewPage extends WebViewPageBase {


    public WebViewPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    // @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]")
    @FindBy(xpath = "//*[@id=\"rec42972268\"]")
    WebElement burgerWeb;

    public void clickRightMenuWeb() {
        clickWeb(burgerWeb);
    }


//*[@id="screenshotContainer"]/div[2]/div/div/div/div/div[40]/div
    //readongithub
    // xpath = //*[@id="nav40073764"]/div/div[3]/div/ul/li[1]/a
}
