package com.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterInfoPage {

	@FindBy(xpath = "//div[@class='result']")
	private WebElement RegisterHeader;

	public RegisterInfoPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getRegisterHeader() {
		return RegisterHeader;
	}
	
	public String getRegHeader() {
		return RegisterHeader.getText();
	}
	
	
}
