import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "F:/Automation Project/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions a = new Actions(driver);
		
		driver.get("https://www.amazon.in/");
		
		//Mouse hover
		a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		//right click
		a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).contextClick().build().perform();
		//composite actions - move to element click on it wite the letter in captial then select the text
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("mobile").doubleClick().build().perform();
		
		a.keyDown(Keys.PAGE_DOWN).sendKeys("LL").keyUp(Keys.PAGE_DOWN);
		
	}

}
