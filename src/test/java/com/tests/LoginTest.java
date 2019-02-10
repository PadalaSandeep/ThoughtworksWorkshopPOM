package com.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.pages.LoginPage;

public class LoginTest extends Config{
	
	@Test(groups = {"smoke", "Regression"}, priority=1)
	public void login() {
		driver.get("https://spreecommerce-demo.herokuapp.com");
		LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
		login_page.login_Page_Test("sandeep.dm@live.com", "Thoughtworks");
		assertEquals(login_page.verifyText().toString(), "My Account");
		login_page.logout();
	}

}
