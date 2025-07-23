package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageClasses.CalenderPageClass;
import pageClasses.DashboardPageClass;
import pageClasses.LoginPageClass;
import utilities.ExcelReadUtility;

public class CalenderPageTestClass extends BaseClass{
	CalenderPageClass cp;
	LoginPageClass lp;
	DashboardPageClass dp;
  @Test
  public void verifyCalenderTitleIsPresent() throws IOException {
	  lp=new LoginPageClass(driver);
	  dp=lp.login(ExcelReadUtility.getStringData(0, 0, "LoginPage"),ExcelReadUtility.getIntData(0, 1, "LoginPage"));
	  cp =  dp.calenderClick();
	  String actualResult= cp.getTitle();
	  String expectedResult=ExcelReadUtility.getStringData(1, 0, "CalenderPage");
	  Assert.assertEquals(actualResult, expectedResult);
	  System.out.println(actualResult); 
	  
  }
}
