package com.share.objectrepository;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RegistrationPage {
	AndroidDriver<AndroidElement> driver;

	public RegistrationPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	@AndroidFindBy(id = "imageViewOnBoardingContent")
	public AndroidElement onboardScreen;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='2']/android.view.View[@index='0']")
	public AndroidElement onboardScrolla;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='2']/android.view.View[@index='1']")
	public AndroidElement onboardScrollb;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='2']/android.view.View[@index='2']")
	public AndroidElement onboardScrollc;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='2']/android.view.View[@index='3']")
	public AndroidElement onboardScrolld;

	@AndroidFindBy(id = "buttonOnBoardingStartAction")
	public AndroidElement startElement;

	@AndroidFindBy(id = "et_country_code")
	public AndroidElement countryCode;

	@AndroidFindBy(id = "rv_country_code")
	public AndroidElement countryCodeFrame;

	@AndroidFindBy(id = "et_email_address")
	public AndroidElement emailElement;

	@AndroidFindBy(xpath ="//android.widget.EditText[contains(@resource-id,'et_email_address') and @index='0']")
	public AndroidElement emailidPresent;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'et_country_code') and @index='0']")
	public AndroidElement countryElement;

	@AndroidFindBy(id  = "et_phone_number")
	public AndroidElement mobileNumElement;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'et_phone_number') and @index='0']")
	public AndroidElement mobilenumPresent;

	@AndroidFindBy(id = "btn_continue")
	public AndroidElement continueButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'btn_continue')and@enabled='true']")
	public AndroidElement continueButtonEnabled;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'btn_continue')and@enabled='false']")
	public AndroidElement nextElementDisabled;

	@AndroidFindBy(id = "rb_mr")
	public AndroidElement titleMr;

	@AndroidFindBy(id = "rb_mrs")
	public AndroidElement titleMrs;

	@AndroidFindBy(id = "rb_miss")
	public AndroidElement titleMiss;

	@AndroidFindBy(id = "rb_ms")
	public AndroidElement titleMs;

	@AndroidFindBy(id = "rg_title")
	public AndroidElement alltitle;


	//Email id already registered
	@AndroidFindBy(id = "btn_login")
	public AndroidElement regLogin;

	@AndroidFindBy(id = "tv_reset_password_title")
	public AndroidElement alreadyRegMessage;

	@AndroidFindBy(id = "tv_reset_password_subtitle")
	public AndroidElement alreadyRegMessageDes;




	//@AndroidFindBy(xpath = "//android.widget.EditText[@text='Title']" )
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@checked='true']")
	public AndroidElement titlePresent;

	@AndroidFindBy(id = "et_first_name")
	public AndroidElement firstNameElement;

	@AndroidFindBy(id = "et_first_name")
	public AndroidElement firstNamePresent;

	@AndroidFindBy(id = "et_last_name")
	public AndroidElement lastNameElement;

	@AndroidFindBy(id = "et_last_name")
	public AndroidElement lastNamePresent;

	@AndroidFindBy(id = "et_nationality")
	public AndroidElement nationalityElement;

	@AndroidFindBy(id = "et_password" )
	public AndroidElement passwordElement;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@index='1']/android.widget.LinearLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.EditText[@index='0']")
	public AndroidElement passwordPresent;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Confirm password']" )
	public AndroidElement confirmPasswordElement;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@index='3']/android.widget.LinearLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.EditText[@index='0']")
	public AndroidElement confirmPasswordPresent;

	@AndroidFindBy(id = "s_terms_and_policy")
	public AndroidElement termsCheckboxElement;

	@AndroidFindBy(id = "signup_promotional_and_offers_check")
	public AndroidElement offersCheckboxElement;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='1']/android.widget.Button[@text='THANKS']")
	public AndroidElement thanksElement;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='1']/android.widget.Button[@text='TRY AGAIN']")
	public AndroidElement ErrorElement;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='EMAIL ALREADY REGISTERED']")
	public AndroidElement closeElement;

	@AndroidFindBy(id = "cb_password_num_of_characters")
	public AndroidElement passwordLength;

	@AndroidFindBy(id = "cb_password_uppercase_lowercase")
	public AndroidElement passwordUpperLower;

	@AndroidFindBy(id = "cb_password_number")
	public AndroidElement passwordNumber;


	@AndroidFindBy(xpath = "//android.widget.CheckBox[contains(@resource-id,'cb_password_num_of_characters') and (@checked='true')]")
	public AndroidElement passwordCriteriaA;

	@AndroidFindBy(xpath = "//android.widget.CheckBox[contains(@resource-id,'cb_password_num_of_characters') and (@checked='false')]")
	public AndroidElement passwordCriteriaADisabled;

	@AndroidFindBy(xpath = "//android.widget.CheckBox[contains(@resource-id,'cb_password_number') and (@checked='true')]")
	public AndroidElement passwordCriteriaB;

	@AndroidFindBy(xpath = "//android.widget.CheckBox[contains(@resource-id,'cb_password_number') and (@checked='false']")
	public AndroidElement passwordCriteriaBDisabled;

	@AndroidFindBy(xpath = "//android.widget.CheckBox[contains(@resource-id,'cb_password_uppercase_lowercase') and (@checked='true')]")
	public AndroidElement passwordCriteriaC;

	@AndroidFindBy(xpath = "//android.widget.CheckBox[contains(@resource-id,'cb_password_uppercase_lowercase') and (@checked='false')]")
	public AndroidElement passwordCriteriaCDisabled;


	//	@AndroidFindBy(xpath = "//android.widget.ImageButton[contains(@resource-id,'text_input_end_icon')and(@checked='false']")
	//	public AndroidElement showPassword;

	@AndroidFindBy(id = "text_input_end_icon")
	public AndroidElement showPassword;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[contains(@resource-id,'text_input_end_icon') and (@checked='true')]")
	public AndroidElement hidePassword;

	@AndroidFindBy(id = "tv_login_sign_up")
	public AndroidElement alreadySignin;

	@AndroidFindBy(id = "textinput_error")
	public AndroidElement errorMessage;

	@AndroidFindBy(id = "tv_mobile_number_error")
	public AndroidElement mobileNumberError;


	@AndroidFindBy(xpath = "//android.widget.TextView[@text='This email address is not valid. Please check and try again.']")
	public AndroidElement infobipError;

	@AndroidFindBy(id = "btn_create_account")
	public AndroidElement createAccount;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'btn_create_account')and@enabled='false']")
	public AndroidElement createAccountDisabled;

	//Calendar
	@AndroidFindBy(xpath = "//android.widget.DatePicker[@index='2']")
	public AndroidElement datePicker;

	@AndroidFindBy(id =  "prev")
	public AndroidElement monthPrev;

	@AndroidFindBy(id =  "next")
	public AndroidElement monthNext;

	@AndroidFindBy(id =  "date_picker_header_date")
	public AndroidElement currentMonth;

//	@AndroidFindBy(id =  "date_picker_header_year")
//	public AndroidElement dobyear;


	@AndroidFindBy(id =  "android:id/date_picker_header_year")
	public AndroidElement dobyear;

	@AndroidFindBy(id =  "et_date_of_birth")
	public AndroidElement dateofbirth;

	@AndroidFindBy(id =  "signup_date_of_birth_error_label")
	public AndroidElement dateofbirthError;

	@AndroidFindBy(id =  "android:id/button1")
	public AndroidElement calendarOK;

	@AndroidFindBy(id =  "android:id/message")
	public AndroidElement dobError;

	//TC
	@AndroidFindBy(id = "s_terms_and_policy")
	public AndroidElement TermsLink;

	@AndroidFindBy(xpath = "//*[@class='android.widget.TextView']")
	public AndroidElement TermsPage;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@index='0']")
	public AndroidElement NavigateBack;


	@AndroidFindBy(id = "simple_dialog_answer_positive_button")
	public AndroidElement GotItElement;

	@AndroidFindBy(id = "tutorial_tip_stop_tutorial_button")
	public AndroidElement StopTutorialElement;

	@AndroidFindBy(id = "home_bottom_navigation_bar")
	public AndroidElement objHome;

	@AndroidFindBy(id = "v_back_to_step_one")
	public AndroidElement backtoStep;

	@AndroidFindBy(id = "btn_send_reset_link")
	public AndroidElement sendAgain;

	@AndroidFindBy(id = "textView6")
	public AndroidElement registrationSuccess;

	@AndroidFindBy(id = "option_home_home")
	public AndroidElement HomeIcon;

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id = 'simple_dialog_answer_positive_button' and @text='CONFIRM']")
	public AndroidElement ConfirmLogout;

	public String DropDownList="//android.widget.LinearLayout//android.widget.FrameLayout[@resource-id = 'et_country_code']";

	public String SelectCountry(int SelectedElement)
	{

		String Xpath="//android.widget.LinearLayout[@index='"+SelectedElement+"']//android.widget.FrameLayout[@resource-id = 'et_country_code']";
		return Xpath;
	}

}