package com.sapizon.instavr.pages_T006;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sapizon.instavr.config.Configration;

public class Instavr_logout {
	
public static final Logger log = Logger.getLogger(Instavr_logout.class.getName());
	
	
	WebDriver driver;
	public Instavr_logout(WebDriver driver) {
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
