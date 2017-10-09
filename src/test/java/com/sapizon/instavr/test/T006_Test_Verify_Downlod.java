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

import com.sapizon.instavr.config.TestBase;
import com.sapizon.instavr.pages_T006.InstaVR_gotoDownload;
import com.sapizon.instavr.pages_T006.InstaVR_login_Download;
import com.sapizon.instavr.pages_T006.Instavr_logout;

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
		log("Opening the browser object");

	}

	@Test(dataProvider="loginData")
	public  void login(String Email,String password,String runmode) throws InterruptedException {
		if(runmode.equalsIgnoreCase("n")) {
			throw new SkipException("User Marked The Record As No");
		}
		log("Verified instavr Login is displayed");
		InstaVR_login_Download loginpage = PageFactory.initElements(driver, InstaVR_login_Download.class);
		InstaVR_gotoDownload Dashboard = loginpage.dologin(Email, password);
		log("Verified instavr Dashboard is displayed");
		Instavr_logout logout =  Dashboard.gotoDownloads();
		AssertJUnit.assertEquals("InstaVR Web Dashboard", driver.getTitle());
		logout.Logout();
		
	}
	
	
	
}
