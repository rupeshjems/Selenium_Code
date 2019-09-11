package com.crm.qa.pages;
 
 

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	

	@FindBy(xpath="//td[contains(text(),'User: Rupesh  SIngh')]")
	
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(), 'Contacts')]")
	
	WebElement contactsLink;
	
    @FindBy(xpath="//a[contains(text(), 'New Contact')]")
	
	WebElement newContactsLink;
	
	
	@FindBy(xpath="//a[contains(text(), 'Deals')]")
	
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(), 'Tasks')]")
	
	WebElement tasksLink;
	
	public void HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName()
	{
		 return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickContectsLink()
	{
		contactsLink.click();
		return new ContactsPage();
		
		
	}
	
	public DealsPage clickDealsLink()
	{
		dealsLink.click();
		return new DealsPage();
		
		
	}
	
	public TasksPage clickTasksLink()
	{
		tasksLink.click();
		return new TasksPage();
		
		
	}
	
	
	public void clickOnNewContact()
	{
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
	}
	
	
}
