package com.share.testscript;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.share.functions.RegistrationFunctions;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.NotificationPage;
import com.share.objectrepository.RegistrationPage;
import com.share.objectrepository.SignInPage;
import com.share.utility.Utilities;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Notification extends DriverSetUp
{

//	
//	GeneralFunctions generalFunctions = new GeneralFunctions();
//	
//	@Test
//	public void TC_NOT_001(Method method) throws Exception
//	{
//		String TC_Method = method.getName();
//		test = extent.createTest(TC_Method);
//		test.log(Status.INFO, "Notification");
//		test.info("User mail validation for Forgot password");
//		test.assignCategory("Notification");
//		driver.activateApp("com.maf.sharesit");
//		String EmailAddress=map.get("UserName").toString();
//						
//		GeneralFunctions GenFunctions = new GeneralFunctions();
//		NotificationPage notificationpage= new NotificationPage(driver);
//		
//		try
//		{
//			
//		
//		//Logout if already logged in 
//		GenFunctions.Logout();
//		
//		Thread.sleep(10000);
//		//Click on Sign in
//		GenFunctions.ClickSignIn();
//		
//		//Verify Sign in page Displayed
//		String Page= notificationpage.PageTitle.getText();
//		System.out.println(Page);
//		if(Page.contains("Sign in"))
//		{
//			test.log(Status.PASS, "Sign in page displayed");
//		}
//		else
//		{
//			test.log(Status.FAIL, "Sign in page Not Displayed");
//			Assert.fail("Sign in page Not Displayed");
//		}	
//		
//		//Click on Forgot password link
//		generalFunctions.isElementPresent(notificationpage.ForgotPassword, 90);
//		notificationpage.ForgotPassword.click();
//		Thread.sleep(15000);
//		
//		//Verify Reset Password page Displayed
//		String ResetPasswordPage= notificationpage.PageTitle.getText();
//		System.out.println(ResetPasswordPage);
//		if(ResetPasswordPage.contains("Reset password"))
//		{
//			test.log(Status.PASS, "Reset password page displayed");
//		}
//		else
//		{
//			test.log(Status.FAIL, "Reset password page Not Displayed");
//			Assert.fail("Reset password page Not Displayed");
//		}
//		
//		//Enter Email Id
//		generalFunctions.isElementPresent(notificationpage.EmailField, 90);
//		notificationpage.EmailField.sendKeys(EmailAddress);
//		
//		//Click Reset Password
//		notificationpage.ResetPasswordButton.click();
//		Thread.sleep(25000);
//		
//		String Dvtime = driver.getDeviceTime();
//		System.out.println("device time: "+Dvtime);
//		//SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);	
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX", Locale.ENGLISH);
//		Date parsedDate = sdf.parse(Dvtime);
//		SimpleDateFormat print = new SimpleDateFormat("HH:mm");	
//		String FormatedDeviceTime = print.format(parsedDate);	
//		System.out.println("Formated Device Time : "+FormatedDeviceTime);
//		
//		
//		//Verify Email sent successfully
//		generalFunctions.isElementPresent(notificationpage.DialogStatus, 90);
//		String EmailStatus= notificationpage.DialogStatus.getText();
//		System.out.println(EmailStatus);
//		if(EmailStatus.contains("Email sent"))
//		{
//			test.log(Status.PASS, "Email sent successfully");
//		}
//		else
//		{
//			test.log(Status.FAIL, "Email Not sent successfully");
//			Assert.fail("Email Not sent successfully");
//		}
//		
//		//Verify Thanks button displayed
//		String Thanks= notificationpage.ThanksButton.getText();
//		System.out.println(Thanks);
//		if(Thanks.contains("THANKS"))
//		{
//			test.log(Status.PASS, "Thanks button displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
//		}
//		else
//		{
//			test.log(Status.FAIL, "Thanks button Not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
//			Assert.fail("Thanks button Not displayed");
//		}
//		
//		//Click THANKS
//		notificationpage.ThanksButton.click();
//		
//		//Close the application
//		driver.closeApp();
//		Thread.sleep(10000);
//		
//		GenFunctions.StartActivity("com.google.android.gm","ConversationListActivityGmail");
//		Thread.sleep(25000);
//
//		//Search email	
//		notificationpage.SearchMail.click();
//		Thread.sleep(5000);
//		//accountPage.SearchMail.sendKeys("SHARE");
//		Actions action = new Actions(driver);
//		action.sendKeys("SHARE").perform();
//
//		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
//		
//		
//		//Verify Thanks button displayed
//		String EmailSub= notificationpage.MailSubject.getText();
//		System.out.println(EmailSub);
//		if(EmailSub.contains("Reset your password"))
//		{
//			test.log(Status.PASS, "Email received for Reset your password").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
//		}
//		else
//		{
//			test.log(Status.FAIL, "Email Not received for Reset your password").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
//			Assert.fail("Email Not received for Reset your password");
//		}
//		
//		//Verify received email time
//		String EmailTime= notificationpage.MailTime.getText();
//		System.out.println("Email time : "+EmailTime);
//		
//		DateFormat df = new SimpleDateFormat("HH:mm");
//		Date dateft = df.parse(EmailTime);
//		String GetMailTime= df.format(dateft);
//		System.out.println("Time: " + GetMailTime);
//		
//		//Compare the Time		
//		Date Mdate = df.parse(GetMailTime);
//		
//		Date Cdate = df.parse(FormatedDeviceTime);
//		
//		if(Mdate.after(Cdate)==true| Mdate.equals(Cdate)) 
//		{
//			test.log(Status.PASS, "received the latest email");
//		}
//		else
//		{
//			test.log(Status.FAIL, "latest email not received");
//			Assert.fail("latest email not received");
//		}
//		}
//		catch(Exception e)
//		{
//			//test.log(Status.FAIL, e.getMessage());
//			//Assert.fail(e.getMessage());
//		}
//	}
//	
//	
//
//	@Test
//	public void TC_NOT_002(Method method) throws Exception
//	{
//		String TC_Method = method.getName();
//		test = extent.createTest(TC_Method);
//		test.log(Status.INFO, "Notification");
//		test.info("User mail validation for Forgot password");
//		test.assignCategory("Notification");
//		driver.activateApp("com.maf.sharesit");
//		String EmailAddress="mafsit@yopmail.com";
//		driver.activateApp("com.maf.sharesit");			
//		GeneralFunctions GenFunctions = new GeneralFunctions();
//		NotificationPage notificationpage= new NotificationPage(driver);
//		
//		try
//		{
//			
//		
//		//Logout if already logged in 
//		GenFunctions.Logout();
//		
//		Thread.sleep(10000);
//		//Click on Sign in
//		GenFunctions.ClickSignIn();
//		
//		//Verify Sign in page Displayed
//		String Page= notificationpage.PageTitle.getText();
//		System.out.println(Page);
//		if(Page.contains("Sign in"))
//		{
//			test.log(Status.PASS, "Sign in page displayed");
//		}
//		else
//		{
//			test.log(Status.FAIL, "Sign in page Not Displayed");
//			Assert.fail("Sign in page Not Displayed");
//		}	
//		
//		//Click on Forgot password link
//		generalFunctions.isElementPresent(notificationpage.ForgotPassword, 90);
//		notificationpage.ForgotPassword.click();
//		Thread.sleep(15000);
//		
//		//Verify Reset Password page Displayed
//		String ResetPasswordPage= notificationpage.PageTitle.getText();
//		System.out.println(ResetPasswordPage);
//		if(ResetPasswordPage.contains("Reset password"))
//		{
//			test.log(Status.PASS, "Reset password page displayed");
//		}
//		else
//		{
//			test.log(Status.FAIL, "Reset password page Not Displayed");
//			Assert.fail("Reset password page Not Displayed");
//		}
//		
//		//Enter Email Id
//		generalFunctions.isElementPresent(notificationpage.EmailField, 90);
//		notificationpage.EmailField.sendKeys(EmailAddress);
//		
//		//Click Reset Password
//		notificationpage.ResetPasswordButton.click();
//		Thread.sleep(15000);
//		
//		//Verify message
//		generalFunctions.isElementPresent(notificationpage.DialogStatus, 90);
//		String EmailStatus= notificationpage.DialogStatus.getText();
//		System.out.println(EmailStatus);
//		if(EmailStatus.contains("Email not found"))
//		{
//			test.log(Status.PASS, "Message Displayed - Email not found").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
//		}
//		else
//		{
//			test.log(Status.FAIL, "Message Not Displayed - Email not found").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
//			Assert.fail("Message Not Displayed - Email not found");
//		}
//		
//		//Verify message
//		String EmailStatusDesc= notificationpage.DialogDescription.getText();
//		System.out.println(EmailStatusDesc);
//		if(EmailStatusDesc.contains("This email address is not registered with us"))
//		{
//			test.log(Status.PASS, "Message Displayed - This email address is not registered with us");
//		}
//		else
//		{
//			test.log(Status.FAIL, "Message Not Displayed - This email address is not registered with us");
//			Assert.fail("Message Not Displayed - This email address is not registered with us");
//		}
//		}
//		catch(Exception e)
//		{
//			test.log(Status.FAIL, e.getMessage());
//			Assert.fail(e.getMessage());
//		}
//	}
//	
//	
//
//	@Test
//	public void TC_NOT_003(Method method) throws Exception
//	{
//		String TC_Method = method.getName();
//		test = extent.createTest(TC_Method);
//		test.log(Status.INFO, "Notification");
//		test.info("User mail validation for Forgot password");
//		test.assignCategory("Notification");
//		driver.activateApp("com.maf.sharesit");
//		String EmailAddress="test@test";
//						
//		GeneralFunctions GenFunctions = new GeneralFunctions();
//		NotificationPage notificationpage= new NotificationPage(driver);
//		
//		try
//		{
//			
//		
//		//Logout if already logged in 
//		GenFunctions.Logout();
//		
//		Thread.sleep(10000);
//		//Click on Sign in
//		GenFunctions.ClickSignIn();
//		
//		//Verify Sign in page Displayed
//		String Page= notificationpage.PageTitle.getText();
//		System.out.println(Page);
//		if(Page.contains("Sign in"))
//		{
//			test.log(Status.PASS, "Sign in page displayed");
//		}
//		else
//		{
//			test.log(Status.FAIL, "Sign in page Not Displayed");
//			Assert.fail("Sign in page Not Displayed");
//		}	
//		
//		//Click on Forgot password link
//		generalFunctions.isElementPresent(notificationpage.ForgotPassword, 90);
//		notificationpage.ForgotPassword.click();
//		Thread.sleep(15000);
//		
//		//Verify Reset Password page Displayed
//		String ResetPasswordPage= notificationpage.PageTitle.getText();
//		System.out.println(ResetPasswordPage);
//		if(ResetPasswordPage.contains("Reset password"))
//		{
//			test.log(Status.PASS, "Reset password page displayed");
//		}
//		else
//		{
//			test.log(Status.FAIL, "Reset password page Not Displayed");
//			Assert.fail("Reset password page Not Displayed");
//		}
//		
//		//Enter Email Id
//		generalFunctions.isElementPresent(notificationpage.EmailField, 90);
//		notificationpage.EmailField.sendKeys(EmailAddress);
//		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
//		Thread.sleep(15000);
//		
//		//Verify message
//		String ErrorMsg= notificationpage.ErrorMessage.getText();
//		System.out.println(ErrorMsg);
//		if(ErrorMsg.contains("This email address is not valid"))
//		{
//			test.log(Status.PASS, "Error Message Displayed");
//		}
//		else
//		{
//			test.log(Status.FAIL, "Error Message Not Displayed");
//			Assert.fail("Error Message Not Displayed");
//		}
//		}
//		catch(Exception e)
//		{
//			test.log(Status.FAIL, e.getMessage());
//			Assert.fail(e.getMessage());
//		}
//	}
//	
//	
//	@Test
//	public void TC_NOT_004(Method method) throws Exception
//	{
//		String TC_Method = method.getName();
//		test = extent.createTest(TC_Method);
//		test.log(Status.INFO, "Notification");
//		test.info("Verify user is able to Gift points to member");
//		test.assignCategory("Notification");
//		driver.activateApp("com.maf.sharesit");
//		String EmailAddress=map.get("Family_UserName").toString();
//		String Pass=map.get("Family_UserPassword").toString();
//						
//		GeneralFunctions GenFunctions = new GeneralFunctions();
//		NotificationPage notificationpage= new NotificationPage(driver);
//		RegistrationPage registrationPage= new RegistrationPage(driver);
//		AccountPage accountPage = new AccountPage(driver);
//		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
//		SignInPage signInPage = new SignInPage(driver);
//		try
//		{
//		
//		//LOGIN
//		registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);		
//		
//		//Click on Account Icon
//		accountPage.AccountIcon.click();
//		Thread.sleep(15000);				
//		
//		generalFunctions.isElementPresent(notificationpage.PointBalance, 90);
//		String Balance= notificationpage.PointBalance.getText();
//		Balance = Balance.replace(",", "");		
//		double d = Double.parseDouble(Balance);
//		int i = (int) d;
//		System.out.println("Point Balance: "+i);
//		
//		//Click on Family Group
//		generalFunctions.isElementPresent(notificationpage.FamilyGroup, 90);
//		notificationpage.FamilyGroup.click();
//		Thread.sleep(15000);	
//		
//		//Select Member
//		generalFunctions.isElementPresent(notificationpage.FamilyMember, 90);
//		notificationpage.FamilyMember.click();
//		Thread.sleep(15000);
//		
//		//Enter Gift Point
//		int giftAmount =i+10;
//		String giftpointAmount = Integer.toString(giftAmount); 
//		notificationpage.GiftPoint.sendKeys(giftpointAmount);
//		Thread.sleep(10000);
//		
//		//Verify message
//		generalFunctions.isElementPresent(notificationpage.ErrorMessage, 90);
//		String ErrorMsg= notificationpage.ErrorMessage.getText();
//		System.out.println(ErrorMsg);
//		if(ErrorMsg.contains("Sorry, that�s more points than you currently have"))
//		{
//			test.log(Status.PASS, "Error Message Displayed");
//		}
//		else
//		{
//			test.log(Status.FAIL, "Error Message Not Displayed");
//			Assert.fail("Error Message Not Displayed");
//		}
//		}
//		catch(Exception e)
//		{
//			test.log(Status.FAIL, e.getMessage());
//			Assert.fail(e.getMessage());
//		}
//	}
//	
//	
//	@Test
//	public void TC_NOT_005(Method method) throws Exception
//	{
//		String TC_Method = method.getName();
//		test = extent.createTest(TC_Method);
//		test.log(Status.INFO, "Notification");
//		test.info("Verify user is able to Gift points to member");
//		test.assignCategory("Notification");
//		driver.activateApp("com.maf.sharesit");
//		String EmailAddress=map.get("Family_UserName").toString();
//		String Pass=map.get("Family_UserPassword").toString();
//		String Point=map.get("GiftPoint").toString();
//						
//		GeneralFunctions GenFunctions = new GeneralFunctions();
//		NotificationPage notificationpage= new NotificationPage(driver);
//		RegistrationPage registrationPage= new RegistrationPage(driver);
//		AccountPage accountPage = new AccountPage(driver);
//		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
//		SignInPage signInPage = new SignInPage(driver);
//		try
//		{
//			
//		
//		//LOGIN
//		registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);		
//		
//		//Click on Account Icon
//		accountPage.AccountIcon.click();
//		Thread.sleep(15000);				
//		
//		generalFunctions.isElementPresent(notificationpage.PointBalance, 90);
//		String Balance= notificationpage.PointBalance.getText();
//		Balance = Balance.replace(",", "");		
//		double d = Double.parseDouble(Balance);
//		int i = (int) d;
//		System.out.println("Point Balance: "+i);
//		
//		//Click on Family Group
//		generalFunctions.isElementPresent(notificationpage.FamilyGroup, 90);
//		notificationpage.FamilyGroup.click();
//		Thread.sleep(15000);	
//		
//		//Select Member
//		generalFunctions.isElementPresent(notificationpage.FamilyMember, 90);
//		notificationpage.FamilyMember.click();
//		Thread.sleep(15000);
//		
//		//Enter Gift Point
//		notificationpage.GiftPoint.sendKeys(Point);
//
//		//Click Gift Point Button
//		generalFunctions.isElementPresent(notificationpage.GiftPointButton, 90);
//		notificationpage.GiftPointButton.click();
//		Thread.sleep(15000);
//		
//		//Verify message
//		generalFunctions.isElementPresent(notificationpage.DialogStatus, 90);
//		String GiftStatus= notificationpage.DialogStatus.getText();
//		System.out.println(GiftStatus);
//		if(GiftStatus.contains("POINTS SENT"))
//		{
//			test.log(Status.PASS, "Point Gifted Successfully").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
//		//	test.log(Status.PASS, "Point Gifted Successfully");
//		}
//		else
//		{
//			test.log(Status.FAIL, "Failed to send Gift Point").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
//			Assert.fail("Failed to send Gift Point");
//		}
//		
//		//Click Thanks
//		notificationpage.Thanks.click();
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//		}
//		catch(Exception e)
//		{
//			test.log(Status.FAIL, e.getMessage());
//			Assert.fail(e.getMessage());
//		}
//	}
	
		
	


	
}
