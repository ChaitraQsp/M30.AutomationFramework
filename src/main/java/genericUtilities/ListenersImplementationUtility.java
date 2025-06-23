package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener interface of testNG
 * 
 * @author Chaitra M
 *
 */
public class ListenersImplementationUtility implements ITestListener {

	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {

		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + " - Test Execution Started");

		// Create test for Extent reports
		test = report.createTest(methodname);

	}

	public void onTestSuccess(ITestResult result) {

		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + " - Test is PASS");

		// log the status of test to extent reports
		test.log(Status.PASS, methodname + " - Test is PASS");

	}

	public void onTestFailure(ITestResult result) {

		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + " - Test is FAIL");

		// log the status of test to extent reports
		test.log(Status.FAIL, methodname + " - Test is FAIL");

		// Capture the exception
		System.out.println(result.getThrowable());

		// log the exception in extent reports
		test.log(Status.WARNING, result.getThrowable());

		// capture screenshot
		SeleniumUtility s = new SeleniumUtility();
		JavaUtility j = new JavaUtility();

		// configure screenshot name
		String screenshotname = methodname + "-" + j.getSystemDate();

		try {
			
			String path = s.captureScreenshot(BaseClass.sdriver, screenshotname);
			
			//Attach screenshot to extent report
			test.addScreenCaptureFromPath(path, methodname);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + " - Test is SKIP");

		// log the status of test to extent reports
		test.log(Status.SKIP, methodname + " - Test is SKIP");

		// Capture the exception
		System.out.println(result.getThrowable());

		// log the exception in extent reports
		test.log(Status.WARNING, result.getThrowable());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

		System.out.println("Suite execution started");

		// Basic configuration of Extent Report
		ExtentSparkReporter esr = new ExtentSparkReporter(
				".\\ExtentReports\\Report-" + new JavaUtility().getSystemDate() + ".html");
		esr.config().setDocumentTitle("Swag labs Automation execution report");
		esr.config().setReportName("Swag Labs execution report");
		esr.config().setTheme(Theme.DARK);

		// Configure Extent reports
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Microsoft edge");
		report.setSystemInfo("Base platform", "Windows");
		report.setSystemInfo("Base Env", "Testing");
		report.setSystemInfo("Base URL", "Test URL");
		report.setSystemInfo("Reporter name", "Chaitra");

	}

	public void onFinish(ITestContext context) {

		System.out.println("Suite execution Finished");

		// Generate Extent report
		report.flush();
	}

}
