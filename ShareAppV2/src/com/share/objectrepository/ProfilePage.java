package com.share.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.share.general.DriverSetUp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfilePage extends DriverSetUp {

	AndroidDriver<AndroidElement>driver;
	public ProfilePage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}



	@AndroidFindBy(id = "v_avatar")
	public AndroidElement avatar;

	@AndroidFindBy(id = "tv_full_name")
	public AndroidElement fullname;

	@AndroidFindBy(id = "tv_header_subtitle")
	public AndroidElement joiningDate;

	@AndroidFindBy(id = "tv_avatar")
	public AndroidElement AvatarName;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Personal Details']")
	public AndroidElement personalDetails;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Payment Methods']")
	public AndroidElement paymentMethods;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Notifications']")
	public AndroidElement notifications;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Reset Password']")
	public AndroidElement resetPassword;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Terms & Conditions']")
	public AndroidElement termsNconditions;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy Policy']")
	public AndroidElement privacyPolicy;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Logout']")
	public AndroidElement Logout;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text,'Version')]")
	public AndroidElement version;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text ='EDIT DETAILS']")
	public AndroidElement editDetails;

	@AndroidFindBy(id = "et_first_name")
	public AndroidElement editFName;

	@AndroidFindBy(id = "et_last_name")
	public AndroidElement editLName;

	@AndroidFindBy(id = "btn_continue")
	public AndroidElement upadateButton;

	@AndroidFindBy(id = "tv_card_number")
	public AndroidElement existCard;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='‎‏‎‎‎‎‎‏‎‏‏‏‎‎‎‎‎‏‎‎‏‎‎‎‎‏‏‏‏‏‎‏‏‎‏‏‎‎‎‎‏‏‏‏‏‏‏‎‏‏‏‏‏‎‏‎‎‏‏‎‏‎‎‎‎‎‏‏‏‎‏‎‎‎‎‎‏‏‎‏‏‎‎‏‎‏‎‏‏‏‏‏‎‎Navigate up‎‏‎‎‏‎']")
	public AndroidElement navigateBack;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Fingerprint']")
	public AndroidElement fingerprint;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='tv_custom_preference_title' and @text='Notifications']/following-sibling::android.widget.Switch[@resource-id='switch_custom_preference']")
	public AndroidElement notificationSwitch;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.android.settings:id/switch_text' and @text='Show notifications']/following-sibling::android.widget.Switch[@resource-id='com.android.settings:id/switch_widget']")
	public AndroidElement notificationsSettings;

	@AndroidFindBy(xpath = "//android.view.ViewGroup['8']/android.widget.Switch[@index='3'")
	public AndroidElement fingerprintSwitch;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='TERMS & CONDITIONS']")
	public AndroidElement termsNconditionsPage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='PRIVACY POLICY']")
	public AndroidElement privacyPolicyPage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id,'alertTitle']")
	public AndroidElement logoutConfirmation;

	@AndroidFindBy(id = "android:id/button1")
	public AndroidElement ConfirmYES;

	@AndroidFindBy(id = "alertTitle")
	public AndroidElement alertMessage;

	@AndroidFindBy(id = "android:id/button2")
	public AndroidElement confirmNO;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='RESET PASSWORD']")
	public AndroidElement ResetPasswordPage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CHECK YOUR EMAIL']")
	public AndroidElement checkYourEmail;

	@AndroidFindBy(id = "btn_send_again")
	public AndroidElement sendAgain;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='PAYMENT METHODS']")
	public AndroidElement paymentMethodsPage;

	@AndroidFindBy(id = "btn_add_payment_method")
	public AndroidElement addNewPaymentMethod;

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
	public AndroidElement doneButton;

	@AndroidFindBy(id = "edtVerifyAmountCw")
	public AndroidElement TransactionAmount;

	@AndroidFindBy(id = "edtSubmitVerifyCw")
	public AndroidElement SubmitTransactionAmount;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Verify')]")
	public AndroidElement verifyPage;


	@AndroidFindBy(id = "tv_verify")
	public AndroidElement getCardSt;

	public AndroidElement GetCardStatus(String CardNumber)
	{
		AndroidElement status = driver.findElementByXPath("//android.widget.TextView[@resource-id='tv_card_number' and contains(@text, '"+CardNumber+"')]//following::android.widget.TextView[@resource-id='tv_verify']");
		return status;
	}

	@AndroidFindBy(id = "tv_card_number")
	public AndroidElement SelectCard;

	public AndroidElement SelectCards(String CardNumber)
	{
		AndroidElement Cards = driver.findElementByXPath("//android.widget.TextView[@resource-id='tv_card_number' and contains(@text, '"+CardNumber+"')]");
		return Cards;
	}

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='viewToolbar']/android.widget.ImageButton")
	public AndroidElement goBack;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout//android.widget.ImageView")
	public AndroidElement backFromProfile;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SHARE PAY' and @resource-id='smallLabel']")
	public AndroidElement sharePay;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SHARE PAY']")
	public AndroidElement sharePayPage;

	@AndroidFindBy(id = "btn_continue")
	public AndroidElement continueButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SHARE WALLET']")
	public AndroidElement shareWalletPage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SHARE WALLET']/preceding-sibling::android.widget.ImageView")
	public AndroidElement backFromShareWallet;

	@AndroidFindBy(id = "action_edit")
	public AndroidElement editButton;

	@AndroidFindBy(id = "iv_delete")
	public AndroidElement deleteButton;

	public AndroidElement deleteCard(String CardNumber)
	{
		AndroidElement status = driver.findElementByXPath("//android.widget.TextView[contains@resource-id,'tv_card_number' and (@text, '"+CardNumber+"')]//following::android.widget.ImageView[@resource-id='iv_delete']");
		return status;
	}

	public AndroidElement CardInWallet(String CardNumber)
	{
		AndroidElement Cards = driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'tv_number') and @text= '"+CardNumber+"']");
		return Cards;
	}




	////-----Passcode---///

	@AndroidFindBy(id = "btn_pin_action")
	public AndroidElement setupPinCode;

	@AndroidFindBy(id = "btn_pin_cancel")
	public AndroidElement setupPinCodeLater;

	@AndroidFindBy(id ="txt_setup_pin")
	public AndroidElement setUpPin;

	@AndroidFindBy(id = "root_confirm_pin")
	public AndroidElement confirmPassScreen;

	@AndroidFindBy(id = "tv_pin_result_subtitle")
	public AndroidElement pinSuccess;

	@AndroidFindBy(id = "btn_pin_result_action")
	public AndroidElement pinDone;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@index='0']")
	public AndroidElement backButton;
	//ForgotPin

	@AndroidFindBy(id = "tv_forgot_pin")
	public AndroidElement forgotPin;

	@AndroidFindBy(id = "button2")
	public AndroidElement resetCancel;

	@AndroidFindBy(id = "button1")
	public AndroidElement resetResetPin;

	@AndroidFindBy(id = "message")
	public AndroidElement resetAlert;

	@AndroidFindBy(id = "tv_enter_pin_title")
	public AndroidElement resetSuccessAlert;

	@AndroidFindBy(id = "recycler_view")
	public AndroidElement profileFrame;

	//Toast
	public By pinErrorToast = By.id("snackbar_text");


	//Change PIN code

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Change PIN Code for SHARE PAY']")
	public AndroidElement changePin;

	@AndroidFindBy(id="root_verify_pin")
	public AndroidElement existingPinScreen;

	@AndroidFindBy(id = "message")
	public AndroidElement removeCardAlert;

	@AndroidFindBy(id = "button1")
	public AndroidElement yesOption;

	@AndroidFindBy(id = "button2")
	public AndroidElement noOption;

	@AndroidFindBy(id = "btn_forgot_pin_success")
	public AndroidElement pinChangeSuccess;

	@AndroidFindBy(className = "android.widget.ImageButton")
	public AndroidElement backImageButton;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='CANCEL']")
	public AndroidElement cancelBioinPasscode;

	@AndroidFindBy(id ="tv_enter_pin_title")
	public AndroidElement pincodeSetupscreens;
}
