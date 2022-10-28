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
       // iTestContext.setAttribute("AppiumDriver", TestBase.getDriver());
       // Log.info("-----TestBase.getDriver() " +TestBase.getDriver());
//        iTestContext.setAttribute("WebDriver", DriverThread.getTLDriver());
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
       // Log.info("==========TestBase.getDriver()"+TestBase.getDriver());//nao sai essa linha no log
        //Allure.addAttachment("ScreenShot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        //Allure.addAttachment("screenShot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Log.info("====== Method " + getTestMethodName(iTestResult) + " succeed");
        //checkDriverAndtakeScreenShot(iTestResult);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.info("-----onTestFailure - method " + getTestMethodName(iTestResult) + " failed");
        //checkDriverAndtakeScreenShot(iTestResult);
        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
    }

    private void checkDriverAndtakeScreenShot(ITestResult iTestResult) {
        AppiumDriver driver = DriverThread.getTLDriver();
        Object testClass = iTestResult.getInstance();
        if (driver != null) {
            Log.info("Screenshot captured for test case:" + getTestMethodName(iTestResult));
            takeScreenShot(driver);
        }
    }


}
