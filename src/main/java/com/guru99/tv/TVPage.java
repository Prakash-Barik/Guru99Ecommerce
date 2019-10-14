package com.guru99.tv;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TVPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "(//a[contains(text(),'Add to Wishlist')])[1]")
	WebElement LGlcdAddtoWishlist;
	
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
	
	
	

}
