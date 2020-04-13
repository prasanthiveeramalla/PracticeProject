package com.page.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.Utilites;
import common.WebActions;

public class MercuryRegisterPage {
	
	public By linkRegister= By.xpath("//a[contains(text(),'REGISTER')]");
			
	public By fieldFirstName=By.name("firstName");
	public By fieldLastName= By.name("lastName");
	public By fieldPhone=By.name("phone");
	public By fieldEmail=By.name("userName");

	
	public By fieldAddress=By.name("address1");
	public By fieldCity= By.name("city");
	public By fieldState=By.name("state");
	public By fieldPostalCode=By.name("postalCode");
	public By DDCountry=By.name("//tr[@valign='top']//font/b/font[1]");
	
	public By fieldUserName=By.name("email");
	public By fieldPassword= By.name("password");
	public By fieldConfirmPassword= By.name("confirmPassword");
	
	public By fieldSuccessNotePart1=By.xpath("//b[contains(text(),'Note: Your user name is')]");
	public By fieldSuccessNotePart2=By.xpath("//b[contains(text(),'lbnagar");

	public By fieldMailContent=By.xpath("//font[contains(text(),'Thank you for registering.')]");
	
	
	public By getMailContent=By.xpath("//table//td[2]//table//tr[4]//table//tr[3]");
	
	public By buttonSubmit=By.name("register");
	
	public String RP_UserNameVal="Note: Your user name is";
	
	
	private WebDriver driver;
	
	public MercuryRegisterPage(WebDriver driver){
		this.driver=driver;
	}
	
	
	public void createUser(String FName, String LName, String phone, String email, String address, String city,String state,String postalCode,String DDCountry,String userName, String password,String confirmPassword ) throws InterruptedException {
		WebActions.click(driver, linkRegister);
		Thread.sleep(2000);
		WebActions.sendKeys(driver, fieldFirstName, FName);
		WebActions.sendKeys(driver, fieldLastName, LName);
		WebActions.sendKeys(driver, fieldPhone, phone);
		WebActions.sendKeys(driver, fieldEmail, email);
		WebActions.sendKeys(driver, fieldAddress, address);
		
		WebActions.sendKeys(driver, fieldLastName, city);
		WebActions.sendKeys(driver, fieldPhone, state);
		WebActions.sendKeys(driver, fieldEmail, postalCode);
		//WebActions.sendKeys(driver, fieldAddress, DDCountry);//change to DD
		
		
		WebActions.sendKeys(driver, fieldUserName, userName);
		WebActions.sendKeys(driver, fieldPassword, password);
		WebActions.sendKeys(driver, fieldConfirmPassword, confirmPassword);
		
		WebActions.click(driver, buttonSubmit);
		
		WebActions.verifyElementExists(driver, fieldMailContent);
		
		WebActions.verifyElementExists(driver, fieldSuccessNotePart1);
		
		 String actualText=	WebActions.getText(driver, getMailContent);
			Utilites.AssertContains(actualText.trim(), RP_UserNameVal, "verifed value");
	
	}
	
}
