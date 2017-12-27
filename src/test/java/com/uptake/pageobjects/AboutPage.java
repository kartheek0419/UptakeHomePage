package com.uptake.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uptake.utilities.SeleniumHelper;

public class AboutPage 
{
	
	private WebDriver driver;
	
	private By heading = By.cssSelector("h1.hero-heading__subheading");
	private static long productsPageSyncTime = 60;
	private static String page = "ABOUT UPTAKE";
	
	public AboutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public boolean verifyAboutLabel()
	{
		
		WebElement label = SeleniumHelper.findElement(driver, heading, productsPageSyncTime);		
		if(SeleniumHelper.getElementText(label).equalsIgnoreCase(page))
		{
			return true;
		}
		return false;
	}
	
	public boolean verifyPageUrl()
	{		
		if(SeleniumHelper.validateUrl("about"))
		{
			return true;
		}
		return false;
	}
	
}
