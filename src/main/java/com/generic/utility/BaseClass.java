package com.generic.utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public PropertyFileUtility putil = new PropertyFileUtility();
	public WebDriverUtility wutil = new WebDriverUtility();
	public JavaUtility jutil = new JavaUtility();

	public WebDriver d = null;
	public static WebDriver SDriver;
	
	@BeforeSuite
	public void BeforeSuite() {
		System.out.println("===== Database Connection Successful =====");
	}

	@BeforeClass
	public void BCConfigLaunchBrowser() throws IOException {
		String BROWSER = putil.getDataFromPropertiesFile("browser");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			d = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			d = new FirefoxDriver();
		} else {
			System.out.println("Please enter valid browser name...!");
		}
		
		SDriver = d;

		wutil.maximiseWindow(d);

		wutil.waitForPageLoad(d);
		String URL = putil.getDataFromPropertiesFile("url");
		d.get(URL);
	}

	@BeforeMethod
	public void BMCongigLogin() throws IOException {
		System.out.println("Login");
	}

	@AfterMethod
	public void AMConfigOgout() {
		System.out.println("Logout Successful");
	}

	@AfterClass
	public void ACConfigLogout() {
		d.quit();
	}

	@AfterSuite
	public void AfterSuite() {
		System.out.println("===== Database Connection Close =====");
	}
}
