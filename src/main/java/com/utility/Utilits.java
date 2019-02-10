package com.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Utilits {
	
	WebDriver driver;
	
	public Utilits(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebDriver invokeBrowser(String browserName) {
		
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	public String getTextValue(WebElement element, WebDriver driver) {
		
		return	element.getText();

	}
	
	public static WebDriver normalWait(WebDriver driver1) {
		driver1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver1;
	}
	
	public WebDriver elementToVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));
		return driver;
	}

}
