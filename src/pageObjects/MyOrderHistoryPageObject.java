package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraries.GenericMethods;

public class MyOrderHistoryPageObject {

	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;

	public MyOrderHistoryPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		genericMethods = new GenericMethods(driver, wait);
	}
	
	public void clickItemButton() throws Exception {
		genericMethods.clickByXpath("//a[contains(text(),'DHZQDWAXX')]", "FAIL -- Item Button not found");
	}
	
	public void clickReOrderButton() throws Exception {
		genericMethods.clickByXpath("//a[contains(@class,'button btn btn-default')]", "FAIL -- ReOrder Button not found");
	}
}
