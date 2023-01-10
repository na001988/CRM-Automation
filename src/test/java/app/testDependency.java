package app;


public class testDependency {
	
	public static void main(String[] args) {
		
		ServiceWebDriver swd = new ServiceChrome();
		
		ClientWebDriver cl = new ClientChrome(swd);
		
		cl.create_Session();
		
		System.out.println("@@@@@@@ test: "+swd);

	}

}
