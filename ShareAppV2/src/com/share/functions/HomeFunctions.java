package com.share.functions;

import java.util.concurrent.TimeUnit;

import com.share.general.DriverSetUp;
import com.share.objectrepository.HomePage;

import io.appium.java_client.android.AndroidElement;



public class HomeFunctions extends DriverSetUp 
{
	public void introDone(HomePage homePage) {

		AndroidElement next = homePage.introNext;
		AndroidElement done = homePage.introDone;
		String i = next.toString();
		String j = done.toString();
		for(int a=0;a<4;a++) {

			if(homePage.introNext.isDisplayed()) {

				homePage.introNext.click();
			}
			else {

				homePage.introDone.click();
			}
		}

	}

	public void receiptCameraClick(HomePage homePage) {
		homePage.receiptCamera.click();
	}

	public void allowtoAccess(HomePage homePage) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//homePage.allowAccess.click();
		try{
			if(homePage.allowAccess.isDisplayed()==true) {
				homePage.allowAccess.click();
				homePage.allowPermission.click();
				homePage.allowPermission.click();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		//homePage.cameraClose.click();
	}
	public void moreClick(HomePage homePage) {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try {
			if(homePage.buttonCaptureClick.isDisplayed()) {
				for(int a=0;a<=11;a++) {

					Thread.sleep(500);
					homePage.buttonCaptureClick.click();
					System.out.println(a);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}

	}

}
