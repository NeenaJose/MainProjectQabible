package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	// calling inside page class
	public String getTextOfElement(WebElement element) {
		return element.getText();

	}

	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();

	}

	public String getAttribute(WebElement element, String attributeName) {
		return element.getAttribute(attributeName);

	}

	// isSelected
	public boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}

	// isEnabled
	public boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	// clearAndSendKeys
	public void clearAndSendKeys(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	// selectDropdownValueByVisibleText
	public void selectDropdownValueByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	// selectDropdownValueByValue
	public void selectDropdownValueByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	// switchToWindowByIndex
	public void switchToWindowByIndex(WebDriver driver, int index) {
		List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		if (index < windowHandles.size()) {
			driver.switchTo().window(windowHandles.get(index));
		}
	}

	// getPageTitle
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();

	}

	// getCurrentUrl
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();

	}

	// getTagName
	public String getTagName(WebElement element) {
		return element.getTagName();
	}
	
	
	//Dropdown De-select Methods
	public void deselectAllOptions(WebElement element) {
	    Select select = new Select(element);
	    select.deselectAll();
	}

	public void deselectByIndex(WebElement element, int index) {
	    Select select = new Select(element);
	    select.deselectByIndex(index);
	}

	public void deselectByVisibleText(WebElement element, String text) {
	    Select select = new Select(element);
	    select.deselectByVisibleText(text);
	}

	public void deselectByValue(WebElement element, String value) {
	    Select select = new Select(element);
	    select.deselectByValue(value);
	}

	//Alert Dismiss and SendKeys
	public void alertDismiss(WebDriver driver) {
	    driver.switchTo().alert().dismiss();
	}

	public void alertSendKeys(WebDriver driver, String text) {
	    driver.switchTo().alert().sendKeys(text);
	}
	
	//iFrame Switching Options
	public void switchToFrameByIndex(WebDriver driver, int index) {
	    driver.switchTo().frame(index);
	}

	public void switchToFrameByWebElement(WebDriver driver, WebElement element) {
	    driver.switchTo().frame(element);
	}

	public void switchToDefaultContent(WebDriver driver) {
	    driver.switchTo().defaultContent();
	}

	//Actions - KeyDown, KeyUp, DoubleClick, DragAndDrop
	public void keyDownAction(WebDriver driver, WebElement element, CharSequence key) {
	    Actions actions = new Actions(driver);
	    actions.keyDown(element, key).perform();
	}

	public void keyUpAction(WebDriver driver, WebElement element, CharSequence key) {
	    Actions actions = new Actions(driver);
	    actions.keyUp(element, key).perform();
	}

	public void doubleClick(WebDriver driver, WebElement element) {
	    Actions actions = new Actions(driver);
	    actions.doubleClick(element).perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
	    Actions actions = new Actions(driver);
	    actions.dragAndDrop(source, target).perform();
	}


	// ***********************************JavaScript*******************************************//
	public void clickUsingJavaScriptExecutor(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void scrollUsingJavaScriptExecutor(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	public void scrollUsingJavaScriptExecutor_ScrollBy(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

	}

	// mouse hover
	public void mouseHoverElement_Utility(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void mouseHoverAndClick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}

	public void fileUpload(WebElement element, String filepath) {
		element.sendKeys(filepath);

	}

	// Multiselectdropdown
	public boolean isMultiSelectDropdown(WebElement element) {
		Select select = new Select(element);
		return select.isMultiple();
	}

	public void selectDropdownValueByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public List<String> getAllDropDownOptions(WebElement element) {
		Select select = new Select(element);
		return select.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
	}

	// code similar to stream().map()
	public List<String> getOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> allOptions = select.getOptions();
		List<String> optionText = new ArrayList<String>();
		for (WebElement webElement : allOptions) {
			optionText.add(webElement.getText());
		}
		return optionText;

	}

	public List<String> getAllSelectedOptionFromDropdown(WebElement element) {
		Select select = new Select(element);
		return select.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList());
	}

	// alertAccept
	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	// getTextOfAlert
	public String getTextOfAlertMessage(WebDriver driver) {
		return driver.switchTo().alert().getText();

	}

	// Frame
	public void switchToFrameByNameOrID(WebDriver driver, String NameOrID) {
		driver.switchTo().frame(NameOrID);
	}

	// Thread.Sleep
	public void addSleep(long timeOut) throws InterruptedException {
		Thread.sleep(timeOut);
	}

}
