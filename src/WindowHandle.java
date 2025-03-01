import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "F:/Automation Project/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		//calling WindowHandles class
		Set<String> windows = driver.getWindowHandles();
		//Stroring alll the id's (parent,child,subchild etc) it wil store like[parent id, child id]
		Iterator<String> id = windows.iterator();
		//storing each id's to a string by using .next(), initially it will be out of the bracket using it we are inserting and grabing the ids
		String prentId = id.next();
		String childId = id.next();
		//switching to child window
		driver.switchTo().window(childId);
		String userName = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split(" ")[4];
		driver.switchTo().window(prentId);
		driver.findElement(By.id("username")).sendKeys(userName);
		

	}

}
