 package com.sapizon.instavr.test;

  import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sapizon.instavr.config.Configration;
import com.sapizon.instavr.config.TestBase;
import com.sapizon.instavr.pages_T014_Upload_Video.B005_Login_Upload_Video;
import com.sapizon.instavr.pages_T014_Upload_Video.Upload_add_VR_Video;
import com.sapizon.instavr.pages_T014_Upload_Video.Upload_click_authoring_video;
import com.sapizon.instavr.pages_T014_Upload_Video.instaLogout;

public class test extends TestBase{
	
	public static final Logger log = Logger.getLogger(test.class.getName());

	@BeforeMethod
	@BeforeTest
	public void setUp(){
		init();
		log.info("Open console.instavr.co");

	}
	@Test
	public void addVideo() throws IOException, InterruptedException {
		B005_Login_Upload_Video loginpage = PageFactory.initElements(driver, B005_Login_Upload_Video.class);
		Upload_click_authoring_video authoring=loginpage.dologin("pramodnp.pnp@gmail.com", "pramodnp1995");
		Upload_add_VR_Video add = authoring.gotoAuthoring();
		new WebDriverWait(driver, 1000l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.AddVRcontent)));
		instaLogout logout=add.AddContent();
		logout.Logout();
		
	}
	
	

}
