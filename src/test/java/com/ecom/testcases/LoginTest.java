package com.ecom.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ecom.base.BaseClass;
import com.ecom.pom.LoginPagePom;
import com.ecom.utility.ExcelReader;
import com.ecom.utility.Utility;
import com.listner.MyListner;
import com.retry.RetryTest;
import com.userexception.BusinessException;

@Listeners(MyListner.class)
public class LoginTest extends BaseClass{
	
	LoginPagePom loginPagePom;
	ExcelReader excelReader;
	Utility utility;
	
	ExtentSparkReporter extentSparkReporter ;
	ExtentReports extentReports ;
	ExtentTest logger;
	
	@BeforeClass
	public void openBrowser() {
		
		
		extentSparkReporter = new ExtentSparkReporter(projectPath+"//extentReport//testReport.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
	}
	
	@BeforeMethod
	public void setUp() {
		initDriver();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		
		//if(result.getStatus() == ITestResult.FAILURE) {
			
			
			//logger.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(Utility.takeScreenShot(result.getName())).build());
			logger.addScreenCaptureFromPath(Utility.takeScreenShot(result.getName()), result.getName()+"test");
			
		//}
		
			driver.quit();
	}
	
	@AfterClass
	public void closeBrowser() {
		extentReports.flush();
		
	}
	
	
	
	@Test(retryAnalyzer = RetryTest.class)
	public void testTitle() throws IOException {
		logger = extentReports.createTest("testTitle");
		utility = new Utility();
		String title = utility.getTitle();
		logger.log(Status.FAIL, "i am not getting the exact title");
		Assert.assertEquals(title, "GTPL Bank Home");
		logger.log(Status.PASS, "i am getting the exact title");
		//logger.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(title));
	}
	
	@DataProvider( name = "exceldata" )
	public Object[][] getExcelData() throws EncryptedDocumentException, IOException {
		excelReader = new ExcelReader();
		Sheet sh = excelReader.getSheet("loginpage");
		Object[][] data = excelReader.getData(sh);
		return data;
	}
	
	@Test(groups = {"validLogin"}, dataProvider = "exceldata")
	public void testValidLogin(Map<String, String> data) {
		logger = extentReports.createTest("testValidLogin");
	//	SoftAssert softAssert = new SoftAssert();
		loginPagePom = new LoginPagePom();
		loginPagePom.setLoginCredentials(data.get("userid"), data.get("password"));
		//throw new BusinessException();
	//	softAssert.assertEquals(data.get("userid").toString(), "mngr455515");
		//loginPagePom.clickOnLogin();
		//softAssert.assertAll();
	}

}
