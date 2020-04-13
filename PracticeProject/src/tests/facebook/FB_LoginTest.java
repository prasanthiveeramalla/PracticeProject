package tests.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.page.facebook.LoginPage;

import common.WebActions;

public class FB_LoginTest {
	WebDriver driver;
	
	@BeforeMethod
	public void initialize() {		
		driver=WebActions.getDriver("Chrome");
		WebActions.launchUrl(driver, "https://www.facebook.com/");		
	}
	
	
	@Test(priority=1)
	public void fbLoginTest() throws InterruptedException {
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login("prasanthi.v502@gmail.com", "Entrada@1");
		Thread.sleep(5000);
		loginPage.logOut();
	}
	
//	@Test(priority=2,enabled=false)
	public void fbLogOut() {
		LoginPage loginPage=new LoginPage(driver);
		
	}
	
	/*@Test
	public void fbSomeOtherTest() {
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login("prasanthi.v502@gmail.com", "Entrada@1");
		
		
	}*/
	
	@AfterMethod
	public void finish() {
		//quit driver
				driver.quit();
	}

}
