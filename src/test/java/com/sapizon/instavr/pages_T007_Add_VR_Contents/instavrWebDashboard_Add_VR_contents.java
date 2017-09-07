package com.sapizon.instavr.pages_T007_Add_VR_Contents;

	import java.io.IOException;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import com.sapizon.instavr.config.Configration;

	public class instavrWebDashboard_Add_VR_contents {
		WebDriver driver;
		public instavrWebDashboard_Add_VR_contents(WebDriver driver) throws IOException{
			this.driver=driver;
			
		}
		
		@FindBy(xpath=Configration.Aut)
		public WebElement Aut;
		
		
		public Authoring_Add_VR_contents authoring() {
		
			Aut.click();
			
			return PageFactory.initElements(driver, Authoring_Add_VR_contents.class); 
		}
		
	

}
