package com.qc.pom.testcases;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import com.qc.pom.utils.TestUtils;


public class BaseIntegration {
	TestUtils test=new TestUtils();
	Properties prop;
	WebDriver driver;
	WebElement email, pass, submit, logout,regLink,rName,rMobile,rEmail,logLink,rPass;
	SoftAssert sa = new SoftAssert();
	String actResult, expResult,name,mobile,email1,password;
	
	@BeforeSuite

	public void doSetup() throws IOException {
		prop=test.readPropData();
		if(prop.getProperty("browser").equals("chrome")) {
			System.setProperty(prop.getProperty("WebDriverKey"),prop.getProperty("WebDriverValue"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		driver.get(prop.getProperty("SiteURL"));
	} 
	@DataProvider
	public Object[][]readLogindata() throws IOException{
		return test.readExcelData("LoginSheet");
	}
	@DataProvider
	public Object[][]Registerdata() throws IOException{
		return test.readExcelData("RegisterSheet");
	}
  @AfterSuite
	public void tearDown() {
		driver.close();
		sa.assertAll();
	}
}
