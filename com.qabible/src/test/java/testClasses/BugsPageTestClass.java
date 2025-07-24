package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageClasses.BugsPageClass;
import pageClasses.DashboardPageClass;
import pageClasses.LoginPageClass;
import utilities.ExcelReadUtility;
import utilities.RandomDataUtility;

public class BugsPageTestClass extends BaseClass {
	BugsPageClass bp;
	DashboardPageClass dp;
	LoginPageClass lp;

	@Test
	public void verifyAddNewbugClickIsNavigatingToNewPage() throws IOException {
		lp = new LoginPageClass(driver);
		dp = lp.login(ExcelReadUtility.getStringData(0, 0, "LoginPage"),
				ExcelReadUtility.getIntData(0, 1, "LoginPage"));
		bp = dp.bugMenuClick();
		bp = bp.newBugsMenuClick();
		Assert.assertTrue(bp.isIssueFieldVisible(), "'Issue #' field is not visible on New Bug page");
		System.out.println("'Issue #' field is displayed.");

	}

}
