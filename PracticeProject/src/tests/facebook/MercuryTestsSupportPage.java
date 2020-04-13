package tests.facebook;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.page.facebook.MercurySupportPage;

import common.WebActions;

public class MercuryTestsSupportPage {
	
	WebDriver driver;
	@BeforeMethod
	public void initialize() {
		driver=WebActions.getDriver("Chrome");
		WebActions.launchUrl(driver, "http://newtours.demoaut.com/");
		
	}
	
	@Test (priority=1)
	public void testSupportPage()
	{
		MercurySupportPage page=new MercurySupportPage(driver);
		page.verifySupportPage();
	}
	@Test (priority=2)
	public void verifyBackToHome()
	{
		MercurySupportPage page=new MercurySupportPage(driver);
		page.goBackToHome();
	}
	@Test (groups= "A")
	public void TestGroupA1() 
	{
		System.out.println("Test A Group1");
	}
	@Test (groups= "A")
	public void TestGroupA2() 
	{
		System.out.println("Test A Group2");
	}
	@Test (groups= "B")
	public void TestGroupB1() 
	{
		System.out.println("Test B Group1");
	}
	@Test (groups= "B")
	public void TestGroupB2() 
	{
		System.out.println("Test B Group2");
	}
	@Test (groups= {"A" , "B"})
	public void TestGroupC()
	{
		System.out.println("Test C Group");
	}
	
	@AfterMethod
	public void Finish() {
		driver.quit();
	}
}
