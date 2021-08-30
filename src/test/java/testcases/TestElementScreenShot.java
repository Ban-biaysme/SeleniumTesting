package testcases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestElementScreenShot {

	public static WebDriver driver;
	public static void captureScreenshot() throws IOException {
		
		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//screenshot//"+fileName));
	
	}
	
	public static void captureElementScreenshot(WebElement element) throws IOException {
		
		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg = ImageIO.read(screenshot);
		
		Point point = element.getLocation();
		
		int eleWidth = element.getSize().getWidth();
		int eleHeight = element.getSize().getHeight();
		
		BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
		
		ImageIO.write(eleScreenshot,"jpg", screenshot);

		FileUtils.copyFile(screenshot,  new File(".\\screenshot\\"+ fileName));
	
	}
	
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		//to maximize the browser window
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img"));
		captureElementScreenshot(element);
		
		driver.close();
		
//		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		BufferedImage fullImg = ImageIO.read(screenshot);
//		
//		Point point = element.getLocation();
//		
//		int eleWidth = element.getSize().getWidth();
//		int eleHeight = element.getSize().getHeight();
//		
//		BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
//		
//		ImageIO.write(eleScreenshot,"jpg", screenshot);
//
//		FileUtils.copyFile(screenshot,  new File(".\\screenshot\\googlelogo.jpg"));
	}

}
