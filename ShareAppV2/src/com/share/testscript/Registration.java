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



