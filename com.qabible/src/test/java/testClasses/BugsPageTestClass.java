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

public class BugsPageTestClass extends BaseClass{
	BugsPageClass bp;
	DashboardPageClass dp;
	LoginPageClass lp;
	
	@Test
	public void verifybugAddition() throws IOException {
	    lp = new LoginPageClass(driver);
		dp=lp.login(ExcelReadUtility.getStringData(0, 0, "LoginPage"),ExcelReadUtility.getIntData(0, 1, "LoginPage"));

	    dp = new DashboardPageClass(driver);
	    dp.bugClick();

	    bp = new BugsPageClass(driver);
	    bp.newBugs();

	    String bugTitle = RandomDataUtility.getBugTitle();
	    bp.addNewBug("TestIssue", bugTitle);

	    Assert.assertTrue(bp.isBugPresent(bugTitle), "Bug was not added successfully");
	}
	

	

	
	

  }

