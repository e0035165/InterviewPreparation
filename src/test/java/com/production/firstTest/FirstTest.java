package com.production.firstTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {
	private static WebDriver driver;
	private static Wait<WebDriver> waiter;

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
		//WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		options.setHeadless(true);
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		Explicit waits provide more control over the waiting mechanism than implicit waits. 
//		When we need a more fine-grained control, 
//		we can use fluent waits to check for a particular condition with a specified frequency until the WebElement meets the specified condition or a timeout occurs.
		/*
		 * This is a global setting that applies to every element location call for the entire session. The default value is 0, 
		 * which means that if the element is not found, it will immediately return an error. If an implicit wait is set, 
		 * the driver will wait for the duration of the provided value before returning the error. Note that as soon as the element is located, 
		 * the driver will return the element reference and the code will continue executing, 
		 * so a larger implicit wait value won’t necessarily increase the duration of the session.
		 * */
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
//		The default timeout for setScriptTimeout method is zero. 
//		If you do not set time, then there are chances that executeAsyncScript method may fail because the JavaScript code may take more than the time allotted. 
//		To avoid such failures, set the setScriptTimeout. 
//		This is mainly used for Javascript objects and executors.
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//		This sets the time to wait for a page to load completely before throwing an error. If the timeout is negative, page loads can be indefinite.
		waiter = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(250));
		
//		The implicit and explicit wait is used to wait for an element to appear on the page. However, there are some differences between them:
//
//			Timeouts: Implicit wait sets a default timeout for the entire test runtime, while explicit wait sets timeouts for specific conditions.
//			Condition: Implicit wait waits for an element to appear on the page, while explicit wait waits for a specific condition, 
//			such as the presence of an element or the element to be clickable.
//			Scope: Implicit wait applies globally, while explicit wait applies locally to a specific element.
//			Exception: Implicit wait throws a NoSuchElementException when the WebDriver cannot find the element within the specified timeout. 
//			In contrast, explicit wait throws a TimeoutException when the element doesn’t meet the condition within the specified timeout.
//			The implicit wait is helpful when we want to wait a certain amount of time for elements to appear on the page.
//			However, the explicit wait is the better option if we need to wait for a specific condition.
		driver.get("https://www.selenium.dev/documentation/webdriver/waits/");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
	
	@Test
	public void checkPopup()
	{
		
	}
	
	
	@AfterMethod
	public void teardown()
	{
		
	}

}
