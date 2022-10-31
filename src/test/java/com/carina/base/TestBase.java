package com.carina.base;

import org.testng.annotations.AfterTest;

public class TestBase {
    @AfterTest
    public void teardown() {
        DriverFactory.killDriver();
    }



}
