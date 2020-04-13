package com.page.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.Utilites;
import common.WebActions;

public class MercurySupportPage {
	
	public  String text_note="This section of our web site is currently under construction.";

	public By linkSupport=By.xpath("//a[contains(text(),'SUPPORT')]");
	public By filedHomePage= By.xpath("//img[contains(@src, 'findflight.gif')]");
	public By buttonHome=By.xpath("//img[contains(@src, 'home.gif')]");
	public By fieldSupportMessage=By.xpath("//tr[@valign='top']//font/b/font[1]");

	private WebDriver driver;


	public MercurySupportPage(WebDriver driver) {
		this.driver=driver;
	}
	
	

	public void verifySupportPage() {
		WebActions.click(driver, linkSupport);
		//WebActions.verifyText(driver, fieldSupportMessage, text_note.trim());
		  String actualText=	WebActions.getText(driver, fieldSupportMessage);
			Utilites.Assert(actualText, text_note.trim(), "verifed value");
	}

	public void goBackToHome() {
		WebActions.click(driver, linkSupport);
		WebActions.click(driver, buttonHome);
	}




}
