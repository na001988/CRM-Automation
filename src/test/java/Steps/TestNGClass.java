package Steps;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.Constants;
import utils.Reporting;

@CucumberOptions(
		tags = (Constants.tags),
		features = {Constants.features},
		glue = {Constants.glue}
		)

//build report myCustomExtent.html
@Listeners(Reporting.class)

//build report Spark.html (to-do)
//this listener do not support @DataProvider with parallel=true
//error: the return value of "java.lang.ThreadLocal.get()" is null
//@Listeners(ExtentITestListenerClassAdapter.class)

public class TestNGClass extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel=false)
	public Object [][] scenarios(){
	return super.scenarios();
	}
	
	
}
