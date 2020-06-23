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
import com.share.objectrepository.OffersPage;
import com.share.objectrepository.RegistrationPage;
import com.share.objectrepository.SignInPage;
import com.share.utility.Utilities;

import org.testng.Assert;

public class Offers extends DriverSetUp
{
	GeneralFunctions generalFunctions = new GeneralFunctions();
	
	//Clear all activated offers
	
	@Test
	public void TC_Offers_001(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Offers");
		test.info("Offers - Activated");
		test.assignCategory("Offers");
		System.out.println("Running Test"+" "+ TC_Method);
		
		String EmailAddress=map.get("Offers_UserEmail").toString();
		String Pass=map.get("Offers_UserPassword").toString();
					
		RegistrationPage registrationPage= new RegistrationPage(driver);
		OffersPage objOfferPage= new OffersPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions genFunctions = new GeneralFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{
			driver.resetApp();
			Thread.sleep(2000);	
		
		//LOGIN
		registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);
				
		//Click on Offers Icon
		objOfferPage.offers.click();
		Thread.sleep(5000);
	try
	{
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
								
		//Verify the saved tab in SHARE App is empty if no offers are saved
		String Title = genFunctions.getText(objOfferPage.Title);
		System.out.println("Title "+ Title);
		if(Title.contains("Offers"))
		{
			test.log(Status.PASS, "Offers Title Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Offers Title Not Displayed");
			Assert.fail("Offers Title Not Displayed");
		}
		
		//Click on Activated Tab
		objOfferPage.ActivatedTab.click();
		Thread.sleep(10000);
		
		//Verify No Offers displayed
		try
		{
			if(objOfferPage.NoOffers.isDisplayed()==true)
			{
				
				test.log(Status.PASS, "No Offers Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Offers Displayed");
			Assert.fail("Offers Displayed");
		}
		
		genFunctions.Logout();
		Thread.sleep(10000);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	
	//one activated 
	@Test
	public void TC_Offers_002(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Offers");
		test.info("Offers - Activated");
		test.assignCategory("Offers");
		System.out.println("Running Test"+" "+ TC_Method);
		
			
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("Password").toString();
					
		RegistrationPage registrationPage= new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		OffersPage objOfferPage= new OffersPage(driver);
		GeneralFunctions genFunctions = new GeneralFunctions();
		SignInPage signInPage = new SignInPage(driver);
		
		try
		{
		driver.resetApp();
		Thread.sleep(2000);	
		
		//LOGIN
		registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);
		
		//Click on Offers Icon
		objOfferPage.offers.click();
		Thread.sleep(6000);
		
		try
		{
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
		
		//Verify the saved tab in SHARE App is empty if no offers are saved
		String Title = genFunctions.getText(objOfferPage.Title);
		System.out.println("Title "+ Title);
		if(Title.contains("Offers"))
		{
			test.log(Status.PASS, "Offers Title Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Offers Title Not Displayed");
			Assert.fail("Offers Title Not Displayed");
		}
		
		generalFunctions.isElementPresent(objOfferPage.activated, 60);
		objOfferPage.activated.click();
		Thread.sleep(5000);
		
		//Click on Activated Tab
		objOfferPage.ActivatedTab.click();
		Thread.sleep(10000);
				
		
		//Verify Offers Displayed
		try
		{
			if(objOfferPage.ActivatedOffers.isDisplayed()==true)
			{
						
				test.info("Navigated to Offers Actiaved Tab");
				test.log(Status.PASS, "Activated Offers is Present in Activated Tab");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Activated Offers is Not present in Activated Tab");
			Assert.fail("Activated Offers is Not Present in Activated Tab");
		}
		Thread.sleep(5000);
		
		//Dependency for next scripts
		objOfferPage.untick_offer.click();
		
		
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	
	@Test
	public void TC_Offers_003(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Offers");
		test.info("Offer details displayed in Details page");
		test.assignCategory("Offers");
		System.out.println("Running Test"+" "+ TC_Method);
		
		//driver.activateApp("com.maf.sharesit");
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("Password").toString();
					
		RegistrationPage registrationPage= new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions genFunctions = new GeneralFunctions();
		OffersPage objOfferPage= new OffersPage(driver);
		SignInPage signInPage = new SignInPage(driver);
		try
		{
			driver.resetApp();
			Thread.sleep(2000);	
		
		//LOGIN
		registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);
		
		//Click on Offers Icon
		objOfferPage.offers.click();
		Thread.sleep(5000);
		
		try
		{
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
		
		//Click on any offer
		generalFunctions.isElementPresent(objOfferPage.offers_title_des, 60);
		objOfferPage.offers_title_des.click();
		Thread.sleep(7000);
		
		//Image displayed or not
		try
		{
			if(objOfferPage.offers_image.isDisplayed()==true)
			{
				
				test.log(Status.PASS, "Image Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Image Not Displayed");
			Assert.fail("Image Not Displayed");
		}		
		
		//Verify Title Displayed
		String title = genFunctions.getText(objOfferPage.offers_title1);
		System.out.println("Title "+ title);
		if(title!="")
		{
			test.log(Status.PASS, "Title Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Title Not Displayed");
			Assert.fail("Title Not Displayed");
			
		}
		
		boolean dayscaal=false;
		//Verify days remaining Displayed
		try 
		{
			String days_remaining = genFunctions.getText(objOfferPage.days_remaining);
			System.out.println("Days: "+days_remaining );
			if(days_remaining.contains("days remaining"))
			{
				dayscaal=true;
				test.log(Status.PASS, "days remaining Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.WARNING, "days remaining Not Displayed");
		}
								
		//Verify Expiry Date Displayed		
		try
		{
			String days_text = genFunctions.getText(objOfferPage.expiry_date);
			System.out.println("Dates: "+ days_text);
			if(days_text.contains("START"))
			{
				test.log(Status.PASS, "START and END Dates Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.WARNING, "START and END Dates Not Displayed");
		}
			
		try
		{
			
		String Start = genFunctions.getText(objOfferPage.expiry_date);
	    String[] sp1 = Start.split(" ");	 
	   // System.out.println("First date is " + sp1[1]);
	    String date1= sp1[1];
	    System.out.println("New First date is " + date1);
	   
	    
	    String Ends = genFunctions.getText(objOfferPage.expiry_date);
	    String[] sp2 = Ends.split(" ");	 
	   // System.out.println("second date is " + sp2[4]);
	    String date2= sp2[4];
	    System.out.println("New second date is " + date2);
	    
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
	    LocalDateTime now = LocalDateTime.now();  
	    String date =dtf.format(now);
	    System.out.println("date today: "+ date);	    
	    
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");        
        Date datefor = formatter.parse(date);
        System.out.println("Formated date today "+formatter.format(datefor));
        String sDate=formatter.format(datefor);
         
        Date Expdate = formatter.parse(date2);     
        System.out.println("Formated Exp date "+formatter.format(Expdate)); 
        String xDate=formatter.format(Expdate);
            	
        Date dateBefore = formatter.parse(sDate);
	    Date dateAfter = formatter.parse(xDate);
	    long difference = dateAfter.getTime() - dateBefore.getTime();
	    float daysBetween = (difference / (1000*60*60*24));
	    System.out.println("Number of Days between dates: "+daysBetween);
    		
	    String numofDays=String.valueOf(daysBetween);
	    String   strnumofDays = numofDays.replace( '.', ' ' );
	    String   strnumofDays1 = strnumofDays.replace( '0', ' ' ).trim();
	    System.out.println("Number of Days :"+strnumofDays1);
	    String days_remaining = genFunctions.getText(objOfferPage.days_remaining);
	    if(dayscaal==true)
	    {
	    	if(days_remaining.contains(strnumofDays1+" days remaining!"))
		    {
		    	test.log(Status.PASS, "days remaining calculated correctly");
		    }
		    else
		    {
		    	test.log(Status.FAIL, "days remaining calculated incorrectly");
		    }
	    }
	    
		}
		catch(Exception x)
		{
			
		}		
	    
	    //Verify description Displayed		
		String desc = genFunctions.getText(objOfferPage.offers_des);
		System.out.println("Description " + desc);
		if(desc!="")
		{
			test.log(Status.PASS, "Description Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Description Not Displayed");
			Assert.fail("Description Not Displayed");
		}
		
		//Verify option to share Displayed
		String share = genFunctions.getText(objOfferPage.offers_share);
		System.out.println("Share "+ share);
		if(share!="")
		{
			test.log(Status.PASS, "Option to share Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Option to share Not Displayed");
			Assert.fail("Option to share Not Displayed");
		}
		
		//Verify save icon Displayed
		try
		{
			if(objOfferPage.offers_like_save.isDisplayed()==true)
			{
				test.log(Status.PASS, "Save icon Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Save icon Not Displayed");
			Assert.fail("Saved icon not Displayed");
		}
					
		//Verify offer location Displayed
		try
		{
			if(objOfferPage.offers_location.isDisplayed()==true)
			{
				test.log(Status.PASS, "Location Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Location Not Displayed");
			Assert.fail("Location not displayed");
		}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	
	
	@Test
	public void TC_Offers_004(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Offers");
		test.info("Verify that the user is able to save an offer");
		test.assignCategory("Offers");
		System.out.println("Running Test"+" "+ TC_Method);
				
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("Password").toString();
					
		RegistrationPage registrationPage= new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		OffersPage objOfferPage= new OffersPage(driver);
		GeneralFunctions genFunctions = new GeneralFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{
			driver.resetApp();
			Thread.sleep(2000);	
			
		//LOGIN
		registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);
		Thread.sleep(2000);	
	
		//Click on Offers Icon
		objOfferPage.offers.click();
		Thread.sleep(5000);
		
		try
		{
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
		
		//Verify offers page displayed
		String Title = genFunctions.getText(objOfferPage.Title);
		System.out.println("Title "+ Title);
		if(Title.contains("Offers"))
		{
			test.log(Status.PASS, "Offers Title Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Offers Title Not Displayed");
			Assert.fail("Offers Title Not Displayed");
		}
		Thread.sleep(10000);
		
		//Select Scroll to Unsaved Offer and click Activate	
		genFunctions.MoveToElement(objOfferPage.UnActivatedOfferXpath);
		//if(genFunctions.MoveToElement(objOfferPage.UnActivatedOfferXpath)==false)
		//{
			//test.log(Status.PASS, "Offers Saved Successfully");
		//}
		//else
		//{
			//test.log(Status.FAIL, "Failed to Save the Offer");
			//Assert.fail("Failed to Save the Offer");
		//}
		
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
		
	@Test
	public void TC_Offers_005(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Offers");
		test.info("Share offers from  offers details screen");
		test.assignCategory("Offers");
		System.out.println("Running Test"+" "+ TC_Method);
		
			
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("Password").toString();
		
		//driver.activateApp("com.maf.sharesit");			
		RegistrationPage registrationPage= new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		OffersPage objOfferPage= new OffersPage(driver);
		GeneralFunctions genFunctions = new GeneralFunctions();
		SignInPage signInPage = new SignInPage(driver);
		try
		{
			driver.resetApp();
			Thread.sleep(2000);	
		
		//LOGIN
		registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);
				
		//Click on Offers Icon
		objOfferPage.offers.click();
		Thread.sleep(5000);	
		
		try
		{
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
		
		//Verify offers page displayed
		String Title = genFunctions.getText(objOfferPage.Title);
		System.out.println("Title "+ Title);
		if(Title.contains("Offers"))
		{
			test.log(Status.PASS, "Offers Title Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Offers Title Not Displayed");
			Assert.fail("Offers Title Not Displayed");
		}
		Thread.sleep(10000);
		
		generalFunctions.isElementPresent(objOfferPage.offers_click, 60);
		objOfferPage.offers_click.click();
		Thread.sleep(10000);
		
		//Verify Offer share icon displayed
		try
		{
			if(objOfferPage.offers_share1.isDisplayed()==true)
			{
				//objOfferPage.offers_share1.click();
				test.log(Status.PASS, "Offer Share icon Displayed");
			}
		}
		catch(Exception x) 
		{
			test.log(Status.FAIL, "Offer Share icon Not Displayed");
			Assert.fail("Offer Share icon Not Displayed");
		}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	
	@Test
	public void TC_Offers_006(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Offers");
		test.info("Share the offers from  offers listing screen");
		test.assignCategory("Offers");	
		System.out.println("Running Test"+" "+ TC_Method);
		
		//driver.activateApp("com.maf.sharesit");
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("Password").toString();
		
					
		RegistrationPage registrationPage= new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		OffersPage objOfferPage= new OffersPage(driver);
		SignInPage signInPage = new SignInPage(driver);
		try
		{
			driver.resetApp();
			Thread.sleep(2000);	
			
		//LOGIN
		registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

		//Click on Offers Icon
		objOfferPage.offers.click();
		Thread.sleep(20000);
		
		try
		{
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
							
		//Verify share icon displayed
		try
		{
			if(objOfferPage.share_list.isDisplayed()==true)
			{
				
				test.log(Status.PASS, "share icon Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Share icon Not Displayed");
			Assert.fail("Share icon not displayed");
		}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC_Offers_007(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Offers");
		test.info("1.Verify Offers have Offers Listings");
		test.info("2.Activate Offer and Deactivate Offer From Offers Detail Page");
		test.assignCategory("Offers");	
		System.out.println("Running Test"+" "+ TC_Method);
		
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("Password").toString();
					
		RegistrationPage registrationPage= new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		OffersPage objOfferPage= new OffersPage(driver);
		SignInPage signInPage = new SignInPage(driver);
		
		try
		{
			
			driver.resetApp();
			Thread.sleep(2000);	
		
		//LOGIN
		registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

		//Click on Offers Icon
		objOfferPage.offers.click();
		Thread.sleep(10000);
		
		try
		{
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
							
		//Verify share icon displayed
		generalFunctions.isElementPresent(objOfferPage.share_list, 60);
			if(objOfferPage.share_list.isDisplayed()==true)
			{
			test.log(Status.PASS, "Share Offer Icon is Present in Offer Listings");
			}
			else
			{
			test.log(Status.FAIL, "Share Offer Icon is Not Present in Offer Listings");
			Assert.fail("Share Offer Icon is Not Present in Offer Listings");
			}
			Thread.sleep(9000);
		
			generalFunctions.isElementPresent(objOfferPage.activated, 60);
			if(objOfferPage.activated.isDisplayed()==true)
			{		
				test.log(Status.PASS, "Activate Offer Icon is Present in Offer Listings").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Activate Offer Icon is Not Present in Offer Listings").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
				Assert.fail("Activate Offer Icon is Not Present in Offer Listings");
			}
		
		String title1=objOfferPage.offer_title.getText();
		System.out.println("title 1--" +title1);
		objOfferPage.offer_image.click();
		
		String title2=objOfferPage.offer_details_title.getText();
		System.out.println("title 2--" +title2);
		
			if(title1.equals(title2))
			{
				test.log(Status.PASS, "Offer Detailed Page is Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Offer Detail Page is Not Displayed");
				Assert.fail("Offer Detail Page is  Not Displayed");
			}

		if(objOfferPage.offer_details_share.isDisplayed()==true)
		{
			test.log(Status.PASS, "Share Offer Icon is Present in Offer Details Page").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
		}
		else
		{
			test.log(Status.FAIL, "Share Offer Icon is Not Present in Offer Details Page").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			Assert.fail("Share Offer Icon is Not Present in Offer Details Page");
		}
		
		if(objOfferPage.activated_icon.isDisplayed()==true)
		{
			test.log(Status.PASS, "Activate Offer Icon is Present in Offer Details Page");
		}
		else
		{
			test.log(Status.FAIL, "Activate Offer Icon is Not Present in Offer Details Page");
			Assert.fail("Activate Offer Icon is Not Present in Offer Details Page");
		}
		
		generalFunctions.isElementPresent(objOfferPage.activated_icon, 60);
		objOfferPage.activated_icon.click();
		Thread.sleep(5000);
		
		generalFunctions.isElementPresent(objOfferPage.offer_back_button, 60);
		objOfferPage.offer_back_button.click();
		Thread.sleep(5000);
		
		generalFunctions.isElementPresent(objOfferPage.activated_tab, 60);
		objOfferPage.activated_tab.click();
		Thread.sleep(5000);
		
		generalFunctions.isElementPresent(objOfferPage.offer_banner_title, 60);
		String title3=objOfferPage.offer_banner_title.getText();
		System.out.println(title3);

		try
		{
			if(title1.equals(title3))
			{		
				test.info("Navigated to Offers Actiaved Tab");
				test.log(Status.PASS, "Activated Offers is Present in Activated Tab");
			}
		}
		catch(NoSuchElementException x)
		{
			test.log(Status.FAIL, "Activated Offers is Not present in Activated Tab");
			Assert.fail("Activated Offers is Not Present in Activated Tab");
		}

		objOfferPage.untick_offer.click();
		Thread.sleep(5000);
		
		 try
	     {
	     if(driver.findElementByXPath(objOfferPage.VerifyOffer(title3)).isDisplayed()==true)
	     {
	         test.log(Status.FAIL, "Deactivated Offer is Present in Activated Tab");
	         Assert.fail("Deactivated Offer is Present in Activated Tab");
	     }
	     }
	     catch(Exception e)
	     {
	         test.log(Status.PASS, "Deactivated Offer Not is Present in Activated Tab");
	         System.out.println("Deactivated offer is not present in activated tab");
	     }
		}
		
		 catch(Exception e)
			{
				test.log(Status.FAIL, e.getMessage());
				Assert.fail(e.getMessage());
			}
	}


	@Test
	public void TC_Offers_008(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Offers");
		test.info("Verify Offers tab have Carrefour Offers Listings");
		test.info("2.Activate Carrefour Offer and Deactivate Offer From Carrefour Detail Page");
		test.assignCategory("Offers");	
		System.out.println("Running Test"+" "+ TC_Method);
		
		String EmailAddress=map.get("UserName").toString();
		String Pass=map.get("Password").toString();
					
		RegistrationPage registrationPage= new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		OffersPage objOfferPage= new OffersPage(driver);
		SignInPage signInPage = new SignInPage(driver);
		
		try
		{
		
		driver.resetApp();
		Thread.sleep(2000);	
			
		//LOGIN
		registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);

		//Click on Offers Icon
		objOfferPage.offers.click();
		Thread.sleep(5000);
		
		try
		{
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
		
		generalFunctions.isElementPresent(objOfferPage.carrefour, 60);
		objOfferPage.carrefour.click();
		Thread.sleep(8000);
							
		//Verify share icon displayed
		
			if(objOfferPage.share_button.isDisplayed()==true)
			{
				test.log(Status.PASS, "Share Offer Icon is Present in Carrefour Offer Listings");
			}
			else
			{
			test.log(Status.FAIL, "Share Offer Icon is Not Present in Carrefour Offer Listings");
			Assert.fail("Share Offer Icon is Not Present in Offer Listings");
			}
			Thread.sleep(5000);
		
			if(objOfferPage.carre_tick.isDisplayed()==true)
			{
				test.log(Status.PASS, "Activate Offer Icon is Present in Offer Listings");
			}
			else
			{
				test.log(Status.FAIL, "Activate Offer Icon is Not Present in Offer Listings");
				Assert.fail("Activate Offer Icon is Not Present in Offer Listings");
			}
		
		generalFunctions.isElementPresent(objOfferPage.offer_title, 60);
		String title1=objOfferPage.offer_title.getText();
		System.out.println("title 1--" +title1);
		objOfferPage.carre_img.click();
		
		generalFunctions.isElementPresent(objOfferPage.offer_details_title, 60);
		String title2=objOfferPage.offer_details_title.getText();
		System.out.println("title 2--" +title2);
		
		if(title1.equals(title2))
		{
			test.log(Status.PASS, "Carrefour Offer Detailed Page is Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Carrefour Offer Detailed Page Not Displayed");
			Assert.fail("Carrefour Offer Detailed Page Not Displayed");
		}
	
		generalFunctions.isElementPresent(objOfferPage.offer_details_share, 60);
		if(objOfferPage.offer_details_share.isDisplayed()==true)
		{
			test.log(Status.PASS, "Share Offer Icon is Present in Carrefour Details Page").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
		}
		else
		{
			test.log(Status.FAIL, "Share Offer Icon is Not Present in Carrefour Details Page").addScreenCaptureFromPath(Utilities.getScreenshot(driver,TC_Method));
			Assert.fail("Share Offer Icon is Not Present in Carrefour Details Page");
		}
		
		if(objOfferPage.activated_icon.isDisplayed()==true)
		{
			test.log(Status.PASS, "Activate Offer Icon is Present in CarreFour Details Page");
		}
		else
		{
			test.log(Status.FAIL, "Activate Offer Icon Not Present in CarreFour Details Page");
			Assert.fail("Activate Offer Icon Not Present in CarreFour Details Page");
		}
		
		generalFunctions.isElementPresent(objOfferPage.activated_icon, 60);
		objOfferPage.activated_icon.click();
		Thread.sleep(5000);
		
		generalFunctions.isElementPresent(objOfferPage.offer_back_button, 90);
		objOfferPage.offer_back_button.click();
		Thread.sleep(5000);
		
		generalFunctions.isElementPresent(objOfferPage.activated_tab, 90);
		objOfferPage.activated_tab.click();
		Thread.sleep(5000);
		
		generalFunctions.isElementPresent(objOfferPage.offer_banner_title, 90);
		String title3=objOfferPage.offer_banner_title.getText();
		System.out.println(title3);
			if(title1.equals(title3))
			{		
				test.info("Navigated to Offers Actiaved Tab");
				test.log(Status.PASS, "Activated Carrefour Offer is Present in Activated Tab");
			}
			else	
			{
				test.log(Status.FAIL, "Activated Carrefour Offer Not Present in Activated Tab");
				Assert.fail("Activated Carrefour Offer Not Present in Activated Tab");
			}
	
		objOfferPage.untick_offer.click();
		Thread.sleep(5000);
		
		 try
	     {
	     if(driver.findElementByXPath(objOfferPage.VerifyOffer(title3)).isDisplayed()==true)
	     {
	         test.log(Status.FAIL, "Deactivated Offer is Present in Activated Tab");
	         Assert.fail("Deactivated Offer is Present in Activated Tab");
	     }
	     }
	     catch(Exception e)
	     {
	         test.log(Status.PASS, "Deactivated Offer Not is Present in Activated Tab");
	         System.out.println("Deactivated offer is not present in activated tab");
	     }       
	}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}	
}	
	
	
	
	@Test
	public void TC_Offers_009_to_TC_Offers_010(Method method) throws Exception
	{
		
			String TC_Method = method.getName();
			test = extent.createTest(TC_Method);
			test.log(Status.INFO, "Verify Offer Submit Receipt able to Submit Receipt");
			test.log(Status.INFO, "Verify Offer Submit Receipt Have Skip and Next Buttons");
			test.log(Status.INFO, "Verify Offer Submit Camera have information Tooltip");
			test.log(Status.INFO, "Verify that the user is able to Go to Scanning Page");
			test.log(Status.INFO, "Verify that Capture Button is Present in Offer");
			test.assignCategory("Offers");
			System.out.println("Running Test"+" "+ TC_Method);
			
			String EmailAddress=map.get("Offers_UserEmail").toString();
			String Pass=map.get("Offers_UserPassword").toString();
			
			GeneralFunctions generalFunctions = new GeneralFunctions();
			//AccountPage accountPage = new AccountPage(driver);
			HomePage homePage = new HomePage(driver);
			HomeFunctions homeFunctions = new HomeFunctions();
			RegistrationFunctions registrationFunctions= new RegistrationFunctions();
			RegistrationPage registrationPage= new RegistrationPage(driver);
			OffersPage objOfferPage= new OffersPage(driver);
			SignInPage signInPage = new SignInPage(driver);
			
			try
			{
			driver.resetApp();
			Thread.sleep(2000);	
			
			//LOGIN
			registrationFunctions.LoginFun(registrationPage,EmailAddress,Pass,signInPage);
			Thread.sleep(2000);	

			generalFunctions.isElementPresent(objOfferPage.offers, 90);
			Thread.sleep(2000);
			
			objOfferPage.offers.click();
			Thread.sleep(10000);
			
			try
			{
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
			
			homeFunctions.receiptCameraClick(homePage);
			//generalFunctions.isElementPresent(accountPage.accountReceipt, 90);
			//accountFunctions.receiptScan(accountPage);
			
			Thread.sleep(4000);
			//Verify Skip Button is Present
			if(homePage.introSkip.isDisplayed()==true)
			{
				test.log(Status.PASS, "Submit Receipt Camera Intro Skip Button is Present");
			}
			else
			{
				test.log(Status.FAIL, "Submit Receipt Camera Have Intro Skip Button is Not Present");
				Assert.fail("Submit Receipt Camera Intro Skip Button is Not Present");
			}
			
			generalFunctions.isElementPresent(homePage.introNext, 90);
			if(homePage.introNext.isDisplayed()==true)
			{
				test.log(Status.PASS, "Submit Receipt Camera Have Intro Next Button is Present");
			}
			else
			{
				test.log(Status.FAIL, "Submit Receipt Receipt Camera Have Intro Next Button is Not Present");
				Assert.fail("Submit Receipt Camera Have Intro Next Button is Not Present");
			}
			
			generalFunctions.isElementPresent(homePage.introSkip, 90);
			homePage.introSkip.click();
			Thread.sleep(6000);
			homeFunctions.allowtoAccess(homePage);
			Thread.sleep(6000);
			generalFunctions.isElementPresent(homePage.introInfo, 90);
			if(homePage.introInfo.isDisplayed()==true)
			{
				test.log(Status.PASS, "Submit Receipt Camera Have IntroInfo icon is Present");
			}
			else
			{
				test.log(Status.FAIL, "Submit Receipt Camera Have IntroInfo icon is Not Present");
				Assert.fail("Submit Receipt Camera Have IntroInfo icon is Not Present");
			}
			
			generalFunctions.isElementPresent(homePage.introInfo, 90);
			homePage.introInfo.click();
			Thread.sleep(8000);
			homeFunctions.introDone(homePage);
			
			generalFunctions.isElementPresent(homePage.normalReceiptButton, 90);
			if(homePage.normalReceiptButton.isDisplayed()==true)
			{
				test.log(Status.PASS, "NormalReceipt Scan Button is Present");
			}
			else
			{
				test.log(Status.FAIL, "NormalReceipt Scan Button is Not  Present");
				Assert.fail("NormalReceipt Scan Button is Not Present");
			}
			Thread.sleep(7000);
			generalFunctions.isElementPresent(homePage.longReceiptButton, 90);
			if(homePage.longReceiptButton.isDisplayed()==true)
			{
				test.log(Status.PASS, "LongReceipt Scan Button is Present");
			}
			else
			{
				test.log(Status.FAIL, "LongReceipt Scan Button is Not Present");
				Assert.fail("LongReceipt Scan Button is Not Present");
			}
			Thread.sleep(7000);
			generalFunctions.isElementPresent(homePage.buttonCaptureClick, 90);
			if(homePage.buttonCaptureClick.isDisplayed()==true)
			{
				test.log(Status.PASS, "Capture Receipt Button is Present");
			}
			else
			{
				test.log(Status.FAIL, "Capture Receipt Button is Not Present");
				Assert.fail("Capture Receipt Button is Not Present");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
}

	
	