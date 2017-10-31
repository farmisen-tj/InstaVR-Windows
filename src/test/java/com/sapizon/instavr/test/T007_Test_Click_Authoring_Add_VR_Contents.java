package com.sapizon.instavr.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.sapizon.instavr.config.TestBase;
import com.sapizon.instavr.pages_T001.InstaVR_Logout;
import com.sapizon.instavr.pages_T007_Add_VR_Contents.Authoring_Add_VR_contents;
import com.sapizon.instavr.pages_T007_Add_VR_Contents.B001_login;
import com.sapizon.instavr.pages_T007_Add_VR_Contents.Selecting_Content_From_Frame;
import com.sapizon.instavr.pages_T007_Add_VR_Contents.instavrWebDashboard_Add_VR_contents;

public class T007_Test_Click_Authoring_Add_VR_Contents extends TestBase{
	
public static final Logger log = Logger.getLogger(T007_Test_Click_Authoring_Add_VR_Contents.class.getName());
	
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
	public  void VerifyAddVRContentsButton(String Email,String password,String runmode) throws InterruptedException {
		if(runmode.equalsIgnoreCase("n")) {
			throw new SkipException("User Marked The Record As No");
		}
		log("Verify InstaVR Login page is displayed");
		String s=captureScreen("");
		test.log(LogStatus.INFO, "Verify InstaVR Login page is displayed"+test.addScreenCapture(s));	
		B001_login loginpage = PageFactory.initElements(driver, B001_login.class);
		instavrWebDashboard_Add_VR_contents Dashboard = loginpage.dologin(Email, password);
		log("Verified instavr Dashboard is displayed");
		String c=captureScreen("");
		 test.log(LogStatus.INFO, "Verify user is logged in successfully & InstaVR Dashboard is displayed"+test.addScreenCapture(c));
		Authoring_Add_VR_contents add = Dashboard.authoring();
		Selecting_Content_From_Frame first = add.AddContent();
		String a=captureScreen("");
		log("Verify 'Click to Add VR Contents' Button is Present");
		test.log(LogStatus.INFO, "Verify 'Click to Add VR Contents' Button is Present"+test.addScreenCapture(a));
		InstaVR_Logout logout =	first.firstElement();
		logout.Logout();
		log("Verify user loged out sucessfully");
		String ss=captureScreen("");
		test.log(LogStatus.INFO, "Log out from InstaVR"+test.addScreenCapture(ss));
	}
	
	

}
