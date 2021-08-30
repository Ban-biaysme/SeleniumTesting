package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestIsElemenPresent {

	public static WebDriver driver;
	
	public static boolean isElementPresent(String locator) {
		try {
			driver.findElement(By.xpath(locator));
			return true;
		}catch(Throwable t) {
			return false;
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
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.wikipedia.org/");
		
		//to maximize the browser window
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//tofind the xpath, select element and press ctrl + f ( use chrome) 
		// xpath syntax: //input[@name='userName'
		// xpath syntax with OR | operator : //input[@name='userName']|//input[@id='userName']
		
		// if i like to find the element with same text the sytax of xpath is -->  (//*[text()='click txt to navigate'])[1]
		// here [1] indicates the first text of the same group
		
		
		//WebElement element = driver.findElement(By.xpath("//*[@id=\"js-link-box-en\"]/strong"));
		
		//find total number of links in a division of a  web page
		// target the element using xpath
		WebElement block = driver.findElement(By.xpath("//div[@class='other-projects']"));
		
		List<WebElement> links= block.findElements(By.tagName("a"));
		int linkLength= links.size();
		System.out.println("Length of the links: " + linkLength);
		
		// find all the values from links
		for(WebElement l: links) {
			System.out.println(l.getText() + " links : " + l.getAttribute("href"));
		}
		
		// to check if the element visibility in DOM - .isDisplayed()		
		System.out.println(isElementPresent("//*[@id=\"js-link-box-en\"]/strong"));
		
		//below line we used the same method with diff parameter using id/class/xpath
		// so we can use the same method for different type of locator to target the element on DOM
		System.out.println(isElementPresent(By.id("js-link-box-de")));

		
	}

}
