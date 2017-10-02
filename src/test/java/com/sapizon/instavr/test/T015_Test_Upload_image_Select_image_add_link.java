package com.sapizon.instavr.test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sapizon.instavr.config.Configration;
import com.sapizon.instavr.config.TestBase;
import com.sapizon.instavr.pages_T013_Upload_image.Add_Link;
import com.sapizon.instavr.pages_T013_Upload_image.B004_Login_Upload_Image;
import com.sapizon.instavr.pages_T013_Upload_image.InstaVR_logout;
import com.sapizon.instavr.pages_T013_Upload_image.Upload_add_VR_image;
import com.sapizon.instavr.pages_T015.Upload_click_authoring;

public class T015_Test_Upload_image_Select_image_add_link extends TestBase{

	
	public static final Logger log = Logger.getLogger(T015_Test_Upload_image_Select_image_add_link.class.getName());

	@DataProvider(name="loginData")
	public String[][] getTestData(){
		String[][] testRecords = getData("testdata.xlsx", "loginTestData");
		return testRecords;
	}
	
	@BeforeTest
	public void setUp(){
		init();
		log("Opening the browser object");
		}
		

	@Test(dataProvider="loginData")
	public  void login(String Email,String password,String runmode) throws InterruptedException {
		if(runmode.equalsIgnoreCase("n")) {
			throw new SkipException("User Marked The Record As No");
		}
		log("Verified instavr Login is displayed");
		B004_Login_Upload_Image loginpage = PageFactory.initElements(driver, B004_Login_Upload_Image.class);
		loginpage.dologin(Email, password);
		log("Verify User is logged in successfully");
	}
	
	@Test(priority=2)
	public void authoring() {	
		Upload_click_authoring Dashboard = PageFactory.initElements(driver, Upload_click_authoring.class);
		log("Verified instavr Dashboard is displayed");
		new WebDriverWait(driver, 1000l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.Authoring)));	
		 Dashboard.gotoAuthoring();	
			log("Verified the user is on Authoring section");
	}
		
	@Test(priority=3)
	public void Addcontent() throws IOException, InterruptedException {
		Upload_add_VR_image add = PageFactory.initElements(driver, Upload_add_VR_image.class);
		new WebDriverWait(driver, 10l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.AddVRcontent)));
		add.AddContent();
		log("Verified the user Uploads a image");
	}
	
	
	@Test(priority=4)
	public void AddLink() throws IOException, InterruptedException {
		Add_Link link = PageFactory.initElements(driver, Add_Link.class);
		link.AddLink();
		if(driver.findElement(By.xpath(Configration.Assert))!= null){
			log("Verified the Link added sucessfully");	
		 	}else{
			log( "Unable to add Link");	
			}
	}


	@Test(priority=5)
	public void logout() throws IOException, InterruptedException {
		InstaVR_logout logout = PageFactory.initElements(driver, InstaVR_logout.class);
		logout.Logout();
		log("Verified the user logged out sucessfully");	

	}
	
	
	
	
}
