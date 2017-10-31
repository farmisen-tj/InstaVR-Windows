package com.sapizon.instavr.pages_T002;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sapizon.instavr.config.Configration;


public class InstaVR_gotoAuthoring {
	
		public static final Logger log = Logger.getLogger(InstaVR_gotoAuthoring.class.getName());

		WebDriver driver;
		public InstaVR_gotoAuthoring(WebDriver driver) throws IOException{
			this.driver=driver;
		
		}
		
		@FindBy(xpath=Configration.Authoring)
		public WebElement Authoring;
		
		public InstaVR_logout gotoAuthoring() {
			
			Authoring.click();
			log.info("Verify user is on Authoring");
			
			return PageFactory.initElements(driver, InstaVR_logout.class); 
		}
		

}
