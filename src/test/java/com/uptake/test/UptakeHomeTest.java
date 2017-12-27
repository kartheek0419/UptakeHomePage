package com.uptake.test;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.uptake.pageobjects.AboutPage;
import com.uptake.pageobjects.AgriculturePage;
import com.uptake.pageobjects.Aviation;
import com.uptake.pageobjects.CareersPage;
import com.uptake.pageobjects.ConstructionPage;
import com.uptake.pageobjects.DataSciencePage;
import com.uptake.pageobjects.EnergyPage;
import com.uptake.pageobjects.EquipmentDealers;
import com.uptake.pageobjects.ExpertisePage;
import com.uptake.pageobjects.FleetPage;
import com.uptake.pageobjects.IndustriesPage;
import com.uptake.pageobjects.MiningPage;
import com.uptake.pageobjects.NewsAndInsight;
import com.uptake.pageobjects.OilAndGasPage;
import com.uptake.pageobjects.ProductsPage;
import com.uptake.pageobjects.RailPage;
import com.uptake.pageobjects.SecurityPage;
import com.uptake.pageobjects.UptakeHomePage;
import com.uptake.pageobjects.WindPage;
import com.uptake.utilities.AutomationCore;
import com.uptake.utilities.SeleniumHelper;

public class UptakeHomeTest
{
	private static WebDriver testDriver = null;
	private static WebDriverWait wait = null;
	private static UptakeHomePage uptakeHome;
	private static ProductsPage products;
	private static IndustriesPage industries;
	private static AboutPage about;
	private static ExpertisePage expertise;
	private static NewsAndInsight news;
	private static CareersPage careers;
	private static AgriculturePage agriculture;
	private static Aviation aviation;
	private static ConstructionPage construction;
	private static EnergyPage energy;
	private static EquipmentDealers equipmentDealers;
	private static FleetPage fleet;
	private static MiningPage mining;
	private static OilAndGasPage oilAndGas;
	private static RailPage rail;
	private static WindPage wind;
	private static DataSciencePage datascience = null;
	private static SecurityPage security= null;
	private static long testSyncTime = 60;
	private static String pageTitle = "Industrial Analytics for Global Industry | Uptake";
	
//	@Test
//	public void Navigatite() throws InterruptedException
//	{
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\lib\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.uptake.com/");
//		wait = new WebDriverWait(driver, 30);
//		home = new UptakeHomePage(driver);
//		products = new ProductsPage(driver);
//		aviation = new Aviation(driver);
//		wait.until(ExpectedConditions.visibilityOf(UptakeHomePage.getMainMenu().get(0)));
//		UptakeHomePage.getProducts();
////		wait.until(ExpectedConditions.visibilityOf(ProductsPage.getHeading()));
//				Thread.sleep(2000);
//		if(ProductsPage.getHeading().getText().equalsIgnoreCase("products"))
//		{
//			Assert.assertTrue(true);
//		}
//		else
//		{
//			
//			Assert.assertFalse(true);
//		}
//		Assert.assertTrue(driver.getCurrentUrl().contains("products"));
//		
//		
//		
//		UptakeHomePage.getEquipmentDealers();
//		Thread.sleep(2000);
//		
//		
//		driver.quit();	
//	}
	
//	@Test
//	public static void initiateBrowser()
//	{
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\lib\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		wait.until(ExpectedConditions.visibilityOf(UptakeHomePage.getMainMenu().get(1)));
//		home = new UptakeHomePage(driver);
//		driver.get("https://www.uptake.com/");
//	}
	
	@BeforeTest
	public void testInit()
	{
		testDriver = SeleniumHelper.invokeBrowser(AutomationCore.readProperties("browser"));
		boolean result = SeleniumHelper.navigate(AutomationCore.readProperties("url"), testDriver, testSyncTime, pageTitle);
		Assert.assertTrue(result, "Test initialization failed");
		
		
	}
	
	@BeforeMethod
	public void intiatePageObjects() throws InterruptedException
	{
		wait = new WebDriverWait(testDriver, 30);
		uptakeHome = new UptakeHomePage(testDriver);
		products = new ProductsPage(testDriver);
		about = new AboutPage(testDriver);
		news = new NewsAndInsight(testDriver);
		industries = new IndustriesPage(testDriver);
		expertise = new ExpertisePage(testDriver);
		careers = new CareersPage(testDriver);
		agriculture = new AgriculturePage(testDriver);
		aviation = new Aviation(testDriver);
		construction = new ConstructionPage(testDriver);
		energy = new EnergyPage(testDriver);
		equipmentDealers = new EquipmentDealers(testDriver);
		mining = new MiningPage(testDriver);
		oilAndGas = new OilAndGasPage(testDriver);
		rail = new RailPage(testDriver);
		wind = new WindPage(testDriver);	
		datascience = new DataSciencePage(testDriver);
		security = new SecurityPage(testDriver);
	}
	
	@Test(priority=0)
	public void verifyProductsNavigation()
	{
		
		boolean result = false;
		result = uptakeHome.navigateToProductsScreen();
		Assert.assertTrue(result);
		Assert.assertTrue(products.verifyPageUrl());
	}
	
	@Test(priority=1)
	public void indudustiesNavigation()
	{
		boolean result = false;
		result = uptakeHome.navigateToIndustriesScreen();
		Assert.assertTrue(result);
		Assert.assertTrue(industries.verifyPageUrl());
	}
		
	@Test(priority=2)
	public void verifyAboutNavigation()
	{
		
		boolean result = false;
		result = uptakeHome.navigateToAboutScreen();
		Assert.assertTrue(result);
		Assert.assertTrue(about.verifyPageUrl());
	}

	@Test(priority=3)
	public void expertiseNavigation()
	{
		boolean result = false;
		result = uptakeHome.navigateToExpertiseScreen();
		Assert.assertTrue(result);
		Assert.assertTrue(expertise.verifyPageUrl());
	}
	
	@Test(priority=4)
	public void verifyNewsAndInsightNavigation()
	{
		
		boolean result = false;
		result = uptakeHome.navigateToNewsInsightScreen();
		Assert.assertTrue(result);
		Assert.assertTrue(news.verifyPageUrl());
	}
	
	@Test(priority = 5)
	public void careersNavigation()
	{
		boolean result = false;
		result = uptakeHome.navigateToCareersScreen();
		Assert.assertTrue(result);
		Assert.assertTrue(careers.verifyPageUrl());
		
	}
	
	@Test(priority=6)
	public void verifyAgricultureNavigation()
	{	
		boolean result = false;
		result = uptakeHome.navigateToAgricultureScreen();
		Assert.assertTrue(result);
		Assert.assertTrue(agriculture.verifyPageUrl());
	}
		
	@Test(priority=7)
	public void verifyAviationPageNavigation()
	{
		boolean result = false;
		result = uptakeHome.navigateToAviationScreen();
		Assert.assertTrue(result);
//		wait.until(ExpectedConditions.presenceOfElementLocated())
		Assert.assertTrue(aviation.verifyPageUrl());
	}
	
	@Test(priority=8)
	public void verifyConstrutionPageNavigation()
	{
		
		boolean result = false;
		result = uptakeHome.navigateToConstuctionScreen();
		Assert.assertTrue(result);
		Assert.assertTrue(construction.verifyPageUrl());
	}
	@Test(priority=9)
	public void verifyEnergyPageNavigation()
	{
		
		boolean result = false;
		result = uptakeHome.navigateToEnergyScreen();
		Assert.assertTrue(result);
		Assert.assertTrue(energy.verifyPageUrl());
	}
	@Test(priority=10)
	public void verifyEquipmentDelearsPageNavigation()
	{
		
		boolean result = false;
		result = uptakeHome.navigateToEquipmentDealersScreen();
		Assert.assertTrue(result);
		Assert.assertTrue(equipmentDealers.verifyPageUrl());
	}
//	@Test(priority=11)
//	public void verifyFleetPageNavigation() throws InterruptedException
//	{
//		
//		boolean result = false;
//		result = uptakeHome.navigateToFleetScreen();
//		Assert.assertTrue(result);
//		Assert.assertTrue(fleet.verifyPageUrl());
//	}
	@Test(priority=12)
	public void verifyMiningNavigation()
	{
		
		boolean result = false;
		result = uptakeHome.navigateToMiningScreen();
		Assert.assertTrue(result);
		Assert.assertTrue(mining.verifyPageUrl());
	}
	
	@Test(priority=13)
	public void verifyOilAndGasNavigation()
	{
		boolean result = false;
		result = uptakeHome.navigateToOilAndGasScreen();
		Assert.assertTrue(result);
		Assert.assertTrue(oilAndGas.verifyPageUrl());
	}
	@Test(priority=14)
	public void verifyRailNavigation()
	{	
		boolean result = false;
		result = uptakeHome.navigateToRailScreen();
		Assert.assertTrue(result);
		Assert.assertTrue(rail.verifyPageUrl());
	}
	@Test(priority=15)
	public void verifyWingNavigation()
	{
		boolean result = false;
		result = uptakeHome.navigateToWindScreen();
		Assert.assertTrue(result);
		Assert.assertTrue(wind.verifyPageUrl());
	}
	
	@Test(priority=16)
	public void verifyDataScienceNavigation()
	{
		boolean result = false;
		result = uptakeHome.navigateToDataScienceScreen();
		Assert.assertTrue(result);
		Assert.assertTrue(datascience.verifyPageUrl());
	}
	@Test(priority=17)
	public void verifySecurityNavigation()
	{
		boolean result = false;
		result = uptakeHome.navigateToSecurityScreen();
		Assert.assertTrue(result);
		Assert.assertTrue(security.verifyPageUrl());
	}
	
	@AfterTest
	public void tearDown()
	{
		testDriver.quit();
	}
	
	
}
