package app;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporting implements ITestListener{

	ExtentReports report;
	static ExtentTest test;
	ProcessWithExcel re = new ProcessWithExcel();
	Map<String, Object[]> testData = new TreeMap<String, Object[]>();
	LocalDate myObj = LocalDate.now();
	
	public void onStart(ITestContext context) {
		 
		System.out.println("Reports for TestNG Class > started successfully....");
		 
		 ExtentSparkReporter html = new ExtentSparkReporter("MyCustomExtent.html");
		 report = new ExtentReports();
		 report.attachReporter(html);
		 
	}	
	
	public void onTestStart(ITestResult result) {
		String t = result.getMethod().getMethodName();
		test = report.createTest(t).assignAuthor("Manual Test Analyst").assignCategory(Constants.tags);
	}
	
	public void onTestSuccess(ITestResult result) {
		String paramName = Arrays.asList(result.getParameters()).toString();
		String d2 = result.getName();
		String d1 = myObj.toString();
		test.pass("Scenario: " +paramName + " > is passed ");

		try {
			re.run(paramName, d1, d2);
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("@@@@@@ Error onTestSuccess");
			e.printStackTrace();
		}
		
	}

	
	public void onTestFailure(ITestResult result) {
		
		String paramName = Arrays.asList(result.getParameters()).toString();
		String error = result.getThrowable().getMessage();
		String d1 = myObj.toString();
		
		test.fail(paramName+" > is failed ");
		
		try {
			re.run(paramName, d1, error.substring(0,40));
		} catch (InvalidFormatException | IOException e) {
			System.out.println("@@@@@@ Error | onTestFailure | ProcessWithExcel.java");
			e.printStackTrace();
		}
		
	}
	
	public void onFinish(ITestContext context) {
		report.flush();
	}

}