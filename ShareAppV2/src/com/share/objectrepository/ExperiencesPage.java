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

public class ExperiencesPage extends DriverSetUp  {

	AndroidDriver<AndroidElement> driver;

	public ExperiencesPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);

	}
	
	// V2 START
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='EXPERIENCES' and @resource-id='com.maf.sharesit:id/smallLabel']")
	public AndroidElement Experiences;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/indicatorOnBoarding")
    public AndroidElement OnBoarding;
	
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.maf.sharesit:id/indicatorOnBoarding']//android.view.View[@index='0']")
	public AndroidElement OnBoardingSwipe1;
	
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.maf.sharesit:id/indicatorOnBoarding']//android.view.View[@index='1']")
	public AndroidElement OnBoardingSwipe2;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/tv_skip")
    public AndroidElement OnBoardingSkip;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/btn_continue")
    public AndroidElement OnBoardingContinue;
	
	 @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_always_button' and @text='ALLOW ALL THE TIME']")
	 public AndroidElement AllowAllTheTime;
	  
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SHARE EXPERIENCES']")
	public AndroidElement shareExperiences;
	 
	@AndroidFindBy(xpath = "//android.widget.Button[@text='SEE ALL']")
	public AndroidElement seeAll; 
	 
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CARREFOUR OFFERS']")
	public AndroidElement carrefourOffers; 
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='PRODUCT DISCOUNTS']")
	public AndroidElement productDiscounts;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CONTESTS']")
	public AndroidElement contests;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='REDEEM & EARN']")
	public AndroidElement redeemNEarn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CHARITY']")
	public AndroidElement charity;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SHARE BENEFITS']")
	public AndroidElement shareBenefits;
	
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.maf.sharesit:id/toolbarFilterSearchActionsContainer']/following-sibling::android.widget.TextView[@text='CARREFOUR OFFERS']")
	public AndroidElement carrefourOffersPage;
	
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.maf.sharesit:id/toolbarFilterSearchActionsContainer']/following-sibling::android.widget.TextView[@text='PRODUCT DISCOUNTS']")
	public AndroidElement productDiscountsPage; 
	
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.maf.sharesit:id/toolbarFilterSearchActionsContainer']/following-sibling::android.widget.TextView[@text='CONTESTS']")
	public AndroidElement contestsPage;
	
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.maf.sharesit:id/toolbarFilterSearchActionsContainer']/following-sibling::android.widget.TextView[@text='REDEEM & EARN']")
	public AndroidElement redeemNEarnPage;
	
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.maf.sharesit:id/toolbarFilterSearchActionsContainer']/following-sibling::android.widget.TextView[@text='CHARITY']")
	public AndroidElement charityPage;
	
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.maf.sharesit:id/toolbarFilterSearchActionsContainer']/following-sibling::android.widget.TextView[@text='SHARE BENEFITS']")
	public AndroidElement shareBenefitsPage;
	
	@AndroidFindBy(xpath = "//androidx.cardview.widget.CardView[@index='0']")
	public AndroidElement firstOffer;
	
	@AndroidFindBy(xpath = "//androidx.cardview.widget.CardView[@index='0']//android.widget.TextView[@resource-id='com.maf.sharesit:id/textViewOfferTitle']")
	public AndroidElement firstOfferTitle;
	
	@AndroidFindBy(xpath = "//androidx.cardview.widget.CardView[@index='0']//android.widget.Switch")
	public AndroidElement firstOfferActivate;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView[@resource-id='com.maf.sharesit:id/scroll_experience_details']//android.widget.TextView[@resource-id='com.maf.sharesit:id/textView21']")
	public AndroidElement DetailedOfferTitle;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView[@resource-id='com.maf.sharesit:id/scroll_experience_details']//android.widget.ImageView[@resource-id='com.maf.sharesit:id/imageView9']")
	public AndroidElement DetailedOfferLogo;
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.maf.sharesit:id/frameLayoutViewPagerItemContainer']//android.widget.ImageView")
	public AndroidElement DetailedOfferImage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/tv_experience_details_start']")
	public AndroidElement DetailedOfferStartDate;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/tv_experience_details_end']")
	public AndroidElement DetailedOfferEndDate;
	
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.maf.sharesit:id/switchOfferActivate']//android.widget.Switch")
	public AndroidElement DetailedOfferActivate;
	
	
	@AndroidFindBy(xpath = "//androidx.cardview.widget.CardView[@index='2']//android.widget.TextView[@resource-id='com.maf.sharesit:id/textViewOfferTitle']")
	public AndroidElement offerTitle;
	
	@AndroidFindBy(xpath = "//androidx.cardview.widget.CardView[@index='2']//android.widget.ImageView[@resource-id='com.maf.sharesit:id/imageViewOfferImage']")
	public AndroidElement offerImage;
	
	@AndroidFindBy(xpath = "//androidx.cardview.widget.CardView[@index='2']//android.widget.TextView[@resource-id='com.maf.sharesit:id/textViewOfferStartDate']")
	public AndroidElement offerStartDate;
	
	@AndroidFindBy(xpath = "//androidx.cardview.widget.CardView[@index='2']//android.widget.TextView[@resource-id='com.maf.sharesit:id/textViewOfferEndDate']")
	public AndroidElement offerEndDate;
	
	@AndroidFindBy(xpath = "//androidx.cardview.widget.CardView[@index='2']//android.widget.ImageView[@resource-id='com.maf.sharesit:id/imageViewOfferSponsorLogo']")
	public AndroidElement offerSponsorLogo;
	
	@AndroidFindBy(xpath = "//androidx.cardview.widget.CardView[@index='2']//android.widget.ImageView[@resource-id='com.maf.sharesit:id/imageViewOfferShareAction']")
	public AndroidElement offerShareButton;
	
	@AndroidFindBy(xpath = "//androidx.cardview.widget.CardView[@index='2']//android.widget.Switch")
	public AndroidElement offerActivateSwitch;
	
	public String categoryIcons= "//android.view.ViewGroup[@resource-id='com.maf.sharesit:id/constraintExperiencesCategories']/android.widget.LinearLayout";
	
	@AndroidFindBy(id = "com.maf.sharesit:id/fragment_experiences_categories_section")
    public AndroidElement categoryIconBar;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/textViewCategoryName1']")
	public AndroidElement categoryName;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='You have Activated Offers']")
	public AndroidElement activatedOffer;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ACTIVATED OFFERS']")
	public AndroidElement activatedOfferPage;
	
	@AndroidFindBy(xpath = "//androidx.cardview.widget.CardView[@index='0']//android.widget.Switch")
	public AndroidElement ActivateSwitch;
		
	public AndroidElement checkOfferTitle(String offerTitle)
	{
		AndroidElement Title = driver.findElementByXPath("//androidx.cardview.widget.CardView[@index='0']//android.widget.TextView[@resource-id='com.maf.sharesit:id/textViewOfferTitle' and contains(@text,'"+offerTitle+"')]");
		return Title;
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/tv_title' and @text='NOT AVAILABLE']")
	public AndroidElement NotAvailable;
		
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/tv_action' and @text='EXPLORE OTHER EXPERIENCES']")
	public AndroidElement exploreOtherExperiences;
		
	@AndroidFindBy(xpath = "//android.widget.ListView[@resource-id='android:id/resolver_list']")
	public AndroidElement shareOptions;
	
	@AndroidFindBy(xpath = "//androidx.cardview.widget.CardView[@index='2']")
	public AndroidElement offer;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView[@resource-id='com.maf.sharesit:id/scroll_experience_details']//android.widget.ImageView[@resource-id='com.maf.sharesit:id/ic_tv_experience_details_share']")
	public AndroidElement detailedOfferShareIcon;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/imageViewListFilterAction")
    public AndroidElement offerFilter;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='FILTERS']")
	public AndroidElement filtersPage; 
	
	@AndroidFindBy(xpath = "//android.widget.CompoundButton[@text='Dubai']")
	public AndroidElement locationDubai;
	
	@AndroidFindBy(xpath = "//android.widget.CompoundButton[@text='Abu Dhabi']")
	public AndroidElement locationAbuDhabi;
	
	@AndroidFindBy(xpath = "//android.widget.CompoundButton[@text='Ajman']")
	public AndroidElement locationAjman;
	
	@AndroidFindBy(xpath = "//android.widget.CompoundButton[@text='Ras Al Khaimah']")
	public AndroidElement locationRasAlKhaimah;
	
	@AndroidFindBy(xpath = "//android.widget.CompoundButton[@text='Sharjah']")
	public AndroidElement locationSharjah;
	
	@AndroidFindBy(xpath = "//android.widget.CompoundButton[@text='Umm Al Quwain']")
	public AndroidElement locationUmmAlQuwain;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/tv_nearby']")
	public AndroidElement nearby;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/action_clear_all']")
	public AndroidElement clearAll;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/btn_show_experiences']")
	public AndroidElement showExperiences;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='OFFER TYPE']")
	public AndroidElement offerType;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id='com.maf.sharesit:id/tv_earn_only']")
	public AndroidElement earnOnly;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id='com.maf.sharesit:id/tv_burn_only']")
	public AndroidElement burnOnly;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='AVAILABILITY']")
	public AndroidElement availability;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id='com.maf.sharesit:id/tv_online']")
	public AndroidElement online;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id='com.maf.sharesit:id/tv_instore']")
	public AndroidElement inStore;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='EXPIRY']")
	public AndroidElement expiry;
	
	@AndroidFindBy(xpath = "//android.widget.SeekBar[@resource-id='com.maf.sharesit:id/sb_expiry']")
	public AndroidElement expirySeekBar;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/imageViewSearchAction")
    public AndroidElement searchIcon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SEARCH']")
	public AndroidElement searchPage;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/et_search")
    public AndroidElement searchField;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.sharesit:id/rv_search']//android.view.ViewGroup[@index='1']//android.widget.ImageView[@resource-id='com.maf.sharesit:id/iv_search']/following-sibling::android.widget.TextView")
	public AndroidElement recentSearchItem;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/ib_close")
    public AndroidElement searchClear;
	
	@AndroidFindBy(xpath = "//androidx.cardview.widget.CardView//android.view.ViewGroup[@index='0']")
	public AndroidElement searchResult;
	
	public AndroidElement recentSearches(String searchValue)
	{
		AndroidElement value = driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.sharesit:id/rv_search']//android.view.ViewGroup//android.widget.TextView[@text='"+searchValue+"']");
		return value;
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/tvClear' and @text='CLEAR']")
	public AndroidElement clearButton;
	
	public String trySearch="//android.view.ViewGroup//android.widget.ImageView[@resource-id='com.maf.sharesit:id/iv_search']/following-sibling::android.widget.TextView";
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.maf.sharesit:id/toolbar']//android.widget.ImageView[@resource-id='com.maf.sharesit:id/imageView8']")
	public AndroidElement activatedOfferClose;
	
	
	
	
	//V2 END
	
	
	

	
}