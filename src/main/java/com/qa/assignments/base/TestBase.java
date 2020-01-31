package com.qa.assignments.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	// We are Using "public static" because we are using it in static method and other classes
	public static Properties prop;
	public static FileInputStream input;
	public static WebDriver driver;
	public static Actions action;

	public TestBase() {

		try {

			// Initializing Properties to use properties file elements
			prop = new Properties();
			input = new FileInputStream("./src/main/java/com/qa/assignments/config/config.properties");
			prop.load(input);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Using static method to call it directly in child class
	public static void initialization() {

		// Selecting browser
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equals("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		action = new Actions(driver);

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Maximizing browser window
		driver.manage().window().maximize();

	}

}
