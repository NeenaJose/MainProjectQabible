package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageClasses.BugsPageClass;
import pageClasses.DashboardPageClass;
import pageClasses.LoginPageClass;
import utilities.RandomDataUtility;

public class BugsPageTestClass extends BaseClass{
	BugsPageClass bp;
	DashboardPageClass dp;
	LoginPageClass lp;
	
	@Test
	public void verifybugAddition() {
	    lp = new LoginPageClass(driver);
	    lp.login("admin", "123456");

	    dp = new DashboardPageClass(driver);
	    dp.bugClick();

	    bp = new BugsPageClass(driver);
	    bp.newBugs();

	    String bugTitle = RandomDataUtility.getBugTitle();
	    bp.addNewBug("TestIssue", bugTitle);

	    Assert.assertTrue(bp.isBugPresent(bugTitle), "Bug was not added successfully");
	}

  }

