package com.share.testscript;

import java.lang.reflect.Method;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.share.functions.HomeFunctions;
import com.share.functions.RegistrationFunctions;
import com.share.functions.SignInFunctions;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.ExperiencesPage;
import com.share.objectrepository.HomePage;
import com.share.objectrepository.RegistrationPage;
import com.share.objectrepository.SignInPage;
import com.share.objectrepository.TransactionsPage;
import com.share.utility.Utilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Home extends DriverSetUp{

	@Test(priority=1)//Verify curve header: Verify UserProfile name,Points Balance, Aed,Avtar
	public void TC_Home_001(Method method) throws Exception {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify curve header: Verify UserProfile name,Points Balance, Aed,Avtar");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		
		driver.resetApp();
		signInFunctions.SignContinue();
		signInFunctions.quickSignIn();

		generalFunctions.isElementPresent(homePage.homeElement, 30);
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
	}

	@Test(priority=2)//TC:Verify below curve headers:Submit reciept,Share ID,My Family, Share your points
	public void TC_Home_002(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify below curve headers:Submit reciept,Share ID,My Family, Share your points");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		try
		{

			driver.resetApp();
			signInFunctions.SignContinue();
			signInFunctions.quickSignIn();

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

	@Test(priority=3)//TC:Verify user should view tutorial on clicking Submit receipt and Camera permissions
	public void TC_Home_003_005(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user should view tutorial on clicking Submit receipt and Camera permissions");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		try
		{
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			homeFunctions.receiptCameraClick(homePage);
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
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}catch(Exception e) {

			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}

	@Test(priority=4)//TC:Verify user can skip the tutorial by clicking on skip button in tutorials in receipt submit screen
	public void TC_Home_053(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can skip the tutorial by clicking on skip button in tutorials in receipt submit screen");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		try
		{
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
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}

	@Test(priority=5)//TC:Verify user can selected dont show  in Intro Screen
	public void TC_Home_004(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can selected dont show  in Intro Screen");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();

		try
		{
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

			homePage.introCheckbox.click();
			generalFunctions.isElementPresent(homePage.introNext, 90);
			homeFunctions.introDone(homePage);
			Thread.sleep(1000);
			homeFunctions.allowtoAccess(homePage);
			Thread.sleep(1000);
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

			Thread.sleep(1000);
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
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}catch(Exception e) {

			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}

	@Test(priority=6)//TC:Verify user should be able to click normal receipt
	public void TC_Home_006(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user should be able to click normal receipt");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		try
		{
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
			driver.pressKey(new KeyEvent(AndroidKey.BACK));

		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}

	@Test(priority=7)//TC:Verify user should be able to click Long receipt
	public void TC_Home_007(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user should be able to click Long receipt");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		try
		{
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
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}

	@Test(priority=7)//TC:Verify user should not be able to upload more than 10 images
	public void TC_Home_008(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user should not be able to upload more than 10 images");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		try
		{
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
			Thread.sleep(500);
			homePage.buttonCaptureClick.click();
			Thread.sleep(500);
			generalFunctions.toastMessages();
			String toast = "you can take maximum of 10 images";
			if(generalFunctions.toastMessages().contains(toast)) {
				test.log(Status.PASS, "The error message is displayed: "+toast);
			}else {
				test.log(Status.FAIL, "The error message not displayed");
			}
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}

	@Test(priority=8)//TC:Verify user can retake the images using Long receipt
	public void TC_Home_009(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can retake the images using long receipt");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();

		try
		{
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
				test.log(Status.FAIL, "The error message not displayed");
			}

			generalFunctions.isElementPresent(homePage.submitReceipt, 90);
			if(homePage.submitReceipt.isDisplayed()) {
				test.log(Status.PASS, "The Submit receipt screen displayed");

			}else {
				test.log(Status.FAIL, "The Submit Receipt screen is not displayed");
			}
			generalFunctions.isElementPresent(homePage.previewRetake, 90);
			homePage.previewRetake.click();
			generalFunctions.isElementPresent(homePage.previewRetakebutton, 30);
			homePage.previewRetakebutton.click();
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
				test.log(Status.FAIL, "The error message not displayed");
			}
			generalFunctions.isElementPresent(homePage.submitReceipt, 90);
			if(homePage.submitReceipt.isDisplayed()) {
				test.log(Status.PASS, "The Submit receipt screen displayed");

			}else {
				test.log(Status.FAIL, "The Submit Receipt screen is not displayed");
			}
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(500);
			generalFunctions.isElementPresent(homePage.previewRetakebutton, 30);
			homePage.previewRetakebutton.click();
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}

	@Test(priority=9)//TC:Verify user can retake the images using Normal receipt
	public void TC_Home_010(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can retake the images using Normal receipt");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();

		try
		{
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
			generalFunctions.isElementPresent(homePage.previewRetakebutton, 30);
			homePage.previewRetakebutton.click();
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
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(500);
			generalFunctions.isElementPresent(homePage.previewRetakebutton, 30);
			homePage.previewRetakebutton.click();
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}

	@Test(priority=10)//TC:Verify user can click on cancel button to exit the receipt scanning
	public void TC_Home_011(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can click on cancel button to exit the receipt scanning");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();

		try
		{
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

	@Test(priority=11)//TC:Verify user can exit the receipt scanning by tapping on Cancel button
	public void TC_Home_012(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can exit the receipt scanning by tapping on Cancel button");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		try
		{
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
	@Test(priority=12)//TC:Verify user can discard the images of Normal receipt
	public void TC_Home_013(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can discard the images of Normal receipt");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		try
		{
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

		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}

	@Test(priority=13)//TC:Verify user can discard the images of long receipt
	public void TC_Home_014(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can discard the images of long receipt");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();

		try
		{
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

			generalFunctions.isElementPresent(homePage.previewSubmit, 90);
			if(homePage.previewSubmit.isDisplayed()) {
				test.log(Status.PASS, "The Preview button displayed");
				homePage.previewSubmit.click();

			}else {
				test.log(Status.FAIL, "The Preview button Not displayed");
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
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}

	@Test(priority=14)//TC:Verify user can submit long receipt
	public void TC_Home_015(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can submit normal receipt");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();

		try
		{
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
			generalFunctions.isElementPresent(homePage.submitReceiptButton, 90);
			homePage.submitReceiptButton.click();
			Thread.sleep(1000);
			generalFunctions.isElementPresent(homePage.successMessageInhome, 90);
			if(homePage.successMessageInhome.isDisplayed()) {
				test.log(Status.PASS, "The Receipt submitted Successfully");
			}else {
				test.log(Status.FAIL, "The Receipt not submitted Successfully");
			}
			generalFunctions.isElementPresent(homePage.submitReceiptButtonOk, 90);
			homePage.submitReceiptButtonOk.click();

			generalFunctions.isElementPresent(homePage.homeElement, 90);
			if(homePage.homeElement.isDisplayed()) {
				test.log(Status.PASS, "Navigated to Homepage");
			}else {
				test.log(Status.FAIL, "Not Navigated to Homepage");
			}
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}

	@Test(priority=15)//TC:Verify user can submit normal receipt
	public void TC_Home_016(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can submit Long receipt");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		try
		{
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
			homePage.longReceiptButton.click();
			generalFunctions.isElementPresent(homePage.buttonCaptureClick, 90);
			homePage.buttonCaptureClick.click();
			homePage.buttonCaptureClick.click();

			generalFunctions.isElementPresent(homePage.previewSubmit, 90);
			if(homePage.previewSubmit.isDisplayed()) {
				test.log(Status.PASS, "The preview button button displayed");
				homePage.previewSubmit.click();
			}else {
				test.log(Status.FAIL, "The Preview button Not displayed");
			}
			generalFunctions.isElementPresent(homePage.submitReceiptButton, 90);
			homePage.submitReceiptButton.click();
			Thread.sleep(1000);
			generalFunctions.isElementPresent(homePage.successMessageInhome, 90);
			if(homePage.successMessageInhome.isDisplayed()) {
				test.log(Status.PASS, "The Receipt submitted Successfully");
			}else {
				test.log(Status.FAIL, "The Receipt not submitted Successfully");
			}
			generalFunctions.isElementPresent(homePage.submitReceiptButtonOk, 90);
			homePage.submitReceiptButtonOk.click();

			generalFunctions.isElementPresent(homePage.homeElement, 90);
			if(homePage.homeElement.isDisplayed()) {
				test.log(Status.PASS, "Navigated to Homepage");
			}else {
				test.log(Status.FAIL, "Not Navigated to Homepage");
			}
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}


	@Test(priority=16)//TC:Verify user should be able to click normal receipt
	public void TC_Home_056(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user should be able to click normal receipt");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();

		try
		{
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
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}

	@Test(priority=17)//TC:Verify user can view the receipt tutorial by clicking on the i button in receipt scanning screen
	public void TC_Home_064(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can view the receipt tutorial by clicking on the i button in receipt scanning screen");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		try
		{
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
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}

	/////////////////********SHARE_ID**************////////////***************
	@Test(priority=18)//TC:Verify user clicks on SHARE ID
	public void TC_Home_017(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user clicks on SHARE ID");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		try
		{
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
			Thread.sleep(500);
			generalFunctions.isElementPresent(homePage.homeBarcode, 90);
			if(homePage.homeBarcode.isDisplayed()) {
				test.log(Status.PASS, "Share ID Number displayed: "+homePage.homeBarcode.getText());
			}
			else
			{
				test.log(Status.FAIL, "Share ID Number not displayed");
			}
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}


	@Test(priority=19)//TC:Verify user able to view SHOP ONLINE & EARN SHARE POINTS section in the home screen
	public void TC_Home_065(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user able to view SHOP ONLINE & EARN SHARE POINTS section in the home screen");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		try
		{
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			if(homePage.homeShopEarn.isDisplayed()) {
				test.log(Status.PASS, "The SHOP ONLINE & EARN SHARE POINTS IS PRESENT: "+homePage.homeShopEarn.getText());
			}else {
				test.log(Status.FAIL, "The SHOP ONLINE & EARN SHARE POINTS IS NOT PRESENT");
			}
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}


	@Test(priority=20)//TC:Verify user able to switch between the ‘Experiences’ and ‘Updates’ tabs in the home screen.
	public void TC_Home_067(Method method)  {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user able to switch between the ‘Experiences’ and ‘Updates’ tabs in the home screen.");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();

		try
		{
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

	@Test(priority=21)//TC:Verify the app tabs: Home,Experiences,SharePay,Assistant,Account.
	public void TC_Home_080(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify the app tabs: Home,Experiences,SharePay,Assistant,Account");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		try
		{
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

	@Test(priority=22)//TC//TC:Verify user can click on See all
	public void TC_Home_068(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can click on See all on Experiences Screen");
		System.out.println("Running Test"+" "+ TC_Method);
		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		try
		{
			generalFunctions.isElementPresent(homePage.homeElement, 90);

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

	@Test(priority=23)//TC:Verify user can click on Share Your Points and able to share points
	public void TC_Home_070(Method method) throws Exception {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can click on Share Your Points & able to share points");
		test.info("Points Burn via Share Your Points");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		TransactionsPage transactionsPage = new TransactionsPage(driver);
		try
		{
			generalFunctions.isElementPresent(homePage.homeElement, 10);
			Thread.sleep(2000);
			if(homePage.pointshome.isDisplayed()) {
				test.log(Status.PASS, "Points Before SYP is :"+" "+homePage.pointshome.getText());
			}else {
				test.log(Status.FAIL, "Points not displayed");
			}
			String po = homePage.pointshome.getText();
			System.out.println(po);
			
			if(homePage.pointsAed.isDisplayed()) {
				test.log(Status.PASS, "Equivalent AED is displayed:"+" "+homePage.pointsAed.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else {
				test.log(Status.FAIL, "Points in AED is not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			homePage.homeSharePoints.click();
			Thread.sleep(2000);
			generalFunctions.isElementPresent(homePage.homePointsBalance, 90);
			homePage.homePointsFieldplaceholder.click();
			generalFunctions.isElementPresent(homePage.homePointsField, 30);
			homePage.homePointsField.sendKeys("10.1");
			test.info("Point shared amount: 10.1");
			driver.hideKeyboard();
			homePage.homePointsEmail.sendKeys("sharetest371@yopmail.com");
			test.info("Point shared to Account member: sharetest371@yopmail.com");
			homePage.homePointsSubmit.click();
			homePage.homePointsSubmitConfirm.click();
			Thread.sleep(500);
			generalFunctions.isElementPresent(homePage.PointsSuccess, 30);
			if(homePage.PointsSuccess.isDisplayed()) {
				test.log(Status.PASS, "Successfully Transferred points").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else {
				test.log(Status.FAIL, "Points Transfer Failed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			generalFunctions.isElementPresent(homePage.PointsDoneButton, 30);
			homePage.PointsDoneButton.click();
			// Click Account
			generalFunctions.isElementPresent(transactionsPage.accountIcon, 90);
			transactionsPage.accountIcon.click();
			Thread.sleep(5000);
		
			if(generalFunctions.isElementPresent(transactionsPage.myAccountPage, 90))
			{	test.log(Status.PASS, "Navigated to transaction list to verify the transaction").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Not navigated to transaction list").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			if(generalFunctions.isElementPresent(transactionsPage.transactiontodaylabel, 20))
			{	test.log(Status.PASS, "Transaction date displayed under:"+" "+transactionsPage.transactiontodaylabel.getText());
			}
			else
			{	test.log(Status.FAIL, "Transaction date not displayed");
			}
			if(generalFunctions.isElementPresent(transactionsPage.pointsShared, 20))
			{	test.log(Status.PASS, "Transaction label displayed as:"+" "+transactionsPage.pointsShared.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Transaction label not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			transactionsPage.pointsShared.click();
			Thread.sleep(2000);
			if(generalFunctions.isElementPresent(transactionsPage.transactionDetailspage, 20))
			{	test.log(Status.PASS, "Navigated to transaction detail page to verify").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Not navigated to transaction detail page").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			if(generalFunctions.isElementPresent(transactionsPage.pointsSharedlabelindetailpage, 20))
			{	test.log(Status.PASS, "Points shared label displayed in transaction detail page");
				test.info("Label:"+" "+transactionsPage.pointsSharedlabelindetailpage.getText());
			}
			else
			{	test.log(Status.FAIL, "Points shared label not displayed in transaction detail page");
			}
			if(generalFunctions.isElementPresent(transactionsPage.pointsSharedmember, 20))
			{	test.log(Status.PASS, "Points shared member[Loyalty member] emaild id displayed in transaction detail page");
				test.info("Share member:"+" "+transactionsPage.pointsSharedmember.getText());
			}
			else
			{	test.log(Status.FAIL, "Points shared member not emaild id displayed in transaction detail page");
			}
			if(generalFunctions.isElementPresent(transactionsPage.sharedPoints, 20))
			{	test.log(Status.PASS, "Point amount shared/burned displayed in detailed page");
				test.info("Points Burned:"+" "+transactionsPage.sharedPoints.getText());
			}
			else
			{	test.log(Status.FAIL, "Point amount shared/burned not displayed in detailed page");
			}
			String burn = transactionsPage.sharedPoints.getText();
			if(generalFunctions.isElementPresent(transactionsPage.sharedPointsinAED, 20))
			{	test.log(Status.PASS, "Equivalent AED amount shared/burned displayed in detailed page");
				test.info("Points Burned AED:"+" "+transactionsPage.sharedPointsinAED.getText());
			}
			else
			{	test.log(Status.FAIL, "Equivalent AED amount shared/burned not displayed in detailed page");
			}
			if(generalFunctions.isElementPresent(transactionsPage.sharedPointsdateandtime, 20))
			{	test.log(Status.PASS, "Transaction date and time displayed in detail page");
				test.info("Transaction Date:"+" "+transactionsPage.sharedPointsdateandtime.getText());
			}
			else
			{	test.log(Status.FAIL, "Transaction date and time not displayed in detail page");
			}
			
			driver.navigate().back();
			homePage.homeElement.click();
			if(homePage.pointshome.isDisplayed()) {
				test.log(Status.PASS, "Updated points after SYP is:"+" "+homePage.pointshome.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else {
				test.log(Status.FAIL, "Points not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			if(homePage.pointsAed.isDisplayed()) {
				test.log(Status.PASS, "Updated equivalent AED displayed as:"+" "+homePage.pointsAed.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else {
				test.log(Status.FAIL, "Updated Points in AED is not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}


	@Test(priority=24)//TC:Verify the error message is displaying when we input points if the user points is Zero
	public void TC_Home_071(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify the error message is displaying when we input points if the user points is Zero");
		System.out.println("Running Test"+" "+ TC_Method);

		//SignInPage signInPage = new SignInPage(driver);
		HomePage homePage = new HomePage(driver);

		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{
			driver.resetApp();
			signInFunctions.SignContinue();
			homeFunctions.zeroPointuser();

			generalFunctions.isElementPresent(homePage.homeElement, 90);
			homePage.homeSharePoints.click();
			Thread.sleep(2000);
			generalFunctions.isElementPresent(homePage.homePointsBalance, 90);
			homePage.homePointsFieldplaceholder.click();
			homePage.homePointsField.sendKeys("10.1");
			Thread.sleep(500);
			//homePage.homePointsOption.click();
			homePage.homePointsEmail.click();
			if(homePage.homeNopointError.isDisplayed()) {
				test.log(Status.PASS, "Error message is displayed: "+homePage.homeNopointError.getText());
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

	@Test(priority=25)//TC:Verify the validations of points and email fields
	public void TC_Home_072(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify the validations of points and email fields");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{
			driver.resetApp();
			signInFunctions.SignContinue();
			homeFunctions.zeroPointuser();
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			homePage.homeSharePoints.click();
			Thread.sleep(2000);
			generalFunctions.isElementPresent(homePage.homePointsBalance, 90);
			homePage.homePointsFieldplaceholder.click();
			homePage.homePointsField.sendKeys("-10");
			Thread.sleep(1000);
			driver.hideKeyboard();
			//homePage.homePointsOption.click();
			//homePage.PointsOptionFamily.click();
			homePage.homePointsEmail.click();
			if(homePage.homePointsError1.isDisplayed()) {
				test.log(Status.PASS, "Error message is displayed: "+homePage.homePointsError1.getText());
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


	@Test(priority=26)//TC:Verify all the titles are present in the Share Your Points screen
	public void TC_Home_073(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:vVerify all the titles are present in the Share Your Points screen");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{
			driver.resetApp();
			signInFunctions.SignContinue();
			homeFunctions.zeroPointuser();
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			homePage.homeSharePoints.click();
			Thread.sleep(2000);
			generalFunctions.isElementPresent(homePage.homePointsBalance, 90);
			homePage.homePointsFieldplaceholder.click();
			homePage.homePointsField.sendKeys("10.1");
			Thread.sleep(500);
			//homePage.homePointsOption.click();
			homePage.homePointsEmail.click();
			if(homePage.homePointsBalance.isDisplayed()) {
				test.log(Status.PASS, "Title is "+homePage.homePointsBalance.getText());
			}else {
				test.log(Status.FAIL, "Point Balance title no displayed");
			}
			if(homePage.homePointsAed.isDisplayed()) {
				test.log(Status.PASS, "Points with AED Displayed:-"+homePage.homePointsAed.getText());
			}else {
				test.log(Status.FAIL, "Points with AED Not Displayed ");
			}
			if(homePage.homePointsPoints.isDisplayed()) {
				test.log(Status.PASS, "Title is  "+homePage.homePointsPoints.getText());
			}else {
				test.log(Status.FAIL, "Points Text Not Displayed");
			}
			//homePage.previewClose.click();
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}


	}
	//TC:Verify the validations messages of points and email fields
	@Test(priority=27)
	public void TC_Home_074(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify the validations of points and email fields");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		HomeFunctions homeFunctions = new HomeFunctions();
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{
			driver.resetApp();
			signInFunctions.SignContinue();
			homeFunctions.zeroPointuser();
			
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			homePage.homeSharePoints.click();
			Thread.sleep(4000);
			if(homePage.homePointsError.isDisplayed()) {
				test.log(Status.PASS, "Error message is displayed: "+" "+homePage.homePointsError.getText());
			}else {
				test.log(Status.FAIL, "Error message not displayed");
			}
			homePage.homePointsEmail.click();
			if(homePage.homePointsEmailError.isDisplayed()) {
				test.log(Status.PASS, "Error message is displayed: "+homePage.homePointsEmailError.getText());
			}else {
				test.log(Status.FAIL, "Error message not displayed");
			}
			driver.pressKey(new KeyEvent(AndroidKey.BACK));

		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}


	}


	@Test(priority=28)//TC:Verify user can view offer tiles on home screen under experiences tab
	public void TC_Home_028(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can view 4 offers on home screen under experiences tab");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{
			driver.resetApp();
			signInFunctions.SignContinue();
			signInFunctions.quickSignIn();
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			String a = homePage.homeOffers1.getText();
			System.out.println(a);

			if(homePage.homeOffers1.isDisplayed()) {
				test.log(Status.PASS, "Carrefour Offer Category displayed: "+homePage.homeOffers1.getText());
			}else {
				test.log(Status.FAIL, "Carrefour Offer Category NOT displayed");
			}
			if(homePage.homeOffers2.isDisplayed()) {
				test.log(Status.PASS, "Default Offer Category displayed: "+homePage.homeOffers2.getText());
			}else {
				test.log(Status.FAIL, "Default Offer Category NOT displayed");
			}
			if(homePage.homeOffers3.isDisplayed()) {
				test.log(Status.PASS, "Member Benefits Offer Category displayed: "+homePage.homeOffers3.getText());
			}else {
				test.log(Status.FAIL, "Member Benefits Offer Category NOT displayed");
			}
			if(homePage.homeOffers4.isDisplayed()) {
				test.log(Status.PASS, "Member Contests Offer Category displayed: "+homePage.homeOffers4.getText());
			}else {
				test.log(Status.FAIL, "Member Contests Offer Category NOT displayed");
			}
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}


	}



	@Test(priority=29)//TC:Verify user can click on any offer
	public void TC_Home_029(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can click on any offer tile from home experiences");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		try
		{
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			homePage.homeExperiences.click();
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"SHOP ONLINE & EARN SHARE POINTS\").instance(0))"));
			homePage.homeTileoffer.click();
			Thread.sleep(500);
			if(homePage.homeOffersDes.isDisplayed()) {
				test.log(Status.PASS, "Offers detail description screen displayed: "+homePage.homeOffersDes.getText());
			}else {
				test.log(Status.FAIL, "Offers detail description screen NOT displayed");
			}
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}


	}


	@Test(priority=30)//TC:Verify user navigates to home screen when the user click on close button of offer description
	public void TC_Home_030(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user navigates to home screen when the user click on close button of offer description");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		try
		{
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			homePage.homeExperiences.click();
			//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"UPDATES\").instance(0))"));
			homePage.homeTileoffer.click();
			Thread.sleep(1000);
			homePage.homeOfferClose.click();
			if(homePage.homeElement.isDisplayed()) {
				test.info("User clicked close icon from offer and navigated to homepage");
				test.log(Status.PASS, "Navigated to Experience offers tiles in: "+homePage.homeElement.getText());
			}else {
				test.log(Status.FAIL, "Not Navigated to Experience offers tiles in home");
			}
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}


	}



	@Test(priority=31)//TC:Verify user can click on SEE ALL option in the Updates and able to navigate to the update screen
	public void TC_Home_041(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can click on SEE ALL option in the Updates and able to navigate to the update screen");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{
			driver.resetApp();
			signInFunctions.SignContinue();
			signInFunctions.quickSignIn();
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

	@Test(priority=32)//TC:Verify user can click on SEE ALL option in the Experiences and able to navigate to the Experiences screen
	public void TC_Home_042(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can click on SEE ALL option in the Experiences and able to navigate to the Experiences screen");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		try
		{
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			homePage.homeExperiences.click();
			//String see = homePage.homeExpSeeAll.getText();
			//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+see+"\").instance(0))")).click();

			if(homePage.homeupdateSeeAll.isDisplayed()) {
				test.log(Status.PASS, "SEE ALL option is displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else {
				test.log(Status.FAIL, "SEE ALL option is NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			homePage.homeupdateSeeAll.click();
			Thread.sleep(1500);
			//Verify OnBoarding displayed
			if(generalFunctions.isElementPresent(objExperiencesPage.OnBoarding, 30))
			{	test.log(Status.PASS, "OnBoarding Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "OnBoarding Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			generalFunctions.isElementPresent(objExperiencesPage.OnBoardingSkip, 30);
			objExperiencesPage.OnBoardingSkip.click();
			try
			{
				generalFunctions.isElementPresent(objExperiencesPage.AllowAllTheTime, 30);
				if(objExperiencesPage.AllowAllTheTime.isDisplayed()== true)
				{
					test.log(Status.PASS, "Location Access Displayed When navigated to experience page");
					objExperiencesPage.DontAllowaccess.click();
			     }
			    }
				catch(Exception x)
				{
					test.log(Status.INFO, "Access Not given because of next testcases dependency");
					System.out.println("Location Access Denied");
				}
		
			if(generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30))
			{
				test.log(Status.PASS, "SHARE EXPERIENCES Page Displayed");
			}
			else
			{
				test.log(Status.FAIL, "SHARE EXPERIENCES Page Not Displayed");
				Assert.fail("SHARE EXPERIENCES Page  Not Displayed");
			}
			driver.navigate().back();
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}


	}


	@Test(priority=33)//TC:Verify user can toggle from one tutorial screen to next by toggling from one to another and back
	public void TC_Home_043(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user can toggle from one tutorial screen to next by toggling from one to another and back");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();

		try
		{
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
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}


	}



	@Test(priority=34)//TC:Verify user able to navigate to a page (UPDATES) to see all the updates when clicking on ‘See all updates' option on the home screen.
	public void TC_Home_N053(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user able to navigate to a page (UPDATES) to see all the updates when clicking on ‘See all updates' option on the home screen.");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{
			driver.resetApp(); 
			signInFunctions.SignContinue();
			signInFunctions.quickSignIn();
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
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}

	@Test(priority=35)//TC:Verify News date,description,share,close button.
	public void TC_Home_058_059_60_61_62(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify News Date,Description,Share,Close button");
		System.out.println("Running Test"+" "+ TC_Method);


		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		try
		{
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

	@Test(priority=36)//TC:Verify user is able to share News.
	public void TC_Home_N063(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user is able to share News");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		try
		{
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			homePage.homeUpdates.click();
			generalFunctions.isElementPresent(homePage.homeupdateSeeAll, 90);
			homePage.homeupdateNews.click();
			generalFunctions.isElementPresent(homePage.homeupdateDesc, 90);
			if(homePage.homeupdateShare.isDisplayed())
			{
				test.log(Status.PASS, "The Share button displayed");
			}else {
				test.log(Status.FAIL, "The Share button is not displayed");
			}
			homePage.homeupdateShare.click();
			if(homePage.homeupdateShareOptions.isDisplayed()) {
				test.log(Status.PASS, "Share options displayed");
			}else {
				test.log(Status.FAIL, "Share options not displayed");
			}
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}
	@Test(priority=37)//TC:Verify user selected news detail screen is displayed
	public void TC_Home_N064(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Home");
		test.log(Status.INFO, "Home");
		test.info("TC:Verify user selected news detail screen is displayed");
		System.out.println("Running Test"+" "+ TC_Method);

		HomePage homePage = new HomePage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		try
		{
			generalFunctions.isElementPresent(homePage.homeElement, 90);
			homePage.homeUpdates.click();
			generalFunctions.isElementPresent(homePage.homeupdateSeeAll, 90);
			String newstitle = homePage.homeupdateNews.getText();
			homePage.homeupdateNews.click();
			String updatetitle =  homePage.homeupdatespagetitle.getText();
			if(newstitle.equalsIgnoreCase(updatetitle)) {
				test.log(Status.PASS, "Selected News detail screen displayed");
			}else {
				test.log(Status.FAIL, "Wrong News detail screen displayed");
			}
			driver.pressKey(new KeyEvent(AndroidKey.BACK));

		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured");
		}
	}


	//************************************SHOP ONLINE AND EARN SHARE POINTS**********************//

		//TC:Verify the header SHOP ONLINE AND EARN SHARE POINTS displayed
		@Test(priority=38)
		public void TC_Home_SO001(Method method) throws InterruptedException {
			String TC_Method = method.getName();
			test = extent.createTest(TC_Method).assignCategory("Home");
			test.log(Status.INFO, "Module:Home");
			test.info("TC:Verify the header SHOP ONLINE AND EARN SHARE POINTS displayed ");
			System.out.println("Running Test"+" "+ TC_Method);
			
			HomePage homePage = new HomePage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();	
			GeneralFunctions generalFunctions = new GeneralFunctions();
			try
			{
			driver.resetApp();
			signInFunctions.SignContinue();
			signInFunctions.quickSignIn();
			generalFunctions.isElementPresent(homePage.shopOnlineHeaders, 10);
			List<MobileElement> shopeOnlineCategory = homePage.shopOnlineHeadersList.findElementsByClassName("android.view.ViewGroup");

			if(generalFunctions.isElementPresent(shopeOnlineCategory.get(0), 30)){
				test.log(Status.PASS, "Share Online :Carrefour Present");
				shopeOnlineCategory.get(0).click();
				Thread.sleep(5000);
				String webContent = driver.getContextHandles().toString();
				generalFunctions.viewComparison(webContent);
				test.log(Status.PASS, "Navigates to WebPage");
			}else {
				test.log(Status.FAIL, "Share Online :Carrefour NOT Present");
			}
			driver.navigate().back();
			if(generalFunctions.isElementPresent(shopeOnlineCategory.get(1), 30)){
				test.log(Status.PASS, "Share Online :VOX Present");
				shopeOnlineCategory.get(1).click();
				Thread.sleep(5000);
				String webContent = driver.getContextHandles().toString();
				generalFunctions.viewComparison(webContent);
				test.log(Status.PASS, "Navigates to WebPage");
			}else {
				test.log(Status.FAIL, "Share Online :VOX NOT Present");
			}
			driver.navigate().back();
			if(generalFunctions.isElementPresent(shopeOnlineCategory.get(2), 30)){
				test.log(Status.PASS, "Share Online :THAT Present");
				shopeOnlineCategory.get(2).click();
				Thread.sleep(5000);
				String webContent = driver.getContextHandles().toString();
				generalFunctions.viewComparison(webContent);
				test.log(Status.PASS, "Navigates to WebPage");
			}else {
				test.log(Status.FAIL, "Share Online :THAT NOT Present");
			}
			driver.navigate().back();
			if(generalFunctions.isElementPresent(shopeOnlineCategory.get(3), 30)){
				test.log(Status.PASS, "Share Online :LEGO Present");
				shopeOnlineCategory.get(3).click();
				Thread.sleep(5000);
				String webContent = driver.getContextHandles().toString();
				generalFunctions.viewComparison(webContent);
				test.log(Status.PASS, "Navigates to WebPage");
			}else {
				test.log(Status.FAIL, "Share Online :LEGO NOT Present");
			}
			driver.navigate().back();
			if(generalFunctions.isElementPresent(shopeOnlineCategory.get(4), 30)){
				test.log(Status.PASS, "Share Online :CRATE &BARELL Present");
				shopeOnlineCategory.get(4).click();
				Thread.sleep(5000);
				String webContent = driver.getContextHandles().toString();
				generalFunctions.viewComparison(webContent);
				test.log(Status.PASS, "Navigates to WebPage");
			}else {
				test.log(Status.FAIL, "Share Online :CRATE &BARELL NOT Present");
			}
			driver.navigate().back();
				}catch(Exception e) {
						e.printStackTrace();
						e.getCause();
						e.getMessage();
						Assert.fail("Error Occured");
					}
		}
}



