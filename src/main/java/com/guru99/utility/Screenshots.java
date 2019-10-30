package com.guru99.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	static String filePath = "E:\\workspace\\Guru99Ecommerce\\Screenshot\\";
	static WebDriver driver;
	
	public static void takeScreenshot() {
		TakesScreenshot scr = ((TakesScreenshot)driver);
		File srcFile = scr.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy__hh_mm_ss").format(new Date());
		File destFile = new File(filePath+"screenshot"+timeStamp+".png");
		try 
		{
			FileUtils.copyFile(srcFile, destFile);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
