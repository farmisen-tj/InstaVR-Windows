package com.sapizon.instavr.pages.addMusic;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sapizon.instavr.config.Configration;
import com.sapizon.instavr.pages_T009_Update_new_image.T009_login;

public class B003_Login_Music {
	
public static final Logger log = Logger.getLogger(T009_login.class.getName());
	
	WebDriver driver;
	public B003_Login_Music(WebDriver driver) {
	this.driver = driver;
}


	@FindBy(name=Configration.username)
	public WebElement username;
	@FindBy(xpath=Configration.password)
	public WebElement password;
	@FindBy(xpath=Configration.signin)
	public WebElement signin;
	
	
	public Authoring_for_music dologin(String username, String password){
		
	this.username.sendKeys(username);
	log.info("Sending User Name"+username.toString());
	this.password.sendKeys(password);
	log.info("Sending Password"+password.toString());
	signin.click();
	log.info("Clicking On Sign In"+signin.toString());

	return PageFactory.initElements(driver, Authoring_for_music.class); 
	
	}
	
	
	
	

}
