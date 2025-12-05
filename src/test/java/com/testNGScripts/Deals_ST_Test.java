package com.testNGScripts;

import org.testng.annotations.Test;

import com.BaseUtility.BaseClass;
import com.objectRepository.HomePage;
import com.objectRepository.LoginPage;

public class Deals_ST_Test extends BaseClass{

	@Test
	public void navigateToDealPageTest() {
		HomePage hp = new HomePage(driver);
		hp.clickOnDealsLink();
		
	}
}
