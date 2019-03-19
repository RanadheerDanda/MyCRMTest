package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@class='img-responsive']")	
	WebElement logo;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUp;
	
	/* Initializing the page element*/
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	public boolean isLogoDisplayed() {
		return logo.isDisplayed();
	}
	
	public HomePage login(String un,String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		//loginBtn.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", loginBtn);
		return new HomePage();
		
	}
	
	

}
