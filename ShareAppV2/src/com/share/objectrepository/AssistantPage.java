package com.share.objectrepository;
import org.openqa.selenium.support.PageFactory;

import com.share.general.DriverSetUp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AssistantPage extends DriverSetUp  {

	AndroidDriver<AndroidElement> driver;

	public AssistantPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);

	}


	//V2 START

	@AndroidFindBy(id = "option_home_using_share")
	public AndroidElement AssistantIcon;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ASSISTANT']")
	public AndroidElement assistantPage;

	@AndroidFindBy(id = "imageViewSearchAction")
	public AndroidElement searchIcon;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'SEARCH']")
	public AndroidElement searchTitle;

	@AndroidFindBy(id = "linear_layout_assistant_topics")
	public AndroidElement topicSection;

	@AndroidFindBy(id = "text_view_assistant_share_basics")
	public AndroidElement shareBasicsSection;

	@AndroidFindBy(id = "text_view_chat_message")
	public AndroidElement callUsSection;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SHARE WALLET']")
	public AndroidElement ShareWalletTopic;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='REGISTRATION/YOUR']")
	public AndroidElement RegistrationTopic;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SHARE POINTS']")
	public AndroidElement sharePointsTopic;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='EARNING POINTS']")
	public AndroidElement earningSharePointsTopic;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='REDEEMING POINTS']")
	public AndroidElement redeemSharePointsTopic;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SHARE FAMILY GROUP']")
	public AndroidElement familyGroupTopic;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SHARE ID']")
	public AndroidElement shareIDTopic;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='YOUR SHARE WORLD']")
	public AndroidElement shareWorldTopic;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'SHARE WALLET']")
	public AndroidElement pageTitleWallet;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'SHARE POINTS']")
	public AndroidElement pageTitleSPoints;


	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'EARNING POINTS']")
	public AndroidElement pageTitleEarn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'REDEEMING POINTS']")
	public AndroidElement pageTitleRedeem;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'SHARE FAMILY GROUP']")
	public AndroidElement pageTitleFamily;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'SHARE ID']")
	public AndroidElement pageTitleID;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'YOUR SHARE WORLD']")
	public AndroidElement pageTitleWorld;

	@AndroidFindBy(className = "android.widget.ImageView")
	public AndroidElement backAssistant;

	@AndroidFindBy(id = "recyclerCategoryQuestions")
	public AndroidElement questionsList;

	//	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id,'recyclerCategoryQuestions']")
	//	public AndroidElement questionsList;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id,'toolbar']//android.widget.RelativeLayout//android.widget.ImageView[@index = '0']")
	public AndroidElement pageBack;

	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id,'recyclerCategoryQuestions']//android.widget.RelativeLayout[@index='0']//android.widget.TextView[@resource-id='text_view_category_question']")
	public AndroidElement firstQuestion;

	@AndroidFindBy(id = "textViewCategoryAnswer")
	public AndroidElement firstQuestionAnswer;

	//	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id,'recyclerCategoryQuestions']//android.widget.RelativeLayout[@index='0']//android.widget.TextView[@resource-id='textViewCategoryAnswer']")
	//	public AndroidElement firstQuestionAnswer;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Where to use SHARE']")
	public AndroidElement usingShare;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SHARE in Shopping Malls']")
	public AndroidElement usingShareMalls;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Earning SHARE points']")
	public AndroidElement earningSHAREPoints;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Number of points earned']")
	public AndroidElement numberOFPointsEarned;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Redeeming SHARE Points']")
	public AndroidElement redeemingSHAREPoints;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout['1']/android.view.ViewGroup['0']/android.widget.TextView[@index = '1']")
	public AndroidElement Description;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'SEARCH']")
	public AndroidElement pageTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'SHARE BASICS']")
	public AndroidElement pageTitleShareBasics;

	@AndroidFindBy(id = "search_src_text")
	public AndroidElement searchField;

	@AndroidFindBy(id = "recyclerViewAssistantSearch")
	public AndroidElement recentSearchItem;

	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='recyclerViewAssistantSearch']//android.widget.ImageView[@resource-id='iv_search']/following-sibling::android.widget.TextView")
	public AndroidElement recentSearchItems;

	@AndroidFindBy(id = "tvClear")
	public AndroidElement searchClear;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[2]\r\n" +
			"")
	public AndroidElement searchResultcarrefour;

	@AndroidFindBy(id = "recyclerViewAssistantSearch")
	public AndroidElement searchResult;

	public String trySearches="//android.view.ViewGroup//android.widget.ImageView[@resource-id,'iv_search']/following-sibling::android.widget.TextView";

	public AndroidElement recentSearches(String searchValue)
	{
		AndroidElement value = driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView[@resource-id='recyclerViewAssistantSearch']//android.widget.ImageView[@resource-id='iv_search']/following-sibling::android.widget.TextView[@text='"+searchValue+"']");
		return value;
	}

	@AndroidFindBy(id = "tvClear")
	public AndroidElement clearButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='TRY SEARCHING']")
	public AndroidElement trySearching;


	@AndroidFindBy(id = "text_view_question")
	public AndroidElement assistantQuestion;

	@AndroidFindBy(id = "fragment_assistant_nav_host")
	public AndroidElement answerDetailsPage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.dl.sharesit:id/tv_title' and @text='SORRY, NO RESULT FOUND']")
	public AndroidElement noResult;

//	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.google.android.dialer:id/digits']")
//	public AndroidElement Dialer;

	@AndroidFindBy(className = "android.widget.EditText")
	public AndroidElement Dialer;

	@AndroidFindBy(xpath = "//androidx.viewpager.widget.ViewPager[@resource-id,'onBoardingViewpager']")
	public AndroidElement onBoarding;

	@AndroidFindBy(id = "tvDate")
    public AndroidElement transactionsdate;


	//V2 END





}