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
	public void verifyCalenderIsClickable() throws IOException {
		lp = new LoginPageClass(driver);
		dp = lp.login(ExcelReadUtility.getStringData(0, 0, "LoginPage"),ExcelReadUtility.getIntData(0, 1, "LoginPage"));
		cp = dp.calenderClick();
		String actualResult = cp.getTextOfCalender();
		Assert.assertEquals(actualResult, "Calendar");
		System.out.println(actualResult);

	}

	@Test(priority=4)
	public void verifyBugMenuClick() throws IOException {
		lp = new LoginPageClass(driver);
		dp = lp.login(ExcelReadUtility.getStringData(0, 0, "LoginPage"),ExcelReadUtility.getIntData(0, 1, "LoginPage"));
		bp=dp.bugClick();
		bp = new BugsPageClass(driver);
		String actualResult = bp.getTextOfbugs();
		String expectedResult = ExcelReadUtility.getStringData(2, 0, "DashboardPage");
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println(actualResult);

	}

	@Test(priority=2)
	public void verifyUrl() throws IOException {
		lp = new LoginPageClass(driver);
		dp = lp.login(ExcelReadUtility.getStringData(0, 0, "LoginPage"),ExcelReadUtility.getIntData(0, 1, "LoginPage"));
		String actualResult = dp.getDashboardUrl();
		String expectedUrl = ExcelReadUtility.getStringData(1, 0, "DashboardPage");
		Assert.assertEquals(actualResult, expectedUrl);
		System.out.println(actualResult);
	}

	@Test(priority=3)
	public void verifySearchMenu() throws IOException {
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
	public void verifyPaymentSalaryNavigation() throws IOException {
		lp = new LoginPageClass(driver);
		dp = lp.login(ExcelReadUtility.getStringData(0, 0, "LoginPage"),ExcelReadUtility.getIntData(0, 1, "LoginPage"));
		dp.selectPaymentSalaryFromAddDropdown();

		Assert.assertTrue(driver.getCurrentUrl().contains("/admin/payroll/make_payment"),
				"Navigation to Payment Salary page failed.");
	}

}
