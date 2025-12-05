package com.Generic.WebdriverUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void WindowMax(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToWindow(WebDriver driver,String partialTitle) {
		Set<String> allIds = driver.getWindowHandles();
		for(String id:allIds) {
			@Nullable
			String windowTitle = driver.switchTo().window(id).getTitle();
			if(windowTitle.contains(partialTitle)) {
				break;
			}
		}
	}
	public void switchToWindowUrl(WebDriver driver,String partialUrl) {
		Set<String> allIds = driver.getWindowHandles();
		for(String id:allIds) {
			@Nullable
			String actUrl = driver.switchTo().window(id).getCurrentUrl();
			if(actUrl.contains(partialUrl)) {
				break;
			}
		}
	}
	
	//frame by index
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	//frame by id
	public void switchToFrame(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);
	}
	
	//frame by webelement
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	//simple alert
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	//alert dismiss
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	//select by index
	public void select(WebElement element,int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	//select by value
	public void select(WebElement element,String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	//select by visible text
	public void select(String visible,WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visible);
	}
	
	//context click
	public void rightClick(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick().perform();;
	}
	
	//doubleClick
	public void doubleClick(WebDriver driver,WebElement element ) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();;
	}
	
	//movetoelement
	public void moveToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();;
	}
	
	//draganddrop
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();
	}
	
	//scrolltoelement
	public void scrollToElement(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}
	
	//scrollbyamount
	public void scrollByAmount(WebDriver driver, int x, int y) {
		Actions act = new Actions(driver);
		act.scrollByAmount(x, y);
	}
	
	//javaScriptExecuter
	public void jsExecuterScroll(WebDriver driver) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(x,y);");
	}
	
	//javascriptsendkeys
	public void jsExecuterSendkey(WebDriver driver, WebElement element, String data) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='"+data+"';",element);
	}
	
	//javascriptdisable
		public void jsExecuterClick(WebDriver driver, WebElement element) {
			JavascriptExecutor js =(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",element);
		}
	
		//takescreenShot
		public void screenShot(WebDriver driver, String ssName) throws IOException {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target= new File("./errorShots/"+ssName+".png");
			FileHandler.copy(source, target);
		}
		
}
