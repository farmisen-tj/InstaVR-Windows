package com.sapizon.instavr.pages_T016_add_hotspot;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sapizon.instavr.config.Configration;

public class T016_Hotsopt {
	
	
	WebDriver driver;
	public T016_Hotsopt(WebDriver driver) throws IOException{
		this.driver=driver;
	}
	
	@FindBy(xpath=Configration.addHotspot)
	public WebElement addHotspot;

	
	public T016_logout addHotspot() {
		
		this.addHotspot.click();
		
		return PageFactory.initElements(driver, T016_logout.class); 

		
	}
	
	
	
	
	

}
