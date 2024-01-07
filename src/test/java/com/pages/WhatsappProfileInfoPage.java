package com.pages;

import com.pageobjects.WhatsappProfileInfoPageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class WhatsappProfileInfoPage {
	protected AppiumDriver<MobileElement>mobiledriver;
	protected WhatsappProfileInfoPageObject wsprofilepgobj;
	public WhatsappProfileInfoPage(AppiumDriver<MobileElement> mobiledriver) {
		super();
		this.mobiledriver = mobiledriver;
		wsprofilepgobj=new WhatsappProfileInfoPageObject(this.mobiledriver);
	}
	
	public void enterName(String name) throws InterruptedException
	{
		this.wsprofilepgobj.entrantName.sendKeys(name);
		this.wsprofilepgobj.next.click();
		Thread.sleep(1000);
	}
	
	public void sendEmail(String email) throws InterruptedException
	{
		this.wsprofilepgobj.entrantName.sendKeys(email);
		Thread.sleep(5000);
		this.wsprofilepgobj.next.click();
	}
	
	public void skip() throws InterruptedException
	{
		this.wsprofilepgobj.skip.click();
		Thread.sleep(20000);
	}
	
	

}
