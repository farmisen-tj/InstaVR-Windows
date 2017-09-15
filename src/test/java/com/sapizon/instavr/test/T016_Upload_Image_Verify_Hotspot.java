package com.sapizon.instavr.test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sapizon.instavr.config.Configration;
import com.sapizon.instavr.config.TestBase;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_Hotsopt;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_add_image;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_authoring;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_login;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_logout;

public class T016_Upload_Image_Verify_Hotspot extends TestBase {

	public static final Logger log = Logger.getLogger(T016_Upload_Image_Verify_Hotspot.class.getName());
  
	
	@DataProvider(name="loginData")
	public String[][] getTestData() {
		String[][] test = getData("testdata.xlsx","testcase");
		return test;
	}
	
	@BeforeTest
	public void setUp(){
		init();
		log.info("Opening the browser object");
		}
		

	@Test(dataProvider="loginData",priority=1)
	public void login(String username, String password) {
		log.info("Verified instavr Login is displayed");
		T016_login loginpage = PageFactory.initElements(driver, T016_login.class);
		loginpage.dologin(username, password);
		log.info("Verify User is logged in successfully");
	}
	
	@Test(priority=2)
	public void authoring() {	
		T016_authoring Dashboard = PageFactory.initElements(driver, T016_authoring.class);
		log.info("Verified instavr Dashboard is displayed");
		new WebDriverWait(driver, 1000l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.Authoring)));	
		 Dashboard.gotoAuthoring();	
			log.info("Verified the user is on Authoring section");
	}
		
	@Test(priority=3)
	public void Addcontent() throws IOException, InterruptedException {
		T016_add_image add = PageFactory.initElements(driver, T016_add_image.class);
		new WebDriverWait(driver, 10l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.AddVRcontent)));
		add.AddContent();
		log.info("Verified the user Uploads a image");
	}
	
	
	@Test(priority=4)
	public void AddLink() throws IOException, InterruptedException {
		T016_Hotsopt link = PageFactory.initElements(driver, T016_Hotsopt.class);
		link.addHotspot();
		if(driver.findElement(By.xpath(Configration.Assert1))!= null){
			log.info("Verified the Hotspot added sucessfully");	
		 	}else{
			log.info( "Unable to add Hotspot");	
			}
				
	}


	@Test(priority=5)
	public void logout() throws IOException, InterruptedException {
		T016_logout logout = PageFactory.initElements(driver, T016_logout.class);
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