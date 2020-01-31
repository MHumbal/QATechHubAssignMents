package com.qa.assignments.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.qa.assignments.base.TestBase;

public class FBLogInOrSignUpPage extends TestBase {

	Select select;

	// Elements
	private By fName = By.id("u_0_m");
	private By lName = By.id("u_0_o");
	private By mail = By.id("u_0_r");
	private By confirmMail = By.id("u_0_u");
	private By password = By.id("u_0_w");
	private By bDay_Day = By.id("day");
	private By bDay_Month = By.id("month");
	private By bDay_Year = By.id("year");
	private By gender_Female = By.id("u_0_6");
	private By gender_Male = By.id("u_0_7");
	private By signUpButton = By.id("u_0_13");
	private By verifyCodeHeader = By.className("uiHeaderTitle");

	// Methods
	public String signUP(String firstName, String lastName, String email, String confirmEmail, String pass, String day, String month, String year, String gender) throws InterruptedException {

		driver.findElement(fName).sendKeys(firstName);
		driver.findElement(lName).sendKeys(lastName);
		driver.findElement(mail).sendKeys(email);
		driver.findElement(confirmMail).sendKeys(confirmEmail);
		driver.findElement(password).sendKeys(pass);
		select = new Select(driver.findElement(bDay_Day));
		select.selectByVisibleText(day);
		select = new Select(driver.findElement(bDay_Month));
		select.selectByVisibleText(month);
		select = new Select(driver.findElement(bDay_Year));
		select.selectByVisibleText(year);
		Thread.sleep(1000);
		if(gender.equals("Male")) {
			driver.findElement(gender_Male).click();
		}else if(gender.equals("Female")) {
			driver.findElement(gender_Female).click();
		}
		Thread.sleep(1000);
		driver.findElement(signUpButton).click();
		
		return driver.findElement(verifyCodeHeader).getText();

	}

}
