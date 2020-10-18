package com.share.testscript;

import java.lang.reflect.Method;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.share.functions.AssistantFunctions;
import com.share.functions.SignInFunctions;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.AssistantPage;
import com.share.objectrepository.ZendeskChatPage;
import com.share.utility.Utilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class Assistant extends DriverSetUp
{
	GeneralFunctions generalFunctions = new GeneralFunctions();
	
	@Test(priority=1)
	public void TC_Assistant_001_002(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant Faq");
		test.assignCategory("ASSISTANT");
		System.out.println(TC_Method);
		AssistantPage assistantPage = new AssistantPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{	driver.resetApp();
			signInFunctions.SignContinue();
			signInFunctions.quickSignIn();
			generalFunctions.isElementPresent(assistantPage.AssistantIcon, 60);
			assistantPage.AssistantIcon.click();
			//Verify Assistant Page displayed
			if(generalFunctions.isElementPresent(assistantPage.assistantPage,30))
			{	test.log(Status.PASS, "Assistant Page Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Assistant Page Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			//Verify Search Icon
			if(generalFunctions.isElementPresent(assistantPage.searchIcon,30))
			{	test.log(Status.PASS, "Search Icon Displayed");
			}
			else
			{	test.log(Status.FAIL, "Search Icon Not Displayed");
			}
			//Verify Topic Section
			if(generalFunctions.isElementPresent(assistantPage.topicSection,30))
			{	test.log(Status.PASS, "Topic Section Displayed");
			}
			else
			{	test.log(Status.FAIL, "Topic Section Not Displayed");
			}
			//Verify Share Basics Section
			if(generalFunctions.isElementPresent(assistantPage.shareBasicsSection,30))
			{	test.log(Status.PASS, "Top share tips/Share Basics Section Displayed");
			}
			else{
				test.log(Status.FAIL, "Top share tips/Share Basics Section Not Displayed");
			}
			generalFunctions.SimplyScrollDown();
			//chat us icon
			if(generalFunctions.isElementPresent(assistantPage.assistantchaticon,30))
			{	test.log(Status.PASS, "Assistant Chat icon Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else{
				test.log(Status.FAIL, "Assistant Chat icon Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			//Verify Call Us Section
			if(generalFunctions.isElementPresent(assistantPage.callUsSection,30))
			{	test.log(Status.PASS, "Call Us Section Displayed");
			}
			else
			{	test.log(Status.FAIL, "Call Us Section Not Displayed");
			}
			// sendus message
			if(generalFunctions.isElementPresent(assistantPage.sendusmessage,30))
			{	test.log(Status.PASS, "Send us a message Displayed");
			}
			else
			{	test.log(Status.FAIL, "Send us a message Not Displayed");
			}
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority=2)
	public void TC_Assistant_003(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant Faq");
		test.assignCategory("ASSISTANT");
		System.out.println(TC_Method);
		AssistantPage assistantPage = new AssistantPage(driver);
		try
		{
			generalFunctions.isElementPresent(assistantPage.AssistantIcon, 60);
			assistantPage.AssistantIcon.click();
			//Verify Assistant Page displayed
			if(generalFunctions.isElementPresent(assistantPage.assistantPage,30))
			{	test.log(Status.PASS, "Assistant Page Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Assistant Page Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			if(generalFunctions.isElementPresent(assistantPage.RegistrationTopic, 10))
			{	test.log(Status.PASS, "Registration Topic Displayed");
			}
			else
			{	test.log(Status.FAIL, "Registration Topic Not Displayed");
			}
			if(generalFunctions.isElementPresent(assistantPage.ShareWalletTopic, 10))
			{ 	test.log(Status.PASS, "Share Wallet Topic Displayed");
			}
			else
			{	test.log(Status.FAIL, "Share Wallet Topic Not Displayed");
			}
			if(generalFunctions.isElementPresent(assistantPage.sharePointsTopic,10))
			{	test.log(Status.PASS, "About Share Points Topic Displayed");
			}
			else
			{	test.log(Status.FAIL, "About Share Points Topic Not Displayed");
			}
			if(generalFunctions.isElementPresent(assistantPage.earningSharePointsTopic, 10))
			{	test.log(Status.PASS, "Earning Share Points Topic Topic Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Earning Share Points Topic Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			//if(generalFunctions.isElementPresent(assistantPage.redeemSharePointsTopic, 10))
			//{
				//test.log(Status.PASS, "Redeem Share Points Topic Topic Displayed");
			//}else{
				//test.log(Status.FAIL, "Redeem Share Points Topic Not Displayed");
			//}
			if(generalFunctions.isElementPresent(assistantPage.familyGroupTopic, 10))
			{	test.log(Status.PASS, "Share Family Group Topic Displayed");
			}
			else
			{	test.log(Status.FAIL, "Share Family Group Topic Not Displayed");
			}
			//if(generalFunctions.isElementPresent(assistantPage.shareIDTopic, 10))
			//{
			//	test.log(Status.PASS, "Share At VOX Cinemas Topic Topic Displayed");
			//}else{
			//	test.log(Status.FAIL, "Share At VOX Cinemas Topic Not Displayed");
			//}
			if(generalFunctions.isElementPresent(assistantPage.shareWorldTopic, 10))
			{	test.log(Status.PASS, "Share At Carrefour Topic Displayed");
			}
			else
			{	test.log(Status.FAIL, "Share At Carrefour Topic Not Displayed");
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
	public void TC_Assistant_004_005(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant Faq");
		test.assignCategory("ASSISTANT");
		System.out.println(TC_Method);
		AssistantPage assistantPage = new AssistantPage(driver);
		AssistantFunctions assistantFunctions = new AssistantFunctions();
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{	driver.resetApp();
			signInFunctions.SignContinue();
			signInFunctions.quickSignIn();
			generalFunctions.isElementPresent(assistantPage.AssistantIcon, 30);
			assistantPage.AssistantIcon.click();

			//Verify Assistant Page displayed
			if(generalFunctions.isElementPresent(assistantPage.assistantPage, 30))
			{	test.log(Status.PASS, "Assistant Page Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Assistant Page Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			if(generalFunctions.isElementPresent(assistantPage.RegistrationTopic, 30))
			{	test.log(Status.PASS, "Registration Topic Displayed");
			}
			else
			{	test.log(Status.FAIL, "Registration Topic Not Displayed");
			}
			assistantPage.RegistrationTopic.click();
			Thread.sleep(4000);
			//generalFunctions.isElementPresent(assistantPage.pageTitle, 30);
			if(generalFunctions.getText(assistantPage.RegistrationTopic).contains("REGISTRATION/YOUR ACCOUNT"))
			{
				test.log(Status.PASS, "REGISTRATION related questions page Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "REGISTRATION related questions page Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			try
			{
				if(assistantPage.questionsList.isDisplayed()==true)
				{	test.log(Status.PASS, "REGISTRATION related questions list Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}
			}
			catch(Exception x)
			{	test.log(Status.FAIL, "REGISTRATION related questions list Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			assistantPage.firstQuestion.click();
			generalFunctions.isElementPresent(assistantPage.firstQuestionAnswer, 20);
			if(generalFunctions.getText(assistantPage.firstQuestionAnswer)!="")
			{	test.log(Status.PASS, "Answer Displayed for the selected question").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Answer Not Displayed for the selected question").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			assistantPage.pageBack.click();
			
			if(generalFunctions.isElementPresent(assistantPage.ShareWalletTopic, 10))
			{	test.log(Status.PASS, "Share Wallet Topic Displayed");
			}
			else
			{	test.log(Status.FAIL, "Share Wallet Topic Not Displayed");
			}
			assistantPage.ShareWalletTopic.click();
			generalFunctions.isElementPresent(assistantPage.questionsList, 10);
			if(generalFunctions.getText(assistantPage.pageTitleWallet).contains("SHARE WALLET"))
			{	test.log(Status.PASS, "SHARE WALLET related questions page Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "SHARE WALLET related questions page Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			if(generalFunctions.isElementPresent(assistantPage.questionsList, 30))
			{	test.log(Status.PASS, "SHARE WALLET related questions list Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "SHARE WALLET related questions list Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			assistantFunctions.questionsClick();
			//assistantPage.firstQuestion.click();
			generalFunctions.isElementPresent(assistantPage.firstQuestionAnswer, 20);
			if(generalFunctions.getText(assistantPage.firstQuestionAnswer)!="")
			{	test.log(Status.PASS, "Answer Displayed for the selected question").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Answer Not Displayed for the selected question").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			assistantPage.backAssistant.click();

			if(generalFunctions.isElementPresent(assistantPage.sharePointsTopic, 10))
			{	test.log(Status.PASS, "About Share Points Topic Displayed");
			}
			else
			{	test.log(Status.FAIL, "About Share Points Topic Not Displayed");
			}
			assistantPage.sharePointsTopic.click();
			generalFunctions.isElementPresent(assistantPage.questionsList, 10);
			if(generalFunctions.getText(assistantPage.pageTitleSPoints).contains("SHARE POINTS"))
			{	test.log(Status.PASS, "ABOUT SHARE POINTS related questions page Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "ABOUT SHARE POINTS related questions page Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			if(generalFunctions.isElementPresent(assistantPage.questionsList, 10))
			{	test.log(Status.PASS, "ABOUT SHARE POINTS related questions list Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "ABOUT SHARE POINTS related questions list Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			assistantFunctions.questionsClick();
			generalFunctions.isElementPresent(assistantPage.firstQuestionAnswer, 20);
			if(generalFunctions.getText(assistantPage.firstQuestionAnswer)!="")
			{	test.log(Status.PASS, "Answer Displayed for the selected question").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Answer Not Displayed for the selected question").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			assistantPage.backAssistant.click();

			if(generalFunctions.isElementPresent(assistantPage.earningSharePointsTopic, 10))
			{	test.log(Status.PASS, "Earning Share Points Topic Topic Displayed");
			}
			else
			{	test.log(Status.FAIL, "Earning Share Points Topic Not Displayed");
			}
			assistantPage.earningSharePointsTopic.click();
			generalFunctions.isElementPresent(assistantPage.questionsList, 10);
			if(generalFunctions.getText(assistantPage.pageTitleEarn).contains("EARNING POINTS"))
			{	test.log(Status.PASS, "EARNING SHARE POINTS related questions page Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "EARNING SHARE POINTS related questions page Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			if(generalFunctions.isElementPresent(assistantPage.questionsList, 10))
			{	test.log(Status.PASS, "EARNING SHARE POINTS related questions list Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "EARNING SHARE POINTS related questions list Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			assistantFunctions.questionsClick();
			generalFunctions.isElementPresent(assistantPage.firstQuestionAnswer, 20);
			if(generalFunctions.getText(assistantPage.firstQuestionAnswer)!="")
			{	test.log(Status.PASS, "Answer Displayed for the selected question").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Answer Not Displayed for the selected question").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			assistantPage.backAssistant.click();

/*
			if(generalFunctions.isElementPresent(assistantPage.redeemSharePointsTopic, 10))
			{
				test.log(Status.PASS, "Redeem Share Points Topic Topic Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Redeem Share Points Topic Not Displayed");

			}

			assistantPage.redeemSharePointsTopic.click();
			generalFunctions.isElementPresent(assistantPage.questionsList, 30);
			if(generalFunctions.getText(assistantPage.pageTitleRedeem).contains("REDEEMING POINTS"))
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
				if(generalFunctions.isElementPresent(assistantPage.questionsList, 10))
				{
					test.log(Status.PASS, "REDEEMING SHARE POINTS related questions list Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "REDEEMING SHARE POINTS related questions list Not Displayed");
				Assert.fail("REDEEMING SHARE POINTS related questions list Not Displayed");
			}

			assistantFunctions.questionsClick();
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

			assistantPage.backAssistant.click();

*/
			if(generalFunctions.isElementPresent(assistantPage.familyGroupTopic, 10))
			{	test.log(Status.PASS, "Share Family Group Topic Displayed");
			}
			else
			{	test.log(Status.FAIL, "Share Family Group Topic Not Displayed");
			}
			assistantPage.familyGroupTopic.click();
			generalFunctions.isElementPresent(assistantPage.questionsList, 10);
			if(generalFunctions.getText(assistantPage.pageTitleFamily).contains("SHARE FAMILY GROUP"))
			{	test.log(Status.PASS, "SHARE FAMILY GROUP related questions page Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "SHARE FAMILY GROUP related questions page Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			if(generalFunctions.isElementPresent(assistantPage.questionsList, 10))
			{	test.log(Status.PASS, "SHARE FAMILY GROUP related questions list Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "SHARE FAMILY GROUP related questions list Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			assistantFunctions.questionsClick();
			generalFunctions.isElementPresent(assistantPage.firstQuestionAnswer, 20);
			if(generalFunctions.getText(assistantPage.firstQuestionAnswer)!="")
			{	test.log(Status.PASS, "Answer Displayed for the selected question").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Answer Not Displayed for the selected question").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			assistantPage.backAssistant.click();

/*
			if(generalFunctions.isElementPresent(assistantPage.shareIDTopic, 10))
			{
				test.log(Status.PASS, "Share At VOX Cinemas Topic Topic Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Share At VOX Cinemas Topic Not Displayed");

			}

			assistantPage.shareIDTopic.click();

			generalFunctions.isElementPresent(assistantPage.questionsList, 10);
			if(generalFunctions.getText(assistantPage.pageTitleID).contains("SHARE ID"))
			{
				test.log(Status.PASS, "'SHARE ID' related questions page Displayed");
			}
			else
			{
				test.log(Status.FAIL, "'SHARE ID' related questions page Not Displayed");

			}
			if(generalFunctions.isElementPresent(assistantPage.questionsList, 10))
			{
				test.log(Status.PASS, "SHARE ID related questions list Displayed");
			}
			else
			{
				test.log(Status.FAIL, "SHARE ID related questions list Not Displayed");
				Assert.fail("SHARE ID related questions list Not Displayed");
			}

			assistantFunctions.questionsClick();
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

			assistantPage.backAssistant.click();
*/

			if(generalFunctions.isElementPresent(assistantPage.shareWorldTopic, 10))
			{	test.log(Status.PASS, "Share At Carrefour Topic Displayed");
			}
			else
			{	test.log(Status.FAIL, "Share At Carrefour Topic Not Displayed");
			}
			assistantPage.shareWorldTopic.click();
			generalFunctions.isElementPresent(assistantPage.questionsList, 10);
			if(generalFunctions.getText(assistantPage.pageTitleWorld).contains("YOUR SHARE WORLD"))
			{	test.log(Status.PASS, "YOUR SHARE WORLD related questions page Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "YOUR SHARE WORLD related questions page Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			if(generalFunctions.isElementPresent(assistantPage.questionsList, 10))
			{
				test.log(Status.PASS, "YOUR SHARE WORLD related questions list Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "YOUR SHARE WORLD related questions list Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			assistantFunctions.questionsClick();
			generalFunctions.isElementPresent(assistantPage.firstQuestionAnswer, 20);
			if(generalFunctions.getText(assistantPage.firstQuestionAnswer)!="")
			{	test.log(Status.PASS, "Answer Displayed for the selected question").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Answer Not Displayed for the selected question").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			assistantPage.backAssistant.click();
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority=4)
	public void TC_Assistant_006_007(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant Faq");
		test.assignCategory("ASSISTANT");
		System.out.println(TC_Method);
		AssistantPage assistantPage = new AssistantPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{
			driver.resetApp();
			signInFunctions.SignContinue();
			signInFunctions.quickSignIn();
			generalFunctions.isElementPresent(assistantPage.AssistantIcon, 60);
			assistantPage.AssistantIcon.click();

			//Verify Assistant Page displayed
			if(generalFunctions.isElementPresent(assistantPage.assistantPage, 30))
			{	test.log(Status.PASS, "Assistant Page Displayed");
			}
			else
			{	test.log(Status.FAIL, "Assistant Page Not Displayed");
			}

			//Verify Share Basics Section
			if(generalFunctions.isElementPresent(assistantPage.shareBasicsSection, 10))
			{	test.log(Status.PASS, "Top Share tips/Share Basics Section Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Top Share tips/Share Basics Section Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			if(generalFunctions.isElementPresent(assistantPage.usingShare, 10))
			{	test.log(Status.PASS, "Using Share - Share Basics Displayed");
			}
			else
			{	test.log(Status.FAIL, "Using Share - Share Basics Not Displayed");
			}
			assistantPage.usingShare.click();

			generalFunctions.isElementPresent(assistantPage.pageTitleShareBasics, 10);
			if(generalFunctions.getText(assistantPage.pageTitleShareBasics).contains("SHARE BASICS"))
			{	test.log(Status.PASS, "SHARE BASICS page Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "SHARE BASICS page Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			if(generalFunctions.getText(assistantPage.Description)!="")
			{	test.log(Status.PASS, "Using Share Description Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Using Share Description Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			assistantPage.backAssistant.click();

			if(generalFunctions.isElementPresent(assistantPage.usingSharewallet, 10))
			{	test.log(Status.PASS, "Using the SHARE Wallet - Share Basics Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Using the SHARE Wallet - Share Basics Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			assistantPage.usingSharewallet.click();
			generalFunctions.isElementPresent(assistantPage.pageTitleShareBasics, 10);
			if(generalFunctions.getText(assistantPage.pageTitleShareBasics).contains("SHARE BASICS"))
			{	test.log(Status.PASS, "SHARE BASICS page Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "SHARE BASICS page Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			if(generalFunctions.getText(assistantPage.Description)!="")
			{	test.log(Status.PASS, "Using the SHARE Wallet Description Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Using the SHARE Wallet Description Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			assistantPage.backAssistant.click();

			if(generalFunctions.isElementPresent(assistantPage.earningSHAREPoints, 10))
			{	test.log(Status.PASS, "Earning SHARE points - Share Basics Displayed");
			}
			else
			{	test.log(Status.FAIL, "Earning SHARE points - Share Basics Not Displayed");
			}

			assistantPage.earningSHAREPoints.click();
			generalFunctions.isElementPresent(assistantPage.pageTitleShareBasics, 10);
			if(generalFunctions.getText(assistantPage.pageTitleShareBasics).contains("SHARE BASICS"))
			{	test.log(Status.PASS, "SHARE BASICS page Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "SHARE BASICS page Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			if(generalFunctions.getText(assistantPage.Description)!="")
			{	test.log(Status.PASS, "Earning SHARE points Description Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Earning SHARE points Description Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			assistantPage.backAssistant.click();
/*

			if(generalFunctions.isElementPresent(assistantPage.numberOFPointsEarned, 20))
			{
				test.log(Status.PASS, "Number of points Earned- Share Basics Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Number of points Earned - Share Basics Not Displayed");

			}

			assistantPage.numberOFPointsEarned.click();


			generalFunctions.isElementPresent(assistantPage.pageTitleShareBasics, 30);
			if(generalFunctions.getText(assistantPage.pageTitleShareBasics).contains("SHARE BASICS"))
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
				test.log(Status.PASS, "Number of points Earned points Description Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Number of points Earned Description Not Displayed");
				Assert.fail("Number of points Earned Description Not Displayed");
			}

			assistantPage.backAssistant.click();

			if(generalFunctions.isElementPresent(assistantPage.redeemingSHAREPoints, 20))
			{
				test.log(Status.PASS, "Redeeming SHARE points - Share Basics Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Redeeming SHARE points - Share Basics Not Displayed");

			}

			assistantPage.redeemingSHAREPoints.click();


			generalFunctions.isElementPresent(assistantPage.pageTitleShareBasics, 10);
			if(generalFunctions.getText(assistantPage.pageTitleShareBasics).contains("SHARE BASICS"))
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

			assistantPage.backAssistant.click();
*/
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority=5)
	public void TC_Assistant_008_009_010(Method method) throws Exception
	{

		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant Faq");
		test.assignCategory("ASSISTANT");
		System.out.println(TC_Method);
		AssistantPage assistantPage = new AssistantPage(driver);
		String searchKeyWord="wallet";
		String searchKeyWord2="family";
		String searchKeyWord3="offer";
		try
		{
			generalFunctions.isElementPresent(assistantPage.AssistantIcon, 30);
			assistantPage.AssistantIcon.click();

			//Verify Assistant Page displayed
			if(generalFunctions.isElementPresent(assistantPage.assistantPage, 30))
			{	test.log(Status.PASS, "Assistant Page Displayed");
			}
			else
			{	test.log(Status.FAIL, "Assistant Page Not Displayed");
			}
			//Verify Search Icon
			if(generalFunctions.isElementPresent(assistantPage.searchIcon, 10))
			{	test.log(Status.PASS, "Search Icon Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Search Icon Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			assistantPage.searchIcon.click();
			generalFunctions.isElementPresent(assistantPage.searchTitle, 20);
			if(generalFunctions.getText(assistantPage.searchTitle).contains("SEARCH"))
			{	test.log(Status.PASS, "SEARCH page Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "SEARCH page Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			assistantPage.searchField.click();
			assistantPage.searchField.sendKeys(searchKeyWord);
			generalFunctions.pressSearch();
			if(generalFunctions.isElementPresent(assistantPage.searchResult, 30))
			{	test.log(Status.PASS, "Search Result Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Search Result Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			assistantPage.backAssistant.click();
			assistantPage.searchIcon.click();
			if(generalFunctions.isElementPresent(assistantPage.recentSearchItem, 20))
			{	test.log(Status.PASS, "Recent Search Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Recent Search Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			generalFunctions.isElementPresent(assistantPage.searchField, 30);
			assistantPage.searchField.click();
			assistantPage.searchField.sendKeys(searchKeyWord2);
			generalFunctions.pressSearch();
			if(generalFunctions.isElementPresent(assistantPage.searchResult, 30))
			{	test.log(Status.PASS, "Search Result Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "Search Result Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			assistantPage.backAssistant.click();
			assistantPage.searchIcon.click();
			generalFunctions.isElementPresent(assistantPage.searchField, 30);
			assistantPage.searchField.click();
			assistantPage.searchField.sendKeys(searchKeyWord3);
			generalFunctions.pressSearch();
			if(generalFunctions.isElementPresent(assistantPage.searchResult, 30))
			{	test.log(Status.PASS, "Search Result Displayed");
			}
			else 
			{test.log(Status.FAIL, "Search Result Not Displayed");
			}
			assistantPage.backAssistant.click();
			assistantPage.searchIcon.click();
			List<MobileElement> searchText = assistantPage.recentSearchItem.findElementsByClassName("android.view.ViewGroup");
			String searchfirst = searchText.get(1).findElementByClassName("android.widget.TextView").getText();
			String searchSecond = searchText.get(2).findElementByClassName("android.widget.TextView").getText();
			String searchThird = searchText.get(3).findElementByClassName("android.widget.TextView").getText();
			try
			{
				System.out.println("TT"+searchfirst+searchSecond+searchThird);
				if(searchThird.equalsIgnoreCase(searchKeyWord)&&searchSecond.equalsIgnoreCase(searchKeyWord2)
						&&searchfirst.equalsIgnoreCase(searchKeyWord3))
				{
					test.log(Status.PASS, "Recent 3 Search keywords Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Recent 3 Search keywords Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			assistantPage.clearButton.click();
			if(generalFunctions.isElementPresent(assistantPage.trySearching, 30))
			{	test.log(Status.PASS, "Try Searching Displayed");
			}
			else
			{	test.log(Status.FAIL, "Try Searching Not Displayed");
			}
			assistantPage.backAssistant.click();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}


	@Test(priority=6)
	public void TC_Assistant_010(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant Faq");
		test.assignCategory("ASSISTANT");
		System.out.println(TC_Method);
		AssistantPage assistantPage = new AssistantPage(driver);
		String searchKeyWord="family";
		try
		{
			generalFunctions.isElementPresent(assistantPage.AssistantIcon, 60);
			assistantPage.AssistantIcon.click();

			//Verify Assistant Page displayed
			try
			{
				if(assistantPage.assistantPage.isDisplayed()==true)
				{	test.log(Status.PASS, "Assistant Page Displayed");
				}
			}
			catch(Exception x)
			{	test.log(Status.FAIL, "Assistant Page Not Displayed");
			}

			//Verify Search Icon
			try
			{
				if(assistantPage.searchIcon.isDisplayed()==true)
				{
					test.log(Status.PASS, "Search Icon Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Search Icon Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Search Icon Not Displayed");
			}
			assistantPage.searchIcon.click();
			generalFunctions.isElementPresent(assistantPage.searchTitle, 30);
			if(generalFunctions.getText(assistantPage.searchTitle).contains("SEARCH"))
			{	test.log(Status.PASS, "SEARCH page Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "SEARCH page Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			assistantPage.searchField.click();
			assistantPage.searchField.sendKeys(searchKeyWord);
			generalFunctions.pressSearch();
			Thread.sleep(1000);
			try
			{
				generalFunctions.isElementPresent(assistantPage.searchResultcarrefour, 30);
				if(assistantPage.searchResultcarrefour.isDisplayed()==true)
				{
					test.log(Status.PASS, "Search Result Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Search Result Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Search Result Not Displayed");
			}
			assistantPage.searchResultcarrefour.click();
			try
			{
				generalFunctions.isElementPresent(assistantPage.answerDetailsPage, 30);
				if(assistantPage.answerDetailsPage.isDisplayed()==true)
				{
					test.log(Status.PASS, "Search Result Details screen Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Search Result Details screen Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Search Result Details screen Not Displayed");
			}
			try
			{
				if(assistantPage.assistantQuestion.isDisplayed()==true)
				{
					test.log(Status.PASS, "Search Result Question Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Search Result Question Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(500);
			generalFunctions.isElementPresent(assistantPage.pageTitle, 30);
			if(generalFunctions.getText(assistantPage.pageTitle).contains("SEARCH"))
			{	test.log(Status.PASS, "SEARCH page Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "SEARCH page Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(priority=7)
	public void TC_Assistant_011(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant Faq");
		test.assignCategory("ASSISTANT");
		System.out.println(TC_Method);
		AssistantPage assistantPage = new AssistantPage(driver);
		String searchKeyWord="health";
		try
		{
			generalFunctions.isElementPresent(assistantPage.AssistantIcon, 60);
			assistantPage.AssistantIcon.click();
			Thread.sleep(500);

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
			Thread.sleep(500);
			generalFunctions.isElementPresent(assistantPage.pageTitle, 30);
			if(generalFunctions.getText(assistantPage.pageTitle).contains("SEARCH"))
			{	test.log(Status.PASS, "SEARCH page Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{	test.log(Status.FAIL, "SEARCH page Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			assistantPage.searchField.click();
			assistantPage.searchField.sendKeys(searchKeyWord);
			generalFunctions.pressSearch();
			Thread.sleep(500);
			try
			{
				generalFunctions.isElementPresent(assistantPage.noResult, 30);
				if(assistantPage.noResult.isDisplayed()==true)
				{
					test.log(Status.PASS, "SORRY, NO RESULT FOUND message displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "SORRY, NO RESULT FOUND message displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("SORRY, NO RESULT FOUND message displayed");
			}
			assistantPage.backAssistant.click();
			Thread.sleep(500);
			assistantPage.searchIcon.click();
			Thread.sleep(500);
			assistantPage.searchClear.click();
			assistantPage.backAssistant.click();
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}


	/*
	//Descoped
	public void TC_01_18(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant Faq");
		test.assignCategory("ASSISTANT");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		AssistantPage assistantPage = new AssistantPage(driver);

		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();
		String searchKeyWord="health";
		try
		{
			driver.resetApp();
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
	 */
	@Test(priority=8)
	public void TC_Assistant_012(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant - Call us");
		test.assignCategory("ASSISTANT");
		System.out.println(TC_Method);
		AssistantPage assistantPage = new AssistantPage(driver);
		try
		{
			// Click Experiences
			//Thread.sleep(1000);
			generalFunctions.isElementPresent(assistantPage.AssistantIcon, 60);
			assistantPage.AssistantIcon.click();
			Thread.sleep(1000);

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
		
			generalFunctions.SimplyScrollDown();

			//Verify Call Us Section
			try
			{
				if(assistantPage.callUsSection.isDisplayed()==true)
				{
					test.log(Status.PASS, "Call Us Section Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Call Us Section Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
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
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(300);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	//Sprint 16 implementation
	@Test(priority=9)
	public void TC_Assistant_013(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant Chat");
		test.assignCategory("ASSISTANT");
		test.log(Status.INFO, "TC: Verify user able to view the chat option in assitant module");
		System.out.println(TC_Method);
		AssistantPage assistantPage = new AssistantPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{
			driver.resetApp();
			signInFunctions.SignContinue();
			signInFunctions.quickSignIn();
			// Click Experiences
			//Thread.sleep(5000);
			generalFunctions.isElementPresent(assistantPage.AssistantIcon, 30);
			assistantPage.AssistantIcon.click();
			//Verify Assistant Page displayed
			if(generalFunctions.isElementPresent(assistantPage.assistantPage,30))
			{
				test.log(Status.PASS, "Assistant Page Displayed");
			}else{
				test.log(Status.FAIL, "Assistant Page Not Displayed");
			}
			
			//Verify Search Icon
			if(generalFunctions.isElementPresent(assistantPage.assistantchaticon,30))
			{
				test.log(Status.PASS, "Assistant Chat icon Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else{
				test.log(Status.FAIL, "Assistant Chat icon Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	
	@Test(priority=10)
	public void TC_Assistant_014(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Assistant Chat");
		test.assignCategory("ASSISTANT");
		test.log(Status.INFO, "TC: Verify the user able to view Chat Screen with automated chat box message from assitant module");
		System.out.println(TC_Method);
		AssistantPage assistantPage = new AssistantPage(driver);
		ZendeskChatPage zendeskchatpage = new ZendeskChatPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{
			driver.resetApp();
			signInFunctions.SignContinue();
			signInFunctions.quickSignIn();
			// Click Experiences
			//Thread.sleep(5000);
			generalFunctions.isElementPresent(assistantPage.AssistantIcon, 30);
			assistantPage.AssistantIcon.click();
			//Verify Assistant Page displayed
			if(generalFunctions.isElementPresent(assistantPage.assistantPage,30))
			{
				test.log(Status.PASS, "Assistant Page Displayed");
			}else{
				test.log(Status.FAIL, "Assistant Page Not Displayed");
			}
			
			//Verify Search Icon
			if(generalFunctions.isElementPresent(assistantPage.assistantchaticon,30))
			{
				test.log(Status.PASS, "Assistant Chat icon Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else{
				test.log(Status.FAIL, "Assistant Chat icon Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			
			assistantPage.assistantchaticon.click();
			
			if(generalFunctions.isElementPresent(zendeskchatpage.chatscreen, 20)) {
				test.log(Status.PASS, "User should be able to view Chat Screen from Assistant Screen").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else {
				test.log(Status.FAIL, "User is not able to view Chat Screen from Assistant Screen").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
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
