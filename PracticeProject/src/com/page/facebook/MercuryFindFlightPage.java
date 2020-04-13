package com.page.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MercuryFindFlightPage {
WebDriver driver;
	
	public By rb_oneWay= By.name("oneway");
	public By rb_roundWay= By.name("roundtrip");
	public By select_passengers=By.name("passCount");
	
	public MercuryFindFlightPage(WebDriver driver) {
	this.driver=driver;
	}
	
	
	
	
}
