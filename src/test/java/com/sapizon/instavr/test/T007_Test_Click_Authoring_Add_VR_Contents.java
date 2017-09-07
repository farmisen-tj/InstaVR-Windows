package com.sapizon.instavr.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sapizon.instavr.config.TestBase;
import com.sapizon.instavr.pages_T007_Add_VR_Contents.Authoring_Add_VR_contents;
import com.sapizon.instavr.pages_T007_Add_VR_Contents.B001_login;
import com.sapizon.instavr.pages_T007_Add_VR_Contents.Selecting_Content_From_Frame;
import com.sapizon.instavr.pages_T007_Add_VR_Contents.instavrWebDashboard_Add_VR_contents;

public class T007_Test_Click_Authoring_Add_VR_Contents extends TestBase{
	
public static final Logger log = Logger.getLogger(T007_Test_Click_Authoring_Add_VR_Contents.class.getName());
	
	@BeforeTest
	public void setUp(){
		init();
	}

	@Test
	public void AddVRcontents() {
		log.info("============= Adding VR contents test ==============");
		B001_login loginpage = PageFactory.initElements(driver, B001_login.class);
		log.info("At Login Page");
		instavrWebDashboard_Add_VR_contents Dashboard = loginpage.dologin("pramodnp.pnp@gmail.com", "pramodnp1995");
		log.info("At InstaVR Dashbord");
		Authoring_Add_VR_contents add = Dashboard.authoring();
		log.info("Clicked on authoring");
		Selecting_Content_From_Frame first = add.AddContent();
		log.info("Switching to the selecting frame");
		first.firstElement();
		log.info("Selecting the first element on the frame");
		
		
	}
	
	@AfterTest
	public void endTest() {
		
		driver.close();
	
	}
	
	
	

}
