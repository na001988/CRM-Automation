package app;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class myReporting implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	public void onStart(ITestContext context) {
		 
		System.out.println("Reports for TestNG Class > started successfully....");
		 
		 ExtentSparkReporter html = new ExtentSparkReporter("MyCustomExtent.html");
		 report = new ExtentReports();
		 report.attachReporter(html);
		 
	}	
	
	public void onTestStart(ITestResult result) {
		
		String t = result.getName();
		test = report.createTest(t).assignAuthor("Me").assignCategory(Constants.tags);
	}
	
	public void onTestSuccess(ITestResult result) {
		
		test.pass(result.getName()+" > is passed ");
	}

	
	public void onTestFailure(ITestResult result) {
		test.fail(result.getName()+" > is failed ");
		test.log(Status.FAIL, "Info related to failure");
		test.warning("Custom warning");
	}
	
	public void onFinish(ITestContext context) {
		report.flush();
	}
}
