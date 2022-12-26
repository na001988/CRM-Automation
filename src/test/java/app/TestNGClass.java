package app;

import org.testng.annotations.Listeners;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		tags = (Constants.tags),
		features = {Constants.features},
		glue = {Constants.glue}
		)

@Listeners(ExtentITestListenerClassAdapter.class)
public class TestNGClass extends AbstractTestNGCucumberTests{

}
