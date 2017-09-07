package com.sapizon.instavr.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sapizon.instavr.config.TestBase;
import com.sapizon.instavr.pages_T001.InstaVR_Logout;
import com.sapizon.instavr.pages_T001.InstavrLoginPage;

public class T001_Test_LoginTest extends TestBase {
	
	public static final Logger log = Logger.getLogger(T001_Test_LoginTest.class.getName());
	
	@BeforeTest
	public void setUp(){
		init();
		
		log.info("Opening the browser object");

	}

	@Test
	public void loginTest() throws InterruptedException {
	log.info("Verified instavr Login is displayed");
	InstavrLoginPage loginpage = PageFactory.initElements(driver, InstavrLoginPage.class);
	InstaVR_Logout Dashboard = loginpage.dologin("pramodnp.pnp@gmail.com", "pramodnp1995");
	Assert.assertEquals("InstaVR Web Dashboard", driver.getTitle());
	log.info("Verify user loged in sucessfully");
	Dashboard.Logout();
	log.info("Verify user loged out sucessfully");
	}
	
	@AfterTest
	
	public void endTest() {
		
		driver.close();
		log.info("Closing the browser object");
	}


	
}




