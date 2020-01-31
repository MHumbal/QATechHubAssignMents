package com.qa.assignments.pages;

import com.qa.assignments.base.TestBase;

public class QATechHubHomePage extends TestBase{

	// Elements
	
	
	// Methods
	public String validatePageTitle() {
		return driver.getTitle();
	}

}
