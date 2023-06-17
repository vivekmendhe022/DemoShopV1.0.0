package com.generic.utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListneresImplementation implements ITestListener {

	ExtentReports reports;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " ===== Test Execution Start =====");

		test = reports.createTest(methodName);
		test.log(Status.INFO, methodName + " ***** Execution Started *****");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " ===== Test Execution Success =====");
		test.log(Status.PASS, methodName + " ***** Script Passed *****");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " ===== Test Execution Failed =====");
		test.log(Status.FAIL, methodName + " ***** Script Failed *****");
		test.log(Status.WARNING, result.getThrowable());

		// Take ScreenShot
		String scr = methodName + "-" + new JavaUtility().getSystemDateinFormate();
		WebDriverUtility wutil = new WebDriverUtility();
		try {
			String path = wutil.takeScreenShot(BaseClass.SDriver, scr);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " ===== Test Execution Skipped =====");
		test.log(Status.SKIP, methodName + " ***** Skipped ******");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("===== Execution Start =====");
		String path = ".\\ExtentReport\\Report-" + new JavaUtility().getSystemDateinFormate() + ".html";
		ExtentSparkReporter html = new ExtentSparkReporter(path);
		html.config().setDocumentTitle("DemoWebShop Extent Report");
		html.config().setReportName("Execution Report V1.0.0");
		html.config().setTheme(Theme.DARK);

		reports = new ExtentReports();
		reports.attachReporter(html);
		reports.setSystemInfo("Base Browser", "FireFox: gecko Driver");
		reports.setSystemInfo("BaseUrl", "https://demowebshop.tricentis.com/");
		reports.setSystemInfo("BasePlatform", "Windows 11");
		reports.setSystemInfo("Reporter Name", "Vivek");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("===== Execution Finish =====");
		reports.flush(); // responsible for report generation.
	}

}
