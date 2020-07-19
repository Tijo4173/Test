package com.share.objectrepository;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import com.share.general.DriverSetUp;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class TransactionsPage extends DriverSetUp  {

	AndroidDriver<AndroidElement> driver;

	public TransactionsPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);

	}
	
	
	// V2 START
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ACCOUNT' and @resource-id='com.maf.sharesit:id/smallLabel']")
	public AndroidElement accountIcon;
	
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout//android.widget.TextView[@text='MY ACCOUNT']")
	public AndroidElement myAccountPage;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/tv_pending_title")
    public AndroidElement pendingTitle;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/tv_pending_header' and @text='Pending Receipts']")
	public AndroidElement pendingReceiptsSection;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup//android.widget.TextView[@resource-id='com.maf.sharesit:id/tvMerchantName']")
	public AndroidElement transactions;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='PENDING RECEIPTS']")
	public AndroidElement pendingReceiptsPage;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/recycler_pending_list")
    public AndroidElement pendingReceiptsList;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.sharesit:id/recycler_pending_list']//android.view.ViewGroup")
	public AndroidElement pendingReceipts;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.sharesit:id/recycler_pending_list']//android.view.ViewGroup[@index='0']")
	public AndroidElement firstPendingReceipt;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.sharesit:id/recycler_pending_list']//android.view.ViewGroup[@index='0']//android.widget.TextView[@resource-id='com.maf.sharesit:id/tv_pending_row_title']")
	public AndroidElement firstPendingReceiptTitle;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.maf.sharesit:id/toolbar']//android.widget.ImageButton[@content-desc='‎‏‎‎‎‎‎‏‎‏‏‏‎‎‎‎‎‏‎‎‏‎‎‎‎‏‏‏‏‏‎‏‏‎‏‏‎‎‎‎‏‏‏‏‏‏‏‎‏‏‏‏‏‎‏‎‎‏‏‎‏‎‎‎‎‎‏‏‏‎‏‎‎‎‎‎‏‏‎‏‏‎‎‏‎‏‎‏‏‏‏‏‎‎Navigate up‎‏‎‎‏‎']")
	public AndroidElement back;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/tv_title'and @text='NO TRANSACTIONS']")
	public AndroidElement noTransactions;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.maf.sharesit:id/toolbar']//android.widget.TextView")
	public AndroidElement pageTitle;
	
	@AndroidFindBy(xpath = "//android.view.View//android.widget.Image")
	public AndroidElement receiptImage;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup//android.widget.ImageView[@resource-id='com.maf.sharesit:id/ivMerchantLogo']")
	public AndroidElement transactionIcon;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup//android.widget.TextView[@resource-id='com.maf.sharesit:id/tvPoints']")
	public AndroidElement transactionPoints;
	
	
	
	
	// V2 END
	
	
	
	
}