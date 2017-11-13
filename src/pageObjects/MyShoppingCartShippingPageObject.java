package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraries.GenericMethods;

/**
 * This file contains all the methods/objects related to My Account page of the application
 * @author Sri harsha
 */
public class MyShoppingCartShippingPageObject {

	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;
	
	public MyShoppingCartShippingPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		genericMethods = new GenericMethods(driver, wait);
	}
	
	public void clickAgreeButton() throws Exception {
		genericMethods.clickByXpath("//div[@id='uniform-cgv']", "FAIL -- Agree Button not found");
	}
	
	public void clickCheckOutButton() throws Exception {
		genericMethods.clickByXpath("//button[@name='processCarrier']", "FAIL -- Check Out Button not found");
	}
}
