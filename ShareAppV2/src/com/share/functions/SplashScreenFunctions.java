package com.share.functions;

import com.share.general.DriverSetUp;
import com.share.objectrepository.SplashScreenPage;

public class SplashScreenFunctions extends DriverSetUp {
	
	
	
	public void splashScreenSkip(SplashScreenPage splashScreenPage) {
		try {
		if(splashScreenPage.splashScreenSkip.isDisplayed()) {
			
			splashScreenPage.splashScreenSkip.click();
			
		}else {
			System.out.println("Skip is not Present");
		}
	}catch(Exception e){
		
	e.printStackTrace();
	e.getMessage();
	}
	
	}		


}