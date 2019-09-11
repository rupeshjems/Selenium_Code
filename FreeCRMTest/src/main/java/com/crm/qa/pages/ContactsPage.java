package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	
	@FindBy(xpath=" //a[contains(text(), 'Contacts')]")
	
	WebElement contactsLabel;
	 
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name)
	{
		driver.findElement(By.xpath(""));
		// To be written by extensive xpath
	}
	
	public void createNewContact()
	{
		Select select=new Select(driver.findElement(By.name("Title")));
		
		select.selectByVisibleText("");
	}
	
	
}
