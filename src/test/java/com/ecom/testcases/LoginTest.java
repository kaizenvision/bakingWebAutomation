package com.ecom.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ecom.base.BaseClass;
import com.ecom.pom.LoginPagePom;
import com.ecom.utility.ExcelReader;

public class LoginTest extends BaseClass{
	
	LoginPagePom loginPagePom;
	ExcelReader excelReader;
	
	@BeforeClass
	public void setUp() {
		initDriver();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testLogin() throws EncryptedDocumentException, IOException {
		excelReader = new ExcelReader();
		Sheet sh = excelReader.getSheet("loginpage");
		Map<String, Object> data = excelReader.getData(sh);
		loginPagePom = new LoginPagePom();
		loginPagePom.loginWithValidCredentials((String) data.get("userid"), (String) data.get("password"));
	}

}
