package libraries;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class file consists of all the generic methods which are used for automation with
 * Selenium WebDriver
 * @author Sri harsha
 *
 */
public class GenericMethods {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public GenericMethods(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void scrollDownPage(){
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,900)", "");
	}
	
	/**
	 * This method clicks on the xpath that is provided and throws the message as exception
	 * if the element is not found/clickable
	 * @param xpath
	 * @param message
	 * @throws Exception
	 */
	public void clickByXpath(String xpath, String message) throws Exception {
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath)).click();
		}catch(Exception e) {
			throw new Exception(message);
		}
	}
	
	/**
	 * This method enters the text provided into the text field and throws the message as exception
	 * if the element is not found/clickable
	 * @param xpath
	 * @param value
	 * @param message
	 * @throws Exception
	 */
	public void enterByXpath(String xpath, String value, String message) throws Exception {
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath)).sendKeys(value);
		}catch(Exception e) {
			throw new Exception(message);
		}
	}
	
	/**
	 * This method enters the text provided into the text field and throws the message as exception
	 * if the element is not found/clickable
	 * @param id
	 * @param value
	 * @param message
	 * @throws Exception
	 */
	public void enterById(String id, String value, String message) throws Exception {
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		driver.findElement(By.id(id)).sendKeys(value);
		}catch(Exception e) {
			throw new Exception(message);
		}
	}
	
	/**
	 * This method fetches the text from the xpath provided and throws the message as exception
	 * if the element is not found
	 * @param xpath
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public String getTextByXpath(String xpath, String message) throws Exception {
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		String resultText = driver.findElement(By.xpath(xpath)).getText();
		return resultText;
		}catch(Exception e) {
			throw new Exception(message);
		}
	}
	
}
