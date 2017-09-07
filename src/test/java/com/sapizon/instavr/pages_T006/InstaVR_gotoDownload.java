package com.sapizon.instavr.pages_T006;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sapizon.instavr.config.Configration;

public class InstaVR_gotoDownload {
	public static final Logger log = Logger.getLogger(InstaVR_gotoDownload.class.getName());

	WebDriver driver;
	public InstaVR_gotoDownload(WebDriver driver) throws IOException{
		this.driver=driver;
	
	}

	@FindBy(xpath=Configration.Downloads)
	public WebElement Downloads;
	
	public Instavr_logout gotoDownloads() {
		
		Downloads.click();
	
		return PageFactory.initElements(driver, Instavr_logout.class); 

		
	}
	
	
	
}
