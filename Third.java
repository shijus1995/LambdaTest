package lambda3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Third {
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
	       driver.findElement(By.partialLinkText("Input Form")).click();
			driver.findElement(By.xpath("/html/body/div[1]/div/section[3]/div/div/div[2]/div/form/div[6]/button")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String message = driver.findElement(By.name("name")).getAttribute("validationMessage"); 
			System.out.print(message);
	if(message.equals("Please fill out this field.")) {
				
				System.out.println("Test is passed");}
				else {
					System.out.println("Test is failed");}
	
	
		
		driver.findElement(By.id("name")).sendKeys("shiju");
		driver.findElement(By.id("inputEmail4")).sendKeys("abcd@gmail.com");
		driver.findElement(By.name("password")).sendKeys("abcd1234");
		driver.findElement(By.id("company")).sendKeys("STC technology");
		driver.findElement(By.name("website")).sendKeys("www.stcal.com");
		new Select (driver.findElement(By.name("country"))).selectByVisibleText("United States");
		driver.findElement(By.id("inputCity")).sendKeys("trivandrum");
		driver.findElement(By.name("address_line1")).sendKeys("amc villa");
		driver.findElement(By.name("address_line2")).sendKeys("trivandrum");
		driver.findElement(By.id("inputState")).sendKeys("kerala");
		driver.findElement(By.name("zip")).sendKeys("695588");
		driver.findElement(By.xpath("/html/body/div[1]/div/section[3]/div/div/div[2]/div/form/div[6]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String message2=driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[3]/div/div/div[2]/div/p")).getText();
		if(message2.equals("Thanks for contacting us, we will get back to you shortly.")) {
			
			System.out.println("Test is completed");}
			else {
				System.out.println("please try again test failed");}}
	
	
	
	
	@AfterMethod
	    public void tearDown() throws Exception {
	       if (driver != null) {
	            driver.quit();
	        }
	    }
	}

