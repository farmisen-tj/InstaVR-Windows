
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
import com.sapizon.instavr.pages_T014_Upload_Video.B005_Login_Upload_Video;
import com.sapizon.instavr.pages_T014_Upload_Video.Upload_add_VR_Video;
import com.sapizon.instavr.pages_T014_Upload_Video.Upload_click_authoring_video;
import com.sapizon.instavr.pages_T014_Upload_Video.instaLogout;


public class T014_Test_Upload_video extends TestBase{
	
	public static final Logger log = Logger.getLogger(T014_Test_Upload_video.class.getName());

	@BeforeTest
	public void setUp(){
		init();
		log.info("Opening the browser object");
	}
	
	@Test(priority=1)
	public void login() throws IOException, InterruptedException {
		B005_Login_Upload_Video loginpage = PageFactory.initElements(driver, B005_Login_Upload_Video.class);
		loginpage.dologin("pramodnp.pnp@gmail.com", "pramodnp1995");
	}

	@Test(priority=2)
	public void Authoring() throws IOException, InterruptedException {
		Upload_click_authoring_video Dashboard = PageFactory.initElements(driver, Upload_click_authoring_video.class);
		new WebDriverWait(driver, 1000l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.Authoring)));	
		Dashboard.gotoAuthoring();
	
	}
	@Test(priority=3)
	public void Addcontent() throws IOException, InterruptedException {
		Upload_add_VR_Video add = PageFactory.initElements(driver, Upload_add_VR_Video.class);
		new WebDriverWait(driver, 10l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.AddVRcontent)));
		add.AddContent();
		if(driver.findElement(By.xpath("//*[@id=\"placeholder\"]/div/button"))!= null){
			log.info("Verified the video added sucessfully");	
			}else{
			System.out.println("Unable to add Video");
			}
		
	}
	@Test(priority=4)
	public void logout() throws IOException, InterruptedException {
		instaLogout logout = PageFactory.initElements(driver, instaLogout.class);
		logout.Logout();
	}


	@AfterTest 
	public void endTest() {
	new WebDriverWait(driver, 1000l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.password)));	
	driver.close();
	}
	
	
}

