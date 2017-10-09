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
import com.sapizon.instavr.pages_T004.InstaVR_Login__Preview;
import com.sapizon.instavr.pages_T004.InstaVR_gotoPreview;
import com.sapizon.instavr.pages_T004.InstaVr_logout;

public class T004_Test_Verify_Preview extends TestBase{

public static final Logger log = Logger.getLogger(T004_Test_Verify_Preview.class.getName());
	
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
		InstaVR_Login__Preview loginpage = PageFactory.initElements(driver, InstaVR_Login__Preview.class);
		InstaVR_gotoPreview Dashboard = loginpage.dologin(Email, password);
		log("Verified instavr Login is displayed");
		InstaVr_logout logout=Dashboard.gotoPreview();
		Thread.sleep(60l);
		AssertJUnit.assertEquals("InstaVR Web Dashboard", driver.getTitle());
		logout.Logout();
		AssertJUnit.assertEquals("Login", driver.getTitle());
		

	}
	
	
	
}
