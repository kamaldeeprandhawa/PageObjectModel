package com.crm.qa.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.RecruitmentPage;
import com.crm.qa.util.KeywordData;
import com.crm.qa.util.TestUtil;
import com.fasterxml.jackson.core.type.TypeReference;



public class RecruitmentPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	RecruitmentPage recruitmentPage;
	
	public RecruitmentPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		intilization();
		loginPage = new LoginPage();
		recruitmentPage = new RecruitmentPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		recruitmentPage = homePage.clickOnRecruitmentPage();
	}
	
	@Test(priority = 1)
	public void verifyRecruitmentPageLabel() {
		Assert.assertTrue(recruitmentPage.verifyRecruitmentPage());
	}
	
	@DataProvider
	public Object[][] getKeywordTestData(){
		return TestUtil.readJsonDataProvider("C:\\Users\\khehra\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\keywordTestData.json", 
				new TypeReference<List<KeywordData>>() {});
	}
	
	
	@Test(priority = 2, dataProvider = "getKeywordTestData")
	public void verifySearchButton(KeywordData keyword) {
		recruitmentPage.enterKeywordToFind(keyword.getKeyword());
		Assert.assertTrue(recruitmentPage.verifyRecordFoundLabel());
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
