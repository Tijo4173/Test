package com.share.testscript;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.share.functions.FamilyFunctions;
import com.share.functions.RegistrationFunctions;
import com.share.functions.SignInFunctions;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.FamilyPage;
import com.share.objectrepository.HomePage;
import com.share.objectrepository.RegistrationPage;
import com.share.objectrepository.SignInPage;
import com.share.utility.Utilities;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Family extends DriverSetUp
{
	GeneralFunctions generalFunctions = new GeneralFunctions();
	//Verify family Head can send Invites-User: New User
	@Test
	public void TC_Family_001(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module:Family").assignCategory("FAMILY");
		test.info("Verify family Head/member can send Invites");
		System.out.println(TC_Method);
		String EmailAddress= "smtestqa2@yopmail.com";
		String Pass= "Test@123";
		String InviteEmailAddress=map.get("InviteEmailAddress").toString();
		RegistrationPage registrationPage= new RegistrationPage(driver);
		FamilyPage familyPage = new FamilyPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		FamilyFunctions familyFunctions = new FamilyFunctions();
		SignInFunctions signInFunctions = new SignInFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{
			driver.resetApp();
			signInFunctions.SignContinue();
			//LOGIN//can use new user
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Member Invite
			familyFunctions.FamilyInviteNew(familyPage);

			//Click on EmailAddressField
			System.out.println(InviteEmailAddress);
			familyPage.emailAddressField.sendKeys(InviteEmailAddress);

			//Click on SendInviteButton

			if(generalFunctions.isElementPresent(familyPage.sendInviteButton, 10))
			{
				test.log(Status.PASS, "SendInviteButton Displayed");
				familyPage.sendInviteButton.click();
			}
			else
			{
				test.log(Status.FAIL, "SendInviteButton Not Displayed");
				Assert.fail("Group Icon Not Displayed");
			}

			//Click on Done Button
			if(generalFunctions.isElementPresent(familyPage.doneButton, 20))
			{
				test.log(Status.PASS, "DoneButton Dispalyed: "+familyPage.sendInviteScreen.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				//	familyPage.DoneButton.click();

			}
			else
			{
				test.log(Status.FAIL, "DoneButton Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("DoneButton Not Displayed");
			}

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}


	}

	//Verify that error alert is displayed for invalid email id//User: FamilyHead
	@Test
	public void TC_Family_002(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module:Family").assignCategory("FAMILY");
		test.info("Verify that error alert is displayed for invalid email id");
		System.out.println(TC_Method);
		String EmailAddress=map.get("NameUser").toString();
		String Pass=map.get("PassCode").toString();
		String InvalidEmailAddress=map.get("InvalidEmailAddress").toString();
		RegistrationPage registrationPage= new RegistrationPage(driver);
		FamilyPage familyPage = new FamilyPage(driver);
		HomePage homePage = new HomePage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		FamilyFunctions familyFunctions = new FamilyFunctions();
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{
			driver.resetApp();
			signInFunctions.SignContinue();
			//LOGIN//can use new user
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//FamilyInvite
			familyFunctions.FamilyInvite(familyPage);
			
			//Click on EmailAddressField
			familyPage.emailAddressField.sendKeys(InvalidEmailAddress);
			//Thread.sleep(2000);

			//Click on SendInviteButton
			if(generalFunctions.isElementPresent(familyPage.invalidEmailWarning, 30))
			{
				test.log(Status.PASS, "Error message displayed: "+familyPage.invalidEmailWarning.getText());
			}
			else
			{
				test.log(Status.FAIL, "Please Enter a Valid email address Not Displayed");
				Assert.fail("Please Enter a Valid email address Not Displayed");
			}
			familyPage.back_button1.click();
			generalFunctions.isElementPresent(familyPage.balanceValue, 60);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			generalFunctions.isElementPresent(homePage.homeElement, 20);

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	//Verify user is unable to invite a member who is already a part of the Family//User-Family head
	@Test
	public void TC_Family_003(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module:Family").assignCategory("FAMILY");
		test.info("Verify user is unable to invite a member who is already a part of the Family ");
		System.out.println(TC_Method);
		String EmailAddress=map.get("NameUser").toString();
		String Pass=map.get("PassCode").toString();
		String AlreadyMemberId=map.get("AlreadyMemberId").toString();
		RegistrationPage registrationPage= new RegistrationPage(driver);
		HomePage homePage = new HomePage(driver);
		FamilyPage familyPage = new FamilyPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		FamilyFunctions familyFunctions = new FamilyFunctions();
		SignInFunctions signInFunctions = new SignInFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{
			driver.resetApp();
			signInFunctions.SignContinue();
			//LOGIN//
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//FamilyInviteExistingMember function calling
			familyFunctions.FamilyInviteExistingMember(familyPage);

			//Click on EmailAddressField
			System.out.println(AlreadyMemberId);
			familyPage.emailAddressField.sendKeys(AlreadyMemberId);

			//Click on SendInviteButton
			if(generalFunctions.isElementPresent(familyPage.sendInviteButton, 30))
			{
				test.log(Status.PASS, "SendInviteButton Dispalyed");
				familyPage.sendInviteButton.click();
			}
			else
			{
				test.log(Status.FAIL, "SendInviteButton Not Displayed");
				Assert.fail("SendInviteButton Not Displayed");
			}
			//ExistingMemberErrorMessage
			generalFunctions.isElementPresent(familyPage.sendInviteScreen, 30);

			if(familyPage.sendInviteScreen.getText().matches("Invite not sent")) {
				test.log(Status.PASS, "ExistingMemberErrorMessage Dispalyed: "+familyPage.statusDescription.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "ExistingMemberErrorMessage Not Displayed: "+familyPage.statusDescription.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("ExistingMemberErrorMessage Not Displayed");
			}

			//Click on DoneButton
			if(generalFunctions.isElementPresent(familyPage.doneButton, 30))
			{
				test.log(Status.PASS, "DoneButton Dispalyed");
				familyPage.doneButton.click();
			}
			else
			{
				test.log(Status.FAIL, "DoneButton Not Displayed");
				Assert.fail("DoneButton Not Displayed");
			}
			generalFunctions.isElementPresent(familyPage.balanceValue, 60);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			generalFunctions.isElementPresent(homePage.homeElement, 20);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	//Verify the error message is displayed when the head is adding the Member who is a part of another family group//User:FamilyHead
	@Test
	public void TC_Family_004(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module:Family").assignCategory("FAMILY");
		test.info("Verify the error message is displayed when the head is adding the Member who is a part of another family group");
		System.out.println(TC_Method);
		String EmailAddress=map.get("NameUser").toString();
		String Pass=map.get("PassCode").toString();
		String AnotherMemberId=map.get("AnotherGroupMember").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		HomePage homePage = new HomePage(driver);
		FamilyPage familyPage = new FamilyPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		FamilyFunctions familyFunctions = new FamilyFunctions();
		SignInFunctions signInFunctions = new SignInFunctions();
		SignInPage signInPage = new SignInPage(driver);

		try
		{
			driver.resetApp();
			signInFunctions.SignContinue();

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//FamilyIconClick
			familyFunctions.FamilyInviteExistingMember(familyPage);

			//Click on EmailAddressField
			generalFunctions.isElementPresent(familyPage.emailAddressField, 60);
			familyPage.emailAddressField.sendKeys(AnotherMemberId);

			//Click on SendInviteButton
			if(generalFunctions.isElementPresent(familyPage.sendInviteButton, 60))
			{
				test.log(Status.PASS, "SendInviteButton Dispalyed");
				familyPage.sendInviteButton.click();
			}
			else
			{
				test.log(Status.FAIL, "SendInviteButton Not Displayed");
				Assert.fail("SendInviteButton Not Displayed");
			}


			//ExistingMemberErrorMessage
			generalFunctions.isElementPresent(familyPage.sendInviteScreen, 30);

			if(familyPage.sendInviteScreen.getText().matches("Invite not sent")) {
				test.log(Status.PASS, "ExistingMemberErrorMessage Dispalyed: "+familyPage.statusDescription.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "ExistingMemberErrorMessage Not Displayed: "+familyPage.statusDescription.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("ExistingMemberErrorMessage Not Displayed");
			}

			//Click on DoneButton
			if(generalFunctions.isElementPresent(familyPage.doneButton, 60))
			{
				test.log(Status.PASS, "DoneButton Dispalyed");
				familyPage.doneButton.click();
			}
			else
			{
				test.log(Status.FAIL, "DoneButton Not Displayed");
				Assert.fail("DoneButton Not Displayed");
			}
			generalFunctions.isElementPresent(familyPage.balanceValue, 60);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			generalFunctions.isElementPresent(homePage.homeElement, 20);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	//Verify Non Share member is asked to download the app when member doesn’t have the app installed
	//	@Test
	//	public void TC_Family_005(Method method) throws Exception
	//	{
	//		String TC_Method = method.getName();
	//		test = extent.createTest(TC_Method);
	//		test.log(Status.INFO, "Module:Family").assignCategory("Family");
	//		test.info("Verify Non Share member is asked to download the app when member doesn’t have the app installed");
	//		System.out.println(TC_Method);
	//		String EmailAddress=map.get("NameUser").toString();
	//		String Pass=map.get("PassCode").toString();
	//		String InviteEmailAddress=map.get("InviteEmailAddress").toString();
	//
	//		RegistrationPage registrationPage= new RegistrationPage(driver);
	//		HomePage homePage = new HomePage(driver);
	//		FamilyPage familyPage = new FamilyPage(driver);
	//		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
	//		FamilyFunctions familyFunctions = new FamilyFunctions();
	//		SignInPage signInPage = new SignInPage(driver);
	//		try
	//		{
	//			//LOGIN
	//			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);
	//
	//			//FamilyGroupClick
	//			familyFunctions.FamilyInviteExistingMember(familyPage);
	//
	//			//Click on EmailAddressField
	//			generalFunctions.isElementPresent(familyPage.emailAddressField, 60);
	//			familyPage.emailAddressField.sendKeys("smitkll@gmail.com");
	//
	//			//Click on SendInviteButton
	//			if(generalFunctions.isElementPresent(familyPage.sendInviteButton, 60))
	//			{
	//				test.log(Status.PASS, "SendInviteButton Dispalyed");
	//				familyPage.sendInviteButton.click();
	//			}
	//			else
	//			{
	//				test.log(Status.FAIL, "SendInviteButton Not Displayed");
	//				Assert.fail("SendInviteButton Not Displayed");
	//			}
	//
	//			//Click on DoneButton
	//			if(generalFunctions.isElementPresent(familyPage.doneButton, 60))
	//			{
	//				test.log(Status.PASS, "DoneButton Dispalyed");
	//				familyPage.doneButton.click();
	//			}
	//			else
	//			{
	//				test.log(Status.FAIL, "DoneButton Not Displayed");
	//				Assert.fail("DoneButton Not Displayed");
	//			}
	//
	//			//driver.startActivity(new Activity("com.google.android.gm", "com.google.android.gm.ConversationListActivityGmail"));
	//		}
	//		catch(Exception e)
	//		{
	//			test.log(Status.FAIL, e.getMessage());
	//			Assert.fail(e.getMessage());
	//		}
	//	}

	//Verify a Family head to able to share the point with the other members//User: Family Head
	@Test
	public void TC_Family_006(Method method) throws Exception{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module:Family").assignCategory("FAMILY");
		test.info("Verify a Family head to able to share the point with the other members");
		System.out.println(TC_Method);
		String EmailAddress=map.get("NameUser").toString();
		String Pass=map.get("PassCode").toString();
		String Points = "10.00";

		RegistrationPage registrationPage= new RegistrationPage(driver);
		HomePage homePage = new HomePage(driver);
		FamilyPage familyPage = new FamilyPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInFunctions signInFunctions = new SignInFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{
			driver.resetApp();
			signInFunctions.SignContinue();
			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//FamilyGroupClick
			if(generalFunctions.isElementPresent(familyPage.familyGroupIcon, 60))
			{
				test.log(Status.PASS, "Group Icon Dispalyed");
				familyPage.familyGroupIcon.click();

			}
			else
			{
				test.log(Status.FAIL, "Group Icon Not Displayed");
				Assert.fail("Group Icon Not Displayed");
			}
			generalFunctions.isElementPresent(familyPage.balanceValue, 60);
			String _name = familyPage.familyMemberName.getText();
			System.out.println(_name);

			generalFunctions.isElementPresent(familyPage.familyMemberName, 30);
			familyPage.familyMember.click();
			generalFunctions.isElementPresent(familyPage.familyPointBalance, 60);

			//familyPage.pointsField.click();
			familyPage.pointsField.sendKeys(Points);

			String _pointbalance = familyPage.familyPointBalance.getText();
			System.out.println(_pointbalance);
			//driver.hideKeyboard();

			familyPage.getPointsButton.click();
			Thread.sleep(3000);
			generalFunctions.isElementPresent(familyPage.pointsSuccessMessage, 60);
			String _pointSuccessMessage = familyPage.pointsSuccessMessage.getText();

			if(_pointSuccessMessage.contains(_name) && _pointSuccessMessage.contains(Points))
			{
				System.out.println("Displayed member name and points:"+_name+":"+Points);
				test.log(Status.PASS, "Name displayed in success message:"+_pointSuccessMessage);
			}
			else
			{
				test.log(Status.FAIL, "Name or Points not displayed in success message");
				Assert.fail("Name or Points not displayed in success message");
			}
			familyPage.thanksButton.click();
			generalFunctions.isElementPresent(familyPage.familyPointBalance, 60);

			System.out.println(_pointbalance);
			System.out.println(Points);

			String _newpointbalance = _pointbalance.replaceAll(",", "");
			double updatedPointBalance = Double.valueOf(_newpointbalance) - Double.valueOf(Points);
			System.out.println("updatedPointBalance "+updatedPointBalance);

			String _finalpointbalance = familyPage.familyPointBalance.getText();
			_finalpointbalance = _finalpointbalance.replaceAll(",", "");

			System.out.println("_finalpointbalance "+_finalpointbalance);
			Thread.sleep(3000);

			if(String.valueOf(_finalpointbalance).contentEquals(String.valueOf(updatedPointBalance)))
			{
				System.out.println("PASS");
				test.log(Status.PASS, "Final balance Points are correct");
			}

			else
			{
				System.out.println("Fail,Final balance Points are not correct");
				test.log(Status.FAIL, "Final balance Points are not correct");
				Assert.fail("Final balance Points are not correct");
			}

			//Thread.sleep(2000);
			familyPage.back_button1.click();
			generalFunctions.isElementPresent(familyPage.balanceValue, 60);
			familyPage.back_button2.click();
			generalFunctions.isElementPresent(homePage.homeElement, 20);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	//Need to check
	//verify the member list is displayed//User:Family Head
	@Test
	public void TC_Family_007_009(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Family").assignCategory("FAMILY");
		test.info("Verify family head is able to invite a new member as now the group is not fill");
		System.out.println(TC_Method);
		String EmailAddress=map.get("NameUser").toString();
		String Pass=map.get("PassCode").toString();
		String InviteEmailAddress=map.get("InviteEmailAddress").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		HomePage homePage = new HomePage(driver);
		FamilyPage familyPage = new FamilyPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		FamilyFunctions familyFunctions = new FamilyFunctions();
		SignInFunctions signInFunctions = new SignInFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{
			driver.resetApp();
			signInFunctions.SignContinue();
			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Family group click
			familyFunctions.FamilyInvite(familyPage);

			if(!familyPage.sendInviteButton.isEnabled())
			{
				test.log(Status.PASS, "SendInviteButton not enabled");
			}
			else
			{
				test.log(Status.FAIL, "SendInviteButton enabled");
				Assert.fail("SendInviteButton enabled");

			}
			//Click on EmailAddressField

			familyPage.emailAddressField.sendKeys(InviteEmailAddress);

			//Click on SendInviteButton

			if(generalFunctions.isElementPresent(familyPage.sendInviteButton, 30))
			{
				test.log(Status.PASS, "SendInviteButton Dispalyed");
				familyPage.sendInviteButton.click();
			}
			else
			{
				test.log(Status.FAIL, "SendInviteButton Not Displayed");
				Assert.fail("SendInviteButton Not Displayed");

			}

			//Click on DoneButton
			if(generalFunctions.isElementPresent(familyPage.doneButton, 30))
			{
				test.log(Status.PASS, "DoneButton Dispalyed");
			}
			else
			{
				test.log(Status.FAIL, "DoneButton Not Displayed");
				Assert.fail("DoneButton Not Displayed");
			}
			familyPage.doneButton.click();
			generalFunctions.isElementPresent(familyPage.balanceValue, 60);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			generalFunctions.isElementPresent(homePage.homeElement, 20);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	//Member are unable to share/gift points more than what they have earned
	@Test
	public void TC_Family_008(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module: Family").assignCategory("FAMILY");
		test.info("Member are unable to share/gift points more than what they have earned ");
		System.out.println(TC_Method);
		String EmailAddress=map.get("NameUser").toString();
		String Pass=map.get("PassCode").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		HomePage homePage = new HomePage(driver);
		FamilyPage familyPage = new FamilyPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInFunctions signInFunctions = new SignInFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{
			driver.resetApp();
			signInFunctions.SignContinue();
			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);
			if(generalFunctions.isElementPresent(familyPage.familyGroupIcon, 30))
			{
				test.log(Status.PASS, "Group Icon Dispalyed");
				familyPage.familyGroupIcon.click();
			}
			else
			{
				test.log(Status.FAIL, "Group Icon Not Displayed");
				Assert.fail("Group Icon Not Displayed");
			}
			generalFunctions.isElementPresent(familyPage.balanceValue, 60);

			String _name = familyPage.familyMemberName.getText();
			System.out.println(_name);
			
			familyPage.familyMember.click();

			generalFunctions.isElementPresent(familyPage.familyPointBalance, 60);
			String _pointbalance = familyPage.familyPointBalance.getText();
			_pointbalance= _pointbalance.replaceAll(",", "");
			double Points = Double.parseDouble(_pointbalance) *2;
			String _finalpoints = String.valueOf(Points);
			familyPage.pointsField.click();
			familyPage.pointsField.sendKeys(_finalpoints);
			//driver.hideKeyboard();

			if(generalFunctions.isElementPresent(familyPage.errorMessageGiftPoints, 30))
			{
				System.out.println(_name+"ErrorMessageGiftPoints displayed");
				test.log(Status.PASS, "Displayed the error:"+familyPage.errorMessageGiftPoints.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				System.out.println(_name+"ErrorMessageGiftPoints not displayed");
				test.log(Status.FAIL, "Displayed the error:"+familyPage.errorMessageGiftPoints.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("ErrorMessageGiftPoints not displayed");
			}


			familyPage.back_button1.click();
			Thread.sleep(500);
			generalFunctions.isElementPresent(familyPage.balanceValue, 60);
			familyPage.back_button2.click();
			generalFunctions.isElementPresent(homePage.homeElement, 20);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	//member login
	//Verify Family member can edit and add contribution percentage to the Family group or family head
	@Test
	public void TC_Family_011(Method method) throws Exception
	{
		String TC_Method = method.getName();
		System.out.println(TC_Method);
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module:Family").assignCategory("FAMILY");
		test.info("Verify Family member can edit and add contribution percentage to the Family group or family head");

		String EmailAddress=map.get("Family_mem_user").toString();
		String Pass=map.get("Family_mem_pass").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		
		FamilyPage familyPage = new FamilyPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInFunctions signInFunctions = new SignInFunctions();
		SignInPage signInPage = new SignInPage(driver);

		try
		{
			driver.resetApp();
			signInFunctions.SignContinue();
			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			if(generalFunctions.isElementPresent(familyPage.familyGroupIcon, 30))
			{
				test.log(Status.PASS, "Group Icon Dispalyed");
				familyPage.familyGroupIcon.click();
			}else {
				test.log(Status.FAIL, "Group Icon Not Displayed");
				Assert.fail("Group Icon Not Displayed");
			}
			generalFunctions.isElementPresent(familyPage.balanceValue, 60);
			familyPage.edit_family.click();
			generalFunctions.isElementPresent(familyPage.earn_family_head, 30);

			Integer points = 30;
			familyPage.earn_family_head.sendKeys(String.valueOf(points));
			generalFunctions.isElementPresent(familyPage.family_save, 30);
			familyPage.family_save.click();
			Thread.sleep(2000);
			String desc=familyPage.family_edit_desc.getText();
			System.out.println(desc);
			Thread.sleep(1000);
			if(desc.contains("You are contributing " + points + "%"))
			{
				System.out.println("Contributing points updated and displayed:"+desc);
				test.log(Status.PASS, "Contributing points updated and displayed:" +desc);
			}
			else
			{
				test.log(Status.FAIL, "Contributing points not updated or displayed");
				Assert.fail("Contributing points not updated or displayed");
			}

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}


	//member login
	//Edit the Contribution percentage of family member to 0%
	@Test
	public void TC_Family_012(Method method) throws Exception
	{
		String TC_Method = method.getName();
		System.out.println(TC_Method);
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module:Family").assignCategory("FAMILY");
		test.info("Verify Family member / head can edit contribution to 0%");

		String EmailAddress=map.get("Family_mem_user").toString();
		String Pass=map.get("Family_mem_pass").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		
		FamilyPage familyPage = new FamilyPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{
			driver.resetApp();
			signInFunctions.SignContinue();
			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			if(familyPage.familyGroupIcon.isDisplayed())
			{
				test.log(Status.PASS, "Group Icon Dispalyed");
				familyPage.familyGroupIcon.click();
			}else {
				test.log(Status.FAIL, "Group Icon Not Displayed");
				Assert.fail("Group Icon Not Displayed");
			}
			generalFunctions.isElementPresent(familyPage.balanceValue, 60);
			familyPage.edit_family.click();

			generalFunctions.isElementPresent(familyPage.earn_family_head, 30);
			familyPage.earn_family_head.clear();
			Integer points = 0;
			familyPage.earn_family_head.sendKeys(String.valueOf(points));
			generalFunctions.isElementPresent(familyPage.family_save, 20);
			familyPage.family_save.click();

			Thread.sleep(2000);

			generalFunctions.isElementPresent(familyPage.family_edit_desc, 20);
			String desc=familyPage.family_edit_desc.getText();
			Thread.sleep(1000);
			System.out.println(desc);
			
			if(desc.contains("You are contributing " + points + "%"))
			{
				System.out.println("Contributing points updated and displayed");
				test.log(Status.PASS, "Contributing points updated and displayed:"+desc);
			}
			else
			{
				test.log(Status.FAIL, "Contributing points not updated or not displayed");
				Assert.fail("Contributing points not updated or not displayed");
			}

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}


	}

	//member login
	//Verify Family member can edit contribution to 100%
	@Test
	public void TC_Family_013(Method method) throws Exception
	{
		String TC_Method = method.getName();
		System.out.println(TC_Method);
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module: Family").assignCategory("FAMILY");;
		test.info("Verify Family member can edit contribution to 100%");


		String EmailAddress=map.get("Family_mem_user").toString();
		String Pass=map.get("Family_mem_pass").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		
		FamilyPage familyPage = new FamilyPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{
			driver.resetApp();
			signInFunctions.SignContinue();
			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			if(familyPage.familyGroupIcon.isDisplayed())
			{
				test.log(Status.PASS, "Group Icon Dispalyed");
				familyPage.familyGroupIcon.click();
			}else {
				test.log(Status.FAIL, "Group Icon Not Displayed");
				Assert.fail("Group Icon Not Displayed");
			}
			generalFunctions.isElementPresent(familyPage.balanceValue, 60);
			familyPage.edit_family.click();
			generalFunctions.isElementPresent(familyPage.earn_family_head, 30);
			familyPage.earn_family_head.clear();
			Integer points = 100;
			familyPage.earn_family_head.sendKeys(String.valueOf(points));
			generalFunctions.isElementPresent(familyPage.family_save, 20);
			familyPage.family_save.click();
			Thread.sleep(1000);
			generalFunctions.isElementPresent(familyPage.family_edit_desc, 20);
			Thread.sleep(1000);
			String desc=familyPage.family_edit_desc.getText();
			if(desc.contains("You are contributing " + points + "%"))
			{
				System.out.println("Contributing points updated and displayed");
				test.log(Status.PASS, "Contributing points updated and displayed: "+desc).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Contributing points not updated or not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Contributing points not updated or not displayed");
			}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}


	}
	//member login
	//Verify the gift points drop down list shows all group members
	@Test
	public void TC_Family_014(Method method) throws Exception
	{
		String TC_Method = method.getName();
		System.out.println(TC_Method);
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module:Family").assignCategory("FAMILY");
		test.info("Verify the gift points drop down list shows all group members");

		String EmailAddress = map.get("Family_mem_user").toString();
		String Pass = map.get("Family_mem_pass").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		HomePage homePage = new HomePage(driver);
		FamilyPage familyPage = new FamilyPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInFunctions signInFunctions = new SignInFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{
			driver.resetApp();
			signInFunctions.SignContinue();
			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);
			if(familyPage.familyGroupIcon.isDisplayed())
			{
				test.log(Status.PASS, "Group Icon Displayed");
				familyPage.familyGroupIcon.click();

			}else{
				test.log(Status.FAIL, "Group Icon Not Displayed");
				Assert.fail("Group Icon Not Displayed");
			}
			generalFunctions.isElementPresent(familyPage.balanceValue, 60);

			familyPage.family_mem.click();

			generalFunctions.isElementPresent(familyPage.familyPointBalance, 60);
			generalFunctions.isElementPresent(familyPage.family_mem_dropdown, 30);
			familyPage.family_mem_dropdown.click();
			if(generalFunctions.isElementPresent(familyPage.familyMemberList, 30))
			{
				System.out.println("Drop down of family member group is displayed");
				test.log(Status.PASS, "Drop down of family member grouplist is displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));

			}else{
				test.log(Status.FAIL, "Drop down of family member group is not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Drop down of family member group is not displayed");
			}

			familyPage.dropdown_cancel.click();
			familyPage.back_button1.click();
			Thread.sleep(2000);
			generalFunctions.isElementPresent(familyPage.balanceValue, 60);
			familyPage.back_button2.click();
			generalFunctions.isElementPresent(homePage.homeElement, 20);

		}

		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}



	}

	//member login
	//Verify the dropdown can change to different family member
	@Test
	public void TC_Family_015(Method method) throws Exception
	{
		String TC_Method = method.getName();
		System.out.println(TC_Method);
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module:Family").assignCategory("FAMILY");
		test.info("Verify the drop-down can change to different family member");


		String EmailAddress=map.get("Family_mem_user").toString();
		String Pass=map.get("Family_mem_pass").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		HomePage homePage = new HomePage(driver);
		FamilyPage familyPage = new FamilyPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInFunctions signInFunctions = new SignInFunctions();
		SignInPage signInPage = new SignInPage(driver);

		try
		{
			driver.resetApp();
			signInFunctions.SignContinue();
			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);
			if(familyPage.familyGroupIcon.isDisplayed())
			{
				test.log(Status.PASS, "Group Icon Displayed");
				familyPage.familyGroupIcon.click();

			}else{
				test.log(Status.FAIL, "Group Icon Not Displayed");
				Assert.fail("Group Icon Not Displayed");
			}
			generalFunctions.isElementPresent(familyPage.balanceValue, 60);
			String memberName = familyPage.family_mem.getText();
			familyPage.family_mem.click();

			generalFunctions.isElementPresent(familyPage.familyPointBalance, 60);
			generalFunctions.isElementPresent(familyPage.family_mem_dropdown, 30);
			familyPage.family_mem_dropdown.click();
			if(generalFunctions.isElementPresent(familyPage.familyMemberList, 30))
			{
				System.out.println("Drop down of family member group is displayed");
				test.log(Status.PASS, "Drop down of family member grouplist is displayed::USER: "+memberName).addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));

			}else{
				test.log(Status.FAIL, "Drop down of family member group is not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
				Assert.fail("Drop down of family member group is not displayed");
			}
			String memberAnotherName = familyPage.anot_mem_dropdown.getText();
			if(generalFunctions.isElementPresent(familyPage.anot_mem_dropdown, 30)){
				familyPage.anot_mem_dropdown.click();
				System.out.println("Drop down of family member group is displayed");
				test.log(Status.PASS, "Another Member selected from dropdownlist displayed::USER "+memberAnotherName).addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			}else{
				test.log(Status.FAIL, "Drop down of family member group is not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
				Assert.fail("Drop down of family member group is not displayed");
			}

			familyPage.dropdown_ok.click();
			familyPage.back_button1.click();
			Thread.sleep(2000);
			generalFunctions.isElementPresent(familyPage.balanceValue, 60);
			familyPage.back_button2.click();
			generalFunctions.isElementPresent(homePage.homeElement, 20);



		}catch(Exception e){
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	/*

	@Test
	public void TC_Family_016(Method method) throws Exception
	{
		String TC_Method = method.getName();
		System.out.println(TC_Method);
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Family member/ head can see the transaction history");
		test.info("Verify the the transaction history is present in family group");
		test.assignCategory("Family");

		String EmailAddress=map.get("Family_mem_user").toString();
		String Pass=map.get("Family_mem_pass").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		HomePage homePage = new HomePage(driver);
		FamilyPage familyPage = new FamilyPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		FamilyFunctions familyFunctions = new FamilyFunctions();
		SignInPage signInPage = new SignInPage(driver);

		try
		{

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);


			try
			{
				if(familyPage.familyGroupIcon.isDisplayed())
				{
					test.log(Status.PASS, "Group Icon Displayed");
				}
			}
			catch(Exception e)
			{
				test.log(Status.FAIL, "Group Icon Not Displayed");
				Assert.fail("Group Icon Not Displayed");
			}

			Thread.sleep(2000);

			try
			{
				if(familyPage.transaction.isDisplayed())
				{
					System.out.println("Transaction history displayed");
					test.log(Status.PASS, "Transaction history displayed");
				}
			}
			catch(Exception  e)
			{
				test.log(Status.FAIL, "Transaction history not displayed");
				Assert.fail("Transaction history not displayed");
			}

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage()).addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			driver.closeApp();
			Assert.fail(e.getMessage());
		}
	}

	 */
	//Verify user can gift 0 points//member login
	@Test
	public void TC_Family_017(Method method) throws Exception
	{
		String TC_Method = method.getName();
		System.out.println(TC_Method);
		test = extent.createTest(TC_Method).assignCategory("FAMILY");
		test.log(Status.INFO, "Family member/ head point decreases when gifting");
		test.info("Verify user can gift 0 points");
		String EmailAddress=map.get("Family_mem_user").toString();
		String Pass=map.get("Family_mem_pass").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		FamilyPage familyPage = new FamilyPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{
			driver.resetApp();
			signInFunctions.SignContinue();
			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			if(familyPage.familyGroupIcon.isDisplayed())
			{
				test.log(Status.PASS, "Group Icon Displayed");
				familyPage.familyGroupIcon.click();
			}else{
				test.log(Status.FAIL, "Group Icon Not Displayed");
				Assert.fail("Group Icon Not Displayed");
			}
			generalFunctions.isElementPresent(familyPage.balanceValue, 60);

			String member_info = familyPage.family_mem.getText().trim();
			System.out.println(member_info);
			familyPage.family_mem.click();
			generalFunctions.isElementPresent(familyPage.familyPointBalance, 60);
			generalFunctions.isElementPresent(familyPage.family_mem_dropdown, 30);
			familyPage.family_mem_dropdown.click();
			generalFunctions.isElementPresent(familyPage.familyMemberList, 30);
			if(generalFunctions.isElementPresent(familyPage.radioButtonSelected, 90)) {
				test.log(Status.PASS, "The selected User is : "+familyPage.radioButtonSelected.getText());
				System.out.println("Radio------"+familyPage.radioButtonSelected.getText());
			}else {
				test.log(Status.FAIL, "The radio button selected is wrong");
				System.out.println("Radio------"+familyPage.radioButtonSelected.getText());
			}

			String selectedMember = familyPage.radioButtonSelected.getText();
			try {
				if(selectedMember.equalsIgnoreCase(member_info)) {
					test.log(Status.PASS, "Radio button selected for the correct Member").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}else {
					test.log(Status.FAIL, "The Member selected in the listview is wrong").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				}
			}catch(Exception e) {
				test.fail(e.getMessage());
				e.printStackTrace();
			}


			familyPage.dropdown_ok.click();
			int amount=0;
			familyPage.amount_points.sendKeys(String.valueOf(amount));

			if(familyPage.gift_points.isEnabled() == false)
			{
				System.out.println("Not able to gift 0 points to any members");
				test.log(Status.PASS, "Not able to gift 0 points to any members");
			}
			else
			{
				test.log(Status.FAIL, "User is able to gift 0 points to any members");
				Assert.fail("User is able to gift 0 points to any members");
			}

		}catch(Exception e){
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}

	}




}