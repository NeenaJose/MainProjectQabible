package baseClass;

import org.testng.annotations.Test;

import constants.ConstantsClass;
import extentReport.ExtentManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	public static WebDriver driver;
	WebDriverWait explicitWait;
	public static Properties property;
	
	public static void readProperty() throws IOException{
		property=new Properties();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
		property.load(file);
		
	}
	
  @Parameters("browser")
  @BeforeMethod(groups = {"TearUp"})
  public void beforeMethod(String browserValue) throws IOException {
	  readProperty();
	  if(browserValue.equalsIgnoreCase("chrome")) {
		  driver = new ChromeDriver();  
	  }
	  else if (browserValue.equalsIgnoreCase("edge")) {
		  driver = new EdgeDriver();
		
	}
	  else {
		  throw new IllegalArgumentException("Invalid browser: " + browserValue);
	  }
	  
	  driver.manage().window().maximize();
	  driver.get(property.getProperty("baseurl"));
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConstantsClass.implicitWaitTimeout));
  }
  
  

  @AfterMethod(groups = {"TearDown"})
  public void afterMethod() {
	driver.quit();
  }
  
  @BeforeSuite(alwaysRun = true)
	public void createReport() {
		ExtentManager.createInstance();
	}

}

