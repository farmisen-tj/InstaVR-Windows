package com.sapizon.instavr.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sapizon.instavr.config.TestBase;
import com.sapizon.instavr.pages.instavrWebDashboard;
import com.sapizon.instavr.pages_T001.InstavrLoginPage;
import com.sapizon.instavr.pages_T002.InstaVR_Login_Authoring;
import com.sapizon.instavr.pages_T002.InstaVR_gotoAuthoring;
import com.sapizon.instavr.pages_T002.InstaVR_logout;

@SuppressWarnings("unused")
public class T002_Test_Verify_Authoring extends TestBase {

public static final Logger log = Logger.getLogger(T002_Test_Verify_Authoring.class.getName());
	
	@BeforeTest
	public void setUp(){
		init();
		log.info("Opening the browser object");

	}

	@Test
	public void AuthoringClick(){
		log.info("Verified instavr Login is displayed");
		InstaVR_Login_Authoring loginpage = PageFactory.initElements(driver, InstaVR_Login_Authoring.class);
		InstaVR_gotoAuthoring Dashboard = loginpage.dologin("pramodnp.pnp@gmail.com", "pramodnp1995");
		log.info("Verify user loged in sucessfully");
		InstaVR_logout logout = Dashboard.gotoAuthoring();
		Assert.assertEquals("InstaVR Web Dashboard", driver.getTitle());
		logout.Logout();
	
	
	}
	
	@AfterTest
	
	public void endTest() {
		
		driver.close();
		log.info("Closing the browser object");
	}
	
	
	
}
