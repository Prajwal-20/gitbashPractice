package com.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadPage {

	WebDriver driver;
	
	 public CreateLeadPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	 
	 @FindBy(xpath = "//button[text()='New deal']")
	 private WebElement newDealBtn;
	 
	 
	 @FindBy(xpath = "//input[@value='New deal']")
	 private WebElement dealNameText;
	 
	 @FindBy(xpath = "(//div[@aria-label='Start conversation'])[1]")
	 private WebElement googleBtn;
	 
	 @FindBy(xpath = "//button[text()='New contact']")
	 private WebElement newContButton;
	 
	 @FindBy(xpath = "//input[@value='New contact']")
	 private WebElement contnameText;
	 
	 @FindBy(xpath = "(//div[@class='email-cell-component'])[4]")
	 private WebElement emailTextField;
	 
	 

	public WebElement getDealNameText() {
		return dealNameText;
		
		
	}

	public WebElement getNewDealBtn() {
		return newDealBtn;
	}

	public WebElement getNewContButton() {
		return newContButton;
	}

	public WebElement getContnameText() {
		return contnameText;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}
	
	 
	public WebElement getGoogleBtn() {
		return googleBtn;
	}

	public void enterDetails(String name, String email) {
		
		newDealBtn.click();
		dealNameText.sendKeys(name);
		
		googleBtn.click();
		driver.findElement(By.xpath("(//img[@class='person-bullet-image person-bullet-component fs-mask'])[4]")).click();
		driver.findElement(By.xpath("(//span[text()='Rengoku'])[2]")).click();
		driver.findElement(By.xpath("//button[text()='Lost']")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[48]"));
	}
	
}
