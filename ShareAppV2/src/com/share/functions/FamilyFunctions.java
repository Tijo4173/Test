package com.share.functions;
import org.testng.Assert;

import java.time.Duration;
import com.aventstack.extentreports.Status;
import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.FamilyPage;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;


public class FamilyFunctions extends DriverSetUp
{

	GeneralFunctions generalFunctions = new GeneralFunctions();


	public void RegisterWithMandatoryField()
	{



	}

	public String getText(AndroidElement element)
	{
		String text = element.getText();
		return text;
	}


	public static void LongPress(AndroidElement element)
	{

		//AndroidTouchAction touch = new AndroidTouchAction (driver);
		//touch.longPress(LongPressOptions.longPressOptions()
		//.withElement(ElementOption.element (element))).perform ();

		TouchAction action = new TouchAction(driver).longPress(longPressOptions().withElement(element(element)).withDuration(Duration.ofMillis(10000))).release().perform();
	}

	public void FamilyInvite(FamilyPage familypage) throws Exception
	{

		FamilyPage familyPage = new FamilyPage(driver);

		//Click on FamilyGroupIcon

		if(generalFunctions.isElementPresent(familyPage.familyGroupIcon, 30))
		{
			test.log(Status.PASS, "Group Icon Dispalyed");
			familyPage.familyGroupIcon.click();

		}
		else
		{
			test.log(Status.FAIL, "Group Icon Not Displayed");
			Assert.fail("Group Icon Not Displayed");
		}


		//Click on InviteMember			
		try
		{
			//Click on add new member button
			if(generalFunctions.isElementPresent(familyPage.addNewMemberButton, 30))
			{
				test.log(Status.PASS, "AddNewMemberButton Dispalyed");
				familyPage.addNewMemberButton.click();
			}
		}
		catch(Exception x)
		{
			System.out.println("AddNewMemberButton Not Displayed");
		}


		try
		{
			//Click on invite button
			if(generalFunctions.isElementPresent(familyPage.inviteMember, 30))
			{
				test.log(Status.PASS, "InviteMember Dispalyed");
				familyPage.inviteMember.click();
			}
		}
		catch(Exception x)
		{
			System.out.println("InviteMember Not Displayed");
		}

		//Click on EmailAddressField
		if(generalFunctions.isElementPresent(familyPage.emailAddressField, 30))
		{
			test.log(Status.PASS, "EmailAddressField Dispalyed");
			familyPage.emailAddressField.click();
		}
		else
		{
			test.log(Status.FAIL, "EmailAddressField Not Displayed");
			Assert.fail("EmailAddressField Not Displayed");
		}

	}

	public void FamilyInviteExistingMember(FamilyPage familypage) throws Exception
	{

		FamilyPage familyPage = new FamilyPage(driver);

		//Click on FamilyGroupIcon
		if(generalFunctions.isElementPresent(familyPage.familyGroupIcon, 30))
		{
			test.log(Status.PASS, "Group Icon Dispalyed");
			familyPage.familyGroupIcon.click();

		}
		else
		{
			test.log(Status.FAIL, "Group Icon Not Displayed");
			Assert.fail("Group Icon Not Displayed");
		}


		//Click on InviteMember
		if(generalFunctions.isElementPresent(familyPage.addNewMemberButton, 30))
		{

			test.log(Status.PASS, "AddNewMemberButton Dispalyed");
			familyPage.addNewMemberButton.click();
		}
		else
		{
			test.log(Status.FAIL, "AddNewMemberButton Not Displayed");
			Assert.fail("AddNewMemberButton Not Displayed");
		}


		//Click on EmailAddressField
		if(generalFunctions.isElementPresent(familyPage.emailAddressField, 30))
		{
			test.log(Status.PASS, "EmailAddressField Dispalyed");
			familyPage.emailAddressField.click();
		}
		else
		{
			test.log(Status.FAIL, "EmailAddressField Not Displayed");
			Assert.fail("EmailAddressField Not Displayed");
		}

	}
}

