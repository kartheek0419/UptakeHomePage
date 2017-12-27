package com.uptake.utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.Constants;

import com.uptake.pageobjects.UptakeHomePage;

public class SeleniumHelper 
{
	private static WebDriver driver;
	public static String browserName;
	private static WebDriverWait wait;
	
	
	public static WebDriver invokeBrowser(String browserName)
	{
		
		switch(browserName.toLowerCase().trim())
		{
		case "chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\lib\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\lib\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			break;
		default:
			System.out.println("No Driver invoked");
			System.exit(0);
		}
		
		driver.manage().deleteAllCookies();
		
		driver.manage().window().maximize();
		
		return driver;
	}
	
	
	public static boolean navigate(String url, WebDriver driver, long syncTime, String expTitle)
	{
		try {
			driver.get(url);
			wait = new WebDriverWait(driver,syncTime);
			if(!wait.until(ExpectedConditions.titleIs(expTitle)))
			{
				return false;
			}
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	public static boolean menuNavigation(WebDriver driver, String menuName, By mainlocator, By subMenuLocator)
	{
		
		List<WebElement> menus = driver.findElements(mainlocator);
		List<WebElement> subMenus = null;
		if(subMenuLocator != null)
		{
			subMenus = driver.findElements(subMenuLocator);
		}
		String[] menuItems=null;
		try{
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
			else if(subMenus != null && menuItems != null)
			{
				if(menus.get(i).getText().trim().equalsIgnoreCase(menuItems[0]))
				{
					Actions action = new Actions(driver);
					action.moveToElement(menus.get(i)).build().perform();
//					driver.manage().timeouts().wait(1000);
					
					
					for(int j=0; j<subMenus.size(); ++j)
					{
						if(subMenus.get(j).getText().trim().equalsIgnoreCase(menuItems[1]))
						{
							subMenus.get(j).click();
							break;
						}
					}
					break;
				}
			}
		}
		Thread.sleep(2000);
		return true;
	}catch(Exception e){
		e.printStackTrace();
		return false;
		}
	}
	
	public static WebElement findElement(WebDriver driver, By by, long syncTime)
	{
		try{
			
			wait = new WebDriverWait(driver, syncTime);
			return wait.until(ExpectedConditions.elementToBeClickable(by));
			
		}catch(Exception e)
		{
			return null;
		}
	}
	
	public static String getElementText(WebElement element)
	{
		try
		{
			if(element!=null)
			{
				return element.getText().trim();
			}
		}
		catch(Exception e)
		{
			return null;
		}
		return null;
	}
	
	public static boolean validateUrl(String screen)
	{
		System.out.println(screen);
		if(driver.getCurrentUrl().contains(screen.toLowerCase().trim()))
		{
			return true;
		}
		return false;
	}

}
