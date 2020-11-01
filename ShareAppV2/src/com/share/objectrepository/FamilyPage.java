package com.share.objectrepository;
import org.openqa.selenium.support.PageFactory;

import com.share.general.DriverSetUp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FamilyPage extends DriverSetUp  {

	AndroidDriver<AndroidElement> driver;

	public FamilyPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);

	}
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Account']/android.widget.ImageView")
	public AndroidElement AccountIcon;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='settings']")
	public AndroidElement SettingsIcon;

	@AndroidFindBy(id = "iv_home_feature_family")
	public AndroidElement familyGroupIcon;

	@AndroidFindBy(id = "add_member_bottom_btn")
	public AndroidElement inviteMember;

	@AndroidFindBy(id = "text_input_layout_input")
	public AndroidElement emailAddressField;

	@AndroidFindBy(id = "add_new_member_send_invite_button")
	public AndroidElement sendInviteButton;

	@AndroidFindBy(id = "dialog_primary_button")
	public AndroidElement sendAnotherButton;

	@AndroidFindBy(id = "static_head_balance_value")
	public AndroidElement balanceValue;

	@AndroidFindBy(id = "dialog_status_title")
	public AndroidElement sendInviteScreen;

	@AndroidFindBy(id = "dialog_secondary_button")
	public AndroidElement doneButton;

	@AndroidFindBy(id = "textinput_error")
	public AndroidElement invalidEmailWarning;

	@AndroidFindBy(id = "add_member_button")
	public AndroidElement addNewMemberButton;

	@AndroidFindBy(id = "family_progress")
	public AndroidElement familyProgress;

	@AndroidBy(xpath = "//android.widget.TextView[@text='Invite not sent']")
	public AndroidElement inviteNotSend;

	@AndroidFindBy(id = "dialog_status_description")
	public AndroidElement statusDescription;

	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[@index='0']")
	public AndroidElement familyMember;

	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='1']")
	public AndroidElement familyMemberName;

	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='state_recycler_view_recycler']//android.view.ViewGroup[@index='0']//android.widget.TextView[@resource-id='family_head_member_points_integer']")
	public AndroidElement familyMemberPoint;

	@AndroidFindBy(id = "balance_value_label")
	public AndroidElement familyPointBalance;

	@AndroidFindBy(id = "text_input_layout_input")
	public AndroidElement pointsField;

	@AndroidFindBy(id = "gift_button")
	public AndroidElement getPointsButton;

	@AndroidFindBy(id = "dialog_status_description")
	public AndroidElement pointsSuccessMessage;

	@AndroidFindBy(id = "dialog_primary_button")
	public AndroidElement thanksButton;

	@AndroidFindBy(id = "textinput_error")
	public AndroidElement errorMessageGiftPoints;

	@AndroidFindBy(id = "family_member_edit_button")
	public AndroidElement edit_family;

	@AndroidFindBy(id = "text_input_layout_input")
	public AndroidElement earn_family_head;

	@AndroidFindBy(id = "family_member_save_button")
	public AndroidElement family_save;

	@AndroidFindBy(id = "family_member_contribution_title")
	public AndroidElement family_edit_desc;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.TextView[2]")
	public AndroidElement family_mem;

	@AndroidFindBy(id = "gift_points_selected_member")
	public AndroidElement family_mem_dropdown;

	@AndroidFindBy(xpath = "//android.widget.RadioGroup/android.widget.RadioButton[3]")
	public AndroidElement anot_mem_dropdown;

	@AndroidFindBy(id = "single_choice_dialog_cancel_button")
	public AndroidElement dropdown_cancel;

	@AndroidFindBy(id = "single_choice_dialog_ok_button")
	public AndroidElement dropdown_ok;

	@AndroidFindBy(id = "text_input_layout_input")
	public AndroidElement amount_points;

	@AndroidFindBy(id = "gift_button")
	public AndroidElement gift_points;

	@AndroidFindBy(id = "single_choice_dialog_item_list")
	public AndroidElement familyMemberList;

	@AndroidFindBy(id = "transaction_name")
	public AndroidElement transaction;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.ImageButton")
	public AndroidElement back_button1;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.ImageButton")
	public AndroidElement back_button2;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@checked = 'true']")
	public AndroidElement radioButtonSelected;
	
}

