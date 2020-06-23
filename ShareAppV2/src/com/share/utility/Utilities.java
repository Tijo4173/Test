package com.share.utility;	
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Utilities {

	@Test
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		//below line is just to append the date format with the screenshot name to avoid duplicate names		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		System.out.println(dateName);
		TakesScreenshot ts = (TakesScreenshot) driver;
		System.out.println(ts);
		File source = ts.getScreenshotAs(OutputType.FILE);
		//after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/Screenshots/"+screenshotName+dateName+".png";
		System.out.println(destination);
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		//System.out.println("Utilities");
		//Returns the captured file path
		return destination;
	}





}
