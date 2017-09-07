package com.sapizon.instavr.pages_T015;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sapizon.instavr.config.Configration;

public class Upload_click_authoring {
	
	
	WebDriver driver;
	public Upload_click_authoring(WebDriver driver) throws IOException{
		this.driver=driver;
		
	}
	
	@FindBy(xpath=Configration.Authoring)
	public WebElement Authoring;
	
	
	public Upload_add_VR_image gotoAuthoring() {
	
		Authoring.click();
		
		return PageFactory.initElements(driver, Upload_add_VR_image.class); 
	}
	

}
