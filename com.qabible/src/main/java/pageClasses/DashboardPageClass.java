package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class DashboardPageClass {
	WebDriver driver;
	WaitUtility wu=new WaitUtility();
	GeneralUtilities glu = new GeneralUtilities();
	
public DashboardPageClass(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

@FindBy(xpath = "//a[text()='Dashboard']") WebElement dashboard;
@FindBy(xpath = "//a[@title='Calendar']") WebElement calender; 
@FindBy(xpath = "//a[@title='Bugs']") WebElement bug;
@FindBy(id = "s-menu") WebElement search;
@FindBy(xpath = "//i[@class='fa fa-plus-circle']") WebElement addButton;
@FindBy(xpath = "//a[contains(text(),'Payment salary')]") WebElement paymentSalaryOption;


public String getTextOfDashboard() {
	
	return glu.getTextOfElement(dashboard);
}

public String getDashboardUrl() {
	return glu.getCurrentUrl(driver);
	
}

public CalenderPageClass calenderClick() {
    wu.waitForElementToBeClickableByWebElement(driver, calender, 5);
    calender.click();
    return new CalenderPageClass(driver);
}

public BugsPageClass bugClick() {
	wu.waitForElementToBeClickableByWebElement(driver,bug , 5);
	bug.click();
	return new BugsPageClass(driver);
	
}

public void searchData(String menuItem) {
    wu.waitForElementToBeVisibleByWebElement(driver, search, 5);
    search.clear();
    search.sendKeys(menuItem + Keys.ENTER);
}

public void selectPaymentSalaryFromAddDropdown() {
    wu.waitForElementToBeClickableByWebElement(driver, addButton, 5);
    addButton.click();

    wu.waitForElementToBeClickableByWebElement(driver, paymentSalaryOption, 5);
    paymentSalaryOption.click();
}










}

