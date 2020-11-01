package com.share.functions;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.general.GeneralFunctions.Directions;
import com.share.objectrepository.HomePage;
import com.share.objectrepository.RegistrationPage;
import com.share.objectrepository.SignInPage;
//import com.sun.jdi.Location;
import com.share.objectrepository.SplashScreenPage;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class RegistrationFunctions extends DriverSetUp{

	String email;
	String phone;
	String number;
	String lastname;
	WebElement button;
	WebDriverWait wait;

	String existingEmail = map.get("email").toString();
	String mobileNumber = map.get("MobileNumber").toString();
	String dvmobileNumber = map.get("dvmobile").toString();
	String emailAddress=map.get("EmailAddress").toString();
	String firstName =map.get("FirstName").toString();
	String dvfirstName =map.get("dvfirst").toString();
	String lastName = map.get("Surname").toString();
	String dvlastName = map.get("dvlast").toString();
	String password = map.get("Password").toString();
	String dvpassword = map.get("dvpassword").toString();
	String confirmPassword = map.get("ConfirmPassword").toString();
	String dvconfirmPassword = map.get("dvconfirm").toString();
	String date = map.get("Date").toString();
	String month = map.get("Month").toString();
	String year = map.get("Year").toString();
	String invalidyear = map.get("inYear").toString();
	String title = map.get("Title").toString();
	String cCode = map.get("CountryCode").toString();
	String psemail = map.get("psemail").toString();
	String psemailid = map.get("psemailid").toString();
	String fdemail = map.get("fdemail").toString();
	String bvyear = map.get("byear").toString();
	String dvemail = map.get("dvemail").toString();
	String dvemailid = map.get("dvemailid").toString();
	String dvremail = map.get("dvremail").toString();
	String dvryemail = map.get("dvryemail").toString();
	String dvroemail = map.get("dvroemail").toString();
	String inmobnum = map.get("indiaNumber").toString();
	public	String eemail = map.get("eemail").toString();
	public	String efirstname = map.get("efirstname").toString();
	public	String elastname = map.get("elastname").toString();
	public	String invalidusername =  map.get("InvalidEmailid").toString();
	public String clearemail = map.get("clearEmail").toString();
	public String reenterEmail = map.get("reEnterEmail").toString();
	public String modifyEmail = map.get("modifyEmail").toString();


	GeneralFunctions generalFunctions = new GeneralFunctions();

//	public boolean nextEnabled(RegistrationPage registrationPage) {
//		return registrationPage.continueButton.isDisplayed();
//	}
	public boolean nextbuttonEnabled(RegistrationPage registrationPage) {
		return registrationPage.continueButton.isEnabled();
	}
	public void onBoardScreen(RegistrationPage registrationPage) {
		registrationPage.onboardScreen.click();
	}

	public void nextButton(RegistrationPage registrationPage) {
		registrationPage.continueButton.click();
	}

	public void startButton(RegistrationPage registrationPage) {
		registrationPage.startElement.click();
	}
	public void emailId(RegistrationPage registrationPage) {
		registrationPage.emailElement.sendKeys(emailAddress);
	}
	public void psemail(RegistrationPage registrationPage) {
		registrationPage.emailElement.sendKeys(psemail);
	}
	public void psemailid(RegistrationPage registrationPage) {
		registrationPage.emailElement.sendKeys(psemailid);
	}
	public void fdemailid(RegistrationPage registrationPage) {
		registrationPage.emailElement.sendKeys(fdemail);
	}
	public void dvemail(RegistrationPage registrationPage) {
		registrationPage.emailElement.sendKeys(dvemail);
	}
	public void dvemailid(RegistrationPage registrationPage) {
		registrationPage.emailElement.sendKeys(dvemailid);
	}
	public void dvremail(RegistrationPage registrationPage) {
		registrationPage.emailElement.sendKeys(dvremail);
	}
	public void dvryemail(RegistrationPage registrationPage) {
		registrationPage.emailElement.sendKeys(dvryemail);
	}
	public void dvroemail(RegistrationPage registrationPage) {
		registrationPage.emailElement.sendKeys(dvroemail);
	}
	public void emailidClear(RegistrationPage registrationPage) {
		registrationPage.emailidPresent.clear();
	}
	public boolean emailidPresent(RegistrationPage registrationPage) {
		return registrationPage.emailidPresent.isDisplayed();
	}
	public void existingEmail(RegistrationPage registrationPage) {
		registrationPage.emailElement.sendKeys(existingEmail);
	}
	public boolean countryCodePresent(RegistrationPage registrationPage) {
		return registrationPage.countryElement.isDisplayed();

	}
	public void countryCode(RegistrationPage registrationPage) {
		registrationPage.countryCode.click();
		generalFunctions.isElementPresent(registrationPage.countryCodeFrame, 60);
		//System.out.println(countryCode);
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"+93\").instance(0))"));
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"+263\").instance(0))"));
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+cCode+"\"))").click();
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"+91\"))").click();
		//System.out.println(countryCode);

	}

	public void countryCodeData(String code) {
		RegistrationPage registrationPage = new RegistrationPage(driver);
		registrationPage.countryCode.click();
		generalFunctions.isElementPresent(registrationPage.countryCodeFrame, 60);
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceIdMatches(\".*rv_country_code.*\").scrollable(true))" +
				".scrollIntoView(new UiSelector().text(\""+code+"\"))")).click();

	}

	public void countryCodeDefault(RegistrationPage registrationPage) {
		registrationPage.countryCode.click();
		generalFunctions.isElementPresent(registrationPage.countryCodeFrame, 60);
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"+971\").instance(0))")).click();
	}
	public boolean mobileNumberFieldPresent(RegistrationPage registrationPage) {
		return registrationPage.mobileNumElement.isDisplayed();
	}
	public void mobileNumber(RegistrationPage registrationPage) {
		registrationPage.mobileNumElement.sendKeys(mobileNumber);
	}

	public void inmobileNumber(RegistrationPage registrationPage) {
		registrationPage.mobileNumElement.sendKeys(inmobnum);
	}

	public void dvmobileNumber(RegistrationPage registrationPage) {
		registrationPage.mobileNumElement.sendKeys(dvmobileNumber);
		System.out.println(dvmobileNumber);
	}
	public void mobileNumberClear(RegistrationPage registrationPage) {
		String st = registrationPage.mobilenumPresent.getText().toString();
		System.out.println(st);
		registrationPage.mobilenumPresent.clear();
	}
	public void titledropdown(RegistrationPage registrationPage) {
		registrationPage.titlePresent.click();
	}

	public void title(RegistrationPage registrationPage) {
		registrationPage.titlePresent.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Title\"))").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Mrs\"))").click();
	}
	public boolean firstNameField(RegistrationPage registrationPage) {
		return registrationPage.firstNameElement.isDisplayed();
	}
	public void firstName(RegistrationPage registrationPage) {
		registrationPage.firstNameElement.sendKeys(firstName);
	}
	public void dvfirstName(RegistrationPage registrationPage) {
		registrationPage.firstNameElement.sendKeys(dvfirstName);
	}
	public void firstNametap(RegistrationPage registrationPage) {
		registrationPage.firstNameElement.click();
	}
	public void firstNameClear(RegistrationPage registrationPage) {
		registrationPage.firstNamePresent.clear();
	}

	public boolean lastNameField(RegistrationPage registrationPage) {
		return registrationPage.lastNameElement.isEnabled();
	}
	public void lastName(RegistrationPage registrationPage) {
		registrationPage.lastNameElement.sendKeys(lastName);
	}
	public void dvlastName(RegistrationPage registrationPage) {
		registrationPage.lastNameElement.sendKeys(dvlastName);
	}
	public void lastnametap(RegistrationPage registrationPage) {
		registrationPage.lastNameElement.click();
	}
	public void lastNameClear(RegistrationPage registrationPage) {
		registrationPage.lastNamePresent.clear();
	}
	public void passwordText(RegistrationPage registrationPage) {
		registrationPage.passwordElement.sendKeys(password);
	}
	public void dvpasswordText(RegistrationPage registrationPage) {
		registrationPage.passwordElement.sendKeys(dvpassword);
	}
	public boolean passwordFields(RegistrationPage registrationPage) {
		return registrationPage.passwordElement.isDisplayed();
	}
	public void passwordTextClear(RegistrationPage registrationPage) {
		registrationPage.passwordPresent.clear();
	}
	public String passwordPresent(RegistrationPage registrationPage) {
		return registrationPage.passwordPresent.getText().toString();
	}
	public boolean passwordCriteriaA(RegistrationPage registrationPage) {
		return registrationPage.passwordCriteriaA.isDisplayed();
	}
	public boolean passwordCriteriaB(RegistrationPage registrationPage) {
		return registrationPage.passwordCriteriaB.isDisplayed();
	}
	public boolean passwordCriteriaC(RegistrationPage registrationPage) {
		return registrationPage.passwordCriteriaC.isDisplayed();
	}

	public boolean confirmPasswordField(RegistrationPage registrationPage) {
		return registrationPage.confirmPasswordElement.isEnabled();
	}
	public void confirmpasswordClick(RegistrationPage registrationPage) {
		registrationPage.confirmPasswordElement.click();
	}
	public void passwordTap(RegistrationPage registrationPage) {
		registrationPage.passwordElement.click();
	}

	public void confirmpasswordText(RegistrationPage registrationPage) {
		registrationPage.confirmPasswordElement.sendKeys(confirmPassword);
	}
	public void dvconfirmpasswordText(RegistrationPage registrationPage) {
		registrationPage.confirmPasswordElement.sendKeys(dvconfirmPassword);
	}
	public void confirmPasswordClear(RegistrationPage registrationPage) {
		registrationPage.confirmPasswordPresent.clear();
	}
	public String confirmPasswordPresent(RegistrationPage registrationPage) {
		return registrationPage.confirmPasswordPresent.getText().toString();
	}
	public boolean closeButton(RegistrationPage registrationPage) {
		return registrationPage.closeElement.isDisplayed();
	}
	public void closeButtonClick(RegistrationPage registrationPage) {
		registrationPage.closeElement.click();
	}
	public boolean termsButtonisEnabled(RegistrationPage registrationPage) {
		return registrationPage.termsCheckboxElement.isDisplayed();
	}
	public void termsButton(RegistrationPage registrationPage) {
		registrationPage.termsCheckboxElement.click();
	}
	public boolean offerssButtonisEnabled(RegistrationPage registrationPage) {
		return registrationPage.offersCheckboxElement.isDisplayed();
	}
	public void offersButton(RegistrationPage registrationPage) {
		registrationPage.offersCheckboxElement.click();
	}
	public void thanksButton(RegistrationPage registrationPage) {
		registrationPage.thanksElement.click();
	}
	public boolean thanksButtonPresent(RegistrationPage registrationPage) {
		return registrationPage.thanksElement.isDisplayed();
	}
	public boolean connectionErrorPresent(RegistrationPage registrationPage) {
		return registrationPage.ErrorElement.isDisplayed();
	}
	public boolean startButtonPresent(RegistrationPage registrationPage) {
		return registrationPage.startElement.isDisplayed();
	}
	public boolean titlefield(RegistrationPage registrationPage) {
		return registrationPage.titlePresent.isDisplayed();
	}
	public boolean emailEntryScreen(RegistrationPage registrationPage) {
		return registrationPage.emailElement.isDisplayed();
	}
	public boolean nationalitySelection(RegistrationPage registrationPage) {
		return registrationPage.nationalityElement.isEnabled();
	}
	public void nationalityClick(RegistrationPage registrationPage) {
		GeneralFunctions generalFunctions = new GeneralFunctions();
		generalFunctions.isElementPresent(registrationPage.nationalityElement, 90);
		registrationPage.nationalityElement.click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"ALBANIA\"))").click();

	}
	public boolean onboardScreenDisplayed(RegistrationPage registrationPage) {
		return registrationPage.onboardScreen.isDisplayed();
	}
	public boolean lastScrollScreen(RegistrationPage registrationPage) {
		return registrationPage.onboardScrolld.isDisplayed();
	}



	public void cleardata(RegistrationPage registrationPage) throws Exception {
		GeneralFunctions generalFunctions = new GeneralFunctions();
		//generalFunctions.isElementPresent(registrationPage.titlePresent, 90);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//registrationPage.titlePresent.clear();
		generalFunctions.isElementPresent(registrationPage.firstNamePresent, 90);
		registrationPage.firstNamePresent.clear();
		generalFunctions.isElementPresent(registrationPage.lastNamePresent, 90);
		registrationPage.lastNamePresent.clear();
		generalFunctions.isElementPresent(registrationPage.emailidPresent, 90);
		registrationPage.emailidPresent.clear();


	}
	public String GetMessage(RegistrationPage registrationPage)
	{
		String objMessage = registrationPage.errorMessage.getText();
		return objMessage;
	}

	public String getErrorMessage(RegistrationPage registrationPage) {
		String errMessage=registrationPage.infobipError.getText();
		return errMessage;
	}

	public void PressENTER()
	{
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}

	public List<AndroidElement> getValues()
	{
		List<AndroidElement> allitems= driver.findElementsById("com.maf.sharesit:id/title");

		return allitems;
	}
	public Boolean GetValues(RegistrationPage registrationPage)
	{
		Boolean found = false;
		getValues();

		List<AndroidElement> ele = getValues();
		int size=0;
		size = size+ele.size();
		System.out.println("size : "+size);

		for (int i = 0; i < size; i++)
		{

			String titles = ele.get(i).getText();
			System.out.println("titles : "+titles);
			if(titles.contains("Mr")||titles.contains("Miss")||titles.contains("Ms")||titles.contains("Mrs"))
			{
				found = true;
			}
		}
		return found;
	}
	public boolean datePicker(RegistrationPage registrationPage) {
		return registrationPage.datePicker.isDisplayed();
	}
	public void datePickerSpinner(RegistrationPage registrationPage) {
		// MONTH
		try {
			System.out.println("Month");
			MobileElement dropDown = driver.findElement(By.xpath("//android.widget.DatePicker[@index='2']"));
			List<MobileElement> scrollDown = dropDown.findElements(By.xpath("//android.widget.NumberPicker[@index='0']/android.widget.Button[@index='0']"));
			String st = scrollDown.get(0).getText().toString();
			//System.out.println(st);
			String a = month;
			//System.out.println(a);
			for(int i=0;i<11;i++) {
				List<MobileElement> Present = dropDown.findElements(By.xpath("//android.widget.NumberPicker[@index='0']/android.widget.EditText[@index='1']"));
				String su = Present.get(0).getText().toString();
				System.out.println(su);

				if(a.equalsIgnoreCase(su)) {
					//System.out.println("Current"+su);
					break;


				}else {
					scrollDown.get(0).click();
					Thread.sleep(500);
					//System.out.println(i);
				}
			}
		}catch(Exception e) {
			System.out.println("Month is already Set");
		}

		//DATE

		try {
			System.out.println("Date");
			MobileElement dropDown = driver.findElement(By.xpath("//android.widget.DatePicker[@index='2']"));
			List<MobileElement> scrollDown = dropDown.findElements(By.xpath("//android.widget.NumberPicker[@index='1']/android.widget.Button[@index='0']"));
			String st = scrollDown.get(0).getText().toString();
			int b = Integer.parseInt(st);
			//System.out.println(st);
			List<MobileElement> Present = dropDown.findElements(By.xpath("//android.widget.NumberPicker[@index='1']/android.widget.EditText[@index='1']"));
			String su = Present.get(0).getText().toString();
			int c = Integer.parseInt(su);
			//System.out.println(su);
			List<MobileElement> scrollUp = dropDown.findElements(By.xpath("//android.widget.NumberPicker[@index='1']/android.widget.Button[@index='2']"));
			String sv = scrollUp.get(0).getText().toString();
			int d = Integer.parseInt(sv);
			//System.out.println(sv);
			int a = Integer.parseInt(date);
			System.out.println(date);
			if(a<c) {
				for(int i=a;i<c;i++) {

					scrollDown.get(0).click();
					//System.out.println(c);
				}
			}else if (a>c){
				for(int i=a;i>c;i--) {
					scrollUp.get(0).click();
					//System.out.println(c);
				}
			}

		}catch(Exception e){
			e.printStackTrace();
			System.out.println("The date is already set");
		}

		//YEAR
		try {
			System.out.println("Year");
			MobileElement dropDown = driver.findElement(By.xpath("//android.widget.DatePicker[@index='2']"));
			List<MobileElement> scrollDown = dropDown.findElements(By.xpath("//android.widget.NumberPicker[@index='2']/android.widget.Button[@index='0']"));
			String st = scrollDown.get(0).getText().toString();
			int b = Integer.parseInt(st);
			//System.out.println(st);
			List<MobileElement> Present = dropDown.findElements(By.xpath("//android.widget.NumberPicker[@index='2']/android.widget.EditText[@index='1']"));
			String su = Present.get(0).getText().toString();
			int c = Integer.parseInt(su);
			//System.out.println(su);
			List<MobileElement> scrollUp = dropDown.findElements(By.xpath("//android.widget.NumberPicker[@index='2']/android.widget.Button[@index='2']"));
			String sv = scrollUp.get(0).getText().toString();
			int d = Integer.parseInt(sv);
			//System.out.println(sv);
			int a = Integer.parseInt(year);
			if(a<c) {
				for(int i=a;i<c;i++) {

					scrollDown.get(0).click();
					//System.out.println(c);
				}
			}else if (a>c){
				for(int i=a;i>c;i--) {
					scrollUp.get(0).click();
					//System.out.println(c);
				}
			}

		}catch(Exception e){
			e.printStackTrace();
			System.out.println("The year is already set");
		}
	}
	//Button validation
	public void bvdatePickerSpinner(RegistrationPage registrationPage) {
		try {
			System.out.println("Date");
			MobileElement dropDown = driver.findElement(By.xpath("//android.widget.DatePicker[@index='2']"));
			List<MobileElement> scrollDown = dropDown.findElements(By.xpath("//android.widget.NumberPicker[@index='1']/android.widget.Button[@index='0']"));
			String st = scrollDown.get(0).getText().toString();
			int b = Integer.parseInt(st);
			//System.out.println(st);
			List<MobileElement> Present = dropDown.findElements(By.xpath("//android.widget.NumberPicker[@index='1']/android.widget.EditText[@index='1']"));
			String su = Present.get(0).getText().toString();
			int c = Integer.parseInt(su);
			//System.out.println(su);
			List<MobileElement> scrollUp = dropDown.findElements(By.xpath("//android.widget.NumberPicker[@index='1']/android.widget.Button[@index='2']"));
			String sv = scrollUp.get(0).getText().toString();
			int d = Integer.parseInt(sv);
			//System.out.println(sv);
			int a = Integer.parseInt(date);
			System.out.println(date);
			if(a<c) {
				for(int i=a;i<c;i++) {

					scrollDown.get(0).click();
					//System.out.println(c);
				}
			}else if (a>c){
				for(int i=a;i>c;i--) {
					scrollUp.get(0).click();
					//System.out.println(c);
				}
			}

		}catch(Exception e){
			e.printStackTrace();
			System.out.println("The date is already set");
		}
		// MONTH
		try {
			System.out.println("Month");
			MobileElement dropDown = driver.findElement(By.xpath("//android.widget.DatePicker[@index='2']"));
			List<MobileElement> scrollDown = dropDown.findElements(By.xpath("//android.widget.NumberPicker[@index='0']/android.widget.Button[@index='0']"));
			String st = scrollDown.get(0).getText().toString();
			//System.out.println(st);
			String a = month;
			//System.out.println(a);
			for(int i=0;i<11;i++) {
				List<MobileElement> Present = dropDown.findElements(By.xpath("//android.widget.NumberPicker[@index='0']/android.widget.EditText[@index='1']"));
				String su = Present.get(0).getText().toString();
				System.out.println(su);

				if(a.equalsIgnoreCase(su)) {
					//System.out.println("Current"+su);
					break;


				}else {
					scrollDown.get(0).click();
					Thread.sleep(500);
					//System.out.println(i);
				}
			}
		}catch(Exception e) {
			System.out.println("Month is already Set");
		}
		//YEAR
		try {
			System.out.println("Year");
			MobileElement dropDown = driver.findElement(By.xpath("//android.widget.DatePicker[@index='2']"));
			List<MobileElement> scrollDown = dropDown.findElements(By.xpath("//android.widget.NumberPicker[@index='2']/android.widget.Button[@index='0']"));
			String st = scrollDown.get(0).getText().toString();
			int b = Integer.parseInt(st);
			//System.out.println(st);
			List<MobileElement> Present = dropDown.findElements(By.xpath("//android.widget.NumberPicker[@index='2']/android.widget.EditText[@index='1']"));
			String su = Present.get(0).getText().toString();
			int c = Integer.parseInt(su);
			//System.out.println(su);
			List<MobileElement> scrollUp = dropDown.findElements(By.xpath("//android.widget.NumberPicker[@index='2']/android.widget.Button[@index='2']"));
			String sv = scrollUp.get(0).getText().toString();
			int d = Integer.parseInt(sv);
			//System.out.println(sv);
			int a = Integer.parseInt(bvyear);
			if(a<c) {
				for(int i=a;i<c;i++) {

					scrollDown.get(0).click();
					//System.out.println(c);
				}
			}else if (a>c){
				for(int i=a;i>c;i--) {
					scrollUp.get(0).click();
					//System.out.println(c);
				}
			}

		}catch(Exception e){
			e.printStackTrace();
			System.out.println("The year is already set");
		}
	}
	public boolean dobError(RegistrationPage registrationPage) {
		return registrationPage.dateofbirthError.isDisplayed();
	}

	public void ScrollToElement(int miliseconds,String Sector)
	{
		AndroidElement element = null;
		int numberOfTimes = 40;
		Dimension size = driver.manage().window().getSize();
		int anchor = size.width / 2;
		//Swipe up to scroll down
		int startPoint = size.height - 5;
		int endPoint = 300;

		System.out.println("point "+startPoint+","+endPoint);

		for (int i = 0; i < numberOfTimes; i++)
		{
			try
			{
				new TouchAction(driver)
				.longPress(point(anchor, startPoint)) //.press(point(anchor, startPoint)) if used press need proper waiting time
				//.waitAction(waitOptions(ofMillis(miliseconds)))
				.moveTo(point(anchor, endPoint)).release().perform();
				element = driver.findElementByXPath("//android.widget.TextView[@text='"+Sector+"']");
				i = numberOfTimes;
			}
			catch (Exception ex)
			{
				System.out.println(String.format("Element not available. Scrolling (%s) times", i + 1));
			}
		}

		element.click();
		//return element;
	}
	public void selectTitle(String strTitle)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+strTitle+"\"))").click();
	}
	////////




	public void LoginFun(RegistrationPage registrationPage,String username,String password,SignInPage signInPage) throws Exception
	{
		generalFunctions.isElementPresent(signInPage.signinPresent, 30);
		signInPage.signinPresent.click();
		generalFunctions.isElementPresent(signInPage.useridElement, 90);
		signInPage.useridElement.sendKeys(username);
		signInPage.userpassElement.sendKeys(password);
		signInPage.signinElement.click();
		Thread.sleep(5000);
	}

	//		try
	//		{
	//
	//			try
	//			{
	//				//Click Stop Tutorial
	//				//if(registrationPage.StopTutorialElement.isDisplayed()==true)
	//				if(onboardPage.homeWelcome.isDisplayed()==true)
	//				{
	//					System.out.println("Test");
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
	//			if(registrationPage.objHome.isDisplayed()==true)
	//			{
	//				System.out.println("User already logged in");
	//			}
	//
	//			try
	//			{
	//				if(generalFunctions.isElementPresent(registrationPage.StopTutorialElement, 10)==true)
	//					//Thread.sleep(10000);
	//					//Click Stop Tutorial
	//					//	if(registrationPage.StopTutorialElement.isDisplayed()==true)
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
	//		}
	//		catch(Exception ex)
	//		{
	//
	//			System.out.println("User Login Flow");
	//
	//			//registrationFunctions.onboardscreenDisexxplay(registrationPage);
	//			try
	//			{
	//
	//				if(registrationPage.onboardScreen.isDisplayed()==true)
	//				{
	//					System.out.println("onboard Screen Displayed");
	//				}
	//			}
	//			catch(Exception e)
	//			{
	//				Assert.fail("onboard Screen Not Displayed");
	//			}
	//
	//			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//
	//			//registrationFunctions.startButtonActive(registrationPage);
	//			try
	//			{
	//
	//				if(registrationPage.startElement.isDisplayed()==true)
	//				{
	//					System.out.println("GET STARTED Button Displayed");
	//				}
	//			}
	//			catch(Exception e)
	//			{
	//				Assert.fail("GET STARTED Button Not Displayed");
	//			}
	//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//
	//			//Click on Sign In
	//			/*
	//			AndroidElement element= driver.findElementById("com.maf.sharesit:id/onboarding_already_have_account_view");
	//			Point objPont =element.getLocation();
	//			int Xcord =objPont.getX();
	//			int Ycord = objPont.getY();
	//			 */
	//			MobileElement element = (MobileElement) driver.findElementById("com.maf.sharesit:id/onboarding_already_have_account_view");
	//			Point p = element.getCenter();
	//			int Xcord =p.getX();
	//			int Ycord = p.getY();
	//			System.out.println("Cords "+Xcord+","+Ycord);
	//			TouchAction action= new TouchAction(driver).tap(point(Xcord+200,Ycord)).waitAction(waitOptions(Duration.ofMillis(1000))).perform();
	//
	//			//Enter User Name
	//			signInPage.useridElement.sendKeys(username);
	//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//
	//			//Enter Password
	//			signInPage.userpassElement.sendKeys(password);
	//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//
	//			//Click Sign In button
	//			signInPage.signinElement.click();
	//			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
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
	//			//Verify home page displayed
	//			if(registrationPage.HomeIcon.isDisplayed())
	//			{
	//				System.out.println("Home page Displayed");
	//			}
	//			else
	//			{
	//				Assert.fail("Home page Not Displayed");
	//			}
	//		}
	//}
	public void onBoardScroll(RegistrationPage registrationPage) {

		MobileElement el= driver.findElement(By.id("com.maf.android.share:id/textViewOnBoardingMessage"));
		int start = el.getLocation().getX();
		int end  = el.getLocation().getY();
		int wid = el.getSize().getWidth();
		int heig = el.getSize().getHeight();
		System.out.println(start+"|"+end+"|"+wid+"|"+heig);

		TouchAction t = new TouchAction(driver);
		t.press(point(wid, heig))
		.waitAction(waitOptions(Duration.ofMillis(2000)))
		.moveTo(point(wid, heig))
		.release().perform();

	}

	public String SelectDate(int selectEle)
	{

		String Xpath="//android.view.View[@index='"+selectEle+"']";
		return Xpath;
	}


	public String selectYear(int selectYear)
	{

		String Xpath="//android.widget.TextView[contains(@resource-id,'android:id/text1') and@index='"+selectYear+"']";
		return Xpath;
	}

//	public void userYear(RegistrationPage registrationPage) throws Exception {
//		GeneralFunctions generalFunctions = new GeneralFunctions();
//		generalFunctions.isElementPresent(registrationPage.dateofbirth, 90);
//		registrationPage.dateofbirth.click();
//		generalFunctions.isElementPresent(registrationPage.dobyear, 90);
//		registrationPage.dobyear.click();
//		String currentYear = registrationPage.dobyear.getText();
//		int currentvalue = Integer.parseInt(currentYear);
//		String xpath = "//android.widget.TextView[@text=\""+year+"\"]";
//		int uservalue = Integer.parseInt(year);
//		test.log(Status.INFO, "Year is: "+uservalue);
//		System.out.println(year);
//		if(currentvalue>uservalue) {
//			generalFunctions.calendardown(xpath);
//		}else {
//			generalFunctions.calendarUp(xpath);
//		}
//	}

	public void userYear(RegistrationPage registrationPage) {
		generalFunctions.isElementPresent(registrationPage.dateofbirth, 90);
		registrationPage.dateofbirth.click();
		generalFunctions.isElementPresent(registrationPage.dobyear, 90);
		registrationPage.dobyear.click();
		String currentYear = registrationPage.dobyear.getText();
		int currentvalue = Integer.parseInt(currentYear);
		//String xpath = "//android.widget.TextView[@text=\""+year+"\"]";
		int uservalue = Integer.parseInt(year);
		test.log(Status.INFO, "Year is: "+uservalue);
		System.out.println(year);
		AndroidElement el = driver.findElementByXPath("//android.widget.ListView[@index='0']");
		if(currentvalue>uservalue) {
			try {
				Directions dir = Directions.DOWN;
				generalFunctions.swipeElementAndroid(el, dir, year);
			} catch (Exception e) {
			    e.printStackTrace();
			    System.out.println("Scroll down Error");
			}

		}else {
			try {
				Directions dir = Directions.UP;
				generalFunctions.swipeElementAndroid(el, dir, year);

			} catch (Exception e) {
			    e.printStackTrace();
			    System.out.println("Scroll Up Error");
			}

		}

	}

	public void userinvalidYear(RegistrationPage registrationPage) throws Exception {
		GeneralFunctions generalFunctions = new GeneralFunctions();
		generalFunctions.isElementPresent(registrationPage.dateofbirth, 90);
		registrationPage.dateofbirth.click();
		generalFunctions.isElementPresent(registrationPage.dobyear, 90);
		registrationPage.dobyear.click();
		String currentYear = registrationPage.dobyear.getText();
		int currentvalue = Integer.parseInt(currentYear);
		String xpath = "//android.widget.TextView[@text=\""+invalidyear+"\"]";
		int uservalue = Integer.parseInt(invalidyear);
		test.log(Status.INFO, "Year is: "+uservalue);
		System.out.println(invalidyear);
		AndroidElement el = driver.findElementByXPath("//android.widget.ListView[@index='0']");
		if(currentvalue>uservalue) {
			try {
				Directions dir = Directions.DOWN;
				generalFunctions.swipeElementAndroid(el, dir, invalidyear);
			} catch (Exception e) {
			    e.printStackTrace();
			    System.out.println("Scroll down Error");
			}

		}else {
			try {
				Directions dir = Directions.UP;
				generalFunctions.swipeElementAndroid(el, dir, invalidyear);

			} catch (Exception e) {
			    e.printStackTrace();
			    System.out.println("Scroll Up Error");
			}

		}
	}

	public void userMonth(RegistrationPage registrationPage) {

	}

	public void quickDOB(RegistrationPage registrationPage) {
		GeneralFunctions generalFunctions = new GeneralFunctions();
		generalFunctions.isElementPresent(registrationPage.dateofbirth, 90);
		registrationPage.dateofbirth.click();
		generalFunctions.isElementPresent(registrationPage.dobyear, 90);
		registrationPage.dobyear.click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"2009\"))").click();
		registrationPage.calendarOK.click();


	}

	public void tcClick(RegistrationPage registrationPage) {
		MobileElement element = driver.findElementById("tv_terms_and_policy");
		generalFunctions.isElementPresent(element, 10);
		int Xcord = element.getLocation().getX();
		int Ycord = element.getLocation().getY();
		System.out.println("Cords "+Xcord+","+Ycord);
		TouchAction action= new TouchAction(driver).tap(point(Xcord+362,Ycord+44)).waitAction(waitOptions(Duration.ofMillis(1000))).perform();

	}
	public void ppClick(RegistrationPage registrationPage) {
		MobileElement element = driver.findElementById("tv_terms_and_policy");
		generalFunctions.isElementPresent(element, 10);
		int Xcord = element.getLocation().getX();
		int Ycord = element.getLocation().getY();
		System.out.println("Cords "+Xcord+","+Ycord);
		TouchAction action= new TouchAction(driver).tap(point(Xcord+126,Ycord+44)).waitAction(waitOptions(Duration.ofMillis(1000))).perform();

	}
	public void infoClick(RegistrationPage registrationPage) {
		MobileElement element = driver.findElementById("et_date_of_birth");
		generalFunctions.isElementPresent(element, 10);
		Point p = element.getCenter();
		int Xcord =p.getX();
		int Ycord = p.getY();
		System.out.println("Cords "+Xcord+","+Ycord);
		TouchAction action= new TouchAction(driver).tap(point(Xcord+268,Ycord)).waitAction(waitOptions(Duration.ofMillis(1000))).perform();

	}

	/// ***********************Year Iteration*******************//
	public void userYeariter(RegistrationPage registrationPage, String slctYear) throws Exception {
		System.out.println(slctYear);
		generalFunctions.isElementPresent(registrationPage.dateofbirth, 90);
		registrationPage.dateofbirth.click();
		generalFunctions.isElementPresent(registrationPage.dobyear, 90);
		registrationPage.dobyear.click();
		String currentYear = registrationPage.dobyear.getText();
		int currentvalue = Integer.parseInt(currentYear);
		//String xpath = "//android.widget.TextView[@text=\""+slctYear+"\"]";
		int uservalue = Integer.parseInt(slctYear);
		AndroidElement el = driver.findElementByXPath("//android.widget.ListView[@index='0']");
		if(currentvalue>uservalue) {
			try {
				Directions dir = Directions.DOWN;
				generalFunctions.swipeElementAndroid(el, dir, slctYear);
			} catch (Exception e) {
			    e.printStackTrace();
			    System.out.println("Scroll down Error");
			}

		}else {
			try {
				Directions dir = Directions.UP;
				generalFunctions.swipeElementAndroid(el, dir, year);

			} catch (Exception e) {
			    e.printStackTrace();
			    System.out.println("Scroll Up Error");
			}

		}
	}


	public boolean errorStatus(RegistrationPage registrationPage) {
		return registrationPage.errorMessage.isDisplayed();
	}

	//Use the function for normal user
	public void signInUser() {

		SplashScreenPage splashScreenPage = new SplashScreenPage(driver);
		RegistrationPage registrationPage = new RegistrationPage(driver);
		RegistrationFunctions registrationFunctions= new RegistrationFunctions();
		GeneralFunctions generalFunctions = new GeneralFunctions();
		SignInPage signInPage = new SignInPage(driver);
		SignInFunctions signInFunctions = new SignInFunctions();
		SplashScreenFunctions splashScreenFunctions = new SplashScreenFunctions();
		HomePage homePage = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//	Thread.sleep(15000);

		try {
			//User already Login case
			if(generalFunctions.isElementPresent(homePage.homeElement, 20)) {
				System.out.println("User already Login");
			}else  {
				System.out.println("User NOT Logged in");
				//splashScreenFunctions.splashScreenSkip(splashScreenPage);
				generalFunctions.isElementPresent(signInPage.signinPresent, 90);
				signInFunctions.validUserLogin();
				generalFunctions.isElementPresent(registrationPage.HomeIcon, 90);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}

