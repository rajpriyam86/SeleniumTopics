package EndToEndAutomation;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ECommerceAutomation {
	
	public WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	String email = "usertest2884099@gmail.com";
	String password = "User@1234";
	String[] items = {"ADIDAS ORIGINAL","ZARA COAT 3"};
	
	
	@BeforeMethod
	public void webdriver()
	{
		System.setProperty("webdriver.chrome.driver", "F:/Automation Project/Drivers/chromedriver.exe");
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
	}
	
	@Test (priority = 0)
	public void Registration() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//a[@class='text-reset']")).click();
		driver.findElement(By.id("firstName")).sendKeys("user");
		driver.findElement(By.id("lastName")).sendKeys("Test");
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.id("userMobile")).sendKeys("1234567890");
		List<WebElement> occupations = driver.findElements(By.xpath("//div[@class='form-group col-md-6']/select/option"));
		for (WebElement occupation : occupations)
		{
			System.out.println(occupation.getText());
			if (  occupation.getText().equalsIgnoreCase("Student")  )
			{
				occupation.click();
				break;
			}
		}
		
		List<WebElement> genders = driver.findElements(By.xpath("//input[@formcontrolname='gender']"));
		for (WebElement gender : genders)
		{
			System.out.println(gender.getAttribute("value"));
			if ( gender.getAttribute("value").equalsIgnoreCase("Male")  )
			{
				gender.click();
				break;
			}
		}
		
		driver.findElement(By.id("userPassword")).sendKeys(password);
		driver.findElement(By.id("confirmPassword")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@id='login']")).click();
		Thread.sleep(2000);
		String confirmation = driver.findElement(By.xpath("//div[@class='login-section-wrapper']/div[2]/h1")).getText();
		Assert.assertEquals(confirmation, "Account Created Successfully", "Account Creation is completed");
			
		
	}
	
	@Test(priority = 2)
	public void LoginTest() throws InterruptedException
	{
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.id("userPassword")).sendKeys(password);
		driver.findElement(By.id("login")).click(); 
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='left mt-1']/h3")).getText(), "AUTOMATION");
	}
	
	@Test(priority = 3)
	public void AddToCart() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='card-body']/h5/b"));
		int j = 0;
		for(int i=0;i<products.size();i++)
		{
			List finalItems = Arrays.asList(items);
			String product = products.get(i).getText();
			
			if(finalItems.contains(product))
					{
//						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='card-body']/button[2]")));
						driver.findElements(By.xpath("//div[@class='card-body']/button[2]")).get(i).click();
						j++;
						Thread.sleep(3000);
					}
			if(j==products.size())
			{
				break;
			}
		}
	}
	
	@Test(priority = 4)
	public void CartCheck()
	{
		driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']")).click();
		List<WebElement> cartitems = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		for(int k=0;k<cartitems.size();k++)
		{
		System.out.println(cartitems.get(k).getText());
		System.out.println(cartitems.size());
				
		}
		int m = 0;
		
		List<WebElement> totalPrice = driver.findElements(By.xpath("//li[@class='totalRow']/span"));
		while( m<4)
		{
			System.out.println(totalPrice.get(m).getText());
			m++;
			
		}
	}
	
	
	
	
	@AfterClass
	public void CloseWindow()
	{
		
		System.out.println("Completed");
	}
	

}
