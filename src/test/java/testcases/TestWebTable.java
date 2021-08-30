package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebTable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://money.rediff.com/losers/bse/daily/groupa");
		
		//to maximize the browser window
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		List<WebElement> tableRows= driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		System.out.println("No of rows in the table: "+ tableRows.size());
		
		List<WebElement> tableCols= driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td"));
		System.out.println("No of columns in the table: "+ tableCols.size());
		
		for(int r=1; r<=tableRows.size(); r++) {
			for(int c=1;c<=tableCols.size(); c++) {
				System.out.print(driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+r+"]/td["+c+"]")).getText() + " -- ");
		}
			System.out.println();
		}
	}

}
