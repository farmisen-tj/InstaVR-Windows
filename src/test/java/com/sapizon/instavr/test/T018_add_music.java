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

import com.relevantcodes.extentreports.LogStatus;
import com.sapizon.instavr.config.Configration;
import com.sapizon.instavr.config.TestBase;
import com.sapizon.instavr.pages.addMusic.instaVR_Add_Music;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_logout;
import com.sapizon.instavr.pages_T017_add_Action.T017_Actions;
import com.sapizon.instavr.pages_T017_add_Action.T017_add_image;
import com.sapizon.instavr.pages_T017_add_Action.T017_authoring;
import com.sapizon.instavr.pages_T017_add_Action.T017_login;

@SuppressWarnings("unused")
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

	@Test(dataProvider="loginData",priority=1)
	public  void AddMusic(String Email,String password,String runmode) throws InterruptedException, IOException {
		if(runmode.equalsIgnoreCase("n")) {
			throw new SkipException("User Marked The Record As No");
		}
		log("Verify InstaVR Login page is displayed");
		String s=captureScreen("");
		test.log(LogStatus.INFO, "Verify InstaVR Login page is displayed"+test.addScreenCapture(s));
		T017_login loginpage = PageFactory.initElements(driver, T017_login.class);
		loginpage.dologin(Email, password);
		log("Verified instavr Dashboard is displayed");
		String c=captureScreen("");
		test.log(LogStatus.INFO, "Verify user is logged in successfully & InstaVR Dashboard is displayed"+test.addScreenCapture(c));				
		T017_authoring Dashboard = PageFactory.initElements(driver, T017_authoring.class);
		log("Verify user is on Authoring Section");
		 String d=captureScreen("");
		 test.log(LogStatus.INFO, "Verify user is on Authoring Section"+test.addScreenCapture(d));
		 new WebDriverWait(driver, 1000l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.Authoring)));	
		 Dashboard.gotoAuthoring();		
		T017_add_image add = PageFactory.initElements(driver, T017_add_image.class);
		new WebDriverWait(driver, 10l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.AddVRcontent)));
		add.AddContent();
		log("Verify File Manager is displayed");
		String dd=captureScreen("");
		test.log(LogStatus.INFO, "Verify File Manager is displayed"+test.addScreenCapture(dd));	
		instaVR_Add_Music link = PageFactory.initElements(driver, instaVR_Add_Music.class);
		String ddm=captureScreen("");
		test.log(LogStatus.INFO, "Select File (Image) from your local machine and upload to the File Manager"+test.addScreenCapture(ddm));
		test.log(LogStatus.INFO, "Verify File (Image) is uploaded succesfully"+test.addScreenCapture(ddm));
		link.AddMusic();
		String ddmm=captureScreen("");
		test.log(LogStatus.INFO, "Select File (Music) from your local machine and upload to the File Manager"+test.addScreenCapture(ddm));
		test.log(LogStatus.INFO, "Verify File (Music) is uploaded succesfully"+test.addScreenCapture(ddmm));
		log("Verified the Music added sucessfully");
		String ddz=captureScreen("");
		test.log(LogStatus.INFO, "Verify the Music added successfully"+test.addScreenCapture(ddz));
		T016_logout logout = PageFactory.initElements(driver, T016_logout.class);
		logout.Logout();
		log("Verify user loged out sucessfully");
		String ss=captureScreen("");
		test.log(LogStatus.INFO, "Log out from InstaVR"+test.addScreenCapture(ss));
	}
	

}
