package app;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporting implements ITestListener{

	ExtentReports report;
	static ExtentTest test;
	
	public void onStart(ITestContext context) {
		 
		System.out.println("Reports for TestNG Class > started successfully....");
		 
		 ExtentSparkReporter html = new ExtentSparkReporter("MyCustomExtent.html");
		 report = new ExtentReports();
		 report.attachReporter(html);
		 
	}	
	
	public void onTestStart(ITestResult result) {
		String t = result.getMethod().getMethodName();
		test = report.createTest(t).assignAuthor("Me").assignCategory(Constants.tags);
	}
	
	public void onTestSuccess(ITestResult result) {
		String paramName = Arrays.asList(result.getParameters()).toString();
		test.pass(paramName + " > is passed ");
	}

	
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable()+" > is failed ");
	}
	
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
