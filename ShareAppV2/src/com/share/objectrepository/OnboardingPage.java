package com.share.objectrepository;

import org.openqa.selenium.support.PageFactory;

import com.share.general.DriverSetUp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OnboardingPage extends DriverSetUp {
	
	AndroidDriver<AndroidElement> driver;
	
	public OnboardingPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);

	}
	
			@AndroidFindBy(xpath ="//android.widget.ImageButton[@resource-id='com.maf.sharesit:id/tip_next_image_button']")
			public AndroidElement Nexttutorial;
			
			@AndroidFindBy(xpath ="//android.widget.ImageButton[@resource-id='com.maf.sharesit:id/tip_previous_image_button']")
			public AndroidElement Prevtutorial;
			
			@AndroidFindBy(xpath ="//android.widget.TextView[@resource-id='com.maf.sharesit:id/tutorial_tip_title']")
			public AndroidElement homeWelcome;
			
			
			//count checking
			@AndroidFindBy(xpath ="//android.widget.TextView[@resource-id='com.maf.sharesit:id/tutorial_tips_progress']")
			public AndroidElement NumberCountTutorial;
			
			@AndroidFindBy(id="com.maf.sharesit:id/simple_dialog_answer_title")
			public AndroidElement StopTutorialText;
			
			
			
			@AndroidFindBy(id="android:id/navigationBarBackground")
			public AndroidElement Navigatehome;
		
			@AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc=\"Home\"]/android.view.ViewGroup/android.widget.TextView")
			public AndroidElement iconClickhome;
			
			

			@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.maf.sharesit:id/tutorial_tip_action_button']")
			public AndroidElement GotitIcon;
			
			@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Offers\"]/android.view.ViewGroup/android.widget.TextView")
		    public AndroidElement offersicon;
			
			//offers
			
			@AndroidFindBy(xpath ="//android.widget.TextView[@text='SHARE Offers']")
			public AndroidElement offersWelcome;
			
			@AndroidFindBy(xpath ="//android.widget.TextView[@resource-id='com.maf.sharesit:id/tutorial_tips_progress']")
			public AndroidElement NumberCountTutorialOffers;
			
			//Account
			@AndroidFindBy(xpath ="//android.widget.TextView[@text='Transaction History']")
			public AndroidElement accountWelcome;
			
			
			//Family
			@AndroidFindBy(xpath ="//android.widget.TextView[@text='Start by adding members']")
			public AndroidElement familyWelcome;
			
			//Settings
			@AndroidFindBy(xpath ="//android.widget.TextView[@text='Add your card']")
			public AndroidElement settingsWelcome;
			

}
