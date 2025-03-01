import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

public class UdemyAssignment8 {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "F:/Automation Project/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String countryToSelect = "United Arab Emirates";
		String initials = countryToSelect.substring(0, 3);
		WebElement suggestionBox = driver.findElement(By.id("autocomplete"));
		suggestionBox.sendKeys(initials);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> suggestions = wait.until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//ul[@id='ui-id-1']/li/div")));
        
        for (WebElement suggestion : suggestions) {
            if (suggestion.getText().equals(countryToSelect)) {
                suggestion.click();
                break;
            }
        }
        String selectedCountry = suggestionBox.getAttribute("value");

        // Print the selected country
        System.out.println("Selected Country: " + selectedCountry); 
        
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("F:\\Automation Project\\SeleniuamSS\\screenshot.jpg"));

	}

}
