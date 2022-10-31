package com.carina.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class ScrollDownUtil {
    public static void scrollDown(AppiumDriver driver,double start, double end) {
        Dimension dimension = driver.manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * start);
        int scrollEnd = (int) (dimension.getHeight() * end);
        AndroidTouchAction actions = new AndroidTouchAction(driver)
                .press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(0, scrollEnd)).release().perform();
    }
}
