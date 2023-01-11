package Steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import drivers.Client;
import drivers.ClientWebDriver;
import drivers.ServiceChrome;
import drivers.Service;
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
		
		Service swd = new ServiceChrome();
		ClientWebDriver cl = new Client(swd);
		cl.create_Session();
		((Client) cl).setServiceWd(swd);
		
		System.out.println("#######Login");
	}

	public static WebDriver getDriver() {

		WebDriver mwd = null;
		Service swd = new ServiceChrome();
		try {
		mwd = swd.getWebDriver(); 
		}catch(Exception e) {
			System.out.println("On > WebDriver getDriver() > "+e.getMessage());
		}
		return mwd;
	}

	//Cucumber hook after all
	@AfterAll
	public static void after_all() throws InterruptedException {

		ServiceChrome swd = new ServiceChrome();
		System.out.println("@@@@@@@@Close WebDriver: "+Constants.browser_c+" | "+ Thread.currentThread().getId());
		WebDriver mwd=getDriver();
		mwd.quit();
		swd.removeWebDriver();
		
	}
	
	@And("I choose the {string} shorcut")
	public void i_choose_the_shorcut(String shorcut) throws Exception {
		
		try {
			//tmp
			getDriver().get(Constants.base_uri);
			getDriver().manage().timeouts().implicitlyWait(Constants.delay, TimeUnit.SECONDS);
			
		Thread.sleep(3000);
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
	
	
}
