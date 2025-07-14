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

public class PromotionPageTestClass extends BaseClass{
	DashboardPageClass dp;
	LoginPageClass lp;
	PromotionPageClass pp;
	
  @Test
  public void verifyPromotionMenuIsClickable() throws IOException {
	  lp=new LoginPageClass(driver);
	  dp=lp.login(ExcelReadUtility.getStringData(0, 0, "LoginPage"),ExcelReadUtility.getIntData(0, 1, "LoginPage"));
	  pp=new PromotionPageClass(driver);
	  pp.promotionClick();
	  Assert.assertTrue(pp.isPromotionHeaderVisible(), "❌ Promotion menu did not load properly");
	  
  }
  
  @Test
  public void verifyAddPromotion() throws IOException {
      lp = new LoginPageClass(driver);
  	  dp=lp.login(ExcelReadUtility.getStringData(0, 0, "LoginPage"),ExcelReadUtility.getIntData(0, 1, "LoginPage"));

      pp = new PromotionPageClass(driver);
      pp.promotionClick();
      pp.newPromotionClick();

      String promotionTitle = RandomDataUtility.getPromotionTitle();
      String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
      String designation = ExcelReadUtility.getStringData(0, 2, "PromotionPage");

      boolean isAdded = pp.addNewPromotion(promotionTitle, date, designation);
      Assert.assertTrue(isAdded, "Promotion was not added (alert shown)");
  }

}
