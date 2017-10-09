package com.sapizon.instavr.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sapizon.instavr.config.TestBase;
import com.sapizon.instavr.pages.ManagingScene;
import com.sapizon.instavr.pages_T007_Add_VR_Contents.Authoring_Add_VR_contents;
import com.sapizon.instavr.pages_T007_Add_VR_Contents.B001_login;
import com.sapizon.instavr.pages_T007_Add_VR_Contents.Selecting_Content_From_Frame;
import com.sapizon.instavr.pages_T007_Add_VR_Contents.instavrWebDashboard_Add_VR_contents;

public class T008_Test_Managing_Sences  extends TestBase{
	
public static final Logger log = Logger.getLogger(T008_Test_Managing_Sences.class.getName());
	
	@BeforeMethod
	@BeforeTest
	public void setUp(){
		init();
	}
	
	@Test
	public void Moving_Slider_and_Resting_offset() {
		log("============= Starting Moving_Slider_and_Resting_offset test==============");
		B001_login loginpage = PageFactory.initElements(driver, B001_login.class);
		log("At Login Page");
		instavrWebDashboard_Add_VR_contents Dashboard = loginpage.dologin("pramodnp.pnp@gmail.com", "pramodnp1995");
		log("At InstaVR Dashbord");
		Authoring_Add_VR_contents add = Dashboard.authoring();
		log("Clicked on authoring");
		Selecting_Content_From_Frame first = add.AddContent();
		log("Switching to the selecting frame");
		ManagingScene sences = first.firstElement();
		log("Selecting the first element on the frame");
		sences.Slider();
		log("Moving the slider to 145");
		sences.ResetOff();
		log("Reseting the offset");

	}
	

}
