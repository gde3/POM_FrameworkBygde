package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraries.GenericMethods;

/**
 * This file contains all the methods/objects related to My Account page of the application
 * @author Sri harsha
 */
public class MyAccountPageObject {

	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;
	
	public MyAccountPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		genericMethods = new GenericMethods(driver, wait);
	}
	
	public void clickReturnHomeButton() throws Exception {
		genericMethods.clickByXpath("//img[@alt='My Store']", "FAIL -- Return Home Button not found");
	}
	
	public void clickOrderButton() throws Exception {
		genericMethods.clickByXpath("//a[@title='Orders']", "FAIL -- Order Button not found");
	}
}
