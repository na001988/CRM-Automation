package app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class handleWebDriver {
	
	WebDriver driver;

	public WebDriver getWebDriver(WebDriver driver) {

		if(driver == null) {
			System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Running a webdriver instance > "+Thread.currentThread().getId());
		}else {
			System.out.println("Creating a NEW webdriver instance > "+Thread.currentThread().getId());
			return driver;
		}
		return driver;
	}

}
