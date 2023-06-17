package com.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	@FindBy(xpath = "//h1[.='Register'")
	private WebElement RegPageInfo;

	@FindBy(id = "gender-male")
	private WebElement GenderMale;

	@FindBy(id = "gender-female")
	private WebElement GenderFemale;

	@FindBy(id = "FirstName")
	private WebElement FirstNameTextField;

	@FindBy(id = "LastName")
	private WebElement LastNameTextField;

	@FindBy(id = "Email")
	private WebElement EmailTextField;

	@FindBy(id = "Password")
	private WebElement PasswordTextField;

	@FindBy(id = "ConfirmPassword")
	private WebElement CPasswordTextField;

	@FindBy(id = "register-button")
	private WebElement RegisterBtn;

	public RegisterPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getGenderMale() {
		return GenderMale;
	}

	public WebElement getGenderFemale() {
		return GenderFemale;
	}

	public WebElement getRegPageInfo() {
		return RegPageInfo;
	}

	public WebElement getFirstNameTextField() {
		return FirstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return LastNameTextField;
	}

	public WebElement getEmailTextField() {
		return EmailTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getCPasswordTextField() {
		return CPasswordTextField;
	}

	public WebElement getRegisterBtn() {
		return RegisterBtn;
	}

	public void register(String GENDER, String FirstName, String LastName, String Email, String Password,
			String CPassword) {
		if (GENDER.equalsIgnoreCase("male")) {
			GenderMale.click();
		} else if (GENDER.equalsIgnoreCase("female")) {
			GenderFemale.click();
		}
		FirstNameTextField.sendKeys(FirstName);
		LastNameTextField.sendKeys(LastName);
		EmailTextField.sendKeys(Email);
		PasswordTextField.sendKeys(Password);
		CPasswordTextField.sendKeys(CPassword);
		RegisterBtn.sendKeys(Keys.ENTER);
	}

	public String getRegPageHeader() {
		return RegPageInfo.getText();
	}

}
