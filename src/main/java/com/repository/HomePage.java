package com.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(linkText = "Register")
	private WebElement RegisterLink;

	public HomePage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getRegisterLink() {
		return RegisterLink;
	}
	
	public void clickOnRegisterLink() {
		RegisterLink.click();
	}
	
	
}
