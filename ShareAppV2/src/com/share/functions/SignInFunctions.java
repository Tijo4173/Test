package com.share.functions;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.time.Duration;

import org.openqa.selenium.Point;

import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.SignInPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class SignInFunctions extends DriverSetUp{
	GeneralFunctions generalFunctions;
	String username = map.get("UserName").toString();
	String userpass	= map.get("UserPassword").toString();
	String resetid = map.get("ResetEmailid").toString();
	String nonusername =  map.get("NonuserName").toString();
	String invalidpass = map.get("InvalidPass").toString();
	String invalidusername =  map.get("InvalidEmailid").toString();
	
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
		MobileElement element = (MobileElement) driver.findElementById("tv_sign_in");
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
		MobileElement element = (MobileElement) driver.findElementById("tv_sign_in");
		Point p = element.getCenter();
		int Xcord =p.getX();
		int Ycord = p.getY();
		System.out.println("Cords "+Xcord+","+Ycord);
		TouchAction action= new TouchAction(driver).tap(point(Xcord+350,Ycord)).waitAction(waitOptions(Duration.ofMillis(1000))).perform();
		
}
	
	public void contactUs(SignInPage signInPage) {
		MobileElement element = (MobileElement) driver.findElementById("onboarding_contact_us");
		Point p = element.getCenter();
		int Xcord =p.getX();
		int Ycord = p.getY();
		System.out.println("Cords "+Xcord+","+Ycord);
		TouchAction action= new TouchAction(driver).tap(point(Xcord+50,Ycord)).waitAction(waitOptions(Duration.ofMillis(1000))).perform();
		
	}
	
	
	public void validUserLogin(SignInPage signInPage) {

		signInPage.signinPresent.click();
		//generalFunctions.isElementPresent(signInPage.useridElement, 90);
		signInPage.useridElement.sendKeys(username);
		signInPage.userpassElement.sendKeys(userpass);
		signInButton(signInPage);
		
	}
	
}