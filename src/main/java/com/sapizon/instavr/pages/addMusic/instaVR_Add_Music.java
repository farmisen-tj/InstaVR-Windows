package com.sapizon.instavr.pages.addMusic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class instaVR_Add_Music {
	WebDriver driver;
	public instaVR_Add_Music(WebDriver driver) throws IOException{
		this.driver=driver;	
	}

	@FindBy(xpath="//*[@id=\"instavr-content\"]/div/div/div[3]/div/div[1]/div[2]/div/div[1]/div[4]/div/div[3]/div[3]/div[3]/div/a")
	public WebElement Music;	
	
	@FindBy(xpath="//*[@id=\"files-modal-edvardgriegpeergynt1morningmoodpiano.mp3\"]")
	public WebElement Selecting;
	
	
	public void AddMusic() {
		
		this.Music.click();
		this.Selecting.click();
		
		
		
	}
	
	
}
