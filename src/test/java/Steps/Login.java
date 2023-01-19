package Steps;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import drivers.ServiceChrome;
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
		try {
		getDriver().quit();
		swd.removeWebDriver();
		}catch(Exception e) {
			System.out.println("@@@@@@@@Issue while Closing WebDriver");
		}
	}
	
	@Given("I enter a user_name and a password")
	public void i_enter_a_user_name_and_a_password() throws Exception {
		System.out.println("A: I enter a user_name and a password");
		getDriver().get(Constants.base_uri);

		try {
			getDriver().manage().timeouts().implicitlyWait(Constants.delay, TimeUnit.SECONDS);
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
		setup.find_do("login_btn", "", WebDriverAction.CLICK, LocatorType.ID);
		}catch(Exception e) {
			throw new Exception("Falied-Step: "+"press_the_login_button()");
		}
	}
	
	@Then("I can see the main page of the system")
	public void i_can_see_the_main_page_of_the_system() throws Exception {
		getDriver().manage().timeouts().implicitlyWait(Constants.delay, TimeUnit.SECONDS);
		if(getDriver().getTitle().contains("Healthcare")) {
			System.out.println("C: I can see the main page of the system: "+getDriver().getTitle());
		}else {
			throw new Exception("Falied-Step: "+"i_can_see_the_main_page_of_the_system()");
		}
	
	}
	
}
