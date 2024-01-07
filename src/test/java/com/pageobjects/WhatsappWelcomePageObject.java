package com.pageobjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WhatsappWelcomePageObject {
	private AppiumDriver<MobileElement> driver;
	public WhatsappWelcomePageObject(AppiumDriver<MobileElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver),this);
	}
	
	@AndroidFindBy(id="com.whatsapp:id/title")
	public MobileElement title;
	
	@AndroidFindBy(id="com.whatsapp:id/eula_view")
	public MobileElement privacy_policy;
	
	@AndroidFindBy(id="com.whatsapp:id/language_picker")
	public MobileElement languagePicker;
	
	@AndroidFindBy(id="com.whatsapp:id/eula_accept")
	public MobileElement agreeandcontinue;

}
