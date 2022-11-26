package com.listner;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ecom.utility.Utility;

public class MyListner implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) {
	    System.out.println(result.getName()+" test case startred....");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		try {
			Utility.takeScreenShot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
	    // not implemented
	}

}
