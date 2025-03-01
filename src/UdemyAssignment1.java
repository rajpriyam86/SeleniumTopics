import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UdemyAssignment1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "F:/Automation Project/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//1st question
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		//2nd question
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
	

	}

}
