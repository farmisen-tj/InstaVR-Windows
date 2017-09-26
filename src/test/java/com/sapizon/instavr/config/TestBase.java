package com.sapizon.instavr.config;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import com.sapizon.instavr.Listner.Listner;
import com.sapizon.instavr.testData.ExcelReader;



public class TestBase {
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public WebDriver driver;
	String url = Configration.testsite;
	String browser ="chrome";
	ExcelReader excel;
	Listner lis;

	public void init(){
		selectBrowser(browser);
		getUrl(url);
	//	lis = new Listner(driver);
		String log4jConfPath ="log4j.properties";
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
	driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
	driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

public String[][] getData(String excelName, String sheetName) {
	String path = System.getProperty("user.dir") + "/src/test/java/com/sapizon/instavr/testData/"+excelName;
	excel = new ExcelReader(path);
	String[][] data = excel.getDataFromSheet(sheetName, excelName);  
	return data;
}
 
public String captureScreen(String fileName) {
	if (fileName == "") {
		fileName = "blank";
	}
	File destFile = null;
	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	try {
		String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/test/java/com/sapizon/instavr/screenshots";
		destFile = new File((String) reportDirectory + fileName + "_" + formater.format(calendar.getTime()) + ".png");
		FileUtils.copyFile(scrFile, destFile);
		// This will help us to link the screen shot in testNG report
		Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
	} catch (IOException e) {
		e.printStackTrace();
	}
	return destFile.toString();
}
	public void log(String data){
		log.info(data);
		Reporter.log(data);
	}

}



