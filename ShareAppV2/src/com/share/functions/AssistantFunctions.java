package com.share.functions;

import java.util.List;
import java.util.Random;

import org.testng.collections.Lists;

import com.share.general.DriverSetUp;
import com.share.objectrepository.AssistantPage;

import io.appium.java_client.MobileElement;

public class AssistantFunctions extends DriverSetUp {

	String username = map.get("UserName").toString();
	String mobileNumber = map.get("MobileNumber").toString();
	String countryCode = map.get("CountryCode").toString();
	String assistdescription = map.get("description").toString();



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


	public void questionsClick() {
		AssistantPage assistantPage = new AssistantPage(driver);
		List<MobileElement> questions = assistantPage.questionsList.findElementsByClassName("android.widget.RelativeLayout");
		questions.get(0).click();
	}



}
