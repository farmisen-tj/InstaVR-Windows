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
import com.sapizon.instavr.pages_T010_file_Offset.T010_Slider_resetOffset;
import com.sapizon.instavr.pages_T010_file_Offset.T010_add_image;
import com.sapizon.instavr.pages_T010_file_Offset.T010_authoring;
import com.sapizon.instavr.pages_T010_file_Offset.T010_login;
import com.sapizon.instavr.pages_T010_file_Offset.T010_logout;

@SuppressWarnings("unused")
public class T010_Test_Upload_image_verify_offset extends TestBase{
	
public static final Logger log = Logger.getLogger(T010_Test_Upload_image_verify_offset.class.getName());
	
@DataProvider(name="loginData")
public String[][] getTestData(){
	String[][] testRecords = getData("testdata.xlsx", "loginTestData");
	return testRecords;
}

	@BeforeClass

	public void setUp(){
		init();
	}
	
	@Test(dataProvider="loginData")
	public  void VerifyOffsetAndResetButton(String Email,String password,String runmode) throws InterruptedException, IOException {
		if(runmode.equalsIgnoreCase("n")) {
			throw new SkipException("User Marked The Record As No");
		}
		log("Verify InstaVR Login page is displayed");
		String s=captureScreen("");
		test.log(LogStatus.INFO, "Verify InstaVR Login page is displayed"+test.addScreenCapture(s));			
		T010_login loginpage = PageFactory.initElements(driver, T010_login.class);
		loginpage.dologin(Email, password);	
		log("Verified instavr Dashboard is displayed");
		String c=captureScreen("");
		test.log(LogStatus.INFO, "Verify user is logged in successfully & InstaVR Dashboard is displayed"+test.addScreenCapture(c));
		T010_authoring Dashboard = PageFactory.initElements(driver, T010_authoring.class);
		log("Verified instavr Dashboard is displayed");
		new WebDriverWait(driver, 1000l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.Authoring)));	
		 Dashboard.gotoAuthoring();	
		 log("Verify user is on Authoring Section");
		 String d=captureScreen("");
		 test.log(LogStatus.INFO, "Verify user is on Authoring Section"+test.addScreenCapture(d));	
		T010_add_image add = PageFactory.initElements(driver, T010_add_image.class);
		new WebDriverWait(driver, 10l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.AddVRcontent)));
		log("Verify File Manager is displayed");
		String dd=captureScreen("");
		 test.log(LogStatus.INFO, "Verify File Manager is displayed"+test.addScreenCapture(dd));
		add.AddContent();
		String ddm=captureScreen("");
		 test.log(LogStatus.INFO, "Select File from your local machine and upload to the File Manager"+test.addScreenCapture(ddm));
		 test.log(LogStatus.INFO, "Verify File is uploaded succesfully"+test.addScreenCapture(ddm));
		T010_Slider_resetOffset link = PageFactory.initElements(driver, T010_Slider_resetOffset.class);
		link.SliderAction();
		String ddc=captureScreen("");
		test.log(LogStatus.INFO, "Verify Slider movement to 90 degree And -90 degree "+test.addScreenCapture(ddc));
		test.log(LogStatus.INFO, "Verify Reset button is present"+test.addScreenCapture(ddc));
		T010_logout logout = PageFactory.initElements(driver, T010_logout.class);
		logout.Logout();
		log("Verified the user logged out sucessfully");	
		String ss=captureScreen("");
		test.log(LogStatus.INFO, "Log out from InstaVR"+test.addScreenCapture(ss));
	}
	
	

}
	
	
	
