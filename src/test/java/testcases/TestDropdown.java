/**
 * 
 */
package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Biyas-Anirban
 *
 */
public class TestDropdown {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.way2automation.com/way2auto_jquery/index.php");
		
		//to maximize the browser window
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	    //implicit wait in web driver- it declare only once, it will work for each findElement method
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		/*
		 * to check the selector from web site type in console -->  $$("[name='language']")
		 * when working with drop down list do not use sendKeys instead select
		 */
		// driver.findElement(By.name("country")).sendKeys("Germany");
	
		WebElement dropdown = driver.findElement(By.name("country"));
		Select select = new Select(dropdown);
		select.selectByValue("India");
				
		System.out.println(select.getAllSelectedOptions());

		List<WebElement> dropdownValues= driver.findElements(By.tagName("option"));
		int length= dropdownValues.size();
		System.out.println("Length of the drop down menu: " + length);
		
		// find all the values for drop down list
		for(int i=0; i<length; i++) {
			System.out.println(dropdownValues.get(i).getText());
		}
		
		System.out.println();
		//find total number of links in the web page
		//WebElement block = driver.findElement(By.className("bottom row"));

//		List<WebElement> links= driver.findElements(By.tagName("a"));
		
		// target a specific element from div
		List<WebElement> links= driver.findElements(By.tagName("a"));
		int linkLength= links.size();
		System.out.println("Length of the links: " + linkLength);
		
		// find all the values from links
		for(WebElement l: links) {
			System.out.println(l.getText() + " URL : " + l.getAttribute("href"));
		}

		
	}
}
