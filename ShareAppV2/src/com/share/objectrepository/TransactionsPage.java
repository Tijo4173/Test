package com.share.objectrepository;
import org.openqa.selenium.support.PageFactory;

import com.share.general.DriverSetUp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TransactionsPage extends DriverSetUp  {

	AndroidDriver<AndroidElement> driver;

	public TransactionsPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	// V2 START

	@AndroidFindBy(id = "option_home_account")
	public AndroidElement accountIcon;

	@AndroidFindBy(id = "tv_account_title")
	public AndroidElement myAccountPage;

	@AndroidFindBy(id = "tv_pending_header")
    public AndroidElement pendingTitle;

	@AndroidFindBy(id = "tv_pending_header")
	public AndroidElement pendingReceiptsSection;

	@AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.TextView[contains(@resource-id,'tvMerchantName')]")
	public AndroidElement transactions;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='PENDING RECEIPTS']")
	public AndroidElement pendingReceiptsPage;

	@AndroidFindBy(id = "recycler_pending_list")
    public AndroidElement pendingReceiptsList;

	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView['0']/android.view.ViewGroup[@index='0']")
	public AndroidElement pendingReceipts;

	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView['0']/android.view.ViewGroup[@index='0']")
	public AndroidElement firstPendingReceipt;

	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView['0']/android.view.ViewGroup['0']/android.widget.TextView[@index='0']")
	public AndroidElement firstPendingReceiptTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tv_title'and @text='NO TRANSACTIONS')]")
	public AndroidElement noTransactions;

	@AndroidFindBy(className = "android.widget.TextView")
	public AndroidElement pageTitle;

	@AndroidFindBy(xpath = "//android.view.View//android.widget.Image")
	public AndroidElement receiptImage;

	@AndroidFindBy(id = "tvMerchantName")
	public AndroidElement transactionIcon;

	@AndroidFindBy(id = "tvPoints")
	public AndroidElement transactionPoints;

	@AndroidFindBy(accessibility = "‎‏‎‎‎‎‎‏‎‏‏‏‎‎‎‎‎‏‎‎‏‎‎‎‎‏‏‏‏‏‎‏‏‎‏‏‎‎‎‎‏‏‏‏‏‏‏‎‏‏‏‏‏‎‏‎‎‏‏‎‏‎‎‎‎‎‏‏‏‎‏‎‎‎‎‎‏‏‎‏‏‎‎‏‎‏‎‏‏‏‏‏‎‎Navigate up‎‏‎‎‏‎")
	public AndroidElement backButton;

	@AndroidFindBy(id = "tvDate")
	public AndroidElement transactionsdate;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='TODAY']")
	public AndroidElement transactiontodaylabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Points shared']")
	public AndroidElement pointsShared;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='TRANSACTION DETAILS']")
	public AndroidElement transactionDetailspage;
	
	//transaction detail page
	@AndroidFindBy(id = "transaction_details")
	public AndroidElement pointsSharedlabelindetailpage;
	
	@AndroidFindBy(id = "tv_transaction_subtitle")
	public AndroidElement pointsSharedmember;
	
	@AndroidFindBy(id = "tv_declined")
	public AndroidElement sharedPoints;
	
	@AndroidFindBy(id = "tv_transaction_details_value")
	public AndroidElement sharedPointsinAED;
	
	@AndroidFindBy(id = "tv_transaction_date")
	public AndroidElement sharedPointsdateandtime;
	
	@AndroidFindBy(id = "tv_declined_header")
    public AndroidElement declineTitle;
	
	@AndroidFindBy(id = "tv_declined_header")
    public AndroidElement declineReceiptsection;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='DECLINED RECEIPTS']")
	public AndroidElement declinedReceiptsPage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.dl.sharesit:id/tv_pending_row_title']")
	public AndroidElement declineReceiptslist;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.dl.sharesit:id/tv_pending_row_subtitle']")
	public AndroidElement declineReceiptsdateandtime;
		
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView['0']/android.view.ViewGroup[@index='0']")
	public AndroidElement declinefirstReceipt;
	
	@AndroidFindBy(id = "iv_transaction_details_logo")
    public AndroidElement declineReceiptTransactionlogo;
	
	@AndroidFindBy(id = "tv_transaction_title")
    public AndroidElement declineReceiptTransactionTitle;
	
	@AndroidFindBy(id = "tv_transaction_date")
    public AndroidElement declineReceiptTransactiondate;
	
	@AndroidFindBy(id = "include3")
    public AndroidElement declineReceiptview;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView")
    public AndroidElement declinedReceiptmessage;
	
}