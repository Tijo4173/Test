package com.share.general;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.google.common.collect.ImmutableMap;
import com.share.objectrepository.ExperiencesPage;
import com.share.objectrepository.ProfilePage;
import com.share.objectrepository.SignInPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class GeneralFunctions extends DriverSetUp{

	//GenericFunctions genericfunctions = new GenericFunctions();

	public static String brandName;
	public static String deviceName;
	public static String osVersion;
	public static String buildVersion;

	public void SignIn(String username,String password,SignInPage signInPage) throws Exception
	{

		Thread.sleep(10000);
		try
		{
			if(signInPage.skipUpdate.isDisplayed()==true)
			{
				signInPage.skipUpdate.click();
			}
		}
		catch(Exception x)
		{
			System.out.println("skip Update Not Displayed");
		}

		try
		{

			if(signInPage.homeIcon.isDisplayed()==true)
			{
				System.out.println("User already logged in");
			}
		}
		catch(Exception e)
		{
			System.out.println("Login flow");

			try
			{
				if(signInPage.skipButton.isDisplayed()==true)
				{

					//Click skip
					signInPage.skipButton.click();
				}
			}
			catch(Exception x)
			{
				System.out.println("Skip Not Displayed");
			}
			Thread.sleep(2000);
			isElementPresent(signInPage.signinButton, 25);
			signInPage.signinButton.click();
			Thread.sleep(5000);

			signInPage.emailAddress.sendKeys(username);
			signInPage.password.sendKeys(password);
			signInPage.loginButton.click();
			Thread.sleep(15000);
			isElementPresent(signInPage.cancelButton, 50);
			try
			{
				if(signInPage.cancelButton.isDisplayed()==true)
				{
					signInPage.cancelButton.click();
				}
			}
			catch(Exception x)
			{
				System.out.println("Cancel Not Displayed");
			}
			Thread.sleep(6000);

			try
			{
				if(signInPage.skipUpdate.isDisplayed()==true)
				{
					signInPage.skipUpdate.click();
				}
			}
			catch(Exception x)
			{
				System.out.println("skip Update Not Displayed");
			}

		}


	}

	public static void deviceInfo() {

		Map<Object, Object> deviceDetails =  (Map<Object, Object>) driver.executeScript("mobile: deviceInfo");
		//System.out.println("TT"+deviceDetails);
		brandName = deviceDetails.get("brand").toString();
		deviceName = deviceDetails.get("model").toString();
		osVersion = deviceDetails.get("platformVersion").toString();
	//	buildVersion = driver.getStatus();
		System.out.println("build"+driver.getStatus());

	}
	public boolean selectCategory(String Category)
	  {
		  ExperiencesPage objExperiencesPage= new ExperiencesPage(driver);

		  boolean displayedFlag=false;

		  switch(Category)
		  {
		  	case "CARREFOUR OFFERS":

		  		objExperiencesPage.carrefourOffers.click();
		  		try
				{
		  			isElementPresent(objExperiencesPage.carrefourOffersPage, 30);
					if(objExperiencesPage.carrefourOffersPage.isDisplayed()==true)
					{
						displayedFlag=true;
					}
				}
				catch(Exception x)
				{
					displayedFlag=false;
				}

			    break;
			 case "SHARE OFFERS":

				 objExperiencesPage.shareOffers.click();
			  		try
					{
			  			isElementPresent(objExperiencesPage.shareOffersPage, 30);
						if(objExperiencesPage.shareOffersPage.isDisplayed()==true)
						{
							displayedFlag=true;
						}
					}
					catch(Exception x)
					{
						displayedFlag=false;
					}

			    break;
			 case "MEMBER CONTESTS":

				 objExperiencesPage.memberContests.click();
				 try
					{
			  			isElementPresent(objExperiencesPage.memberContests, 30);
						if(objExperiencesPage.memberContests.isDisplayed()==true)
						{
							displayedFlag=true;
						}
					}
					catch(Exception x)
					{
						displayedFlag=false;
					}


			 case "MEMBER BENEFITS":

				 objExperiencesPage.memberBenefits.click();
				 try
					{
			  			isElementPresent(objExperiencesPage.memberBenefits, 30);
						if(objExperiencesPage.memberBenefits.isDisplayed()==true)
						{
							displayedFlag=true;
						}
					}
					catch(Exception x)
					{
						displayedFlag=false;
					}
				    break;
		  }

		  return displayedFlag;
	  }
	public String getText(AndroidElement element)
	{
		String text = element.getText();
		return text;
	}


	public void StartActivity(String AppPackage, String AppActivity)
	{
		driver.startActivity(new Activity(AppPackage,AppActivity));
	}


	public void ClickSignIn()
	{
		MobileElement element = driver.findElementById("com.maf.sharesit:id/onboarding_already_have_account_view");
		Point p = element.getCenter();
		int Xcord =p.getX();
		int Ycord = p.getY();
		/*
		Point objPont =element.getLocation();
		int Xcord =objPont.getX();
		int Ycord = objPont.getY();
		 */
		System.out.println("Cords "+Xcord+","+Ycord);
		TouchAction action= new TouchAction(driver).tap(point(Xcord+200,Ycord)).waitAction(waitOptions(Duration.ofMillis(1000))).perform();

	}


	public void Logout() throws Exception
	{
		ProfilePage profilePage = new ProfilePage(driver);
		SignInPage signInPage = new SignInPage(driver);

		try
		{
			Thread.sleep(10000);
			if(signInPage.username.isDisplayed()==true)
			{
				System.out.println("User already logged in");

				//Click on Avatar icon
				profilePage.avatar.click();
				Thread.sleep(4000);
				ScrollDown("Version");

				//Logout
				try
				{
					if(profilePage.Logout.isDisplayed()==true)
					{
						test.log(Status.PASS, "Logout Displayed");
					}
				}
				catch(Exception x)
				{
					test.log(Status.FAIL, "Logout Not Displayed");
					Assert.fail("Logout Not Displayed");
				}

				profilePage.Logout.click();
				Thread.sleep(5000);

				//Logout Confirmation
				try
				{
					if(getText(profilePage.logoutConfirmation).contains("Are you sure you want to logout?"))
					{
						test.log(Status.PASS, "Logout Confirmation Displayed");
					}
				}
				catch(Exception x)
				{
					test.log(Status.FAIL, "Logout Confirmation Not Displayed");
					Assert.fail("Logout Confirmation Not Displayed");
				}

				//Click Yes
				profilePage.ConfirmYES.click();

				try
				{
					if(signInPage.signinButton.isDisplayed()==true)
					{
						test.log(Status.PASS, "Logout Successful");
					}
				}
				catch(Exception x)
				{
					test.log(Status.FAIL, "Logout Failed");
					Assert.fail("Logout Failed");
				}

			}
		}
		catch(Exception e)
		{
			System.out.println("User not logged in");
		}

	}


	public void swipeLeft()
	{
		new TouchAction(driver).
		longPress(point(200, 180)).moveTo(point(790, 180)).release().perform();

	}


	public void swipeHorizontal( double startPercentage, double finalPercentage, double anchorPercentage) throws Exception
	{
		Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.height * anchorPercentage);
		int startPoint = (int) (size.width * startPercentage);
		int endPoint = (int) (size.width * finalPercentage);

		new TouchAction(driver).press(PointOption.point(startPoint, anchor)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(endPoint, anchor)).release().perform();

	}


	public void SimplyScrollDown() throws Exception
	{

		new TouchAction(driver).press(PointOption.point(550, 940)).waitAction().moveTo(PointOption.point(550, 60)).release().perform();

	}


	public int elementCount(String elementXapath)
	{
		int size=0;

		List optionCount =driver.findElementsByXPath(elementXapath);

		size = optionCount.size();

		return size;


	}


	 public void skipupdate() throws Exception
	    {

	    	SignInPage signInPage = new SignInPage(driver);
			try
			{
				if(isElementPresent(signInPage.skipUpdate,30))
				{
					signInPage.skipUpdate.click();
				}else {
					System.out.println("Update screen not displayed");
				}
			}
			catch(Exception x)
			{
				System.out.println("skip Update Not Displayed");
			}
	    }
	public void seekBar(AndroidElement seekBar)
	{

		//WebElement seekBar = driver.findElement(By.id("com.cj.scrolling:id/seekbar"));
		//Get start point of seekbar.
		int startX = seekBar.getLocation().getX();
		System.out.println(startX);
		//Get end point of seekbar.
		int endX = seekBar.getSize().getWidth();
		System.out.println(endX);
		//Get vertical location of seekbar.
		int yAxis = seekBar.getLocation().getY();
		//Set slidebar move to position.
		// this number is calculated based on (offset + 3/4width)
		int moveToXDirectionAt = 500 + startX;
		System.out.println("Moving seek bar at " + moveToXDirectionAt+" In X direction.");
		//Moving seekbar using TouchAction class.
		TouchAction act=new TouchAction(driver);
		act.longPress(point(startX,yAxis)).moveTo(point(moveToXDirectionAt,yAxis)).release().perform();

	}


	public void pressEnter()
	{
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}

	public void pressSearch()
	{

		driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));

	}

	//
	//	public void Logout() throws Exception
	//	{
	//		RegistrationPage registrationPage = new RegistrationPage(driver);
	//		AccountPage accountPage = new AccountPage(driver);
	//		String visibleText="Log out";
	//
	//		try
	//		{
	//			Thread.sleep(5000);
	//
	//			try
	//			{
	//				//Click Stop Tutorial
	//				if(registrationPage.StopTutorialElement.isDisplayed()==true)
	//				{
	//					registrationPage.StopTutorialElement.click();
	//					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//
	//					//Click Got It
	//					registrationPage.GotItElement.click();
	//				}
	//			}
	//			catch(Exception x)
	//			{
	//				System.out.println("Stop Tutorial Not Displayed");
	//			}
	//
	//			//Click on Account Icon
	//			accountPage.AccountIcon.click();
	//			Thread.sleep(10000);
	//
	//			//Click on Settings Icon
	//			accountPage.SettingsIcon.click();
	//			Thread.sleep(10000);
	//
	//			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
	//			Thread.sleep(5000);
	//
	//			registrationPage.ConfirmLogout.click();
	//
	//			Thread.sleep(5000);
	//		}
	//		catch(Exception x)
	//		{
	//			System.out.println("Logout Not Found");
	//		}
	//
	//	}

	public boolean MoveToElement(String Xpath) throws Exception
	{

		AndroidElement element = null;
		Dimension size = driver.manage().window().getSize();

		//x position set to mid-screen horizontally
		int width = size.width / 2;

		//Starting y location set to 80% of the height (near bottom)
		int startPoint = (int) (size.getHeight() * 0.80);

		//Ending y location set to 20% of the height (near top)
		int endPoint = (int) (size.getHeight() * 0.20);

		boolean existFlag = true;

		for (int i = 0; i < 20; i++)
		{

			try
			{

				new TouchAction(driver).press(PointOption.point(width, startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(width, endPoint)).release().perform();

				element = driver.findElementByXPath(Xpath);
				existFlag=true;
				break;


			}
			catch (Exception ex)
			{
				System.out.println(String.format("Element not available. Scrolling (%s) timesï¿½", i + 1));
				existFlag=false;
			}
		}

		if(existFlag==false)
		{
			Assert.fail("Failed to Find the Element");
		}

		element.click();
		Thread.sleep(2000);

		if(element.isEnabled()==true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	public void RandomlyScrollToElement(String Xpath) throws Exception
	{
		AndroidElement element = null;

		Random rand = new Random();

		int rand_int = rand.nextInt(5);
		System.out.println("Random Number for swipe:  "+rand_int);

		Dimension size = driver.manage().window().getSize();
		int anchor = size.width / 2;
		//Swipe up to scroll down
		int startPoint = size.height - 5;
		int endPoint = 300;

		System.out.println("point "+startPoint+","+endPoint);

		for (int i = 0; i < rand_int; i++)
		{

			new TouchAction(driver)
			.longPress(point(anchor, startPoint))
			.moveTo(point(anchor, endPoint)).release().perform();
			//element = (AndroidElement) driver.findElementByXPath(Xpath);

			System.out.println(String.format("Scrolling (%s) timeï¿½", i));
			Thread.sleep(2000);
		}

		try
		{
			element = driver.findElementByXPath(Xpath);
		}
		catch(Exception x)
		{
			Assert.fail("Failed to Find the Element");
		}
		element.click();

	}


	public int  GenerateRandomNumber(int number)
	{

		Random rand = new Random();

		int rand_int = rand.nextInt(number);
		System.out.println("Random Number Generated:  "+rand_int);
		return rand_int;
	}



	/**
	 * Wait for element to appear on the screen
	 * @param driver
	 * @param locatorObject
	 */
	public void waitForElementToBeVisible(WebDriver driver, By locatorObject) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locatorObject));
	}

	public void ScrollDown(String strText) throws Exception
	{

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+ strText + "\").instance(0))");
	}


	/**
	 * Waits for element to clickable
	 * @param WebElement
	 */
	public boolean isElementToBeClickable(WebElement element, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public boolean isElementInvisible(WebElement element, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.invisibilityOf(element));
			return true;
		}catch(Exception e){
			return false;
		}

	}

	public boolean isElementToBeSelected(WebElement element, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.elementToBeSelected(element));
			return true;
		}catch(Exception e){
			return false;
		}
	}


	/*	protected MobileElement scrollToElementByTextContains(String text) {
	    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\" + text + "\").instance(0));
	}
	 */
	public boolean isElementPresent(MobileElement elementName, int timeout){
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(elementName));
			return true;
		}catch(Exception e){
			return false;
		}
	}

	//Call this function for Capture toast

	public boolean isElementPresence(By elementName, int timeout){
		try{
			WebDriverWait waitForToast = new WebDriverWait(driver, timeout);
			waitForToast.until(ExpectedConditions.presenceOfElementLocated(elementName));
			//			String toastMessage = driver.findElement(elementName).getText();
			//			System.out.println(toastMessage);
			return true;
		}catch(Exception e){
			return false;
		}
	}


//*****************************CalendarScroll*********************//
//	public boolean calendarUp(String year) throws Exception {
//		WebElement el = driver.findElementByXPath("//android.widget.ScrollView[1]");
//
//		AndroidElement element = null;
//		Dimension size = el.getSize();
//		System.out.println(size);
//		int start = el.getSize().getHeight();
//		System.out.println(start);
//		int end  = el.getLocation().getY();
//		System.out.println(end);
//		int x= el.getLocation().getX();
//		System.out.println(x);
//
//		boolean existFlag = true;
//
//		for (int i = 0; i < 40; i++)
//		{
//
//			try
//			{
//
//				new TouchAction(driver).press(PointOption.point(x, start)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(x, end)).release().perform();
//
//				element = driver.findElementByXPath(year);
//				existFlag=true;
//				break;
//
//
//			}
//			catch (Exception ex)
//			{
//				System.out.println(String.format("Element not available. Scrolling (%s) times", i + 1));
//				existFlag=false;
//			}
//		}
//
//		if(existFlag==false)
//		{
//			Assert.fail("Failed to Find the Element");
//		}
//
//		element.click();
//		Thread.sleep(2000);
//
//		if(element.isEnabled()==true)
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
//
//	}

	//*****************************CalendarScroll*********************//
//	public boolean calendardown(String year) throws Exception {
//		WebElement el = driver.findElementByXPath("//android.widget.ScrollView[1]");
//
//		AndroidElement element = null;
//		Dimension size = el.getSize();
//		//System.out.println(size);
//		int start = el.getSize().getHeight();
//		//System.out.println(start);
//		int end  = el.getLocation().getY();
//		//System.out.println(end);
//		int x= el.getLocation().getX();
//		//System.out.println(x);
//
//		boolean existFlag = true;
//
//		for (int i = 0; i < 40; i++)
//		{
//
//			try
//			{
//
//				new TouchAction(driver).press(PointOption.point(x, end)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(x, start)).release().perform();
//
//				element = driver.findElementByXPath(year);
//				existFlag=true;
//				break;
//
//
//			}
//			catch (Exception ex)
//			{
//				System.out.println(String.format("Element not available. Scrolling (%s) times", i + 1));
//				existFlag=false;
//			}
//		}
//
//		if(existFlag==false)
//		{
//			Assert.fail("Failed to Find the Element");
//		}
//
//		element.click();
//		Thread.sleep(2000);
//
//		if(element.isEnabled()==true)
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
//
//	}

	//************************************************Toast
	public String toastMessages() {
		WebDriverWait waitForToast = new WebDriverWait(driver,25);

		waitForToast.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));

		String toastMessage = driver.findElement((By.xpath("/hierarchy/android.widget.Toast"))).getText();
		System.out.println(toastMessage);
		return toastMessage ;
	}



	public void rightLeftSwipe() throws Exception {
		Thread.sleep(500);
		Dimension size = driver.manage().window().getSize();
		System.out.println(size);
		int endx = (int) (size.width * 0.8);
		System.out.println(endx);
		int startx = (int) (size.width * 0.20);
		System.out.println(startx);
		int starty = size.height / 2;
		System.out.println(starty);
		for(int i=0;i<=3;i++) {
			//   appiumDriver..swipe(startx, starty, endx, starty, 1000);
			new TouchAction(driver).press(PointOption.point(startx, starty)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(endx, starty)).release().perform();

		}
	}


	public void leftRightSwipe() throws Exception {
		Thread.sleep(1000);
		Dimension size = driver.manage().window().getSize();
		System.out.println(size);
		int startx = (int) (size.width * 0.8);
		System.out.println(startx);
		int endx = (int) (size.width * 0.20);
		System.out.println(endx);
		int starty = size.height / 2;
		System.out.println(starty);
		for(int i=0;i<=3;i++) {
			new TouchAction(driver).press(PointOption.point(endx, starty)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(startx, starty)).release().perform();

		}
	}
	//SWIPE GENERIC

	public void swipeScreen(Directions dir) {
		//  System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

		// Animation default time:
		//  - Android: 300 ms
		//  - iOS: 200 ms
		// final value depends on your app and could be greater
		final int ANIMATION_TIME = 200; // ms

		final int PRESS_TIME = 200; // ms

		int edgeBorder = 10; // better avoid edges
		PointOption pointOptionStart, pointOptionEnd;
		//  System.out.println("STart----");
		// init screen variables
		Dimension dims = driver.manage().window().getSize();
		//System.out.println("Di----"+dims);
		// init start point = center of screen
		pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
		//System.out.println("Point=====----"+pointOptionStart);
		//System.out.println("Switch=====----");
		switch (dir) {

		case DOWN: // center of footer
			pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
			break;
		case UP: // center of header
			pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
			break;
		case LEFT: // center of left side
			pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
			break;
		case RIGHT: // center of right side
			pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
			break;
		default:
			throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
		}
		System.out.println("Switch end=====----");
		// execute swipe using TouchAction
		try {
			new TouchAction(driver)
			.press(pointOptionStart)
			// a bit more reliable when we add small wait
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
			.moveTo(pointOptionEnd)
			.release().perform();
		} catch (Exception e) {
			System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
			return;
		}
		System.out.println("Switch swipe=====----");
		// always allow swipe action to complete
		try {
			Thread.sleep(ANIMATION_TIME);
		} catch (InterruptedException e) {
			// ignore
		}
	}

	public enum Directions {
		UP,
		DOWN,
		LEFT,
		RIGHT;
	}

	public boolean viewComparison(String view) {

		String WebViewEl = driver.getContextHandles().toString();
		if(WebViewEl.equals(view)) {
			return true;
		}else {
			return false;
		}
	}

	public void swipeElementAndroid(MobileElement el, Directions dir, String year) {

		AndroidElement element = null;
		System.out.println("swipeElementAndroid(): dir: '" + dir + "'"); // always log your actions

		final int ANIMATION_TIME = 2000; // ms

		final int PRESS_TIME = 2000; // ms

		int edgeBorder;
		PointOption pointOptionStart, pointOptionEnd;

		// init screen variables
		Rectangle rect = el.getRect();
		// sometimes it is needed to configure edgeBorders
		// you can also improve borders to have vertical/horizontal
		// or left/right/up/down border variables
		edgeBorder = 0;

		switch (dir) {
		case DOWN: // from up to down
			pointOptionStart = PointOption.point(rect.x + rect.width / 2,
					rect.y + edgeBorder);
			pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
					rect.y + rect.height - edgeBorder);
			break;
		case UP: // from down to up
			pointOptionStart = PointOption.point(rect.x + rect.width / 2,
					rect.y + rect.height - edgeBorder);
			pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
					rect.y + edgeBorder);
			break;

		default:
			throw new IllegalArgumentException("swipeElementAndroid(): dir: '" + dir + "' NOT supported");
		}
		boolean Flag = true;
		for(int i =0;i<40;i++) {

			// execute swipe using TouchAction
			  try {
			new TouchAction(driver)
			.press(pointOptionStart)
			// a bit more reliable when we add small wait
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
			.moveTo(pointOptionEnd)
			.release().perform();

				element = driver.findElementByXPath("//android.widget.TextView[@text='"+year+"']");
				Flag = true;
				break;

			}catch(Exception e) {
				e.printStackTrace();
				Flag = false;
				  System.err.println("swipeElementAndroid(): TouchAction FAILED\n" + e.getMessage());
			}
		}
			if( Flag == true) {
				System.out.println("IFFFFFFFFFF"+Flag);
				element.click();

			}

		// always allow swipe action to complete
		try {
			Thread.sleep(ANIMATION_TIME);
		} catch (InterruptedException e) {
			// ignore
		}
	}

}
