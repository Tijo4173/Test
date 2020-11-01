package com.share.testscript;
import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.share.functions.SignInFunctions;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.TransactionsPage;
import com.share.utility.Utilities;

public class Transactions extends DriverSetUp
{

	GeneralFunctions generalFunctions = new GeneralFunctions();

	//Verify user able to view transaction account and pending receipts
	@Test
	public void TC_Transactions_01_02_04(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Transaction List");
		test.info("Verify user able to view transaction account and pending receipts");
		test.assignCategory("TRANSACTIONS");
		System.out.println(TC_Method);
		TransactionsPage transactionsPage = new TransactionsPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{	driver.resetApp();
			signInFunctions.SignContinue();//For sprint 18
			signInFunctions.quickSignIn();

			// Click Account
			generalFunctions.isElementPresent(transactionsPage.accountIcon, 90);
			transactionsPage.accountIcon.click();
			Thread.sleep(5000);

			//Verify My Account page displayed
			if(generalFunctions.isElementPresent(transactionsPage.myAccountPage, 90))
			{
				test.log(Status.PASS, "My Account page Displayed");
			}
			else
			{
				test.log(Status.FAIL, "My Account page Not Displayed");
				Assert.fail("My Account page Not Displayed");
			}
			if(generalFunctions.isElementPresent(transactionsPage.pendingTitle, 30))
			{
				test.log(Status.PASS, "PENDING Title Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "PENDING Title Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("PENDING Title Not Displayed");
			}

			if(generalFunctions.isElementPresent(transactionsPage.pendingReceiptsSection, 30))
			{
				test.log(Status.PASS, "Pending Receipts Section Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Pending Receipts Section Not Displayed");
				Assert.fail("Pending Receipts Section Not Displayed");
			}

			if(generalFunctions.isElementPresent(transactionsPage.transactionsdate, 30))
			{
				test.log(Status.PASS, "Transactions Date Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Transactions Date Not Displayed");
				Assert.fail("Transactions Date Not Displayed");
			}

			if(generalFunctions.isElementPresent(transactionsPage.transactions, 30))
			{
				test.log(Status.PASS, "Transactions Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Transactions Not Displayed");
				Assert.fail("Transactions Not Displayed");
			}

			transactionsPage.pendingReceiptsSection.click();

			//Verify Pending Receipts Page displayed
			if(generalFunctions.isElementPresent(transactionsPage.pendingReceiptsPage, 90))
			{
				test.log(Status.PASS, "Pending Receipts page Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Pending Receipts page Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Pending Receipts page Not Displayed");
			}

			//Verify Pending Receipts List displayed
			if(generalFunctions.isElementPresent(transactionsPage.pendingReceipts, 30))
			{
				test.log(Status.PASS, "Pending Receipts List Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Pending Receipts List Not Displayed");
				Assert.fail("Pending Receipts List Not Displayed");
			}

			transactionsPage.backButton.click();
			generalFunctions.isElementPresent(transactionsPage.myAccountPage, 90);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}


	@Test
	public void TC_Transactions_05(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Transaction List");
		test.assignCategory("TRANSACTIONS");
		test.info("Verify user able to view pending receipts and pending receipts list an verfy the image");
		System.out.println(TC_Method);
		TransactionsPage transactionsPage = new TransactionsPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{	driver.resetApp();
			signInFunctions.SignContinue();//For sprint 18
			signInFunctions.quickSignIn();
			// Click Experiences
			generalFunctions.isElementPresent(transactionsPage.accountIcon, 90);
			transactionsPage.accountIcon.click();
			Thread.sleep(5000);

			//Verify My Account page displayed
			if(generalFunctions.isElementPresent(transactionsPage.myAccountPage, 90))
			{
				test.log(Status.PASS, "My Account page Displayed");
			}
			else
			{
				test.log(Status.FAIL, "My Account page Not Displayed");
				Assert.fail("My Account page Not Displayed");
			}
			if(generalFunctions.isElementPresent(transactionsPage.pendingTitle, 30))
			{
				test.log(Status.PASS, "PENDING Title Displayed");
			}
			else
			{
				test.log(Status.FAIL, "PENDING Title Not Displayed");
				Assert.fail("PENDING Title Not Displayed");
			}
			if(generalFunctions.isElementPresent(transactionsPage.pendingReceiptsSection, 30))
			{
				test.log(Status.PASS, "Pending Receipts Section Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Pending Receipts Section Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Pending Receipts Section Not Displayed");
			}

			transactionsPage.pendingReceiptsSection.click();

			//Verify Pending Receipts Page displayed

			if(generalFunctions.isElementPresent(transactionsPage.pendingReceiptsPage, 90))
			{
				test.log(Status.PASS, "Pending Receipts page Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Pending Receipts page Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Pending Receipts page Not Displayed");
			}

			//Verify Pending Receipts List displayed
			if(generalFunctions.isElementPresent(transactionsPage.pendingReceipts, 30))
			{
				test.log(Status.PASS, "Pending Receipts List Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Pending Receipts List Not Displayed");
				Assert.fail("Pending Receipts List Not Displayed");
			}

			String ReceiptTitle=generalFunctions.getText(transactionsPage.firstPendingReceiptTitle);
			transactionsPage.firstPendingReceiptTitle.click();
			Thread.sleep(1000);

			if(generalFunctions.isElementPresent(transactionsPage.pageTitle, 30))
			{
				test.log(Status.PASS, "Pending Receipts List Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Pending Receipts List Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Pending Receipts List Not Displayed");
			}

			String ReceiptPagetitle=generalFunctions.getText(transactionsPage.pageTitle);
			if(ReceiptPagetitle.contains(ReceiptTitle))
			{
				test.log(Status.PASS, "Pending Receipts image page Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Pending Receipts image page Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Pending Receipts image page Not Displayed");
			}

			if(generalFunctions.isElementPresent(transactionsPage.receiptImage, 30))
			{
				test.log(Status.PASS, "Pending Receipts Image Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Pending Receipts Image Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Pending Receipts Image Not Displayed");
			}

			transactionsPage.backButton.click();

			if(generalFunctions.isElementPresent(transactionsPage.pendingReceiptsPage, 30))
			{
				test.log(Status.PASS, "Pending Receipts page Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Pending Receipts page Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			//	Assert.fail("Pending Receipts page Not Displayed");
			}

			transactionsPage.backButton.click();
			generalFunctions.isElementPresent(transactionsPage.myAccountPage, 90);

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}


	@Test
	public void TC_Transactions_03(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Transaction List");
		test.assignCategory("TRANSACTIONS");
		test.info("Verify user able to view pending receipts section and declined receipts section");
		System.out.println(TC_Method);
		TransactionsPage transactionsPage = new TransactionsPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{	driver.resetApp();
			signInFunctions.SignContinue();//For sprint 18
			signInFunctions.quickSignIn();
			// Click Experiences
			generalFunctions.isElementPresent(transactionsPage.accountIcon, 90);
			transactionsPage.accountIcon.click();
			Thread.sleep(3000);
			//Verify My Account page displayed
			if(generalFunctions.isElementPresent(transactionsPage.myAccountPage, 90))
			{
				test.log(Status.PASS, "My Account page Displayed");
			}
			else
			{
				test.log(Status.FAIL, "My Account page Not Displayed");
				Assert.fail("My Account page Not Displayed");
			}

			if(generalFunctions.isElementPresent(transactionsPage.pendingTitle, 30))
			{
				test.log(Status.PASS, "PENDING Title Displayed");
			}
			else
			{
				test.log(Status.FAIL, "PENDING Title Not Displayed");
				Assert.fail("PENDING Title Not Displayed");
			}

			if(generalFunctions.isElementPresent(transactionsPage.pendingReceiptsSection, 30))
			{
				test.log(Status.PASS, "Pending Receipts Section Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Pending Receipts Section Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Pending Receipts Section Not Displayed");
			}
			
			if(generalFunctions.isElementPresent(transactionsPage.declineReceiptsection, 30))
			{
				test.log(Status.PASS, "Declined Receipts Section Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Decline Receipts Section Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}


	@Test
	public void TC_Transactions_06(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Transaction List");
		test.assignCategory("TRANSACTIONS");
		test.info("Verify user able to view pending receipts section with points and sponsor logo");
		System.out.println(TC_Method);
		TransactionsPage transactionsPage = new TransactionsPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{	driver.resetApp();
			signInFunctions.SignContinue();//For sprint 18
			signInFunctions.quickSignIn();
			// Click Experiences
			generalFunctions.isElementPresent(transactionsPage.accountIcon, 90);
			transactionsPage.accountIcon.click();
			Thread.sleep(2000);

			//Verify My Account page displayed
			if(generalFunctions.isElementPresent(transactionsPage.myAccountPage, 90))
			{
				test.log(Status.PASS, "My Account page Displayed");
			}
			else
			{
				test.log(Status.FAIL, "My Account page Not Displayed");
				Assert.fail("My Account page Not Displayed");
			}
			if(generalFunctions.isElementPresent(transactionsPage.pendingTitle, 30))
			{
				test.log(Status.PASS, "PENDING Title Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "PENDING Title Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("PENDING Title Not Displayed");
			}
			if(generalFunctions.isElementPresent(transactionsPage.pendingReceiptsSection, 30))
			{
				test.log(Status.PASS, "Pending Receipts Section Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Pending Receipts Section Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Pending Receipts Section Not Displayed");
			}
			if(generalFunctions.isElementPresent(transactionsPage.transactions, 30))
			{
				test.log(Status.PASS, "Transactions Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Transactions Not Displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Transactions Not Displayed");
			}
			if(generalFunctions.isElementPresent(transactionsPage.transactionIcon, 30))
			{
				test.log(Status.PASS, "Sponsor Name Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Sponsor Name Not Displayed");
				Assert.fail("Sponsor Name Not Displayed");
			}
			if(generalFunctions.isElementPresent(transactionsPage.transactionPoints, 30))
			{
				test.log(Status.PASS, "Sponsor Point Displayed");
			}
			else
			{
				test.log(Status.FAIL, "Sponsor Point Not Displayed");
				Assert.fail("Sponsor Point Not Displayed");
			}
			String Point =generalFunctions.getText(transactionsPage.transactionPoints);
			if(Point.contains("+")||Point.contains("-"))
			{
				test.log(Status.PASS, "Sponsor Point Contains '+' or '-'").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Sponsor Point Not Contains '+' or '-'").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
				Assert.fail("Sponsor Point Not Contains '+' or '-'");
			}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC_Transactions_07(Method method) throws Exception
	{
		String TC_Method = method.getName();
		test = extent.createTest(TC_Method);
		test.log(Status.INFO, "Transaction List");
		test.assignCategory("TRANSACTIONS");
		test.info("Verify user able to view Decline receipts and declined reciepts list");
		System.out.println(TC_Method);
		TransactionsPage transactionsPage = new TransactionsPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		try
		{	driver.resetApp();
			signInFunctions.SignContinue();//For sprint 18
			signInFunctions.quickSignIn();
			// Click Experiences
			generalFunctions.isElementPresent(transactionsPage.accountIcon, 90);
			transactionsPage.accountIcon.click();
			Thread.sleep(5000);

			//Verify My Account page displayed
			if(generalFunctions.isElementPresent(transactionsPage.myAccountPage, 90))
			{
				test.log(Status.PASS, "My account page displayed");
			}
			else
			{
				test.log(Status.FAIL, "My account page Not displayed");
			}
			if(generalFunctions.isElementPresent(transactionsPage.declineTitle, 30))
			{
				test.log(Status.PASS, "Declined transactions title displayed");
			}
			else
			{
				test.log(Status.FAIL, "Declined transactions Title not displayed");
			}
			if(generalFunctions.isElementPresent(transactionsPage.declineReceiptsection, 30))
			{
				test.log(Status.PASS, "Declined receipts section displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Declined receipts section not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}

			transactionsPage.declineReceiptsection.click();
			if(generalFunctions.isElementPresent(transactionsPage.declinedReceiptsPage, 90))
			{
				test.log(Status.PASS, "Declined receipts page displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Declined receipts page not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}

			if(generalFunctions.isElementPresent(transactionsPage.declineReceiptslist, 30))
			{
				test.log(Status.PASS, "Declined receipts list displayed");
			}
			else
			{
				test.log(Status.FAIL, "Declined receipts list not displayed");
			}
			
			if(generalFunctions.isElementPresent(transactionsPage.declineReceiptsdateandtime, 30))
			{
				test.log(Status.PASS, "Declined receipts date and time displayed");
			}
			else
			{
				test.log(Status.FAIL, "Declined receipts date and time not displayed");
			}
			transactionsPage.declinefirstReceipt.click();
			Thread.sleep(1000);
			if(generalFunctions.isElementPresent(transactionsPage.transactionDetailspage, 30))
			{
				test.log(Status.PASS, "Transaction details page displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Transaction details page not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			if(generalFunctions.isElementPresent(transactionsPage.declineReceiptTransactionlogo, 30))
			{
				test.log(Status.PASS, "Decline transaction logo displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			else
			{
				test.log(Status.FAIL, "Decline transaction logo not displayed").addScreenCaptureFromPath(Utilities.getScreenshot(driver, TC_Method));
			}
			if(generalFunctions.isElementPresent(transactionsPage.declineReceiptTransactionTitle, 30))
			{
				test.log(Status.PASS, "Decline transaction title displayed");
			}
			else
			{
				test.log(Status.FAIL, "Decline transaction title not displayed");
			}
			if(generalFunctions.isElementPresent(transactionsPage.declineReceiptTransactiondate, 30))
			{
				test.log(Status.PASS, "Decline transaction date and time displayed");
			}
			else
			{
				test.log(Status.FAIL, "Decline transaction date and time not displayed");
			}
			if(generalFunctions.isElementPresent(transactionsPage.declineReceiptview, 30))
			{
				test.log(Status.PASS, "Decline transaction receipt view section displayed");
			}
			else
			{
				test.log(Status.FAIL, "Decline transaction receipt view section not displayed");
			}
			if(generalFunctions.isElementPresent(transactionsPage.declinedReceiptmessage, 30))
			{
				test.log(Status.PASS, "Receipt declined message displayed");
			}
			else
			{
				test.log(Status.FAIL, "Receipt declined message displayed not displayed");
			}
			transactionsPage.declineReceiptview.click();
			Thread.sleep(1000);
			if(generalFunctions.isElementPresent(transactionsPage.receiptImage, 30))
			{
				test.log(Status.PASS, "Declined receipt image displayed");
			}
			else
			{
				test.log(Status.FAIL, "Declined receipt image not displayed");
			}
			transactionsPage.backButton.click();
			transactionsPage.backButton.click();
			transactionsPage.backButton.click();
			
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

}
