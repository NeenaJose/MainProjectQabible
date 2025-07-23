package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer{
	
	private int initialRetryCount = 0;
	private static final int maxRetryCount = 3;
	
	@Override
	public boolean retry(ITestResult result) { //ITestResult is an interface provided by TestNG.
		if(initialRetryCount<maxRetryCount) {
			initialRetryCount++;
			return true;
		}
		
		return false;
	}

}
