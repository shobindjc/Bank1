package com.inetbanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter  {

	public ExtentSparkReporter htmlReport;
	public ExtentReports extent;
	public ExtentTest logger;
	
	  public void onStart(ITestContext testContext) {
		  String timeStamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		  String reportName = "Test-Report"+timeStamp+".html";
		  htmlReport = new ExtentSparkReporter(System.getProperty("user.dir")+"/Test-output/"+ reportName);
		  try {
			htmlReport.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  extent = new ExtentReports();
		  extent.attachReporter(htmlReport);
		  extent.setSystemInfo("Host Name", "localhost");
		  extent.setSystemInfo("Environment", "QA");
		  extent.setSystemInfo("User","Shobind");
		  
		  htmlReport.config().setDocumentTitle("Banking Report");
		  htmlReport.config().setReportName("Functional test report");
		  htmlReport.config().setTheme(Theme.STANDARD);
		  }
	  
	  public void onTestSuccess(ITestResult tr) {
logger = extent.createTest(tr.getName());
logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		  }
	  
	  public void onTestFailure(ITestResult tr) {
		  logger = extent.createTest(tr.getName());
		  logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		  
		  String scrrenshot = System.getProperty("user.dir")+"test-output\\ScreenShots\\"+tr.getName()+".png";
		  File f = new File(scrrenshot);
		  if(f.exists())
		  {
			  
			  try {
				  logger.fail("screen shot is below:"+ logger.addScreenCaptureFromPath(scrrenshot));
			  }
			  catch(Exception e)
			  {
				  e.printStackTrace();
			  }
		  }
		  }
	  
	  public void onTestSkipped(ITestResult tr) {
logger = extent.createTest(tr.getName());
logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		  }
	  
	  public void onFinish(ITestContext testContext)
	  {
		  
		  extent.flush();
	  }
	
}
