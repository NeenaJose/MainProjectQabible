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

public class DashboardTestClass extends BaseClass{
	DashboardPageClass dp;
	LoginPageClass lp;
	CalenderPageClass cp;
	BugsPageClass bp;
  @Test
  public void verifyCalenderIsClickable() throws IOException {
	  lp=new LoginPageClass(driver);
	  lp.login(ExcelReadUtility.getStringData(0, 0, "LoginPage"),ExcelReadUtility.getIntData(0, 1, "LoginPage"));
	  dp=new DashboardPageClass(driver);
	  dp.calenderClick();
	  cp=new CalenderPageClass(driver);
	  cp.getTextOfCalender();
	  String actualResult=cp.getTextOfCalender();
	  Assert.assertEquals(actualResult, "Calendar");
	  System.out.println(actualResult);  
	
  }
  
  @Test
  public void verifyBugMenuClick() throws IOException {
	  lp=new LoginPageClass(driver);
	  lp.login(ExcelReadUtility.getStringData(0, 0, "LoginPage"),ExcelReadUtility.getIntData(0, 1, "LoginPage"));
	  dp=new DashboardPageClass(driver);
	  dp.bugClick();
	  bp = new BugsPageClass(driver);
	  String actualResult = bp.getTextOfbugs();
	  String expectedResult = ExcelReadUtility.getStringData(2, 0, "DashboardPage");
	  Assert.assertEquals(actualResult, expectedResult);
	  System.out.println(actualResult);
	  
  }
  
  @Test
  public void verifyUrl() throws IOException {
	  lp = new LoginPageClass(driver);
	  lp.login(ExcelReadUtility.getStringData(0, 0, "LoginPage"),ExcelReadUtility.getIntData(0, 1, "LoginPage")); 
	    dp = new DashboardPageClass(driver);
	    String actualResult = dp.getDashboardUrl();  
	    String expectedUrl = ExcelReadUtility.getStringData(1, 0, "DashboardPage");
	    Assert.assertEquals(actualResult, expectedUrl);
	    System.out.println(actualResult);
  }
  
  @Test
  public void verifySearchMenu() throws IOException {
	  lp = new LoginPageClass(driver);
	    lp.login(
	        ExcelReadUtility.getStringData(0, 0, "LoginPage"),
	        ExcelReadUtility.getIntData(0, 1, "LoginPage")
	    );

	    dp = new DashboardPageClass(driver);
	    String menuItem = ExcelReadUtility.getStringData(2, 0, "DashboardPage");
	    dp.searchData(menuItem);

	    System.out.println("Search text entered: " + menuItem);
	   
	    String actualResult = dp.getDashboardUrl();
	    String expectedUrl = ExcelReadUtility.getStringData(1, 0, "DashboardPage");
	    Assert.assertEquals(actualResult,expectedUrl);
	    System.out.println(actualResult);
	
      
  }
  
  @Test
  public void verifyPaymentSalaryNavigation() throws IOException {
      lp = new LoginPageClass(driver);
      lp.login(ExcelReadUtility.getStringData(0, 0, "LoginPage"),ExcelReadUtility.getIntData(0, 1, "LoginPage"));

      DashboardPageClass dp = new DashboardPageClass(driver);
      dp.selectPaymentSalaryFromAddDropdown();

      Assert.assertTrue(driver.getCurrentUrl().contains("/admin/payroll/make_payment"), "Navigation to Payment Salary page failed.");
  }
  
}
