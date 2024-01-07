package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleAccountPasswordPageObject {
	protected RemoteWebDriver driver;

	public GoogleAccountPasswordPageObject(RemoteWebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(id="logo")
	public WebElement logo;
	
	@FindAll({@FindBy(xpath="//div[@role='link']")})
	public WebElement emailselected;
	
	@FindAll({@FindBy(xpath="//input[@type='password']")})
	public WebElement password_txtbox;
	
	@FindBy(xpath="//input[@type='checkbox']/following-sibling::div")
	public WebElement checkbox_show_password;
	
	@FindBy(xpath="//*[text()='Next']")
	public WebElement next;
	

}
