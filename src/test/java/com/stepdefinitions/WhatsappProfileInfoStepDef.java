package com.stepdefinitions;

import com.pages.WhatsappProfileInfoPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WhatsappProfileInfoStepDef extends BaseTest {
	AppiumDriver<MobileElement>mobiledriver;
	protected WhatsappProfileInfoPage infoPage;
	
	public WhatsappProfileInfoStepDef()
	{
		super();
		this.mobiledriver=Hooks.test_driver;
		this.infoPage=new WhatsappProfileInfoPage(this.mobiledriver);
	}
	
	@When("^I enter \"([^\\\"]*)\" in the name$")
	public void enterName(String name) throws InterruptedException
	{
		this.infoPage.enterName(name);
	}
	
	@Then("^I skip email addition$")
	public void skip() throws InterruptedException
	{
		this.infoPage.skip();
		Thread.sleep(10000);
	}

}
