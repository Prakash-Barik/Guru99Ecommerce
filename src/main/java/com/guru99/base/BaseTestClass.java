package com.guru99.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTestClass {
	public WebDriver driver;
	String baseUrl = "http://live.guru99.com/index.php/";
	
	@BeforeClass
	public void browserSetup() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium_soft\\Driver\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
