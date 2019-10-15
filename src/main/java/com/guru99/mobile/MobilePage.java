package com.guru99.mobile;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(xpath = "(//a[contains(text(),'Add to Compare')])[1]")
	WebElement addToCompareXperia;
	
	@FindBy(xpath = "(//a[contains(text(),'Add to Compare')])[2]")
	WebElement addToCompareIphone;
	
	@FindBy(xpath = "(//span[contains(text(),'Compare')])[2]")
	WebElement compareBtn;
	
	@FindBy(xpath = "//img[@src=\'http://live.guru99.com/media/catalog/product/cache/1/small_image/125x125/9df78eab33525d08d6e5fb8d27136e95/x/p/xperia.jpg\']")
	WebElement reflectedXperiaImg;
	
	@FindBy(xpath = "//img[@src=\"http://live.guru99.com/media/catalog/product/cache/1/small_image/125x125/9df78eab33525d08d6e5fb8d27136e95/i/p/iphone.png\"]")
	WebElement reflectedIphoneImg;
	
	@FindBy(xpath = "//span[contains(text(),'Close Window')]")
	WebElement closeWindowBtn;
	
	
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
		//Another option is to take the screenshot of the page and verify the sort order.
		
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
	
	public void addToCompareXperia() throws InterruptedException {
		addToCompareXperia.click();
		Thread.sleep(2000);
	}
	
	public void addToCompareIphone() {
		addToCompareIphone.click();
	}
	
	public void clickCompareButton() {
		compareBtn.click();
	}
	
	public boolean reflectedXperia(WebDriver driver, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(reflectedXperiaImg));
				
		return reflectedXperiaImg.isDisplayed();	
	}
	
	public boolean reflectedIphone(WebDriver driver, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(reflectedIphoneImg));
		
		return reflectedIphoneImg.isDisplayed();
	}
	
	public void verifyPopupAndCheckReflectedProducts(WebDriver driver, long time) {
		String mainWindow = driver.getWindowHandle();
		
		//to handle all new opened windows. 
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		
		while(i1.hasNext()) {
			String childWindow = i1.next();
			
			if(!mainWindow.equalsIgnoreCase(childWindow)) 
			{
				driver.switchTo().window(childWindow);
				if(reflectedXperia(driver, time) == true && reflectedIphone(driver, time) == true)
				{
					System.out.println("Both the products are reflected on the window..");
				}	
			}
		}
	} 
	
	public void clickCloseWindowButton() {
		closeWindowBtn.click();
	}
}

