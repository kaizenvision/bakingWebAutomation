package com.ecom.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.base.BaseClass;

public class ManagerHomePom extends BaseClass {
	
	public ManagerHomePom() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "New Customer")				//a[text()='New Customer']
	WebElement newCustomer;

	@FindBy(linkText = "Edit Customer")				//a[text()='Edit Customer']
	WebElement editCustomer;
	
	@FindBy(linkText = "Delete Customer")			//a[text()='Delete Customer']
	WebElement deleteCustomer;
	
	@FindBy(linkText = "New Account")				//a[text()='New Account']
	WebElement newAccount;
	
	@FindBy(linkText = "Edit Account")				//a[text()='Edit Customer']
	WebElement editAccount;
	
	@FindBy(linkText = "Delete Account")			//a[text()='Delete Account']
	WebElement deleteAccount;
	
	@FindBy(linkText = "Mini Statement")			//a[text()='Mini Statement']
	WebElement miniStatement;
	
	@FindBy(linkText = "Customised Statement")		//a[text()='Customised Statement']
	WebElement customisedStatement;
	
	@FindBy(linkText = "Log out")					//a[text()='Log out']
	WebElement logOut;
	
	
	public AddCustomerPom clickOnNewCustomer() {
		newCustomer.click();
		return new AddCustomerPom();
	}
	

}
