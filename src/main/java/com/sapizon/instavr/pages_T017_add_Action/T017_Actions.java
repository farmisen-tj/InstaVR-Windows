package com.sapizon.instavr.pages_T017_add_Action;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sapizon.instavr.config.Configration;

public class T017_Actions {
	WebDriver driver;
	public T017_Actions(WebDriver driver) throws IOException{
		this.driver=driver;
	}
	
	@FindBy(xpath=Configration.actions)
	public WebElement actions;

	
	public T017_logout Actions() {
		
		this.actions.click();
		
		return PageFactory.initElements(driver, T017_logout.class); 

		
	}
	
}
