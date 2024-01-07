package com.pages;

import org.junit.Assert;
import org.openqa.selenium.Dimension;

import com.pageobjects.WhatsappPhoneVerificationPageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

import java.time.Duration;

public class WhatsappPhoneVerificationPage {
	protected AppiumDriver<MobileElement>mobiledriver;
	protected WhatsappPhoneVerificationPageObject wsphveripgobj;
	public WhatsappPhoneVerificationPage(AppiumDriver<MobileElement> driver)
	{
		this.mobiledriver=driver;
		this.wsphveripgobj=new WhatsappPhoneVerificationPageObject(this.mobiledriver);
	}
	
	public void verifyPage()
	{
		Assert.assertTrue(this.wsphveripgobj.title.isDisplayed());
		Assert.assertTrue(this.wsphveripgobj.country_selection.isEnabled());
		Assert.assertTrue(this.wsphveripgobj.next.isEnabled());
		//Assert.assertTrue(this.wsphveripgobj.number.isDisplayed());
	}
	
	public void selectCountry(String ctry) throws InterruptedException
	{
		this.wsphveripgobj.country_selection.click();
		Thread.sleep(1000);
		boolean isCountryThere=false;
		Dimension tag = this.wsphveripgobj.country_list.get(2).getSize();
		int startX = this.mobiledriver.manage().window().getSize().getWidth()/2;
		int startY = this.mobiledriver.manage().window().getSize().getHeight()/2;
		while(!isCountryThere)
		{
			for(int i=0;i<this.wsphveripgobj.country_names.size()-1;++i)
			{
				if(this.wsphveripgobj.country_names.get(i).getText().equalsIgnoreCase(ctry))
				{
					isCountryThere=true;
					this.wsphveripgobj.country_names.get(i).click();
				}
			}
			if(!isCountryThere)
			{
				new TouchAction<>(this.mobiledriver)
				.press(point(startX,startY))
				.waitAction(waitOptions(ofMillis(400)))
				.moveTo(point(startX,startY-tag.getHeight()+20))
				.release().perform();
				Thread.sleep(2000);
			}
		}
		
		
	}
	
	
	public void enterNumber(String num) throws InterruptedException
	{
		this.wsphveripgobj.number.sendKeys(num);
		Thread.sleep(1000);
		this.wsphveripgobj.next.click();
	}

}
