import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FlightBookingE2E {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "F:/Automation Project/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//selecting country
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for(WebElement option : options)
		{
			
			if(option.getText().equalsIgnoreCase("india"))
			{
				option.click();
				break;
			}
		}
		
		//selecting trip type
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		
		//selecting origin
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		
		//selecting Destination
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='CCU']")).click();
		
		//selecting date
		driver.findElement(By.linkText("11")).click(); 
		
		//checking if return date is disabled as we selected one way trip
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
		{
			
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		// selecting passenger count
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		for(int j =1;j<4;j++)
		  {
			  driver.findElement(By.id("hrefIncAdt")).click(); 
		  }
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "4 Adult");
		
		//select currency
		WebElement droplocator = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(droplocator);
		dropdown.selectByVisibleText("INR"); //dropdown.getFirstSelectedOption()
		Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "INR");
		
		//selecting check box
		Assert.assertEquals(driver.findElements(By.xpath("//input[@type='checkbox']")).size(), 6);
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		
		//Hitting Search Button
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		System.out.println("You have successfully completed the Automation");
		driver.close();
		
		
		
		

	}

}
