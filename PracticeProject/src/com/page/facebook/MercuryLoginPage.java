package com.page.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import common.WebActions;

public class MercuryLoginPage {
	WebDriver driver;
	
	public By inputUserName= By.name("userName");
	public By inputPassword= By.name("password");
	public By btnLogin= By.name("login");
	public By btnLogOut= By.xpath("//a[text()='SIGN-OFF']");
	public By fieldHomePage= By.xpath("//img[contains(@src, 'findflight.gif')]");
	public By fiel=By.id("");
	
	
	public MercuryLoginPage(WebDriver driver) {
		this.driver=driver;
	}

	public void Login(String userName, String password) {
		WebActions.sendKeys(driver, inputUserName, "mercury");
		WebActions.sendKeys(driver, inputPassword, "mercury");
		WebActions.click(driver, btnLogin);
	}
	
	public void LogOut() {
		WebActions.click(driver, btnLogOut);
	}
	public void verifyHomePage() {
		WebActions.verifyElementExists(driver, fieldHomePage);
	}
}
