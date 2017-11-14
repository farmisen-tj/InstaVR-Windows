package com.sapizon.instavr.remove;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Remove_item {
public static final Logger log = Logger.getLogger(Remove_item.class.getName());
	
	
	WebDriver driver;
	public Remove_item(WebDriver driver) {
	this.driver = driver;
}
	
	@FindBy(xpath="//*[@id=\"media-list-dnd-0\"]/a[1]/span[1]/i")
	public WebElement remove;
	

	public void remove() {
		remove.click();
	}
}


