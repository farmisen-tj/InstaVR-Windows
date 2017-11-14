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
	test.log(LogStatus.INFO, "Verify InstaVR Login page is displayed"+test.addScreenCapture(s));

	T016_login loginpage = PageFactory.initElements(driver, T016_login.class);
	loginpage.dologin(Email );
	String szzzs=captureScreen("");
	test.log(LogStatus.INFO, "Enter Valid Username"+test.addScreenCapture(szzzs));
	loginpage.password(password);
	String szzs=captureScreen("");
	test.log(LogStatus.INFO, "Enter Valid Password"+test.addScreenCapture(szzs));
	String sss=captureScreen("");
	test.log(LogStatus.INFO, "Click on Sign In Button"+test.addScreenCapture(sss));
	loginpage.signin();
	log("Verified instavr Dashboard is displayed");
	String c=captureScreen("");
	test.log(LogStatus.INFO, "Verify user is logged in successfully & InstaVR Dashboard is displayed"+test.addScreenCapture(c));
	
	InstaVR_gotoAuthoring Dashboard = PageFactory.initElements(driver, InstaVR_gotoAuthoring.class);
	Dashboard.gotoAuthoring();
	String a=captureScreen("");
	log("Verify User is on Authoring Section");
	test.log(LogStatus.INFO, "Verify User is on Authoring Section"+test.addScreenCapture(a));
	T016_logout logout = PageFactory.initElements(driver, T016_logout.class);
	logout.dropdown();
	String ddmmm=captureScreen("");
	 test.log(LogStatus.INFO, "Click on username dropdown at top right corner"+test.addScreenCapture(ddmmm));
	 test.log(LogStatus.INFO, "Verify dropdown menu is displays “Logout” button"+test.addScreenCapture(ddmmm));
	 logout.Logout();
	log("Verify user loged out sucessfully");
	String ss=captureScreen("");
	test.log(LogStatus.INFO, "Log out from InstaVR"+test.addScreenCapture(ss));
}
		
}
