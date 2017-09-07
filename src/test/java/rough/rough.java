package rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class rough {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrom.driver", System.getProperty("user.dir") +"chromedriver");
		WebDriver driver = new ChromeDriver();
				driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).sendKeys("apple");;
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]")).click();
	}

}
