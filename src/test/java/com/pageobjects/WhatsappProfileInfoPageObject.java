package com.pageobjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class WhatsappProfileInfoPageObject {

	public WhatsappProfileInfoPageObject(AppiumDriver<MobileElement>driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindAll({@AndroidBy(className="android.widget.Button")})
	public MobileElement next;
	
	@AndroidFindAll({@AndroidBy(className="android.widget.EditText")})
	public MobileElement entrantName;
	
	@AndroidFindAll({@AndroidBy(id="com.whatsapp:id/register_email_title_toolbar_text")})
	public MobileElement emailTitle;
	
	@AndroidFindBy(id="com.whatsapp:id/title")
	public MobileElement profileInfoTitle;
	
	@AndroidFindBy(accessibility="More options")
	public MobileElement moptions;
	
	@AndroidFindBy(id="com.whatsapp:id/register_email_skip")
	public MobileElement skip;
	
}
