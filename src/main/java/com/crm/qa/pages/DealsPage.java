package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase{
	@FindBy(xpath = "//td[contains(text(),'Deals')]")
	WebElement dealsLabel;

	@FindBy(xpath = "//input[@id='title']")
	WebElement title;

	@FindBy(xpath = "//input[@name='client_lookup']")
	WebElement company;

	@FindBy(name = "amount")
	WebElement amount;

	@FindBy(xpath = "//input[@type='submit' and @value='Save and Create Another']//preceding-sibling::input")
	WebElement saveBtn;
	@FindBy(xpath="//input[@value='Export']//parent::td//preceding-sibling::td")
	WebElement DealsLabel;
	
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyDealsLabel() {
		return DealsLabel.isDisplayed();
	}
	public void createNewDeal(String tit, String amnt, String comp){
		
		
		title.sendKeys(tit);
		company.sendKeys(comp);
		amount.sendKeys(amnt);
		saveBtn.click();
		
	}
	
	public void dealDetails(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']")).click();
		
	}

}
