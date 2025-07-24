package pageClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class PromotionPageClass {
	WebDriver driver;
	WaitUtility wu = new WaitUtility();
	GeneralUtilities glu = new GeneralUtilities();

	public PromotionPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='Promotion']")
	WebElement promotion;

	@FindBy(xpath = "//a[@href='https://erp.qabible.in/admin/promotion/new_promotion']")
	WebElement newPromotion;

	@FindBy(id = "select2-user_id-wx-container")
	WebElement employeeNameDropdown;
	By employeeOptions = By.xpath("//ul[@class='select2-results__options']/li[not(contains(@class, 'loading'))]");

	@FindBy(xpath = "//span[starts-with(@id,'select2-designation_id') and contains(@class,'select2-selection__rendered')]")
	WebElement designationDropdown;

	@FindBy(name = "promotion_title")
	WebElement promotionTitle;

	@FindBy(name = "promotion_date")
	WebElement promotionDate;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	WebElement designationInput;

	@FindBy(xpath = "(//a[@href='https://erp.qabible.in/admin/promotion'])[2]")
	WebElement promotionHeader;

	public boolean isPromotionHeaderVisible() {
		return promotionHeader.isDisplayed();
	}

	// Click on New Promotion
	public PromotionPageClass newPromotionMenuClick() {
		wu.waitForElementToBeClickableByWebElement(driver, newPromotion, 5);
		newPromotion.click();
		return this;
	}

	public boolean addNewPromotion(String title, String date, String designation) {
		wu.waitForElementToBeVisibleByWebElement(driver, promotionTitle, 5);
		promotionTitle.sendKeys(title);

		wu.waitForElementToBeVisibleByWebElement(driver, designationDropdown, 5);
		designationDropdown.click();

		wu.waitForElementToBeVisibleByWebElement(driver, designationInput, 5);
		designationInput.sendKeys(designation);
		designationInput.sendKeys(Keys.ENTER);

		wu.waitForElementToBeVisibleByWebElement(driver, promotionDate, 5);
		promotionDate.sendKeys(date);
		promotionDate.sendKeys(Keys.TAB);

		wu.waitForElementToBeClickableByWebElement(driver, saveButton, 5);
		saveButton.click();

		boolean isAlertPresent = wu.isAlertPresent(driver, 3);
		if (isAlertPresent) {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert: " + alert.getText());
			alert.accept();
			return false;
		}
		return true;
	}

}
