package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraries.GenericMethods;

/**
 * This file contains all the methods/objects related to My Account page of the application
 * @author Sri harsha
 */
public class MyShoppingCartPageObject {

	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;
	
	public MyShoppingCartPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		genericMethods = new GenericMethods(driver, wait);
	}
	
	public void clickCheckOutButton() throws Exception {
		genericMethods.clickByXpath("//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']", "FAIL -- Check Out Button not found");
	}
}
