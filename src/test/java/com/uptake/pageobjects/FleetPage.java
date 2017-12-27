package com.uptake.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uptake.utilities.SeleniumHelper;

public class FleetPage 
{
	private WebDriver driver;
	private By heading = By.cssSelector("h1.hero-heading__subheading");
	private static long pageSyncTime = 60;
	private String page = "Fleet";
	
	
	public FleetPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public boolean verifyFleetLabel()
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
