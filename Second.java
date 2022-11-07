package lambda3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Second {
	public String username = "shijus1995";
	public String accesskey = "rSGOa2NjyRrlBjqLGvkoYdyqRpTgCnF30kCmTqHyVWaf6z3hRm";
	public RemoteWebDriver driver = null;
	public String gridURL = "@hub.lambdatest.com/wd/hub";
	boolean status = false;
	 
	@BeforeMethod
	@Parameters(value={"browser","version","platform"})
	public void setUp(String browser, String version, String platform) throws Exception {
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	     capabilities.setCapability("browserName", browser);
	     capabilities.setCapability("version", version);
	     capabilities.setCapability("platform", platform);
	     capabilities.setCapability("build", "ParallelTestNG");
	     capabilities.setCapability("name", "ParallelTestNG");
	     capabilities.setCapability("network", true); 
	     capabilities.setCapability("visual", true); 
	     capabilities.setCapability("video", true); 
	     capabilities.setCapability("console", true); 
	     try {
	         driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
	     } catch (MalformedURLException e) {
	         System.out.println("Invalid grid URL");
	     } catch (Exception e) {
	         System.out.println(e.getMessage());
	     }
	 }
	@Test
	public void test1() {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/selenium-playground");
		driver.findElement(By.linkText("Drag & Drop Sliders")).click();
		WebElement element=driver.findElement(By.xpath("/html/body/div[1]/div/section[3]/div/div/div[2]/div[2]/div[1]/div/input"));
	
		 for (int i = 1; i <= 80 ; i++) {
	            element.sendKeys(Keys.ARROW_RIGHT);
	        }
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String val=driver.findElement(By.id("rangeSuccess")).getText();
		if(val.equals("95")) {
			
			System.out.println("value is changed to 95");}
			else {
				System.out.println("Test is failed");
			}}
	
	
	
	
	@AfterMethod
	    public void tearDown() throws Exception {
	       if (driver != null) {
	            driver.quit();
	        }
	    }
	}

