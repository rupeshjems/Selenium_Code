package com.crm.qa.testcases;

 
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{

	
	LoginPage loginPage; 
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	
	public HomePageTest()
	{
		super();
	}
	
	//Testcases should be independent
	//Before each TC launch the browser and close
	@BeforeMethod
	public void setup()
	{
		initilization();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
		contactsPage=new ContactsPage();
		homePage=loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		
	}	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle=homePage.verifyHomePageTitle();
		 
		Assert.assertEquals(homePageTitle,"CRMPRO", "Home page title did not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		testUtil.switchToFrame(); 
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		testUtil.switchToFrame(); 
		contactsPage= homePage.clickContectsLink();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
