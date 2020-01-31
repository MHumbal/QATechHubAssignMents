package com.qa.assignments.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.assignments.base.TestBase;
import com.qa.assignments.pages.FBLogInOrSignUpPage;

public class Assignment2 extends TestBase {

	FBLogInOrSignUpPage fbLogInOrSignUpPage;
	
	@BeforeMethod
	public void setUP() {

		initialization();
		driver.get(prop.getProperty("fb_url"));
		fbLogInOrSignUpPage = new FBLogInOrSignUpPage();

	}

	@Test(dataProvider = "UserDetails")
	public void createAnAccount(String firstName, String lastName, String mail, String confirmMail, String pass, String day, String month, String year, String gender) throws InterruptedException {
		
		fbLogInOrSignUpPage.signUP(firstName, lastName, mail, confirmMail, pass, day, month, year, gender);
		
	}
	
	@DataProvider(name = "UserDetails")
	public Object[][] getData() {
		
		Object[][] data = new Object[][]{ {"Sanjay", "Saini", "sanjay@gmail.com", "sanjay@gmail.com", "qazwsx@1290", "5", "Jan", "1995", "Male"} };
		
		return data;
		
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}
	
}
