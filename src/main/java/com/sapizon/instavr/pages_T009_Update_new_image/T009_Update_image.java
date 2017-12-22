package com.sapizon.instavr.pages_T009_Update_new_image;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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
	public void update() throws IOException, InterruptedException {
		

		UpdateScene.click();
	}
	public T009_logout imageUpdate() throws IOException, AWTException {	
		 Robot robot = new Robot();
		 StringSelection selection = new StringSelection("C:\\Users\\DELL\\Documents\\GitHub\\Sapizon\\Pano2");
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
		try{
			
			
			image.click();
			System.out.println("image is present");
			}catch(Exception e){
				
		
				upload.click();
				 robot.setAutoDelay(1000);
				 
			        robot.keyPress(KeyEvent.VK_CONTROL);
			        robot.keyPress(KeyEvent.VK_V);
			 
			        robot.keyRelease(KeyEvent.VK_CONTROL);
			        robot.keyRelease(KeyEvent.VK_V);
			 
			        robot.setAutoDelay(1000);
			 
			        robot.keyPress(KeyEvent.VK_ENTER);
			        robot.keyRelease(KeyEvent.VK_ENTER);
		new WebDriverWait(driver, 1000l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"files-modal-Pano2.jpg\"]")));
		image.click();
			}		
		return PageFactory.initElements(driver, T009_logout.class); 

	
		
	}
	
	
	
}
