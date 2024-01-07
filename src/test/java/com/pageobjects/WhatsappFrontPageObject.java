package com.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WhatsappFrontPageObject {
	private AppiumDriver<MobileElement> driver;
	public WhatsappFrontPageObject(AppiumDriver<MobileElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver),this);
	}
	
	@AndroidFindAll({@AndroidBy(id="com.whatsapp:id/toolbar")})
	public MobileElement toolbar;
	
	@AndroidFindBy(xpath="(//android.widget.TextView[@text=\"WhatsApp\"])[2]")
	public MobileElement title;
	
	
	@AndroidFindAll({@AndroidBy(xpath="//*[@class='android.widget.RelativeLayout']"),@AndroidBy(xpath="//*[@resource-id='com.whatsapp:id/contact_row_container']")})
	public List<MobileElement> whatsappTabs;
	
	@AndroidFindAll({@AndroidBy(xpath="//*[@class='android.widget.RelativeLayout']//*[@resource-id='com.whatsapp:id/conversations_row_contact_name']")})
	public List<MobileElement> whatsappTabsTitleNames;
	
	@AndroidFindBy(accessibility="Camera")
	public MobileElement camera;
	
	
	@AndroidFindAll({@AndroidBy(accessibility="Search")})
	public MobileElement search;
	
	@AndroidFindAll({@AndroidBy(accessibility="More options")})
	public MobileElement options;
	
	@AndroidFindBy(xpath="//*[@resource-id='com.whatsapp:id/home_tab_layout']")
	public List<MobileElement>homeTabs;

}
