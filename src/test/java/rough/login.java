package rough;

import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sapizon.instavr.config.TestBase;
import com.sapizon.instavr.pages_T001.InstavrLoginPage;

public class login extends TestBase {

public static final Logger log = Logger.getLogger(login.class.getName());
  
	
@DataProvider(name="loginData")
public String[][] getTestData(){
	String[][] testRecords = getData("testdata.xlsx", "loginTestData");
	return testRecords;
}


	
	
	@BeforeTest
	public void setUp(){
		init();
		log.info("Opening the browser object");
		}
	
	

	@Test(dataProvider="loginData")
	public  void login(String Email,String password,String runmode) {
		if(runmode.equalsIgnoreCase("n")) {
			throw new SkipException("User Marked The Record As No");
		}
		
		
		log.info("Verified instavr Login is displayed");
		InstavrLoginPage loginpage = PageFactory.initElements(driver, InstavrLoginPage.class);
		loginpage.dologin(Email, password);
		log.info("Verify User is logged in successfully");
	}
	
	
}
