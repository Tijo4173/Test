package com.share.objectrepository;

import org.openqa.selenium.support.PageFactory;

import com.share.general.DriverSetUp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SharePayPage extends DriverSetUp{

	AndroidDriver<AndroidElement>driver;

	public SharePayPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		System.out.println("Test: "+driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	// V2 START
	
//	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SHARE PAY' and @resource-id='smallLabel']")
//	public AndroidElement shareWalletButton;
	
	@AndroidFindBy(id = "option_home_pay")
	public AndroidElement shareWalletButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='textView13' and @text='HOW IT WORKS']")
    public AndroidElement OnBoarding;
	
	@AndroidFindBy(id = "btn_continue")
    public AndroidElement OnBoardingContinue;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SHARE WALLET']")
	public AndroidElement sharePayWallet;
	
//	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='tv_action' and @text='ADD A NEW CARD']")
//	public AndroidElement AddANewCardLink;
	
	@AndroidFindBy(id = "tv_action")
	public AndroidElement AddANewCardLink;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='tv_title' and @text='ADD CREDIT/DEBIT CARDS']")
	public AndroidElement AddANewDebitOrCreditCardText;
	
	@AndroidFindBy(id = "imageViewAddAction")
    public AndroidElement AddCardIcon;
	
	@AndroidFindBy(id = "tv_points_balance_value")
    public AndroidElement pointBalance;
	
	@AndroidFindBy(id = "tv_aed_value")
    public AndroidElement aedValue;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Add New Card']")
	public AndroidElement addNewCardPage;
	
	@AndroidFindBy(id = "edtPanCw")
	public AndroidElement CardNumber;

	@AndroidFindBy(id = "edtFullNameCw")
	public AndroidElement NameOnCard;

	@AndroidFindBy(id = "edtExpiryCw")
	public AndroidElement Expiry;

	@AndroidFindBy(id = "edtCvcCw")
	public AndroidElement CVC;
	
	@AndroidFindBy(id = "btnSubmitCw")
	public AndroidElement doneButon;
	
	@AndroidFindBy(id = "edtVerifyAmountCw")
	public AndroidElement TransactionAmount;
	
	@AndroidFindBy(id = "edtSubmitVerifyCw")
	public AndroidElement SubmitTransactionAmount;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Verify')]")
	public AndroidElement verifyPage;
	
	public AndroidElement GetCardStatus(String CardNumber)
	{
		AndroidElement status = driver.findElementByXPath("//android.widget.TextView[@resource-id='tv_card_number' and contains(@text, '"+CardNumber+"')]//following::android.widget.TextView[@resource-id='tv_verify']");
		return status;
	}
		
	public AndroidElement SelectCards(String CardNumber)
	{
		AndroidElement Cards = driver.findElementByXPath("//android.widget.TextView[@resource-id='tv_card_number' and contains(@text, '"+CardNumber+"')]");
		return Cards;
	}
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='viewToolbar']/android.widget.ImageButton")
	public AndroidElement goBack;
	
	
	public AndroidElement CardInWalletStatus(String CardNumber)
	{
		AndroidElement Cards = driver.findElementByXPath("//android.widget.TextView[@resource-id='tv_number' and contains(@text, '"+CardNumber+"')]//following::android.widget.TextView[@resource-id='tv_unverified']");
		return Cards;
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='tv_error_message' and @text='Location Access Required']")
	public AndroidElement locationAccessRequired;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='btn_done' and @text='SWITCH ON LOCATION']")
	public AndroidElement switchOnLocation;
	
	 @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_always_button' and @text='ALLOW ALL THE TIME']")
	 public AndroidElement AllowAllTheTime;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='tv_error_message' and @text='Bluetooth Access Required']")
	public AndroidElement bluetoothAccessRequired;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='btn_done' and @text='SWITCH ON BLUETOOTH']")
	public AndroidElement switchOnBluetooth;
		
	@AndroidFindBy(id = "ic_wallet_result_close")
	public AndroidElement closeAccess;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='tv_pay_cards']")
	public AndroidElement payWithCreditCard;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='tv_pay_points']")
	public AndroidElement payWithPoints;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='tv_pay_split']")
	public AndroidElement payWithCardsAndPoints;
	
	@AndroidFindBy(id = "imageViewAddAction")
	public AndroidElement addCardAgain;
	
	// V2 END
	

}
