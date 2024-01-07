package com.pages;

import org.openqa.selenium.Dimension;

import com.pageobjects.WhatsappFrontPageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class WhatsappFrontPage {
	protected AppiumDriver<MobileElement>mobiledriver;
	protected WhatsappFrontPageObject wspgobj;
	public WhatsappFrontPage(AppiumDriver<MobileElement>driver)
	{
		this.mobiledriver=driver;
		this.wspgobj=new WhatsappFrontPageObject(this.mobiledriver);
	}
	
	public void scrollDownToMemberChat(String lbl) throws InterruptedException
	{
		Dimension size = this.mobiledriver.manage().window().getSize();
		int startX = (int)(size.width/2.00f);
		int startY = (int)(size.height/2.00f);
		Dimension toolbarSize = this.wspgobj.toolbar.getSize();
		
		int endX = startX;
		int endY = startY - toolbarSize.height-10;
		Thread.sleep(2000);
		new TouchAction(this.mobiledriver)
			.press(point(startX,startY))
			.waitAction(waitOptions(ofMillis(600)))
			.moveTo(point(endX,endY))
			.release().perform();
		Thread.sleep(2000);
		boolean detected = false;
		
		while(!detected)
		{
			for(MobileElement ele: this.wspgobj.whatsappTabsTitleNames)
			{
				if(ele.getText().equalsIgnoreCase(lbl))
				{
					System.out.println("Person detected");
					detected=true;
					break;
				}
			}
			if(!detected)
			{
				Thread.sleep(1000);
				MobileElement ex = this.wspgobj.whatsappTabs.get(1);
				new TouchAction(this.mobiledriver)
				.press(point(startX,startY))
				.waitAction(waitOptions(ofMillis(560)))
				.moveTo(point(startX,startY-ex.getSize().getHeight()))
				.release().perform();
				Thread.sleep(2000);
			}
			
		}
		
	}
	
	public void selectMember(String name)
	{
		for(MobileElement ele: this.wspgobj.whatsappTabsTitleNames)
		{
			if(ele.getText().equalsIgnoreCase(name))
			{
				System.out.println("Person selected");
				ele.click();
				break;
			}
		}
	}
	
	

}
