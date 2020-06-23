package com.share.testscript;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.share.functions.AssistantFunctions;
import com.share.functions.RegistrationFunctions;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.AssistantPage;
import com.share.objectrepository.RegistrationPage;
import com.share.objectrepository.SignInPage;
import com.share.utility.Utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class Assistant extends DriverSetUp
{



	@Test
	public void TC_Assistant_001(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant");
		test.info("Using SHARE");
		test.assignCategory("Assistant");
		System.out.println(TC_Method);		
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AssistantPage assistantPage = new AssistantPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
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

			//Click on Assistant Icon
			assistantPage.AssistantIcon.click();
			Thread.sleep(10000);

			//Verify Title Displayed
			String Title = generalFunctions.getText(assistantPage.PageTitle);
			System.out.println("Title "+ Title);
			if(Title.contains("Assistant"))
			{
				test.log(Status.PASS, "Assistant Title Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Assistant Title Not Displayed");
				Assert.fail("Assistant Title Not Displayed");
			}

			//Click on using Share
			assistantPage.usingShare.click();
			Thread.sleep(10000);

			//Verify Description Displayed
			generalFunctions.isElementPresent(assistantPage.Description, 60);
			String Description = generalFunctions.getText(assistantPage.Description);
			System.out.println("Description "+ Description);
			if(Description.contains("SHARE can be used on all Majid�Al�Futtaim brands"))
			{
				test.log(Status.PASS, "Description Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Description Not Displayed");
				Assert.fail("Description Not Displayed");

			}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}

	}



	@Test
	public void TC_Assistant_002(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant");
		test.info("Using SHARE Wallet");
		test.assignCategory("Assistant");
		System.out.println(TC_Method);		
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AssistantPage assistantPage = new AssistantPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{


			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Assistant Icon
			assistantPage.AssistantIcon.click();
			Thread.sleep(10000);

			//Verify Title Displayed
			String Title = generalFunctions.getText(assistantPage.PageTitle);
			System.out.println("Title "+ Title);
			if(Title.contains("Assistant"))
			{
				test.log(Status.PASS, "Assistant Title Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Assistant Title Not Displayed");
				Assert.fail("Assistant Title Not Displayed");
			}

			//Click on using Share wallet
			assistantPage.usingShareWallet.click();
			Thread.sleep(10000);

			//Verify Description Displayed
			generalFunctions.isElementPresent(assistantPage.Description, 60);
			String Description = generalFunctions.getText(assistantPage.Description);
			System.out.println("Description "+ Description);
			if(Description.contains("The SHARE Wallet can be used at all Majid�Al�Futtaim brands"))
			{
				test.log(Status.PASS, "Description Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Description Not Displayed");
				Assert.fail("Description Not Displayed");
			}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}



	@Test
	public void TC_Assistant_003(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant");
		test.info("Earning SHARE points");
		test.assignCategory("Assistant");
		System.out.println(TC_Method);			
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AssistantPage assistantPage = new AssistantPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{


			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Assistant Icon
			assistantPage.AssistantIcon.click();
			Thread.sleep(10000);

			//Verify Title Displayed
			String Title = generalFunctions.getText(assistantPage.PageTitle);
			System.out.println("Title "+ Title);
			if(Title.contains("Assistant"))
			{
				test.log(Status.PASS, "Assistant Title Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Assistant Title Not Displayed");
				Assert.fail("Assistant Title Not Displayed");
			}

			//Click on earning SHARE Points
			assistantPage.earningSHAREPoints.click();
			Thread.sleep(10000);

			//Verify Description Displayed
			generalFunctions.isElementPresent(assistantPage.Description, 60);
			String Description = generalFunctions.getText(assistantPage.Description);
			System.out.println("Description "+ Description);
			if(Description.contains("SHARE points can be earned by:"))
			{
				test.log(Status.PASS, "Description Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Description Not Displayed");
				Assert.fail("Description Not Displayed");
			}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}




	@Test
	public void TC_Assistant_004(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant");
		test.info("Earning SHARE points");
		test.assignCategory("Assistant");
		System.out.println(TC_Method);			
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AssistantPage assistantPage = new AssistantPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{


			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Assistant Icon
			assistantPage.AssistantIcon.click();
			Thread.sleep(10000);

			//Verify Title Displayed
			String Title = generalFunctions.getText(assistantPage.PageTitle);
			System.out.println("Title "+ Title);
			if(Title.contains("Assistant"))
			{
				test.log(Status.PASS, "Assistant Title Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Assistant Title Not Displayed");
				Assert.fail("Assistant Title Not Displayed");
			}

			//Click on redeeming SHARE Points
			assistantPage.redeemingSHAREPoints.click();
			Thread.sleep(10000);

			//Verify Description Displayed
			generalFunctions.isElementPresent(assistantPage.Description, 60);
			String Description = generalFunctions.getText(assistantPage.Description);
			System.out.println("Description "+ Description);
			if(Description.contains("SHARE points can be redeemed by:"))
			{
				test.log(Status.PASS, "Description Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Description Not Displayed");
				Assert.fail("Description Not Displayed");
			}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}



	@Test
	public void TC_Assistant_005(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant");
		test.info("Frequently Asked Questions");
		test.assignCategory("Assistant");
		System.out.println(TC_Method);			
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AssistantPage assistantPage = new AssistantPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{


			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Assistant Icon
			assistantPage.AssistantIcon.click();
			Thread.sleep(10000);

			//Verify Title Displayed
			String Title = generalFunctions.getText(assistantPage.PageTitle);
			System.out.println("Title "+ Title);
			if(Title.contains("Assistant"))
			{
				test.log(Status.PASS, "Assistant Title Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Assistant Title Not Displayed");
				Assert.fail("Assistant Title Not Displayed");
			}

			//Click on See our help categories
			assistantPage.helpCategories.click();
			Thread.sleep(10000);

			//Verify help Categories Displayed
			generalFunctions.isElementPresent(assistantPage.CategoryTitleText, 60);
			String Description = generalFunctions.getText(assistantPage.CategoryTitleText);
			System.out.println("help Categories page"+ Description);
			if(Description.contains("CATEGORIES"))
			{
				test.log(Status.PASS, "help Categories page Displayed");
			}
			else
			{
				test.log(Status.FAIL, "help Categories page Not Displayed");
				Assert.fail("help Categories page Not Displayed");
			}

			//Verify categories Displayed
			if(assistantPage.Categories.isDisplayed()==true)
			{
				test.log(Status.PASS, "Categories Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Categories Not Displayed");
				Assert.fail("Categories Not Displayed");
			}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}



	@Test
	public void TC_Assistant_008(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant");
		test.info("Contact Us");
		test.assignCategory("Assistant");
		System.out.println(TC_Method);			
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AssistantPage assistantPage = new AssistantPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{

			//logout if already logged in
			generalFunctions.Logout();
			Thread.sleep(10000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Assistant Icon
			assistantPage.AssistantIcon.click();
			Thread.sleep(10000);

			//Verify Title Displayed
			String Title = generalFunctions.getText(assistantPage.PageTitle);
			System.out.println("Title "+ Title);
			if(Title.contains("Assistant"))
			{
				test.log(Status.PASS, "Assistant Title Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Assistant Title Not Displayed");
				Assert.fail("Assistant Title Not Displayed");
			}				

			//Verify Contact Us Displayed
			generalFunctions.isElementPresent(assistantPage.ContactUs, 60);
			String ContactUs = generalFunctions.getText(assistantPage.ContactUs);
			System.out.println(ContactUs);
			if(ContactUs.contains("CONTACT US"))
			{
				test.log(Status.PASS, "Contact Us Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Contact Us Not Displayed");
				Assert.fail("Contact Us Not Displayed");
			}

			//Scroll down
			generalFunctions.ScrollDown("Call us");

			//Verify Call Us Displayed
			String CallUs = generalFunctions.getText(assistantPage.CallUs);
			System.out.println("Call Us "+ CallUs);
			if(CallUs.contains("Call us"))
			{
				test.log(Status.PASS, "Call Us Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Call Us Not Displayed");
				Assert.fail("Call Us Not Displayed");
			}

			//Click 
			assistantPage.CallUs.click();
			Thread.sleep(10000);

			//Verify Dialer Displayed
			generalFunctions.isElementPresent(assistantPage.Dialer, 60);
			String Dialer = generalFunctions.getText(assistantPage.Dialer);
			System.out.println("Dialer "+ Dialer);
			if(Dialer.contains("80074 273")|Dialer.contains("80074273"))
			{
				test.log(Status.PASS, "Dialer Displayed with Phone Number");
			}
			else
			{
				test.log(Status.FAIL, "Dialer Not Displayed with Phone Number");
				Assert.fail("Dialer Not Displayed with Phone Number");
			}	
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}



	@Test
	public void TC_Assistant_006(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant");
		test.info("Validate Search");
		test.assignCategory("Assistant");
		System.out.println(TC_Method);			
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();
		String SearchText="What is the SHARE Wallet?";

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AssistantPage assistantPage = new AssistantPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{


			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Assistant Icon
			assistantPage.AssistantIcon.click();
			Thread.sleep(10000);

			//Verify Title Displayed
			String Title = generalFunctions.getText(assistantPage.PageTitle);
			System.out.println("Title "+ Title);
			if(Title.contains("Assistant"))
			{
				test.log(Status.PASS, "Assistant Title Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Assistant Title Not Displayed");
				Assert.fail("Assistant Title Not Displayed");
			}				

			//Verify search displayed
			if(assistantPage.Search.isDisplayed()==true)
			{
				test.log(Status.PASS, "Search option Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Search option Not Displayed");
				Assert.fail("Search option Not Displayed");
			}

			//Enter Search value
			assistantPage.Search.sendKeys(SearchText);
			assistantPage.Search.click();
			Thread.sleep(5000);
			driver.hideKeyboard();

			//Verify Question Displayed
			generalFunctions.isElementPresent(assistantPage.Question, 60);
			String SearchQuestion = generalFunctions.getText(assistantPage.Question);
			System.out.println("Question "+ SearchQuestion);
			if(SearchQuestion.contains(SearchText))
			{
				test.log(Status.PASS, "Assistant Title Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Assistant Title Not Displayed");
				Assert.fail("Assistant Title Not Displayed");
			}	
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}



	@Test
	public void TC_Assistant_007(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant");
		test.info("Validate Search with invalid keyword");
		test.assignCategory("Assistant");
		System.out.println(TC_Method);			
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();
		String SearchText="test";

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AssistantPage assistantPage = new AssistantPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{


			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Assistant Icon
			assistantPage.AssistantIcon.click();
			Thread.sleep(10000);

			//Verify Title Displayed
			String Title = generalFunctions.getText(assistantPage.PageTitle);
			System.out.println("Title "+ Title);
			if(Title.contains("Assistant"))
			{
				test.log(Status.PASS, "Assistant Title Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Assistant Title Not Displayed");
				Assert.fail("Assistant Title Not Displayed");
			}				

			//Verify search displayed
			if(assistantPage.Search.isDisplayed()==true)
			{
				test.log(Status.PASS, "Search option Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Search option Not Displayed");
				Assert.fail("Search option Not Displayed");
			}

			//Enter Search value
			assistantPage.Search.sendKeys(SearchText);
			assistantPage.Search.click();
			Thread.sleep(5000);
			driver.hideKeyboard();

			//Verify Alert Displayed
			generalFunctions.isElementPresent(assistantPage.Alert, 60);
			String Alert = generalFunctions.getText(assistantPage.Alert);
			System.out.println("Alert "+ Alert);
			if(Alert.contains("Sorry, no results were found."))
			{
				test.log(Status.PASS, "Alert Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Alert Not Displayed");
				Assert.fail("Alert Not Displayed");
			}	
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	//New Feature Sprint 20 to 23
	@Test
	public void TC_Assitant_008(Method method) throws Exception {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("Assistant");
		test.log(Status.INFO, "Assistant:Email Us");
		test.log(Status.INFO, "Verify  user able to send query through Email Us");
		System.out.println(TC_Method);			
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("UserPassword").toString();
		String SearchText="test";

		RegistrationPage registrationPage= new RegistrationPage(driver);
		AssistantPage assistantPage = new AssistantPage(driver);
		AssistantFunctions assistantFunctions = new AssistantFunctions();
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		SignInPage signInPage = new SignInPage(driver);
		//try
		//{


		//LOGIN
		registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

		//Click on Assistant Icon
		assistantPage.AssistantIcon.click();
		Thread.sleep(10000);

		//Verify Title Displayed
		String Title = generalFunctions.getText(assistantPage.PageTitle);
		System.out.println("Title "+ Title);
		if(Title.contains("Assistant"))
		{
			test.log(Status.PASS, "Assistant Title Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Assistant Title Not Displayed");
			Assert.fail("Assistant Title Not Displayed");
		}	
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Email us\"))");
		generalFunctions.isElementPresent(assistantPage.assistantEmailUs, 90);
		registrationFunctions.emailId(registrationPage);		
		registrationFunctions.countryCode(registrationPage);			
		//Enter Mobile Number
		registrationFunctions.mobileNumber(registrationPage);
		//Reason
		generalFunctions.isElementPresent(assistantPage.assisatantReason, 90);
		assistantPage.assisatantReason.click();
		assistantFunctions.reasonRandom(assistantPage);
		//Reason Something else
		try {
			String reasonText = assistantPage.assistantSomething.getText();
			System.out.println(reasonText);
			if(reasonText.contains("Something else") ){
				assistantPage.assistantOtherReason.sendKeys("Please enter the reason");
				driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"SUBMIT\"))");

			}
		}catch(Exception e){
			e.getCause();
			e.getStackTrace();
		}

		//Description
		generalFunctions.isElementPresent(assistantPage.assistantDesription, 90);
		assistantFunctions.assistdesc(assistantPage);

		//Scroll
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"SUBMIT\"))");
		//Attachment
		//generalFunctions.isElementPresent(assistantPage.assistantAttachment, 90);
		//assistantPage.assistantAttachment.click();
		//assistantFunctions.allowtoAccess(assistantPage);


		//Terms and Conditions
		assistantPage.assistantTC.click();
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"2.0 DEFINITIONS\"))");
		//	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"RECITAL\"))");
		//driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Navigate up']").click();
		generalFunctions.isElementPresent(registrationPage.NavigateBack, 90);
		registrationPage.NavigateBack.click();
		//driver.navigate().back();
		//Submit
		generalFunctions.isElementPresent(assistantPage.assistantSubmit, 90);
		assistantPage.assistantSubmit.click();
		//Success
		generalFunctions.isElementPresent(assistantPage.assistantOK, 90);
		if(assistantFunctions.assistantOk(assistantPage)==true) {
			test.log(Status.PASS, "Successfully submitted the feedback").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			assistantPage.assistanSuccess.click();
		}else {
			test.log(Status.PASS, "Successful alert not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));

		}

	}

}

