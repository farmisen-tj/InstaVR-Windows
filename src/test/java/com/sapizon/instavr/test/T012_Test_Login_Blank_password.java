package com.sapizon.instavr.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.sapizon.instavr.config.TestBase;
import com.sapizon.instavr.pages_T001.InstavrLoginPage;

@SuppressWarnings("unused")
public class T012_Test_Login_Blank_password extends TestBase{

public static final Logger log = Logger.getLogger(T001_Test_LoginTest.class.getName());
	
@BeforeClass

	public void setUp(){
		init();
		log("Opening the browser object");
	}
	
	@Test
	public void LoginWithBlankCredentials() {
		log("Verify InstaVR Login page is displayed");
		captureScreen("");
		test.log(LogStatus.INFO, "Verify InstaVR Login page is displayed"+test.addScreenCapture(newFileName));
		InstavrLoginPage loginpage = PageFactory.initElements(driver, InstavrLoginPage.class);
	loginpage.dologin("","");
	log("Verified Login with blank password");

	}
	
	

	
	
}
	
	
	
	
	

