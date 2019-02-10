package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(how = How.ID, using = "link-to-login")
	@CacheLookup
	WebElement LoginLink;

	@FindBy(how = How.ID, using = "spree_user_email")
	@CacheLookup
	WebElement uname;

	@FindBy(how = How.ID, using = "spree_user_password")
	@CacheLookup
	WebElement password;

	@FindBy(how = How.NAME, using = "commit")
	@CacheLookup
	WebElement submit;

	@FindBy(how = How.XPATH, using = "//*[@id='nav-bar']/li[1]/a")
	@CacheLookup
	WebElement MyAccount;

	@FindBy(how = How.XPATH, using = "//*[@id='nav-bar']/li[2]/a")
	@CacheLookup
	WebElement logOut;

	public void login_Page_Test(String username, String pwd) {
		LoginLink.click();
		uname.sendKeys(username);
		password.sendKeys(pwd);
		submit.click();

	}

	public String verifyText() {

		String actual = MyAccount.getText();
		return actual;

	}

	public void logout() {
		logOut.click();

	}

}
