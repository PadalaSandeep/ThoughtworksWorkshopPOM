package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductAddToCart {
	WebDriver driver;

	public ProductAddToCart(WebDriver ldriver) {
		this.driver = ldriver;
	}


	@FindBy(how=How.ID,using="keywords")
	@CacheLookup
	WebElement Search;

	@FindBy(how=How.XPATH,using="//div[@id='products']//div[contains(@id,'product_')][2]//input[@name='quantity']")
	@CacheLookup
	WebElement quanityOfProduct;

	@FindBy(how=How.XPATH,using="//div[@id='products']//div[contains(@id,'product_')][2]//button[@name='button']")
	@CacheLookup
	WebElement addProductToCart;

	@FindBy(how=How.XPATH,using="//li[@id='link-to-cart']//a")
	@CacheLookup
	WebElement BtnCart;
	
	public void addProductToCart() throws InterruptedException {
		quanityOfProduct.clear();
		quanityOfProduct.sendKeys("2");
		addProductToCart.click();
	}
}
