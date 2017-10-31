package com.sapizon.instavr.pages_T010_file_Offset;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sapizon.instavr.config.Configration;

public class T010_Slider_resetOffset {

	WebDriver driver;
	public T010_Slider_resetOffset(WebDriver driver) throws IOException{
		this.driver=driver;
	}
	
	
	
		@FindBy(xpath=Configration.SliderValue)
		public WebElement SliderValue;
		

		@FindBy(xpath=Configration.Reset)
		public WebElement Reset;
		
		

		public T010_logout SliderAction() throws InterruptedException {
			
			SliderValue.sendKeys("90");
			Reset.click();
		
			SliderValue.sendKeys("-90");
			Reset.click();
	
			return PageFactory.initElements(driver, T010_logout.class); 

		
		}
		
		
	
		
}
	
