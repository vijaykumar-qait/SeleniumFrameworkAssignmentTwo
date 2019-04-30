package org.automationlabs.tests;

import org.apache.log4j.xml.DOMConfigurator;
import org.automationlabs.config.ConfigFileReader;
import org.automationlabs.core.BaseDriver;
import org.automationlabs.core.GenericFunctions;
import org.automationlabs.pageobject.MMTHomePage;
import org.automationlabs.utils.Log;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.automationlabs.utils.TakeSceenShotListener.class)

public class MakeMyTrip_Test extends BaseDriver{

	String URL;
	String browserType;
	int timeout;
	GenericFunctions generic;
	MMTHomePage mmtHomePage;
	
	@BeforeTest
	public void BeforeTest() {
		URL = ConfigFileReader.getConfigValue("url");
		browserType = ConfigFileReader.getConfigValue("browser");
		timeout = Integer.parseInt(ConfigFileReader.getConfigValue("implicitwait"));
		generic = new GenericFunctions();
		driver = generic.StartDriver(browserType);
		mmtHomePage = new MMTHomePage(driver, generic);
		DOMConfigurator.configure("log4j.xml");
	}
	
	@Test//(retryAnalyzer = org.automationlabs.utils.RetryAnalyzer.class)
	public void TC_01_Verify_MMT_Home_Page() {
		Log.startTestCase("TC_01_Verify_MMT_Home_Page");
		generic.get(URL);
		mmtHomePage.click_flightIcon_WE();
		mmtHomePage.click_roundTrip_WE();
		mmtHomePage.click_departure_WE();
		mmtHomePage.fill_fromCity_Input("Delhi");
		Log.endTestCase("TC_01_Verify_MMT_Home_Page");
	}
	
	@AfterTest
	public void closeBrowser() {
		generic.closeBrowser();
	}
}
