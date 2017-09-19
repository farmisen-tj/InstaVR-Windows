

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
import com.sapizon.instavr.pages_T013_Upload_image.B004_Login_Upload_Image;
import com.sapizon.instavr.pages_T013_Upload_image.InstaVR_logout;
import com.sapizon.instavr.pages_T013_Upload_image.Upload_add_VR_image;
import com.sapizon.instavr.pages_T013_Upload_image.Upload_click_authoring;

public class T013_Test_Upload_image extends TestBase{
	
	public static final Logger log = Logger.getLogger(T013_Test_Upload_image.class.getName());

	@DataProvider(name="loginData")
	public String[][] getTestData(){
		String[][] testRecords = getData("testdata.xlsx", "loginTestData");
		return testRecords;
	}
	
	@BeforeTest
	public void setUp(){
		init();
		log.info("Opening the browser object");
	}
	
		

	@Test(dataProvider="loginData")
	public  void login(String Email,String password,String runmode) throws InterruptedException {
		if(runmode.equalsIgnoreCase("n")) {
			throw new SkipException("User Marked The Record As No");
		}
		log.info("Verified instavr Login is displayed");
		B004_Login_Upload_Image loginpage = PageFactory.initElements(driver, B004_Login_Upload_Image.class);
		loginpage.dologin(Email, password);
	}
	
	@Test(priority=2)
	public void authoring() {	
		Upload_click_authoring Dashboard = PageFactory.initElements(driver, Upload_click_authoring.class);
		log.info("Verified instavr Dashboard is displayed");
		new WebDriverWait(driver, 1000l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.Authoring)));	
		 Dashboard.gotoAuthoring();	
	}
		
	@Test(priority=3)
	public void Addcontent() throws IOException, InterruptedException {
		Upload_add_VR_image add = PageFactory.initElements(driver, Upload_add_VR_image.class);
		new WebDriverWait(driver, 1000l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.AddVRcontent)));
		add.AddContent();

	}
	
	
	@Test(priority=4)
	public void logout() throws IOException, InterruptedException {
		InstaVR_logout logout = PageFactory.initElements(driver, InstaVR_logout.class);
		logout.Logout();
	}
	
	
	@AfterTest 
	public void endTest() {
	new WebDriverWait(driver, 1000l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.password)));	
	driver.close();
	}
	
}
