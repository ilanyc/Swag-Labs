package com.SwagLabs.TestCases;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ExtentListener.class)
public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void VerifyApplicationUrl() {

		lp.verifyUrl();
	screenshot.takeScreenshot("/Users/mhasan/eclipse-workspace/NewSwagLabProject/target/screenShot/login_verifyUrl_click.png");
	}

	@Test(priority = 2)
	public void VerifyApplicationTitle() {
		lp.verifyTitle();
		screenshot.takeScreenshot("/Users/mhasan/eclipse-workspace/NewSwagLabProject/target/screenShot/login_verifytitle_click.png");
	}

	@Test(priority = 3)
	public void VerifyApplicationLogin() {
		lp.verifylogin("standard_user", "secret_sauce");
		screenshot.takeScreenshot("/Users/mhasan/eclipse-workspace/NewSwagLabProject/target/screenShot/login_verifyAplication_click.png");
	}
	
	

}
