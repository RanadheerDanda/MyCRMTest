package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;

public class DealsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	DealsPage dealsPage;

	String sheetName = "Deals";

	public DealsPageTest() {
		super();

	}

	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();
		testUtil = new TestUtil();
		dealsPage = new DealsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.runTimeInfo("error", "login successful");
		testUtil.switchToFrame();
		dealsPage = homePage.clickOnDealsLink();
	}

	@Test(priority = 1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(dealsPage.verifyDealsLabel(), "Deals label is missing on the page");
	}
	@Test(priority=2)
	public void selectSingleDealsTest(){
		
		dealsPage.dealDetails("Test Deal");
	}
	@Test(priority=3)
	public void selectMultipleContactsTest(){
		dealsPage.dealDetails("Test Deal");
		//dealsPage.dealDetails("Test2");

	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewDeals(String title, String amount, String company){
		homePage.clickOnNewDealLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		dealsPage.createNewDeal(title, amount,company );
		}
		

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
