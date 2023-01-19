package Steps;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import drivers.ServiceChrome;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.Constants;
import utils.Setup;


public class Dashboard {
	
	Setup setup = new Setup(getDriver());

	//Cucumber hook before all
	@BeforeAll
	public static void before_all() throws Exception  {
		getDriver();
	}

	public static WebDriver getDriver() {
		return Setup.ManageDriver(Constants.browser_c);
	}

	//Cucumber hook after all
	@AfterAll
	public static void after_all() throws InterruptedException {
		ServiceChrome swd = new ServiceChrome();
		System.out.println("@@@@@@@@Close WebDriver: "+Constants.browser_c+" | "+ Thread.currentThread().getId());
		getDriver().quit();
		swd.removeWebDriver();
	}
	
	@And("I choose the {string} shorcut")
	public void i_choose_the_shorcut(String shorcut) throws Exception {
		try {
			getDriver().manage().timeouts().implicitlyWait(Constants.delay, TimeUnit.SECONDS);
			getDriver().get(Constants.base_uri+shorcut+".php");
		}catch(Exception e) {
			throw new Exception("Falied-Step: "+"i_choose_the_shorcut");
		}
	}

	@And("I fill the form with required information")
	public void i_fill_the_form_with_required_information() {
	    
	}
	@And("I {string} the form")
	public void i_the_form(String string) {
	    
	}
	@Then("I can see the new {string} is created in the system under test.")
	public void i_can_see_the_new_is_created_in_the_system_under_test(String string) {
	   
	}
	
	@Then("I can read the fist post")
	public void i_can_read_the_fist_post() {

	}	

	@Then("I can enter a question in the form")
	public void i_can_enter_a_question_in_the_form() {
	}

	@Then("I can read the posts in the page")
	public void i_can_read_the_posts_in_the_page() {
	}

}
