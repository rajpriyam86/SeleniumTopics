import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "F:/Automation Project/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		
		for (int i=0;i<links.size();i++)
		{
//			System.out.println(links.get(i).getAttribute("href"));
			String link = links.get(i).getAttribute("href");
			
			HttpURLConnection conn = (HttpURLConnection) new URL(link).openConnection();
//			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode = conn.getResponseCode();
			if(responseCode>400)
			{
				System.out.println(responseCode);
				System.out.println(links.get(i).getText()+" is Broken");
				
			}
		}

	}

}
