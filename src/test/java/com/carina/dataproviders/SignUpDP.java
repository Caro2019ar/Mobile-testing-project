package com.carina.dataproviders;

import org.testng.annotations.DataProvider;

public class SignUpDP {

    @DataProvider
    public static Object[][] signUpData() {
        Object[][] data = new Object[1][3];

        data[0][0] = "Cristian";
        data[0][1] = "123456";
        data[0][2] = "male";
        return data;
    }

}
