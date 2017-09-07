package com.sapizon.instavr.pages_T009_Update_new_image;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sapizon.instavr.config.Configration;

public class T009_logout {
	WebDriver driver;
	public T009_logout(WebDriver driver) {
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
