/**
 * 
 */
package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * @author Biyas-Anirban
 * Configure Fire fox driver
 * we need latest selenium version, latest browser virsion and driver
 * for firefox we need gecko driver - geckodriver.exe
 */
public class TestChromeBrowser {
	public static void main(String[] args) {

		//Initialize chrome driver driver
		//ctrl+shift+o -> shortcut for import class	
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Biyas-Anirban\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		
		driver.get("http://google.com");
	}

}
