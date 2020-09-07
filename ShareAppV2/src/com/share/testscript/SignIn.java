package com.share.testscript;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.share.functions.SignInFunctions;
import com.share.functions.SplashScreenFunctions;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.RegistrationPage;
import com.share.objectrepository.SignInPage;
import com.share.objectrepository.SplashScreenPage;
import com.share.utility.Utilities;

public class SignIn extends DriverSetUp
{

	//Launch the shareapp and click on "Sign in" button
	@Test(priority = 6)
	public void TC_SignIn_001_002_007(Method method) throws Exception
	{

		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module: Sign In").assignCategory("SIGNIN");
		test.info("Launch the share app and click on Sign in button");
		driver.resetApp();
		System.out.println(TC_Method);
		RegistrationPage registrationPage = new RegistrationPage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();

		try
		{

			signInFunctions.quickSignIn();
			if(generalFunctions.isElementPresent(registrationPage.HomeIcon, 90)) {
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

	//	//Verify user lands on Home screen
	//	@Test()
	//	public void TC_SignIn_002(Method method) throws Exception
	//	{
	//
	//		String TC_Method = method.getName();
	//		test = extent.createTest(TC_Method);
	//		test.log(Status.INFO, "Module: Sign In").assignCategory("SIGNIN");
	//		test.info("Verify user lands on Home screen");
	//		driver.resetApp();
	//		System.out.println(TC_Method);
	//		RegistrationPage registrationPage = new RegistrationPage(driver);
	//		GeneralFunctions generalFunctions = new GeneralFunctions();
	//		SignInFunctions signInFunctions = new SignInFunctions();
	//		try
	//		{
	//					signInFunctions.validUserLogin();
	//
	//			if(generalFunctions.isElementPresent(registrationPage.HomeIcon, 90)) {
	//				test.log(Status.PASS, "User lands on Home screen");
	//			}else {
	//				test.log(Status.FAIL, "User not lands on Home screen and not displayed the Tutorial");
	//				Assert.fail("User not lands on Home screen");
	//			}
	//
	//
	//		}catch(Exception e) {
	//			e.printStackTrace();
	//			e.getCause();
	//			e.getMessage();
	//		}
	//	}

	//Verify user can reset Password
	@Test(priority = 4)
	public void TC_SignIn_003_004(Method method) throws Exception
	{

		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module: Sign In").assignCategory("SIGNIN");
		test.info("Verify user can reset Password");
		driver.resetApp();
		System.out.println(TC_Method);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		try
		{
			splashScreenFunctions.splashScreenSkip(splashScreenPage);
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
			/*
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
			 */


		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}
	}

	//Verify user receiving reset password mail when the user do send again
	@Test(priority = 5)
	public void TC_SignIn_005(Method method) throws Exception
	{

		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module: Sign In").assignCategory("SIGNIN");
		test.info("Verify user receiving reset password mail when the user do send again");
		driver.resetApp();
		System.out.println(TC_Method);
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
			generalFunctions.isElementPresent(signInPage.sendAgain, 90);
			signInPage.sendAgain.click();
			if(generalFunctions.isElementPresence(signInPage.sendAgainToast, 60)) {
				test.log(Status.PASS, "Able to resend the mail: "+signInFunctions.sendAgaintoast());
			}else {
				test.log(Status.FAIL, "Unable to resend the mail");
			}
			/*
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

			 */
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();

		}
	}


	//Verify user can view the password by clicking on the eye icon
	@Test(priority = 3)
	public void TC_SignIn_008(Method method) throws Exception
	{

		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module: Sign In").assignCategory("SIGNIN");
		test.info("Verify user can view the password by clicking on the eye icon");
		driver.resetApp();
		System.out.println(TC_Method);
		RegistrationPage registrationPage = new RegistrationPage(driver);
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
			generalFunctions.isElementPresent(signInPage.userpassElement, 90);
			signInFunctions.userpassword(signInPage);
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


	@Test(priority = 2, dataProvider = "signindata")//iteration:Sign in using invalid combinations
	public void TC_SignIn_009_to_014(Method method, String signuser, String signpass) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module: Sign In").assignCategory("SIGNIN");
		test.info("Sign in using invalid combinations");
		//driver.resetApp();
		System.out.println(TC_Method);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		SignInPage signInPage = new SignInPage(driver);
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{
			//String pass = signpass;
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			if(generalFunctions.isElementPresent(signInPage.signinPresent, 30)) {
				test.log(Status.PASS, "SignIn Button Present");
				signInPage.signinPresent.click();
			}else {
				test.log(Status.FAIL, "SignIn Button NOT Present");
			}
			if(generalFunctions.isElementPresent(signInPage.useridElement, 30)) {
				signInPage.useridElement.clear();
				signInPage.useridElement.sendKeys(signuser);
				test.log(Status.PASS, "Email id field Present: "+signuser);
			}else {
				test.log(Status.FAIL, "Email id field NOT Present");
			}
			if(generalFunctions.isElementPresent(signInPage.userpassElement, 30)) {
				signInPage.userpassElement.clear();
				signInPage.userpassElement.sendKeys(signpass);
				test.log(Status.PASS, "Password field Present: "+signpass);
			}else {
				test.log(Status.FAIL, "Password field NOT Present");
			}
			if(signInPage.signinElement.isEnabled()) {
				test.log(Status.PASS, "SignIn Button Enabled");
				signInPage.signinElement.click();
				if(generalFunctions.isElementPresence(signInPage.signInErrorToast, 60))  {
					test.log(Status.PASS, "Username or Password is invalid and Error message displayed: "+signInFunctions.signInErrortoast()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}else {
					test.log(Status.FAIL, "Error message not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}
			}else {
				test.log(Status.PASS, "SignIn Button NOT Enabled").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			driver.navigate().back();
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
			Assert.fail("Error Occured"+e.getCause());
		}
	}


	//Verify user is navigated to sign up page when clicking on sign up hyperlink in login screen
	@Test(priority = 1)
	public void TC_SignIn_015(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module: Sign In").assignCategory("SIGNIN");
		test.info("Verify user is navigated to sign up page when clicking on sign up hyperlink in login screen  ");
		driver.resetApp();
		System.out.println(TC_Method);
		RegistrationPage registrationPage = new RegistrationPage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		SignInPage signInPage = new SignInPage(driver);
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		try
		{
			splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
			signInPage.signinPresent.click();
			generalFunctions.isElementPresent(signInPage.useridElement, 30);
			signInPage.signUpElement.click();

			if(generalFunctions.isElementPresent(registrationPage.firstNameElement, 10)) {
				test.log(Status.PASS, "Navigates to Registration screen").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else {
				test.log(Status.FAIL, "Not navigates to Registration screen").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Not navigates to Registration screen");
			}
			driver.navigate().back();
			generalFunctions.isElementPresent(signInPage.signinPresent, 30);
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}
	}

}


