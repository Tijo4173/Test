package com.share.functions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import com.aventstack.extentreports.Status;
import com.share.general.DriverSetUp;
import com.share.objectrepository.FamilyPage;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;


public class FamilyFunctions extends DriverSetUp
{
	

	
	
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
	
	public static void FamilyInvite(FamilyPage familypage) throws Exception
	{
	
		FamilyPage familyPage = new FamilyPage(driver);
		
		//Click on FamilyGroupIcon
				
				Thread.sleep(5000);
				if(familyPage.FamilyGroupIcon.isDisplayed())
				{
					test.log(Status.PASS, "Group Icon Dispalyed");
					familyPage.FamilyGroupIcon.click();
				
				}
				else
				{
					test.log(Status.FAIL, "Group Icon Not Displayed");
					Assert.fail("Group Icon Not Displayed");
				}
				
				
				//Click on InviteMember
			
				Thread.sleep(4000);
				
				try
				{
					//Click Stop Tutorial
					if(familyPage.AddNewMemberButton.isDisplayed()==true)
					{
						test.log(Status.PASS, "AddNewMemberButton Dispalyed");
						familyPage.AddNewMemberButton.click();
					}
				}
				catch(Exception x)
				{
					System.out.println("AddNewMemberButton Not Displayed");
				}
				

				try
				{
					//Click Stop Tutorial
					if(familyPage.InviteMember.isDisplayed()==true)
					{
						test.log(Status.PASS, "InviteMember Dispalyed");
						familyPage.InviteMember.click();
					}
				}
				catch(Exception x)
				{
					System.out.println("InviteMember Not Displayed");
				}
							
				//Click on EmailAddressField
			
				Thread.sleep(2000);
				
				if(familyPage.EmailAddressField.isDisplayed())
				{
					test.log(Status.PASS, "EmailAddressField Dispalyed");
					familyPage.EmailAddressField.click();
				}
				else
				{
					test.log(Status.FAIL, "EmailAddressField Not Displayed");
					Assert.fail("EmailAddressField Not Displayed");
				}
				
	}
	
	public static void FamilyInviteExistingMember(FamilyPage familypage) throws Exception
	{
	
		FamilyPage familyPage = new FamilyPage(driver);
		
		//Click on FamilyGroupIcon
				
				Thread.sleep(6000);
				if(familyPage.FamilyGroupIcon.isDisplayed())
				{
					test.log(Status.PASS, "Group Icon Dispalyed");
					familyPage.FamilyGroupIcon.click();
				
				}
				else
				{
					test.log(Status.FAIL, "Group Icon Not Displayed");
					Assert.fail("Group Icon Not Displayed");
				}
				
				
				//Click on InviteMember
			
				Thread.sleep(3000);
				
				if(familyPage.AddNewMemberButton.isDisplayed())
				{
				
					test.log(Status.PASS, "AddNewMemberButton Dispalyed");
					familyPage.AddNewMemberButton.click();
				}
				else
				{
					test.log(Status.FAIL, "AddNewMemberButton Not Displayed");
					Assert.fail("AddNewMemberButton Not Displayed");
				}
				
				
				//Click on EmailAddressField
			
				Thread.sleep(2000);
				
				if(familyPage.EmailAddressField.isDisplayed())
				{
					test.log(Status.PASS, "EmailAddressField Dispalyed");
					familyPage.EmailAddressField.click();
				}
				else
				{
					test.log(Status.FAIL, "EmailAddressField Not Displayed");
					Assert.fail("EmailAddressField Not Displayed");
				}
				
	}
}

