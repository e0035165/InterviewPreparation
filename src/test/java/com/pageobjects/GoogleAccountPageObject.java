package com.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindAll;

public class GoogleAccountPageObject {
	public GoogleAccountPageObject(RemoteWebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindAll({@FindBy(id="logo"),@FindBy(xpath="//div[@id='logo']")})
	public WebElement GoogleLogo;
	
	@FindBy(xpath="//*[text()='Sign in']")
	public WebElement Signin;
	
	@FindBy(xpath="//input[@type='email']")
	public WebElement emailorphone;
	
	@FindAll({@FindBy(xpath="//*[contains(text(),'Not your computer? Use Guest mode to sign in privately.')]")})
	public WebElement guestmode;
	
	@FindAll({@FindBy(xpath="//span[text()='Create account']")})
	public WebElement createaccount;
	
	@FindAll({@FindBy(xpath="(//button[@jsname='LgbsSe'])[2]")})
	public WebElement Next;
	
	@FindAll({@FindBy(xpath="//li[@role='menuitem']")})
	public List<WebElement> accountList;
	
	@FindAll({@FindBy(xpath="//button[text()='Forgot email?']")})
	public WebElement forgotemail;

}
