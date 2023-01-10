package parallel;

import app.Constants;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class Dashboard {
	

	//Cucumber hook after all
	@AfterAll
	public static void after_all() throws InterruptedException {
		System.out.println("Close WebDriver: "+Constants.browser_c+" | "+ Thread.currentThread().getId());

	}
	
	@And("I choose the {string} shorcut")
	public void i_choose_the_shorcut(String shorcut) throws Exception {
		
		try {
		
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
