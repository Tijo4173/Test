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

public class AccountPage extends DriverSetUp  {

	AndroidDriver<AndroidElement> driver;

	public AccountPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);

	}

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Account']/android.widget.ImageView")
	public AndroidElement AccountIcon;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='settings']")
	public AndroidElement SettingsIcon;

	@AndroidFindBy(id = "edit_profile_button")
	public AndroidElement EditProfile;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='update_user_profile_title_dropdown']//android.widget.EditText[@resource-id='text_input_layout_input']")
	public AndroidElement EditProfileTitle;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='update_user_profile_first_name']//android.widget.EditText[@resource-id='text_input_layout_input']")
	public AndroidElement EditProfileFirstName;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='update_user_profile_surname']//android.widget.EditText[@resource-id='text_input_layout_input']")
	public AndroidElement EditProfileSurName;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='update_user_profile_phone_number']//android.widget.EditText[@resource-id='text_input_layout_input']")
	public AndroidElement EditProfilePhoneNum;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='update_user_profile_date_of_birth']//android.widget.EditText[@resource-id='text_input_layout_input']")
	public AndroidElement EditProfileDob;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='update_user_profile_nationality']//android.widget.EditText[@resource-id='text_input_layout_input']")
	public AndroidElement EditProfileNationality;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='update_user_profile_country_code_drop_down']//android.widget.EditText[@resource-id='text_input_layout_input']")
	public AndroidElement EditProfileCountryCode;

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='update_user_profile_save_changes_button']")
	public AndroidElement EditProfileSaveChanges;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='simple_dialog_answer_description']")
	public AndroidElement EditProfileSaveChangesMsg;

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='simple_dialog_answer_positive_button']")
	public AndroidElement EditProfileSaveChangesConfirm;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public AndroidElement NavigateBack;

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='simple_dialog_answer_positive_button']")
	public AndroidElement EditProfileDiscard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='simple_dialog_answer_description']")
	public AndroidElement EditProfileDiscardMsg;

	@AndroidFindBy(xpath = "//*[@class='android.widget.TextView']")
	public AndroidElement PageTitle;

	@AndroidFindBy(id = "reset_password_button")
	public AndroidElement ResetPassword;

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='text_input_layout_input']")
	public AndroidElement ResetPasswordEmail;

	@AndroidFindBy(id = "change_password_button")
	public AndroidElement ResetPasswordButton;

	@AndroidFindBy(id = "notifications_button")
	public AndroidElement Notifications;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='notification_settings_title']")
	public AndroidElement NotificationsText;

	@AndroidFindBy(id = "payment_methods_button")
	public AndroidElement PaymentMethods;

	@AndroidFindBy(id = "payment_methods_button")
	public AndroidElement AddCard;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='number_layout']//android.widget.EditText[@resource-id='edtPanCw']")
	public AndroidElement CardNumber;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='full_name_layout']//android.widget.EditText[@resource-id='edtFullNameCw']")
	public AndroidElement NameOnCard;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='expiry_layout']//android.widget.EditText[@resource-id='edtExpiryCw']")
	public AndroidElement Expiry;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='cvc_layout']//android.widget.EditText[@resource-id='edtCvcCw']")
	public AndroidElement CVV;

	@AndroidFindBy(id = "btnSubmitCw")
	public AndroidElement SaveCard;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='viewTextInputLayout']//android.widget.EditText[@resource-id='edtVerifyAmountCw']")
	public AndroidElement TransactionAmount;

	@AndroidFindBy(id = "edtSubmitVerifyCw")
	public AndroidElement SubmitTransactionAmount;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='viewTextMessage']")
	public AndroidElement InformationText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='payment_method_unverified_label']")
	public AndroidElement Unverified;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Delete Card\"]")
	public AndroidElement Delete;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='simple_dialog_answer_title']")
	public AndroidElement Confrimation;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='simple_dialog_answer_description']")
	public AndroidElement ConfrimationMessage;

	@AndroidFindBy(id = "simple_dialog_answer_positive_button")
	public AndroidElement confirm;

	@AndroidFindBy(id = "dialog_status_title")
	public AndroidElement Status;

	@AndroidFindBy(id = "dialog_primary_button")
	public AndroidElement Button;

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='dialog_primary_button']")
	public AndroidElement ThanksButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.google.android.gm:id/open_search_bar_text_view']")
	public AndroidElement SearchMail;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.google.android.gm:id/viewified_conversation_item_view' and @index='1']//android.widget.TextView[@resource-id='com.google.android.gm:id/subject']")
	public AndroidElement MailSubject;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.google.android.gm:id/viewified_conversation_item_view' and @index='1']//android.widget.TextView[@resource-id='com.google.android.gm:id/date']")
	public AndroidElement MailTime;

	@AndroidFindBy(id = "dialog_status_description")
	public AndroidElement err_status;

	@AndroidFindBy(id = "btnSubmitCw")
	public AndroidElement save_err;

	@AndroidFindBy(id = "txtPanError")
	public AndroidElement Invalid;

	@AndroidFindBy(id = "dialog_status_description")
	public AndroidElement error_message;

	@AndroidFindBy(id = "txtNameError")
	public AndroidElement Name_error;

	@AndroidFindBy(id = "txtExprError")
	public AndroidElement Expiry_error;

	@AndroidFindBy(id = "simple_dialog_answer_negative_button")
	public AndroidElement card_cancel;


	//manasa start

	//privacy policy

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='privacy_policy_button']")
	public AndroidElement privacy_icon;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy policy']")
	public AndroidElement privacy_policy;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	public AndroidElement back_navigate;


	//log out
	

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public AndroidElement BackButton;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='logout_button']")
	public AndroidElement logout_icon;

	@AndroidFindBy(id = "simple_dialog_answer_negative_button")
	public AndroidElement logout_neg;

	@AndroidFindBy(id = "simple_dialog_answer_positive_button")
	public AndroidElement logout_pos;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Already have an account? Sign In']")
	public AndroidElement start_page;

	@AndroidFindBy(id = "onboarding_already_have_account_view")
	public AndroidElement SignIn;

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='tutorial_tip_action_button']")
	public AndroidElement gotit;

	//relogin

	@AndroidFindBy(id = "home_screen_expanded_title")
	public AndroidElement relogin;

	//reset tutorial confirm and cancel

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Reset tutorial']")
	public AndroidElement reset_icon;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='CONFIRM']")
	public AndroidElement confirm_button;	

	@AndroidFindBy(xpath = "//android.widget.Button[@text='CANCEL']")
	public AndroidElement cancel_button;	

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
	public AndroidElement settings;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='simple_dialog_answer_description']")
	public AndroidElement ResetConfrimation;


	//terms and condition

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Terms and conditions']")
	public AndroidElement terms_cond;


	//manasa end


	public AndroidElement GetCardStatus(String CardNumber)
	{
		AndroidElement status = driver.findElementByXPath("//android.widget.TextView[@resource-id='payment_method_card_number' and contains(@text, '"+CardNumber+"')]//following::android.widget.TextView[@resource-id='payment_method_unverified_label']");
		return status;
	}

	public AndroidElement SelectCards(String CardNumber)
	{
		AndroidElement Cards = driver.findElementByXPath("//android.widget.TextView[@resource-id='payment_method_card_number' and contains(@text, '"+CardNumber+"')]");
		return Cards;
	}

	@AndroidFindBy(xpath = "//*[@class='android.widget.ImageButton']")
	public AndroidElement clickBack;

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='dialog_primary_button' and @text='TRY AGAIN']")
	public AndroidElement TryAgainButton;
	
	//About   
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='settings_item_label_text_view' and @text='About']")
	public AndroidElement Aboutclick;   

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='about_content_text']")
	public AndroidElement Aboutcontent;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='simple_dialog_answer_description']")
    public AndroidElement LogoutDescription;
   
   
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView]")
    public AndroidElement LogoutPageConfrim;
    
    //New feature_Sprint_20 to 23
    
    @AndroidFindBy(id = "item_myaccount_gift_points")
    public AndroidElement accountgift;
    
    @AndroidFindBy(id = "retrieve_my_club_points")
    public AndroidElement linktoMyClub;
    
    @AndroidFindBy(id = "my_club_card")
    public AndroidElement clubCardNumber;
    
    @AndroidFindBy(id = "my_club_card-error")
    public AndroidElement clubCardNumberError;
    
    @AndroidFindBy(id = "submit-btn")
    public AndroidElement NextButton;
}