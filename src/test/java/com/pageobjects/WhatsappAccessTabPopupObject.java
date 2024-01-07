package com.pageobjects;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WhatsappAccessTabPopupObject {
	protected AppiumDriver<MobileElement>mobiledriver;

	public WhatsappAccessTabPopupObject(AppiumDriver<MobileElement> mobiledriver) {
		super();
		this.mobiledriver = mobiledriver;
		PageFactory.initElements(new AppiumFieldDecorator(this.mobiledriver), this);
		
	}
	
	@AndroidFindAll({@AndroidBy(id="com.whatsapp:id/permission_title")})
	public MobileElement contactsandmedia;
	
	@AndroidFindAll({@AndroidBy(id="com.whatsapp:id/permission_message")})
	public MobileElement message;
	
	@AndroidFindAll({@AndroidBy(className="android.widget.Button")})
	public List<MobileElement> approvals;
	
	@AndroidFindAll({@AndroidBy(id="com.android.permissioncontroller:id/permission_message")})
	public MobileElement contactAccesspermissiontitle;
	
	@AndroidFindAll({@AndroidBy(id="com.android.permissioncontroller:id/permission_allow_button")})
	public MobileElement allow;
	
	@AndroidFindAll({@AndroidBy(id="com.android.permissioncontroller:id/permission_deny_button")})
	public MobileElement disallow;
	
	@AndroidFindBy(id="com.whatsapp:id/phone_number_confirmation_text_view")
	public MobileElement number_confirmation;
	
	@AndroidFindBy(id="android:id/button1")
	public MobileElement yes;
	
	@AndroidFindBy(id="com.whatsapp:id/phone_number_confirmation_text_view")
	public MobileElement confirmNumber;
	
	@AndroidFindAll({@AndroidBy(id="com.whatsapp:id/dialog_title")})
	public MobileElement verification_status;
	
	@AndroidFindBy(id="com.whatsapp:id/dialog_message")
	public MobileElement dialog_message;
	
	@AndroidFindAll({@AndroidBy(className="android.widget.Button")})
	public MobileElement contineu;
	
	

}
