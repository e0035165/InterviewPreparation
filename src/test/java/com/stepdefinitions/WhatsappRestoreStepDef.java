package com.stepdefinitions;

import com.pages.WhatsappRestoreBackupPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Then;

public class WhatsappRestoreStepDef extends BaseTest {
	AppiumDriver<MobileElement>mobiledriver;
	WhatsappRestoreBackupPage wsrestorebkuppg;
	public WhatsappRestoreStepDef() {
		super();
		this.mobiledriver=Hooks.test_driver;
		this.wsrestorebkuppg=new WhatsappRestoreBackupPage(this.mobiledriver);
		
	}
	
	@Then("^I verify backup page$")
	public void verifyBackUpPage()
	{
		this.wsrestorebkuppg.verifyPage();
	}
	
	@Then("^I click restore$")
	public void restore() throws InterruptedException
	{
		this.wsrestorebkuppg.restore();
		Thread.sleep(30000);
		this.wsrestorebkuppg.next();
	}
	

}
