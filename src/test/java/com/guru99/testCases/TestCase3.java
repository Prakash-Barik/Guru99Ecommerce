package com.guru99.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.guru99.home.HomePage;
import com.guru99.mobile.MobilePage;

public class TestCase3 {
	//navigate to http://live.guru99.com
	//click on mobile menu
	//In the list of all mobile, click on 'Add cart' for sony experia mobile.
	//change quantity value to  1000 and click on update button.
	//verify the error message.
	//Then click on 'Empty Cart' link in the footer of all lists of mobiles.
	//verify cart is empty.
	
	WebDriver driver;
	HomePage objhp;
	MobilePage objmob;
	String baseURL = "http://live.guru99.com/index.php/";
	
	@BeforeClass
	public void setupBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium_soft\\Driver\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testCase3() throws InterruptedException {
		objhp = new HomePage(driver);
		objhp.clickOnMobileMenu();
		Reporter.log("Clicked on Mobile menu from the Home page", true);
		objmob = new MobilePage(driver);
		objmob.addCart2Xperia();
		Reporter.log("Sony Experia added to the Cart..", true);
		objmob.enterQtyAndUpdate("1000");
		Reporter.log("Updated the quantity value to 1000.", true);
		objmob.verifyErrorMessage();
		Assert.assertEquals(objmob.verifyErrorMessage(), "* The maximum quantity allowed for purchase is 500.");
		objmob.clickEmptycartLink();
		Reporter.log("Clicked on empty cart link", true);
		objmob.verifyShoppingcartemptyMessage();
		Assert.assertTrue(objmob.verifyShoppingcartemptyMessage(), "Shopping Cartis empty message is displayed.");
		Reporter.log("Verified cart is empty", true);
	}

    @AfterClass
    public void tearDown() {
    	driver.quit();;
    }
}

