package com.sapizon.instavr.test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
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
import com.sapizon.instavr.pages.addMusic.instaVR_Add_Music;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_add_image;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_logout;
import com.sapizon.instavr.pages_T017_add_Action.T017_Actions;
import com.sapizon.instavr.pages_T017_add_Action.T017_add_image;
import com.sapizon.instavr.pages_T017_add_Action.T017_authoring;
import com.sapizon.instavr.pages_T017_add_Action.T017_login;
import com.sapizon.instavr.remove.Remove_item;

@SuppressWarnings("unused")
public class T018_add_music extends TestBase {

	public static final Logger log = Logger.getLogger(T018_add_music.class.getName());

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
	public void AddMusic(String Email, String password, String runmode) throws Exception {
		if (runmode.equalsIgnoreCase("n")) {
			throw new SkipException("User Marked The Record As No");
		}
		log("Verify InstaVR Login page is displayed");
		captureScreen("");
		test.log(LogStatus.INFO, "Verify InstaVR Login page is displayed" + test.addScreenCapture(newFileName));
		T017_login loginpage = PageFactory.initElements(driver, T017_login.class);
		loginpage.dologin(Email, password);
		log("Verified instavr Dashboard is displayed");
		captureScreen("");
		test.log(LogStatus.INFO, "Verify user is logged in successfully & InstaVR Dashboard is displayed"
				+ test.addScreenCapture(newFileName));
		T017_authoring Dashboard = PageFactory.initElements(driver, T017_authoring.class);
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
		instaVR_Add_Music link = PageFactory.initElements(driver, instaVR_Add_Music.class);
		captureScreen("");
		test.log(LogStatus.INFO, "Select File (Image) from your local machine and upload to the File Manager"
				+ test.addScreenCapture(newFileName));
		test.log(LogStatus.INFO, "Verify File (Image) is uploaded succesfully" + test.addScreenCapture(newFileName));
		link.AddMusic();
		captureScreen("");
		test.log(LogStatus.INFO, "Select File (Music) from your local machine and upload to the File Manager"
				+ test.addScreenCapture(newFileName));
		link.selectMusic();
		test.log(LogStatus.INFO, "Verify File (Music) is uploaded succesfully" + test.addScreenCapture(newFileName));
		log("Verified the Music added sucessfully");
		captureScreen("");
		test.log(LogStatus.INFO, "Verify the Music added successfully" + test.addScreenCapture(newFileName));
		Remove_item remove = PageFactory.initElements(driver, Remove_item.class);
		captureScreen("");
		test.log(LogStatus.INFO, "Removing the File from dashboard" + test.addScreenCapture(newFileName));
		remove.remove();
		Alert alert = driver.switchTo().alert();
		driver.switchTo().alert();
		alert.accept();
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
