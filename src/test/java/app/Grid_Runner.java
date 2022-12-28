package app;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.Dates;

@Listeners(Reporting.class)
public class Grid_Runner {
	
	WebDriver driver;
    
  @BeforeClass(groups="start")
   public void run1() throws InterruptedException, MalformedURLException{
	  
	  Setup ob1 = new Setup(driver);
	  driver = ob1.run(Constants.browser_c);
  }
  
  @AfterClass(groups="end")
  public void close() throws InterruptedException{
	  try {
		  if(driver != null) driver.quit(); System.out.println("Close driver "+driver.toString());
		  
	  }catch(Exception e) {
			System.out.println("On-Close-1 > Error: "+e);
		}
  }
  
  
  @Test(groups=""+Constants.browser_c+"")
  public void launch_test() throws InterruptedException {
	  //passing WebDriver instance to call and execute methods
	  Dates d = new Dates(driver);
	  
	  try {
		  if(driver==null) {
			System.out.println("driver is null for : "+Constants.base_uri); 
		  }
		  
	  System.out.println("Web Browser "+driver.toString()+ " started...." + Thread.currentThread().getId());
	  driver.get(Constants.base_uri);
	  Thread.sleep(Constants.delay);
	  //d.run_page_1();
	  System.out.println(driver.getTitle());
	  }catch(Exception e) {
		  System.out.println("Warning...... while launching: "+driver.toString()+" | "+e.getMessage());
	  }
  }
  
}
