package com.sapizon.instavr.pages_T013_Upload_image;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sapizon.instavr.config.Configration;

public class Add_Link {
	
	WebDriver driver;
	public Add_Link(WebDriver driver) throws IOException{
		this.driver=driver;
	}
	
	@FindBy(xpath=Configration.addLink)
	public WebElement addLink;

	
	public InstaVR_logout AddLink() {
		
		addLink.click();
		
		return PageFactory.initElements(driver, InstaVR_logout.class); 

		
	}
	
	
	
	
}
