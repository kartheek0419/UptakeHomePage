package com.uptake.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReadProp {
	
	private static String nav = "nav[data-nav-group='base']>ul>li>a";
	private static String subMen = "//ul[@class='site-nav__subnav']/li/a";

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		String Nav = "nav[data-nav-group='base']";
		
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.uptake.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(Nav)));
		System.out.println("No of link : "+driver.findElements(By.cssSelector("nav[data-nav-group='base']>ul>li>a")).size());
		
		menuNavigation(driver,"expertise:security");
		
	}
	
	public static void menuNavigation(WebDriver driver, String menuName) throws InterruptedException
	{
		
		List<WebElement> menus = driver.findElements(By.cssSelector(nav));
		List<WebElement> subMenus = driver.findElements(By.xpath(subMen));
		String[] menuItems=null;
		for(int i=0; i<menus.size(); ++i)
		{
			if(menuName.contains(":"))
			{
				menuItems = menuName.split(":");
			}
			if(menuItems==null)
			{
				if(menus.get(i).getText().trim().equalsIgnoreCase(menuName))
				{
					menus.get(i).click();
					break;
				}
			}
			else
			{
				if(menus.get(i).getText().trim().equalsIgnoreCase(menuItems[0]))
				{
					Actions action = new Actions(driver);
					action.moveToElement(menus.get(i)).build().perform();
//					driver.manage().timeouts().wait(1000);
					
					
					for(int j=0; j<subMenus.size(); ++j)
					{
						System.out.println(subMenus.get(j).getText().trim());
						if(subMenus.get(j).getText().trim().equalsIgnoreCase(menuItems[1]))
						{
							System.out.println("No of sublinks : "+ subMenus.size());
							subMenus.get(j).click();
							break;
						}
					}
					break;
				}
			}
		}
	}
	
	public static void navigate(WebDriver driver, String menuName)
	{
		List<WebElement> links = driver.findElements(By.cssSelector(nav));
		
		String[] sublinks=null;
		
		for(int i=0; i<links.size(); ++i)
		{
			if(menuName.contains(":"))
			{
				sublinks = menuName.split(":");
			}
			if(menuName.trim().equalsIgnoreCase(links.get(i).getText().trim()))
			{
				links.get(i).click();
				break;
			}
			
			else
			{
				System.out.println("No Such link");
			}
		}
		
	}

}
