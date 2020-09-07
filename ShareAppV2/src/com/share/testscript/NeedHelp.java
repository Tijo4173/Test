package com.share.testscript;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.share.functions.NeedHelpFunctions;
import com.share.functions.RegistrationFunctions;
import com.share.functions.SignInFunctions;
import com.share.functions.SplashScreenFunctions;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.NeedHelpPage;
import com.share.objectrepository.RegistrationPage;
import com.share.objectrepository.SignInPage;
import com.share.objectrepository.SplashScreenPage;
import com.share.utility.Utilities;

public class NeedHelp extends DriverSetUp {

	//TC:Verify User can submit need help form
	@Test(priority = 5)
	public void NeedHelp_005(Method method) throws Exception
	{

		String TC_method = method.getName();
		System.out.println(TC_method);
		test = extent.createTest(TC_method).assignCategory("NEEDHELP");
		test.log(Status.INFO, "Module:Need help");
		test.log(Status.INFO, "TC:Verify User can submit need help form");
		driver.resetApp();
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		NeedHelpPage needHelpPage = new NeedHelpPage(driver);
		NeedHelpFunctions needHelpFunctions = new NeedHelpFunctions();
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();

		try
		{
			splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			if(generalFunctions.isElementPresent(needHelpPage.needHelp, 60)) {
				test.log(Status.PASS, "User should be able to view need help in join now screen").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
				needHelpFunctions.needHelpElement(needHelpPage);

			}else {
				test.log(Status.FAIL, "User is not able to view need help in join now screen").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}
			if(generalFunctions.isElementPresent(needHelpPage.needHelpTitle, 30)) {
				test.log(Status.PASS, "Need help screen displayed");
			}else {
				test.log(Status.FAIL, "Need help Screen NOT displayed");
			}
			generalFunctions.isElementPresent(needHelpPage.emailAddress, 20);
			needHelpFunctions.emailAddressElement(needHelpPage);
			needHelpFunctions.countryCodeHelp(registrationPage);
			needHelpFunctions.phoneNumberElement(needHelpPage);
			needHelpFunctions.reasonElement(needHelpPage);
			needHelpFunctions.reasonOptElement(needHelpPage);
			needHelpFunctions.descriptionElement(needHelpPage);
			if(needHelpPage.submit.isEnabled()) {
				test.log(Status.PASS, "Fields are updated with data and the Submit button is Enabled").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));

			}else {
				test.log(Status.FAIL, "Fields are updated with data but the Submit button is NOT Enabled").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}
			driver.hideKeyboard();
			needHelpFunctions.submitSignElement(needHelpPage);
			if(generalFunctions.isElementPresent(needHelpPage.btnDone, 30)) {
				test.log(Status.PASS, "Need help form is submitted successfully"+needHelpPage.successMessageTitle.getText()+":"+needHelpPage.successMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));

			}else {
				test.log(Status.FAIL, "Need help form is not submitted successfully").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}

			needHelpFunctions.btnDoneElement(needHelpPage);
			generalFunctions.isElementPresent(needHelpPage.needHelp, 30);
		}

		catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}

	}

	//TC:Verify User can submit need help form
	@Test(priority = 6)
	public void NeedHelp_006(Method method) throws Exception
	{

		String TC_method = method.getName();
		System.out.println(TC_method);
		test = extent.createTest(TC_method).assignCategory("NEEDHELP");
		test.log(Status.INFO, "Module:Needhelp");
		test.log(Status.INFO, "TC:Verify User can submit need help form");
		driver.resetApp();
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		NeedHelpPage needHelpPage = new NeedHelpPage(driver);
		NeedHelpFunctions needHelpFunctions = new NeedHelpFunctions();
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();

		try
		{
			splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(signInPage.signinPresent, 90);
			signInPage.signinPresent.click();
			if(generalFunctions.isElementPresent(needHelpPage.needHelp, 60)) {
				test.log(Status.PASS, "User should be able to view need help in sign in screen").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
				needHelpFunctions.needHelpElement(needHelpPage);

			}else {
				test.log(Status.FAIL, "User is not able to view need help in sign in screen").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}
			if(generalFunctions.isElementPresent(needHelpPage.needHelpTitle, 30)) {
				test.log(Status.PASS, "Need help screen displayed");
			}else {
				test.log(Status.FAIL, "Need help Screen NOT displayed");
			}
			generalFunctions.isElementPresent(needHelpPage.emailAddress, 20);
			needHelpFunctions.emailAddressElement(needHelpPage);
			needHelpFunctions.countryCodeHelp(registrationPage);
			needHelpFunctions.phoneNumberElement(needHelpPage);
			needHelpFunctions.reasonElement(needHelpPage);
			needHelpFunctions.reasonOptElement(needHelpPage);
			needHelpFunctions.descriptionElement(needHelpPage);
			if(needHelpPage.submit.isEnabled()) {
				test.log(Status.PASS, "Fields are updated with data and the Submit button is Enabled").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));

			}else {
				test.log(Status.FAIL, "Fields are updated with data but the Submit button is NOT Enabled").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}
			driver.hideKeyboard();
			needHelpFunctions.submitSignElement(needHelpPage);
			if(generalFunctions.isElementPresent(needHelpPage.btnDone, 30)) {
				test.log(Status.PASS, "Need help form is submitted successfully"+needHelpPage.successMessageTitle.getText()+":"+needHelpPage.successMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));

			}else {
				test.log(Status.FAIL, "Need help form is not submitted successfully").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}

			needHelpFunctions.btnDoneElement(needHelpPage);
			generalFunctions.isElementPresent(needHelpPage.needHelp, 30);
		}

		catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}

	}

	//**************************************need help validation********************************************//

	//Need Help Validation for Sign Up Module

	@Test(priority = 1)
	public void NeedHelp_001(Method method)throws Exception
	{

		String TC_method = method.getName();
		System.out.println(TC_method);
		test = extent.createTest(TC_method).assignCategory("NEEDHELP");
		test.log(Status.INFO, "Scenario:Need Help");
		test.log(Status.INFO, "Module:Sign Up");
		test.log(Status.INFO, "Verify that the error message is displayed when email address is empty");
		driver.resetApp();
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		NeedHelpPage needHelpPage = new NeedHelpPage(driver);
		NeedHelpFunctions needHelpFunctions = new NeedHelpFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();

		try
		{
			splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(needHelpPage.needHelp, 30);
			needHelpFunctions.needHelpElement(needHelpPage);
			generalFunctions.isElementPresent(needHelpPage.emailAddress, 20);
			needHelpFunctions.emailAddressElementVal(needHelpPage);
			needHelpFunctions.phoneNumberElementVal(needHelpPage);
			needHelpFunctions.emailAddressValFun(needHelpPage);
			if(generalFunctions.isElementPresent(needHelpPage.emailAddressVal, 10)) {
				test.log(Status.PASS, "Error message for email address is shown and the field is mandatory");
			}else {
				test.log(Status.FAIL, "Error message is not shown ");
				Assert.fail("Error message is not shown ");
			}

			driver.hideKeyboard();
			Thread.sleep(3000);
			if(needHelpPage.submit.isEnabled()==false) {
				test.log(Status.PASS, "Submit button is disabled");

			}else {
				test.log(Status.FAIL, "Submit button is enabled");
			}

		}

		catch(Exception e)
		{
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}
	}

	@Test(priority = 2)
	public void NeedHelp_002(Method method) throws Exception


	{


		String TC_method = method.getName();
		System.out.println(TC_method);
		test = extent.createTest(TC_method).assignCategory("NEEDHELP");
		test.log(Status.INFO, "Scenario:Need Help");
		test.log(Status.INFO, "Module:Sign Up");
		test.log(Status.INFO, "Verify error message is displayed when country code is left blank ");
		driver.resetApp();
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		NeedHelpPage needHelpPage = new NeedHelpPage(driver);
		NeedHelpFunctions needHelpFunctions = new NeedHelpFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();

		try

		{
			splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(needHelpPage.needHelp, 10);
			needHelpFunctions.needHelpElement(needHelpPage);
			generalFunctions.isElementPresent(needHelpPage.emailAddress, 20);
			needHelpFunctions.emailAddressElement(needHelpPage);
			needHelpFunctions.phoneNumberElement(needHelpPage);
			needHelpPage.emailAddress.click();
			//needHelpFunctions.descriptionElement(needHelpPage);
			//needHelpFunctions.countryCodeFun(needHelpPage);
			if(generalFunctions.isElementPresent(needHelpPage.mobNumVal, 10)) {
				test.log(Status.PASS, "Error message  for country code is shown and the field is mandatory"+needHelpPage.mobNumVal.getText());
				test.log(Status.PASS, "Submit button is disabled");
			}else {
				test.log(Status.FAIL, "Error message is not shown");
				Assert.fail("Error message is not shown");
			}

			driver.hideKeyboard();
			Thread.sleep(3000);
			if(needHelpPage.submit.isEnabled()==false) {
				test.log(Status.PASS, "Submit button is disabled");

			}else {
				test.log(Status.FAIL, "Submit button is enabled");
			}

		}

		catch(Exception e)

		{
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}
	}

	@Test(priority = 3)
	public void NeedHelp_003(Method method) throws Exception


	{


		String TC_method = method.getName();
		System.out.println(TC_method);
		test = extent.createTest(TC_method).assignCategory("NEEDHELP");
		test.log(Status.INFO, "Scenario:Need Help");
		test.log(Status.INFO, "Module:Sign Up");
		test.log(Status.INFO, "Verify error message is displayed when phone number is left blank ");
		driver.resetApp();
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		NeedHelpPage needHelpPage = new NeedHelpPage(driver);
		NeedHelpFunctions needHelpFunctions = new NeedHelpFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();

		try

		{
			splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);

			Thread.sleep(3000);
			if(generalFunctions.isElementPresent(needHelpPage.needHelp, 10)) {
				test.log(Status.PASS, "need help element is present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));

			}else {
				test.log(Status.FAIL, "need help element is not present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}
			needHelpFunctions.needHelpElement(needHelpPage);
			generalFunctions.isElementPresent(needHelpPage.emailAddress, 20);
			needHelpFunctions.emailAddressElement(needHelpPage);
			needHelpFunctions.countryCodeHelp(registrationPage);
			needHelpFunctions.descriptionElement(needHelpPage);
			//	needHelpFunctions.countryNumFun(needHelpPage);
			if(generalFunctions.isElementPresent(needHelpPage.mobNumVal, 10)) {
				test.log(Status.PASS, "Error message for phone number field is shown and the field is mandatory"+needHelpPage.mobNumVal.getText());
			}
			else {
				test.log(Status.FAIL, "Error message is not shown");
				Assert.fail("Error message is not shown");
			}

			driver.hideKeyboard();
			Thread.sleep(3000);
			if(needHelpPage.submit.isEnabled()==false) {
				test.log(Status.PASS, "Submit button is disabled");

			}else {
				test.log(Status.FAIL, "Submit button is enabled");
			}


		}

		catch(Exception e)

		{
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}
	}


	@Test(priority = 4)
	public void NeedHelp_004(Method method) throws Exception


	{
		driver.resetApp();

		String TC_method = method.getName();
		System.out.println(TC_method);
		test = extent.createTest(TC_method).assignCategory("NEEDHELP");
		test.log(Status.INFO, "Module:Need Help");
		test.log(Status.INFO, "Module:Sign Up");
		test.log(Status.INFO, "Verify error message is displayed when description field is left blank");

		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		NeedHelpPage needHelpPage = new NeedHelpPage(driver);
		NeedHelpFunctions needHelpFunctions = new NeedHelpFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();

		try

		{
			splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);

			Thread.sleep(3000);
			if(generalFunctions.isElementPresent(needHelpPage.needHelp, 10)) {
				test.log(Status.PASS, "need help element is present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));

			}else {
				test.log(Status.FAIL, "need help element is not present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}
			needHelpFunctions.needHelpElement(needHelpPage);
			generalFunctions.isElementPresent(needHelpPage.emailAddress, 20);
			needHelpFunctions.emailAddressElement(needHelpPage);
			needHelpFunctions.countryCodeHelp(registrationPage);
			needHelpFunctions.phoneNumberElement(needHelpPage);
			needHelpFunctions.descriptionElementVal(needHelpPage);
			needHelpFunctions.phoneNumberElementVal(needHelpPage);
			needHelpFunctions.descriptionFun(needHelpPage);
			if(generalFunctions.isElementPresent(needHelpPage.descriptionVal, 10)) {
				test.log(Status.PASS, "Error message for description field is shown and the field is mandatory");
			}
			else
			{
				test.log(Status.FAIL, "Error message is not shown");
				Assert.fail("Error message is not shown");
			}

			driver.hideKeyboard();
			Thread.sleep(3000);
			if(needHelpPage.submit.isEnabled()==false) {
				test.log(Status.PASS, "Submit button is disabled");

			}else {
				test.log(Status.FAIL, "Submit button is enabled");
			}

		}

		catch(Exception e)

		{
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}
	}


	/*
	//Need Help Validation for Sign in module
	@Test
	public void NeedHelp_06(Method method) throws Exception

	{
		driver.resetApp();

		String TC_method = method.getName();
		System.out.println(TC_method);
		test= extent.createTest(TC_method).assignCategory("NEEDHELP");
		test.log(Status.INFO, "Scenario:Need Help");
		test.log(Status.INFO, "Module:Need Help");
		test.log(Status.INFO, "Verify all the mandatory fields are entered in the need help of SIGN IN");

		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		//SignInPage signInPage = new SignInPage(driver);
		//SignInFunctions signInFunctions = new SignInFunctions();
		NeedHelpPage needHelpPage = new NeedHelpPage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();

		try
		{
			splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.signInElement(registrationPage);
			Thread.sleep(3000);
			if(generalFunctions.isElementPresent(needHelpPage.needHelp, 10)) {
				test.log(Status.PASS, "need help element is present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));

			}else {
				test.log(Status.FAIL, "need help element is not present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}

			needHelpFunctions.needHelpElement(needHelpPage);
			registrationFunctions.emailAddressElement(registrationPage);
			registrationFunctions.countryCodeHelp(registrationPage);
			registrationFunctions.phoneNumberElement(registrationPage);
			registrationFunctions.reasonElement(registrationPage);
			registrationFunctions.reasonOptElement(registrationPage);
			registrationFunctions.descriptionElement(registrationPage);

			driver.hideKeyboard();
			if(registrationPage.submit.isEnabled()) {
				test.log(Status.PASS, "All the mandatory fields are entered").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));

			}else {
				test.log(Status.FAIL, "All the mandatory fields are not entered").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}

		}

		catch(Exception e)

		{
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}

	}

	@Test
	public void NeedHelp_07(Method method)throws Exception
	{
		driver.resetApp();

		String TC_method = method.getName();
		System.out.println(TC_method);
		test = extent.createTest(TC_method).assignCategory("NEEDHELP");
		test.log(Status.INFO, "Scenario:Need Help");
		test.log(Status.INFO, "Module:Need Help");
		test.log(Status.INFO, "Verify that the error message is displayed when email address is empty");

		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		NeedHelpPage needHelpPage = new NeedHelpPage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();

		try
		{
			splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.signInElement(registrationPage);

			Thread.sleep(3000);
			if(generalFunctions.isElementPresent(needHelpPage.needHelp, 10)) {
				test.log(Status.PASS, "need help element is present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));

			}else {
				test.log(Status.FAIL, "need help element is not present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}
			needHelpFunctions.needHelpElement(needHelpPage);
			registrationFunctions.emailAddressElementVal(registrationPage);
			registrationFunctions.phoneNumberElementVal(registrationPage);
			registrationFunctions.emailAddressValFun(registrationPage);
			Thread.sleep(3000);
			if(generalFunctions.isElementPresent(registrationPage.emailAddressVal, 10)) {
				test.log(Status.PASS, "Error message for email address is shown and the field is mandatory");

			}else {
				test.log(Status.FAIL, "Error message is not shown");
				Assert.fail("Error message is not shown");
			}


			driver.hideKeyboard();
			Thread.sleep(3000);
			if(registrationPage.submit.isEnabled()==false) {
				test.log(Status.PASS, "Submit button is disabled");

			}else {
				test.log(Status.FAIL, "Submit button is enabled");
			}

		}

		catch(Exception e)
		{
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}

	}

	@Test
	public void NeedHelp_08(Method method) throws Exception


	{
		driver.resetApp();
		String TC_method = method.getName();
		System.out.println(TC_method);
		test = extent.createTest(TC_method).assignCategory("NEEDHELP");
		test.log(Status.INFO, "Scenario:Need Help");
		test.log(Status.INFO, "Module:Need Help");
		test.log(Status.INFO, "Verify error message is displayed when country code is left blank");

		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		NeedHelpPage needHelpPage = new NeedHelpPage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();

		try

		{
			splashScreenFunctions.splashScreenSkip(splashScreenPage);
			registrationFunctions.signInElement(registrationPage);

			Thread.sleep(3000);
			if(generalFunctions.isElementPresent(needHelpPage.needHelp, 10)) {
				test.log(Status.PASS, "need help element is present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));

			}else {
				test.log(Status.FAIL, "need help element is not present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}
			needHelpFunctions.needHelpElement(needHelpPage);
			registrationFunctions.emailAddressElement(registrationPage);
			registrationFunctions.phoneNumberElement(registrationPage);
			registrationFunctions.descriptionElement(registrationPage);
			registrationFunctions.countryCodeFun(registrationPage);
			if(generalFunctions.isElementPresent(registrationPage.mobCodeVal, 10)) {
				test.log(Status.PASS, "Error message  for country code is shown and the field is mandatory");

			}else {
				test.log(Status.FAIL, "Error message is not shown");
				Assert.fail("Error message is not shown");
			}

			driver.hideKeyboard();
			Thread.sleep(3000);
			if(registrationPage.submit.isEnabled()==false) {
				test.log(Status.PASS, "Submit button is disabled");

			}else {
				test.log(Status.FAIL, "Submit button is enabled");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}
	}


	@Test
	public void NeedHelp_09(Method method) throws Exception


	{
		driver.resetApp();

		String TC_method = method.getName();
		System.out.println(TC_method);
		test = extent.createTest(TC_method).assignCategory("NEEDHELP");
		test.log(Status.INFO, "Scenario:Need Help");
		test.log(Status.INFO, "Module:Need Help");
		test.log(Status.INFO, "Verify error message is displayed when phone number is left blank");

		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		NeedHelpPage needHelpPage = new NeedHelpPage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();

		try

		{
			splashScreenFunctions.splashScreenSkip(splashScreenPage);
			registrationFunctions.signInElement(registrationPage);

			Thread.sleep(3000);
			if(generalFunctions.isElementPresent(needHelpPage.needHelp, 10)) {
				test.log(Status.PASS, "need help element is present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));

			}else {
				test.log(Status.FAIL, "need help element is not present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}
			needHelpFunctions.needHelpElement(needHelpPage);
			registrationFunctions.emailAddressElement(registrationPage);
			registrationFunctions.countryCodeHelp(registrationPage);
			registrationFunctions.descriptionElement(registrationPage);
			registrationFunctions.countryNumFun(registrationPage);
			if(generalFunctions.isElementPresent(registrationPage.mobNumVal, 10)) {
				test.log(Status.PASS, "Error message for phone number field is shown and the field is mandatory");

			}else {
				test.log(Status.FAIL, "Error message is not shown");
				Assert.fail("Error message is not shown");
			}


			driver.hideKeyboard();
			Thread.sleep(3000);
			if(registrationPage.submit.isEnabled()==false) {
				test.log(Status.PASS, "Submit button is disabled");

			}else {
				test.log(Status.FAIL, "Submit button is enabled");
			}


		}

		catch(Exception e)

		{
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}
	}




	@Test
	public void NeedHelp_10(Method method) throws Exception


	{
		driver.resetApp();

		String TC_method = method.getName();
		System.out.println(TC_method);
		test = extent.createTest(TC_method).assignCategory("NEEDHELP");
		test.log(Status.INFO, "Scenario:Need Help");
		test.log(Status.INFO, "Module:Need Help");
		test.log(Status.INFO, "Verify error message is displayed when description field is left blank");

		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		//splashScreenFunctions.splashScreenSkip(splashScreenPage);
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		NeedHelpPage needHelpPage = new NeedHelpPage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();

		try

		{
			splashScreenFunctions.splashScreenSkip(splashScreenPage);
			registrationFunctions.signInElement(registrationPage);

			Thread.sleep(3000);
			if(generalFunctions.isElementPresent(needHelpPage.needHelp, 10)) {
				test.log(Status.PASS, "need help element is present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));

			}else {
				test.log(Status.FAIL, "need help element is not present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}
			needHelpFunctions.needHelpElement(needHelpPage);
			registrationFunctions.emailAddressElement(registrationPage);
			registrationFunctions.countryCodeHelp(registrationPage);
			registrationFunctions.phoneNumberElement(registrationPage);
			registrationFunctions.descriptionElementVal(registrationPage);
			registrationFunctions.phoneNumberElementVal(registrationPage);
			registrationFunctions.descriptionFun(registrationPage);
			if(generalFunctions.isElementPresent(registrationPage.descriptionVal, 10)) {
				test.log(Status.PASS, "Error message for description field is shown and the field is mandatory");

			}else {
				test.log(Status.FAIL, "Error message is not shown");
				Assert.fail("Error message is not shown");
			}

			driver.hideKeyboard();
			Thread.sleep(3000);
			if(registrationPage.submit.isEnabled()==false) {
				test.log(Status.PASS, "Submit button is disabled");

			}else {
				test.log(Status.FAIL, "Submit button is enabled");
			}


		}

		catch(Exception e)

		{
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}
	}
	 */

}
