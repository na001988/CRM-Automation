package drivers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import utils.Constants;


public class ServiceChrome implements Service{
	
	protected static ThreadLocal<WebDriver>threadLocalDriver = new ThreadLocal<>();
	
	public WebDriver wd;
	
	public WebDriver getWebDriver() {
		
		try {
			if(threadLocalDriver.get()==null) {

			ChromeOptions c = new ChromeOptions();
			c.setHeadless(Constants.is_headless);
			URL uri = new URL(Constants.hub);
			wd = new RemoteWebDriver(uri, c); 
			
			threadLocalDriver.set(wd);
			
			System.out.println("Start WebDriver Chrome: "+threadLocalDriver.hashCode());
			//System.out.println(" Verify-local : "+threadLocalDriver.get().toString());
			
			SessionId s = ((RemoteWebDriver) wd).getSessionId();
		    System.out.println("Session Id is: " + s);
			
			}
		} catch (MalformedURLException e) {
			System.out.println("Error on getWebDriver() > ServiceChrome :"+e.getMessage());
			
		}
		
		return threadLocalDriver.get(); 
	}
	
	public void removeWebDriver() {
		
		threadLocalDriver.remove();
		getWebDriver().quit();
		
	}
}
