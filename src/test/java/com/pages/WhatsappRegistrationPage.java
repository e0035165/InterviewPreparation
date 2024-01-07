package com.pages;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import com.pageobjects.WhatsappFrontPageObject;
import com.pageobjects.WhatsappRegistrationPageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class WhatsappRegistrationPage {
	protected AppiumDriver<MobileElement>mobiledriver;
	protected WhatsappRegistrationPageObject wspgobj;
	public WhatsappRegistrationPage(AppiumDriver<MobileElement>driver)
	{
		this.mobiledriver=driver;
		this.wspgobj=new WhatsappRegistrationPageObject(driver);
	}
	
	public void selectLanguage(String language) throws InterruptedException
	{
		MobileElement ele = this.wspgobj.languageBoxers.get(2);
		
		boolean isLanguageThere = false;
		Dimension size = this.mobiledriver.manage().window().getSize();
		int startX = (int)(size.width/2.00f);
		int startY = (int)(size.height/2.00f);
		Dimension toolbarSize = ele.getSize();
		
		int endX = startX;
		int endY = startY - toolbarSize.height+20;
		while(!isLanguageThere)
		{
			for(int i=0;i<this.wspgobj.languages.size()-1;i++)
			{
				if(this.wspgobj.languages.get(i).getText().equalsIgnoreCase(language))
				{
					isLanguageThere=true;
					this.wspgobj.languages.get(i).click();
					break;
				}
			}
			if(isLanguageThere==false)
			{
				new TouchAction<>(this.mobiledriver)
				.press(point(startX,startY))
				.waitAction(waitOptions(ofMillis(400)))
				.moveTo(point(endX,endY))
				.release().perform();
			}
			Thread.sleep(2000);
		}
	}
	
	public void next()
	{
		this.wspgobj.next.click();
	}
	
	public void verifyPage()
	{
		Assert.assertTrue(this.wspgobj.title.isDisplayed());
		Assert.assertTrue(this.wspgobj.next.isEnabled());
		Assert.assertTrue(this.wspgobj.choose_language.isDisplayed());
	}
}
