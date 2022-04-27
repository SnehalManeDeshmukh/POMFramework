package com.qc.pom.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.qc.pom.pages.DashboardPage;
import com.qc.pom.pages.LoginPage;
import com.qc.pom.pages.RegisterPage;

public class POMTest extends BaseIntegration {
	@Test(dataProvider = "readLogindata")
	public void doLogin(String testName, String uName, String uPass, String expResult) throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		if (testName.equals("both are valid")) {
			DashboardPage dashboard = login.validLogin(uName, uPass);
			Assert.assertTrue(dashboard.verifyResult());
			dashboard.dologout();
		}
		else {
			login.InvalidLogin(uName, uPass);
			Assert.assertTrue(login.verifyResult());
		}
	}
	@AfterMethod
	public void Setwait() throws InterruptedException {
		Thread.sleep(2000);
	}
	@Test(dataProvider = "Registerdata")
	public void doRegister(String testName, String uName, String uMobile, String uEmail, String uPass)
			throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		if (driver.getTitle().equals("Queue Codes | Log in")) {
			login.clickOnRegisterPage();
		}
		RegisterPage register = new RegisterPage(driver);
		register.registerWithData(uName, uMobile, uEmail, uPass);
		if (testName.equals("All fields are valid")) {
			Assert.assertTrue(register.verifyAlert());

		} else {
			Assert.assertTrue(register.verifyResult());
		}
	}
}
