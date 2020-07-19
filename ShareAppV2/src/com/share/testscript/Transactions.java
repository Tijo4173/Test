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

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.share.functions.RegistrationFunctions;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.AssistantPage;
import com.share.objectrepository.ProfilePage;
import com.share.objectrepository.SharePayPage;
import com.share.objectrepository.RegistrationPage;
import com.share.objectrepository.SignInPage;
import com.share.utility.Utilities;
import com.share.objectrepository.TransactionsPage;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Transactions extends DriverSetUp
{

	
	GeneralFunctions generalFunctions = new GeneralFunctions();
	

	@Test
	public void TC_01_02_07(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Transaction List");
		test.assignCategory("Transactions");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		TransactionsPage transactionsPage = new TransactionsPage(driver);
		
		String EmailAddress=map.get("TransactionUser").toString();
		String Password=map.get("TransactionUserPassword").toString();
		
		try
		
		{		
			
		driver.activateApp("com.maf.sharesit");
			
		generalFunctions.Logout();	
			
		//Login to the App				
		generalFunctions.SignIn(EmailAddress, Password, signInPage);
		
		// Click Experiences
		generalFunctions.isElementPresent(transactionsPage.accountIcon, 90);
		transactionsPage.accountIcon.click();
		Thread.sleep(5000);
				
		//Verify My Account page displayed
		try
		{
			generalFunctions.isElementPresent(transactionsPage.myAccountPage, 90);
			if(transactionsPage.myAccountPage.isDisplayed()==true)
			{
				test.log(Status.PASS, "My Account page Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "My Account page Not Displayed");
			Assert.fail("My Account page Not Displayed");
		}
		
		try
		{
			if(transactionsPage.pendingTitle.isDisplayed()==true)
			{
				test.log(Status.PASS, "PENDING Title Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "PENDING Title Not Displayed");
			Assert.fail("PENDING Title Not Displayed");
		}
		
		try
		{
			if(transactionsPage.pendingReceiptsSection.isDisplayed()==true)
			{
				test.log(Status.PASS, "Pending Receipts Section Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Pending Receipts Section Not Displayed");
			Assert.fail("Pending Receipts Section Not Displayed");
		}
		
		try
		{
			if(transactionsPage.transactions.isDisplayed()==true)
			{
				test.log(Status.PASS, "Transactions Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Transactions Not Displayed");
			Assert.fail("Transactions Not Displayed");
		}
		
		transactionsPage.pendingReceiptsSection.click();
		
		//Verify Pending Receipts Page displayed
		try
		{
			generalFunctions.isElementPresent(transactionsPage.pendingReceiptsPage, 90);
			if(transactionsPage.pendingReceiptsPage.isDisplayed()==true)
			{
				test.log(Status.PASS, "Pending Receipts page Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Pending Receipts page Not Displayed");
			Assert.fail("Pending Receipts page Not Displayed");
		}
		
		//Verify Pending Receipts List displayed
		try
		{
			if(transactionsPage.pendingReceipts.isDisplayed()==true)
			{
				test.log(Status.PASS, "Pending Receipts List Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Pending Receipts List Not Displayed");
			Assert.fail("Pending Receipts List Not Displayed");
		}
		
		transactionsPage.back.click();
		Thread.sleep(5000);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}		
	}
	
	
	@Test
	public void TC_01_08(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Transaction List");
		test.assignCategory("Transactions");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		TransactionsPage transactionsPage = new TransactionsPage(driver);
		
		String EmailAddress=map.get("TransactionUser").toString();
		String Password=map.get("TransactionUserPassword").toString();
		
		try
		
		{	
			
		driver.activateApp("com.maf.sharesit");
		
		generalFunctions.Logout();	
			
		//Login to the App				
		generalFunctions.SignIn(EmailAddress, Password, signInPage);
		
		// Click Experiences
		generalFunctions.isElementPresent(transactionsPage.accountIcon, 90);
		transactionsPage.accountIcon.click();
		Thread.sleep(5000);
				
		//Verify My Account page displayed
		try
		{
			generalFunctions.isElementPresent(transactionsPage.myAccountPage, 90);
			if(transactionsPage.myAccountPage.isDisplayed()==true)
			{
				test.log(Status.PASS, "My Account page Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "My Account page Not Displayed");
			Assert.fail("My Account page Not Displayed");
		}
		
		try
		{
			if(transactionsPage.pendingTitle.isDisplayed()==true)
			{
				test.log(Status.PASS, "PENDING Title Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "PENDING Title Not Displayed");
			Assert.fail("PENDING Title Not Displayed");
		}
		
		try
		{
			if(transactionsPage.pendingReceiptsSection.isDisplayed()==true)
			{
				test.log(Status.PASS, "Pending Receipts Section Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Pending Receipts Section Not Displayed");
			Assert.fail("Pending Receipts Section Not Displayed");
		}		
		
		transactionsPage.pendingReceiptsSection.click();
		
		//Verify Pending Receipts Page displayed
		try
		{
			generalFunctions.isElementPresent(transactionsPage.pendingReceiptsPage, 90);
			if(transactionsPage.pendingReceiptsPage.isDisplayed()==true)
			{
				test.log(Status.PASS, "Pending Receipts page Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Pending Receipts page Not Displayed");
			Assert.fail("Pending Receipts page Not Displayed");
		}
		
		//Verify Pending Receipts List displayed
		try
		{
			if(transactionsPage.pendingReceipts.isDisplayed()==true)
			{
				test.log(Status.PASS, "Pending Receipts List Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Pending Receipts List Not Displayed");
			Assert.fail("Pending Receipts List Not Displayed");
		}
		
		String ReceiptTitle=generalFunctions.getText(transactionsPage.firstPendingReceiptTitle);
		transactionsPage.firstPendingReceiptTitle.click();
		Thread.sleep(5000);
		
		try
		{
			if(transactionsPage.pageTitle.isDisplayed()==true)
			{
				test.log(Status.PASS, "Pending Receipts List Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Pending Receipts List Not Displayed");
			Assert.fail("Pending Receipts List Not Displayed");
		}
		
		String ReceiptPagetitle=generalFunctions.getText(transactionsPage.pageTitle);
		if(ReceiptPagetitle.contains(ReceiptTitle))
		{
			test.log(Status.PASS, "Pending Receipts image page Displayed");
		}
		else
		{
			test.log(Status.FAIL, "Pending Receipts image page Not Displayed");
			Assert.fail("Pending Receipts image page Not Displayed");
		}
			
		try
		{
			if(transactionsPage.receiptImage.isDisplayed()==true)
			{
				test.log(Status.PASS, "Pending Receipts Image Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Pending Receipts Image Not Displayed");
			Assert.fail("Pending Receipts Image Not Displayed");
		}
		
		transactionsPage.back.click();
		Thread.sleep(5000);
		
		try
		{
			generalFunctions.isElementPresent(transactionsPage.pendingReceiptsPage, 90);
			if(transactionsPage.pendingReceiptsPage.isDisplayed()==true)
			{
				test.log(Status.PASS, "Pending Receipts page Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Pending Receipts page Not Displayed");
			Assert.fail("Pending Receipts page Not Displayed");
		}
		
		transactionsPage.back.click();
		Thread.sleep(5000);
		
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
		test.log(Status.INFO, "Transaction List");
		test.assignCategory("Transactions");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		TransactionsPage transactionsPage = new TransactionsPage(driver);
		
		String EmailAddress=map.get("UserName").toString();
		String Password=map.get("UserPassword").toString();
		
		try
		
		{		
			
		driver.activateApp("com.maf.sharesit");
			
		generalFunctions.Logout();	
			
		//Login to the App				
		generalFunctions.SignIn(EmailAddress, Password, signInPage);
		
		// Click Experiences
		generalFunctions.isElementPresent(transactionsPage.accountIcon, 90);
		transactionsPage.accountIcon.click();
		Thread.sleep(5000);
				
		//Verify My Account page displayed
		try
		{
			generalFunctions.isElementPresent(transactionsPage.myAccountPage, 90);
			if(transactionsPage.myAccountPage.isDisplayed()==true)
			{
				test.log(Status.PASS, "My Account page Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "My Account page Not Displayed");
			Assert.fail("My Account page Not Displayed");
		}
		
		try
		{
			if(transactionsPage.pendingTitle.isDisplayed()==true)
			{
				test.log(Status.PASS, "PENDING Title Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "PENDING Title Not Displayed");
			Assert.fail("PENDING Title Not Displayed");
		}
		
		try
		{
			if(transactionsPage.pendingReceiptsSection.isDisplayed()==true)
			{
				test.log(Status.PASS, "Pending Receipts Section Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Pending Receipts Section Not Displayed");
			Assert.fail("Pending Receipts Section Not Displayed");
		}
		
		try
		{
			if(transactionsPage.noTransactions.isDisplayed()==true)
			{
				test.log(Status.PASS, "No Transactions Message Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "No Transactions Message Not Displayed");
			Assert.fail("No Transactions Message Not Displayed");
		}
		
		
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
		test.log(Status.INFO, "Transaction List");
		test.assignCategory("Transactions");
		System.out.println(TC_Method);

		SignInPage signInPage = new SignInPage(driver);
		TransactionsPage transactionsPage = new TransactionsPage(driver);
		
		String EmailAddress=map.get("TransactionUser").toString();
		String Password=map.get("TransactionUserPassword").toString();
		
		try
		
		{	
		
		driver.activateApp("com.maf.sharesit");
			
		generalFunctions.Logout();	
			
		//Login to the App				
		generalFunctions.SignIn(EmailAddress, Password, signInPage);
		
		// Click Experiences
		generalFunctions.isElementPresent(transactionsPage.accountIcon, 90);
		transactionsPage.accountIcon.click();
		Thread.sleep(5000);
				
		//Verify My Account page displayed
		try
		{
			generalFunctions.isElementPresent(transactionsPage.myAccountPage, 90);
			if(transactionsPage.myAccountPage.isDisplayed()==true)
			{
				test.log(Status.PASS, "My Account page Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "My Account page Not Displayed");
			Assert.fail("My Account page Not Displayed");
		}
		
		try
		{
			if(transactionsPage.pendingTitle.isDisplayed()==true)
			{
				test.log(Status.PASS, "PENDING Title Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "PENDING Title Not Displayed");
			Assert.fail("PENDING Title Not Displayed");
		}
		
		try
		{
			if(transactionsPage.pendingReceiptsSection.isDisplayed()==true)
			{
				test.log(Status.PASS, "Pending Receipts Section Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Pending Receipts Section Not Displayed");
			Assert.fail("Pending Receipts Section Not Displayed");
		}
		
		try
		{
			if(transactionsPage.transactions.isDisplayed()==true)
			{
				test.log(Status.PASS, "Transactions Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Transactions Not Displayed");
			Assert.fail("Transactions Not Displayed");
		}
		
		try
		{
			if(transactionsPage.transactionIcon.isDisplayed()==true)
			{
				test.log(Status.PASS, "Sponsor icon Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Sponsor icon Not Displayed");
			Assert.fail("Sponsor icon Not Displayed");
		}
		
		try
		{
			if(transactionsPage.transactionPoints.isDisplayed()==true)
			{
				test.log(Status.PASS, "Sponsor Point Displayed");
			}
		}
		catch(Exception x)
		{
			test.log(Status.FAIL, "Sponsor Point Not Displayed");
			Assert.fail("Sponsor Point Not Displayed");
		}
		
		String Point =generalFunctions.getText(transactionsPage.transactionPoints);
		if(Point.contains("+")||Point.contains("-"))
		{
			test.log(Status.PASS, "Sponsor Point Contains + or -");
		}
		else
		{
			test.log(Status.FAIL, "Sponsor Point Not Contains + or -");
			Assert.fail("Sponsor Point Not Contains + or -");
		}
		
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}		
	}
	
	
	
	
	
	
}
