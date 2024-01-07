package com.pageobjects;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WhatsappRegistrationPageObject {
	private AppiumDriver<MobileElement> driver;
	public WhatsappRegistrationPageObject(AppiumDriver<MobileElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver),this);
	}
	
	@AndroidFindAll({@AndroidBy(id="com.whatsapp:id/pre_tos_title")})
	public MobileElement title;
	
	@AndroidFindAll({@AndroidBy(id="com.whatsapp:id/choose_language")})
	public MobileElement choose_language;
	
	@AndroidFindAll({@AndroidBy(accessibility="Next")})
	public MobileElement next;
	
	@AndroidFindAll({@AndroidBy(xpath="//*[@class='android.widget.ListView']//android.widget.TextView")})
	public List<MobileElement> languages;
	
	@AndroidFindAll({@AndroidBy(xpath="//*[@resource-id='com.whatsapp:id/language_selector_listview']//android.widget.LinearLayout")})
	public List<MobileElement> languageBoxers;

}
