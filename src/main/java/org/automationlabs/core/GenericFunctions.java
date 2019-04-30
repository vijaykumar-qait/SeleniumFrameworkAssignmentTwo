package org.automationlabs.core;

import java.io.File;

import org.automationlabs.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class GenericFunctions extends BaseDriver{
	
	String browerType;
	
	public WebDriver getDriver() {
		System.out.println("driver: " + driver);
		return driver;
	}
	
	public WebDriver StartDriver(String browserType) {
		this.browerType = browserType;
		if(browserType.toLowerCase().equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "." + File.separator + "Resources" + 
					File.separator + "drivers" + File.separator + "chromedriver" + File.separator + "chromedriver.exe");
			this.driver = new ChromeDriver();
			
		}
		else if(browserType.toLowerCase().equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "." + File.separator + "resources" + 
					File.separator + "drivers" + File.separator + "ffdriver" + File.separator + "geckodriver.exe");
			
			this.driver = new FirefoxDriver();
		}
		return this.driver;
	}
	
	public void get(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		Log.info("Get: " + url) ;
	}
	
	public void closeBrowser() {
		driver.quit();
		Log.info("Browser closed");
	}
	
	public boolean isVisible(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
	
	public void Click(By locator) {
		driver.findElement(locator).click();
		Log.info("Element is clicked");
	}
	
	public void Fill_Text(By locator, String value) {
		WebElement element = driver.findElement(locator);
		this.Click(locator);
		element.sendKeys(value);
		Log.info("Filled text " + value);
	}

	public void Mouse_Hover(By locator) {
		Actions actions = new Actions(driver);
		WebElement element = driver.findElement(locator);
		actions.moveToElement(element);
		actions.build().perform();
	}
	
	public String GetText(By locator) {
		return driver.findElement(locator).getText().trim();
	}
	
	public void moveToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element);
		action.perform();
	}
}
