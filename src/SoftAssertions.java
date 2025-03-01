import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class SoftAssertions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(driver.getTitle(), "Googe");
		driver.navigate().to("https://chatgpt.com/");
		soft.assertEquals(driver.getTitle(), "ChatGPT");
		
		soft.assertAll();

	}

}
