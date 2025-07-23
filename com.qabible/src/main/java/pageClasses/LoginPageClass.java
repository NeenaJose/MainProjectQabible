package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class LoginPageClass {
	WebDriver driver;
	GeneralUtilities glu= new GeneralUtilities(); 
	WaitUtility wu= new WaitUtility();
	
	public LoginPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	//PageFactory annotation in Selenium used to locate a web element
	@FindBy(name = "user_name") WebElement username;
	@FindBy(name = "password") WebElement password;
	@FindBy(xpath = "(//button[@type='submit'])[1]") WebElement signin;
	@FindBy(xpath="//img[@src='https://erp.qabible.in/uploads/SurviCamLogoHighResTransparent.png']") WebElement logo;
	@FindBy(xpath = "//div[@class='alert alert-danger']") WebElement errorMessage;
	@FindBy(xpath = "//label[contains(.,'Remember Me')]") WebElement rememberMe;
	@FindBy(name = "remember") WebElement checkbox;
	
	public DashboardPageClass login(String uname,String pass) {
		username.sendKeys(uname);
		password.sendKeys(pass);
		wu.waitForElementToBeClickableByWebElement(driver, signin, 5);
		signin.click();
		return new DashboardPageClass(driver);	
	}
	
	public LoginPageClass loginChaining(String uname,String pass) {
		username.sendKeys(uname);
		password.sendKeys(pass);
		wu.waitForElementToBeClickableByWebElement(driver, signin, 5);
		signin.click();
		return this;	
	}
	public String getTextOfErrorMessage() {
	    wu.waitForElementToBeVisibleByWebElement(driver, errorMessage, 5);
	    return errorMessage.getText();
	}
	public boolean isLogoDisplayed() {
	    return glu.isElementDisplayed(logo);
	}
	
	public boolean rememberMe() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].checked = true;", checkbox);

	    return checkbox.isSelected(); 
	}
	
	
	

}
