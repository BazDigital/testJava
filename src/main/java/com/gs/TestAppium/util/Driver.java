package com.gs.TestAppium.util;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Driver extends BaseSetup {
		
	protected AppiumDriver<MobileElement> driver;
	
	public Driver()
	{
		this.driver = super.getDriver();					
	}
	
	/**
	 * Driver params deviceName and version 
	 * @param deviceName 
	 * @param version
	 * @autor Tomas Yussef
	 */
	public Driver(String deviceName, String version, long timeOut)
	{	
		this.driver = super.getDriver(deviceName, version, timeOut);					
	}

	public AppiumDriver<MobileElement> getAppiumDriver() {
		return driver;
	}

	public void setAppiumDriver(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}	
	
	

}