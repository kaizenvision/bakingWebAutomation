package com.ecom.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ecom.base.BaseClass;

public class Utility extends BaseClass {
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public static void applyImplicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
	}
	
	public static void applyExplicitWait(WebElement ele) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
	}

}
