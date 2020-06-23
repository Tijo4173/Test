package com.share.testscript;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.share.functions.RegistrationFunctions;
import com.share.functions.SignInFunctions;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.AccountPage;
import com.share.objectrepository.FamilyPage;
import com.share.objectrepository.OffersPage;
import com.share.objectrepository.OnboardingPage;
import com.share.objectrepository.RegistrationPage;
import com.share.objectrepository.SignInPage;
import com.share.utility.Utilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class Onboarding extends DriverSetUp {

	@Test
	public void TC_Onboarding_001(Method method) throws IOException, Exception {

		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Onboarding Tutorial Screen");
		test.info("Onboarding");
		test.assignCategory("Onboarding");
		System.out.println(TC_Method);
		driver.resetApp();
		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		FamilyPage familyPage = new FamilyPage(driver);
		OffersPage offersPage = new OffersPage(driver);
		OnboardingPage onboardingPage = new OnboardingPage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		SignInFunctions signInFunctions = new SignInFunctions();

		driver.resetApp();
		Thread.sleep(5000);
		
		//SignIn
		registrationFunctions.onboardScreenDisplayed(registrationPage);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		signInFunctions.SignInUser(signInPage);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

		// Verify Onboarding screen displayed on Home
		
		generalFunctions.isElementPresent(onboardingPage.homeWelcome, 90);
		String OnboardWelcomeMsg = onboardingPage.homeWelcome.getText();
		System.out.println(OnboardWelcomeMsg);
		if(OnboardWelcomeMsg.contains("Welcome to SHARE"))
		{
			test.log(Status.PASS, "Welcome to SHARE Onboarding Tab Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));

		}
		else
		{
			test.log(Status.FAIL, "Welcome to SHARE Onboarding Tab not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			Assert.fail("Welcome to share title Onboarding not displayed");
		}
		generalFunctions.isElementPresent(onboardingPage.NumberCountTutorial, 90);
		String CountHome=onboardingPage.NumberCountTutorial.getText();
		char lastHome = CountHome.charAt(CountHome.length() - 1);	
		System.out.println("Home Onboarding Count is" + " " + lastHome);  
		int a=Integer.parseInt(String.valueOf(lastHome));  	
		System.out.println(a);
		//driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

		for (int i = 1; i<=a ; i++)
		{
			onboardingPage.GotitIcon.click();
			//driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			System.out.println(i);
		}

		//Verify onboarding screen displayed on Offers
		generalFunctions.isElementPresent(offersPage.offers, 90);
		offersPage.offers.click();
		//driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		generalFunctions.isElementPresent(onboardingPage.offersWelcome, 90);
		String OnboardWelcomeMsgOffers = onboardingPage.offersWelcome.getText();
		System.out.println(OnboardWelcomeMsgOffers);
		if(OnboardWelcomeMsgOffers.contains("SHARE Offers"))
		{
			test.log(Status.PASS, "Welcome to SHARE Onboarding Tab Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));	
		}
		else
		{
			test.log(Status.FAIL, "SHARE Offers not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			Assert.fail("SHARE Offers title Onboarding not displayed");
		}
		generalFunctions.isElementPresent(onboardingPage.NumberCountTutorialOffers, 90);
		String Countoffers =onboardingPage.NumberCountTutorialOffers.getText();
		//driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		char lastOffers = Countoffers.charAt(Countoffers.length() - 1);	
		System.out.println("Share Onboarding Count is" + " " + lastOffers);  
		int b=Integer.parseInt(String.valueOf(lastOffers));  	
		System.out.println(a);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		for (int i = 1; i<=b ; i++)
		{
			onboardingPage.GotitIcon.click();
			//driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			System.out.println(i);
		}

		//Verify onboarding screen displayed on Account
		generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
		accountPage.AccountIcon.click();
		generalFunctions.isElementPresent(onboardingPage.accountWelcome, 90);
		String OnboardWelcomeMsgAccount = onboardingPage.accountWelcome.getText();
		System.out.println(OnboardWelcomeMsgAccount);
		if(OnboardWelcomeMsgAccount.contains("Transaction History"))
		{
			test.log(Status.PASS, "Account Onboarding Tab Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));		
		}
		else
		{
			test.log(Status.FAIL, "Account Onboarding Tab not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			Assert.fail("Account title Onboarding not displayed");
		}
		generalFunctions.isElementPresent(onboardingPage.NumberCountTutorialOffers, 90);
		String CountAccount =onboardingPage.NumberCountTutorialOffers.getText();
		//driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		char lastAccount = CountAccount.charAt(CountAccount.length()-1);
		System.out.println("Account Onboarding Count is" + lastAccount);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		int c=Integer.parseInt(String.valueOf(lastAccount));  	
		System.out.println(a);
		//driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		for (int i = 1; i<=c ; i++)
		{
			onboardingPage.GotitIcon.click();
			//driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			System.out.println(i);
		}



		//Verify onboarding screen displayed on Family
		generalFunctions.isElementPresent(familyPage.FamilyGroupIcon, 90);
		familyPage.FamilyGroupIcon.click();
		//driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		generalFunctions.isElementPresent(onboardingPage.familyWelcome, 90);
		String OnboardWelcomeMsgFamily = onboardingPage.familyWelcome.getText();
		System.out.println(OnboardWelcomeMsgFamily);
		if(OnboardWelcomeMsgFamily.contains("Start by adding members"))
		{
			test.log(Status.PASS, "Family Group Onboarding Tab Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));		
		}
		else
		{
			test.log(Status.FAIL, "Family Group Onboarding Tab not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			Assert.fail("Family Group Onboarding Tab not Displayed");
		}
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		onboardingPage.GotitIcon.click();



		//Verify onboarding screen displayed on Settings
		generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
		accountPage.AccountIcon.click();
		generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
		accountPage.SettingsIcon.click();
		generalFunctions.isElementPresent(onboardingPage.settingsWelcome, 90);
		String OnboardWelcomeMsgSettings = onboardingPage.settingsWelcome.getText();
		System.out.println(OnboardWelcomeMsgSettings);
		if(OnboardWelcomeMsgSettings.contains("Add your card"))
		{
			test.log(Status.PASS, "Add your card Onboarding Tab Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));		
		}
		else
		{
			test.log(Status.FAIL, "Add your card Onboarding Tab not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			Assert.fail("Add your card Onboarding Tab not Displayed");
		}
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		generalFunctions.isElementPresent(onboardingPage.NumberCountTutorialOffers, 90);
		String Countsettings =onboardingPage.NumberCountTutorialOffers.getText();
		//driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		char lastSettings = Countsettings.charAt(Countsettings.length()-1);
		System.out.println("Settings Onboarding Count is" + lastSettings);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		int d=Integer.parseInt(String.valueOf(lastSettings));  	
		System.out.println(a);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		for (int i = 1; i<=d ; i++)
		{
			onboardingPage.GotitIcon.click();
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			System.out.println(i);
		}

	}


	@Test
	public void TC_Onboarding_02(Method method) throws IOException, Exception 
	{

		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Onboarding Screen Started");
		test.assignCategory("Onboarding");
		System.out.println(TC_Method);
		driver.resetApp();
		RegistrationPage registrationPage= new RegistrationPage(driver);
		SignInPage signInPage = new SignInPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		FamilyPage familyPage = new FamilyPage(driver);
		OffersPage offersPage = new OffersPage(driver);
		OnboardingPage onboardingPage = new OnboardingPage(driver);
		GeneralFunctions generalFunctions = new GeneralFunctions();
		RegistrationFunctions registrationFunctions = new RegistrationFunctions();
		SignInFunctions signInFunctions = new SignInFunctions();

		//driver.resetApp();
		//Thread.sleep(5000);
		
		//SignIn
		registrationFunctions.onboardScreenDisplayed(registrationPage);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		signInFunctions.SignInUser(signInPage);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);


		/**
		  On Boarding Home Page
		 **/			

		// Verify Onboarding screen displayed on Home
		String OnboardWelcomeMsg = onboardingPage.homeWelcome.getText();
		System.out.println(OnboardWelcomeMsg);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		if(OnboardWelcomeMsg.contains("Welcome to SHARE"))
		{
			test.log(Status.PASS, "Home Onboarding Tab Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));

		}
		else
		{
			test.log(Status.FAIL, "Home Onboarding Tab not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			Assert.fail("Home Onboarding Tab not Displayed");
		}
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);


		//Verify the next button is enabled in Home
		if(onboardingPage.Nexttutorial.isEnabled()==true)
		{
			test.log(Status.INFO, "Next icon is Present in Home");
			test.log(Status.PASS, "Changed to Next Tutorial Tab").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));		
		}
		else
		{
			test.log(Status.FAIL, "Not Changed to Next Tutorial Tab").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			Assert.fail("Not Changed to Next Tutorial Tab");
		}

		//Clcik Next On boarding icon
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		onboardingPage.Nexttutorial.click();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);


		//Verify the Previous button is enabled in Home
		if(onboardingPage.Prevtutorial.isEnabled()==true)
		{
			test.log(Status.INFO, "Previous icon is Present in Home");
			test.log(Status.PASS, "Changed to Previous Tutorial Tab in Home ").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));		
		}
		else
		{
			test.log(Status.FAIL, "Not Changed to Previous Tutorial Tab in Home").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			Assert.fail("Not Changed to Previous Tutorial Tab in Home");
		}


		//Click Previous On boarding icon
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		onboardingPage.Prevtutorial.click();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);


		//Get Tool tip Count
		String CountHome=onboardingPage.NumberCountTutorial.getText();
		char lastHome = CountHome.charAt(CountHome.length() - 1);	
		System.out.println("Home Onboarding Count is" + " " + lastHome); 
		int a=Integer.parseInt(String.valueOf(lastHome));  
		int aminus = a-1;

		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		for (int i = 1; i<=aminus ; i++)
		{
			onboardingPage.Nexttutorial.click();
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			System.out.println(i);
		}

		//click Got it icon once after the next icon is disabled
		onboardingPage.GotitIcon.click();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);


		/**
		  On Boarding Offers Page
		 **/			

		//Verify onboarding screen displayed on Offers Page
		offersPage.offers.click();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

		String OnboardWelcomeMsgOffers = onboardingPage.offersWelcome.getText();
		System.out.println(OnboardWelcomeMsgOffers);
		if(OnboardWelcomeMsgOffers.contains("SHARE Offers"))
		{
			test.log(Status.PASS, "Offers Onboarding Tab Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));	
		}
		else
		{
			test.log(Status.FAIL, "Offers Onboarding not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			Assert.fail("Offers Onboarding not Displayed");
		}
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);


		//Verify the next button is enabled in Offers
		if(onboardingPage.Nexttutorial.isEnabled()==true)
		{
			test.log(Status.INFO, "Next icon is Present in Offers");
			test.log(Status.PASS, "Changed to Next Tutorial Tab in Offers").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));		
		}
		else
		{
			test.log(Status.FAIL, "Not Changed to Next Tutorial Tab in Offers").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			Assert.fail("Not Changed to Next Tutorial Tab in Offers");
		}

		//Clcik Next On boarding icon
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		onboardingPage.Nexttutorial.click();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

		//Verify the Previous button is enabled in Home
		if(onboardingPage.Prevtutorial.isEnabled()==true)
		{
			test.log(Status.INFO, "Previous icon is Present in Offers");
			test.log(Status.PASS, "Changed to Previous Tutorial Tab in Offers").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));		
		}
		else
		{
			test.log(Status.FAIL, "Not Changed to Previous Tutorial Tab in Offers").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			Assert.fail("Not Changed to Previous Tutorial Tab in Offers");
		}

		//Click Previous On boarding icon
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		onboardingPage.Prevtutorial.click();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);


		//Get Tool tip Count in Offers
		String Countoffers =onboardingPage.NumberCountTutorialOffers.getText();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		char lastOffers = Countoffers.charAt(Countoffers.length() - 1);	
		System.out.println("Share Onboarding Count is" + " " + lastOffers);  
		int b=Integer.parseInt(String.valueOf(lastOffers));  	
		int bminus = b-1;
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

		for (int i = 1; i<=bminus ; i++)
		{
			onboardingPage.Nexttutorial.click();
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			System.out.println(i);
		}

		//click Got it icon once after the next icon is disabled
		onboardingPage.GotitIcon.click();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

		/**  
		  On Boarding Account Page
		 **/					

		//Verify onboarding screen displayed on Account
		accountPage.AccountIcon.click();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		String OnboardWelcomeMsgAccount = onboardingPage.accountWelcome.getText();
		System.out.println(OnboardWelcomeMsgAccount);
		if(OnboardWelcomeMsgAccount.contains("Transaction History"))
		{
			test.log(Status.PASS, "Account Onboarding Tab Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));		
		}
		else
		{
			test.log(Status.FAIL, "Account Onboarding Tab not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			Assert.fail("Account title Onboarding not displayed");
		}

		//Verify the next button is enabled in Account
		if(onboardingPage.Nexttutorial.isEnabled()==true)
		{
			test.log(Status.INFO, "Next icon is Present in Account");
			test.log(Status.PASS, "Changed to Next Tutorial Tab in Account").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));		
		}
		else
		{
			test.log(Status.FAIL, "Not Changed to Next Tutorial Tab in Account").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			Assert.fail("Not Changed to Next Tutorial Tab in Account");
		}

		//Clcik Next On boarding icon
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		onboardingPage.Nexttutorial.click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		//Verify the Previous button is enabled in Account
		if(onboardingPage.Prevtutorial.isEnabled()==true)
		{
			test.log(Status.INFO, "Previous icon is Present in Account");
			test.log(Status.PASS, "Changed to Previous Tutorial Tab in Account").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));		
		}
		else
		{
			test.log(Status.FAIL, "Not Changed to Previous Tutorial Tab in Account").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			Assert.fail("Not Changed to Previous Tutorial Tab in Account");
		}

		//Click Previous On boarding icon
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		onboardingPage.Prevtutorial.click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);


		//Get Tool tip count in Account 
		String CountAccount =onboardingPage.NumberCountTutorialOffers.getText();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		char lastAccount = CountAccount.charAt(CountAccount.length()-1);
		System.out.println("Account Onboarding Count is" + " " + lastAccount);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		int c=Integer.parseInt(String.valueOf(lastAccount));  
		int cminus = c-1;
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

		for (int i = 1; i<=cminus ; i++)
		{
			onboardingPage.Nexttutorial.click();
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			System.out.println(i);
		}

		//click Got it icon once after the next icon is disabled
		onboardingPage.GotitIcon.click();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

		/**  
		  On Boarding Family Page
		 **/					

		//Verify onboarding screen displayed on Family
		familyPage.FamilyGroupIcon.click();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

		String OnboardWelcomeMsgFamily = onboardingPage.familyWelcome.getText();
		System.out.println(OnboardWelcomeMsgFamily);
		if(OnboardWelcomeMsgFamily.contains("Start by adding members"))
		{
			test.log(Status.PASS, "Family Group Onboarding Tab Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));		
		}
		else
		{
			test.log(Status.FAIL, "Family Group Onboarding Tab not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			Assert.fail("Family Group Onboarding Tab not Displayed");
		}
		//driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		
		generalFunctions.isElementPresent(onboardingPage.GotitIcon, 90);
		onboardingPage.GotitIcon.click();
		
		/*try
		{
			if(onboardingPage.GotitIcon.isDisplayed())
			{
				onboardingPage.GotitIcon.click();
			}		
		}
		catch(Exception e)
		{
			
		}*/

		/**  
		  On Boarding Settings Page
		 **/	
		Thread.sleep(5000);
		//Verify onboarding screen displayed on Settings
		generalFunctions.isElementPresent(accountPage.AccountIcon, 90);
		accountPage.AccountIcon.click();
		Thread.sleep(2000);
		
		try
		{
			if(onboardingPage.GotitIcon.isDisplayed())
			{
				onboardingPage.GotitIcon.click();
			}		
		}
		catch(Exception e)
		{
			
		}

		generalFunctions.isElementPresent(accountPage.SettingsIcon, 90);
		accountPage.SettingsIcon.click();
		Thread.sleep(2000);

		generalFunctions.isElementPresent(onboardingPage.settingsWelcome, 90);
		String OnboardWelcomeMsgSettings = onboardingPage.settingsWelcome.getText();
		System.out.println(OnboardWelcomeMsgSettings);
		if(OnboardWelcomeMsgSettings.contains("Add your card"))
		{
			test.log(Status.PASS, "Add your card Onboarding Tab Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));		
		}
		else
		{
			test.log(Status.FAIL, "Add your card Onboarding Tab not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			Assert.fail("Add your card Onboarding Tab not Displayed");
		}

		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		onboardingPage.GotitIcon.click();

	}


}

