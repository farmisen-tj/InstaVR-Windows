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
import com.sapizon.instavr.pages.ManagingScene;
import com.sapizon.instavr.pages_T007_Add_VR_Contents.Authoring_Add_VR_contents;
import com.sapizon.instavr.pages_T007_Add_VR_Contents.B001_login;
import com.sapizon.instavr.pages_T007_Add_VR_Contents.Selecting_Content_From_Frame;
import com.sapizon.instavr.pages_T007_Add_VR_Contents.instavrWebDashboard_Add_VR_contents;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_add_image;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_authoring;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_login;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_logout;

@SuppressWarnings("unused")
public class T008VerifyFilemanager  extends TestBase{
	
public static final Logger log = Logger.getLogger(T008VerifyFilemanager.class.getName());
	
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
public  void VerifyFilemanager(String Email,String password,String runmode) throws InterruptedException, IOException {
	if(runmode.equalsIgnoreCase("n")) {
		throw new SkipException("User Marked The Record As No");
	}
	log("Verify InstaVR Login page is displayed");
	String s=captureScreen("");
	test.log(LogStatus.INFO, "Verify InstaVR Login page is displayed"+test.addScreenCapture(s));	
	T016_login loginpage = PageFactory.initElements(driver, T016_login.class);
	loginpage.dologin(Email );
	String smms=captureScreen("");
	test.log(LogStatus.INFO, "Enter Valid Username"+test.addScreenCapture(smms));
	loginpage.password(password);
	String szzs=captureScreen("");
	test.log(LogStatus.INFO, "Enter Valid Password"+test.addScreenCapture(szzs));
	String sss=captureScreen("");
	test.log(LogStatus.INFO, "Click on Sign In Button"+test.addScreenCapture(sss));
	loginpage.signin();
	log("Verified instavr Dashboard is displayed");
	String c=captureScreen("");
	test.log(LogStatus.INFO, "Verify user is logged in successfully & InstaVR Dashboard is displayed"+test.addScreenCapture(c));
	T016_authoring Dashboard = PageFactory.initElements(driver, T016_authoring.class);;
	new WebDriverWait(driver, 1000l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.Authoring)));	
	 Dashboard.gotoAuthoring();
	 log("Verify user is on Authoring Section");
		String d=captureScreen("");
		 test.log(LogStatus.INFO, "Verify user is on Authoring Section"+test.addScreenCapture(d));
		 T016_add_image add = PageFactory.initElements(driver, T016_add_image.class);
			new WebDriverWait(driver, 10l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.AddVRcontent)));
			add.AddContent();
			String dd=captureScreen("");
			test.log(LogStatus.INFO, "Verify File Manager is displayed"+test.addScreenCapture(dd));	
			add.addimage();
			log("Verify File Manager is displayed");
	T016_logout logout = PageFactory.initElements(driver, T016_logout.class);
	logout.dropdown();
	String ddmmm=captureScreen("");
	 test.log(LogStatus.INFO, "Click on username dropdown at top right corner"+test.addScreenCapture(ddmmm));
	 test.log(LogStatus.INFO, "Verify dropdown menu is displays “Logout” button"+test.addScreenCapture(ddmmm));
	 logout.Logout();
	log("Verify user loged out sucessfully");
	String sxs=captureScreen("");
	test.log(LogStatus.INFO, "Log out from InstaVR"+test.addScreenCapture(sxs));
}

}
