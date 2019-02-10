package com.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.pages.ProductAddToCart;

public class DashboardTest extends Config {
	
	@Test(groups = {"smoke","Regression"}, priority=2)
	@Parameters("serachItem")
	public void searchForAProduct(String serachItem) {
		driver.get("https://spreecommerce-demo.herokuapp.com");
		DashboardPage searchProduct=PageFactory.initElements(driver, DashboardPage.class);
		searchProduct.searchingForAProduct(serachItem);
		assertEquals(searchProduct.sizeofProducts(), 2);
	}
	
	@Test(groups = {"Regression"}, priority=3)
	public void addProductToCart() throws InterruptedException{
		driver.get("https://spreecommerce-demo.herokuapp.com");
		LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
		login_page.login_Page_Test("sandeep.dm@live.com", "Thoughtworks");
		DashboardPage searchProduct = PageFactory.initElements(driver, DashboardPage.class);
		searchProduct.searchingForAProduct("Bag");
		ProductAddToCart productAddToCart = PageFactory.initElements(driver, ProductAddToCart.class);
		productAddToCart.addProductToCart(); 

	}

}
