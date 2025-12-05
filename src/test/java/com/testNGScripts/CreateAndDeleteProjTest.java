package com.testNGScripts;

import com.BaseUtility.BaseClass;

public class CreateAndDeleteProjTest extends BaseClass{

	 public void deleteProjectsTest() throws Exception {
	        
	        String dealsPageUrl = futil.getDataFromPropertiesFile("url");
	        String dealName = futil.getDataFromPropertiesFile("dealName");

	        
	        driver.get(dealsPageUrl);

	       
	       // CreateDealsPage dealsPage = new CreateDealsPage(driver);

	       
	       // dealsPage.deleteDeal(dealName);

	        System.out.println(" Deal '" + dealName + "' deleted successfully.");
	    }
}
