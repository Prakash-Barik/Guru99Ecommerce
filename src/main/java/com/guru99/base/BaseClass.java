package com.guru99.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	public void ExpliWaitUntilElementToBeClickableByElement(WebDriver driver, long time, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void ExpliWaitUntilElementToBeClickableByLocator() {
		
	}

}
