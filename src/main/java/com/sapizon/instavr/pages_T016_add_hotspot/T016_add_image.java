package com.sapizon.instavr.pages_T016_add_hotspot;

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

public class T016_add_image {
	
	
	WebDriver driver;
	public T016_add_image(WebDriver driver) throws IOException{
		this.driver=driver;
	}
	@FindBy(xpath=Configration.AddVRcontent)
	public WebElement AddVRcontent;
	
	@FindBy(xpath=Configration.upload)
	public WebElement upload;
	
	@FindBy(xpath="//*[@id=\"files-modal-360_a.jpg\"]")
	public WebElement image;
	
	
	@SuppressWarnings("unused")
	public void AddContent() {

		AddVRcontent.click();
	}
		public void addimage() throws IOException, Exception {
			 Robot robot = new Robot();
			 StringSelection selection = new StringSelection("C:\\Users\\DELL\\Documents\\GitHub\\Sapizon\\360_a.jpg");
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
	        
		new WebDriverWait(driver, 1000l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"files-modal-360_a.jpg\"]")));
		image.click();
			}		

	
		
	}
	
}
