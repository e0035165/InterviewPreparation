package com.stepdefinitions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	protected static AppiumDriver<MobileElement>test_driver;
	protected static URL url;
	@Before
	public void setup() throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Galaxy A70");
		cap.setCapability("udid", "RR8MA0E022A");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");
		cap.setCapability("appPackage", "com.whatsapp");
		cap.setCapability("appActivity", "com.whatsapp.Main");
		cap.setCapability(MobileCapabilityType.FULL_RESET, false);
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		url = new URL("http://127.0.0.1:4764/wd/hub");
		test_driver = new AppiumDriver<MobileElement>(url,cap);
		test_driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@After
	public void teardown()
	{
		test_driver.close();
		test_driver.quit();
	}

}
