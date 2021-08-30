package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestMOuseHoover {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		//to maximize the browser window
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//driver.findElement(By.name("q")).sendKeys("way2automation");
		WebElement keyWord = driver.findElement(By.name("q"));
		utilities.Highlighter.highlightElement(driver, keyWord);
		keyWord.sendKeys("way2automation");
				
		WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement searchBtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/center/input[1]")));
		//WebElement searchBtn = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/center/input[1]"));
		utilities.Highlighter.highlightElement(driver, searchBtn);
		searchBtn.click();
		
		WebElement link= driver.findElement(By.xpath("/html/body/div[7]/div/div[8]/div[1]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/a/h3"));
		utilities.Highlighter.highlightElement(driver, link);
		link.click();
		
		
		WebElement menu = driver.findElement(By.xpath("/html/body/div[4]/div/header/div[3]/div/nav/div[2]/ul/li[8]/a"));
		
		Actions action= new Actions(driver);
		
		action.moveToElement(menu).perform();
		WebElement menuLink= driver.findElement(By.linkText("Practice site 1"));
		utilities.Highlighter.highlightElement(driver, menuLink);
		menuLink.click();
		

	//	driver.close();
		
	}

}
