package RaaOnlineProject01.Raaonline;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;

public class BaseClass {

	public AppiumDriver driver; 
	public AppiumDriverLocalService service;
//	public AndroidDriver driver;

	@BeforeClass//(alwaysRun=true)
	public void configureAppium() throws MalformedURLException {

		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\nvm4w\\nodejs\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		// options.setDeviceName("Testing");
		options.setDeviceName("R9WW30G5FJD");
//		options.setApp("C:\\Users\\janan\\eclipse-workspace\\Raaonline\\src\\main\\java\\resourse01\\dev-apk.apk");
		options.setApp("C:\\Users\\janan\\eclipse-workspace\\Raaonline\\src\\main\\java\\resourse01\\viewplan_apk.apk");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

	}

	public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException {
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFilePath = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
//		FileUtils.copyFile(source, new File(destinationFile));
		try {
	        FileUtils.copyFile(source, new File(destinationFilePath));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return destinationFilePath;
	}

	@AfterClass//(alwaysRun=true)
	public void tearDown() {
		// Quit driver
		driver.quit();
		service.stop();
	}
}
