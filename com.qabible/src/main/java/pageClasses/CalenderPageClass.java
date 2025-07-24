package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class CalenderPageClass {
	WebDriver driver;
	WaitUtility wu=new WaitUtility();
	GeneralUtilities glu = new GeneralUtilities();
	
public CalenderPageClass(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "(//a[@href='https://erp.qabible.in/admin/calendar'])[2]") WebElement calender;
	
	public String getTextOfCalender() {
		
		return glu.getTextOfElement(calender);
	}
	
	public String getTitleOfCalenderPage() {
		return glu.getPageTitle(driver);
		
	}

}
