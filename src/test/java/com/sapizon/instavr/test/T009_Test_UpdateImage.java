package com.sapizon.instavr.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.sapizon.instavr.config.Configration;
import com.sapizon.instavr.config.TestBase;
import com.sapizon.instavr.pages_T009_Update_new_image.T009_Update_image;
import com.sapizon.instavr.pages_T009_Update_new_image.T009_authoring;
import com.sapizon.instavr.pages_T009_Update_new_image.T009_login;
import com.sapizon.instavr.pages_T009_Update_new_image.T009_logout;
import com.sapizon.instavr.pages_T010_file_Offset.T010_add_image;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_add_image;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_authoring;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_login;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_logout;
import com.sapizon.instavr.remove.Remove_item;

@SuppressWarnings("unused")
public class T009_Test_UpdateImage extends TestBase {

	public static final Logger log = Logger.getLogger(T009_Test_UpdateImage.class.getName());

	@DataProvider(name = "loginData")
	public String[][] getTestData() {
		String[][] testRecords = getData("testdata.xlsx", "loginTestData");
		return testRecords;
	}

	@BeforeClass

	public void setUp() {
		init();
	}

	@Test(dataProvider = "loginData")
	public void UpdateImageTest(String Email, String password, String runmode)
			throws Exception {
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
		captureScreen("");
		test.log(LogStatus.INFO, "Verify addVR contents button is displayed" + test.addScreenCapture(newFileName));
		add.AddContent();
		captureScreen("");
		test.log(LogStatus.INFO, "Verify File Manager is displayed" + test.addScreenCapture(newFileName));
		add.addimage();
		log("Verify File Manager is displayed");

		T009_Update_image up = PageFactory.initElements(driver, T009_Update_image.class);
		captureScreen("");
		test.log(LogStatus.INFO, "Verify Update button is present" + test.addScreenCapture(newFileName));

		up.update();
		captureScreen("");
		test.log(LogStatus.INFO, "Verify File Manager is displayed" + test.addScreenCapture(newFileName));
		up.imageUpdate();
		captureScreen("");
		test.log(LogStatus.INFO, "Select File from your local machine and upload to the File Manager"
				+ test.addScreenCapture(newFileName));
		test.log(LogStatus.INFO, "Verify File is Updated successfully" + test.addScreenCapture(newFileName));

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
