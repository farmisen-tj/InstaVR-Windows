package com.sapizon.instavr.pages_T008_Add_music;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sapizon.instavr.config.Configration;

public class T008_login {

	public static final Logger log = Logger.getLogger(T008_login.class.getName());
	
	WebDriver driver;
	public T008_login(WebDriver driver) {
	this.driver = driver;
}


	@FindBy(name=Configration.username)
	public WebElement username;
	@FindBy(xpath=Configration.password)
	public WebElement password;
	@FindBy(xpath=Configration.signin)
	public WebElement signin;
	
	
	public T008_authoring dologin(String username, String password){
		
	this.username.sendKeys(username);
	log.info("Sending User Name"+username.toString());
	this.password.sendKeys(password);
	log.info("Sending Password"+password.toString());
	signin.click();
	log.info("Clicking On Sign In"+signin.toString());

	return PageFactory.initElements(driver, T008_authoring.class); 
	
	}
	
}
