package com.qa.assignments.tests;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.assignments.base.TestBase;
import com.qa.assignments.pages.EbayHomePage;
import com.qa.assignments.pages.EbaySearchResultPage;

public class Assignment4 extends TestBase {

	EbayHomePage ebayHomePage;
	EbaySearchResultPage ebaySearchResultPage;
	
	@BeforeSuite
	public void setUP() throws IOException {

		initialization();
		driver.get(prop.getProperty("ebay_url"));
		ebayHomePage = new EbayHomePage();
		
	}

	@Test(priority = 0)
	public void verifySearchProduct() {
		ebaySearchResultPage = ebayHomePage.validateSearchProduct("Laptop", "Computers/Tablets & Networking");
	}
	
	@Test(priority = 1)
	public void resultscount() {
		System.out.println(ebaySearchResultPage.getTotalResults());
	}
	
	@Test(priority = 2)
	public void displayProduct() {
		System.out.println(ebaySearchResultPage.getSpecificProduct(3));
	}
	
	@Test(priority = 3)
	public void displayAllProducts() {
		ebaySearchResultPage.getAndDisplayAllProducts();
	}

	@AfterSuite
	public void tearDown() {

		driver.quit();

	}
	
}