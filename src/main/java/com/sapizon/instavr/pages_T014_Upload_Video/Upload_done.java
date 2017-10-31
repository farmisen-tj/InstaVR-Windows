package com.sapizon.instavr.pages_T014_Upload_Video;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sapizon.instavr.config.Configration;

public class Upload_done {
	
	WebDriver driver;
	public Upload_done(WebDriver driver) throws IOException{
		this.driver=driver;
	
	}
	
	@FindBy(xpath=Configration.ok)
	public WebElement ok;
	
	public void ok() {
		
		this.ok.click();
		
	}
	
	
	
	
}
