package com.share.functions;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.HomePage;
import com.share.objectrepository.SignInPage;
import com.share.objectrepository.SplashScreenPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class SignInFunctions extends DriverSetUp{

	GeneralFunctions generalFunctions = new GeneralFunctions();

	public String username = map.get("UserName").toString();
	public String userpass	= map.get("UserPassword").toString();
	String resetid = map.get("ResetEmailid").toString();
	String nonusername =  map.get("NonuserName").toString();
	String invalidpass = map.get("InvalidPass").toString();
	String invalidusername =  map.get("InvalidEmailid").toString();
	String activatedofferuser =  map.get("Offers_UserEmail").toString();
	String activatedofferpass =  map.get("Offers_UserPassword").toString();

	public void useremailid(SignInPage signInPage) {
		signInPage.useridElement.sendKeys(username);
	}
	public void nonuseremailid(SignInPage signInPage) {
		signInPage.useridElement.sendKeys(nonusername);
	}
	public void invalidEmail(SignInPage signInPage) {
		signInPage.useridElement.sendKeys(invalidusername);
	}
	public void userpassword(SignInPage signInPage) {
		signInPage.userpassElement.sendKeys(userpass);
	}
	public void signInButton(SignInPage signInPage) {
		signInPage.signinElement.click();
	}
	public void forgotButton(SignInPage signInPage) {
		signInPage.forgotElement.click();
	}
	public void resetPassword(SignInPage signInPage) {
		signInPage.resetPassElement.click();
	}
	public void resetEmail(SignInPage signInPage) {
		signInPage.resetemailElement.sendKeys(resetid);
	}
	public boolean validateEmail(SignInPage signInPage) {
		return signInPage.validateElement.isEnabled();
	}
	public boolean tutorialScreen(SignInPage signInPage) {
		return signInPage.tutorialElement.isDisplayed();
	}
	public boolean homeScreen(SignInPage signInPage) {
		return signInPage.homeElement.isDisplayed();
	}
	public String getSignInError(SignInPage signinPage) {
		String errorMessage=signinPage.SignInErrorElement.getText();
		return errorMessage;
	}


	public void invalidpass(SignInPage signInPage)
	{
		signInPage.userpassElement.sendKeys(invalidpass);
	}

	public void SignInUser(SignInPage signInPage) {
		MobileElement element = driver.findElementById("tv_sign_in");
		Point p = element.getCenter();
		int Xcord =p.getX();
		int Ycord = p.getY();
		System.out.println("Cords "+Xcord+","+Ycord);//changing the xcord for run on emulator
		TouchAction action= new TouchAction(driver).tap(point(Xcord+350,Ycord)).waitAction(waitOptions(Duration.ofMillis(1000))).perform();
		useremailid(signInPage);
		userpassword(signInPage);
		signInButton(signInPage);

	}

	public void signInClick(SignInPage signInPage) {
		MobileElement element = driver.findElementById("tv_sign_in");
		Point p = element.getCenter();
		int Xcord =p.getX();
		int Ycord = p.getY();
		System.out.println("Cords "+Xcord+","+Ycord);
		TouchAction action= new TouchAction(driver).tap(point(Xcord+350,Ycord)).waitAction(waitOptions(Duration.ofMillis(1000))).perform();

	}

	public void contactUs(SignInPage signInPage) {
		MobileElement element = driver.findElementById("onboarding_contact_us");
		Point p = element.getCenter();
		int Xcord =p.getX();
		int Ycord = p.getY();
		System.out.println("Cords "+Xcord+","+Ycord);
		TouchAction action= new TouchAction(driver).tap(point(Xcord+50,Ycord)).waitAction(waitOptions(Duration.ofMillis(1000))).perform();

	}


	public void validUserLogin() {

		SignInPage signInPage = new SignInPage(driver);
		HomePage homePage = new HomePage(driver);
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		try {

			if(generalFunctions.isElementPresent(homePage.homeElement, 30)) {
				System.out.println("User already Login");
			}else  {
				System.out.println("User NOT Logged in");
				splashScreenFunctions.splashScreenSkip(splashScreenPage);
				generalFunctions.isElementPresent(signInPage.signinPresent, 60);
				signInPage.signinPresent.click();
				generalFunctions.isElementPresent(signInPage.useridElement, 60);
				signInPage.useridElement.sendKeys(username);
				signInPage.userpassElement.sendKeys(userpass);
				signInButton(signInPage);
				generalFunctions.skipupdate();
				generalFunctions.isElementPresent(homePage.homeElement, 30);
			}
		}catch(Exception e) {
			e.getCause();
			e.printStackTrace();
			e.getMessage();
			test.fail("Error Occured");
		}
	}

	////for quickSignIn
	public void quickSignIn() {
		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		SignInPage signInPage = new SignInPage(driver);
		HomePage homePage = new HomePage(driver);
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		try {
			splashScreenFunctions.splashScreenSkip(splashScreenPage);
			generalFunctions.isElementPresent(signInPage.signinPresent, 90);
			signInPage.signinPresent.click();
			generalFunctions.isElementPresent(signInPage.useridElement, 60);
			signInPage.useridElement.sendKeys(username);
			signInPage.userpassElement.sendKeys(userpass);
			signInButton(signInPage);
			generalFunctions.skipupdate();
			generalFunctions.isElementPresent(homePage.homeElement, 5);

		}catch(Exception e) {
			e.getCause();
			e.printStackTrace();
			e.getMessage();
			test.fail("Error Occured");
		}
	}
	public String signInErrortoast() {
		String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[@index = '1']")).getText();
		return toastMessage;
	}
	public String sendAgaintoast() {
		String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[@index = '1']")).getText();
		return toastMessage;
	}

	public void ActivatedOfferUser() {

		SignInPage signInPage = new SignInPage(driver);
	    HomePage homePage = new HomePage(driver);
	        try {

	        if(generalFunctions.isElementPresent(homePage.homeElement, 10)) {
	            System.out.println("User already Login");
	        }else  {
	           System.out.println("User NOT Logged in");

	        generalFunctions.isElementPresent(signInPage.signinPresent, 60);
	        signInPage.signinPresent.click();
	        generalFunctions.isElementPresent(signInPage.useridElement, 60);
	        signInPage.useridElement.sendKeys(activatedofferuser);
	        signInPage.userpassElement.sendKeys(activatedofferpass);
	        signInButton(signInPage);
	        generalFunctions.isElementPresent(homePage.homeElement, 30);
	      }
	    }catch(Exception e) {
	        e.getCause();
	        e.printStackTrace();
	        e.getMessage();
	        test.fail("Error Occured");
	    }
	    }
}
