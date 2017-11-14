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
import com.sapizon.instavr.pages_T013_Upload_image.Add_Link;
import com.sapizon.instavr.pages_T013_Upload_image.B004_Login_Upload_Image;
import com.sapizon.instavr.pages_T013_Upload_image.InstaVR_logout;
import com.sapizon.instavr.pages_T013_Upload_image.Upload_add_VR_image;
import com.sapizon.instavr.pages_T015.Upload_click_authoring;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_add_image;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_login;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_logout;
import com.sapizon.instavr.remove.Remove_item;

@SuppressWarnings("unused")
public class T015_Test_Upload_image_Select_image_add_link extends TestBase{

	
	public static final Logger log = Logger.getLogger(T015_Test_Upload_image_Select_image_add_link.class.getName());

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
	public  void AddLink(String Email,String password,String runmode) throws InterruptedException, IOException {
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
		Upload_click_authoring Dashboard = PageFactory.initElements(driver, Upload_click_authoring.class);
		log("Verify user is on Authoring Section");
		 String d=captureScreen("");
		 test.log(LogStatus.INFO, "Verify user is on Authoring Section"+test.addScreenCapture(d));
		new WebDriverWait(driver, 1000l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.Authoring)));	
		 Dashboard.gotoAuthoring();	
		 T016_add_image add = PageFactory.initElements(driver, T016_add_image.class);
			new WebDriverWait(driver, 10l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.AddVRcontent)));
			add.AddContent();
			String dd=captureScreen("");
			test.log(LogStatus.INFO, "Verify File Manager is displayed"+test.addScreenCapture(dd));	
			add.addimage();
			log("Verify File Manager is displayed");
		Add_Link link = PageFactory.initElements(driver, Add_Link.class);
		link.AddLink();
		String ddm=captureScreen("");
		 test.log(LogStatus.INFO, "Select File (Image) from your local machine and upload to the File Manager"+test.addScreenCapture(ddm));
		 test.log(LogStatus.INFO, "Verify File (Image) is uploaded succesfully"+test.addScreenCapture(ddm));
		if(driver.findElement(By.xpath(Configration.Assert))!= null){
			log("Verify the Link added sucessfully");	
			String ddz=captureScreen("");
			 test.log(LogStatus.INFO, "Verify the Link added sucessfully"+test.addScreenCapture(ddz));
		 	}else{
		 	String ddz=captureScreen("");
		 	test.log(LogStatus.INFO, "Unable To Locate Link button"+test.addScreenCapture(ddz));
			}
		Remove_item remove = PageFactory.initElements(driver, Remove_item.class);
		String ddmm=captureScreen("");
		 test.log(LogStatus.INFO, "Removing the File from dashboard"+test.addScreenCapture(ddmm));
		remove.remove();
		Alert alert = driver.switchTo().alert();
		driver.switchTo().alert();
		alert.accept();
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
