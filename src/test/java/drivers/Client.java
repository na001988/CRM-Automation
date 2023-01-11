package drivers;

public class Client implements ClientWebDriver{

	Service wd;
	
	public Client(Service wd) {
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
	
	
	public void setServiceWd(Service mwd) {
		this.wd = mwd;
		
	}

}
