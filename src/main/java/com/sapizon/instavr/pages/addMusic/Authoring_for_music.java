package com.sapizon.instavr.pages.addMusic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sapizon.instavr.config.Configration;

public class Authoring_for_music {

	WebDriver driver;
	public Authoring_for_music(WebDriver driver) throws IOException{
		this.driver=driver;
		
	}
	
	@FindBy(xpath=Configration.Aut)
	public WebElement Aut;
	
	
	public instaVR_Add_Music authoring() {
	
		Aut.click();
		
		return PageFactory.initElements(driver, instaVR_Add_Music.class); 
	}
	


}

	
	
	
	

