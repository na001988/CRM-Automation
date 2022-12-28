package parallel;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import app.Constants;
import app.Reporting;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		tags = (Constants.tags),
		features = {Constants.features},
		glue = {Constants.glue}
		//plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		//		"timeline:test-output-thread/"}
		)

//build report myCustomExtent.html
@Listeners(Reporting.class)

//build report Spark.html
//this listener do not support parallel execution with data provider. Must be a way !!!
//@Listeners(ExtentITestListenerClassAdapter.class)

public class TestNGClass extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel=true)
	public Object [][] scenarios(){
	return super.scenarios();
	}
	
}
