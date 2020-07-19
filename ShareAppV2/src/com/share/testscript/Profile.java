package com.share.testscript;

import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.share.functions.ProfileFunctions;
import com.share.functions.SharePayFunctions;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.ProfilePage;
import com.share.objectrepository.HomePage;
import com.share.objectrepository.SharePayPage;
import com.share.objectrepository.SignInPage;
import com.share.utility.Utilities;

public class Profile extends DriverSetUp
{

	GeneralFunctions generalFunctions = new GeneralFunctions();


	@Test
	public void TC_01(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Profile - Landing screen");
		test.assignCategory("Profile");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ProfilePage profilePage = new ProfilePage(driver);

		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();

		try
		{

			driver.activateApp("com.maf.sharesit");	

			//Login to the App
			generalFunctions.SignIn(EmailAddress, Password, signInPage);

			//Click on Avatar icon
			profilePage.avatar.click();
			Thread.sleep(4000);

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
					test.log(Status.PASS, "Joining Date Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Joining Date Not Displayed");
				Assert.fail("Joining Date Not Displayed");
			}

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

			//Notifications
			try
			{
				if(profilePage.notifications.isDisplayed()==true)
				{
					test.log(Status.PASS, "Notifications Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Notifications Not Displayed");
				Assert.fail("Notifications Not Displayed");
			}		

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
					test.log(Status.PASS, "Privacy Policy Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Privacy Policy Not Displayed");
				Assert.fail("Privacy Policy Not Displayed");
			}		

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

			generalFunctions.ScrollDown("Version");

			//App Version
			try
			{
				if(profilePage.version.isDisplayed()==true)
				{
					test.log(Status.PASS, "App Version Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "App Version Not Displayed");
				Assert.fail("App Version Not Displayed");
			}	
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}

	}


	@Test
	public void TC_02(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Profile - Avatar Initials");
		test.assignCategory("Profile");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ProfilePage profilePage = new ProfilePage(driver);

		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();

		try
		{
			driver.activateApp("com.maf.sharesit");

			//Login to the App
			generalFunctions.SignIn(EmailAddress, Password, signInPage);

			//Click on Avatar icon
			profilePage.avatar.click();
			Thread.sleep(10000);

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
				test.log(Status.PASS, "Avatar Name Displayed Correctly");
			}
			else
			{
				test.log(Status.FAIL, "Avatar Name Not Displayed Correctly");
				Assert.fail("Avatar Name Not Displayed Correctly");
			}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}


	@Test
	public void TC_03(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Profile");
		test.assignCategory("Profile");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ProfilePage profilePage = new ProfilePage(driver);

		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();

		try
		{

			driver.activateApp("com.maf.sharesit");

			//Login to the App
			generalFunctions.SignIn(EmailAddress, Password, signInPage);

			//Click on Avatar icon
			profilePage.avatar.click();
			Thread.sleep(8000);

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
					test.log(Status.PASS, "Joining Date Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Joining Date Not Displayed");
				Assert.fail("Joining Date Not Displayed");
			}

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}

	}


	@Test
	public void TC_04(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Profile - Personal Details");
		test.assignCategory("Profile");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ProfilePage profilePage = new ProfilePage(driver);

		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();
		String FirstName=map.get("FirstName").toString();
		String Surname=map.get("Surname").toString();

		try
		{
			driver.activateApp("com.maf.sharesit");

			//Login to the App
			generalFunctions.SignIn(EmailAddress, Password, signInPage);

			//Click on Avatar icon
			profilePage.avatar.click();
			Thread.sleep(8000);

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
				test.log(Status.PASS, "First Name updated");
			}
			else
			{
				test.log(Status.FAIL, "First Name Not updated");
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
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}			
	}


	@Test
	public void TC_05(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Profile-Settings");
		test.assignCategory("Profile");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ProfilePage profilePage = new ProfilePage(driver);

		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();

		try
		{

			driver.activateApp("com.maf.sharesit");

			//Login to the App
			generalFunctions.SignIn(EmailAddress, Password, signInPage);

			//Click on Avatar icon
			profilePage.avatar.click();
			Thread.sleep(4000);

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
					test.log(Status.PASS, "Fingerprint Icon Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Fingerprint Icon Not Displayed");
				Assert.fail("Fingerprint Icon Not Displayed");
			}	

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}

	}


	@Test
	public void TC_06(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Profile-Settings");
		test.assignCategory("Profile");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ProfilePage profilePage = new ProfilePage(driver);

		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();

		try
		{

			driver.activateApp("com.maf.sharesit");

			//Login to the App
			generalFunctions.SignIn(EmailAddress, Password, signInPage);

			//Click on Avatar icon
			profilePage.avatar.click();
			Thread.sleep(4000);

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

			//Click on Notifications Icon
			profilePage.notificationSwitch.click();
			Thread.sleep(4000);

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


	@Test
	public void TC_12(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Profile-Settings");
		test.assignCategory("Profile");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ProfilePage profilePage = new ProfilePage(driver);

		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();

		try
		{

			driver.activateApp("com.maf.sharesit");

			//Login to the App
			generalFunctions.SignIn(EmailAddress, Password, signInPage);

			//Click on Avatar icon
			profilePage.avatar.click();
			Thread.sleep(4000);

			//Fingerprint
			try
			{
				if(profilePage.fingerprint.isDisplayed()==true)
				{
					test.log(Status.PASS, "Fingerprint Icon Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Fingerprint Icon Not Displayed");
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

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}

	}


	@Test
	public void TC_14(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "T&Cs, Privacy Policy");
		test.assignCategory("Profile");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ProfilePage profilePage = new ProfilePage(driver);

		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();

		try
		{

			driver.activateApp("com.maf.sharesit");

			//Login to the App
			generalFunctions.SignIn(EmailAddress, Password, signInPage);

			//Click on Avatar icon
			profilePage.avatar.click();
			Thread.sleep(4000);		

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
					test.log(Status.PASS, "Privacy Policy Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Privacy Policy Not Displayed");
				Assert.fail("Privacy Policy Not Displayed");
			}		

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}

	}


	@Test
	public void TC_15(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "T&Cs, Privacy Policy");
		test.assignCategory("Profile");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ProfilePage profilePage = new ProfilePage(driver);

		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();

		try
		{

			driver.activateApp("com.maf.sharesit");

			//Login to the App
			generalFunctions.SignIn(EmailAddress, Password, signInPage);

			//Click on Avatar icon
			profilePage.avatar.click();
			Thread.sleep(4000);		

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

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}

	}


	@Test
	public void TC_16(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "T&Cs, Privacy Policy");
		test.assignCategory("Profile");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ProfilePage profilePage = new ProfilePage(driver);

		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();

		try
		{

			driver.activateApp("com.maf.sharesit");

			//Login to the App
			generalFunctions.SignIn(EmailAddress, Password, signInPage);

			//Click on Avatar icon
			profilePage.avatar.click();
			Thread.sleep(4000);		

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
					test.log(Status.PASS, "Privacy Policy page Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Privacy Policy page Not Displayed");
				Assert.fail("Privacy Policy page Not Displayed");
			}		

			profilePage.navigateBack.click();

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}				
	}


	@Test
	public void TC_17_18(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Logout");
		test.assignCategory("Profile");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ProfilePage profilePage = new ProfilePage(driver);

		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();

		try
		{

			driver.activateApp("com.maf.sharesit");

			//Login to the App
			generalFunctions.SignIn(EmailAddress, Password, signInPage);

			//Click on Avatar icon
			profilePage.avatar.click();
			Thread.sleep(4000);		
			generalFunctions.ScrollDown("Version");

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
					test.log(Status.PASS, "Logout Confirmation Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Logout Confirmation Not Displayed");
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


	@Test
	public void TC_19_20_21(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Reset Password");
		test.assignCategory("Profile");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ProfilePage profilePage = new ProfilePage(driver);

		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();

		try
		{

			driver.activateApp("com.maf.sharesit");

			//Login to the App
			generalFunctions.SignIn(EmailAddress, Password, signInPage);

			//Click on Avatar icon
			profilePage.avatar.click();
			Thread.sleep(4000);

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
					test.log(Status.PASS, "Reset Password Confirmation Alert Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Reset Password Confirmation Alert Not Displayed");
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

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}

	}


	@Test
	public void TC_22_23(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Reset Password");
		test.assignCategory("Profile");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ProfilePage profilePage = new ProfilePage(driver);

		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();

		try
		{

			driver.activateApp("com.maf.sharesit");

			//Login to the App
			generalFunctions.SignIn(EmailAddress, Password, signInPage);

			//Click on Avatar icon
			profilePage.avatar.click();
			Thread.sleep(4000);

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
					test.log(Status.PASS, "Reset Password Confirmation Alert Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Reset Password Confirmation Alert Not Displayed");
				Assert.fail("Reset Password Confirmation Alert Not Displayed");
			}	

			profilePage.ConfirmYES.click();
			Thread.sleep(25000);

			try
			{
				if(profilePage.ResetPasswordPage.isDisplayed()==true)
				{
					test.log(Status.PASS, "Reset Password Confirmation page Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Reset Password Confirmation page Not Displayed");
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
			Thread.sleep(5000);

			profilePage.navigateBack.click();


		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}

	}


	@Test
	public void TC_25_To_31(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Profile - Payment methods");
		test.assignCategory("Profile");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ProfilePage profilePage = new ProfilePage(driver);

		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();
		String CardNumber=map.get("CardNumber").toString();
		String NameOnCard =map.get("NameOnCard").toString();
		String ExpiryDate=map.get("ExpiryDate").toString();
		String Cvv =map.get("Cvv").toString();
		String TransactionAmount=map.get("TransactionAmount").toString();

		try
		{

			driver.activateApp("com.maf.sharesit");

			//Login to the App
			generalFunctions.SignIn(EmailAddress, Password, signInPage);

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

			//Add New Payment Method
			profilePage.addNewPaymentMethod.click();
			Thread.sleep(4000);

			try
			{
				if(profilePage.addNewCardPage.isDisplayed()==true)
				{
					test.log(Status.PASS, "Add New Card page Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Add New Card page Not Displayed");
				Assert.fail("Add New Card page Not Displayed");
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
			Thread.sleep(5000);
			Thread.sleep(50000);

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

			//Verify the submit button
			if(profilePage.SubmitTransactionAmount.isEnabled()==false)
			{
				test.log(Status.PASS, "Submit Button is Disabled");
			}
			else
			{
				test.log(Status.FAIL, "Submit Button is Enabled");
				Assert.fail("Submit Button is Enabled");
			}

			profilePage.goBack.click();
			Thread.sleep(4000);		

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

			//Verify the Card Details Tag
			String CardTag= profilePage.GetCardStatus(lastDigits).getText();
			System.out.println("Card Status : "+CardTag);
			if(CardTag.contains("Not Verified"))
			{
				test.log(Status.PASS, "Card Status Displayed and verified");
			}
			else
			{
				test.log(Status.FAIL, "Card Status Not Displayed OR Wrong Status displayed");
				Assert.fail("Card Status Not Displayed OR Wrong Status displayed");
			}

			//Select Card
			profilePage.SelectCards(lastDigits).click();
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

			profilePage.TransactionAmount.sendKeys(TransactionAmount);
			driver.hideKeyboard();

			profilePage.SubmitTransactionAmount.click();
			Thread.sleep(40000);

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

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}

	}

	////-------------Passcode------////

	//Verify New User is able to set up PIN on selecting Payment methods
	@Test
	public void TC_59_to_63(Method method) throws Exception   {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("PROFILE");
		test.log(Status.INFO, "Payment Method:Passcode Set up");
		test.info("Verify New User is able to set up PIN on selecting Payment methods");
		System.out.println(TC_Method);
		SignInPage signInPage = new SignInPage(driver);
		ProfilePage profilePage = new ProfilePage(driver);
		ProfileFunctions profileFunctions = new ProfileFunctions();
		//SignIn New User and click on Payment Methods
		profileFunctions.newUserPass();

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

		//PINCODE SUCCESS
		if(generalFunctions.isElementPresent(profilePage.pinSuccess, 30)) {
			test.log(Status.PASS, "SUCCESS:"+profilePage.pinSuccess.getText()).addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			profilePage.pinDone.click();
		}else {
			test.log(Status.FAIL, "SUCCESS Screen NOT displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
		}

		if(generalFunctions.isElementPresent(profilePage.addNewPaymentMethod, 30)) {
			test.log(Status.PASS, "Payment Methods Screen displayed");
		}else {
			test.log(Status.FAIL, "Payment Methods Screen NOT displayed");
		}
	}

	//Verify Error message is displayed when PIN on the first set up screen does not match with the PIN on the confirm screen
	@Test // run before the above tc
	public void TC_70(Method method) throws InterruptedException {
		try {
			String TC_Method = method.getName();
			test = extent.createTest(TC_Method);
			test.log(Status.INFO, "Payment Methods: Passcode Mismatch").assignCategory("PROFILE");
			test.info("Verify Error message is displayed when PIN on the first set up screen does not match with the PIN on the confirm screen");
			System.out.println(TC_Method);
			SignInPage signInPage = new SignInPage(driver);
			ProfilePage profilePage = new ProfilePage(driver);
			ProfileFunctions profileFunctions = new ProfileFunctions();
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
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			Assert.fail(e.getMessage());
		}
	}
	//Verify New User is able to set up PIN later by selecting "SET UP PIN CODE LATER"
	//Verify User is not able to Proceed with Profile - Payment Methods without setting up PIN
	//Need new user for running the script
	@Test
	public void TC_073_074(Method method) throws Exception {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "PaymentMethods;Passcode Setup Later").assignCategory("PROFILE");
		test.info("Verify New User is able to set up PIN later by selecting SET UP PIN CODE LATER");
		System.out.println(TC_Method);
		SignInPage signInPage = new SignInPage(driver);
		ProfilePage profilePage = new ProfilePage(driver);
		ProfileFunctions profileFunctions = new ProfileFunctions();
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
	}

	//*************************************************Passcode for Existing Users**************************************//

	//Verify Enter PIN code screen is displayed if an existing user trying to add new card
	@Test
	public void TC_75_to_77(Method method) throws Exception   {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("PROFILE");
		test.log(Status.INFO, "Payment Method:Passcode Set up");
		test.info("Verify Enter PIN code screen is displayed if an existing user trying to add new card");
		test.info("Verify the Add New card details screen is displayed");
		System.out.println(TC_Method);
		SignInPage signInPage = new SignInPage(driver);
		ProfilePage profilePage = new ProfilePage(driver);
		HomePage homePage = new HomePage(driver);
		ProfileFunctions profileFunctions = new ProfileFunctions();
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
	}
	//Verify New User is navigating to the previous screen when he clicks back arrow on the PIN code screens
	@Test
	public void TC_078(Method method) throws Exception   {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method).assignCategory("PROFILE");
		test.log(Status.INFO, "Payment Method:Passcode Set up");
		test.info("Verify New User is navigating to the previous screen when he clicks back arrow on the PIN code screens");
		System.out.println(TC_Method);
		SignInPage signInPage = new SignInPage(driver);
		ProfilePage profilePage = new ProfilePage(driver);
		HomePage homePage = new HomePage(driver);
		ProfileFunctions profileFunctions = new ProfileFunctions();
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
		if(generalFunctions.isElementPresent(profilePage.paymentMethods, 30)) {
			test.log(Status.PASS, "Payment Methods Screen displayed");
		}else {
			test.log(Status.FAIL, "Payment Methods Screen NOT displayed");
		}
	}
	//Verify the error message is showing for incorrect pin
	@Test
	public void TC_79(Method method) throws Exception {
		try {
			String TC_Method = method.getName();
			test = extent.createTest(TC_Method);
			test.log(Status.INFO, "SharePay:Passcode Error").assignCategory("PROFILE");
			test.info("Verify the error message is showing for incorrect pin");
			System.out.println(TC_Method);
			SharePayPage sharePayPage = new SharePayPage(driver);
			SharePayFunctions sharePayFunctions = new SharePayFunctions();
			ProfilePage profilePage = new ProfilePage(driver);
			ProfileFunctions profileFunctions = new ProfileFunctions();
			HomePage homePage = new HomePage(driver);
			//New User login
			//	sharePayFunctions.newUserPassPay();


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
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			Assert.fail(e.getMessage());
		}
	}



	////*********************************CHANGE PIN CODE**************************/////////


	//Verify "Change PIN code for Share Pay " button is  NOT visible if the user is not Set the PIN code"
	@Test
	public void TC_32(Method method) {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Profile:Change PIN Code").assignCategory("PROFILE");
		test.info("Verify Change PIN code for Share Pay  button is  NOT visible if the user is not Set the PIN code");
		System.out.println(TC_Method);
		SharePayPage sharePayPage = new SharePayPage(driver);
		SharePayFunctions sharePayFunctions = new SharePayFunctions();
		ProfilePage profilePage = new ProfilePage(driver);
		ProfileFunctions profileFunctions = new ProfileFunctions();
		HomePage homePage = new HomePage(driver);
		//New User login
		//sharePayFunctions.newUserPassPay();

		//SignIn New User and click on Payment Methods
		generalFunctions.isElementPresent(homePage.homeElement, 20);
		homePage.avatarHome.click();

		if(generalFunctions.isElementPresent(profilePage.changePin, 30)) {
			test.log(Status.FAIL, "The Change PIN code for Share Pay button is displayed");
		}else {
			test.log(Status.PASS, "The Change PIN code for Share Pay button is NOT displayed");

		}
	}


	//Verify "Change PIN code for Share Pay " Journey"
	@Test
	public void TC_33_to_43_45(Method method) throws IOException, Exception {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Profile:Change PIN Code").assignCategory("PROFILE");
		test.info("Verify Change PIN code for Share Pay button is visible if the user already set PIN code");
		System.out.println(TC_Method);
		SharePayPage sharePayPage = new SharePayPage(driver);
		SharePayFunctions sharePayFunctions = new SharePayFunctions();
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
	}

	//Verify the Card removed from Wallet and the passcode should be updated on Payment Methods
	@Test
	public void TC_46_to_48(Method method) throws IOException, Exception {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Profile:Change PIN Code").assignCategory("PROFILE");
		test.info("Verify the Card removed from Wallet and the passcode should be updated on Payment Methods");
		System.out.println(TC_Method);
		SharePayPage sharePayPage = new SharePayPage(driver);
		SharePayFunctions sharePayFunctions = new SharePayFunctions();
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
		if(generalFunctions.isElementPresent(profilePage.addNewPaymentMethod, 30)) {
			test.log(Status.PASS, "The Card is removed from the wallet");
		}else {
			test.log(Status.FAIL, "The card is not removed from the Wallet");
		}
	}
	////--need to check
	//Verify the Card removed from SharePayWallet and the passcode should be updated 
	@Test
	public void TC_49_to_50(Method method) throws IOException, Exception {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Profile:Change PIN Code").assignCategory("PROFILE");
		test.info("Verify the Card removed from SharePayWallet and the passcode should be updated");
		System.out.println(TC_Method);
		SharePayPage sharePayPage = new SharePayPage(driver);
		SharePayFunctions sharePayFunctions = new SharePayFunctions();
		ProfilePage profilePage = new ProfilePage(driver);
		ProfileFunctions profileFunctions = new ProfileFunctions();
		HomePage homePage = new HomePage(driver);

		//Go to Payment Methods
		generalFunctions.isElementPresent(homePage.homeElement, 20);
		generalFunctions.isElementPresent(sharePayPage.shareWalletButton, 20);
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
		if(generalFunctions.isElementPresent(profilePage.addNewPaymentMethod, 30)) {
			test.log(Status.PASS, "The Card is removed from the wallet");
		}else {
			test.log(Status.FAIL, "The card is not removed from the Wallet");
		}
	}
}