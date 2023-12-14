package TestUtilities;

import java.net.URL;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class CommonUtilities {

	public static AppiumDriver driver;
	public static WebDriverWait wait;
	
	public void launchApplication() {
		DesiredCapabilities cap=new DesiredCapabilities();
    	try {
    	cap.setCapability("deviceName", "GalaxyM51");
    	cap.setCapability("udid", "RZ8NA0T713R");
    	cap.setCapability("platformName", "Android");
    	cap.setCapability("appPackage", "in.redbus.android");
    	cap.setCapability("appActivity", "in.redbus.android.homeV2.HomeV2Activity");
    	cap.setCapability("appium:noReset", true);
    	System.out.println("Started execution");
    	URL url=new URL("http://127.0.0.1:4723/wd/hub");
    	driver=new AppiumDriver(url,cap);
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;
    	wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    	System.out.println("Application Started");
    	}
    	catch(Exception e)
    	{
    		System.out.println("Application not started due to "+e.getMessage());
    	}
    	
	}
	
	 public  void scrollAndClick(String visibleText) {
	    	driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))")).click();
	   }
	 
	 public int generateRandom(int num)
	 {
		 Random n=new Random();
		 return n.nextInt(num)+100;
	 }
	 
	 public void closeApp() {
		 driver.quit();
	 }
	 
	 
}
