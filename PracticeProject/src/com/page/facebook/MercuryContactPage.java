package com.page.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.Utilites;
import common.WebActions;

public class MercuryContactPage {

	public  String text_note="This section of our web site is currently under construction.";
	
	public By linkContact=By.xpath("//a[contains(text(),'CONTACT')]");
	public By filedHomePage= By.xpath("//img[contains(@src,'findflight.gif')]");
	public By buttonHome=By.xpath("//img[contains(@src,'home.gif')]");
	public By fieldContactMessage=By.xpath("//tr[@valign='top']//font/b/font[1]");

	private WebDriver driver;

	public MercuryContactPage(WebDriver driver) {
		this.driver=driver;
	}

	public void verifyContactPage() {
		WebActions.click(driver, linkContact);
	    String actualText=	WebActions.getText(driver, fieldContactMessage);
		Utilites.Assert(actualText.trim(), text_note.trim(), "verifed value");
	}

	public void goBackToHome() {
		WebActions.click(driver, buttonHome);
	}




}
