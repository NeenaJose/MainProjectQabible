package utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	 WebDriverWait wait;
	 
	 public void waitForElementToBeClickableByXpathLocator(WebDriver driver,String locatorValue,int timeOut) {
			
			wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
		}
	 
	 public void waitForElementToBeClickableByIdLocator(WebDriver driver,String locatorValue,int timeOut) {
			
			wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
		}
	 
	 public void waitForElementToBeClickableByWebElement(WebDriver driver,WebElement element,int timeOut) {
			
			wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
	 
	 public void waitForElementToBeVisibleByWebElement(WebDriver driver,WebElement element,int timeOut) {
			
			wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
	 
	 public boolean waitForAlertPresent(WebDriver driver,int timeOut) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		 wait.until(ExpectedConditions.alertIsPresent());
		return false; 
		 
	 }
	 
	 
	 public void waitForElementToBeVisibleByXpathLocator(WebDriver driver, String locatorValue, int timeOut) {
		    wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
		}
	 
	 public void waitForElementToBeVisibleByIdLocator(WebDriver driver, String locatorValue, int timeOut) {
		    wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
		}
	 
	 public void fluentWaitForElementtoBeClickableByIdLocator_Utility(WebDriver driver,String locatorValue,int totalTimeOut,int pollingTimeOut ) {
			
			FluentWait<WebDriver> wait = new FluentWait<> (driver)
					.withTimeout(Duration.ofSeconds(totalTimeOut))
					.pollingEvery(Duration.ofSeconds(pollingTimeOut))
					.ignoring(NoSuchElementException.class);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
		}
	 
	 
	 public List<WebElement> waitForElementsToBeVisibleByXpathLocator(WebDriver driver, String locatorValue, int timeOut) {
		    wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		    return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locatorValue)));
		}
	 
	 public boolean isAlertPresent(WebDriver driver, int timeoutInSeconds) {
		    try {
		        wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		        wait.until(ExpectedConditions.alertIsPresent());
		        return true;
		    } catch (Exception e) {
		        return false;
		    }
		}
}

