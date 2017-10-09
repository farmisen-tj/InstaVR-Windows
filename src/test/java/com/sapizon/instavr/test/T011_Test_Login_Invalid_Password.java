package com.sapizon.instavr.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sapizon.instavr.config.Configration;
import com.sapizon.instavr.config.TestBase;
import com.sapizon.instavr.pages_T001.InstavrLoginPage;

public class T011_Test_Login_Invalid_Password  extends TestBase{
	
public static final Logger log = Logger.getLogger(T001_Test_LoginTest.class.getName());
	


@BeforeClass

	public void setUp(){
		init();
		log("Opening the browser object");

	}
	
	
	@Test
	public void loginTest() {
	log("Verified instavr Login is displayed");
	InstavrLoginPage loginpage = PageFactory.initElements(driver, InstavrLoginPage.class);
	loginpage.dologin("pramodnp.pnp@gmail.com", "qwertyuiop");
	log("Verifing the with Incorrect Passwred");
	StringBuffer verificationErrors = new StringBuffer();
	try {
        AssertJUnit.assertTrue(driver.findElement(By.xpath(Configration.Invalid)).getText().matches("Invalid email or password."));
} catch (Error e) {
verificationErrors.append(e.toString());
}
	
	}
	

}
	
	
	
	
	
	
	


