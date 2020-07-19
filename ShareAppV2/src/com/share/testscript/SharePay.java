package com.share.testscript;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.share.functions.ProfileFunctions;
import com.share.functions.RegistrationFunctions;
import com.share.functions.SharePayFunctions;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.ProfilePage;
import com.share.objectrepository.SharePayPage;
import com.share.objectrepository.RegistrationPage;
import com.share.objectrepository.SignInPage;
import com.share.utility.Utilities;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class SharePay extends DriverSetUp
{


	GeneralFunctions generalFunctions = new GeneralFunctions();


	@Test
	public void TC_01_02(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Beam Wallet - SHARE Pay");
		test.assignCategory("SHARE Pay");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		SharePayPage sharePayPage = new SharePayPage(driver);

		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();

		try

		{

			driver.resetApp();
			driver.activateApp("com.maf.sharesit");

			//Login to the App				
			generalFunctions.SignIn(EmailAddress, Password, signInPage);

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
			Thread.sleep(5000);

			try
			{
				if(sharePayPage.OnBoarding.isDisplayed()==true)
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
				if(sharePayPage.OnBoardingContinue.isDisplayed()==true)
				{
					test.log(Status.PASS, "Continue Button Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Continue Button Not Displayed");
				Assert.fail("Continue Button Not Displayed");
			}

			sharePayPage.OnBoardingContinue.click();
			Thread.sleep(4000);

			try
			{
				generalFunctions.isElementPresent(sharePayPage.sharePayWallet, 60);
				if(sharePayPage.sharePayWallet.isDisplayed()==true)
				{
					test.log(Status.PASS, "Share Pay Page Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Share Pay Page Not Displayed");
				Assert.fail("Share Pay Page Not Displayed");
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
		test.log(Status.INFO, "Beam Wallet - SHARE Pay");
		test.assignCategory("SHARE Pay");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		SharePayPage sharePayPage = new SharePayPage(driver);

		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();

		try

		{

			driver.activateApp("com.maf.sharesit");

			//Login to the App				
			//generalFunctions.SignIn(EmailAddress, Password, signInPage);

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
			Thread.sleep(5000);

			try
			{
				generalFunctions.isElementPresent(sharePayPage.sharePayWallet, 60);
				if(sharePayPage.sharePayWallet.isDisplayed()==true)
				{
					test.log(Status.PASS, "Share Pay Page Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Share Pay Page Not Displayed");
				Assert.fail("Share Pay Page Not Displayed");
			}


			try
			{
				generalFunctions.isElementPresent(sharePayPage.AddANewCardLink, 60);
				if(sharePayPage.AddANewCardLink.isDisplayed()==true)
				{
					test.log(Status.PASS, "Add A New Card Link Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Add A New Card Link Not Displayed");
				Assert.fail("Add A New Card Link Not Displayed");
			}

			try
			{
				if(sharePayPage.AddANewDebitOrCreditCardText.isDisplayed()==true)
				{
					test.log(Status.PASS, "Add A New Credit/Debit Card Text Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Add A New Credit/Debit Card Text Not Displayed");
				Assert.fail("Add A New Credit/Debit Card Text Not Displayed");
			}

			try
			{
				if(sharePayPage.AddCardIcon.isDisplayed()==true)
				{
					test.log(Status.PASS, "Add Card Icon Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Add Card Icon Not Displayed");
				Assert.fail("Add Card Icon Not Displayed");
			}

			try
			{
				if(sharePayPage.pointBalance.isDisplayed()==true)
				{
					test.log(Status.PASS, "Point Balance Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Point Balance Not Displayed");
				Assert.fail("Point Balance Not Displayed");
			}

			try
			{
				if(sharePayPage.aedValue.isDisplayed()==true)
				{
					test.log(Status.PASS, "AED Value Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "AED Value Not Displayed");
				Assert.fail("AED Value Not Displayed");
			}

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}		
	}


	@Test
	public void TC_04_05_11_16(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Beam Wallet - SHARE Pay");
		test.assignCategory("SHARE Pay");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		SharePayPage sharePayPage = new SharePayPage(driver);
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
			//generalFunctions.SignIn(EmailAddress, Password, signInPage);

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
			Thread.sleep(5000);

			try
			{
				generalFunctions.isElementPresent(sharePayPage.sharePayWallet, 60);
				if(sharePayPage.sharePayWallet.isDisplayed()==true)
				{
					test.log(Status.PASS, "Share Pay Page Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Share Pay Page Not Displayed");
				Assert.fail("Share Pay Page Not Displayed");
			}


			try
			{
				generalFunctions.isElementPresent(sharePayPage.AddANewCardLink, 80);
				if(sharePayPage.AddANewCardLink.isDisplayed()==true)
				{
					test.log(Status.PASS, "Add A New Card Link Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Add A New Card Link Not Displayed");
				Assert.fail("Add A New Card Link Not Displayed");
			}

			//Click Add A New Card Link
			sharePayPage.AddANewCardLink.click();
			Thread.sleep(4000);

			try
			{
				generalFunctions.isElementPresent(sharePayPage.addNewCardPage, 30);
				if(sharePayPage.addNewCardPage.isDisplayed()==true)
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
			sharePayPage.CardNumber.click();
			Actions action = new Actions(driver);
			action.sendKeys(CardNumber).perform();
			Thread.sleep(5000);

			//Enter Expiry
			sharePayPage.Expiry.click();
			action.sendKeys(ExpiryDate).perform();
			Thread.sleep(5000);

			//Enter CVC
			sharePayPage.CVC.sendKeys(Cvv);

			//Enter Name On Card
			sharePayPage.NameOnCard.sendKeys(NameOnCard);

			String GetCardNumber=sharePayPage.CardNumber.getText();
			System.out.println(GetCardNumber);
			//String lastDigits = GetCardNumber.split(" ")[(CardNumber.split(" ")).length -1];
			String lastDigits = GetCardNumber.substring(GetCardNumber.lastIndexOf(' ') + 1);
			System.out.println(lastDigits);

			//Click Done
			sharePayPage.doneButon.click();
			driver.hideKeyboard();
			Thread.sleep(5000);
			generalFunctions.isElementPresent(sharePayPage.verifyPage, 40);	

			//Verify Verify Card Page page displayed
			try
			{
				if(sharePayPage.verifyPage.isDisplayed()==true)
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
			if(sharePayPage.TransactionAmount.isDisplayed()==true)
			{
				test.log(Status.PASS, "Transaction Amount Field Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Transaction Amount Field Not Displayed");
				Assert.fail("Transaction Amount Field Not Displayed");
			}	

			sharePayPage.TransactionAmount.sendKeys(TransactionAmount);
			driver.hideKeyboard();

			sharePayPage.SubmitTransactionAmount.click();
			Thread.sleep(20000);


			generalFunctions.isElementPresent(profilePage.shareWalletPage, 40);		
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

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}		
	}


	@Test
	public void TC_06_07_08(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Beam Wallet - SHARE Pay");
		test.assignCategory("SHARE Pay");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		SharePayPage sharePayPage = new SharePayPage(driver);
		ProfilePage profilePage = new ProfilePage(driver);

		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();
		String CardNumber=map.get("CardNumber").toString();
		String NameOnCard =map.get("NameOnCard").toString();
		String ExpiryDate=map.get("ExpiryDate").toString();
		String Cvv =map.get("Cvv").toString();
		String wrongTransactionAmount="10";
		String TransactionAmount=map.get("TransactionAmount").toString();
		try

		{

			driver.activateApp("com.maf.sharesit");	

			//Login to the App				
			//generalFunctions.SignIn(EmailAddress, Password, signInPage);

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
			Thread.sleep(5000);

			try
			{
				generalFunctions.isElementPresent(sharePayPage.sharePayWallet, 60);
				if(sharePayPage.sharePayWallet.isDisplayed()==true)
				{
					test.log(Status.PASS, "Share Pay Page Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Share Pay Page Not Displayed");
				Assert.fail("Share Pay Page Not Displayed");
			}


			try
			{
				generalFunctions.isElementPresent(sharePayPage.AddANewCardLink, 80);
				if(sharePayPage.AddANewCardLink.isDisplayed()==true)
				{
					test.log(Status.PASS, "Add A New Card Link Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Add A New Card Link Not Displayed");
				Assert.fail("Add A New Card Link Not Displayed");
			}

			//Click Add A New Card Link
			sharePayPage.AddANewCardLink.click();
			Thread.sleep(4000);

			try
			{
				generalFunctions.isElementPresent(sharePayPage.addNewCardPage, 30);
				if(sharePayPage.addNewCardPage.isDisplayed()==true)
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
			sharePayPage.CardNumber.click();
			Actions action = new Actions(driver);
			action.sendKeys(CardNumber).perform();
			Thread.sleep(5000);

			//Enter Expiry
			sharePayPage.Expiry.click();
			action.sendKeys(ExpiryDate).perform();
			Thread.sleep(5000);

			//Enter CVC
			sharePayPage.CVC.sendKeys(Cvv);

			//Enter Name On Card
			sharePayPage.NameOnCard.sendKeys(NameOnCard);

			String GetCardNumber=sharePayPage.CardNumber.getText();
			System.out.println(GetCardNumber);
			//String lastDigits = GetCardNumber.split(" ")[(CardNumber.split(" ")).length -1];
			String lastDigits = GetCardNumber.substring(GetCardNumber.lastIndexOf(' ') + 1);
			System.out.println(lastDigits);

			//Click Done
			sharePayPage.doneButon.click();
			driver.hideKeyboard();
			Thread.sleep(5000);
			generalFunctions.isElementPresent(sharePayPage.verifyPage, 40);	

			//Verify Verify Card Page page displayed
			try
			{
				if(sharePayPage.verifyPage.isDisplayed()==true)
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
			if(sharePayPage.TransactionAmount.isDisplayed()==true)
			{
				test.log(Status.PASS, "Transaction Amount Field Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Transaction Amount Field Not Displayed");
				Assert.fail("Transaction Amount Field Not Displayed");
			}	

			sharePayPage.TransactionAmount.sendKeys(wrongTransactionAmount);
			driver.hideKeyboard();

			sharePayPage.SubmitTransactionAmount.click();
			Thread.sleep(4000);

			sharePayPage.goBack.click();

			generalFunctions.isElementPresent(profilePage.shareWalletPage, 40);		
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

			//Verify the Card Details Tag
			String CardTag= sharePayPage.CardInWalletStatus(lastDigits).getText();
			System.out.println("Card Status : "+CardTag);
			if(CardTag.contains("Not Verified"))
			{
				test.log(Status.PASS, "Card Status Displayed and verified in Share Wallet");
			}
			else
			{
				test.log(Status.FAIL, "Card Status Not Displayed OR Wrong Status displayed in Share Wallet");
				Assert.fail("Card Status Not Displayed OR Wrong Status displayed in Share Wallet");
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

			//Verify the Card Details Tag
			String NewCardTag= profilePage.GetCardStatus(lastDigits).getText();
			System.out.println("Card Status : "+NewCardTag);
			if(NewCardTag.contains("Not Verified"))
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
			generalFunctions.isElementPresent(profilePage.editButton, 70);

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

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}		
	}


	@Test
	public void TC_09_10(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Beam Wallet - SHARE Pay");
		test.assignCategory("SHARE Pay");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		SharePayPage sharePayPage = new SharePayPage(driver);
		ProfilePage profilePage = new ProfilePage(driver);

		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();
		String CardNumber=map.get("CardNumber").toString();
		String NameOnCard =map.get("NameOnCard").toString();
		String ExpiryDate=map.get("ExpiryDate").toString();
		String Cvv =map.get("Cvv").toString();

		String VisaCardNumber=map.get("VisaCardNumber").toString();
		String VisaNameOnCard =map.get("VisaNameOnCard").toString();
		String VisaExpiryDate=map.get("VisaCardExpiry").toString();
		String VisaCvv =map.get("VisaCardCVC").toString();
		String TransactionAmount=map.get("TransactionAmount").toString();
		try

		{

			driver.activateApp("com.maf.sharesit");

			//Login to the App				
			//generalFunctions.SignIn(EmailAddress, Password, signInPage);

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
			Thread.sleep(5000);

			try
			{
				generalFunctions.isElementPresent(sharePayPage.sharePayWallet, 60);
				if(sharePayPage.sharePayWallet.isDisplayed()==true)
				{
					test.log(Status.PASS, "Share Pay Page Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Share Pay Page Not Displayed");
				Assert.fail("Share Pay Page Not Displayed");
			}


			try
			{
				generalFunctions.isElementPresent(sharePayPage.AddANewCardLink, 80);
				if(sharePayPage.AddANewCardLink.isDisplayed()==true)
				{
					test.log(Status.PASS, "Add A New Card Link Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Add A New Card Link Not Displayed");
				Assert.fail("Add A New Card Link Not Displayed");
			}

			//Click Add A New Card Link
			sharePayPage.AddANewCardLink.click();
			Thread.sleep(4000);

			try
			{
				generalFunctions.isElementPresent(sharePayPage.addNewCardPage, 30);
				if(sharePayPage.addNewCardPage.isDisplayed()==true)
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
			sharePayPage.CardNumber.click();
			Actions action = new Actions(driver);
			action.sendKeys(CardNumber).perform();
			Thread.sleep(5000);

			//Enter Expiry
			sharePayPage.Expiry.click();
			action.sendKeys(ExpiryDate).perform();
			Thread.sleep(5000);

			//Enter CVC
			sharePayPage.CVC.sendKeys(Cvv);

			//Enter Name On Card
			sharePayPage.NameOnCard.sendKeys(NameOnCard);

			String GetCardNumber=sharePayPage.CardNumber.getText();
			System.out.println(GetCardNumber);
			//String lastDigits = GetCardNumber.split(" ")[(CardNumber.split(" ")).length -1];
			String lastDigits = GetCardNumber.substring(GetCardNumber.lastIndexOf(' ') + 1);
			System.out.println(lastDigits);

			//Click Done
			sharePayPage.doneButon.click();
			driver.hideKeyboard();
			Thread.sleep(5000);
			generalFunctions.isElementPresent(sharePayPage.verifyPage, 40);	

			//Verify Verify Card Page page displayed
			try
			{
				if(sharePayPage.verifyPage.isDisplayed()==true)
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
			if(sharePayPage.TransactionAmount.isDisplayed()==true)
			{
				test.log(Status.PASS, "Transaction Amount Field Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Transaction Amount Field Not Displayed");
				Assert.fail("Transaction Amount Field Not Displayed");
			}	

			sharePayPage.TransactionAmount.sendKeys(TransactionAmount);
			driver.hideKeyboard();

			sharePayPage.SubmitTransactionAmount.click();
			Thread.sleep(20000);


			generalFunctions.isElementPresent(profilePage.shareWalletPage, 40);		
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
					test.log(Status.PASS, "Added Maser Card Displayed in Share Wallet");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Added Maser Card Not Displayed in Share Wallet");
				Assert.fail("Added Maser Card Not Displayed in Share Wallet");
			}	



			//Click Add A New Card icon
			sharePayPage.AddCardIcon.click();
			Thread.sleep(4000);

			try
			{
				generalFunctions.isElementPresent(sharePayPage.addNewCardPage, 30);
				if(sharePayPage.addNewCardPage.isDisplayed()==true)
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
			sharePayPage.CardNumber.click();
			action.sendKeys(VisaCardNumber).perform();
			Thread.sleep(5000);

			//Enter Expiry
			sharePayPage.Expiry.click();
			action.sendKeys(VisaExpiryDate).perform();
			Thread.sleep(5000);

			//Enter CVC
			sharePayPage.CVC.sendKeys(VisaCvv);

			//Enter Name On Card
			sharePayPage.NameOnCard.sendKeys(VisaNameOnCard);

			String VisaGetCardNumber=sharePayPage.CardNumber.getText();
			System.out.println(GetCardNumber);
			//String lastDigits = GetCardNumber.split(" ")[(CardNumber.split(" ")).length -1];
			String VisalastDigits = VisaGetCardNumber.substring(VisaGetCardNumber.lastIndexOf(' ') + 1);
			System.out.println(VisalastDigits);

			//Click Done
			sharePayPage.doneButon.click();
			driver.hideKeyboard();
			Thread.sleep(5000);
			generalFunctions.isElementPresent(sharePayPage.verifyPage, 40);	

			//Verify Verify Card Page page displayed
			try
			{
				if(sharePayPage.verifyPage.isDisplayed()==true)
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
			if(sharePayPage.TransactionAmount.isDisplayed()==true)
			{
				test.log(Status.PASS, "Transaction Amount Field Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Transaction Amount Field Not Displayed");
				Assert.fail("Transaction Amount Field Not Displayed");
			}	

			sharePayPage.TransactionAmount.sendKeys(TransactionAmount);
			driver.hideKeyboard();

			sharePayPage.SubmitTransactionAmount.click();
			Thread.sleep(20000);


			generalFunctions.isElementPresent(profilePage.shareWalletPage, 40);		
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
				if(profilePage.CardInWallet(VisalastDigits).isDisplayed()==true)
				{
					test.log(Status.PASS, "Added Visa Card Displayed in Share Wallet");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Added Visa Card Not Displayed in Share Wallet");
				Assert.fail("Added Visa Card Not Displayed in Share Wallet");
			}	


			try
			{
				if(profilePage.CardInWallet(lastDigits).isDisplayed()==true && profilePage.CardInWallet(VisalastDigits).isDisplayed()==true)
				{
					test.log(Status.PASS, "Multiple Card (Visa and MasterCard) Added to Share Wallet");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Failed to Add Multiple Card (Visa and MasterCard) to Share Wallet");
				Assert.fail("Failed to Add Multiple Card (Visa and MasterCard) to Share Wallet");
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
					test.log(Status.PASS, "Master Card Displayed in Payment Methods");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Master Card Not Displayed in Payment Methods");
				Assert.fail("Master Card Not Displayed in Payment Methods");
			}

			try
			{
				if(profilePage.SelectCards(VisalastDigits).isDisplayed()==true)
				{
					test.log(Status.PASS, "Visa Card Displayed in Payment Methods");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Visa Card Not Displayed in Payment Methods");
				Assert.fail("Visa Card Not Displayed in Payment Methods");
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
			Thread.sleep(15000);	

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


			profilePage.deleteCard(VisalastDigits).click();
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
			Thread.sleep(15000);	

			try
			{
				if(profilePage.SelectCards(VisalastDigits).isDisplayed()==true)
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

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}		
	}


	@Test
	public void TC_13(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Beam Wallet - SHARE Pay");
		test.assignCategory("SHARE Pay");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		SharePayPage sharePayPage = new SharePayPage(driver);

		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();

		try

		{

			driver.resetApp();
			driver.activateApp("com.maf.sharesit");

			//Login to the App				
			generalFunctions.SignIn(EmailAddress, Password, signInPage);

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
			Thread.sleep(5000);

			try
			{
				if(sharePayPage.OnBoarding.isDisplayed()==true)
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
				if(sharePayPage.OnBoardingContinue.isDisplayed()==true)
				{
					test.log(Status.PASS, "Continue Button Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Continue Button Not Displayed");
				Assert.fail("Continue Button Not Displayed");
			}

			sharePayPage.OnBoardingContinue.click();
			//Thread.sleep(2000);	

			/*try
		{
			generalFunctions.isElementPresent(sharePayPage.sharePayPage, 60);
			if(sharePayPage.sharePayPage.isDisplayed()==true)
			{
				test.log(Status.PASS, "Share Pay Page Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Share Pay Page Not Displayed");
			Assert.fail("Share Pay Page Not Displayed");
		}*/

			try
			{
				generalFunctions.isElementPresent(sharePayPage.locationAccessRequired, 60);
				if(sharePayPage.locationAccessRequired.isDisplayed()==true)
				{
					test.log(Status.PASS, "Location Access Required Message Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Location Access Required Message Not Displayed");
				Assert.fail("Location Access Required Message Not Displayed");
			}

			sharePayPage.locationAccessRequired.click();

			try
			{
				generalFunctions.isElementPresent(sharePayPage.switchOnLocation, 20);
				if(sharePayPage.switchOnLocation.isDisplayed()==true)
				{
					test.log(Status.PASS, "Switch On Location Button Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Switch On Location Button Not Displayed");
				Assert.fail("Switch On Location Button Not Displayed");
			}

			sharePayPage.switchOnLocation.click();

			try
			{
				generalFunctions.isElementPresent(sharePayPage.AllowAllTheTime, 20);
				if(sharePayPage.AllowAllTheTime.isDisplayed()==true)
				{
					test.log(Status.PASS, "Allow All The Time Button Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Allow All The Time Button Not Displayed");
				Assert.fail("Allow All The Time Button Not Displayed");
			}

			sharePayPage.AllowAllTheTime.click();


			try
			{
				generalFunctions.isElementPresent(sharePayPage.bluetoothAccessRequired, 40);
				if(sharePayPage.bluetoothAccessRequired.isDisplayed()==true)
				{
					test.log(Status.PASS, "Bluetooth Access Required Message Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Bluetooth Access Required Message Not Displayed");
				Assert.fail("Bluetooth Access Required Message Not Displayed");
			}

			sharePayPage.bluetoothAccessRequired.click();

			try
			{
				generalFunctions.isElementPresent(sharePayPage.switchOnBluetooth, 20);
				if(sharePayPage.switchOnBluetooth.isDisplayed()==true)
				{
					test.log(Status.PASS, "Switch On Bluetooth Button Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Switch On Bluetooth Button Not Displayed");
				Assert.fail("Switch On Bluetooth Button Not Displayed");
			}

			sharePayPage.switchOnBluetooth.click();

			generalFunctions.isElementPresent(sharePayPage.sharePayWallet, 60);

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
		test.log(Status.INFO, "Beam Wallet - SHARE Pay");
		test.assignCategory("SHARE Pay");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		SharePayPage sharePayPage = new SharePayPage(driver);

		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();

		try

		{

			driver.resetApp();
			driver.activateApp("com.maf.sharesit");

			//Login to the App				
			generalFunctions.SignIn(EmailAddress, Password, signInPage);

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
			Thread.sleep(5000);

			try
			{
				if(sharePayPage.OnBoarding.isDisplayed()==true)
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
				if(sharePayPage.OnBoardingContinue.isDisplayed()==true)
				{
					test.log(Status.PASS, "Continue Button Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Continue Button Not Displayed");
				Assert.fail("Continue Button Not Displayed");
			}

			sharePayPage.OnBoardingContinue.click();
			//Thread.sleep(2000);	

			/*try
		{
			generalFunctions.isElementPresent(sharePayPage.sharePayPage, 60);
			if(sharePayPage.sharePayPage.isDisplayed()==true)
			{
				test.log(Status.PASS, "Share Pay Page Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Share Pay Page Not Displayed");
			Assert.fail("Share Pay Page Not Displayed");
		}*/

			try
			{
				generalFunctions.isElementPresent(sharePayPage.locationAccessRequired, 60);
				if(sharePayPage.locationAccessRequired.isDisplayed()==true)
				{
					test.log(Status.PASS, "Location Access Required Message Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Location Access Required Message Not Displayed");
				Assert.fail("Location Access Required Message Not Displayed");
			}

			sharePayPage.locationAccessRequired.click();

			try
			{
				generalFunctions.isElementPresent(sharePayPage.switchOnLocation, 20);
				if(sharePayPage.switchOnLocation.isDisplayed()==true)
				{
					test.log(Status.PASS, "Switch On Location Button Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Switch On Location Button Not Displayed");
				Assert.fail("Switch On Location Button Not Displayed");
			}

			try
			{
				generalFunctions.isElementPresent(sharePayPage.closeAccess, 20);
				if(sharePayPage.closeAccess.isDisplayed()==true)
				{
					test.log(Status.PASS, "Close option for Switch On Location Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Close option for Switch On Location Not Displayed");
				Assert.fail("Close option for Switch On Location Not Displayed");
			}

			sharePayPage.closeAccess.click();

			try
			{
				generalFunctions.isElementPresent(sharePayPage.locationAccessRequired, 60);
				if(sharePayPage.locationAccessRequired.isDisplayed()==true)
				{
					test.log(Status.PASS, "Location Access Required Message Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Location Access Required Message Not Displayed");
				Assert.fail("Location Access Required Message Not Displayed");
			}

			sharePayPage.locationAccessRequired.click();

			try
			{
				generalFunctions.isElementPresent(sharePayPage.switchOnLocation, 20);
				if(sharePayPage.switchOnLocation.isDisplayed()==true)
				{
					test.log(Status.PASS, "Switch On Location Button Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Switch On Location Button Not Displayed");
				Assert.fail("Switch On Location Button Not Displayed");
			}

			sharePayPage.switchOnLocation.click();

			try
			{
				generalFunctions.isElementPresent(sharePayPage.AllowAllTheTime, 20);
				if(sharePayPage.AllowAllTheTime.isDisplayed()==true)
				{
					test.log(Status.PASS, "Allow All The Time Button Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Allow All The Time Button Not Displayed");
				Assert.fail("Allow All The Time Button Not Displayed");
			}

			sharePayPage.AllowAllTheTime.click();


			try
			{
				generalFunctions.isElementPresent(sharePayPage.bluetoothAccessRequired, 20);
				if(sharePayPage.bluetoothAccessRequired.isDisplayed()==true)
				{
					test.log(Status.FAIL, "Bluetooth Access Required Message Displayed");
					Assert.fail("Bluetooth Access Required Message Displayed");
				}
			}
			catch(Exception x)
			{			
				test.log(Status.PASS, "Bluetooth Access Required Message Not Displayed");
			}


		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}		
	}


	@Test
	public void TC_17(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Beam Wallet - SHARE Pay");
		test.assignCategory("SHARE Pay");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		SharePayPage sharePayPage = new SharePayPage(driver);

		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();

		try

		{
			driver.activateApp("com.maf.sharesit");	

			//Login to the App				
			//generalFunctions.SignIn(EmailAddress, Password, signInPage);

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
			Thread.sleep(5000);

			try
			{
				generalFunctions.isElementPresent(sharePayPage.sharePayWallet, 60);
				if(sharePayPage.sharePayWallet.isDisplayed()==true)
				{
					test.log(Status.PASS, "Share Pay Page Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Share Pay Page Not Displayed");
				Assert.fail("Share Pay Page Not Displayed");
			}

			try
			{
				generalFunctions.isElementPresent(sharePayPage.payWithCreditCard, 40);
				if(sharePayPage.payWithCreditCard.isDisplayed()==true)
				{
					test.log(Status.PASS, "Pay With Credit Card Icon Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Pay With Credit Card Icon Not Displayed");
				Assert.fail("Pay With Credit Card Icon Not Displayed");
			}

			try
			{
				if(sharePayPage.payWithPoints.isDisplayed()==true)
				{
					test.log(Status.PASS, "Pay with Points Icon Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Pay With Points Icon Not Displayed");
				Assert.fail("Pay WithPoints Icon Not Displayed");
			}

			try
			{
				if(sharePayPage.payWithCardsAndPoints.isDisplayed()==true)
				{
					test.log(Status.PASS, "Pay with Card + Points Icon Displayed");
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Pay with Card + Points Icon Not Displayed");
				Assert.fail("Pay with Card + Points Icon Not Displayed");
			}


		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}		
	}

	////----PASSCODE---////

	//Verify New User is able to set up PIN on selecting Share Wallet - Add Card
	@Test
	public void TC_08_to_012(Method method) throws Exception {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "SharePay:Passcode setup").assignCategory("SHAREPAY");
		test.info("Verify New User is able to set up PIN on selecting Share Wallet - Add Card");
		System.out.println(TC_Method);
		SharePayPage sharePayPage = new SharePayPage(driver);
		SharePayFunctions sharePayFunctions = new SharePayFunctions();
		ProfilePage profilePage = new ProfilePage(driver);
		ProfileFunctions profileFunctions = new ProfileFunctions();
		//New User login
		sharePayFunctions.newUserPassPay();


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
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Continue Button Not Displayed");
			Assert.fail("Continue Button Not Displayed");
		}

		sharePayPage.OnBoardingContinue.click();
		Thread.sleep(4000);


		try
		{
			generalFunctions.isElementPresent(sharePayPage.AddANewCardLink, 60);
			if(sharePayPage.AddANewCardLink.isDisplayed()==true)
			{
				test.log(Status.PASS, "Add A New Card Link Displayed");
				sharePayPage.AddANewCardLink.click();
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Add A New Card Link Not Displayed");
			Assert.fail("Add A New Card Link Not Displayed");
		}


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


	//Verify New User is able to set up PIN later by selecting "SET UP PIN CODE LATER"
	//Verify User is not able to Proceed with Share Wallet - Add card without setting up PIN
	//run before tc_8 to 12
	@Test
	public void TC_22_to_23(Method method) throws Exception {
		try {
			String TC_Method = method.getName();
			test = extent.createTest(TC_Method);
			test.log(Status.INFO, "SharePay:Passcode setup").assignCategory("SHAREPAY");
			test.info("Verify New User is able to set up PIN later by selecting SET UP PIN CODE LATER");
			System.out.println(TC_Method);
			SharePayPage sharePayPage = new SharePayPage(driver);
			SharePayFunctions sharePayFunctions = new SharePayFunctions();
			ProfilePage profilePage = new ProfilePage(driver);
			ProfileFunctions profileFunctions = new ProfileFunctions();
			//New User login
			sharePayFunctions.newUserPassPay();


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
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Continue Button Not Displayed");
				Assert.fail("Continue Button Not Displayed");
			}

			sharePayPage.OnBoardingContinue.click();


			try
			{
				generalFunctions.isElementPresent(sharePayPage.AddANewCardLink, 60);
				if(sharePayPage.AddANewCardLink.isDisplayed()==true)
				{
					test.log(Status.PASS, "Add A New Card Link Displayed");
					sharePayPage.AddANewCardLink.click();
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Add A New Card Link Not Displayed");
				Assert.fail("Add A New Card Link Not Displayed");
			}


			if(generalFunctions.isElementPresent(profilePage.setupPinCode, 20)) {
				test.log(Status.PASS, " User is not able to Proceed with Share Wallet - Add card without setting up PIN").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}else {
				test.log(Status.FAIL, "The Passcode screen not displayed and user can able to add card").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			generalFunctions.isElementPresent(profilePage.setupPinCodeLater, 30);
			profilePage.setupPinCodeLater.click();

			if(generalFunctions.isElementPresent(sharePayPage.AddANewCardLink, 30)) {
				test.log(Status.PASS, "User navigates back to the Share Wallet Screen");
			}else{
				test.log(Status.FAIL, "Share Wallet Screen NOT displayed");
			}

		}catch(Exception e) {
			e.getCause();
			e.getMessage();
		}
	}

	//Verify Error message is displayed when PIN on the first set up screen does not match with the PIN on the confirm screen
	//run before tc_8 to 12
	@Test
	public void TC_19_35(Method method) throws Exception {
		try {
			String TC_Method = method.getName();
			test = extent.createTest(TC_Method);
			test.log(Status.INFO, "SharePay:Passcode setup").assignCategory("SHAREPAY");
			test.info("Verify Error message is displayed when PIN on the first set up screen does not match with the PIN on the confirm screen");
			System.out.println(TC_Method);
			SharePayPage sharePayPage = new SharePayPage(driver);
			SharePayFunctions sharePayFunctions = new SharePayFunctions();
			ProfilePage profilePage = new ProfilePage(driver);
			ProfileFunctions profileFunctions = new ProfileFunctions();
			//New User login
			sharePayFunctions.newUserPassPay();


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
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Continue Button Not Displayed");
				Assert.fail("Continue Button Not Displayed");
			}

			sharePayPage.OnBoardingContinue.click();
			Thread.sleep(4000);


			try
			{
				generalFunctions.isElementPresent(sharePayPage.AddANewCardLink, 60);
				if(sharePayPage.AddANewCardLink.isDisplayed()==true)
				{
					test.log(Status.PASS, "Add A New Card Link Displayed");
					sharePayPage.AddANewCardLink.click();
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Add A New Card Link Not Displayed");
				Assert.fail("Add A New Card Link Not Displayed");
			}


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

	//Verify New User is navigating to the previous screen when user clicks back arrow on any of the screens
	//run before tc_8 to 12
	@Test
	public void TC_24_25(Method method) throws Exception {
		try {
			String TC_Method = method.getName();
			test = extent.createTest(TC_Method);
			test.log(Status.INFO, "SharePay:Passcode setup").assignCategory("SHAREPAY");
			test.info("Verify User is navigating to the previous screen when he clicks back arrow on any of the screens");
			System.out.println(TC_Method);
			SharePayPage sharePayPage = new SharePayPage(driver);
			SharePayFunctions sharePayFunctions = new SharePayFunctions();
			ProfilePage profilePage = new ProfilePage(driver);
			ProfileFunctions profileFunctions = new ProfileFunctions();
			//New User login
			sharePayFunctions.newUserPassPay();


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
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Continue Button Not Displayed");
				Assert.fail("Continue Button Not Displayed");
			}

			sharePayPage.OnBoardingContinue.click();
			Thread.sleep(4000);


			try
			{
				generalFunctions.isElementPresent(sharePayPage.AddANewCardLink, 60);
				if(sharePayPage.AddANewCardLink.isDisplayed()==true)
				{
					test.log(Status.PASS, "Add A New Card Link Displayed");
					sharePayPage.AddANewCardLink.click();
				}
			}
			catch(Exception x)
			{
				test.log(Status.FAIL, "Add A New Card Link Not Displayed");
				Assert.fail("Add A New Card Link Not Displayed");
			}

			generalFunctions.isElementPresent(profilePage.setupPinCode, 30);
			profilePage.setupPinCode.click();
			generalFunctions.isElementPresent(profilePage.setUpPin, 30);
			profilePage.backButton.click();
			if(generalFunctions.isElementPresent(profilePage.setupPinCode, 30)) {
				test.log(Status.PASS, "User navigate back to the SET UP PIN CODE screen").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));

			}else {
				test.log(Status.FAIL, "User navigated to WRONG screen").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			profilePage.setupPinCode.click();
			generalFunctions.isElementPresent(profilePage.setUpPin, 30);
			profilePage.setUpPin.sendKeys("1234");
			Thread.sleep(500);
			generalFunctions.isElementPresent(profilePage.confirmPassScreen, 30);
			profilePage.backButton.click();
			//String toast = profilePage.pinErrortoast.getText();
			if(generalFunctions.isElementPresent(profilePage.setUpPin, 30)) {
				test.log(Status.PASS, "User navigate back to the previous screen");
			}else {
				test.log(Status.FAIL, "User not navigated to previous screen");
			}
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			Assert.fail(e.getMessage());
		}
	}

	//***************************Passcode for existing user**********************************//
	//Verify Enter PIN code screen is displayed if an existing user trying to add new card
	@Test
	public void TC_01_to_03(Method method) throws Exception {
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "SharePay:Passcode setup").assignCategory("SHAREPAY");
		test.info("Verify User is navigating to the previous screen when he clicks back arrow on any of the screens");
		System.out.println(TC_Method);
		SharePayPage sharePayPage = new SharePayPage(driver);
		SharePayFunctions sharePayFunctions = new SharePayFunctions();
		ProfilePage profilePage = new ProfilePage(driver);
		ProfileFunctions profileFunctions = new ProfileFunctions();
		//New User login
		//	sharePayFunctions.newUserPassPay();


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
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Continue Button Not Displayed");
			Assert.fail("Continue Button Not Displayed");
		}

		try
		{
			generalFunctions.isElementPresent(sharePayPage.addCardAgain, 60);
			if(sharePayPage.addCardAgain.isDisplayed()==true)
			{
				test.log(Status.PASS, "Add A New Card Displayed");
				sharePayPage.addCardAgain.click();
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Add A New Card is Not Displayed");
			Assert.fail("Add A New Card is Not Displayed");
		}

		generalFunctions.isElementPresent(profilePage.setUpPin, 30);
		profilePage.setUpPin.sendKeys("1234");
		Thread.sleep(500);
		if(generalFunctions.isElementPresent(profilePage.CardNumber, 30)) {
			test.log(Status.PASS, "The Add new card screen displayed");
		}else {
			test.log(Status.FAIL, "The Add new card screen NOT displayed");
		}

	}

	//Verify the error message is showing for incorrect pin
	@Test
	public void TC_80(Method method) throws Exception {
		//try {
			String TC_Method = method.getName();
			test = extent.createTest(TC_Method);
			test.log(Status.INFO, "SharePay:Passcode Error").assignCategory("SHAREPAY");
			test.info("Verify the error message is showing for incorrect pin");
			System.out.println(TC_Method);
			SharePayPage sharePayPage = new SharePayPage(driver);
			SharePayFunctions sharePayFunctions = new SharePayFunctions();
			ProfilePage profilePage = new ProfilePage(driver);
			ProfileFunctions profileFunctions = new ProfileFunctions();
			
			//New User login
			//	sharePayFunctions.newUserPassPay();

			//Call function for ShareWallet to Add card Payment
			sharePayFunctions.shareToAddPayment();
			generalFunctions.isElementPresent(profilePage.setUpPin, 30);
			profilePage.setUpPin.sendKeys("1243");
			Thread.sleep(500);
			//String toast = profilePage.pinErrortoast.getText();
			if(generalFunctions.isElementPresence(By.id("snackbar_text"), 30)) {
				test.log(Status.PASS, "Passcode Mismatch Error displayed: "+profileFunctions.toast());
			}else {
				test.log(Status.FAIL, "Passcode Mismatch Error is NOT displayed");
			}
//		}catch(Exception e) {
//			e.printStackTrace();
//			e.getCause();
//			Assert.fail(e.getMessage());
//		}
	}

}
