package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

import io.qameta.allure.Step;

public class LoginPage extends TestBase{
	//Page Factory - OR:
		@FindBy(name="username")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(xpath="//*[@type='submit']")
		WebElement loginBtn;
		
		@FindBy(xpath="//*[@alt='company-branding']")
		WebElement hrmLogo;
		
		@FindBy(partialLinkText = "Forgot")
		WebElement forgotPasswordLink;
		
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		@Step("Getting Login Page Title")
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		@Step("Verifying HRMImage")
		public boolean validateHRMImage(){
			return hrmLogo.isDisplayed();
		}
		
		@Step("login with username: {0} and password: {1}")
		public HomePage login(String un, String pwd){
			username.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn.click();
			    	
			return new HomePage();
		}
		

}
