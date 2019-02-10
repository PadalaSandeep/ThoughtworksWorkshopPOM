package com.tests;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.utility.Utilits;

public class DataProviderLoginTest {
	WebDriver driver;
	Utilits utility = new Utilits(driver);


	@BeforeTest(alwaysRun=true)
	public void browserinvoke() {

		driver = utility.invokeBrowser("chrome");
	}

	@DataProvider(name ="Logindetails")
	public static Object[][] loginData(){
		return  new  Object[][] {{"sandeep.dm@live.com", "Thoughtworks"},{"sandeep.dm@live.com", "Thought"}};
	}

	LoginPage login_page;
	@Test(dataProvider = "Logindetails")
	public void loginIntoSpreecommercePOM(String uname, String pwd) throws InterruptedException {
		
		driver.get("https://spreecommerce-demo.herokuapp.com");

		login_page=PageFactory.initElements(driver, LoginPage.class);
		login_page.login_Page_Test(uname,pwd);
		assertEquals(login_page.verifyText().toString(), "My Account");

	}

	@AfterMethod
	public void logout() {
		login_page.logout();
	}


	@AfterSuite(alwaysRun=true)
	public void driverquit() {
		driver.quit();
	}
}
