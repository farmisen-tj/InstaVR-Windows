package com.sapizon.instavr.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.sapizon.instavr.config.TestBase;
import com.sapizon.instavr.pages_T006.InstaVR_gotoDownload;
import com.sapizon.instavr.pages_T006.InstaVR_login_Download;
import com.sapizon.instavr.pages_T006.Instavr_logout;

@SuppressWarnings("unused")
public class T006_Test_Verify_Downlod extends TestBase{

public static final Logger log = Logger.getLogger(T006_Test_Verify_Downlod.class.getName());
	
@DataProvider(name="loginData")
public String[][] getTestData(){
	String[][] testRecords = getData("testdata.xlsx", "loginTestData");
	return testRecords;
}

@BeforeClass

	public void setUp(){
		init();
		log("Open console.instavr.co");

	}

	@Test(dataProvider="loginData")
	public  void VerifyDownload(String Email,String password,String runmode) throws InterruptedException {
		if(runmode.equalsIgnoreCase("n")) {
			throw new SkipException("User Marked The Record As No");
		}
		log("Verify InstaVR Login page is displayed");
		String s=captureScreen("");
		test.log(LogStatus.INFO, "Verify InstaVR Login page is displayed"+test.addScreenCapture(s));
		InstaVR_login_Download loginpage = PageFactory.initElements(driver, InstaVR_login_Download.class);
		InstaVR_gotoDownload Dashboard = loginpage.dologin(Email, password);
		log("Verified instavr Dashboard is displayed");
		String c=captureScreen("");
		 test.log(LogStatus.INFO, "Verify user is logged in successfully & InstaVR Dashboard is displayed"+test.addScreenCapture(c));
		Instavr_logout logout =  Dashboard.gotoDownloads();
		String a=captureScreen("");
		log("Verify User is on Download Section");
		test.log(LogStatus.INFO, "Verify User is on Download Section"+test.addScreenCapture(a));
		Assert.assertEquals("InstaVR Web Dashboard", driver.getTitle());
		logout.Logout();
		log("Verify user loged out sucessfully");
		String ss=captureScreen("");
		test.log(LogStatus.INFO, "Log out from InstaVR"+test.addScreenCapture(ss));
	}
	
	
	
}
