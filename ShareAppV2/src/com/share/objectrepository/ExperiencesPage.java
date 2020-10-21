package com.share.objectrepository;

import org.openqa.selenium.support.PageFactory;

 

import com.share.general.DriverSetUp;

 

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;

import io.appium.java_client.pagefactory.AndroidFindBy;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

 

public class ExperiencesPage extends DriverSetUp  {

 

    AndroidDriver<AndroidElement> driver;

 

    public ExperiencesPage(AndroidDriver<AndroidElement> driver) {

        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

 

    }

 

    // V2 START

 

    @AndroidFindBy(id = "smallLabel")
    public AndroidElement Experiences;

    @AndroidFindBy(id = "indicatorOnBoarding")
    public AndroidElement OnBoarding;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='indicatorOnBoarding']//android.view.View[@index='0']")
    public AndroidElement OnBoardingSwipe1;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='indicatorOnBoarding']//android.view.View[@index='1']")
   public AndroidElement OnBoardingSwipe2;


    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.dl.sharesit:id/tvSkip']")
    public AndroidElement OnBoardingSkip;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.dl.sharesit:id/btn_continue']")
    public AndroidElement OnBoardingContinue;

    @AndroidFindBy(id = "android:id/button1")
    public AndroidElement AllowAllTheTime;
    
    @AndroidFindBy(id = "android:id/button2")
    public AndroidElement DontAllowaccess;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SHARE EXPERIENCES']")
    public AndroidElement shareExperiences;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='SEE ALL']")
    public AndroidElement seeAll;

    @AndroidFindBy(id="textViewCategoryName1")
    public AndroidElement Shopping;
    
    @AndroidFindBy(id="textViewCategoryName2")
    public AndroidElement Dining;
    
    @AndroidFindBy(id="textViewCategoryName3")
    public AndroidElement Leisure;

    @AndroidFindBy(id = "textViewCategoryName4")
    public AndroidElement Carrefour;

    @AndroidFindBy(id="textViewCategoryName5")
    public AndroidElement Contests;
    
    @AndroidFindBy(id="textViewCategoryName6")
    public AndroidElement Benefits;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SHOPPING']")
    public AndroidElement shareOffersPage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CARREFOUR']")
    public AndroidElement carrefourOffersPage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CONTESTS']")
    public AndroidElement memberContestsPage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='BENEFITS']")
    public AndroidElement memberBenefitsPage;

 

//    @AndroidFindBy(xpath = "//androidx.cardview.widget.CardView/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='0']")
//    public AndroidElement firstOffer;

    @AndroidFindBy(xpath = "//androidx.cardview.widget.CardView[@index='0']")
    public AndroidElement firstOffer;

    @AndroidFindBy(id = "textViewOfferTitle")
    public AndroidElement firstOfferTitle;

    @AndroidFindBy(xpath = "//androidx.cardview.widget.CardView[@index='0']//android.widget.Switch")
    public AndroidElement firstOfferActivate;

    @AndroidFindBy(id = "textView21")
    public AndroidElement DetailedOfferTitle;

    @AndroidFindBy(id = "imageView9")
    public AndroidElement DetailedOfferLogo;

    @AndroidFindBy(id = "frameLayoutViewPagerItemContainer")
    public AndroidElement DetailedOfferImage;

    @AndroidFindBy(id = "tv_experience_details_start")
    public AndroidElement DetailedOfferStartDate;

    @AndroidFindBy(id = "tv_experience_details_end")
    public AndroidElement DetailedOfferEndDate;

    @AndroidFindBy(className = "android.widget.Switch")
    public AndroidElement DetailedOfferActivate;
    
    @AndroidFindBy(id = "tv_experience_details_description")
    public AndroidElement DetailedOfferDescription;
    
    @AndroidFindBy(xpath = "//androidx.cardview.widget.CardView['1']/android.view.ViewGroup['0']/android.widget.TextView[@index='3']")
    public AndroidElement offerTitle;

    @AndroidFindBy(xpath = "//androidx.cardview.widget.CardView['1']/android.view.ViewGroup['0']/android.widget.TextView[@index='3']")
    public AndroidElement offerTitlecompare;
    
    @AndroidFindBy(xpath = "//androidx.cardview.widget.CardView['1']/android.view.ViewGroup['0']/android.widget.ImageView[@index='0']")
    public AndroidElement offerImage;

    @AndroidFindBy(xpath = "//androidx.cardview.widget.CardView['1']/android.view.ViewGroup['0']/android.widget.TextView[@index='1']")
    public AndroidElement offerStartDate;
    
    @AndroidFindBy(xpath = "//androidx.cardview.widget.CardView['1']/android.view.ViewGroup['0']/android.widget.TextView[@index='2']")
    public AndroidElement offerEndDate;

    @AndroidFindBy(xpath = "//androidx.cardview.widget.CardView['1']/android.view.ViewGroup['0']/android.widget.ImageView[@index='4']")
    public AndroidElement offerSponsorLogo;

    @AndroidFindBy(id = "imageViewOfferShareAction")
    public AndroidElement offerShareButton;

    @AndroidFindBy(className = "android.widget.Switch")
    public AndroidElement offerActivateSwitch;

    public String categoryIcons= "//android.view.ViewGroup[@resource-id='constraintExperiencesCategories']/android.widget.LinearLayout";

    @AndroidFindBy(id = "fragment_experiences_categories_section")
    public AndroidElement categoryIconBar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='textViewCategoryName1']")
    public AndroidElement categoryName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='You have Activated Offers']")
    public AndroidElement activatedOffer;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ACTIVATED OFFERS']")
    public AndroidElement activatedOfferPage;

//    @AndroidFindBy(xpath = "//androidx.cardview.widget.CardView['1']/android.view.ViewGroup['0']/android.widget.Switch[@index='0']")
//    public AndroidElement activateSwitch;

    @AndroidFindBy(className = "android.widget.Switch")
    public AndroidElement activateSwitch;

 
//    public AndroidElement checkOfferTitle()[contains(@resource-id,'digit5') and @text='5']")
//    {
//        AndroidElement Title = driver.findElementByXPath("//androidx.cardview.widget.CardView['1']/android.view.ViewGroup['0']/android.widget.TextView[contains(@index='3'] and contains(@text,'\"+offerTitle+\"')]");
//        return Title;
//    }

    public AndroidElement checkOfferTitle(String offerTitle)
    {
    	AndroidElement Title = driver.findElementByXPath("//androidx.cardview.widget.CardView[@index='0']/android.view.ViewGroup['0']/android.widget.TextView[contains(@resource-id,'textViewOfferTitle') and @text='"+offerTitle+"']");
        return Title;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='tv_title' and @text='NOT AVAILABLE']")
    public AndroidElement NotAvailable;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='tv_action' and @text='EXPLORE OTHER EXPERIENCES']")
    public AndroidElement exploreOtherExperiences;

    @AndroidFindBy(xpath = "//android.widget.ListView[@resource-id='android:id/resolver_list']")
    public AndroidElement shareOptions;

    @AndroidFindBy(xpath = "//androidx.cardview.widget.CardView[@index='2']")
    public AndroidElement offer;

    @AndroidFindBy(id = "ic_tv_experience_details_share")
    public AndroidElement detailedOfferShareIcon;

    @AndroidFindBy(id = "imageViewListFilterAction")
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
    
    @AndroidFindBy(xpath = "//android.widget.CompoundButton[@text='Fujairah']")
	public AndroidElement locationFujairah;

    @AndroidFindBy(id = "tv_nearby")
    public AndroidElement nearby;

    @AndroidFindBy(id = "action_clear_all")
    public AndroidElement clearAll;

    @AndroidFindBy(id = "btn_show_experiences")
    public AndroidElement showExperiences;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='OFFER TYPE']")
    public AndroidElement offerType;

    @AndroidFindBy(id = "tv_earn_only")
    public AndroidElement earnOnly;

    @AndroidFindBy(id = "tv_burn_only")
    public AndroidElement burnOnly;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='AVAILABILITY']")
    public AndroidElement availability;

    @AndroidFindBy(id = "tv_online")
    public AndroidElement online;

    @AndroidFindBy(id = "tv_instore")
    public AndroidElement inStore;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='EXPIRY']")
    public AndroidElement expiry;

    @AndroidFindBy(xpath = "//android.widget.SeekBar[@resource-id='sb_expiry']")
    public AndroidElement expirySeekBar;

    @AndroidFindBy(id = "imageViewSearchAction")
    public AndroidElement searchIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SEARCH']")
    public AndroidElement searchPage;

    @AndroidFindBy(id = "et_search")
    public AndroidElement searchField;
    
    @AndroidFindBy(id = "tv_title")
    public AndroidElement noResultfound;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text ='RECENT']")
    public AndroidElement recentSearchItem;

    @AndroidFindBy(id = "ib_close")
    public AndroidElement searchClear;

    @AndroidFindBy(id = "textViewOfferTitle")
    public AndroidElement searchResult;

    public AndroidElement recentSearches(String searchValue)
    {
    	AndroidElement value = driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.dl.sharesit:id/rv_search']//android.view.ViewGroup//android.widget.TextView[@text='"+searchValue+"']");
        return value;
    }

    @AndroidFindBy(id = "tvClear")
    public AndroidElement clearButton;

    public String trySearch="//android.view.ViewGroup//android.widget.ImageView[@resource-id='com.maf.dl.sharesit:id/rv_search']/following-sibling::android.widget.TextView";

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.maf.dl.sharesit:id/imageView8']")
    public AndroidElement activatedOfferClose;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ALL OFFERS']")
    public AndroidElement allOffers;
    
  //tijo
  	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.maf.dl.sharesit:id/linearLayoutCategoryContainer1']")
    public AndroidElement category1iconshopping;
  	
  	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.maf.dl.sharesit:id/linearLayoutCategoryContainer2']")
    public AndroidElement category2icondining;	
  	
  	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.maf.dl.sharesit:id/linearLayoutCategoryContainer3']")
    public AndroidElement category3iconleisure;
  	
  	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.maf.dl.sharesit:id/linearLayoutCategoryContainer4']")
    public AndroidElement category4iconcarrefour;
  	
  	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.maf.dl.sharesit:id/linearLayoutCategoryContainer5']")
    public AndroidElement category5iconcontests;
  	
  	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.maf.dl.sharesit:id/linearLayoutCategoryContainer6']")
    public AndroidElement category6ibenefits;
  	
  	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ImageView")
    public AndroidElement backarrow;
    
  	//sprint17
  	
  	@AndroidFindBy(id = "btn_offer_sort")
    public AndroidElement sortbutton;
  	
  	@AndroidFindBy(id = "alertTitle")
    public AndroidElement sortingwindow;
  	
	@AndroidFindBy(id = "android:id/button1")
    public AndroidElement cancelsortingwindow;
	
	@AndroidFindBy(id = "textView32")
    public AndroidElement sortedbylabel;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='All offers']")
    public AndroidElement allofferslabel;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Newly added']")
    public AndroidElement newlyadded;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Expiring soon']")
    public AndroidElement expiringsoon;
	
	@AndroidFindBy(id = "textViewTargetedOfferTitle")
    public AndroidElement offerforyou;
	
	@AndroidFindBy(id = "textViewTargetedOffersCount")
    public AndroidElement offerforyoucount;
	
	@AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.widget.ImageView")
    public AndroidElement targetoffer;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SEE ALL']")
    public AndroidElement seeAllofferforyou;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='OFFERS FOR YOU']")
    public AndroidElement offerforyoupage;
		
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")
    public AndroidElement offerforyoupagecount;

}