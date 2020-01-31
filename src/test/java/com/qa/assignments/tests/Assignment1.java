package com.qa.assignments.tests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.assignments.base.TestBase;
import com.qa.assignments.pages.QATechHubHomePage;

public class Assignment1 extends TestBase{

	QATechHubHomePage qaTechHubHomePage;
	String currentUrl;

	@BeforeSuite
	public void setUP() {

		initialization();
		driver.get(prop.getProperty("qatechhub_url"));
		qaTechHubHomePage = new QATechHubHomePage();

	}

	@Test(priority=0)
	public void verifyPageTitle() {

		Assert.assertEquals(qaTechHubHomePage.validatePageTitle(), "QA Automation Tools Trainings and Tutorials | QA Tech Hub");

	}

	@Test(priority= 1)
	public void navigationBackAndForth() {

		driver.navigate().to(prop.getProperty("fb_url"));

		currentUrl = driver.getCurrentUrl();

		System.out.println("Navigated to FB : Current URL :: " + currentUrl);

		driver.navigate().back();

		currentUrl = driver.getCurrentUrl();

		System.out.println("Back : Current URL :: " + currentUrl);

		driver.navigate().forward();

		currentUrl = driver.getCurrentUrl();

		System.out.println("Forward : Current URL :: " + currentUrl);

		driver.navigate().refresh();
		
		currentUrl = driver.getCurrentUrl();

		System.out.println("Refresh : Current URL :: " + currentUrl);

	}

	@AfterSuite
	public void tearDown() {

		driver.quit();

	}

}
