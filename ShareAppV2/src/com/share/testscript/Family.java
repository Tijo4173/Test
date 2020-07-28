package com.share.testscript;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.share.functions.FamilyFunctions;
import com.share.functions.RegistrationFunctions;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.FamilyPage;
import com.share.objectrepository.HomePage;
import com.share.objectrepository.RegistrationPage;
import com.share.objectrepository.SignInPage;
import com.share.utility.Utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;


public class Family extends DriverSetUp
{
	GeneralFunctions generalFunctions = new GeneralFunctions();

	@Test
	public void TC_Family_001(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module:Family").assignCategory("Family");
		test.info("Verify family Head can send Invites");
		System.out.println(TC_Method);	
		String EmailAddress=map.get("NameUser").toString();
		String Pass=map.get("PassCode").toString();
		String InviteEmailAddress=map.get("InviteEmailAddress").toString();
		RegistrationPage registrationPage= new RegistrationPage(driver);
		FamilyPage familyPage = new FamilyPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		FamilyFunctions familyFunctions = new FamilyFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{
			//			driver.activateApp("com.maf.sharesit");
			//			Thread.sleep(5000);
			//
			//			//Logout if already logged in 
			//			generalFunctions.Logout();			
			//			Thread.sleep(5000);

			//LOGIN//can use new user
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Member Invite
			familyFunctions.FamilyInvite(familyPage);

			//Click on EmailAddressField
			System.out.println(InviteEmailAddress);
			familyPage.emailAddressField.sendKeys(InviteEmailAddress);
			Thread.sleep(2000);

			//Click on SendInviteButton

			if(generalFunctions.isElementPresent(familyPage.sendInviteButton, 10))
			{
				test.log(Status.PASS, "SendInviteButton Dispalyed");
				familyPage.sendInviteButton.click();
				Thread.sleep(6000);
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
			
			familyPage.doneButton.click();
			Thread.sleep(500);

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
		
		
	}
	

	@Test
	public void TC_Family_002(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module:Family").assignCategory("Family");
		test.info("Verify that error alert is displayed for invalid email id");
		System.out.println(TC_Method);			
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("Password").toString();
		String InvalidEmailAddress=map.get("InvalidEmailAddress").toString();
		RegistrationPage registrationPage= new RegistrationPage(driver);
		FamilyPage familyPage = new FamilyPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		FamilyFunctions familyFunctions = new FamilyFunctions();
		SignInPage signInPage = new SignInPage(driver);
		

		try
		{
			//Logout if already logged in 
			//generalFunctions.Logout();			
			//Thread.sleep(5000);	

			//LOGIN//can use new user
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//FamilyInvite
			familyFunctions.FamilyInvite(familyPage);

			//Click on EmailAddressField
			familyPage.emailAddressField.sendKeys(InvalidEmailAddress);
			Thread.sleep(2000);

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
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}		
	}


	@Test
	public void TC_Family_003(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Module:Family").assignCategory("Family");
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
		SignInPage signInPage = new SignInPage(driver);
		GeneralFunctions GeneralFunctions = new GeneralFunctions();

		try
		{

			//Logout if already logged in 
//			generalFunctions.Logout();			
//			Thread.sleep(5000);

			//LOGIN//use new user
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//FamilyInviteExistingMember function calling		
			familyFunctions.FamilyInviteExistingMember(familyPage);

			//Click on EmailAddressField
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
			if(generalFunctions.isElementPresent(familyPage.existingMemberErrorMessage, 30))
			{
				test.log(Status.PASS, "ExistingMemberErrorMessage Dispalyed");
			}
			else
			{
				test.log(Status.FAIL, "ExistingMemberErrorMessage Not Displayed");
				Assert.fail("ExistingMemberErrorMessage Not Displayed");
			}		

			//Click on DoneButton
			generalFunctions.isElementPresent(familyPage.doneButton, 60);
			if(familyPage.doneButton.isDisplayed())
			{
				test.log(Status.PASS, "DoneButton Dispalyed");
				familyPage.doneButton.click();
			}
			else
			{
				test.log(Status.FAIL, "DoneButton Not Displayed");
				Assert.fail("DoneButton Not Displayed");
			}

			Thread.sleep(3000);
			familyPage.back_button1.click();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

/*
	@Test
	public void TC_Family_004(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Family");
		test.info("Already Member of Another Group");
		test.assignCategory("Family");
		System.out.println(TC_Method);			
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("Password").toString();
		String AlreadyMemberId=map.get("AlreadyMemberId").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		HomePage homePage = new HomePage(driver);
		FamilyPage familyPage = new FamilyPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		FamilyFunctions familyFunctions = new FamilyFunctions();
		SignInPage signInPage = new SignInPage(driver);

		try
		{
			//Logout if already logged in 
			generalFunctions.Logout();			
			Thread.sleep(5000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			accountPage.AccountIcon.click();
			Thread.sleep(3000);

			familyFunctions.FamilyInvite(familyPage);

			//Click on EmailAddressField
			generalFunctions.isElementPresent(familyPage.EmailAddressField, 60);
			familyPage.EmailAddressField.sendKeys(AlreadyMemberId);
			Thread.sleep(2000);

			//Click on SendInviteButton
			generalFunctions.isElementPresent(familyPage.SendInviteButton, 60);
			if(familyPage.SendInviteButton.isDisplayed())
			{
				test.log(Status.PASS, "SendInviteButton Dispalyed");
				familyPage.SendInviteButton.click();
				Thread.sleep(6000);
			}
			else
			{
				test.log(Status.FAIL, "SendInviteButton Not Displayed");
				Assert.fail("SendInviteButton Not Displayed");
			}


			//ExistingMemberErrorMessage
			Thread.sleep(2000);
			generalFunctions.isElementPresent(familyPage.ExistingMemberErrorMessage, 60);
			if(familyPage.ExistingMemberErrorMessage.isDisplayed())
			{
				test.log(Status.PASS, "ExistingMemberErrorMessage Dispalyed");
			}
			else
			{
				test.log(Status.FAIL, "ExistingMemberErrorMessage Not Displayed");
				Assert.fail("ExistingMemberErrorMessage Not Displayed");
			}		

			//Click on DoneButton
			Thread.sleep(2000);
			generalFunctions.isElementPresent(familyPage.DoneButton, 60);
			if(familyPage.DoneButton.isDisplayed())
			{
				test.log(Status.PASS, "DoneButton Dispalyed");
				familyPage.DoneButton.click();
			}
			else
			{
				test.log(Status.FAIL, "DoneButton Not Displayed");
				Assert.fail("DoneButton Not Displayed");
			}

			Thread.sleep(2000);
			familyPage.back_button1.click();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}


	@Test
	public void TC_Family_005(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Family");
		test.info("NonShareMemberInvite");
		test.assignCategory("Family");
		System.out.println(TC_Method);			
		String EmailAddress=map.get("NameUser").toString();
		String Pass=map.get("PassCode").toString();
		String InviteEmailAddress=map.get("InviteEmailAddress").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		HomePage homePage = new HomePage(driver);
		FamilyPage familyPage = new FamilyPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		FamilyFunctions familyFunctions = new FamilyFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{
			//Logout if already logged in 
			generalFunctions.Logout();			
			Thread.sleep(5000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			accountPage.AccountIcon.click();
			Thread.sleep(3000);

			familyFunctions.FamilyInvite(familyPage);

			//Click on EmailAddressField
			generalFunctions.isElementPresent(familyPage.EmailAddressField, 60);
			familyPage.EmailAddressField.sendKeys(InviteEmailAddress);
			Thread.sleep(2000);

			//Click on SendInviteButton
			generalFunctions.isElementPresent(familyPage.SendInviteButton, 60);
			if(familyPage.SendInviteButton.isDisplayed())
			{
				test.log(Status.PASS, "SendInviteButton Dispalyed");
				familyPage.SendInviteButton.click();
				Thread.sleep(6000);
			}
			else
			{
				test.log(Status.FAIL, "SendInviteButton Not Displayed");
				Assert.fail("SendInviteButton Not Displayed");
			}

			//Click on DoneButton
			Thread.sleep(2000);
			generalFunctions.isElementPresent(familyPage.DoneButton, 60);
			if(familyPage.DoneButton.isDisplayed())
			{
				test.log(Status.PASS, "DoneButton Dispalyed");
				familyPage.DoneButton.click();
			}
			else
			{
				test.log(Status.FAIL, "DoneButton Not Displayed");
				Assert.fail("DoneButton Not Displayed");
			}

			driver.startActivity(new Activity("com.google.android.gm", "com.google.android.gm.ConversationListActivityGmail"));
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}


	@Test
	public void TC_Family_006(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Family");
		test.info("Share Points to Family Members");
		test.assignCategory("Family");
		System.out.println(TC_Method);			
		String EmailAddress=map.get("NameUser").toString();
		String Pass=map.get("PassCode").toString();
		String Points = "10.00";
		driver.activateApp("com.maf.sharesit");
		RegistrationPage registrationPage= new RegistrationPage(driver);
		HomePage homePage = new HomePage(driver);
		FamilyPage familyPage = new FamilyPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		FamilyFunctions familyFunctions = new FamilyFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{

			//driver.launchApp();
			Thread.sleep(5000);

			//Logout if already logged in 
			generalFunctions.Logout();			
			Thread.sleep(5000);
			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			accountPage.AccountIcon.click();
			Thread.sleep(3000);

			generalFunctions.isElementPresent(familyPage.FamilyGroupIcon, 60);
			if(familyPage.FamilyGroupIcon.isDisplayed())
			{
				test.log(Status.PASS, "Group Icon Dispalyed");
				familyPage.FamilyGroupIcon.click();

			}
			else
			{
				test.log(Status.FAIL, "Group Icon Not Displayed");
				Assert.fail("Group Icon Not Displayed");
			}

			Thread.sleep(10000);		
			String _name = familyPage.FamilyMemberName.getText();		
			System.out.println(_name);

			generalFunctions.isElementPresent(familyPage.FamilyMember, 60);
			familyPage.FamilyMember.click();		
			Thread.sleep(3000);

			familyPage.PointsField.click();
			familyPage.PointsField.sendKeys(Points);

			String _pointbalance = familyPage.FamilyPointBalance.getText();		
			driver.hideKeyboard();

			familyPage.GetPointsButton.click();
			Thread.sleep(6000);

			generalFunctions.isElementPresent(familyPage.PointsSuccessMessage, 60);
			String _pointSuccessMessage = familyPage.PointsSuccessMessage.getText();

			if(_pointSuccessMessage.contains(_name)) 
			{
				System.out.println(_name+"Dislayed");
				test.log(Status.PASS, "Name displayed in success message");
			}
			else 
			{
				test.log(Status.FAIL, "Name not displayed in success message");
				Assert.fail("Name not displayed in success message");
			}

			if(_pointSuccessMessage.contains(Points+" points")) 
			{
				System.out.println(Points+"Dislayed");
				test.log(Status.PASS, "Points displayed in success message");
			}
			else 
			{
				test.log(Status.FAIL, "Points not displayed in success message");
				Assert.fail("Points not displayed in success message");
			}

			familyPage.ThanksButton.click();
			Thread.sleep(6000);

			System.out.println(_pointbalance);
			System.out.println(Points);

			String _newpointbalance = _pointbalance.replaceAll(",", "");
			double updatedPointBalance = Double.valueOf(_newpointbalance) - Double.valueOf(Points);
			System.out.println("updatedPointBalance "+updatedPointBalance);

			Thread.sleep(3000);

			String _finalpointbalance = familyPage.FamilyPointBalance.getText();
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

			Thread.sleep(2000);
			familyPage.back_button1.click();
			Thread.sleep(2000);
			familyPage.back_button2.click();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}


	@Test
	public void TC_Family_007(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Family");
		test.info("Invite New Member");
		test.assignCategory("Family");
		System.out.println(TC_Method);			
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("Password").toString();
		String InviteEmailAddress=map.get("InviteEmailAddress").toString();
		driver.activateApp("com.maf.sharesit");
		RegistrationPage registrationPage= new RegistrationPage(driver);
		HomePage homePage = new HomePage(driver);
		FamilyPage familyPage = new FamilyPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		FamilyFunctions familyFunctions = new FamilyFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{
			//Logout if already logged in 
			generalFunctions.Logout();		
			Thread.sleep(5000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			accountPage.AccountIcon.click();
			Thread.sleep(2000);

			familyFunctions.FamilyInvite(familyPage);

			if(!familyPage.SendInviteButton.isEnabled())
			{
				test.log(Status.PASS, "SendInviteButton not enabled");
				Thread.sleep(3000);
			}
			else
			{
				test.log(Status.FAIL, "SendInviteButton enabled");
				Assert.fail("SendInviteButton enabled");

			}	
			//Click on EmailAddressField
			familyPage.EmailAddressField.sendKeys(InviteEmailAddress);
			Thread.sleep(2000);

			//Click on SendInviteButton

			if(familyPage.SendInviteButton.isDisplayed())
			{
				test.log(Status.PASS, "SendInviteButton Dispalyed");
				familyPage.SendInviteButton.click();
				Thread.sleep(6000);
			}
			else
			{
				test.log(Status.FAIL, "SendInviteButton Not Displayed");
				Assert.fail("SendInviteButton Not Displayed");

			}	

			//Click on DoneButton
			Thread.sleep(2000);
			if(familyPage.DoneButton.isDisplayed())
			{
				test.log(Status.PASS, "DoneButton Dispalyed");
				familyPage.DoneButton.click();
			}
			else
			{
				test.log(Status.FAIL, "DoneButton Not Displayed");
				Assert.fail("DoneButton Not Displayed");
			}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC_Family_008(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.info("Exeeding Gift Points Error Message");
		test.assignCategory("Family");
		System.out.println(TC_Method);			
		String EmailAddress=map.get("NameUser").toString();
		String Pass=map.get("PassCode").toString();
		driver.activateApp("com.maf.sharesit");
		RegistrationPage registrationPage= new RegistrationPage(driver);
		HomePage homePage = new HomePage(driver);
		FamilyPage familyPage = new FamilyPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		FamilyFunctions familyFunctions = new FamilyFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{
			//Logout if already logged in 
			generalFunctions.Logout();		

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			accountPage.AccountIcon.click();
			Thread.sleep(3000);

			Thread.sleep(3000);
			if(familyPage.FamilyGroupIcon.isDisplayed())
			{
				test.log(Status.PASS, "Group Icon Dispalyed");
				familyPage.FamilyGroupIcon.click();

			}
			else
			{
				test.log(Status.FAIL, "Group Icon Not Displayed");
				Assert.fail("Group Icon Not Displayed");
			}

			Thread.sleep(2000);		
			String _name = familyPage.FamilyMemberName.getText();		
			System.out.println(_name);

			familyPage.FamilyMember.click();		
			Thread.sleep(3000);

			String _pointbalance = familyPage.FamilyPointBalance.getText();		
			_pointbalance= _pointbalance.replaceAll(",", "");
			double Points = Double.parseDouble(_pointbalance) *2;
			String _finalpoints = String.valueOf(Points);

			Thread.sleep(3000);
			familyPage.PointsField.click();
			familyPage.PointsField.sendKeys(_finalpoints);		
			driver.hideKeyboard();

			if(familyPage.ErrorMessageGiftPoints.isDisplayed() == true) 
			{
				System.out.println(_name+"ErrorMessageGiftPoints displayed");
				test.log(Status.PASS, "ErrorMessageGiftPoints displayed");
			}
			else 
			{
				System.out.println(_name+"ErrorMessageGiftPoints not displayed");
				test.log(Status.FAIL, "ErrorMessageGiftPoints not displayed");
				Assert.fail("ErrorMessageGiftPoints not displayed");
			}

			Thread.sleep(2000);
			familyPage.back_button1.click();

			Thread.sleep(2000);
			familyPage.back_button1.click();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}


	@Test
	public void TC_Family_009(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Family");
		test.info("View Other Users");
		test.assignCategory("Family");
		System.out.println(TC_Method);			
		String EmailAddress=map.get("NameUser").toString();
		String Pass=map.get("PassCode").toString();
		driver.activateApp("com.maf.sharesit");
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

			//Click on Account Icon
			accountPage.AccountIcon.click();
			Thread.sleep(3000);

			Thread.sleep(3000);
			if(familyPage.FamilyGroupIcon.isDisplayed())
			{
				test.log(Status.PASS, "Group Icon Dispalyed");
				familyPage.FamilyGroupIcon.click();

			}
			else
			{
				test.log(Status.FAIL, "Group Icon Not Displayed");
				Assert.fail("Group Icon Not Displayed");
			}

			Thread.sleep(2000);		
			String _name = familyPage.FamilyMemberName.getText();		
			System.out.println(_name);

			familyPage.FamilyMember.click();		
			Thread.sleep(3000);


			Thread.sleep(3000);
			if(familyPage.PointsField.isDisplayed()== true)
			{
				familyPage.PointsField.click();
			}
			else
			{
				test.log(Status.FAIL, "Unable to go inside member");
				Assert.fail("Unable to go inside member");
			}

			Thread.sleep(2000);
			familyPage.back_button1.click();

			Thread.sleep(2000);
			familyPage.back_button1.click();

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}



	@Test
	public void TC_Family_011(Method method) throws Exception
	{
		String TC_Method = method.getName();
		System.out.println(TC_Method);
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Edit the Contribution percentage of family member");
		test.info("Verify Family member can edit and add contribution percentage to the Family group or family head");
		test.assignCategory("Family");

		String EmailAddress=map.get("Family_mem_user").toString();
		String Pass=map.get("Family_mem_pass").toString();

		RegistrationPage registrationPage= new RegistrationPage(driver);
		HomePage homePage = new HomePage(driver);
		FamilyPage familyPage = new FamilyPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		FamilyFunctions familyFunctions = new FamilyFunctions();
		SignInPage signInPage = new SignInPage(driver);
		GeneralFunctions GenFunctions = new GeneralFunctions();

		try
		{

			driver.activateApp("com.maf.sharesit");
			Thread.sleep(5000);	

			//Logout if already logged in 
			GenFunctions.Logout();			
			Thread.sleep(5000);	

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			accountPage.AccountIcon.click();
			Thread.sleep(4000);

			try
			{
				if(familyPage.FamilyGroupIcon.isDisplayed())
				{
					test.log(Status.PASS, "Group Icon Dispalyed");
					familyPage.FamilyGroupIcon.click();		
				}
			}
			catch(Exception e)
			{
				test.log(Status.FAIL, "Group Icon Not Displayed");
				Assert.fail("Group Icon Not Displayed");
			}


			Thread.sleep(5000);				

			familyPage.Edit_family.click();		
			Thread.sleep(3000);

			Integer points = 30;
			familyPage.Earn_family_head.sendKeys(String.valueOf(points));		
			Thread.sleep(3000);

			familyPage.family_save.click();		
			Thread.sleep(3000);	

			String desc=familyPage.family_edit_desc.getText();
			System.out.println(desc);
			if(desc.contains("You are contributing " + points + "%"))
			{
				System.out.println("Contributing points updated and displayed");
				test.log(Status.PASS, "Contributing points updated and displayed");
			}
			else
			{
				test.log(Status.FAIL, "Contributing points not updated or displayed");
				Assert.fail("Contributing points not updated or displayed");
			}

			Thread.sleep(2000);
			familyPage.back_button1.click();
		}
		catch(Exception e)
		{    			
			test.log(Status.FAIL, e.getMessage()).addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			driver.closeApp();
			Assert.fail(e.getMessage());
		}					
	}




	@Test
	public void TC_Family_012(Method method) throws Exception
	{
		String TC_Method = method.getName();
		System.out.println(TC_Method);
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Edit the Contribution percentage of family member");
		test.info("Verify Family member / head can edit contribution to 0%");
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
			//Logout if already logged in 
			generalFunctions.Logout();		
			Thread.sleep(5000);

			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

			//Click on Account Icon
			accountPage.AccountIcon.click();
			Thread.sleep(3000);

			try
			{

				if(familyPage.FamilyGroupIcon.isDisplayed())
				{
					test.log(Status.PASS, "Group Icon Dispalyed");
					familyPage.FamilyGroupIcon.click();		
				}
			}
			catch(Exception e)
			{
				test.log(Status.FAIL, "Group Icon Not Displayed");
				Assert.fail("Group Icon Not Displayed");	
			}

			Thread.sleep(8000);		


			familyPage.Edit_family.click();		
			Thread.sleep(5000);

			Integer points = 0;
			familyPage.Earn_family_head.sendKeys(String.valueOf(points));		
			Thread.sleep(3000);

			familyPage.family_save.click();		
			Thread.sleep(5000);


			String desc=familyPage.family_edit_desc.getText();

			if(desc.contains("You are contributing " + points + "%"))
			{
				System.out.println("Contributing points updated and displayed");
				test.log(Status.PASS, "Contributing points updated and displayed");
			}
			else
			{
				test.log(Status.FAIL, "Contributing points not updated or not displayed");
				Assert.fail("Contributing points not updated or not displayed");
			}

			Thread.sleep(2000);
			familyPage.back_button1.click();
		}
		catch(Exception e)
		{    			
			test.log(Status.FAIL, e.getMessage()).addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			driver.closeApp();
			Assert.fail(e.getMessage());
		}	


	}



	@Test
	public void TC_Family_013(Method method) throws Exception
	{
		String TC_Method = method.getName();
		System.out.println(TC_Method);
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Edit the Contribution percentage of family member to 100%");
		test.info("Verify Family member can edit contribution to 100%");
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

			//Click on Account Icon
			accountPage.AccountIcon.click();
			Thread.sleep(5000);

			try
			{

				if(familyPage.FamilyGroupIcon.isDisplayed())
				{
					test.log(Status.PASS, "Group Icon Dispalyed");
					familyPage.FamilyGroupIcon.click();		
				}
			}
			catch(Exception e)
			{
				test.log(Status.FAIL, "Group Icon Not Displayed");
				Assert.fail("Group Icon Not Displayed");	
			}

			Thread.sleep(8000);		


			familyPage.Edit_family.click();		
			Thread.sleep(15000);

			Integer points = 100;
			familyPage.Earn_family_head.sendKeys(String.valueOf(points));		
			Thread.sleep(3000);

			familyPage.family_save.click();		
			Thread.sleep(5000);


			String desc=familyPage.family_edit_desc.getText();

			if(desc.contains("You are contributing " + points + "%"))
			{
				System.out.println("Contributing points updated and displayed");
				test.log(Status.PASS, "Contributing points updated and displayed");
			}
			else
			{
				test.log(Status.FAIL, "Contributing points not updated or not displayed");
				Assert.fail("Contributing points not updated or not displayed");
			}

			Thread.sleep(2000);
			familyPage.back_button1.click();

		}
		catch(Exception e)
		{    			
			test.log(Status.FAIL, e.getMessage()).addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			driver.closeApp();
			Assert.fail(e.getMessage());
		}


	}




	@Test
	public void TC_Family_014(Method method) throws Exception
	{
		String TC_Method = method.getName();
		System.out.println(TC_Method);
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Gift points dropdown listed to all family group members ");
		test.info("Verify the gift points drop down listed to all group members");
		test.assignCategory("Family");

		String EmailAddress = map.get("Family_mem_user").toString();
		String Pass = map.get("Family_mem_pass").toString();

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

			//Click on Account Icon	
			accountPage.AccountIcon.click();
			Thread.sleep(8000);

			try
			{

				if(familyPage.FamilyGroupIcon.isDisplayed())
				{
					test.log(Status.PASS, "Group Icon Displayed");
					familyPage.FamilyGroupIcon.click();

				}
			}
			catch(Exception e)
			{
				test.log(Status.FAIL, "Group Icon Not Displayed");
				Assert.fail("Group Icon Not Displayed");
			}

			Thread.sleep(5000);		


			familyPage.family_mem.click();		
			Thread.sleep(8000);

			try
			{
				if(familyPage.family_mem_dropdown.isDisplayed()) 
				{
					System.out.println("Drop down of family member group is displayed");
					test.log(Status.PASS, "Drop down of family member group is displayed");

				}	
			}
			catch(Exception e)
			{
				test.log(Status.FAIL, "Drop down of family member group is not displayed");
				Assert.fail("Drop down of family member group is not displayed");
			}

			familyPage.family_mem_dropdown.click();		
			Thread.sleep(5000);

			familyPage.dropdown_ok.click();

			Thread.sleep(2000);
			familyPage.back_button1.click();

			Thread.sleep(2000);
			familyPage.back_button1.click();

		}
		catch(Exception e)
		{    
			test.log(Status.FAIL, e.getMessage()).addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			driver.closeApp();
			Assert.fail(e.getMessage());
		}	



	}



	@Test
	public void TC_Family_015(Method method) throws Exception
	{
		String TC_Method = method.getName();
		System.out.println(TC_Method);
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Gift points dropdown able to change to different");
		test.info("Verify the dropdown can change to different family member");
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

			//Click on Account Icon
			accountPage.AccountIcon.click();
			Thread.sleep(5000);

			try
			{
				if(familyPage.FamilyGroupIcon.isDisplayed())
				{
					test.log(Status.PASS, "Group Icon Displayed");
					familyPage.FamilyGroupIcon.click();

				}
			}
			catch(Exception e)
			{
				test.log(Status.FAIL, "Group Icon Not Displayed");
				Assert.fail("Group Icon Not Displayed");
			}

			Thread.sleep(2000);		

			familyPage.family_mem.click();		
			Thread.sleep(5000);

			try
			{
				if(familyPage.family_mem_dropdown.isDisplayed())
				{
					System.out.println("Drop down Displayed");
					test.log(Status.PASS, "Drop down Displayed");		
				}
			}
			catch(Exception e)
			{
				test.log(Status.FAIL, "Drop down not Displayed");
				Assert.fail("Drop down not Displayed");
			}	

			familyPage.family_mem_dropdown.click();		
			Thread.sleep(3000);

			familyPage.anot_mem_dropdown.click();
			familyPage.dropdown_ok.click();

			test.log(Status.PASS, "Flow Completed").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));		

			Thread.sleep(2000);
			familyPage.back_button1.click();

			Thread.sleep(2000);
			familyPage.back_button1.click();
		}	
		catch(Exception e)
		{    
			test.log(Status.FAIL, e.getMessage()).addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			driver.closeApp();
			Assert.fail(e.getMessage());
		}
	}



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

			//Click on Account Icon
			accountPage.AccountIcon.click();
			Thread.sleep(5000);

			try
			{
				if(familyPage.FamilyGroupIcon.isDisplayed())
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


	@Test
	public void TC_Family_017(Method method) throws Exception
	{
		String TC_Method = method.getName();
		System.out.println(TC_Method);
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Family member/ head point decreases when gifting");
		test.info("Verify user can gift 0 points");
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

			//Click on Account Icon
			accountPage.AccountIcon.click();
			Thread.sleep(5000);

			try
			{
				if(familyPage.FamilyGroupIcon.isDisplayed())
				{
					test.log(Status.PASS, "Group Icon Displayed");		
				}
			}
			catch(Exception e)
			{
				test.log(Status.FAIL, "Group Icon Not Displayed");
				Assert.fail("Group Icon Not Displayed");
			}

			familyPage.FamilyGroupIcon.click();
			Thread.sleep(2000);		

			String member_info = familyPage.family_mem.getText().trim();
			System.out.println(member_info);

			familyPage.family_mem.click();			
			Thread.sleep(5000);

			String Dropdown_info = familyPage.family_mem_dropdown.getText().trim();
			System.out.println(Dropdown_info);	

			if(member_info.contains(Dropdown_info)) 
			{
				System.out.println(" family member dropdown is pointed correct");
				test.log(Status.PASS, " family member dropdown is pointed correct");			
			}
			else 
			{
				test.log(Status.FAIL, "Drop down not Displayed");
				Assert.fail("Drop down not Displayed");
			}

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

		}
		catch(Exception e)
		{    
			test.log(Status.FAIL, e.getMessage()).addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			driver.closeApp();
			Assert.fail(e.getMessage());
		}

	}

	 */
}
