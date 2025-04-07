package RaaOnlineProject01.Raaonline;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.apache.commons.io.FileUtils;

public class BaseClassPerformance {

    public static AppiumDriver driver;
    public AppiumDriverLocalService service;
    public long appLaunchTime = 0;

    public void configureAppium() throws MalformedURLException {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\nvm4w\\nodejs\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("R9WW30G5FJD");
        options.setApp("C:\\Users\\janan\\eclipse-workspace\\Raaonline\\src\\main\\java\\resourse01\\dev-apk.apk");

        long start = System.currentTimeMillis();
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        long end = System.currentTimeMillis();

        appLaunchTime = end - start;
        System.out.println("📱 App Launch Time: " + appLaunchTime + " ms");
        logResult("App Launch Time", appLaunchTime);
    }

    public long measureLoadingTime(Runnable action, By waitForElement, String screenName) {
        long startTime = System.currentTimeMillis();
        action.run();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitForElement));

        long endTime = System.currentTimeMillis();
        long loadTime = endTime - startTime;
        System.out.println("⏳ Screen '" + screenName + "' Load Time: " + loadTime + " ms");
        logResult(screenName + " Load Time", loadTime);
        return loadTime;
    }

    public long measureApiResponseTime(String urlStr) {
        try {
            long start = System.currentTimeMillis();
            HttpURLConnection connection = (HttpURLConnection) new URL(urlStr).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int code = connection.getResponseCode();
            long end = System.currentTimeMillis();
            long time = end - start;
            System.out.println("🌐 API Response Time (" + urlStr + "): " + time + " ms (Status: " + code + ")");
            logResult("API Call to " + urlStr, time);
            return time;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void logResult(String name, long time) {
        try (FileWriter fw = new FileWriter("performance_results.txt", true)) {
            fw.write(name + ": " + time + " ms\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException {
        File source = driver.getScreenshotAs(OutputType.FILE);
        String destinationFilePath = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(destinationFilePath));
        return destinationFilePath;
    }

    public void tearDown() {
        driver.quit();
        service.stop();
    }
}
