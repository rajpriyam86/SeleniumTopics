import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UdemyAssignment6 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		String input = "option1";
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> options = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for (WebElement option : options)
		{
			 if (option.getAttribute("value").equals(input))
			 {
				 option.click();
				 break;
			 }
			
		}
		
		
		List<WebElement> dropdowns = driver.findElements(By.xpath("//select[@id='dropdown-class-example']/option"));
		
		for (WebElement dropdown : dropdowns)
		{
			if (dropdown.getAttribute("value").equals(input))
			{
				driver.findElement(By.id("dropdown-class-example")).click();
				dropdown.click();
			}
		}
		
		driver.findElement(By.id("name")).sendKeys(input);
		driver.findElement(By.id("alertbtn")).click();
		
		String popup = driver.switchTo().alert().getText();
		String text = popup.split(",")[0].split(" ")[1].trim();
		Assert.assertEquals(text, input);
		
		System.out.println(text);
		

	}

}
