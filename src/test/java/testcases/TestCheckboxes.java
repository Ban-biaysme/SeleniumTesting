package testcases;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCheckboxes {

	public static WebDriver driver;
	

	public static void main(String[] args){
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		
		//to maximize the browser window
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
//		  Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
//				   .withTimeout(Duration.ofSeconds(10))
//				   .pollingEvery(Duration.ofSeconds(2))
//				   .ignoring(NoSuchElementException.class);
	
//		driver.findElement(By.xpath("//div[4]/input[1]")).click();
//		driver.findElement(By.xpath("//div[4]/input[2]")).click();
//		driver.findElement(By.xpath("//div[4]/input[3]")).click();
//		driver.findElement(By.xpath("//div[4]/input[4]")).click();
		
//	We can also write the above three lines of code in a loop format
		int i=1;
		int counter=0;
		while(isElementPresent(By.xpath("//div[6]/input["+i+"]"))) {
			
			driver.findElement(By.xpath("//div[6]/input["+i+"]")).click();
				i++;
				counter++;
		}
		System.out.println("Total check boxes clicked:" + counter);	
		System.out.println("-----------------------------------");
		
		
		// if we want to click all the check boxes from a specific block
		
		WebElement block = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"));

		List<WebElement> chkbxes= block.findElements(By.name("sports"));
		System.out.println("Total check boxes clicked from a specific div : "+ chkbxes.size());
		
		for(WebElement ckbx: chkbxes) {
			ckbx.click();
		}
		
	}
	
	public static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		}catch(Throwable t) {
			return false;
		}
	}
	
}
