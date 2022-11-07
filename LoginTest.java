package grid4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {

		
		public WebDriver driver;
		
		@BeforeTest
		@Parameters("browser")
		public void setUp(String browser) {
			
			if(browser.equalsIgnoreCase("Firefox")) {
	System.setProperty("webdriver.gecko.driver", "D:\\selenium\\geckodriver-v0.32.0-win32.zip\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			
			else if (browser.equalsIgnoreCase("GoogleChrome")) {
	System.setProperty("webdriver.chrome.driver", "D:\\\\selenium\\\\chromedriver_win32.zip\\\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			
			else if(browser.equalsIgnoreCase("Opera")) {
							  System.setProperty("webdriver.opera.driver","D:\\selenium\\operadriver_win32.zip\\operadriver_win32\\\\operadriver.exe");
				driver = new OperaDriver();
			}
		}
		
		@Test
	    	public void Login() {
			
			driver.get("https://www.facebook.com/");	 	 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String pageTitle = driver.getTitle();							 
			System.out.println("The title of this page is "+pageTitle);
			
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys("Admin");
			
			driver.findElement(By.id("pass")).clear();
			driver.findElement(By.id("pass")).sendKeys("admin123");
			
			
	  }
		
		@AfterTest
		public void tearDown() {
			driver.quit();
		}
	}

