package com.sapizon.instavr.pages_T007_Add_VR_Contents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sapizon.instavr.config.Configration;
import com.sapizon.instavr.pages_T001.InstaVR_Logout;

public class Selecting_Content_From_Frame {
	
	
	WebDriver driver;
	public Selecting_Content_From_Frame(WebDriver driver) throws IOException{
		this.driver=driver;
	}
	
	@FindBy(xpath=Configration.selectElement)
	public WebElement selectElement;
	
	public InstaVR_Logout firstElement() {
		
		selectElement.click();
		
		return PageFactory.initElements(driver, InstaVR_Logout.class); 

		
	}
	

}
