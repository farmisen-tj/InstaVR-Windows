package com.sapizon.instavr.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sapizon.instavr.config.TestBase;
import com.sapizon.instavr.pages_T001.InstaVR_Logout;
import com.sapizon.instavr.pages_T001.InstavrLoginPage;

public class T001_Test_LoginTest extends TestBase {
	
	public static final Logger log = Logger.getLogger(T001_Test_LoginTest.class.getName());
	
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
	InstavrLoginPage loginpage = PageFactory.initElements(driver, InstavrLoginPage.class);
	InstaVR_Logout Dashboard = loginpage.dologin(Email, password);
	Assert.assertEquals("InstaVR Web Dashboard", driver.getTitle());
	log("Verify user loged in sucessfully");
	Dashboard.Logout();
	log("Verify user loged out sucessfully");
	}
	

	
}




