package com.sapizon.instavr.pages.addMusic;

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


public class instaVR_Add_Music {
	WebDriver driver;
	public instaVR_Add_Music(WebDriver driver) throws IOException{
		this.driver=driver;	
	}

	@FindBy(xpath=Configration.Music)
	public WebElement Music;	
	
	@FindBy(xpath=Configration.SelectMusic)
	public WebElement Selecting;
	
	
	public void AddMusic() {
		
		Music.click();
	}
	public void selectMusic() throws IOException, AWTException {	
		 Robot robot = new Robot();
		 StringSelection selection = new StringSelection("C:\\Users\\DELL\\Documents\\GitHub\\Sapizon\\edvard-grieg-peer-gynt1-morning-mood-piano");
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
		try{
			Selecting.click();
			System.out.println("Music Present");
		}catch(Exception e){
			
	
			Selecting.click();
			 robot.setAutoDelay(1000);
			 
		        robot.keyPress(KeyEvent.VK_CONTROL);
		        robot.keyPress(KeyEvent.VK_V);
		 
		        robot.keyRelease(KeyEvent.VK_CONTROL);
		        robot.keyRelease(KeyEvent.VK_V);
		 
		        robot.setAutoDelay(1000);
		 
		        robot.keyPress(KeyEvent.VK_ENTER);
		        robot.keyRelease(KeyEvent.VK_ENTER);
	new WebDriverWait(driver, 1000l).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Configration.SelectMusic)));
	
		}		
	
		
		
		
		
	}
	
	
}
