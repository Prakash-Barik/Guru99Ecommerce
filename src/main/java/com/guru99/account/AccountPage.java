package com.guru99.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	WebDriver driver;
	
	@FindBy(xpath = "//span[contains(text(),'Create an Account')]")
	WebElement createAccountBtn;
	
	@FindBy(id = "email")
	WebElement loginEmailField;
	
	@FindBy(id = "pass")
	WebElement loginPasswordField;
	
	@FindBy(xpath = "//a[contains(text(),'Forgot Your Password?')]")
	WebElement forgotPasswordLink;
	
	@FindBy(id = "send2")
	WebElement loginBtn;
	
	@FindBy(id = "firstname")
	WebElement firstnameTxtField;
	
	@FindBy(id = "middlename")
	WebElement middleNameTxtField;
	
	@FindBy(id = "lastname")
	WebElement lastNameTextField;
	
	@FindBy(id = "email_address")
	WebElement emailAddressField;
	
	@FindBy(id = "password")
	WebElement passwordField;
	
	@FindBy(id = "confirmation")
	WebElement confirmPasswordField;
	
	@FindBy(css = "//input[type='checkbox']")
	WebElement signupNewsletterChkbox;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickCreateAccountButton() {
		createAccountBtn.click();
	}
	
	public void enterFirstName(String fName) {
		firstnameTxtField.clear();
		firstnameTxtField.sendKeys(fName);
	}
	
	
	
	

}
