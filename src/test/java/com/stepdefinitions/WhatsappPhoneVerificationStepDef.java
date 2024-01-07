package com.stepdefinitions;

import com.pages.WhatsappAccessTabPopup;
import com.pages.WhatsappPhoneVerificationPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WhatsappPhoneVerificationStepDef {
	WhatsappPhoneVerificationPage wsphverfpg;
	WhatsappAccessTabPopup wsaccesspopup;
	AppiumDriver<MobileElement>mobiledriver;

	public WhatsappPhoneVerificationStepDef() {
		super();
		this.mobiledriver=Hooks.test_driver;
		this.wsphverfpg=new WhatsappPhoneVerificationPage(this.mobiledriver);
		this.wsaccesspopup=new WhatsappAccessTabPopup(this.mobiledriver);
	}
	
	@When("^I get to the phone number verification page$")
	public void phoneVerify()
	{
		this.wsphverfpg.verifyPage();
	}
	
	@And("^I select country \"([^\\\"]*)\"$")
	public void select_country(String ctry) throws InterruptedException
	{
		this.wsphverfpg.selectCountry(ctry);
	}
	
	@And("^I add in number \"([^\\\"]*)\"$")
	public void enterNumber(String num) throws InterruptedException
	{
		this.wsphverfpg.enterNumber(num);
	}
	
	@When("^I come to the contact popup page$")
	public void verifyPopup()
	{
		this.wsaccesspopup.verifyPopup();
	}
	
	@When("^I get the contact confirmation popup$")
	public void verifyNumberPopUp() throws InterruptedException
	{
		this.wsaccesspopup.confirmation();
		Thread.sleep(5000);
		this.wsaccesspopup.verification();
	}
	
	@Then("^I select \"([^\\\"]*)\"$")
	public void selectApproval(String app) throws InterruptedException
	{
		if(app.equalsIgnoreCase("continue"))
		{
			this.wsaccesspopup.Continue();
		} else {
			this.wsaccesspopup.not_now();
		}
	}
	
	@Then("^I set access to contacts to \"([^\\\"]*)\"$")
	public void setAccessContacts(String access) throws InterruptedException
	{
		if(access.equalsIgnoreCase("Allow"))
		{
			this.wsaccesspopup.allow();
			Thread.sleep(2000);
			this.wsaccesspopup.allow();
			Thread.sleep(2000);
		} else {
			this.wsaccesspopup.disallow();
		}
	}
	
	@Then("^I complete number verification$")
	public void verification() throws InterruptedException
	{
		this.wsaccesspopup.verification();
		this.wsaccesspopup.confirmation();
	}
	
}
