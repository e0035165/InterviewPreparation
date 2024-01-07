package com.pageobjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WhatsappRestoreBackupPageObject {
	protected AppiumDriver<MobileElement>mobiledriver;

	public WhatsappRestoreBackupPageObject(AppiumDriver<MobileElement> mobiledriver) {
		super();
		this.mobiledriver = mobiledriver;
		PageFactory.initElements(new AppiumFieldDecorator(this.mobiledriver), this);
	}
	
	@AndroidFindBy(id="com.whatsapp:id/title_toolbar")
	public MobileElement title;
	
	@AndroidFindBy(id="com.whatsapp:id/activity_gdrive_backup_found_category")
	public MobileElement subtitle;
	
	@AndroidFindBy(id="com.whatsapp:id/restore_general_info")
	public MobileElement general_info;
	
	@AndroidFindAll({@AndroidBy(accessibility="Restore messages")})
	public MobileElement restore;
	
	@AndroidFindAll({@AndroidBy(id="com.whatsapp:id/dont_restore")})
	public MobileElement skip;
	
	@AndroidFindBy(id="com.whatsapp:id/nextBtn")
	public MobileElement next;
	
}
