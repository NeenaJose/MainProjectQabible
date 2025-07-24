package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import dataProvider.DataProviderClass;
import pageClasses.DashboardPageClass;
import pageClasses.LoginPageClass;
import utilities.ExcelReadUtility;

public class LoginPageTestClass extends BaseClass {
	LoginPageClass lp;
	DashboardPageClass dp;

	@Test(priority = 1, groups = { "Group1" })
	public void verifySuccessfullLogin() throws IOException {
		lp = new LoginPageClass(driver);// invoking constructor
		dp = lp.login(ExcelReadUtility.getStringData(0, 0, "LoginPage"),
				ExcelReadUtility.getIntData(0, 1, "LoginPage"));
		String actualResult = dp.getTextOfDashboard();
		Assert.assertEquals(actualResult, "Dashboard");
		System.out.println(actualResult);
	}

	@Test(priority = 2, dataProvider = "unsuccessfullLogin", dataProviderClass = DataProviderClass.class)
	public void verifyUnSuccessfullLogin(String u, String p) {
		lp = new LoginPageClass(driver);
		lp.invalidLogin(u, p);
		String actualResult = lp.getTextOfErrorMessage();
		Assert.assertEquals(actualResult, "username or password information doesn't exist!");
		System.out.println(actualResult);
	}

	@Test(groups = { "Group1" }, priority = 3)
	public void verifyLogoIsDisplayed() {
		lp = new LoginPageClass(driver);
		boolean isLogoVisible = lp.isLogoDisplayed();
		Assert.assertTrue(isLogoVisible, "Logo is not displayed after login");
		System.out.println("Logo is displayed: " + isLogoVisible);

	}

	@Test(priority = 4)
	public void verifyRememberMeCheckboxIsChecked() throws IOException {
		lp = new LoginPageClass(driver);
		boolean isChecked = lp.rememberMeCheckboxSelection();
		Assert.assertTrue(isChecked, "Remember Me checkbox is not selected");
		System.out.println("Remember Me checkbox selected: " + isChecked);
		lp.login(ExcelReadUtility.getStringData(0, 0, "LoginPage"), ExcelReadUtility.getIntData(0, 1, "LoginPage"));
	}

}
