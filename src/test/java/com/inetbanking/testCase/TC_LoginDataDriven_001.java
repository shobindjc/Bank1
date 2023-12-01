package com.inetbanking.testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobject.LoginPage;
import com.inetbanking.utilities.XmlUtil;

public class TC_LoginDataDriven_001 extends Base{

	@Test(dataProvider = "LoginData")
	public void login(String userName , String password) {
		LoginPage lp = new LoginPage(driver);
		lp.enterLoginTxt(userName);
		lp.enterPAss(password);
		lp.clickLogin();
		if(isAlertPResent() == true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else 
		{
			Assert.assertTrue(true);
			lp.LogoutClick();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();		
		}
		
	}
	
	public boolean isAlertPResent()
	{
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
		
	}
	
	
	@DataProvider(name = "LoginData")
	String [][] getData() throws IOException{
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testData/LoginData.xlsx";
        int rowNumber = XmlUtil.getRowCount(path, "Sheet1");
		int columnNum = XmlUtil.getColumnCount(path,"Sheet1");
		String [][] loginData = new String[rowNumber][columnNum];
		
		for(int i =1; i<=rowNumber; i++) {
			for(int j= 0 ; j <columnNum; j++) {
				loginData[i-1][j] = XmlUtil.getCellData(path, "Sheet1", i ,j);
			}
		}
		return loginData;
	}
	
}
