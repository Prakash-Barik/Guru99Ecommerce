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

public class TestCase1 {
	/*
	 * go to, http://live.guru99.com/.
	 * verify title of the page. 
	 * click on the 'Mobile' menu. verify title of the page. 
	 * In the list of mobiles, select 'SORT
	 * BY' drop down as 'name'. verify all products are sorted by name.
	 */
	WebDriver driver;
	HomePage objhp;
	MobilePage objMob;
	String baseUrl = "http://live.guru99.com/index.php/";
	
	@BeforeClass
	public void browserSetup()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium_soft\\Driver\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void testCase1() throws InterruptedException
	{
		objhp = new HomePage(driver);
		Assert.assertEquals(objhp.verifyPageTitle(), "Home page");
		Reporter.log("Home page title verified..", true);
		objhp.clickOnMobileMenu();
		Assert.assertEquals(objhp.verifyPageTitleAfterClickingMobile(), "Mobile");
		Reporter.log("Mobile page title verified..", true);
		objMob = new MobilePage(driver);
		objMob.sortMobileByName();
		Reporter.log("Mobiles are sorted by Name...yet to verify.", true);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
}
