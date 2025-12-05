package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "emailaddress")
	private WebElement emailid;

	@FindBy(id = "continue-button")
	private WebElement continueBtn;

	@FindBy(id = "password")
	private WebElement passwordbtn;

	@FindBy(id = "login-button")
	private WebElement loginBtn;

	public WebElement getEmailid() {
		return emailid;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public WebElement getPassword() {
		return passwordbtn;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void loginToApp(String username, String password) {
		emailid.sendKeys(username);
		continueBtn.click();
		passwordbtn.sendKeys(password);
		loginBtn.click();
	}



	
}
