package testScripts;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import libraries.GenericMethods;
import libraries.Utilities;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.MyOrderHistoryPageObject;
import pageObjects.MyShoppingCartAddressPageObject;
import pageObjects.MyShoppingCartPageObject;
import pageObjects.MyShoppingCartPaymentPageObject;
import pageObjects.MyShoppingCartShippingPageObject;




/**
 * This file has the test scripts for the basic functionalities of demo application
 * @author Sri harsha
 */
public class seleniumTestScript1 {
	
	public static void main(String[] args) throws Exception {
		seleniumTestScript1 script1 = new seleniumTestScript1();
		script1.startBrowser();
		script1.webDriverCommands2();
		script1.endBrowser();
	}
	
	WebDriver driver;
	WebDriverWait wait;
	HomePageObject homepage;
	LoginPageObject loginpage;
	MyAccountPageObject myaccountpage;
	MyOrderHistoryPageObject myorderhistorypage;
	MyShoppingCartPageObject myshoppingcartpage;
	MyShoppingCartAddressPageObject myshoppingcartaddresspage;
	MyShoppingCartShippingPageObject myshoppingcartshippingpage;
	MyShoppingCartPaymentPageObject myshoppingcartpaymentpage;
	GenericMethods genericMethods;
	Utilities utilities = new Utilities();
	
	@BeforeTest
	public void startBrowser() {
		driver = utilities.launchBrowser();
		wait = new WebDriverWait(driver, 30);
		genericMethods = new GenericMethods(driver, wait);
		driver.manage().window().maximize(); // Maximize the browser window
		homepage = new HomePageObject(driver, wait);
		loginpage = new LoginPageObject(driver, wait);
		myaccountpage = new MyAccountPageObject(driver, wait);
		myshoppingcartpage = new MyShoppingCartPageObject(driver, wait);
		myorderhistorypage = new MyOrderHistoryPageObject(driver, wait);
		myshoppingcartaddresspage = new MyShoppingCartAddressPageObject(driver, wait);
		myshoppingcartshippingpage = new MyShoppingCartShippingPageObject(driver, wait);
		myshoppingcartpaymentpage = new MyShoppingCartPaymentPageObject(driver, wait);
	}
	
	@Test
	public void webDriverCommands() throws Exception {

		Reporter.log("This is the current URL -->" + driver.getCurrentUrl(), true); // Print the url of the page.
		Reporter.log("This is the Window title -->" + driver.getTitle(), true); // Print the title of the page.

		homepage.clickSignInLink();
		loginpage.enterUsername("testautomation88@test.com");
		loginpage.enterPassword("123456");
		loginpage.clickSignInButton();
	}

	@Test
	public void webDriverCommands2() throws Exception {
		
		homepage.clickSignInLink();

		loginpage.enterUsername("testautomation88@test.com");
		loginpage.enterPassword("123456");
		loginpage.clickSignInButton();

		myaccountpage.clickReturnHomeButton();
		homepage.clickMyAccountLink();

		String accountPageText = driver.findElement(By.xpath("//div[@id='center_column']/h1")).getText();
		Assert.assertEquals(accountPageText, "MY ACCOUNT", "FAIL -- The account page text is not displayed properly");

		myaccountpage.clickOrderButton();
		myorderhistorypage.clickItemButton();
		myorderhistorypage.clickReOrderButton();
		
		genericMethods.scrollDownPage();

		myshoppingcartpage.clickCheckOutButton();
		myshoppingcartaddresspage.clickCheckOutButton();
		myshoppingcartshippingpage.clickAgreeButton();
		myshoppingcartshippingpage.clickCheckOutButton();
		myshoppingcartpaymentpage.clickBankWireButton();
		myshoppingcartpaymentpage.clickConfirmOrderButton();

		String confirmation = driver.findElement(By.xpath("//div[@id='center_column']/h1")).getText();
		Assert.assertEquals(confirmation, "ORDER CONFIRMATION", "FAIL -- Order not confirmed");

	}
	
	@Test
	public void webdriverCommands3() throws InterruptedException {
		
		driver.manage().window().maximize(); // Maximize the browser window

		WebElement signInLink = driver.findElement(By.xpath("//a[@class='login']")); // Will identify the sign in link
																						// and stores
		signInLink.click(); // Clicks the sign in link
		
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("newemailtestaccount01@test.com");
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='account-creation_form']")));
		
		String accountPage = driver.findElement(By.xpath("//div[@id='noSlide']/h1")).getText();
		Assert.assertEquals(accountPage, "CREATE AN ACCOUNT", "FAIL -- Account page title does not match");
		
		//Scroll the page down
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,250)", "");
		
		//Selenium commands for drop down selection
		
		WebElement dateDropdown = driver.findElement(By.xpath("//select[@id='days']"));
		Select dateDD = new Select(dateDropdown);
		dateDD.selectByIndex(8);    // Date as 8
		
		WebElement monthDropdown = driver.findElement(By.xpath("//select[@id='months']"));
		Select monthDD = new Select(monthDropdown);
		monthDD.selectByValue("7");   //Month as July
		
		WebElement yearDropdown = driver.findElement(By.xpath("//select[@id='years']"));
		Select yearDD = new Select(yearDropdown);
		yearDD.selectByVisibleText("1988  ");   //Year as 1988
		
	}
	
	@Test
	public void testMethod(){
		
		System.out.println("hello ");

	}
	@AfterTest
	public void endBrowser(){
		// driver.close(); //close the browser
		driver.quit(); // Quit the Service and all opened instances of the browser
	}
		
	
}
