package com.uptake.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uptake.utilities.SeleniumHelper;

public class CareersPage 
{
	private WebDriver driver;
	private By heading = By.cssSelector("h1.hero-heading__subheading");
	private static long productsPageSyncTime = 60;
	
	private static String pageHeading = "Our Team";
	private static String urlSubString = "careers";
	
	public CareersPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean verifyCareersLabel()
	{
		
		WebElement label = SeleniumHelper.findElement(driver, heading, productsPageSyncTime);		
		if(SeleniumHelper.getElementText(label).equalsIgnoreCase(pageHeading))
		{
			return true;
		}
		return false;
	}
	
	
	public boolean verifyPageUrl()
	{		
		if(SeleniumHelper.validateUrl(urlSubString))
		{
			return true;
		}
		return false;
	}
		
}
