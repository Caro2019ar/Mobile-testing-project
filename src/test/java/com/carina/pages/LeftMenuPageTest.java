package com.carina.pages;

import com.carina.allureReport.AllureListener;
import com.carina.base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
@Test(dependsOnGroups = "initialize")
public class LeftMenuPageTest extends TestBase {
    private LeftMenuPage leftMenuPage;

    @BeforeClass
    public void setUpLeftMenu(){
        leftMenuPage = new LeftMenuPage(driver);
    }

    @Test
    @Description("clickOnChart")
    @Step("clickOnChart")
    public void clickOnChart(){
        leftMenuPage.clickCharts();
    }

}
