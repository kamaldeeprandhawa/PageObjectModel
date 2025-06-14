package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class RecruitmentPage extends TestBase{
	
	@FindBy(xpath = "//*[contains(@placeholder,'words')]")
	WebElement keywordInputBox;
	
	@FindBy(xpath = "//*[contains(@class,'breadcrumb') and text()='Recruitment']")
	WebElement recruitmentPageLabel;
	
	@FindBy(xpath = "//*[@type='submit']")
	WebElement searchButton;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")
	WebElement recordFoundLabel;
	
	public RecruitmentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyRecruitmentPage() {
		return recruitmentPageLabel.isDisplayed();
	}
	
	public void enterKeywordToFind(String key) {
		keywordInputBox.sendKeys(key);
		searchButton.click();
	}
	
	public boolean verifyRecordFoundLabel() {
		return recordFoundLabel.isDisplayed();
	}

}
