package com.crm.qa.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	// Page factory (Object Repository)
	
	//span[@class='icon icon-xs mdi-chart-bar']
	
	
	
	@FindBy(linkText="Login")
	WebElement loginButton;
	
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath= "//div[@class='ui fluid large blue submit button']")

	WebElement login;
	
	
	@FindBy(xpath= "//span[@class='mdi-chart-bar icon icon-md']")

	WebElement signUpButton;
	
	@FindBy(xpath= "//div[@class='rd-navbar-brand']")

	WebElement brandLogo;
	
	//Page object initilizarion
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Action
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCrmImage() {
		return brandLogo.isDisplayed();
		 
		
	}
	public HomePage login(String mail, String pwd)
	{
		email.sendKeys(mail);
		password.sendKeys(pwd);
		loginButton.click();
		
		return new HomePage();
	} 
	

}
