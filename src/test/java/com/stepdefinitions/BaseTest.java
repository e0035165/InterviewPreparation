package com.stepdefinitions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.production.testing.InterviewPreparation.EncryptionDataClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseTest {
	protected RemoteWebDriver driver;
	protected Wait<RemoteWebDriver> waiter;
	protected Actions action;
	protected EncryptionDataClass encdec = new EncryptionDataClass();
	protected AppiumDriver<MobileElement> mobiledriver;
	protected Wait<AppiumDriver<MobileElement>>mobile_wait;
	
	
	public BaseTest()
	{
		System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
		this.driver=new ChromeDriver();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
//		This sets the time to wait for a page to load completely before throwing an error. If the timeout is negative, page loads can be indefinite.
		this.waiter = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(250));
		action = new Actions(this.driver);
	}
	
//	@After
//	public void teardown()
//	{
//		this.driver.close();
//		this.driver.quit();
//	}


}
