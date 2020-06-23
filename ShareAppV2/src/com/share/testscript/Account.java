package com.share.testscript;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.share.functions.AccountFunctions;
import com.share.functions.RegistrationFunctions;
import com.share.functions.SignInFunctions;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.AccountPage;
import com.share.objectrepository.HomePage;
import com.share.objectrepository.RegistrationPage;
import com.share.objectrepository.SignInPage;
import com.share.utility.Utilities;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Account extends DriverSetUp
{

	GeneralFunctions generalFunctions = new GeneralFunctions();

	@Test
	public void TC_A_P_001(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Edit Profile");
		test.info("Edit Profile - Mandatory Fields");
		test.assignCategory("Account");
		System.out.println(TC_Method);

		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		AccountFunctions accountFunctions =new AccountFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{
			driver.activateApp("com.maf.sharesit");
			//Logout if already logged in 
			generalFunctions.Logout();			
			Thread.sleep(5000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();


			//Click on Settings Icon
			generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
			accountPage.SettingsIcon.click();
			Thread.sleep(2000);
			
			try
			{
				//Click Stop Tutorial
				if(registrationPage.StopTutorialElement.isDisplayed()==true)
				{
					registrationPage.StopTutorialElement.click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					//Click Got It
					registrationPage.GotItElement.click();
				}
			}
			catch(Exception x)
			{
				System.out.println("Stop Tutorial Not Displayed");
			}

			//Click on Edit Profile
			generalFunctions.isElementPresent(accountPage.EditProfile, 90);
			accountPage.EditProfile.click();
			Thread.sleep(12000);

			//Verify Title Displayed
			String Title = accountFunctions.getText(accountPage.EditProfileTitle);
			System.out.println("Title "+ Title);

			if(Title.contains("Mr") ||Title.contains("Miss")||Title.contains("Ms")||Title.contains("Mrs"))
			{
				test.log(Status.PASS, "Title Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Title Not Displayed");
				Assert.fail("Title Not Displayed");
			}

			//Verify First Name Displayed
			String FName = accountFunctions.getText( accountPage.EditProfileFirstName);
			System.out.println("First Name "+ FName);
			if(FName!="")
			{
				test.log(Status.PASS, "First Name Displayed");
			}
			else
			{
				test.log(Status.FAIL, "First Name Not Displayed");
				Assert.fail("First Name Not Displayed");
			}

			//Verify Surname Displayed
			String SName = accountFunctions.getText( accountPage.EditProfileSurName);
			System.out.println("Surname "+ SName);
			if(SName!="")
			{
				test.log(Status.PASS, "Surname Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Surname Not Displayed");
				Assert.fail("Surname Not Displayed");
			}

			//Verify Phone Number Displayed
			String PhoneNum = accountFunctions.getText( accountPage.EditProfilePhoneNum);
			System.out.println("Phone Number "+ PhoneNum);
			if(PhoneNum!="")
			{
				test.log(Status.PASS, "Phone Number Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Phone Number Not Displayed");
				Assert.fail("Phone Number Not Displayed");
			}

			//Verify DOB Displayed
			String DOB = accountFunctions.getText( accountPage.EditProfileDob);
			System.out.println("DOB "+ DOB);
			if(DOB!="")
			{
				test.log(Status.PASS, "DOB Displayed");
			}
			else
			{
				test.log(Status.FAIL, "DOB Not Displayed");
				Assert.fail("DOB Not Displayed");
			}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}


	@Test
	public void TC_A_P_002(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Edit Profile");
		test.info("Edit Profile - Non Mandatory Fields");
		test.assignCategory("Account");
		System.out.println(TC_Method);		
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		AccountFunctions accountFunctions =new AccountFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{

			driver.activateApp("com.maf.sharesit");
			Thread.sleep(5000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();


			//Click on Settings Icon
			generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
			accountPage.SettingsIcon.click();


			//Click on Edit Profile
			generalFunctions.isElementPresent(accountPage.EditProfile, 90);
			accountPage.EditProfile.click();
			Thread.sleep(15000);

			//Verify Title Displayed
			String Title = accountFunctions.getText( accountPage.EditProfileTitle);
			System.out.println("Title "+ Title);
			if(Title.contains("Mr") ||Title.contains("Miss")||Title.contains("Ms")||Title.contains("Mrs"))
			{
				test.log(Status.PASS, "Title Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Title Not Displayed");
				Assert.fail("Title Not Displayed");
			}

			//Verify First Name Displayed
			String FName = accountFunctions.getText( accountPage.EditProfileFirstName);
			System.out.println("First Name "+ FName);
			if(FName!="")
			{
				test.log(Status.PASS, "First Name Displayed");
			}
			else
			{
				test.log(Status.FAIL, "First Name Not Displayed");
				Assert.fail("First Name Not Displayed");
			}

			//Verify Surname Displayed
			String SName = accountFunctions.getText( accountPage.EditProfileSurName);
			System.out.println("Surname "+ SName);
			if(SName!="")
			{
				test.log(Status.PASS, "Surname Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Surname Not Displayed");
				Assert.fail("Surname Not Displayed");
			}

			//Verify Nationality Displayed
			String Nationality = accountFunctions.getText( accountPage.EditProfileNationality);
			System.out.println("Nationality "+ Nationality);
			if(Nationality!="")
			{
				test.log(Status.PASS, "Nationality Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Nationality Not Displayed");
				Assert.fail("Nationality Not Displayed");
			}

			//Verify Country Code Displayed
			String CountryCode = accountFunctions.getText(accountPage.EditProfileCountryCode);
			System.out.println("Country Code "+ CountryCode);
			if(CountryCode!="")
			{
				test.log(Status.PASS, "Country Code Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Country Code Not Displayed");
				Assert.fail("Country Code Not Displayed");
			}

			//Verify Phone Number Displayed
			String PhoneNum = accountFunctions.getText( accountPage.EditProfilePhoneNum);
			System.out.println("Phone Number "+ PhoneNum);
			if(PhoneNum!="")
			{
				test.log(Status.PASS, "Phone Number Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Phone Number Not Displayed");
				Assert.fail("Phone Number Not Displayed");
			}

			//Verify DOB Displayed
			String DOB = accountFunctions.getText( accountPage.EditProfileDob);
			System.out.println("DOB "+ DOB);
			if(DOB!="")
			{
				test.log(Status.PASS, "DOB Displayed");
			}
			else
			{
				test.log(Status.FAIL, "DOB Not Displayed");
				Assert.fail("DOB Not Displayed");
			}
			//driver.closeApp();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			//driver.closeApp();
			Assert.fail(e.getMessage());
		}
	}


	@Test
	public void TC_A_P_003(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Edit Profile");
		test.info("Edit Profile - Save with Non Mandatory Fields");
		test.assignCategory("Account");
		System.out.println(TC_Method);		
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		AccountFunctions accountFunctions =new AccountFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{

			driver.activateApp("com.maf.sharesit");
			Thread.sleep(5000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();


			//Click on Settings Icon
			generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
			accountPage.SettingsIcon.click();


			//Click on Edit Profile
			generalFunctions.isElementPresent(accountPage.EditProfile, 90);
			accountPage.EditProfile.click();
			Thread.sleep(15000);

			//Select Nationality
			accountPage.EditProfileNationality.click();
			
			int ObjElements = driver.findElementsByXPath(registrationPage.DropDownList).size();
			System.out.println("Number of elements : "+ObjElements);
													
			//Generate random number with number of Nationality displayed
			int SelectedElement = generalFunctions.GenerateRandomNumber(ObjElements);
			System.out.println("Drop down value : "+SelectedElement);
													
			//Set the Xpath for Nationality with index
			String Xpath= registrationPage.SelectCountry(SelectedElement);
													
			//select the country
			generalFunctions.RandomlyScrollToElement(Xpath);
			Thread.sleep(2000);
													
			String Selectednationality =generalFunctions.getText(accountPage.EditProfileNationality);
			System.out.println("Selected Nationality : "+Selectednationality);
					

			//Click Save Changes
			accountPage.EditProfileSaveChanges.click();
			//Thread.sleep(15000);
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

			//Verify the success message
			String success = accountFunctions.getText(accountPage.EditProfileSaveChangesMsg);
			System.out.println("Message : "+ success);
			if(success.contains("Profile saved successfully"))
			{
				test.log(Status.PASS, "Profile saved successfully");
			}
			else
			{
				test.log(Status.FAIL, "Profile Not saved successfully");
				Assert.fail("Profile Not saved successfully");
			}

			//Click Confirm
			accountPage.EditProfileSaveChangesConfirm.click();
			//driver.closeApp();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			//driver.closeApp();
			Assert.fail(e.getMessage());
		}
	}


	@Test
	public void TC_A_P_004(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Edit Profile");
		test.info("Edit Profile - Save with Mandatory Fields");
		test.assignCategory("Account");
		System.out.println(TC_Method);		
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();
		String Surname=map.get("Surname").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		AccountFunctions accountFunctions =new AccountFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{

			driver.activateApp("com.maf.sharesit");
			Thread.sleep(5000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();


			//Click on Settings Icon
			generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
			accountPage.SettingsIcon.click();


			//Click on Edit Profile
			generalFunctions.isElementPresent(accountPage.EditProfile, 90);
			accountPage.EditProfile.click();
			Thread.sleep(10000);

			//Edit Surname
			accountPage.EditProfileSurName.clear();
			accountPage.EditProfileSurName.sendKeys(Surname);
			driver.hideKeyboard();

			//Select Nationality
			//accountPage.EditProfileNationality.click();
			//String Country = "Emirati";			
			//registrationFunctions.ScrollToElement(2000,Country);

			//Click Save Changes
			accountPage.EditProfileSaveChanges.click();
			//Thread.sleep(15000);
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

			//Verify the success message
			String success = accountFunctions.getText(accountPage.EditProfileSaveChangesMsg);
			System.out.println("Message : "+ success);
			if(success.contains("Profile saved successfully"))
			{
				test.log(Status.PASS, "Profile saved successfully");
			}
			else
			{
				test.log(Status.FAIL, "Profile Not saved successfully");
				Assert.fail("Profile Not saved successfully");
			}

			//Click Confirm
			accountPage.EditProfileSaveChangesConfirm.click();
			//driver.closeApp();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			//driver.closeApp();
			Assert.fail(e.getMessage());
		}
	}


	@Test
	public void TC_A_P_005(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Edit Profile");
		test.info("Validate user not able to leave the manadatory fields blank");
		test.assignCategory("Account");
		System.out.println(TC_Method);		
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{

			driver.activateApp("com.maf.sharesit");	
			Thread.sleep(5000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();

			//Click on Settings Icon
			generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
			accountPage.SettingsIcon.click();

			//Click on Edit Profile
			generalFunctions.isElementPresent(accountPage.EditProfile, 90);
			accountPage.EditProfile.click();
			Thread.sleep(10000);

			//Clear First Name
			accountPage.EditProfileFirstName.clear();
			driver.hideKeyboard();

			//Clear Surname
			accountPage.EditProfileSurName.clear();
			driver.hideKeyboard();

			//Clear Phone Number
			accountPage.EditProfilePhoneNum.clear();
			driver.hideKeyboard();

			//Select Nationality
			//accountPage.EditProfileNationality.click();
			//String Country = "Emirati";			
			//registrationFunctions.ScrollToElement(2000,Country);

			//Verify Save Changes Button
			if(accountPage.EditProfileSaveChanges.isEnabled()==false)
			{
				test.log(Status.PASS, "user is not able to leave the mandatory fields as blank");
			}
			else
			{
				test.log(Status.FAIL, "user is able to leave the mandatory fields as blank");
				Assert.fail("user is able to leave the mandatory fields as blank");
			}	
			//driver.closeApp();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			//driver.closeApp();
			Assert.fail(e.getMessage());
		}
	}


	@Test
	public void TC_A_P_006(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Edit Profile");
		test.info("Validate the Discard button");
		test.assignCategory("Account");
		System.out.println(TC_Method);		
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		AccountFunctions accountFunctions =new AccountFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{

			driver.activateApp("com.maf.sharesit");			
			Thread.sleep(5000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();

			//Click on Settings Icon
			generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
			accountPage.SettingsIcon.click();

			//Click on Edit Profile
			generalFunctions.isElementPresent(accountPage.EditProfile, 90);
			accountPage.EditProfile.click();
			Thread.sleep(10000);

			//Clear First Name
			accountPage.EditProfileFirstName.clear();
			accountPage.EditProfileFirstName.sendKeys("test");
			driver.hideKeyboard();

			//Clear Surname
			accountPage.EditProfileSurName.clear();
			accountPage.EditProfileSurName.sendKeys("qa");
			driver.hideKeyboard();

			//Clear Phone Number
			accountPage.EditProfilePhoneNum.clear();
			accountPage.EditProfilePhoneNum.sendKeys("99209370");
			driver.hideKeyboard();

			//Select Nationality
			accountPage.EditProfileNationality.click();
			int ObjElements = driver.findElementsByXPath(registrationPage.DropDownList).size();
			System.out.println("Number of elements : "+ObjElements);
													
			//Generate random number with number of Nationality displayed
			int SelectedElement = generalFunctions.GenerateRandomNumber(ObjElements);
			System.out.println("Drop down value : "+SelectedElement);
													
			//Set the Xpath for Nationality with index
			String Xpath= registrationPage.SelectCountry(SelectedElement);
													
			//select the country
			generalFunctions.RandomlyScrollToElement(Xpath);
			Thread.sleep(2000);
													
			String Selectednationality =generalFunctions.getText(accountPage.EditProfileNationality);
			System.out.println("Selected Nationality : "+Selectednationality);

			//Click Back
			accountPage.NavigateBack.click();
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

			//Verify the unsaved changes message
			String DiscardMessage = accountFunctions.getText(accountPage.EditProfileDiscardMsg);
			System.out.println("Message : "+ DiscardMessage);
			if(DiscardMessage.contains("You have unsaved changes to your profile. Do you wish to discard them?"))
			{
				test.log(Status.PASS, "Message for Unsaved Changes Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Message for Unsaved Changes Not Displayed");
				Assert.fail("Message for Unsaved Changes Not Displayed");
			}

			//Click Discard
			accountPage.EditProfileDiscard.click();
			Thread.sleep(10000);

			//Click on Edit Profile
			accountPage.EditProfile.click();
			Thread.sleep(15000);

			//Verify First Name Displayed
			String FName = accountFunctions.getText( accountPage.EditProfileFirstName);
			System.out.println("First Name "+ FName);
			if(FName!="test")
			{
				test.log(Status.PASS, "First Name Not updated");
			}
			else
			{
				test.log(Status.FAIL, "First Name updated");
				Assert.fail("First Name updated");
			}

			//Verify Surname Displayed
			String SName = accountFunctions.getText( accountPage.EditProfileSurName);
			System.out.println("Surname "+ SName);
			if(SName!="qa")
			{
				test.log(Status.PASS, "Surname Not Updated");
			}
			else
			{
				test.log(Status.FAIL, "Surname updated");
				Assert.fail("Surname updated");
			}
			System.out.println("Changes not saved");
			//driver.closeApp();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			//driver.closeApp();
			Assert.fail(e.getMessage());
		}
	}



	@Test
	public void TC_A_P_007(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Edit Profile");
		test.info("Validate the user is able to Reset Password");
		test.assignCategory("Account");
		System.out.println(TC_Method);		
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions GenFunctions = new GeneralFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{

			driver.activateApp("com.maf.sharesit");	
			Thread.sleep(5000);	
			
			//Logout if already logged in 
			generalFunctions.Logout();			
			Thread.sleep(5000);
			
			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();

			//Click on Settings Icon
			generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
			accountPage.SettingsIcon.click();
			Thread.sleep(10000);


			//Click on Reset password
			accountPage.ResetPassword.click();
			generalFunctions.isElementPresent(accountPage.PageTitle, 90);

			//Verify Reset password page Displayed
			String Page= accountPage.PageTitle.getText();
			System.out.println(Page);
			if(Page.contains("Reset password"))
			{
				test.log(Status.PASS, "Reset password page displayed");
			}
			else
			{
				test.log(Status.FAIL, "Reset password page Not Displayed");
				Assert.fail("Reset password page Not Displayed");
			}	
			Thread.sleep(10000);
			//Verify the email address
			String VerifyEmail= accountPage.ResetPasswordEmail.getText();
			System.out.println(VerifyEmail);
			if(VerifyEmail.contains(EmailAddress))
			{
				test.log(Status.PASS, "Email Address is same as the logged in email address");
			}
			else
			{
				test.log(Status.FAIL, "Email Address is Not same as the logged in email address");
				Assert.fail("Email Address is Not same as the logged in email addres");
			}

			//Click on Reset Password
			accountPage.ResetPasswordButton.click();
			Thread.sleep(10000);

			String Dvtime = driver.getDeviceTime();
			System.out.println("device time: "+Dvtime);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.ENGLISH);		
			Date parsedDate = sdf.parse(Dvtime);
			SimpleDateFormat print = new SimpleDateFormat("HH:mm");	
			String FormatedDeviceTime = print.format(parsedDate);	
			System.out.println("Formated Device Time : "+FormatedDeviceTime);

			//Verify Status
			String VerifyStatus= accountPage.Status.getText();
			System.out.println(VerifyStatus);
			if(VerifyStatus.contains("Email sent"))
			{
				test.log(Status.PASS, "Email sent successfully");
			}
			else
			{
				test.log(Status.FAIL, "Email Not sent successfully");
				Assert.fail("Email Not sent successfully");
			}

			String ThanksButton= accountPage.Button.getText();
			System.out.println(ThanksButton);
			if(ThanksButton.contains("THANKS"))
			{
				test.log(Status.PASS, "THANKS button Displayed");
			}
			else
			{
				test.log(Status.FAIL, "THANKS button Not Displayed");
				Assert.fail("THANKS button Not Displayed");
			}
			accountPage.Button.click();
			//Close the application
			//driver.closeApp();
			Thread.sleep(10000);

			GenFunctions.StartActivity("com.google.android.gm","ConversationListActivityGmail");
			Thread.sleep(25000);

			//Search email	
			accountPage.SearchMail.click();
			Thread.sleep(5000);
			//accountPage.SearchMail.sendKeys("SHARE");
			Actions action = new Actions(driver);
			action.sendKeys("SHARE").perform();

			driver.pressKey(new KeyEvent(AndroidKey.ENTER));


			//Verify Email received
			String EmailSub= accountPage.MailSubject.getText();
			System.out.println(EmailSub);
			if(EmailSub.contains("Reset your password"))
			{
				test.log(Status.PASS, "Email received for Reset your password");
			}
			else
			{
				test.log(Status.FAIL, "Email Not received for Reset your password");
				Assert.fail("Email Not received for Reset your password");
			}

			//Verify received email time
			String EmailTime= accountPage.MailTime.getText();
			System.out.println("Email time : "+EmailTime);

			DateFormat df = new SimpleDateFormat("hh:mm");
			Date dateft = df.parse(EmailTime);
			String GetMailTime= df.format(dateft);
			System.out.println("Time: " + GetMailTime);

			//Compare the Time		
			Date Mdate = df.parse(GetMailTime);

			Date Cdate = df.parse(FormatedDeviceTime);

			if(Cdate.after(Mdate)==true| Mdate.equals(Cdate)) 
			{
				test.log(Status.PASS, "received the latest email");
			}
			else
			{
				test.log(Status.FAIL, "latest email not received");
				Assert.fail("latest email not received");
			}
			//driver.closeApp();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			//driver.closeApp();
			Assert.fail(e.getMessage());
		}
	}



	@Test
	public void TC_A_P_008(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Edit Profile");
		test.info("Validate the Notification page");
		test.assignCategory("Account");
		System.out.println(TC_Method);		
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{

			driver.activateApp("com.maf.sharesit");
			Thread.sleep(5000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();

			//Click on Settings Icon
			generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
			accountPage.SettingsIcon.click();

			//Click on Notifications
			generalFunctions.isElementPresent(accountPage.Notifications, 90);
			accountPage.Notifications.click();
			//Thread.sleep(15000);

			//Verify Notifications page Displayed
			generalFunctions.isElementPresent(accountPage.PageTitle, 90);
			String Page= accountPage.PageTitle.getText();
			System.out.println(Page);
			if(Page.contains("Notifications"))
			{
				test.log(Status.PASS, "Notifications page displayed");
			}
			else
			{
				test.log(Status.FAIL, "Notifications page Not Displayed");
				Assert.fail("Notifications page Not Displayed");
			}	

			//Verify Notifications Text
			String Notifications= accountPage.NotificationsText.getText();
			System.out.println(Notifications);
			if(Notifications.contains("To modify the notification preferences for this application, please go to your phone settings."))
			{
				test.log(Status.PASS, "Notifications Message Displayed and verified successfully");
			}
			else
			{
				test.log(Status.FAIL, "Notifications Message Not Displayed Or Wrong Message Displayed");
				Assert.fail("Notifications Message Not Displayed Or Wrong Message Displayed");
			}
			//driver.closeApp();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			//driver.closeApp();
			Assert.fail(e.getMessage());
		}
	}




	@Test
	public void TC_A_P_009(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Edit Profile");
		test.info("Validate the Payment Methods");
		test.assignCategory("Account");
		System.out.println(TC_Method);		
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInPage signInPage = new SignInPage(driver);
		
		try	
		{

			driver.activateApp("com.maf.sharesit");
			Thread.sleep(5000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();

			//Click on Settings Icon
			generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
			accountPage.SettingsIcon.click();

			//Click on Payment Methods
			generalFunctions.isElementPresent(accountPage.PaymentMethods, 90);
			accountPage.PaymentMethods.click();

			//Verify Payment methods page Displayed
			generalFunctions.isElementPresent(accountPage.PageTitle, 90);
			String Page= accountPage.PageTitle.getText();
			System.out.println(Page);
			if(Page.contains("Payment methods"))
			{
				test.log(Status.PASS, "Payment methods page displayed");
			}
			else
			{
				test.log(Status.FAIL, "Payment methods page Not Displayed");
				Assert.fail("Payment methods page Not Displayed");
			}	
			Thread.sleep(10000);
			
			if(accountPage.AddCard.isDisplayed())
			{
				test.log(Status.PASS, "Add Credit or Debit Card option Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Add Credit or Debit Card option Not Displayed");
				Assert.fail("Add Credit or Debit Card option Not Displayed");
			}

			//Click on Add Credit or Debit Card option
			accountPage.AddCard.click();
			Thread.sleep(15000);

			//Verify Add Payment method page displayed
			generalFunctions.isElementPresent(accountPage.PageTitle, 90);
			String AddPaymentmethodPage= accountPage.PageTitle.getText();
			System.out.println(AddPaymentmethodPage);
			if(AddPaymentmethodPage.contains("Add payment method"))
			{
				test.log(Status.PASS, "Add payment method page Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Add payment method page Not Displayed");
				Assert.fail("Add payment method page Not Displayed");
			}
			//driver.closeApp();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			//driver.closeApp();
			Assert.fail(e.getMessage());
		}
	}



	@Test
	public void TC_A_P_010_To_TC_A_P_013(Method method) throws Exception
	{

		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Edit Profile");
		test.info("TC_A_P_010, TC_A_P_011, TC_A_P_012, TC_A_P_013");
		test.info("Validate adding a Card to share wallet");
		test.assignCategory("Account");
		System.out.println(TC_Method);		
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();
		String CardNumber=map.get("CardNumber").toString();
		String NameOnCard =map.get("NameOnCard").toString();
		String ExpiryDate=map.get("ExpiryDate").toString();
		String Cvv =map.get("Cvv").toString();
		String TransactionAmount=map.get("TransactionAmount").toString();


		//String lastDigits = CardNumber.split(" ")[(CardNumber.split(" ")).length -1];

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{

			driver.activateApp("com.maf.sharesit");
			Thread.sleep(5000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();

			//Click on Settings Icon
			generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
			accountPage.SettingsIcon.click();
			Thread.sleep(10000);
			
			//Click on Payment Methods
			generalFunctions.isElementPresent(accountPage.PaymentMethods, 90);
			accountPage.PaymentMethods.click();
			Thread.sleep(10000);

			//Verify Payment methods page Displayed
			generalFunctions.isElementPresent(accountPage.PageTitle, 90);
			String Page= accountPage.PageTitle.getText();
			System.out.println(Page);
			if(Page.contains("Payment methods"))
			{
				test.log(Status.PASS, "Payment methods page displayed");
			}
			else
			{
				test.log(Status.FAIL, "Payment methods page Not Displayed");
				Assert.fail("Payment methods page Not Displayed");
			}	

			if(accountPage.AddCard.isDisplayed())
			{
				test.log(Status.PASS, "Add Credit or Debit Card option Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Add Credit or Debit Card option Not Displayed");
				Assert.fail("Add Credit or Debit Card option Not Displayed");
			}

			//Click on Add Credit or Debit Card option
			accountPage.AddCard.click();
			Thread.sleep(20000);

			//Verify Add Payment method page displayed
			String AddPaymentmethodPage= accountPage.PageTitle.getText();
			System.out.println(AddPaymentmethodPage);
			if(AddPaymentmethodPage.contains("Add payment method"))
			{
				test.log(Status.PASS, "Add payment method page Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Add payment method page Not Displayed");
				Assert.fail("Add payment method page Not Displayed");
			}	

			//Enter Card Number
			//accountPage.CardNumber.setValue(CardNumber);
			accountPage.CardNumber.click();
			Actions action = new Actions(driver);
			action.sendKeys(CardNumber).perform();
			Thread.sleep(5000);
			
			//Enter Name on Card
			accountPage.NameOnCard.sendKeys(NameOnCard);
			
			//Enter Expiry date
			//accountPage.Expiry.setValue(ExpiryDate);
			accountPage.Expiry.click();
			action.sendKeys(ExpiryDate).perform();
			Thread.sleep(5000);
			
			//Enter CVV
			accountPage.CVV.sendKeys(Cvv);
			
			String GetCardNumber=accountPage.CardNumber.getText();
			System.out.println(GetCardNumber);
			//String lastDigits = GetCardNumber.split(" ")[(CardNumber.split(" ")).length -1];
			String lastDigits = GetCardNumber.substring(GetCardNumber.lastIndexOf(' ') + 1);
			System.out.println(lastDigits);

			//Click Save Card
			accountPage.SaveCard.click();
			Thread.sleep(10000);		

			//Verify Verify Card Page page displayed
			String VerifyCardPage= accountPage.PageTitle.getText();
			System.out.println(VerifyCardPage);
			if(VerifyCardPage.contains("Verify card"))
			{
				test.log(Status.PASS, "Verify Card page Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Verify Card page Not Displayed");
				Assert.fail("Verify Card page Not Displayed");
			}	

			//Verify the Transaction Amount Field displayed
			if(accountPage.TransactionAmount.isDisplayed()==true)
			{
				test.log(Status.PASS, "Transaction Amount Field Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Transaction Amount Field Not Displayed");
				Assert.fail("Transaction Amount Field Not Displayed");
			}

			//Verify Information Text
			String Informations= accountPage.InformationText.getText();
			System.out.println(Informations);
			if(Informations.contains("To ensure the security of your SHARE Wallet, we have deducted a small amount from the card that you have just added."))
			{
				test.log(Status.PASS, "Verify Card Information Text Displayed and verified successfully");
			}
			else
			{
				test.log(Status.FAIL, "Verify Card Information Text Not Displayed Or Wrong Message Displayed");
				Assert.fail("Verify Card Information Text Not Displayed Or Wrong Message Displayed");
			}	

			//Verify the submit button
			if(accountPage.SubmitTransactionAmount.isEnabled()==false)
			{
				test.log(Status.PASS, "Submit Button is Disabled");
			}
			else
			{
				test.log(Status.FAIL, "Submit Button is Enabled");
				Assert.fail("Submit Button is Enabled");
			}

			//TC_A_P_010

			//Navigate Back
			accountPage.clickBack.click();
			Thread.sleep(10000);	

			//Verify Payment methods page displayed
			String PaymentmethodPage= accountPage.PageTitle.getText();
			System.out.println(PaymentmethodPage);
			if(PaymentmethodPage.contains("Payment methods"))
			{
				test.log(Status.PASS, "Payment methods page Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Payment methods page Not Displayed");
				Assert.fail("Payment methods page Not Displayed");
			}	

			//Verify the Card Details Tag
			String CardTag= accountPage.GetCardStatus(lastDigits).getText();
			System.out.println("Card Status : "+CardTag);
			if(CardTag.contains("UNVERIFIED"))
			{
				test.log(Status.PASS, "Card Details Tag Displayed and verified");
			}
			else
			{
				test.log(Status.FAIL, "Card Tag Not Displayed OR Wrong Details Tag displayed");
				Assert.fail("Card Tag Not Displayed OR Wrong Details Tag displayed");
			}	

			//TC_A_P_011

			//Close the application
			driver.closeApp();
			Thread.sleep(5000);

			createAndroidDriver();
			Thread.sleep(5000);

			//LOGIN

			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();

			//Click on Settings Icon
			generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
			accountPage.SettingsIcon.click();

			//Click on Payment Methods
			generalFunctions.isElementPresent(accountPage.PaymentMethods, 90);
			accountPage.PaymentMethods.click();


			//Verify Payment methods page Displayed
			generalFunctions.isElementPresent(accountPage.PageTitle, 90);
			String PMPage= accountPage.PageTitle.getText();
			System.out.println(PMPage);
			if(PMPage.contains("Payment methods"))
			{
				test.log(Status.PASS, "Payment methods page displayed");
			}
			else
			{
				test.log(Status.FAIL, "Payment methods page Not Displayed");
				Assert.fail("Payment methods page Not Displayed");
			}

			//Select Card
			accountPage.SelectCards(lastDigits).click();
			Thread.sleep(15000);

			//Verify Verify Card Page page displayed
			String VerifyCardPage1= accountPage.PageTitle.getText();
			System.out.println(VerifyCardPage1);
			if(VerifyCardPage1.contains("Verify card"))
			{
				test.log(Status.PASS, "Verify Card page Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Verify Card page Not Displayed");
				Assert.fail("Verify Card page Not Displayed");
			}	

			//Verify the Transaction Amount Field displayed
			if(accountPage.TransactionAmount.isDisplayed()==true)
			{
				test.log(Status.PASS, "Transaction Amount Field Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Transaction Amount Field Not Displayed");
				Assert.fail("Transaction Amount Field Not Displayed");
			}

			//Enter Amount
			accountPage.TransactionAmount.sendKeys(TransactionAmount);

			//Verify the submit button
			if(accountPage.SubmitTransactionAmount.isEnabled()==true)
			{
				test.log(Status.PASS, "Submit Button is Enabled after entering Transaction Amount");
			}
			else
			{
				test.log(Status.FAIL, "Submit Button is Disabled after entering Transaction Amount");
				Assert.fail("Submit Button is Disabled after entering Transaction Amount");
			}

			//Click Submit
			accountPage.SubmitTransactionAmount.click();
			Thread.sleep(15000);

			String PMPage1= accountPage.PageTitle.getText();
			System.out.println(PMPage1);
			if(PMPage1.contains("Payment methods"))
			{
				test.log(Status.PASS, "Payment methods page displayed");
			}
			else
			{
				test.log(Status.FAIL, "Payment methods page Not Displayed");
				Assert.fail("Payment methods page Not Displayed");
			}

			System.out.println("Transaction amount submitted and card verified");

			//TC_A_P_012

			//Long press on Card
			AccountFunctions.LongPress(accountPage.SelectCards(lastDigits));

			//Click Delete
			accountPage.Delete.click();
			Thread.sleep(10000);

			//Verify the delete confirmation
			String DeleteConfirmation = accountPage.Confrimation.getText();
			System.out.println(DeleteConfirmation);
			if(DeleteConfirmation.contains("Delete card"))
			{
				test.log(Status.PASS, "Delete card confirmation displayed");
			}
			else
			{
				test.log(Status.FAIL, "Delete card confirmation Not Displayed");
				Assert.fail("Delete card confirmation Not Displayed");
			}

			//Verify the delete confirmation
			String DeleteConfirmationMsg = accountPage.ConfrimationMessage.getText();
			System.out.println(DeleteConfirmationMsg);
			if(DeleteConfirmationMsg.contains("Are you sure you want to delete MasterCard ending in"))
			{
				test.log(Status.PASS, "Delete card confirmation message displayed");
			}
			else
			{
				test.log(Status.FAIL, "Delete card confirmation message Not Displayed");
				Assert.fail("Delete card confirmation message Not Displayed");
			}

			//Click Confirm 
			accountPage.confirm.click();
			Thread.sleep(15000);

			try
			{
				if(accountPage.SelectCards(lastDigits).isDisplayed()==true)
				{
					test.log(Status.FAIL, "Card Not Deleted");
					Assert.fail("Card Not Deleted");
				}			
			}
			catch(NoSuchElementException x)
			{
				test.log(Status.PASS, "Card Deleted");
			}
			//driver.closeApp();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			//driver.closeApp();
			Assert.fail(e.getMessage());
		}
	}




	@Test
	public void TC_A_P_014(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Edit Profile");
		test.info("Validate the login page");
		test.assignCategory("Account");
		System.out.println(TC_Method);		
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{

			driver.activateApp("com.maf.sharesit");
			Thread.sleep(5000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();

			//Click on Settings Icon
			generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
			accountPage.SettingsIcon.click();

			//Click on Terms and conditions	
			generalFunctions.isElementPresent(accountPage.terms_cond, 90);
			accountPage.terms_cond.click();

			generalFunctions.isElementPresent(accountPage.PageTitle, 90);

			String Page = accountPage.PageTitle.getText();
			System.out.println(Page);
			if(Page.contains("Terms and conditions"))
			{
				test.log(Status.PASS, "Successfully entered to Terms and conditions");
			}
			else
			{
				test.log(Status.FAIL, "Entering to Terms and conditions is unsuccessfull");
				Assert.fail("Entering to Terms and conditions is unsuccessfull");
			}	
			//driver.closeApp();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			//driver.closeApp();
			Assert.fail(e.getMessage());
		}
	}	


	@Test
	public void TC_A_P_015(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Edit Profile");
		test.info("Validate the login page");
		test.assignCategory("Account");
		System.out.println(TC_Method);		
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{

			driver.activateApp("com.maf.sharesit");
			Thread.sleep(5000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);
			Thread.sleep(5000);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();			
			Thread.sleep(6000);
			
			try
			{
				//Click Stop Tutorial
				if(registrationPage.StopTutorialElement.isDisplayed()==true)
				{
					registrationPage.StopTutorialElement.click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					//Click Got It
					registrationPage.GotItElement.click();
				}
			}
			catch(Exception x)
			{
				System.out.println("Stop Tutorial Not Displayed");
			}

			//Click on Settings Icon
			generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
			accountPage.SettingsIcon.click();
			Thread.sleep(4000);
			
			try
			{
				//Click Stop Tutorial
				if(registrationPage.StopTutorialElement.isDisplayed()==true)
				{
					registrationPage.StopTutorialElement.click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					//Click Got It
					registrationPage.GotItElement.click();
				}
			}
			catch(Exception x)
			{
				System.out.println("Stop Tutorial Not Displayed");
			}

			//Click on reset button
			generalFunctions.isElementPresent(accountPage.reset_icon, 90);
			accountPage.reset_icon.click();

			//Verify the confirmation
			generalFunctions.isElementPresent(accountPage.ResetConfrimation, 90);
			String ConfirmMsg = accountPage.ResetConfrimation.getText();
			if(ConfirmMsg.contains("Are you sure you want to reset the tutorial?"))
			{
				test.log(Status.PASS, "Reset Confirmation Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Reset Confirmation Not Displayed");
				Assert.fail("Reset Confirmation Not Displayed");
			}

			accountPage.confirm_button.click();
			//Thread.sleep(15000);
			generalFunctions.isElementPresent(accountPage.settings, 90);

			String Page = accountPage.settings.getText();
			System.out.println(Page);
			if(Page.contains("Settings"))
			{
				test.log(Status.PASS, "Reset tutorial is confirmed");
			}
			else
			{
				test.log(Status.FAIL, "Reset tutorial is not confirmed");
				Assert.fail("Reset tutorial is not confirmed");
			}

			//Navigate Back
			accountPage.NavigateBack.click();
			Thread.sleep(5000);						
			
			//generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
			//accountPage.SettingsIcon.click();
			//Thread.sleep(5000);

			//Click Stop Tutorial
			if(registrationPage.StopTutorialElement.isDisplayed()==true)
			{
				test.log(Status.PASS, "Tutorials Appeared in Home page");							
			}
			else
			{
				test.log(Status.PASS, "Tutorials Not Appeared in Home page");
				Assert.fail("Tutorials Not Appeared in Home page");
			}
			//driver.closeApp();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			//driver.closeApp();
			Assert.fail(e.getMessage());
		}
	}	



	@Test
	public void TC_A_P_016(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Edit Profile");
		test.info("Validate the login page");
		test.assignCategory("Account");
		System.out.println(TC_Method);		
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{

			driver.activateApp("com.maf.sharesit");
			Thread.sleep(5000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);
			Thread.sleep(15000);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();

			//Click on Settings Icon
			generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
			accountPage.SettingsIcon.click();

			//Click on reset button
			generalFunctions.isElementPresent(accountPage.reset_icon, 90);
			accountPage.reset_icon.click();
			Thread.sleep(15000);

			//Verify the confirmation
			String ConfirmMsg = accountPage.ResetConfrimation.getText();
			if(ConfirmMsg.contains("Are you sure you want to reset the tutorial?"))
			{
				test.log(Status.PASS, "Reset Confirmation Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Reset Confirmation Not Displayed");
				Assert.fail("Reset Confirmation Not Displayed");
			}

			accountPage.cancel_button.click();
			Thread.sleep(15000);

			String Page = accountPage.settings.getText();
			System.out.println(Page);
			if(Page.contains("Settings"))
			{
				test.log(Status.PASS, "Reset tutorial is cancelled");
			}
			else
			{
				test.log(Status.FAIL, "Reset tutorial is not cancelled");
				Assert.fail("Reset tutorial is not cancelled");
			}

			//Navigate Back
			accountPage.NavigateBack.click();
			Thread.sleep(15000);

			//Click Stop Tutorial
			//if(registrationPage.StopTutorialElement.isDisplayed()==true)
			//{
			//	test.log(Status.PASS, "Tutorials Appeared in Home page");
			//}
			//else
			//{
			//test.log(Status.PASS, "Tutorials Not Appeared in Home page");
			//}
			//driver.closeApp();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			//	driver.closeApp();
			Assert.fail(e.getMessage());
		}
	}	


	@Test
	public void TC_A_P_017(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Edit Profile");
		test.info("Validate the privacy page");
		test.assignCategory("Account");
		System.out.println(TC_Method);		
		String UserName=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{

			driver.activateApp("com.maf.sharesit");
			Thread.sleep(5000);

			//LOGIN
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			registrationFunctions.LoginFun(registrationPage,UserName,Pass,signInPage);

			//accountPage.gotit.click();
			//Thread.sleep(10000);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();

			//Click on Settings Icon
			generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
			accountPage.SettingsIcon.click();

			//Click on privacy policy
			generalFunctions.isElementPresent(accountPage.privacy_icon, 90);
			accountPage.privacy_icon.click();
			//Thread.sleep(15000);
			generalFunctions.isElementPresent(accountPage.PageTitle, 90);
			String Page = accountPage.PageTitle.getText();
			System.out.println(Page);
			if(Page.contains("Privacy policy"))
			{
				test.log(Status.PASS, "Privacy policy page displayed");
			}
			else
			{
				test.log(Status.FAIL, "Privacy policy page Not Displayed");
				Assert.fail("Privacy policy page Not Displayed");
			}	

			//accountPage.back_navigate.click();

			//driver.closeApp();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			//driver.closeApp();
			Assert.fail(e.getMessage());
		}
	}	


	@Test
	public void TC_A_P_018(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Edit Profile");
		test.info("Validate the logout page");
		test.assignCategory("Account");
		System.out.println(TC_Method);		
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{

			driver.activateApp("com.maf.sharesit");
			Thread.sleep(5000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();

			//Click on Settings Icon
			generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
			accountPage.SettingsIcon.click();

			generalFunctions.ScrollDown("Log out");
			//Click on logout
			generalFunctions.isElementPresent(accountPage.logout_icon, 90);
			accountPage.logout_icon.click();
			//Thread.sleep(15000);
			generalFunctions.isElementPresent(accountPage.logout_pos, 90);
			accountPage.logout_pos.click();
			//	Thread.sleep(15000);
			generalFunctions.isElementPresent(accountPage.SignIn, 90);
			String Page = accountPage.SignIn.getText();
			System.out.println(Page);
			if(Page.contains("Already have an account? Sign In"))
			{
				test.log(Status.PASS, "logout successfull");
			}
			else
			{
				test.log(Status.FAIL, "logout unsuccessfull");
				Assert.fail("log out unsuccessfull");
			}
			//driver.closeApp();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			//driver.closeApp();
			Assert.fail(e.getMessage());
		}
	}	


	@Test	
	public void TC_A_P_019(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Edit Profile");
		test.info("Validate the login page");
		test.assignCategory("Account");
		System.out.println(TC_Method);		
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();
		String FirstName=map.get("FirstName").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{

			driver.activateApp("com.maf.sharesit");
			Thread.sleep(5000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);
			Thread.sleep(15000);

			String Page = accountPage.relogin.getText();
			System.out.println(Page);
			if(Page.contains("Hi"))
			{
				test.log(Status.PASS, "login successfull");
			}
			else
			{
				test.log(Status.FAIL, "login unsuccessfull");
				Assert.fail("login unsuccessfull");
			}		
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC_A_P_020(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Cancel Logout");
		test.info("Validate the logout page is present After Cancel");
		test.assignCategory("Account");

		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInPage signInPage = new SignInPage(driver);

		try
		{

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);
			//Thread.sleep(10000);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();

			//Click on Settings Icon
			generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
			accountPage.SettingsIcon.click();

			//Click on logout
			generalFunctions.ScrollDown("Log out");
			generalFunctions.isElementPresent(accountPage.logout_icon, 90);
			accountPage.logout_icon.click();
			//Thread.sleep(6000);

			//Verify Message pop up displayed
			generalFunctions.isElementPresent(accountPage.LogoutDescription, 90);
			String LogoutConfirmationMessage = accountPage.LogoutDescription.getText();
			System.out.println(LogoutConfirmationMessage);
			if(LogoutConfirmationMessage.contains("Are you sure you want to log out of SHARE?"))
			{
				test.log(Status.PASS, "Logout Pop Up Message Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Logout Pop Up Message Not Displayed");
				Assert.fail("Logout Popoup Message Not Displayed");
			}	

			//Verify Logout Confirm and cancel button is present
			if(accountPage.logout_pos.isDisplayed()==true)
			{
				test.log(Status.PASS, "Logout Confirm Button is Present");		
			}
			else
			{
				test.log(Status.FAIL, "Logout Confirm Button is Not Present");
				Assert.fail("Logout Confirm Button is Not Present");
			}

			if(accountPage.logout_neg.isDisplayed()==true)
			{
				test.log(Status.PASS, "Logout Cancel Button is Present");		
			}
			else
			{
				test.log(Status.FAIL, "Logout Cancel Button is Not Present");
				Assert.fail("Logout Cancel Button is Not Present");
			}

			accountPage.logout_neg.click();
			Thread.sleep(3000);

			//Verify Logout page is still present

			if(accountPage.logout_icon.isDisplayed()==true)
			{
				test.log(Status.PASS, "User is not logged out of the application");
			}
			else
			{
				test.log(Status.FAIL, "User is logged out of the application");
				Assert.fail("User is logged out of the application");
			}	
			
			//click back
			accountPage.BackButton.click();
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}	

	//TC_A_P_021
	@Test
	public void TC_A_P_021(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Member can click on About");
		test.info("Validate the Member can click on About page from Account tab");
		test.assignCategory("Account");

		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);
			//Thread.sleep(10000);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();

			//Click on Settings Icon
			generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
			accountPage.SettingsIcon.click();

			//Click on About	
			generalFunctions.ScrollDown("Log out");
			generalFunctions.isElementPresent(accountPage.Aboutclick, 90);
			accountPage.Aboutclick.click();
			Thread.sleep(5000);

			//Verify About Content is Present
			if(accountPage.Aboutcontent.isDisplayed()==true)
			{
				test.log(Status.PASS, "About Content Of Application is Displayed");		
			}
			else
			{
				test.log(Status.FAIL, "About Content Of Application is Not Displayed");
				Assert.fail("About Content Of Application is Not Displayed");
			}
			
			//click back
			accountPage.BackButton.click();
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	/*
	@Test
	public void TC_A_P_22(Method method) throws Exception
	{

		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Settings");
		test.info("Verify user is able to add new card as payment method by entering wrong transaction amount");
		test.assignCategory("Account");

		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("Password").toString();
		String CardNumber=map.get("CardNumber").toString();
		String NameOnCard =map.get("NameOnCard").toString();
		String ExpiryDate=map.get("ExpiryDate").toString();
		String Cvv =map.get("Cvv").toString();
		String TransactionAmount="2";
		String ValidTransactionAmount=map.get("TransactionAmount").toString();


		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{

			driver.activateApp("com.maf.sharesit");
			Thread.sleep(5000);


			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			accountPage.AccountIcon.click();
			Thread.sleep(2000);

			try
			{
				//Click Stop Tutorial
				if(registrationPage.StopTutorialElement.isDisplayed()==true)
				{
					registrationPage.StopTutorialElement.click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					//Click Got It
					registrationPage.GotItElement.click();
				}
			}
			catch(Exception x)
			{
				System.out.println("Stop Tutorial Not Displayed");
			}
			Thread.sleep(8000);

			//Click on Settings Icon
			accountPage.SettingsIcon.click();
			Thread.sleep(15000);

			//Click on Payment Methods
			accountPage.PaymentMethods.click();
			Thread.sleep(15000);

			//Verify Payment methods page Displayed
			String Page= accountPage.PageTitle.getText();
			System.out.println(Page);
			if(Page.contains("Payment methods"))
			{
				test.log(Status.PASS, "Payment methods page displayed");
			}
			else
			{
				test.log(Status.FAIL, "Payment methods page Not Displayed");
				Assert.fail("Payment methods page Not Displayed");
			}	

			try
			{

				if(accountPage.AddCard.isDisplayed()==true)
				{
					test.log(Status.PASS, "Add Credit or Debit Card option Displayed");
				}
			}
			catch(Exception e)
			{
				test.log(Status.FAIL, "Add Credit or Debit Card option Not Displayed");
				Assert.fail("Add Credit or Debit Card option Not Displayed");
			}


			//Click on Add Credit or Debit Card option
			accountPage.AddCard.click();
			Thread.sleep(15000);

			//Verify Add Payment method page displayed
			String AddPaymentmethodPage= accountPage.PageTitle.getText();
			System.out.println(AddPaymentmethodPage);
			if(AddPaymentmethodPage.contains("Add payment method"))
			{
				test.log(Status.PASS, "Add payment method page Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Add payment method page Not Displayed");
				Assert.fail("Add payment method page Not Displayed");
			}	

			//Enter Card Number
			accountPage.CardNumber.setValue(CardNumber);
			Thread.sleep(5000);

			//Enter Name on Card
			accountPage.NameOnCard.sendKeys(NameOnCard);

			//Enter Expiry date
			accountPage.Expiry.setValue(ExpiryDate);
			Thread.sleep(5000);

			//Enter CVV
			accountPage.CVV.sendKeys(Cvv);

			//Click Save Card
			accountPage.SaveCard.click();
			Thread.sleep(10000);		

			//Verify Verify Card Page page displayed
			String VerifyCardPage= accountPage.PageTitle.getText();
			System.out.println(VerifyCardPage);
			if(VerifyCardPage.contains("Verify card"))
			{
				test.log(Status.PASS, "Verify Card page Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Verify Card page Not Displayed");
				Assert.fail("Verify Card page Not Displayed");
			}	

			//Verify the Transaction Amount Field displayed
			try
			{
				if(accountPage.TransactionAmount.isDisplayed()==true)
				{
					test.log(Status.PASS, "Transaction Amount Field Displayed");
				}
			}
			catch(Exception e)
			{
				test.log(Status.FAIL, "Transaction Amount Field Not Displayed");
				Assert.fail("Transaction Amount Field Not Displayed");
			}

			//Enter transaction amount
			accountPage.TransactionAmount.setValue(TransactionAmount);

			//Verify Information Text
			String Informations= accountPage.InformationText.getText();
			System.out.println(Informations);
			if(Informations.contains("To ensure the security of your SHARE Wallet, we have deducted a small amount from the card that you have just added."))
			{
				test.log(Status.PASS, "Verify Card Information Text Displayed and verified successfully");
			}
			else
			{
				test.log(Status.FAIL, "Verify Card Information Text Not Displayed Or Wrong Message Displayed");
				Assert.fail("Verify Card Information Text Not Displayed Or Wrong Message Displayed");
			}	

			//click submit
			accountPage.SubmitTransactionAmount.click();
			Thread.sleep(5000);

			//verify the error message
			String error_message=accountPage.err_status.getText();
			System.out.println(error_message);
			if(error_message.contains("incorrect verification amount"))
			{
				test.log(Status.PASS, "Error message displayed for Incorrect verification amount");
			}
			else
			{
				test.log(Status.FAIL, "Error message not displayed for Incorrect verification amount");
				Assert.fail("Error message not displayed for Incorrect verification amount");
			}

			//dependancy for TC_A_P_026
			//Enter Amount
			accountPage.TransactionAmount.clear();
			accountPage.TransactionAmount.sendKeys(ValidTransactionAmount);

			//Verify the submit button
			if(accountPage.SubmitTransactionAmount.isEnabled()==true)
			{
				test.log(Status.PASS, "Submit Button is Enabled after entering Transaction Amount");
			}
			else
			{
				test.log(Status.FAIL, "Submit Button is Disabled after entering Transaction Amount");
				Assert.fail("Submit Button is Disabled after entering Transaction Amount");
			}

			//Click Submit
			accountPage.SubmitTransactionAmount.click();
			Thread.sleep(15000);

			String PMPage1= accountPage.PageTitle.getText();
			System.out.println(PMPage1);
			if(PMPage1.contains("Payment methods"))
			{
				test.log(Status.PASS, "Payment methods page displayed");
			}
			else
			{
				test.log(Status.FAIL, "Payment methods page Not Displayed");
				Assert.fail("Payment methods page Not Displayed");
			}

			System.out.println("Transaction amount submitted and card verified");

			test.log(Status.PASS, "Flow Completed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			//driver.closeApp();
		}			
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage()).addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			//driver.closeApp();
			Assert.fail(e.getMessage());
		}
	}
	 */

	@Test
	public void TC_A_P_022(Method method) throws Exception
	{

		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Settings");
		test.info("Verify user is able to add new card as payment method by entering wrong transaction amount");
		test.assignCategory("Account");

		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("Password").toString();
		String CardNumber=map.get("CardNumber").toString();
		String NameOnCard =map.get("NameOnCard").toString();
		String ExpiryDate=map.get("ExpiryDate").toString();
		String Cvv =map.get("Cvv").toString();
		String TransactionAmount="2";
		String ValidTransactionAmount=map.get("TransactionAmount").toString();


		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		SignInPage signInPage = new SignInPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();

		try
		{

			driver.activateApp("com.maf.sharesit");
			Thread.sleep(5000);


			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();
			Thread.sleep(2000);

			try
			{
				//Click Stop Tutorial
				if(registrationPage.StopTutorialElement.isDisplayed()==true)
				{
					registrationPage.StopTutorialElement.click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					//Click Got It
					registrationPage.GotItElement.click();
				}
			}
			catch(Exception x)
			{
				System.out.println("Stop Tutorial Not Displayed");
			}
			//	Thread.sleep(8000);

			//Click on Settings Icon
			generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
			accountPage.SettingsIcon.click();
			//Thread.sleep(15000);

			//Click on Payment Methods
			generalFunctions.isElementPresent(accountPage.PaymentMethods, 90);
			accountPage.PaymentMethods.click();
			Thread.sleep(10000);

			//Verify Payment methods page Displayed
			generalFunctions.isElementPresent(accountPage.PageTitle, 90);
			String Page= accountPage.PageTitle.getText();
			System.out.println(Page);
			if(Page.contains("Payment methods"))
			{
				test.log(Status.PASS, "Payment methods page displayed");
			}
			else
			{
				test.log(Status.FAIL, "Payment methods page Not Displayed");
				Assert.fail("Payment methods page Not Displayed");
			}	

			try
			{

				if(accountPage.AddCard.isDisplayed()==true)
				{
					test.log(Status.PASS, "Add Credit or Debit Card option Displayed");
				}
			}
			catch(Exception e)
			{
				test.log(Status.FAIL, "Add Credit or Debit Card option Not Displayed");
				Assert.fail("Add Credit or Debit Card option Not Displayed");
			}


			//Click on Add Credit or Debit Card option
			accountPage.AddCard.click();
			Thread.sleep(10000);

			//Verify Add Payment method page displayed
			generalFunctions.isElementPresent(accountPage.PageTitle, 90);
			String AddPaymentmethodPage= accountPage.PageTitle.getText();
			System.out.println(AddPaymentmethodPage);
			if(AddPaymentmethodPage.contains("Add payment method"))
			{
				test.log(Status.PASS, "Add payment method page Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Add payment method page Not Displayed");
				Assert.fail("Add payment method page Not Displayed");
			}	

			//Enter Card Number
			//accountPage.CardNumber.setValue(CardNumber);
			accountPage.CardNumber.click();
			Actions action = new Actions(driver);
			action.sendKeys(CardNumber).perform();
			Thread.sleep(4000);

			//Enter Name on Card
			accountPage.NameOnCard.sendKeys(NameOnCard);

			//Enter Expiry date
			//accountPage.Expiry.setValue(ExpiryDate);
			accountPage.Expiry.click();
			action.sendKeys(ExpiryDate).perform();
			Thread.sleep(4000);


			//Enter CVV
			accountPage.CVV.sendKeys(Cvv);

			String GetCardNumber=accountPage.CardNumber.getText();
			System.out.println(GetCardNumber);
			//String lastDigits = GetCardNumber.split(" ")[(CardNumber.split(" ")).length -1];
			String lastDigits = GetCardNumber.substring(GetCardNumber.lastIndexOf(' ') + 1);
			System.out.println(lastDigits);

			//Click Save Card
			accountPage.SaveCard.click();
			Thread.sleep(10000);		

			//Verify Verify Card Page page displayed
			String VerifyCardPage= accountPage.PageTitle.getText();
			System.out.println(VerifyCardPage);
			if(VerifyCardPage.contains("Verify card"))
			{
				test.log(Status.PASS, "Verify Card page Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Verify Card page Not Displayed");
				Assert.fail("Verify Card page Not Displayed");
			}	

			//Verify the Transaction Amount Field displayed
			try
			{
				if(accountPage.TransactionAmount.isDisplayed()==true)
				{
					test.log(Status.PASS, "Transaction Amount Field Displayed");
				}
			}
			catch(Exception e)
			{
				test.log(Status.FAIL, "Transaction Amount Field Not Displayed");
				Assert.fail("Transaction Amount Field Not Displayed");
			}

			//Enter transaction amount
			accountPage.TransactionAmount.setValue(TransactionAmount);

			//Verify Information Text
			String Informations= accountPage.InformationText.getText();
			System.out.println(Informations);
			if(Informations.contains("To ensure the security of your SHARE Wallet, we have deducted a small amount from the card that you have just added."))
			{
				test.log(Status.PASS, "Verify Card Information Text Displayed and verified successfully");
			}
			else
			{
				test.log(Status.FAIL, "Verify Card Information Text Not Displayed Or Wrong Message Displayed");
				Assert.fail("Verify Card Information Text Not Displayed Or Wrong Message Displayed");
			}	

			//click submit
			accountPage.SubmitTransactionAmount.click();
			//Thread.sleep(5000);

			//verify the error message
			String error_message=accountPage.err_status.getText();
			System.out.println(error_message);
			if(error_message.contains("incorrect verification amount"))
			{
				test.log(Status.PASS, "Error message displayed for Incorrect verification amount");
			}
			else
			{
				test.log(Status.FAIL, "Error message not displayed for Incorrect verification amount");
				Assert.fail("Error message not displayed for Incorrect verification amount");
			}


			//dependancy for TC_A_P_026
			//click try again
			generalFunctions.isElementPresent(accountPage.TryAgainButton, 90);
			accountPage.TryAgainButton.click();
			//Thread.sleep(4000);

			//Enter Amount
			generalFunctions.isElementPresent(accountPage.TransactionAmount, 90);
			accountPage.TransactionAmount.clear();
			accountPage.TransactionAmount.sendKeys(ValidTransactionAmount);

			//Verify the submit button
			if(accountPage.SubmitTransactionAmount.isEnabled()==true)
			{
				test.log(Status.PASS, "Submit Button is Enabled after entering Transaction Amount");
			}
			else
			{
				test.log(Status.FAIL, "Submit Button is Disabled after entering Transaction Amount");
				Assert.fail("Submit Button is Disabled after entering Transaction Amount");
			}

			//Click Submit
			accountPage.SubmitTransactionAmount.click();
			Thread.sleep(15000);

			String PMPage1= accountPage.PageTitle.getText();
			System.out.println(PMPage1);
			if(PMPage1.contains("Payment methods"))
			{
				test.log(Status.PASS, "Payment methods page displayed");
			}
			else
			{
				test.log(Status.FAIL, "Payment methods page Not Displayed");
				Assert.fail("Payment methods page Not Displayed");
			}

			System.out.println("Transaction amount submitted and card verified");

			test.log(Status.PASS, "Flow Completed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			//driver.closeApp();
			
			//click back
			accountPage.BackButton.click();
			Thread.sleep(5000);
			
			//click back
			accountPage.BackButton.click();
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
		}			
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage()).addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			//driver.closeApp();
			Assert.fail(e.getMessage());
		}
	}


	@Test
	public void TC_A_P_023(Method method) throws Exception
	{

		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Settings");
		test.info("payment method  without providing mandatory fields");
		test.assignCategory("Account");

		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("Password").toString();
		String CardNumber=map.get("CardNumber").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{

			driver.activateApp("com.maf.sharesit");
			Thread.sleep(5000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();
			Thread.sleep(2000);

			try
			{
				//Click Stop Tutorial
				if(registrationPage.StopTutorialElement.isDisplayed()==true)
				{
					registrationPage.StopTutorialElement.click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					//Click Got It
					registrationPage.GotItElement.click();
				}
			}
			catch(Exception x)
			{
				System.out.println("Stop Tutorial Not Displayed");
			}
			Thread.sleep(8000);
			//Click on Settings Icon
			accountPage.SettingsIcon.click();
			Thread.sleep(5000);

			//Click on Payment Methods
			generalFunctions.isElementPresent(accountPage.PaymentMethods, 90);
			accountPage.PaymentMethods.click();
			Thread.sleep(10000);

			//Verify Payment methods page Displayed
			generalFunctions.isElementPresent(accountPage.PageTitle, 90);
			String Page= accountPage.PageTitle.getText();
			System.out.println(Page);
			if(Page.contains("Payment methods"))
			{
				test.log(Status.PASS, "Payment methods page displayed");
			}
			else
			{
				test.log(Status.FAIL, "Payment methods page Not Displayed");
				Assert.fail("Payment methods page Not Displayed");
			}	

			try
			{
				if(accountPage.AddCard.isDisplayed())
				{
					test.log(Status.PASS, "Add Credit or Debit Card option Displayed");
				}
			}
			catch(Exception e)
			{
				test.log(Status.FAIL, "Add Credit or Debit Card option Not Displayed");
				Assert.fail("Add Credit or Debit Card option Not Displayed");
			}			

			//Click on Add Credit or Debit Card option
			accountPage.AddCard.click();
			Thread.sleep(10000);

			//Verify Add Payment method page displayed
			generalFunctions.isElementPresent(accountPage.PageTitle, 90);
			String AddPaymentmethodPage= accountPage.PageTitle.getText();
			System.out.println(AddPaymentmethodPage);
			if(AddPaymentmethodPage.contains("Add payment method"))
			{
				test.log(Status.PASS, "Add payment method page Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Add payment method page Not Displayed");
				Assert.fail("Add payment method page Not Displayed");
			}	

			//Enter Card Number
			//accountPage.CardNumber.setValue(CardNumber);
			accountPage.CardNumber.click();
			Actions action = new Actions(driver);
			action.sendKeys(CardNumber).perform();
			Thread.sleep(4000);

			//verify card is disabled								
			if(accountPage.SaveCard.isEnabled() == false)
			{  
				test.log(Status.PASS, "Save Card button is Disabled when mandatory fields are not entered");
			}

			else
			{
				test.log(Status.FAIL, "Save Card button is Enabled when mandatory fields are not entered");
				Assert.fail("Save Card button is Enabled when mandatory fields are not entered");
			}	

			test.log(Status.PASS, "Flow Completed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			//driver.closeApp();
		}

		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage()).addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			//driver.closeApp();
			Assert.fail(e.getMessage());
		}
	}



	@Test
	public void TC_A_P_024(Method method) throws Exception
	{

		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Settings");
		test.info(" Payment method  with card number more than 16 digit");
		test.assignCategory("Account");

		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("Password").toString();
		String CardNumber = "51111111111111118";


		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{
			driver.activateApp("com.maf.sharesit");
			Thread.sleep(5000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();
			Thread.sleep(2000);

			try
			{
				//Click Stop Tutorial
				if(registrationPage.StopTutorialElement.isDisplayed()==true)
				{
					registrationPage.StopTutorialElement.click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					//Click Got It
					registrationPage.GotItElement.click();
				}
			}
			catch(Exception x)
			{
				System.out.println("Stop Tutorial Not Displayed");
			}
			//Thread.sleep(8000);

			//Click on Settings Icon
			generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
			accountPage.SettingsIcon.click();
			//Thread.sleep(15000);

			//Click on Payment Methods
			generalFunctions.isElementPresent(accountPage.PaymentMethods, 90);
			accountPage.PaymentMethods.click();
			Thread.sleep(10000);

			//Verify Payment methods page Displayed
			generalFunctions.isElementPresent(accountPage.PageTitle, 90);
			String Page = accountPage.PageTitle.getText();
			System.out.println(Page);
			if(Page.contains("Payment methods"))
			{
				test.log(Status.PASS, "Payment methods page displayed");
			}
			else
			{
				test.log(Status.FAIL, "Payment methods page Not Displayed");
				Assert.fail("Payment methods page Not Displayed");
			}	

			try
			{
				if(accountPage.AddCard.isDisplayed())
				{
					test.log(Status.PASS, "Add Credit or Debit Card option Displayed");
				}
			}
			catch(Exception e)
			{
				test.log(Status.FAIL, "Add Credit or Debit Card option Not Displayed");
				Assert.fail("Add Credit or Debit Card option Not Displayed");
			}

			//Click on Add Credit or Debit Card option
			accountPage.AddCard.click();
			Thread.sleep(15000);

			//Verify Add Payment method page displayed
			String AddPaymentmethodPage= accountPage.PageTitle.getText();
			System.out.println(AddPaymentmethodPage);
			if(AddPaymentmethodPage.contains("Add payment method"))
			{
				test.log(Status.PASS, "Add payment method page Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Add payment method page Not Displayed");
				Assert.fail("Add payment method page Not Displayed");
			}	

			//Dimension card_size=accountPage.CardNumber.getSize();
			//Enter Card Number
			//accountPage.CardNumber.setValue(CardNumber);
			accountPage.CardNumber.click();
			Actions action = new Actions(driver);
			action.sendKeys(CardNumber).perform();
			Thread.sleep(5000);

			String card_size = accountPage.CardNumber.getText().replace(" ", "");								
			System.out.println(card_size);
			int length=card_size.length();
			System.out.println(length);

			if(length==16)
			{
				test.log(Status.PASS, "Application not allowed user to enter card number more than 16 digit");

			}			
			else
			{				
				test.log(Status.FAIL, "Application allowed user to enter card number more than 16 digit");
				Assert.fail("Application allowed user to enter card number more than 16 digit");				
			}

			test.log(Status.PASS, "Flow Completed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			//driver.closeApp();
		}			
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage()).addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			//driver.closeApp();
			Assert.fail(e.getMessage());
		}
	}



	@Test
	public void TC_A_P_025(Method method) throws Exception
	{

		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Settings");
		test.info("Payment method with card number less than 16 digit");
		test.assignCategory("Account");

		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("Password").toString();
		String CardNumber="511111111111118";

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{

			driver.activateApp("com.maf.sharesit");
			Thread.sleep(5000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();
			Thread.sleep(2000);

			try
			{
				//Click Stop Tutorial
				if(registrationPage.StopTutorialElement.isDisplayed()==true)
				{
					registrationPage.StopTutorialElement.click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					//Click Got It
					registrationPage.GotItElement.click();
				}
			}
			catch(Exception x)
			{
				System.out.println("Stop Tutorial Not Displayed");
			}
			//Thread.sleep(8000);

			//Click on Settings Icon
			generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
			accountPage.SettingsIcon.click();
			//Thread.sleep(15000);

			//Click on Payment Methods
			generalFunctions.isElementPresent(accountPage.PaymentMethods, 90);
			accountPage.PaymentMethods.click();
			Thread.sleep(10000);

			//Verify Payment methods page Displayed
			generalFunctions.isElementPresent(accountPage.PageTitle, 90);
			String Page= accountPage.PageTitle.getText();
			System.out.println(Page);
			if(Page.contains("Payment methods"))
			{
				test.log(Status.PASS, "Payment methods page displayed");
			}
			else
			{
				test.log(Status.FAIL, "Payment methods page Not Displayed");
				Assert.fail("Payment methods page Not Displayed");
			}	

			try
			{
				if(accountPage.AddCard.isDisplayed())
				{
					test.log(Status.PASS, "Add Credit or Debit Card option Displayed");
				}
			}
			catch(Exception e)
			{
				test.log(Status.FAIL, "Add Credit or Debit Card option Not Displayed");
				Assert.fail("Add Credit or Debit Card option Not Displayed");
			}

			//Click on Add Credit or Debit Card option
			accountPage.AddCard.click();
			Thread.sleep(10000);

			//Verify Add Payment method page displayed
			generalFunctions.isElementPresent(accountPage.PageTitle, 90);
			String AddPaymentmethodPage= accountPage.PageTitle.getText();
			System.out.println(AddPaymentmethodPage);
			if(AddPaymentmethodPage.contains("Add payment method"))
			{
				test.log(Status.PASS, "Add payment method page Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Add payment method page Not Displayed");
				Assert.fail("Add payment method page Not Displayed");
			}	

			//Enter Card Number			
			//accountPage.CardNumber.setValue(CardNumber);
			accountPage.CardNumber.click();
			Actions action = new Actions(driver);
			action.sendKeys(CardNumber).perform();
			Thread.sleep(4000);
			Thread.sleep(5000);
			accountPage.NameOnCard.click();
			accountPage.CardNumber.click();

			//verify the error message
			String invalid_text = accountPage.Invalid.getText();
			System.out.println(invalid_text);
			if(invalid_text.contains("Invalid card"))
			{
				test.log(Status.PASS, "Error message displayed forinvalid Card number");
			}
			else
			{
				test.log(Status.FAIL, "Error message not displayed for invalid Card number");
				Assert.fail("Error message not displayed for invalid Card number");
			}							

			test.log(Status.PASS, "Flow Completed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			//driver.closeApp();
		}			
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage()).addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			//	driver.closeApp();
			Assert.fail(e.getMessage());
		}
	}



	@Test
	public void TC_A_P_026(Method method) throws Exception
	{

		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Settings");
		test.info("Verify user is able to add a card which is already added to share app");
		test.assignCategory("Account");

		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("Password").toString();
		String CardNumber=map.get("CardNumber").toString();
		String NameOnCard =map.get("NameOnCard").toString();
		String ExpiryDate=map.get("ExpiryDate").toString();
		String Cvv =map.get("Cvv").toString();


		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{

			driver.activateApp("com.maf.sharesit");
			Thread.sleep(5000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();
			Thread.sleep(2000);

			try
			{
				//Click Stop Tutorial
				if(registrationPage.StopTutorialElement.isDisplayed()==true)
				{
					registrationPage.StopTutorialElement.click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					//Click Got It
					registrationPage.GotItElement.click();
				}
			}
			catch(Exception x)
			{
				System.out.println("Stop Tutorial Not Displayed");
			}
			//Thread.sleep(8000);

			//Click on Settings Icon
			generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
			accountPage.SettingsIcon.click();
			//Thread.sleep(15000);

			//Click on Payment Methods
			generalFunctions.isElementPresent(accountPage.PaymentMethods, 90);
			accountPage.PaymentMethods.click();
			Thread.sleep(10000);

			//Verify Payment methods page Displayed
			generalFunctions.isElementPresent(accountPage.PageTitle, 90);
			String Page= accountPage.PageTitle.getText();
			System.out.println(Page);
			if(Page.contains("Payment methods"))
			{
				test.log(Status.PASS, "Payment methods page displayed");
			}
			else
			{
				test.log(Status.FAIL, "Payment methods page Not Displayed");
				Assert.fail("Payment methods page Not Displayed");
			}	

			try
			{
				if(accountPage.AddCard.isDisplayed())
				{
					test.log(Status.PASS, "Add Credit or Debit Card option Displayed");
				}
			}
			catch(Exception e)
			{
				test.log(Status.FAIL, "Add Credit or Debit Card option Not Displayed");
				Assert.fail("Add Credit or Debit Card option Not Displayed");	
			}

			//Click on Add Credit or Debit Card option
			accountPage.AddCard.click();
			Thread.sleep(10000);

			//Verify Add Payment method page displayed
			generalFunctions.isElementPresent(accountPage.PageTitle, 90);
			String AddPaymentmethodPage= accountPage.PageTitle.getText();
			System.out.println(AddPaymentmethodPage);
			if(AddPaymentmethodPage.contains("Add payment method"))
			{
				test.log(Status.PASS, "Add payment method page Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Add payment method page Not Displayed");
				Assert.fail("Add payment method page Not Displayed");
			}	

			//Enter Card Number
			//accountPage.CardNumber.setValue(CardNumber);
			accountPage.CardNumber.click();
			Actions action = new Actions(driver);
			action.sendKeys(CardNumber).perform();
			Thread.sleep(4000);

			//Enter Name on Card
			accountPage.NameOnCard.sendKeys(NameOnCard);

			//Enter Expiry date
			//accountPage.Expiry.setValue(ExpiryDate);
			accountPage.Expiry.click();
			action.sendKeys(ExpiryDate).perform();
			Thread.sleep(4000);

			//Enter CVV
			accountPage.CVV.sendKeys(Cvv);

			String GetCardNumber=accountPage.CardNumber.getText();
			System.out.println(GetCardNumber);
			//String lastDigits = GetCardNumber.split(" ")[(CardNumber.split(" ")).length -1];
			String lastDigits = GetCardNumber.substring(GetCardNumber.lastIndexOf(' ') + 1);
			System.out.println(lastDigits);

			//Click Save Card
			accountPage.SaveCard.click();
			Thread.sleep(5000);	

			//verify the error message
			generalFunctions.isElementPresent(accountPage.error_message, 90);
			String err_message=accountPage.error_message.getText();
			System.out.println(err_message);
			if(err_message.contains("card has already been added"))
			{
				test.log(Status.PASS, "Error message displayed when try to  add a card which is already added");
			}
			else
			{
				test.log(Status.FAIL, "Error message not displayed when try to  add a card which is already added");
				Assert.fail("Error message not displayed when try to  add a card which is already added");
			}

			test.log(Status.PASS, "Flow Completed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			//driver.closeApp();
		}			
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage()).addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			//driver.closeApp();
			Assert.fail(e.getMessage());
		}
	}



	@Test
	public void TC_A_P_027(Method method) throws Exception
	{

		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Settings");
		test.info(" Payment method  with name on card in single word ");
		test.assignCategory("Account");

		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("Password").toString();
		String CardNumber=map.get("CardNumber").toString();
		String NameOnCard = "test";
		String ExpiryDate=map.get("ExpiryDate").toString();
		String Cvv =map.get("Cvv").toString();


		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{

			driver.activateApp("com.maf.sharesit");
			Thread.sleep(5000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();
			Thread.sleep(2000);

			try
			{
				//Click Stop Tutorial
				if(registrationPage.StopTutorialElement.isDisplayed()==true)
				{
					registrationPage.StopTutorialElement.click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					//Click Got It
					registrationPage.GotItElement.click();
				}
			}
			catch(Exception x)
			{
				System.out.println("Stop Tutorial Not Displayed");
			}
			//Thread.sleep(8000);

			//Click on Settings Icon
			generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
			accountPage.SettingsIcon.click();
			//Thread.sleep(15000);

			//Click on Payment Methods
			generalFunctions.isElementPresent(accountPage.PaymentMethods, 90);
			accountPage.PaymentMethods.click();
			Thread.sleep(10000);

			//Verify Payment methods page Displayed
			generalFunctions.isElementPresent(accountPage.PageTitle, 90);
			String Page= accountPage.PageTitle.getText();
			System.out.println(Page);
			if(Page.contains("Payment methods"))
			{
				test.log(Status.PASS, "Payment methods page displayed");
			}
			else
			{
				test.log(Status.FAIL, "Payment methods page Not Displayed");
				Assert.fail("Payment methods page Not Displayed");
			}	

			try
			{
				if(accountPage.AddCard.isDisplayed())
				{
					test.log(Status.PASS, "Add Credit or Debit Card option Displayed");
				}
			}
			catch(Exception e)
			{
				test.log(Status.FAIL, "Add Credit or Debit Card option Not Displayed");
				Assert.fail("Add Credit or Debit Card option Not Displayed");
			}

			//Click on Add Credit or Debit Card option
			accountPage.AddCard.click();
			Thread.sleep(15000);

			//Verify Add Payment method page displayed
			String AddPaymentmethodPage= accountPage.PageTitle.getText();
			System.out.println(AddPaymentmethodPage);
			if(AddPaymentmethodPage.contains("Add payment method"))
			{
				test.log(Status.PASS, "Add payment method page Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Add payment method page Not Displayed");
				Assert.fail("Add payment method page Not Displayed");
			}	

			//Enter Card Number
			//accountPage.CardNumber.setValue(CardNumber);
			accountPage.CardNumber.click();
			Actions action = new Actions(driver);
			action.sendKeys(CardNumber).perform();
			Thread.sleep(4000);
			//Thread.sleep(5000);

			//Enter Name on Card
			generalFunctions.isElementPresent(accountPage.NameOnCard, 90);
			accountPage.NameOnCard.click();
			accountPage.NameOnCard.sendKeys(NameOnCard);
			accountPage.NameOnCard.click();
			accountPage.CVV.click();
			//Thread.sleep(5000);

			//verify the error message	
			generalFunctions.isElementPresent(accountPage.Name_error, 90);
			String err_message=accountPage.Name_error.getText();
			System.out.println(err_message);
			if(err_message.contains("Invalid cardholder name"))
			{
				test.log(Status.PASS, "Error message displayed for Invalid card holder name");
			}
			else
			{
				test.log(Status.FAIL, "Error message not displayed for Invalid card holder name");
				Assert.fail("Error message not displayed for Invalid card holder name");
			}	

			test.log(Status.PASS, "Flow Completed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			//driver.closeApp();
		}			
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage()).addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			//driver.closeApp();
			Assert.fail(e.getMessage());
		}
	}



	@Test
	public void TC_A_P_028(Method method) throws Exception
	{

		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Settings");
		test.info(" Payment method  with wrong card expiry date");
		test.assignCategory("Account");

		String EmailAddress=map.get("UserName").toString();
		String Pass = map.get("Password").toString();
		String CardNumber=map.get("CardNumber").toString();
		String NameOnCard = map.get("NameOnCard").toString();
		String ExpiryDate = "1019";
		String Cvv = map.get("Cvv").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{


			driver.activateApp("com.maf.sharesit");
			Thread.sleep(5000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();
			Thread.sleep(2000);

			try
			{
				//Click Stop Tutorial
				if(registrationPage.StopTutorialElement.isDisplayed()==true)
				{
					registrationPage.StopTutorialElement.click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					//Click Got It
					registrationPage.GotItElement.click();
				}
			}
			catch(Exception x)
			{
				System.out.println("Stop Tutorial Not Displayed");
			}
			//Thread.sleep(8000);

			//Click on Settings Icon
			generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
			accountPage.SettingsIcon.click();
			//Thread.sleep(15000);

			//Click on Payment Methods
			generalFunctions.isElementPresent(accountPage.PaymentMethods, 90);
			accountPage.PaymentMethods.click();
			Thread.sleep(10000);

			//Verify Payment methods page Displayed
			generalFunctions.isElementPresent(accountPage.PageTitle, 90);
			String Page= accountPage.PageTitle.getText();
			System.out.println(Page);
			if(Page.contains("Payment methods"))
			{
				test.log(Status.PASS, "Payment methods page displayed");
			}
			else
			{
				test.log(Status.FAIL, "Payment methods page Not Displayed");
				Assert.fail("Payment methods page Not Displayed");
			}	

			try
			{
				if(accountPage.AddCard.isDisplayed())
				{
					test.log(Status.PASS, "Add Credit or Debit Card option Displayed");
				}
			}
			catch(Exception e)
			{
				test.log(Status.FAIL, "Add Credit or Debit Card option Not Displayed");
				Assert.fail("Add Credit or Debit Card option Not Displayed");
			}

			//Click on Add Credit or Debit Card option
			accountPage.AddCard.click();
			Thread.sleep(15000);

			//Verify Add Payment method page displayed
			String AddPaymentmethodPage= accountPage.PageTitle.getText();
			generalFunctions.isElementPresent(accountPage.CardNumber, 90);
			System.out.println(AddPaymentmethodPage);
			if(AddPaymentmethodPage.contains("Add payment method"))
			{
				test.log(Status.PASS, "Add payment method page Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Add payment method page Not Displayed");
				Assert.fail("Add payment method page Not Displayed");
			}	

			//Enter Card Number
			//accountPage.CardNumber.setValue(CardNumber);
			accountPage.CardNumber.click();
			Actions action = new Actions(driver);
			action.sendKeys(CardNumber).perform();
			Thread.sleep(4000);

			//Enter Name on Card
			generalFunctions.isElementPresent(accountPage.NameOnCard, 90);
			accountPage.NameOnCard.sendKeys(NameOnCard);
			//Thread.sleep(5000);

			//Enter Expiry date
			generalFunctions.isElementPresent(accountPage.Expiry, 90);
			//accountPage.Expiry.setValue(ExpiryDate);			
			accountPage.Expiry.click();
			action.sendKeys(ExpiryDate).perform();
			Thread.sleep(4000);

			//Enter CVV
			generalFunctions.isElementPresent(accountPage.CVV, 90);
			accountPage.CVV.click();
			//Thread.sleep(2000);	

			//verify the error message
			generalFunctions.isElementPresent(accountPage.Expiry_error, 90);
			String err_message=accountPage.Expiry_error.getText();
			System.out.println(err_message);
			if(err_message.contains("Card expired"))
			{
				test.log(Status.PASS, "Error message displayed for Expiry");
			}
			else
			{
				test.log(Status.FAIL, "Error message not displayed for Expiry");
				Assert.fail("Error message not displayed for Expiry");
			}	

			test.log(Status.PASS, "Flow Completed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			//driver.closeApp();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage()).addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			//driver.closeApp();
			Assert.fail(e.getMessage());
		}
	}



	@Test
	public void TC_A_P_029(Method method) throws Exception
	{

		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Settings");
		test.info("Verify user is able to cancel the delete card by clicking on cancel button in Delete card pop over");
		test.assignCategory("Account");

		String EmailAddress = map.get("UserName").toString();
		String Pass = map.get("Password").toString();
		String CardNumber=map.get("CardNumber").toString();

		//String lastDigits = CardNumber.split(" ")[(CardNumber.split(" ")).length -1];
		String lastDigits=CardNumber.substring(CardNumber.length() - 4);
		
		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{


			driver.activateApp("com.maf.sharesit");
			Thread.sleep(5000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();
			Thread.sleep(2000);

			try
			{
				//Click Stop Tutorial
				if(registrationPage.StopTutorialElement.isDisplayed()==true)
				{
					registrationPage.StopTutorialElement.click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					//Click Got It
					registrationPage.GotItElement.click();
				}
			}
			catch(Exception x)
			{
				System.out.println("Stop Tutorial Not Displayed");
			}
			//Thread.sleep(8000);

			//Click on Settings Icon
			generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
			accountPage.SettingsIcon.click();
			//Thread.sleep(15000);

			//Click on Payment Methods
			generalFunctions.isElementPresent(accountPage.PaymentMethods, 90);
			accountPage.PaymentMethods.click();
			//Thread.sleep(15000);

			//Verify Payment methods page Displayed
			generalFunctions.isElementPresent(accountPage.PageTitle, 90);
			String Page1= accountPage.PageTitle.getText();
			System.out.println(Page1);
			if(Page1.contains("Payment methods"))
			{
				test.log(Status.PASS, "Payment methods page displayed");
			}
			else
			{
				test.log(Status.FAIL, "Payment methods page Not Displayed");
				Assert.fail("Payment methods page Not Displayed");
			}	

			//Long press on Card
			AccountFunctions.LongPress(accountPage.SelectCards(lastDigits));

			//Click Delete
			accountPage.Delete.click();
			//Thread.sleep(10000);
			generalFunctions.isElementPresent(accountPage.card_cancel, 90);
			accountPage.card_cancel.click();
			//Thread.sleep(10000);			

			//Verify Add Payment method page displayed
			generalFunctions.isElementPresent(accountPage.PageTitle, 90);
			String Page2= accountPage.PageTitle.getText();
			System.out.println(Page2);
			if(Page2.contains("Payment methods"))
			{
				test.log(Status.PASS, "Payment methods page displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Payment methods page Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
				Assert.fail("Payment methods page Not Displayed");
			}

			try
			{
				if(accountPage.SelectCards(lastDigits).isDisplayed()==true)
				{
					test.log(Status.PASS, "Card Not Deleted");				
				}			
			}
			catch(Exception x)
			{				
				test.log(Status.FAIL, "Card Deleted");
				Assert.fail("Card Deleted");
			}


			//Dependency for next run
			//Click Delete
			accountPage.Delete.click();
			Thread.sleep(10000);

			//Verify the delete confirmation
			String DeleteConfirmation = accountPage.Confrimation.getText();
			System.out.println(DeleteConfirmation);
			if(DeleteConfirmation.contains("Delete card"))
			{
				test.log(Status.PASS, "Delete card confirmation displayed");
			}
			else
			{
				test.log(Status.FAIL, "Delete card confirmation Not Displayed");
				Assert.fail("Delete card confirmation Not Displayed");
			}

			//Verify the delete confirmation
			String DeleteConfirmationMsg = accountPage.ConfrimationMessage.getText();
			System.out.println(DeleteConfirmationMsg);
			if(DeleteConfirmationMsg.contains("Are you sure you want to delete MasterCard ending in"))
			{
				test.log(Status.PASS, "Delete card confirmation message displayed");
			}
			else
			{
				test.log(Status.FAIL, "Delete card confirmation message Not Displayed");
				Assert.fail("Delete card confirmation message Not Displayed");
			}

			//Click Confirm 
			accountPage.confirm.click();
			Thread.sleep(15000);

			try
			{
				if(accountPage.SelectCards(lastDigits).isDisplayed()==true)
				{
					test.log(Status.FAIL, "Card Not Deleted");
					Assert.fail("Card Not Deleted");
				}			
			}
			catch(NoSuchElementException x)
			{
				test.log(Status.PASS, "Card Deleted");
			}

			test.log(Status.PASS, "Flow Completed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			//driver.closeApp();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage()).addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			//driver.closeApp();
			Assert.fail(e.getMessage());
		}
	}
	//**************************
	
	//New Feature_Sprint_20 to 23
	@Test
	public void TC_A_P_030(Method method) throws Exception{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Accounts:Share Gifting").assignCategory("Account");
		test.info("Verify the acces denied alert message is displayed on the share your points screen using invalid credentials");
		

		String EmailAddress = map.get("UserName").toString();
		String Pass = map.get("Password").toString();
		
		RegistrationPage registrationPage= new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInPage signInPage = new SignInPage(driver);
		HomePage homepage = new HomePage(driver);
	//	try
	//	{


			driver.activateApp("com.maf.sharesit");
			Thread.sleep(5000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
			accountPage.AccountIcon.click();
			Thread.sleep(2000);

			try
			{
				//Click Stop Tutorial
				if(registrationPage.StopTutorialElement.isDisplayed()==true)
				{
					registrationPage.StopTutorialElement.click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					//Click Got It
					registrationPage.GotItElement.click();
				}
			}
			catch(Exception x)
			{
				System.out.println("Stop Tutorial Not Displayed");
			}
			
			//Share Gifting to Back button click
			generalFunctions.isElementPresent(accountPage.accountgift, 90);
			accountPage.accountgift.click();
			generalFunctions.isElementPresent(registrationPage.NavigateBack, 90);
			registrationPage.NavigateBack.click();
			generalFunctions.isElementPresent(accountPage.accountgift, 90);
			test.log(Status.INFO, "Back button is Clickable");
			
			//Gifting and click Back button
			accountPage.accountgift.click();
			generalFunctions.isElementPresent(homepage.accessDenied, 90);
			if(homepage.accessDenied.isDisplayed()) {
				test.log(Status.PASS, "Access is denied due to invalid credentials alert is displayed");
				homepage.giftErrorDone.click();
			}else {
				test.log(Status.FAIL, "The Access denied alert is not displayed");
			}
	}
	
	//Retrieve My ClubCard
	@Test
	public void TC_A_P_031(Method method) throws Exception{
	
	String TC_Method = method.getName();
	test = extent.createTest(TC_Method);
	test.log(Status.INFO, "Settings:Retrieve My club Card").assignCategory("Account");
	test.info("Verify the error message is displayed for wrong card number");
	

	String EmailAddress=map.get("UserName").toString();
	String Pass = map.get("Password").toString();
	String CardNumber=map.get("CardNumber").toString();


	RegistrationPage registrationPage= new RegistrationPage(driver);
	AccountPage accountPage = new AccountPage(driver);
	RegistrationFunctions registrationFunctions= new RegistrationFunctions();
	SignInPage signInPage = new SignInPage(driver);
	SignInFunctions signInFunctions = new SignInFunctions();
	//try
	//{


		driver.activateApp("com.maf.sharesit");
		Thread.sleep(5000);

		generalFunctions.Logout();			
		Thread.sleep(5000);

		generalFunctions.isElementPresent(registrationPage.onboardScreen, 90);
		registrationFunctions.onboardScreenDisplayed(registrationPage);			
		generalFunctions.isElementPresent(signInPage.signinPresent, 90);
		signInFunctions.SignInUser(signInPage);

		//Click on Account Icon
		generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
		accountPage.AccountIcon.click();
		Thread.sleep(2000);

		try
		{
			//Click Stop Tutorial
			if(registrationPage.StopTutorialElement.isDisplayed()==true)
			{
				registrationPage.StopTutorialElement.click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				//Click Got It
				registrationPage.GotItElement.click();
			}
		}
		catch(Exception x)
		{
			System.out.println("Stop Tutorial Not Displayed");
		}
		//Thread.sleep(8000);

		//Click on Settings Icon
		generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
		accountPage.SettingsIcon.click();
		//Thread.sleep(15000);

		//Click on Retrieve My club card and back button
		generalFunctions.isElementPresent(accountPage.linktoMyClub, 90);
		accountPage.linktoMyClub.click();
		Thread.sleep(10000);
		//Click on Back button
		generalFunctions.isElementPresent(registrationPage.NavigateBack, 90);
		registrationPage.NavigateBack.click();
		
		//Click on Retrieve My club card and back button
		generalFunctions.isElementPresent(accountPage.linktoMyClub, 90);
		accountPage.linktoMyClub.click();
		Thread.sleep(10000);
		generalFunctions.isElementPresent(accountPage.clubCardNumber, 90);
		accountPage.clubCardNumber.sendKeys(CardNumber);
		generalFunctions.isElementPresent(accountPage.clubCardNumberError, 90);
		if(accountPage.clubCardNumberError.isDisplayed()) {
			test.log(Status.PASS, "Error message displayed as Please enter a valid account number");
			if(accountPage.NextButton.isEnabled()) {
				test.log(Status.FAIL, "Next Button is Enabled");
			}else {
				test.log(Status.PASS, "NEXT button is disabled");
			}
		}else {
			test.log(Status.FAIL, "Error message NOT displayed ");
		}
	}
	
	}


