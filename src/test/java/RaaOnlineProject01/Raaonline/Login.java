package RaaOnlineProject01.Raaonline;

import java.net.MalformedURLException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class Login extends BaseClass {
//	@Test(dataProvider="getData",groups= {"Smoke"})
	@Test(priority = 1)
	public void LoginPage() throws MalformedURLException, InterruptedException {
//		ExtentTest test=extent.createtest("Initial Demo");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']")).click();

		// Enter phone number
		WebElement phoneField = wait
				.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.EditText)[1]")));
		phoneField.click();
		System.out.println("Entering phone number...");
		phoneField.sendKeys("6383317837");

//        WebElement EmailField = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.EditText)[1]")));
//        EmailField.click();
//        System.out.println("Entering Email id...");
//        EmailField.sendKeys("jananiprakash233@gmail.com");

		// Enter password
		WebElement Validpassword = wait
				.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.EditText)[2]")));
		Validpassword.click();
		System.out.println("Entering password...");
		Validpassword.sendKeys("123456");

//        WebElement Invalidpassword = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.EditText)[2]")));
//        Invalidpassword.click();
//        Invalidpassword.sendKeys("12345678");

//		driver.hideKeyboard();
		if (driver instanceof AndroidDriver) {
			((AndroidDriver) driver).hideKeyboard();
		} else if (driver instanceof IOSDriver) {
			((IOSDriver) driver).hideKeyboard();
		}

		// Click Login button
		System.out.println("Click Login button");
		WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Login")));
		loginButton.click();

// Check for toast message (Incorrect number or password)
		try {
			WebElement toastMessage = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc=\"RaaOnline\"]")));
//            WebElement toastMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
//            		"//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View")));
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

		// tearDown();
	}
}
