package com.ecom.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import com.ecom.utility.Utility;

public class BaseClass {
	
	public static String projectPath = System.getProperty("user.dir");
	public static WebDriver driver;
	
	
	public void initDriver() {
		System.setProperty("webdriver.chrome.driver", projectPath+"\\driver\\chromedriver.exe");
		driver = new ChromeDriver();   //new FirefoxDriver(); new EdgeDriver();
		driver.get("https://demo.guru99.com/V1/index.php");
		Utility.applyImplicitWait();
	}
	
	

}
