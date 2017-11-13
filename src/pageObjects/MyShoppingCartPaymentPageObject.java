package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraries.GenericMethods;

/**
 * This file contains all the methods/objects related to My Account page of the application
 * @author Sri harsha
 */
public class MyShoppingCartPaymentPageObject {

	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;
	
	public MyShoppingCartPaymentPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		genericMethods = new GenericMethods(driver, wait);
	}
	
	public void clickBankWireButton() throws Exception {
		genericMethods.clickByXpath("//a[@class='bankwire']", "FAIL -- Bank Wire Button not found");
	}
	
	public void clickConfirmOrderButton() throws Exception {
		genericMethods.clickByXpath("//p[@id='cart_navigation']/button", "FAIL -- Confirm Order Button not found");
	}
}
