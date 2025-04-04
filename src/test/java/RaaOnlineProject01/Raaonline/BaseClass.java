package RaaOnlineProject01.Raaonline;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;

public class BaseClass {

//	private static final String FileUtils = null;
	public AppiumDriverLocalService service;
	public AndroidDriver driver;

	@BeforeClass
	public void configureAppium() throws MalformedURLException {

		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\nvm4w\\nodejs\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		// options.setDeviceName("Testing");
		options.setDeviceName("R9WW30G5FJD");
		options.setApp("C:\\Users\\janan\\eclipse-workspace\\Raaonline\\src\\main\\java\\resourse01\\dev-apk.apk");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

	}

	public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException {
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

	@AfterClass
	public void tearDown() {
		// Quit driver
		driver.quit();
		service.stop();
	}
}
