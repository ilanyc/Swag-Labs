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
		screenshot.takeScreenshot("/Users/mhasan/eclipse-workspace/NewSwagLabProject/target/screenShot/login_verifyPrduct_click.png");
	}

	@Test(priority = 3)
	public void verifyAddToCart() {

		ip.addProductToCart("Sauce Labs Fleece Jacket");
		screenshot.takeScreenshot("/Users/mhasan/eclipse-workspace/NewSwagLabProject/target/screenShot/login_addToCart_click.png");
	}

	@Test(priority = 4)
	public void verifyCartPageLaunch() {

		ip.launchCartPage();
		screenshot.takeScreenshot("/Users/mhasan/eclipse-workspace/NewSwagLabProject/target/screenShot/login_pageLaunce_click.png");
	}

}
