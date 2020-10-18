package com.share.testscript;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.share.functions.ProfileFunctions;
import com.share.functions.RegistrationFunctions;
import com.share.functions.SignInFunctions;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.ProfilePage;
import com.share.objectrepository.RegistrationPage;
import com.share.objectrepository.ExperiencesPage;
import com.share.objectrepository.HomePage;
import com.share.objectrepository.SharePayPage;
import com.share.objectrepository.SignInPage;
import com.share.utility.Utilities;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Profile extends DriverSetUp
{
	GeneralFunctions generalFunctions = new GeneralFunctions();
	
     //Profile - Landing screen
	@Test(priority=1)
	public void TC_Profile_001(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Profile - Landing screen");
		test.assignCategory("Profile");
		System.out.println(TC_Method);
		
		ProfilePage profilePage = new ProfilePage(driver);
		ProfileFunctions profileFunctions = new ProfileFunctions();
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{
			driver.resetApp();
			signInFunctions.SignContinue();
			profileFunctions.newUserSign();
			if(generalFunctions.isElementPresent(profilePage.AvatarName, 30))
			{
				test.log(Status.PASS, "Navigated To Profile Page");
			}
			else
			{
				test.log(Status.FAIL, "Not Navigated To Profile Page");
				Assert.fail("Not Navigated To Profile Page");
			}
			//Full Name
			if(generalFunctions.isElementPresent(profilePage.fullname, 30))
			{
				test.log(Status.PASS, "Full Name Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}	
			else
			{
				test.log(Status.FAIL, "Full Name Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Full Name Not Displayed");
			}
			//Joining Date
			if(generalFunctions.isElementPresent(profilePage.joiningDate, 30))
			{
				test.log(Status.PASS, "Joining Date Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Joining Date Not Displayed");
				Assert.fail("Joining Date Not Displayed");
			}
			//Avatar
			if(generalFunctions.isElementPresent(profilePage.AvatarName, 30))
			{
				test.log(Status.PASS, "Avatar Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Avatar Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Avatar Not Displayed");
			}
			//Personal Details
			if(generalFunctions.isElementPresent(profilePage.personalDetails, 30))
			{
				test.log(Status.PASS, "Personal Details Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Personal Details Not Displayed");
				Assert.fail("Personal Details Not Displayed");
			}
			//Payment Methods
			if(generalFunctions.isElementPresent(profilePage.paymentMethods, 30))
			{
				test.log(Status.PASS, "Payment Methods Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Payment Methods Not Displayed");
				Assert.fail("Payment Methods Not Displayed");
			}		
			//Notifications
			if(generalFunctions.isElementPresent(profilePage.notifications, 30))
			{
				test.log(Status.PASS, "Notifications Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Notifications Not Displayed");
				Assert.fail("Notifications Not Displayed");
			}		

			//Reset Password
			if(generalFunctions.isElementPresent(profilePage.resetPassword, 30))
			{
				test.log(Status.PASS, "Reset Password Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Reset Password Not Displayed");
				Assert.fail("Reset Password Not Displayed");
			}	
			
			generalFunctions.SimplyScrollDown();

			//Terms & Conditions
			if(generalFunctions.isElementPresent(profilePage.termsNconditions, 30))
			{
				test.log(Status.PASS, "Terms & Conditions Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Terms & Conditions Not Displayed");
				Assert.fail("Terms & Conditions Not Displayed");
			}	

			//Privacy Policy
			if(generalFunctions.isElementPresent(profilePage.privacyPolicy, 30))
			{
				test.log(Status.PASS, "Privacy Policy Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Privacy Policy Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Privacy Policy Not Displayed");
			}		

			//Logout
			if(generalFunctions.isElementPresent(profilePage.Logout, 30))
			{
			     test.log(Status.PASS, "Logout Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Logout Not Displayed");
				Assert.fail("Logout Not Displayed");
			}	


			//App Version
			if(generalFunctions.isElementPresent(profilePage.version, 30))
			{
				test.log(Status.PASS, "App Version Displayed");
			}
			else
			{
				test.log(Status.FAIL, "App Version Not Displayed");
				Assert.fail("App Version Not Displayed");
			}
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}

	}

     //Profile - Avatar Initials
	@Test(priority=2)
	public void TC_Profile_002(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Profile - Avatar Initials");
		test.assignCategory("Profile");
		System.out.println(TC_Method);

		ProfilePage profilePage = new ProfilePage(driver);
		try
		{
			//Click on Avatar icon
			generalFunctions.isElementPresent(profilePage.avatar, 20);
			profilePage.avatar.click();
			Thread.sleep(1000);

			//Full Name
			try
			{
				if(profilePage.fullname.isDisplayed()==true)
				{
					test.log(Status.PASS, "Full Name Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Full Name Not Displayed");
				Assert.fail("Full Name Not Displayed");
			}

			String FullName=generalFunctions.getText(profilePage.fullname);
			System.out.println(FullName);

			String[] parts = FullName.split(" ");

			String Fname = parts[0];

			String Lname = parts[1];
			System.out.println(Fname);
			System.out.println(Lname);

			String firstN = Fname.substring(0, 1);
			String lastN = Lname.substring(0, 1);
			System.out.println(firstN);
			System.out.println(lastN);

			Thread.sleep(10000);
			//Avatar
			try
			{
				if(profilePage.AvatarName.isDisplayed()==true)
				{
					test.log(Status.PASS, "Avatar Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Avatar Not Displayed");
				Assert.fail("Avatar Not Displayed");
			}

			String AvatarName=generalFunctions.getText(profilePage.AvatarName).trim();
			System.out.println("1 "+AvatarName);

			String AvatarNameStored =firstN+" "+lastN;
			System.out.println("2 "+AvatarNameStored);
			if(AvatarNameStored.trim().contains(AvatarName))
			{
				test.log(Status.PASS, "Avatar Name Displayed Correctly").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Avatar Name Not Displayed Correctly").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Avatar Name Not Displayed Correctly");
			}
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}


	@Test(priority=3)
	public void TC_Profile_003(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Profile");
		test.assignCategory("Profile");
		System.out.println(TC_Method);

		ProfilePage profilePage = new ProfilePage(driver);
		try
		{
			//Click on Avatar icon
			generalFunctions.isElementPresent(profilePage.avatar, 20);
			profilePage.avatar.click();
			Thread.sleep(2000);

			//Full Name
			try
			{
				if(profilePage.fullname.isDisplayed()==true)
				{
					test.log(Status.PASS, "Full Name Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Full Name Not Displayed");
				Assert.fail("Full Name Not Displayed");
			}

			//Joining Date
			try
			{
				if(profilePage.joiningDate.isDisplayed()==true)
				{
					test.log(Status.PASS, "Joining Date Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Joining Date Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Joining Date Not Displayed");
			}
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}

	}
	
	//TC:Verify all the radio buttons Present ( Mr, MS .Miss. Mrs)

	@Test(priority=5)
	public void TC_Profile_4_1(Method method) {
	try {
	String TC_method = method.getName();
	System.out.println(TC_method);
	test = extent.createTest(TC_method).assignCategory("Profile");
	test.log(Status.INFO, "Module:Profile");
	test.log(Status.INFO, "TC:Verify all the radio buttons Present");
	
	RegistrationPage registrationPage = new RegistrationPage(driver);
	ProfilePage profilePage = new ProfilePage(driver);
	GeneralFunctions generalFunctions = new GeneralFunctions();
	
	generalFunctions.isElementPresent(profilePage.avatar, 20);
	profilePage.avatar.click();
	try
	{if(profilePage.personalDetails.isDisplayed()==true)
		{test.log(Status.PASS, "Personal Details Displayed");
		}
	}
	catch(Exception x)
	{	test.log(Status.FAIL, "Personal Details Not Displayed");
		Assert.fail("Personal Details Not Displayed");
	}
	//click on Personal Details 
	profilePage.personalDetails.click();
	Thread.sleep(1000);
	//Edit Details
	if(generalFunctions.isElementPresent(profilePage.editDetails,60))
	{
	test.log(Status.PASS, "Edit Details Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
	}
	else
	{
	test.log(Status.FAIL, "Edit Details Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
	Assert.fail("Edit Details Not Displayed");
	}

	String first = registrationPage.titleMr.getText();
	String second = registrationPage.titleMrs.getText();
	String third = registrationPage.titleMiss.getText();
	String fourth = registrationPage.titleMs.getText();
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
	}
	else {
	test.log(Status.FAIL, "Title \"Ms\" is NOT Present");
	}
	}
	catch (Exception e) 
	{
	e.printStackTrace();
	test.log(Status.FAIL, e.getCause());
	test.log(Status.FAIL, e.getMessage());
	}
	}

	//TC:Verify the user is able to select other title radio button
	@Test(priority=6)
	public void TC_Profile_4_2(Method method) {
	try {
	String TC_method = method.getName();
	test = extent.createTest(TC_method).assignCategory("Profile");
	test.log(Status.INFO, "Module:Profile");
	test.log(Status.INFO, "TC:Verify the user is able to select other title radio button[Miss and Ms]");
	System.out.println(TC_method);
	RegistrationPage registrationPage = new RegistrationPage(driver);
	ProfilePage profilePage = new ProfilePage(driver);
	GeneralFunctions generalFunctions = new GeneralFunctions();
	//Click on Avatar icon
	generalFunctions.isElementPresent(profilePage.avatar, 20);
	profilePage.avatar.click();
	try
	{if(profilePage.personalDetails.isDisplayed()==true)
		{test.log(Status.PASS, "Personal Details Displayed");
		}
	}
	catch(Exception x)
	{	test.log(Status.FAIL, "Personal Details Not Displayed");
		Assert.fail("Personal Details Not Displayed");
	}
	//click on Personal Details 
	profilePage.personalDetails.click();
	Thread.sleep(1000);
	//Edit Details

	if(generalFunctions.isElementPresent(profilePage.editDetails,60))
	{
	test.log(Status.PASS, "Edit Details Displayed");
	}
	else
	{
	test.log(Status.FAIL, "Edit Details Not Displayed");
	Assert.fail("Edit Details Not Displayed");
	}
	registrationPage.titleMiss.click();
	
	if(registrationPage.titleMiss.isEnabled())
	{	
		
	test.log(Status.PASS, "The Title selected is: " +registrationPage.titleMiss.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
	}
	else {	
	test.log(Status.FAIL, "The Title Selected wrong ").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
	}
	Thread.sleep(1000);
	
	registrationPage.titleMs.click();
	if(registrationPage.titleMs.isEnabled()){
	test.log(Status.PASS, "The Title selected is: "+registrationPage.titleMs.getText());
	}else {
	test.log(Status.FAIL, "The title selected Wrong");
	}
	}catch (Exception e) {
	e.printStackTrace();
	test.log(Status.FAIL, e.getCause());
	test.log(Status.FAIL, e.getMessage());
	}
	}

	//TC:Firstname validation using Special characters,null,numerical

	@Test(priority = 7, dataProvider = "registrationdata")//iteration
	public void TC_Profile_4_3(Method method,String FName,String LName,String emailID, String MbNum,String first,String last,String password,String cCode ) throws Exception
	{
		try
		{
			String TC_method = method.getName();
			test = extent.createTest(TC_method).assignCategory("Profile");
			test.log(Status.INFO, "Module:Profile");
			test.log(Status.INFO, "TC:Firstname validation using Special characters,null,numericals");
			Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
			System.out.println(TC_method);
			//Pattern charac = Pattern.compile("[a-zA-z]");
			//Pattern numerical = Pattern.compile("[0-9]");
			//Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

			boolean name;
			Matcher match;
			String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}~0123456789";

			//String specialCharacters = "((\\d+)\\.\\s+(\\w+)\\s+(\\d+)\\s+)";

			//String specialCharacters = "~`!@#$%^&*()-=+[{]}\\|;:\'\",<.>/?@[//[//]^_`{|}~0123456789".replaceAll("[\\[\\]]", "");
			RegistrationPage registrationPage = new RegistrationPage(driver);
			ProfilePage profilePage = new ProfilePage(driver);
			GeneralFunctions generalFunctions = new GeneralFunctions();
		
			generalFunctions.isElementPresent(profilePage.avatar, 20);
			profilePage.avatar.click();
			try
			{if(profilePage.personalDetails.isDisplayed()==true)
				{test.log(Status.PASS, "Personal Details Displayed");
				}
			}
			catch(Exception x)
			{	test.log(Status.FAIL, "Personal Details Not Displayed");
				Assert.fail("Personal Details Not Displayed");
			}
			//click on Personal Details 
			profilePage.personalDetails.click();
			Thread.sleep(1000);
			//Edit Details

		if(generalFunctions.isElementPresent(profilePage.editDetails,60))
		{
		test.log(Status.PASS, "Edit Details Displayed");
		}
		else
		{
		test.log(Status.FAIL, "Edit Details Not Displayed");
		Assert.fail("Edit Details Not Displayed");
		}
	
		profilePage.editFName.clear();
		profilePage.editFName.sendKeys(first);
		profilePage.editLName.click();
		driver.hideKeyboard();
		test.log(Status.INFO, "First Name: "+first);
		String firstName = profilePage.editFName.getText();
		System.out.println("FIRST"+firstName);
		match = pattern.matcher(firstName);
		name = match.find();
	
		//String firstName=driver.findElement(By.xpath("//android.view.ViewGroup[@index='3']/android.widget.LinearLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.EditText[@index='0']")).getText().toString();
	
		System.out.println(first.contains(firstName));
	
		if(first.isEmpty())
		{
			if(generalFunctions.isElementPresent(registrationPage.errorMessage, 10)) {
				test.log(Status.PASS, "Error message Displayed: "+registrationPage.errorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}else {
				test.log(Status.FAIL, "Error Message not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}
	
		}
			else if(specialCharacters.contains(firstName))
		{
			if(generalFunctions.isElementPresent(registrationPage.errorMessage, 10)){
				test.log(Status.PASS, "Error message Displayed: "+registrationPage.errorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}else {
				test.log(Status.FAIL, "Error Message not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}
		}
			else if(name == true)
			{
				if(generalFunctions.isElementPresent(registrationPage.errorMessage, 10)){
					test.log(Status.PASS, "Error message Displayed: "+registrationPage.errorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
				}else {
					test.log(Status.FAIL, "Error Message not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
				}
			}
		else if(firstName.length()>30)
		{
			if(generalFunctions.isElementPresent(registrationPage.errorMessage, 10)){
				test.log(Status.PASS, "Error message Displayed: "+registrationPage.errorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}else {
				test.log(Status.FAIL, "Error Message not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}
		}else if(firstName.length()<=1)
		{
			if(generalFunctions.isElementPresent(registrationPage.errorMessage, 10)){
				test.log(Status.PASS, "Error message Displayed: "+registrationPage.errorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}else {
				test.log(Status.FAIL, "Error Message not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
			}
		}else
		{
			test.log(Status.INFO, "VALID INPUT");
		}
		
		if(profilePage.upadateButton.isEnabled()) {
		test.log(Status.FAIL, "Update button is Enabled");
		}else {
		test.log(Status.PASS, "Update button is disabled");
		}
		
		profilePage.navigateBack.click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

	}catch(Exception e){
	e.printStackTrace();
	test.log(Status.FAIL, e.getCause());
	test.log(Status.FAIL, e.getMessage());
	}
	}



	//TC:Lastname validation using Special characters,null,numericals

	@Test(priority = 8, dataProvider = "registrationdata")//iteration
	public void TC_Profile_4_4(Method method,String FName,String LName,String emailID, String MbNum,String first,String last,String password,String cCode) throws Exception{
	try{

	String TC_method = method.getName();
	test = extent.createTest(TC_method).assignCategory("Profile");
	test.log(Status.INFO, "Module:Profile");
	test.log(Status.INFO, "TC:Lastname validation using Special characters,null,numericals");
	System.out.println(TC_method);
	//String specialCharacters = "((\\d+)\\.\\s+(\\w+)\\s+(\\d+)\\s+)";

	String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}~0123456789";
	Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
	boolean name;
	Matcher match;

	RegistrationPage registrationPage = new RegistrationPage(driver);
	ProfilePage profilePage = new ProfilePage(driver);
	GeneralFunctions generalFunctions = new GeneralFunctions();

	generalFunctions.isElementPresent(profilePage.avatar, 20);
	profilePage.avatar.click();
	try
	{if(profilePage.personalDetails.isDisplayed()==true)
		{test.log(Status.PASS, "Personal Details Displayed");
		}
	}
	catch(Exception x)
	{	test.log(Status.FAIL, "Personal Details Not Displayed");
		Assert.fail("Personal Details Not Displayed");
	}
	//click on Personal Details 
	profilePage.personalDetails.click();
	Thread.sleep(1000);
	//Edit Details
	if(generalFunctions.isElementPresent(profilePage.editDetails,60))
	{
	test.log(Status.PASS, "Edit Details Displayed");
	}
	else
	{
	test.log(Status.FAIL, "Edit Details Not Displayed");
	Assert.fail("Edit Details Not Displayed");
	}
	profilePage.editLName.clear();
	profilePage.editLName.sendKeys(last);
	profilePage.editFName.click();
	driver.hideKeyboard();
	test.log(Status.INFO, "Last Name: "+last);
	String lastName = profilePage.editLName.getText();
	System.out.println("LAST"+lastName);
	match = pattern.matcher(lastName);
	name = match.find();
	//String firstName=driver.findElement(By.xpath("//android.view.ViewGroup[@index='3']/android.widget.LinearLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.EditText[@index='0']")).getText().toString();
	System.out.println(lastName);
	if(last.isEmpty())
	{
		if(generalFunctions.isElementPresent(registrationPage.errorMessage, 10)) {
			test.log(Status.PASS, "Error message Displayed: "+registrationPage.errorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
		}else {
			test.log(Status.FAIL, "Error Message not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
		}

	}	else if(specialCharacters.contains(lastName))
	{
		if(generalFunctions.isElementPresent(registrationPage.errorMessage, 10)){
			test.log(Status.PASS, "Error message Displayed: "+registrationPage.errorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
		}else {
			test.log(Status.FAIL, "Error Message not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
		}
	}
	else if(name == true)
	{
		if(generalFunctions.isElementPresent(registrationPage.errorMessage, 10)) {
			test.log(Status.PASS, "Error message Displayed: "+registrationPage.errorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
		}else {
			test.log(Status.FAIL, "Error Message not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
		}
	}
	else if(lastName.length()>30)
	{
		if(generalFunctions.isElementPresent(registrationPage.errorMessage, 10)) {
			test.log(Status.PASS, "Error message Displayed: "+registrationPage.errorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
		}else {
			test.log(Status.FAIL, "Error Message not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
		}
	}else if(lastName.length()<=1)
	{
		if(generalFunctions.isElementPresent(registrationPage.errorMessage, 10)){
			test.log(Status.PASS, "Error message Displayed: "+registrationPage.errorMessage.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
		}else {
			test.log(Status.FAIL, "Error Message not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_method));
		}
	}else
	{
		test.log(Status.INFO, "VALID INPUT");
	}
	if(profilePage.upadateButton.isEnabled()) {

	test.log(Status.FAIL, "Update button is Enabled");

	}else {

	test.log(Status.PASS, "Update button is disabled");

	}
	profilePage.navigateBack.click();
	driver.pressKey(new KeyEvent(AndroidKey.BACK));

	}catch(Exception e){
	e.printStackTrace();
	test.log(Status.FAIL, e.getCause());
	test.log(Status.FAIL, e.getMessage());
	}
	}

	//TC: Validate Mobile number with invalid combinations
	@Test(priority = 9, dataProvider = "registrationdata")
	public void TC_Profile_4_5(Method method, String FName,String LName,String emailID, String MbNum, String first,String last,String password,String cCode)throws Exception {
	try {
	String TC_method = method.getName();
	test = extent.createTest(TC_method).assignCategory("Profile");
	test.log(Status.INFO, "Module:Profile");
	test.log(Status.INFO, "TC: Validate Mobile number with invalid combinations");
	System.out.println("Running Test"+" "+ TC_method);
	RegistrationPage registrationPage = new RegistrationPage(driver);
	ProfilePage profilePage = new ProfilePage(driver);
	RegistrationFunctions registrationFunctions = new RegistrationFunctions();
	GeneralFunctions generalFunctions = new GeneralFunctions();
	//Click on Avatar icon
	generalFunctions.isElementPresent(profilePage.avatar, 20);
	profilePage.avatar.click();
	try
	{if(profilePage.personalDetails.isDisplayed()==true)
		{test.log(Status.PASS, "Personal Details Displayed");
		}
	}
	catch(Exception x)
	{	test.log(Status.FAIL, "Personal Details Not Displayed");
		Assert.fail("Personal Details Not Displayed");
	}
	//click on Personal Details 
	profilePage.personalDetails.click();
	Thread.sleep(1000);
	//Edit Details
	if(generalFunctions.isElementPresent(profilePage.editDetails,60))
	{
	test.log(Status.PASS, "Edit Details Displayed");
	}
	else
	{
	test.log(Status.FAIL, "Edit Details Not Displayed");
	Assert.fail("Edit Details Not Displayed");
	}
	generalFunctions.SimplyScrollDown();
	registrationPage.mobileNumElement.sendKeys(MbNum);
	driver.hideKeyboard();
	registrationFunctions.countryCodeData(cCode);
	
	test.log(Status.INFO, "Mobile Number: "+MbNum);
	test.log(Status.INFO, "Mobile Number: "+cCode);
	
	if(generalFunctions.isElementPresent(registrationPage.mobileNumberError, 30)) {
	test.log(Status.PASS, "Displayed the Mobile Number field error message:: "+cCode+MbNum+":"+registrationPage.mobileNumberError.getText());
	}else {
	test.log(Status.FAIL, "Mobile number field error message is NOT displayed");
	}
	if(profilePage.upadateButton.isEnabled()) {
	test.log(Status.FAIL, "Update button is Enabled");
	}else {
	test.log(Status.PASS, "Update button is disabled");
	}
	Thread.sleep(500);
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}catch(Exception e) {
	e.printStackTrace();
	test.log(Status.FAIL, e.getCause());
	test.log(Status.FAIL, e.getMessage());
	}
	}

    //Profile - Personal Details
	@Test(priority=4)
	public void TC_Profile_004(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Profile - Personal Details");
		test.assignCategory("Profile");
		System.out.println(TC_Method);
		
		ProfilePage profilePage = new ProfilePage(driver);
		String FirstName=map.get("FirstName").toString();
		String Surname=map.get("Surname").toString();

		try
		{
			//Click on Avatar icon
			generalFunctions.isElementPresent(profilePage.avatar, 20);
			profilePage.avatar.click();
			Thread.sleep(2000);

			//Personal Details
			try
			{
				if(profilePage.personalDetails.isDisplayed()==true)
				{
					test.log(Status.PASS, "Personal Details Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Personal Details Not Displayed");
				Assert.fail("Personal Details Not Displayed");
			}

			//click on Personal Details 
			profilePage.personalDetails.click();
			Thread.sleep(4000);

			//Edit Details
			try
			{
				if(profilePage.editDetails.isDisplayed()==true)
				{
					test.log(Status.PASS, "Edit Details Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Edit Details Not Displayed");
				Assert.fail("Edit Details Not Displayed");
			}	

			//Enter First name
			profilePage.editFName.sendKeys(FirstName);

			//Enter Last name
			profilePage.editLName.sendKeys(Surname);

			//Click Update
			profilePage.upadateButton.click();
			Thread.sleep(15000);

			//click on Personal Details 
			profilePage.personalDetails.click();
			Thread.sleep(4000);

			//Verify First Name updated
			String FName = generalFunctions.getText(profilePage.editFName);
			System.out.println("First Name "+ FName);
			if(FName.contains(FirstName))
			{
				test.log(Status.PASS, "First Name updated").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "First Name Not updated").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("First Name Not updated");
			}

			//Verify Last Name updated
			String LName = generalFunctions.getText(profilePage.editLName);
			System.out.println("Last Name "+ LName);
			if(LName.contains(Surname))
			{
				test.log(Status.PASS, "Last Name updated");
			}
			else
			{
				test.log(Status.FAIL, "Last Name Not updated");
				Assert.fail("Last Name Not updated");
			}

			profilePage.navigateBack.click();
			Thread.sleep(4000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
		
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}			
	}


    //Verify user able to see  notifications and Biometric icons from Profile- Settings. 
	@Test(priority=10)
	public void TC_Profile_005(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Profile-Settings");
		test.assignCategory("Profile");
		System.out.println(TC_Method);
		ProfilePage profilePage = new ProfilePage(driver);
		try
		{
			//Click on Avatar icon
			generalFunctions.isElementPresent(profilePage.avatar, 20);
			profilePage.avatar.click();
			Thread.sleep(2000);

			//Notifications
			try
			{
				if(profilePage.notifications.isDisplayed()==true)
				{
					test.log(Status.PASS, "Notifications Icon Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Notifications Icon Not Displayed");
				Assert.fail("Notifications Icon Not Displayed");
			}	

			//Fingerprint
			try
			{
				if(profilePage.notifications.isDisplayed()==true)
				{
					test.log(Status.PASS, "Fingerprint Icon Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Fingerprint Icon Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Fingerprint Icon Not Displayed");
			}
			driver.pressKey(new KeyEvent(AndroidKey.BACK));

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}

	}

             
    //Notification Setting
	@Test(priority=11)
	public void TC_Profile_006(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Profile-Settings");
		test.assignCategory("Profile");
		System.out.println(TC_Method);
		ProfilePage profilePage = new ProfilePage(driver);
		try
		{
			//Click on Avatar icon
			generalFunctions.isElementPresent(profilePage.avatar, 20);
			profilePage.avatar.click();
			Thread.sleep(1000);
		
			//Notifications
			try
			{
				if(profilePage.notifications.isDisplayed()==true)
				{
					test.log(Status.PASS, "Notifications Icon Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Notifications Icon Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Notifications Icon Not Displayed");
			}	

			//Click on Notifications Icon
			profilePage.notificationSwitch.click();
			Thread.sleep(1000);

			try
			{
				if(profilePage.notificationsSettings.isDisplayed()==true)
				{
					test.log(Status.PASS, "Notifications Settings Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Notifications Settings Not Displayed");
				Assert.fail("Notifications Settings Not Displayed");
			}	
		
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}

	}
            
                
    //Biometric Settings
	@Test(priority=12)
	public void TC_Profile_007(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Profile-Settings");
		test.assignCategory("Profile");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ProfilePage profilePage = new ProfilePage(driver);
		ProfileFunctions profileFunctions = new ProfileFunctions();
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{

			driver.resetApp();
			signInFunctions.SignContinue();
			profileFunctions.newUserSign();

			generalFunctions.SimplyScrollDown();
			//Fingerprint
			try
			{
				if(profilePage.fingerprint.isDisplayed()==true)
				{
					test.log(Status.PASS, "Fingerprint Icon Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Fingerprint Icon Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Fingerprint Icon Not Displayed");
			}	

			//Click on Fingerprint Switch
			profilePage.fingerprintSwitch.click();
			Thread.sleep(4000);

			try
			{
				if(signInPage.cancelButton.isDisplayed()==true)
				{
					signInPage.cancelButton.click();
					test.log(Status.PASS, "Fingerprint Promt Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Fingerprint Promt Not Displayed");
				Assert.fail("Fingerprint Promt Not Displayed");
			}	
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}

	}


     //Verify user able to view the Terms and conditions and privacy policy  icons under the General section  in Profile page.
	@Test(priority=13)
	public void TC_Profile_008(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "T&Cs, Privacy Policy");
		test.assignCategory("Profile");
		System.out.println(TC_Method);

		ProfilePage profilePage = new ProfilePage(driver);
		try
		{
			//Click on Avatar icon
			generalFunctions.isElementPresent(profilePage.avatar, 20);
			profilePage.avatar.click();
			Thread.sleep(2000);	

			generalFunctions.SimplyScrollDown();
			//Terms & Conditions
			try
			{
				if(profilePage.termsNconditions.isDisplayed()==true)
				{
					test.log(Status.PASS, "Terms & Conditions Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Terms & Conditions Not Displayed");
				Assert.fail("Terms & Conditions Not Displayed");
			}	

			//Privacy Policy
			try
			{
				if(profilePage.privacyPolicy.isDisplayed()==true)
				{
					test.log(Status.PASS, "Privacy Policy Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Privacy Policy Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Privacy Policy Not Displayed");
			}	
			driver.pressKey(new KeyEvent(AndroidKey.BACK));

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}

	}

              
    //Terms and Conditions
	@Test(priority=14)
	public void TC_Profile_009(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "T&Cs, Privacy Policy");
		test.assignCategory("Profile");
		System.out.println(TC_Method);

		ProfilePage profilePage = new ProfilePage(driver);
		ProfileFunctions profileFunctions = new ProfileFunctions();
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{
			driver.resetApp();
			signInFunctions.SignContinue();
			profileFunctions.newUserSign();

			//Click on Avatar icon
			generalFunctions.isElementPresent(profilePage.avatar, 20);
			profilePage.avatar.click();
			Thread.sleep(2000);	

			generalFunctions.SimplyScrollDown();

			//Terms & Conditions
			try
			{
				if(profilePage.termsNconditions.isDisplayed()==true)
				{
					test.log(Status.PASS, "Terms & Conditions Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Terms & Conditions Not Displayed");
				Assert.fail("Terms & Conditions Not Displayed");
			}	

			//Click on Terms & Conditions
			profilePage.termsNconditions.click();
			Thread.sleep(4000);

			try
			{
				if(profilePage.termsNconditionsPage.isDisplayed()==true)
				{
					test.log(Status.PASS, "Terms & Conditions page Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Terms & Conditions page Not Displayed");
				Assert.fail("Terms & Conditions page Not Displayed");
			}

			profilePage.navigateBack.click();
			driver.pressKey(new KeyEvent(AndroidKey.BACK));

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}

	}

             
               //Privacy Policy
	@Test(priority=15)
	public void TC_Profile_010(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "T&Cs, Privacy Policy");
		test.assignCategory("Profile");
		System.out.println(TC_Method);
		ProfilePage profilePage = new ProfilePage(driver);
		try
		{
			//Click on Avatar icon
			generalFunctions.isElementPresent(profilePage.avatar, 20);
			profilePage.avatar.click();
			Thread.sleep(2000);	

			generalFunctions.SimplyScrollDown();	

			//Privacy Policy
			try
			{
				if(profilePage.privacyPolicy.isDisplayed()==true)
				{
					test.log(Status.PASS, "Privacy Policy Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Privacy Policy Not Displayed");
				Assert.fail("Privacy Policy Not Displayed");
			}

			profilePage.privacyPolicy.click();
			Thread.sleep(4000);

			try
			{
				if(profilePage.privacyPolicyPage.isDisplayed()==true)
				{
					test.log(Status.PASS, "Privacy Policy page Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Privacy Policy page Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Privacy Policy page Not Displayed");
			}		

			profilePage.navigateBack.click();
			driver.pressKey(new KeyEvent(AndroidKey.BACK));

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}				
	}


	@Test(priority=16)
	public void TC_Profile_011_012(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Logout");
		test.assignCategory("Profile");
		System.out.println(TC_Method);
		SignInPage signInPage = new SignInPage(driver);
		ProfilePage profilePage = new ProfilePage(driver);
		try
		{
			//Click on Avatar icon
			generalFunctions.isElementPresent(profilePage.avatar, 20);
			profilePage.avatar.click();
			Thread.sleep(2000);		
			generalFunctions.SimplyScrollDown();

			//Logout
			try
			{
				if(profilePage.Logout.isDisplayed()==true)
				{
					test.log(Status.PASS, "Logout Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Logout Not Displayed");
				Assert.fail("Logout Not Displayed");
			}	

			profilePage.Logout.click();
			Thread.sleep(5000);	

			//Logout Confirmation
			try
			{
				if(generalFunctions.getText(profilePage.logoutConfirmation).contains("Are you sure you want to logout?"))
				{
					test.log(Status.PASS, "Logout Confirmation Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Logout Confirmation Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Logout Confirmation Not Displayed");
			}

			//Click Yes
			profilePage.ConfirmYES.click();

			try
			{
				if(signInPage.signinButton.isDisplayed()==true)
				{
					test.log(Status.PASS, "Logout Successful");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Logout Failed");
				Assert.fail("Logout Failed");
			}

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}				
	}

              //Reset Password
	@Test(priority=17)
	public void TC_Profile_013_014_015(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Reset Password");
		test.assignCategory("Profile");
		System.out.println(TC_Method);
		ProfilePage profilePage = new ProfilePage(driver);
		ProfileFunctions profileFunctions = new ProfileFunctions();
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{
			driver.resetApp();
			signInFunctions.SignContinue();
			profileFunctions.newUserSign();
			Thread.sleep(2000);

			//Reset Password
			try
			{
				if(profilePage.resetPassword.isDisplayed()==true)
				{
					test.log(Status.PASS, "Reset Password Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Reset Password Not Displayed");
				Assert.fail("Reset Password Not Displayed");
			}		

			profilePage.resetPassword.click();
			Thread.sleep(2000);

			try
			{
				if(generalFunctions.getText(profilePage.alertMessage).contains("Are you sure you want to reset your password?"))
				{
					test.log(Status.PASS, "Reset Password Confirmation Alert Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Reset Password Confirmation Alert Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Reset Password Confirmation Alert Not Displayed");
			}	

			profilePage.confirmNO.click();
			Thread.sleep(2000);

			try
			{
				if(profilePage.resetPassword.isDisplayed()==true)
				{
					test.log(Status.PASS, "User retured to Profile page");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "User Not retured to Profile page");
				Assert.fail("User Not retured to Profile page");
			}	
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}

	}


	@Test(priority=18)
	public void TC_Profile_016_017(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Reset Password");
		test.assignCategory("Profile");
		System.out.println(TC_Method);
		ProfilePage profilePage = new ProfilePage(driver);	
		try
		{
			generalFunctions.isElementPresent(profilePage.avatar, 20);
			profilePage.avatar.click();
			Thread.sleep(2000);

			//Reset Password
			try
			{
				if(profilePage.resetPassword.isDisplayed()==true)
				{
					test.log(Status.PASS, "Reset Password Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Reset Password Not Displayed");
				Assert.fail("Reset Password Not Displayed");
			}		

			profilePage.resetPassword.click();
			Thread.sleep(2000);

			try
			{
				if(generalFunctions.getText(profilePage.alertMessage).contains("Are you sure you want to reset your password?"))
				{
					test.log(Status.PASS, "Reset Password Confirmation Alert Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Reset Password Confirmation Alert Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Reset Password Confirmation Alert Not Displayed");
			}	

			profilePage.ConfirmYES.click();
			Thread.sleep(2000);

			try
			{
				if(profilePage.ResetPasswordPage.isDisplayed()==true)
				{
					test.log(Status.PASS, "Reset Password Confirmation page Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Reset Password Confirmation page Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Reset Password Confirmation page Not Displayed");
			}	

			try
			{
				if(profilePage.checkYourEmail.isDisplayed()==true)
				{
					test.log(Status.PASS, "Check Your Email Message Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Check Your Email Message Not Displayed");
				Assert.fail("Check Your Email Message Not Displayed");
			}	

			//Send Again
			profilePage.sendAgain.click();
			Thread.sleep(1000);

			profilePage.navigateBack.click();

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}

	}


	

	////-------------Passcode------////
	//Verify New User is able to set up PIN later by selecting "SET UP PIN CODE LATER"
	//Verify User is not able to Proceed with Profile - Payment Methods without setting up PIN
		
	@Test(priority=19)
	public void TC_Profile_031_032(Method method) throws Exception {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "PaymentMethods;Passcode Setup Later").assignCategory("Profile");
		test.info("Verify New User is able to set up PIN later by selecting SET UP PIN CODE LATER");
		System.out.println(TC_Method);
		driver.resetApp();
		SignInFunctions signInFunctions = new SignInFunctions();
		ProfilePage profilePage = new ProfilePage(driver);
		ProfileFunctions profileFunctions = new ProfileFunctions();
		signInFunctions.SignContinue();//sprint 18 builds
		//SignIn New User and click on Payment Methods
		profileFunctions.newUserPass();

		if(generalFunctions.isElementPresent(profilePage.setupPinCode, 20)) {
			test.log(Status.PASS, "The Passcode Setup Screen displayed when user tap on Payment Methods").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else {
				test.log(Status.FAIL, "The Passcode screen not displayed and user can able to add card").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			generalFunctions.isElementPresent(profilePage.setupPinCodeLater, 30);
			profilePage.setupPinCodeLater.click();

			if(generalFunctions.isElementPresent(profilePage.paymentMethods, 30)) {
				test.log(Status.PASS, "User navigates back to the Profile section");
			}else{
				test.log(Status.FAIL, "Profile Screen NOT displayed");
			}
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			
		}

	//Verify Error message is displayed when PIN on the first set up screen does not match with the PIN on the confirm screen
	@Test(priority=20)
	public void TC_Profile_030(Method method) throws InterruptedException {
		try {
			String TC_Method = method.getName();
			test = extent.createTest(TC_Method);
			test.log(Status.INFO, "Payment Methods: Passcode Mismatch").assignCategory("Profile");
			test.info("Verify Error message is displayed when PIN on the first set up screen does not match with the PIN on the confirm screen");
			System.out.println(TC_Method);
			driver.resetApp();
			SignInFunctions signInFunctions = new SignInFunctions();
			ProfilePage profilePage = new ProfilePage(driver);
			ProfileFunctions profileFunctions = new ProfileFunctions();
			signInFunctions.SignContinue();
			//SignIn New User and click on Payment Methods
			profileFunctions.newUserPass();
			generalFunctions.isElementPresent(profilePage.setupPinCode, 30);
			profilePage.setupPinCode.click();
			generalFunctions.isElementPresent(profilePage.setUpPin, 30);
			profilePage.setUpPin.sendKeys("1234");
			Thread.sleep(500);
			generalFunctions.isElementPresent(profilePage.confirmPassScreen, 30);
			profilePage.setUpPin.sendKeys("1434");
			//String toast = profilePage.pinErrortoast.getText();
			if(generalFunctions.isElementPresence(By.id("snackbar_text"), 30)) {
				test.log(Status.PASS, "Passcode Mismatch Error displayed: "+profileFunctions.toast());
			}else {
				test.log(Status.FAIL, "Passcode Mismatch Error is NOT displayed");
			}
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			Assert.fail(e.getMessage());
		}
	}


	//Verify New User is able to set up PIN on selecting Payment methods
	@Test(priority=21)
	public void TC_Profile_025_to_029(Method method) throws Exception   {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Profile");
		test.log(Status.INFO, "Payment Method:Passcode Set up");
		test.info("Verify New User is able to set up PIN on selecting Payment methods");
		System.out.println(TC_Method);
		driver.resetApp();
		SignInFunctions signInFunctions = new SignInFunctions();
		ProfilePage profilePage = new ProfilePage(driver);
		ProfileFunctions profileFunctions = new ProfileFunctions();
		signInFunctions.SignContinue();
		//SignIn New User and click on Payment Methods
		profileFunctions.newUserPass();
		Thread.sleep(1000);

		//SetPinCode
		if(generalFunctions.isElementPresent(profilePage.setupPinCode, 30)) {
			test.log(Status.PASS, "SET UP PIN CODE Button is Present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}else {
			test.log(Status.FAIL, "SET UP PIN CODE Button is NOT Present").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}
		if(generalFunctions.isElementPresent(profilePage.setupPinCodeLater, 30)) {
			test.log(Status.PASS, "SET UP PIN CODE LATER Button is Present");
		}else {
			test.log(Status.FAIL, "SET UP PIN CODE LATER Button is NOT Present");
		}
		profilePage.setupPinCode.click();
		Thread.sleep(1000);
		//PINCODE SCREEN
		if(generalFunctions.isElementPresent(profilePage.setUpPin, 30)) {
			test.log(Status.PASS, "Setup PINCODE Screen dispalyed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			profilePage.setUpPin.sendKeys("1234");
		}else {
			test.log(Status.FAIL, "Setup PINCODE Screen NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}

		//PINCODE CONFIRM SCREEN
		if(generalFunctions.isElementPresent(profilePage.confirmPassScreen, 30)) {
			test.log(Status.PASS, "Confirm PINCODE Screen displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			profilePage.setUpPin.sendKeys("1234");
		}else {
			test.log(Status.FAIL, "Confirm PINCODE Screen NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}
		Thread.sleep(500);
		//PINCODE SUCCESS
		if(generalFunctions.isElementPresent(profilePage.pinSuccess, 30)) {
			test.log(Status.PASS, "SUCCESS:"+profilePage.pinSuccess.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			profilePage.pinDone.click();
		}else {
			test.log(Status.FAIL, "SUCCESS Screen NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}
		Thread.sleep(1000);

		if(generalFunctions.isElementPresent(profilePage.addNewPaymentMethod, 30)) {
			test.log(Status.PASS, "Payment Methods Screen displayed");
		}else {
			test.log(Status.FAIL, "Payment Methods Screen NOT displayed");
		}
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
	}

	
	//*************************************************Passcode for Existing Users**************************************//

	//Verify Enter PIN code screen is displayed if an existing user trying to add new card
	@Test(priority=22)
	public void TC_Profile_033_to_035(Method method) throws Exception   {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Profile");
		test.log(Status.INFO, "Payment Method:Passcode Set up");
		test.info("Verify Enter PIN code screen is displayed if an existing user trying to add new card");
		test.info("Verify the Add New card details screen is displayed");
		System.out.println(TC_Method);
		ProfilePage profilePage = new ProfilePage(driver);
		HomePage homePage = new HomePage(driver);
		
		//SignIn New User and click on Payment Methods
		generalFunctions.isElementPresent(homePage.homeElement, 20);
		homePage.avatarHome.click();
		generalFunctions.isElementPresent(profilePage.paymentMethods, 20);
		profilePage.paymentMethods.click();

		//PINCODE SCREEN
		if(generalFunctions.isElementPresent(profilePage.setUpPin, 30)) {
			test.log(Status.PASS, "Setup PINCODE Screen dispalyed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			profilePage.setUpPin.sendKeys("1234");
		}else {
			test.log(Status.FAIL, "Setup PINCODE Screen NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}
		Thread.sleep(500);
		if(generalFunctions.isElementPresent(profilePage.addNewPaymentMethod, 30)) {
			test.log(Status.PASS, "Payment Methods Screen displayed");
		}else {
			test.log(Status.FAIL, "Payment Methods Screen NOT displayed");
		}
		Thread.sleep(500);
		profilePage.addNewPaymentMethod.click();
		Thread.sleep(1000);
		if(generalFunctions.isElementPresent(profilePage.CardNumber, 30)) {
			test.log(Status.PASS, "Add card details Screen displayed");
		}else {
			test.log(Status.FAIL, "Add card details Screen NOT displayed");
		}
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	//Add card from profile section
	@Test(priority=23)
	public void TC_Profile_018_To_024(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Profile - Payment methods");
		test.assignCategory("Profile");
		System.out.println(TC_Method);

		ProfilePage profilePage = new ProfilePage(driver);
		HomePage homePage = new HomePage(driver);
		String CardNumber=map.get("CardNumber").toString();
		String NameOnCard =map.get("NameOnCard").toString();
		String ExpiryDate=map.get("ExpiryDate").toString();
		String Cvv =map.get("Cvv").toString();
		String TransactionAmount=map.get("TransactionAmount").toString();

		try
		{
			generalFunctions.isElementPresent(homePage.homeElement, 20);
			homePage.avatarHome.click();
			generalFunctions.isElementPresent(profilePage.paymentMethods, 20);
			profilePage.paymentMethods.click();
			
			//PINCODE SCREEN
			if(generalFunctions.isElementPresent(profilePage.setUpPin, 30)) {
				test.log(Status.PASS, "Setup PINCODE Screen dispalyed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				profilePage.setUpPin.sendKeys("1234");
			}else {
				test.log(Status.FAIL, "Setup PINCODE Screen NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			if(generalFunctions.isElementPresent(profilePage.addNewPaymentMethod, 30)) {
				test.log(Status.PASS, "Payment Methods Screen displayed");
			}else {
				test.log(Status.FAIL, "Payment Methods Screen NOT displayed");
			}
			profilePage.addNewPaymentMethod.click();
			if(generalFunctions.isElementPresent(profilePage.CardNumber, 30)) {
				test.log(Status.PASS, "Add card details Screen displayed");
			}else {
				test.log(Status.FAIL, "Add card details Screen NOT displayed");
			}
			
			//Enter Card Number
			profilePage.CardNumber.click();
			Actions action = new Actions(driver);
			action.sendKeys(CardNumber).perform();
			Thread.sleep(5000);

			//Enter Expiry
			profilePage.Expiry.click();
			action.sendKeys(ExpiryDate).perform();
			Thread.sleep(5000);

			//Enter CVC
			profilePage.CVC.sendKeys(Cvv);

			//Enter Name On Card
			profilePage.NameOnCard.sendKeys(NameOnCard);

			String GetCardNumber=profilePage.CardNumber.getText();
			System.out.println(GetCardNumber);
			//String lastDigits = GetCardNumber.split(" ")[(CardNumber.split(" ")).length -1];
			String lastDigits = GetCardNumber.substring(GetCardNumber.lastIndexOf(' ') + 1);
			System.out.println(lastDigits);

			//Click Done
			profilePage.doneButton.click();
			driver.hideKeyboard();
			Thread.sleep(4000);
		

			//Verify Verify Card Page page displayed
			try
			{
				if(profilePage.verifyPage.isDisplayed()==true)
				{
					test.log(Status.PASS, "Verify Card page Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Verify Card page Not Displayed");
				Assert.fail("Verify Card page Not Displayed");
			}	
		

			//Verify the Transaction Amount Field displayed
			if(profilePage.TransactionAmount.isDisplayed()==true)
			{
				test.log(Status.PASS, "Transaction Amount Field Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Transaction Amount Field Not Displayed");
				Assert.fail("Transaction Amount Field Not Displayed");
			}
			Thread.sleep(1200);

			//Verify the submit button
			//if(profilePage.SubmitTransactionAmount.isEnabled()==false)
			//{
				//test.log(Status.PASS, "Submit Button is Disabled");
			//}
			//else
			//{
				//test.log(Status.FAIL, "Submit Button is Enabled");
				//Assert.fail("Submit Button is Enabled");
			//}

			//driver.pressKey(new KeyEvent(AndroidKey.BACK));
	
			//try
			//{
				//if(profilePage.paymentMethodsPage.isDisplayed()==true)
				//{
					//test.log(Status.PASS, "Payment Methods page Displayed");
				//}
		//	}
			//catch(Exception x)
		//	{
				//test.log(Status.FAIL, "Payment Methods page Not Displayed");
				//Assert.fail("Payment Methods page Not Displayed");
			//}		

			//Verify the Card Details Tag
			//String CardTag= profilePage.GetCardStatus(lastDigits).getText();
			//System.out.println("Card Status : "+CardTag);
			//if(CardTag.contains("Not Verified"))
			//{
				//test.log(Status.PASS, "Card Status Displayed and verified");
			//}
		//	else
			//{
				//test.log(Status.FAIL, "Card Status Not Displayed OR Wrong Status displayed");
				//Assert.fail("Card Status Not Displayed OR Wrong Status displayed");
			//}

			//Select Card
			//profilePage.SelectCards(lastDigits).click();
			//Thread.sleep(4000);

			//Verify Verify Card Page page displayed
			//try
			//{
				//if(profilePage.verifyPage.isDisplayed()==true)
				//{
					//test.log(Status.PASS, "Verify Card page Displayed");
				//}
			//}
			//catch(Exception x)
			//{
				//test.log(Status.FAIL, "Verify Card page Not Displayed");
				//Assert.fail("Verify Card page Not Displayed");
			//}	

			profilePage.TransactionAmount.sendKeys(TransactionAmount);
			driver.hideKeyboard();

			profilePage.SubmitTransactionAmount.click();
			Thread.sleep(3000);

		//	try
			//{
			///	if(profilePage.paymentMethodsPage.isDisplayed()==true)
				//{
					//test.log(Status.PASS, "Payment Methods page Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
					//test.log(Status.INFO, "Added Card Present in Payment Methods");
					
				//}
			//}
			//catch(Exception x)
			//{
			//	test.log(Status.FAIL, "Payment Methods page Not Displayed");
			//	Assert.fail("Payment Methods page Not Displayed");
			//}	
			

			profilePage.backButton.click();
			driver.navigate().back();
			Thread.sleep(3000);

			try
			{
				if(profilePage.paymentMethods.isDisplayed()==true)
				{
					test.log(Status.PASS, "Payment Methods Displayed");
					test.log(Status.INFO, "Added Card Present in Payment Methods");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Payment Methods Not Displayed");
				Assert.fail("Payment Methods Not Displayed");
			}	

			profilePage.backFromProfile.click();
			Thread.sleep(1000);
/*
			try
			{
				if(profilePage.sharePay.isDisplayed()==true)
				{
					test.log(Status.PASS, "Share Pay Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Share Pay Not Displayed");
				Assert.fail("Share Pay Not Displayed");
			}	

			profilePage.sharePay.click();
			Thread.sleep(1000);

			try
			{
				if(profilePage.sharePayPage.isDisplayed()==true)
				{
					test.log(Status.PASS, "Share Pay page Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.PASS, "Share Pay page Not Displayed");
			}	

			try
			{
				if(profilePage.continueButton.isDisplayed()==true)
				{
					test.log(Status.PASS, "Continue Button Displayed");
					profilePage.continueButton.click();
				}
			}
			catch(Exception x)
			{
				test.log(Status.PASS, "Continue Button  Not Displayed");			
			}

			try
			{
				if(profilePage.shareWalletPage.isDisplayed()==true)
				{
					test.log(Status.PASS, "Share Wallet Page Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.PASS, "Share Wallet Page Not Displayed");
				Assert.fail("Share Wallet Page Not Displayed");

			}

			try
			{
				if(profilePage.CardInWallet(lastDigits).isDisplayed()==true)
				{
					test.log(Status.PASS, "Added Card Displayed in Share Wallet");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Added Card Not Displayed in Share Wallet");
				Assert.fail("Added Card Not Displayed in Share Wallet");
			}	

			profilePage.backFromShareWallet.click();
			Thread.sleep(4000);

			//Click on Avatar icon
			profilePage.avatar.click();
			Thread.sleep(4000);

			//Payment Methods
			try
			{
				if(profilePage.paymentMethods.isDisplayed()==true)
				{
					test.log(Status.PASS, "Payment Methods Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Payment Methods Not Displayed");
				Assert.fail("Payment Methods Not Displayed");
			}		

			profilePage.paymentMethods.click();		
			Thread.sleep(5000);	

			try
			{
				if(profilePage.paymentMethodsPage.isDisplayed()==true)
				{
					test.log(Status.PASS, "Payment Methods page Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Payment Methods page Not Displayed");
				Assert.fail("Payment Methods page Not Displayed");
			}		

			try
			{
				if(profilePage.SelectCards(lastDigits).isDisplayed()==true)
				{
					test.log(Status.PASS, "Card Displayed in Payment Methods");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Card Not Displayed in Payment Methods");
				Assert.fail("Card Not Displayed in Payment Methods");
			}	

			profilePage.editButton.click();
			Thread.sleep(2000);	

			profilePage.deleteCard(lastDigits).click();
			Thread.sleep(2000);	

			try
			{
				if(generalFunctions.getText(profilePage.alertMessage).contains("Are you sure you want to remove this card?"))
				{
					test.log(Status.PASS, "Delete Card Confirmation Message Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Delete Card Confirmation Message Not Displayed");
				Assert.fail("Delete Card Confirmation Message Not Displayed");
			}

			profilePage.ConfirmYES.click();
			Thread.sleep(6000);	

			try
			{
				if(profilePage.SelectCards(lastDigits).isDisplayed()==true)
				{						
					test.log(Status.FAIL, "Card Not Deleted");
					Assert.fail("Card Not Deleted");
				}
			}
			catch(Exception x)
			{
				test.log(Status.PASS, "Card Deleted Successfully");
			}	

			profilePage.navigateBack.click();
			Thread.sleep(4000);

			try
			{
				if(profilePage.paymentMethods.isDisplayed()==true)
				{
					test.log(Status.PASS, "Payment Methods Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Payment Methods Not Displayed");
				Assert.fail("Payment Methods Not Displayed");
			}	

			profilePage.backFromProfile.click();
			Thread.sleep(4000);

			try
			{
				if(profilePage.sharePay.isDisplayed()==true)
				{
					test.log(Status.PASS, "Share Pay Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Share Pay Not Displayed");
				Assert.fail("Share Pay Not Displayed");
			}	

			profilePage.sharePay.click();
			Thread.sleep(10000);

			try
			{
				if(profilePage.sharePayPage.isDisplayed()==true)
				{
					test.log(Status.PASS, "Share Pay page Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.PASS, "Share Pay page Not Displayed");
			}	

			try
			{
				if(profilePage.continueButton.isDisplayed()==true)
				{
					test.log(Status.PASS, "Continue Button Displayed");
					profilePage.continueButton.click();
				}
			}
			catch(Exception x)
			{
				test.log(Status.PASS, "Continue Button  Not Displayed");			
			}

			try
			{
				if(profilePage.shareWalletPage.isDisplayed()==true)
				{
					test.log(Status.PASS, "Share Wallet Page Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.PASS, "Share Wallet Page Not Displayed");
				Assert.fail("Share Wallet Page Not Displayed");

			}

			try
			{
				if(profilePage.SelectCards(lastDigits).isDisplayed()==true)
				{						
					test.log(Status.FAIL, "Card Not Removed from Share Wallet");
					Assert.fail("Card Not Removed from Share Wallet");
				}
			}
			catch(Exception x)
			{
				test.log(Status.PASS, "Card Removed from Share Wallet");
			}	

			profilePage.backFromShareWallet.click();
			Thread.sleep(4000);			
*/
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}

	}
	
	//Verify New User is navigating to the previous screen when he clicks back arrow on the PIN code screens
	@Test(priority=24)
	public void TC_Profile_036(Method method) throws Exception   {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Profile");
		test.log(Status.INFO, "Payment Method:Passcode Set up");
		test.info("Verify New User is navigating to the previous screen when he clicks back arrow on the PIN code screens");
		System.out.println(TC_Method);
		ProfilePage profilePage = new ProfilePage(driver);
		HomePage homePage = new HomePage(driver);
		//SignIn New User and click on Payment Methods
		generalFunctions.isElementPresent(homePage.homeElement, 20);
		homePage.avatarHome.click();
		generalFunctions.isElementPresent(profilePage.paymentMethods, 20);
		profilePage.paymentMethods.click();

		//PINCODE SCREEN
		if(generalFunctions.isElementPresent(profilePage.setUpPin, 30)) {
			test.log(Status.PASS, "Setup PINCODE Screen dispalyed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}else {
			test.log(Status.FAIL, "Setup PINCODE Screen NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}
		profilePage.backButton.click();
		Thread.sleep(1000);
		if(generalFunctions.isElementPresent(profilePage.paymentMethods, 30)) {
			test.log(Status.PASS, "Payment Methods Screen displayed");
		}else {
			test.log(Status.FAIL, "Payment Methods Screen NOT displayed");
		}
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

	//Verify the error message is showing for incorrect pin
	@Test(priority=25)
	public void TC_Profile_037(Method method) throws Exception {
		try {
			String TC_Method = method.getName();
			test = extent.createTest(TC_Method);
			test.log(Status.INFO, "SharePay:Passcode Error").assignCategory("Profile");
			test.info("Verify the error message is showing for incorrect pin");
			System.out.println(TC_Method);
			ProfilePage profilePage = new ProfilePage(driver);
			ProfileFunctions profileFunctions = new ProfileFunctions();
			HomePage homePage = new HomePage(driver);
			//SignIn New User and click on Payment Methods
			generalFunctions.isElementPresent(homePage.homeElement, 20);
			homePage.avatarHome.click();
			generalFunctions.isElementPresent(profilePage.paymentMethods, 20);
			profilePage.paymentMethods.click();
			generalFunctions.isElementPresent(profilePage.setUpPin, 30);
			profilePage.setUpPin.sendKeys("1243");
			Thread.sleep(500);
			//String toast = profilePage.pinErrortoast.getText();
			if(generalFunctions.isElementPresence(By.id("snackbar_text"), 30)) {
				test.log(Status.PASS, "Passcode Mismatch Error displayed: "+profileFunctions.toast());
			}else {
				test.log(Status.FAIL, "Passcode Mismatch Error is NOT displayed");
			}
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			Assert.fail(e.getMessage());
		}
	}
	//Verify the user can reset Pin using forgot Pin
	@Test(priority=30)
	public void TC_Profile_038_to_041(Method method) throws IOException, Exception {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "PaymentMethods:Forgot Passcode").assignCategory("Profile");
		test.info("Verify the user can reset Pin using forgot Pin");
		System.out.println(TC_Method);
		ProfilePage profilePage = new ProfilePage(driver);
		HomePage homePage = new HomePage(driver);
		generalFunctions.isElementPresent(homePage.homeElement, 20);
		homePage.avatarHome.click();
		generalFunctions.isElementPresent(profilePage.paymentMethods, 20);
		profilePage.paymentMethods.click();
		generalFunctions.isElementPresent(profilePage.setUpPin, 30);

		if(generalFunctions.isElementPresent(profilePage.forgotPin, 30)) {
			test.log(Status.PASS, "The Forgot Pin button is visible");
			profilePage.forgotPin.click();
		}else {
			test.log(Status.FAIL, "The Forgot Pin button is not visible");
		}
		if(generalFunctions.isElementPresent(profilePage.resetAlert, 30)) {
			test.log(Status.PASS, "The reset Alert displayed");
		}else {
			test.log(Status.FAIL, "The reset Alert is NOT displayed");
		}
		generalFunctions.isElementPresent(profilePage.resetCancel, 30);
		profilePage.resetCancel.click();
		if(generalFunctions.isElementPresent(profilePage.forgotPin, 30)) {
			test.log(Status.PASS, "User tap on Cancel button and dismissed the alert");
		}else {
			test.log(Status.FAIL, "User tap on Cancel button and alert is NOT dismissed");
		}
		generalFunctions.isElementPresent(profilePage.forgotPin, 30);
		profilePage.forgotPin.click();
		
		if(generalFunctions.isElementPresent(profilePage.resetAlert, 30)) {
			test.log(Status.PASS, "The reset Alert displayed");
			generalFunctions.isElementPresent(profilePage.resetResetPin, 30);
			profilePage.resetResetPin.click();
		}else {
			test.log(Status.FAIL, "The reset Alert is NOT displayed");
		}
		if(generalFunctions.isElementPresent(profilePage.pincodeSetupscreens, 30)) {
			test.log(Status.PASS, "New pin setup Screen displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			profilePage.setUpPin.sendKeys("1234");

		}else {
			test.log(Status.FAIL, "New pin setup Screen NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}

		if(generalFunctions.isElementPresent(profilePage.setUpPin, 30)) {
			test.log(Status.PASS, "Confirm pin setup Screen displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			profilePage.setUpPin.sendKeys("1234");
		}else {
			test.log(Status.FAIL, "Confirm Pin set up screen not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}
		if(generalFunctions.isElementPresent(profilePage.pinChangeSuccess, 30)) {
			test.log(Status.PASS, "Displayed Reset Pin Success"+profilePage.resetSuccessAlert).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			profilePage.pinChangeSuccess.click();
		}else {
			test.log(Status.FAIL, "Reset Pin Success screen NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}
		if(generalFunctions.isElementPresent(profilePage.paymentMethods, 30)) {

			test.log(Status.PASS, "Completed the Reset Pin journey Successfully");

		}else {
			test.log(Status.FAIL, "Reset Pin journey is NOT Successfull");
		
		}	
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}


	////*********************************CHANGE PIN CODE**************************/////////


	//Verify "Change PIN code for Share Pay " button is  NOT visible if the user is not Set the PIN code"
	@Test(priority=26)
	public void TC_Profile_042(Method method) throws Exception {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Profile:Change PIN Code").assignCategory("Profile");
		test.info("Verify Change PIN code for Share Pay  button is  NOT visible if the user is not Set the PIN code");
		System.out.println(TC_Method);
	
		ProfilePage profilePage = new ProfilePage(driver);
		HomePage homePage = new HomePage(driver);
		//SignIn New User and click on Payment Methods
		generalFunctions.isElementPresent(homePage.homeElement, 20);
		homePage.avatarHome.click();
		Thread.sleep(2000);

		if(generalFunctions.isElementPresent(profilePage.changePin, 30)) {
			test.log(Status.PASS, "The Change PIN code for Share Pay button is displayed");
		}else {
			test.log(Status.FAIL, "The Change PIN code for Share Pay button is NOT displayed");
		}
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	//Verify "Change PIN code for Share Pay " Journey" for remove card option selected as NO
	//user with card needed to check this
	@Test(priority=27)
	public void TC_Profile_036_to_048(Method method) throws IOException, Exception {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Profile:Change PIN Code").assignCategory("Profile");
		test.info("Verify Change PIN code for Share Pay button is visible if the user already set PIN code");
		System.out.println(TC_Method);
	
		ProfilePage profilePage = new ProfilePage(driver);
		ProfileFunctions profileFunctions = new ProfileFunctions();
		HomePage homePage = new HomePage(driver);

		//SignIn and click on Payment Methods
		generalFunctions.isElementPresent(homePage.homeElement, 20);
		homePage.avatarHome.click();

		if(generalFunctions.isElementPresent(profilePage.changePin, 30)) {
			test.log(Status.PASS, "The Change PIN code for Share Pay button is displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			profilePage.changePin.click();
		}else {
			test.log(Status.FAIL, "The Change PIN code for Share Pay button is NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));

		}
		if(generalFunctions.isElementPresent(profilePage.existingPinScreen, 30)) {
			test.log(Status.PASS, "The Enter PIN code screen displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));

		}else {
			test.log(Status.FAIL, "The Enter PIN code screen is not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}
		profilePage.setUpPin.sendKeys("0005");
		if(generalFunctions.isElementPresence(By.id("snackbar_text"), 90)) {
			test.log(Status.PASS, "Passcode Mismatch Error displayed: "+profileFunctions.toast()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}else {
			test.log(Status.FAIL, "Passcode Mismatch Error is NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}
		Thread.sleep(5000);
		profileFunctions.existPin(profilePage);
		if(generalFunctions.isElementPresent(profilePage.setUpPin, 30)) {
			test.log(Status.PASS, "New pin setup Screen displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			profileFunctions.newPin(profilePage);
			test.log(Status.PASS, "New Pin code screen accepts numericals");
		}else {
			test.log(Status.FAIL, "New Pin set up screen not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}
		if(generalFunctions.isElementPresent(profilePage.setUpPin, 30)) {
			test.log(Status.PASS, "Confirm pin setup Screen displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));

		}else {
			test.log(Status.FAIL, "Confirm Pin set up screen not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}
		profilePage.setUpPin.sendKeys("0005");
		if(generalFunctions.isElementPresence(By.id("snackbar_text"), 90)) {
			test.log(Status.PASS, "Passcode Mismatch Error displayed: "+profileFunctions.toast()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}else {
			test.log(Status.FAIL, "Passcode Mismatch Error is NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}
		Thread.sleep(5000);

		if(generalFunctions.isElementPresent(profilePage.setUpPin, 30)) {
			profileFunctions.newPin(profilePage);
			test.log(Status.PASS, "Confirm Pin code screen accepts numericals");
		}else {
			test.log(Status.FAIL, "New Pin set up screen not displayed");
		}
		if(generalFunctions.isElementPresent(profilePage.removeCardAlert, 30)) {
			test.log(Status.PASS, "The Remove card alert displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			profilePage.noOption.click();
		}else {
			test.log(Status.FAIL, "The Remove Card alert not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}
		if(generalFunctions.isElementPresent(profilePage.pinChangeSuccess, 30)) {
			test.log(Status.PASS, "The New Pin has been set successfully").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			profilePage.pinChangeSuccess.click();
		}else {
			test.log(Status.FAIL, "The New Pin not set Successfully").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}
		if(generalFunctions.isElementPresent(profilePage.paymentMethods, 10)) {
			test.log(Status.PASS, "User directs to PaymentMethods");
		}else {
			test.log(Status.FAIL, "User not directs to the Payment Methods");
		}
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	//Verify the Card is not removed and the passcode should be updated on Payment Methods
		@Test(priority=28)
		public void TC_Profile_061(Method method) throws IOException, Exception {
			String TC_Method = method.getName();
			test = extent.createTest(TC_Method);
			test.log(Status.INFO, "Profile:Change PIN Code").assignCategory("Profile");
			test.info("Verify the Card is not removed and the passcode should be updated on Payment Methods");
			System.out.println(TC_Method);
			
			ProfilePage profilePage = new ProfilePage(driver);
			ProfileFunctions profileFunctions = new ProfileFunctions();
			HomePage homePage = new HomePage(driver);

			//Go to Payment Methods
			generalFunctions.isElementPresent(homePage.homeElement, 20);
			homePage.avatarHome.click();
			generalFunctions.isElementPresent(profilePage.paymentMethods, 20);
			profilePage.paymentMethods.click();
			if(generalFunctions.isElementPresent(profilePage.setUpPin, 30)) {
				test.log(Status.PASS, "Enter your PIN code screen displayed");
			}else {
				test.log(Status.FAIL, "The PIN code screen is NOT displayed");
				Assert.fail("The PIN code screen is NOT displayed");
			}
			profileFunctions.newPin(profilePage);
			Thread.sleep(2000);
			if(generalFunctions.isElementPresent(profilePage.existCard, 30)) {
				test.log(Status.PASS, "The Card is available in the wallet");
			}else {
				test.log(Status.FAIL, "The card is not available in the wallet");
				Assert.fail("The card is not available in the wallet");
			}
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}

		//Verify the Card is not removed and the passcode should be updated on SharePay 
		@Test(priority=29)
		public void TC_Profile_062(Method method) throws IOException, Exception {
			String TC_Method = method.getName();
			test = extent.createTest(TC_Method);
			test.log(Status.INFO, "Profile:Change PIN Code").assignCategory("Profile");
			test.info("Verify the Card is not removed and the passcode should be updated on SharePay");
			System.out.println(TC_Method);
			SharePayPage sharePayPage = new SharePayPage(driver);
			ProfilePage profilePage = new ProfilePage(driver);
			HomePage homePage = new HomePage(driver);

			generalFunctions.isElementPresent(homePage.homeElement, 20);
			generalFunctions.isElementPresent(sharePayPage.shareWalletButton, 20);
			sharePayPage.shareWalletButton.click();
			Thread.sleep(1000);
			
			if(generalFunctions.isElementPresent(sharePayPage.OnBoardingContinue, 30))
			{
				test.log(Status.PASS, "Continue Button Displayed");
			}

			else
			{
				test.log(Status.FAIL, "Continue Button Not Displayed");
				Assert.fail("Continue Button Not Displayed");
			}

			sharePayPage.OnBoardingContinue.click();
			Thread.sleep(1000);

			if(generalFunctions.isElementPresent(profilePage.existCard, 30)) {
				test.log(Status.PASS, "The Card is available in the wallet");
			}else {
				test.log(Status.FAIL, "The card is not available in the wallet");
			}
			driver.navigate().back();
			
			//driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}

	//Verify "Change PIN code for Share Pay " Journey"
	@Test(priority=31)
	public void TC_33_to_43_45(Method method) throws IOException, Exception {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Profile:Change PIN Code").assignCategory("Profile");
		test.info("Verify Change PIN code for Share Pay button is visible if the user already set PIN code");
		System.out.println(TC_Method);
		
		ProfilePage profilePage = new ProfilePage(driver);
		ProfileFunctions profileFunctions = new ProfileFunctions();
		HomePage homePage = new HomePage(driver);

		//SignIn and click on Payment Methods
		generalFunctions.isElementPresent(homePage.homeElement, 20);
		homePage.avatarHome.click();

		if(generalFunctions.isElementPresent(profilePage.changePin, 30)) {
			test.log(Status.PASS, "The Change PIN code for Share Pay button is displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			profilePage.changePin.click();
		}else {
			test.log(Status.FAIL, "The Change PIN code for Share Pay button is NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}
		if(generalFunctions.isElementPresent(profilePage.existingPinScreen, 30)) {
			test.log(Status.PASS, "The Enter PIN code screen displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));

		}else {
			test.log(Status.FAIL, "The Enter PIN code screen is not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));	
		}
		profilePage.setUpPin.sendKeys("0005");
		if(generalFunctions.isElementPresence(By.id("snackbar_text"), 30)) {
			test.log(Status.PASS, "Passcode Mismatch Error displayed: "+profileFunctions.toast()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}else {
			test.log(Status.FAIL, "Passcode Mismatch Error is NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));	
		}
		Thread.sleep(2000);
		profileFunctions.existPin(profilePage);
		if(generalFunctions.isElementPresent(profilePage.setUpPin, 30)) {
			test.log(Status.PASS, "New pin setup Screen displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			profileFunctions.newPin(profilePage);
			test.log(Status.PASS, "New Pin code screen accepts numericals");
		}else {
			test.log(Status.FAIL, "New Pin set up screen not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));	
		}
		if(generalFunctions.isElementPresent(profilePage.setUpPin, 30)) {
			test.log(Status.PASS, "Confirm pin setup Screen displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}else {
			test.log(Status.FAIL, "Confirm Pin set up screen not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));	
		}
		profilePage.setUpPin.sendKeys("0005");
		if(generalFunctions.isElementPresence(By.id("snackbar_text"), 90)) {
			test.log(Status.PASS, "Passcode Mismatch Error displayed: "+profileFunctions.toast()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}else {
			test.log(Status.FAIL, "Passcode Mismatch Error is NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));	
		}
		Thread.sleep(1000);

		if(generalFunctions.isElementPresent(profilePage.setUpPin, 30)) {
			profileFunctions.newPin(profilePage);
			test.log(Status.PASS, "Confirm Pin code screen accepts numericals");
		}else {
			test.log(Status.FAIL, "New Pin set up screen not displayed");	
		}
		if(generalFunctions.isElementPresent(profilePage.removeCardAlert, 30)) {
			test.log(Status.PASS, "The Remove card alert displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			profilePage.yesOption.click();
		}else {
			test.log(Status.FAIL, "The Remove Card option not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));	
		}
		if(generalFunctions.isElementPresent(profilePage.pinChangeSuccess, 30)) {
			test.log(Status.PASS, "The New Pin has been set successfully").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			profilePage.pinChangeSuccess.click();
		}else {
			test.log(Status.FAIL, "The New Pin not set Successfully").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));	
		}
		if(generalFunctions.isElementPresent(profilePage.paymentMethods, 10)) {
			test.log(Status.PASS, "User directs to PaymentMethods");
		}else {
			test.log(Status.FAIL, "User not directs to the Payment Methods");	
		}
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

	//Verify the Card removed from Wallet and the passcode should be updated on Payment Methods
	@Test(priority=32)
	public void TC_Profile_056_to_058(Method method) throws IOException, Exception {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Profile:Change PIN Code").assignCategory("Profile");
		test.info("Verify the Card removed from Wallet and the passcode should be updated on Payment Methods");
		System.out.println(TC_Method);
		
		ProfilePage profilePage = new ProfilePage(driver);
		ProfileFunctions profileFunctions = new ProfileFunctions();
		HomePage homePage = new HomePage(driver);

		//Go to Payment Methods
		generalFunctions.isElementPresent(homePage.homeElement, 20);
		homePage.avatarHome.click();
		generalFunctions.isElementPresent(profilePage.paymentMethods, 20);
		profilePage.paymentMethods.click();
		if(generalFunctions.isElementPresent(profilePage.setUpPin, 30)) {
			test.log(Status.PASS, "Enter your PIN code screen displayed");
		}else {
			test.log(Status.FAIL, "The PIN code screen is NOT displayed");
		}
		profilePage.setUpPin.sendKeys("1234");
		if(generalFunctions.isElementPresence(By.id("snackbar_text"), 90)) {
			test.log(Status.PASS, "Passcode Mismatch Error displayed: "+profileFunctions.toast()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}else {
			test.log(Status.FAIL, "Passcode Mismatch Error is NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}
		profileFunctions.newPin(profilePage);
		Thread.sleep(3000);	
		if(generalFunctions.isElementPresent(profilePage.addNewPaymentMethod, 30)) {
			test.log(Status.PASS, "The Card is removed from the wallet");
		}else {
			test.log(Status.FAIL, "The card is not removed from the Wallet");
		}
		Thread.sleep(1000);	
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
	}

	//Verify the Card removed from SharePayWallet and the passcode should be updated 
	@Test(priority=33)
	public void TC_Profile_059_060(Method method) throws IOException, Exception {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Profile:Change PIN Code").assignCategory("Profile");
		test.info("Verify the Card removed from SharePayWallet and the passcode should be updated");
		System.out.println(TC_Method);
		SharePayPage sharePayPage = new SharePayPage(driver);
		ProfilePage profilePage = new ProfilePage(driver);
		ProfileFunctions profileFunctions = new ProfileFunctions();
		HomePage homePage = new HomePage(driver);
	
		generalFunctions.isElementPresent(homePage.homeElement, 20);
		generalFunctions.isElementPresent(sharePayPage.shareWalletButton, 20);
		sharePayPage.shareWalletButton.click();
		profileFunctions.spayOnboardinskip();
		Thread.sleep(1000);
		if(generalFunctions.isElementPresent(sharePayPage.AddANewCardLink, 30)) {
			test.log(Status.PASS, "The New Card link is displayed");
			sharePayPage.AddANewCardLink.click();
		}else {
			test.log(Status.FAIL, "The new Card link is NOT displayed");
		}
		if(generalFunctions.isElementPresent(profilePage.setUpPin, 30)) {
			test.log(Status.PASS, "Enter your PIN code screen displayed");
		}else {
			test.log(Status.FAIL, "The PIN code screen is NOT displayed");
		}
		profilePage.setUpPin.sendKeys("1237");
		if(generalFunctions.isElementPresence(By.id("snackbar_text"), 90)) {
			test.log(Status.PASS, "Passcode Mismatch Error displayed: "+profileFunctions.toast()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}else {
			test.log(Status.FAIL, "Passcode Mismatch Error is NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}
		profileFunctions.newPin(profilePage);
		//profilePage.setUpPin.sendKeys("1234");
		//profileFunctions.skipbiometric();
		Thread.sleep(1000);	
		if(generalFunctions.isElementPresent(profilePage.CardNumber, 30)) {
			test.log(Status.PASS, "The Card is removed from the wallet");
		}else {
			test.log(Status.FAIL, "The card is not removed from the Wallet");
		}
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	//sprint 18 scripting
	@Test(priority=34)
	public void TC_Profile_61_to_71(Method method) throws Exception
	{	String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Profile - Landing screen");
		test.log(Status.INFO, "TC:Verify user able to view Tutorials under profile screen");
		test.assignCategory("Profile");
		System.out.println(TC_Method);
		ProfilePage profilePage = new ProfilePage(driver);
		SharePayPage sharePayPage = new SharePayPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		HomePage homePage = new HomePage(driver);
		ProfileFunctions profileFunctions = new ProfileFunctions();
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{
			driver.resetApp();
			signInFunctions.SignContinue();//for sprint 18 build
			profileFunctions.newUserSign();
			if(generalFunctions.isElementPresent(profilePage.AvatarName, 30))
			{	test.log(Status.PASS, "Navigated To Profile Page").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Not Navigated To Profile Page").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			generalFunctions.SimplyScrollDown();
			if(generalFunctions.isElementPresent(profilePage.howitworks, 30))
			{	test.log(Status.PASS, "How It Works Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "How It Works Displayed Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}	
			profilePage.howitworks.click();
			
			//SharePay
			if(generalFunctions.isElementPresent(profilePage.spaytutorialscreeninprofile,30))
			{	
				profilePage.spaytutorialscreeninprofile.click();
				test.log(Status.PASS, "Share Pay Onboarding Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Share Pay Onboarding Displayed Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			
			//navigates
			if(generalFunctions.isElementPresent(profilePage.navigatesTutorialspage,30))
			{	test.log(Status.PASS, "Go To Share Pay Navigation Link Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Go To Share Pay Navigation Link Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			profilePage.navigatesTutorialspage.click();
			if(generalFunctions.isElementPresent(sharePayPage.sharePayWallet, 60))
			{	test.log(Status.PASS, "Navigated to Share Pay Page");
			}
			else
			{
				test.log(Status.FAIL, "Not Navigated to Share Pay Page");
			}
			driver.navigate().back();
			
			//AvatarClick
			generalFunctions.isElementPresent(homePage.avatarHome, 20);
			homePage.avatarHome.click();
			generalFunctions.SimplyScrollDown();
			profilePage.howitworks.click();
			
			//Experiences
			if(generalFunctions.isElementPresent(profilePage.spaytutorialscreeninprofile,30))
			{	profilePage.exptutorialscreeninprofile.click();
				test.log(Status.PASS, "Experience Onboarding Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Experience Onboarding Displayed Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			generalFunctions.swipeHorizontal(0.9,0.01,0.5);
			
			//navigation
			if(generalFunctions.isElementPresent(profilePage.navigatesTutorialspage,30))
			{	
				test.info("Able to swipe the Experiences onboarding able to view whole content");
				test.log(Status.PASS, "Go To Experiences Navigation Link Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Go To Experiences Navigation Link Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			profilePage.navigatesTutorialspage.click();
			try
			{generalFunctions.isElementPresent(objExperiencesPage.AllowAllTheTime, 30);
				if(objExperiencesPage.AllowAllTheTime.isDisplayed()== true)
				{	test.log(Status.PASS, "Location Access Displayed");
					objExperiencesPage.DontAllowaccess.click();
				}}
			catch(Exception x)
				{	test.log(Status.INFO, "Access not given because of next testcases dependencies");
					System.out.println("Location Access Denied");
				}
			Thread.sleep(2000);
			
			//Verify SHARE EXPERIENCES displayed
			if(generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30))
			{	test.log(Status.PASS, "Navigated To Experiences Page").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Not Navigated To Experiences Page").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			
			//AvatarClick
			generalFunctions.isElementPresent(homePage.homeElement, 20);
			homePage.homeElement.click();
			generalFunctions.isElementPresent(homePage.avatarHome, 20);
			homePage.avatarHome.click();
			generalFunctions.SimplyScrollDown();
			profilePage.howitworks.click();
			
			//Share Your Points
			if(generalFunctions.isElementPresent(profilePage.spaytutorialscreeninprofile,30))
			{	profilePage.syptutorialscreeninprofile.click();
				test.log(Status.PASS, "Share your points Onboarding Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Share your points Onboarding Displayed Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			//navigation
			if(generalFunctions.isElementPresent(profilePage.navigatesTutorialspage,30))
			{	
				test.log(Status.PASS, "Share Points Now  Navigation Link Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Share Points Now Navigation Link Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			profilePage.navigatesTutorialspage.click();
			Thread.sleep(2200);
			if(generalFunctions.isElementPresent(homePage.Shareyourpointspage, 90))
			{	test.log(Status.PASS, "Navigated To Share Your Points Page").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Not Navigated To Share Your Points Page").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			driver.navigate().back();
			
			//AvatarClick
			generalFunctions.isElementPresent(homePage.avatarHome, 20);
			homePage.avatarHome.click();
			generalFunctions.SimplyScrollDown();
			profilePage.howitworks.click();
			
			//Etihad
			generalFunctions.isElementPresent(profilePage.spaytutorialscreeninprofile,30);
			profilePage.syptutorialscreeninprofile.click();
			if(generalFunctions.isElementPresent(profilePage.ethiadtutorialscreeninprofile,30))
			{	profilePage.ethiadtutorialscreeninprofile.click();
				test.log(Status.PASS, "Etihad Onboarding Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Etihad Onboarding Displayed Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}	
			generalFunctions.swipeHorizontal(0.9,0.01,0.5);
			//navigation
			if(generalFunctions.isElementPresent(profilePage.navigatesTutorialspage,30))
			{	
				test.info("Able to swipe the Etihad onboarding able to view whole content");
				test.log(Status.PASS, "Go To Etihad Guest Transfer Navigation Link Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Go To Etihad Guest Transfer Link Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			profilePage.navigatesTutorialspage.click();
			Thread.sleep(2200);
			if(generalFunctions.isElementPresent(homePage.etihadGuesttransferpage, 90))
			{	test.log(Status.PASS, "Navigated To Etihad Guest Transfer Page").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Not Navigated To Etihad Guest Transfer Page").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
}