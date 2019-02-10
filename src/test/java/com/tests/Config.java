package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.utility.Utilits;

public class Config {

	public static WebDriver driver;
	Utilits utility = new Utilits(driver);
	@BeforeSuite(alwaysRun=true)
	public void browserinvoke() {
		driver = utility.invokeBrowser("Chrome");
	}
	
	@AfterSuite(alwaysRun=true)
	public void driverquit() {
		driver.quit();
	}

}
