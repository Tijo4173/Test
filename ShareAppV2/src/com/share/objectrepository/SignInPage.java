package com.share.objectrepository;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumElementLocatorFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignInPage {
	
	AndroidDriver<AndroidElement> driver;
	
	public SignInPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Email Address']")
	public AndroidElement useridElement;


	@AndroidFindBy(id = "com.maf.sharesit:id/et_login_password")
	public AndroidElement userpassElement;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/buttonOnBoardingEndAction")
	public AndroidElement signinPresent;

	@AndroidFindBy(id = "com.maf.sharesit:id/btn_login_login")
	public AndroidElement signinElement;

	@AndroidFindBy(id = "com.maf.sharesit:id/tv_login_forget_password")
	public AndroidElement forgotElement;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='RESET PASSWORD']")
	public AndroidElement resetPassElement;

	@AndroidFindBy(id="com.maf.sharesit:id/et_login_email")
	public AndroidElement resetemailElement;
	
	@AndroidFindBy(id="com.maf.sharesit:id/btn_send_reset_link")
	public AndroidElement sendResetLink;
	
	@AndroidFindBy(id="com.maf.sharesit:id/textView4")
	public AndroidElement checkYourEmail;
	
	@AndroidFindBy(id="com.maf.sharesit:id/textView6")
	public AndroidElement screenText;
	
	@AndroidFindBy(id="com.maf.sharesit:id/textView6")
	public AndroidElement forgotPasswordScreen;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/validate_email_title_text")
	public AndroidElement validateElement;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/tutorial_tip_action_button")
	public AndroidElement tutorialElement;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/tv_login_sign_up")
	public AndroidElement signUpElement;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
	public AndroidElement homeElement;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Please check your email and password and try again.']")
	public AndroidElement SignInErrorElement;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/onboarding_contact_us")
 	public AndroidElement contactus;
	
	@AndroidFindBy(id="com.maf.sharesit:id/textinput_error")
	public AndroidElement signErrorMessage;
}
