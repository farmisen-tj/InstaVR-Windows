package com.sapizon.instavr.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.sapizon.instavr.config.Configration;
import com.sapizon.instavr.config.TestBase;
import com.sapizon.instavr.pages_T013_Upload_image.Add_Link;
import com.sapizon.instavr.pages_T013_Upload_image.B004_Login_Upload_Image;
import com.sapizon.instavr.pages_T013_Upload_image.InstaVR_logout;
import com.sapizon.instavr.pages_T013_Upload_image.Upload_add_VR_image;
import com.sapizon.instavr.pages_T015.Upload_click_authoring;

@SuppressWarnings("unused")
public class T015_Test_Upload_image_Select_image_add_link extends TestBase{

	
	public static final Logger log = Logger.getLogger(T015_Test_Upload_image_Select_image_add_link.class.getName());

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
	public  void AddLink(String Email,String password,String runmode) throws InterruptedException, IOException {
		if(runmode.equalsIgnoreCase("n")) {
			throw new SkipException("User Marked The Record As No");
		}
		log("Verify InstaVR Login page is displayed");
		String s=captureScreen("");
		test.log(LogStatus.INFO, "Verify InstaVR Login page is displayed"+test.addScreenCapture(s));
		B004_Login_Upload_Image loginpage = PageFactory.initElements(driver, B004_Login_Upload_Image.class);
		loginpage.dologin(Email, password);
		log("Verified instavr Dashboard is displayed");
		String c=captureScreen("");
		test.log(LogStatus.INFO, "Verify user is logged in successfully & InstaVR Dashboard is displayed"+test.addScreenCapture(c));
	
		Upload_click_authoring Dashboard = PageFactory.initElements(driver, Upload_click_authoring.class);
		log("Verify user is on Authoring Section");
		 String d=captureScreen("");
		 test.log(LogStatus.INFO, "Verify user is on Authoring Section"+test.addScreenCapture(d));
		new WebDriverWait(driver, 1000l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.Authoring)));	
		 Dashboard.gotoAuthoring();	
		Upload_add_VR_image add = PageFactory.initElements(driver, Upload_add_VR_image.class);
		new WebDriverWait(driver, 10l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.AddVRcontent)));
		add.AddContent();
		log("Verify File Manager is displayed");
		String dd=captureScreen("");
		 test.log(LogStatus.INFO, "Verify File Manager is displayed"+test.addScreenCapture(dd));
		Add_Link link = PageFactory.initElements(driver, Add_Link.class);
		link.AddLink();
		String ddm=captureScreen("");
		 test.log(LogStatus.INFO, "Select File (Image) from your local machine and upload to the File Manager"+test.addScreenCapture(ddm));
		 test.log(LogStatus.INFO, "Verify File (Image) is uploaded succesfully"+test.addScreenCapture(ddm));
		if(driver.findElement(By.xpath(Configration.Assert))!= null){
			log("Verify the Link added sucessfully");	
			String ddz=captureScreen("");
			 test.log(LogStatus.INFO, "Verify the Link added sucessfully"+test.addScreenCapture(ddz));
		 	}else{
		 	String ddz=captureScreen("");
		 	test.log(LogStatus.INFO, "Unable To Locate Link button"+test.addScreenCapture(ddz));
			}
		InstaVR_logout logout = PageFactory.initElements(driver, InstaVR_logout.class);
		logout.Logout();
		log("Verify user loged out sucessfully");
		String ss=captureScreen("");
		test.log(LogStatus.INFO, "Log out from InstaVR"+test.addScreenCapture(ss));

	}
	
	
	
	
}
