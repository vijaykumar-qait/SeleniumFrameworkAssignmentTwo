package org.automationlabs.utils;

import java.io.File;
import java.io.IOException;

import org.automationlabs.core.BaseDriver;
import org.automationlabs.core.GenericFunctions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TakeSceenShotListener extends BaseDriver implements ITestListener {
	
	String filePath = "." + File.separator + "Resources" + File.separator+"screenshots/"; 
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("**********" + result.getName() + "**********");
		String methodName = result.getName().toString().trim();
		Object currentClass = result.getInstance();
		takeScreenShot(methodName, ((BaseDriver)currentClass).getDriver());
	}
	
	public void takeScreenShot(String methodName, WebDriver driver) {
	
		try {
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			System.out.println("Src file: " + srcFile);
			FileHandler.copy(srcFile, new File(filePath + methodName + ".png"));
			System.out.println("***Placed screen shot in " + filePath + " ***");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}
