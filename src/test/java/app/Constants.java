package app;

public class Constants {
	
	public static int delay = 800;
	public static boolean is_headless = true;
	public static boolean writeFile = true;
	public static final String browser_c = "chrome";
	public static final String base_uri="https://demo.1crmcloud.com/login.php";
	public static String user = "admin";
	public static String pass = "admin";
	public static String hub = "http://localhost:4444/wd/hub";
	public static String path_browser_f = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
	public static final String glue = "parallel";
	public static final String tags = "@SIT";
	public static final String features = "testcases/parallel";
	public static final String excelFile = "\\OutputData.xlsx";
	

	public String data(String x) {
		return x = "x-"+Math.random();
	}

	public long number() {
		long value = 0;
		return value = (long) (Math.random()*100000);
	}

}
