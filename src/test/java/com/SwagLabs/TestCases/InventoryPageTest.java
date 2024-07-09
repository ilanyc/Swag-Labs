package com.SwagLabs.TestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ExtentListener.class)
public class InventoryPageTest extends BaseTest {


	@Test(priority = 1)
	public void verifyTotalProduct() {

		ip.verifyCountOfProduct();

	}

	@Test(priority = 2)
	public void verifyProductDetails() {

		ip.ProductList();
	}

	@Test(priority = 3)
	public void verifyAddToCart() {

		ip.addProductToCart("Sauce Labs Fleece Jacket");
	}

	@Test(priority = 4)
	public void verifyCartPageLaunch() {

		ip.launchCartPage();

	}

}
