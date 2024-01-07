package com.pagefactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage_PF {
	
	@FindAll({@FindBy(xpath="//textarea[@name='q']")})
	WebElement search_btn;
	
	@FindAll({@FindBy(linkText="Gmail")})
	WebElement gmail;
	
	@FindAll({@FindBy(linkText="Images")})
	WebElement images;
	
	@FindBy(xpath="//a[@class='gb_d'][@role='button']")
	WebElement nineTabs;
	
	@FindBy(id="voiceSearchButton")
	WebElement voiceTab;
	
	private RemoteWebDriver driver;
	
	public GoogleSearchPage_PF(RemoteWebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void enterSearch(String srch)
	{
		search_btn.sendKeys(srch);
		search_btn.sendKeys(Keys.ENTER);
	}
	
	public void enter_gmail()
	{
		gmail.click();
	}
	
	public void enternineTabs()
	{
		gmail.click();
	}
	
	public void go_to_website(String url) throws InterruptedException
	{
		this.driver.get(url);
		Thread.sleep(2000);
	}
}
