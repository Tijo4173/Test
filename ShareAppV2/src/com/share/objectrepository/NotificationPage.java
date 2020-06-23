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

public class NotificationPage extends DriverSetUp  {

	AndroidDriver<AndroidElement> driver;

	public NotificationPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);

	}
	
	
	@AndroidFindBy(id = "com.maf.sharesit:id/onboarding_already_have_account_view")
	public AndroidElement SignInElement;
	
	@AndroidFindBy(xpath = "//*[@class='android.widget.TextView']")
	public AndroidElement PageTitle;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/tv_login_forget_password")
	public AndroidElement ForgotPassword;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.maf.sharesit:id/text_input_layout_input' and @text='Email address']")
	public AndroidElement EmailField;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.maf.sharesit:id/change_password_button']")
	public AndroidElement ResetPasswordButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/dialog_status_title']")
	public AndroidElement DialogStatus;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.maf.sharesit:id/dialog_primary_button']")
	public AndroidElement ThanksButton;
	
	//@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.google.android.gm:id/open_search_bar_text_view']")
	//public AndroidElement SearchMail;
	
	@AndroidFindBy(id = "com.google.android.gm:id/open_search")
	public AndroidElement SearchBox;
	
	@AndroidFindBy(id ="com.google.android.gm:id/open_search_view_edit_text")
	public AndroidElement SearchMail;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.google.android.gm:id/viewified_conversation_item_view' and @index='1']//android.widget.TextView[@resource-id='com.google.android.gm:id/subject']")
	public AndroidElement MailSubject;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.google.android.gm:id/viewified_conversation_item_view' and @index='1']//android.widget.TextView[@resource-id='com.google.android.gm:id/date']")
	public AndroidElement MailTime;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/dialog_status_description']")
	public AndroidElement DialogDescription;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/textinput_error']")
	public AndroidElement ErrorMessage;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.maf.sharesit:id/item_myaccount_family']")
	public AndroidElement FamilyGroup;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.maf.sharesit:id/my_account_points_balance_expanded']")
	public AndroidElement PointBalance;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@index='1']//android.widget.TextView[@resource-id='com.maf.sharesit:id/family_head_member_name' and @index='1']")
	public AndroidElement FamilyMember;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.maf.sharesit:id/text_input_layout_input']")
	public AndroidElement GiftPoint;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.maf.sharesit:id/gift_button']")
	public AndroidElement GiftPointButton;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.maf.sharesit:id/dialog_primary_button' and @text='THANKS']")
	public AndroidElement Thanks;
	
}