package com.sapizon.instavr.pages_T016_add_hotspot;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sapizon.instavr.config.Configration;

public class T016_logout {
	
public static final Logger log = Logger.getLogger(T016_logout.class.getName());
	
	
	WebDriver driver;
	public T016_logout(WebDriver driver) {
	this.driver = driver;
}
	
	@FindBy(xpath=Configration.dropdown)
	public WebElement dropdown;
	@FindBy(xpath=Configration.logout)
	public WebElement logout;

	
	public void dropdown() {
		dropdown.click();
	}
	public void Logout() {
		
		logout.click();
	}
	
	

}
