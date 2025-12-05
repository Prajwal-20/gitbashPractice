package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[.='Tasks']")
	private WebElement taskBtn;

	@FindBy(xpath = "//span[.='Contacts']")
	private WebElement contactBtn;

	@FindBy(xpath = "//span[.='Leads']")
	private WebElement leadsBtn;

	@FindBy(xpath = "//span[.='Opportunities']")
	private WebElement opportunityBtn;

	@FindBy(id = "navlink_organisation")
	private WebElement organisationBtn;

	@FindBy(id = "user-menu-dd")
	private WebElement userLogo;

	@FindBy(id = "user-logout")
	private WebElement logoutBtn;

	@FindBy(id="navlink_project")
	private WebElement projectBtn;
	
	
	
	public WebElement getProjectBtn() {
		return projectBtn;
	}

	public WebElement getUserLogo() {
		return userLogo;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getTaskBtn() {
		return taskBtn;
	}

	public WebElement getContactBtn() {
		return contactBtn;
	}

	public WebElement getLeadsBtn() {
		return leadsBtn;
	}

	public WebElement getOrganisationBtn() {
		return organisationBtn;
	}

	public WebElement getOpportunityBtn() {
		return opportunityBtn;
	}

	public void logout() {
		userLogo.click();
		logoutBtn.click();
	}

	
}
