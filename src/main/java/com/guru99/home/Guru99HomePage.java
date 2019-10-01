package com.guru99.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Guru99HomePage {
	WebDriver driver;
	@FindBy(xpath = "//a[contains(text(),'Mobile')]")
	WebElement mobileLink;
	
	@FindBy(xpath = "//a[contains(text(),'TV')]")
	WebElement tVlink;
	
	@FindBy(xpath = "//span[contains(text(),'Account')]")
	WebElement accountLink;
	
	@FindBy(xpath = "//span[contains(text(),'Cart')]")
	WebElement cartLink;
	
	@FindBy(css = "input[id='search']")
	WebElement searchField;
	
	@FindBy(css = "input[type='email']")
	WebElement newsletterField;
	
	@FindBy(xpath = "//span[contains(text(),'Subscribe')]")
	WebElement subscribeBttn;
	
	@FindBy(xpath = "//p[contains(text(),'Default welcome msg! ')]")
	WebElement welcomeMsg;
	
	

}
