package com.sapizon.instavr.pages_T010_file_Offset;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sapizon.instavr.config.Configration;

public class T010_login {

public static final Logger log = Logger.getLogger(T010_login.class.getName());
	
	WebDriver driver;
	public T010_login(WebDriver driver) {
	this.driver = driver;
}


	@FindBy(name=Configration.username)
	public WebElement username;
	@FindBy(xpath=Configration.password)
	public WebElement password;
	@FindBy(xpath=Configration.signin)
	public WebElement signin;
	
	
	public T010_authoring dologin(String username, String password){
		
	this.username.sendKeys(username);
	log.info("Enter Valid Email Address "+username.toString());
	this.password.sendKeys(password);
	log.info("Enter Valid Password "+password.toString());
	signin.click();
	log.info("Clicking On Sign In");

	return PageFactory.initElements(driver, T010_authoring.class); 
	
	}

	
	
}