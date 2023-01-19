package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import drivers.Client;
import drivers.ClientWebDriver;
import drivers.Service;
import drivers.ServiceChrome;

public class Setup {

	protected WebDriver driver;
	protected WebElement label;
	public LocatorType locator;

	public Setup(WebDriver driver) {
		this.driver = driver;
	}
	
	public static WebDriver ManageDriver(String browser) {
		
		WebDriver mwd = null;
		
		if(browser.equals("chrome")) {
			
			Service swd = new ServiceChrome();
			ClientWebDriver cl = new Client(swd);
			cl.create_Session();
			((Client) cl).setServiceWd(swd);
			mwd = swd.getWebDriver();
			
		}else if(browser.equals("firefox")) {
			//add here logic to manage firefox
		}
		try {
		 
		}catch(Exception e) {
			System.out.println("On > WebDriver getDriver() > "+e.getMessage());
		}
		return mwd; 
	}
	
	
/*	
	public WebDriver run(String brw) throws InterruptedException, MalformedURLException {

	try {	
		if (brw.equals("firefox")) {
			System.out.println("Start WebDriver Firefox: "+Thread.currentThread().getId());
			FirefoxOptions f = new FirefoxOptions();
			f.setCapability(CapabilityType.BROWSER_NAME, brw);
			f.setBinary(Constants.path_browser_f);
			f.setHeadless(Constants.is_headless);
			URL uri = new URL(Constants.hub);
			return driver = new RemoteWebDriver(uri, f);
		}
	} catch (MalformedURLException e) {
		System.out.println("Error on WebDriver Firefox :"+e.getMessage());
	}	
		
		return driver;

	}

*/
	public WebElement locateWebElement(WebDriver obj, LocatorType l, String info) throws InterruptedException {

		try {
			
			Thread.sleep(Constants.delay);
			
			WebElement dynamicElement;
			switch (l) {
			case XPATH -> dynamicElement = obj.findElement(By.xpath(info));
			case ID -> dynamicElement = obj.findElement(By.id(info)); 
			case LINK_TEXT -> dynamicElement = obj.findElement(By.linkText(info));
			case CSS_SELECTOR -> dynamicElement = obj.findElement(By.cssSelector(info));
			case PARTIAL_LINK_TEXT -> dynamicElement = obj.findElement(By.partialLinkText(info));
			default -> throw new TypeNotPresentException("Warning ..... "+locator.getClass().getName(), null);
			
			}

			Thread.sleep(Constants.delay);

			return dynamicElement;

		} catch (StaleElementReferenceException | ElementNotInteractableException | NoSuchElementException | UnhandledAlertException ex) {
			System.out.println("Error on locateWebElement() > " + ex.getMessage());
			return null;
		}
	}

	public void PerformAction(WebElement we, WebDriverAction act, String data) {
		String var_value = "";
		Actions at = new Actions(driver);

		try {
			switch (act) {
			case CLICK -> {
				we.click();
			}
			case CLEAR -> {
				we.click();
				we.clear();
			}
			case GETTEXT -> {
				var_value = we.getText();
				if(var_value.length()==0) {
					var_value = we.getAttribute("alt");
					if(var_value.length()==0) {
						var_value = we.getAttribute("name");
					}
				}
			}
			case SETTEXT -> {
				we.sendKeys(data);
			}
			case SELECT -> {
				Select sl = new Select(we);
		        sl.selectByVisibleText(data);
			}
			case PERFORM -> {
				at.moveToElement(we).click().perform();
			}			
			default -> {
				Thread.sleep(2500);
			}
			}

		} catch (Exception e) {
			System.out.println("Warning on PerformAction(x,y,z) > " + e.getMessage());
		}
	}

	public enum LocatorType {
		ID, NAME, CLASS_NAME, XPATH, TAG_NAME, CSS_SELECTOR, LINK_TEXT, PARTIAL_LINK_TEXT,
	}

	public enum WebDriverAction {
		CLEAR, CLICK, INPUT, SELECT, GETTEXT, SETTEXT, PERFORM 
	}
	
	
	public void find_do(String x, String y, WebDriverAction z, LocatorType l) throws InterruptedException {
		PerformAction(findByLinkText(x, l), z, y);
	}

	
	private WebElement findByLinkText(String x, LocatorType l) throws InterruptedException {
		return label = locateWebElement(driver, l, x);
	}
	
}
