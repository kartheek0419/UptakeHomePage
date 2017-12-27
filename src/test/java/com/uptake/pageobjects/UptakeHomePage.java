package com.uptake.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uptake.utilities.SeleniumHelper;

public class UptakeHomePage
{
	
	private WebDriver uptakeHomeDriver;
		
	private  By mainMenu = By.cssSelector("nav[data-nav-group='base']>ul>li>a");
	private  By subMenu = By.cssSelector("ul.site-nav__subnav > li > a");
	private  ProductsPage productsPageObj = null;
	private IndustriesPage industriesPageObj = null;
	private AboutPage aboutPageObj = null;
	private ExpertisePage expertisePageObj = null;
	private AgriculturePage agriculturePageObj = null;
	private Aviation aviationPageObj = null;
	private NewsAndInsight newsPageObj = null;
	private CareersPage careersPageObj = null;
	private ConstructionPage constructionPageObj = null;
	private EnergyPage energyPageObj = null;
	private EquipmentDealers equipmentPageObj = null;
	private FleetPage fleetPageObj = null;
	private MiningPage miningPageObj = null;
	private OilAndGasPage oilAngGasPageObj = null;
	private RailPage railPageObj = null;
	private WindPage windPageObj = null;
	private DataSciencePage dataSciencePageObj = null;
	private SecurityPage securityPageObj = null;
	
	
	public UptakeHomePage(WebDriver driver)
	{
		this.uptakeHomeDriver = driver;
		productsPageObj = new ProductsPage(driver);
		industriesPageObj = new IndustriesPage(driver);
		aboutPageObj = new AboutPage(driver);
		expertisePageObj = new ExpertisePage(driver);
		newsPageObj = new NewsAndInsight(driver);
		careersPageObj = new CareersPage(driver);
		agriculturePageObj = new AgriculturePage(driver);
		aviationPageObj = new Aviation(driver);
		constructionPageObj = new ConstructionPage(driver);
		energyPageObj = new EnergyPage(driver);	
		equipmentPageObj = new EquipmentDealers(driver);
		fleetPageObj = new FleetPage(driver);
		miningPageObj = new MiningPage(driver);
		oilAngGasPageObj = new OilAndGasPage(driver);
		railPageObj = new RailPage(driver);
		windPageObj = new WindPage(driver);
		dataSciencePageObj = new DataSciencePage(driver);
		securityPageObj = new SecurityPage(driver);
	}
	
	public  List<WebElement> getMainMenu()
	{
		return uptakeHomeDriver.findElements(mainMenu);
	}
	
	public  List<WebElement> getSubMenu()
	{
		return uptakeHomeDriver.findElements(subMenu);
	}
	
	public boolean navigateToProductsScreen()
	{
		if(SeleniumHelper.menuNavigation(uptakeHomeDriver, "PRODUCTS", mainMenu, null) != true)
		{
			return false;
		}		
		if(productsPageObj.verifyProductsLabel() != true)
		{
			return false;
		}		
		return true;
	}
	
	public boolean navigateToIndustriesScreen()
	{
		if(SeleniumHelper.menuNavigation(uptakeHomeDriver, "INDUSTRIES", mainMenu, null) != true)
		{
			return false;
		}		
		if(industriesPageObj.verifyIndustriesLabel() != true)
		{
			return false;
		}		
		return true;
	}
	
	public boolean navigateToAboutScreen()
	{
		if(SeleniumHelper.menuNavigation(uptakeHomeDriver, "ABOUT", mainMenu, null) != true)
		{
			return false;
		}		
		if(aboutPageObj.verifyAboutLabel() != true)
		{
			return false;
		}		
		return true;
	}
	
	public boolean navigateToExpertiseScreen()
	{
		if(SeleniumHelper.menuNavigation(uptakeHomeDriver, "EXPERTISE", mainMenu, null) != true)
		{
			return false;
		}		
		if(expertisePageObj.verifyExpertiseLabel() != true)
		{
			return false;
		}		
		return true;
	}
	
	public boolean navigateToNewsInsightScreen()
	{
		if(SeleniumHelper.menuNavigation(uptakeHomeDriver, "NEWS & INSIGHTS", mainMenu, null) != true)
		{
			return false;
		}		
		if(newsPageObj.verifyProductsLabel() != true)
		{
			return false;
		}
		return true;
	}
	
	public boolean navigateToCareersScreen()
	{
		if(SeleniumHelper.menuNavigation(uptakeHomeDriver, "CAREERS", mainMenu, null) != true)
		{
			return false;
		}		
		if(careersPageObj.verifyCareersLabel() != true)
		{
			return false;
		}		
		return true;
	}
	
	public boolean navigateToContactScreenScreen()
	{
		SeleniumHelper.menuNavigation(uptakeHomeDriver, "CONTACT", mainMenu, null);
		return true;
	}
	
	
	//Industries Sub Link
	public boolean navigateToAgricultureScreen()
	{
		if(SeleniumHelper.menuNavigation(uptakeHomeDriver, "INDUSTRIES:AGRICULTURE", mainMenu, subMenu) != true)
		{
			return false;
		}		
		if(agriculturePageObj.verifyAgricultureLabel() != true)
		{
			return false;
		}		
		return true;
	}
	public boolean navigateToAviationScreen()
	{
		if(SeleniumHelper.menuNavigation(uptakeHomeDriver, "INDUSTRIES:AVIATION", mainMenu, subMenu) != true)
		{
			return false;
		}		
		if(aviationPageObj.verifyAviationLabel() != true)
		{
			return false;
		}		
		return true;
		
	}
	public boolean navigateToConstuctionScreen()
	{
		if(SeleniumHelper.menuNavigation(uptakeHomeDriver, "INDUSTRIES:CONSTRUCTION", mainMenu, subMenu) != true)
		{
			return false;
		}		
		if(constructionPageObj.verifyConstructionLabel() != true)
		{
			return false;
		}		
		return true;
		
	}
	public boolean navigateToEnergyScreen()
	{
		if(SeleniumHelper.menuNavigation(uptakeHomeDriver, "INDUSTRIES:ENERGY", mainMenu, subMenu) != true)
		{
			return false;
		}		
		if(energyPageObj.verifyEnergyLabel() != true)
		{
			return false;
		}
		return true;
	}
	public boolean navigateToEquipmentDealersScreen()
	{
		if(SeleniumHelper.menuNavigation(uptakeHomeDriver, "INDUSTRIES:EQUIPMENT DEALERS", mainMenu, subMenu) != true)
		{
			return false;
		}		
		if(equipmentPageObj.verifyEquipmentDealersLabel() != true)
		{
			return false;
		}
		return true;
	}
	public boolean navigateToFleetScreen()
	{
		if(SeleniumHelper.menuNavigation(uptakeHomeDriver, "INDUSTRIES:FLEET", mainMenu, subMenu) != true)
		{
			return false;
		}		
		if(fleetPageObj.verifyFleetLabel() != true)
		{
			return false;
		}
		return true;
	}
	public boolean navigateToMiningScreen()
	{
		if(SeleniumHelper.menuNavigation(uptakeHomeDriver, "INDUSTRIES:MINING", mainMenu, subMenu) != true)
		{
			return false;
		}		
		if(miningPageObj.verifyMiningLabel() != true)
		{
			return false;
		}
		return true;
	}
	public boolean navigateToOilAndGasScreen()
	{
		if(SeleniumHelper.menuNavigation(uptakeHomeDriver, "INDUSTRIES:OIL AND GAS", mainMenu, subMenu) != true)
		{
			return false;
		}		
		if(oilAngGasPageObj.verifyOilAndGasLabel() != true)
		{
			return false;
		}
		return true;
	}
	public boolean navigateToRailScreen()
	{
		if(SeleniumHelper.menuNavigation(uptakeHomeDriver, "INDUSTRIES:RAIL", mainMenu, subMenu) != true)
		{
			return false;
		}		
		if(railPageObj.verifyRailLabel() != true)
		{
			return false;
		}
		return true;
	}
	
	public boolean navigateToWindScreen()
	{
		if(SeleniumHelper.menuNavigation(uptakeHomeDriver, "INDUSTRIES:WIND", mainMenu, subMenu) != true)
		{
			return false;
		}		
		if(windPageObj.verifyWindLabel() != true)
		{
			return false;
		}
		return true;
	}
	
	
	//Expertise sub links
	public boolean navigateToDataScienceScreen()
	{
		if(SeleniumHelper.menuNavigation(uptakeHomeDriver, "EXPERTISE:DATA SCIENCE", mainMenu, subMenu) != true)
		{
			return false;
		}		
		if(dataSciencePageObj.verifyDataScienceLabel() != true)
		{
			return false;
		}
		return true;
	}
	public boolean navigateToSecurityScreen()
	{
		if(SeleniumHelper.menuNavigation(uptakeHomeDriver, "EXPERTISE:SECURITY", mainMenu, subMenu) != true)
		{
			return false;
		}		
		if(securityPageObj.verifySecurityLabel() != true)
		{
			return false;
		}
		return true;
	}
	
}