package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class BugsPageClass {
	WebDriver driver;
	WaitUtility wu = new WaitUtility();
	GeneralUtilities glu = new GeneralUtilities();

	public BugsPageClass(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[text()='Bugs']")
	WebElement bugs;
	@FindBy(xpath = "//a[text()='New Bugs']")
	WebElement newBugs;
	@FindBy(name = "bug_title")
	WebElement bugTitle;
	@FindBy(xpath = "//label[contains(text(),'Issue #')]")
	WebElement issue;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath = "//table")
	WebElement bugTable;

	public String getTextOfbugs() {

		return glu.getTextOfElement(bugs);
	}

	public BugsPageClass newBugs() {
		wu.waitForElementToBeClickableByWebElement(driver, newBugs, 5);
		newBugs.click();
		return this;
	}
	
	
	public boolean isIssueFieldVisible() {
		return glu.isElementDisplayed(issue);
	}

	
	
	

}
