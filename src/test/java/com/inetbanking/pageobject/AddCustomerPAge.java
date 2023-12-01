package com.inetbanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPAge {
	
	public static WebDriver driver ;
	
	public AddCustomerPAge(WebDriver rDriver)
	{
		driver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'New Customer')]")
	WebElement  newCustomerTab;
	
	@FindBy(xpath = "//tbody/tr[4]/td[2]/input[1]")
	WebElement customerNameTxt;
	
	@FindBy(xpath = "//tbody/tr[5]/td[2]/input[1]")
	WebElement maleRadioBtn;
	
	@FindBy(xpath = "//tbody/tr[5]/td[2]/input[2]")
	WebElement felmaeRadioBtn;
	
	@FindBy(xpath = "//input[@id='dob']")
	WebElement dobBox;
	
	@FindBy(xpath = "//tbody/tr[7]/td[2]/textarea[1]")
	WebElement addresstxt;
	
	@FindBy(xpath = "//tbody/tr[8]/td[2]/input[1]")
	WebElement cityTxt;
	
	@FindBy(xpath = "//tbody/tr[9]/td[2]/input[1]")
	WebElement stateTxt;
	
	@FindBy(xpath = "//tbody/tr[10]/td[2]/input[1]")
	WebElement pinTxt;
	
	@FindBy(xpath = "//tbody/tr[11]/td[2]/input[1]")
	WebElement mobileTxt;
	
	@FindBy(xpath = "//tbody/tr[12]/td[2]/input[1]")
	WebElement emailTxt;
	
	@FindBy(xpath = "//tbody/tr[13]/td[2]/input[1]")
	WebElement passTxt;
	
	@FindBy(xpath = "//tbody/tr[14]/td[2]/input[1]")
	WebElement submitBtn;
	
	@FindBy(xpath = "//tbody/tr[14]/td[2]/input[2]")
	WebElement resetBtn;
	
	public void newCustomerTbClick()
	{
		newCustomerTab.click();
	}
	
	public void customerNameTxtEnter(String custName)
	{
		customerNameTxt.sendKeys(custName);
	}
	
	public void maleRadioBtnClick()
	{
		maleRadioBtn.click();
	}
	
	public void felmaeRadioBtnClick()
	{
		felmaeRadioBtn.click();
	}
	
	public void dobBoxTxt(String mm,String dd, String yy )
	{
		dobBox.sendKeys(mm);
		dobBox.sendKeys(dd);
		dobBox.sendKeys(yy);
	}
	
	public void addresstxtEnter(String address)
	{
		addresstxt.sendKeys(address);
	}
	
	public void cityTxtEnter(String city)
	{
		cityTxt.sendKeys(city);
	}
	
	public void stateTxtEnter(String state)
	{
		stateTxt.sendKeys(state);
	}
	
	public void pinTxtEnter(String pin)
	{
		pinTxt.sendKeys(pin);
	}
	
	public void mobileTxtEnter(String mobile)
	{
		mobileTxt.sendKeys(mobile);
	}
	
	public void passTxtEnter(String pass)
	{
		passTxt.sendKeys(pass);
	}
	
	public void emailTxtEnter(String email)
	{
		emailTxt.sendKeys(email);
	}
	
	public void btnSubmit() {
		submitBtn.click();
	}
	
	public void btnreset() {
		resetBtn.click();
	}

}
