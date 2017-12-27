package com.uptake.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uptake.utilities.SeleniumHelper;

public class ExpertisePage 
{
	
	private WebDriver driver;
	private By heading = By.cssSelector("h1.hero-heading__subheading");
	private static long productsPageSyncTime = 60;
	
	public ExpertisePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean verifyExpertiseLabel()
	{
		
		WebElement label = SeleniumHelper.findElement(driver, heading, productsPageSyncTime);		
		if(SeleniumHelper.getElementText(label).equalsIgnoreCase("Our Expertise"))
		{
			return true;
		}
		return false;
	}
	
	
	public boolean verifyPageUrl()
	{		
		if(SeleniumHelper.validateUrl("expertise"))
		{
			return true;
		}
		return false;
	}
	
}
