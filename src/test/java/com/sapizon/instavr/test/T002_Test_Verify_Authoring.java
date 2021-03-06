package com.sapizon.instavr.test;

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
import com.sapizon.instavr.pages_T002.InstaVR_Login_Authoring;
import com.sapizon.instavr.pages_T002.InstaVR_gotoAuthoring;
import com.sapizon.instavr.pages_T002.InstaVR_logout;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_login;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_logout;

@SuppressWarnings("unused")
public class T002_Test_Verify_Authoring extends TestBase {

public static final Logger log = Logger.getLogger(T002_Test_Verify_Authoring.class.getName());
	
@DataProvider(name="loginData")
public String[][] getTestData(){
	String[][] testRecords = getData("testdata.xlsx", "loginTestData");
	return testRecords;
}

@BeforeClass

	public void setUp(){
		init();
		log("Open console.instavr.co");

	}

@Test(dataProvider="loginData")
public  void VerifingAuthoring(String Email,String password,String runmode) throws InterruptedException {
	if(runmode.equalsIgnoreCase("n")) {
		throw new SkipException("User Marked The Record As No");
	}
	log("Verify InstaVR Login page is displayed");
	 String s=captureScreen("");
	test.log(LogStatus.INFO, "Verify InstaVR Login page is displayed"+test.addScreenCapture(newFileName));
	T016_login loginpage = PageFactory.initElements(driver, T016_login.class);
	loginpage.dologin(Email );
	captureScreen("");
	test.log(LogStatus.INFO, "Enter Valid Username"+test.addScreenCapture(newFileName));
	loginpage.password(password);
	captureScreen("");
	test.log(LogStatus.INFO, "Enter Valid Password"+test.addScreenCapture(newFileName));
	captureScreen("");
	test.log(LogStatus.INFO, "Click on Sign In Button"+test.addScreenCapture(newFileName));
	loginpage.signin();
	log("Verified instavr Dashboard is displayed");
	captureScreen("");
	test.log(LogStatus.INFO, "Verify user is logged in successfully & InstaVR Dashboard is displayed"+test.addScreenCapture(newFileName));
	
	InstaVR_gotoAuthoring Dashboard = PageFactory.initElements(driver, InstaVR_gotoAuthoring.class);
	Dashboard.gotoAuthoring();
	captureScreen("");
	log("Verify User is on Authoring Section");
	test.log(LogStatus.INFO, "Verify User is on Authoring Section"+test.addScreenCapture(newFileName));
	T016_logout logout = PageFactory.initElements(driver, T016_logout.class);
	logout.dropdown();
	captureScreen("");
	 test.log(LogStatus.INFO, "Click on username dropdown at top right corner"+test.addScreenCapture(newFileName));
	 test.log(LogStatus.INFO, "Verify dropdown menu is displays â€œLogoutâ€� button"+test.addScreenCapture(newFileName));
	 logout.Logout();
	log("Verify user loged out sucessfully");
	captureScreen("");
	test.log(LogStatus.INFO, "Log out from InstaVR"+test.addScreenCapture(newFileName));
}
		
}
