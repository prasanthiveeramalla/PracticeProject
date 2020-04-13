package com.page.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import common.WebActions;

public class LoginPage {
	WebDriver driver;
	public By inputEmailId=By.id("email");
	public By inputPassword=By.id("pass");
	public By buttonLogin=By.id("u_0_b");//loginbutton
	public By dropDownMenu=By.xpath("//div[@id='logoutMenu']");
	public By buttonLogout=By.id("u_13_3");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
		
	public void login(String emailId,String password) {
		Reporter.log("I am Logging into the FB page.",true);
		WebActions.sendKeys(driver, inputEmailId, emailId);
		WebActions.sendKeys(driver, inputPassword, password);
		WebActions.click(driver, buttonLogin);	
	}
	
	public void logOut() throws InterruptedException {
		//Logout
		Reporter.log("I am clicking logout", true);
		WebActions.click(driver, dropDownMenu);
		Thread.sleep(5000);
		WebActions.click(driver, buttonLogout);
	}

}
