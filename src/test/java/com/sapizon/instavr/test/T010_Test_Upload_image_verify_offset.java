package com.sapizon.instavr.test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sapizon.instavr.config.Configration;
import com.sapizon.instavr.config.TestBase;
import com.sapizon.instavr.pages_T010_file_Offset.T010_Slider_resetOffset;
import com.sapizon.instavr.pages_T010_file_Offset.T010_add_image;
import com.sapizon.instavr.pages_T010_file_Offset.T010_authoring;
import com.sapizon.instavr.pages_T010_file_Offset.T010_login;
import com.sapizon.instavr.pages_T010_file_Offset.T010_logout;

public class T010_Test_Upload_image_verify_offset extends TestBase{
	
public static final Logger log = Logger.getLogger(T009_Test_Select_Sence_Add_Link.class.getName());
	
	@BeforeTest
	public void setUp(){
		init();
	}
	
	@Test(priority=1)
	public void login() {
		log.info("Verified instavr Login is displayed");
		T010_login loginpage = PageFactory.initElements(driver, T010_login.class);
		loginpage.dologin("pramodnp.pnp@gmail.com", "pramodnp1995");
		log.info("Verify User is logged in successfully");
	}
	
	

	@Test(priority=2)
	public void authoring() {	
		T010_authoring Dashboard = PageFactory.initElements(driver, T010_authoring.class);
		log.info("Verified instavr Dashboard is displayed");
		new WebDriverWait(driver, 1000l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.Authoring)));	
		 Dashboard.gotoAuthoring();	
			log.info("Verified the user is on Authoring section");
	}
	
	@Test(priority=3)
	public void Addcontent() throws IOException, InterruptedException {
		T010_add_image add = PageFactory.initElements(driver, T010_add_image.class);
		new WebDriverWait(driver, 10l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.AddVRcontent)));
		add.AddContent();
		log.info("Verified the user Uploads a image");
	}
	
	@Test(priority=4)
	public void sliderAction() throws IOException, InterruptedException {
		T010_Slider_resetOffset link = PageFactory.initElements(driver, T010_Slider_resetOffset.class);
	link.SliderAction();
	
	}
	
	@Test(priority=5)
	public void logout() throws IOException, InterruptedException {
		T010_logout logout = PageFactory.initElements(driver, T010_logout.class);
		logout.Logout();
		log.info("Verified the user logged out sucessfully");	

	}
	
	
	@AfterTest 
	
	public void endTest() {
		new WebDriverWait(driver, 1000l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.password)));	
		driver.close();
		log.info("closing the browser object");

	}
	
	
	
	

}
	
	
	
