package com.share.objectrepository;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SplashScreenPage {
	AndroidDriver<AndroidElement> driver;
	
	public SplashScreenPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
		
	}
	@AndroidFindBy(id = "com.maf.android.share:id/buttonChangeLanguage")
	public AndroidElement splashChangeLanguage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='English']")
	public AndroidElement splashLanguage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='عربي']")
	public AndroidElement splashLanguageA;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='United Arab Emirates']")
	public AndroidElement splashCountry;
	
	@AndroidFindBy(id = "com.maf.android.share:id/buttonOnBoardingLanguageDone")
	public AndroidElement splashDone;

	@AndroidFindBy(id = "com.maf.android.share:id/action_bar_root")
	public AndroidElement splashScreen;
	
	@AndroidFindBy(id = "com.maf.sharesit:id/buttonSkip")
	public AndroidElement splashScreenSkip;
	
}
