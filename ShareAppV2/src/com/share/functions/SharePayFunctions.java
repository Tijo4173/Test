package com.share.functions;

import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.HomePage;
import com.share.objectrepository.ProfilePage;
import com.share.objectrepository.SharePayPage;
import com.share.objectrepository.SignInPage;

public class SharePayFunctions extends DriverSetUp {
	GeneralFunctions generalFunctions = new GeneralFunctions();

	String newUserPasscodePay = mapdata.get("newUserSharePasscode").toString();
	String newUserPasswordPay = mapdata.get("newUserSharePassword").toString();


	//Passcode for New user
	public void newUserPassPay() {
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		HomePage homePage = new HomePage(driver);
		ProfilePage profilePage =  new ProfilePage(driver);
		generalFunctions.isElementPresent(signInPage.signinPresent, 30);
		signInPage.signinPresent.click();
		generalFunctions.isElementPresent(signInPage.useridElement, 90);
		signInPage.useridElement.sendKeys(newUserPasscodePay);
		signInPage.userpassElement.sendKeys(newUserPasswordPay);
		signInPage.signinElement.click();
		generalFunctions.isElementPresent(homePage.homeElement, 20);			

	}
	
	//Function for ShareWallet to Add card Payment
	public void shareToAddPayment() throws InterruptedException {

		SharePayPage sharePayPage = new SharePayPage(driver);
		//Verify Share Pay Icon displayed
		generalFunctions.isElementPresent(sharePayPage.shareWalletButton, 60);
		try
		{
			if(sharePayPage.shareWalletButton.isDisplayed()==true)
			{
				test.log(Status.PASS, "Share Pay Icon Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Share Pay Icon Not Displayed");
			Assert.fail("Share Pay Icon Not Displayed");
		}

		// Click Share Pay Icon
		sharePayPage.shareWalletButton.click();


		try
		{
			if(generalFunctions.isElementPresent(sharePayPage.OnBoarding, 30))
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
			if(generalFunctions.isElementPresent(sharePayPage.OnBoardingContinue, 30))
			{
				test.log(Status.PASS, "Continue Button Displayed");
				sharePayPage.OnBoardingContinue.click();
				Thread.sleep(4000);
				
				
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Continue Button Not Displayed");
			Assert.fail("Continue Button Not Displayed");
		}

		
			generalFunctions.isElementPresent(sharePayPage.addCardAgain, 60);
			if(sharePayPage.addCardAgain.isDisplayed()==true)
			{
				test.log(Status.PASS, "Add A New Card Displayed");
				sharePayPage.addCardAgain.click();
			}else
		{
			test.log(Status.FAIL, "Add A New Card is Not Displayed");
			Assert.fail("Add A New Card is Not Displayed");
		}

	}



}

