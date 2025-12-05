package com.testNGScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.BaseUtility.BaseClass;
import com.objectRepository.CreateAccountsPage;
import com.objectRepository.CreateLeadPage;


public class CreateLeadToAccountTest extends BaseClass{

	  @Test
	    public void verifyLeadConvertedToAccount() throws Exception {
	       
			
		 int r = jutil.getRandomNumber();
			  String leadName = eutil.getDataFromExcel("Lead", 1, 0)+r; 
			  String leadEmail =eutil.getDataFromExcel("Lead", 1, 1); 
			  String leadPhone =eutil.getDataFromExcel("Lead", 1, 2);
			 
	     
	       CreateLeadPage clp=new CreateLeadPage(driver);
	    
	       clp.enterDetails(leadName,leadEmail);

	       
	       

	       
	        CreateAccountsPage accountsPage = new CreateAccountsPage(driver);
	        boolean isAccountPresent = accountsPage.verifyAccountExists(leadName);

	        Assert.assertTrue(isAccountPresent, "Lead is converted into an Account.");
	        System.out.println("Lead successfully converted into Account: " + leadName);
	    }
	  }

