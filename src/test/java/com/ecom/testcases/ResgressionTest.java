package com.ecom.testcases;

import org.testng.annotations.Test;

public class ResgressionTest {
	
	@Test(groups = {"smoke"}, dependsOnGroups = {"sanity"})
	public void test1() {
		System.out.println("in test1");
	}
	
	@Test(groups = {"regression","smoke"})
	public void test2() {
		System.out.println("in test2");
	}
	
	@Test(invocationCount = 3)
	public void test3() {
		System.out.println("in test3");
	}
	
	@Test(groups = {"sanity"})
	public void test4() {
		System.out.println("in test4");
	}
	
	@Test
	public void test5() {
		System.out.println("in test5");
	}

}
