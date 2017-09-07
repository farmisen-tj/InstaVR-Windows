package com.sapizon.instavr.pages_T007_Add_VR_Contents;

	import org.apache.log4j.Logger;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import com.sapizon.instavr.config.Configration;
	public class B001_login {
	public static final Logger log = Logger.getLogger(B001_login.class.getName());
		
		WebDriver driver;
		public B001_login(WebDriver driver) {
		this.driver = driver;
	}


		@FindBy(name=Configration.username)
		public WebElement username;
		@FindBy(xpath=Configration.password)
		public WebElement password;
		@FindBy(xpath=Configration.signin)
		public WebElement signin;
		
		
		public instavrWebDashboard_Add_VR_contents dologin(String username, String password){
			
		this.username.sendKeys(username);
		log.info("Sending User Name"+username.toString());
		this.password.sendKeys(password);
		log.info("Sending Password"+password.toString());
		signin.click();
		log.info("Clicking On Sign In"+signin.toString());

		return PageFactory.initElements(driver, instavrWebDashboard_Add_VR_contents.class); 
		
		}

	}



