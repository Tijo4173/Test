package com.share.testscript;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.share.functions.SignInFunctions;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.general.GeneralFunctions.Directions;
import com.share.objectrepository.ExperiencesPage;
import com.share.objectrepository.HomePage;
import com.share.objectrepository.SignInPage;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Experiences extends DriverSetUp
{
	GeneralFunctions generalFunctions = new GeneralFunctions();


	// V2 START

	//Verify user able to view on-boarding screen & able to swipe

	@Test
	public void TC_Experience_001(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Verify user able to view on-boarding screen & able to swipe");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		//String EmailAddress=map.get("TransactionUser").toString();
		//String Password=map.get("TransactionUserPassword").toString();

		try
		{

		driver.resetApp();
		//Login to the App
		signInFunctions.validUserLogin();

		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(1000);

		//Verify OnBoarding displayed
		if(generalFunctions.isElementPresent(objExperiencesPage.OnBoarding, 30))
		{
			test.log(Status.PASS, "OnBoarding Displayed");
		}
		else
		{
			test.log(Status.FAIL, "OnBoarding Not Displayed");
			Assert.fail("OnBoarding Not Displayed");
		}

		//Swipe left
		generalFunctions.swipeHorizontal(0.9,0.01,0.5);
		Thread.sleep(4000);

		if(generalFunctions.isElementPresent(objExperiencesPage.OnBoardingSkip, 30))
		{
			test.log(Status.FAIL, "Failed to swipe through the Onboarding screens");
			Assert.fail("Failed to swipe through the Onboarding screens");
		}
		else
		{
			test.log(Status.PASS, "User should is able to swipe through the Onboarding screens");
		}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}

	}


            //	Verify user able to view continue button in onboarding screens
	@Test
	public void TC_Experience_002(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Verify user able to view continue button in onboarding screens");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		//String EmailAddress=map.get("TransactionUser").toString();
		//String Password=map.get("TransactionUserPassword").toString();

		try
		{

		driver.resetApp();
		//Login to the App
		signInFunctions.validUserLogin();

		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(2000);

		//Verify Continue button displayed
		if(generalFunctions.isElementPresent(objExperiencesPage.OnBoardingContinue, 30))
		{
			test.log(Status.PASS, "Continue Button Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Continue Button Not Displayed");
			Assert.fail("Continue Button Not Displayed");
		}

		generalFunctions.isElementPresent(objExperiencesPage.OnBoardingContinue, 30);
		objExperiencesPage.OnBoardingContinue.click();
		Thread.sleep(1000);
		if(generalFunctions.isElementPresent(objExperiencesPage.OnBoardingSkip, 30))
		{
			test.log(Status.FAIL, "Failed to Continue to the next Onboarding screen");
			Assert.fail("Failed to Continue to the next Onboarding screen");
		}
		else
		{
			test.log(Status.PASS, "User is able to Continue to the next Onboarding screen");
		}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}


	//Verify that the user is able to skip the onboarding screen in the experience section.
	@Test
	public void TC_Experience_003(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Verify user able to skip the onboarding screens");
		test.log(Status.INFO, "Verify user able to view device location access for offer listing ");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		//String EmailAddress=map.get("TransactionUser").toString();
		//String Password=map.get("TransactionUserPassword").toString();

		try
		{
		driver.resetApp();
		//Login to the App
		signInFunctions.validUserLogin();

		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(5000);

		//Verify OnBoarding displayed
		if(generalFunctions.isElementPresent(objExperiencesPage.OnBoarding, 30))
		{
			test.log(Status.PASS, "OnBoarding Displayed");
		}
		else
		{
			test.log(Status.FAIL, "OnBoarding Not Displayed");
			Assert.fail("OnBoarding Not Displayed");
		}

		//Verify Skip button displayed
		if(generalFunctions.isElementPresent(objExperiencesPage.OnBoardingSkip, 30))
		{
			test.log(Status.PASS, "Skip Button Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Skip Button Not Displayed");
			Assert.fail("Skip Button Not Displayed");
		}

		objExperiencesPage.OnBoardingSkip.click();
		Thread.sleep(5000);

		try
		{
			generalFunctions.isElementPresent(objExperiencesPage.AllowAllTheTime, 30);
			if(objExperiencesPage.AllowAllTheTime.isDisplayed()== true)
			{
				test.log(Status.PASS, "Location Access Displayed");
				objExperiencesPage.AllowAllTheTime.click();
		     }
		    }
			catch(Exception x)
			{
				test.log(Status.INFO, "Location Access Already Enabled in Device");
				System.out.println("Location Access Already enabled in device");
			}

		Thread.sleep(2000);

		generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30);

		//Verify SHARE EXPERIENCES displayed
		if(generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30))
		{
			test.log(Status.PASS, "SHARE EXPERIENCES Displayed");
		}
		else
		{
			test.log(Status.FAIL, "SHARE EXPERIENCES Not Displayed");
			Assert.fail("SHARE EXPERIENCES Not Displayed");
		}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	//Verify user able to view share experiences
	@Test
	public void TC_Experience_004(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Verify user able to view share experiences");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		//SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		//SignInFunctions signInFunctions = new SignInFunctions();
		HomePage homepage = new HomePage(driver);
		//String EmailAddress=map.get("TransactionUser").toString();
		//String Password=map.get("TransactionUserPassword").toString();

		try
		{

		//Login to the App
		//generalFunctions.SignIn(EmailAddress, Password, signInPage);
		//signInFunctions.validUserLogin();
		//Thread.sleep(1000);

		// Click Experiences
		//generalFunctions.isElementPresent(objExperiencesPage.OnBoardingContinue, 30);
		//objExperiencesPage.OnBoardingSkip.click();
		//Thread.sleep(4000);

		generalFunctions.isElementPresent(homepage.homeElement, 10);
		homepage.homeElement.click();

		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(2000);

		//Verify SHARE EXPERIENCES displayed

		if(generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30))
		{
			test.log(Status.PASS, "Navigated To SHARE EXPERIENCES");
		}
		else
		{
			test.log(Status.FAIL, "Not Navigated To SHARE EXPERIENCES");
			Assert.fail("Not Navigated To SHARE EXPERIENCES");
		}

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}


   /* //Descoped
    //Experiences-Landing Page
	public void TC_Experience_005(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Experiences-Landing Page");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		//SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		//String EmailAddress=map.get("TransactionUser").toString();
		//String Password=map.get("TransactionUserPassword").toString();

		try
		{

		//Login to the App
		//generalFunctions.SignIn(EmailAddress, Password, signInPage);
		//signInFunctions.validUserLogin();


		//dismiss biometric
		///generalFunctions.isElementPresent(signInPage.biocancel, 30);
		//signInPage.biocancel.click();


		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(2000);


		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		generalFunctions.ScrollDown("SEE ALL");

		//Click on SEE ALL
		//objExperiencesPage.allOffers.click();


		//Verify SHARE EXPERIENCES displayed
		if(generalFunctions.isElementPresent(objExperiencesPage.category1iconshareoffer, 30))
		{
			test.log(Status.PASS, "Able To Scroll Down and View Other Offers");
		}
		else
		{
			test.log(Status.FAIL, "Not Able To Scroll Down and View Other Offers");
			Assert.fail("Not Able To Scroll Down and View Other Offers");
		}

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	} */

	//Verify user able to view 4 categories in experiences
	@Test
	public void TC_Experience_006(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Verify user able to view 4 categories in experiences");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		//SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		HomePage homepage = new HomePage(driver);


		try
		{

		//Login to the App
		//generalFunctions.SignIn(EmailAddress, Password, signInPage);
		//signInFunctions.validUserLogin();

		generalFunctions.isElementPresent(homepage.homeElement, 10);
		homepage.homeElement.click();

		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(2000);

		//Verify SHARE EXPERIENCES page displayed
		if(generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30))
		{
			test.log(Status.PASS, "Navigated To SHARE EXPERIENCES");
		}
		else
		{
			test.log(Status.FAIL, "Not Navigated To SHARE EXPERIENCES");
			Assert.fail("Not Navigated To SHARE EXPERIENCES");
		}

		//Categories

			String Shopping = objExperiencesPage.shareOffers.getText();
		 	if(generalFunctions.isElementPresent(objExperiencesPage.shareOffers, 30))
		 	{
		 		test.log(Status.PASS, Shopping+" "+"Category Displayed");
		 	}
		 	else
		 	{
		 		test.log(Status.FAIL, "Share Offers Category Not Displayed");
		 		Assert.fail("Share Offers Category Not Displayed");
		 	}

			if(generalFunctions.isElementPresent(objExperiencesPage.carrefourOffers, 30))
			{
				test.log(Status.PASS, "Carrefour Offers Category Displayed");
			}

			else
		    {
				test.log(Status.FAIL, "Carrefour Offers Category Not Displayed");
				Assert.fail("Carrefour Offers Category Not Displayed");
		    }



			if(generalFunctions.isElementPresent(objExperiencesPage.memberContests, 30))
			{
				test.log(Status.PASS, "Member Contests Category Displayed");
			}

			else
			{
				test.log(Status.FAIL, "Member Contests Category Not Displayed");
				Assert.fail("Member Contests Category Not Displayed");
			}


			if(generalFunctions.isElementPresent(objExperiencesPage.memberBenefits, 30))
			{
				test.log(Status.PASS, "Member Benefits Category Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Member Benefits Category Not Displayed");
				Assert.fail("Member Benefits Category Not Displayed");
			}

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	//Verify user able to view carrefour offers in carrefour category tab
	@Test
	public void TC_Experience_007(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Verify user able to view carrefour offers in carrefour category tab");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		//SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		HomePage homepage = new HomePage(driver);
		String categorySelection="CARREFOUR OFFER";

		try
		{

		//Login to the App
		//generalFunctions.SignIn(EmailAddress, Password, signInPage);
		generalFunctions.isElementPresent(homepage.homeElement, 10);
		homepage.homeElement.click();

		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(4000);

		//Verify SHARE EXPERIENCES page displayed
		if(generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30))
		{
			test.log(Status.PASS, "Navigated To SHARE EXPERIENCES");
		}
		else
		{
			test.log(Status.FAIL, "Not Navigated To SHARE EXPERIENCES");
			Assert.fail("Not Navigated To SHARE EXPERIENCES");
		}

		//Categories
		if(generalFunctions.isElementPresent(objExperiencesPage.carrefourOffers, 30))
		{
			test.log(Status.PASS, "carrefour Offers Category Displayed");
		}
		else
		{
			test.log(Status.FAIL, "carrefour Offers Category Not Displayed");
			Assert.fail("carrefour Offers Category Not Displayed");
		}

		if(generalFunctions.selectCategory(categorySelection)==true)
		{
			test.log(Status.PASS, "Navigated to the "+categorySelection+" list screen based on the selected "+categorySelection+"category");
		}
		else
		{
			test.log(Status.FAIL, "Not Navigated to the "+categorySelection+" list screen based on the selected "+categorySelection+" category");
			//Assert.fail("Not Navigated to the "+categorySelection+" list screen based on the selected "+categorySelection+" category");
		}

		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}


               //Verify user able to view carrefour category offers detail page
	@Test
	public void TC_Experience_008(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Verify user able to view carrefour category offers detail page");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		//SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		HomePage homepage = new HomePage(driver);

		String categorySelection="CARREFOUR OFFERS";

		try
		{

		//Login to the App
		//generalFunctions.SignIn(EmailAddress, Password, signInPage);
		generalFunctions.isElementPresent(homepage.homeElement, 10);
		homepage.homeElement.click();

		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(2000);


		//Verify SHARE EXPERIENCES page displayed
		if(generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30))
		{
			test.log(Status.PASS, "Navigated To SHARE EXPERIENCES");
		}
		else
		{
			test.log(Status.FAIL, "Not Navigated To SHARE EXPERIENCES");
			Assert.fail("Not Navigated To SHARE EXPERIENCES");
		}

		//Categories
		if(generalFunctions.isElementPresent(objExperiencesPage.carrefourOffers, 30))
		{
			test.log(Status.PASS, "carrefour Offers Category Displayed");
		}
		else
		{
			test.log(Status.FAIL, "carrefour Offers Category Not Displayed");
			Assert.fail("carrefour Offers Category Not Displayed");
		}

		if(generalFunctions.selectCategory(categorySelection)==true)
		{
			test.log(Status.PASS, "Navigated to the "+categorySelection+" list screen based on the selected "+categorySelection+"category");
		}
		else
		{
			test.log(Status.FAIL, "Not Navigated to the "+categorySelection+" list screen based on the selected "+categorySelection+" category");
			Assert.fail("Not Navigated to the "+categorySelection+" list screen based on the selected "+categorySelection+" category");
		}

		//Offers
		if(generalFunctions.isElementPresent(objExperiencesPage.firstOffer, 40))
		{
			test.log(Status.PASS, ""+categorySelection+ " Offers Displayed");
		}
		else
		{
			test.log(Status.FAIL, ""+categorySelection+ " Offers Not Displayed");
			Assert.fail(""+categorySelection+ " Offers Not Displayed");
		}

		generalFunctions.isElementPresent(objExperiencesPage.firstOfferTitle, 40);
		String OfferTitle =generalFunctions.getText(objExperiencesPage.firstOfferTitle);

		objExperiencesPage.firstOfferTitle.click();
		Thread.sleep(5000);

		if(generalFunctions.isElementPresent(objExperiencesPage.DetailedOfferTitle, 30))
		{
			test.log(Status.PASS, "Offer Details Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Offer Details Not Displayed");
			Assert.fail("Offer Details Not Displayed");
		}

		String DetailedOfferTitle =generalFunctions.getText(objExperiencesPage.DetailedOfferTitle);

		if(DetailedOfferTitle.contains(OfferTitle))
		{
			test.log(Status.PASS, "Offer Title verified in the Offer Details Screen");
		}
		else
		{
			test.log(Status.FAIL, "Offer Title verification Failed in the Offer Details Screen");
			Assert.fail("Offer Title verification Failed in the Offer Details Screen");
		}
		generalFunctions.isElementPresent(objExperiencesPage.activatedOfferClose, 20);
		objExperiencesPage.activatedOfferClose.click();
		generalFunctions.isElementPresent(objExperiencesPage.backarrow, 20);
		objExperiencesPage.backarrow.click();

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	//Verify user able to view the offer title,offer image,offer startdate and enddate,sharebutton and activate toggle
	@Test
	public void TC_Experience_009(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Verify user able to view the offer title,offer image,offer start-date& end-date,offer sharebutton and activate toggle");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		//SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		HomePage homepage = new HomePage(driver);


		try
		{

		//Login to the App
		//generalFunctions.SignIn(EmailAddress, Password, signInPage);
		generalFunctions.isElementPresent(homepage.homeElement, 10);
		homepage.homeElement.click();

		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(2500);

		//Verify SHARE EXPERIENCES page displayed

			if(generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30))
			{
				test.log(Status.PASS, "Navigate To SHARE EXPERIENCES");
			}
			else
			{
				test.log(Status.FAIL, "Not Navigated To SHARE EXPERIENCES");
				Assert.fail("Not Navigated To SHARE EXPERIENCES");
			}
			//
			if(generalFunctions.isElementPresent(objExperiencesPage.offerTitle, 30))
			{
				test.log(Status.PASS, "Offer Title Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Offer Title Not Displayed");
				Assert.fail("Offer Title Not Displayed");
			}
			//
			if(generalFunctions.isElementPresent(objExperiencesPage.offerImage, 30))
			{
				test.log(Status.PASS, "Offer Image Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Offer Image Not Displayed");
				Assert.fail("Offer Image Not Displayed");
			}
			//
			if(generalFunctions.isElementPresent(objExperiencesPage.offerStartDate, 30))
			{
				test.log(Status.PASS, "Offer Start Date Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Offer Start Date Not Displayed");
				Assert.fail("Offer Start Date Not Displayed");
			}
			//
			if(generalFunctions.isElementPresent(objExperiencesPage.offerEndDate, 30))
			{
				test.log(Status.PASS, "Offer End Date Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Offer End Date Not Displayed");
				Assert.fail("Offer End Date Not Displayed");
			}
			//
			if(generalFunctions.isElementPresent(objExperiencesPage.offerSponsorLogo, 30))
			{
				test.log(Status.PASS, "Offer Sponsor Logo Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Offer Sponsor Logo Not Displayed");
				Assert.fail("Offer Sponsor Logo Not Displayed");
		    }
			//
			if(generalFunctions.isElementPresent(objExperiencesPage.offerShareButton, 30))
			{
				test.log(Status.PASS, "Offer Share Button Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Offer Share Button Not Displayed");
				Assert.fail("Offer Share Button Not Displayed");
			}
			//
			if(generalFunctions.isElementPresent(objExperiencesPage.offerActivateSwitch, 30))
			{
				test.log(Status.PASS, "Offer Activate Button Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Offer Activate Button Not Displayed");
				Assert.fail("Offer Activate Button Not Displayed");
			}

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}


	//TC: Verify that user able to view collapsed category icons
	@Test
	public void TC_Experience_010(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Verify that user able to view collapsed category icons");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		//SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		HomePage homepage = new HomePage(driver);
		try
		{

		//Login to the App
		//generalFunctions.SignIn(EmailAddress, Password, signInPage);
		generalFunctions.isElementPresent(homepage.homeElement, 10);
		homepage.homeElement.click();

		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(1000);

		//Verify SHARE EXPERIENCES page displayed
		if(generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30))
		{
			test.log(Status.PASS, "Navigated to SHARE EXPERIENCES");
		}
		else
		{
			test.log(Status.FAIL, "Not Navigated to SHARE EXPERIENCES");
			Assert.fail("Not Navigated to SHARE EXPERIENCES");
		}
		generalFunctions.isElementPresent(objExperiencesPage.offerTitle, 20);
		generalFunctions.SimplyScrollDown();
		generalFunctions.isElementPresent(objExperiencesPage.categoryIconBar, 30);

		if(generalFunctions.isElementPresent(objExperiencesPage.categoryName, 30))
		{
			test.log(Status.FAIL, "Offer Category Icons Section Not Collapsed");
			Assert.fail("Offer Category Icons Section Not Collapsed");
		}
		else
		{
			test.log(Status.PASS, "Offer Category Icon Section Collapsed");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.categoryIconBar, 30))
		{
			test.log(Status.PASS, "Offer Category icon section Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Offer Category icon section Not Displayed");
			Assert.fail("Offer Category icon section Not Displayed");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.category1iconshareoffer, 30))
		{
			test.log(Status.PASS, "Collapsed Shareoffer Icon Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Collapsed Shareoffer Icon Not Displayed");
			Assert.fail("Collapsed Shareoffer Icon Section NotDisplayed");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.category2iconmembercontests, 30))
		{
			test.log(Status.PASS, "Collapsed Member Contests Icon Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Collapsed Member Contests Icon Not Displayed");
			Assert.fail("Collapsed Member Contests Icon Not Displayed");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.category3iconcarrefouroffers, 30))
		{
			test.log(Status.PASS, "Collapsed Carrefour Icon Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Collapsed Carrefour Icon Not Displayed");
			Assert.fail("Collapsed Carrefour Icon Not Displayed");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.category4iconmemberbenefits, 30))
		{
			test.log(Status.PASS, "Collapsed Member Benefits Icon Displayed");
			test.log(Status.INFO, "All 4 Collapsed Icons Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Collapsed Member Benefits  Icon Not Displayed");
			Assert.fail("Collapsed Member Benefits Icon Not Displayed");
		}

		//int CategoryIcons=generalFunctions.elementCount(objExperiencesPage.categoryIcons);
		//System.out.println("Icons "+CategoryIcons);

		//if(CategoryIcons==4)
		//{
			//test.log(Status.PASS, "4 Offer Category icon section Displayed");
		//}
		//else
		//{
			//test.log(Status.FAIL, "4 Offer Category icon section Not Displayed");
			//Assert.fail("4 Offer Category icon section Not Displayed");
		//}

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}


            //Verify user able to activate offer from experience page & Deactivate it from activated tab
	@Test
    public void TC_Experience_011(Method method) throws Exception
    {
        String TC_Method = method.getName();
        test = extent.createTest(TC_Method);
        test.log(Status.INFO, "Verify user able to activate offer from experience page & Deactivate it from activated tab");
        test.assignCategory("Experiences");
        System.out.println(TC_Method);

        SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();


        try
        {
        	driver.resetApp();
    		//Login to the App
    		signInFunctions.validUserLogin();

    		// Click Experiences
    		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
    		objExperiencesPage.Experiences.click();
    		Thread.sleep(1000);

    		//Verify OnBoarding displayed
    		if(generalFunctions.isElementPresent(objExperiencesPage.OnBoarding, 30))
    		{
    			test.log(Status.PASS, "OnBoarding Displayed");
    		}
    		else
    		{
    			test.log(Status.FAIL, "OnBoarding Not Displayed");
    			Assert.fail("OnBoarding Not Displayed");
    		}
    		objExperiencesPage.OnBoardingSkip.click();


            //Verify SHARE EXPERIENCES page displayed
            if(generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30))
    		{
    			test.log(Status.PASS, "Navigated To SHARE EXPERIENCES");
    		}
    		else
    		{
    			test.log(Status.FAIL, "Not Navigated To SHARE EXPERIENCES");
    			Assert.fail("Not Navigated To SHARE EXPERIENCES");
    		}
            generalFunctions.isElementPresent(objExperiencesPage.allOffers, 30);
            String OfferTitle=generalFunctions.getText(objExperiencesPage.offerTitle);
            if(generalFunctions.isElementPresent(objExperiencesPage.activateSwitch, 30))
            {
                test.log(Status.PASS, "Offer Activate Button Displayed");
            }else {
                test.log(Status.FAIL, "Offer Activate Button Not Displayed");
            }

            String ActivateStatus =generalFunctions.getText(objExperiencesPage.activateSwitch);
            if(ActivateStatus.contains("ON"))
            {
                System.out.println("Offer Already Activated");
                objExperiencesPage.activateSwitch.click();
                Thread.sleep(2000);
            }
            objExperiencesPage.activateSwitch.click();
            Thread.sleep(4000);
            String ActivatedOffer =generalFunctions.getText(objExperiencesPage.activateSwitch);
            if(ActivatedOffer.contains("ON"))
            {
                test.log(Status.PASS, "Offer Activated");
            }
            else{
                test.log(Status.FAIL, "Offer Not Activated");
                Assert.fail("Offer Not Activated");
            }
            Directions dir = Directions.DOWN;
            generalFunctions.swipeScreen(dir);
            generalFunctions.isElementPresent(objExperiencesPage.activatedOffer, 60);
            objExperiencesPage.activatedOffer.click();
            if(generalFunctions.isElementPresent(objExperiencesPage.activatedOfferPage, 60))
            {
                test.log(Status.PASS, "ACTIVATED OFFERS page Displayed");
            }else{
                test.log(Status.FAIL, "ACTIVATED OFFERS page Not Displayed");



            }
            generalFunctions.isElementPresent(objExperiencesPage.firstOfferTitle, 30);
            System.out.println("Test:...."+OfferTitle);
            if(OfferTitle.contains(generalFunctions.getText(objExperiencesPage.firstOfferTitle)))
            {
                test.log(Status.PASS, "Activated offer Displayed in ACTIVATED OFFERS page");
            }
            else{
                test.log(Status.FAIL, "Activated offer Not Displayed in ACTIVATED OFFERS page");
                Assert.fail("Activated offer Not Displayed in ACTIVATED OFFERS page");
            }
            AndroidElement activatedOffer = objExperiencesPage.checkOfferTitle(OfferTitle);
            objExperiencesPage.offerActivateSwitch.click();
            Thread.sleep(500);
            if(generalFunctions.isElementPresent(activatedOffer, 30))
            {
                test.log(Status.FAIL, "Deactivated offer Not removed from Activated Offers page");
            }else {
                test.log(Status.PASS, "Deactivated offer removed from Activated Offers page");
            }
        }
        catch(Exception e)
        {
            test.log(Status.FAIL, e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

	/*
	//de scoped category
	public void TC_Experience_012(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Experiences-Landing Page");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);

		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();

		try
		{

		//Login to the App
		generalFunctions.SignIn(EmailAddress, Password, signInPage);

		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(15000);

		//Verify SHARE EXPERIENCES page displayed
		generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30);
		try
		{
			if(objExperiencesPage.shareExperiences.isDisplayed()==true)
			{
				test.log(Status.PASS, "SHARE EXPERIENCES page Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "SHARE EXPERIENCES page Not Displayed");
			Assert.fail("SHARE EXPERIENCES page Not Displayed");
		}

		//objExperiencesPage.charity.click();

		try
		{
			//generalFunctions.isElementPresent(objExperiencesPage.charityPage, 30);
			//if(objExperiencesPage.charityPage.isDisplayed()==true)
			{
				test.log(Status.PASS, "Charity page Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Charity page Not Displayed");
			Assert.fail("Charity page Not Displayed");
		}

		try
		{
			generalFunctions.isElementPresent(objExperiencesPage.firstOffer, 20);
			if(objExperiencesPage.firstOffer.isDisplayed()==true)
			{
				test.log(Status.PASS, "User have Offers in this Category");
				System.out.println("User have Offers in this Category");
			}
		}
		catch(Exception e)
		{
			try
			{
				generalFunctions.isElementPresent(objExperiencesPage.NotAvailable, 20);
				if(objExperiencesPage.NotAvailable.isDisplayed()==true)
				{
					test.log(Status.PASS, "Not Available Message Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Not Available Message Not Displayed");
				Assert.fail("Not Available Message Not Displayed");
			}


			try
			{
				if(objExperiencesPage.exploreOtherExperiences.isDisplayed()==true)
				{
					test.log(Status.PASS, "EXPLORE OTHER EXPERIENCES option Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "EXPLORE OTHER EXPERIENCES option Not Displayed");
				Assert.fail("EXPLORE OTHER EXPERIENCES option Not Displayed");
			}

			//objExperiencesPage.exploreOtherExperiences.click();


		}

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	*/

	//Verify user able to share the offer from experiences
	@Test
	public void TC_Experience_013(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Verify user able to share the offer from experiences");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		//SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		HomePage homepage = new HomePage(driver);

		try
		{

		//Login to the App
		//generalFunctions.SignIn(EmailAddress, Password, signInPage);
		generalFunctions.isElementPresent(homepage.homeElement, 10);
    	homepage.homeElement.click();

		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(2000);

		//Verify SHARE EXPERIENCES page displayed
		if(generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30))
		{
			test.log(Status.PASS, "Navigated To SHARE EXPERIENCES");
		}
		else
		{
			test.log(Status.FAIL, "Not Navigated To SHARE EXPERIENCES");
			Assert.fail("Not Navigated To SHARE EXPERIENCES");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.offer, 40))
		{
			test.log(Status.PASS, "Offer Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Offer Not Displayed");
			Assert.fail("Offer Not Displayed");
		}


		objExperiencesPage.offerShareButton.click();

		if(generalFunctions.isElementPresent(objExperiencesPage.shareOptions, 30))
		{
			test.log(Status.PASS, "Share Referral Pop-Up Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Share Referral Pop-Up Not Displayed");
			Assert.fail("Share Referral Pop-Up Not Displayed");
		}

		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	//Verify user able to view detailed offer screen and share referal icon
	@Test
	public void TC_Experience_014(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Verify user able to view detailed offer screen and share refferal icon");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		//SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		HomePage homepage = new HomePage(driver);

		try
		{

		//Login to the App
		//generalFunctions.SignIn(EmailAddress, Password, signInPage);
		generalFunctions.isElementPresent(homepage.homeElement, 10);
	    homepage.homeElement.click();

		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(2000);


		//Verify SHARE EXPERIENCES page displayed
		if(generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30))
		{
			test.log(Status.PASS, "Navigated To SHARE EXPERIENCES");
		}
		else
		{
			test.log(Status.FAIL, "Not Navigated To SHARE EXPERIENCES");
			Assert.fail("Not Navigated To SHARE EXPERIENCES");
		}

		generalFunctions.isElementPresent(objExperiencesPage.offerTitle, 40);
		String OfferTitle =generalFunctions.getText(objExperiencesPage.offerTitle);

		objExperiencesPage.offerTitle.click();
		Thread.sleep(2000);

		if(generalFunctions.isElementPresent(objExperiencesPage.DetailedOfferTitle, 30))
		{
			test.log(Status.PASS, "Offer Details Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Offer Details Not Displayed");
			Assert.fail("Offer Details Not Displayed");
		}

		String DetailedOfferTitle =generalFunctions.getText(objExperiencesPage.DetailedOfferTitle);

		if(DetailedOfferTitle.contains(OfferTitle))
		{
			test.log(Status.PASS, "Offer Title verified in the Offer Details Screen");
		}
		else
		{
			test.log(Status.FAIL, "Offer Title verification Failed in the Offer Details Screen");
			Assert.fail("Offer Title verification Failed in the Offer Details Screen");
		}
		if(generalFunctions.isElementPresent(objExperiencesPage.detailedOfferShareIcon, 40))
		{
				test.log(Status.PASS, "Share Icon Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Share Icon Not Displayed");
			Assert.fail("Share Icon Not Displayed");
		}
		objExperiencesPage.detailedOfferShareIcon.click();

		if(generalFunctions.isElementPresent(objExperiencesPage.shareOptions, 30))
		{
			test.log(Status.PASS, "Share referral medium pop-up Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Share referral medium pop-up Not Displayed");
			Assert.fail("Share referral medium pop-up Not Displayed");
		}
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		//navigate back to share experience page for next script
		objExperiencesPage.activatedOfferClose.click();

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	//Verify user able to view filter and filter options
	@Test
	public void TC_Experience_015_to_017(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Verify user able to view filter and filter options");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		//SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		HomePage homepage = new HomePage(driver);


		try
		{
		//Login to the App
	    //generalFunctions.SignIn(EmailAddress, Password, signInPage);
		generalFunctions.isElementPresent(homepage.homeElement, 10);
		homepage.homeElement.click();

		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(1000);


		//Verify SHARE EXPERIENCES page displayed
		if(generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30))
		{
			test.log(Status.PASS, "Navigated To SHARE EXPERIENCES");
		}
		else
		{
			test.log(Status.FAIL, "Not Navigated To SHARE EXPERIENCES");
			Assert.fail("Not Navigated To SHARE EXPERIENCES");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.offerFilter, 30))
		{
			test.log(Status.PASS, "Filter icon Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Filter icon Not Displayed");
			Assert.fail("Filter icon Not Displayed");
		}

		objExperiencesPage.offerFilter.click();

		if(generalFunctions.isElementPresent(objExperiencesPage.filtersPage, 30))
		{
			test.log(Status.PASS, "Filters page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Filters page Not Displayed");
			Assert.fail("Filters page Not Displayed");
		}

		if(objExperiencesPage.locationDubai.isDisplayed()&&objExperiencesPage.locationAbuDhabi.isDisplayed()&&objExperiencesPage.locationAjman.isDisplayed()
		&&objExperiencesPage.locationRasAlKhaimah.isDisplayed()&&objExperiencesPage.locationSharjah.isDisplayed()&&objExperiencesPage.locationUmmAlQuwain.isDisplayed()&&objExperiencesPage.locationFujairah.isDisplayed()	)
		{
			test.log(Status.PASS, "User is Not able to see all the Emirates Location");
		}
		else
		{
			test.log(Status.FAIL, "User is Not able to see all the Emirates Location");
			Assert.fail("User is Not able to see all the Emirates Location");
		}

		objExperiencesPage.locationDubai.click();

		if(generalFunctions.isElementPresent(objExperiencesPage.nearby, 60))
		{
			test.log(Status.PASS, "Nearby option Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Nearby option Not Displayed");
			Assert.fail("Nearby option Not Displayed");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.clearAll, 30))
		{
			test.log(Status.PASS, "Clear All Button Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Clear All Button Not Displayed");
			Assert.fail("Clear All Button Not Displayed");
		}
		if(objExperiencesPage.showExperiences.isDisplayed()==true)
		{
			test.log(Status.PASS, "Show Experiences Button Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Show Experiences Button Not Displayed");
			Assert.fail("Show Experiences Button Not Displayed");
		}

		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	//Verify user able to view the locations in filter
	@Test
	public void TC_Experience_018_019(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Verify user able to view the locations in filter");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		//SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		HomePage homepage = new HomePage(driver);


		try
		{
		//Login to the App
		//generalFunctions.SignIn(EmailAddress, Password, signInPage);
		generalFunctions.isElementPresent(homepage.homeElement, 10);
		homepage.homeElement.click();

		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(2000);

		//Verify SHARE EXPERIENCES page displayed
		if(generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30))
		{
			test.log(Status.PASS, "Navigated To SHARE EXPERIENCES");
		}
		else
		{
			test.log(Status.FAIL, "Not Navigated To SHARE EXPERIENCES");
			Assert.fail("Not Navigated To SHARE EXPERIENCES");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.offerFilter, 30))
		{
			test.log(Status.PASS, "Filter icon Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Filter icon Not Displayed");
			Assert.fail("Filter icon Not Displayed");
		}

		objExperiencesPage.offerFilter.click();
		if(generalFunctions.isElementPresent(objExperiencesPage.filtersPage, 30))
		{
			test.log(Status.PASS, "Filters page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Filters page Not Displayed");
			Assert.fail("Filters page Not Displayed");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.locationDubai, 30))
		{
			test.log(Status.PASS, "User is Not able to see all the Emirates Location");
		}
		else
		{
			test.log(Status.FAIL, "User is Not able to see all the Emirates Location");
			Assert.fail("User is Not able to see all the Emirates Location");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.clearAll, 30))
		{
			test.log(Status.PASS, "Clear All Button Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Clear All Button Not Displayed");
			Assert.fail("Clear All Button Not Displayed");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.clearAll, 30))
		{
			test.log(Status.PASS, "Clear All Button is Disabled by Default");
		}
		else
		{
			test.log(Status.FAIL, "Clear All Button is Not Disabled by Default");
			Assert.fail("Clear All Button is Not Disabled by Default");
		}

		objExperiencesPage.locationDubai.click();
		Thread.sleep(4000);

		if(generalFunctions.isElementPresent(objExperiencesPage.clearAll, 30))
		{
			test.log(Status.PASS, "Clear All Button is Enabled when user selects a filter option");
		}
		else
		{
			test.log(Status.FAIL, "Clear All Button is Not Enabled even after user selects a filter option");
			Assert.fail("Clear All Button is Not Enabled even after user selects a filter option");
		}

		objExperiencesPage.clearAll.click();
		Thread.sleep(4000);

		if(generalFunctions.isElementPresent(objExperiencesPage.locationDubai, 60))
		{
			test.log(Status.PASS, "Selected filter is cleared");
		}
		else
		{
			test.log(Status.FAIL, "Selected filter is Not cleared");
			Assert.fail("Selected filter is Not cleared");
		}
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	//Verify user able to filter by Earn only
	@Test
	public void TC_Experience_020(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Verify user able to filter by Earn only");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		//SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		HomePage homepage = new HomePage(driver);

		try
		{
		//Login to the App
		//generalFunctions.SignIn(EmailAddress, Password, signInPage);
		generalFunctions.isElementPresent(homepage.homeElement, 10);
		homepage.homeElement.click();

		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(2000);

		//Verify SHARE EXPERIENCES page displayed
		if(generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30))
		{
			test.log(Status.PASS, "Navigated To SHARE EXPERIENCES");
		}
		else
		{
			test.log(Status.FAIL, "Not Navigated To SHARE EXPERIENCES");
			Assert.fail("Not Navigated To SHARE EXPERIENCES");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.offerFilter, 30))
		{
				test.log(Status.PASS, "Filter icon Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Filter icon Not Displayed");
			Assert.fail("Filter icon Not Displayed");
		}

		objExperiencesPage.offerFilter.click();

		if(generalFunctions.isElementPresent(objExperiencesPage.filtersPage, 30))
		{
			test.log(Status.PASS, "Filters page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Filters page Not Displayed");
			Assert.fail("Filters page Not Displayed");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.offerType, 30))
		{
			test.log(Status.PASS, "Offer Type Filter Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Offer Type Filter Not Displayed");
			Assert.fail("Offer Type Filter Not Displayed");
		}

		if(objExperiencesPage.earnOnly.isDisplayed()==true)
		{
			test.log(Status.PASS, "Earn Only Option Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Earn Only Option Not Displayed");
			Assert.fail("Earn Only Option Not Displayed");
		}

		objExperiencesPage.earnOnly.click();
		Thread.sleep(2000);

		objExperiencesPage.showExperiences.click();
		Thread.sleep(4000);

		if(generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30))
		{
			test.log(Status.PASS, "Navigated To SHARE EXPERIENCES");
		}
		else
		{
			test.log(Status.FAIL, "Not Navigated To SHARE EXPERIENCES");
			Assert.fail("Not Navigated To SHARE EXPERIENCES");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.offerFilter, 30))
		{
			test.log(Status.PASS, "Filter icon Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Filter icon Not Displayed");
			Assert.fail("Filter icon Not Displayed");
		}

		objExperiencesPage.offerFilter.click();

		if(generalFunctions.isElementPresent(objExperiencesPage.filtersPage, 30))
		{
			test.log(Status.PASS, "Filters page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Filters page Not Displayed");
			Assert.fail("Filters page Not Displayed");
		}

		objExperiencesPage.clearAll.click();

		objExperiencesPage.showExperiences.click();
		Thread.sleep(4000);

		if(generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30))
		{
			test.log(Status.PASS, "Navigated To SHARE EXPERIENCES");
		}
		else
		{
			test.log(Status.FAIL, "Not Navigated To SHARE EXPERIENCES");
			Assert.fail("Not Navigated To SHARE EXPERIENCES");
		}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	//Verify user able to filter by online availability
	@Test
	public void TC_Experience_21(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Verify user able to filter by online availability");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		//SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		HomePage homepage = new HomePage(driver);

		try
		{

		//Login to the App
		//generalFunctions.SignIn(EmailAddress, Password, signInPage);
		generalFunctions.isElementPresent(homepage.homeElement, 10);
		homepage.homeElement.click();

		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(2000);

		//Verify SHARE EXPERIENCES page displayed
		if(generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30))
		{
			test.log(Status.PASS, "Navigated To SHARE EXPERIENCES");
		}
		else
		{
			test.log(Status.FAIL, "Not Navigated To SHARE EXPERIENCES");
			Assert.fail("Not Navigated To SHARE EXPERIENCES");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.offerFilter, 30))
		{
			test.log(Status.PASS, "Filter icon Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Filter icon Not Displayed");
			Assert.fail("Filter icon Not Displayed");
		}
		objExperiencesPage.offerFilter.click();
		if(generalFunctions.isElementPresent(objExperiencesPage.filtersPage, 30))
		{
			test.log(Status.PASS, "Filters page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Filters page Not Displayed");
			Assert.fail("Filters page Not Displayed");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.availability, 30))
		{
			test.log(Status.PASS, "Availability Type Filter Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Availability Type Filter Not Displayed");
			Assert.fail("Availability Type Filter Not Displayed");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.online, 30))
		{
			test.log(Status.PASS, "Online Availability Filter Option Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Online Availability Filter Option Not Displayed");
			Assert.fail("Online Availability Filter Option Not Displayed");
		}

		objExperiencesPage.online.click();
		Thread.sleep(2000);

		objExperiencesPage.showExperiences.click();
		Thread.sleep(3000);

		if(generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30))
		{
			test.log(Status.PASS, "Navigated To SHARE EXPERIENCES");
		}
		else
		{
			test.log(Status.FAIL, "Not Navigated To SHARE EXPERIENCES");
			Assert.fail("Not Navigated To SHARE EXPERIENCES");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.offerFilter, 30))
		{
			test.log(Status.PASS, "Filter icon Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Filter icon Not Displayed");
			Assert.fail("Filter icon Not Displayed");
		}

		objExperiencesPage.offerFilter.click();

		if(generalFunctions.isElementPresent(objExperiencesPage.filtersPage, 30))
		{
			test.log(Status.PASS, "Filters page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Filters page Not Displayed");
			Assert.fail("Filters page Not Displayed");
		}

		objExperiencesPage.clearAll.click();

		objExperiencesPage.showExperiences.click();
		Thread.sleep(4000);

		if(generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30))
		{
			test.log(Status.PASS, "Navigated Back To SHARE EXPERIENCES");
		}
		else
		{
			test.log(Status.FAIL, "Not Navigated Back To SHARE EXPERIENCES");
			Assert.fail("Not Navigated Back To SHARE EXPERIENCES");
		}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}


	/*//Expiry Category Descoped
	public void TC_Experience_022(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Filters and filtered view (Offer)");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		//SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);

		//String EmailAddress=map.get("TransactionUser").toString();
		//String Password=map.get("TransactionUserPassword").toString();

		try
		{

		//Login to the App
		//generalFunctions.SignIn(EmailAddress, Password, signInPage);

		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(1000);

		//Verify SHARE EXPERIENCES page displayed
		if(generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30))
		{
			test.log(Status.PASS, "Navigated To SHARE EXPERIENCES");
		}
		else
		{
			test.log(Status.FAIL, "Not Navigated To SHARE EXPERIENCES");
			Assert.fail("Not Navigated To SHARE EXPERIENCES");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.offerFilter, 30))
		{
			test.log(Status.PASS, "Filter icon Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Filter icon Not Displayed");
			Assert.fail("Filter icon Not Displayed");
		}

		objExperiencesPage.offerFilter.click();

		if(generalFunctions.isElementPresent(objExperiencesPage.filtersPage, 30))
		{
			test.log(Status.PASS, "Filters page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Filters page Not Displayed");
			Assert.fail("Filters page Not Displayed");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.expiry, 30))
		{
			test.log(Status.PASS, "Expiry Filter Displayed");
		}
		else

		{
			test.log(Status.FAIL, "Expiry Filter Not Displayed");
			Assert.fail("Expiry Filter Not Displayed");
		}

		try
		{
			if(objExperiencesPage.expirySeekBar.isDisplayed()==true)
			{
				test.log(Status.PASS, "Expiry SeekBar Filter Option Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Expiry SeekBar Filter Option Not Displayed");
			Assert.fail("Expiry SeekBar Filter Option Not Displayed");
		}

		objExperiencesPage.expirySeekBar.sendKeys("51");

		Thread.sleep(2000);

		objExperiencesPage.showExperiences.click();
		Thread.sleep(4000);

		generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30);
		try
		{
			if(objExperiencesPage.shareExperiences.isDisplayed()==true)
			{
				test.log(Status.PASS, "SHARE EXPERIENCES page Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "SHARE EXPERIENCES page Not Displayed");
			Assert.fail("SHARE EXPERIENCES page Not Displayed");
		}

		try
		{
			generalFunctions.isElementPresent(objExperiencesPage.offerFilter, 30);
			if(objExperiencesPage.offerFilter.isDisplayed()==true)
			{
				test.log(Status.PASS, "Filter icon Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Filter icon Not Displayed");
			Assert.fail("Filter icon Not Displayed");
		}

		objExperiencesPage.offerFilter.click();

		try
		{
			generalFunctions.isElementPresent(objExperiencesPage.filtersPage, 30);
			if(objExperiencesPage.filtersPage.isDisplayed()==true)
			{
				test.log(Status.PASS, "Filters page Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Filters page Not Displayed");
			Assert.fail("Filters page Not Displayed");
		}

		objExperiencesPage.clearAll.click();

		objExperiencesPage.showExperiences.click();
		Thread.sleep(4000);

		generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30);
		try
		{
			if(objExperiencesPage.shareExperiences.isDisplayed()==true)
			{
				test.log(Status.PASS, "SHARE EXPERIENCES page Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "SHARE EXPERIENCES page Not Displayed");
			Assert.fail("SHARE EXPERIENCES page Not Displayed");
		}

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	} */


	@Test
	public void TC_Experience_023_024(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Verify user able to view offer detail page offer");
		test.log(Status.INFO, "Verify offer detail page have offer title,image,startdate & end date,offer logo and share button ");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		//SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		HomePage homepage = new HomePage(driver);

		try
		{

		//Login to the App
		//generalFunctions.SignIn(EmailAddress, Password, signInPage);
		generalFunctions.isElementPresent(homepage.homeElement, 10);
		homepage.homeElement.click();

		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(2000);


		//Verify SHARE EXPERIENCES page displayed
		if(generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30))
		{
			test.log(Status.PASS, "Navigated To SHARE EXPERIENCES");
		}
		else
		{
			test.log(Status.FAIL, "Not Navigated To SHARE EXPERIENCES");
			Assert.fail("Not Navigated To SHARE EXPERIENCES");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.offer, 30))
		{
			test.log(Status.PASS, "Offer Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Offer Not Displayed");
			Assert.fail("Offer Not Displayed");
		}

		String OfferTitle =generalFunctions.getText(objExperiencesPage.offerTitle);
		System.out.println(OfferTitle);
		objExperiencesPage.offerTitle.click();

		if(generalFunctions.isElementPresent(objExperiencesPage.DetailedOfferTitle, 30))
		{
			test.log(Status.PASS, "Offer Details Page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Offer Details Page Not Displayed");
			Assert.fail("Offer Details Page Not Displayed");
		}

		String DetailedOfferTitle =generalFunctions.getText(objExperiencesPage.DetailedOfferTitle);
		System.out.println(DetailedOfferTitle);

		/*if(OfferTitle.contains(DetailedOfferTitle))
		{
			test.log(Status.PASS, "Offer Title verified in the Offer Details Screen");
		}
		else
		{
			test.log(Status.FAIL, "Offer Title verification Failed in the Offer Details Screen");
			Assert.fail("Offer Title verification Failed in the Offer Details Screen");
		}*/

		if(generalFunctions.isElementPresent(objExperiencesPage.DetailedOfferImage, 30))
		{
			test.log(Status.PASS, "Offer Image Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Offer Image Not Displayed");
			Assert.fail("Offer Image Not Displayed");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.DetailedOfferStartDate, 30))
		{
			test.log(Status.PASS, "Offer Start Date Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Offer Start Date Not Displayed");
			Assert.fail("Offer Start Date Not Displayed");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.DetailedOfferEndDate, 30))
		{
			test.log(Status.PASS, "Offer End Date Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Offer End Date Not Displayed");
			Assert.fail("Offer End Date Not Displayed");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.DetailedOfferLogo, 30))
		{
			test.log(Status.PASS, "Offer Sponsor Logo Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Offer Sponsor Logo Not Displayed");
			Assert.fail("Offer Sponsor Logo Not Displayed");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.detailedOfferShareIcon, 30))
		{
			test.log(Status.PASS, "Offer Share Button Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Offer Share Button Not Displayed");
			Assert.fail("Offer Share Button Not Displayed");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.DetailedOfferActivate, 30))
		{
			test.log(Status.PASS, "Offer Activate Button Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Offer Activate Button Not Displayed");
			Assert.fail("Offer Activate Button Not Displayed");
		}

		objExperiencesPage.activatedOfferClose.click();

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}


	@Test
	public void TC_Experience_025_to_029(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Verify user able to search different keywords in search page");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		//SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		HomePage homepage = new HomePage(driver);

		String searchKeyWord="dubai";
		String searchKeyWord2="offer";
		String searchKeyWord3="discount";

		try
		{


		//Login to the App
		//generalFunctions.SignIn(EmailAddress, Password, signInPage);
		generalFunctions.isElementPresent(homepage.homeElement, 10);
		homepage.homeElement.click();

		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(10000);

		//Verify SHARE EXPERIENCES page displayed
		if(generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30))
		{
			test.log(Status.PASS, "Navigated To SHARE EXPERIENCES");
		}
		else
		{
			test.log(Status.FAIL, "Not Navigated To SHARE EXPERIENCES");
			Assert.fail("Not Navigated To SHARE EXPERIENCES");
		}

		generalFunctions.isElementPresent(objExperiencesPage.searchIcon, 30);
		objExperiencesPage.searchIcon.click();

		if(generalFunctions.isElementPresent(objExperiencesPage.searchPage, 30))
		{
			test.log(Status.PASS, "Search page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Search page Not Displayed");
			Assert.fail("Search page Not Displayed");
		}
		if(generalFunctions.isElementPresent(objExperiencesPage.searchField, 30))
		{
			test.log(Status.PASS, "Search field Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Search field Not Displayed");
			Assert.fail("Search field Not Displayed");
		}
		objExperiencesPage.searchField.click();
		objExperiencesPage.searchField.sendKeys(searchKeyWord);

		generalFunctions.pressSearch();
		Thread.sleep(4000);

		if(generalFunctions.isElementPresent(objExperiencesPage.searchResult, 30))
		{
			test.log(Status.PASS, "Search Result Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Search Result Not Displayed");
			Assert.fail("Search Result Not Displayed");
		}

		objExperiencesPage.searchClear.click();

		if(generalFunctions.isElementPresent(objExperiencesPage.recentSearchItem, 20))
		{
			test.log(Status.PASS, "Recent Search Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Recent Search Not Displayed");
			Assert.fail("Recent Search Not Displayed");
		}

		objExperiencesPage.searchField.click();
		objExperiencesPage.searchField.sendKeys(searchKeyWord2);

		generalFunctions.pressSearch();
		Thread.sleep(4000);

		if(generalFunctions.isElementPresent(objExperiencesPage.searchResult, 30))
		{
			test.log(Status.PASS, "Search Result Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Search Result Not Displayed");
			Assert.fail("Search Result Not Displayed");
		}

		objExperiencesPage.searchClear.click();

		objExperiencesPage.searchField.click();
		objExperiencesPage.searchField.sendKeys(searchKeyWord3);

		generalFunctions.pressSearch();
		Thread.sleep(4000);

		if(generalFunctions.isElementPresent(objExperiencesPage.searchResult, 30))
		{
			test.log(Status.PASS, "Search Result Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Search Result Not Displayed");
			Assert.fail("Search Result Not Displayed");
		}

		objExperiencesPage.searchClear.click();

		if(objExperiencesPage.recentSearches(searchKeyWord).isDisplayed()&&objExperiencesPage.recentSearches(searchKeyWord2).isDisplayed()
				&&objExperiencesPage.recentSearches(searchKeyWord3).isDisplayed())
		{
			test.log(Status.PASS, "Recent 3 Search keywords Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Recent 3 Search keywords Not Displayed");
			Assert.fail("Recent 3 Search keywords Not Displayed");
		}
		objExperiencesPage.clearButton.click();
		Thread.sleep(4000);

		if(objExperiencesPage.recentSearches(searchKeyWord).isDisplayed()&&objExperiencesPage.recentSearches(searchKeyWord2).isDisplayed()
				&&objExperiencesPage.recentSearches(searchKeyWord3).isDisplayed())
		{
			test.log(Status.FAIL, "Recent Search keywords Not Cleared");
			Assert.fail("Recent Search keywords Not Cleared");
		}
		else
		{
			test.log(Status.PASS, "Recent 3 Search keywords Cleared");
		}

		int trySearches = generalFunctions.elementCount(objExperiencesPage.trySearch);
		if(trySearches==4)
		{
			test.log(Status.PASS, "4 Try Search options Displayed");
		}
		else
		{
			test.log(Status.FAIL, "4 Try Search options Not Displayed");
			Assert.fail("4 Try Search options Not Displayed");
		}

		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}


	@Test
	public void TC_Experience_030(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Verify user not able find results in search page while giving special characters");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		//SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		HomePage homepage = new HomePage(driver);

		//String EmailAddress=map.get("TransactionUser").toString();
		//String Password=map.get("TransactionUserPassword").toString();
		String searchKeyWord="@#&*";


		try
		{

		//Login to the App
		//generalFunctions.SignIn(EmailAddress, Password, signInPage);
		generalFunctions.isElementPresent(homepage.homeElement, 10);
		homepage.homeElement.click();

		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(1000);

		//Verify SHARE EXPERIENCES page displayed

		if(generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30))
		{
			test.log(Status.PASS, "Navigated To SHARE EXPERIENCES");
		}
		else
		{
			test.log(Status.FAIL, "Not Navigated To SHARE EXPERIENCES");
			Assert.fail("Not Navigated To SHARE EXPERIENCES");
		}

		generalFunctions.isElementPresent(objExperiencesPage.searchIcon, 30);
		objExperiencesPage.searchIcon.click();

		if(generalFunctions.isElementPresent(objExperiencesPage.searchPage, 30))
		{
			test.log(Status.PASS, "Search Page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Search Page Not Displayed");
			Assert.fail("Search Page Not Displayed");
		}

		if(generalFunctions.isElementPresent(objExperiencesPage.searchField, 30))
		{
			test.log(Status.PASS, "Search Field Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Search Field Not Displayed");
			Assert.fail("Search Field Not Displayed");
		}

		objExperiencesPage.searchField.click();
		objExperiencesPage.searchField.sendKeys(searchKeyWord);
		Thread.sleep(2000);

		generalFunctions.pressSearch();
		Thread.sleep(3000);

		if(generalFunctions.isElementPresent(objExperiencesPage.noResultfound, 30))
		{
		   test.log(Status.PASS, "No Results Found For Special Characters");
		}
		else
		{
			test.log(Status.FAIL, "Fail! Results Found For Special Characters");
			Assert.fail("Fail! Results Found For Special Characters");
		}

		//if(generalFunctions.getText(objExperiencesPage.searchField).contains(searchKeyWord))
		//{
			//test.log(Status.FAIL, "Special Characters are allowing in Search field");
			//Assert.fail("Special Characters are allowing in Search field");
		//}
		//else
		//{
			//test.log(Status.PASS, "Special Characters are Not allowing in Search field");
		//}

		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}


	@Test
	public void TC_Experience_031_035(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Verify user able deactivate offers from activated tab");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		//SignInPage signInPage = new SignInPage(driver);
		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();

		//String EmailAddress=map.get("TransactionUser").toString();
		//String Password=map.get("TransactionUserPassword").toString();


		try
		{
			driver.resetApp();
			signInFunctions.ActivatedOfferUser();
			Thread.sleep(2000);

			// Click Experiences
			generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
			objExperiencesPage.Experiences.click();
			Thread.sleep(2000);

			//Verify Skip button displayed
			if(generalFunctions.isElementPresent(objExperiencesPage.OnBoardingSkip, 30))
			{
				test.log(Status.PASS, "Skip Button Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Skip Button Not Displayed");
				Assert.fail("Skip Button Not Displayed");
			}

			objExperiencesPage.OnBoardingSkip.click();
			Thread.sleep(4000);

			//Verify SHARE EXPERIENCES page displayed
			generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30);
			if(generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30))
			{
				test.log(Status.PASS, "Navigated To SHARE EXPERIENCES");
			}
			else
			{
				test.log(Status.FAIL, "Not Navigated To SHARE EXPERIENCES");
				Assert.fail("Not Navigated To SHARE EXPERIENCES");
			}

			if(generalFunctions.isElementPresent(objExperiencesPage.offer, 30))
			{
				test.log(Status.PASS, "Offer Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Offer Not Displayed");
				Assert.fail("Offer Not Displayed");
			}

			String OfferTitle =generalFunctions.getText(objExperiencesPage.offerTitle);
			System.out.println(OfferTitle);


			if(generalFunctions.isElementPresent(objExperiencesPage.offerActivateSwitch, 30))
			{
				test.log(Status.PASS, "Offer Activate Button Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Offer Activate Button Not Displayed");
				Assert.fail("Offer Activate Button Not Displayed");
			}

			String ActivateStatus =generalFunctions.getText(objExperiencesPage.offerActivateSwitch);
			if(ActivateStatus.contains("ON"))
			{
				System.out.println("Offer Already Activated");
				objExperiencesPage.offerActivateSwitch.click();
				Thread.sleep(2000);
			}

			objExperiencesPage.offerActivateSwitch.click();
			Thread.sleep(4000);

			String ActivatedOffer =generalFunctions.getText(objExperiencesPage.offerActivateSwitch);
			if(ActivatedOffer.contains("ON"))
			{
				test.log(Status.PASS, "Offer Activated");
			}
			else
			{
				test.log(Status.FAIL, "Offer Not Activated");
				Assert.fail("Offer Not Activated");
			}

			if(generalFunctions.isElementPresent(objExperiencesPage.activatedOffer, 60))
			{
				test.log(Status.PASS, "You have Activated Offers- message is displayed in the experience landing page");
				objExperiencesPage.activatedOffer.click();
				Thread.sleep(4000);
			}
			else
			{
				test.log(Status.FAIL, "You have Activated Offers- message is Not displayed in the experience landing page");
				Assert.fail("You have Activated Offers- message is Not displayed in the experience landing page");
			}

			if(generalFunctions.isElementPresent(objExperiencesPage.activatedOfferPage, 30))
			{
				test.log(Status.PASS, "ACTIVATED OFFERS page Displayed");
			}
			else
			{
				test.log(Status.FAIL, "ACTIVATED OFFERS page Not Displayed");
				Assert.fail("ACTIVATED OFFERS page Not Displayed");
			}

				generalFunctions.isElementPresent(objExperiencesPage.firstOfferTitle, 30);
				if(OfferTitle.contains(generalFunctions.getText(objExperiencesPage.firstOfferTitle)))
				{
					test.log(Status.PASS, "Activated offer Displayed in ACTIVATED OFFERS page");
				}
				else
				{
					test.log(Status.FAIL, "Activated offer Not Displayed in ACTIVATED OFFERS page");
					Assert.fail("Activated offer Not Displayed in ACTIVATED OFFERS page");
				}

				objExperiencesPage.firstOfferTitle.click();
				generalFunctions.isElementPresent(objExperiencesPage.DetailedOfferTitle, 30);


				if(generalFunctions.isElementPresent(objExperiencesPage.DetailedOfferTitle, 30))
				{
					test.log(Status.PASS, "ACTIVATED OFFERS details page Displayed");
				}
				else
				{
					test.log(Status.FAIL, "ACTIVATED OFFERS details page Not Displayed");
					Assert.fail("ACTIVATED OFFERS details page Not Displayed");
				}

				objExperiencesPage.activatedOfferClose.click();
				Thread.sleep(4000);

				generalFunctions.isElementPresent(objExperiencesPage.activateSwitch, 20);
				objExperiencesPage.activateSwitch.click();

				String OfferTitle2 =generalFunctions.getText(objExperiencesPage.offerTitlecompare);
				System.out.println(OfferTitle2);

				if(OfferTitle2.contains(generalFunctions.getText(objExperiencesPage.offerTitle)))
				{
					test.log(Status.PASS, "Deactiavted offer removed from Activated Offers page");
				}
				else
				{
					test.log(Status.FAIL, "Deactiavted offer Not removed from Activated Offers page");
					Assert.fail("Deactiavted offer Not removed from Activated Offers page");
				}

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	//Verify user able to view carrefour detail page and able to activate offer from carrefour category
	@Test
	public void TC_Experience_36_To_38(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Verify user able to view carrefour detail page and able to activate offer from carrefour category");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		String categorySelection="CARREFOUR OFFERS";

		try
		{

			driver.resetApp();
			//Login to the App
			signInFunctions.validUserLogin();

			// Click Experiences
			generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
			objExperiencesPage.Experiences.click();

			//Verify Skip button displayed
			if(generalFunctions.isElementPresent(objExperiencesPage.OnBoardingSkip, 30))
			{
				test.log(Status.PASS, "Skip Button Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Skip Button Not Displayed");
				Assert.fail("Skip Button Not Displayed");
			}

			objExperiencesPage.OnBoardingSkip.click();
			Thread.sleep(4000);

			//Verify SHARE EXPERIENCES page displayed
			generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30);
			if(generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30))
			{
				test.log(Status.PASS, "Navigated To SHARE EXPERIENCES");
			}
			else
			{
				test.log(Status.FAIL, "Not Navigated To SHARE EXPERIENCES");
				Assert.fail("Not Navigated To SHARE EXPERIENCES");
			}

			if(generalFunctions.selectCategory(categorySelection)==true)
			{
				test.log(Status.PASS, "Navigated to the "+categorySelection+" list screen based on the selected "+categorySelection+"category");
			}
			else
			{
				test.log(Status.FAIL, "Not Navigated to the "+categorySelection+" list screen based on the selected "+categorySelection+" category");
				Assert.fail("Not Navigated to the "+categorySelection+" list screen based on the selected "+categorySelection+" category");
			}

			//Offers
			generalFunctions.isElementPresent(objExperiencesPage.firstOffer, 40);
			if(generalFunctions.isElementPresent(objExperiencesPage.firstOffer, 30))
			{
				test.log(Status.PASS, ""+categorySelection+ " Offers Displayed");
			}
			else
			{
				test.log(Status.FAIL, ""+categorySelection+ " Offers Not Displayed");
				Assert.fail(""+categorySelection+ " Offers Not Displayed");
			}

			generalFunctions.isElementPresent(objExperiencesPage.firstOfferTitle, 40);
			String OfferTitle =generalFunctions.getText(objExperiencesPage.firstOfferTitle);
			System.out.println(OfferTitle);


			if(generalFunctions.isElementPresent(objExperiencesPage.firstOfferActivate, 30))
			{
				test.log(Status.PASS, "Offer Activate Button Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Offer Activate Button Not Displayed");
				Assert.fail("Offer Activate Button Not Displayed");
			}

			String ActivateStatus =generalFunctions.getText(objExperiencesPage.firstOfferActivate);
			if(ActivateStatus.contains("OFF‎‏‎‎‏‎"))
			{
				System.out.println("Offer Not Activated");
				objExperiencesPage.firstOfferActivate.click();
				Thread.sleep(4000);

				objExperiencesPage.firstOfferTitle.click();
				Thread.sleep(5000);

				generalFunctions.isElementPresent(objExperiencesPage.DetailedOfferTitle, 30);
				if(generalFunctions.isElementPresent(objExperiencesPage.DetailedOfferTitle, 30))
				{
					test.log(Status.PASS, "ACTIVATED OFFERS details page Displayed");
				}
				else
				{
					test.log(Status.FAIL, "ACTIVATED OFFERS details page Not Displayed");
					Assert.fail("ACTIVATED OFFERS details page Not Displayed");
				}

				String ActivatedStatus =generalFunctions.getText(objExperiencesPage.DetailedOfferActivate);

				if(ActivatedStatus.contains("ON"))
				{
					test.log(Status.PASS, "OFFER ACTIVATED");
				}
				else
				{
					test.log(Status.FAIL, "OFFER Not ACTIVATED");
					Assert.fail("OFFER Not ACTIVATED");
				}
				objExperiencesPage.DetailedOfferActivate.click();

				Thread.sleep(4000);
				System.out.println(generalFunctions.getText(objExperiencesPage.DetailedOfferActivate));
				if(generalFunctions.getText(objExperiencesPage.DetailedOfferActivate).contains("OFF"))
				{
					test.log(Status.PASS, "OFFER Deactivated");
				}
				else
				{
					test.log(Status.FAIL, "OFFER Not Deactivated");
					Assert.fail("OFFER Not Deactivated");
				}

				objExperiencesPage.activatedOfferClose.click();

			}
			else
			{
				test.log(Status.FAIL, "Offer Already Activated");
				Assert.fail("Offer Already Activated");
			}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
}
	// V2 END



