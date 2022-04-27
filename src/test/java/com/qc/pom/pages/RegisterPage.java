package com.qc.pom.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "name")
	WebElement rName;

	@FindBy(id = "mobile")
	WebElement rMoblie;

	@FindBy(id = "email")
	WebElement rEmail;

	@FindBy(id = "password")
	WebElement rPass;

	@FindBy(className = "btn")
	WebElement rSubmit;

	public void enterName(String uName) {
		rName.clear();
		rName.sendKeys(uName);
	}

	public void enterMoblie(String uMobile) {
		rMoblie.clear();
		rMoblie.sendKeys(uMobile);
	}

	public void enterEmail(String uEmail) {
		rEmail.clear();
		rEmail.sendKeys(uEmail);
	}

	public void enterPassward(String uPass) {
		rPass.clear();
		rPass.sendKeys(uPass);
	}

	public void ClickOnSubmit() {
		rSubmit.click();
	}

	public void registerWithData(String uName, String uMoblie, String uEmail, String uPass) {
		enterName(uName);
		enterMoblie(uMoblie);
		enterEmail(uEmail);
		enterPassward(uPass);
		ClickOnSubmit();

	}

	public String getTitle() {
		return driver.getTitle();
	}

	public boolean verifyResult() {
		return getTitle().equals("Queue Codes | Registration Page");
	}

	public String handleAlert() {
     Alert alt=driver.switchTo().alert();
     String result=alt.getText();
     alt.accept();
     return result;
	}
    public boolean verifyAlert() {
    	return handleAlert().equals("User registered successfully.");
	
}
}
