package com.uptake.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uptake.utilities.SeleniumHelper;

public class OilAndGasPage 
{
	private WebDriver driver;
	private By heading = By.cssSelector("h1.hero-heading__subheading");
	private static long pageSyncTime = 60;
	private String page = "Oil and Gas";
	
	public OilAndGasPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public boolean verifyOilAndGasLabel()
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
		if(SeleniumHelper.validateUrl("oil-and-gas"))
		{
			return true;
		}
		return false;
	}
}
