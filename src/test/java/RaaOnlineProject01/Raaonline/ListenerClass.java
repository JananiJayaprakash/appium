package RaaOnlineProject01.Raaonline;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;

public class ListenerClass extends BaseClass implements ITestListener {
	ExtentTest test;
	static ExtentReports extent = ExtendReportRaaonline.getRepoterObject();

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		System.out.println("Test Started: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
		System.out.println("Test Passed: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if (test == null) {
			test = extent.createTest(result.getMethod().getMethodName());
		}
		test.fail(result.getThrowable());
		try {
			driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(), driver), null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Test Failed: " + result.getName());
	}

//	@Override
//	public void onTestFailure(ITestResult result) {
//		test.fail(result.getThrowable());
//
//		try {
//			String screenshotPath = getScreenshotPath(result.getMethod().getMethodName(), driver);
//			test.addScreenCaptureFromPath(screenshotPath, "Failed Test Screenshot");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		System.out.println("Test Failed: " + result.getName());
//	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped: " + result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Execution Started");
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		System.out.println("Test Execution Finished");
	}
}
