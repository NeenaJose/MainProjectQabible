package testClasses;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageClasses.DashboardPageClass;
import pageClasses.LoginPageClass;
import pageClasses.PromotionPageClass;
import utilities.ExcelReadUtility;
import utilities.RandomDataUtility;

public class PromotionPageTestClass extends BaseClass {
	DashboardPageClass dp;
	LoginPageClass lp;
	PromotionPageClass pp;

	@Test(priority = 1)
	public void verifyPromotionMenuIsClickable() throws IOException {
		lp = new LoginPageClass(driver);
		dp = lp.login(ExcelReadUtility.getStringData(0, 0, "LoginPage"),
				ExcelReadUtility.getIntData(0, 1, "LoginPage"));
		pp = dp.promotionMenuClick();
		Assert.assertTrue(pp.isPromotionHeaderVisible(), "Promotion menu did not load properly");

	}

	@Test(priority = 2)
	public void verifyAddPromotionIsPossible() throws IOException {
		lp = new LoginPageClass(driver);
		dp = lp.login(ExcelReadUtility.getStringData(0, 0, "LoginPage"),
				ExcelReadUtility.getIntData(0, 1, "LoginPage"));
		pp = dp.promotionMenuClick().newPromotionMenuClick();
		String promotionTitle = RandomDataUtility.getPromotionTitle();
		String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String designation = ExcelReadUtility.getStringData(0, 2, "PromotionPage");

		boolean isAdded = pp.addNewPromotion(promotionTitle, date, designation);
		Assert.assertTrue(isAdded, "Promotion was not added (alert shown)");
	}

}
