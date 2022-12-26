package app;

public class Constants {
	
	static int delay = 800;
	boolean is_headless = false;
	String browser_c = "chrome";
	String browser_f = "firefox";
	String base_uri="https://demo.1crmcloud.com/login.php";
	String user = "admin";
	String pass = "admin";
	String hub = "http://localhost:4444/wd/hub";
	String path_browser_f = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
	static final String glue = "stepD";
	static final String tags = "@sit_001";
	static final String features = "src/main/java/myFeatures";
	

	public int delay() {
		return delay;
	}
	
	public String data(String x) {
		return x = "x-"+Math.random();
	}

	public long number() {
		long value = 0;
		return value = (long) (Math.random()*100000);
	}
	

}
