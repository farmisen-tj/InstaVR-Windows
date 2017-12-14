package com.sapizon.instavr.pages_T014_Upload_Video;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sapizon.instavr.config.Configration;

public class Upload_add_VR_Video {

	WebDriver driver;
	public Upload_add_VR_Video(WebDriver driver) throws IOException{
		this.driver=driver;
	}
	@FindBy(xpath=Configration.AddVRcontent)
	public WebElement AddVRcontent;
	
	@FindBy(xpath=Configration.upload)
	public WebElement upload;
	
	@FindBy(xpath="//*[@id=\"files-modal-orange_house_making.mp4\"]")
	public WebElement video;

	
	@SuppressWarnings("unused")
	public void AddContent() throws IOException, InterruptedException {
		AddVRcontent.click();
	}
		
	public void addVideo() throws IOException, Exception {
		
		 Robot robot = new Robot();
		 StringSelection selection = new StringSelection("C:\\Users\\DELL\\Documents\\GitHub\\Sapizon\\orange_house_making.mp4");
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);

	try{
	video.click();
	System.out.println("video is present");
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
		new WebDriverWait(driver, 1000l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"files-modal-orange_house_making.mp4\"]")));
		new WebDriverWait(driver, 1000l).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"files-modal-orange_house_making.mp4\"]/span\n")));
		video.click();
}
	
	
	
	

		
	}
	
}

