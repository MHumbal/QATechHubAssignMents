package com.qa.assignments.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.assignments.base.TestBase;
import com.qa.assignments.pages.SnapdealHomePage;

public class Assignment5 extends TestBase {

	SnapdealHomePage snapdealHomePage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		driver.get(prop.getProperty("snapdeal_url"));
		snapdealHomePage = new SnapdealHomePage();
	}
	
	@Test
	public void verifyLogin() throws InterruptedException {
		
		String accountUserName = "8153974171";
		
		Assert.assertEquals(snapdealHomePage.validateLogin("8153974171", "Master@2002"), accountUserName);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
