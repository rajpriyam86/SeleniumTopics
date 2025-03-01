import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UdemyAssignment3 {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "F:/Automation Project/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		//extracting the username and password from the login page
		String[] credential = driver.findElement(By.xpath("//p[@class='text-center text-white']")).getText().split(" ");
		String username =credential[2];
		String password = credential[6].replaceAll("[()]","");
		
		//Storing Profession
		String profession = "Consultant";
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		if(driver.findElement(By.xpath("//input[@value='admin']")).isSelected())
		{
			driver.findElement(By.xpath("//input[@value='user']")).click();
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal fade show']")));
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select prof = new Select(dropdown);
		prof.selectByVisibleText(profession);
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		//Explicit Wait
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[@class='my-4']")));
		List<WebElement> products = driver.findElements(By.xpath("//button[@class='btn btn-info']"));
		for(int i=0;i<products.size();i++)
		{
			driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
		}
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("F:\\Automation Project\\SeleniuamSS\\screenshot2.jpg"));

	}

}
