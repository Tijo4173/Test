package com.share.testscript;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.share.functions.AssistantFunctions;
import com.share.functions.HomeFunctions;
import com.share.functions.RegistrationFunctions;
import com.share.functions.SignInFunctions;
import com.share.functions.SplashScreenFunctions;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.AssistantPage;
import com.share.objectrepository.HomePage;
import com.share.objectrepository.NotificationPage;
import com.share.objectrepository.RegistrationPage;
import com.share.objectrepository.SignInPage;
import com.share.objectrepository.SplashScreenPage;
import com.share.utility.Utilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class SignIn extends DriverSetUp
{




	//Launch the shareapp and click on "Sign in" button
	@Test()
	public void TC_SignIn_001_007(Method method) throws Exception
	{

		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module: Sign In").assignCategory("SignIn");
		test.info("Launch the shareapp and click on Sign in button");
		//driver.resetApp();
		System.out.println(TC_Method);
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();	
		GeneralFunctions generalFunctions = new GeneralFunctions();
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();

		try 
		{
			splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(signInPage.signinPresent, 90);
			signInFunctions.validUserLogin(signInPage);
			generalFunctions.isElementPresent(registrationPage.HomeIcon, 90);
			if(generalFunctions.isElementPresent(registrationPage.HomeIcon, 10)) {
				test.log(Status.PASS, "SignIn Successful and Home Screen Displayed");
			}else {
				test.log(Status.FAIL, "SignIn is not Successful");
				Assert.fail("The Sign In is not Successful");
			}


		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}
	}

	//Verify user lands on Home screen
	@Test()
	public void TC_SignIn_002(Method method) throws Exception
	{

		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module: Sign In").assignCategory("SignIn");
		test.info("Verify user lands on Home screen");
		driver.resetApp();
		System.out.println(TC_Method);
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();	
		GeneralFunctions generalFunctions = new GeneralFunctions();
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		try 
		{
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInFunctions.validUserLogin(signInPage);
			
			if(generalFunctions.isElementPresent(registrationPage.HomeIcon, 90)) {
				test.log(Status.PASS, "User lands on Home screen");
			}else {
				test.log(Status.FAIL, "User not lands on Home screen and not displayed the Tutorial");
				Assert.fail("User not lands on Home screen");
			}


		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}
	}

	//Verify user can reset Password
	@Test()
	public void TC_SignIn_003_004(Method method) throws Exception
	{

		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module: Sign In").assignCategory("SignIn");
		test.info("Verify user can reset Password");
		driver.resetApp();
		System.out.println(TC_Method);
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();	
		GeneralFunctions generalFunctions = new GeneralFunctions();
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		NotificationPage notificationpage= new NotificationPage(driver);
		try 
		{
			generalFunctions.isElementPresent(signInPage.signinPresent, 90);
			signInPage.signinPresent.click();
			generalFunctions.isElementPresent(signInPage.forgotElement, 90);
			signInPage.forgotElement.click();		
			if(generalFunctions.isElementPresent(signInPage.forgotPasswordScreen, 10)) {
				test.log(Status.PASS, "Forgot Password is working and displayed Forgot Password success Screen");
			}else {
				test.log(Status.FAIL, "Forgot Password button is not working");
				Assert.fail("Forgot Password button is not working");
			}
			signInFunctions.resetEmail(signInPage);
			signInPage.sendResetLink.click();
		
			if(generalFunctions.isElementPresent(signInPage.checkYourEmail, 90)) {
				test.log(Status.PASS, "The Reset Password linke sent to the email id:"+signInPage.screenText.getText());
			}else {
				test.log(Status.FAIL, "Forgot Password Reset is not working");
			}
			String Dvtime = driver.getDeviceTime();
			System.out.println("device time: "+Dvtime);
			//SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);	
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX", Locale.ENGLISH);
			Date parsedDate = sdf.parse(Dvtime);
			SimpleDateFormat print = new SimpleDateFormat("HH:mm");	
			String FormatedDeviceTime = print.format(parsedDate);	
			System.out.println("Formated Device Time : "+FormatedDeviceTime);
			Thread.sleep(10000);

			driver.pressKey(new KeyEvent(AndroidKey.HOME));
			driver.startActivity(new Activity("com.google.android.gm","ConversationListActivityGmail"));
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Thread.sleep(10000);

			//Tap on Search
			notificationpage.SearchBox.click();
			
			//Search email	
			if(generalFunctions.isElementPresent(notificationpage.SearchMail, 10)) {
				test.log(Status.PASS, "The Mail box is displayed");
			}else {
				test.log(Status.FAIL, "The mail box is not displayed");
			}
			notificationpage.SearchMail.click();
			Thread.sleep(5000);
			//accountPage.SearchMail.sendKeys("SHARE");
			Actions action = new Actions(driver);
			action.sendKeys("SHARE").perform();

			driver.pressKey(new KeyEvent(AndroidKey.ENTER));


			//Verify Thanks button displayed
			String EmailSub= notificationpage.MailSubject.getText();
			System.out.println(EmailSub);
			if(EmailSub.contains("Reset your password"))
			{
				test.log(Status.PASS, "Email received for Reset your password").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Email Not received for Reset your password").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Email Not received for Reset your password");
			}

			//Verify received email time
			String EmailTime= notificationpage.MailTime.getText();
			System.out.println("Email time : "+EmailTime);

			DateFormat df = new SimpleDateFormat("HH:mm");
			Date dateft = df.parse(EmailTime);
			String GetMailTime= df.format(dateft);
			System.out.println("Time: " + GetMailTime);

			//Compare the Time		
			Date Mdate = df.parse(GetMailTime);

			Date Cdate = df.parse(FormatedDeviceTime);

			if(Mdate.after(Cdate)==true| Mdate.equals(Cdate)) 
			{
				test.log(Status.PASS, "received the latest email");
			}
			else
			{
				test.log(Status.FAIL, "latest email not received");
				Assert.fail("latest email not received");
			}



		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}
	}

	//Verify user receiving reset password mail when the user do send again
	@Test()
	public void TC_SignIn_005(Method method) throws Exception
	{

		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module: Sign In").assignCategory("SignIn");
		test.info("Verify user receiving reset password mail when the user do send again");
		driver.resetApp();
		System.out.println(TC_Method);
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();	
		GeneralFunctions generalFunctions = new GeneralFunctions();
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		NotificationPage notificationpage= new NotificationPage(driver);
		try 
		{
			generalFunctions.isElementPresent(signInPage.signinPresent, 90);
			signInPage.signinPresent.click();
			generalFunctions.isElementPresent(signInPage.forgotElement, 90);
			signInPage.forgotElement.click();		
			if(generalFunctions.isElementPresent(signInPage.forgotPasswordScreen, 10)) {
				test.log(Status.PASS, "Forgot Password is working and displayed Forgot Password success Screen");
			}else {
				test.log(Status.FAIL, "Forgot Password button is not working");
				Assert.fail("Forgot Password button is not working");
			}
			signInFunctions.resetEmail(signInPage);
			signInPage.sendResetLink.click();
			Thread.sleep(5000);
			signInPage.sendResetLink.click();
			generalFunctions.isElementPresent(signInPage.checkYourEmail, 90);
			if(generalFunctions.isElementPresent(signInPage.checkYourEmail, 90)) {
				test.log(Status.PASS, "The Reset Password linke sent to the email id:"+signInPage.screenText.getText());
			}else {
				test.log(Status.FAIL, "Forgot Password Reset is not working");
			}
			String Dvtime = driver.getDeviceTime();
			System.out.println("device time: "+Dvtime);
			//SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);	
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX", Locale.ENGLISH);
			Date parsedDate = sdf.parse(Dvtime);
			SimpleDateFormat print = new SimpleDateFormat("HH:mm");	
			String FormatedDeviceTime = print.format(parsedDate);	
			System.out.println("Formated Device Time : "+FormatedDeviceTime);
			Thread.sleep(10000);

			driver.pressKey(new KeyEvent(AndroidKey.HOME));
			driver.startActivity(new Activity("com.google.android.gm","ConversationListActivityGmail"));
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Thread.sleep(10000);

			//Tap on Search
			notificationpage.SearchBox.click();


			//Search email	
			if(generalFunctions.isElementPresent(notificationpage.SearchMail, 10)) {
				test.log(Status.PASS, "The Mail box is displayed");
			}else {
				test.log(Status.FAIL, "The mail box is not displayed");
			}
			notificationpage.SearchMail.click();
			Thread.sleep(5000);
			//accountPage.SearchMail.sendKeys("SHARE");
			Actions action = new Actions(driver);
			action.sendKeys("SHARE").perform();

			driver.pressKey(new KeyEvent(AndroidKey.ENTER));


			//Verify Thanks button displayed
			String EmailSub= notificationpage.MailSubject.getText();
			System.out.println(EmailSub);
			if(EmailSub.contains("Reset your password"))
			{
				test.log(Status.PASS, "Email received for Reset your password").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Email Not received for Reset your password").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Email Not received for Reset your password");
			}

			//Verify received email time
			String EmailTime= notificationpage.MailTime.getText();
			System.out.println("Email time : "+EmailTime);

			DateFormat df = new SimpleDateFormat("HH:mm");
			Date dateft = df.parse(EmailTime);
			String GetMailTime= df.format(dateft);
			System.out.println("Time: " + GetMailTime);

			//Compare the Time		
			Date Mdate = df.parse(GetMailTime);

			Date Cdate = df.parse(FormatedDeviceTime);

			if(Mdate.after(Cdate)==true| Mdate.equals(Cdate)) 
			{
				test.log(Status.PASS, "received the latest email");
			}
			else
			{
				test.log(Status.FAIL, "latest email not received");
				Assert.fail("latest email not received");
			}



		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			
		}
	}


	//Verify user can view the password by clicking on the eye icon
	@Test()
	public void TC_SignIn_008(Method method) throws Exception
	{

		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module: Sign In").assignCategory("SignIn");
		test.info("Verify user can view the password by clicking on the eye icon");
		driver.resetApp();
		System.out.println(TC_Method);
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();	
		GeneralFunctions generalFunctions = new GeneralFunctions();
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();

		try 
		{
			splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(signInPage.signinPresent, 90);
			signInPage.signinPresent.click();
			generalFunctions.isElementPresent(signInPage.useridElement, 90);
			signInFunctions.useremailid(signInPage);
			String inpass ="Test@123";
			generalFunctions.isElementPresent(registrationPage.passwordElement, 10);
			signInPage.userpassElement.sendKeys(inpass);
//			registrationPage.passwordElement.sendKeys(inpass);
			registrationPage.showPassword.click();
			String currentpass = signInPage.userpassElement.getText();
			if(generalFunctions.isElementPresent(registrationPage.showPassword, 10)) {
				test.log(Status.PASS, "The Password is displayed"+currentpass);
			}else {
				test.log(Status.FAIL, "The password id not displayed and the button is not working");
			}


		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail(e.getMessage());
		}


	}

	
	@Test(dataProvider = "signindata")//iteration:Sign in using invalid combinations
	public void TC_SignIn_009_to_012(Method method, String signuser, String signpass) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module: Sign In").assignCategory("SignIn");
		test.info("Sign in using invalid combinations");
		driver.resetApp();
		System.out.println(TC_Method);
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();	
		GeneralFunctions generalFunctions = new GeneralFunctions();
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		NotificationPage notificationpage= new NotificationPage(driver);
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		try 
		{
			String pass = signpass;
			generalFunctions.isElementPresent(signInPage.signinPresent, 90);
			signInPage.signinPresent.click();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			signInPage.useridElement.sendKeys(signuser);
			signInPage.userpassElement.sendKeys(pass);
			signInPage.signinElement.click();		
			if(generalFunctions.isElementPresent(signInPage.signErrorMessage, 10)) {
				test.log(Status.PASS, "Username or Password is invalid and Error message displayed");
			}else {
				test.log(Status.FAIL, "Error message not displayed");
				Assert.fail("Error message not displayed");
			}
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}
	}
	
	//Verify user is navigated to sign up page when clicking on sign up hyperlink in login screen  
	@Test
	public void TC_SignIn_015(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module: Sign In").assignCategory("SignIn");
		test.info("Verify user is navigated to sign up page when clicking on sign up hyperlink in login screen  ");
		driver.resetApp();
		System.out.println(TC_Method);
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();	
		GeneralFunctions generalFunctions = new GeneralFunctions();
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		NotificationPage notificationpage= new NotificationPage(driver);
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		try 
		{
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInPage.signinPresent.click();
			splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(signInPage.useridElement, 30);
			signInPage.signUpElement.click();
					
			if(generalFunctions.isElementPresent(registrationPage.firstNameElement, 10)) {
				test.log(Status.PASS, "Navigates to Registration screen");
			}else {
				test.log(Status.FAIL, "Not navigates to Registration screen");
				Assert.fail("Not navigates to Registration screen");
			}
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}
	}
	
	
	
	
	
}




	//	
	//	///----V1 Scripting----///
	//	@Test
	//	public void TC_Splash_Screen_001_002(Method method) throws Exception
	//	{
	//		String TC_Method = method.getName();
	//		test = extent.createTest(TC_Method).assignCategory("SignIn");
	//		test.log(Status.INFO,"Contact_Us");
	//		driver.resetApp();
	//		System.out.println(TC_Method);
	//		SignInPage signInPage = new SignInPage(driver);
	//		SignInFunctions signInFunctions = new SignInFunctions();
	//		AssistantPage assistantPage = new AssistantPage(driver);
	//		AssistantFunctions assistantFunctions = new AssistantFunctions();
	//		RegistrationPage registrationPage = new RegistrationPage(driver);
	//		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
	//		GeneralFunctions generalFunctions = new GeneralFunctions();
	//		HomePage homepage = new HomePage(driver);
	//		HomeFunctions homeFunctions = new HomeFunctions();
	//		generalFunctions.isElementPresent(signInPage.contactus, 60);
	//		if(signInPage.contactus.isDisplayed()==true) {
	//
	//			test.log(Status.PASS, "Verify Need help? Contact Us Text link is Displayed ").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
	//		}else {
	//			test.log(Status.FAIL, "Verify Need help? Contact Us Text link is  NOT Displayed ").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
	//
	//		}
	//		signInFunctions.contactUs(signInPage);
	//		//Email id
	//		//generalFunctions.isElementPresent(assistantPage.assistantEmail, 90);
	//		generalFunctions.isElementPresent(registrationPage.emailElement, 90);
	//		//Screen1
	//		registrationFunctions.emailId(registrationPage);		
	//		registrationFunctions.countryCode(registrationPage);			
	//		//Enter Mobile Number
	//		registrationFunctions.mobileNumber(registrationPage);
	//		/*//assistantPage.assistantEmail.click();
	//		assistantPage.assistantEmailfield.click();
	//		assistantFunctions.assistantemailid(assistantPage);
	//		//driver.hideKeyboard();
	//		//CountryCode
	//		generalFunctions.isElementPresent(assistantPage.assistantCountrycode, 90);
	//		assistantPage.assistantCountrycode.click();
	//		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina (+54)\"))").click();
	//		//MobileNumber
	//		generalFunctions.isElementPresent(assistantPage.assistantPhonenumber, 90);
	//		assistantPage.assistantPhonenumber.click();
	//		registrationFunctions.mobileNumber(registrationPage);
	//		// */
	//		//Reason
	//		generalFunctions.isElementPresent(assistantPage.assisatantReason, 90);
	//		assistantPage.assisatantReason.click();
	//		assistantFunctions.reasonRandom(assistantPage);
	//		//Reason Something else
	//		try {
	//			String reasonText = assistantPage.assistantSomething.getText();
	//			System.out.println(reasonText);
	//			if(reasonText.contains("Something else") ){
	//				assistantPage.assistantOtherReason.sendKeys("Please enter the reason");
	//				driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"SUBMIT\"))");
	//
	//			}
	//		}catch(Exception e){
	//			e.getCause();
	//			e.getStackTrace();
	//		}
	//		//Description
	//		generalFunctions.isElementPresent(assistantPage.assistantDesription, 90);
	//		assistantFunctions.assistdesc(assistantPage);
	//
	//		//Scroll
	//		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"SUBMIT\"))");
	//
	//		//Attachment
	//		//generalFunctions.isElementPresent(assistantPage.assistantAttachment, 90);
	//		//assistantPage.assistantAttachment.click();
	//		//assistantFunctions.allowtoAccess(assistantPage);
	//
	//
	//		//Terms and Conditions
	//		assistantPage.assistantTC.click();
	//		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"2.0 DEFINITIONS\"))");
	//		//	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"RECITAL\"))");
	//		//driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Navigate up']").click();
	//		generalFunctions.isElementPresent(registrationPage.NavigateBack, 90);
	//		registrationPage.NavigateBack.click();
	//		//driver.navigate().back();
	//		//Submit
	//		generalFunctions.isElementPresent(assistantPage.assistantSubmit, 90);
	//		assistantPage.assistantSubmit.click();
	//		//Success
	//		generalFunctions.isElementPresent(assistantPage.assistantOK, 90);
	//		if(assistantFunctions.assistantOk(assistantPage)==true) {
	//			test.log(Status.PASS, "Successfully submitted the feedback").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
	//			assistantPage.assistanSuccess.click();
	//		}else {
	//			test.log(Status.PASS, "Successful alert not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
	//
	//		}
	//
	//	}
	//
	//	@Test()
	//	public void TC_SignIN_001(Method method) throws Exception
	//	{
	//
	//		String TC_Method = method.getName();
	//		test = extent.createTest(TC_Method);
	//		test.log(Status.INFO, "Sign In");
	//		test.info("Verify the user is able to SignIn");
	//		test.assignCategory("SignIn");
	//		driver.resetApp();
	//		System.out.println(TC_Method);
	//		RegistrationPage registrationPage = new RegistrationPage(driver);
	//		RegistrationFunctions registrationFunctions = new RegistrationFunctions();	
	//		GeneralFunctions generalFunctions = new GeneralFunctions();
	//		SignInPage signInPage = new SignInPage(driver);
	//		SignInFunctions signInFunctions = new SignInFunctions();
	//
	//		try 
	//		{
	//
	//			//Logout if already logged in 
	//			generalFunctions.Logout();			
	//			Thread.sleep(5000);
	//
	//			generalFunctions.isElementPresent(registrationPage.onboardScreen, 90);
	//			registrationFunctions.onboardScreenDisplayed(registrationPage);			
	//			generalFunctions.isElementPresent(signInPage.signinPresent, 90);
	//			signInFunctions.SignInUser(signInPage);
	//			Thread.sleep(10000);
	//
	//			try
	//			{
	//				generalFunctions.isElementPresent(registrationPage.StopTutorialElement, 10);
	//				if(registrationPage.StopTutorialElement.isDisplayed()==true)
	//				{
	//					registrationPage.StopTutorialElement.click();
	//					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//
	//					//Click Got It
	//					registrationPage.GotItElement.click();
	//				}
	//			}
	//			catch(Exception x)
	//			{
	//				System.out.println("Stop Tutorial Not Displayed");
	//			}
	//
	//			generalFunctions.isElementPresent(signInPage.homeElement, 90);
	//			if(signInFunctions.homeScreen(signInPage)==true)
	//			{
	//				test.log(Status.PASS, "SignIn is Successfull");
	//				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	//			}
	//			else 
	//			{
	//				test.log(Status.FAIL, "SignIn is not Successful");
	//				Assert.fail("The Sign In is not Successful");
	//			}
	//		}
	//		catch(Exception e)
	//		{
	//			e.printStackTrace();
	//			test.log(Status.FAIL, e.getCause());
	//			test.log(Status.FAIL, e.getMessage());
	//			Assert.fail(e.getMessage());
	//		}
	//	}
	//
	//
	//	//TC_SignIN_002 - Sign in with invalid username and  valid password
	//	@Test()
	//	public void TC_SignIN_02(Method method) {
	//
	//
	//		String TC_Method = method.getName();
	//		test = extent.createTest(TC_Method);
	//		test.log(Status.INFO, "SignIn");
	//		test.info("In-valid Username and Valid Password");
	//		test.assignCategory("SignIn");
	//		//driver.resetApp();
	//		System.out.println(TC_Method);
	//		RegistrationPage registrationPage = new RegistrationPage(driver);
	//		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
	//		GeneralFunctions generalFunctions = new GeneralFunctions();
	//
	//		try 
	//		{
	////
	////			//Logout if already logged in 
	////			generalFunctions.Logout();			
	////			Thread.sleep(5000);
	////
	////			generalFunctions.isElementPresent(registrationPage.onboardScreen, 90);
	////			registrationFunctions.onboardScreenDisplayed(registrationPage);
	//
	//			SignInPage signInPage = new SignInPage(driver);
	//			SignInFunctions signInFunctions = new SignInFunctions();
	//
	//
	//
	//			generalFunctions.isElementPresent(signInPage.signinElement, 90);		
	//			signInPage.signinPresent.click();
	//			signInFunctions.invalidEmail(signInPage);
	//			signInFunctions.userpassword(signInPage);
	//			signInFunctions.signInButton(signInPage);
	//
	//			generalFunctions.isElementPresent(signInPage.SignInErrorElement, 90);
	//			if(signInFunctions.getSignInError(signInPage).contains("Please check your email and password and try again.")){
	//				test.log(Status.PASS, "Error displayed:The Username or Password is Invalid");
	//				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	//			}
	//			else 
	//			{
	//				test.log(Status.FAIL, "Error NOT displayed");
	//				Assert.fail("Error NOT displayed");
	//			}
	//
	//		}
	//		catch(Exception e){
	//			e.printStackTrace();
	//			test.log(Status.FAIL, e.getCause());
	//			test.log(Status.FAIL, e.getMessage());
	//			Assert.fail(e.getMessage());
	//		}
	//	}
	//
	//
	//
	//	//TC_SignIN_003 -  Sign in with valid username and  in-valid password
	//	@Test()
	//	public void TC_SignIN_03(Method method) {
	//
	//
	//		String TC_Method = method.getName();
	//		test = extent.createTest(TC_Method);
	//		test.log(Status.INFO, "Sign In");
	//		test.info("Valid Username and In-Valid Password");
	//		test.assignCategory("SignIn");
	//		driver.resetApp();
	//		System.out.println(TC_Method);
	//		RegistrationPage registrationPage = new RegistrationPage(driver);
	//		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
	//		GeneralFunctions generalFunctions = new GeneralFunctions();
	//		generalFunctions.isElementPresent(registrationPage.onboardScreen, 90);
	//		registrationFunctions.onboardScreenDisplayed(registrationPage);		
	//		SignInPage signInPage = new SignInPage(driver);
	//		SignInFunctions signInFunctions = new SignInFunctions();
	//
	//		try 
	//		{
	//
	//			//Logout if already logged in 
	//			generalFunctions.Logout();			
	//			Thread.sleep(5000);
	//
	//			generalFunctions.isElementPresent(signInPage.signinPresent, 90);			
	//			signInFunctions.signInClick(signInPage);
	//			signInFunctions.useremailid(signInPage);
	//			signInFunctions.invalidpass(signInPage);
	//			signInFunctions.signInButton(signInPage);
	//
	//			generalFunctions.isElementPresent(signInPage.SignInErrorElement, 90);
	//			if(signInFunctions.getSignInError(signInPage).contains("Please check your email and password and try again.")){
	//				test.log(Status.PASS, "Error displayed:The Username or Password is Invalid");
	//				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	//			}
	//			else 
	//			{
	//				test.log(Status.FAIL, "Error NOT displayed");
	//				Assert.fail("Error NOT displayed");
	//			}
	//
	//		}
	//		catch(Exception e){
	//			e.printStackTrace();
	//			test.log(Status.FAIL, e.getCause());
	//			test.log(Status.FAIL, e.getMessage());
	//			Assert.fail(e.getMessage());
	//		}
	//	}
	//}


