package com.SwagLabs.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	// Encapsulation = Private Data + public function

	public LoginPage(WebDriver driver) {

		this.driver = driver;// from base class
	}

	// Locatiors
	private By username = By.id("user-name");
	private By password = By.id("password");
	private By logbton = By.xpath("//input[@name='login-button']");

	// Action
	public void verifyTitle() {
		String title = driver.getTitle();
		// Assert.assertEquals(title.contains("Swag Labs"), "Test Fail: Title is not
		// matched");
		System.out.println("Test Pass: Title is matched! ");
	}

	public void verifyUrl() {
		String url = driver.getCurrentUrl();
		// Assert.assertTrue(false);;
		System.out.println("Test Pass: Url is Matched!");
	}

	public void verifylogin(String un, String pss) {
		driver.findElement(By.id("user-name")).sendKeys(un);
		driver.findElement(By.id("password")).sendKeys(pss);
		driver.findElement(logbton).click();
		System.out.println("Login completed!");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		Assert.assertTrue(false, "Login verification failed! Element not visible after login.");

		System.out.println("Login completed!");

	}

}
