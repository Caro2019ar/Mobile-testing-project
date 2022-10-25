package com.carina.pages;

import com.carina.base.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LeftMenuPageTest extends TestBase {
    private LeftMenuPage leftMenuPage;

    @BeforeClass
    public void setUpLeftMenu(){
        leftMenuPage = new LeftMenuPage(driver);
    }

    @Test
    public void clickOnChart(){
        leftMenuPage.clickCharts();
    }

}
