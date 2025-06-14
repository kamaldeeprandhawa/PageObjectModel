package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//p[text()='manda user']")
	WebElement usernameLogoDropDown;
	
	@FindBy(xpath = "//span[text()='Time']")
	WebElement timeLink;
	
	@FindBy(xpath = "//span[text()='Recruitment']")
	WebElement recruitmentLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public String validateUsername() {
		return usernameLogoDropDown.getText();
	}
	
	public TimePage clickOnTimeLink() {
		timeLink.click();
		return new TimePage();
	}
	
	public RecruitmentPage clickOnRecruitmentPage() {
		recruitmentLink.click();
		return new RecruitmentPage();
	}

}
