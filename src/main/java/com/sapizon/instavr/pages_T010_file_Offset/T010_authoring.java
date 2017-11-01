package com.sapizon.instavr.pages_T010_file_Offset;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sapizon.instavr.config.Configration;

public class T010_authoring {
	
	WebDriver driver;
	public T010_authoring(WebDriver driver) throws IOException{
		this.driver=driver;
		
	}
	
	@FindBy(xpath=Configration.Authoring)
	public WebElement Authoring;
	
	
	public T010_add_image gotoAuthoring() {
	
		Authoring.click();
		
		return PageFactory.initElements(driver, T010_add_image.class); 
	}

	
	
	

}