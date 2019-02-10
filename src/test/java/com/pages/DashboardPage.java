package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage {

	WebDriver driver;


	public DashboardPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}

	@FindBy(how=How.ID,using="keywords")
	@CacheLookup
	WebElement Search;

	@FindBy(how=How.XPATH,using="//input[@value='Search']")
	@CacheLookup
	WebElement searchButton;

	@FindBy(how=How.XPATH,using="//div[@id='products']//div[contains(@id,'product_')]")
	@CacheLookup
	WebElement Allproduct;


	@FindBy(how=How.XPATH,using="//div[contains(@id,'product_')]")
	@CacheLookup
	WebElement Allproducts;

	@FindBy(how=How.XPATH,using="//div[@id='products']//div[contains(@id,'product_')]//a[2][@class='info']")
	@CacheLookup
	WebElement Productnames;


	public void searchingForAProduct(String product)
	{
		Search.sendKeys(product);
		searchButton.click();
	}

	public int sizeofProducts()
	{
		//List<WebElement> products  = driver.findElements(By.xpath("//div[@id='products']//div[contains(@id,'product_')]"));
		List<WebElement> products  = driver.findElements(By.xpath("//div[contains(@id,'product_')]"));

		int sizes = products.size();
		return sizes;
	}

	public void nameOfProducts()
	{

		List<WebElement> productsNames  = driver.findElements(By.xpath("//div[@id='products']//div[contains(@id,'product_')]//a[2][@class='info']"));
		for (WebElement name: productsNames) {

			System.out.println("getText :: "+name.getText());
		}

	}

}
