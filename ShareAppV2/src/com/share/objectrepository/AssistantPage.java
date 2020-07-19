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

public class AssistantPage extends DriverSetUp  {

	AndroidDriver<AndroidElement> driver;

	public AssistantPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);

	}


	//V2 START
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ASSISTANT' and @resource-id='com.maf.sharesit:id/smallLabel']")
	public AndroidElement AssistantIcon;
	
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout//android.widget.TextView[@text='ASSISTANT']")
	public AndroidElement assistantPage;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.maf.sharesit:id/imageViewSearchAction']")
	public AndroidElement searchIcon;
	
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.maf.sharesit:id/linear_layout_assistant_topics']")
	public AndroidElement topicSection;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.sharesit:id/recyclerViewShareBasics']")
	public AndroidElement shareBasicsSection;
	
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.maf.sharesit:id/relativeLayoutAssistantCallBubble']")
	public AndroidElement callUsSection;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.sharesit:id/recyclerViewAssistantTopics']//android.widget.TextView[@text='SHARE WALLET']")
	public AndroidElement ShareWalletTopic;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.sharesit:id/recyclerViewAssistantTopics']//android.widget.TextView[contains(@text,'REGISTRATION')]")
	public AndroidElement RegistrationTopic;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.sharesit:id/recyclerViewAssistantTopics']//android.widget.TextView[@text='ABOUT SHARE POINTS']")
	public AndroidElement sharePointsTopic;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.sharesit:id/recyclerViewAssistantTopics']//android.widget.TextView[@text='EARNING SHARE POINTS']")
	public AndroidElement earningSharePointsTopic;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.sharesit:id/recyclerViewAssistantTopics']//android.widget.TextView[@text='REDEEMING SHARE POINTS']")
	public AndroidElement redeemSharePointsTopic;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.sharesit:id/recyclerViewAssistantTopics']//android.widget.TextView[@text='SHARE FAMILY GROUP']")
	public AndroidElement familyGroupTopic;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.sharesit:id/recyclerViewAssistantTopics']//android.widget.TextView[@text='SHARE AT VOX CINEMAS']")
	public AndroidElement shareAtVOXCinemasTopic;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.sharesit:id/recyclerViewAssistantTopics']//android.widget.TextView[@text='SHARE AT CARREFOUR']")
	public AndroidElement shareAtCarrefourTopic;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.maf.sharesit:id/toolbar']//android.widget.RelativeLayout//android.widget.TextView")
	public AndroidElement pageTitle;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.sharesit:id/recyclerCategoryQuestions']")
	public AndroidElement questionsList;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.maf.sharesit:id/toolbar']//android.widget.RelativeLayout//android.widget.ImageView")
	public AndroidElement pageBack;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.sharesit:id/recyclerCategoryQuestions']//android.widget.RelativeLayout[@index='0']//android.widget.TextView[@resource-id='com.maf.sharesit:id/text_view_category_question']")
	public AndroidElement firstQuestion;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.sharesit:id/recyclerCategoryQuestions']//android.widget.RelativeLayout[@index='0']//android.widget.TextView[@resource-id='com.maf.sharesit:id/textViewCategoryAnswer']")
	public AndroidElement firstQuestionAnswer;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.sharesit:id/recyclerViewShareBasics']//android.widget.TextView[@text='Using SHARE']")
	public AndroidElement usingShare;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.sharesit:id/recyclerViewShareBasics']//android.widget.TextView[@text='Using the SHARE Wallet']")
	public AndroidElement usingShareWallet;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.sharesit:id/recyclerViewShareBasics']//android.widget.TextView[@text='Earning SHARE points']")
	public AndroidElement earningSHAREPoints;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.sharesit:id/recyclerViewShareBasics']//android.widget.TextView[@text='Redeeming SHARE points']")
	public AndroidElement redeemingSHAREPoints;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/text_view_question']//following-sibling::android.widget.TextView")
	public AndroidElement Description;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/search_src_text")
    public AndroidElement searchField;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.sharesit:id/recyclerViewAssistantSearch']//android.view.ViewGroup[@index='1']//android.widget.ImageView[@resource-id='com.maf.sharesit:id/iv_search']/following-sibling::android.widget.TextView")
	public AndroidElement recentSearchItem;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.sharesit:id/recyclerViewAssistantSearch']//android.widget.ImageView[@resource-id='com.maf.sharesit:id/iv_search']/following-sibling::android.widget.TextView")
	public AndroidElement recentSearchItems;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/imageViewSearchClose")
    public AndroidElement searchClear;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.sharesit:id/recyclerViewAssistantSearch']//android.widget.TextView[@index='1']")
	public AndroidElement searchResult;
	
	public String trySearches="//android.view.ViewGroup//android.widget.ImageView[@resource-id='com.maf.sharesit:id/iv_search']/following-sibling::android.widget.TextView";
	
	public AndroidElement recentSearches(String searchValue)
	{
		AndroidElement value = driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.sharesit:id/recyclerViewAssistantSearch']//android.widget.ImageView[@resource-id='com.maf.sharesit:id/iv_search']/following-sibling::android.widget.TextView[@text='"+searchValue+"']");
		return value;
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/tvClear' and @text='CLEAR']")
	public AndroidElement clearButton;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.maf.sharesit:id/recyclerViewAssistantSearch']//android.widget.TextView[@text='TRY SEARCHING']")
	public AndroidElement trySearching;
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/text_view_question']")
	public AndroidElement assistantQuestion;
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.maf.sharesit:id/fragment_assistant_nav_host']")
	public AndroidElement answerDetailsPage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/tv_title' and @text='SORRY, NO RESULT FOUND']")
	public AndroidElement noResult;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.android.dialer:id/digits']")
	public AndroidElement Dialer;
	
	@AndroidFindBy(xpath = "//androidx.viewpager.widget.ViewPager[@resource-id='com.maf.sharesit:id/onBoardingViewpager']")
	public AndroidElement onBoarding;
	
	
	//V2 END
	


	
	
}