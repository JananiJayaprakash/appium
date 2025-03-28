package RaaOnlineProject01.Raaonline;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class networkSpeed extends BaseClass {

	@Test(priority = 1)
	public void LoginPage() throws MalformedURLException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Step 1: Check Network Speed
		double networkSpeed = getWifiSpeed();
		System.out.println("Current Network Speed: " + networkSpeed + " Mbps");

		// Step 2: Set Minimum Required Speed
		double minRequiredSpeed = 5.0;
		if (networkSpeed < minRequiredSpeed) {
			System.out.println("Network speed is too low! Test aborted.");
			Assert.fail("Network speed is below " + minRequiredSpeed + " Mbps");
			return;
		}

		driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']")).click();

		// Enter phone number
		WebElement phoneField = wait
				.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.EditText)[1]")));
		phoneField.click();
		System.out.println("Entering phone number...");
		phoneField.sendKeys("6383317837");

		// Enter password
		WebElement Validpassword = wait
				.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.EditText)[2]")));
		Validpassword.click();
		System.out.println("Entering password...");
		Validpassword.sendKeys("123456");

		driver.hideKeyboard();

		// Click Login button
		System.out.println("Clicking Login button");
		WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Login")));
		loginButton.click();

		// Check for toast message (Incorrect number or password)
		try {
			WebElement toastMessage = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc=\"RaaOnline\"]")));
			System.out.println("Toast message checking: " + toastMessage.isDisplayed());
			if (toastMessage.isDisplayed()) {
				System.out.println("Login failed: Incorrect credentials.");
				WebElement closeToast = wait
						.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("OK")));
				closeToast.click();
				System.out.println("Toast message closed.");
				tearDown(); // Close the app
				return; // Stop further execution
			}
		} catch (TimeoutException e) {
			System.out.println("No toast message found. Checking Home Page...");
		}
	}

	// Method to get WiFi speed using ADB command
	public static double getWifiSpeed() {
		try {
			ProcessBuilder processBuilder = new ProcessBuilder("adb", "shell", "dumpsys wifi | grep 'Link speed'");
			Process process = processBuilder.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				if (line.contains("Link speed:")) {
					String speedString = line.replaceAll("[^0-9]", ""); // Extract only digits
					return Double.parseDouble(speedString); // Convert to number
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0.0; // Return 0 if speed cannot be detected
	}
}
