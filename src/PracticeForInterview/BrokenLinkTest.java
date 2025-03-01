package PracticeForInterview;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {
	public static void main(String[] args) throws MalformedURLException, IOException {
//		System.setProperty("webdriver.chrome.driver", "F:/Automation Project/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		for(int i = 0; i<links.size();i++) {
			String url = links.get(i).getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.connect();
			int responseCode = conn.getResponseCode();
			if(responseCode>=400) {
				System.out.println(url+" is a broken Link");
			}
		}
		
	}

}
