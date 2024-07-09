package com.SwagLabs.TestCases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import com.SwagLabs.Pages.InventoryPage;
import com.SwagLabs.Pages.LoginPage;



public class BaseTest {
	
	public WebDriver driver;
    public LoginPage lp;
    public InventoryPage ip;
    public ScreenshotOfTest screenshot;
	

	@BeforeMethod
	@BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        lp = new LoginPage(driver);
        ip = new InventoryPage(driver);
        screenshot = new ScreenshotOfTest(driver);
	}
	
	@AfterMethod
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	

}
