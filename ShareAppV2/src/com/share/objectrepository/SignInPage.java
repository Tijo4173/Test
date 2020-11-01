package com.share.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignInPage {

	AndroidDriver<AndroidElement> driver;

	public SignInPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "et_login_email")
	public AndroidElement useridElement;


	@AndroidFindBy(id = "et_login_password")
	public AndroidElement userpassElement;

	@AndroidFindBy(id = "buttonOnBoardingEndAction")
	public AndroidElement signinPresent;

	@AndroidFindBy(id = "btn_login_login")
	public AndroidElement signinElement;

	@AndroidFindBy(id = "tv_login_forget_password")
	public AndroidElement forgotElement;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='RESET PASSWORD']")
	public AndroidElement resetPassElement;

	@AndroidFindBy(id= "et_login_email")
	public AndroidElement resetemailElement;

	@AndroidFindBy(id= "btn_send_reset_link")
	public AndroidElement sendResetLink;

	@AndroidFindBy(id= "btn_send_again")
	public AndroidElement sendAgain;

	@AndroidFindBy(id= "textView4")
	public AndroidElement checkYourEmail;

	@AndroidFindBy(id= "textView6")
	public AndroidElement screenText;

	@AndroidFindBy(id= "textView6")
	public AndroidElement forgotPasswordScreen;

	@AndroidFindBy(id = "validate_email_title_text")
	public AndroidElement validateElement;

	@AndroidFindBy(id = "tutorial_tip_action_button")
	public AndroidElement tutorialElement;

	@AndroidFindBy(id = "tv_login_sign_up")
	public AndroidElement signUpElement;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
	public AndroidElement homeElement;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Please check your email and password and try again.']")
	public AndroidElement SignInErrorElement;

	@AndroidFindBy(id = "onboarding_contact_us")
 	public AndroidElement contactus;

	@AndroidFindBy(id="textinput_error")
	public AndroidElement signErrorMessage;



	//Deepu
	@AndroidFindBy(id = "com.maf.sharesit:id/buttonSkip")
	public AndroidElement skipButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SIGN IN']")
	public AndroidElement signinButton;

	@AndroidFindBy(id = "com.maf.sharesit:id/et_login_email")
	public AndroidElement emailAddress;

	@AndroidFindBy(id = "com.maf.sharesit:id/et_login_password")
	public AndroidElement password;

	@AndroidFindBy(id = "btn_login_login")
	public AndroidElement loginButton;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='CANCEL']")
	public AndroidElement cancelButton;

	@AndroidFindBy(id = "buttonSkip")
	public AndroidElement skipUpdate;

	@AndroidFindBy(id = "tv_home_user_name")
	public AndroidElement username;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='HOME' and @resource-id,'largeLabel']")
	public AndroidElement homeIcon;

	@AndroidFindBy(id = "com.android.systemui:id/button2")
    public AndroidElement biocancel;

	//Loader
	@AndroidFindBy(id = "imageViewMafLoader")
    public AndroidElement signInloader;

public By sendAgainToast = By.xpath("//android.widget.Toast[@index = '1']");

public By signInErrorToast = By.xpath("//android.widget.Toast[@index = '1']");

@AndroidFindBy(id = "buttonContinue")
public AndroidElement Signcontinue;



}
