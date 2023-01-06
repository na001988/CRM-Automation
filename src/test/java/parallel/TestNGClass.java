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
		)

//build report myCustomExtent.html
@Listeners(Reporting.class)

//build report Spark.html
//this listener do not support @DataProvider with parallel=true
//@Listeners(ExtentITestListenerClassAdapter.class)

public class TestNGClass extends AbstractTestNGCucumberTests{
	
	//there is an issue while running @DataProvider=true, the actions of remotewebdriver are performed in the first instance of the browser only.
	//few options to solve this issue was performed, from maven update versions, to adding settings in pom.xml
	//but the same outcome was recorded.
	//the option is to try, another way to run parallel testing for cucumber without @DataProvider.
	
	@Override
	@DataProvider(parallel=false)
	public Object [][] scenarios(){
	return super.scenarios();
	}
	
	
}
