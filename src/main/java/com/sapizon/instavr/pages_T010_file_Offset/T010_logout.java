package com.sapizon.instavr.pages_T010_file_Offset;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sapizon.instavr.config.Configration;
import com.sapizon.instavr.pages_T016_add_hotspot.T016_logout;

public class T010_logout {
public static final Logger log = Logger.getLogger(T016_logout.class.getName());
	
	
	WebDriver driver;
	public T010_logout(WebDriver driver) {
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
