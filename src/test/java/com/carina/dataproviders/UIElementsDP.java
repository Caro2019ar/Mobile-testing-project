package com.carina.dataproviders;

import org.testng.annotations.DataProvider;

public class UIElementsDP {
    @DataProvider
    public static Object[][] uiElementsDP() {
        Object[][] data = new Object[1][5];

        data[0][0] = "Carolina D'Arc";
        data[0][1] = "joana@gmail.com";
        data[0][2] = "02/02/2022";
        data[0][3] = true;
        data[0][4] = "Female";
        return data;
    }
}
