import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IFrameHandle {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "F:/Automation Project/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://jqueryui.com/droppable/");
		//Switching to another frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		//creating action class to perform drag and drop
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).build().perform();
		//getting out from iFrame and switching to main WebPage
		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.xpath("//h1[@class='entry-title']")).getText());

	}

}
