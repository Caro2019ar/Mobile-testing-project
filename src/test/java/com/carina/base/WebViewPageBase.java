package com.carina.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebViewPageBase extends PageBase {
    public static final long WAIT = 10;

    public WebViewPageBase(AppiumDriver appiumDriver) {
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

    public void waitToolbar() {
        waitForVisibility(toolbar);
    }


    public void waitForVisibilityWeb(String xpathString) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT);
        By by = By.xpath(xpathString);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void waitForVisibilityWeb(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickWeb(WebElement element) {
        waitForVisibilityWeb(element);
        element.click();
    }

}
