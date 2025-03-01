import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIntroduction {

	public static void main(String[] args) {
		
		//Chrome Launch
		System.setProperty("webdriver.chrome.driver", "F:/Automation Project/Drivers/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
	
		//Firefox Launch
//		System.setProperty("webdriver.gecko.driver", "F:/Automation Project/Drivers/geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
		//edge launch
//		System.setProperty("webdriver.edge.driver", "F:/Automation Project/Drivers/msedgedriver.exe");
//		WebDriver driver = new EdgeDriver();
		
	    //Code for automation starts here
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.nopcommerce.com/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Apparel")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.partialLinkText("Clothing")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Custom T-Shirt")).click();
		driver.findElement(By.id("product_attribute_12")).sendKeys("Buy");
		driver.findElement(By.cssSelector("button[class='button-1 add-to-cart-button']")).click();
		driver.findElement(By.cssSelector("span[class='cart-label']")).click();
		System.out.println(driver.findElement(By.cssSelector("div[class='page-title']")).getText());
		driver.findElement(By.cssSelector("a[class ='ico-login']")).click();
		driver.findElement(By.xpath("//input[@class ='email']")).sendKeys("ff@ff.com");
		driver.findElement(By.xpath("//input[@class ='password']")).sendKeys("dwhdjw");
		driver.findElement(By.xpath("//button[@class ='button-1 login-button']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class ='message-error validation-summary-errors']")).getText());
		driver.close(); //to close only current browser 
		driver.quit(); //to close all associated browser
		

	}

}
