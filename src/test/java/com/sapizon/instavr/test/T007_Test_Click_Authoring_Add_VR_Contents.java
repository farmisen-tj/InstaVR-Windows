package com.sapizon.instavr.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sapizon.instavr.config.TestBase;
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
	public  void login(String Email,String password,String runmode) throws InterruptedException {
		if(runmode.equalsIgnoreCase("n")) {
			throw new SkipException("User Marked The Record As No");
		}
		log("Verified instavr Login is displayed");		
		B001_login loginpage = PageFactory.initElements(driver, B001_login.class);
		log("At Login Page");
		instavrWebDashboard_Add_VR_contents Dashboard = loginpage.dologin(Email, password);
		log("Verify User is logged in successfully");
		Authoring_Add_VR_contents add = Dashboard.authoring();
		log("Verified instavr Dashboard is displayed");
		Selecting_Content_From_Frame first = add.AddContent();
		log("Verifing Add content is present");
		first.firstElement();
		log("Selecting the first element on the frame");
		
		
	}
	
	

}
