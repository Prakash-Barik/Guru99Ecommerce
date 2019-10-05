package com.guru99.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MobilePage {
	WebDriver driver;
	
	@FindBy(xpath = "(//a[@title='IPhone'])[1]")
	WebElement iPhone;
	
	@FindBy(xpath = "(//a[@title='Samsung Galaxy'])[1]")
	WebElement samsungGalaxy;
	
	@FindBy(id = "product-collection-image-1")
	WebElement xperia;
	
	@FindBy(xpath = "//span[contains(text(),'$100.00')]")
	WebElement xperiaPrice;
	
	@FindBy(xpath = "(//span[contains(text(),'Add to Cart')])[1]")
	WebElement xperiaAddtocart;
	
	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement qtyField;
	
	@FindBy(xpath = "(//span[contains(text(),'Update')])[3]")
	WebElement updateBtn;
	
	@FindBy(xpath = "//p[@class='item-msg error']")
	WebElement errorMsg;
	
	@FindBy(xpath = "//span[contains(text(),'Empty Cart')]")
	WebElement emptycartLink;
	
	@FindBy(xpath = "//h1[contains(text(),'Shopping Cart is Empty')]")
	WebElement shoppingcartemptyMessage;
	
	
	public MobilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void sortMobileByName() {
		Select dropdown = new Select(driver.findElement(By.xpath("(//select[@title='Sort By'])[1]")));
		dropdown.selectByVisibleText("Name");
	}
	
	public void verifyAllProductsSortedByName() {
		//ArrayList<String> obtainedList = new ArrayList<>();
		//driver.findElements(by)
		
	}
	
	public String readCostOfXperiaOnHomePage() {
		String price = xperiaPrice.getText();
		System.out.println("The cost of sony experia is : "+ price);
		return price;
	}
	
	public void clickOnSonyExperia() {
		xperia.click();
	}
	
	public String readDetailsPriceOfXperia() {
		WebElement priceDetails = driver.findElement(By.xpath("//span[contains(text(),'$100.00')]"));
		String priceDeatilsText = priceDetails.getText();
		return priceDeatilsText;
	}
	
	public void addCart2Xperia() throws InterruptedException {
		xperiaAddtocart.click();
		Thread.sleep(2000);
	}
	
	public void enterQtyAndUpdate(String qty){
		qtyField.sendKeys(qty);
		updateBtn.click();
	}
	
	public String verifyErrorMessage() {
		String errormsg = errorMsg.getText();
		return errormsg;
	}
	
	public void clickEmptycartLink() {
		emptycartLink.click();
	}
	
	public boolean verifyShoppingcartemptyMessage() {
		return shoppingcartemptyMessage.isDisplayed();
	}
	
	
	
	
}
