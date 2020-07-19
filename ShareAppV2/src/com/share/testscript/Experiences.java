package com.share.testscript;


import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.share.functions.HomeFunctions;
import com.share.functions.RegistrationFunctions;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.HomePage;
import com.share.objectrepository.ProfilePage;
import com.share.objectrepository.ExperiencesPage;
import com.share.objectrepository.RegistrationPage;
import com.share.objectrepository.SignInPage;
import com.share.utility.Utilities;

import org.testng.Assert;

public class Experiences extends DriverSetUp
{
	GeneralFunctions generalFunctions = new GeneralFunctions();
	
	
	
	// V2 START
	
	
	@Test
	public void TC_01_01(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Experiences - Onboarding screens");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		
		String EmailAddress=map.get("TransactionUser").toString();
		String Password=map.get("TransactionUserPassword").toString();
		
		try
		{
		
		//Logout
		//generalFunctions.Logout();
		
		driver.resetApp();
		driver.activateApp("com.maf.sharesit");
		
		//Login to the App				
		generalFunctions.SignIn(EmailAddress, Password, signInPage);
		
		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(5000);
		
		//Verify OnBoarding displayed
		try
		{
			if(objExperiencesPage.OnBoarding.isDisplayed()==true)
			{
				test.log(Status.PASS, "OnBoarding Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "OnBoarding Not Displayed");
			Assert.fail("OnBoarding Not Displayed");
		}
		
		//Swipe left
		generalFunctions.swipeHorizontal(0.9,0.01,0.5);
		Thread.sleep(4000);
		
		try
		{
			if(objExperiencesPage.OnBoardingSkip.isDisplayed()==true)
			{
				test.log(Status.FAIL, "Failed to swipe through the Onboarding screens");
				Assert.fail("Failed to swipe through the Onboarding screens");
			}
		}
		catch(Exception x)
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
	
	
	@Test
	public void TC_01_02(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Experiences - Onboarding screens");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		
		String EmailAddress=map.get("TransactionUser").toString();
		String Password=map.get("TransactionUserPassword").toString();
		
		try
		{
		
		//Logout
		//generalFunctions.Logout();
		
		driver.resetApp();
		driver.activateApp("com.maf.sharesit");
		
		//Login to the App				
		generalFunctions.SignIn(EmailAddress, Password, signInPage);
		
		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(5000);
		
		//Verify OnBoarding displayed
		try
		{
			if(objExperiencesPage.OnBoarding.isDisplayed()==true)
			{
				test.log(Status.PASS, "OnBoarding Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "OnBoarding Not Displayed");
			Assert.fail("OnBoarding Not Displayed");
		}
		
		//Verify Continue button displayed
		try
		{
			if(objExperiencesPage.OnBoardingContinue.isDisplayed()==true)
			{
				test.log(Status.PASS, "Continue Button Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Continue Button Not Displayed");
			Assert.fail("Continue Button Not Displayed");
		}
		
		objExperiencesPage.OnBoardingContinue.click();
		Thread.sleep(4000);
		
		try
		{
			if(objExperiencesPage.OnBoardingSkip.isDisplayed()==true)
			{
				test.log(Status.FAIL, "Failed to Continue to the next Onboarding screen");
				Assert.fail("Failed to Continue to the next Onboarding screen");
			}
		}
		catch(Exception x)
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
	
	
	@Test
	public void TC_01_03(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Experiences - Onboarding screens");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		
		String EmailAddress=map.get("TransactionUser").toString();
		String Password=map.get("TransactionUserPassword").toString();
		
		try
		{
		
		//Logout
		//generalFunctions.Logout();
		
		driver.resetApp();
		driver.activateApp("com.maf.sharesit");
		
		//Login to the App				
		generalFunctions.SignIn(EmailAddress, Password, signInPage);
		
		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(5000);
		
		//Verify OnBoarding displayed
		try
		{
			if(objExperiencesPage.OnBoarding.isDisplayed()==true)
			{
				test.log(Status.PASS, "OnBoarding Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "OnBoarding Not Displayed");
			Assert.fail("OnBoarding Not Displayed");
		}
		
		//Verify Skip button displayed
		try
		{
			if(objExperiencesPage.OnBoardingSkip.isDisplayed()==true)
			{
				test.log(Status.PASS, "Skip Button Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Skip Button Not Displayed");
			Assert.fail("Skip Button Not Displayed");
		}
		
		objExperiencesPage.OnBoardingSkip.click();
		Thread.sleep(4000);
		
		try
		{
		if(objExperiencesPage.AllowAllTheTime.isDisplayed()==true)
		{
			System.out.println("Location Access Displayed");
			test.log(Status.PASS, "Location Access Displayed");
		}
		}
		catch(Exception e)
		{
			System.out.println("Location Access Not Displayed");
		}
		
		objExperiencesPage.AllowAllTheTime.click();
		
		generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 30);
		
		//Verify SHARE EXPERIENCES displayed
		try
		{
			if(objExperiencesPage.shareExperiences.isDisplayed()==true)
			{
				test.log(Status.PASS, "SHARE EXPERIENCES Displayed");
			}
		}
		catch(Exception x)
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
	
	
	@Test
	public void TC_02_01(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Experiences-Landing Page");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		
		String EmailAddress=map.get("TransactionUser").toString();
		String Password=map.get("TransactionUserPassword").toString();
		
		try
		{
			
		driver.activateApp("com.maf.sharesit");
						
		//Login to the App				
		generalFunctions.SignIn(EmailAddress, Password, signInPage);
		
		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(5000);
				
		//Verify SHARE EXPERIENCES displayed
		try
		{
			if(objExperiencesPage.shareExperiences.isDisplayed()==true)
			{
				test.log(Status.PASS, "SHARE EXPERIENCES Displayed");
			}
		}
		catch(Exception x)
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
	
	
	@Test
	public void TC_02_02(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Experiences-Landing Page");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		
		String EmailAddress=map.get("TransactionUser").toString();
		String Password=map.get("TransactionUserPassword").toString();
		
		try
		{
			
		driver.activateApp("com.maf.sharesit");	
		
		//Login to the App				
		generalFunctions.SignIn(EmailAddress, Password, signInPage);
		
		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		generalFunctions.ScrollDown("SEE ALL");
		
		//Click on SEE ALL
		objExperiencesPage.seeAll.click();
			
		generalFunctions.isElementPresent(objExperiencesPage.shareExperiences, 25);				
		//Verify SHARE EXPERIENCES displayed
		try
		{
			if(objExperiencesPage.shareExperiences.isDisplayed()==true)
			{
				test.log(Status.PASS, "SHARE EXPERIENCES Page Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "SHARE EXPERIENCES Page Not Displayed");
			Assert.fail("SHARE EXPERIENCES Page Not Displayed");
		}
					
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	
	@Test
	public void TC_02_03(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Experiences-Landing Page");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		
		String EmailAddress=map.get("TransactionUser").toString();
		String Password=map.get("TransactionUserPassword").toString();
		
		try
		{
			
		driver.activateApp("com.maf.sharesit");
			
		//Login to the App				
		generalFunctions.SignIn(EmailAddress, Password, signInPage);
		
		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(5000);
				
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
				
		//Categories
		try
		{
			if(objExperiencesPage.carrefourOffers.isDisplayed()==true)
			{
				test.log(Status.PASS, "carrefour Offers Category Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "carrefour Offers Category Not Displayed");
			Assert.fail("carrefour Offers Category Not Displayed");
		}
		
		try
		{
			if(objExperiencesPage.productDiscounts.isDisplayed()==true)
			{
				test.log(Status.PASS, "Product Discounts Category Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Product Discounts Category Not Displayed");
			Assert.fail("Product Discounts Category Not Displayed");
		}
		
		try
		{
			if(objExperiencesPage.contests.isDisplayed()==true)
			{
				test.log(Status.PASS, "Contests Category Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Contests Category Not Displayed");
			Assert.fail("Contests Category Not Displayed");
		}
		
		try
		{
			if(objExperiencesPage.redeemNEarn.isDisplayed()==true)
			{
				test.log(Status.PASS, "Redeem & Earn Category Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Redeem & Earn Category Not Displayed");
			Assert.fail("Redeem & Earn Category Not Displayed");
		}
		
		try
		{
			if(objExperiencesPage.charity.isDisplayed()==true)
			{
				test.log(Status.PASS, "Charity Category Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Charity Category Not Displayed");
			Assert.fail("Charity Category Not Displayed");
		}
		
		try
		{
			if(objExperiencesPage.shareBenefits.isDisplayed()==true)
			{
				test.log(Status.PASS, "Share Benefits Category Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Share Benefits Category Not Displayed");
			Assert.fail("Share Benefits Category Not Displayed");
		}
				
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	
	@Test
	public void TC_02_04(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Experiences-Landing Page");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		
		String EmailAddress=map.get("TransactionUser").toString();
		String Password=map.get("TransactionUserPassword").toString();
		String categorySelection="CARREFOUR OFFERS";
		
		try
		{
			
		driver.activateApp("com.maf.sharesit");
						
		//Login to the App				
		generalFunctions.SignIn(EmailAddress, Password, signInPage);
		
		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(5000);
				
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
				
		//Categories
		try
		{
			if(objExperiencesPage.carrefourOffers.isDisplayed()==true)
			{
				test.log(Status.PASS, "carrefour Offers Category Displayed");
			}
		}
		catch(Exception x)
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
		
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	
	@Test
	public void TC_02_05_To_10(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Experiences-Landing Page");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		
		String EmailAddress=map.get("TransactionUser").toString();
		String Password=map.get("TransactionUserPassword").toString();
		String categorySelection="CARREFOUR OFFERS";
		
		try
		{
			
		driver.activateApp("com.maf.sharesit");
											
		//Login to the App				
		generalFunctions.SignIn(EmailAddress, Password, signInPage);
		
		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(10000);
				
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
				
		//Categories
		try
		{
			if(objExperiencesPage.carrefourOffers.isDisplayed()==true)
			{
				test.log(Status.PASS, "carrefour Offers Category Displayed");
			}
		}
		catch(Exception x)
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
		generalFunctions.isElementPresent(objExperiencesPage.firstOffer, 40);
		try
		{
			if(objExperiencesPage.firstOffer.isDisplayed()==true)
			{
				test.log(Status.PASS, ""+categorySelection+ " Offers Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, ""+categorySelection+ " Offers Not Displayed");
			Assert.fail(""+categorySelection+ " Offers Not Displayed");
		}
		
		generalFunctions.isElementPresent(objExperiencesPage.firstOfferTitle, 40);
		String OfferTitle =generalFunctions.getText(objExperiencesPage.firstOfferTitle);
		
		objExperiencesPage.firstOfferTitle.click();
		Thread.sleep(5000);
		
		generalFunctions.isElementPresent(objExperiencesPage.DetailedOfferTitle, 30);
		
		try
		{
			if(objExperiencesPage.DetailedOfferTitle.isDisplayed()==true)
			{
				test.log(Status.PASS, "Offer Details Displayed");
			}
		}
		catch(Exception x)
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
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	
	@Test
	public void TC_02_19(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Experiences-Landing Page");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		
		String EmailAddress=map.get("TransactionUser").toString();
		String Password=map.get("TransactionUserPassword").toString();	
		
		try
		{
			
		driver.activateApp("com.maf.sharesit");
											
		//Login to the App				
		generalFunctions.SignIn(EmailAddress, Password, signInPage);
		
		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(10000);
				
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
		generalFunctions.isElementPresent(objExperiencesPage.offerTitle, 30);		
		try
		{
			if(objExperiencesPage.offerTitle.isDisplayed()==true)
			{
				test.log(Status.PASS, "Offer Title Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Offer Title Not Displayed");
			Assert.fail("Offer Title Not Displayed");
		}
		
		try
		{
			if(objExperiencesPage.offerImage.isDisplayed()==true)
			{
				test.log(Status.PASS, "Offer Image Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Offer Image Not Displayed");
			Assert.fail("Offer Image Not Displayed");
		}
		
		try
		{
			if(objExperiencesPage.offerStartDate.isDisplayed()==true)
			{
				test.log(Status.PASS, "Offer Start Date Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Offer Start Date Not Displayed");
			Assert.fail("Offer Start Date Not Displayed");
		}
		
		try
		{
			if(objExperiencesPage.offerEndDate.isDisplayed()==true)
			{
				test.log(Status.PASS, "Offer End Date Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Offer End Date Not Displayed");
			Assert.fail("Offer End Date Not Displayed");
		}
		
		try
		{
			if(objExperiencesPage.offerSponsorLogo.isDisplayed()==true)
			{
				test.log(Status.PASS, "Offer Sponsor Logo Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Offer Sponsor Logo Not Displayed");
			Assert.fail("Offer Sponsor Logo Not Displayed");
		}
		
		try
		{
			if(objExperiencesPage.offerShareButton.isDisplayed()==true)
			{
				test.log(Status.PASS, "Offer Share Button Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Offer Share Button Not Displayed");
			Assert.fail("Offer Share Button Not Displayed");
		}
		
		try
		{
			if(objExperiencesPage.offerActivateSwitch.isDisplayed()==true)
			{
				test.log(Status.PASS, "Offer Activate Button Displayed");
			}
		}
		catch(Exception x)
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
	
	
	@Test
	public void TC_02_20(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Experiences-Landing Page");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		
		String EmailAddress=map.get("TransactionUser").toString();
		String Password=map.get("TransactionUserPassword").toString();	
		
		try
		{
			
		driver.activateApp("com.maf.sharesit");
											
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
		generalFunctions.isElementPresent(objExperiencesPage.offerTitle, 30);		
		
		
		generalFunctions.SimplyScrollDown();
		
		generalFunctions.isElementPresent(objExperiencesPage.categoryIconBar, 30);	
				
		try
		{
			if(objExperiencesPage.categoryName.isDisplayed()==true)
			{
				
				test.log(Status.FAIL, "Offer Category icon with Name section Not Collapsed");
				Assert.fail("Offer Category icon with Name section Not Collapsed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.PASS, "Offer Category icon with Name section Collapsed");
		}
						
		try
		{
			if(objExperiencesPage.categoryIconBar.isDisplayed()==true)
			{
				test.log(Status.PASS, "Offer Category icon section Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Offer Category icon section Not Displayed");
			Assert.fail("Offer Category icon section Not Displayed");
		}
		
		int CategoryIcons=generalFunctions.elementCount(objExperiencesPage.categoryIcons);
		System.out.println("Icons "+CategoryIcons);
		
		if(CategoryIcons==6)
		{
			test.log(Status.PASS, "6 Offer Category icon section Displayed");
		}
		else
		{
			test.log(Status.FAIL, "6 Offer Category icon section Not Displayed");
			Assert.fail("6 Offer Category icon section Not Displayed");
		}
		
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	
	@Test
	public void TC_02_23(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Experiences-Landing Page");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		
		String EmailAddress=map.get("TransactionUser").toString();
		String Password=map.get("TransactionUserPassword").toString();
		
		try
		{
			
		driver.activateApp("com.maf.sharesit");
											
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
		generalFunctions.isElementPresent(objExperiencesPage.offerTitle, 80);		
		
		String OfferTitle=generalFunctions.getText(objExperiencesPage.offerTitle);
		
		try
		{
			if(objExperiencesPage.offerActivateSwitch.isDisplayed()==true)
			{
				test.log(Status.PASS, "Offer Activate Button Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Offer Activate Button Not Displayed");
			Assert.fail("Offer Activate Button Not Displayed");
		}
		
		generalFunctions.isElementPresent(objExperiencesPage.offerActivateSwitch, 60);	
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
			
			objExperiencesPage.activatedOffer.click();
			Thread.sleep(4000);
			
			try
			{
				if(objExperiencesPage.activatedOfferPage.isDisplayed()==true)
				{
					test.log(Status.PASS, "ACTIVATED OFFERS page Displayed");
				}
			}
			catch(Exception x)
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
			
			objExperiencesPage.ActivateSwitch.click();
			
			try
			{
				if(objExperiencesPage.checkOfferTitle(OfferTitle).isDisplayed()==true)
				{					
					test.log(Status.FAIL, "Deactiavted offer Not removed from Activated Offers page");
					Assert.fail("Deactiavted offer Not removed from Activated Offers page");
				}
			}
			catch(Exception x)
			{
				test.log(Status.PASS, "Deactiavted offer removed from Activated Offers page");
			}							
										
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	

	@Test
	public void TC_02_25(Method method) throws Exception
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
			
		driver.activateApp("com.maf.sharesit");
											
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
				
		objExperiencesPage.charity.click();
		
		try
		{
			generalFunctions.isElementPresent(objExperiencesPage.charityPage, 30);
			if(objExperiencesPage.charityPage.isDisplayed()==true)
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
	
	
	@Test
	public void TC_02_30(Method method) throws Exception
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
			
		driver.activateApp("com.maf.sharesit");
			
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
				
		try
		{
			generalFunctions.isElementPresent(objExperiencesPage.offer, 40);
			if(objExperiencesPage.offer.isDisplayed()==true)
			{
				test.log(Status.PASS, "Offer Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Offer Not Displayed");
			Assert.fail("Offer Not Displayed");
		}
								
		
		objExperiencesPage.offerShareButton.click();
		
		try
		{
			generalFunctions.isElementPresent(objExperiencesPage.shareOptions, 30);
			if(objExperiencesPage.shareOptions.isDisplayed()==true)
			{
				test.log(Status.PASS, "Share referral medium pop-up Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Share referral medium pop-up Not Displayed");
			Assert.fail("Share referral medium pop-up Not Displayed");
		}
										
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	
	@Test
	public void TC_02_31(Method method) throws Exception
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
		
		driver.activateApp("com.maf.sharesit");
			
		//Login to the App				
		generalFunctions.SignIn(EmailAddress, Password, signInPage);
		
		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(10000);
				
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
								
		
		generalFunctions.isElementPresent(objExperiencesPage.offerTitle, 40);
		String OfferTitle =generalFunctions.getText(objExperiencesPage.offerTitle);
		
		objExperiencesPage.offerTitle.click();
		Thread.sleep(5000);
		
		generalFunctions.isElementPresent(objExperiencesPage.DetailedOfferTitle, 30);
		
		try
		{
			if(objExperiencesPage.DetailedOfferTitle.isDisplayed()==true)
			{
				test.log(Status.PASS, "Offer Details Displayed");
			}
		}
		catch(Exception x)
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
		
		try
		{
			generalFunctions.isElementPresent(objExperiencesPage.detailedOfferShareIcon, 40);
			if(objExperiencesPage.detailedOfferShareIcon.isDisplayed()==true)
			{
				test.log(Status.PASS, "Share Icon Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Share Icon Not Displayed");
			Assert.fail("Share Icon Not Displayed");
		}
								
		
		objExperiencesPage.detailedOfferShareIcon.click();
		
		try
		{
			generalFunctions.isElementPresent(objExperiencesPage.shareOptions, 30);
			if(objExperiencesPage.shareOptions.isDisplayed()==true)
			{
				test.log(Status.PASS, "Share referral medium pop-up Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Share referral medium pop-up Not Displayed");
			Assert.fail("Share referral medium pop-up Not Displayed");
		}
												
		
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	
	@Test
	public void TC_03_01_02_03(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Filters and filtered view (Offer)");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		
		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();
				
		try
		{
			
		driver.activateApp("com.maf.sharesit");
			
		//Login to the App				
		generalFunctions.SignIn(EmailAddress, Password, signInPage);
		
		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(10000);
				
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
				
		try
		{
			if(objExperiencesPage.locationDubai.isDisplayed()&&objExperiencesPage.locationAbuDhabi.isDisplayed()&&objExperiencesPage.locationAjman.isDisplayed()
			&&objExperiencesPage.locationRasAlKhaimah.isDisplayed()&&objExperiencesPage.locationSharjah.isDisplayed()&&objExperiencesPage.locationUmmAlQuwain.isDisplayed()	)
			{
				test.log(Status.PASS, "User is Not able to see all the Emirates Location");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "User is Not able to see all the Emirates Location");
			Assert.fail("User is Not able to see all the Emirates Location");
		}
		
		try
		{
			generalFunctions.isElementPresent(objExperiencesPage.nearby, 30);
			if(objExperiencesPage.nearby.isDisplayed()==true)
			{
				test.log(Status.PASS, "Nearby option Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Nearby option Not Displayed");
			Assert.fail("Nearby option Not Displayed");
		}
		
		try
		{
			if(objExperiencesPage.clearAll.isDisplayed()==true)
			{
				test.log(Status.PASS, "Clear All Button Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Clear All Button Not Displayed");
			Assert.fail("Clear All Button Not Displayed");
		}
		
		try
		{
			if(objExperiencesPage.showExperiences.isDisplayed()==true)
			{
				test.log(Status.PASS, "Show Experiences Button Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Show Experiences Button Not Displayed");
			Assert.fail("Show Experiences Button Not Displayed");
		}
						
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	
	@Test
	public void TC_03_05(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Filters and filtered view (Offer)");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		
		String EmailAddress=map.get("TransactionUser").toString();
		String Password=map.get("TransactionUserPassword").toString();
				
		try
		{
			
		driver.activateApp("com.maf.sharesit");
											
		//Login to the App				
		generalFunctions.SignIn(EmailAddress, Password, signInPage);
		
		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(10000);
				
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
				
		try
		{
			if(objExperiencesPage.locationDubai.isDisplayed()==true)
			{
				test.log(Status.PASS, "User is Not able to see all the Emirates Location");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "User is Not able to see all the Emirates Location");
			Assert.fail("User is Not able to see all the Emirates Location");
		}
		
		try
		{
			if(objExperiencesPage.clearAll.isDisplayed()==true)
			{
				test.log(Status.PASS, "Clear All Button Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Clear All Button Not Displayed");
			Assert.fail("Clear All Button Not Displayed");
		}
		
		try
		{
			if(objExperiencesPage.clearAll.isEnabled()==false)
			{
				test.log(Status.PASS, "Clear All Button is Disabled by Default");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Clear All Button is Not Disabled by Default");
			Assert.fail("Clear All Button is Not Disabled by Default");
		}
				
		objExperiencesPage.locationDubai.click();
		Thread.sleep(4000);
		
		try
		{
			if(objExperiencesPage.clearAll.isEnabled()==true)
			{
				test.log(Status.PASS, "Clear All Button is Enabled when user selects a filter option");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Clear All Button is Not Enabled even after user selects a filter option");
			Assert.fail("Clear All Button is Not Enabled even after user selects a filter option");
		}
		
		objExperiencesPage.clearAll.click();
		Thread.sleep(4000);
		
		try
		{
			if(objExperiencesPage.locationDubai.isEnabled()==false)
			{
				test.log(Status.PASS, "Selected filter is cleared");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Selected filter is Not cleared");
			Assert.fail("Selected filter is Not cleared");
		}		
						
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	
	@Test
	public void TC_03_10(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Filters and filtered view (Offer)");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		
		String EmailAddress=map.get("TransactionUser").toString();
		String Password=map.get("TransactionUserPassword").toString();
				
		try
		{
			
		driver.activateApp("com.maf.sharesit");
			
		//Login to the App				
		generalFunctions.SignIn(EmailAddress, Password, signInPage);
		
		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(10000);
				
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
				
		try
		{
			if(objExperiencesPage.offerType.isDisplayed()==true)
			{
				test.log(Status.PASS, "Offer Type Filter Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Offer Type Filter Not Displayed");
			Assert.fail("Offer Type Filter Not Displayed");
		}
		
		try
		{
			if(objExperiencesPage.earnOnly.isDisplayed()==true)
			{
				test.log(Status.PASS, "Earn Only Option Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Earn Only Option Not Displayed");
			Assert.fail("Earn Only Option Not Displayed");
		}			
				
		objExperiencesPage.earnOnly.click();
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
	}
	
	
	@Test
	public void TC_03_12(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Filters and filtered view (Offer)");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		
		String EmailAddress=map.get("TransactionUser").toString();
		String Password=map.get("TransactionUserPassword").toString();
				
		try
		{
			
		driver.activateApp("com.maf.sharesit");
			
		//Login to the App				
		generalFunctions.SignIn(EmailAddress, Password, signInPage);
		
		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(10000);
				
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
				
		try
		{
			if(objExperiencesPage.availability.isDisplayed()==true)
			{
				test.log(Status.PASS, "Availability Type Filter Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Availability Type Filter Not Displayed");
			Assert.fail("Availability Type Filter Not Displayed");
		}
		
		try
		{
			if(objExperiencesPage.online.isDisplayed()==true)
			{
				test.log(Status.PASS, "Online Availability Filter Option Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Online Availability Filter Option Not Displayed");
			Assert.fail("Online Availability Filter Option Not Displayed");
		}			
				
		objExperiencesPage.online.click();
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
	}
	
	
	@Test
	public void TC_03_13(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Filters and filtered view (Offer)");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		
		String EmailAddress=map.get("TransactionUser").toString();
		String Password=map.get("TransactionUserPassword").toString();
				
		try
		{
			
		driver.activateApp("com.maf.sharesit");
											
		//Login to the App				
		generalFunctions.SignIn(EmailAddress, Password, signInPage);
		
		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(10000);
				
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
				
		try
		{
			if(objExperiencesPage.expiry.isDisplayed()==true)
			{
				test.log(Status.PASS, "Expiry Filter Displayed");
			}
		}
		catch(Exception x)
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
	}
	
	
	@Test
	public void TC_04_01_02(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Offer Details screen");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		
		String EmailAddress=map.get("TransactionUser").toString();
		String Password=map.get("TransactionUserPassword").toString();
		
		try
		{
			
		driver.activateApp("com.maf.sharesit");
											
		//Login to the App				
		generalFunctions.SignIn(EmailAddress, Password, signInPage);
		
		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(10000);
				
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
				
		generalFunctions.isElementPresent(objExperiencesPage.offer, 30);		
		try
		{
			if(objExperiencesPage.offer.isDisplayed()==true)
			{
				test.log(Status.PASS, "Offer Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Offer Not Displayed");
			Assert.fail("Offer Not Displayed");
		}
		
		String OfferTitle =generalFunctions.getText(objExperiencesPage.offerTitle);
		System.out.println(OfferTitle);
		objExperiencesPage.offerTitle.click();
				
		generalFunctions.isElementPresent(objExperiencesPage.DetailedOfferTitle, 30);
		
		try
		{
			if(objExperiencesPage.DetailedOfferTitle.isDisplayed()==true)
			{
				test.log(Status.PASS, "Offer Details Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Offer Details Not Displayed");
			Assert.fail("Offer Details Not Displayed");
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
		
		try
		{
			if(objExperiencesPage.DetailedOfferImage.isDisplayed()==true)
			{
				test.log(Status.PASS, "Offer Image Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Offer Image Not Displayed");
			Assert.fail("Offer Image Not Displayed");
		}
		
		try
		{
			if(objExperiencesPage.DetailedOfferStartDate.isDisplayed()==true)
			{
				test.log(Status.PASS, "Offer Start Date Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Offer Start Date Not Displayed");
			Assert.fail("Offer Start Date Not Displayed");
		}
		
		try
		{
			if(objExperiencesPage.DetailedOfferEndDate.isDisplayed()==true)
			{
				test.log(Status.PASS, "Offer End Date Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Offer End Date Not Displayed");
			Assert.fail("Offer End Date Not Displayed");
		}
		
		try
		{
			if(objExperiencesPage.DetailedOfferLogo.isDisplayed()==true)
			{
				test.log(Status.PASS, "Offer Sponsor Logo Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Offer Sponsor Logo Not Displayed");
			Assert.fail("Offer Sponsor Logo Not Displayed");
		}
		
		try
		{
			if(objExperiencesPage.detailedOfferShareIcon.isDisplayed()==true)
			{
				test.log(Status.PASS, "Offer Share Button Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Offer Share Button Not Displayed");
			Assert.fail("Offer Share Button Not Displayed");
		}
		
		try
		{
			if(objExperiencesPage.DetailedOfferActivate.isDisplayed()==true)
			{
				test.log(Status.PASS, "Offer Activate Button Displayed");
			}
		}
		catch(Exception x)
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
	
	
	@Test
	public void TC_05_01_To_05(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Search Functionality");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		
		String EmailAddress=map.get("TransactionUser").toString();
		String Password=map.get("TransactionUserPassword").toString();
		
		String searchKeyWord="dubai";
		String searchKeyWord2="offer";
		String searchKeyWord3="discount";
		
		try
		{
			
		driver.activateApp("com.maf.sharesit");
											
		//Login to the App				
		generalFunctions.SignIn(EmailAddress, Password, signInPage);
		
		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(10000);
				
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
				
		generalFunctions.isElementPresent(objExperiencesPage.searchIcon, 30);
		
		objExperiencesPage.searchIcon.click();
		
		try
		{
			generalFunctions.isElementPresent(objExperiencesPage.searchPage, 30);
			if(objExperiencesPage.searchPage.isDisplayed()==true)
			{
				test.log(Status.PASS, "Search page Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Search page Not Displayed");
			Assert.fail("Search page Not Displayed");
		}
		
		try
		{
			if(objExperiencesPage.searchField.isDisplayed()==true)
			{
				test.log(Status.PASS, "Search field Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Search field Not Displayed");
			Assert.fail("Search field Not Displayed");
		}
		
		objExperiencesPage.searchField.click();
		objExperiencesPage.searchField.sendKeys(searchKeyWord);
		
		generalFunctions.pressSearch();
		Thread.sleep(4000);
		
		try
		{
			generalFunctions.isElementPresent(objExperiencesPage.searchResult, 30);
			if(objExperiencesPage.searchResult.isDisplayed()==true)
			{
				test.log(Status.PASS, "Search Result Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Search Result Not Displayed");
			Assert.fail("Search Result Not Displayed");
		}
		
		objExperiencesPage.searchClear.click();
		
		try
		{
			generalFunctions.isElementPresent(objExperiencesPage.recentSearchItem, 20);
			if(objExperiencesPage.recentSearchItem.isDisplayed()==true)
			{
				test.log(Status.PASS, "Recent Search Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Recent Search Not Displayed");
			Assert.fail("Recent Search Not Displayed");
		}				
						
		objExperiencesPage.searchField.click();
		objExperiencesPage.searchField.sendKeys(searchKeyWord2);
		
		generalFunctions.pressSearch();
		Thread.sleep(4000);
		
		try
		{
			generalFunctions.isElementPresent(objExperiencesPage.searchResult, 30);
			if(objExperiencesPage.searchResult.isDisplayed()==true)
			{
				test.log(Status.PASS, "Search Result Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Search Result Not Displayed");
			Assert.fail("Search Result Not Displayed");
		}
		
		objExperiencesPage.searchClear.click();
		
		objExperiencesPage.searchField.click();
		objExperiencesPage.searchField.sendKeys(searchKeyWord3);
		
		generalFunctions.pressSearch();
		Thread.sleep(4000);
		
		try
		{
			generalFunctions.isElementPresent(objExperiencesPage.searchResult, 30);
			if(objExperiencesPage.searchResult.isDisplayed()==true)
			{
				test.log(Status.PASS, "Search Result Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Search Result Not Displayed");
			Assert.fail("Search Result Not Displayed");
		}
		
		objExperiencesPage.searchClear.click();
		
		try
		{
		if(objExperiencesPage.recentSearches(searchKeyWord).isDisplayed()&&objExperiencesPage.recentSearches(searchKeyWord2).isDisplayed()
				&&objExperiencesPage.recentSearches(searchKeyWord3).isDisplayed())
		{
			test.log(Status.PASS, "Recent 3 Search keywords Displayed");
		}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Recent 3 Search keywords Not Displayed");
			Assert.fail("Recent 3 Search keywords Not Displayed");
		}
		
		
		objExperiencesPage.clearButton.click();
		Thread.sleep(4000);
		
		try
		{
		if(objExperiencesPage.recentSearches(searchKeyWord).isDisplayed()&&objExperiencesPage.recentSearches(searchKeyWord2).isDisplayed()
				&&objExperiencesPage.recentSearches(searchKeyWord3).isDisplayed())
		{
			test.log(Status.FAIL, "Recent Search keywords Not Cleared");
			Assert.fail("Recent Search keywords Not Cleared");
		}
		}
		catch(Exception x)
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
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	
	@Test
	public void TC_05_06(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Search Functionality");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		
		String EmailAddress=map.get("TransactionUser").toString();
		String Password=map.get("TransactionUserPassword").toString();
		String searchKeyWord="@#&*";

		
		try
		{
			
		driver.activateApp("com.maf.sharesit");
		
		//Login to the App				
		generalFunctions.SignIn(EmailAddress, Password, signInPage);
		
		// Click Experiences
		generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
		objExperiencesPage.Experiences.click();
		Thread.sleep(10000);
				
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
				
		generalFunctions.isElementPresent(objExperiencesPage.searchIcon, 30);
		
		objExperiencesPage.searchIcon.click();
		
		try
		{
			generalFunctions.isElementPresent(objExperiencesPage.searchPage, 30);
			if(objExperiencesPage.searchPage.isDisplayed()==true)
			{
				test.log(Status.PASS, "Search page Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Search page Not Displayed");
			Assert.fail("Search page Not Displayed");
		}
		
		try
		{
			if(objExperiencesPage.searchField.isDisplayed()==true)
			{
				test.log(Status.PASS, "Search field Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Search field Not Displayed");
			Assert.fail("Search field Not Displayed");
		}
		
		objExperiencesPage.searchField.click();
		objExperiencesPage.searchField.sendKeys(searchKeyWord);
		Thread.sleep(2000);
		
		if(generalFunctions.getText(objExperiencesPage.searchField).contains(searchKeyWord))
		{
			test.log(Status.FAIL, "Special Characters are allowing in Search field");
			Assert.fail("Special Characters are allowing in Search field");
		}
		else
		{
			test.log(Status.PASS, "Special Characters are Not allowing in Search field");
		}
		
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
		
	
	@Test
	public void TC_06_01_To_05(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Activated offers section");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		
		String EmailAddress=map.get("TransactionUser").toString();
		String Password=map.get("TransactionUserPassword").toString();

		
		try
		{
			
			driver.activateApp("com.maf.sharesit");
											
			//Login to the App				
			generalFunctions.SignIn(EmailAddress, Password, signInPage);
			
			// Click Experiences
			generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
			objExperiencesPage.Experiences.click();
			Thread.sleep(10000);
					
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
					
			generalFunctions.isElementPresent(objExperiencesPage.offer, 30);		
			try
			{
				if(objExperiencesPage.offer.isDisplayed()==true)
				{
					test.log(Status.PASS, "Offer Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Offer Not Displayed");
				Assert.fail("Offer Not Displayed");
			}
			
			String OfferTitle =generalFunctions.getText(objExperiencesPage.offerTitle);
			System.out.println(OfferTitle);

			try
			{
				if(objExperiencesPage.offerActivateSwitch.isDisplayed()==true)
				{
					test.log(Status.PASS, "Offer Activate Button Displayed");
				}
			}
			catch(Exception x)
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
				
				try
				{
					if(objExperiencesPage.activatedOffer.isDisplayed()==true)
					{
						test.log(Status.PASS, "You have Activated Offers- message is displayed in the experience landing page");
						objExperiencesPage.activatedOffer.click();
						Thread.sleep(4000);
					}
				}
				catch(Exception x)
				{
					test.log(Status.FAIL, "You have Activated Offers- message is Not displayed in the experience landing page");
					Assert.fail("You have Activated Offers- message is Not displayed in the experience landing page");
				}				
				
				try
				{
					if(objExperiencesPage.activatedOfferPage.isDisplayed()==true)
					{
						test.log(Status.PASS, "ACTIVATED OFFERS page Displayed");
					}
				}
				catch(Exception x)
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
				
				try
				{
					if(objExperiencesPage.DetailedOfferTitle.isDisplayed()==true)
					{
						test.log(Status.PASS, "ACTIVATED OFFERS details page Displayed");
					}
				}
				catch(Exception x)
				{
					test.log(Status.FAIL, "ACTIVATED OFFERS details page Not Displayed");
					Assert.fail("ACTIVATED OFFERS details page Not Displayed");
				}
				
				objExperiencesPage.activatedOfferClose.click();
				Thread.sleep(4000);
				
				generalFunctions.isElementPresent(objExperiencesPage.ActivateSwitch, 20);
				objExperiencesPage.ActivateSwitch.click();
				
				try
				{
					if(objExperiencesPage.checkOfferTitle(OfferTitle).isDisplayed()==true)
					{					
						test.log(Status.FAIL, "Deactiavted offer Not removed from Activated Offers page");
						Assert.fail("Deactiavted offer Not removed from Activated Offers page");
					}
				}
				catch(Exception x)
				{
					test.log(Status.PASS, "Deactiavted offer removed from Activated Offers page");
				}
				
							
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	
	@Test
	public void TC_06_06_To_08(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Activated offers section");
		test.assignCategory("Experiences");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);
		
		String EmailAddress=map.get("TransactionUser").toString();
		String Password=map.get("TransactionUserPassword").toString();
		String categorySelection="CARREFOUR OFFERS";
		
		try
		{
			
		driver.activateApp("com.maf.sharesit");
			
			//Login to the App				
			generalFunctions.SignIn(EmailAddress, Password, signInPage);
			
			// Click Experiences
			generalFunctions.isElementPresent(objExperiencesPage.Experiences, 90);
			objExperiencesPage.Experiences.click();
			Thread.sleep(10000);
					
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
			try
			{
				if(objExperiencesPage.firstOffer.isDisplayed()==true)
				{
					test.log(Status.PASS, ""+categorySelection+ " Offers Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, ""+categorySelection+ " Offers Not Displayed");
				Assert.fail(""+categorySelection+ " Offers Not Displayed");
			}
			
			generalFunctions.isElementPresent(objExperiencesPage.firstOfferTitle, 40);
			String OfferTitle =generalFunctions.getText(objExperiencesPage.firstOfferTitle);
			System.out.println(OfferTitle);

			try
			{
				if(objExperiencesPage.firstOfferActivate.isDisplayed()==true)
				{
					test.log(Status.PASS, "Offer Activate Button Displayed");
				}
			}
			catch(Exception x)
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
				
				try
				{
					if(objExperiencesPage.DetailedOfferTitle.isDisplayed()==true)
					{
						test.log(Status.PASS, "ACTIVATED OFFERS details page Displayed");
					}
				}
				catch(Exception x)
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
	
	
	
	// V2 END
	
	
	
	
}

	
	