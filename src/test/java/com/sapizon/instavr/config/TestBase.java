package com.sapizon.instavr.config;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public WebDriver driver;
	String url = Configration.testsite;
	String browser = "chrome";
	
	
	public void init(){
		selectBrowser(browser);
		getUrl(url);
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);

	
	}
	
public  void selectBrowser(String browser){
	if(browser.equalsIgnoreCase("chrome")){
		System.setProperty("webdriver.chrom.driver", System.getProperty("user.dir") +"chromedriver");
		 ChromeOptions options = new ChromeOptions();
		    options.addArguments("--start-fullscreen");
		driver = new ChromeDriver(options);
		log.info("creating object of"+browser);
	}
}

public void getUrl(String url){
	driver.get(url);
	log.info("Open console.instavr.co");
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
}



