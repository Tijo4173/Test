package com.share.testscript;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.io.PrintStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.apache.poi.hssf.record.CountryRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.battery.BatteryInfo;


public class Registration extends DriverSetUp {


	//	String number;
	//	String name;

	//	String pass;
	//	String confirm;
	//	String text;*/
	//	String title;
	//	String fdemail;
	//	WebElement button;
	WebDriverWait wait;
	GeneralFunctions GeneralFunctions = new GeneralFunctions();
	//-------------*********************************MODULE--CUSTOMER SIGNUP**********************************------------//

	@Test
	public void TC_C_SU_001_004(Method method) {
		try {
			String Tc_method = method.getName();
			test = extent.createTest(Tc_method).assignCategory("Customer SignUp");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify user is able to proceed without email id");
			//driver.activateApp("com.maf.sharesit");
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			splashScreenFunctions.splashScreenSkip(splashScreenPage);
			GeneralFunctions generalFunctions = new GeneralFunctions();
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationPage.emailElement.click();
			driver.hideKeyboard();
			registrationPage.mobileNumElement.click();
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			if(generalFunctions.isElementPresent(registrationPage.ErrorMessage, 10)) {
				test.log(Status.PASS, "Displayed the Email field error message ").addScreenCaptureFromPath(Utilities.getScreenshot(driver, Tc_method));

			}else {
				test.log(Status.FAIL, "Email field error message is NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, Tc_method));
			}
			//			Thread.sleep(2000);
			if(registrationPage.nextElementDisabled.isDisplayed()) {
				test.log(Status.PASS, "Continue button is disabled");
			}else {
				test.log(Status.FAIL, "Continue button is Enabled");
			}

		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());

		}

	}


	@Test
	public void TC_C_SU_005(Method method) {
		try {
			String Tc_method = method.getName();
			test = extent.createTest(Tc_method).assignCategory("Customer SignUp");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify user is able to register with incorrect email id format");
			driver.activateApp("com.maf.sharesit");
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			splashScreenFunctions.splashScreenSkip(splashScreenPage);
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationPage.emailElement.click();
			signInFunctions.invalidEmail(signInPage);
			driver.hideKeyboard();
			registrationPage.mobileNumElement.click();
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			if(generalFunctions.isElementPresent(registrationPage.ErrorMessage, 10)) {
				test.log(Status.PASS, "Displayed the Email field error message ").addScreenCaptureFromPath(Utilities.getScreenshot(driver, Tc_method));

			}else {
				test.log(Status.FAIL, "Email field error message is NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, Tc_method));
			}
			//			Thread.sleep(2000);
			if(generalFunctions.isElementPresent(registrationPage.nextElementDisabled, 10)) {
				test.log(Status.PASS, "Continue button is disabled");
			}else {
				test.log(Status.FAIL, "Continue button is Enabled");
			}

		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());

		}

	}


	@Test(dataProvider = "registrationdata")
	public void TC_C_SU_006_007_010_011(Method method, String FName,String LName,String emailID, String MbNum, String first,String last,String password)throws Exception {
		try {
			String Tc_method = method.getName();
			test = extent.createTest(Tc_method).assignCategory("Customer SignUp");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC: Validate Mobile number with invalid combinations");
			driver.activateApp("com.maf.sharesit");
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationPage.firstNameElement.sendKeys(FName);
			registrationPage.lastNameElement.sendKeys(LName);
			signInPage.useridElement.sendKeys(emailID);
			//registrationPage.mobileNumElement.click();
			registrationPage.mobileNumElement.sendKeys(MbNum);
			driver.hideKeyboard();
			if(generalFunctions.isElementPresent(registrationPage.ErrorMessage, 10)) {
				test.log(Status.PASS, "Displayed the Mobile Number field error message ").addScreenCaptureFromPath(Utilities.getScreenshot(driver, Tc_method));
				test.log(Status.INFO, registrationPage.ErrorMessage.getText());

			}else {
				test.log(Status.FAIL, "Mobile number field error message is NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, Tc_method));
			}
			//			Thread.sleep(2000);
			if(generalFunctions.isElementPresent(registrationPage.nextElementDisabled, 10)) {
				test.log(Status.PASS, "Continue button is disabled");
			}else {
				test.log(Status.FAIL, "Continue button is Enabled");
			}

		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());

		}

	}
	@Test
	public void TC_C_SU_008(Method method) {
		try {
			String Tc_method = method.getName();
			test = extent.createTest(Tc_method).assignCategory("Customer SignUp");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify user is able to proceed with valid india number");
			System.out.println(Tc_method);
			driver.activateApp("com.maf.sharesit");
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationFunctions.psemailid(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.countryCode(registrationPage);
			Thread.sleep(5000);
			registrationFunctions.inmobileNumber(registrationPage);
			driver.hideKeyboard();
			if(generalFunctions.isElementPresent(registrationPage.nextElement, 10)) {
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

	@Test
	public void TC_C_SU_009(Method method) {
		try {
			String Tc_method = method.getName();
			test = extent.createTest(Tc_method).assignCategory("Customer SignUp");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify user is able to register with valid Dubai number");
			System.out.println(Tc_method);
			driver.activateApp("com.maf.sharesit");
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationFunctions.psemailid(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			if(generalFunctions.isElementPresent(registrationPage.nextElement, 10)) {
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
	@Test
	public void TC_C_SU_012(Method method) {
		try {
			String Tc_method = method.getName();
			test = extent.createTest(Tc_method).assignCategory("Customer SignUp");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify the drop down for country code is Scrollable and Selectable");
			System.out.println(Tc_method);
			driver.activateApp("com.maf.sharesit");
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationFunctions.psemailid(registrationPage);
			driver.hideKeyboard();
			String initialcountry = registrationPage.countryElement.getText();
			test.log(Status.INFO, "Initial Country Code"+initialcountry);
			System.out.println(initialcountry);
			registrationFunctions.countryCode(registrationPage);
			String selectedcountry = registrationPage.countryElement.getText();
			test.log(Status.INFO, "Initial Country Code"+selectedcountry);
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

	@Test
	public void TC_C_SU_013(Method method) {
		try {
			String Tc_method = method.getName();
			test = extent.createTest(Tc_method).assignCategory("Customer SignUp");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify user is not allowed to register with mail id that is already registered in share app");
			System.out.println(Tc_method);
			driver.activateApp("com.maf.sharesit");
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			signInFunctions.useremailid(signInPage);
			driver.hideKeyboard();
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.nextButton(registrationPage);
			if(registrationFunctions.closeButton(registrationPage)==true) {
				test.log(Status.PASS, "The Email id is already existing alert displayed");

			}else {
				test.log(Status.FAIL, "The Email id is already existing alert is not displayed");
			}
		}catch(Exception e){
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());
		}

	}


	@Test
	public void TC_C_SU_014(Method method) {
		try {
			String Tc_method = method.getName();
			test = extent.createTest(Tc_method).assignCategory("Customer SignUp");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify  user can proceed registration without selecting radio buttons for Title ( Mr, MS .Miss. Mrs)");
			driver.activateApp("com.maf.sharesit");
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationFunctions.emailId(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			if(generalFunctions.isElementPresent(registrationPage.ErrorMessage, 10)) {
				test.log(Status.PASS, "Displayed the Title radio button error message ").addScreenCaptureFromPath(Utilities.getScreenshot(driver, Tc_method));

			}else {
				test.log(Status.FAIL, "Title radio button error message is NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, Tc_method));
			}
			if(generalFunctions.isElementPresent(registrationPage.nextElementDisabled, 10)) {
				test.log(Status.PASS, "Continue button is disabled");
			}else {
				test.log(Status.FAIL, "Continue button is Enabled");
			}

		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());

		}

	}


	@Test(dataProvider = "registrationdata")//iteration
	public void TC_C_SU_015_to_017_021(Method method,String FName,String LName,String emailID, String MbNum,String first,String last,String password) throws Exception{ 

		try{
			String TC_Method = method.getName();
			test = extent.createTest(TC_Method).assignCategory("Customer SignUp");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Firstname validation using Special characters,null,numericals");
			driver.activateApp("com.maf.sharesit");
			String specialCharacters = "((\\d+)\\.\\s+(\\w+)\\s+(\\d+)\\s+)";
			//String specialCharacters =  "\\$[\\{]([^}]*)[\\}]0123456789";
			//String specialCharacters = "~`!@#$%^&*()-=+[{]}\\|;:\'\",<.>/?@[//[//]^_`{|}~0123456789".replaceAll("[\\[\\]]", "");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();

			//Click GET STARTED
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			//select Title
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
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
			registrationFunctions.mobileNumber(registrationPage);
			String firstName = registrationPage.firstNameElement.getText();
			//String firstName=driver.findElement(By.xpath("//android.view.ViewGroup[@index='3']/android.widget.LinearLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.EditText[@index='0']")).getText().toString();
			System.out.println(firstName);
			if(firstName.contains(firstName))
			{
				if(generalFunctions.isElementPresent(registrationPage.ErrorMessage, 10)) {
					test.log(Status.PASS, "Error message Dispalyed: "+registrationPage.ErrorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}else {
					test.log(Status.FAIL, "Error Message not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}

			}
			else if(firstName.matches(specialCharacters))
			{
				if(generalFunctions.isElementPresent(registrationPage.ErrorMessage, 10)){
					test.log(Status.PASS, "Error message Dispalyed: "+registrationPage.ErrorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}else {
					test.log(Status.FAIL, "Error Message not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}
			}
			else if(firstName.length()>30)
			{
				if(generalFunctions.isElementPresent(registrationPage.ErrorMessage, 10)){
					test.log(Status.PASS, "Error message Dispalyed: "+registrationPage.ErrorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}else {
					test.log(Status.FAIL, "Error Message not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}
			}else
			{
				test.log(Status.INFO, "VALID INPUT");
			}
			if(generalFunctions.isElementPresent(registrationPage.nextElementDisabled, 10)) {
				test.log(Status.PASS, "Continue button is disabled");
			}else {
				test.log(Status.FAIL, "Continue button is Enabled");
			}
		}catch(Exception e){
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());
		}
	}

	@Test(dataProvider = "registrationdata")//iteration
	public void TC_C_SU_018_to_020_022(Method method,String FName,String LName,String emailID, String MbNum,String first,String last,String password) throws Exception{ 

		try{
			String TC_Method = method.getName();
			test = extent.createTest(TC_Method).assignCategory("Customer SignUp");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Lastname validation using Special characters,null,numericals");
			driver.activateApp("com.maf.sharesit");
			String specialCharacters = "((\\d+)\\.\\s+(\\w+)\\s+(\\d+)\\s+)";
			//String specialCharacters =  "\\$[\\{]([^}]*)[\\}]0123456789";
			//String specialCharacters = "~`!@#$%^&*()-=+[{]}\\|;:\'\",<.>/?@[//[//]^_`{|}~0123456789".replaceAll("[\\[\\]]", "");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();

			//Click GET STARTED
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
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
			registrationFunctions.mobileNumber(registrationPage);
			String lastName = registrationPage.lastNameElement.getText();
			//String firstName=driver.findElement(By.xpath("//android.view.ViewGroup[@index='3']/android.widget.LinearLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.EditText[@index='0']")).getText().toString();
			System.out.println(lastName);
			if(lastName.contains(lastName))
			{
				if(generalFunctions.isElementPresent(registrationPage.ErrorMessage, 10)) {
					test.log(Status.PASS, "Error message Dispalyed: "+registrationPage.ErrorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}else {
					test.log(Status.FAIL, "Error Message not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}

			}
			else if(lastName.matches(specialCharacters))
			{
				if(generalFunctions.isElementPresent(registrationPage.ErrorMessage, 10)) {
					test.log(Status.PASS, "Error message Dispalyed: "+registrationPage.ErrorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}else {
					test.log(Status.FAIL, "Error Message not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}
			}
			else if(lastName.length()>30)
			{
				if(generalFunctions.isElementPresent(registrationPage.ErrorMessage, 10)) {
					test.log(Status.PASS, "Error message Dispalyed: "+registrationPage.ErrorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}else {
					test.log(Status.FAIL, "Error Message not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}
			}else
			{
				test.log(Status.INFO, "VALID INPUT");
			}
			if(generalFunctions.isElementPresent(registrationPage.nextElementDisabled, 10)) {
				test.log(Status.PASS, "Continue button is disabled");
			}else {
				test.log(Status.FAIL, "Continue button is Enabled");
			}
		}catch(Exception e){
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());
		}
	}
	@Test
	public void TC_C_SU_023(Method method) throws Exception {
		try {
			String Tc_method = method.getName();
			test = extent.createTest(Tc_method).assignCategory("Customer SignUp");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify user is not able to proceed  without  selecting the nationality");
			driver.activateApp("com.maf.sharesit");
			System.out.println(Tc_method);
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationFunctions.emailId(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.nextButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.nationalityElement, 90);
			registrationFunctions.userYear(registrationPage);
			registrationPage.calendarOK.click();
			generalFunctions.isElementPresent(registrationPage.passwordElement, 10);
			registrationFunctions.passwordText(registrationPage);
			driver.hideKeyboard();
			if(generalFunctions.isElementPresent(registrationPage.createAccountDisabled, 10)) {
				test.log(Status.PASS, "Continue button is Disabled");
			}else {
				test.log(Status.FAIL, "Continue button is Enabled");

			}
		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());
		}
	}




	@Test
	public void TC_C_SU_024(Method method) throws Exception {
		try {
			String Tc_method = method.getName();
			test = extent.createTest(Tc_method).assignCategory("Customer SignUp");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify the user is able to select current date from the calendar field");
			driver.activateApp("com.maf.sharesit");
			System.out.println(Tc_method);
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationFunctions.emailId(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.nextButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.nationalityElement, 90);
			registrationFunctions.userYear(registrationPage);
			registrationPage.calendarOK.click();
			if(generalFunctions.isElementPresent(registrationPage.dobError, 10)) {
				String errorMessage = registrationPage.dobError.getText();
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

	@Test
	public void TC_C_SU_025(Method method) throws Exception {
		try {
			String Tc_method = method.getName();
			test = extent.createTest(Tc_method).assignCategory("Customer SignUp");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Verify user is able to unselect the check box of Agreement and privacy  and proceed for registration");
			driver.activateApp("com.maf.sharesit");
			System.out.println(Tc_method);
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationFunctions.emailId(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.nextButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.nationalityElement, 90);
			registrationFunctions.userYear(registrationPage);
			registrationPage.calendarOK.click();
			registrationFunctions.nationalityClick(registrationPage);
			generalFunctions.isElementPresent(registrationPage.passwordElement, 10);
			registrationFunctions.passwordText(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.termsButton(registrationPage);
			if(generalFunctions.isElementPresent(registrationPage.createAccountDisabled, 10)) {
				test.log(Status.PASS, "Continue button is Disabled");
			}else {
				test.log(Status.FAIL, "Continue button is Enabled");

			}
		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, e.getCause());
			test.log(Status.FAIL, e.getMessage());
		}
	}



	@Test(dataProvider = "registrationdata")//iteration
	public void TC_C_SU_027_to_33(Method method,String FName,String LName,String emailID, String MbNum,String first,String last,String password) throws Exception {
		try {
			String Tc_method = method.getName();
			test = extent.createTest(Tc_method).assignCategory("Customer SignUp");
			test.log(Status.INFO, "Module:Customer SignUp");
			test.log(Status.INFO, "TC:Validation of Password text field with invalid and valid inputs");
			driver.activateApp("com.maf.sharesit");
			System.out.println(Tc_method);
			String passVal = "((?=.*[a-z])(?=.*d)(?=.*[A-Z]).{8,16})";
			String lowerUpperCase = "?=.*[a-zA-Z]";
			String numericCase = "\\d+";
			RegistrationPage registrationPage = new RegistrationPage(driver);
			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
			SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
			SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
			//splashScreenFunctions.splashScreenSkip(splashScreenPage);
			SignInPage signInPage = new SignInPage(driver);
			SignInFunctions signInFunctions = new SignInFunctions();
			GeneralFunctions generalFunctions = new GeneralFunctions();
			generalFunctions.isElementPresent(registrationPage.startElement, 90);
			registrationFunctions.startButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.titleMr, 90);
			registrationPage.titleMr.click();
			registrationFunctions.firstName(registrationPage);
			registrationFunctions.lastName(registrationPage);
			registrationFunctions.emailId(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.mobileNumber(registrationPage);
			driver.hideKeyboard();
			registrationFunctions.nextButton(registrationPage);
			generalFunctions.isElementPresent(registrationPage.nationalityElement, 90);
			//registrationFunctions.quickDOB(registrationPage);
			registrationFunctions.userYear(registrationPage);
			registrationPage.calendarOK.click();
			registrationFunctions.nationalityClick(registrationPage);
			generalFunctions.isElementPresent(registrationPage.passwordElement, 10);
			registrationPage.passwordElement.sendKeys(password);
			test.log(Status.INFO, "Password is : "+password);
			driver.hideKeyboard();
			//			if(password.matches(passVal)){
			//				test.log(Status.PASS, "Password contains 8 characters with Uppercase,Lowercase and Numbers");
			//				test.log(Status.PASS, registrationPage.passwordCriteriaA.getText());
			//				test.log(Status.PASS, registrationPage.passwordCriteriaB.getText());
			//				test.log(Status.PASS, registrationPage.passwordCriteriaC.getText());
			//			}else {
			//				Thread.sleep(2000);
			if(password.length()>=8) {
				if(generalFunctions.isElementPresent(registrationPage.passwordCriteriaA, 10)) {
					test.log(Status.PASS, "The password contain 8 characters and the Button is enabled");
				}else {
					test.log(Status.FAIL, "The password contain 8 characters but the button is disabled");
				}
			}else {
				test.log(Status.FAIL, "The password does not contain 8 characters");
			}
			System.out.println(password.matches(numericCase));
			if(password.matches(numericCase)) {
				System.out.println(password.matches(numericCase));
				if(generalFunctions.isElementPresent(registrationPage.passwordCriteriaB, 10)) {
					test.log(Status.PASS, "The password contain 1 number and the Button is enabled");
				}else {
					test.log(Status.PASS, "The password contain 1 number and the Button is disabled");
				}
			}else{
				test.log(Status.FAIL, "The password does not contain 1 number");
			}
			System.out.println(password.matches(lowerUpperCase));
			if(password.matches(lowerUpperCase)) {
				if(generalFunctions.isElementPresent(registrationPage.passwordCriteriaC, 10)) {
					test.log(Status.PASS, "The password contain 1 Uppercase and lowercase letters, the Button is enabled");
				}else{
					test.log(Status.FAIL, "The password contain 1 Uppercase or lowercase letters but the button is disabled");
				}
			}else {
				test.log(Status.FAIL, "The password does not contain 1 Uppercase or lowercase letters");
			}
		
	}catch(Exception e) {
		e.printStackTrace();
		test.log(Status.FAIL, e.getCause());
		test.log(Status.FAIL, e.getMessage());
	}
}

@Test
public void TC_C_SU_034(Method method) throws Exception {
	try {
		String Tc_method = method.getName();
		test = extent.createTest(Tc_method).assignCategory("Customer SignUp");
		test.log(Status.INFO, "Module:Customer SignUp");
		test.log(Status.INFO, "TC:Verify TC and Privacy policy is clickable");
		driver.activateApp("com.maf.sharesit");
		System.out.println(Tc_method);
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		//splashScreenFunctions.splashScreenSkip(splashScreenPage);
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		generalFunctions.isElementPresent(registrationPage.startElement, 90);
		registrationFunctions.startButton(registrationPage);
		generalFunctions.isElementPresent(registrationPage.titleMr, 90);
		registrationPage.titleMr.click();
		registrationFunctions.firstName(registrationPage);
		registrationFunctions.lastName(registrationPage);
		registrationFunctions.emailId(registrationPage);
		driver.hideKeyboard();
		registrationFunctions.mobileNumber(registrationPage);
		driver.hideKeyboard();
		registrationFunctions.nextButton(registrationPage);
		generalFunctions.isElementPresent(registrationPage.nationalityElement, 90);
		registrationFunctions.userYear(registrationPage);
		registrationPage.calendarOK.click();
		registrationFunctions.nationalityClick(registrationPage);
		generalFunctions.isElementPresent(registrationPage.passwordElement, 10);
		registrationFunctions.passwordText(registrationPage);
		driver.hideKeyboard();
		registrationFunctions.ppClick(registrationPage);
		Thread.sleep(5000);
		generalFunctions.isElementPresent(registrationPage.NavigateBack, 20);
		if(generalFunctions.isElementPresent(registrationPage.NavigateBack, 10)) {
			test.log(Status.PASS, "Privacy Policy Screen displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, Tc_method));
			Thread.sleep(2000);
			registrationPage.NavigateBack.click();
		}else {
			test.log(Status.FAIL, "Privacy Policy Screen is not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, Tc_method));
		}
		generalFunctions.isElementPresent(registrationPage.passwordElement, 10);
		registrationFunctions.tcClick(registrationPage);
		Thread.sleep(5000);
		generalFunctions.isElementPresent(registrationPage.NavigateBack, 20);

		if(generalFunctions.isElementPresent(registrationPage.NavigateBack, 10)){
			test.log(Status.PASS, "Terms and Condition Screen displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, Tc_method));
			Thread.sleep(2000);
			registrationPage.NavigateBack.click();
			Thread.sleep(5000);
		}else {
			test.log(Status.FAIL, "Terms and Condition Screen  is not displayed");
		}
		

	}catch(Exception e) {
		e.printStackTrace();
		test.log(Status.FAIL, e.getCause());
		test.log(Status.FAIL, e.getMessage());
	}
}



@Test
public void TC_C_SU_035(Method method) throws Exception {
	try {
		String Tc_method = method.getName();
		test = extent.createTest(Tc_method).assignCategory("Customer SignUp");
		test.log(Status.INFO, "Module:Customer SignUp");
		test.log(Status.INFO, "TC: Verify user with less than 10 year is not able to register");
		driver.activateApp("com.maf.sharesit");
		System.out.println(Tc_method);
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		//splashScreenFunctions.splashScreenSkip(splashScreenPage);
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		generalFunctions.isElementPresent(registrationPage.startElement, 90);
		registrationFunctions.startButton(registrationPage);
		generalFunctions.isElementPresent(registrationPage.titleMr, 90);
		registrationPage.titleMr.click();
		registrationFunctions.firstName(registrationPage);
		registrationFunctions.lastName(registrationPage);
		registrationFunctions.emailId(registrationPage);
		driver.hideKeyboard();
		registrationFunctions.mobileNumber(registrationPage);
		driver.hideKeyboard();
		registrationFunctions.nextButton(registrationPage);
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


@Test
public void TC_C_SU_036(Method method) throws Exception {
	try {
		String Tc_method = method.getName();
		test = extent.createTest(Tc_method).assignCategory("Customer SignUp");
		test.log(Status.INFO, "Module:Customer SignUp");
		test.log(Status.INFO, "TC:Verify user able to view information by clicking on i Button in Date of Birth ");
		driver.activateApp("com.maf.sharesit");
		System.out.println(Tc_method);
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		generalFunctions.isElementPresent(registrationPage.startElement, 90);
		registrationFunctions.startButton(registrationPage);
		generalFunctions.isElementPresent(registrationPage.titleMr, 90);
		registrationPage.titleMr.click();
		registrationFunctions.firstName(registrationPage);
		registrationFunctions.lastName(registrationPage);
		registrationFunctions.emailId(registrationPage);
		driver.hideKeyboard();
		registrationFunctions.mobileNumber(registrationPage);
		driver.hideKeyboard();
		registrationFunctions.nextButton(registrationPage);
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



@Test(dataProvider = "registrationdatayear")//iteration
public void TC_C_SU_037_38_39(Method method,String ryear, String remail) throws Exception {
	try {
		String Tc_method = method.getName();
		test = extent.createTest(Tc_method).assignCategory("Customer SignUp");
		test.log(Status.INFO, "Module:Customer SignUp");
		test.log(Status.INFO, "TC:Verify user able to select year from calendar with different range of year ");
		driver.resetApp();
		//driver.activateApp("com.maf.sharesit");
		System.out.println(Tc_method);
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		//splashScreenFunctions.splashScreenSkip(splashScreenPage);
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		generalFunctions.isElementPresent(registrationPage.startElement, 90);
		registrationFunctions.startButton(registrationPage);
		generalFunctions.isElementPresent(registrationPage.titleMr, 90);
		registrationPage.titleMr.click();
		registrationFunctions.firstName(registrationPage);
		registrationFunctions.lastName(registrationPage);
		registrationFunctions.emailId(registrationPage);
		driver.hideKeyboard();
		registrationFunctions.mobileNumber(registrationPage);
		driver.hideKeyboard();
		registrationFunctions.nextButton(registrationPage);
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


@Test
public void TC_C_SU_042(Method method) throws Exception {
	try {
		String Tc_method = method.getName();
		test = extent.createTest(Tc_method).assignCategory("Customer SignUp");
		test.log(Status.INFO, "Module:Customer SignUp");
		test.log(Status.INFO, "TC:Verify user can navigate to Sign in screen from registration 1st Screen ");
		driver.resetApp();
		//driver.activateApp("com.maf.sharesit");
		System.out.println(Tc_method);
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		//splashScreenFunctions.splashScreenSkip(splashScreenPage);
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		generalFunctions.isElementPresent(registrationPage.startElement, 90);
		registrationFunctions.startButton(registrationPage);
		generalFunctions.isElementPresent(registrationPage.titleMr, 90);
		registrationPage.titleMr.click();
		registrationFunctions.firstName(registrationPage);
		registrationFunctions.lastName(registrationPage);
		registrationFunctions.emailId(registrationPage);
		driver.hideKeyboard();
		registrationFunctions.mobileNumber(registrationPage);
		driver.hideKeyboard();
		signInFunctions.SignInUser(signInPage);
		generalFunctions.isElementPresent(registrationPage.HomeIcon, 10);
		if(generalFunctions.isElementPresent(registrationPage.HomeIcon, 10)) {
			test.log(Status.PASS, "Able to sign in and HomeScreen displayed");
		}else {
			test.log(Status.FAIL, "Able to sign in");
		}		

	}catch(Exception e) {
		e.printStackTrace();
		test.log(Status.FAIL, e.getCause());
		test.log(Status.FAIL, e.getMessage());

	}

}

@Test
public void TC_C_SU_043(Method method) throws Exception {
	try {
		String Tc_method = method.getName();
		test = extent.createTest(Tc_method).assignCategory("Customer SignUp");
		test.log(Status.INFO, "Module:Customer SignUp");
		test.log(Status.INFO, "TC:Verify user can navigate to Sign in screen from registration 2st Screen ");
		driver.resetApp();
		//driver.activateApp("com.maf.sharesit");
		System.out.println(Tc_method);
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		//splashScreenFunctions.splashScreenSkip(splashScreenPage);
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		generalFunctions.isElementPresent(registrationPage.startElement, 90);
		registrationFunctions.startButton(registrationPage);
		generalFunctions.isElementPresent(registrationPage.titleMr, 90);
		registrationPage.titleMr.click();
		registrationFunctions.firstName(registrationPage);
		registrationFunctions.lastName(registrationPage);
		registrationFunctions.emailId(registrationPage);
		driver.hideKeyboard();
		registrationFunctions.mobileNumber(registrationPage);
		driver.hideKeyboard();
		registrationFunctions.nextButton(registrationPage);
		generalFunctions.isElementPresent(registrationPage.nationalityElement, 90);
		signInFunctions.SignInUser(signInPage);
		generalFunctions.isElementPresent(registrationPage.HomeIcon, 10);
		if(generalFunctions.isElementPresent(registrationPage.HomeIcon, 10)) {
			test.log(Status.PASS, "Able to sign in and HomeScreen displayed");
		}else {
			test.log(Status.FAIL, "Able to sign in");
		}		

	}catch(Exception e) {
		e.printStackTrace();
		test.log(Status.FAIL, e.getCause());
		test.log(Status.FAIL, e.getMessage());

	}

}

@Test
public void TC_C_SU_044(Method method) throws Exception {
	try {
		String Tc_method = method.getName();
		test = extent.createTest(Tc_method).assignCategory("Customer SignUp");
		test.log(Status.INFO, "Module:Customer SignUp");
		test.log(Status.INFO, "TC:Verify user can navigate to 1st screen from screen2");
		driver.resetApp();
		//driver.activateApp("com.maf.sharesit");
		System.out.println(Tc_method);
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		//splashScreenFunctions.splashScreenSkip(splashScreenPage);
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		generalFunctions.isElementPresent(registrationPage.startElement, 90);
		registrationFunctions.startButton(registrationPage);
		generalFunctions.isElementPresent(registrationPage.titleMr, 90);
		registrationPage.titleMr.click();
		registrationFunctions.firstName(registrationPage);
		registrationFunctions.lastName(registrationPage);
		registrationFunctions.emailId(registrationPage);
		driver.hideKeyboard();
		registrationFunctions.mobileNumber(registrationPage);
		driver.hideKeyboard();
		registrationFunctions.nextButton(registrationPage);
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
@Test(dataProvider = "registrationdatayear")//iteration
public void TC_C_SU_045(Method method, String ryear, String remail) {
	try {
		String Tc_method = method.getName();
		test = extent.createTest(Tc_method).assignCategory("Customer SignUp");
		test.log(Status.INFO, "Module:Customer SignUp");
		test.log(Status.INFO, "TC:Verify user is able to register with incorrect email id format");
		driver.resetApp();
		//driver.activateApp("com.maf.sharesit");
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		splashScreenFunctions.splashScreenSkip(splashScreenPage);
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		generalFunctions.isElementPresent(registrationPage.startElement, 90);
		registrationFunctions.startButton(registrationPage);
		generalFunctions.isElementPresent(registrationPage.titleMr, 90);
		registrationPage.titleMr.click();
		registrationFunctions.firstName(registrationPage);
		registrationFunctions.lastName(registrationPage);
		registrationPage.emailElement.click();
		registrationPage.emailElement.sendKeys(remail);
		driver.hideKeyboard();
		registrationPage.mobileNumElement.click();
		registrationFunctions.mobileNumber(registrationPage);
		driver.hideKeyboard();
		if(generalFunctions.isElementPresent(registrationPage.ErrorMessage, 10)) {
			test.log(Status.PASS, "Displayed the Email field error message ").addScreenCaptureFromPath(Utilities.getScreenshot(driver, Tc_method));

		}else {
			test.log(Status.FAIL, "Email field error message is NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, Tc_method));
		}
		//			Thread.sleep(2000);
		if(generalFunctions.isElementPresent(registrationPage.nextElementDisabled, 10)) {
			test.log(Status.PASS, "Continue button is disabled");
		}else {
			test.log(Status.FAIL, "Continue button is Enabled");
		}

	}catch(Exception e) {
		e.printStackTrace();
		test.log(Status.FAIL, e.getCause());
		test.log(Status.FAIL, e.getMessage());

	}

}

@Test
public void TC_C_SU_003(Method method) throws Exception {
	try {
		String Tc_method = method.getName();
		test = extent.createTest(Tc_method).assignCategory("Customer SignUp");
		test.log(Status.INFO, "Module:Customer SignUp");
		test.log(Status.INFO, "TC:Verify user is able to navigate back to First screen using the back button in application  and modify the data and complete registration");
		driver.resetApp();
		//driver.activateApp("com.maf.sharesit");
		System.out.println(Tc_method);
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		//splashScreenFunctions.splashScreenSkip(splashScreenPage);
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		generalFunctions.isElementPresent(registrationPage.startElement, 90);
		registrationFunctions.startButton(registrationPage);
		generalFunctions.isElementPresent(registrationPage.titleMr, 90);
		registrationPage.titleMr.click();
		registrationFunctions.firstName(registrationPage);
		registrationFunctions.lastName(registrationPage);
		registrationPage.emailElement.sendKeys("smuser201@yopmail.com");
		//registrationFunctions.emailId(registrationPage);
		driver.hideKeyboard();
		registrationFunctions.mobileNumber(registrationPage);
		driver.hideKeyboard();
		registrationFunctions.nextButton(registrationPage);
		generalFunctions.isElementPresent(registrationPage.nationalityElement, 90);
		registrationPage.backtoStep.click();
		generalFunctions.isElementPresent(registrationPage.firstNameElement, 90);
		registrationFunctions.cleardata(registrationPage);
		Thread.sleep(500);
		registrationPage.firstNameElement.sendKeys(registrationFunctions.efirstname);
		registrationPage.lastNameElement.sendKeys(registrationFunctions.elastname);
		registrationPage.emailElement.sendKeys("smuser201@yopmail.com");
		//registrationPage.emailElement.sendKeys(registrationFunctions.eemail);
		driver.hideKeyboard();
		registrationFunctions.nextButton(registrationPage);
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
	}catch(Exception e) {
		e.printStackTrace();
		test.log(Status.FAIL, e.getCause());
		test.log(Status.FAIL, e.getMessage());

	}

}


@Test
public void TC_C_SU_047(Method method) throws Exception {
	try {
		String Tc_method = method.getName();
		test = extent.createTest(Tc_method).assignCategory("Customer SignUp");
		test.log(Status.INFO, "Module:Customer SignUp");
		test.log(Status.INFO, "TC:Verify the Send again button is working in the registration Successful screen");
		driver.resetApp();
		//driver.activateApp("com.maf.sharesit");
		System.out.println(Tc_method);
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		//splashScreenFunctions.splashScreenSkip(splashScreenPage);
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		generalFunctions.isElementPresent(registrationPage.startElement, 90);
		registrationFunctions.startButton(registrationPage);
		generalFunctions.isElementPresent(registrationPage.titleMr, 90);
		registrationPage.titleMr.click();
		registrationFunctions.firstName(registrationPage);
		registrationFunctions.lastName(registrationPage);
		registrationFunctions.emailId(registrationPage);
		driver.hideKeyboard();
		registrationFunctions.mobileNumber(registrationPage);
		driver.hideKeyboard();
		registrationFunctions.nextButton(registrationPage);
		generalFunctions.isElementPresent(registrationPage.nationalityElement, 90);
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

		if(generalFunctions.isElementPresent(registrationPage.sendAgain, 10)) {
			test.log(Status.PASS, "Registration Successful"+registrationPage.sendAgain);
			registrationPage.sendAgain.click();
		}else {
			test.log(Status.FAIL, "Registration Failed");

		}

	}catch(Exception e) {
		e.printStackTrace();
		test.log(Status.FAIL, e.getCause());
		test.log(Status.FAIL, e.getMessage());

	}
}
@Test
public void TC_C_SU_048(Method method) throws Exception {
	try {
		String Tc_method = method.getName();
		test = extent.createTest(Tc_method).assignCategory("Customer SignUp");
		test.log(Status.INFO, "Module:Customer SignUp");
		test.log(Status.INFO, "TC:Verify the user can register successfully");
		driver.resetApp();
		//driver.activateApp("com.maf.sharesit");
		System.out.println(Tc_method);
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		//splashScreenFunctions.splashScreenSkip(splashScreenPage);
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		generalFunctions.isElementPresent(registrationPage.startElement, 90);
		registrationFunctions.startButton(registrationPage);
		generalFunctions.isElementPresent(registrationPage.titleMr, 90);
		registrationPage.titleMr.click();
		registrationFunctions.firstName(registrationPage);
		registrationFunctions.lastName(registrationPage);
		registrationFunctions.emailId(registrationPage);
		driver.hideKeyboard();
		registrationFunctions.mobileNumber(registrationPage);
		driver.hideKeyboard();
		registrationFunctions.nextButton(registrationPage);
		generalFunctions.isElementPresent(registrationPage.nationalityElement, 90);
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


@Test
public void TC_C_SU_049(Method method) {
	try {
		String Tc_method = method.getName();
		test = extent.createTest(Tc_method).assignCategory("Customer SignUp");
		test.log(Status.INFO, "Module:Customer SignUp");
		test.log(Status.INFO, "TC:Verify the Show Password button is working");
		driver.resetApp();
		//driver.activateApp("com.maf.sharesit");
		System.out.println(Tc_method);
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		//splashScreenFunctions.splashScreenSkip(splashScreenPage);
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		generalFunctions.isElementPresent(registrationPage.startElement, 90);
		registrationFunctions.startButton(registrationPage);
		generalFunctions.isElementPresent(registrationPage.titleMr, 90);
		registrationPage.titleMr.click();
		registrationFunctions.firstName(registrationPage);
		registrationFunctions.lastName(registrationPage);
		registrationFunctions.emailId(registrationPage);
		driver.hideKeyboard();
		registrationFunctions.mobileNumber(registrationPage);
		driver.hideKeyboard();
		registrationFunctions.nextButton(registrationPage);
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


//////////////----------------------------------------Share V1 Script------------------------------------//////////////////
//	@Test(priority=36)
//	public void TC_R_P_003(Method method) throws InterruptedException {
//		try {
//			String Tc_method = method.getName();
//			test = extent.createTest(Tc_method);
//			test.log(Status.INFO, "Scenario:Positive Scenario");
//			test.log(Status.INFO, "Register only with Mandatory Fields");
//			test.assignCategory("Registration");
//			driver.activateApp("com.maf.sharesit");
//			RegistrationPage registrationPage = new RegistrationPage(driver);
//			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
//			GeneralFunctions generalFunctions = new GeneralFunctions();
//			//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			generalFunctions.isElementPresent(registrationPage.startElement, 90);
//			registrationFunctions.startButtonPresent(registrationPage);
//			registrationFunctions.startButton(registrationPage);
//			registrationFunctions.psemail(registrationPage);
//			registrationFunctions.countryCode(registrationPage);
//			registrationFunctions.mobileNumber(registrationPage);
//			generalFunctions.isElementPresent(registrationPage.nextElement, 90);
//			if(registrationFunctions.nextEnabled(registrationPage)==true) {
//				//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//				registrationFunctions.nextButton(registrationPage);
//				Thread.sleep(5000);
//				registrationFunctions.cleardata(registrationPage);
//			}else {
//				test.log(Status.FAIL, "Mandatory fields are not filled");
//				//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//				System.out.println("Please fill all the Mandatory fields");
//			}
//			generalFunctions.isElementPresent(registrationPage.titlePresent, 90);
//			if(registrationFunctions.titlefield(registrationPage)== true) {
//				//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//				registrationFunctions.title(registrationPage);
//			}else {
//				test.log(Status.FAIL, "The Next Screen not Displayed");
//				System.out.println("Next Screen not displayed");
//			}
//			generalFunctions.isElementPresent(registrationPage.firstNameElement, 90);
//			registrationFunctions.firstNametap(registrationPage);
//			registrationFunctions.firstName(registrationPage);
//			generalFunctions.isElementPresent(registrationPage.lastNameElement, 90);
//			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			registrationFunctions.lastnametap(registrationPage);
//			registrationFunctions.lastName(registrationPage);
//			generalFunctions.isElementPresent(registrationPage.nextElement, 90);
//			if(registrationFunctions.nextEnabled(registrationPage)==true) {
//				//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//				registrationFunctions.nextButton(registrationPage);
//			}else {
//				test.log(Status.FAIL, "Mandatory fields are not filled");
//				//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//				System.out.println("Please fill all the Mandatory fields");
//			}
//			generalFunctions.isElementPresent(registrationPage.datePicker, 90);
//			registrationFunctions.datePicker(registrationPage);
//			registrationFunctions.nextButton(registrationPage);
//			if(registrationFunctions.passwordFields(registrationPage)==true) {
//				//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//				registrationFunctions.passwordText(registrationPage);	
//			}else {
//				test.log(Status.FAIL, "The Password screen is not displayed");
//				System.out.println("The Password screen is not displayed");
//			}
//
//			registrationFunctions.confirmpasswordText(registrationPage);
//			registrationFunctions.termsButton(registrationPage);
//			registrationFunctions.offersButton(registrationPage);
//			generalFunctions.isElementPresent(registrationPage.nextElement, 90);
//			if(registrationFunctions.nextEnabled(registrationPage)==true) {
//				//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//				Thread.sleep(10000);
//				registrationFunctions.nextButton(registrationPage);
//			}else {
//				test.log(Status.FAIL, "Mandatory fields are not filled");
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//				System.out.println("Please fill all the Mandatory fields");
//			}
//			generalFunctions.isElementPresent(registrationPage.thanksElement, 90);
//			if(registrationFunctions.thanksButtonPresent(registrationPage)==true){
//				//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//				//registrationFunctions.thanksButton(registrationPage);
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//				test.log(Status.PASS, "Registration Success");
//			}else {
//				test.log(Status.FAIL, "Registration is not Successfull");
//
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			test.log(Status.FAIL, e.getCause());
//			test.log(Status.FAIL, e.getMessage());
//		}
//	}
//
//
//	@Test(priority=37)
//	public void TC_R_P_004(Method method) throws Exception {
//		try {
//			String Tc_method = method.getName();
//			test = extent.createTest(Tc_method);
//			test.log(Status.INFO, "Scenario:Positive Scenario");
//			test.log(Status.INFO, "Register with non Mandatory Fields");
//			test.assignCategory("Registration");
//			driver.activateApp("com.maf.sharesit");
//			RegistrationPage registrationPage = new RegistrationPage(driver);
//			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
//			GeneralFunctions GeneralFunctions = new GeneralFunctions();
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			registrationFunctions.startButtonPresent(registrationPage);
//			registrationFunctions.startButton(registrationPage);
//			registrationFunctions.psemailid(registrationPage);
//			registrationFunctions.countryCode(registrationPage);
//			registrationFunctions.mobileNumber(registrationPage);
//			driver.hideKeyboard();
//			if(registrationFunctions.nextEnabled(registrationPage)==true) {
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//				registrationFunctions.nextButton(registrationPage);
//				Thread.sleep(5000);
//				registrationFunctions.cleardata(registrationPage);
//			}else {
//				test.log(Status.FAIL, "Mandatory fields are not filled");
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//				System.out.println("Please fill all the Mandatory fields");
//			}
//			if(registrationFunctions.titlefield(registrationPage)== true) {
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//				registrationFunctions.title(registrationPage);
//			}else {
//				test.log(Status.FAIL, "The Next Screen not Displayed");
//				System.out.println("Next Screen not displayed");
//			}
//			registrationFunctions.firstNametap(registrationPage);
//			registrationFunctions.firstName(registrationPage);
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			registrationFunctions.lastnametap(registrationPage);
//			registrationFunctions.lastName(registrationPage);
//			//	driver.hideKeyboard(); //uncomment while running on emulators
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			registrationFunctions.nationalitySelection(registrationPage);
//			registrationFunctions.nationalityClick(registrationPage);
//			if(registrationFunctions.nextEnabled(registrationPage)==true) {
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//				registrationFunctions.nextButton(registrationPage);
//			}else {
//				test.log(Status.FAIL, "Mandatory fields are not filled");
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//				System.out.println("Please fill all the Mandatory fields");
//			}
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			registrationFunctions.datePicker(registrationPage);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			registrationFunctions.datePickerSpinner(registrationPage);
//			registrationFunctions.nextButton(registrationPage);
//			if(registrationFunctions.passwordFields(registrationPage)==true) {
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//				registrationFunctions.passwordText(registrationPage);	
//			}else {
//				test.log(Status.FAIL, "The Password screen is not displayed");
//				System.out.println("The Password screen is not displayed");
//			}
//
//			registrationFunctions.confirmpasswordText(registrationPage);
//			registrationFunctions.termsButton(registrationPage);
//			registrationFunctions.offersButton(registrationPage);
//			if(registrationFunctions.nextEnabled(registrationPage)==true) {
//				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//				Thread.sleep(10000);
//				registrationFunctions.nextButton(registrationPage);
//			}else {
//				test.log(Status.FAIL, "Mandatory fields are not filled");
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//				System.out.println("Please fill all the Mandatory fields");
//			}
//			if(registrationFunctions.thanksButtonPresent(registrationPage)==true){
//				//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//				//registrationFunctions.thanksButton(registrationPage);
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//				test.log(Status.PASS, "Registration Success");
//			}else {
//				test.log(Status.FAIL, "Registration is not Successfull");
//				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			test.log(Status.FAIL, e.getCause());
//			test.log(Status.FAIL, e.getMessage());
//		}
//	}
//
//	//-------------*********************************FIELD VALIDATION**********************************------------//
//
//
//
//	@Test(priority=4)
//	public void TC_R_FV_004(Method method) throws InterruptedException {
//		try {
//			String TC_Method = method.getName();
//			test = extent.createTest(TC_Method);
//			test.log(Status.INFO, "Scenario:Field Validation");
//			test.log(Status.INFO, "Validate the field in the 4th Screen");
//			driver.activateApp("com.maf.sharesit");
//			RegistrationPage registrationPage = new RegistrationPage(driver);
//			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
//			GeneralFunctions GeneralFunctions = new GeneralFunctions();
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			registrationFunctions.startButtonPresent(registrationPage);
//			registrationFunctions.startButton(registrationPage);
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			registrationFunctions.fdemailid(registrationPage);
//			registrationFunctions.countryCode(registrationPage);
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			registrationFunctions.mobileNumber(registrationPage);
//			registrationFunctions.nextButton(registrationPage);
//			Thread.sleep(5000);
//			registrationFunctions.cleardata(registrationPage);
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			registrationFunctions.title(registrationPage);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			registrationFunctions.firstNametap(registrationPage);
//			registrationFunctions.firstName(registrationPage);
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			registrationFunctions.lastnametap(registrationPage);
//			registrationFunctions.lastName(registrationPage);
//			driver.hideKeyboard();
//			registrationFunctions.nextButton(registrationPage);
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			registrationFunctions.datePicker(registrationPage);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			registrationFunctions.nextButton(registrationPage);
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			if(registrationFunctions.passwordFields(registrationPage)==true) {
//				test.log(Status.PASS, "The Password Field is Present");
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			}else {
//				test.log(Status.FAIL, "The Password field is not Present");
//			}
//			if(registrationFunctions.passwordCriteriaA(registrationPage)==true) {
//				test.log(Status.PASS, "Use atleast 8 characters: PRESENT");
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			}else {
//				test.log(Status.FAIL, "Use atleast 8 characters: NOT PRESENT");
//			}
//			if(registrationFunctions.passwordCriteriaB(registrationPage)==true) {
//				test.log(Status.PASS, "Use atleast 1 number: PRESENT");
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			}else {
//				test.log(Status.FAIL, "Use atleast 1 number: NOT PRESENT");
//
//			}if(registrationFunctions.passwordCriteriaC(registrationPage)==true) {
//				test.log(Status.PASS, "Use atleast one uppercase letter: PRESENT");
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			}else {
//				test.log(Status.FAIL, "Use atleast one uppercase letter: NOT PRESENT");
//			}
////			if(registrationFunctions.passwordCriteriaD(registrationPage)==true) {
////				test.log(Status.PASS, "Use atleast one lowercase letter: PRESENT");
////				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
////			}else {
////				test.log(Status.FAIL, "Use atleast one lowercase letter: NOT PRESENT");
////			}
//			if(registrationFunctions.confirmPasswordField(registrationPage)==true) {
//				test.log(Status.PASS, "The Confirm Password Field is Present");
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			}else {
//				test.log(Status.FAIL, "The Confirm Password field is not Present");
//			}
//			if(registrationFunctions.termsButtonisEnabled(registrationPage)==true) {
//				test.log(Status.PASS, "I agree to the terms and conditions, and the privacy policy: PRESENT");
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			}else {
//				test.log(Status.FAIL, "I agree to the terms and conditions, and the privacy policy: NOT PRESENT");
//			}
//			if(registrationFunctions.offerssButtonisEnabled(registrationPage)==true) {
//				test.log(Status.PASS, "Keep me upto date with promotions and offers: PRESENT");
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			}else {
//				test.log(Status.FAIL,"Keep me upto date with promotions and offers: NOT PRESENT");
//			}
//			if(registrationFunctions.nextbuttonEnabled(registrationPage)!=true) {
//				test.log(Status.PASS, "Next Button is Disabled");
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			}else {
//				test.log(Status.FAIL, "Next Button is Enabled");
//			}	
//		}catch(Exception e){
//			e.printStackTrace();
//			test.log(Status.FAIL, e.getCause());
//			test.log(Status.FAIL, e.getMessage());
//		}
//	}
//
//	@Test(priority=5)
//	public void TC_R_FV_005(Method method) throws InterruptedException {
//		try {
//			String TC_Method = method.getName();
//			test= extent.createTest(TC_Method);
//			test.log(Status.INFO, "Scenario:Field Validation");
//			test.log(Status.INFO, "Validate the fields after filling the 4th Screen");
//			driver.activateApp("com.maf.sharesit");
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			RegistrationPage registrationPage = new RegistrationPage(driver);
//			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
//			GeneralFunctions GeneralFunctions = new GeneralFunctions();
//			registrationFunctions.startButtonPresent(registrationPage);
//			registrationFunctions.startButton(registrationPage);
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			registrationFunctions.fdemailid(registrationPage);
//			registrationFunctions.countryCode(registrationPage);
//			registrationFunctions.mobileNumber(registrationPage);
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			registrationFunctions.nextButton(registrationPage);
//			Thread.sleep(5000);
//			registrationFunctions.cleardata(registrationPage);
//			//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//			registrationFunctions.title(registrationPage);
//			registrationFunctions.firstNametap(registrationPage);
//			registrationFunctions.firstName(registrationPage);
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			registrationFunctions.lastnametap(registrationPage);
//			registrationFunctions.lastName(registrationPage);
//			driver.hideKeyboard();
//			registrationFunctions.nationalityClick(registrationPage);
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			registrationFunctions.nextButton(registrationPage);
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			registrationFunctions.nextButton(registrationPage);
//			Thread.sleep(5000);
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			registrationFunctions.passwordText(registrationPage);
//			registrationFunctions.confirmpasswordText(registrationPage);
//			registrationFunctions.termsButton(registrationPage);
//			registrationFunctions.offersButton(registrationPage);
//			if(registrationFunctions.nextbuttonEnabled(registrationPage)==true) {
//				try {
//					test.log(Status.PASS, "Mandatory Fileds are filled :Next button is Enabled");
//					Thread.sleep(20000);
//					registrationFunctions.nextButton(registrationPage);
//					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//					if(registrationFunctions.thanksButtonPresent(registrationPage)==true) {
//
//						//registrationFunctions.thanksButtonPresent(registrationPage);
//						test.log(Status.PASS, "Displayed the alert screen with Email verfication message and Thanks button");
//						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//					}else {
//						test.log(Status.FAIL, "Email verification with Thanks button is not DISPLAYED");
//					}
//
//				}catch(Exception e) {
//					e.printStackTrace();
//					test.log(Status.FAIL, e.getCause());
//					test.log(Status.FAIL, e.getMessage());
//				}
//			}else {
//				test.log(Status.FAIL, "Mandatory Fileds are filled :Next button is Disabled");
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			test.log(Status.FAIL, e.getCause());
//			test.log(Status.FAIL, e.getMessage());
//		}
//	}
//
//
//	//------------------------------------*************************BUTTON VALIDATION**************************--------------------------------------------------------//
//
//
//	//------------------------------------***********************------------------------****************************--------------------------------------------
//	//---------------------------------------******* DATA VALIDATION ****************------------------*****************------------------------------------- 
//
//	@Test(priority=15)
//	public void TC_R_DV_001(Method method){
//		try{
//			String TC_Method = method.getName();
//			test = extent.createTest(TC_Method);
//			test.log(Status.INFO, "Scenario : Data Validation");
//			test.info("Validate Email id Format");
//			test.assignCategory("Registration");
//			driver.activateApp("com.maf.sharesit");
//			//String EmailAddress="sss@";// Iteration
//			RegistrationPage registrationPage = new RegistrationPage(driver);
//			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
//			GeneralFunctions generalFunctions = new GeneralFunctions();
//			//Click GET STARTED
//			generalFunctions.isElementPresent(registrationPage.startElement, 90);	
//			registrationFunctions.startButton(registrationPage);	
//			generalFunctions.isElementPresent(registrationPage.emailElement, 90);
//			//Enter Email Address
//			registrationFunctions.dvemail(registrationPage);		
//			//Press Enter		
//			registrationFunctions.PressENTER();
//			generalFunctions.isElementPresent(registrationPage.ErrorMessage, 90);		
//			//Verify the Error Message
//			String Message=	registrationFunctions.GetMessage(registrationPage);
//			System.out.println("Error Message Displayed : "+Message);
//			if(Message.contains("This email address is not valid"))
//			{
//				test.log(Status.PASS, "Incorrect Email Address validation Succeeded");		
//			}
//			else
//			{
//				test.log(Status.FAIL, "Incorrect Email Address validation Failed");
//
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			test.log(Status.FAIL, e.getCause());
//			test.log(Status.FAIL, e.getMessage());
//		}
//	}
//
//	@Test(priority=16)
//	public void TC_R_DV_002(Method method) {
//		try{
//			String TC_Method = method.getName();
//			test = extent.createTest(TC_Method);
//			test.log(Status.INFO, "Scenario : Data Validation");
//			test.info("Validate an Incorrect email address");
//			test.assignCategory("Registration");
//			driver.activateApp("com.maf.sharesit");
//			//String EmailAddress="sss@";// Iteration
//			RegistrationPage registrationPage = new RegistrationPage(driver);
//			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
//			GeneralFunctions generalFunctions = new GeneralFunctions();
//			//Click GET STARTED
//			generalFunctions.isElementPresent(registrationPage.startElement, 90);	
//			registrationFunctions.startButton(registrationPage);	
//			generalFunctions.isElementPresent(registrationPage.emailElement, 90);
//			//Enter Email Address
//			registrationFunctions.dvemailid(registrationPage);		
//			//Press Enter		
//			registrationFunctions.PressENTER();
//			generalFunctions.isElementPresent(registrationPage.ErrorMessage, 90);		
//			//Verify the Error Message
//			String Message=	registrationFunctions.getErrorMessage(registrationPage);
//			System.out.println("Error Message Displayed : "+Message);
//			if(Message.contains("This email address is not valid. Please check and try again."))
//			{
//				test.log(Status.PASS, "Incorrect Email Address validation Succeeded");		
//			}
//			else
//			{
//				test.log(Status.FAIL, "Incorrect Email Address validation Failed");
//
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			test.log(Status.FAIL, e.getCause());
//			test.log(Status.FAIL, e.getMessage());
//		}
//	}
//
//	@Test(priority=17)
//	public void TC_R_DV_003(Method method){
//		try{
//			String TC_Method = method.getName();
//			test = extent.createTest(TC_Method);
//			test.log(Status.INFO, "Scenario : Data Validation");
//			test.info("Validate Country Code Field");
//			test.assignCategory("Registration");
//			driver.activateApp("com.maf.sharesit");
//			RegistrationPage registrationPage = new RegistrationPage(driver);
//			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
//			GeneralFunctions generalFunctions = new GeneralFunctions();
//			//Click GET STARTED
//			generalFunctions.isElementPresent(registrationPage.startElement, 90);	
//			registrationFunctions.startButton(registrationPage);	
//			generalFunctions.isElementPresent(registrationPage.emailElement, 90);
//			//Enter Email Address
//			registrationFunctions.emailId(registrationPage);	
//			//Press Enter		
//			registrationFunctions.PressENTER();
//			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//			//Verify the Error Message
//			generalFunctions.isElementPresent(registrationPage.ErrorMessage, 90);
//			String Message=	registrationFunctions.GetMessage(registrationPage);
//			System.out.println("Error Message Displayed : "+Message);
//			if(Message.contains("Select country code"))
//			{
//				test.log(Status.PASS, "country code validation Succeeded");
//			}
//			else
//			{
//				test.log(Status.FAIL, "country code validation Failed");
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			test.log(Status.FAIL, e.getCause());
//			test.log(Status.FAIL, e.getMessage());
//		}
//	}
//
//	@Test(priority=18)
//	public void TC_R_DV_004(Method method) {
//		try{
//			String TC_Method = method.getName();
//			test = extent.createTest(TC_Method);
//			test.log(Status.INFO, "Data Validation");
//			test.log(Status.INFO,"Validate mobile number");
//			test.assignCategory("Registration");
//			driver.activateApp("com.maf.sharesit");
//			RegistrationPage registrationPage = new RegistrationPage(driver);
//			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
//			GeneralFunctions generalFunctions = new GeneralFunctions();
//
//			//Click GET STARTED
//			generalFunctions.isElementPresent(registrationPage.startElement, 90);	
//			registrationFunctions.startButton(registrationPage);	
//			generalFunctions.isElementPresent(registrationPage.emailElement, 90);						
//			//Enter Email Address
//			registrationFunctions.emailId(registrationPage);
//			//Select country code
//			registrationFunctions.countryCode(registrationPage);
//			//Enter Mobile Number
//			registrationFunctions.dvmobileNumber(registrationPage);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);		
//			String phone =driver.findElement(By.xpath("//android.view.ViewGroup[@index='3']/android.widget.LinearLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.EditText[@index='0']")).getText().toString();
//			if(phone.length()<5)
//			{
//				//test.log(Status.FAIL, "Mobile number you entered has only less than 5 numbers");
//				System.out.println("Invalid Mobile number");
//
//				if(registrationFunctions.nextbuttonEnabled(registrationPage)==false)
//				{
//					test.log(Status.PASS, "invalid phone number validation Succeeded");
//				}
//				else
//				{
//					test.log(Status.FAIL, "invalid phone number validation Failed");
//				}
//				//Verify the Error Message
//				//String Message=	registrationFunctions.GetMessage(registrationPage);
//				//System.out.println("Error Message Displayed : "+Message);
//				//if(Message.contains("Please enter a valid phone number"))
//				//{
//				//test.log(Status.PASS, "invalid phone number validation Succeeded");
//				// }
//				//else
//				//{
//				//test.log(Status.FAIL, "invalid phone number validation Failed");
//				//}
//			}
//			else
//			{
//				System.out.println("valid Mobile number");
//
//				if(registrationFunctions.nextbuttonEnabled(registrationPage)==true)
//				{
//					test.log(Status.PASS, "valid phone number validation Succeeded");
//				}
//				else
//				{
//					test.log(Status.FAIL, "valid phone number validation Failed");
//				}
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			test.log(Status.FAIL, e.getCause());
//			test.log(Status.FAIL, e.getMessage());
//		}
//	}
//	@Test(priority=19)
//	public void TC_R_DV_005(Method method)throws InterruptedException{
//		try {
//			String TC_Method = method.getName();
//			test = extent.createTest(TC_Method);
//			test.log(Status.INFO, "Scenario : Data Validation");
//			test.log(Status.INFO, "Validate email id field using existing email id");
//			test.assignCategory("Registration");
//			driver.activateApp("com.maf.sharesit");
//			RegistrationPage registrationPage = new RegistrationPage(driver);
//			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
//			GeneralFunctions generalFunctions = new GeneralFunctions();
//			//Click GET STARTED
//			generalFunctions.isElementPresent(registrationPage.startElement, 90);	
//			registrationFunctions.startButton(registrationPage);	
//			generalFunctions.isElementPresent(registrationPage.emailElement, 90);
//			//Enter Email Address
//			//	registrationFunctions.emailfield(strDate+email, registrationPage);
//			registrationFunctions.existingEmail(registrationPage);
//			registrationFunctions.countryCode(registrationPage);
//			//Enter Mobile Number
//			registrationFunctions.mobileNumber(registrationPage);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			//Click Next
//			registrationFunctions.nextButton(registrationPage);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			Thread.sleep(5000);
//			if(registrationFunctions.closeButton(registrationPage)==true) {
//				test.log(Status.PASS, "The Email id is already existing alert displayed");
//				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			}else {
//				test.log(Status.FAIL, "The Email id is already existing alert is not displayed");
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			test.log(Status.FAIL, e.getCause());
//			test.log(Status.FAIL, e.getMessage());
//		}
//
//	}
//
//
//
//	@Test(priority=30)
//	public void TC_R_DV_016(Method method) throws InterruptedException {
//		try {
//			String TC_Method = method.getName();
//			test = extent.createTest(TC_Method);
//			test.log(Status.INFO, "Scenario: Register and SignIn");
//			test.assignCategory("Registration");
//			driver.activateApp("com.maf.sharesit");
//			RegistrationPage registrationPage = new RegistrationPage(driver);
//			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
//			GeneralFunctions generalFunctions = new GeneralFunctions();
//			SignInPage signInPage = new SignInPage(driver);
//			SignInFunctions signInFunctions = new SignInFunctions();
//			generalFunctions.isElementPresent(registrationPage.startElement, 90);	
//			registrationFunctions.startButton(registrationPage);	
//			generalFunctions.isElementPresent(registrationPage.emailElement, 90);
//
//
//			//Enter Email Address
//			signInFunctions.nonuseremailid(signInPage);
//			//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			registrationFunctions.countryCode(registrationPage);
//			//Enter Mobile Number
//			registrationFunctions.mobileNumber(registrationPage);
//			generalFunctions.isElementPresent(registrationPage.nextElement, 90);
//			//Click Next
//			registrationFunctions.nextButton(registrationPage);
//			Thread.sleep(5000);
//			registrationFunctions.cleardata(registrationPage);
//			generalFunctions.isElementPresent(registrationPage.titlePresent, 90);
//			//select Title
//			registrationFunctions.title(registrationPage);
//			generalFunctions.isElementPresent(registrationPage.firstNameElement, 90);
//			//Enter First Name
//			registrationFunctions.firstNametap(registrationPage);
//			registrationFunctions.firstName(registrationPage);
//			generalFunctions.isElementPresent(registrationPage.lastNameElement, 90);
//			//Enter Last Name
//			registrationFunctions.lastnametap(registrationPage);
//			registrationFunctions.lastName(registrationPage);
//			driver.hideKeyboard();
//			generalFunctions.isElementPresent(registrationPage.nextElement, 90);
//			registrationFunctions.nextButton(registrationPage);
//			generalFunctions.isElementPresent(registrationPage.nextElement, 90);
//			//Select DOB
//			//registrationPage.selectDate("25","Jan","1991");
//			//Click Next
//			registrationFunctions.nextButton(registrationPage);
//			//Thread.sleep(5000);
//			generalFunctions.isElementPresent(registrationPage.passwordElement, 90);
//			//Enter Password		
//			registrationFunctions.passwordText(registrationPage);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			//Enter Confirm Password	
//			registrationFunctions.confirmpasswordText(registrationPage);
//			driver.hideKeyboard();
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			registrationFunctions.termsButton(registrationPage);
//			registrationFunctions.offersButton(registrationPage);
//			generalFunctions.isElementPresent(registrationPage.nextElement, 90);
//			registrationFunctions.nextButton(registrationPage);
//			Thread.sleep(10000);
//			if(registrationFunctions.thanksButtonPresent(registrationPage)==true) {
//				test.log(Status.PASS, "Registration Successfull");
//				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//				registrationFunctions.thanksButton(registrationPage);
//				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//
//				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//				System.out.println("****Test****");
//				signInFunctions.nonuseremailid(signInPage);
//				signInFunctions.userpassword(signInPage);
//				signInFunctions.signInButton(signInPage);
//				if(signInFunctions.validateEmail(signInPage)==true) {
//					test.log(Status.PASS, "Email is not Verified alert is Dispalyed");
//					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//				}else {
//					test.log(Status.FAIL, "Email is not verified alert is NOT displayed");
//				}
//
//			}else {
//				test.log(Status.FAIL, "Registration Failed");
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			test.log(Status.FAIL, e.getCause());
//			test.log(Status.FAIL, e.getMessage());
//		}
//	}
//
//	@Test(priority=31)
//	public void TC_R_DV_017(Method method) throws InterruptedException {
//		try {
//			String TC_Method = method.getName();
//			test = extent.createTest(TC_Method);
//			test.log(Status.INFO, "Scenario: Register and SignIn");
//			test.log(Status.INFO, "Scenario: SignIn using Gmail");
//			test.assignCategory("Registration");
//			driver.activateApp("com.maf.sharesit");
//			RegistrationPage registrationPage = new RegistrationPage(driver);
//			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
//			GeneralFunctions generalFunctions = new GeneralFunctions();
//			SignInPage signInPage = new SignInPage(driver);
//			SignInFunctions signInFunctions = new SignInFunctions();
//			generalFunctions.isElementPresent(registrationPage.startElement, 90);
//			generalFunctions.isElementPresent(registrationPage.startElement, 90);	
//			registrationFunctions.startButton(registrationPage);	
//			generalFunctions.isElementPresent(registrationPage.emailElement, 90);
//			//Enter Email Address
//			registrationFunctions.dvremail(registrationPage);
//			//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			registrationFunctions.countryCode(registrationPage);
//			//Enter Mobile Number
//			registrationFunctions.mobileNumber(registrationPage);
//			generalFunctions.isElementPresent(registrationPage.nextElement, 90);
//			//Click Next
//			registrationFunctions.nextButton(registrationPage);
//			Thread.sleep(5000);
//			registrationFunctions.cleardata(registrationPage);
//			generalFunctions.isElementPresent(registrationPage.titlePresent, 90);
//			//select Title
//			registrationFunctions.title(registrationPage);
//			generalFunctions.isElementPresent(registrationPage.firstNameElement, 90);
//			//Enter First Name
//			registrationFunctions.firstNametap(registrationPage);
//			registrationFunctions.firstName(registrationPage);
//			generalFunctions.isElementPresent(registrationPage.lastNameElement, 90);
//			//Enter Last Name
//			registrationFunctions.lastnametap(registrationPage);
//			registrationFunctions.lastName(registrationPage);
//			driver.hideKeyboard();
//			generalFunctions.isElementPresent(registrationPage.nextElement, 90);
//			registrationFunctions.nextButton(registrationPage);
//			generalFunctions.isElementPresent(registrationPage.nextElement, 90);
//			//Select DOB
//			//registrationPage.selectDate("25","Jan","1991");
//			//Click Next
//			registrationFunctions.nextButton(registrationPage);
//			generalFunctions.isElementPresent(registrationPage.passwordElement, 90);
//			//Enter Password		
//			registrationFunctions.passwordText(registrationPage);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			//Enter Confirm Password	
//			registrationFunctions.confirmpasswordText(registrationPage);
//			driver.hideKeyboard();
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			registrationFunctions.termsButton(registrationPage);
//			registrationFunctions.offersButton(registrationPage);
//			generalFunctions.isElementPresent(registrationPage.nextElement, 90);
//			registrationFunctions.nextButton(registrationPage);
//			generalFunctions.isElementPresent(registrationPage.ErrorElement, 30);
//			registrationFunctions.connectionErrorPresent(registrationPage);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			driver.pressKey(new KeyEvent(AndroidKey.HOME));
//			driver.startActivity(new Activity("com.google.android.gm","ConversationListActivityGmail"));
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			Thread.sleep(10000);
//			driver.findElementByXPath("//android.widget.EditText[@text='Search mail']").click();
//			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
//			driver.findElementByXPath("//android.widget.EditText[@text='Search mail']").sendKeys("share");
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			driver.pressKey(new KeyEvent(AndroidKey.ENTER));
//			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//			driver.findElementByXPath("//android.widget.TextView[@text='sitauth0']").click();
//			driver.findElementById("com.google.android.gm:id/sender_name").isDisplayed();
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			System.out.println("Gmail");
//			//driver.findElementByXPath("//android.view.View[@text='VERIFY MY EMAIL']").click();
//			//TouchAction action1= new TouchAction(driver).tap(point(253,1639)).waitAction(waitOptions(Duration.ofMillis(1000))).perform();
//			//Thread.sleep(30000);
//			SignInFunctions signFunctions = new SignInFunctions();
//			signFunctions.signInClick(signInPage);
//			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
//			driver.pressKey(new KeyEvent(AndroidKey.HOME));
//			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//			driver.activateApp("com.maf.sharesit");
//			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//			registrationFunctions.onboardScreenDisplayed(registrationPage);
//			generalFunctions.isElementPresent(signInPage.signinElement, 90);
//			signInFunctions.SignInUser(signInPage);
//			/*Thread.sleep(5000);
//			TouchAction action= new TouchAction(driver).tap(point(782,1915)).waitAction(waitOptions(Duration.ofMillis(1000))).perform();
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			signInFunctions.useremailid(signInPage);
//			signInFunctions.userpassword(signInPage);
//			signInFunctions.signInButton(signInPage);
//			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);*/
//			generalFunctions.isElementPresent(signInPage.tutorialElement, 90);
//			if(signInFunctions.tutorialScreen(signInPage)==true) {
//				test.log(Status.PASS, "The user registered and SignIn Successfully");
//				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			}else {
//				test.log(Status.FAIL, "The Sign In is not Successful");
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			test.log(Status.FAIL, e.getCause());
//			test.log(Status.FAIL, e.getMessage());
//		}
//	}
//	@Test(priority=32)
//	public void TC_R_DV_018(Method method) throws InterruptedException {
//		try {
//			String TC_Method = method.getName();
//			test = extent.createTest(TC_Method);
//			test.log(Status.INFO, "Scenario: Register and SignIn");
//			test.log(Status.INFO, "Scenario: SignIn using Outlook");
//			test.assignCategory("Registration");
//			driver.activateApp("com.maf.sharesit");
//			driver.resetApp();
//			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
//			driver.activateApp("com.maf.sharesit");
//			RegistrationPage registrationPage = new RegistrationPage(driver);
//			SignInPage signInPage = new SignInPage(driver);
//			SignInFunctions signInFunctions = new SignInFunctions();
//			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
//			GeneralFunctions generalFunctions = new GeneralFunctions();
//			//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			generalFunctions.isElementPresent(registrationPage.startElement, 90);
//			registrationFunctions.startButton(registrationPage);		
//			generalFunctions.isElementPresent(registrationPage.emailElement, 90);
//
//			//Enter Email Address
//			registrationFunctions.dvroemail(registrationPage);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			registrationFunctions.countryCode(registrationPage);
//			//Enter Mobile Number
//			registrationFunctions.mobileNumber(registrationPage);
//			generalFunctions.isElementPresent(registrationPage.nextElement, 90);
//			//Click Next
//			registrationFunctions.nextButton(registrationPage);
//			Thread.sleep(5000);
//			//generalFunctions.isElementPresent(registrationPage.titlePresent, 90);
//			registrationFunctions.cleardata(registrationPage);
//			generalFunctions.isElementPresent(registrationPage.titlePresent, 90);
//			//select Title
//			registrationFunctions.title(registrationPage);
//			generalFunctions.isElementPresent(registrationPage.firstNameElement, 90);
//			//Enter First Name
//			registrationFunctions.firstNametap(registrationPage);
//			registrationFunctions.firstName(registrationPage);
//			generalFunctions.isElementPresent(registrationPage.lastNameElement, 90);
//			//Enter Last Name
//			registrationFunctions.lastnametap(registrationPage);
//			registrationFunctions.lastName(registrationPage);
//			driver.hideKeyboard();
//			generalFunctions.isElementPresent(registrationPage.nextElement, 90);
//			registrationFunctions.nextButton(registrationPage);
//			generalFunctions.isElementPresent(registrationPage.nextElement, 90);
//			//Select DOB
//			//registrationPage.selectDate("25","Jan","1991");
//			//Click Next
//			registrationFunctions.nextButton(registrationPage);
//			generalFunctions.isElementPresent(registrationPage.passwordElement, 90);
//			//Enter Password		
//			registrationFunctions.passwordText(registrationPage);
//			//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			//Enter Confirm Password	
//			registrationFunctions.confirmpasswordText(registrationPage);
//			driver.hideKeyboard();
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			registrationFunctions.termsButton(registrationPage);
//			registrationFunctions.offersButton(registrationPage);
//			generalFunctions.isElementPresent(registrationPage.nextElement, 90);
//			//Thread.sleep(10000);
//			registrationFunctions.nextButton(registrationPage);
//			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//			registrationFunctions.thanksButton(registrationPage);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			driver.pressKey(new KeyEvent(AndroidKey.HOME));
//			driver.startActivity(new Activity("com.microsoft.office.outlook","com.acompli.acompli.CentralActivity"));
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			Thread.sleep(5000);
//			driver.findElementById("com.microsoft.office.outlook:id/action_search").click();
//			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
//			driver.findElementById("com.microsoft.office.outlook:id/action_search").click();
//			driver.findElementById("com.microsoft.office.outlook:id/search_edit_text").sendKeys("verify");
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			driver.findElementById("com.microsoft.office.outlook:id/message_snippet_body").click();
//			Thread.sleep(5000);
//			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
//			TouchAction action1 = new TouchAction(driver).tap(point(245,1584)).waitAction(waitOptions(Duration.ofMillis(2000))).perform();
//			Thread.sleep(10000);
//			System.out.println("OUTLOOK");
//			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
//			driver.pressKey(new KeyEvent(AndroidKey.HOME));
//			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//			driver.activateApp("com.maf.sharesit");
//			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//			registrationFunctions.onboardScreenDisplayed(registrationPage);
//			generalFunctions.isElementPresent(signInPage.signinElement, 90);
//			//	Thread.sleep(5000);
//			signInFunctions.SignInUser(signInPage);
//			/*TouchAction action= new TouchAction(driver).tap(point(782,1915)).waitAction(waitOptions(Duration.ofMillis(1000))).perform();
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			signInFunctions.useremailid(signInPage);
//			signInFunctions.userpassword(signInPage);
//			signInFunctions.signInButton(signInPage);*/
//			generalFunctions.isElementPresent(signInPage.tutorialElement, 90);
//			if(signInFunctions.tutorialScreen(signInPage)==true) {
//				test.log(Status.PASS, "The user registered and SignIn Successfully");
//				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			}else {
//				test.log(Status.FAIL, "The Sign In is not Successful");
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			test.log(Status.FAIL, e.getCause());
//			test.log(Status.FAIL, e.getMessage());
//		}
//	}
//	@Test(priority=33)
//	public void TC_R_DV_019(Method method) throws InterruptedException {
//		try {
//			String TC_Method = method.getName();
//			test = extent.createTest(TC_Method);
//			test.log(Status.INFO, "Scenario: Register and SignIn");
//			test.log(Status.INFO, "Scenario: SignIn using Yahoo");
//			test.assignCategory("Registration");
//			driver.activateApp("com.maf.sharesit");
//			driver.resetApp();
//			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
//			driver.activateApp("com.maf.sharesit");
//			RegistrationPage registrationPage = new RegistrationPage(driver);
//			RegistrationFunctions registrationFunctions = new RegistrationFunctions();
//			GeneralFunctions generalFunctions = new GeneralFunctions();
//			SignInPage signInPage = new SignInPage(driver);
//			SignInFunctions signInFunctions = new SignInFunctions();
//			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			registrationFunctions.startButton(registrationPage);		
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//			//Enter Email Address
//			registrationFunctions.dvryemail(registrationPage);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			registrationFunctions.countryCode(registrationPage);
//			//Enter Mobile Number
//			registrationFunctions.mobileNumber(registrationPage);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			//Click Next
//			registrationFunctions.nextButton(registrationPage);
//			Thread.sleep(5000);
//			registrationFunctions.cleardata(registrationPage);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			//select Title
//			registrationFunctions.title(registrationPage);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			//Enter First Name
//			registrationFunctions.firstNametap(registrationPage);
//			registrationFunctions.firstName(registrationPage);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			//Enter Last Name
//			registrationFunctions.lastnametap(registrationPage);
//			registrationFunctions.lastName(registrationPage);
//			driver.hideKeyboard();
//			registrationFunctions.nextButton(registrationPage);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			//Select DOB
//			//registrationPage.selectDate("25","Jan","1991");
//			//Click Next
//			registrationFunctions.nextButton(registrationPage);
//			Thread.sleep(5000);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			//Enter Password		
//			registrationFunctions.passwordText(registrationPage);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			//Enter Confirm Password	
//			registrationFunctions.confirmpasswordText(registrationPage);
//			driver.hideKeyboard();
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			registrationFunctions.termsButton(registrationPage);
//			registrationFunctions.offersButton(registrationPage);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			Thread.sleep(10000);
//			registrationFunctions.nextButton(registrationPage);
//			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//			registrationFunctions.thanksButton(registrationPage);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			driver.pressKey(new KeyEvent(AndroidKey.HOME));
//			driver.startActivity(new Activity("com.yahoo.mobile.client.android.mail","com.yahoo.mobile.client.android.mail.activity.MainActivity"));
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			Thread.sleep(5000);
//			driver.findElementById("com.yahoo.mobile.client.android.mail:id/right_button_2").click();
//			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
//			driver.findElementById("com.yahoo.mobile.client.android.mail:id/search_edit_text").sendKeys("verify");
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			driver.pressKey(new KeyEvent(AndroidKey.ENTER));
//			driver.findElementById("com.yahoo.mobile.client.android.mail:id/email_description").click();
//			Thread.sleep(5000);
//			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
//			Thread.sleep(2000);
//			TouchAction action1 = new TouchAction(driver).tap(point(264,1416)).waitAction(waitOptions(Duration.ofMillis(2000))).perform();
//			Thread.sleep(10000);
//			System.out.println("YAHOO");
//			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
//			driver.pressKey(new KeyEvent(AndroidKey.HOME));
//			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//			driver.activateApp("com.maf.sharesit");
//			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//			registrationFunctions.onboardScreenDisplayed(registrationPage);
//			generalFunctions.isElementPresent(signInPage.signinElement, 90);
//			//	Thread.sleep(5000);
//			signInFunctions.SignInUser(signInPage);
//			/*	TouchAction action= new TouchAction(driver).tap(point(782,1915)).waitAction(waitOptions(Duration.ofMillis(1000))).perform();
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			signInFunctions.useremailid(signInPage);
//			signInFunctions.userpassword(signInPage);
//			signInFunctions.signInButton(signInPage);*/
//			generalFunctions.isElementPresent(signInPage.tutorialElement, 90);
//			//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//			if(signInFunctions.tutorialScreen(signInPage)==true) {
//				test.log(Status.PASS, "The user registered and SignIn Successfully");
//				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			}else {
//				test.log(Status.FAIL, "The Sign In is not Successful");
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			test.log(Status.FAIL, e.getCause());
//			test.log(Status.FAIL, e.getMessage());
//		}
//	}
//}
//for checking password criteria
//if(passVal.contains(password)){
//	test.log(Status.PASS, "Password contains 8 characters with Uppercase,Lowercase and Numbers");
//	test.log(Status.PASS, registrationPage.passwordCriteriaA.getText());
//	test.log(Status.PASS, registrationPage.passwordCriteriaB.getText());
//	test.log(Status.PASS, registrationPage.passwordCriteriaC.getText());
//}else {
//	Thread.sleep(2000);
//if(generalFunctions.isElementPresent(registrationPage.passwordCriteriaADisabled, 10)) {
//	test.log(Status.PASS, "The password does not contain 8 characters and the Button is disabled");
//}else if(registrationFunctions.passwordCriteriaA(registrationPage)) {
//	test.log(Status.FAIL, "The password does not contain 8 characters but the button is enabled");
//}else if(registrationPage.passwordCriteriaBDisabled.isDisplayed()) {
//	test.log(Status.PASS, "The password does not contain 1 number and the Button is disabled");
//}else if(registrationFunctions.passwordCriteriaB(registrationPage)) {
//	test.log(Status.FAIL, "The password does not contain 1 number but the button is enabled");
//}else if(registrationPage.passwordCriteriaCDisabled.isDisplayed()) {
//	test.log(Status.PASS, "The password does not contain 1 Uppercase or lowercase letters and the Button is disabled");
//}else if(registrationFunctions.passwordCriteriaC(registrationPage)) {
//	test.log(Status.FAIL, "The password does not contain 1 Uppercase or lowercase letters but the button is enabled");
//}
//}



