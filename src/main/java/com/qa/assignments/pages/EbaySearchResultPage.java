package com.qa.assignments.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.assignments.base.TestBase;

public class EbaySearchResultPage extends TestBase {

	List<WebElement> productTitles; 

	// Elements
	private By totalResults = By.xpath("//h1//span[1]");

	private By productTitle = By.xpath("//li[contains(@id, 'srp-river-results-listing')]//h3");

	//Methods
	public int getTotalResults() {

		return Integer.parseInt(driver.findElement(totalResults).getText().replaceAll(",", ""));

	}

	public String getSpecificProduct(int index) {

		productTitles = driver.findElements(productTitle);

		return productTitles.get(index-1).getText();

	}

	public void getAndDisplayAllProducts() {
		for(WebElement product : productTitles) {
			action.moveToElement(product).perform();
			System.out.println(product.getText());
		}
	}

}
