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

	GeneralFunctions generalFunctions = new GeneralFunctions();
	
	
	//V2 START
	
	
	@Test
	public void TC_01_01_02(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant Faq");
		test.assignCategory("Assistant");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		AssistantPage assistantPage = new AssistantPage(driver);
		
		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();
		
		try
		
		{
			
		driver.activateApp("com.maf.sharesit");
			
		//Login to the App				
		generalFunctions.SignIn(EmailAddress, Password, signInPage);
		
		// Click Experiences
		Thread.sleep(5000);
		generalFunctions.isElementPresent(assistantPage.AssistantIcon, 60);
		assistantPage.AssistantIcon.click();
		Thread.sleep(5000);
		
		//Verify Assistant Page displayed
		try
		{
			if(assistantPage.assistantPage.isDisplayed()==true)
			{
				test.log(Status.PASS, "Assistant Page Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Assistant Page Not Displayed");
			Assert.fail("Assistant Page Not Displayed");
		}
		
		
		//Verify Search Icon
		try
		{
			if(assistantPage.searchIcon.isDisplayed()==true)
			{
				test.log(Status.PASS, "Search Icon Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Search Icon Not Displayed");
			Assert.fail("Search Icon Not Displayed");
		}
		
		//Verify Topic Section
		try
		{
			if(assistantPage.topicSection.isDisplayed()==true)
			{
				test.log(Status.PASS, "Topic Section Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Topic Section Not Displayed");
			Assert.fail("Topic Section Not Displayed");
		}
		
		//Verify Share Basics Section
		try
		{
			if(assistantPage.shareBasicsSection.isDisplayed()==true)
			{
				test.log(Status.PASS, "Share Basics Section Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Share Basics Section Not Displayed");
			Assert.fail("Share Basics Section Not Displayed");
		}
		
		//Verify Call Us Section
		try
		{
			if(assistantPage.callUsSection.isDisplayed()==true)
			{
				test.log(Status.PASS, "Call Us Section Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Call Us Section Not Displayed");
			Assert.fail("Call Us Section Not Displayed");
		}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}		
	}
	
	
	@Test
	public void TC_01_03(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant Faq");
		test.assignCategory("Assistant");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		AssistantPage assistantPage = new AssistantPage(driver);
		
		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();
		
		try
		
		{

		//Login to the App				
		//generalFunctions.SignIn(EmailAddress, Password, signInPage);
		driver.activateApp("com.maf.sharesit");
			
		// Click Experiences
		Thread.sleep(5000);
		generalFunctions.isElementPresent(assistantPage.AssistantIcon, 60);
		assistantPage.AssistantIcon.click();
		Thread.sleep(5000);
		
		//Verify Assistant Page displayed
		try
		{
			if(assistantPage.assistantPage.isDisplayed()==true)
			{
				test.log(Status.PASS, "Assistant Page Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Assistant Page Not Displayed");
			Assert.fail("Assistant Page Not Displayed");
		}
		
		generalFunctions.isElementPresent(assistantPage.RegistrationTopic, 30);
	
		try
		{
			if(assistantPage.RegistrationTopic.isDisplayed()==true)
			{
				test.log(Status.PASS, "Registration Topic Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Registration Topic Not Displayed");
			Assert.fail("Registration Topic Not Displayed");
		}	
	
		try
		{
			if(assistantPage.ShareWalletTopic.isDisplayed()==true)
			{
				test.log(Status.PASS, "Share Wallet Topic Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Share Wallet Topic Not Displayed");
			Assert.fail("Share Wallet Topic Not Displayed");
		}	
		
		try
		{
			if(assistantPage.sharePointsTopic.isDisplayed()==true)
			{
				test.log(Status.PASS, "About Share Points Topic Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "About Share Points Topic Not Displayed");
			Assert.fail("About Share Points Topic Not Displayed");
		}		
		
		try
		{
			if(assistantPage.earningSharePointsTopic.isDisplayed()==true)
			{
				test.log(Status.PASS, "Earning Share Points Topic Topic Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Earning Share Points Topic Not Displayed");
			Assert.fail("Earning Share Points Topic Not Displayed");
		}
		
		try
		{
			if(assistantPage.redeemSharePointsTopic.isDisplayed()==true)
			{
				test.log(Status.PASS, "Redeem Share Points Topic Topic Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Redeem Share Points Topic Not Displayed");
			Assert.fail("Redeem Share Points Topic Not Displayed");
		}
		
		try
		{
			if(assistantPage.familyGroupTopic.isDisplayed()==true)
			{
				test.log(Status.PASS, "Share Family Group Topic Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Share Family Group Topic Not Displayed");
			Assert.fail("Share Family Group Topic Not Displayed");
		}
		
		try
		{
			if(assistantPage.shareAtVOXCinemasTopic.isDisplayed()==true)
			{
				test.log(Status.PASS, "Share At VOX Cinemas Topic Topic Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Share At VOX Cinemas Topic Not Displayed");
			Assert.fail("Share At VOX Cinemas Topic Not Displayed");
		}
		
		try
		{
			if(assistantPage.shareAtCarrefourTopic.isDisplayed()==true)
			{
				test.log(Status.PASS, "Share At Carrefour Topic Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Share At Carrefour Topic Not Displayed");
			Assert.fail("Share At Carrefour Topic Not Displayed");
		}
				
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}		
	}
	
	
	@Test
	public void TC_01_04_05(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant Faq");
		test.assignCategory("Assistant");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		AssistantPage assistantPage = new AssistantPage(driver);
		
		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();
		
		try
		
		{

		//Login to the App				
		//generalFunctions.SignIn(EmailAddress, Password, signInPage);
		driver.activateApp("com.maf.sharesit");
			
		// Click Experiences
		Thread.sleep(5000);
		generalFunctions.isElementPresent(assistantPage.AssistantIcon, 60);
		assistantPage.AssistantIcon.click();
		Thread.sleep(5000);
		
		//Verify Assistant Page displayed
		try
		{
			if(assistantPage.assistantPage.isDisplayed()==true)
			{
				test.log(Status.PASS, "Assistant Page Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Assistant Page Not Displayed");
			Assert.fail("Assistant Page Not Displayed");
		}
				
	
		try
		{
			generalFunctions.isElementPresent(assistantPage.RegistrationTopic, 30);
			if(assistantPage.RegistrationTopic.isDisplayed()==true)
			{
				test.log(Status.PASS, "Registration Topic Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Registration Topic Not Displayed");
			Assert.fail("Registration Topic Not Displayed");
		}
		
		assistantPage.RegistrationTopic.click();
		Thread.sleep(4000);
		generalFunctions.isElementPresent(assistantPage.pageTitle, 30);
		if(generalFunctions.getText(assistantPage.pageTitle).contains("REGISTRATION"))
		{
			test.log(Status.PASS, "REGISTRATION related questions page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "REGISTRATION related questions page Not Displayed");
			Assert.fail("REGISTRATION related questions page Not Displayed");
		}
		
		try
		{
			if(assistantPage.questionsList.isDisplayed()==true)
			{
				test.log(Status.PASS, "REGISTRATION related questions list Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "REGISTRATION related questions list Not Displayed");
			Assert.fail("REGISTRATION related questions list Not Displayed");
		}
		
		assistantPage.firstQuestion.click();
		generalFunctions.isElementPresent(assistantPage.firstQuestionAnswer, 20);
		if(generalFunctions.getText(assistantPage.firstQuestionAnswer)!="")
		{
			test.log(Status.PASS, "Answer Displayed for the selected question");
		}
		else
		{
			test.log(Status.FAIL, "Answer Not Displayed for the selected question");
			Assert.fail("Answer Not Displayed for the selected question");
		}
		
		assistantPage.pageBack.click();
		
		
		try
		{
			generalFunctions.isElementPresent(assistantPage.ShareWalletTopic, 30);
			if(assistantPage.ShareWalletTopic.isDisplayed()==true)
			{
				test.log(Status.PASS, "Share Wallet Topic Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Share Wallet Topic Not Displayed");
			Assert.fail("Share Wallet Topic Not Displayed");
		}	
		
		assistantPage.ShareWalletTopic.click();
		Thread.sleep(4000);
		generalFunctions.isElementPresent(assistantPage.pageTitle, 30);
		if(generalFunctions.getText(assistantPage.pageTitle).contains("SHARE WALLET"))
		{
			test.log(Status.PASS, "SHARE WALLET related questions page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "SHARE WALLET related questions page Not Displayed");
			Assert.fail("SHARE WALLET related questions page Not Displayed");
		}
		
		try
		{
			if(assistantPage.questionsList.isDisplayed()==true)
			{
				test.log(Status.PASS, "SHARE WALLET related questions list Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "SHARE WALLET related questions list Not Displayed");
			Assert.fail("SHARE WALLET related questions list Not Displayed");
		}
		
		assistantPage.firstQuestion.click();
		generalFunctions.isElementPresent(assistantPage.firstQuestionAnswer, 20);
		if(generalFunctions.getText(assistantPage.firstQuestionAnswer)!="")
		{
			test.log(Status.PASS, "Answer Displayed for the selected question");
		}
		else
		{
			test.log(Status.FAIL, "Answer Not Displayed for the selected question");
			Assert.fail("Answer Not Displayed for the selected question");
		}
		
		assistantPage.pageBack.click();
		
		try
		{
			generalFunctions.isElementPresent(assistantPage.sharePointsTopic, 30);
			if(assistantPage.sharePointsTopic.isDisplayed()==true)
			{
				test.log(Status.PASS, "About Share Points Topic Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "About Share Points Topic Not Displayed");
			Assert.fail("About Share Points Topic Not Displayed");
		}	
		
		
		assistantPage.sharePointsTopic.click();
		Thread.sleep(4000);
		generalFunctions.isElementPresent(assistantPage.pageTitle, 30);
		if(generalFunctions.getText(assistantPage.pageTitle).contains("ABOUT SHARE POINTS"))
		{
			test.log(Status.PASS, "ABOUT SHARE POINTS related questions page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "ABOUT SHARE POINTS related questions page Not Displayed");
			Assert.fail("ABOUT SHARE POINTS related questions page Not Displayed");
		}
		
		try
		{
			if(assistantPage.questionsList.isDisplayed()==true)
			{
				test.log(Status.PASS, "ABOUT SHARE POINTS related questions list Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "ABOUT SHARE POINTS related questions list Not Displayed");
			Assert.fail("ABOUT SHARE POINTS related questions list Not Displayed");
		}
		
		assistantPage.firstQuestion.click();
		generalFunctions.isElementPresent(assistantPage.firstQuestionAnswer, 20);
		if(generalFunctions.getText(assistantPage.firstQuestionAnswer)!="")
		{
			test.log(Status.PASS, "Answer Displayed for the selected question");
		}
		else
		{
			test.log(Status.FAIL, "Answer Not Displayed for the selected question");
			Assert.fail("Answer Not Displayed for the selected question");
		}
		
		assistantPage.pageBack.click();
		
		try
		{
			generalFunctions.isElementPresent(assistantPage.earningSharePointsTopic, 30);
			if(assistantPage.earningSharePointsTopic.isDisplayed()==true)
			{
				test.log(Status.PASS, "Earning Share Points Topic Topic Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Earning Share Points Topic Not Displayed");
			Assert.fail("Earning Share Points Topic Not Displayed");
		}
		
		assistantPage.earningSharePointsTopic.click();
		Thread.sleep(4000);
		generalFunctions.isElementPresent(assistantPage.pageTitle, 30);
		if(generalFunctions.getText(assistantPage.pageTitle).contains("EARNING SHARE POINTS"))
		{
			test.log(Status.PASS, "EARNING SHARE POINTS related questions page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "EARNING SHARE POINTS related questions page Not Displayed");
			Assert.fail("EARNING SHARE POINTS related questions page Not Displayed");
		}
		
		try
		{
			if(assistantPage.questionsList.isDisplayed()==true)
			{
				test.log(Status.PASS, "EARNING SHARE POINTS related questions list Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "EARNING SHARE POINTS related questions list Not Displayed");
			Assert.fail("EARNING SHARE POINTS related questions list Not Displayed");
		}
		
		assistantPage.firstQuestion.click();
		generalFunctions.isElementPresent(assistantPage.firstQuestionAnswer, 20);
		if(generalFunctions.getText(assistantPage.firstQuestionAnswer)!="")
		{
			test.log(Status.PASS, "Answer Displayed for the selected question");
		}
		else
		{
			test.log(Status.FAIL, "Answer Not Displayed for the selected question");
			Assert.fail("Answer Not Displayed for the selected question");
		}
		
		assistantPage.pageBack.click();
		
		try
		{
			generalFunctions.isElementPresent(assistantPage.redeemSharePointsTopic, 30);
			if(assistantPage.redeemSharePointsTopic.isDisplayed()==true)
			{
				test.log(Status.PASS, "Redeem Share Points Topic Topic Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Redeem Share Points Topic Not Displayed");
			Assert.fail("Redeem Share Points Topic Not Displayed");
		}
		
		assistantPage.redeemSharePointsTopic.click();
		Thread.sleep(4000);
		generalFunctions.isElementPresent(assistantPage.pageTitle, 30);
		if(generalFunctions.getText(assistantPage.pageTitle).contains("REDEEMING SHARE POINTS"))
		{
			test.log(Status.PASS, "REDEEMING SHARE POINTS related questions page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "REDEEMING SHARE POINTS related questions page Not Displayed");
			Assert.fail("REDEEMING SHARE POINTS related questions page Not Displayed");
		}
		
		try
		{
			if(assistantPage.questionsList.isDisplayed()==true)
			{
				test.log(Status.PASS, "REDEEMING SHARE POINTS related questions list Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "REDEEMING SHARE POINTS related questions list Not Displayed");
			Assert.fail("REDEEMING SHARE POINTS related questions list Not Displayed");
		}
		
		assistantPage.firstQuestion.click();
		generalFunctions.isElementPresent(assistantPage.firstQuestionAnswer, 20);
		if(generalFunctions.getText(assistantPage.firstQuestionAnswer)!="")
		{
			test.log(Status.PASS, "Answer Displayed for the selected question");
		}
		else
		{
			test.log(Status.FAIL, "Answer Not Displayed for the selected question");
			Assert.fail("Answer Not Displayed for the selected question");
		}
		
		assistantPage.pageBack.click();
		
		try
		{
			generalFunctions.isElementPresent(assistantPage.familyGroupTopic, 30);
			if(assistantPage.familyGroupTopic.isDisplayed()==true)
			{
				test.log(Status.PASS, "Share Family Group Topic Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Share Family Group Topic Not Displayed");
			Assert.fail("Share Family Group Topic Not Displayed");
		}
		
		assistantPage.familyGroupTopic.click();
		Thread.sleep(4000);
		generalFunctions.isElementPresent(assistantPage.pageTitle, 30);
		if(generalFunctions.getText(assistantPage.pageTitle).contains("SHARE FAMILY GROUP"))
		{
			test.log(Status.PASS, "SHARE FAMILY GROUP related questions page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "SHARE FAMILY GROUP related questions page Not Displayed");
			Assert.fail("SHARE FAMILY GROUP related questions page Not Displayed");
		}
		
		try
		{
			if(assistantPage.questionsList.isDisplayed()==true)
			{
				test.log(Status.PASS, "SHARE FAMILY GROUP related questions list Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "SHARE FAMILY GROUP related questions list Not Displayed");
			Assert.fail("SHARE FAMILY GROUP related questions list Not Displayed");
		}
		
		assistantPage.firstQuestion.click();
		generalFunctions.isElementPresent(assistantPage.firstQuestionAnswer, 20);
		if(generalFunctions.getText(assistantPage.firstQuestionAnswer)!="")
		{
			test.log(Status.PASS, "Answer Displayed for the selected question");
		}
		else
		{
			test.log(Status.FAIL, "Answer Not Displayed for the selected question");
			Assert.fail("Answer Not Displayed for the selected question");
		}
		
		assistantPage.pageBack.click();
		
		try
		{
			generalFunctions.isElementPresent(assistantPage.shareAtVOXCinemasTopic, 30);
			if(assistantPage.shareAtVOXCinemasTopic.isDisplayed()==true)
			{
				test.log(Status.PASS, "Share At VOX Cinemas Topic Topic Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Share At VOX Cinemas Topic Not Displayed");
			Assert.fail("Share At VOX Cinemas Topic Not Displayed");
		}
		
		assistantPage.shareAtVOXCinemasTopic.click();
		Thread.sleep(4000);
		generalFunctions.isElementPresent(assistantPage.pageTitle, 30);
		if(generalFunctions.getText(assistantPage.pageTitle).contains("SHARE AT VOX CINEMAS"))
		{
			test.log(Status.PASS, "SHARE AT VOX CINEMAS related questions page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "SHARE AT VOX CINEMAS related questions page Not Displayed");
			Assert.fail("SHARE AT VOX CINEMAS related questions page Not Displayed");
		}
		
		try
		{
			if(assistantPage.questionsList.isDisplayed()==true)
			{
				test.log(Status.PASS, "SHARE AT VOX CINEMAS related questions list Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "SHARE AT VOX CINEMAS related questions list Not Displayed");
			Assert.fail("SHARE AT VOX CINEMAS related questions list Not Displayed");
		}
		
		assistantPage.firstQuestion.click();
		generalFunctions.isElementPresent(assistantPage.firstQuestionAnswer, 20);
		if(generalFunctions.getText(assistantPage.firstQuestionAnswer)!="")
		{
			test.log(Status.PASS, "Answer Displayed for the selected question");
		}
		else
		{
			test.log(Status.FAIL, "Answer Not Displayed for the selected question");
			Assert.fail("Answer Not Displayed for the selected question");
		}
		
		assistantPage.pageBack.click();
		
		try
		{
			generalFunctions.isElementPresent(assistantPage.shareAtCarrefourTopic, 30);
			if(assistantPage.shareAtCarrefourTopic.isDisplayed()==true)
			{
				test.log(Status.PASS, "Share At Carrefour Topic Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Share At Carrefour Topic Not Displayed");
			Assert.fail("Share At Carrefour Topic Not Displayed");
		}
		
		assistantPage.shareAtCarrefourTopic.click();
		Thread.sleep(4000);
		generalFunctions.isElementPresent(assistantPage.pageTitle, 30);
		if(generalFunctions.getText(assistantPage.pageTitle).contains("SHARE AT CARREFOUR"))
		{
			test.log(Status.PASS, "SHARE AT CARREFOUR related questions page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "SHARE AT CARREFOUR related questions page Not Displayed");
			Assert.fail("SHARE AT CARREFOUR related questions page Not Displayed");
		}
		
		try
		{
			if(assistantPage.questionsList.isDisplayed()==true)
			{
				test.log(Status.PASS, "SHARE AT CARREFOUR related questions list Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "SHARE AT CARREFOUR related questions list Not Displayed");
			Assert.fail("SHARE AT CARREFOUR related questions list Not Displayed");
		}
		
		assistantPage.firstQuestion.click();
		generalFunctions.isElementPresent(assistantPage.firstQuestionAnswer, 20);
		if(generalFunctions.getText(assistantPage.firstQuestionAnswer)!="")
		{
			test.log(Status.PASS, "Answer Displayed for the selected question");
		}
		else
		{
			test.log(Status.FAIL, "Answer Not Displayed for the selected question");
			Assert.fail("Answer Not Displayed for the selected question");
		}
		
		assistantPage.pageBack.click();
				
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}		
	}
	
	
	@Test
	public void TC_01_07_08(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant Faq");
		test.assignCategory("Assistant");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		AssistantPage assistantPage = new AssistantPage(driver);
		
		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();
		
		try
		
		{

		//Login to the App				
		//generalFunctions.SignIn(EmailAddress, Password, signInPage);
		driver.activateApp("com.maf.sharesit");
			
		// Click Experiences
		Thread.sleep(5000);
		generalFunctions.isElementPresent(assistantPage.AssistantIcon, 60);
		assistantPage.AssistantIcon.click();
		Thread.sleep(5000);
		
		//Verify Assistant Page displayed
		try
		{
			if(assistantPage.assistantPage.isDisplayed()==true)
			{
				test.log(Status.PASS, "Assistant Page Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Assistant Page Not Displayed");
			Assert.fail("Assistant Page Not Displayed");
		}
		
		//Verify Share Basics Section
		try
		{
			if(assistantPage.shareBasicsSection.isDisplayed()==true)
			{
				test.log(Status.PASS, "Share Basics Section Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Share Basics Section Not Displayed");
			Assert.fail("Share Basics Section Not Displayed");
		}	
		
		try
		{
			generalFunctions.isElementPresent(assistantPage.usingShare, 20);
			if(assistantPage.usingShare.isDisplayed()==true)
			{
				test.log(Status.PASS, "Using Share - Share Basics Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Using Share - Share Basics Not Displayed");
			Assert.fail("Using Share - Share Basics Not Displayed");
		}	
		
		assistantPage.usingShare.click();
		Thread.sleep(4000);
		
		generalFunctions.isElementPresent(assistantPage.pageTitle, 30);
		if(generalFunctions.getText(assistantPage.pageTitle).contains("SHARE BASICS"))
		{
			test.log(Status.PASS, "SHARE BASICS page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "SHARE BASICS page Not Displayed");
			Assert.fail("SHARE BASICS page Not Displayed");
		}
		
		if(generalFunctions.getText(assistantPage.Description)!="")
		{
			test.log(Status.PASS, "Using Share Description Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Using Share Description Not Displayed");
			Assert.fail("Using Share Description Not Displayed");
		}
		
		assistantPage.pageBack.click();
		
		
		try
		{
			generalFunctions.isElementPresent(assistantPage.usingShare, 20);
			if(assistantPage.usingShareWallet.isDisplayed()==true)
			{
				test.log(Status.PASS, "Using the SHARE Wallet - Share Basics Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Using the SHARE Wallet - Share Basics Not Displayed");
			Assert.fail("Using the SHARE Wallet - Share Basics Not Displayed");
		}	
		
		assistantPage.usingShareWallet.click();
		Thread.sleep(4000);
		
		generalFunctions.isElementPresent(assistantPage.pageTitle, 30);
		if(generalFunctions.getText(assistantPage.pageTitle).contains("SHARE BASICS"))
		{
			test.log(Status.PASS, "SHARE BASICS page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "SHARE BASICS page Not Displayed");
			Assert.fail("SHARE BASICS page Not Displayed");
		}
		
		if(generalFunctions.getText(assistantPage.Description)!="")
		{
			test.log(Status.PASS, "Using the SHARE Wallet Description Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Using the SHARE Wallet Description Not Displayed");
			Assert.fail("Using the SHARE Wallet Description Not Displayed");
		}
		
		assistantPage.pageBack.click();
		
		
		try
		{
			generalFunctions.isElementPresent(assistantPage.earningSHAREPoints, 20);
			if(assistantPage.earningSHAREPoints.isDisplayed()==true)
			{
				test.log(Status.PASS, "Earning SHARE points - Share Basics Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Earning SHARE points - Share Basics Not Displayed");
			Assert.fail("Earning SHARE points - Share Basics Not Displayed");
		}	
		
		assistantPage.earningSHAREPoints.click();
		Thread.sleep(4000);
		
		generalFunctions.isElementPresent(assistantPage.pageTitle, 30);
		if(generalFunctions.getText(assistantPage.pageTitle).contains("SHARE BASICS"))
		{
			test.log(Status.PASS, "SHARE BASICS page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "SHARE BASICS page Not Displayed");
			Assert.fail("SHARE BASICS page Not Displayed");
		}
		
		if(generalFunctions.getText(assistantPage.Description)!="")
		{
			test.log(Status.PASS, "Earning SHARE points Description Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Earning SHARE points Description Not Displayed");
			Assert.fail("Earning SHARE points Description Not Displayed");
		}
		
		assistantPage.pageBack.click();
		
		
		try
		{
			generalFunctions.isElementPresent(assistantPage.redeemingSHAREPoints, 20);
			if(assistantPage.redeemingSHAREPoints.isDisplayed()==true)
			{
				test.log(Status.PASS, "Redeeming SHARE points - Share Basics Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Redeeming SHARE points - Share Basics Not Displayed");
			Assert.fail("Redeeming SHARE points - Share Basics Not Displayed");
		}	
		
		assistantPage.redeemingSHAREPoints.click();
		Thread.sleep(4000);
		
		generalFunctions.isElementPresent(assistantPage.pageTitle, 30);
		if(generalFunctions.getText(assistantPage.pageTitle).contains("SHARE BASICS"))
		{
			test.log(Status.PASS, "SHARE BASICS page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "SHARE BASICS page Not Displayed");
			Assert.fail("SHARE BASICS page Not Displayed");
		}
		
		if(generalFunctions.getText(assistantPage.Description)!="")
		{
			test.log(Status.PASS, "Redeeming SHARE points Description Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Redeeming SHARE points Description Not Displayed");
			Assert.fail("Redeeming SHARE points Description Not Displayed");
		}
		
		assistantPage.pageBack.click();
		
		
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}		
	}
	
	
	@Test
	public void TC_01_09_10_11_13(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant Faq");
		test.assignCategory("Assistant");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		AssistantPage assistantPage = new AssistantPage(driver);
		
		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();
		String searchKeyWord="wallet";
		String searchKeyWord2="family";
		String searchKeyWord3="carrefour";
		
		try
		
		{

		//Login to the App				
		//generalFunctions.SignIn(EmailAddress, Password, signInPage);
		driver.activateApp("com.maf.sharesit");
			
		// Click Experiences
		Thread.sleep(5000);
		generalFunctions.isElementPresent(assistantPage.AssistantIcon, 60);
		assistantPage.AssistantIcon.click();
		Thread.sleep(5000);
		
		//Verify Assistant Page displayed
		try
		{
			if(assistantPage.assistantPage.isDisplayed()==true)
			{
				test.log(Status.PASS, "Assistant Page Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Assistant Page Not Displayed");
			Assert.fail("Assistant Page Not Displayed");
		}
				
		//Verify Search Icon
		try
		{
			if(assistantPage.searchIcon.isDisplayed()==true)
			{
				test.log(Status.PASS, "Search Icon Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Search Icon Not Displayed");
			Assert.fail("Search Icon Not Displayed");
		}
		
		assistantPage.searchIcon.click();
		Thread.sleep(4000);
		
		generalFunctions.isElementPresent(assistantPage.pageTitle, 30);
		if(generalFunctions.getText(assistantPage.pageTitle).contains("SEARCH"))
		{
			test.log(Status.PASS, "SEARCH page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "SEARCH page Not Displayed");
			Assert.fail("SEARCH page Not Displayed");
		}
		
		
		assistantPage.searchField.click();
		assistantPage.searchField.sendKeys(searchKeyWord);
		
		generalFunctions.pressSearch();
		Thread.sleep(4000);
		
		try
		{
			generalFunctions.isElementPresent(assistantPage.searchResult, 30);
			if(assistantPage.searchResult.isDisplayed()==true)
			{
				test.log(Status.PASS, "Search Result Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Search Result Not Displayed");
			Assert.fail("Search Result Not Displayed");
		}
		
		assistantPage.searchClear.click();
		
		try
		{
			generalFunctions.isElementPresent(assistantPage.recentSearchItem, 20);
			if(assistantPage.recentSearchItem.isDisplayed()==true)
			{
				test.log(Status.PASS, "Recent Search Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Recent Search Not Displayed");
			Assert.fail("Recent Search Not Displayed");
		}				
						
		assistantPage.searchField.click();
		assistantPage.searchField.sendKeys(searchKeyWord2);
		
		generalFunctions.pressSearch();
		Thread.sleep(4000);
		
		try
		{
			generalFunctions.isElementPresent(assistantPage.searchResult, 30);
			if(assistantPage.searchResult.isDisplayed()==true)
			{
				test.log(Status.PASS, "Search Result Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Search Result Not Displayed");
			Assert.fail("Search Result Not Displayed");
		}
		
		assistantPage.searchClear.click();
		
		assistantPage.searchField.click();
		assistantPage.searchField.sendKeys(searchKeyWord3);
		
		generalFunctions.pressSearch();
		Thread.sleep(4000);
		
		try
		{
			generalFunctions.isElementPresent(assistantPage.searchResult, 30);
			if(assistantPage.searchResult.isDisplayed()==true)
			{
				test.log(Status.PASS, "Search Result Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Search Result Not Displayed");
			Assert.fail("Search Result Not Displayed");
		}
		
		assistantPage.searchClear.click();
		
		try
		{
		if(assistantPage.recentSearches(searchKeyWord).isDisplayed()&&assistantPage.recentSearches(searchKeyWord2).isDisplayed()
				&&assistantPage.recentSearches(searchKeyWord3).isDisplayed())
		{
			test.log(Status.PASS, "Recent 3 Search keywords Displayed");
		}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Recent 3 Search keywords Not Displayed");
			Assert.fail("Recent 3 Search keywords Not Displayed");
		}
		
		
		assistantPage.clearButton.click();
		Thread.sleep(4000);
		
		try
		{
			generalFunctions.isElementPresent(assistantPage.trySearching, 30);
			if(assistantPage.trySearching.isDisplayed()==true)
			{
				test.log(Status.PASS, "Try Searching Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Try Searching Not Displayed");
			Assert.fail("Try Searching Not Displayed");
		}
		
		int trySearches = generalFunctions.elementCount(assistantPage.trySearches);
		if(trySearches==5)
		{
			test.log(Status.PASS, "5 Try Search options Displayed");
		}
		else
		{
			test.log(Status.FAIL, "5 Try Search options Not Displayed");
			Assert.fail("5 Try Search options Not Displayed");
		}
		
		assistantPage.pageBack.click();
		
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}		
	}
	
	
	@Test
	public void TC_01_14(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant Faq");
		test.assignCategory("Assistant");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		AssistantPage assistantPage = new AssistantPage(driver);
		
		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();
		String searchKeyWord="Carrefour";
		
		try
		
		{

		//Login to the App				
		//generalFunctions.SignIn(EmailAddress, Password, signInPage);
		driver.activateApp("com.maf.sharesit");
		
		// Click Experiences
		Thread.sleep(5000);
		generalFunctions.isElementPresent(assistantPage.AssistantIcon, 60);
		assistantPage.AssistantIcon.click();
		Thread.sleep(5000);
		
		//Verify Assistant Page displayed
		try
		{
			if(assistantPage.assistantPage.isDisplayed()==true)
			{
				test.log(Status.PASS, "Assistant Page Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Assistant Page Not Displayed");
			Assert.fail("Assistant Page Not Displayed");
		}
				
		//Verify Search Icon
		try
		{
			if(assistantPage.searchIcon.isDisplayed()==true)
			{
				test.log(Status.PASS, "Search Icon Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Search Icon Not Displayed");
			Assert.fail("Search Icon Not Displayed");
		}
		
		assistantPage.searchIcon.click();
		Thread.sleep(4000);
		
		generalFunctions.isElementPresent(assistantPage.pageTitle, 30);
		if(generalFunctions.getText(assistantPage.pageTitle).contains("SEARCH"))
		{
			test.log(Status.PASS, "SEARCH page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "SEARCH page Not Displayed");
			Assert.fail("SEARCH page Not Displayed");
		}
		
		
		assistantPage.searchField.click();
		assistantPage.searchField.sendKeys(searchKeyWord);
		
		generalFunctions.pressSearch();
		Thread.sleep(4000);
		
		try
		{
			generalFunctions.isElementPresent(assistantPage.searchResult, 30);
			if(assistantPage.searchResult.isDisplayed()==true)
			{
				test.log(Status.PASS, "Search Result Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Search Result Not Displayed");
			Assert.fail("Search Result Not Displayed");
		}
		
		assistantPage.searchResult.click();
		
		
		try
		{
			generalFunctions.isElementPresent(assistantPage.answerDetailsPage, 30);
			if(assistantPage.answerDetailsPage.isDisplayed()==true)
			{
				test.log(Status.PASS, "Search Result Details screen Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Search Result Details screen Not Displayed");
			Assert.fail("Search Result Details screen Not Displayed");
		}	
		
		try
		{
			generalFunctions.isElementPresent(assistantPage.assistantQuestion, 20);
			if(assistantPage.assistantQuestion.isDisplayed()==true)
			{
				test.log(Status.PASS, "Search Result Question Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Search Result Question Not Displayed");
			Assert.fail("Search Result Question Not Displayed");
		}	
		
		assistantPage.pageBack.click();
		Thread.sleep(4000);
		
		generalFunctions.isElementPresent(assistantPage.pageTitle, 30);
		if(generalFunctions.getText(assistantPage.pageTitle).contains("SEARCH"))
		{
			test.log(Status.PASS, "SEARCH page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "SEARCH page Not Displayed");
			Assert.fail("SEARCH page Not Displayed");
		}
		
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}		
	}
	
	
	@Test
	public void TC_01_15(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant Faq");
		test.assignCategory("Assistant");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		AssistantPage assistantPage = new AssistantPage(driver);
		
		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();
		String searchKeyWord="health";
		
		try
		
		{

		//Login to the App				
		//generalFunctions.SignIn(EmailAddress, Password, signInPage);
		driver.activateApp("com.maf.sharesit");
			
		// Click Experiences
		Thread.sleep(5000);
		generalFunctions.isElementPresent(assistantPage.AssistantIcon, 60);
		assistantPage.AssistantIcon.click();
		Thread.sleep(5000);
		
		//Verify Assistant Page displayed
		try
		{
			if(assistantPage.assistantPage.isDisplayed()==true)
			{
				test.log(Status.PASS, "Assistant Page Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Assistant Page Not Displayed");
			Assert.fail("Assistant Page Not Displayed");
		}
				
		//Verify Search Icon
		try
		{
			if(assistantPage.searchIcon.isDisplayed()==true)
			{
				test.log(Status.PASS, "Search Icon Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Search Icon Not Displayed");
			Assert.fail("Search Icon Not Displayed");
		}
		
		assistantPage.searchIcon.click();
		Thread.sleep(4000);
		
		generalFunctions.isElementPresent(assistantPage.pageTitle, 30);
		if(generalFunctions.getText(assistantPage.pageTitle).contains("SEARCH"))
		{
			test.log(Status.PASS, "SEARCH page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "SEARCH page Not Displayed");
			Assert.fail("SEARCH page Not Displayed");
		}
		
		
		assistantPage.searchField.click();
		assistantPage.searchField.sendKeys(searchKeyWord);
		
		generalFunctions.pressSearch();
		Thread.sleep(4000);
		
		try
		{
			generalFunctions.isElementPresent(assistantPage.noResult, 30);
			if(assistantPage.noResult.isDisplayed()==true)
			{
				test.log(Status.PASS, "SORRY, NO RESULT FOUND message displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "SORRY, NO RESULT FOUND message displayed");
			Assert.fail("SORRY, NO RESULT FOUND message displayed");
		}
		
		assistantPage.searchClear.click();
		
		assistantPage.pageBack.click();
		Thread.sleep(4000);
		
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}		
	}
	
	
	@Test
	public void TC_01_18(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant Faq");
		test.assignCategory("Assistant");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		AssistantPage assistantPage = new AssistantPage(driver);
		
		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();
		String searchKeyWord="health";
		
		try
		
		{
			
		driver.resetApp();
		driver.activateApp("com.maf.sharesit");	

		//Login to the App				
		generalFunctions.SignIn(EmailAddress, Password, signInPage);
		
		// Click Experiences
		Thread.sleep(5000);
		generalFunctions.isElementPresent(assistantPage.AssistantIcon, 60);
		assistantPage.AssistantIcon.click();
		Thread.sleep(8000);
		
		//Verify On Boarding Page displayed
		try
		{
			if(assistantPage.onBoarding.isDisplayed()==true)
			{
				test.log(Status.FAIL, "On Boarding Page Displayed");
				Assert.fail("On Boarding Page Displayed");
			}
		}
		catch(Exception x)
		{			
			test.log(Status.PASS, "On Boarding Page Not Displayed");
		}
				
		
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}		
	}
	
		
	@Test
	public void TC_02_01(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant - Call us");
		test.assignCategory("Assistant");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		AssistantPage assistantPage = new AssistantPage(driver);
		
		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();
		
		try
		
		{
		driver.activateApp("com.maf.sharesit");
		
		//Login to the App				
		generalFunctions.SignIn(EmailAddress, Password, signInPage);
					
		// Click Experiences
		Thread.sleep(5000);
		generalFunctions.isElementPresent(assistantPage.AssistantIcon, 60);
		assistantPage.AssistantIcon.click();
		Thread.sleep(5000);
		
		//Verify Assistant Page displayed
		try
		{
			if(assistantPage.assistantPage.isDisplayed()==true)
			{
				test.log(Status.PASS, "Assistant Page Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Assistant Page Not Displayed");
			Assert.fail("Assistant Page Not Displayed");
		}
				
		//Verify Call Us Section
		try
		{
			if(assistantPage.callUsSection.isDisplayed()==true)
			{
				test.log(Status.PASS, "Call Us Section Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Call Us Section Not Displayed");
			Assert.fail("Call Us Section Not Displayed");
		}
		 
		assistantPage.callUsSection.click();
		Thread.sleep(10000);
				
		//Verify Dialer Displayed
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
	
	
		
	
	//V2 END
	
	

	
}

