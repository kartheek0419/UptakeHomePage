package com.uptake.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uptake.utilities.SeleniumHelper;

public class ConstructionPage 
{
	
	private static WebDriver driver;
	private static By heading = By.cssSelector("h1.hero-heading__subheading");
	private String page = "Construction";
	private static long pageSyncTime = 60;
	
	public ConstructionPage(WebDriver driver)
	{
		ConstructionPage.driver = driver;
	}
	
	public boolean verifyConstructionLabel()
	{
		
		WebElement label = SeleniumHelper.findElement(driver, heading, pageSyncTime);		
		if(SeleniumHelper.getElementText(label).equalsIgnoreCase(page))
		{
			return true;
		}
		return false;
	}
	
	
	public boolean verifyPageUrl()
	{		
		if(SeleniumHelper.validateUrl(page.toLowerCase()))
		{
			return true;
		}
		return false;
	}
	
}
