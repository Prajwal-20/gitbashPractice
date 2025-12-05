package com.objectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {

	WebDriver driver;
    WebDriverWait wait;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    @FindBy(xpath = "//button[text()='New contact']")
    private WebElement newcontButton;
    
    @FindBy(xpath = "//input[@value='New contact']")
    private WebElement newContTF;
    
    @FindBy(xpath = "(//div[@class='email-cell-component'])[1]")
    private WebElement newMailTF;
    
    @FindBy(id = "(//div[@role='listitem'])[4]")
    private WebElement accountsTF;
    
    @FindBy(xpath = "//span[text()='Google']")
    private WebElement googleAcntlink;
    
    @FindBy(xpath = "//span[text()='We successfully moved 1 Contact to']")
    private WebElement actResult;
    
    

	public WebElement getActResult() {
		return actResult;
	}


	public WebDriverWait getWait() {
		return wait;
	}

	
	public WebElement getNewcontButton() {
		return newcontButton;
	}


	public WebElement getNewContTF() {
		return newContTF;
	}

	public WebElement getNewMailTF() {
		return newMailTF;
	}

	public WebElement getAccountsTF() {
		return accountsTF;
	}

	public WebElement getGoogleAcntlink() {
		return googleAcntlink;
	}
    
    public void createContact(String name) throws InterruptedException {
    	newcontButton.click();
    	newContTF.sendKeys(name);
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//div[text()='Contact']")).click();
    	driver.findElement(By.xpath("(//div[@class='checkbox_ac84b44ad7'])[2]")).click();
    	driver.findElement(By.xpath("//span[text()='Convert']")).click();
    	driver.findElement(By.xpath("//span[text()='Raju2451']")).click();
    	driver.findElement(By.xpath("//button[text()='Convert item']")).click();
    	driver.findElement(By.xpath("//button[text()='Move items anyway']")).click();
    	newMailTF.sendKeys();
         accountsTF.click();
    	googleAcntlink.click();
    	Actions act = new Actions(driver);
    	act.scrollByAmount(0, 500).perform();
    	
    }
    
}
