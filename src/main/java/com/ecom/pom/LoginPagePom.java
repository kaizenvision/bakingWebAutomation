package com.ecom.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.base.BaseClass;

public class LoginPagePom extends BaseClass{
	
	public LoginPagePom() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='uid']")
	WebElement userId;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@name='btnLogin']")
	WebElement loginButton;
	
	@FindBy(xpath = "//input[@name='btnReset']")
	WebElement resetButton;
	
	@FindBy(xpath = "//a[text()='here']")
	WebElement getCredentials;
	
	public void setLoginCredentials(Object userName, Object passwordMap) {
		userId.sendKeys(userName.toString());
		password.sendKeys(passwordMap.toString());
	}
	
	public ManagerHomePom clickOnLogin() {
		loginButton.click();
		return new ManagerHomePom();
	}
	
	

}
