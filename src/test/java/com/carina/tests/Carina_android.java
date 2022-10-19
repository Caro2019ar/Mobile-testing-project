package com.carina.tests;


import com.carina.base.TestBase;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Carina_android extends TestBase {


    @Test
    public void test_carina() throws MalformedURLException {
        android_setUp();
        tearDown();
    }

}
