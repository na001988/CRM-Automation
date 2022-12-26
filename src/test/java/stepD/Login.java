package stepD;

import org.openqa.selenium.WebDriver;

import app.handleWebDriver;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Login {
	
	static WebDriver wd;
	static handleWebDriver hwd;
	
	//Cucumber hook before all
	@BeforeAll
	public static void before_all() {
		System.out.println("Start WebDriver");
		hwd = new handleWebDriver();
		wd = hwd.getWebDriver(wd);
	}
	
	//Cucumber hook after all
	@AfterAll
	public static void after_all() {
		System.out.println("Close WebDriver");
		wd.quit();
	}
	
	@Given("I enter a user_name and a password")
	public void i_enter_a_user_name_and_a_password() {
		System.out.println("A");
	}
	
	@Given("press the login_button")
	public void press_the_login_button() {
		System.out.println("B");
	}
	
	@Then("I can see the main page of the system")
	public void i_can_see_the_main_page_of_the_system() {
		System.out.println("C");
	}
	
	

}
