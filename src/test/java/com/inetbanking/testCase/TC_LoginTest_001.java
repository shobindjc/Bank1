package com.inetbanking.testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobject.LoginPage;

public class TC_LoginTest_001 extends Base{
	
	@Test
	public void LoginTest() throws IOException
	{		
		logger.info("Open url");
		LoginPage lp = new LoginPage(driver);
		lp.enterLoginTxt(userName);
		lp.enterPAss(pass);
		lp.clickLogin();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage 1"))
		{
			Assert.assertTrue(true);
			logger.info("login pass");
		}
		else 
		{
			capturescreen(driver,"LoginTest");
			Assert.assertTrue(false);
			
			logger.info("login fail");
		}
	}

}
