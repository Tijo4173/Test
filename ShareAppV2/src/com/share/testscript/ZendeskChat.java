package com.share.testscript;

import java.lang.reflect.Method;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.share.functions.RegistrationFunctions;
import com.share.functions.SignInFunctions;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.RegistrationPage;
import com.share.objectrepository.SignInPage;
import com.share.objectrepository.ZendeskChatPage;
import com.share.utility.Utilities;

public class ZendeskChat extends DriverSetUp {
	
	//Sprint 16 implementations
	@Test
	public void Chat_001(Method method) throws Exception
	{
		String TC_method = method.getName();
		System.out.println(TC_method);
		test = extent.createTest(TC_method).assignCategory("CHAT");
		test.log(Status.INFO, "Module:CHAT");
		test.log(Status.INFO, "TC: Verify the user able to view Chat Icon in join now");
		driver.resetApp();
		SignInFunctions signInFunctions = new SignInFunctions();
		signInFunctions.SignContinue();
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		ZendeskChatPage zendeskchatpage = new ZendeskChatPage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		try
		{	generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			
			if(generalFunctions.isElementPresent(zendeskchatpage.chaticon, 30)) {
				test.log(Status.PASS, "User should be able to view Chat icon in join now screen").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}else {
				test.log(Status.FAIL, "User is not able to view need Chat icon join now screen").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}//	
		}
		catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}
	}
	@Test
	public void Chat_002(Method method) throws Exception
	{
		String TC_method = method.getName();
		System.out.println(TC_method);
		test = extent.createTest(TC_method).assignCategory("CHAT");
		test.log(Status.INFO, "Module:CHAT");
		test.log(Status.INFO, "TC: Verify the user able to view Chat Screen with automated chat box message from join now");
		driver.resetApp();
		SignInFunctions signInFunctions = new SignInFunctions();
		signInFunctions.SignContinue();
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		ZendeskChatPage zendeskchatpage = new ZendeskChatPage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		try
		{	generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(zendeskchatpage.chaticon, 20);
			zendeskchatpage.chaticon.click();
			if(generalFunctions.isElementPresent(zendeskchatpage.chatscreen, 20)) {
				test.log(Status.PASS, "User should be able to view Chat Screen from join now").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}else {
				test.log(Status.FAIL, "User is not able to view need Chat screen from join now").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}
	}
	
	@Test
	public void Chat_003(Method method) throws Exception
	{
		String TC_method = method.getName();
		System.out.println(TC_method);
		test = extent.createTest(TC_method).assignCategory("CHAT");
		test.log(Status.INFO, "Module:CHAT");
		test.log(Status.INFO, "TC: Verify the user able to view Chat Icon in Sign In Screen");
		driver.resetApp();
		SignInFunctions signInFunctions = new SignInFunctions();
		signInFunctions.SignContinue();//For sprint 18
		SignInPage signInPage = new SignInPage(driver);
		ZendeskChatPage zendeskchatpage = new ZendeskChatPage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		try
		{	generalFunctions.isElementPresent(signInPage.signinPresent, 90);
			signInPage.signinPresent.click();
			if(generalFunctions.isElementPresent(zendeskchatpage.chaticon, 20)) {
				test.log(Status.PASS, "User should be able to view Chat icon in Sign in screen").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}else {
				test.log(Status.FAIL, "User is not able to view Chat icon in Sign in screen").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}
	}
	@Test
	public void Chat_004(Method method) throws Exception
	{
		String TC_method = method.getName();
		System.out.println(TC_method);
		test = extent.createTest(TC_method).assignCategory("CHAT");
		test.log(Status.INFO, "Module:CHAT");
		test.log(Status.INFO, "TC: Verify the user able to view Chat Screen with automated chat box message from sigin in");
		driver.resetApp();
		SignInFunctions signInFunctions = new SignInFunctions();
		signInFunctions.SignContinue();
		SignInPage signInPage = new SignInPage(driver);
		ZendeskChatPage zendeskchatpage = new ZendeskChatPage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		try
		{	generalFunctions.isElementPresent(signInPage.signinPresent, 90);
			signInPage.signinPresent.click();
			generalFunctions.isElementPresent(zendeskchatpage.chaticon, 20);
			zendeskchatpage.chaticon.click();
			if(generalFunctions.isElementPresent(zendeskchatpage.chatscreen, 20)) {
				test.log(Status.PASS, "User should be able to view Chat Screen from SignIn screen").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}else {
				test.log(Status.FAIL, "User is not able to view Chat Screen from SignIn screen").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}
	}
}
