package com.pages;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.pageobjects.GoogleAccountPageObject;


public class GoogleAccountPage {
	protected RemoteWebDriver driver;
	protected GoogleAccountPageObject gpap;
	protected Wait<RemoteWebDriver>waiter;
	public GoogleAccountPage(RemoteWebDriver driver, Wait<RemoteWebDriver> waiter)
	{
		this.driver=driver;
		this.waiter=waiter;
		gpap = new GoogleAccountPageObject(driver);
	}
	
	public void click_create_account()
	{
		gpap.createaccount.click();
	}
	
	public void addEmail(String email)
	{
		gpap.emailorphone.sendKeys(email);
	}
	
	public void submit()
	{
		this.waiter.until(ExpectedConditions.elementToBeClickable(gpap.Next));
		gpap.Next.click();
	}
	
	public void forgot_email()
	{
		gpap.forgotemail.click();
	}
	
	
	
	

}
