package rough;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sapizon.instavr.config.Configration;
import com.sapizon.instavr.pages_T013_Upload_image.select_uploded_image;

public class Trying_to_upload_image {

	WebDriver driver;
	public Trying_to_upload_image(WebDriver driver) throws IOException{
		this.driver=driver;
	}
	@FindBy(xpath=Configration.AddVRcontent)
	public WebElement AddVRcontent;
	
	@FindBy(xpath=Configration.upload)
	public WebElement upload;
	
	
	
	@SuppressWarnings("unused")
	public select_uploded_image AddContent() throws IOException, InterruptedException {
		String FilePath = "/Users/apple/Documents/InstaVR/360_a.jpg";

		AddVRcontent.click();
		
		
		
		upload.click();
		Thread.sleep(60l);
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
		
		return PageFactory.initElements(driver, select_uploded_image.class); 

		
	}
	
}		

