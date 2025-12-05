package basic;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginToApp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://login.freshworks.com/email-login/");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("prajwalnraja2097@gmail.com");
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Putta@1997");
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		

	}

}
