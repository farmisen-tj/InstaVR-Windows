package com.sapizon.instavr.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.sapizon.instavr.config.TestBase;
import com.sapizon.instavr.pages_T004.InstaVR_Login__Preview;
import com.sapizon.instavr.pages_T004.InstaVR_gotoPreview;
import com.sapizon.instavr.pages_T004.InstaVr_logout;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_login;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_logout;

@SuppressWarnings("unused")
public class T004_Test_Verify_Preview extends TestBase{

public static final Logger log = Logger.getLogger(T004_Test_Verify_Preview.class.getName());
	
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
	public  void VerifyPreview(String Email,String password,String runmode) throws InterruptedException {
		if(runmode.equalsIgnoreCase("n")) {
			throw new SkipException("User Marked The Record As No");
		}
		log("Verify InstaVR Login page is displayed");
		captureScreen("");
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
		
		 InstaVR_gotoPreview Dashboard = PageFactory.initElements(driver, InstaVR_gotoPreview.class);
		 Dashboard.gotoPreview();
		captureScreen("");
		log("Verify User is on Preview Section");
		test.log(LogStatus.INFO, "Verify User is on Preview Section"+test.addScreenCapture(newFileName));
		Assert.assertEquals("InstaVR Web Dashboard", driver.getTitle());
		T016_logout logout = PageFactory.initElements(driver, T016_logout.class);
		logout.dropdown();
		String ddmmm=captureScreen("");
		 test.log(LogStatus.INFO, "Click on username dropdown at top right corner"+test.addScreenCapture(newFileName));
		 test.log(LogStatus.INFO, "Verify dropdown menu is displays Logout button"+test.addScreenCapture(newFileName));
		 logout.Logout();
		log("Verify user loged out sucessfully");
		captureScreen("");
		test.log(LogStatus.INFO, "Logout from InstaVR"+test.addScreenCapture(newFileName));
	}
	
	
	
}
