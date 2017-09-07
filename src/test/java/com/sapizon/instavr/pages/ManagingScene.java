package com.sapizon.instavr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sapizon.instavr.config.Configration;

public class ManagingScene {
	

	WebDriver driver;
	public ManagingScene(WebDriver driver) {
	this.driver = driver;
}
		
	@FindBy(xpath=Configration.RestCam)
	public WebElement RestCam;

	@FindBy(xpath=Configration.RemoveScene)
	public WebElement RemoveScene;
	
	@FindBy(xpath=Configration.UpdateScene)
	public WebElement UpdateScene;
	
	@FindBy(xpath=Configration.Reset)
	public WebElement Reset;
	
	@FindBy(xpath=Configration.SliderValue)
	public WebElement SliderValue;
	
	
	public void ResetCamara() {
		
		RestCam.click();
		
	}
	
	public void Update() {
		
		UpdateScene.click();
		
	}
	
	public void ResetOff() {
		
		Reset.click();
		
	}
	
	public void Slider() {
		
	    
		SliderValue.sendKeys("145");
		
	}
	
	
	
	
}