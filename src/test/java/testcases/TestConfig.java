package testcases;

public class TestConfig{
	
	//below are the details to send email from my gmail to other using smtp
	public static String server="smtp.gmail.com";
	public static String from = "biyas.banerjee2013@gmail.com";
	public static String password = "Riddhi2007#";
	public static String[] to ={"biyas.banerjee2013@gmail.com"};
	public static String subject = "Extent Project Report";
	
	public static String messageBody ="Test Message from Java";
	public static String attachmentPath="D:\\BIYAS-TUTORIALS\\Selenium\\screenshot.jpg";
	public static String attachmentName="screenshot.jpg";
	
	
	
	//SQL DATABASE DETAILS	-- need to change as per my sql connection details
	public static String driver="net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="jdbc:jtds:sqlserver://192.101.44.22;DatabaseName=monitor_eval"; 
	public static String dbUserName="sa"; 
	public static String dbPassword="$ql$!!1"; 
	
	
	//MYSQL DATABASE DETAILS
	public static String mysqldriver="com.mysql.jdbc.Driver";
	public static String mysqluserName = "biyas";
	public static String mysqlpassword = "biyas";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/biyasdb";
	
	
}
