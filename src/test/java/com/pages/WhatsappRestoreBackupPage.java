package com.pages;

import org.junit.Assert;

import com.pageobjects.WhatsappRestoreBackupPageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class WhatsappRestoreBackupPage {
	protected AppiumDriver<MobileElement>mobiledriver;
	WhatsappRestoreBackupPageObject wsresbckuppgobj;
	public WhatsappRestoreBackupPage(AppiumDriver<MobileElement> mobiledriver) {
		super();
		this.mobiledriver = mobiledriver;
		wsresbckuppgobj = new WhatsappRestoreBackupPageObject(this.mobiledriver);
	}
	
	public void restore() throws InterruptedException
	{
		this.wsresbckuppgobj.restore.click();
		Thread.sleep(4000);
	}
	
	public void skip()
	{
		this.wsresbckuppgobj.skip.click();
	}
	
	public void next()
	{
		this.wsresbckuppgobj.next.click();
	}
	
	public void verifyPage()
	{
		Assert.assertTrue(this.wsresbckuppgobj.title.isDisplayed());
		Assert.assertTrue(this.wsresbckuppgobj.subtitle.isDisplayed());
	}
	
	

}
