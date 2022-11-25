package com.ecom.testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ecom.base.BaseClass;
import com.ecom.pom.LoginPagePom;
import com.ecom.pom.ManagerHomePom;
import com.ecom.utility.ExcelReader;
import com.ecom.utility.Utility;

public class ManagerHomeTest extends BaseClass {
	
	LoginPagePom loginPagePom;
	ExcelReader excelReader;
	Utility utility;
	ManagerHomePom managerHomePom;
	
	@BeforeClass
	public void setUp() {
		//initDriver();
		managerHomePom = new ManagerHomePom();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test(dependsOnGroups = {"validLogin"})
	public void testClickOnNewCustomer() {
		Utility.applyImplicitWait();
		managerHomePom.clickOnNewCustomer();
	}

}
