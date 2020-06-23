package com.share.objectrepository;

import org.openqa.selenium.support.PageFactory;

import com.share.general.DriverSetUp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends DriverSetUp {

	AndroidDriver<AndroidElement> driver;

	public HomePage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);

	}

	//tc_home_006
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/home_screen_offer_list_title']")
	public AndroidElement offertitleinhomepage;

	@AndroidFindBy(id ="com.maf.sharesit:id/home_screen_offer_title")
	public AndroidElement offertitleclick;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/offer_details_title']")
	public AndroidElement offertitleinofferdetailpage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/offer_banner_title']")
	public AndroidElement offertitleinactiavtedtab;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/offer_details_share']")
	public AndroidElement offerdetailshare;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/offer_details_like']")
	public AndroidElement offerdetaillike;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/offers_tab_button_text' and @text='ACTIVATED']")
	public AndroidElement ActivatedTab;

	@AndroidFindBy(xpath = "(//android.widget.ImageButton[@content-desc=\"Add to favorites\"])[1]")
	public AndroidElement ActivatetickINaActiavtedtab;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/no_offers_text_vies']")
	public AndroidElement NoOffersText;
	
	public String VerifyOffer(String ElementText)
	{ 
		String Xpath="//android.widget.TextView[@resource-id='com.maf.sharesit:id/offer_banner_title' and @text='"+ElementText+"']";
		return Xpath;
	}

	@AndroidFindBy(id = "com.maf.sharesit:id/tv_shop_online")
	public AndroidElement homeShopEarn;


	//tc_home_001 
	@AndroidFindBy(id = "com.maf.sharesit:id/home_screen_expanded_title")
	public AndroidElement home_title;

	@AndroidFindBy(id = "com.maf.sharesit:id/home_screen_expanded_points_balance")
	public AndroidElement home_points;

	@AndroidFindBy(id = "com.maf.sharesit:id/home_screen_expanded_value_aed")
	public AndroidElement home_currency;


	@AndroidFindBy(id = "com.maf.sharesit:id/v_avatar")
	public AndroidElement avatarHome;

	//Submit Receipt
	@AndroidFindBy(id = "com.maf.sharesit:id/option_home_home")
	public AndroidElement homeElement;

	@AndroidFindBy(id ="com.maf.sharesit:id/iv_home_feature_submit_receipt")
	public AndroidElement receiptCamera;

	@AndroidFindBy(id = "com.maf.sharesit:id/tv_home_user_name")
	public AndroidElement userName;

	@AndroidFindBy(id= "com.maf.sharesit:id/tv_home_points_balance")
	public AndroidElement pointsBalance;

	@AndroidFindBy(id= "com.maf.sharesit:id/tv_home_points")
	public AndroidElement pointshome;

	@AndroidFindBy(id= "com.maf.sharesit:id/tv_home_points_value")
	public AndroidElement pointsAed;

	@AndroidFindBy(id= "com.maf.sharesit:id/iv_home_feature_family")
	public AndroidElement myFamily;

	@AndroidFindBy(id = "com.maf.sharesit:id/home_screen_hint_messages_viewpager")
	public AndroidElement scrollView;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'EXPERIENCES')and @clickable='true']")
	public AndroidElement homeExperiences;

	@AndroidFindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab[@index='1']")
	public AndroidElement homeScrollb;

	@AndroidFindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab[@index='2']")
	public AndroidElement homeScrollc;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@index='0']")
	public AndroidElement offersList;

	@AndroidFindBy(id = "com.maf.sharesit:id/offer_details_share")
	public AndroidElement offersShare;

	@AndroidFindBy(id = "com.maf.sharesit:id/offer_details_like")
	public AndroidElement offersActivate;

	@AndroidFindBy(id = "com.maf.sharesit:id/cb_dont_show_again")
	public AndroidElement introCheckbox;

	@AndroidFindBy(id = "com.maf.sharesit:id/btn_skip")
	public AndroidElement introSkip;

	@AndroidFindBy(id = "com.maf.sharesit:id/btn_next")
	public AndroidElement introNext;

	@AndroidFindBy(xpath = "//com.maf.sharesit:id/btn_next[@text='DONE']")
	public AndroidElement introDone;

	@AndroidFindBy(id = "com.maf.sharesit:id/info")
	public AndroidElement introInfo;


	@AndroidFindBy(id = "com.maf.sharesit:id/bt_allow")
	public AndroidElement allowAccess;

	@AndroidFindBy(id = "com.maf.sharesit:id/bt_not_now")
	public AndroidElement denyAccess;

	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	public AndroidElement allowPermission;

	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
	public AndroidElement denyPermission;

	@AndroidFindBy(id = "com.maf.sharesit:id/iv_close")
	public AndroidElement cameraClose;

	@AndroidFindBy(id = "com.maf.sharesit:id/tv_normal_receipt_type")
	public AndroidElement normalReceiptButton;

	@AndroidFindBy(id = "com.maf.sharesit:id/tv_long_receipt_type")
	public AndroidElement longReceiptButton;

	@AndroidFindBy(id = "com.maf.sharesit:id/bt_capture_receipt")
	public AndroidElement buttonCaptureClick;

	@AndroidFindBy(id = "com.maf.sharesit:id/iv_submit_for_preview")
	public AndroidElement imageSubmit;

	@AndroidFindBy(accessibility = "Navigate up")
	public AndroidElement previewClose;

	@AndroidFindBy(id = "com.maf.sharesit:id/menu_item_retake")
	public AndroidElement previewRetake;

	@AndroidFindBy(id = "com.maf.sharesit:id/iv_submit_for_preview")
	public AndroidElement previewSubmit;

	@AndroidFindBy(id = "com.maf.sharesit:id/iv_receipt_preview")
	public AndroidElement submitReceipt;

	@AndroidFindBy(id = "android:id/button2")
	public AndroidElement popCancel;

	@AndroidFindBy(id = "android:id/button1")
	public AndroidElement popRetake;

	@AndroidFindBy(id = "android:id/button1")
	public AndroidElement popDiscard;



	//Gifting
	@AndroidFindBy(id = "com.maf.sharesit:id/iv_home_feature_share_points")
	public AndroidElement homeGifting;

	@AndroidFindBy(xpath = "//android.view.View[@text='Access is denied due to invalid credentials.']")
	public AndroidElement accessDenied;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='DONE']")
	public AndroidElement giftErrorDone;

	/// SHARE_ID////

	@AndroidFindBy(id = "com.maf.sharesit:id/iv_home_feature_share_id")
	public AndroidElement homeShareId;


	@AndroidFindBy(id = "com.maf.sharesit:id/tv_share_id_barcode")
	public AndroidElement homeBarcode;

	///All Tabs
	@AndroidFindBy(id = "com.maf.sharesit:id/option_home_experiences")
	public AndroidElement shareExperiencesTab;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/option_home_pay")
	public AndroidElement sharePayTab;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/option_home_using_share")
	public AndroidElement shareAssistantTab;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/option_home_account")
	public AndroidElement shareAccountTab;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/iv_home_feature_share_points")
	public AndroidElement homeSharePoints;
	
	@AndroidFindBy(id = "points")
	public AndroidElement homePointsField;
	
	@AndroidFindBy(id = "reciever")
	public AndroidElement homePointsEmail;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='SUBMIT']")
	public AndroidElement homePointsSubmit;

	@AndroidFindBy(xpath = "//android.view.View[@text='Points balance']")
	public AndroidElement homePointsBalance;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='POINTS']")
	public AndroidElement homePointsPoints;
	
	@AndroidFindBy(xpath = "//android.view.View[@index='4']")
	public AndroidElement homePointsAed;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Enter the points you want to share (starting from 10 points).']")
	public AndroidElement homePointsError;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Enter recipient's email address.']")
	public AndroidElement homePointsEmailError;
	
	//Experiences 4 Tabs
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='OFFERS']")
	public AndroidElement homeOffers;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CHARITY']")
	public AndroidElement homeCharity;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='DISCOUNTS']")
	public AndroidElement homeDiscounts;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CONTEST']")
	public AndroidElement homeContest;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/button_see_all_2")
	public AndroidElement homeExpSeeAll;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/option_home_experiences")
	public AndroidElement homeExpTab;
	
	//Updates
	
	@AndroidFindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc='UPDATES']")
	public AndroidElement homeUpdates;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='UPDATES']")
	public AndroidElement homeUpdatesScreen;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/button_see_all")
	public AndroidElement homeupdateSeeAll;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/tvDate")
	public AndroidElement homeupdateDate;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/iv_share")
	public AndroidElement homeupdateShare;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/tv_experience_details_description")
	public AndroidElement homeupdateDesc;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
	public AndroidElement homeupdateNews;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/iv_close")
	public AndroidElement homeupdateClose;
	
	
	@AndroidFindBy(id = "android:id/chooser_header")
	public AndroidElement homeupdateShareOptions;
	
	//offer Description screen
	
	@AndroidFindBy(id = "com.maf.sharesit:id/tv_experience_details_description")
	public AndroidElement homeOffersDes;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@clickable='true']")
	public AndroidElement homeOfferClose;

}
