package com.guru99.testCases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.guru99.base.BaseTestClass;
import com.guru99.home.HomePage;
import com.guru99.mobile.MobilePage;

public class TestCase4 extends BaseTestClass {
	/*
	 * go to http://live.guru99.com/.
	 * click on mobile menu. 
	 * In mobile product list, click on 'Add to compare' for 2 mobiles. 
	 * click on 'compare' button. 
	 * verify the popup window and check the products are reflected in it. 
	 * Close the popup window.
	 */
	
	//WebDriver driver;
	HomePage objhp;
	MobilePage objmob;
	//String baseURL = "http://live.guru99.com/index.php/";
	
	/*
	 * @BeforeClass public void setupBrowser() {
	 * System.setProperty("webdriver.chrome.driver",
	 * "E:\\Selenium_soft\\Driver\\chromedriver_win32 (1)\\chromedriver.exe");
	 * driver = new ChromeDriver(); driver.get(baseURL);
	 * driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); }
	 */
	
	@Test
	public void testCase4() throws InterruptedException {
		objhp = new HomePage(driver);
		objhp.clickOnMobileMenu();
		Reporter.log("Clicked on the Mobile menu", true);
		objmob = new MobilePage(driver);
		objmob.addToCompareXperia();
		Reporter.log("Xperia added to the compare list", true);
		objmob.addToCompareIphone();
		Reporter.log("Iphone added to the compare list", true);
		objmob.clickCompareButton();
		Reporter.log("Clicked on compare button after adding the products to compare list.", true);
		objmob.verifyPopupAndCheckReflectedProducts(driver, 20);
		Reporter.log("popup window is displyed and both the products are reflected on it.", true);
		objmob.clickCloseWindowButton();
		Reporter.log("Clicked on Close window button.", true);
	}
	
	/*
	 * @AfterClass public void tearDown() { driver.quit(); }
	 */
}
