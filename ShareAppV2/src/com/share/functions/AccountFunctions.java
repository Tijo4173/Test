package com.share.functions;


import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.touch.TouchActions;

import com.share.general.DriverSetUp;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.TouchAction;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class AccountFunctions extends DriverSetUp
{
	

	public void RegisterWithMandatoryField()
	{
		
		
		
	}
	
	public String getText(AndroidElement element)
	{
		String text = element.getText();
		return text;
	}
	
	
	public static void LongPress(AndroidElement element)
	{
		
		//AndroidTouchAction touch = new AndroidTouchAction (driver);
		//touch.longPress(LongPressOptions.longPressOptions()
		//.withElement(ElementOption.element (element))).perform ();
		
		TouchAction action = new TouchAction(driver).longPress(longPressOptions().withElement(element(element)).withDuration(Duration.ofMillis(10000))).release().perform();
	}
	
}

