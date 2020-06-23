package com.share.general;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.sql.Driver;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.share.objectrepository.AccountPage;
import com.share.objectrepository.RegistrationPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class GeneralFunctions extends DriverSetUp{

	//GenericFunctions genericfunctions = new GenericFunctions();


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
		MobileElement element = (MobileElement) driver.findElementById("com.maf.sharesit:id/onboarding_already_have_account_view");
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
		RegistrationPage registrationPage = new RegistrationPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		String visibleText="Log out";

		try
		{
			Thread.sleep(5000);

			try
			{
				//Click Stop Tutorial
				if(registrationPage.StopTutorialElement.isDisplayed()==true)
				{
					registrationPage.StopTutorialElement.click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					//Click Got It
					registrationPage.GotItElement.click();
				}
			}
			catch(Exception x)
			{
				System.out.println("Stop Tutorial Not Displayed");
			}

			//Click on Account Icon
			accountPage.AccountIcon.click();
			Thread.sleep(10000);

			//Click on Settings Icon
			accountPage.SettingsIcon.click();
			Thread.sleep(10000);

			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
			Thread.sleep(5000);

			registrationPage.ConfirmLogout.click();

			Thread.sleep(5000);
		}
		catch(Exception x)
		{
			System.out.println("Logout Not Found");
		}

	}

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

		boolean existFalg = true;

		for (int i = 0; i < 20; i++) 
		{

			try
			{

				new TouchAction(driver).press(PointOption.point(width, startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(width, endPoint)).release().perform();	

				element = (AndroidElement) driver.findElementByXPath(Xpath);
				existFalg=true;
				break;


			} 
			catch (Exception ex)
			{
				System.out.println(String.format("Element not available. Scrolling (%s) times�", i + 1));
				existFalg=false;
			}
		}

		if(existFalg==false)
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
		int anchor = (int)(size.width / 2);
		//Swipe up to scroll down
		int startPoint = (int)(size.height - 5);
		int endPoint = 300;

		System.out.println("point "+startPoint+","+endPoint);

		for (int i = 0; i < rand_int; i++) 
		{

			new TouchAction(driver)
			.longPress(point(anchor, startPoint))
			.moveTo(point(anchor, endPoint)).release().perform();
			//element = (AndroidElement) driver.findElementByXPath(Xpath);

			System.out.println(String.format("Scrolling (%s) time�", i));
			Thread.sleep(2000);
		}

		try
		{
			element = (AndroidElement) driver.findElementByXPath(Xpath);
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
	 * @param driver
	 * @param locatorObject
	 */
	public void waitForElementToBeClickable(WebDriver driver, By locatorObject) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(locatorObject));
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


	public boolean calendarUp(String year) throws Exception {
		WebElement el = driver.findElementByXPath("//android.widget.ScrollView[1]");

		AndroidElement element = null;
		Dimension size = el.getSize();
		System.out.println(size);
		int start = el.getSize().getHeight();
		System.out.println(start);
		int end  = el.getLocation().getY();	
		System.out.println(end);
		int x= el.getLocation().getX();
		System.out.println(x);

		boolean existFalg = true;

		for (int i = 0; i < 40; i++) 
		{

			try
			{

				new TouchAction(driver).press(PointOption.point(x, start)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(x, end)).release().perform();	

				element = (AndroidElement) driver.findElementByXPath(year);
				existFalg=true;
				break;


			} 
			catch (Exception ex)
			{
				System.out.println(String.format("Element not available. Scrolling (%s) times�", i + 1));
				existFalg=false;
			}
		}

		if(existFalg==false)
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

	public boolean calendardown(String year) throws Exception {
		WebElement el = driver.findElementByXPath("//android.widget.ScrollView[1]");

		AndroidElement element = null;
		Dimension size = el.getSize();
		//System.out.println(size);
		int start = el.getSize().getHeight();
		//System.out.println(start);
		int end  = el.getLocation().getY();	
		//System.out.println(end);
		int x= el.getLocation().getX();
		//System.out.println(x);

		boolean existFalg = true;

		for (int i = 0; i < 40; i++) 
		{

			try
			{

				new TouchAction(driver).press(PointOption.point(x, end)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(x, start)).release().perform();	

				element = (AndroidElement) driver.findElementByXPath(year);
				existFalg=true;
				break;


			} 
			catch (Exception ex)
			{
				System.out.println(String.format("Element not available. Scrolling (%s) times�", i + 1));
				existFalg=false;
			}
		}

		if(existFalg==false)
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
	//Toast

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
}
