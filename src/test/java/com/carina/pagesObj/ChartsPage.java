package com.carina.pagesObj;

import com.carina.base.WebViewPageBase;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChartsPage extends WebViewPageBase {

    public ChartsPage(AppiumDriver driver){
        super(driver);
    }

    @FindBy(id="ac_chart_2")
    WebElement ac_chart_2;

    public void clickAcChart(){
        clickWeb(ac_chart_2);
    }
}
