import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WeDriverMethod {

	public static void webdriver()
	{
	System.setProperty("webdriver.chrome.driver", "F:/Automation Project/Drivers/chromedriver.exe"); 
	WebDriver driver = new ChromeDriver();

	//Firefox Launch
	System.setProperty("webdriver.gecko.driver", "F:/Automation Project/Drivers/geckodriver.exe");
	WebDriver driver1 = new FirefoxDriver();
	
	//edge launch
	System.setProperty("webdriver.edge.driver", "F:/Automation Project/Drivers/msedgedriver.exe");
	WebDriver driver2 = new EdgeDriver();
	
	}
	
}
