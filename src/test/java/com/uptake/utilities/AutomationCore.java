package com.uptake.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class AutomationCore {
	
	private static Properties prop = null;
	public static String readProperties(String name)
	{
		try{
		prop = new Properties();
		FileInputStream fio = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Project.properties");
		prop.load(fio);
		return prop.getProperty(name);		
		}
		catch(Exception e)
		{
			return null;
		}
	}
	

}
