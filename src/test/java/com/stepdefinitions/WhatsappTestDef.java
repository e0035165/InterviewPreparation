package com.stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import com.pageobjects.WhatsappFrontPageObject;
import com.pages.WhatsappFrontPage;
import com.pages.WhatsappPhoneVerificationPage;
import com.pages.WhatsappRegistrationPage;
import com.pages.WhatsappWelcomePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class WhatsappTestDef extends BaseTest {
	WhatsappFrontPage wsfrpage;
	WhatsappFrontPageObject wsfrpageobj;
	WhatsappRegistrationPage wsregpage;
	WhatsappWelcomePage wswelpage;
	WhatsappPhoneVerificationPage wsphverfpg;
	
	public WhatsappTestDef()
	{
		super();
		this.mobiledriver=Hooks.test_driver;
		this.wsfrpage=new WhatsappFrontPage(this.mobiledriver);
		this.wsfrpageobj=new WhatsappFrontPageObject(this.mobiledriver);
		this.wsregpage=new WhatsappRegistrationPage(this.mobiledriver);
		this.wswelpage=new WhatsappWelcomePage(this.mobiledriver);
		this.wsphverfpg=new WhatsappPhoneVerificationPage(this.mobiledriver);
	}
//	@Before
//	public void setUP() throws MalformedURLException
//	{
//		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability("deviceName", "Galaxy A70");
//		cap.setCapability("udid", "RR8MA0E022A");
//		cap.setCapability("platformName", "Android");
//		cap.setCapability("platformVersion", "11");
//		cap.setCapability("appPackage", "com.whatsapp");
//		cap.setCapability("appActivity", "com.whatsapp.Main");
//		cap.setCapability(MobileCapabilityType.FULL_RESET, false);
//		cap.setCapability(MobileCapabilityType.NO_RESET, true);
//		this.cap = cap;
//		this.url = new URL("http://127.0.0.1:4764/wd/hub");
//		this.mobiledriver= new AppiumDriver<MobileElement>(url,cap);
//		this.mobiledriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		wsfrpage=new WhatsappFrontPage(this.mobiledriver);
//		wsfrpageobj=new WhatsappFrontPageObject(this.mobiledriver);
//		this.wsregpage=new WhatsappRegistrationPage(this.mobiledriver);
//		this.wswelpage=new WhatsappWelcomePage(this.mobiledriver);
//	}
	
	
	@Given("^I am in Whatsapp front page$")
	public void whatsappPage()
	{
//		assertTrue()
		Assert.assertTrue(wsfrpageobj.title.isDisplayed());
		Assert.assertTrue(wsfrpageobj.camera.isDisplayed());
		Assert.assertTrue(wsfrpageobj.options.isDisplayed());
		Assert.assertTrue(wsfrpageobj.options.isDisplayed());
		System.out.println("All assertions completed");
	}
	
	@And("^I look for this person \"([^\\\"]*)\"$")
	public void searchForPerson(String name) throws InterruptedException
	{
		Thread.sleep(4000);
		this.wsfrpage.scrollDownToMemberChat(name);
	}
	
	@Then("^I click on \"([^\\\"]*)\"$")
	public void selectMember(String name) throws InterruptedException
	{
		Thread.sleep(2000);
		this.wsfrpage.selectMember(name);
		Thread.sleep(8000);
	}
	
	@Given("^I am in the Whatsapp Registration Page$")
	public void whatsAppRegPage() throws InterruptedException
	{
		Thread.sleep(2000);
		this.wsregpage.verifyPage();
		Thread.sleep(2000);
	}
	
	@And("^I choose \"([^\\\"]*)\" language$")
	public void choose_language(String language) throws InterruptedException
	{
		Thread.sleep(1000);
		this.wsregpage.selectLanguage(language);
		Thread.sleep(1000);
	}
	
	
	@When("^I get to the welcome page$")
	public void welcomepage() throws InterruptedException
	{
		Thread.sleep(2000);
		this.wswelpage.verify();
		Thread.sleep(2000);
	}
	
	@Then("^I click on agree and continue$")
	public void agreeandcontinue() throws InterruptedException
	{
		Thread.sleep(2000);
		this.wswelpage.Continue();
		Thread.sleep(2000);
	}
	

	

}
