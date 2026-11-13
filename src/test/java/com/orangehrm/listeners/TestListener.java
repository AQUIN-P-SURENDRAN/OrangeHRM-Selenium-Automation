

package com.orangehrm.listeners;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.orangehrm.base.orangebase;

public class TestListener implements ITestListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    // Initialize HTML report
    private static ExtentReports getReporter() {

        if (extent == null) {

            String reportPath = System.getProperty("user.dir")
                    + "/reports/OrangeHRM_Report.html";

            File reportFolder = new File(
                    System.getProperty("user.dir") + "/reports");

            if (!reportFolder.exists()) {
                reportFolder.mkdirs();
            }

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(reportPath);

            spark.config().setDocumentTitle("OrangeHRM Automation Report");
            spark.config().setReportName("OrangeHRM Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Project", "OrangeHRM Automation");
            extent.setSystemInfo("Automation Tool", "Selenium WebDriver");
            extent.setSystemInfo("Testing Framework", "TestNG");
            extent.setSystemInfo("Language", "Java");
        }

        return extent;
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest = getReporter().createTest(
                result.getMethod().getMethodName());

        test.set(extentTest);

        test.get().log(Status.INFO, "Test execution started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().log(Status.PASS, "Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().log(Status.FAIL, "Test Failed");

        if (result.getThrowable() != null) {
            test.get().fail(result.getThrowable());
        }

        WebDriver driver = orangebase.driver;

        if (driver == null) {
            test.get().warning("Screenshot not captured: WebDriver is null.");
            return;
        }

        try {

            // Create screenshots folder
            File screenshotFolder = new File(
                    System.getProperty("user.dir") + "/screenshots");

            if (!screenshotFolder.exists()) {
                screenshotFolder.mkdirs();
            }

            // Generate unique screenshot filename
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                    .format(new Date());

            String fileName = result.getName() + "_" + timestamp + ".png";

            // Capture screenshot
            File source = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            File destination = new File(screenshotFolder, fileName);

            Files.copy(source.toPath(), destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

            // Attach screenshot to HTML report
            test.get().addScreenCaptureFromPath(
                    destination.getAbsolutePath());

            result.setAttribute("screenshotPath",
                    destination.getAbsolutePath());

            System.out.println("Failure screenshot saved: "
                    + destination.getAbsolutePath());

        } catch (Exception e) {

            test.get().warning("Unable to capture screenshot: "
                    + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().log(Status.SKIP, "Test Skipped");

        if (result.getThrowable() != null) {
            test.get().skip(result.getThrowable());
        }

    }

    @Override
    public void onFinish(
            org.testng.ITestContext context) {

        if (extent != null) {

            extent.flush();

            System.out.println("Extent HTML Report generated successfully!");
        }
    }
}
