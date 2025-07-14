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
	@Test
	public void verifySuccessfullLogin() throws IOException {
		lp=new LoginPageClass(driver);
		dp=lp.login(ExcelReadUtility.getStringData(0, 0, "LoginPage"),ExcelReadUtility.getIntData(0, 1, "LoginPage"));
		String actualResult=dp.getTextOfDashboard();
		Assert.assertEquals(actualResult, "Dashboard");
		System.out.println(actualResult);
	}
	
	@Test(dataProvider = "unsuccessfullLogin",dataProviderClass = DataProviderClass.class)
	public void verifyUnSuccessfullLogin(String u,String p) {
		lp=new LoginPageClass(driver);
		lp.login(u,p);
		String actualResult=lp.getTextOfErrorMessage();
		Assert.assertEquals(actualResult, "username or password information doesn't exist!");
		System.out.println(actualResult);
	}
	
	@Test
	public void verifyLogo() {
		 lp=new LoginPageClass(driver);
		 boolean isLogoVisible = lp.isLogoDisplayed();
		 Assert.assertTrue(isLogoVisible, "Logo is not displayed after login");
		 System.out.println("Logo is displayed: " + isLogoVisible);
		
	}
	

	@Test
	public void verifyRememberMeCheckbox() throws IOException {
	    lp = new LoginPageClass(driver);
	    boolean isChecked = lp.rememberMe(); 
	    Assert.assertTrue(isChecked, "Remember Me checkbox is not selected");
	    System.out.println("Remember Me checkbox selected: " + isChecked);
	    lp.login(ExcelReadUtility.getStringData(0, 0, "LoginPage"),ExcelReadUtility.getIntData(0, 1, "LoginPage"));
	}
	
}
