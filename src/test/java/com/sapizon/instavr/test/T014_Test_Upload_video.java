
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
import com.sapizon.instavr.pages_T014_Upload_Video.B005_Login_Upload_Video;
import com.sapizon.instavr.pages_T014_Upload_Video.Upload_add_VR_Video;
import com.sapizon.instavr.pages_T014_Upload_Video.Upload_click_authoring_video;
import com.sapizon.instavr.pages_T014_Upload_Video.instaLogout;


@SuppressWarnings("unused")
public class T014_Test_Upload_video extends TestBase{
	
	public static final Logger log = Logger.getLogger(T014_Test_Upload_video.class.getName());

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
	public  void UploadVideo(String Email,String password,String runmode) throws InterruptedException, IOException {
		if(runmode.equalsIgnoreCase("n")) {
			throw new SkipException("User Marked The Record As No");
		}
		log("Verify InstaVR Login page is displayed");
		String s=captureScreen("");
		test.log(LogStatus.INFO, "Verify InstaVR Login page is displayed"+test.addScreenCapture(s));	
		B005_Login_Upload_Video loginpage = PageFactory.initElements(driver, B005_Login_Upload_Video.class);
		loginpage.dologin(Email, password);
		log("Verified instavr Dashboard is displayed");
		String c=captureScreen("");
		test.log(LogStatus.INFO, "Verify user is logged in successfully & InstaVR Dashboard is displayed"+test.addScreenCapture(c));
		Upload_click_authoring_video Dashboard = PageFactory.initElements(driver, Upload_click_authoring_video.class);
		new WebDriverWait(driver, 1000l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.Authoring)));	
		log("Verify user is on Authoring Section");
		 String d=captureScreen("");
		 test.log(LogStatus.INFO, "Verify user is on Authoring Section"+test.addScreenCapture(d));
		Dashboard.gotoAuthoring();
		 log("Verify File Manager is displayed");
			String dd=captureScreen("");
			 test.log(LogStatus.INFO, "Verify File Manager is displayed"+test.addScreenCapture(dd));
		Upload_add_VR_Video add = PageFactory.initElements(driver, Upload_add_VR_Video.class);
		new WebDriverWait(driver, 10l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.AddVRcontent)));
		add.AddContent();
		String ddm=captureScreen("");
		 test.log(LogStatus.INFO, "Select File (Video) from your local machine and upload to the File Manager"+test.addScreenCapture(ddm));
		 test.log(LogStatus.INFO, "Verify File (Video) is uploaded succesfully"+test.addScreenCapture(ddm));
		if(driver.findElement(By.xpath("//*[@id=\"placeholder\"]/div/button"))!= null){
			log("Verified the video added sucessfully");	
			}else{
			System.out.println("Unable to add Video");
			}
		instaLogout logout = PageFactory.initElements(driver, instaLogout.class);
		logout.Logout();
		log("Verify user loged out sucessfully");
		String ss=captureScreen("");
		test.log(LogStatus.INFO, "Log out from InstaVR"+test.addScreenCapture(ss));
	}


	
}

