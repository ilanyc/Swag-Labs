package com.SwagLabs.Pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class InventoryPage {
	
	private WebDriver driver;

     public InventoryPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	private By productlist = By.xpath("//div[@data-test='inventory-list']//div[@class='inventory_item_name ']");
	private By addbtn = By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']");
	private By cart = By.xpath("//a[@class='shopping_cart_link']");

//actions

	public void verifyCountOfProduct() {
		int productAmount = driver.findElements(productlist).size();
		
//		Assert.assertEquals(6, "Test fail");
		System.out.println(productAmount);
	}

	public void ProductList() {

		List<WebElement> list = driver.findElements(productlist);
		System.out.println("****** Product Details *******");

		for (WebElement i : list) {

			System.out.println(i.getText());

		}
	}

	public void addProductToCart(String pname) {

		List<WebElement> list = driver.findElements(productlist);
		for (WebElement i : list) {

			if (i.getText().contains(pname)) {
				i.click();
				break;
			}
		}

		// add to cart btn
		driver.findElement(addbtn).click();
		;
		System.out.println("Product " + pname + "Added to the cart!");
	}

	public void launchCartPage() {
		driver.findElement(cart).click();
		System.out.println("Cart page launch");

	}
}



