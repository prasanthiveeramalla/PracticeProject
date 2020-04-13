package tests.facebook;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.page.facebook.MercuryRegisterPage;

import common.Utilites;
import common.WebActions;

public class MercuryTestsRegisterPage {

	public String valueFirstName="MercuryF";
	public String valueLastName= "MercuryL";
	public String valuePhone="876-876-2345";
	public String valueEmail="Mercury1@yopmail.com";
	
	public String valueAddress="Somajiguda";
	public String valueCity= "Hyderabad";
	public String valueState="Telengana";
	public String valuePostalCode="500050";
	public String valueDDCountry="";
	
	public String valueUserName="Mercury1";
	public String valuePassword= "Mercury1@3";
	public String valueConfirmPassword= "Mercury1@3";
	
	public WebDriver driver;
	@BeforeMethod
	public void initialize() {
		driver=WebActions.getDriver("Chrome");
		WebActions.launchUrl(driver, "http://newtours.demoaut.com/");
	}
	
	@Test
	private void RegisterUserTest() throws InterruptedException {
		MercuryRegisterPage page=new MercuryRegisterPage(driver);
		
		page.createUser(valueFirstName, valueLastName, valuePhone, valueEmail, valueAddress, valueCity, valueState, valuePostalCode, valueDDCountry, valueUserName, valuePassword, valueConfirmPassword);
		//String actualText=	WebActions.getText(driver, valueUserName);
			//Utilites.Assert(actualText.trim(), text_note.trim(), "verifed value");
	
	}
	
	
	@AfterMethod
	private void finish() {
		// TODO Auto-generated method stub
		driver.quit();
	}
	
	
}
