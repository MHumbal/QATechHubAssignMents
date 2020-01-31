package com.qa.assignments.tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.assignments.base.TestBase;

public class Assignment3 extends TestBase{

	List<WebElement> allLinks;
	BufferedWriter writer;

	@BeforeSuite
	public void setUP() throws IOException {

		initialization();
		driver.get(prop.getProperty("flipkart_url"));
		writer = new BufferedWriter(new FileWriter("C:\\Users\\ZTI\\Desktop\\Links.txt"));

	}

	@Test(priority = 0)
	public void getLinksCount() {

		allLinks= driver.findElements(By.tagName("a"));
		int linksCount = allLinks.size();
		System.out.println(linksCount);

	}

	@Test(priority = 1)
	public void printLinksWithText() throws IOException {

		for(WebElement link : allLinks) {
			writer.write(link.getText() + " : " + link.getAttribute("href"));
			writer.newLine();
		}

	}

	@AfterSuite
	public void tearDown() {

		driver.quit();

	}

}
