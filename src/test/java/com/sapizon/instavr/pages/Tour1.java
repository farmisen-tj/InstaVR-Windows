package com.sapizon.instavr.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sapizon.instavr.config.Configration;

public class Tour1 {
	
	WebDriver driver;
	public Tour1(WebDriver driver) throws IOException{
		this.driver=driver;
	}
	
	@FindBy(xpath=Configration.icon1)
	public WebElement icon1;
	
	@FindBy(xpath=Configration.icon2)
	public WebElement icon2;
	
	@FindBy(xpath=Configration.icon3)
	public WebElement icon3;
	
	
		public InstaVR_Seen_Properties Seen1() {
		
		icon1.click();
		
		return PageFactory.initElements(driver, InstaVR_Seen_Properties.class);
		
	}
	
		public InstaVR_Seen_Properties Seen2() {
		
		icon2.click();
		
		return PageFactory.initElements(driver, InstaVR_Seen_Properties.class);
		
	}
	
	
		public ManagingScene Seen3() {
		
		icon3.click();
		
		return PageFactory.initElements(driver, ManagingScene.class);
		
	}
	
}
