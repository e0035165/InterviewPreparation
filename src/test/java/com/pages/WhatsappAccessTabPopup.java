package com.pages;

import org.junit.Assert;

import com.pageobjects.WhatsappAccessTabPopupObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class WhatsappAccessTabPopup {
	protected AppiumDriver<MobileElement>mobiledriver;
	WhatsappAccessTabPopupObject wsacctabpopupobj;
	public WhatsappAccessTabPopup(AppiumDriver<MobileElement> mobiledriver) {
		super();
		this.mobiledriver = mobiledriver;
		this.wsacctabpopupobj=new WhatsappAccessTabPopupObject(this.mobiledriver);
	}
	
	
	public void confirmNumber()
	{
		Assert.assertTrue(this.wsacctabpopupobj.confirmNumber.isDisplayed());
		this.wsacctabpopupobj.yes.click();
	}

	public void verifyPopup()
	{
		Assert.assertTrue(this.wsacctabpopupobj.contactsandmedia.isDisplayed());
		Assert.assertTrue(this.wsacctabpopupobj.message.isDisplayed());
	}
	
	public void not_now() throws InterruptedException
	{
		MobileElement notnow = this.wsacctabpopupobj.approvals.get(0);
		notnow.click();
		Thread.sleep(1000);
	}
	
	public void Continue() throws InterruptedException
	{
		MobileElement cont = this.wsacctabpopupobj.approvals.get(1);
		cont.click();
		Thread.sleep(1000);
	}
	
	public void allow()
	{
		this.wsacctabpopupobj.allow.click();
	}
	
	public void disallow()
	{
		this.wsacctabpopupobj.disallow.click();
	}
	
	public void confirmation()
	{
		Assert.assertTrue(this.wsacctabpopupobj.number_confirmation.isDisplayed());
		this.wsacctabpopupobj.yes.click();
	}
	
	public void verification() throws InterruptedException
	{
		try {
			Assert.assertTrue(this.wsacctabpopupobj.verification_status.getText().equalsIgnoreCase("Verified"));
			Thread.sleep(3000);
			this.wsacctabpopupobj.contineu.click();
			Thread.sleep(1000);
		}catch(Exception E)
		{
			System.err.println(E.getMessage());
		}
		
	}
	

}
