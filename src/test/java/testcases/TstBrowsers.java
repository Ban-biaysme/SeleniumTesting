/**
 * 
 */
package testcases;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Biyas-Anirban
 * Configure recent version of driver
 * we need latest selenium version, latest browser version and driver
 * for firefox we need gecko driver - geckodriver.exe
 */


public class TstBrowsers {

	public static WebDriver driver;
	public static String browser="chrome";
	
	public static void main(String[] args) throws InterruptedException {    
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver= new FirefoxDriver();
			 
		}else if(browser.equals("ie")) {
			WebDriverManager.iedriver();
			driver= new InternetExplorerDriver();
		}
		
//		driver.get("http://way2automation.com");
//		String title= driver.getTitle();
//		System.out.println(title);
//		System.out.println("Length: " + title.length());
//		driver.close();
		
		
		driver.get("https://formy-project.herokuapp.com/form");
		
		//to maximize the browser window
		driver.manage().window().maximize();
		
	    //implicit wait in web driver- it declare only once, it will work for each findElement method
	
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     
	   Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
			   .withTimeout(Duration.ofSeconds(10))
			   .pollingEvery(Duration.ofSeconds(2))
			   .ignoring(NoSuchElementException.class);
	   
		String pagetitle= driver.getTitle();
		System.out.println(pagetitle);
		System.out.println("Length: " + pagetitle.length());
		

		
		 driver.findElement(By.id("first-name")).sendKeys("Biyas");		
		 
		//Implementation of fluent waiting
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("last-name"))).sendKeys("Banerjee");	
		
		 // driver.findElement(By.id("last-name")).sendKeys("Banerjee");	
		 
	     driver.findElement(By.id("job-title")).sendKeys("Automation Engineer");

	     driver.findElement(By.id("radio-button-3")).click();

	     driver.findElement(By.id("checkbox-1")).click();
	     	     
	     driver.findElement(By.id("datepicker")).sendKeys("07/29/2021");
	    
	     driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);
	     
 
	     driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();

	     
	     WebDriverWait wait1 = new WebDriverWait(driver, 10);
	     WebElement alert = wait1.until((ExpectedConditions.visibilityOfElementLocated(By.className("alert"))));

	     String alertText = alert.getText();

	     assertEquals("The form was successfully submitted!", alertText);
		
//		Thread.sleep(1000);
//		WebElement nextBtn = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
//		nextBtn.click();
//		
//		Thread.sleep(1000);
//		driver.findElement(By.className("whsOnd zHQkBf")).sendKeys("Riddhi2007#");
		
		//driver.close();
	}

	private static void assertEquals(String string, String alertText) {
		// TODO Auto-generated method stub
		
	}

}


