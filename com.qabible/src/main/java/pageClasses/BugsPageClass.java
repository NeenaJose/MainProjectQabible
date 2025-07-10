package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class BugsPageClass {
	WebDriver driver;
	WaitUtility wu=new WaitUtility();
	GeneralUtilities glu = new GeneralUtilities();
	
public BugsPageClass(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
@FindBy(xpath = "//a[text()='Bugs']") WebElement bugs;
@FindBy(xpath = "//a[text()='New Bugs']") WebElement newBugs;
@FindBy(name = "bug_title") WebElement bugTitle;
@FindBy(name="issue_no") WebElement issue;
@FindBy(xpath = "//button[text()='Save']") WebElement saveButton;
@FindBy(xpath = "//table") WebElement bugTable;

public String getTextOfbugs() {
	
	return glu.getTextOfElement(bugs);
}

public void newBugs() {
	wu.waitForElementToBeClickableByWebElement(driver, newBugs, 5);
	newBugs.click();
}

public void addNewBug(String issueNo, String title) {
    wu.waitForElementToBeVisibleByWebElement(driver, issue, 5);
    issue.clear();                
    issue.sendKeys(issueNo);

    bugTitle.sendKeys(title);

    saveButton.click();
}

public boolean isBugPresent(String expectedTitle) {
    wu.waitForElementToBeVisibleByWebElement(driver, bugTable, 5);
    String tableText = bugTable.getText();
    System.out.println("Looking for bug title: " + expectedTitle);
    return tableText.contains(expectedTitle);
}



}
