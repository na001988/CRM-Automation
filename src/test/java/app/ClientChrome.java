package app;


public class ClientChrome implements ClientWebDriver{

	ServiceWebDriver wd;
	
	public ClientChrome(ServiceWebDriver wd) {
		this.wd = wd;
	}
	
	
	@Override
	public void create_Session() {
		
		try {
				
			wd.getWebDriver();
			
			} catch (Exception e) {
				System.out.println("Error on create_Session :"+e.getMessage());
			}
		 
	}
	
	
	public void setServiceWd(ServiceWebDriver wd) {
		this.wd = wd;
		
	}

}
