package com.carina.pages;


import com.carina.allureReport.AllureListener;
import com.carina.base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
@Epic("EP001")
@Feature("Feature: WebView Hybrid page")
@Severity(SeverityLevel.CRITICAL)
public class WebViewTest extends TestBase {
    private WebViewPage webViewPage;
    private LeftMenuPage leftMenuPage;

    @BeforeClass
    public void setUpWebView() {
        webViewPage = new WebViewPage(driver);
        leftMenuPage = new LeftMenuPage(driver);
    }

    @Test
    public void openLeftMenu() {
        webViewPage.clickLeftHambMenu();
        leftMenuPage.waitProfile();
        Assert.assertEquals(driver.findElement(By.xpath("//android.widget.TextView[@text='Lorem ipsum']")).getText(), "Lorem ipsum");
    }

/*    @Test
    @Description("Webview right menu")
    @Story("Story: user can open right menu")
    @Step("Click on right menu of WebView")
    public void clickRightHambMenu() {
        ContextHandler.changeContext(driver);
        webViewPage.clickRightMenuWeb();
    }*/

}
