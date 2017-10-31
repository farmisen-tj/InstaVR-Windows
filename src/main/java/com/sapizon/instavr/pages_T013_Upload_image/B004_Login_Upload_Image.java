package com.sapizon.instavr.pages_T013_Upload_image;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sapizon.instavr.config.Configration;
import com.sapizon.instavr.pages.instavrWebDashboard;
import com.sapizon.instavr.pages_T001.InstavrLoginPage;

@SuppressWarnings("unused")
public class B004_Login_Upload_Image {
	
public static final Logger log = Logger.getLogger(B004_Login_Upload_Image.class.getName());
	
	WebDriver driver;
	public B004_Login_Upload_Image(WebDriver driver) {
	this.driver = driver;
}


	@FindBy(name=Configration.username)
	public WebElement username;
	@FindBy(xpath=Configration.password)
	public WebElement password;
	@FindBy(xpath=Configration.signin)
	public WebElement signin;
	
	
	public Upload_click_authoring dologin(String username, String password){
		
	this.username.sendKeys(username);
	log.info("Enter Valid Email Address "+username.toString());
	this.password.sendKeys(password);
	log.info("Enter Valid Password "+password.toString());
	signin.click();
	log.info("Clicking On Sign In");

	return PageFactory.initElements(driver, Upload_click_authoring.class); 
	
	}

}
