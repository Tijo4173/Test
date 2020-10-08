package com.share.functions;

import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.SplashScreenPage;

public class SplashScreenFunctions extends DriverSetUp {


	GeneralFunctions generalFunctions = new GeneralFunctions();
	public void splashScreenSkip(SplashScreenPage splashScreenPage) {
		try {
			//generalFunctions.isElementPresent(splashScreenPage.splashScreen, 30);
		if(generalFunctions.isElementPresent(splashScreenPage.splashScreenSkip, 2)) {

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