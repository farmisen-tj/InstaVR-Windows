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
import com.sapizon.instavr.pages_T005.InstaVR_gotoPackage;
import com.sapizon.instavr.pages_T005.InstaVR_login_package;
import com.sapizon.instavr.pages_T005.InstaVr_logout;

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
		log("Opening the browser object");

	}

	
	
	@Test(dataProvider="loginData")
	public  void login(String Email,String password,String runmode) throws InterruptedException {
		if(runmode.equalsIgnoreCase("n")) {
			throw new SkipException("User Marked The Record As No");
		}
		log("Verified instavr Login is displayed");
		InstaVR_login_package loginpage = PageFactory.initElements(driver, InstaVR_login_package.class);
		InstaVR_gotoPackage Dashboard = loginpage.dologin(Email, password);
		log("Verified instavr Login is displayed");
		InstaVr_logout logout = Dashboard.gotoPackages();
		AssertJUnit.assertEquals("InstaVR Web Dashboard", driver.getTitle());
		logout.Logout();
	}
	
}
