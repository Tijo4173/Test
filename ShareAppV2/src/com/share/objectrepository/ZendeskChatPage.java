package com.share.objectrepository;

import org.openqa.selenium.support.PageFactory;

import com.share.general.DriverSetUp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ZendeskChatPage extends DriverSetUp{
	
	AndroidDriver<AndroidElement> driver;
	public ZendeskChatPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}	
	@AndroidFindBy(id = "textView8")
	public AndroidElement chaticon;
	
	@AndroidFindBy(id = "zui_cell_label_text_field")
	public AndroidElement chatscreen;
	
	@AndroidFindBy(id = "input_box_input_text")
	public AndroidElement chatinputtext;
}
