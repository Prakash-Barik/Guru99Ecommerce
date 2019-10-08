package com.guru99.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy(xpath = "//a[contains(text(),'Mobile')]")
	WebElement mobileMenu;
	
	@FindBy(xpath = "//a[contains(text(),'TV')]")
	WebElement tVlMenu;
	
	@FindBy(xpath = "//span[contains(text(),'Account')]")
	WebElement accountMenu;
	
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
	
	@FindBy(xpath = "(//a[contains(text(),'My Account')])[2]")
	WebElement myaccountLink;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public void clickOnMobileMenu() throws InterruptedException {
		mobileMenu.click();
		Thread.sleep(2000);
	}
	
	public String verifyPageTitleAfterClickingMobile() {
		String mobilePageTitle = driver.getTitle();
		return mobilePageTitle;
	}
	
	public void clickMyAccountLink() {
		myaccountLink.click();
	}

}

