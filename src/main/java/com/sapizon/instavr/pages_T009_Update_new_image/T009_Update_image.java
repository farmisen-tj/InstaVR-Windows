package com.sapizon.instavr.pages_T009_Update_new_image;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sapizon.instavr.config.Configration;

public class T009_Update_image {

	WebDriver driver;
	public T009_Update_image(WebDriver driver) throws IOException{
		this.driver=driver;
	
	}
	
	@FindBy(xpath=Configration.UpdateScene)
	public WebElement UpdateScene;
	
	@FindBy(xpath="//*[@id=\"files-modal-Pano2.jpg\"]")
	public WebElement image;
	
	@FindBy(xpath=Configration.upload)
	public WebElement upload;
	
	
	@SuppressWarnings("unused")
	public T009_logout update() throws IOException, InterruptedException {
		String FilePath = "/Users/apple/Documents/InstaVR/Pano2.jpg";

		UpdateScene.click();
		
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
		new WebDriverWait(driver, 1000l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"files-modal-Pano2.jpg\"]")));
		image.click();
			}		
		return PageFactory.initElements(driver, T009_logout.class); 

	
		
	}
	
	
	
}
