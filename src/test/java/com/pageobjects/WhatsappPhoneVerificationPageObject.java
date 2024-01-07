package com.pageobjects;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WhatsappPhoneVerificationPageObject {
	protected AppiumDriver<MobileElement>mobiledriver;
	
	public WhatsappPhoneVerificationPageObject(AppiumDriver<MobileElement> driver)
	{
		this.mobiledriver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.mobiledriver), this);
	}
	
	@AndroidFindBy(id="com.whatsapp:id/register_phone_toolbar_title")
	public MobileElement title;
	
	@AndroidFindBy(id="com.whatsapp:id/description")
	public MobileElement id;
	
	@AndroidFindBy(id="com.whatsapp:id/registration_country")
	public MobileElement country_selection;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Choose a country']")
	public MobileElement popupCountryChoice;
	
	@AndroidFindAll({@AndroidBy(xpath="//*[@resource-id='android:id/list']//android.widget.LinearLayout//android.widget.LinearLayout")})
	public List<MobileElement>country_list;
	
	@AndroidFindAll({@AndroidBy(id="com.whatsapp:id/registration_phone")})
	public MobileElement number;
	
	@AndroidFindAll({@AndroidBy(xpath="//*[@resource-id='com.whatsapp:id/country_first_name']")})
	public List<MobileElement> country_names;
	
	@AndroidFindBy(id="com.whatsapp:id/registration_submit")
	public MobileElement next;
	

}
