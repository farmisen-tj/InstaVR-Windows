package com.sapizon.instavr.pages_T014_Upload_Video;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sapizon.instavr.config.Configration;
import com.sapizon.instavr.pages_T013_Upload_image.B004_Login_Upload_Image;

public class B005_Login_Upload_Video {

public static final Logger log = Logger.getLogger(B004_Login_Upload_Image.class.getName());
	
	WebDriver driver;
	public B005_Login_Upload_Video(WebDriver driver) {
	this.driver = driver;
}


	@FindBy(name=Configration.username)
	public WebElement username;
	@FindBy(xpath=Configration.password)
	public WebElement password;
	@FindBy(xpath=Configration.signin)
	public WebElement signin;
	
	
	public Upload_click_authoring_video dologin(String username, String password){
		
	this.username.sendKeys(username);
	log.info("Sending User Name"+username.toString());
	this.password.sendKeys(password);
	log.info("Sending Password"+password.toString());
	signin.click();
	log.info("Clicking On Sign In"+signin.toString());

	return PageFactory.initElements(driver, Upload_click_authoring_video.class); 
	
	}

}



