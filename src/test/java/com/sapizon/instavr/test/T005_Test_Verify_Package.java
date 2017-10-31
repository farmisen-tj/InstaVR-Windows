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
import com.sapizon.instavr.pages_T005.InstaVR_gotoPackage;
import com.sapizon.instavr.pages_T005.InstaVR_login_package;
import com.sapizon.instavr.pages_T005.InstaVr_logout;

@SuppressWarnings("unused")
public class T005_Test_Verify_Package extends TestBase{

public static final Logger log = Logger.getLogger(T005_Test_Verify_Package.class.getName());
	
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
	public  void VerifyPackage(String Email,String password,String runmode) throws InterruptedException {
		if(runmode.equalsIgnoreCase("n")) {
			throw new SkipException("User Marked The Record As No");
		}
		log("Verify InstaVR Login page is displayed");
		String s=captureScreen("");
		test.log(LogStatus.INFO, "Verify InstaVR Login page is displayed"+test.addScreenCapture(s));
		InstaVR_login_package loginpage = PageFactory.initElements(driver, InstaVR_login_package.class);
		InstaVR_gotoPackage Dashboard = loginpage.dologin(Email, password);
		log("Verified instavr Login is displayed");
		 String c=captureScreen("");
		 test.log(LogStatus.INFO, "Verify user is logged in successfully & InstaVR Dashboard is displayed"+test.addScreenCapture(c));
		InstaVr_logout logout = Dashboard.gotoPackages();
		String a=captureScreen("");
		log("Verify User is on Package Section");
		test.log(LogStatus.INFO, "Verify User is on Package Section"+test.addScreenCapture(a));
		Assert.assertEquals("InstaVR Web Dashboard", driver.getTitle());
		logout.Logout();
		log("Verify user loged out sucessfully");
		String ss=captureScreen("");
		test.log(LogStatus.INFO, "Log out from InstaVR"+test.addScreenCapture(ss));

	}
	
}
