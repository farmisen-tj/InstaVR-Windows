package com.sapizon.instavr.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.sapizon.instavr.config.TestBase;
import com.sapizon.instavr.pages_T001.InstaVR_Logout;
import com.sapizon.instavr.pages_T001.InstavrLoginPage;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_login;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_logout;

@SuppressWarnings("unused")
public class T001_Test_LoginTest extends TestBase {

	public static final Logger log = Logger.getLogger(T001_Test_LoginTest.class.getName());
	
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
	public  void login(String Email,String password,String runmode ) throws InterruptedException {
		if(runmode.equalsIgnoreCase("n")) {
			throw new SkipException("User Marked The Record As No");
		}
	log("Verify InstaVR Login page is displayed");
	String s=captureScreen("");
	test.log(LogStatus.INFO, "Verify InstaVR Login page is displayed"+test.addScreenCapture(s));
	Reporter.log("Verify InstaVR Login page is displayed"+test.addScreenCapture(s));
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




