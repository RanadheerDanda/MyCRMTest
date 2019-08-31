package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homepage;
	public LoginPageTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage=new LoginPage();
	}
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=loginPage.validateLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.","Title is incorrect");
	}
	@Test(priority=2)
	public void verifyCurrentURL() {
		String URL=loginPage.getCurrentURL();
		Assert.assertEquals(URL, "https://classic.crmpro.com/index.html","URL is incorrect");
	}
	@Test(priority=3)
	public void verifyLoginPageLogo() {
		boolean flag=loginPage.isLogoDisplayed();
		Assert.assertTrue(flag, "Logo is not dispalyed");
	}
	@Test(priority=4)
	public void LoginTest() {
	homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	
	}
}
