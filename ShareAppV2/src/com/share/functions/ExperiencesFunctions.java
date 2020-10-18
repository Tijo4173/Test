package com.share.functions;

import com.share.general.DriverSetUp;
import com.share.general.GeneralFunctions;
import com.share.objectrepository.ExperiencesPage;
import com.share.objectrepository.HomePage;
import com.share.objectrepository.SignInPage;

public class ExperiencesFunctions extends DriverSetUp {

	public boolean selectCategory(String Category) throws InterruptedException
	 {
	 ExperiencesPage experiencesPage= new ExperiencesPage(driver);
	 GeneralFunctions generalFunctions = new GeneralFunctions();

	 boolean displayedFlag=false;

	 switch(Category)
	 {
	  case "CARREFOUR OFFERS":
	  experiencesPage.Carrefour.click();
	  Thread.sleep(2000);
	  try
	{
	if(generalFunctions.isElementPresent(experiencesPage.carrefourOffersPage, 30))
	{
	displayedFlag=true;
	}
	}
	catch(Exception x)
	{
	displayedFlag=false;
	}

	   break;
	case "SHARE OFFERS":
	experiencesPage.Shopping.click();
	Thread.sleep(2000);
	  try
	{

	if( generalFunctions.isElementPresent(experiencesPage.shareOffersPage, 30))
	{
	displayedFlag=true;
	}
	}
	catch(Exception x)
	{
	displayedFlag=false;
	}
	   break;
	case "MEMBER CONTESTS":
	experiencesPage.Contests.click();
	try
	{

	if(generalFunctions.isElementPresent(experiencesPage.Contests, 30))
	{
	displayedFlag=true;
	}
	}
	catch(Exception x)
	{
	displayedFlag=false;
	}


	case "MEMBER BENEFITS":
	experiencesPage.Benefits.click();
	try
	{

	if(generalFunctions.isElementPresent(experiencesPage.Benefits, 30))
	{
	displayedFlag=true;
	}
	}
	catch(Exception x)
	{
	displayedFlag=false;
	}
	   break;
	 }

	 return displayedFlag;
	 }

	
}
