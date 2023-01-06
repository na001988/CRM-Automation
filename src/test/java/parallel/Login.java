package parallel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import app.Constants;
import app.Setup;
import app.Setup.LocatorType;
import app.Setup.WebDriverAction;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class Login {
	static WebDriver wd;
	static Setup s = new Setup(wd);
	
	//Cucumber hook before all
	@Before
	public static void before_all() throws Exception  {
		wd =  s.run(Constants.browser_c);
		System.out.println("#######Login > "+wd.hashCode());
	}
	
	//Cucumber hook after all
	@AfterAll
	public static void after_all() throws InterruptedException {
		System.out.println("Close WebDriver: "+Constants.browser_c+" | "+ Thread.currentThread().getId());
			wd.quit();
	}
	
	@Given("I enter a user_name and a password")
	public void i_enter_a_user_name_and_a_password() throws Exception {
		System.out.println("A: I enter a user_name and a password");
		wd.get(Constants.base_uri); 
		wd.manage().timeouts().implicitlyWait(Constants.delay, TimeUnit.SECONDS);
		try {
		s.find_do("login_user", Constants.user, WebDriverAction.SETTEXT, LocatorType.ID);
		s.find_do("login_pass", Constants.pass, WebDriverAction.SETTEXT, LocatorType.ID);
		}catch(Exception e) {
			throw new Exception("Falied-Step: "+"i_enter_a_user_name_and_a_password()");
		}
	}
	
	@And("press the login_button")
	public void press_the_login_button() throws Exception {
		System.out.println("B: press the login_button");
		try {
		s.find_do("login_button", "", WebDriverAction.CLICK, LocatorType.ID);
		wd.manage().timeouts().implicitlyWait(Constants.delay, TimeUnit.SECONDS);
		}catch(Exception e) {
			throw new Exception("Falied-Step: "+"press_the_login_button()");
		}
	}
	
	@Then("I can see the main page of the system")
	public void i_can_see_the_main_page_of_the_system() throws Exception {
		wd.manage().timeouts().implicitlyWait(Constants.delay, TimeUnit.SECONDS);
		//add a fluent wait to remove the sleep
		Thread.sleep(1500);
		if(wd.getTitle().contains("Dashboard")) {
			System.out.println("C: I can see the main page of the system: "+wd.getTitle());
		}else {
			throw new Exception("Falied-Step: "+"i_can_see_the_main_page_of_the_system()");
		}
	
	}
	
}
