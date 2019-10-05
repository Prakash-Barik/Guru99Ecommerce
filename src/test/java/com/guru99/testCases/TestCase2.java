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

public class TestCase2 {
	/*
	 * go to live.guru99.com 
	 * click on mobile menu 
	 * In the list of mobiles, read the cost on Sony experia and note the value
	 * click on sony experia mobile
	 * read the sony experia mobile from the details page. 
	 * compare the value in step.3 & step.5
	 */
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
	public void testCase2() throws InterruptedException {
		objhp = new HomePage(driver);
		objhp.clickOnMobileMenu();
		Reporter.log("Clicked on the Mobile menu", true);
		objmob = new MobilePage(driver);
		objmob.readCostOfXperiaOnHomePage();
		Reporter.log("Cost of Sony Experia on Home page is : "+ objmob.readCostOfXperiaOnHomePage());
		objmob.clickOnSonyExperia();
		objmob.readDetailsPriceOfXperia();
		Reporter.log("Cost of Sone Experia on Details page is : "+ objmob.readDetailsPriceOfXperia());
		Assert.assertEquals(objmob.readCostOfXperiaOnHomePage(), objmob.readDetailsPriceOfXperia());
		Reporter.log("Price of Sony Experia on Home page & Details is $100", true);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	
	

}
