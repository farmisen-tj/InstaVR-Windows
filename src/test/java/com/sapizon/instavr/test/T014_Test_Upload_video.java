
package com.sapizon.instavr.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
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
import com.sapizon.instavr.pages_T016_add_hotspot.T016_add_image;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_login;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_logout;
import com.sapizon.instavr.remove.Remove_item;


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
		test.log(LogStatus.INFO, "Verify InstaVR Login page is displayed"+test.addScreenCapture(newFileName));	
		T016_login loginpage = PageFactory.initElements(driver, T016_login.class);
		loginpage.dologin(Email );
		String szzzs=captureScreen("");
		test.log(LogStatus.INFO, "Enter Valid Username"+test.addScreenCapture(newFileName));
		loginpage.password(password);
		String szzs=captureScreen("");
		test.log(LogStatus.INFO, "Enter Valid Password"+test.addScreenCapture(newFileName));
		String sss=captureScreen("");
		test.log(LogStatus.INFO, "Click on Sign In Button"+test.addScreenCapture(newFileName));
		loginpage.signin();
		log("Verified instavr Dashboard is displayed");
		String c=captureScreen("");
		test.log(LogStatus.INFO, "Verify user is logged in successfully & InstaVR Dashboard is displayed"+test.addScreenCapture(newFileName));
		Upload_click_authoring_video Dashboard = PageFactory.initElements(driver, Upload_click_authoring_video.class);
		new WebDriverWait(driver, 1000l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.Authoring)));	
		log("Verify user is on Authoring Section");
		 String d=captureScreen("");
		 test.log(LogStatus.INFO, "Verify user is on Authoring Section"+test.addScreenCapture(newFileName));
		Dashboard.gotoAuthoring();
		Upload_add_VR_Video add = PageFactory.initElements(driver, Upload_add_VR_Video.class);
		new WebDriverWait(driver, 30l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.AddVRcontent)));
		add.AddContent();
		String dd=captureScreen("");
		test.log(LogStatus.INFO, "Verify File Manager is displayed"+test.addScreenCapture(newFileName));	
		add.addVideo();
		log("Verify File Manager is displayed");
		String ddm=captureScreen("");
		 test.log(LogStatus.INFO, "Select File (Video) from your local machine and upload to the File Manager"+test.addScreenCapture(newFileName));
		 test.log(LogStatus.INFO, "Verify File (Video) is uploaded succesfully"+test.addScreenCapture(newFileName));
		if(driver.findElement(By.xpath("//*[@id=\"placeholder\"]/div/button"))!= null){
			log("Verified the video added sucessfully");	
			}else{
			System.out.println("Unable to add Video");
			}
		Remove_item remove = PageFactory.initElements(driver, Remove_item.class);
		String ddmm=captureScreen("");
		 test.log(LogStatus.INFO, "Removing the File from dashboard"+test.addScreenCapture(newFileName));
		remove.remove();
		Alert alert = driver.switchTo().alert();
		driver.switchTo().alert();
		alert.accept();
		T016_logout logout = PageFactory.initElements(driver, T016_logout.class);
		logout.dropdown();
		String ddmmm=captureScreen("");
		 test.log(LogStatus.INFO, "Click on username dropdown at top right corner"+test.addScreenCapture(newFileName));
		 test.log(LogStatus.INFO, "Verify dropdown menu is displays “Logout” button"+test.addScreenCapture(newFileName));
		 logout.Logout();
		log("Verify user loged out sucessfully");
		String ss=captureScreen("");
		test.log(LogStatus.INFO, "Log out from InstaVR"+test.addScreenCapture(newFileName));
	}


	
}

