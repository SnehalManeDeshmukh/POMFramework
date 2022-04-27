package com.qc.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="email")
   WebElement email;
	
	@FindBy(id="password")
	   WebElement pass;
	
	@FindBy(id="submit")
	   WebElement submit;

	@FindBy(linkText="Register a new membership")
	WebElement registerPageLink;
	
	public void enterEmail(String uName) {
		email.clear();
		email.sendKeys(uName);
		}
	public void enterPassword(String upass) {
		pass.clear();
		pass.sendKeys(upass);
		}
	public void DashboardPage() {
		ClickonSubmit();
	}
	public DashboardPage ClickonSubmit() {
		submit.click();
		return new DashboardPage(driver);
		}
	public void clickonLogin() {
		submit.click();
	}
	 public String getTitle()
	  {
		  return driver.getTitle();
	  }
	 public void clickOnRegisterPage() {
			registerPageLink.click();
			
		}
	  public boolean verifyResult()
	  {
		  return getTitle().equals("Queue Codes | Log in");
	  }

	public DashboardPage validLogin(String uName ,String upass) {
		enterEmail(uName);
		enterPassword(upass);
		return ClickonSubmit();
	}
	public void InvalidLogin(String uName ,String upass) {
		enterEmail(uName);
		enterPassword(upass);
		clickonLogin();
	}
	

   
}
