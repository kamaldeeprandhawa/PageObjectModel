package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.RecruitmentPage;
import com.crm.qa.pages.TimePage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TimePage timePage;
	RecruitmentPage recruitmentPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		intilization();
		loginPage = new LoginPage();
		timePage = new TimePage();
		recruitmentPage = new RecruitmentPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void homePageTitleTest() {
		String actualTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}
	
	@Test(priority = 2)
	public void validateUsernameTest() {
		String actualUsername = homePage.validateUsername();
		Assert.assertEquals(actualUsername, "manda user");
	}
	
	@Test(priority = 3)
	public void clickTimePageTest() {
		timePage = homePage.clickOnTimeLink();
	}
	
	@Test(priority = 4)
	public void clickRecruitmentPageTest() {
		recruitmentPage = homePage.clickOnRecruitmentPage();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
