package com.sapizon.instavr.pages_T007_Add_VR_Contents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sapizon.instavr.config.Configration;

public class Selecting_Content_From_Frame {
	
	
	WebDriver driver;
	public Selecting_Content_From_Frame(WebDriver driver) throws IOException{
		this.driver=driver;
	}
	
	@FindBy(xpath=Configration.selectElement)
	public WebElement selectElement;
	
	public void firstElement() {
		
		selectElement.click();
		
	

		
	}
	

}
