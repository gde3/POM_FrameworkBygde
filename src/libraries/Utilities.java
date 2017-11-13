package libraries;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This file contains all the pre-requisites that are required to start/run 
 * the automation scripts
 * @author Sri harsha
 */
public class Utilities {

	public WebDriver launchBrowser() {
		
//		if (System.getProperty("os.name").equals("windows")) {
//			System.setProperty("webdriver.gecko.driver",
//					System.getProperty("user.dir") + File.separator + "geckodriver.exe");
//		} else {
//			System.setProperty("webdriver.gecko.driver",
//					System.getProperty("user.dir") + File.separator + "geckodriver");
//
//		}
		System.setProperty("webdriver.gecko.driver", 
				System.getProperty("user.dir") + File.separator + "geckodriver.exe");

		WebDriver driver = new FirefoxDriver(); // This will launch Firefox browser
		driver.get(Configurations.URL); // This will launch the application
		return driver;
	}
	
}
