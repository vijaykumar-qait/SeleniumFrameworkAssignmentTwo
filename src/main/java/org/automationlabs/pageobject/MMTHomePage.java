package org.automationlabs.pageobject;

import org.automationlabs.core.GenericFunctions;
import org.automationlabs.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MMTHomePage {

	WebDriver driver;
	GenericFunctions generic;
	 
	
	public MMTHomePage(WebDriver driver, GenericFunctions generic) {
		this.driver = driver;
		this.generic = generic;
	}
	
	By flightIcon_WE = By.xpath("//span[contains(@class,'chFlights')]");
	By roundTrip_WE = By.xpath("//li[text()='Round Trip']/span");
	By fromCity_Txt = By.id("fromCity");
	By fromCity_Input = By.xpath("//input[@placeholder=\"From\"]");
	
	By toCity_Txt = By.id("toCity");
	By toCity_Input = By.xpath("//input[@placeholder=\"To\"]");
	
	By departure_WE = By.xpath("//label[@for='departure']");
	
	By return_WE = By.xpath("//label[@for='return']");
	
	By search_Lnk = By.linkText("Search");
	
	public void click_flightIcon_WE() {
		generic.Click(flightIcon_WE);
		Log.info("Clicked flightIcon_WE");
	}
	
	public void click_roundTrip_WE() {
		generic.Click(roundTrip_WE);
		Log.info("Clicked roundTrip_WE");
	}
	
	public void click_fromCity_Txt() {
		generic.Click(fromCity_Txt);
		Log.info("Clicked fromCity_Txt");
	}
	
	public void fill_fromCity_Input(String city) {
		generic.Fill_Text(fromCity_Input, city);
		Log.info("Filled " + city + " in fromCity_Input");
	}
	
	public void click_toCity_Txt() {
		generic.Click(toCity_Txt);
		Log.info("Clicked toCity_Txt");
	}
	
	public void fill_toCity_Input(String city) {
		generic.Fill_Text(toCity_Input, city);
		Log.info("Filled " + city + " in toCity_Input");
	}
	
	public void click_departure_WE() {
		generic.Click(departure_WE);
		Log.info("Clicked departure_WE");
	}
	
	public void click_return_WE() {
		generic.Click(return_WE);
		Log.info("Clicked return_WE");
	}
	
	public void click_search_Lnk() {
		generic.Click(search_Lnk);
		Log.info("Clicked search_Lnk");
	}
	
	public void click_date_WE(String date) {
		//String date = "Fri Apr 26 2019";
		By date_WE = By.xpath("//div[@aria-label=\""+date+"\"]");
		generic.Click(date_WE);
		Log.info("Clicked date_WE");
	}
	
	public void click_departureDate_WE() {
		click_date_WE("");
	}
	
	public void click_returnDate_WE() {
		click_date_WE("");
	}
}

