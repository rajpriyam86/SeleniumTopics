import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class DropdownHandle {

	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver", "F:/Automation Project/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//creating a webelement variable to pass in the selet argument
		WebElement droplocator = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		//select method to handle static dropdown
		Select dropdown = new Select(droplocator);
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//Dropdown Practice
		
		driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");
		
	}
}
