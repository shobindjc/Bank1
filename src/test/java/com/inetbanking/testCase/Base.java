package com.inetbanking.testCase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class Base {

	ReadConfig configProperty = new ReadConfig();
public static WebDriver driver;
public String baseurl= configProperty.getBaseurl();
public String userName = configProperty.userName(); 
public String pass = configProperty.Password();
public static Logger logger;

@Parameters("browser")
@BeforeClass
public void setup(String br)
{
	logger = Logger.getLogger("eBanking");
	PropertyConfigurator.configure(getClass().getResource("/log4j.properties"));
	if(br.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", configProperty.chromepath());
		driver = new ChromeDriver();
	}
	else if(br.equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.chrome.driver", configProperty.firefoxpath());
		driver = new FirefoxDriver();
	}
	else if(br.equalsIgnoreCase("edge"))
	{
		System.setProperty("webdriver.chrome.driver", configProperty.edgepath());
		driver = new EdgeDriver();
	}
	driver.get(baseurl);
}

@AfterClass
public void tearDown()
{
	driver.quit();
}

public void capturescreen(WebDriver driver, String tname) throws IOException
{
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir")+"/test-output/ScreenShots/"+ tname +".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot taken"+tname);
}

}
