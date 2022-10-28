package com.carina.allureReport;

import com.carina.base.DriverThread;
import com.carina.log.Log;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class AllureListener implements ITestListener {


    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }


    public static void takeScreenShot(AppiumDriver driver) {
        Allure.addAttachment("ScreenShot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }


    @Override
    public void onStart(ITestContext iTestContext) {
        Log.info("-----onStart method " + iTestContext.getName() + " "+ iTestContext.getAttribute("WebDriver"));

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Log.info(" onFinish - method " + iTestContext.getName());
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.info("onTestStart - method " + getTestMethodName(iTestResult) + " start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info("====== Method " + getTestMethodName(iTestResult) + " succeed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.info("-----onTestFailure - method " + getTestMethodName(iTestResult) + " failed");
        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
    }



}
