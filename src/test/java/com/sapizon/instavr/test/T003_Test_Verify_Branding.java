package com.sapizon.instavr.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sapizon.instavr.config.TestBase;
import com.sapizon.instavr.pages_T003.InstaVR_Login_Branding;
import com.sapizon.instavr.pages_T003.InstaVR_gotoBranding;
import com.sapizon.instavr.pages_T003.InstaVR_logout;

public class T003_Test_Verify_Branding extends TestBase {
	
public static final Logger log = Logger.getLogger(T003_Test_Verify_Branding.class.getName());
	
@DataProvider(name="loginData")
public String[][] getTestData(){
	String[][] testRecords = getData("testdata.xlsx", "loginTestData");
	return testRecords;
}

	@BeforeTest
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
		InstaVR_Login_Branding loginpage = PageFactory.initElements(driver, InstaVR_Login_Branding.class);
		InstaVR_gotoBranding Dashboard = loginpage.dologin(Email, password);
		InstaVR_logout logout = Dashboard.gotoBranding();
		log("Verify user loged in sucessfully");
		Assert.assertEquals("InstaVR Web Dashboard", driver.getTitle());
		logout.Logout();
		Thread.sleep(10l);
	}

	
}
