package com.share.functions;

import java.util.concurrent.TimeUnit;

import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.NeedHelpPage;
import com.share.objectrepository.RegistrationPage;

import io.appium.java_client.MobileBy;

public class NeedHelpFunctions extends DriverSetUp {

	String EmailAddress=map.get("EmailAddress").toString();
	String mobileNumber = map.get("MobileNumber").toString();

	GeneralFunctions generalFunctions = new GeneralFunctions();

	public void needHelpElement(NeedHelpPage needHelpPage)
	{
		needHelpPage.needHelp.click();
	}

	public void emailAddressElement(NeedHelpPage needHelpPage)
	{
		needHelpPage.emailAddress.sendKeys(EmailAddress);
	}


	public void phoneNumberElement(NeedHelpPage needHelpPage)
	{
		needHelpPage.phoneNumber.sendKeys(mobileNumber);
	}

	public void reasonElement(NeedHelpPage needHelpPage)
	{
		needHelpPage.reason.click();
	}
	public void reasonOptElement(NeedHelpPage needHelpPage)

	{
		needHelpPage.reasonOpt.click();
	}
	//needHelpPage.cancel.click();
	public void descriptionElement(NeedHelpPage needHelpPage)
	{
		needHelpPage.description.sendKeys("description");
	}
	public void submitSignElement(NeedHelpPage needHelpPage)
	{
		needHelpPage.submit.click();
	}


	public void btnDoneElement(NeedHelpPage needHelpPage)
	{
		needHelpPage.btnDone.click();
	}

	public void countryCodeHelp(RegistrationPage registrationPage) {
		registrationPage.countryCode.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"+971\").instance(0))")).click();
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"+263\").instance(0))"));
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+cCode+"\"))").click();

		//*************Need help text field validation*******************************//

	}


		public void emailAddressElementVal(NeedHelpPage needHelpPage)
		{
			needHelpPage.emailAddress.click();
		}


		public void phoneNumberElementVal(NeedHelpPage needHelpPage)
		{
			needHelpPage.phoneNumber.click();
		}

		public void descriptionElementVal(NeedHelpPage needHelpPage)
		{
			needHelpPage.description.click();
		}

		public void emailAddressValFun(NeedHelpPage needHelpPage)
		{

			String emailErrorMessage = needHelpPage.emailAddressVal.getText();
			System.out.println(emailErrorMessage);
		}


		public void countryCodeFun(NeedHelpPage needHelpPage)

		{

			String countryCodeError = needHelpPage.mobCodeVal.getText();
			System.out.println(countryCodeError);
		}

		public void countryNumFun(NeedHelpPage needHelpPage)

		{

			String countryNumError = needHelpPage.mobNumVal.getText();
			System.out.println(countryNumError);
		}

		public void descriptionFun(NeedHelpPage needHelpPage)

		{

			String descriptionError = needHelpPage.descriptionVal.getText();
			System.out.println(descriptionError);
		}


	}
