package com.testNGScripts;

import org.testng.annotations.Test;

import com.BaseUtility.BaseClass;
import com.Generic.WebdriverUtility.UtilityClassObject;
import com.aventstack.extentreports.Status;
import com.objectRepository.LoginPage;


public class LoginTest extends BaseClass {
	@Test
	public void loginTest() {
		//UtilityClassObject.getTest().log(Status.INFO,"generating random numbers");
		System.out.println("HomePage is displayed");
		
	}

}
