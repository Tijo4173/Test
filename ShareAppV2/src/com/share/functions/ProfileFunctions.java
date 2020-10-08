package com.share.functions;


import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.ExperiencesPage;
import com.share.objectrepository.HomePage;
import com.share.objectrepository.ProfilePage;
import com.share.objectrepository.SignInPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;


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
	public void newUserPass() throws Exception {

		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		HomePage homePage = new HomePage(driver);
		ProfilePage profilePage =  new ProfilePage(driver);
		generalFuntions.isElementPresent(signInPage.signinPresent, 30);
		signInPage.signinPresent.click();
		//generalFuntions.isElementPresent(signInPage.skipUpdate, 2);
		//generalFuntions.skipupdate();
		generalFuntions.isElementPresent(signInPage.useridElement, 90);
		signInPage.useridElement.sendKeys(newUserPasscode);
		signInPage.userpassElement.sendKeys(newUserPassword);
		signInPage.signinElement.click();
		//generalFuntions.isElementPresent(signInPage.skipUpdate, 2);
		//generalFuntions.skipupdate();
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

	public void fingerPrintSwitch() {
		ProfilePage profilePage = new ProfilePage(driver);
		List<MobileElement>switchButton = profilePage.profileFrame.findElementsByClassName("android.view.ViewGroup");
		switchButton.get(10).click();
//		System.out.println("JJJJJJJJJJJJ");
	//AndroidElement switchButton = switches.findElement(By.className("android.widget.Switch")).click();
	}

	public void skipbiometric() throws Exception
	 {

		ProfilePage profilePage = new ProfilePage(driver);
	    Thread.sleep(1000);
		try
		{
		if(generalFuntions.isElementPresent(profilePage.cancelBioinPasscode, 30))
			{
				System.out.println("Biometric Access Asked ");
				profilePage.cancelBioinPasscode.click();
			}else {
				System.out.println("Biometric Access NoT Asked");
			}
			}
			catch(Exception x)
			{
				System.out.println("Biometric Access NoT Asked");
			}
	    }

	public void spayOnboardinskip() throws Exception
	 {
		ExperiencesPage objExperiencesPage = new ExperiencesPage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
	    Thread.sleep(1000);
		try
		{
			//Verify Continue button displayed
			if(objExperiencesPage.OnBoardingContinue.isDisplayed()==true)
			{
				test.log(Status.PASS, "Continue Button Displayed");
				generalFunctions.isElementPresent(objExperiencesPage.OnBoardingContinue, 30);
				objExperiencesPage.OnBoardingContinue.click();
			}
		}
			catch(Exception x)
			{
				System.out.println("OnBoarding Not Displayed, User already seen the onboarding");
			}
	    }

	public void newUserSign() throws Exception {

		SignInPage signInPage = new SignInPage(driver);

		HomePage homePage = new HomePage(driver);

		generalFuntions.isElementPresent(signInPage.signinPresent, 30);
		signInPage.signinPresent.click();
		//generalFuntions.isElementPresent(signInPage.skipUpdate, 2);
		//generalFuntions.skipupdate();
		generalFuntions.isElementPresent(signInPage.useridElement, 90);
		signInPage.useridElement.sendKeys(newUserPasscode);
		signInPage.userpassElement.sendKeys(newUserPassword);
		signInPage.signinElement.click();
		//generalFuntions.isElementPresent(signInPage.skipUpdate, 2);
		//generalFuntions.skipupdate();
		generalFuntions.isElementPresent(homePage.homeElement, 20);
		generalFuntions.isElementPresent(homePage.avatarHome, 10);
		homePage.avatarHome.click();

	}
	
	public void OfferSigin() throws Exception {
		SignInPage signInPage = new SignInPage(driver);
		HomePage homePage = new HomePage(driver);
		generalFuntions.isElementPresent(signInPage.signinPresent, 30);
		signInPage.signinPresent.click();
		//generalFuntions.isElementPresent(signInPage.skipUpdate, 2);
		//generalFuntions.skipupdate();
		generalFuntions.isElementPresent(signInPage.useridElement, 90);
		signInPage.useridElement.sendKeys(newUserPasscode);
		signInPage.userpassElement.sendKeys(newUserPassword);
		signInPage.signinElement.click();
		//generalFuntions.isElementPresent(signInPage.skipUpdate, 2);
		//generalFuntions.skipupdate();
		generalFuntions.isElementPresent(homePage.homeElement, 20);
	}
}

