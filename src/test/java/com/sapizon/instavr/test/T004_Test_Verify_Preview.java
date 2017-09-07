package com.sapizon.instavr.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sapizon.instavr.config.TestBase;
import com.sapizon.instavr.pages_T004.InstaVR_Login__Preview;
import com.sapizon.instavr.pages_T004.InstaVR_gotoPreview;
import com.sapizon.instavr.pages_T004.InstaVr_logout;

public class T004_Test_Verify_Preview extends TestBase{

public static final Logger log = Logger.getLogger(T004_Test_Verify_Preview.class.getName());
	
	@BeforeTest
	public void setUp(){
		init();
		log.info("Opening the browser object");

	}

	
	@Test
	public void BrandingClick() throws InterruptedException{
		log.info("Verified instavr Login is displayed");
		InstaVR_Login__Preview loginpage = PageFactory.initElements(driver, InstaVR_Login__Preview.class);
		InstaVR_gotoPreview Dashboard = loginpage.dologin("pramodnp.pnp@gmail.com", "pramodnp1995");
		log.info("Verified instavr Login is displayed");
		InstaVr_logout logout=Dashboard.gotoPreview();
		Thread.sleep(60l);
		Assert.assertEquals("InstaVR Web Dashboard", driver.getTitle());
		logout.Logout();
		Assert.assertEquals("Login", driver.getTitle());
		

	}
	
	@AfterTest
	
	public void endTest() {
		
		driver.close();
		log.info("Closing the browser object");

	}
	
	
}
