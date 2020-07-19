package com.share.functions;


import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.touch.TouchActions;

import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.HomePage;
import com.share.objectrepository.ProfilePage;
import com.share.objectrepository.SignInPage;

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


public class ProfileFunctions extends DriverSetUp
{

	String newUserPasscode = mapdata.get("newUserPasscode").toString();
	String newUserPassword = mapdata.get("newUserPassword").toString();
	String existPin = mapdata.get("existingPin").toString();
	String newPin = mapdata.get("newPin").toString();

	GeneralFunctions generalFuntions = new GeneralFunctions();

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
	//Passcode for New user
	public void newUserPass() {

		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		HomePage homePage = new HomePage(driver);
		ProfilePage profilePage =  new ProfilePage(driver);
		generalFuntions.isElementPresent(signInPage.signinPresent, 30);
		signInPage.signinPresent.click();
		generalFuntions.isElementPresent(signInPage.useridElement, 90);
		signInPage.useridElement.sendKeys(newUserPasscode);
		signInPage.userpassElement.sendKeys(newUserPassword);
		signInPage.signinElement.click();
		generalFuntions.isElementPresent(homePage.homeElement, 20);
		homePage.avatarHome.click();
		generalFuntions.isElementPresent(profilePage.paymentMethods, 20);
		profilePage.paymentMethods.click();


	}

	public void setupPassCode(ProfilePage profilePage) {
		profilePage.setupPinCode.click();
	}

	public void setupPassCodeLater(ProfilePage profilePage) {
		profilePage.setupPinCodeLater.click();
	}

	public String toast() {
		String toastMessage = driver.findElement((By.id("snackbar_text"))).getText();
		return toastMessage;
	}

	public void existPin(ProfilePage profilePage) {
		profilePage.setUpPin.sendKeys(existPin);
	}

	public void newPin(ProfilePage profilePage ) {
		profilePage.setUpPin.sendKeys(newPin);
	}
}

