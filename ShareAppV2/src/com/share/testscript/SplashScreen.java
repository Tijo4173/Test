package com.share.testscript;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.share.functions.RegistrationFunctions;
import com.share.functions.SplashScreenFunctions;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.general.GeneralFunctions.Directions;
import com.share.objectrepository.RegistrationPage;
import com.share.objectrepository.SplashScreenPage;

public class SplashScreen extends DriverSetUp {

	GeneralFunctions generalFunctions = new GeneralFunctions();

	@Test
	public void TC_SplashScreen_001_002(Method method) {
		try{
			String Tc_method = method.getName();
			test = extent.createTest(Tc_method);
			test.log(Status.INFO, "Scenario:Splash Screen").assignCategory("REGISTRATION");
			test.log(Status.INFO, "TestCase:Verify carousel screen is able to swipe");
			driver.resetApp();
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			splashScreenFunctions.splashScreenSkip(splashScreenPage);
			if(generalFunctions.isElementPresent(registrationPage.onboardScreen, 10)) {
				test.log(Status.PASS, "The Onboard screen displayed");
			for(int i=0;i<=3;i++) {
				Directions dir = Directions.LEFT;
				System.out.println("Enum");
				generalFunctions.swipeScreen(dir);
			}
				if(generalFunctions.isElementPresent(registrationPage.onboardScrolld, 30)){
				test.log(Status.PASS, "The Carousel Last Screen displayed ");
				//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			}else {
				test.log(Status.FAIL, "The Carousel screen is not able to swipe");
			}
			}else {
				test.log(Status.FAIL, "The Onboard screen not present");
			}

			if(generalFunctions.isElementPresent(registrationPage.onboardScrolld, 30)) {
				test.log(Status.PASS, "The Last screen displayed");
			for(int i=0;i<=3;i++) {
				Directions dir = Directions.RIGHT;
				System.out.println("Enum");
				generalFunctions.swipeScreen(dir);
			}
				if(generalFunctions.isElementPresent(registrationPage.onboardScrolla, 30)){
				test.log(Status.PASS, "The Carousel First Screen displayed ");
				//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			}else {
				test.log(Status.FAIL, "The Carousel screen is not able to swipe");
			}
			}else {
				test.log(Status.FAIL, "The Last screen not present");
			}
		}catch(Exception e){
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());
		}
	}
/*
	@Test
	public void TC_002_003_SplashScreen(Method method) {

		try{
			String Tc_method = method.getName();
			test = extent.createTest(Tc_method);
			test.log(Status.INFO, "Scenario:Splash Screen");
			test.log(Status.INFO, "TestCase:Verify user is displayed the country drop down with country and user can select the United Arab Emirate");
			test.assignCategory("SplashScreen");
			driver.resetApp();
			//driver.activateApp("com.maf.android.share");
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashscreenPage = new SplashScreenPage(driver);
			GeneralFunctions generalFunctions = new GeneralFunctions();
			generalFunctions.isElementPresent(splashscreenPage.splashScreen, 90);
			Thread.sleep(5000);
			if(splashscreenPage.splashLanguage.isDisplayed()) {
				test.log(Status.PASS, "The Language selection screen is displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, Tc_method));
				splashscreenPage.splashLanguage.click();
			}else {
				test.log(Status.FAIL, "The Language selection screen NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, Tc_method));
			}
			if(splashscreenPage.splashCountry.isDisplayed()) {
				test.log(Status.PASS, "The Country selection screen is displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, Tc_method));
				splashscreenPage.splashCountry.click();
				splashscreenPage.splashDone.click();
			}else {
				test.log(Status.FAIL, "The Country selection screen NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, Tc_method));
			}

			if(registrationPage.startElement.isDisplayed()) {
				test.log(Status.PASS, "The Explore screen is displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, Tc_method));

			}else {
				test.log(Status.FAIL, "The Explore screen NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, Tc_method));
			}
		}catch(Exception e){
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());
		}

	}
	*/


public void splashScreenSkip() {
	driver.resetApp();
	SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
	SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
	splashScreenFunctions.splashScreenSkip(splashScreenPage);
}

}
