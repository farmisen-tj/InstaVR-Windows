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
import com.sapizon.instavr.pages_T016_add_hotspot.T016_Hotsopt;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_add_image;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_authoring;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_login;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_logout;
import com.sapizon.instavr.remove.Remove_item;

@SuppressWarnings("unused")
public class T016_Upload_Image_Verify_Hotspot extends TestBase {

	public static final Logger log = Logger.getLogger(T016_Upload_Image_Verify_Hotspot.class.getName());

	@DataProvider(name = "loginData")
	public String[][] getTestData() {
		String[][] testRecords = getData("testdata.xlsx", "loginTestData");
		return testRecords;
	}

	@BeforeClass

	public void setUp() {
		init();

		log("Opening the browser object");
	}

	@Test(dataProvider = "loginData", priority = 1)
	public void AddHotspot(String Email, String password, String runmode) throws Exception {
		if (runmode.equalsIgnoreCase("n")) {
			throw new SkipException("User Marked The Record As No");
		}
		log("Verify InstaVR Login page is displayed");
		captureScreen("");
		test.log(LogStatus.INFO, "Verify InstaVR Login page is displayed" + test.addScreenCapture(newFileName));

		T016_login loginpage = PageFactory.initElements(driver, T016_login.class);
		loginpage.dologin(Email);
		captureScreen("");
		test.log(LogStatus.INFO, "Enter Valid Username" + test.addScreenCapture(newFileName));
		loginpage.password(password);
		captureScreen("");
		test.log(LogStatus.INFO, "Enter Valid Password" + test.addScreenCapture(newFileName));
		captureScreen("");
		test.log(LogStatus.INFO, "Click on Sign In Button" + test.addScreenCapture(newFileName));
		loginpage.signin();
		log("Verified instavr Dashboard is displayed");
		captureScreen("");
		test.log(LogStatus.INFO, "Verify user is logged in successfully & InstaVR Dashboard is displayed"
				+ test.addScreenCapture(newFileName));

		T016_authoring Dashboard = PageFactory.initElements(driver, T016_authoring.class);
		log("Verify user is on Authoring Section");
		captureScreen("");
		test.log(LogStatus.INFO, "Verify user is on Authoring Section" + test.addScreenCapture(newFileName));
		new WebDriverWait(driver, 1000l)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.Authoring)));
		Dashboard.gotoAuthoring();

		T016_add_image add = PageFactory.initElements(driver, T016_add_image.class);
		new WebDriverWait(driver, 30l)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.AddVRcontent)));
		add.AddContent();
		captureScreen("");
		test.log(LogStatus.INFO, "Verify File Manager is displayed" + test.addScreenCapture(newFileName));
		add.addimage();
		log("Verify File Manager is displayed");

		T016_Hotsopt link = PageFactory.initElements(driver, T016_Hotsopt.class);
		link.addHotspot();
		captureScreen("");
		test.log(LogStatus.INFO, "Select File (Image) from your local machine and upload to the File Manager"
				+ test.addScreenCapture(newFileName));
		test.log(LogStatus.INFO, "Verify File (Image) is uploaded succesfully" + test.addScreenCapture(newFileName));
		if (driver.findElement(By.xpath(Configration.Assert1)) != null) {
			log("Verify the Hotspot added sucessfully");
			captureScreen("");
			test.log(LogStatus.INFO, "Verify the Hotspot added successfully" + test.addScreenCapture(newFileName));
		} else {
			captureScreen("");
			test.log(LogStatus.INFO, "Unable To Locate Hotspot button" + test.addScreenCapture(newFileName));
		}
		Remove_item remove = PageFactory.initElements(driver, Remove_item.class);
		remove.remove();
		Alert alert = driver.switchTo().alert();
		driver.switchTo().alert();
		alert.accept();
		captureScreen("");
		test.log(LogStatus.INFO, "Removing the File from dashboard" + test.addScreenCapture(newFileName));
		T016_logout logout = PageFactory.initElements(driver, T016_logout.class);
		logout.dropdown();
		captureScreen("");
		test.log(LogStatus.INFO, "Click on username dropdown at top right corner" + test.addScreenCapture(newFileName));
		test.log(LogStatus.INFO,
				"Verify dropdown menu is displays â€œLogoutâ€� button" + test.addScreenCapture(newFileName));
		logout.Logout();
		log("Verify user loged out sucessfully");
		captureScreen("");
		test.log(LogStatus.INFO, "Log out from InstaVR" + test.addScreenCapture(newFileName));
	}

}