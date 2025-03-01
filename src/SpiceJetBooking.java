import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SpiceJetBooking {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.spicejet.com/");
		WebElement origin = driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/div[@data-focusable='true']"));
		origin.click();
		Thread.sleep(2000);
//		origin.clear();
		origin.sendKeys("CCU");
		WebElement destination = driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']/div/div"));
		destination.click();
		destination.sendKeys("DEL");

	}

}
