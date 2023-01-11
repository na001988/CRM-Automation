package Steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import drivers.ClientChrome;
import drivers.ClientWebDriver;
import drivers.ServiceChrome;
import drivers.ServiceWebDriver;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.Constants;
import utils.Setup;
import utils.Setup.LocatorType;
import utils.Setup.WebDriverAction;

public class Login {
	
	
	Setup setup = new Setup(getDriver());

	//Cucumber hook before all
	@BeforeAll
	public static void before_all() throws Exception  {
		
		ServiceWebDriver swd = new ServiceChrome();
		ClientWebDriver cl = new ClientChrome(swd);
		cl.create_Session();
		((ClientChrome) cl).setServiceWd(swd);
		
		System.out.println("#######Login");
	}

	public static WebDriver getDriver() {

		WebDriver mwd = null;
		ServiceWebDriver swd = new ServiceChrome();
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
	
	@Given("I enter a user_name and a password")
	public void i_enter_a_user_name_and_a_password() throws Exception {
		System.out.println("A: I enter a user_name and a password");
		getDriver().get(Constants.base_uri);
		getDriver().manage().timeouts().implicitlyWait(Constants.delay, TimeUnit.SECONDS);
		try {
		
			//call dynamic function to find WebElements and perform actions 
		setup.find_do("//button[@class='nav-login btn btn-outline-dark']", "", WebDriverAction.CLICK, LocatorType.XPATH);
		setup.find_do("l_username", Constants.user, WebDriverAction.SETTEXT, LocatorType.ID);
		setup.find_do("t_l_password", Constants.pass, WebDriverAction.SETTEXT, LocatorType.ID);
		}catch(Exception e) {
			throw new Exception("Falied-Step: "+"i_enter_a_user_name_and_a_password()");
		}
	}
	
	@And("press the login_button")
	public void press_the_login_button() throws Exception {
		System.out.println("B: press the login_button");
		try {
		getDriver().manage().timeouts().implicitlyWait(Constants.delay, TimeUnit.SECONDS);
		//s.find_do("login_button", "", WebDriverAction.CLICK, LocatorType.ID);
		}catch(Exception e) {
			throw new Exception("Falied-Step: "+"press_the_login_button()");
		}
	}
	
	@Then("I can see the main page of the system")
	public void i_can_see_the_main_page_of_the_system() throws Exception {
		getDriver().manage().timeouts().implicitlyWait(Constants.delay, TimeUnit.SECONDS);

		//if(wd.getTitle().contains("Dashboard")) {
		//	System.out.println("C: I can see the main page of the system: "+wd.getTitle());
		//}else {
		//	throw new Exception("Falied-Step: "+"i_can_see_the_main_page_of_the_system()");
		//}
	
	}
	
}