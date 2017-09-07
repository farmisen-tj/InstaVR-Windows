package com.sapizon.instavr.test;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sapizon.instavr.config.TestBase;
import com.sapizon.instavr.pages_T001.InstavrLoginPage;

public class T011_Test_Login_Invalid_Password  extends TestBase{
	
public static final Logger log = Logger.getLogger(T001_Test_LoginTest.class.getName());
	
	@BeforeTest
	public void setUp(){
		init();
		log.info("Opening the browser object");

	}
	
	
	@Test
	public void loginTest() {
	log.info("Verified instavr Login is displayed");
	InstavrLoginPage loginpage = PageFactory.initElements(driver, InstavrLoginPage.class);
	loginpage.dologin("pramodnp.pnp@gmail.com", "qwertyuiop");
	log.info("Verifing the with Incorrect Passwred");
	StringBuffer verificationErrors = new StringBuffer();
	try {
        assertTrue(driver.findElement(By.xpath("/html/body/div[3]/div/form/div[1]")).getText().matches("Invalid email or password."));
} catch (Error e) {
verificationErrors.append(e.toString());
}
	
	}
	
	@AfterTest
	
	public void endTest() {

		driver.close();
		log.info("Closing the browser object");

	}
	
	
}
	
	
	
	
	
	
	


