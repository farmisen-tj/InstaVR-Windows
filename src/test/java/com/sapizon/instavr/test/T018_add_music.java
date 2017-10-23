package com.sapizon.instavr.test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sapizon.instavr.config.Configration;
import com.sapizon.instavr.config.TestBase;
import com.sapizon.instavr.pages.addMusic.instaVR_Add_Music;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_logout;
import com.sapizon.instavr.pages_T017_add_Action.T017_Actions;
import com.sapizon.instavr.pages_T017_add_Action.T017_add_image;
import com.sapizon.instavr.pages_T017_add_Action.T017_authoring;
import com.sapizon.instavr.pages_T017_add_Action.T017_login;

public class T018_add_music extends TestBase{
	
	public static final Logger log = Logger.getLogger(T018_add_music.class.getName());

	@DataProvider(name="loginData")
	public String[][] getTestData(){
		String[][] testRecords = getData("testdata.xlsx", "loginTestData");
		return testRecords;
	}

	@BeforeClass

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
		captureScreen("T017_Test_Upload_image_Verify_Actions");
		T017_login loginpage = PageFactory.initElements(driver, T017_login.class);
		loginpage.dologin(Email, password);
		log("Verify User is logged in successfully");
	}
	
	@Test(priority=2)
	public void authoring() {	
		T017_authoring Dashboard = PageFactory.initElements(driver, T017_authoring.class);
		log("Verified instavr Dashboard is displayed");
		new WebDriverWait(driver, 1000l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.Authoring)));	
		 Dashboard.gotoAuthoring();	
			log("Verified the user is on Authoring section");
	}
		
	@Test(priority=3)
	public void Addcontent() throws IOException, InterruptedException {
		T017_add_image add = PageFactory.initElements(driver, T017_add_image.class);
		new WebDriverWait(driver, 10l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.AddVRcontent)));
		add.AddContent();
		log("Verified the user Uploads a image");
	}
	
	
	@Test(priority=4)
	public void AddLink() throws IOException, InterruptedException {
		instaVR_Add_Music link = PageFactory.initElements(driver, instaVR_Add_Music.class);
		link.AddMusic();
		//if(driver.findElement(By.xpath(Configration.Assert1))!= null){
			//log("Verified the Action added sucessfully");	
		 	//}else{
			//log( "Unable to add Action");	
			}
				
	


	@Test(priority=5)
	public void logout() throws IOException, InterruptedException {
		T016_logout logout = PageFactory.initElements(driver, T016_logout.class);
		logout.Logout();
		log("Verified the user logged out sucessfully");	

	}
	

}
