package dataProvider;

import org.testng.annotations.Test;

import utilities.ExcelReadUtility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
 

  @DataProvider(name="unsuccessfullLogin")
  public Object[][] dp() throws IOException {
    return new Object[][] {
    	
    	 new Object[] { ExcelReadUtility.getStringData(1, 0, "LoginPage"), ExcelReadUtility.getStringData(1, 1, "LoginPage") },
         new Object[] { ExcelReadUtility.getStringData(2, 0, "LoginPage"), ExcelReadUtility.getIntData(2, 1, "LoginPage") },
         new Object[] { ExcelReadUtility.getStringData(3, 0, "LoginPage"), ExcelReadUtility.getStringData(3, 1, "LoginPage")}	
    	
    };
  }
}
