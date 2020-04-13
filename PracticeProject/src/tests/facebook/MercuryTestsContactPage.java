package tests.facebook;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.page.facebook.MercuryContactPage;
import com.page.facebook.MercurySupportPage;

import common.WebActions;

public class MercuryTestsContactPage {
WebDriver driver;
	@BeforeClass
	public void initialize() {
		driver=WebActions.getDriver("Chrome");
		WebActions.launchUrl(driver, "http://newtours.demoaut.com/");
		
	}
	
	@Test (priority=1)
	public void testsContactPage() {
		MercuryContactPage page= new MercuryContactPage(driver);
		page.verifyContactPage();
	}
	
	@Test (priority=2)
	public void verifyBackToHome()
	{
		MercuryContactPage page=new MercuryContactPage(driver);
		page.goBackToHome();
	}
	
	@AfterClass
	public void Finish() {
		driver.quit();
	}
}
