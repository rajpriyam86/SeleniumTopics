import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class UdemyAssignment2 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "F:/Automation Project/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.xpath("//div[@class='form-group'] //input[@name='name']")).sendKeys("User Test");
		driver.findElement(By.xpath("//input[@class='form-control ng-untouched ng-pristine ng-invalid']")).sendKeys("user@test.com");
		driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys("User@123");
		driver.findElement(By.xpath("//input[@id='exampleCheck1']")).click();
		WebElement option = driver.findElement(By.id("exampleFormControlSelect1"));
		Select gender = new Select(option);
		gender.selectByVisibleText("Male");
		driver.findElement(By.id("inlineRadio3")).click();
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("01-01-2000");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class*='alert-success'] strong")).getText(), "Success!");
		System.out.println(driver.findElement(By.cssSelector("div[class*='alert-success']")).getText());
		

	}

}
