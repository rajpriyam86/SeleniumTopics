package MethodCalling;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CallingMethodFromDiffClass extends Method1 {
	
	public static void main(String[] args) throws IOException {
		webdriver();
		Method2 webcall = new Method2();
		String website = webcall.website();
		driver.get(website);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("F:\\Automation Project\\SeleniuamSS\\screenshot.jpg"));
		
	}

}
