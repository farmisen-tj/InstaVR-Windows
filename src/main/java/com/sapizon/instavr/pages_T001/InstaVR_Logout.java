package com.sapizon.instavr.pages_T001;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sapizon.instavr.config.Configration;

public class InstaVR_Logout {
	
	public static final Logger log = Logger.getLogger(InstaVR_Logout.class.getName());
	
	
	WebDriver driver;
	public InstaVR_Logout(WebDriver driver) {
	this.driver = driver;
}
	
	@FindBy(xpath=Configration.dropdown)
	public WebElement dropdown;
	@FindBy(xpath=Configration.logout)
	public WebElement logout;

	public void Logout() {
		dropdown.click();
		logout.click();
	}
}
