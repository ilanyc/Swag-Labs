
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
	private By productlist = By.xpath("//div[@data-test='inventory-list']//div[@class='inventory_item_name']");
	private By addbtn = By.xpath("//button[contains(@id, 'add-to-cart')]");
	private By cart = By.xpath("//a[@class='shopping_cart_link']");

	// Actions
	public void verifyCountOfProduct() {
		int productAmount = driver.findElements(productlist).size();
		Assert.assertEquals(productAmount, 6, "Product count does not match expected value.");
		System.out.println("Number of products: " + productAmount);
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
				// Add to cart btn (assuming there is a button near the product name)
				WebElement addButton = i.findElement(By.xpath("following-sibling::button[contains(@id, 'add-to-cart')]"));
				addButton.click();
				System.out.println("Product " + pname + " added to the cart!");
				break;
			}
		}
	}

	public void launchCartPage() {
		driver.findElement(cart).click();
		System.out.println("Cart page launched");
	}
}