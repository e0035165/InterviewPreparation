package com.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pagefactory.GoogleSearchPage_PF;
import com.pages.GoogleAccountPage;
import com.pages.GoogleAccountPasswordPage;
import com.production.testing.InterviewPreparation.EncryptionDataClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearch_PF_CALL extends BaseTest {
	protected GoogleSearchPage_PF gpf = new GoogleSearchPage_PF(this.driver);
	protected GoogleAccountPage GAP = new GoogleAccountPage(this.driver,this.waiter);
	protected GoogleAccountPasswordPage GAPP = new GoogleAccountPasswordPage(this.driver,this.waiter);
	
	@Given("^I go to the Google Homepage$")
	public void i_go_to_the_google_homepage() throws InterruptedException {
//		this.driver.get("https://www.google.com/");
//		Thread.sleep(1000);
		gpf.go_to_website("https://www.google.com/");
	}
	
	@And("^I search for \"([^\\\"]*)\"$")
	public void I_enter_value(String arg) throws InterruptedException
	{
		gpf.enterSearch(arg);
		Thread.sleep(4000);
	}

	@Then("^I should reach the google search page$")
	public void i_should_reach_the_google_search_page() throws InterruptedException {
	    JavascriptExecutor js = (JavascriptExecutor) this.driver;
	    //Scroll down
	    js.executeScript("window.scrollBy(0,350)", "");
	    //Scroll up
	    //js.executeAsyncScript("window.scrollBy(0,-350)","");
	    WebElement ele = driver.findElement(By.xpath("//*[text()='Related searches']"));
	    //Search based on element
	    js.executeScript("arguments[0].scrollIntoView();", ele);
	    Thread.sleep(10000);
	    //Scroll all the way up
	    js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	    Thread.sleep(2000);
	    this.driver.close();
	    this.driver.quit();
	}
	
	@When("^I click on \"([^\\\\\\\"]*)\" button$")
	public void i_should_click_on_this_button(String btn) throws InterruptedException
	{
		String ele = "//*[contains(text(),'"+btn+"')]";
		this.driver.findElement(By.xpath(ele)).click();
		Thread.sleep(2000);
	}
	
	@Then("^I enter email \"([^\\\"]*)\" in email entrybox$")
	public void i_enter_email(String email) throws InterruptedException
	{
//		this.driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
//		this.driver.findElement(By.xpath("//input[@type='email']")).sendKeys(Keys.ENTER);
//		String test = this.encdec.jweEncrypt(email);
//		System.out.println(test);
//		System.out.println(this.encdec.jwedecrypt(test));
//		Thread.sleep(30000);
		GAP.addEmail(email);
		Thread.sleep(5000);
		GAP.submit();
	}
	
	@Then("^I enter password \"([^\\\"]*)\" in password entrybox$")
	public void i_enter_password(String password) throws InterruptedException
	{
//		this.driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
//		this.driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Keys.ENTER);
		String encpassword = this.encdec.jweEncrypt(password);
		System.out.println(this.encdec.jwedecrypt(encpassword));
		Thread.sleep(10000);
		GAPP.enterPassword(password);
		GAPP.submit();
		Thread.sleep(5000);
		
	}
	

}
