package PracticeForInterview;
import static org.testng.Assert.assertEquals;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



public class PracticeForInterview {

	private static final boolean WebElement = false;

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		WebDriver driver = new ChromeDriver();
	driver.get("https://magento.softwaretestingboard.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //Implicit Wait
//	driver.findElement(By.linkText("Create an Account")).click();
//	
//	//Account creation/From Fillup
//	driver.findElement(By.id("firstname")).sendKeys("Priyam");
//	driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Raj");
//	driver.findElement(By.cssSelector("input[name = 'email']")).sendKeys("abc12345Priyam56@gmail.com");
//	driver.findElement(By.cssSelector("#password")).sendKeys("Test@123");
//	driver.findElement(By.id("password-confirmation")).sendKeys("Test@123");
	
	//Action Class Mouse hover
	
	Actions a = new Actions(driver);
//	a.moveToElement(driver.findElement(By.xpath("//button[@type='submit']/span[text()='Create an Account']"))).click().build().perform();
	
//	driver.navigate().to("https://magento.softwaretestingboard.com/");
//	driver.findElement(By.partialLinkText("Sign")).click();
//	a.moveToElement(driver.findElement(By.id("email"))).click().sendKeys("abc12345Priyam56@gmail.com").build().perform();
//	a.moveToElement(driver.findElement(By.id("pass"))).click().keyDown(Keys.SHIFT).sendKeys("t").keyUp(Keys.SHIFT).sendKeys("est@123").build().perform();
//	JavascriptExecutor js = (JavascriptExecutor)driver;
//	js.executeScript("window.scrollBy(0,-500)");
//	a.sendKeys(Keys.PAGE_UP).build().perform();
//	driver.findElement(By.xpath("//button[@class='action login primary']")).click();
//	
//	String confirmation = driver.findElement(By.xpath("//li/span[@class='logged-in']")).getText();
//	Assert.assertEquals("Welcome, Priyam Raj!", confirmation);
//	System.out.println(confirmation);
	
//	 Window handle
//	driver.navigate().to("https://rahulshettyacademy.com/locatorspractice/");
//	driver.findElement(By.id("visitUsTwo")).click();
//	Set<String> window = driver.getWindowHandles();
//	Iterator<String> it = window.iterator();
//	
//	String Parent = it.next();
//	String child = it.next();
//	driver.switchTo().window(child);
//	String statement = driver.findElement(By.xpath("//div[@class='header-text hidden-xs']/div[@class='col-md-6 text-left']/h2/span")).getText();
//	System.out.println(statement);
//	
//	
//	//dropdown
	driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");
	driver.findElement(By.id("divpaxinfo")).click();
	
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hrefIncAdt")));
	for(int i = 0 ; i<5;i++) {
		driver.findElement(By.id("hrefIncAdt")).click();
//		driver.findElement(By.id("hrefIncChd")).click();
		
	}
	
	driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency")).click();
	List<WebElement> currency= driver.findElements(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']/option"));
	for(WebElement curr : currency) {
		
		if(curr.getText().equals("AED")) {
			curr.click();
			
		}
		
	}
	
	System.out.println(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).isSelected());
	
	if(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).isSelected()) {
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
	}
	
	List<WebElement> checkbox = driver.findElements(By.xpath("//div[@id='discount-checkbox']/div"));
	
	for(int k = 0; k<checkbox.size();k++) {
		
		if(checkbox.get(k).getText().contains(" Family and Friends")) {
			checkbox.get(k).click();
		}
		
	}
	
	int j = 0;
	System.out.println(checkbox.size());
	for(int i = 0; i<checkbox.size();i++) {
		if(checkbox.get(i).isSelected()) {
			j++;
		}
	}
	System.out.println("Total Selection: "+j);
	
//	
//	//I fRame and drag and drop
//	
//	driver.navigate().to("https://jqueryui.com/droppable/");
//	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class= 'demo-frame']")));
//	WebElement Source = driver.findElement(By.xpath("//div[@id= 'draggable']"));
//	WebElement Target = driver.findElement(By.xpath("//div[@id= 'droppable']"));
//	a.dragAndDrop(Source, Target).build().perform();
//	System.out.println(Target.getText());
//
//	System.out.println(driver.switchTo().window(Parent).getTitle());
	
	//Alert Handle
	
//	driver.navigate().to("https://demo.automationtesting.in/Alerts.html");
//	
//	driver.findElement(By.linkText("Alert with Textbox ")).click();
//	driver.findElement(By.xpath("//button[@class = 'btn btn-primary']")).click();
//	driver.switchTo().alert().sendKeys("Priyam Raj");
//	driver.switchTo().alert().accept();
//	driver.switchTo().defaultContent();
	
	driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
	List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
	
	for (int i=0; i<links.size();i++) {
		String link = links.get(i).getAttribute("href");
		HttpURLConnection check = (HttpURLConnection) new URL(link).openConnection();
		check.connect();
		int responseCode = check.getResponseCode();
		if(responseCode >400) {
			System.out.println("Broken Link found: "+link);
		}
	}
	
	//F:\
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("F:\\screenshot.jpg"));
	
	
	
	
}
}
