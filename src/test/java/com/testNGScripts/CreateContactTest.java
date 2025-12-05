package com.testNGScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.BaseUtility.BaseClass;
import com.objectRepository.ContactPage;
import com.objectRepository.HomePage;

public class CreateContactTest extends BaseClass{
	
	@Test
	public void createContactTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		
		
		int r = jutil.getRandomNumber();
		  String contName = eutil.getDataFromExcel("Lead", 1, 0)+r; 
		  String contEmail =eutil.getDataFromExcel("Lead", 1, 1); 
		  String contPhone =eutil.getDataFromExcel("Lead", 1, 2);
		  
		  HomePage hp = new HomePage(driver);
		 
		  hp.getContactLink().click();
		  
		  ContactPage cp = new ContactPage(driver);
		
		  cp.createContact(contName);
		  

		//  Assert.assertTrue(cp.getActResult().equals("We successfully moved 1 Contact to"));
	}

}
