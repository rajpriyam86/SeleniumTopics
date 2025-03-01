import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UdemyAssignment7 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr"));
		List<WebElement> columns =driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr/th"));
		System.out.println(rows.size());
		System.out.println(columns.size());
		List<WebElement> text = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr[3]/td"));
		
		for(int i = 0; i<columns.size();i++)
		{
		System.out.print(text.get(i).getText());
		System.out.print(" | ");
		}

	}

}
