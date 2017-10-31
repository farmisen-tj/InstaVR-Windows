package com.sapizon.instavr.pages_T009_Update_new_image;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sapizon.instavr.config.Configration;

public class T009_authoring {


	WebDriver driver;
	public T009_authoring(WebDriver driver) throws IOException{
		this.driver=driver;
		
	}
	
	@FindBy(xpath=Configration.Authoring)
	public WebElement Authoring;
	
	
	public T009_add_image gotoAuthoring() {
	
		Authoring.click();
		
		return PageFactory.initElements(driver, T009_add_image.class); 
	}

	
	
}
