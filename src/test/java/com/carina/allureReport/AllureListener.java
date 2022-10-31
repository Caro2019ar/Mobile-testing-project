package com.carina.allureReport;

import com.carina.base.DriverFactory;
import com.carina.base.TestBase;
import com.carina.log.Log;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//public class AllureListener implements ITestListener {
public class AllureListener extends TestListenerAdapter {


    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }


    public static void takeScreenShotAllure(WebDriver driver) {
        byte[] screenshootBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        InputStream screenshootStream = new ByteArrayInputStream(screenshootBytes);
        Allure.addAttachment("ScreenShot", screenshootStream);
    }


    public static void takeScreenshotToFile(ITestResult iTestResult) {
        WebDriver driver= DriverFactory.getDriver();
        try {
            File imageTest = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(imageTest, new File("target/screenshots/" + iTestResult.getMethod().getMethodName() + ".png"));
            Path content = Paths.get("target/screenshots/" + iTestResult.getMethod().getMethodName() + ".png");
            InputStream inputStream = Files.newInputStream(content);
            Allure.addAttachment("ScreenShot", inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public InputStream saveScreenshot(WebDriver driver) {
        return new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }


    @Override
    public void onStart(ITestContext iTestContext) {
        Log.info("-----onStart method " + iTestContext.getName() + " " + iTestContext.getAttribute("WebDriver"));

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
        //takeScreenshotToFile(iTestResult);
        Log.info("====== Method " + getTestMethodName(iTestResult) + " succeed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        takeScreenshotToFile(iTestResult);
        Log.info("-----onTestFailure - method " + getTestMethodName(iTestResult) + " failed");
        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
    }


}
