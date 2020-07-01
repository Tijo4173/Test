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



	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Assistant']/android.widget.ImageView")
	public AndroidElement AssistantIcon;

	@AndroidFindBy(xpath = "//*[@resource-id='widget_search_title']")
	public AndroidElement PageTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='item_suggest_question_title' and @text ='Using SHARE']")
	public AndroidElement usingShare;

	@AndroidFindBy(xpath = "//*[@resource-id='item_question_description']")
	public AndroidElement Description;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='item_suggest_question_title' and @text ='Using the SHARE Wallet']")
	public AndroidElement usingShareWallet;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='item_suggest_question_title' and @text ='Earning SHARE points']")
	public AndroidElement earningSHAREPoints;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='item_suggest_question_title' and @text ='Redeeming SHARE points']")
	public AndroidElement redeemingSHAREPoints;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='assistant_categories' and @text ='See our help categories']")
	public AndroidElement helpCategories;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='categories_section_general']")
	public AndroidElement CategoryTitleText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='item_help_category_title']")
	public AndroidElement Categories;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='assistant_contact_us']")
	public AndroidElement ContactUs;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='assistant_phone']")
	public AndroidElement CallUs;

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.google.android.dialer:id/digits']")
	public AndroidElement Dialer;

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='search_src_text']")
	public AndroidElement Search;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='item_question_title']")
	public AndroidElement Question;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='assistant_question_alert']")
	public AndroidElement Alert;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Email address']")
	public AndroidElement assistantEmail;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Country code']")
	public AndroidElement assistantCountrycode;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Phone number']")
	public AndroidElement assistantPhonenumber;

	@AndroidFindBy(xpath ="//android.widget.EditText[@text='Reason for contact']")
	public AndroidElement assisatantReason;

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='zendesk_description']")
	public AndroidElement assistantDesription;

	@AndroidFindBy(id = "submit_button")
	public AndroidElement assistantSubmit;

	@AndroidFindBy(id = "add_attachment_label")
	public AndroidElement assistantAttachment;

	@AndroidFindBy(id = "text_input_layout_input")
	public AndroidElement assistantEmailfield;

	@AndroidFindBy(xpath = "//android.widget.ListView[@index='0']")
	public AndroidElement assistantReasonlist;
	
	@AndroidFindBy(id = "bt_allow")
	public AndroidElement assistantallowAccess;
	
	@AndroidFindBy(id = "zendesk_terms_conditions_label")
	public AndroidElement assistantTC;
	
	@AndroidFindBy(id ="simple_dialog_answer_positive_button")
	public AndroidElement assistantOK;
	
	@AndroidFindBy(id = "simple_dialog_answer_positive_button")
	public AndroidElement assistanSuccess;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Something else']")
	public AndroidElement assistantSomething;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='zendesk_other_reason']")
	public AndroidElement assistantOtherReason;
	
	@AndroidFindBy(id = "assistant_email")
	public AndroidElement assistantEmailUs;
	
}