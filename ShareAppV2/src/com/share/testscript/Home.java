package com.share.testscript;

import java.io.IOException;
import java.lang.reflect.Method;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.share.functions.HomeFunctions;
import com.share.functions.RegistrationFunctions;
import com.share.functions.SignInFunctions;
import com.share.functions.SplashScreenFunctions;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.HomePage;
import com.share.objectrepository.RegistrationPage;
import com.share.objectrepository.SignInPage;
import com.share.objectrepository.SplashScreenPage;
import com.share.utility.Utilities;

import bsh.util.Util;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;

public class Home extends DriverSetUp{




	@Test//Verify curve header: Verify UserProfile name,Points Balance, Aed,Avtar
	public void TC_Home_001(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify curve header: Verify UserProfile name,Points Balance, Aed,Avtar");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		//driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			if(homePage.userName.isDisplayed()) {
				test.log(Status.PASS, "Profile name is displayed: "+homePage.userName.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else {
				test.log(Status.FAIL, "Profile name is not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Profile name is not displayed");
			}
			if(homePage.pointsBalance.isDisplayed()) {
				test.log(Status.PASS, "Points Balance is displayed: "+homePage.pointsBalance.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else {
				test.log(Status.FAIL, "Points Balance is not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Points Balance is not displayed");
			}
			if(homePage.avatarHome.isDisplayed()) {
				test.log(Status.PASS, "Avatar is displayed: "+homePage.avatarHome.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else {
				test.log(Status.FAIL, "Avatar is not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Avatar is not displayed");
			}
			if(homePage.pointsAed.isDisplayed()) {
				test.log(Status.PASS, "Points in AED is displayed: "+homePage.pointsAed.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else {
				test.log(Status.FAIL, "Points in AED is not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Profile name is not displayed");
			}
			if(homePage.pointshome.isDisplayed()) {
				test.log(Status.PASS, "Points is displayed: "+homePage.pointshome.getText());
			}else {
				test.log(Status.FAIL, "Points is not displayed");
				Assert.fail("Points is not displayed");
			}

		}catch(Exception e) {
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}

	@Test//TC:Verify below curve headers:Submit reciept,Share ID,My Family, Share your points
	public void TC_Home_002(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify below curve headers:Submit reciept,Share ID,My Family, Share your points");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			if(homePage.receiptCamera.isDisplayed()) {
				test.log(Status.PASS, "Submit Receipt is displayed: "+homePage.receiptCamera.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else {
				test.log(Status.FAIL, "Submit Receipt is not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Submit Receipt  is not displayed");
			}
			if(homePage.homeShareId.isDisplayed()) {
				test.log(Status.PASS, "Share ID is displayed: "+homePage.homeShareId.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else {
				test.log(Status.FAIL, "Share ID is not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Share ID is not displayed");
			}
			if(homePage.myFamily.isDisplayed()) {
				test.log(Status.PASS, "My Family is displayed: "+homePage.myFamily.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else {
				test.log(Status.FAIL, "My Family is not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("My Family  is not displayed");
			}
			if(homePage.pointshome.isDisplayed()) {
				test.log(Status.PASS, "Share your points is displayed: "+homePage.pointshome.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else {
				test.log(Status.FAIL, "Share your points is not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Share your points is not displayed");
			}

		}catch(Exception e) {
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}



	@Test//TC:Verify user should view tutorial on clicking Submit receipt and Camera permissions
	public void TC_Home_003_005_051(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user should view tutorial on clicking Submit receipt and Camera permissions");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);

			homeFunctions.receiptCameraClick(homePage);
			//generalFunctions.isElementPresent(accountPage.accountReceipt, 90);
			//accountFunctions.receiptScan(accountPage);

			//Thread.sleep(4000);
			//Verify Skip Button is Present
			generalFunctions.isElementPresent(homePage.introInfo, 90);
			if(homePage.introSkip.isDisplayed()==true)
			{
				test.log(Status.PASS, "Submit Receipt Camera Intro Skip Button is Present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Submit Receipt Camera with Intro Skip Button is Not Present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Submit Receipt Camera with Intro Skip Button is Not Present");
			}

			generalFunctions.isElementPresent(homePage.introNext, 90);
			if(homePage.introNext.isDisplayed()==true)
			{
				test.log(Status.PASS, "Submit Receipt Camera with Intro Next Button is Present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Submit Receipt Receipt Camera with Intro Next Button is Not Present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Submit Receipt Camera Have Intro Next Button is Not Present");
			}

			generalFunctions.isElementPresent(homePage.introNext, 90);
			homeFunctions.introDone(homePage);
			Thread.sleep(6000);
			//			homeFunctions.allowtoAccess(homePage);
			//			Thread.sleep(6000);
			generalFunctions.isElementPresent(homePage.introInfo, 90);
			if(homePage.introInfo.isDisplayed()==true)
			{
				test.log(Status.PASS, "Submit Receipt Camera with IntroInfo icon is Present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Submit Receipt Camera with IntroInfo icon is Not Present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Submit Receipt Camera Have IntroInfo icon is Not Present");
			}

			generalFunctions.isElementPresent(homePage.introInfo, 90);
			homePage.introInfo.click();
			Thread.sleep(8000);
			homeFunctions.introDone(homePage);

			generalFunctions.isElementPresent(homePage.normalReceiptButton, 90);
			if(homePage.normalReceiptButton.isDisplayed()==true)
			{
				test.log(Status.PASS, "NormalReceipt Scan Button is Present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "NormalReceipt Scan Button is Not  Present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("NormalReceipt Scan Button is Not Present");
			}
			Thread.sleep(7000);
			generalFunctions.isElementPresent(homePage.longReceiptButton, 90);
			if(homePage.longReceiptButton.isDisplayed()==true)
			{
				test.log(Status.PASS, "LongReceipt Scan Button is Present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "LongReceipt Scan Button is Not Present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("LongReceipt Scan Button is Not Present");
			}
			Thread.sleep(7000);
			generalFunctions.isElementPresent(homePage.buttonCaptureClick, 90);
			if(homePage.buttonCaptureClick.isDisplayed()==true)
			{
				test.log(Status.PASS, "Capture Receipt Button is Present");
			}
			else
			{
				test.log(Status.FAIL, "Capture Receipt Button is Not Present");
				Assert.fail("Capture Receipt Button is Not Present");
			}	



		}catch(Exception e) {

			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}


	}

	@Test//TC:Verify user can skip the tutorial by clicking on skip button in tutorials in receipt submit screen
	public void TC_Home_053(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can skip the tutorial by clicking on skip button in tutorials in receipt submit screen");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);

			homeFunctions.receiptCameraClick(homePage);
			//generalFunctions.isElementPresent(accountPage.accountReceipt, 90);
			//accountFunctions.receiptScan(accountPage);

			//Thread.sleep(4000);
			//Verify Skip Button is Present
			generalFunctions.isElementPresent(homePage.introInfo, 90);
			if(homePage.introSkip.isDisplayed()==true)
			{
				test.log(Status.PASS, "Submit Receipt Camera Intro Skip Button is Present");
			}
			else
			{
				test.log(Status.FAIL, "Submit Receipt Camera with Intro Skip Button is Not Present");
				Assert.fail("Submit Receipt Camera with Intro Skip Button is Not Present");
			}

			generalFunctions.isElementPresent(homePage.introNext, 90);
			if(homePage.introNext.isDisplayed()==true)
			{
				test.log(Status.PASS, "Submit Receipt Camera with Intro Next Button is Present");
			}
			else
			{
				test.log(Status.FAIL, "Submit Receipt Receipt Camera with Intro Next Button is Not Present");
				Assert.fail("Submit Receipt Camera Have Intro Next Button is Not Present");
			}

			generalFunctions.isElementPresent(homePage.introSkip, 90);
			homePage.introSkip.click();
			Thread.sleep(6000);
			homeFunctions.allowtoAccess(homePage);
			Thread.sleep(6000);
			generalFunctions.isElementPresent(homePage.introInfo, 90);
			if(homePage.introInfo.isDisplayed()==true)
			{
				test.log(Status.PASS, "Submit Receipt Camera with IntroInfo icon is Present");
			}
			else
			{
				test.log(Status.FAIL, "Submit Receipt Camera with IntroInfo icon is Not Present");
				Assert.fail("Submit Receipt Camera Have IntroInfo icon is Not Present");
			}

		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}



	@Test//TC:Verify user can selected dont show  in Intro Screen
	public void TC_Home_004(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can selected dont show  in Intro Screen");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);

			homeFunctions.receiptCameraClick(homePage);
			//generalFunctions.isElementPresent(accountPage.accountReceipt, 90);
			//accountFunctions.receiptScan(accountPage);

			//Thread.sleep(4000);
			//Verify Skip Button is Present
			generalFunctions.isElementPresent(homePage.introInfo, 90);
			if(homePage.introCheckbox.isDisplayed()==true)
			{
				test.log(Status.PASS, "Submit Receipt Camera Intro Dont show again Button is Present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Submit Receipt Camera with Intro Dont show again is Not Present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Submit Receipt Camera with Intro Skip Button is Not Present");
			}

			generalFunctions.isElementPresent(homePage.introNext, 90);
			homeFunctions.introDone(homePage);
			Thread.sleep(6000);
			homeFunctions.allowtoAccess(homePage);
			Thread.sleep(6000);
			generalFunctions.isElementPresent(homePage.introInfo, 90);
			if(homePage.introInfo.isDisplayed()==true)
			{
				test.log(Status.PASS, "Submit Receipt Camera with IntroInfo icon is Present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Submit Receipt Camera with IntroInfo icon is Not Present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Submit Receipt Camera Have IntroInfo icon is Not Present");
			}

			generalFunctions.isElementPresent(homePage.introInfo, 90);
			homePage.cameraClose.click();
			Thread.sleep(8000);

			generalFunctions.isElementPresent(homePage.homeElement, 90);
			if(homePage.receiptCamera.isDisplayed()==true)
			{
				test.log(Status.PASS, "Displayed the Home Screen").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Not displayed the Home screen").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Not displayed the Home screen");
			}
			homePage.receiptCamera.click();

			Thread.sleep(7000);
			generalFunctions.isElementPresent(homePage.buttonCaptureClick, 90);
			if(homePage.buttonCaptureClick.isDisplayed()==true)
			{
				test.log(Status.PASS, "Navigates to Camera");
			}
			else
			{
				test.log(Status.FAIL, "Not Navigates to Camera");
				Assert.fail("Not Navigates to Camera");
			}	



		}catch(Exception e) {

			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}


	}

	@Test//TC:Verify user should be able to click normal receipt
	public void TC_Home_006(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user should be able to click normal receipt");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);

			homeFunctions.receiptCameraClick(homePage);

			generalFunctions.isElementPresent(homePage.introInfo, 90);
			if(homePage.normalReceiptButton.isDisplayed()==true)
			{

				homePage.normalReceiptButton.click();
				test.log(Status.PASS, "Normal Receipt scanning is active").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Normal Receipt scanning is Not active").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Normal Receipt scanning is Not active");
			}

		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}

	}



	@Test//TC:Verify user should be able to click Long receipt
	public void TC_Home_007(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user should be able to click Long receipt");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);

			homeFunctions.receiptCameraClick(homePage);

			generalFunctions.isElementPresent(homePage.introInfo, 90);
			if(homePage.longReceiptButton.isDisplayed()==true)
			{

				homePage.longReceiptButton.click();
				test.log(Status.PASS, "Long Receipt scanning is active");
			}
			else
			{
				test.log(Status.FAIL, "Long Receipt scanning is Not active");
				Assert.fail("Long Receipt scanning is Not active");
			}

		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}



	}


	@Test//TC:Verify user should not be able to upload more than 10 images
	public void TC_Home_008(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user should not be able to upload more than 10 images");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		//splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);

			homeFunctions.receiptCameraClick(homePage);

			generalFunctions.isElementPresent(homePage.introInfo, 90);
			if(homePage.longReceiptButton.isDisplayed()==true)
			{

				homePage.longReceiptButton.click();
				test.log(Status.PASS, "Long Receipt scanning is active");
			}
			else
			{
				test.log(Status.FAIL, "Long Receipt scanning is Not active");
				Assert.fail("Long Receipt scanning is Not active");
			}
			homePage.longReceiptButton.click();
			generalFunctions.isElementPresent(homePage.buttonCaptureClick, 90);
			homeFunctions.moreClick(homePage);
			generalFunctions.toastMessages();
			String toast = "You can take maximum of 10 images";
			if(generalFunctions.toastMessages().contains(toast)) {
				test.log(Status.PASS, "The error message is displayed: "+toast);
			}else {
				test.log(Status.FAIL, "The eroro message not dispalyed");
			}
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}



	}



	@Test//TC:Verify user can retake the images using Long receipt
	public void TC_Home_009(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can retake the images using long receipt");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		//splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);

			homeFunctions.receiptCameraClick(homePage);

			generalFunctions.isElementPresent(homePage.introInfo, 90);
			if(homePage.longReceiptButton.isDisplayed()==true)
			{


				test.log(Status.PASS, "Long Receipt scanning is active");
				homePage.longReceiptButton.click();
			}
			else
			{
				test.log(Status.FAIL, "Long Receipt scanning is Not active");
				Assert.fail("Long Receipt scanning is Not active");
			}

			generalFunctions.isElementPresent(homePage.buttonCaptureClick, 90);
			homePage.buttonCaptureClick.click();
			homePage.buttonCaptureClick.click();
			if(homePage.previewSubmit.isDisplayed()) {
				test.log(Status.PASS, "The error message is displayed");
				homePage.previewSubmit.click();
			}else {
				test.log(Status.FAIL, "The eroro message not dispalyed");
			}
			generalFunctions.isElementPresent(homePage.submitReceipt, 90);
			if(homePage.submitReceipt.isDisplayed()) {
				test.log(Status.PASS, "The Submit receipt screen displayed");

			}else {
				test.log(Status.FAIL, "The Submit Receipt screen is not displayed");
			}
			generalFunctions.isElementPresent(homePage.previewRetake, 90);
			homePage.previewRetake.click();
			generalFunctions.isElementPresent(homePage.introInfo, 90);
			if(homePage.longReceiptButton.isDisplayed()==true)
			{


				test.log(Status.PASS, "Long Receipt scanning is active");
			}
			else
			{
				test.log(Status.FAIL, "Long Receipt scanning is Not active");
				Assert.fail("Long Receipt scanning is Not active");
			}
			homePage.buttonCaptureClick.click();
			homePage.buttonCaptureClick.click();
			if(homePage.previewSubmit.isDisplayed()) {
				test.log(Status.PASS, "The error message is displayed");
				homePage.previewSubmit.click();
			}else {
				test.log(Status.FAIL, "The eroro message not dispalyed");
			}
			generalFunctions.isElementPresent(homePage.submitReceipt, 90);
			if(homePage.submitReceipt.isDisplayed()) {
				test.log(Status.PASS, "The Submit receipt screen displayed");

			}else {
				test.log(Status.FAIL, "The Submit Receipt screen is not displayed");
			}
			if(homePage.submitReceipt.isDisplayed()) {
				test.log(Status.PASS, "The Submit receipt screen displayed");

			}else {
				test.log(Status.FAIL, "The Submit Receipt screen is not displayed");
			}
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}



	}


	@Test//TC:Verify user can retake the images using Normal receipt
	public void TC_Home_010(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can retake the images using Normal receipt");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		//splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);

			homeFunctions.receiptCameraClick(homePage);

			generalFunctions.isElementPresent(homePage.introInfo, 90);
			if(homePage.normalReceiptButton.isDisplayed()==true)
			{


				test.log(Status.PASS, "Normal Receipt scanning is active");

			}
			else
			{
				test.log(Status.FAIL, "Normal Receipt scanning is Not active");
				Assert.fail("Long Receipt scanning is Not active");
			}

			generalFunctions.isElementPresent(homePage.buttonCaptureClick, 90);
			homePage.buttonCaptureClick.click();
			homePage.buttonCaptureClick.click();

			generalFunctions.isElementPresent(homePage.submitReceipt, 90);
			if(homePage.submitReceipt.isDisplayed()) {
				test.log(Status.PASS, "The Submit receipt screen displayed");

			}else {
				test.log(Status.FAIL, "The Submit Receipt screen is not displayed");
			}
			generalFunctions.isElementPresent(homePage.previewRetake, 90);
			homePage.previewRetake.click();
			generalFunctions.isElementPresent(homePage.introInfo, 90);
			if(homePage.normalReceiptButton.isDisplayed()==true)
			{


				test.log(Status.PASS, "Normal Receipt scanning is active");
			}
			else
			{
				test.log(Status.FAIL, "Normal Receipt scanning is Not active");
				Assert.fail("Long Receipt scanning is Not active");
			}
			homePage.buttonCaptureClick.click();
			homePage.buttonCaptureClick.click();

			generalFunctions.isElementPresent(homePage.submitReceipt, 90);
			if(homePage.submitReceipt.isDisplayed()) {
				test.log(Status.PASS, "The Submit receipt screen displayed");

			}else {
				test.log(Status.FAIL, "The Submit Receipt screen is not displayed");
			}
			if(homePage.submitReceipt.isDisplayed()) {
				test.log(Status.PASS, "The Submit receipt screen displayed");

			}else {
				test.log(Status.FAIL, "The Submit Receipt screen is not displayed");
			}
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}




	@Test//TC:Verify user can click on cancel button to exit the receipt scanning
	public void TC_Home_011(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can click on cancel button to exit the receipt scanning");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		//splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);

			homeFunctions.receiptCameraClick(homePage);

			generalFunctions.isElementPresent(homePage.introInfo, 90);
			if(homePage.normalReceiptButton.isDisplayed()==true)
			{


				test.log(Status.PASS, "Normal Receipt scanning is active");

			}
			else
			{
				test.log(Status.FAIL, "Normal Receipt scanning is Not active");
				Assert.fail("Normal Receipt scanning is Not active");
			}

			generalFunctions.isElementPresent(homePage.buttonCaptureClick, 90);

			homePage.cameraClose.click();
			generalFunctions.isElementPresent(homePage.homeElement, 90);	
			if(homePage.homeElement.isDisplayed()) {
				test.log(Status.PASS, "The Home screen displayed");
			}else {
				test.log(Status.FAIL, "The Home screen not displayed");
			}

		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}

	}

	@Test//TC:Verify user can exit the receipt scanning by tapping on Cancel button
	public void TC_Home_012(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can exit the receipt scanning by tapping on Cancel button");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		//splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);

			homeFunctions.receiptCameraClick(homePage);

			generalFunctions.isElementPresent(homePage.introInfo, 90);

			if(homePage.longReceiptButton.isDisplayed()==true)
			{
				test.log(Status.PASS, "Normal Receipt scanning is active");
				homePage.longReceiptButton.click();

			}
			else
			{
				test.log(Status.FAIL, "Normal Receipt scanning is Not active");
				Assert.fail("Normal Receipt scanning is Not active");
			}

			generalFunctions.isElementPresent(homePage.buttonCaptureClick, 90);

			homePage.cameraClose.click();
			generalFunctions.isElementPresent(homePage.homeElement, 90);	
			if(homePage.homeElement.isDisplayed()) {
				test.log(Status.PASS, "The Home screen displayed");
			}else {
				test.log(Status.FAIL, "The Home screen not displayed");
			}

		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}

	}



	@Test//TC:Verify user can discard the images of Normal receipt
	public void TC_Home_013(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can discard the images of Normal receipt");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		//splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);

			homeFunctions.receiptCameraClick(homePage);

			generalFunctions.isElementPresent(homePage.introInfo, 90);
			if(homePage.normalReceiptButton.isDisplayed()==true)
			{


				test.log(Status.PASS, "Normal Receipt scanning is active");

			}
			else
			{
				test.log(Status.FAIL, "Normal Receipt scanning is Not active");
				Assert.fail("Long Receipt scanning is Not active");
			}

			generalFunctions.isElementPresent(homePage.buttonCaptureClick, 90);
			homePage.buttonCaptureClick.click();
			homePage.buttonCaptureClick.click();

			generalFunctions.isElementPresent(homePage.submitReceipt, 90);
			if(homePage.submitReceipt.isDisplayed()) {
				test.log(Status.PASS, "The Submit receipt screen displayed");

			}else {
				test.log(Status.FAIL, "The Submit Receipt screen is not displayed");
			}
			generalFunctions.isElementPresent(homePage.previewClose, 90);
			homePage.previewClose.click();
			generalFunctions.isElementPresent(homePage.popDiscard, 90);
			if(homePage.popDiscard.isDisplayed()==true)
			{
				test.log(Status.PASS, "Pop Discard message is dispalyed");
				homePage.popDiscard.click();
			}
			else
			{
				test.log(Status.FAIL, "Pop Discard message not dispalyed");
				Assert.fail("Pop Discard message not dispalyed");
			}
			generalFunctions.isElementPresent(homePage.buttonCaptureClick, 90);

			if(homePage.buttonCaptureClick.isDisplayed()) {
				test.log(Status.PASS, "Discard the captured images");

			}else {
				test.log(Status.FAIL, "Not Discard the captured images");
			}

		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}



	@Test//TC:Verify user can discard the images of long receipt
	public void TC_Home_014(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can discard the images of long receipt");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		//splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);

			homeFunctions.receiptCameraClick(homePage);

			generalFunctions.isElementPresent(homePage.introInfo, 90);
			if(homePage.normalReceiptButton.isDisplayed()==true)
			{


				test.log(Status.PASS, "Normal Receipt scanning is active");

			}
			else
			{
				test.log(Status.FAIL, "Normal Receipt scanning is Not active");
				Assert.fail("Long Receipt scanning is Not active");
			}

			generalFunctions.isElementPresent(homePage.buttonCaptureClick, 90);
			homePage.buttonCaptureClick.click();
			homePage.buttonCaptureClick.click();

			generalFunctions.isElementPresent(homePage.previewSubmit, 90);
			if(homePage.previewSubmit.isDisplayed()) {
				test.log(Status.PASS, "The preview button button displayed");
				homePage.previewSubmit.click();

			}else {
				test.log(Status.FAIL, "The Submit Receipt screen is not displayed");
			}

			generalFunctions.isElementPresent(homePage.submitReceipt, 90);
			if(homePage.submitReceipt.isDisplayed()) {
				test.log(Status.PASS, "The Submit receipt screen displayed");

			}else {
				test.log(Status.FAIL, "The Submit Receipt screen is not displayed");
			}
			generalFunctions.isElementPresent(homePage.previewClose, 90);
			homePage.previewClose.click();
			generalFunctions.isElementPresent(homePage.popDiscard, 90);
			if(homePage.popDiscard.isDisplayed()==true)
			{
				test.log(Status.PASS, "Pop Discard message is dispalyed");
				homePage.popDiscard.click();
			}
			else
			{
				test.log(Status.FAIL, "Pop Discard message not dispalyed");
				Assert.fail("Pop Discard message not dispalyed");
			}
			generalFunctions.isElementPresent(homePage.buttonCaptureClick, 90);

			if(homePage.buttonCaptureClick.isDisplayed()) {
				test.log(Status.PASS, "Discard the captured images");

			}else {
				test.log(Status.FAIL, "Not Discard the captured images");
			}

		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}


	@Test//TC:Verify user can submit long receipt
	public void TC_Home_015(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can submit long receipt");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		//splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);

			homeFunctions.receiptCameraClick(homePage);

			generalFunctions.isElementPresent(homePage.introInfo, 90);
			if(homePage.normalReceiptButton.isDisplayed()==true)
			{


				test.log(Status.PASS, "Normal Receipt scanning is active");

			}
			else
			{
				test.log(Status.FAIL, "Normal Receipt scanning is Not active");
				Assert.fail("Long Receipt scanning is Not active");
			}

			generalFunctions.isElementPresent(homePage.buttonCaptureClick, 90);
			homePage.buttonCaptureClick.click();
			homePage.buttonCaptureClick.click();

			generalFunctions.isElementPresent(homePage.previewSubmit, 90);
			if(homePage.previewSubmit.isDisplayed()) {
				test.log(Status.PASS, "The preview button button displayed");
				homePage.previewSubmit.click();

			}else {
				test.log(Status.FAIL, "The Submit Receipt screen is not displayed");
			}

			generalFunctions.isElementPresent(homePage.submitReceipt, 90);
			if(homePage.submitReceipt.isDisplayed()) {
				test.log(Status.PASS, "The Submit receipt screen displayed");

			}else {
				test.log(Status.FAIL, "The Submit Receipt screen is not displayed");
			}
			generalFunctions.isElementPresent(homePage.submitReceipt, 90);
			homePage.submitReceipt.click();
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			if(homePage.homeElement.isDisplayed()) {

				test.log(Status.PASS, "The Receipt submitted Successfully");


			}else {
				test.log(Status.FAIL, "The Receipt not submitted");
			}


		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}	




	@Test//TC:Verify user can submit normal receipt
	public void TC_Home_016(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can submit normal receipt");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		//splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);

			homeFunctions.receiptCameraClick(homePage);

			generalFunctions.isElementPresent(homePage.introInfo, 90);
			if(homePage.longReceiptButton.isDisplayed()==true)
			{


				test.log(Status.PASS, "Normal Receipt scanning is active");

			}
			else
			{
				test.log(Status.FAIL, "Normal Receipt scanning is Not active");
				Assert.fail("Long Receipt scanning is Not active");
			}
			homePage.longReceiptButton.click();
			generalFunctions.isElementPresent(homePage.buttonCaptureClick, 90);
			homePage.buttonCaptureClick.click();
			homePage.buttonCaptureClick.click();

			generalFunctions.isElementPresent(homePage.previewSubmit, 90);
			if(homePage.previewSubmit.isDisplayed()) {
				test.log(Status.PASS, "The preview button button displayed");
				homePage.previewSubmit.click();

			}else {
				test.log(Status.FAIL, "The Submit Receipt screen is not displayed");
			}

			generalFunctions.isElementPresent(homePage.submitReceipt, 90);
			if(homePage.submitReceipt.isDisplayed()) {
				test.log(Status.PASS, "The Submit receipt screen displayed");

			}else {
				test.log(Status.FAIL, "The Submit Receipt screen is not displayed");
			}
			generalFunctions.isElementPresent(homePage.submitReceipt, 90);
			homePage.submitReceipt.click();
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			if(homePage.homeElement.isDisplayed()) {

				test.log(Status.PASS, "The Receipt submitted Successfully");


			}else {
				test.log(Status.FAIL, "The Receipt not submitted");
			}


		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}	


	@Test//TC:Verify user should be able to click normal receipt
	public void TC_Home_056(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user should be able to click normal receipt");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);

			homeFunctions.receiptCameraClick(homePage);

			generalFunctions.isElementPresent(homePage.introInfo, 90);
			if(homePage.normalReceiptButton.isDisplayed()==true)
			{

				test.log(Status.PASS, "Normal Receipt scanning button is active");
			}
			else
			{
				test.log(Status.FAIL, "Normal Receipt scanning button is Not active");
				Assert.fail("Normal Receipt scanning button is Not active");
			}

		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}



	}

	@Test//TC:Verify user can view the receipt tutorial by clicking on the i button in receipt scanning screen 
	public void TC_Home_064(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can view the receipt tutorial by clicking on the i button in receipt scanning screen");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		//driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);

			homeFunctions.receiptCameraClick(homePage);

			generalFunctions.isElementPresent(homePage.introInfo, 90);
			homePage.introInfo.click();

			if(homePage.introNext.isDisplayed()==true)
			{

				test.log(Status.PASS, "Tutorial Screen displayed");
			}
			else
			{
				test.log(Status.FAIL, "Tutorial Screen NOT displayed");
				Assert.fail("Tutorial Screen NOT displayed");
			}

		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}

	}



	/////////////////********SHARE_ID**************////////////***************
	@Test//TC:Verify user clicks on SHARE ID
	public void TC_Home_017(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user clicks on SHARE ID");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		//splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			homePage.homeElement.click();

			generalFunctions.isElementPresent(homePage.homeShareId, 90);
			if(homePage.homeShareId.isDisplayed()==true)
			{


				test.log(Status.PASS, "Share ID button displayed");

			}
			else
			{
				test.log(Status.FAIL, "Share ID button NOT displayed");
				Assert.fail("Share ID button NOT displayed");
			}
			homePage.homeShareId.click();

			generalFunctions.isElementPresent(homePage.homeBarcode, 90);

			if(homePage.homeBarcode.isDisplayed()) {
				test.log(Status.PASS, "Share ID Number displayed: "+homePage.homeBarcode.getText());
			}
			test.log(Status.FAIL, "Share ID Number not displayed");


		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}


	@Test//TC:Verify user able to view SHOP ONLINE & EARN SHARE POINTS section in the home screen 
	public void TC_Home_065(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user able to view SHOP ONLINE & EARN SHARE POINTS section in the home screen");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			if(homePage.homeShopEarn.isDisplayed()) {
				test.log(Status.PASS, "The SHOP ONLINE & EARN SHARE POINTS is PRESETNT: "+homePage.homeShopEarn.getText());

			}else {
				test.log(Status.FAIL, "The SHOP ONLINE & EARN SHARE POINTS is NOT present");
			}

		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");

		}

	}



	@Test//TC:Verify user able to switch between the ‘Experiences’ and ‘Updates’ tabs in the home screen. 
	public void TC_Home_067(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user able to switch between the ‘Experiences’ and ‘Updates’ tabs in the home screen.");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			if(homePage.homeExperiences.isDisplayed()) {
				homePage.homeUpdates.click();
				test.log(Status.PASS, "Update Button is clickable").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));

			}else {
				test.log(Status.FAIL, "Update Button is not Clickable").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			if(homePage.homeUpdates.isDisplayed()) {
				homePage.homeExperiences.click();
				test.log(Status.PASS, "Experiences Button is clickable");

			}else {
				test.log(Status.FAIL, "Experiences Button is not Clickable");
			}

		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");

		}

	}

	@Test//TC:Verify the app tabs: Home,Experiences,SharePay,Assistant,Account. 
	public void TC_Home_080(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify the app tabs: Home,Experiences,SharePay,Assistant,Account");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			if(homePage.homeElement.isDisplayed()) {

				test.log(Status.PASS, "Home Tab is PRESENT").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));

			}else {
				test.log(Status.FAIL, "Home Tab is NOT PRESENT").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			if(homePage.shareExperiencesTab.isDisplayed()) {

				test.log(Status.PASS, "Experiences Tab is PRESENT").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));

			}else {
				test.log(Status.FAIL, "Experiences Tab is NOT PRESENT").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			if(homePage.sharePayTab.isDisplayed()) {

				test.log(Status.PASS, "SharePay Tab is PRESENT").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));

			}else {
				test.log(Status.FAIL, "SharePay Tab is NOT PRESENT").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			if(homePage.shareAssistantTab.isDisplayed()) {

				test.log(Status.PASS, "Assistant Tab is PRESENT").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));

			}else {
				test.log(Status.FAIL, "Assistant Tab is NOT PRESENT").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			if(homePage.shareAccountTab.isDisplayed()) {

				test.log(Status.PASS, "Account Tab is PRESENT");

			}else {
				test.log(Status.FAIL, "Account Tab is NOT PRESENT");
			}


		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");

		}

	}



	@Test//TC:Verify user can click on See all 
	public void TC_Home_068(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can click on See all on Experiences Screen");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);

			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"	SEE ALL\").instance(0))")).click();	
			generalFunctions.isElementPresent(homePage.shareExperiencesTab, 90);
			if(homePage.shareExperiencesTab.isDisplayed()) {
				test.log(Status.PASS, "The Experiences Screen displayed");
			}else {
				test.log(Status.FAIL, "The Experiences Screen NOT displayed");
			}

		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");

		}

	}

	@Test//TC:Verify user can click on Share Your Points and able to share points
	public void TC_Home_070(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can click on Share Your Points");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		//driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			homePage.homeSharePoints.click();
			generalFunctions.isElementPresent(homePage.homePointsBalance, 90);
			homePage.homePointsField.sendKeys("10");
			homePage.homePointsEmail.sendKeys("test@gmail.com");
			homePage.homePointsSubmit.click();
			if(homePage.homeElement.isDisplayed()) {
				test.log(Status.PASS, "");
			}else {
				test.log(Status.FAIL, "");
			}

		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}


	}


	@Test//TC:Verify the error message is displaying when we input points if the user points is Zero
	public void TC_Home_071(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify the error message is displaying when we input points if the user points is Zero");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			homePage.homeSharePoints.click();
			generalFunctions.isElementPresent(homePage.homePointsBalance, 90);
			homePage.homePointsField.sendKeys("10");
			homePage.homePointsEmail.sendKeys("test@gmail.com");
			homePage.homePointsSubmit.click();
			if(homePage.homePointsError.isDisplayed()) {
				test.log(Status.PASS, "Error message is displayed: "+homePage.homePointsError.getText());
			}else {
				test.log(Status.FAIL, "Error message not displayed");
			}

		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}

	@Test//TC:Verify the validations of points and email fields
	public void TC_Home_072(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify the validations of points and email fields");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			homePage.homeSharePoints.click();
			generalFunctions.isElementPresent(homePage.homePointsBalance, 90);
			homePage.homePointsField.sendKeys("-10");
			homePage.homePointsEmail.sendKeys("test@gmaail.com");
			homePage.homePointsSubmit.click();
			if(homePage.homePointsError.isDisplayed()) {
				test.log(Status.PASS, "Error message is displayed: "+homePage.homePointsError.getText());
			}else {
				test.log(Status.FAIL, "Error message not displayed");
			}
			if(homePage.homePointsEmailError.isDisplayed()) {
				test.log(Status.PASS, "Error message is displayed: "+homePage.homePointsEmailError.getText());
			}else {
				test.log(Status.FAIL, "Error message not displayed");
			}
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}


	}


	@Test//TC:Verify all the titles are present in the Share Your Points screen
	public void TC_Home_073(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify all the titles are present in the Share Your Points screen");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			homePage.homeSharePoints.click();
			generalFunctions.isElementPresent(homePage.homePointsBalance, 90);
			homePage.homePointsField.sendKeys("-10");
			homePage.homePointsEmail.sendKeys("test@gmaail.com");
			homePage.homePointsSubmit.click();
			if(homePage.homePointsBalance.isDisplayed()) {
				test.log(Status.PASS, "Error message is displayed: "+homePage.homePointsBalance.getText());
			}else {
				test.log(Status.FAIL, "Error message not displayed");
			}
			if(homePage.homePointsAed.isDisplayed()) {
				test.log(Status.PASS, "Error message is displayed: "+homePage.homePointsAed.getText());
			}else {
				test.log(Status.FAIL, "Error message not displayed");
			}
			if(homePage.homePointsPoints.isDisplayed()) {
				test.log(Status.PASS, "Error message is displayed: "+homePage.homePointsPoints.getText());
			}else {
				test.log(Status.FAIL, "Error message not displayed");
			}
			driver.navigate().back();
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}


	}
	//check with family

	@Test//TC:Verify the validations of points and email fields
	public void TC_Home_074(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify the validations of points and email fields");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			homePage.myFamily.click();

			if(homePage.homePointsError.isDisplayed()) {
				test.log(Status.PASS, "Error message is displayed: "+homePage.homePointsError.getText());
			}else {
				test.log(Status.FAIL, "Error message not displayed");
			}
			if(homePage.homePointsEmailError.isDisplayed()) {
				test.log(Status.PASS, "Error message is displayed: "+homePage.homePointsEmailError.getText());
			}else {
				test.log(Status.FAIL, "Error message not displayed");
			}
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}


	}


	@Test//TC:Verify user can view 4 offers on home screen under experiences tab
	public void TC_Home_028(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can view 4 offers on home screen under experiences tab");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			homePage.homeExperiences.click();
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"SUBMIT RECEIPT\").instance(0))"));
			if(homePage.homeOffers.isDisplayed()) {
				test.log(Status.PASS, "Offers Category displayed: "+homePage.homeOffers.getText());
			}else {
				test.log(Status.FAIL, "Offers Category NOT displayed");
			}
			if(homePage.homeContest.isDisplayed()) {
				test.log(Status.PASS, "Contest Category displayed: "+homePage.homeContest.getText());
			}else {
				test.log(Status.FAIL, "Contest Category NOT displayed");
			}
			if(homePage.homeDiscounts.isDisplayed()) {
				test.log(Status.PASS, "Discounts Category displayed: "+homePage.homeDiscounts.getText());
			}else {
				test.log(Status.FAIL, "Discounts Category NOT displayed");
			}
			if(homePage.homeCharity.isDisplayed()) {
				test.log(Status.PASS, "Charity Category displayed: "+homePage.homeCharity.getText());
			}else {
				test.log(Status.FAIL, "Contest Category NOT displayed");
			}
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}


	}



	@Test//TC:Verify user can click on any offer
	public void TC_Home_029(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can click on any offer");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			homePage.homeExperiences.click();
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"SUBMIT RECEIPT\").instance(0))"));
			homePage.homeOffers.click();

			if(homePage.homeOffersDes.isDisplayed()) {
				test.log(Status.PASS, "Offers description screen displayed: "+homePage.homeOffersDes.getText());
			}else {
				test.log(Status.FAIL, "Offers description screen NOT displayed");
			}

		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}


	}


	@Test//TC:Verify user navigates to home screen when the user click on close button of offer description
	public void TC_Home_030(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user navigates to home screen when the user click on close button of offer description");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			homePage.homeExperiences.click();
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"SUBMIT RECEIPT\").instance(0))"));
			homePage.homeOffers.click();

			generalFunctions.isElementPresent(homePage.homeOffersDes, 90);
			homePage.homeOfferClose.click();
			if(homePage.homeElement.isDisplayed()) {
				test.log(Status.PASS, "Offers description screen displayed: "+homePage.homeElement.getText());
			}else {
				test.log(Status.FAIL, "Offers description screen NOT displayed");
			}

		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}


	}



	@Test//TC:Verify user can click on SEE ALL option in the Updates and able to navigate to the update screen
	public void TC_Home_041(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can click on SEE ALL option in the Updates and able to navigate to the update screen");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			homePage.homeUpdates.click();	
			generalFunctions.isElementPresent(homePage.homeupdateSeeAll, 90);
			if(homePage.homeupdateSeeAll.isDisplayed()) {
				test.log(Status.PASS, "SEE ALL option is displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else {
				test.log(Status.FAIL, "SEE ALL option is NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			homePage.homeupdateSeeAll.click();
			generalFunctions.isElementPresent(homePage.homeUpdatesScreen, 90);
			if(homePage.homeUpdatesScreen.isDisplayed()) {
				test.log(Status.PASS, "Update screen displayed: "+homePage.homeUpdatesScreen.getText());
			}else {
				test.log(Status.FAIL, "Update screen NOT displayed");
			}
			driver.navigate().back();
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}

	@Test//TC:Verify user can click on SEE ALL option in the Experiences and able to navigate to the Experiences screen
	public void TC_Home_042(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can click on SEE ALL option in the Experiences and able to navigate to the Experiences screen");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			homePage.homeExperiences.click();                                                                                                             
			String see = homePage.homeExpSeeAll.getText();
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+see+"\").instance(0))")).click();
			if(homePage.homeupdateSeeAll.isDisplayed()) {
				test.log(Status.PASS, "SEE ALL option is displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else {
				test.log(Status.FAIL, "SEE ALL option is NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}

			generalFunctions.isElementPresent(homePage.homeExperiences, 90);
			if(homePage.homeExperiences.isDisplayed()) {
				test.log(Status.PASS, "Update screen displayed: "+homePage.homeExperiences.getText());
			}else {
				test.log(Status.FAIL, "Update screen NOT displayed");
			}
			driver.navigate().back();
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}


	}


	@Test//TC:Verify user can toggle from one tutorial screen to next by toggling from one to another and back
	public void TC_Home_043(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can toggle from one tutorial screen to next by toggling from one to another and back");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();

		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			splashScreenFunctions.splashScreenSkip(splashScreenPage);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			homePage.receiptCamera.click();  
			generalFunctions.isElementPresent(homePage.introNext, 90);
			generalFunctions.rightLeftSwipe();
			if(homePage.introDone.isDisplayed()) {
				test.log(Status.PASS, "Swipe to done is working").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else {
				test.log(Status.FAIL, "Swipe to Done is not working").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			generalFunctions.leftRightSwipe();
			if(homePage.introCheckbox.isDisplayed()) {
				test.log(Status.PASS, "Swipe back is working").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else {
				test.log(Status.FAIL, "Swipe back is not working").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}

		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}


	}



	@Test//TC:Verify user able to navigate to a page (UPDATES) to see all the updates when clicking on ‘See all updates' option on the home screen.
	public void TC_Home_N053(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user able to navigate to a page (UPDATES) to see all the updates when clicking on ‘See all updates' option on the home screen.");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			homePage.homeUpdates.click();	
			generalFunctions.isElementPresent(homePage.homeupdateSeeAll, 90);
			homePage.homeupdateSeeAll.click();
			generalFunctions.isElementPresent(homePage.homeUpdatesScreen, 90);
			if(homePage.homeUpdatesScreen.isDisplayed()) {
				test.log(Status.PASS, "Update screen displayed: "+homePage.homeUpdatesScreen.getText());
			}else {
				test.log(Status.FAIL, "Update screen NOT displayed");
			}
			driver.navigate().back();
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}

	@Test//TC:Verify News date,description,share,close button.
	public void TC_Home_N058_059_60_61_62(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify News Date,Description,Share,Close button");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			homePage.homeUpdates.click();	
			generalFunctions.isElementPresent(homePage.homeupdateSeeAll, 90);
			homePage.homeupdateNews.click();
			generalFunctions.isElementPresent(homePage.homeupdateDesc, 90);

			if(homePage.homeupdateDesc.isDisplayed()) {
				test.log(Status.PASS, "News description displayed: "+homePage.homeupdateDesc.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else {
				test.log(Status.FAIL, "News description NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			if(homePage.homeupdateDate.isDisplayed()) {
				test.log(Status.PASS, "News date displayed: "+homePage.homeupdateDate.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else {
				test.log(Status.FAIL, "News date NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			if(homePage.homeupdateShare.isDisplayed()) {
				test.log(Status.PASS, "Share button is displayed: "+homePage.homeupdateShare.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else {
				test.log(Status.FAIL, "Share button NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			if(homePage.homeupdateClose.isDisplayed()) {
				test.log(Status.PASS, "Close button is displayed: "+homePage.homeupdateClose.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else {
				test.log(Status.FAIL, "Close button NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			homePage.homeupdateClose.click();
			generalFunctions.isElementPresent(homePage.homeElement, 90);

			if(homePage.homeElement.isDisplayed()) {
				test.log(Status.PASS, "Close button is working and navigates to Home Screen");
			}else {
				test.log(Status.FAIL, "Close button is NOT working ");
			}
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}

	@Test//TC:Verify user is able to share News.
	public void TC_Home_N063(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user is able to share News");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			homePage.homeUpdates.click();	
			generalFunctions.isElementPresent(homePage.homeupdateSeeAll, 90);
			generalFunctions.isElementPresent(homePage.homeupdateSeeAll, 90);
			homePage.homeupdateNews.click();
			generalFunctions.isElementPresent(homePage.homeupdateDesc, 90);
			if(homePage.homeupdateShare.isDisplayed()) {
				homePage.homeupdateShare.click();
			}else {
				test.log(Status.FAIL, "The Share button is not displayed");
			}
			if(homePage.homeupdateShareOptions.isDisplayed()) {
				test.log(Status.PASS, "Share options displayed");
			}else {
				test.log(Status.FAIL, "Share options not displayed");
			}
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}
	@Test//TC:Verify user selected news detail screen is displayed
	public void TC_Home_N064(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user selected news detail screen is displayed");
		System.out.println("Running Test"+" "+ TC_Method);

		//		String EmailAddress=map.get("UserName").toString();
		//		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);	
		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		driver.resetApp();
		try
		{	
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			homePage.homeUpdates.click();	
			generalFunctions.isElementPresent(homePage.homeupdateSeeAll, 90);
			generalFunctions.isElementPresent(homePage.homeupdateSeeAll, 90);
			String news = homePage.homeupdateNews.getText();
			homePage.homeupdateNews.click();
			generalFunctions.isElementPresent(homePage.homeupdateDesc, 90);
			if(news.contains(homePage.homeupdateNews.getText())) {
				test.log(Status.PASS, "Selected News detail screen displayed");
			}else {
				test.log(Status.FAIL, "Wrong News detail screen displayed");
			}

		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}

}



