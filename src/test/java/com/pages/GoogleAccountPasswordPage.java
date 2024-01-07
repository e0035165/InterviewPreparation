package com.pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.pageobjects.GoogleAccountPasswordPageObject;

public class GoogleAccountPasswordPage {
	protected RemoteWebDriver driver;
	protected GoogleAccountPasswordPageObject gppap;
	protected Wait<RemoteWebDriver> waiter;
	public GoogleAccountPasswordPage(RemoteWebDriver driver, Wait<RemoteWebDriver> waiter) {
		super();
		this.driver = driver;
		this.waiter=waiter;
		gppap = new GoogleAccountPasswordPageObject(this.driver);
	}
	
	public void enterPassword(String password)
	{
		//gppap.checkbox_show_password.click();
		this.waiter.until(ExpectedConditions.visibilityOf(gppap.password_txtbox));
		gppap.password_txtbox.sendKeys(password);
		
	}
	
	
	public void submit()
	{
		this.waiter.until(ExpectedConditions.elementToBeClickable(gppap.next));
		gppap.next.click();
	}
}
