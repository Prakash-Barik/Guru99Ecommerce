package com.guru99.tv;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TVPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "(//a[contains(text(),'Add to Wishlist')])[1]")
	WebElement LGlcdAddtoWishlistBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Share Wishlist')]")
	WebElement shareWishlistBtn;
	
	@FindBy(id = "email_address")
	WebElement shareEmailAddressField;
	
	@FindBy(id = "message")
	WebElement shareMessageField;
	
	@FindBy(xpath = "//span[contains(text(),'Share Wishlist')]")
	WebElement mainShareWishlistBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Your Wishlist has been shared.')]")
	WebElement wishlistSharedMsg;
	
	public TVPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addLGtoWishList() {
		LGlcdAddtoWishlistBtn.click();
	}
	
	public void shareWishList() throws InterruptedException {
		shareWishlistBtn.click();
		Thread.sleep(1500);
	}
	
	public void enterShareEmailAddress(String sEmail) { 
		shareEmailAddressField.sendKeys(sEmail);
	}
	
	public void enterShareMessage(String sMsg) {
		shareMessageField.sendKeys(sMsg);
	}
	
	public void shareFinalWishlist() {
		mainShareWishlistBtn.click();
	}
	
	public String verifyMessageAfterSharingWishlist() {
	String sucessSharedMsg = wishlistSharedMsg.getText();
	return sucessSharedMsg;
	}
}

