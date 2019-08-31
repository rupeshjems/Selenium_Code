package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;

	
	public TestBase()
	{
	
		try {
			prop=new Properties();
			FileInputStream input=new FileInputStream("R:\\Github_Local\\Selenium_Code\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config");
			prop.load(input);
			System.out.println("Hi Here");
			
		}
		catch(FileNotFoundException fnfe)
		{
			fnfe.printStackTrace();	
			System.out.println("Also Here");
			
		}
		catch(IOException ioe)

		{
			ioe.printStackTrace();
			System.out.println("Even Here");
		}
		
	}
	
	public static void initilization()
	{
		String browserName=prop.getProperty("browser");
		 
		if(browserName.contentEquals("chrome"))
		{
			 
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rupesh\\Downloads\\chromedriver.exe");
		 
			
		}
		else if(browserName.contentEquals("Microsoft Edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Rupesh\\Downloads\\msedgedriver");
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
	}
	
	
	

}
