package common;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.cigniti.automation.accelerators.Select;
import com.cigniti.automation.accelerators.WebElement;

public class WebActions {
	
	public static WebDriver getDriver(String browser) {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void launchUrl(WebDriver driver,String url) {
		Reporter.log("Luanching the URL:="+url, true);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		 
		wait.until(webDriver -> ((JavascriptExecutor)webDriver).executeScript("return document.readyState").equals("complete"));
		 
		//driver.get("https://www.softwaretestinghelp.com");

		driver.get(url);
	}
	public static void click(WebDriver driver,By locator) {
		Reporter.log("Click on element with locator:="+locator.toString(), true);
		new WebDriverWait(driver, 60).until(abc ->((JavascriptExecutor) abc ).executeScript("return document.readyState").equals("complete"));
		driver.findElement(locator).click();
	}
	
	public static void sendKeys(WebDriver driver,By locator, String value) {
		Reporter.log("Entering value:="+value+" in the element with locator:="+locator.toString());
		new WebDriverWait(driver, 60).until(abc ->((JavascriptExecutor) abc ).executeScript("return document.readyState").equals("complete"));
		driver.findElement(locator).sendKeys(value);
	}
	
	public static String  getText(WebDriver driver, By locator) {
		Reporter.log("Get text is: "+locator.toString());
		new WebDriverWait(driver, 60).until(abc ->((JavascriptExecutor) abc ).executeScript("return document.readyState").equals("complete"));
		return driver.findElement(locator).getText();
	  
	}
	
	
	public static void verifyElementExists(WebDriver driver, By locator) {
		Reporter.log("Element exists: "+locator.toString());
		new WebDriverWait(driver, 60).until(abc ->((JavascriptExecutor) abc ).executeScript("return document.readyState").equals("complete"));
		 driver.findElement(locator);
	}

	public static boolean gf_SelectByValue(WebDriver driver, By locator, String value) {
		Select dropDown = new Select(driver.findElement(objLocator));           

		List<WebElement> Options = dropDown.getOptions();
		for(WebElement option:Options)
		{
	}
	
}
