package com.sapizon.instavr.pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sapizon.instavr.config.Configration;

public class instavrWebDashboard {
	public static final Logger log = Logger.getLogger(instavrWebDashboard.class.getName());

	WebDriver driver;
	public instavrWebDashboard(WebDriver driver) throws IOException{
		this.driver=driver;
	
	}
	
	@FindBy(xpath=Configration.Authoring)
	public WebElement Authoring;
	@FindBy(xpath=Configration.Branding)
	public WebElement Branding;
	@FindBy(xpath=Configration.Preview)
	public WebElement Preview;
	@FindBy(xpath=Configration.Packages)
	public WebElement Packages;
	@FindBy(xpath=Configration.Downloads)
	public WebElement Downloads;
	
	public Tour1 gotoAuthoring() {
	
		Authoring.click();
		log.info("Verify user is on Authoring");
		
		return PageFactory.initElements(driver, Tour1.class); 
	}
	
	public void gotoBranding() {
		Branding.click();
		log.info("Verify user is on Branding");
	
	}

	public void gotoPreview() {
		
		Preview.click();
		log.info("Verify user is on Preview");

	}
	
	public void gotoPackages() {
		
		Packages.click();
		
	}

	public void gotoDownloads() {
		
		Downloads.click();
		
	}
}

