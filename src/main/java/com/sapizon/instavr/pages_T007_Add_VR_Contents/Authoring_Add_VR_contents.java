package com.sapizon.instavr.pages_T007_Add_VR_Contents;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Authoring_Add_VR_contents {
	
	WebDriver driver;
	public Authoring_Add_VR_contents(WebDriver driver) throws IOException{
		this.driver=driver;
	}
	
	  
	
	@FindBy(css="a.border-action.bg-black")
	public WebElement AddVRcontent;
	

	public Selecting_Content_From_Frame AddContent() {
	
		AddVRcontent.click();
		
		return PageFactory.initElements(driver, Selecting_Content_From_Frame.class); 
		
	}
	
}