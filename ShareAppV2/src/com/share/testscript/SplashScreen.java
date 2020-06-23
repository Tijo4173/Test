package com.share.testscript;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.share.functions.RegistrationFunctions;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.RegistrationPage;
import com.share.objectrepository.SplashScreenPage;
import com.share.utility.Utilities;

public class SplashScreen extends DriverSetUp {


	@Test
	public void TC_001_SplashScreen(Method method) {
		try{
			String Tc_method = method.getName();
			test = extent.createTest(Tc_method);
			test.log(Status.INFO, "Scenario:Splash Screen");
			test.log(Status.INFO, "TestCase:Verify user is displayed four Carousel Screens is displayed and Swipe");
			test.assignCategory("Registration");
			//driver.resetApp();
			/*driver.activateApp("com.maf.sharesit");
			driver.resetApp();
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			driver.activateApp("om.maf.android.share");*/
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			generalFunctions.isElementPresent(registrationPage.onboardScreen, 90);
			//	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			registrationFunctions.onboardScreenDisplayed(registrationPage);
			//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//	registrationFunctions.onBoardScroll(registrationPage);
				if(registrationFunctions.lastScrollScreen(registrationPage)==true) {
				test.log(Status.PASS, "The Carousel Screen is able to swipe");
				//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			}else {
				test.log(Status.FAIL, "The Carousel screen is not able to swipe");
			} 
		}catch(Exception e){
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());
		}
	}



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


}
