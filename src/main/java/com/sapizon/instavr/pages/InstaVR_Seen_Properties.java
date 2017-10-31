package com.sapizon.instavr.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sapizon.instavr.config.Configration;

public class InstaVR_Seen_Properties {
	
	
	@FindBy(xpath=Configration.addLink)
	public WebElement addLink;
	
	
	@FindBy(xpath=Configration.addHotspot)
	public WebElement addHotspot;
	
	@FindBy(xpath=Configration.actions)
	public WebElement actions;
	
	
	public void Link() {
		
		addLink.click();
	}
	
	public void Hotspot() {
		
		addHotspot.click();
		
	}
	
	public void Action() {
		
		actions.click();
		
	}
	

}
