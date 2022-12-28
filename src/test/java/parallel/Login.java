package parallel;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import app.Constants;
import app.Setup;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Login {
	
	static WebDriver wd;
	
	//Cucumber hook before all
	@Before
	public static void before_all() throws InterruptedException, MalformedURLException  {
		Setup s_c = new Setup(wd);
		wd =  s_c.run(Constants.browser_c);
	}
	
	//Cucumber hook after all
	@AfterAll
	public static void after_all() throws InterruptedException {
		System.out.println("Close WebDriver: "+Constants.browser_c+" | "+ Thread.currentThread().getId());
		if(wd!=null) wd.quit();
	}
	
	@Given("I enter a user_name and a password")
	public void i_enter_a_user_name_and_a_password() throws InterruptedException {
		System.out.println("A");
		wd.get(Constants.base_uri); 
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@Given("press the login_button")
	public void press_the_login_button() throws InterruptedException {
		if(wd!=null)
		Thread.sleep(1000);
		System.out.println("B: "+wd.getCurrentUrl());
	}
	
	@Then("I can see the main page of the system")
	public void i_can_see_the_main_page_of_the_system() throws InterruptedException {
		if(wd!=null)
		Thread.sleep(1000);
		System.out.println("C: "+wd.getCurrentUrl()); 
	
	}
	
	
}
