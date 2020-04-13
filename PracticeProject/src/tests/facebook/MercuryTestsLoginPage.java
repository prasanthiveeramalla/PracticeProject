package tests.facebook;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.page.facebook.MercuryLoginPage;

import common.ExcelDataRead;
import common.WebActions;

public class MercuryTestsLoginPage {
	
	WebDriver driver;

	@BeforeMethod
	public void initialize() {
		driver=WebActions.getDriver("");
		WebActions.launchUrl(driver, "http://newtours.demoaut.com/");

	}
	
	@Test
	public void mercuryLoginTest() {
		
		MercuryLoginPage mercury= new MercuryLoginPage(driver);
		mercury.Login("mercury","mercury");
		mercury.LogOut();
	}
	
	/*@Test 
	@Parameters ({"sUsername", "sPassword"})
	public void mercuryLoginTest(String sUsername, String sPassword) {
		
		MercuryLoginPage mercury= new MercuryLoginPage(driver);
		mercury.Login(sUsername,sPassword);
		mercury.LogOut();
	}
	
	 @DataProvider(name = "Authentication")
	  public static Object[][] credentials() {

	        return new Object[][] { { "mercury", "mercury" }, { "mercury", "mercury" }};

	  }

	
	@Test (dataProvider= "Authentication")
	public void mercuryLoginTest(String sUsername, String sPassword) {
		
		MercuryLoginPage mercury= new MercuryLoginPage(driver);
		mercury.Login(sUsername,sPassword);
		mercury.LogOut();
	}
	
	@Test 
	public void mercuryLoginTest() throws IOException {
		
		MercuryLoginPage mercury= new MercuryLoginPage(driver);
		//ExcelDataRead obj=new ExcelDataRead("./src/testdata/Practice.xlsx")
	//	mercury.Login(obj.getdata("Sheet1", 2, 1),sPassword);
			//Object[][] arr = ExcelDataRead.readExcelSheetData();
			mercury.Login(ExcelDataRead.readExcelSheetData(2,1),ExcelDataRead.readExcelSheetData(2,2));
		mercury.LogOut();
	}
	*/
	
	
	
	@AfterMethod
	public void finish() {
		driver.quit();

	}
	
}
