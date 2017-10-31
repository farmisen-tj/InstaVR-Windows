package com.sapizon.instavr.pages_T008_Add_music;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sapizon.instavr.config.Configration;
import com.sapizon.instavr.pages_T010_file_Offset.T010_Slider_resetOffset;

public class T008_Add_music {

	WebDriver driver;
	public T008_Add_music(WebDriver driver) throws IOException{
		this.driver=driver;
	}
	@FindBy(xpath=Configration.AddVRcontent)
	public WebElement AddVRcontent;
	
	@FindBy(xpath=Configration.upload)
	public WebElement upload;
	
	@FindBy(xpath="//*[@id=\"files-modal-edvardgriegpeergynt1morningmoodpiano.mp3\"]")
	public WebElement image;
	
	
	@SuppressWarnings("unused")
	public T010_Slider_resetOffset AddContent() throws IOException, InterruptedException {
		String FilePath = "/Users/apple/Documents/InstaVR/edvard-grieg-peer-gynt1-morning-mood-piano.mp3";

		AddVRcontent.click();
		
		try{
			image.click();
			System.out.println("image is present");
			}catch(Exception e){
				
		
		upload.click();
		Runtime runtime = Runtime.getRuntime();
		String applescriptCommand = "tell app\"System Events\"\n"+
		"keystroke\"G\"using{Command down,Shift down}\n"+
		"delay 2\n"+
		"keystroke\""+FilePath+"\"\n"+
		"delay 1\n"+
		"keystroke return\n"+
		"delay 1\n"+
		"keystroke return\n"+
		"end tell";
		String[]args = {"osascript","-e",applescriptCommand};
		Process process = runtime.exec(args);
		new WebDriverWait(driver, 1000l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"files-modal-edvardgriegpeergynt1morningmoodpiano.mp3\"]")));
		image.click();
			}		
		return PageFactory.initElements(driver, T010_Slider_resetOffset.class); 

	
		
	}

}
	
	

