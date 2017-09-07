package com.sapizon.instavr.pages_T005;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sapizon.instavr.config.Configration;

public class InstaVR_gotoPackage {
	
	public static final Logger log = Logger.getLogger(InstaVR_gotoPackage.class.getName());

	WebDriver driver;
	public InstaVR_gotoPackage(WebDriver driver) throws IOException{
		this.driver=driver;
	
	}
	
	@FindBy(xpath=Configration.Packages)
	public WebElement Packages;
	
    public InstaVr_logout gotoPackages() {
		
		Packages.click();
		
		return PageFactory.initElements(driver, InstaVr_logout.class); 

	}
	
	

}
