package com.guru99.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Mobile {
	WebDriver driver;
	
	@FindBy(xpath = "(//a[@title='IPhone'])[1]")
	WebElement iPhone;
	
	@FindBy(xpath = "(//a[@title='Samsung Galaxy'])[1]")
	WebElement samsungGalaxy;
	
	@FindBy(id = "product-collection-image-1")
	WebElement xperia;
	
	public Mobile(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void sortMobileByName() {
		Select dropdown = new Select(driver.findElement(By.xpath("(//select[@title='Sort By'])[1]")));
		dropdown.selectByVisibleText("Name");
	}
	
	public void verifyAllProductsSortedByName() {
		
		
	}

}
