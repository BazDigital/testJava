package com.gs.TestAppium.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseSetup
{
    public static int DEFAULT_TIME_OUT;
    public static final int TIME_OUT_5_SEGUNDO = 5; 
    public static final int TIME_OUT_1_SEGUNDO = 1; 

    
    private static final Logger log = Logger.getLogger(BaseSetup.class);
    private AppiumDriver<MobileElement> driver;

    private static final String APK_PROD = "app-armeabi-v7a-debug.apk";
    private static final String APK_PATH = "/src/main/resources/apks/";
    private String version;
    private String devicesName;
    private long timeOut;

    private static final String APPIUM_PORT = "4723";
    private static final String SERVER_IP = "localhost";

    /**
     * Parametrizar nombre y version del dispositvo
     * 
     * @param deviceName
     * @param version
     * @param timeOut
     * @return
     * @autor Tomas Yussef
     */
    public AppiumDriver<MobileElement> getDriver(String deviceName, String version, long timeOut)
    {
	this.devicesName = deviceName;
	this.version = version;
	this.timeOut = timeOut;
	DEFAULT_TIME_OUT = (int) this.timeOut;
	initDriver();
	return driver;
    }

    public AppiumDriver<MobileElement> getDriver()
    {
	this.version = "7.0";
	this.devicesName = "SM-G920I";
	this.timeOut = 120;
	DEFAULT_TIME_OUT = (int) this.timeOut;
	initDriver();
	return driver;
    }

    private void initDriver()
    {
	log.info("Inside initDriver method");

	DesiredCapabilities capability = new DesiredCapabilities();

	capability.setCapability("deviceName", devicesName);
	capability.setCapability("platformName", "Android");
	capability.setCapability("platformVersion", version);
	capability.setCapability("autoGrantPermissions", true);
	File file = new File(Paths.get(".").toAbsolutePath().normalize().toString() + APK_PATH + APK_PROD);
	capability.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());

	String serverUrl = "http://" + SERVER_IP + ":" + APPIUM_PORT + "/wd/hub";

	try
	{
	    log.info("Argument to driver object : " + serverUrl);
	    driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capability);
	    driver.manage().timeouts().implicitlyWait(this.timeOut, TimeUnit.SECONDS);
	} catch (NullPointerException | MalformedURLException ex)
	{
	    throw new RuntimeException("appium driver could not be initialised for device");
	}
	log.info("Driver in initdriver id : " + driver);
    }

    public void tearDown()
    {
	driver.quit();
    }

    public void setTimeOut(long time)
    {
	this.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

}
