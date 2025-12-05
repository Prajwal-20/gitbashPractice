package com.objectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountsPage {
	
	 WebDriver driver;
	    WebDriverWait wait;

	    public CreateAccountsPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    @FindBy(xpath = "//button[text()='New account']")
	    private WebElement newAccountBtn;

	    @FindBy(xpath = "//input[@id='accountNameInput']")
	    private WebElement accountNameInput;

	    @FindBy(xpath = "//input[@id='domainNameInput']")
	    private WebElement domainNameInput;

	    @FindBy(xpath = "//select[@id='industrySelect']")
	    private WebElement industrySelect;

	    @FindBy(xpath = "//textarea[@id='descriptionInput']")
	    private WebElement descriptionInput;

	    @FindBy(xpath = "//input[@id='employeesInput']")
	    private WebElement noOfEmployeesInput;

	    @FindBy(xpath = "//button[normalize-space()='Save']")
	    private WebElement saveAccountBtn;

	  
	    

	    

	    public WebDriverWait getWait() {
			return wait;
		}

		public WebElement getNewAccountBtn() {
			return newAccountBtn;
		}

		public WebElement getAccountNameInput() {
			return accountNameInput;
		}

		public WebElement getDomainNameInput() {
			return domainNameInput;
		}

		public WebElement getIndustrySelect() {
			return industrySelect;
		}

		public WebElement getDescriptionInput() {
			return descriptionInput;
		}

		public WebElement getNoOfEmployeesInput() {
			return noOfEmployeesInput;
		}

		public WebElement getSaveAccountBtn() {
			return saveAccountBtn;
		}

		public void createNewAccount(String accountName, String domainName, String industry, String description, String employees) {
	        newAccountBtn.click();

	        accountNameInput.clear();
	        accountNameInput.sendKeys(accountName);

	        domainNameInput.clear();
	        domainNameInput.sendKeys(domainName);

	        industrySelect.sendKeys(industry);

	        descriptionInput.clear();
	        descriptionInput.sendKeys(description);

	        noOfEmployeesInput.clear();
	        noOfEmployeesInput.sendKeys(employees);

	        saveAccountBtn.click();

	        System.out.println("Account created: " + accountName);
	    }

	    public void convertLeadToAccount(String leadName, String accountName) {
	        
	            WebElement convertButton = driver.findElement(By.xpath(
	                    "//div[text()='" + leadName + "']/ancestor::div[contains(@class,'row')]//button[normalize-space()='Convert to Account']"));
	            convertButton.click();

	            WebElement accountNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//input[@id='accountNameInput']")));
	            accountNameField.clear();
	            accountNameField.sendKeys(accountName);

	            WebElement confirmBtn = driver.findElement(By.xpath("//button[normalize-space()='Confirm']"));
	            confirmBtn.click();

	            System.out.println("Lead '" + leadName + "' converted to Account: " + accountName);
	        
	    }

	    public boolean isAccountCreated(String accountName) {
	       
	            WebElement accountRow = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//div[text()='" + accountName + "']")));
	            return accountRow.isDisplayed();
	        
	    }

	    public boolean verifyAccountExists(String accountName) {
	        try {
	            WebElement accountElement = driver.findElement(
	                    By.xpath("//div[@class='account-name' and text()='" + accountName + "']"));
	            return accountElement.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }


}
