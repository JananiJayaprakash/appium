package RaaOnlineProject01.Raaonline;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	
	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException
	{

	service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\nvm4w\\nodejs\\node_modules\\appium\\build\\lib\\main.js"))
    			.withIPAddress("127.0.0.1").usingPort(4723).build();
    	service.start();
    			       
        UiAutomator2Options options = new UiAutomator2Options();
        //options.setDeviceName("Testing");
        options.setDeviceName("R9WW30G5FJD");
        options.setApp("C:\\Users\\janan\\eclipse-workspace\\Raaonline\\src\\main\\java\\resourse01\\dev-apk.apk");
        
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        
	}
	
	@AfterClass
	public void tearDown()
	{
		        // Quit driver
		        driver.quit();
		        service.stop();
	}
}
			
		          
		        
		    
		

	


