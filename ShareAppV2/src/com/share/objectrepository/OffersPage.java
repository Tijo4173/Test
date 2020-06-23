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

public class OffersPage extends DriverSetUp  {

	AndroidDriver<AndroidElement> driver;

	public OffersPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);

	}
	
	
	
	
//testcase TC_Offers_001 and TC_Offers_002
	
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Offers\"]/android.view.ViewGroup/android.widget.TextView")
    public AndroidElement offers;
    
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.widget.TextView[@resource-id='com.maf.sharesit:id/offers_tab_button_text']")
    public AndroidElement offers_activate;

    @AndroidFindBy(id = "com.maf.sharesit:id/offers_title_text_view_expanded")
    public AndroidElement offers_title;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/offers_tab_button_text' and @text='ACTIVATED']")
    public AndroidElement ActivatedTab;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/no_offers_text_vies' and @text='No Offers']")
    public AndroidElement NoOffers;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/offers_title_text_view_expanded']")
    public AndroidElement Title;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/offer_banner_title']")
    public AndroidElement ActivatedOffers;
    
    //testcase TC_Offers_003
   
    @AndroidFindBy(id = "com.maf.sharesit:id/offer_banner_title")
    public AndroidElement offers_title_des;
    
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Offer Image\"]")
    public AndroidElement offers_image;
    
    @AndroidFindBy(id = "com.maf.sharesit:id/offer_details_remaining_days_text")
    public AndroidElement days_remaining;
    
    @AndroidFindBy(id = "com.maf.sharesit:id/offer_details_dates")
    public AndroidElement expiry_date;
    
    
    @AndroidFindBy(id = "com.maf.sharesit:id/offer_details_title")
    public AndroidElement offers_title1;
    
    @AndroidFindBy(id = "com.maf.sharesit:id/offer_details_description_text")
    public AndroidElement offers_des;
    
    @AndroidFindBy(id = "com.maf.sharesit:id/offer_details_share")
    public AndroidElement offers_share;
    
    @AndroidFindBy(id = "com.maf.sharesit:id/offer_details_like")
    public AndroidElement offers_like_save;
    
    @AndroidFindBy(id = "com.maf.sharesit:id/offer_details_location_icon")
    public AndroidElement offers_location;
    
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.maf.sharesit:id/offer_add_to_favorite_button' and @enabled='true']")
    public AndroidElement UnActivatedOffer;
    
    public String UnActivatedOfferXpath ="//android.widget.ImageButton[@resource-id='com.maf.sharesit:id/offer_add_to_favorite_button' and @enabled='true']";
    
  //test case TC_Offers_005
    @AndroidFindBy(id = "com.maf.sharesit:id/offer_banner_title")
    public AndroidElement offers_click;
    
    @AndroidFindBy(id = "com.maf.sharesit:id/offer_details_share")
    public AndroidElement offers_share1;
    
    
    //test case TC_Offers_006
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Share\"]")
    public AndroidElement share_list;
    
  //test case TC_Offers_007
    
    
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Offer Image\"])[1]")
    public AndroidElement offer_image;
    
    @AndroidFindBy(id = "com.maf.sharesit:id/offer_details_like")
    public AndroidElement activated_icon;
    
    @AndroidFindBy(id = "com.maf.sharesit:id/offer_details_share")
    public AndroidElement offer_details_share;
	
    @AndroidFindBy(id = "com.maf.sharesit:id/offer_banner_title")
    public AndroidElement offer_title;
	
    @AndroidFindBy(id = "com.maf.sharesit:id/offer_details_title")
    public AndroidElement offer_details_title;
	
    @AndroidFindBy(id = "com.maf.sharesit:id/offer_banner_title")
    public AndroidElement offer_banner_title;
 
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.ImageButton")
    public AndroidElement offer_back_button;
    
    @AndroidFindBy(id = "com.maf.sharesit:id/offer_add_to_favorite_button")
    public AndroidElement activated;
    
    @AndroidFindBy(id = "com.maf.sharesit:id/offers_tab_button_icon")
    public AndroidElement activated_tab;
    
    @AndroidFindBy(id = "com.maf.sharesit:id/offer_add_to_favorite_button")
    public AndroidElement untick_offer;
    
    public String VerifyOffer(String ElementText)
    {
           String Xpath="//android.widget.TextView[@resource-id='com.maf.sharesit:id/offer_banner_title' and @text='"+ElementText+"']";
           return Xpath;
    }
 
    
  //test case TC_Offers_008
    
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.TextView")
    public AndroidElement carrefour;
    
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.maf.sharesit:id/offer_share_offer_button']")
    public AndroidElement share_button;
  
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.maf.sharesit:id/offer_add_to_favorite_button']")
    public AndroidElement carre_tick;
    
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Offer Image\"])[1]")
    public AndroidElement carre_img;
	
	
}