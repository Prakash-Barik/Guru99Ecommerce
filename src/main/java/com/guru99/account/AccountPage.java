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
	
	@FindBy(css = "[type='checkbox']")
	WebElement signupNewsletterChkbox;
	
	@FindBy(className = "back-link")
	WebElement backLink;
	
	@FindBy(xpath = "//span[contains(text(),'Register')]")
	WebElement registerBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Thank you for registering with Main Website Store.')]")
	WebElement registrationSuccessMsg;
	
	@FindBy(css = "div.validation-advice")
	WebElement emailRequiredError;
	
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
	
	public void enterMiddleName(String mName) {
		middleNameTxtField.clear();
		middleNameTxtField.sendKeys(mName);
	}
	
	public void enterLastName(String lName) {
		lastNameTextField.clear();
		lastNameTextField.sendKeys(lName);
	}
	
	public void enterEmailAddress(String email) {
		emailAddressField.clear();
		emailAddressField.sendKeys(email);
	}
	
	public void enterPassword(String pswd) {
		passwordField.clear();
		passwordField.sendKeys(pswd);
	}
	
	public void confirmPassword(String confPswd) {
		confirmPasswordField.clear();
		confirmPasswordField.sendKeys(confPswd);
	}
	
	public void signupForNewsletter() {
		signupNewsletterChkbox.click();
	}
	
	public void clickRegisterButton() {
		registerBtn.click();
	}
	
	public void registerWithoutEmailId(String fName, String mName, String lName, String pswd, String confPswd) {
		enterFirstName(fName);
		enterMiddleName(mName);
		enterLastName(lName);
		enterPassword(pswd);
		confirmPassword(confPswd);
		clickRegisterButton();
	}
	
	public String verifyRegistrationMessageWithoutEmail() {
    	String requiredErrorMsg = emailRequiredError.getText();
		return requiredErrorMsg;
	}
    
	
	public void registerWithEmailId(String fName, String mName, String lName, String email, String pswd, String confPswd) {
		enterFirstName(fName);
		enterMiddleName(mName);
		enterLastName(lName);
		enterEmailAddress(email);
		enterPassword(pswd);
		confirmPassword(confPswd);
		signupForNewsletter();
		clickRegisterButton();
	}
	
	 public String verifyRegistrationWithEmail() {
	    	String registrationSuccessMessage = registrationSuccessMsg.getText();
	    	return registrationSuccessMessage;
	    }
}


