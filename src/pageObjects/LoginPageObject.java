package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraries.GenericMethods;

/**
 * This file contains all the methods/objects related to Login page of the application
 * @author Sri harsha
 *
 */
public class LoginPageObject {

	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;
	

	public LoginPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		genericMethods = new GenericMethods(driver, wait);
	}
	
	
	public void clickSignInButton() throws Exception {
		genericMethods.clickByXpath("//button[@id='SubmitLogin']", "FAIL -- Sign in Button not found");
	}
	
	public void enterUsername(String username) throws Exception {
		genericMethods.enterByXpath("//input[@id='email']", username, 
				"FAIL -- Username text field not found");
	}
	
	public void enterPassword(String password) throws Exception {
		genericMethods.enterById("passwd", password, 
				"FAIL -- Password text field not found");
	}
}
