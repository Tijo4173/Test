package com.share.testscript;

import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.share.functions.RegistrationFunctions;
import com.share.functions.SignInFunctions;
import com.share.functions.SplashScreenFunctions;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.RegistrationPage;
import com.share.objectrepository.SignInPage;
import com.share.objectrepository.SplashScreenPage;
import com.share.utility.Utilities;

import io.appium.java_client.MobileElement;

public class Registration extends DriverSetUp {

	//-------------*********************************MODULE--CUSTOMER SIGNUP**********************************------------//

	//TC:Verify user is able to proceed without email id"
	@Test
	public void TC_Registration_001(Method method) {
		try {
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify user is able to proceed without email id");
			System.out.println("Running Test"+" "+ TC_method);
			driver.resetApp();
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationPage.emailElement.click();
			driver.hideKeyboard();
			//registrationFunctions.countryCodeDefault(registrationPage);
			registrationPage.mobileNumElement.click();
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.countryCodeDefault(registrationPage);
			if(generalFunctions.isElementPresent(registrationPage.errorMessage, 10)) {
				test.log(Status.PASS, "Displayed the Email field error message ").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));

			}else {
				test.log(Status.FAIL, "Email field error message is NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}
			//			Thread.sleep(2000);
			if(registrationPage.continueButton.isEnabled()) {
				test.log(Status.FAIL, "Continue button is Enabled");
			}else {
				test.log(Status.PASS, "Continue button is disabled");
			}

		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());

		}

	}

	//TC:Verify user is able to register with incorrect email id format
	@Test
	public void TC_Registration_002(Method method) {
		try {
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify user is able to register with incorrect email id format");
			System.out.println("Running Test"+" "+ TC_method);
			driver.resetApp();
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationPage.emailElement.click();
			registrationPage.emailElement.sendKeys(registrationFunctions.invalidusername);
			driver.hideKeyboard();
			//registrationFunctions.countryCodeDefault(registrationPage);
			registrationPage.mobileNumElement.click();
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.countryCodeDefault(registrationPage);
			if(generalFunctions.isElementPresent(registrationPage.errorMessage, 10)) {
				test.log(Status.PASS, "Displayed the Email field error message::"+registrationPage.errorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));

			}else {
				test.log(Status.FAIL, "Email field error message is NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}
			//			Thread.sleep(2000);
			//	if(generalFunctions.isElementPresent(registrationPage.nextElementDisabled, 10)) {
			if(registrationPage.continueButton.isEnabled()) {
				test.log(Status.FAIL, "Continue button is Enabled");
			}else {
				test.log(Status.PASS, "Continue button is disabled");
			}

		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());

		}

	}

	//TC: Validate Mobile number with invalid combinations
	@Test(dataProvider = "registrationdata")
	public void TC_Registration_003_to_008(Method method, String FName,String LName,String emailID, String MbNum, String first,String last,String password,String cCode)throws Exception {
		try {
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC: Validate Mobile number with invalid combinations");
			System.out.println("Running Test"+" "+ TC_method);
			driver.resetApp();
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationPage.firstNameElement.sendKeys(FName);
			registrationPage.lastNameElement.sendKeys(LName);
			registrationPage.emailElement.sendKeys(emailID);
			//registrationPage.mobileNumElement.click();
			registrationPage.mobileNumElement.sendKeys(MbNum);
			driver.hideKeyboard();
			registrationFunctions.countryCodeData(cCode);
			if(generalFunctions.isElementPresent(registrationPage.mobileNumberError, 30)) {
				test.log(Status.PASS, "Displayed the Mobile Number field error message:: "+cCode+MbNum+":"+registrationPage.mobileNumberError.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}else {
				test.log(Status.FAIL, "Mobile number field error message is NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}
			//			Thread.sleep(2000);
			//if(generalFunctions.isElementPresent(registrationPage.nextElementDisabled, 10)) {
			if(registrationPage.continueButton.isEnabled()) {
				test.log(Status.FAIL, "Continue button is Enabled");
			}else {
				test.log(Status.PASS, "Continue button is disabled");
			}

		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());

		}

	}


	//TC:Verify user is able to proceed with valid india number
	@Test
	public void TC_Registration_009(Method method) {
		try {
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify user is able to proceed with valid india number");
			System.out.println(TC_method);
			driver.resetApp();
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationFunctions.psemailid(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.countryCode(registrationPage);
			registrationFunctions.inmobileNumber(registrationPage);
			driver.hideKeyboard();
			if(registrationPage.continueButton.isEnabled()) {
				test.log(Status.PASS, "Continue button is Enabled");
			}else {
				test.log(Status.FAIL, "Continue button is Disabled");
			}

		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());

		}

	}
	//TC:Verify user is able to register with valid Dubai number
	@Test
	public void TC_Registration_010(Method method) {
		try {
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify user is able to register with valid Dubai number");
			System.out.println(TC_method);
			driver.resetApp();
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationFunctions.psemailid(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.countryCodeDefault(registrationPage);
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			if(registrationPage.continueButton.isEnabled()) {
				test.log(Status.PASS, "Continue button is Enabled");
			}else {
				test.log(Status.FAIL, "Continue button is Disabled");
			}

		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());

		}

	}
	//TC:Verify the drop down for country code is Scrollable and Selectable
	@Test
	public void TC_Registration_011(Method method) {
		try {
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify the drop down for country code is Scrollable and Selectable");
			System.out.println(TC_method);
			driver.resetApp();
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationFunctions.psemailid(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.countryCodeDefault(registrationPage);
			String initialcountry = registrationPage.countryElement.getText();
			test.log(Status.INFO, "Initial Country Code"+initialcountry);
			System.out.println(initialcountry);
			registrationFunctions.countryCode(registrationPage);
			String selectedcountry = registrationPage.countryElement.getText();
			test.log(Status.INFO, "Initial Country Code :"+selectedcountry);
			System.out.println(selectedcountry);
			if(initialcountry!=selectedcountry) {
				test.log(Status.PASS, "The Country code is scrollable and selectable");
			}else {
				test.log(Status.FAIL, "The Country code is scrollable and selectable");
			}

		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());

		}

	}

	//TC:Verify user is not allowed to register with mail id that is already registered in share app
	@Test
	public void TC_Registration_012(Method method) {
		try {
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify user is not allowed to register with mail id that is already registered in share app");
			System.out.println(TC_method);
			driver.resetApp();
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationPage.emailElement.sendKeys(signInFunctions.username);
			driver.hideKeyboard();
			registrationFunctions.countryCodeDefault(registrationPage);
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.nextbuttonEnabled(registrationPage);
			registrationPage.continueButton.click();
			if(generalFunctions.isElementPresent(registrationPage.alreadyRegMessage, 30)) {
				test.log(Status.PASS, "The Email id is already existing screen displayed:: "+registrationPage.alreadyRegMessageDes.getText());

			}else {
				test.log(Status.FAIL, "The Email id is already existing Screen not displayed");
			}

		}catch(Exception e){
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());
		}

	}

	//TC:Verify user is able to signIn from the email already registered screen
	@Test
	public void TC_Registration_053(Method method) {
		try {
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify user is able to signIn from the email already registered screen ");
			System.out.println(TC_method);
			driver.resetApp();
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationPage.emailElement.sendKeys(signInFunctions.username);
			driver.hideKeyboard();
			registrationFunctions.countryCodeDefault(registrationPage);
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.nextbuttonEnabled(registrationPage);
			registrationPage.continueButton.click();
			if(generalFunctions.isElementPresent(registrationPage.alreadyRegMessage, 30)) {
				test.log(Status.PASS, "The Email id is already existing screen displayed:: "+registrationPage.alreadyRegMessageDes.getText());

			}else {
				test.log(Status.FAIL, "The Email id is already existing Screen not displayed");
			}
			if(generalFunctions.isElementPresent(registrationPage.regLogin, 30)) {
				test.log(Status.PASS, "The Login Button Displayed");
				registrationPage.regLogin.click();
			}else {
				test.log(Status.FAIL, "Login Button NOT Displayed");
			}
			if(generalFunctions.isElementPresent(signInPage.useridElement, 60)) {
				test.log(Status.PASS, "User login Screen displayed");
				signInPage.useridElement.sendKeys(signInFunctions.username);
				signInPage.userpassElement.sendKeys(signInFunctions.userpass);
				signInFunctions.signInButton(signInPage);
			}else {
				test.log(Status.FAIL, "The Login Screen NOT Displayed");
			}
			//generalFunctions.skipupdate();
			if(generalFunctions.isElementPresent(registrationPage.HomeIcon, 30)) {
				test.log(Status.PASS, "SignIn Successfully and Home Screen Displayed");
			}else {
				test.log(Status.FAIL, "SignIn is not Successful");
				Assert.fail("The Sign In is not Successful");
			}
		}catch(Exception e){
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());
		}
	}


	//TC:Verify all the radio buttons Present ( Mr, MS .Miss. Mrs)
	@Test
	public void TC_Registration_013(Method method) {
		try {
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify all the radio buttons Present");
			driver.resetApp();
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.alltitle, 90);
			List<MobileElement> allTitleList = registrationPage.alltitle.findElementsByClassName("android.widget.RadioButton");
			String first = allTitleList.get(0).getText();
			String second = allTitleList.get(1).getText();
			String third = allTitleList.get(2).getText();
			String fourth = allTitleList.get(3).getText();

			if(first.contentEquals("Mr")) {
				test.log(Status.PASS, "Title \"Mr\" is Present::"+first);
			}else {
				test.log(Status.FAIL, "Title \"Mr\" is NOT Present");
			}
			if(second.contentEquals("Mrs")) {
				test.log(Status.PASS, "Title \"Mrs\" is Present::"+second);
			}else {
				test.log(Status.FAIL, "Title \"Mrs\" is NOT Present");
			}
			if(third.contentEquals("Miss")) {
				test.log(Status.PASS, "Title \"Miss\" is Present::"+third);
			}else {
				test.log(Status.FAIL, "Title \"Miss\" is NOT Present");
			}
			if(fourth.contentEquals("Ms")) {
				test.log(Status.PASS, "Title \"Ms\" is Present::"+fourth);
			}else {
				test.log(Status.FAIL, "Title \"Ms\" is NOT Present");
			}
		}catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());
		}
	}




	//TC:Verify the user is able proceed registration without selecting radio buttons for Title ( Mr, MS .Miss. Mrs)
	@Test
	public void TC_Registration_014(Method method) {
		try {
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify the user is able proceed registration without selecting radio buttons for Title ( Mr, MS .Miss. Mrs)");
			driver.resetApp();
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationFunctions.emailId(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.countryCodeDefault(registrationPage);
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			//			if(generalFunctions.isElementPresent(registrationPage.ErrorMessage, 10)) {
			//				test.log(Status.PASS, "Displayed the Title radio button error message ").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			//
			//			}else {
			//				test.log(Status.FAIL, "Title radio button error message is NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			//			}
			if(registrationPage.continueButton.isEnabled()) {
				test.log(Status.FAIL, "Continue button is Enabled");
			}else {
				test.log(Status.PASS, "Continue button is disabled");
			}

		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());

		}
	}


	//TC:Firstname validation using Special characters,null,numerical
	@Test(dataProvider = "registrationdata")//iteration
	public void TC_Registration_015_to_020(Method method,String FName,String LName,String emailID, String MbNum,String first,String last,String password,String cCode ) throws Exception{

		try{
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Firstname validation using Special characters,null,numericals");
			driver.resetApp();
			Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
	//		Pattern charac = Pattern.compile("[a-zA-z]");
//	        Pattern numerical = Pattern.compile("[0-9]");
//	        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
			boolean name;
			Matcher match;
			String specialCharacters=" !#$%&'()*+,-./:;<=>?@[]^_`{|}~0123456789";
			//String specialCharacters = "((\\d+)\\.\\s+(\\w+)\\s+(\\d+)\\s+)";
			//String specialCharacters = "~`!@#$%^&*()-=+[{]}\\|;:\'\",<.>/?@[//[//]^_`{|}~0123456789".replaceAll("[\\[\\]]", "");
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions  = new SplashScreenFunctions();
			//Click GET STARTED
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			//select Title
			generalFunctions.isElementPresent(registrationPage.titleMiss, 90);
			registrationPage.titleMiss.click();
			//Enter First Name
			registrationFunctions.firstNametap(registrationPage);
			registrationPage.firstNameElement.sendKeys(first);
			//Enter Last Name
			registrationFunctions.lastnametap(registrationPage);
			registrationFunctions.lastName(registrationPage);
			driver.hideKeyboard();
			//Enter Email Address
			registrationFunctions.emailId(registrationPage);
			//Enter Mobile Number
			registrationFunctions.countryCodeDefault(registrationPage);
			registrationFunctions.mobileNumber(registrationPage);
			test.log(Status.INFO, "First Name: "+first);
			String firstName = registrationPage.firstNameElement.getText();
			match = pattern.matcher(firstName);
			name = match.find();
			//String firstName=driver.findElement(By.xpath("//android.view.ViewGroup[@index='3']/android.widget.LinearLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.EditText[@index='0']")).getText().toString();
			System.out.println(first.contains(firstName));
			if(first.isEmpty())
			{
				if(generalFunctions.isElementPresent(registrationPage.errorMessage, 10)) {
					test.log(Status.PASS, "Error message Dispalyed: "+registrationPage.errorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
				}else {
					test.log(Status.FAIL, "Error Message not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
				}

			}
				else if(specialCharacters.contains(firstName))
			{
				if(generalFunctions.isElementPresent(registrationPage.errorMessage, 10)){
					test.log(Status.PASS, "Error message Dispalyed: "+registrationPage.errorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
				}else {
					test.log(Status.FAIL, "Error Message not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
				}
			}
				else if(name == true)
				{
					if(generalFunctions.isElementPresent(registrationPage.errorMessage, 10)){
						test.log(Status.PASS, "Error message Dispalyed: "+registrationPage.errorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
					}else {
						test.log(Status.FAIL, "Error Message not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
					}
				}
			else if(firstName.length()>30)
			{
				if(generalFunctions.isElementPresent(registrationPage.errorMessage, 10)){
					test.log(Status.PASS, "Error message Dispalyed: "+registrationPage.errorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
				}else {
					test.log(Status.FAIL, "Error Message not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
				}
			}else if(firstName.length()<=1)
			{
				if(generalFunctions.isElementPresent(registrationPage.errorMessage, 10)){
					test.log(Status.PASS, "Error message Dispalyed: "+registrationPage.errorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
				}else {
					test.log(Status.FAIL, "Error Message not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
				}
			}else
			{
				test.log(Status.INFO, "VALID INPUT");
			}
			if(registrationPage.continueButton.isEnabled()) {
				test.log(Status.FAIL, "Continue button is Enabled");
			}else {
				test.log(Status.PASS, "Continue button is disabled");
			}
		}catch(Exception e){
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());
		}
	}

	//TC:Lastname validation using Special characters,null,numericals
	@Test(dataProvider = "registrationdata")//iteration
	public void TC_Registration_021_to_026(Method method,String FName,String LName,String emailID, String MbNum,String first,String last,String password,String cCode) throws Exception{

		try{
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Lastname validation using Special characters,null,numericals");
			driver.resetApp();
			//String specialCharacters = "((\\d+)\\.\\s+(\\w+)\\s+(\\d+)\\s+)";
			String specialCharacters=" !#$%&'()*+,-./:;<=>?@[]^_`{|}~0123456789";
			Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
			boolean name;
			Matcher match;
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();

			//Click GET STARTED
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			//select Title
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			//Enter First Name
			registrationFunctions.firstName(registrationPage);
			//Enter Last Name
			registrationFunctions.lastnametap(registrationPage);
			registrationPage.lastNameElement.sendKeys(last);
			//Enter Email Address
			registrationPage.emailElement.click();
			registrationFunctions.emailId(registrationPage);
			driver.hideKeyboard();
			//Enter Mobile Number
			registrationFunctions.countryCodeDefault(registrationPage);
			registrationFunctions.mobileNumber(registrationPage);
			test.log(Status.INFO, "Last Name: "+last);
			String lastName = registrationPage.lastNameElement.getText();
			match = pattern.matcher(lastName);
			name = match.find();
			//String firstName=driver.findElement(By.xpath("//android.view.ViewGroup[@index='3']/android.widget.LinearLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.EditText[@index='0']")).getText().toString();
			System.out.println(lastName);
			if(last.isEmpty())
			{
				if(generalFunctions.isElementPresent(registrationPage.errorMessage, 10)) {
					test.log(Status.PASS, "Error message Dispalyed: "+registrationPage.errorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
				}else {
					test.log(Status.FAIL, "Error Message not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
				}

			}	else if(specialCharacters.contains(lastName))
			{
				if(generalFunctions.isElementPresent(registrationPage.errorMessage, 10)){
					test.log(Status.PASS, "Error message Dispalyed: "+registrationPage.errorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
				}else {
					test.log(Status.FAIL, "Error Message not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
				}
			}
			else if(name == true)
			{
				if(generalFunctions.isElementPresent(registrationPage.errorMessage, 10)) {
					test.log(Status.PASS, "Error message Dispalyed: "+registrationPage.errorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
				}else {
					test.log(Status.FAIL, "Error Message not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
				}
			}
			else if(lastName.length()>30)
			{
				if(generalFunctions.isElementPresent(registrationPage.errorMessage, 10)) {
					test.log(Status.PASS, "Error message Dispalyed: "+registrationPage.errorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
				}else {
					test.log(Status.FAIL, "Error Message not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
				}
			}else if(lastName.length()<=1)
			{
				if(generalFunctions.isElementPresent(registrationPage.errorMessage, 10)){
					test.log(Status.PASS, "Error message Dispalyed: "+registrationPage.errorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
				}else {
					test.log(Status.FAIL, "Error Message not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
				}
			}else
			{
				test.log(Status.INFO, "VALID INPUT");
			}
			if(registrationPage.continueButton.isEnabled()) {
				test.log(Status.FAIL, "Continue button is Enabled");
			}else {
				test.log(Status.PASS, "Continue button is disabled");
			}
		}catch(Exception e){
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());
		}
	}

	//TC:Verify user is not able to proceed  without  selecting the nationality
	@Test
	public void TC_Registration_041(Method method) throws Exception {
		try {
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify user is not able to proceed  without  selecting the nationality");
			driver.resetApp();
			System.out.println(TC_method);
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationFunctions.emailId(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.countryCodeDefault(registrationPage);
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.nextbuttonEnabled(registrationPage);
			registrationPage.continueButton.click();
			generalFunctions.isElementPresent(registrationPage.nationalityElement, 90);
			registrationFunctions.userYear(registrationPage);
			registrationPage.calendarOK.click();
			generalFunctions.isElementPresent(registrationPage.passwordElement, 10);
			registrationFunctions.passwordText(registrationPage);
			driver.hideKeyboard();
			generalFunctions.isElementPresent(registrationPage.createAccount, 10);
			if(registrationPage.createAccount.isEnabled()){
				test.log(Status.FAIL, "Continue button is Enabled");
			}else {
				test.log(Status.PASS, "Continue button is Disabled");
			}
		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());
		}
	}



	//TC:Verify the user is able to select current date from the calendar field
	@Test
	public void TC_Registration_042(Method method) throws Exception {
		try {
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify the user is able to select current date from the calendar field");
			driver.resetApp();
			System.out.println(TC_method);
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationFunctions.emailId(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.countryCodeDefault(registrationPage);
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.nextbuttonEnabled(registrationPage);
			registrationPage.continueButton.click();
			generalFunctions.isElementPresent(registrationPage.nationalityElement, 90);
			generalFunctions.isElementPresent(registrationPage.dateofbirth, 90);
			registrationPage.dateofbirth.click();
			generalFunctions.isElementPresent(registrationPage.calendarOK, 30);
			registrationPage.calendarOK.click();
			if(generalFunctions.isElementPresent(registrationPage.dobError, 10)) {
				test.log(Status.PASS, "The Error Message has been displayed:: "+registrationPage.dobError.getText());
			}else {
				test.log(Status.FAIL, "The Error Message NOT displayed");
			}

		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());
		}
	}

	//TC:Verify user is able to unselect the check box of Agreement and privacy  and proceed for registration
	@Test
	public void TC_Registration_043(Method method) throws Exception {
		try {
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify user is able to unselect the check box of Agreement and privacy  and proceed for registration");
			driver.resetApp();
			System.out.println(TC_method);
			String passVal = "((?=.*[a-z])(?=.*d)(?=.*[A-Z]).{8,16})";
			String lowerCase = "(.*[a-z].*)";
			String upperCase = "(.*[A-Z].*)";
			String numericCase = "(.*\\d.*)";
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationFunctions.emailId(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.countryCodeDefault(registrationPage);
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.nextbuttonEnabled(registrationPage);
			registrationPage.continueButton.click();
			generalFunctions.isElementPresent(registrationPage.nationalityElement, 90);
			registrationFunctions.userYear(registrationPage);
			registrationPage.calendarOK.click();
			registrationFunctions.nationalityClick(registrationPage);
			generalFunctions.isElementPresent(registrationPage.passwordElement, 10);
			String password = "Test@123";
			registrationPage.passwordElement.sendKeys(password);
			driver.hideKeyboard();
			System.out.println("PASSWORD LENGTH");
			if(password.length()>=8) {
				if(generalFunctions.isElementPresent(registrationPage.passwordCriteriaA, 10)) {
					test.log(Status.PASS, "The password contain 8 characters and the Button is enabled");
				}else {
					test.log(Status.FAIL, "The password contain 8 characters but the button is disabled");
				}
			}else {
				test.log(Status.FAIL, "The password does not contain 8 characters");
			}
			System.out.println("NUMERIC"+password.matches(numericCase));
			if(password.matches(numericCase)) {
				if(generalFunctions.isElementPresent(registrationPage.passwordCriteriaB, 10)) {
					test.log(Status.PASS, "The password contain atleast one number and the Button is enabled");
				}else {
					test.log(Status.PASS, "The password contain atleast one number and the Button is disabled");
				}
			}else{
				test.log(Status.FAIL, "The password does not contain atleast one number");
			}
			System.out.println("LOWER"+password.matches(lowerCase));
			System.out.println("UPPER"+password.matches(upperCase));
			if(password.matches(lowerCase)&& password.matches(upperCase)) {
				if(generalFunctions.isElementPresent(registrationPage.passwordCriteriaC, 10)) {
					test.log(Status.PASS, "The password contain atleast one Uppercase and lowercase letters, the Button is enabled");
				}else{
					test.log(Status.FAIL, "The password contain atleast one Uppercase or lowercase letters but the button is disabled");
				}
			}else {
				test.log(Status.FAIL, "The password does not contain atleast one Uppercase or lowercase letters");
			}

			registrationFunctions.termsButton(registrationPage);
			if(registrationPage.createAccount.isEnabled()) {
				//	if(generalFunctions.isElementPresent(registrationPage.createAccountDisabled, 10)) {
				test.log(Status.FAIL, "Continue button is Enabled");
			}else {
				test.log(Status.PASS, "Continue button is Disabled");

			}
		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());
		}
	}


	//TC:Validation of Password text field with invalid inputs
	@Test(dataProvider = "registrationdata")//iteration
	public void TC_Registration_035_to_040(Method method,String FName,String LName,String emailID, String MbNum,String first,String last,String password,String cCode) throws Exception {
		try {
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Validation of Password text field with invalid inputs");
			driver.resetApp();
			System.out.println(TC_method);
			String passVal = "((?=.*[a-z])(?=.*d)(?=.*[A-Z]).{8,16})";
			String lowerCase = "(.*[a-z].*)";
			String upperCase = "(.*[A-Z].*)";
			String numericCase = "(.*\\d.*)";
			//	String lowerUpperCase = "(?=.*[a-zA-Z])";
			//	String numericCase = "\\d+";
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationFunctions.emailId(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.countryCodeDefault(registrationPage);
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.nextbuttonEnabled(registrationPage);
			registrationPage.continueButton.click();
			generalFunctions.isElementPresent(registrationPage.nationalityElement, 90);
			//registrationFunctions.userYear(registrationPage);
			//registrationPage.calendarOK.click();
			//registrationFunctions.nationalityClick(registrationPage);
			generalFunctions.isElementPresent(registrationPage.passwordElement, 10);
			registrationPage.passwordElement.sendKeys(password);
			test.log(Status.INFO, "Password is : "+password);
			driver.hideKeyboard();
			System.out.println("PASSWORD LENGTH");
			if(password.length()<8) {
				if(generalFunctions.isElementPresent(registrationPage.passwordCriteriaADisabled, 10)) {
					test.log(Status.PASS, "The password contain less than 8 characters and the Button is Disabled");
				}else {
					test.log(Status.FAIL, "The password contain less than 8 characters but the button is enabled");
				}
			}else {
				test.log(Status.INFO, "The password contain 8 characters");
			}
			System.out.println("NUMERIC"+password.matches(numericCase));
			if(password.matches(numericCase)==false) {
				if(generalFunctions.isElementPresent(registrationPage.passwordCriteriaBDisabled, 10)) {
					test.log(Status.PASS, "The password does not contain numericals and the button is Disabled");
				}else {
					test.log(Status.PASS, "The password does not contain numericals but the button is Enabled");
				}
			}else{
				test.log(Status.INFO, "The password contain numericals");
			}
			System.out.println("LOWERUPPER"+password.matches(lowerCase));
			System.out.println("LOWERUPPER"+password.matches(upperCase));
			if(password.matches(lowerCase)==false && password.matches(upperCase)==false) {
				if(generalFunctions.isElementPresent(registrationPage.passwordCriteriaCDisabled, 10)) {
					test.log(Status.PASS, "The password does not contain Uppercase or lowercase letters, the button is Disabled");
				}else{
					test.log(Status.FAIL, "The password does not contain Uppercase or lowercase letters but the button is Enabled");
				}
			}else {
				test.log(Status.INFO, "The password contain Uppercase or lowercase letters");
			}

		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());
		}
	}


	//TC:Verify TC and Privacy policy is clickable
	@Test
	public void TC_Registration_044(Method method) throws Exception {
		try {
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify TC and Privacy policy is clickable");
			driver.resetApp();
			System.out.println(TC_method);
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationFunctions.emailId(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.countryCodeDefault(registrationPage);
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.nextbuttonEnabled(registrationPage);
			registrationPage.continueButton.click();
			generalFunctions.isElementPresent(registrationPage.nationalityElement, 90);
			//registrationFunctions.userYear(registrationPage);
			//registrationPage.calendarOK.click();
			//registrationFunctions.nationalityClick(registrationPage);
			generalFunctions.isElementPresent(registrationPage.passwordElement, 10);
			registrationFunctions.passwordText(registrationPage);
			driver.hideKeyboard();
			
			registrationFunctions.ppClick(registrationPage);
			Thread.sleep(4000);
			if(generalFunctions.isElementPresent(registrationPage.NavigateBack, 20)) {
				test.log(Status.PASS, "Privacy Policy Screen displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
				registrationPage.NavigateBack.click();
			}else {
				test.log(Status.FAIL, "Privacy Policy Screen is not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}
		
			registrationFunctions.tcClick(registrationPage);
			Thread.sleep(5000);
			generalFunctions.isElementPresent(registrationPage.NavigateBack, 20);
			if(generalFunctions.isElementPresent(registrationPage.NavigateBack, 10)){
				test.log(Status.PASS, "Terms and Condition Screen displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
				registrationPage.NavigateBack.click();
			}else {
				test.log(Status.FAIL, "Terms and Condition Screen  is not displayed");
			}

		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());
		}
	}


	//TC: Verify user with less than 10 year is not able to register
	@Test
	public void TC_Registration_045(Method method) throws Exception {
		try {
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC: Verify user with less than 10 year is not able to register");
			driver.resetApp();
			System.out.println(TC_method);
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationFunctions.emailId(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.countryCodeDefault(registrationPage);
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.nextbuttonEnabled(registrationPage);
			registrationPage.continueButton.click();
			generalFunctions.isElementPresent(registrationPage.nationalityElement, 90);
			registrationFunctions.userinvalidYear(registrationPage);
			registrationPage.calendarOK.click();
			//String errorMessage = registrationPage.dobError.getText();
			if(generalFunctions.isElementPresent(registrationPage.dobError, 10)) {
				test.log(Status.PASS, "The Error Message has been displayed: "+registrationPage.dobError.getText());
			}else {
				test.log(Status.FAIL, "The Error Message NOT displayed");
			}

		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());

		}

	}

	//TC:Verify user able to view information by clicking on i Button in Date of Birth
	@Test
	public void TC_Registration_046(Method method) throws Exception {
		try {
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify user able to view information by clicking on i Button in Date of Birth ");
			driver.resetApp();
			System.out.println(TC_method);
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationFunctions.emailId(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.countryCodeDefault(registrationPage);
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.nextbuttonEnabled(registrationPage);
			registrationPage.continueButton.click();
			generalFunctions.isElementPresent(registrationPage.nationalityElement, 90);
			registrationFunctions.infoClick(registrationPage);
			String errorMessage = registrationPage.dobError.getText();
			if(generalFunctions.isElementPresent(registrationPage.dobError, 10)) {
				test.log(Status.PASS, "The Error Message has been displayed"+errorMessage);
			}else {
				test.log(Status.FAIL, "The Error Message NOT displayed");
			}



		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());

		}

	}


	//TC:Verify user able to select year from calendar with different range of year
	@Test(dataProvider = "registrationdatayear")//iteration
	public void TC_Registration_031_to_034(Method method,String ryear, String remail) throws Exception {
		try {
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify user able to select year from calendar with different range of year ");
			driver.resetApp();
			//driver.resetApp();
			System.out.println(TC_method);
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationFunctions.emailId(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.countryCodeDefault(registrationPage);
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.nextbuttonEnabled(registrationPage);
			registrationPage.continueButton.click();
			generalFunctions.isElementPresent(registrationPage.nationalityElement, 90);
			test.log(Status.INFO, "Year is: "+ryear);
			registrationFunctions.userYeariter(registrationPage, ryear);
			registrationPage.calendarOK.click();
			String selected = registrationPage.dateofbirth.getText();
			if(generalFunctions.isElementPresent(registrationPage.dobError, 10)==false) {
				test.log(Status.PASS, "The Selected Year is Valid for registration");
			}else {
				test.log(Status.FAIL, "The Selected Year is not Valid for registration");
			}
		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());
		}
	}

	//TC:Verify user can navigate to Sign in screen from registration 1st Screen
	@Test
	public void TC_Registration_048(Method method) throws Exception {
		try {
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify user can navigate to Sign in screen from registration 1st Screen ");
			driver.resetApp();
			//driver.resetApp();
			System.out.println(TC_method);
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationFunctions.emailId(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.countryCodeDefault(registrationPage);
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			signInFunctions.SignInUser(signInPage);
			generalFunctions.isElementPresent(registrationPage.HomeIcon, 10);
			if(generalFunctions.isElementPresent(registrationPage.HomeIcon, 10)) {
				test.log(Status.PASS, "Able to sign in and HomeScreen displayed");
			}else {
				test.log(Status.FAIL, "Not Able to sign in");
			}

		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());

		}

	}

	//TC:Verify user can navigate to Sign in screen from registration 2nd Screen
	@Test
	public void TC_Registration_049(Method method) throws Exception {
		try {
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify user can navigate to Sign in screen from registration 2nd Screen ");
			driver.resetApp();
			//driver.resetApp();
			System.out.println(TC_method);
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationFunctions.emailId(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.countryCodeDefault(registrationPage);
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.nextbuttonEnabled(registrationPage);
			registrationPage.continueButton.click();
			generalFunctions.isElementPresent(registrationPage.nationalityElement, 90);
			signInFunctions.SignInUser(signInPage);
			generalFunctions.isElementPresent(registrationPage.HomeIcon, 10);
			if(generalFunctions.isElementPresent(registrationPage.HomeIcon, 10)) {
				test.log(Status.PASS, "Able to sign in and HomeScreen displayed");
			}else {
				test.log(Status.FAIL, "Not Able to sign in");
			}

		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());

		}

	}


	//TC:Verify user can navigate to 1st screen from screen2
	@Test
	public void TC_Registration_050(Method method) throws Exception {
		try {
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify user can navigate to 1st screen from screen2");
			driver.resetApp();
			//driver.resetApp();
			System.out.println(TC_method);
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationFunctions.emailId(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.countryCodeDefault(registrationPage);
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.nextbuttonEnabled(registrationPage);
			registrationPage.continueButton.click();
			generalFunctions.isElementPresent(registrationPage.nationalityElement, 90);
			registrationPage.backtoStep.click();
			generalFunctions.isElementPresent(registrationPage.firstNameElement, 90);
			if(generalFunctions.isElementPresent(registrationPage.firstNameElement, 10)) {
				test.log(Status.PASS, "Screen 1 is displayed");
			}else {
				test.log(Status.FAIL, "Screen1 is not displayed");
			}

		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());

		}
	}


	//TC:Verify user is able to register with incorrect email id format
	@Test(dataProvider = "registrationdatayear")//iteration
	public void TC_Registration_027_to_030(Method method, String ryear, String remail) {
		try {
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify user is able to register with incorrect email id format");
			driver.resetApp();
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationPage.emailElement.click();
			registrationPage.emailElement.sendKeys(remail);
			driver.hideKeyboard();
			registrationFunctions.countryCodeDefault(registrationPage);
			registrationPage.mobileNumElement.click();
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			test.log(Status.INFO, "Email id: "+remail);
			if(generalFunctions.isElementPresent(registrationPage.errorMessage, 10)) {
				test.log(Status.PASS, "Displayed the Email field error message:: "+remail).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));

			}else {
				test.log(Status.FAIL, "Email field error message is NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}
			//			Thread.sleep(2000);
			if(registrationPage.continueButton.isEnabled()) {
				test.log(Status.FAIL, "Continue button is Enabled");
			}else {
				test.log(Status.PASS, "Continue button is disabled");
			}

		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());

		}

	}

	//TC:Verify user is able to navigate back to First screen using the back button in application  and modify the data and complete registration
	@Test
	public void TC_Registration_051(Method method) throws Exception {
		try {
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify user is able to navigate back to First screen using the back button in application  and modify the data and complete registration");
			test.log(Status.INFO, "TC:Verify the Send again button is working in the registration Successful screen");
			driver.resetApp();
			//driver.resetApp();
			System.out.println(TC_method);
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationPage.emailElement.sendKeys(registrationFunctions.clearemail);
			//registrationFunctions.emailId(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.countryCodeDefault(registrationPage);
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.nextbuttonEnabled(registrationPage);
			registrationPage.continueButton.click();
			generalFunctions.isElementPresent(registrationPage.nationalityElement, 90);
			registrationPage.backtoStep.click();
			generalFunctions.isElementPresent(registrationPage.firstNameElement, 90);
			registrationFunctions.cleardata(registrationPage);
			Thread.sleep(1000);
			registrationPage.firstNameElement.sendKeys(registrationFunctions.efirstname);
			registrationPage.lastNameElement.sendKeys(registrationFunctions.elastname);
			//registrationPage.emailElement.sendKeys(registrationFunctions.reenterEmail);
			registrationPage.emailElement.sendKeys(registrationFunctions.modifyEmail);
			driver.hideKeyboard();
			registrationFunctions.nextButton(registrationPage);
			registrationPage.continueButton.click();
			registrationFunctions.userYear(registrationPage);
			registrationPage.calendarOK.click();
			registrationFunctions.nationalityClick(registrationPage);
			generalFunctions.isElementPresent(registrationPage.passwordElement, 10);
			registrationFunctions.passwordText(registrationPage);
			driver.hideKeyboard();
			generalFunctions.isElementPresent(registrationPage.createAccount, 10);
			registrationPage.createAccount.click();

			if(generalFunctions.isElementPresent(registrationPage.registrationSuccess, 10)) {
				test.log(Status.PASS, "Registration Successful: "+registrationPage.registrationSuccess.getText());

			}else {
				test.log(Status.FAIL, "Registration Failed");
			}

			if(generalFunctions.isElementPresent(registrationPage.sendAgain, 10)) {
				test.log(Status.PASS, "Registration Successful"+registrationPage.sendAgain);
				registrationPage.sendAgain.click();
				if(generalFunctions.isElementPresence(signInPage.sendAgainToast, 60))  {
					test.log(Status.PASS, "Username or Password is invalid and Error message displayed: "+signInFunctions.sendAgaintoast());
				}else {
					test.log(Status.FAIL, "Error message not displayed");
				}
			}else {
				test.log(Status.FAIL, "Send Again button is not present");

			}

		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());

		}

	}

	//TC:Verify the user can register successfully
	@Test
	public void TC_Registration_052(Method method) throws Exception {
		try {
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify the user can register successfully");
			//driver.resetApp();
			driver.resetApp();
			System.out.println(TC_method);
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationFunctions.emailId(registrationPage);
			//registrationPage.emailElement.sendKeys("smautomation08@yopmail.com");
			driver.hideKeyboard();
			registrationFunctions.countryCodeDefault(registrationPage);
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.nextbuttonEnabled(registrationPage);
			registrationPage.continueButton.click();
			registrationFunctions.nationalityClick(registrationPage);
			registrationFunctions.userYear(registrationPage);
			registrationPage.calendarOK.click();
			registrationFunctions.passwordText(registrationPage);
			driver.hideKeyboard();
			generalFunctions.isElementPresent(registrationPage.createAccount, 10);
			registrationPage.createAccount.click();

			if(generalFunctions.isElementPresent(registrationPage.registrationSuccess, 10)) {
				test.log(Status.PASS, "Registration Successful"+registrationPage.registrationSuccess);

			}else {
				test.log(Status.FAIL, "Registration Failed");

			}


		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());

		}

	}

	//TC:Verify the Show Password button is working
	@Test
	public void TC_Registration_047(Method method) {
		try {
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("REGISTRATION");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify the Show Password button is working");
			driver.resetApp();
			System.out.println(TC_method);
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationFunctions.emailId(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.countryCodeDefault(registrationPage);
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.nextbuttonEnabled(registrationPage);
			registrationPage.continueButton.click();
			generalFunctions.isElementPresent(registrationPage.nationalityElement, 90);
			//registrationFunctions.quickDOB(registrationPage);
			registrationFunctions.userYear(registrationPage);
			registrationPage.calendarOK.click();
			registrationFunctions.nationalityClick(registrationPage);
			generalFunctions.isElementPresent(registrationPage.passwordElement, 10);
			String inpass ="Test@123";
			registrationPage.passwordElement.sendKeys(inpass);
			registrationPage.showPassword.click();
			String currentpass = registrationPage.passwordElement.getText();
			if(generalFunctions.isElementPresent(registrationPage.hidePassword, 10)) {
				test.log(Status.PASS, "The Password is displayed"+currentpass);
			}else {
				test.log(Status.FAIL, "The password id not displayed and the button is not working");
			}


		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());

		}

	}
}



