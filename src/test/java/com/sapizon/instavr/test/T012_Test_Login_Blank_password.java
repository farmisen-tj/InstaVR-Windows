package com.sapizon.instavr.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sapizon.instavr.config.TestBase;
import com.sapizon.instavr.pages_T001.InstavrLoginPage;

public class T012_Test_Login_Blank_password extends TestBase{

public static final Logger log = Logger.getLogger(T001_Test_LoginTest.class.getName());
	
	@BeforeTest
	public void setUp(){
		init();
		log("Opening the browser object");
	}
	
	@Test
	public void loginTest() {
	log("Verified instavr Login is displayed");
	InstavrLoginPage loginpage = PageFactory.initElements(driver, InstavrLoginPage.class);
	loginpage.dologin("pramodnp.pnp@gmail.com","");
	log("Verified Login with blank password");

	}
	
	
@AfterTest
	
	public void endTest() {

		driver.close();
	
	}
	
	
}
	
	
	
	
	

