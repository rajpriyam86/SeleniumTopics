package funtionalTest;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EcommarceSample {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "F:/Automation Project/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); //Explicit Wait Object
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		String[] itemsNeeded = {"Tomato","Beetroot","Carrot"};
		//Calling the method
		addItemsMethod(driver,itemsNeeded);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		//Explicit Wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
		driver.close();
		
		
	}
	
	//Method
	public static void addItemsMethod(WebDriver driver, String[] itemsNeeded)
	{
		int j=0;
		List<WebElement> name = driver.findElements(By.xpath("//h4[@class='product-name']"));
		for(int i=0;i<name.size();i++)
		{
			String[] items = name.get(i).getText().split("-");
			String product = items[0].trim(); 
			List finalItems = Arrays.asList(itemsNeeded);
			if(finalItems.contains(product))
			{
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
				if(j==finalItems.size())
				{
					break;
				}
			}
		}
	}

}
