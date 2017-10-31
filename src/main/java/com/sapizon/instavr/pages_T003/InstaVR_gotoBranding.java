package com.sapizon.instavr.pages_T003;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sapizon.instavr.config.Configration;

public class InstaVR_gotoBranding {

	
	public static final Logger log = Logger.getLogger(InstaVR_gotoBranding.class.getName());

	WebDriver driver;
	public InstaVR_gotoBranding(WebDriver driver) throws IOException{
		this.driver=driver;
	
	}
	
	@FindBy(xpath=Configration.Branding)
	public WebElement Branding;
	
	public InstaVR_logout gotoBranding() {
		Branding.click();
		log.info("Verify user is on Branding");
		
		return PageFactory.initElements(driver, InstaVR_logout.class); 

	
	}
}
