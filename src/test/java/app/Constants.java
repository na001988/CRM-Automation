package app;

public class Constants {
	
	public static int delay = 800;
	public static boolean is_headless = false;
	public static boolean writeFile = false;
	public static final String browser_c = "chrome";
	public static final String base_uri="http://caprivihealthcareresearch2.itdp.com.au";
	public static String user = "48521";
	public static String pass = "demo001";
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
