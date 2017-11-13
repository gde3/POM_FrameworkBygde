package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraries.GenericMethods;

/**
 * This file contains all the methods/objects related to Home page of the
 * application
 * 
 * @author Sri harsha
 */
public class HomePageObject {

	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;

	public HomePageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		genericMethods = new GenericMethods(driver, wait);
	}

	public void clickSignInLink() throws Exception {

		genericMethods.clickByXpath("//a[@class='login']", "FAIL -- Sign link is not found");
	}

	public void clickMyAccountLink() throws Exception {

		genericMethods.clickByXpath("//a[@class='account']", "FAIL -- My Account link is not found");
	}
}
