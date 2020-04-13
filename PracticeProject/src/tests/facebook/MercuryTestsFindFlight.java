package tests.facebook;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.page.facebook.MercuryRegisterPage;

import common.WebActions;

public class MercuryTestsFindFlight {
	WebDriver driver;

	@BeforeMethod
	public void initialize() {
		driver=WebActions.getDriver("");
		WebActions.launchUrl(driver, "http://newtours.demoaut.com/");

	}
	@Test
	private void findRoundTrip() {
		
	}
	
	@Test
	private void findOneWay() {
		
	}
	
	
	@AfterMethod
	public void finish() {
		driver.quit();

	}
	
}
