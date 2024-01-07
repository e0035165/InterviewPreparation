package com.pages;

import org.junit.Assert;

import com.pageobjects.WhatsappRegistrationPageObject;
import com.pageobjects.WhatsappWelcomePageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class WhatsappWelcomePage {
	protected AppiumDriver<MobileElement>mobiledriver;
	protected WhatsappWelcomePageObject wspgobj;
	public WhatsappWelcomePage(AppiumDriver<MobileElement>driver)
	{
		this.mobiledriver=driver;
		this.wspgobj=new WhatsappWelcomePageObject(driver);
	}
	
	public void verify()
	{
		Assert.assertTrue(this.wspgobj.title.isDisplayed());
		Assert.assertTrue(this.wspgobj.privacy_policy.isDisplayed());
		Assert.assertTrue(this.wspgobj.languagePicker.isEnabled());
	}
	
	public void Continue()
	{
		this.wspgobj.agreeandcontinue.click();
	}

}
