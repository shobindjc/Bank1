package com.inetbanking.testCase;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.inetbanking.pageobject.AddCustomerPAge;
import com.inetbanking.pageobject.LoginPage;

public class TC_AddCustomer_001 extends Base {

	@Test
	public void AddCustomer() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.enterLoginTxt(userName);
		lp.enterPAss(pass);
		lp.clickLogin();
		Thread.sleep(3000);
		
		AddCustomerPAge cust = new AddCustomerPAge(driver);
		cust.newCustomerTbClick();
		cust.customerNameTxtEnter("Shobind");
		cust.maleRadioBtnClick();
		cust.dobBoxTxt("08", "19", "91");
		Thread.sleep(2000);
		cust.addresstxtEnter("Shimoga Ashoka nagar");
		cust.stateTxtEnter("KArnataka");
		cust.cityTxtEnter("Shimoga");
		cust.pinTxtEnter("577201");
		cust.mobileTxtEnter("9986996061");
		cust.emailTxtEnter(RandomString()+"abc.com");
		cust.passTxtEnter("abcde");
		cust.btnSubmit();
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
	}
	
	public String RandomString() {
		return RandomStringUtils.randomAlphabetic(8);
	}
	
}
