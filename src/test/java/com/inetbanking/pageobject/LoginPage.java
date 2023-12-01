package com.inetbanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public static WebDriver driver ;
	
	@FindBy(name= "uid")
	@CacheLookup
	WebElement txtUserLogin;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPAssword;
	
	@FindBy(name = "btnLogin")
	WebElement btnLogin;
	
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
	WebElement btnLogOut;
	
	public void enterLoginTxt(String loginName)
	{
		txtUserLogin.sendKeys(loginName);
	}
	
	public void enterPAss(String pass)
	{
		txtPAssword.sendKeys(pass);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	public LoginPage(WebDriver rdriver)
	{
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public void LogoutClick()
	{
		btnLogOut.click();
	}
	

}
