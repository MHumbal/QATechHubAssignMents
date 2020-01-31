package com.qa.assignments.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.qa.assignments.base.TestBase;

public class EbayHomePage extends TestBase{
	
	// Elements
	private By searchBar = By.id("gh-ac");
	private By category = By.id("gh-cat");
	private By button = By.id("gh-btn");
	
	// Methods
	public EbaySearchResultPage validateSearchProduct(String prod, String cat) {
		
		driver.findElement(searchBar).sendKeys(prod);
		Select select = new Select(driver.findElement(category));
		select.selectByVisibleText(cat);
		driver.findElement(button).click();
		
		return new EbaySearchResultPage();
		
	}
	
}
