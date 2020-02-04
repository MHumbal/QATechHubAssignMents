package com.qa.assignments.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.qa.assignments.base.TestBase;

public class SnapdealHomePage extends TestBase{

	// Elements
	private By signInOrUserName = By.xpath("//span[@class='accountUserName col-xs-12 reset-padding']");
	private By login = By.xpath("//a[contains(text(),'login')]");
	private By userName = By.id("userName");
	private By password = By.id("j_password_login_uc");
	
	// Methods
	public String validateLogin(String emailOrMobNo, String pass) throws InterruptedException {
		
		action.moveToElement(driver.findElement(signInOrUserName)).perform();
		driver.findElement(login).click();
		
		driver.switchTo().frame("loginIframe");
		
		WebElement userNameElement = driver.findElement(userName);
		WebElement passwordElement = driver.findElement(password);
		
		userNameElement.sendKeys(emailOrMobNo);
		userNameElement.sendKeys(Keys.RETURN);
		passwordElement.sendKeys(pass);
		passwordElement.sendKeys(Keys.RETURN);
		
		Thread.sleep(3000);
		
		return driver.findElement(signInOrUserName).getText();
		
	}
	
}
