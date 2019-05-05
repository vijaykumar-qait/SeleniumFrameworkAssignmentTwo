package org.automationlabs.reports;

import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.annotations.BeforeTest;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentTest;

public class ExtentReporter implements IReporter{
	ExtentReporter extent;
	ExtentTest logger;
	
	@BeforeTest
	public void startReport() {
		
	}

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		
	}
	
}
