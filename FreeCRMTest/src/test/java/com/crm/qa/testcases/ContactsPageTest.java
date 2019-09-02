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

public class ContactsPageTest extends TestBase{

	LoginPage loginPage; 
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	
	public ContactsPageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup()
	{
		initilization();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
		contactsPage=new ContactsPage();
		homePage=loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		testUtil.switchToFrame();
		homePage.clickContectsLink();
		
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel()
	{
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts label is missing on this page");
	}
	
	@Test(priority=2)
	public void selectContectsTest()
	{
		contactsPage.selectContactsByName("Test1 Test");
	}
	
	
	@Test(priority=3)
	public void selectMultipleContectsTest()
	{
		contactsPage.selectContactsByName("Test1 Test");
		contactsPage.selectContactsByName("Util1 Util");
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
