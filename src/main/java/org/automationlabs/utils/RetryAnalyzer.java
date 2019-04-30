package org.automationlabs.utils;

import org.automationlabs.config.ConfigFileReader;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int counter = 0;
	int retryLimit = Integer.parseInt(ConfigFileReader.getConfigValue("retry"));
	
	public boolean retry(ITestResult result) {
		if(counter<retryLimit) {
			counter++;
			return true;
		}
		return false;
	}

}
