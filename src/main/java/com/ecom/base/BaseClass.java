package com.ecom.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.ecom.utility.Utility;

public class BaseClass {
	
	public static String projectPath = System.getProperty("user.dir");
	public static WebDriver driver;
	public static Properties properties;
	
	
	public void initDriver() {
		System.setProperty("webdriver.chrome.driver", projectPath+"\\driver\\chromedriver.exe");
		driver = new ChromeDriver();   //new FirefoxDriver(); new EdgeDriver();
		driver.get(properties.getProperty("websiteurl"));
		Utility.applyImplicitWait();
	}
	
	@BeforeTest
	public void openWebsite() throws IOException {
		FileInputStream readProp = new FileInputStream(projectPath+"\\src\\test\\resources\\data\\data1.properties");
		properties = new Properties();
		properties.load(readProp);	
	}
	
	

}
