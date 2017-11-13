package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraries.GenericMethods;

/**
 * This file contains all the methods/objects related to My Account page of the application
 * @author Sri harsha
 */
public class MyShoppingCartAddressPageObject {

	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;
	
	public MyShoppingCartAddressPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		genericMethods = new GenericMethods(driver, wait);
	}
	
	public void clickCheckOutButton() throws Exception {
		genericMethods.clickByXpath("//button[@name='processAddress']", "FAIL -- Check Out Button not found");
	}
}
