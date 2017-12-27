package com.uptake.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uptake.utilities.SeleniumHelper;

public class NewsAndInsight 
{
	
	private WebDriver driver;
	
	private By heading = By.cssSelector("div.l-split__content>div>a>h2");
	private long productsPageSyncTime = 60;
	
	public NewsAndInsight(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement getHeading()
	{
		return driver.findElement(this.heading);
	}
	
	
	public boolean verifyProductsLabel()
	{		
		WebElement label = SeleniumHelper.findElement(driver, heading, productsPageSyncTime);		
		if(SeleniumHelper.getElementText(label).contains("INDUSTRY"))
		{
			return true;
		}
		return false;
	}
	
	
	public boolean verifyPageUrl()
	{		
		if(SeleniumHelper.validateUrl("https://www.uptake.com/blog"))
		{
			return true;
		}
		return false;
	}

}
