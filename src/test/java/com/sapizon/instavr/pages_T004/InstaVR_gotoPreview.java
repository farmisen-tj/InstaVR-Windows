package com.sapizon.instavr.pages_T004;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sapizon.instavr.config.Configration;


public class InstaVR_gotoPreview {

	public static final Logger log = Logger.getLogger(InstaVR_gotoPreview.class.getName());

	WebDriver driver;
	public InstaVR_gotoPreview(WebDriver driver) throws IOException{
		this.driver=driver;
	
	}
	
	
	@FindBy(xpath=Configration.Preview)
	public WebElement Preview;
	
	public InstaVr_logout gotoPreview() {
		
		Preview.click();
		log.info("Verify user is on Preview");
		return PageFactory.initElements(driver, InstaVr_logout.class); 

		

	}

	
	
	
	
}
