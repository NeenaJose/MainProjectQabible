package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageClasses.BugsPageClass;
import pageClasses.CalenderPageClass;
import pageClasses.DashboardPageClass;
import pageClasses.LoginPageClass;
import utilities.ExcelReadUtility;

public class DashboardTestClass extends BaseClass {
	DashboardPageClass dp;
	LoginPageClass lp;
	CalenderPageClass cp;
	BugsPageClass bp;

	@Test(groups = {"Group1"},priority=1)
	public void verifyCalenderMenuIsClickable() throws IOException {
		lp = new LoginPageClass(driver);
		dp = lp.login(ExcelReadUtility.getStringData(0, 0, "LoginPage"),ExcelReadUtility.getIntData(0, 1, "LoginPage"));
		cp = dp.calenderMenuClick();
		String actualResult = cp.getTextOfCalender();
		Assert.assertEquals(actualResult, "Calendar");
		System.out.println(actualResult);

	}

	@Test(priority=4)
	public void verifyBugMenuIsClickable() throws IOException {
		lp = new LoginPageClass(driver);
		dp = lp.login(ExcelReadUtility.getStringData(0, 0, "LoginPage"),ExcelReadUtility.getIntData(0, 1, "LoginPage"));
		bp=dp.bugMenuClick();
		String actualResult = bp.getTextOfbugs();
		String expectedResult = ExcelReadUtility.getStringData(2, 0, "DashboardPage");
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println(actualResult);

	}

	
	
	 @Test(priority=2)
	    public void verifyNoNotificationDisplayedOnBellClick() throws IOException {
		 lp = new LoginPageClass(driver);
			dp = lp.login(ExcelReadUtility.getStringData(0, 0, "LoginPage"),ExcelReadUtility.getIntData(0, 1, "LoginPage"));
			dp.clickBellIcon();

	        // Validate notification message
	        Assert.assertTrue(dp.isNoNotificationDisplayed(), "Notification message not displayed");
	        Assert.assertEquals(dp.getNoNotificationMessage(), "There is no notification", "Incorrect message");
	    }

	@Test(priority=3)
	public void verifySearchMenuDisplaysSearchData() throws IOException {
		lp = new LoginPageClass(driver);
		dp = lp.login(ExcelReadUtility.getStringData(0, 0, "LoginPage"),ExcelReadUtility.getIntData(0, 1, "LoginPage"));
		String menuItem = ExcelReadUtility.getStringData(2, 0, "DashboardPage");
		dp.searchData(menuItem);

		System.out.println("Search text entered: " + menuItem);

		String actualResult = dp.getDashboardUrl();
		String expectedUrl = ExcelReadUtility.getStringData(1, 0, "DashboardPage");
		Assert.assertEquals(actualResult, expectedUrl);
		System.out.println(actualResult);

	}

	@Test(priority=5)
	public void verifyPaymentSalaryNavigationIsWorking() throws IOException {
		lp = new LoginPageClass(driver);
		dp = lp.login(ExcelReadUtility.getStringData(0, 0, "LoginPage"),ExcelReadUtility.getIntData(0, 1, "LoginPage"));
		dp.selectPaymentSalaryFromAddDropdown();

		Assert.assertTrue(driver.getCurrentUrl().contains("/admin/payroll/make_payment"),
				"Navigation to Payment Salary page failed.");
	}

}
