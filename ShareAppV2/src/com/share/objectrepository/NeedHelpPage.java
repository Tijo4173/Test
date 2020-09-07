package com.share.objectrepository;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NeedHelpPage {

	AndroidDriver<AndroidElement> driver;

	public NeedHelpPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}


	//****************************NEED HELP***************////////////////////

	@AndroidFindBy(id = "action_help")
	public AndroidElement needHelp;

	@AndroidFindBy(id = "et_email_address")
	public AndroidElement emailAddress;

	@AndroidFindBy(id = "et_country_code")
	public AndroidElement countryCode;

	@AndroidFindBy(id = "et_phone_number")
	public AndroidElement phoneNumber;

	@AndroidFindBy(id = "et_reason")
	public AndroidElement reason;

	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.TextView[1]")
	public AndroidElement reasonOpt;

	@AndroidFindBy(id = "et_description")
	public AndroidElement description;

	@AndroidFindBy(id = "btn_add_file_bg")
	public AndroidElement attachment;

	@AndroidFindBy(id = "btn_submit")
	public AndroidElement submit;

	@AndroidFindBy(id = "btn_done")
	public AndroidElement btnDone;

	@AndroidFindBy(id = "tv_title")
	public AndroidElement successMessageTitle;

	@AndroidFindBy(id = "tv_desc")
	public AndroidElement successMessage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'NEED HELP']")
	public AndroidElement needHelpTitle;


	//Text field validation in need help(Sign Up/Sign In)

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView")
	public AndroidElement emailAddressVal;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2][@instance='2']")
	public AndroidElement mobCodeVal;

//	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2][@instance='2']")
//	public AndroidElement mobNumVal;

	@AndroidFindBy(id = "tv_mobile_number_error")
	public AndroidElement mobNumVal;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView")
	public AndroidElement descriptionVal;
}
