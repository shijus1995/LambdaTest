package lambda3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class First {
	 
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
		driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div[1]/div[1]/ul/li[1]/a")).click();
		String urlValue=driver.getCurrentUrl();
		
		if(urlValue.contains("simple-form-demo")){
			   System.out.println("url contains simple-form-demo");
			
			} else {
				System.out.println("url does not contains simple-form-demo");}
		
	
	String data1="Welcome to LambdaTest";
	driver.findElement(By.id("user-message")).sendKeys(data1);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@id=\"showInput\"]")).click();
	 String msg= driver.findElement(By.id("message")).getText();

	if(msg.equals(data1)){
		   System.out.println("your message is diplayed");
		  
		} else {
			System.out.println("your message is not diplayed");}}
	
	
	
	
	
	
	@AfterMethod
	    public void tearDown() throws Exception {
	       if (driver != null) {
	            driver.quit();
	        }
	    }
	}