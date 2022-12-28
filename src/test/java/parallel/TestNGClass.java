package parallel;

import org.testng.annotations.DataProvider;
import app.Constants;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		tags = (Constants.tags),
		features = {Constants.features},
		glue = {Constants.glue}
		)

//@Listeners(ExtentITestListenerClassAdapter.class)
public class TestNGClass extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel=true)
	public Object [][] scenarios(){
	return super.scenarios();
	}

}
