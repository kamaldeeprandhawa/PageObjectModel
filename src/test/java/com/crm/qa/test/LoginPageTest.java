package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.qa.listener.TestAllureReportListener;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;

@Listeners({TestAllureReportListener.class})
public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		intilization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1, description = "Verify Login Page Title test")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description : Verify Login Page Title")
	@Story("Story Name : Check Login Page Title")
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@Test(priority=2, description = "verify CRM logo test")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description : CRM Logo verification")
	@Story("Story Name : Check CRM Logo")
	public void crmLogoImageTest(){
		boolean flag = loginPage.validateHRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3, description = "login into app test")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description : verify login into application with username and password")
	@Story("Story Name : Check Login functionality")
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
