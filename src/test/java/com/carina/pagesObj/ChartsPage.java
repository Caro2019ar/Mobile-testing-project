package com.carina.pagesObj;

import com.carina.base.WebViewPageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

public class ChartsPage extends WebViewPageBase {

    public ChartsPage(AppiumDriver driver) {
        super(driver);
    }


    public void waitVisibilityChart() {

    }

    public void tapChart(AppiumDriver driver, int x, int y) throws InterruptedException {
        Thread.sleep(3000);
        TouchAction touchAction = new TouchAction<>(driver);
        touchAction.tap(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).perform();
    }
}
