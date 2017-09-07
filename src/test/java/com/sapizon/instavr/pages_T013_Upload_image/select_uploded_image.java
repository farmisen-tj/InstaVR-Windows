package com.sapizon.instavr.pages_T013_Upload_image;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class select_uploded_image {
	WebDriver driver;
	public select_uploded_image(WebDriver driver) throws IOException{
		this.driver=driver;
	}

	@FindBy(xpath="//*[@id=\"files-modal-360_a.jpg\"]")
	public WebElement image;

	public Add_Link Select() {
		
		image.click();
	
		
		return PageFactory.initElements(driver, Add_Link.class); 

	}
	
	
	
}
