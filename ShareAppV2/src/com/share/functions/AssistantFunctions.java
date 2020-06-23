package com.share.functions;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.testng.collections.Lists;

import com.share.general.DriverSetUp;
import com.share.objectrepository.AssistantPage;

import io.appium.java_client.android.AndroidElement;

public class AssistantFunctions extends DriverSetUp {

	String username = map.get("UserName").toString();
	String mobileNumber = map.get("MobileNumber").toString(); 
	String countryCode = map.get("CountryCode").toString();
	String assistdescription = map.get("description").toString();


	public void assistantemailid(AssistantPage assistantPage) {
		assistantPage.assistantEmailfield.sendKeys(username);
	}
	public void assistdesc(AssistantPage assistantPage) {
		assistantPage.assistantDesription.sendKeys(assistdescription);
	}

	/*public void reason(AssistantPage assistantPage) {
		assistantPage.assisatantReason.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Title\"))").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Mrs\"))").click();
	}
*/

	public void reasonRandom(AssistantPage assistantPage) {
		
		Random randlist= new Random();
		List<String> reasonList= Lists.newArrayList("General enquiry","Points related enquiry","Technical help","Something else");
		int elements = 3;
		System.out.println(reasonList);
		for(int i =0;i<elements;) {

			int randomIndex = randlist.nextInt(reasonList.size());
			System.out.println("index"+randomIndex);
			String randomElement = reasonList.get(randomIndex);
			System.out.println("element"+randomElement);
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+randomElement+"\"))").click();
			//AndroidElement element = (AndroidElement)driver.findElementsByXPath("//android.widget.LinearLayout[@text='"+randomElement+"']");
			//element.click();
			break;
			// reasonList.remove(randomIndex);

		}
	}
	
	
	public void allowtoAccess(AssistantPage assistantPage) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//homePage.allowAccess.click();
		try{
			if(assistantPage.assistantallowAccess.isDisplayed()==true) {
				assistantPage.assistantallowAccess.click();
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		//homePage.cameraClose.click();
	}
	
	public boolean assistantOk(AssistantPage assistantPage) {
		return assistantPage.assistantOK.isDisplayed();
	}

}
