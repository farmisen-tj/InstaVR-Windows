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
	InstaVR_Login_Authoring loginpage = PageFactory.initElements(driver, InstaVR_Login_Authoring.class);
	InstaVR_gotoAuthoring Dashboard = loginpage.dologin(Email, password);
	new WebDriverWait(driver, 1000l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.Authoring)));	
	String c=captureScreen("");
	test.log(LogStatus.INFO, "Verify user logged in sucessfully"+test.addScreenCapture(c));
	InstaVR_logout logout=Dashboard.gotoAuthoring();
	String a=captureScreen("");
	log("Verify User is on Authoring Section");
	test.log(LogStatus.INFO, "Verify User is on Authoring Section"+test.addScreenCapture(a));
	logout.Logout();
	log("Verify user loged out sucessfully");
	String ss=captureScreen("");
	test.log(LogStatus.INFO, "Log out from InstaVR"+test.addScreenCapture(ss));}
		
}
